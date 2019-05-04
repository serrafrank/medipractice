package org.medipractice.datafileserver.service.impl;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import lombok.extern.slf4j.Slf4j;
import org.medipractice.datafileserver.exception.BadRequestException;
import org.medipractice.datafileserver.exception.ResourceNotFoundException;
import org.medipractice.datafileserver.model.DataFile;
import org.medipractice.datafileserver.repository.DataFileRepository;
import org.medipractice.datafileserver.service.DataFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.*;

@Service("dataFileService")
public class DataFileServiceImpl implements DataFileService {

    private final DataFileRepository dataFileRepository;

    @Autowired
    public DataFileServiceImpl(DataFileRepository dataFileRepository) {
        this.dataFileRepository = dataFileRepository;
    }


    @Override
    public List<DataFile> findByDatafileId(UUID id) {
        return this.dataFileRepository.findAllByDataFileAndArchivedAtIsNull(id);
    }

    @Override
    public List<DataFile> findByDatafileIdAndFields(UUID id, String[] fields) {
        return this.dataFileRepository.findAllByDataFileAndTypeInAndArchivedAtIsNull(id, fields);
    }

    @Override
    public List<DataFile> save(List<DataFile> list){
        list.forEach(d -> d = this.save(d));
        return list;
    }

    @Override
    public DataFile save(DataFile dataFile) {
//            Optional<DataFile> dataFileToArchived =  this.dataFileRepository.findById(dataFile.getId());
            Optional<DataFile> dataFileToArchived =  this.dataFileRepository.findByDataFileAndTypeAndArchivedAtIsNull(dataFile.getDataFile(), dataFile.getType());
        if (dataFileToArchived.isPresent()) {
            DataFile df = dataFileToArchived.get();
//            df.setId(UUID.randomUUID());
            df.setArchivedAt(LocalDateTime.now());
            dataFileRepository.save(df);

            dataFile.setArchived(df);
        }

        return dataFileRepository.save(dataFile);

    }

    @Override
    public List<DataFile> findAllByDataTypesAndValue( String[] types, String value) {
        List<DataFile> datafilesFounds = dataFileRepository.findAllByTypeInAndValueContainingIgnoreCaseAndArchivedIsNull(types, value);
        List<DataFile> datafilesReturned = new ArrayList<>();

        datafilesFounds.forEach( d -> datafilesReturned.addAll(
                dataFileRepository.findAllByDataFileAndTypeInAndArchivedAtIsNull(d.getDataFile(), types)
        ));

        return datafilesReturned;
        
    }

    @Override
    public List<DataFile> findAllByDataTypes(String[] types) {
        return dataFileRepository.findAllByTypeInAndArchivedAtIsNull(types);
    }

    @Override
    public UUID newPatient() {
        UUID id = UUID.randomUUID();
        DataFile dataFile = new DataFile();
        dataFile.setType("new");
        dataFile.setValue("new");
        dataFile.setDataFile(id);
        dataFileRepository.save(dataFile);
        return id ;
    }
}
