package org.medipractice.datafileserver.service;

import org.medipractice.datafileserver.model.DataFile;

import java.util.List;
import java.util.UUID;

public interface DataFileService {
    List<DataFile> findByDatafileId(UUID id);

    List<DataFile> save(List<DataFile> dataFile);

    DataFile save(DataFile dataFile);

    List<DataFile> findAllByDataTypesAndValue(String[] types, String value);

}
