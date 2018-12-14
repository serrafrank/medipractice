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

        Optional<DataFile> optDataFile = dataFileRepository.findById(dataFile.getId());

        dataFile.getDatas().forEach(dataObject -> dataObject.getValues().forEach(dataValue -> {

            if (optDataFile.isPresent()) {

                Optional<DataValue> optValue = optDataFile.get().getDatas()
                        .stream()
                        .filter(t -> t.getId().equals(dataObject.getId()))
                        .flatMap(t -> t.getValues().stream())
                        .filter(v -> v.getId().equals(dataValue.getId())).findFirst();

                if (optValue.isPresent()) {
                    System.out.println("optValue : " + optValue.get());
                    System.out.println("dataValue : " + optValue.get());

                    if (!optValue.get().equals(dataValue)) {
                        DataValue newData = new DataValue(dataValue) ;
                        dataValue.setArchived(true);
                        newData.setParentId(dataValue.getId());
                        dataValuesRepository.save(newData);
                        dataValuesRepository.save(dataValue);
                    }
                }
            }

        }));

        dataFileRepository.save(dataFile);

    }



    @Override
    public void save(DataFile dataFile) {
        this.dataFileRepository.save(dataFile);
    }


}
