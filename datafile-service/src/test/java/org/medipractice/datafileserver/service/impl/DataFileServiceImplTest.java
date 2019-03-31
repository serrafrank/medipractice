package org.medipractice.datafileserver.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medipractice.datafileserver.model.DataFile;
import org.medipractice.datafileserver.service.DataFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataFileServiceImplTest {

    private DataFile dataFile ;

    @Autowired
    private DataFileService dataFileService;

    private UUID datafileId = UUID.randomUUID();

    @Before
    public void setUp() throws Exception {

        List<DataFile> dataFileList = Arrays.asList(
                new DataFile(datafileId, "prenom", "Martin", LocalDateTime.now() ),
                new DataFile(datafileId, "nom_de_famille", "DUPONT", LocalDateTime.now() ),
                new DataFile(datafileId, "prenom", "Jean", LocalDateTime.now() )
        );

        dataFileService.save(dataFileList);

    }

    @Test
    public void findById() {
        List<DataFile> df = dataFileService.findByDatafileId(datafileId);
        Assert.assertNotNull(df);
    }


}
