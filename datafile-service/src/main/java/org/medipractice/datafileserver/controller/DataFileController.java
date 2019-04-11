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

    @GetMapping(value = "{id}")
    public List<DataFile> getDataFile(@PathVariable UUID id) {
        return  dataFileService.findByDatafileId(id);

    }

    @GetMapping(value = "{types}/{value}")
    public List<DataFile> getDataFile(@PathVariable String[] types, @PathVariable String value ) {
        return  dataFileService.findAllByDataTypesAndValue(types, value);

    }


    @PostMapping
    public List<DataFile> postDataFile(@RequestBody List<DataFile> dataFile){
        return dataFileService.save(dataFile);

    }

}
