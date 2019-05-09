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

    private UUID datafileId ;

    @Before
    public void setUp() throws Exception {
        this.datafileId = UUID.randomUUID();
        List<DataFile> dataFileList = Arrays.asList(
                new DataFile(datafileId, "test_prenom", "Martin", LocalDateTime.now() ),
                new DataFile(datafileId, "test_nom_de_famille", "DUPONT", LocalDateTime.now() ),
                new DataFile(datafileId, "test_prenom", "Jean", LocalDateTime.now() )
        );

        dataFileService.save(dataFileList);
    }

    @Test
    public void save(){
        List<DataFile> dataFileList = Arrays.asList(
                new DataFile(datafileId, "test_prenom", "Martin", LocalDateTime.now() ),
                new DataFile(datafileId, "test_nom_de_famille", "DUPONT", LocalDateTime.now() ),
                new DataFile(datafileId, "test_prenom", "Jean", LocalDateTime.now() )
        );

        Assert.assertNotNull( dataFileService.save(dataFileList) );
    }

    @Test
    public void findByDatafileId() {
        List<DataFile> df = dataFileService.findByDatafileId(datafileId);
        Assert.assertNotNull(df);

    }

    @Test
    public void findByDatafileIdAndFields() {
        String[] fields = {"test_prenom",  "test_nom_de_famille"};
        List<DataFile> df = dataFileService.findByDatafileIdAndFields(datafileId, fields);
        Assert.assertNotNull(df);
    }

    @Test
    public void findAllByDataTypesAndValue() {
        String[] fields = {"test_prenom",  "test_nom_de_famille"};
        String value = "DUPONT";
        List<DataFile> df = dataFileService.findAllByDataTypesAndValue(fields, value);
        Assert.assertNotNull(df);
    }

    @Test
    public void findAllByDataTypes() {
        String[] fields = {"test_prenom",  "test_nom_de_famille"};
        List<DataFile> df = dataFileService.findAllByDataTypes(fields);
        Assert.assertNotNull(df);
    }

    @Test
    public void newPatient() {
        UUID id = dataFileService.newPatient();
        Assert.assertNotNull(id);
    }
}
