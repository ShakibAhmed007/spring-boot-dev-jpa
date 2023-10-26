package com.example.dev.springbootdev.onetoone.controller;

import com.example.dev.springbootdev.customresponse.CustomResponse;
import com.example.dev.springbootdev.customresponse.CustomResponseUtil;
import com.example.dev.springbootdev.entities.Nid;
import com.example.dev.springbootdev.onetoone.dto.NidDto;
import com.example.dev.springbootdev.onetoone.service.NidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController("/nid")
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
    public ResponseEntity<CustomResponse<NidDto>> getById(@PathParam("id") Long id){
        NidDto nid = nidService.getById(id);
        CustomResponse<NidDto> response = CustomResponseUtil.createResponse(200, nid, "/GetById");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<CustomResponse<Nid>> save(@Valid @RequestBody NidDto nidDto){
        Nid nid = nidService.save(nidDto);
        CustomResponse<Nid> response = CustomResponseUtil.createResponse(200, nid, "Post /save");
        response.setMessage("Successful");
        return ResponseEntity.ok(response);
    }

}
