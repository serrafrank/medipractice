package org.medipractice.datafileserver.service.impl;

import org.medipractice.datafileserver.model.DataFile;
import org.medipractice.datafileserver.repository.DataFileRepository;
import org.medipractice.datafileserver.service.DataFileService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class DataFileServiceImpl implements DataFileService {

    @Autowired
    private DataFileRepository dataFileRepository;


    @Override
    public DataFile findById(UUID id) {
        return dataFileRepository.findById(id).get();
    }
}
