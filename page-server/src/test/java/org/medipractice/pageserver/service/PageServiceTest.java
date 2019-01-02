package org.medipractice.pageserver.service;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medipractice.pageserver.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PageServiceTest {

    private JSONObject formObject ;

    @Autowired
    private PageService pageService;


    @Before
    public void setUp() throws Exception {

        formObject = new JSONObject("{\n" +
                "    \"display\": \"form\",\n" +
                "    \"components\": [\n" +
                "        {\n" +
                "            \"label\": \"index\",\n" +
                "            \"className\": \"\",\n" +
                "            \"attrs\": [],\n" +
                "            \"content\": \"<h2>Bienvenue !</h2>\",\n" +
                "            \"refreshOnChange\": false,\n" +
                "            \"mask\": false,\n" +
                "            \"tableView\": true,\n" +
                "            \"alwaysEnabled\": false,\n" +
                "            \"type\": \"htmlelement\",\n" +
                "            \"input\": false,\n" +
                "            \"key\": \"html\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");

    }



    @Test
    public void save() throws Exception {
        Page page = new Page("Accueil", null, formObject.toString());
        pageService.save(page);
    }


}