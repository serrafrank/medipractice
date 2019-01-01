package org.medipractice.pageserver.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medipractice.pageserver.model.Navigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class NavigationServiceTest {

    @Autowired
    private NavigationService navigationService;

    private Navigation index;

    @Before
    public void setUp() throws Exception {
        index = new Navigation();

        index.setLabel("Accueil");
        index.setPage("index");


    }
    @Test
    public void findAllNavigation() {
    }

    @Test
    public void save() {
        navigationService.save(index);
    }
}