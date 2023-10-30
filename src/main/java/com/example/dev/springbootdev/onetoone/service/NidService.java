package com.example.dev.springbootdev.onetoone.service;

import com.example.dev.springbootdev.entities.Nid;
import com.example.dev.springbootdev.entities.User;
import com.example.dev.springbootdev.exception.CustomException;
import com.example.dev.springbootdev.onetoone.dto.NidDetailsDto;
import com.example.dev.springbootdev.onetoone.dto.NidDto;
import com.example.dev.springbootdev.onetoone.repository.NidRepository;
import com.example.dev.springbootdev.onetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class NidService {

    @Autowired
    private NidRepository nidRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Nid> getAll() {
        return nidRepository.findAll();
    }

    public NidDetailsDto getById(Long id) {
        Optional<Nid> nidOptional = nidRepository.findById(id);
        if(nidOptional.isPresent()){
            NidDetailsDto nidDto = new NidDetailsDto();
            nidDto.setId(nidOptional.get().getId());
            nidDto.setNumber(nidOptional.get().getNumber());
            nidDto.setAddress(nidOptional.get().getAddress());
            nidDto.setFatherName(nidOptional.get().getFatherName());
            nidDto.setMotherName(nidOptional.get().getMotherName());
            nidDto.setStatus(nidOptional.get().getStatus());
            nidDto.setUser(nidOptional.get().getUser());
            return nidDto;
        } else {
            throw new CustomException(404, "Nid not found with given id"+ id);
        }
    }

    @Transactional
    public Nid save(NidDto nidDto) {
        Optional<User> userOptional = userRepository.findById(nidDto.getUserId());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            Nid nid = new Nid();
            nid.setNumber(nidDto.getNumber());
            nid.setFatherName(nidDto.getFatherName());
            nid.setMotherName(nidDto.getMotherName());
            nid.setAddress(nidDto.getAddress());
            nid.setStatus(nidDto.getStatus());
            nid.setUser(user);
            return nidRepository.save(nid);
        } else {
            throw new CustomException(404, "User not found with Id: "+ nidDto.getUserId());
        }
    }

    @Transactional
    public Nid update(NidDto nidDto) {
        Optional<Nid> nidOptional = nidRepository.findById(nidDto.getId());
        if(nidOptional.isPresent()){
            Optional<User> userOptional = Optional.ofNullable(userRepository.findById(nidDto.getUserId())
                    .orElseThrow(() -> new CustomException(404, "User not found with Id:" + nidDto.getUserId())));
            User user = userOptional.get();
            Nid nid = nidOptional.get();
            nid.setNumber(nidDto.getNumber());
            nid.setFatherName(nidDto.getFatherName());
            nid.setMotherName(nidDto.getMotherName());
            nid.setAddress(nidDto.getAddress());
            nid.setStatus(nidDto.getStatus());
            nid.setUser(user);
            return nidRepository.save(nid);
        } else {
            throw new CustomException(404, "Nid not found with Id: "+ nidDto.getId());
        }
    }
}
