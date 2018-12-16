package org.medipractice.datafileserver.controller;

import org.medipractice.datafileserver.exception.InternalServerError;
import org.medipractice.datafileserver.exception.ResourceNotFoundException;
import org.medipractice.datafileserver.model.DataFile;
import org.medipractice.datafileserver.service.DataFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.crypto.Data;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/DataFile")
public class DataFileController  {

    private final DataFileService dataFileService;

    @Autowired
    public DataFileController(DataFileService dataFileService) {
        this.dataFileService = dataFileService;
    }

    @GetMapping(value = "/{id}")
    public DataFile getDataFile(@PathVariable UUID id) {
        return  dataFileService.findById(id);

    }
    @GetMapping(value = "/{types}/{value}")
    public List<DataFile> getDataFile(@PathVariable List<String> types, @PathVariable String value ) {
        return  dataFileService.findAllByDataTypesAndValue(types, value);

    }


    @PostMapping
    public ResponseEntity<Void> postDataFile(@RequestBody DataFile dataFile){
        DataFile data =  dataFileService.save(dataFile);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(data.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
