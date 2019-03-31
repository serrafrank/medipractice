package org.medipractice.datafileserver.service;

import org.medipractice.datafileserver.model.DataFile;

import java.util.List;
import java.util.UUID;

public interface DataFileService {
    List<DataFile> findByDatafileId(UUID id);

    void save(List<DataFile> dataFile);

    void save(DataFile dataFile);

    List<DataFile> findAllByDataTypesAndValue(List<String> types, String value);

}
