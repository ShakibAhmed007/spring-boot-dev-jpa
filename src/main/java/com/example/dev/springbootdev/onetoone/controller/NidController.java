package com.example.dev.springbootdev.onetoone.controller;

import com.example.dev.springbootdev.customresponse.CustomResponse;
import com.example.dev.springbootdev.customresponse.CustomResponseUtil;
import com.example.dev.springbootdev.entities.Nid;
import com.example.dev.springbootdev.onetoone.dto.NidDetailsDto;
import com.example.dev.springbootdev.onetoone.dto.NidDto;
import com.example.dev.springbootdev.onetoone.service.NidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/nid")
public class NidController {

    @Autowired
    private NidService nidService;

    @GetMapping("/getAll")
    public ResponseEntity<CustomResponse<List<Nid>>> getAll(){
        List<Nid> nids = nidService.getAll();
        CustomResponse<List<Nid>> response = CustomResponseUtil.createResponse(200, nids, "/GetAll");
        response.setMessage("Successfull");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CustomResponse<NidDetailsDto>> getById(@PathParam("id") Long id){
        NidDetailsDto nid = nidService.getById(id);
        CustomResponse<NidDetailsDto> response = CustomResponseUtil.createResponse(200, nid, "/GetById");
        response.setMessage("Successful");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<CustomResponse<Nid>> save(@Valid @RequestBody NidDto nidDto){
        Nid nid = nidService.save(nidDto);
        CustomResponse<Nid> response = CustomResponseUtil.createResponse(200, nid, "/Save");
        response.setMessage("Successful");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomResponse<Nid>> update(@Valid @RequestBody NidDto nidDto){
        Nid nid = nidService.update(nidDto);
        CustomResponse<Nid> response = CustomResponseUtil.createResponse(200, nid, "/Update");
        response.setMessage("Successful");
        return ResponseEntity.ok(response);
    }

}
