package org.medipractice.datafileserver.service.impl;

import org.medipractice.datafileserver.model.DataFile;
import org.medipractice.datafileserver.repository.DataFileRepository;
import org.medipractice.datafileserver.repository.DataValuesRepository;
import org.medipractice.datafileserver.service.DataFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service("dataFileService")
public class DataFileServiceImpl implements DataFileService {

    private final DataFileRepository dataFileRepository;
    private final DataValuesRepository dataValuesRepository;

    @Autowired
    public DataFileServiceImpl(DataFileRepository dataFileRepository, DataValuesRepository dataValuesRepository) {
        this.dataFileRepository = dataFileRepository;
        this.dataValuesRepository = dataValuesRepository;
    }


    @Override
    public DataFile findById(UUID id) {
        return this.dataFileRepository.findById(id).orElse(null);
    }


    @Override
    public void save(DataFile dataFile) {
        if(dataFile.getId() != null) {
            Optional<DataFile> optDataFile = dataFileRepository.findById(dataFile.getId());

            if (optDataFile.isPresent()) {
                DataFile dataFileToUpdate = optDataFile.get();
                dataFile.getDatas().forEach(dataObject -> {
                    if (dataFileToUpdate.getDataType(dataObject.getType()) != null) {
                        dataObject.getValues().forEach(dataValue ->
                                dataFileToUpdate.getDataType(dataObject.getType()).setValue(dataValue)
                        );
                    } else {
                        dataFileToUpdate.getDatas().add(dataObject);
                    }
                });
                dataFile = dataFileToUpdate;
            }
        }

        dataFileRepository.save(dataFile);

    }


}
