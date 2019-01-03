package org.medipractice.pageserver.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medipractice.pageserver.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceTest {

    @Autowired
    private MenuService menuService;


    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void save() {


        Menu agenda = new Menu();
        agenda.setLabel("Agenda");
        agenda.setSort(1);


        Menu patient = new Menu();
        patient.setLabel("Patient");
        patient.setSort(2);

        Menu med = new Menu();
        med.setLabel("Praticiens");
        med.setSort(3);

        Menu email = new Menu();
        email.setLabel("Boite de récéption");
        email.setSort(4);

        Menu set = new Menu();
        set.setLabel("Configuration");
        set.setSort(5);


        menuService.save(agenda);
        menuService.save(patient);
        menuService.save(email);
        menuService.save(set);
    }
}