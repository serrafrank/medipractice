package org.medipractice.pageservice.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medipractice.pageservice.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;


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

        Menu navigation = new Menu();
        navigation.setLabel("Navigation");
        navigation.setChildren(new ArrayList<>());

        Menu agenda = new Menu();
        agenda.setLabel("Index");
        agenda.setPage("index");
        agenda.setSort(1);


        Menu patient = new Menu();
        patient.setLabel("Index 2");
        patient.setPage("index");
        patient.setSort(2);

        Menu med = new Menu();
        med.setLabel("Index 3");
        med.setPage("index");
        med.setSort(3);

        Menu email = new Menu();
        email.setLabel("Index 4");
        email.setPage("index");
        email.setSort(4);

        Menu set = new Menu();
        set.setLabel("Index 5");
        set.setPage("index");
        set.setSort(5);

        navigation.getChildren().add(agenda);
        navigation.getChildren().add(patient);
        navigation.getChildren().add(med);
        navigation.getChildren().add(email);
        navigation.getChildren().add(set);

        menuService.save(navigation);
    }
}