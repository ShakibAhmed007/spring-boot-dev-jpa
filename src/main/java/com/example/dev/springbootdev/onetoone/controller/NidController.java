package com.example.dev.springbootdev.onetoone.controller;

import com.example.dev.springbootdev.customresponse.CustomResponse;
import com.example.dev.springbootdev.customresponse.CustomResponseUtil;
import com.example.dev.springbootdev.entities.Nid;
import com.example.dev.springbootdev.onetoone.dto.NidDto;
import com.example.dev.springbootdev.onetoone.service.NidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/nid")
public class NidController {

    @Autowired
    private NidService nidService;

    @PostMapping("/save")
    public ResponseEntity<CustomResponse<Nid>> save(@Valid @RequestBody NidDto nidDto){
        Nid nid = nidService.save(nidDto);
        CustomResponse<Nid> response = CustomResponseUtil.createResponse(200, nid, "Post /save");
        response.setMessage("Successful");
        return ResponseEntity.ok(response);
    }

}
