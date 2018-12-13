package org.medipractice.datafileserver.service;

import org.medipractice.datafileserver.model.DataFile;

import java.util.UUID;

public interface DataFileService {
    abstract DataFile findById(UUID id);

    void update(DataFile dataFile);

    void save(DataFile dataFile);
}
