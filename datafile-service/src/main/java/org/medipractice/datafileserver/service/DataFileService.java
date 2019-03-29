package org.medipractice.datafileserver.service;

import org.medipractice.datafileserver.model.DataFile;

import java.util.List;
import java.util.UUID;

public interface DataFileService {
    DataFile findById(UUID id);

    DataFile save(DataFile dataFile);

    List<DataFile> findAllByDataTypesAndValue(List<String> types, String value);

    DataFile findByIdWithHistory(UUID id);
}
