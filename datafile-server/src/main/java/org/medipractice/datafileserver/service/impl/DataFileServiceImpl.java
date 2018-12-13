package org.medipractice.datafileserver.service.impl;

import org.medipractice.datafileserver.model.DataFile;
import org.medipractice.datafileserver.model.DataValue;
import org.medipractice.datafileserver.repository.DataFileRepository;
import org.medipractice.datafileserver.repository.DataValuesRepository;
import org.medipractice.datafileserver.service.DataFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        return this.dataFileRepository.findById(id).get();
    }

    @Override
    public void update(DataFile dataFile) {
        dataFile.getDatas().forEach(dataObject -> dataObject.getValues().forEach(dataValue -> {
            Optional<DataValue> optValue = dataValuesRepository.findById(dataValue.getId());
            if (optValue.isPresent()) {
                DataValue value = optValue.get();
                if (!value.equals(dataValue)) {
                    value.setArchived(true);
                    dataValuesRepository.save(value);
                    dataValue.setId(UUID.randomUUID());
                    dataValue.setParentId(value.getId());
                }
            }
            dataValuesRepository.save(dataValue);

        }));


    }


    @Override
    public void save(DataFile dataFile) {
        this.dataFileRepository.save(dataFile);
    }


}
