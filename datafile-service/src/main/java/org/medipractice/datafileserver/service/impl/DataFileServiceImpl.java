package org.medipractice.datafileserver.service.impl;

import org.medipractice.datafileserver.exception.BadRequestException;
import org.medipractice.datafileserver.exception.ResourceNotFoundException;
import org.medipractice.datafileserver.model.DataFile;
import org.medipractice.datafileserver.repository.DataFileRepository;
import org.medipractice.datafileserver.service.DataFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        DataFile dataFile = this.dataFileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found : " + id));


        DataFile dataFileReturn = dataFile;

        //todo
        /*
        DataFile dataFileReturn = dataFile.getDatas()
                .forEach(o -> o = o.getValues().stream().filter(v -> (v.getParentId() != null) ).map(Arrays) );
*/
        return dataFileReturn;
    }

    @Override
    public DataFile findByIdWithHistory(UUID id) {
        return this.dataFileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found : " + id));
    }

    @Override
    public DataFile save(DataFile dataFile) {
        if (dataFile.getId() != null) {
            DataFile dataFileToUpdate = findById(dataFile.getId());

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

        dataFileRepository.save(dataFile);

        return dataFile;
    }


    @Override
    public List<DataFile> findAllByDataTypesAndValue(List<String> types, String value) {
        return dataFileRepository.findAllByDataTypesAndValue(types, value).orElseThrow((BadRequestException::new));
    }
}
