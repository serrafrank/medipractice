package org.medipractice.datafileserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.datafileserver.model.DataFile;
import org.medipractice.datafileserver.service.DataFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/")
public class DataFileController  {

    private final DataFileService dataFileService;

    @Autowired
    public DataFileController(DataFileService dataFileService) {
        this.dataFileService = dataFileService;
    }

    @GetMapping(value = "get/{id}")
    public List<DataFile> getDataFile(@PathVariable UUID id) {
        return  dataFileService.findByDatafileId(id);

    }

    @GetMapping(value = "get/{id}/{fields}")
    public List<DataFile> getDataFile(@PathVariable UUID id, @PathVariable String[] fields) {
        return  dataFileService.findByDatafileIdAndFields(id, fields);

    }

    @GetMapping(value = "find/{types}/{value}")
    public List<DataFile> getDataFiles(@PathVariable String[] types, @PathVariable String value ) {
        return  dataFileService.findAllByDataTypesAndValue(types, value);

    }

//    @GetMapping(value = "find/{types}/all")
//    public List<DataFile> getAllDataFiles(@PathVariable String[] types ) {
//        return  dataFileService.findAllByDataTypes(types);
//
//    }


    @PostMapping
    public List<DataFile> postDataFile(@RequestBody List<DataFile> dataFile){
        return dataFileService.save(dataFile);

    }
    @GetMapping(value = "new_patient")
    public String newPatient(){
        return dataFileService.newPatient().toString();

    }

}
