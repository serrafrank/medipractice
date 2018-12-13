package org.medipractice.datafileserver.controller;

import org.medipractice.datafileserver.model.DataFile;
import org.medipractice.datafileserver.service.DataFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/DataFile")
public class DataFileController extends AbstractController {

    private final DataFileService dataFileService;

    @Autowired
    public DataFileController(DataFileService dataFileService) {
        this.dataFileService = dataFileService;
    }

    @GetMapping(value = "/{id}")
    public DataFile getDataFile(@PathVariable UUID id) {
        return dataFileService.findById(id);
    }


}
