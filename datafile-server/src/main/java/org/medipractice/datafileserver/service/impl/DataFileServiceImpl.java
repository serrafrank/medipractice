package org.medipractice.datafileserver.service.impl;

import org.medipractice.datafileserver.exception.BadRequestException;
import org.medipractice.datafileserver.exception.ResourceNotFoundException;
import org.medipractice.datafileserver.model.DataFile;
import org.medipractice.datafileserver.repository.DataFileRepository;
import org.medipractice.datafileserver.service.DataFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("dataFileService")
public class DataFileServiceImpl implements DataFileService {

    private final DataFileRepository dataFileRepository;

    @Autowired
    public DataFileServiceImpl(DataFileRepository dataFileRepository) {
        this.dataFileRepository = dataFileRepository;
    }


    @Override
    public DataFile findById(UUID id) {
        return this.dataFileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found : " + id ));
    }


    @Override
    public DataFile save(DataFile dataFile) {
        if (dataFile.getId() != null) {
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

        return dataFile;
    }


    @Override
    public List<DataFile> findAllByDataTypesAndValue(List<String> types, String value) {
        return dataFileRepository.findAllByDataTypesAndValue(types, value).orElseThrow((BadRequestException::new));
    }
}
