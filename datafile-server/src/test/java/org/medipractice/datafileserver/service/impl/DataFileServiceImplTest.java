package org.medipractice.datafileserver.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medipractice.datafileserver.model.DataFile;
import org.medipractice.datafileserver.model.DataObject;
import org.medipractice.datafileserver.model.DataValue;
import org.medipractice.datafileserver.service.DataFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataFileServiceImplTest {

    private DataFile dataFile ;

    @Autowired
    private DataFileService dataFileService;

    @Before
    public void setUp() throws Exception {
        dataFile = new DataFile();
        dataFile.getDatas().add( new DataObject("lastname",  Arrays.asList( new DataValue("Martin"), new DataValue("Marc") ) ) );
        dataFile.getDatas().add( new DataObject("firstname", Arrays.asList(new DataValue("Jean")) ));
        dataFileService.save(dataFile);

    }

    @Test
    public void findById() {
        DataFile df = dataFileService.findById(dataFile.getId());
        Assert.assertNotNull(df);
    }



    @Test
    public void update() {
        UUID id = dataFile.getDataType("lastname").getValues().get(0).getId();
        dataFile.getDataType("lastname").getValue(id).setValue("Ducobut");

        dataFileService.update(dataFile);
        Assert.assertTrue(dataFile.getDataType("lastname").getValue(id).isArchived()  );


    }
}