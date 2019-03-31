package org.medipractice.datafileserver.service.impl;

import org.medipractice.datafileserver.exception.BadRequestException;
import org.medipractice.datafileserver.exception.ResourceNotFoundException;
import org.medipractice.datafileserver.model.DataFile;
import org.medipractice.datafileserver.repository.DataFileRepository;
import org.medipractice.datafileserver.service.DataFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OneToMany;
import java.time.LocalDateTime;
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
    public List<DataFile> findByDatafileId(UUID id) {
        return this.dataFileRepository.findAllByDataFile(id).orElseThrow(() -> new ResourceNotFoundException("Id not found : " + id));
    }

    @Override
    public void save(List<DataFile> list){
        list.forEach(this::save);
    }

    @Override
    public void save(DataFile dataFile) {

//            Optional<DataFile> dataFileToArchived =  this.dataFileRepository.findById(dataFile.getId());
            Optional<DataFile> dataFileToArchived =  this.dataFileRepository.findByDataFileAndType(dataFile.getDataFile(), dataFile.getType());
        if (dataFileToArchived.isPresent()) {
            DataFile df = dataFileToArchived.get();
//            df.setId(UUID.randomUUID());
            df.setArchivedAt(LocalDateTime.now());
            dataFileRepository.save(df);

            dataFile.setArchived(df);
        }

        dataFileRepository.save(dataFile);

    }

    @Override
    public List<DataFile> findAllByDataTypesAndValue(List<String> types, String value) {
        return dataFileRepository.findAllByTypeInAndValueContaining(types, value).orElseThrow((BadRequestException::new));
    }
}
