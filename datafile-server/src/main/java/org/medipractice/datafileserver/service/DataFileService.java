package org.medipractice.datafileserver.service;

import org.medipractice.datafileserver.model.DataFile;

import javax.xml.crypto.Data;
import java.util.UUID;

public interface DataFileService {
    DataFile findById(UUID id);
}
