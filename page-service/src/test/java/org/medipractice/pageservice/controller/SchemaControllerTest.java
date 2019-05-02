package org.medipractice.pageservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class SchemaControllerTest {

    @Autowired
    private MockMvc mockMvc;


    private static String token;
    private static String requestMapping = "/page";

    private static final String CLIENT_ID = "medipractice";
    private static final String CLIENT_SECRET = "medipractice";


    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";


    private String getToken() throws Exception {
        if (token == null) {

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://localhost:19111/oauth/token");
            try {
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("grant_type", "password"));
                nameValuePairs.add(new BasicNameValuePair("username", USERNAME));
                nameValuePairs.add(new BasicNameValuePair("password", PASSWORD));
                nameValuePairs.add(new BasicNameValuePair("client_id", CLIENT_ID));
                nameValuePairs.add(new BasicNameValuePair("client_secret", CLIENT_SECRET));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                // Execute HTTP Post Request
                HttpResponse response = httpclient.execute(httppost);
                JSONObject json_auth = new JSONObject(EntityUtils.toString(response.getEntity()));
                token = "Bearer " + json_auth.getString("access_token");

            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
        }
        log.info(">>>>> User Token : " + token);

        return token;
    }

    @Test
    public void getPage() {
    }

    @Test
    public void postPage() throws Exception {

        String json = "{" +
                " \"name\" : \"test\",\n" +
                " \"title\" : \"test\",\n" +
                " \"schema\": {\n" +
                "    \"display\": \"form\",\n" +
                "    \"components\": [\n" +
                "        {\n" +
                "            \"label\": \"___________TEST Text Field\",\n" +
                "            \"allowMultipleMasks\": false,\n" +
                "            \"showWordCount\": false,\n" +
                "            \"showCharCount\": false,\n" +
                "            \"tableView\": true,\n" +
                "            \"alwaysEnabled\": false,\n" +
                "            \"type\": \"textfield\",\n" +
                "            \"input\": true,\n" +
                "            \"key\": \"textField2\",\n" +
                "            \"defaultValue\": \"\",\n" +
                "            \"validate\": {\n" +
                "                \"customMessage\": \"\",\n" +
                "                \"json\": \"\"\n" +
                "            },\n" +
                "            \"conditional\": {\n" +
                "                \"show\": \"\",\n" +
                "                \"when\": \"\",\n" +
                "                \"json\": \"\"\n" +
                "            },\n" +
                "            \"widget\": {\n" +
                "                \"type\": \"\"\n" +
                "            },\n" +
                "            \"reorder\": false,\n" +
                "            \"inputFormat\": \"plain\",\n" +
                "            \"encrypted\": false,\n" +
                "            \"properties\": {},\n" +
                "            \"customConditional\": \"\",\n" +
                "            \"logic\": []\n" +
                "        },\n" +
                "        {\n" +
                "            \"label\": \"___________TEST Password\",\n" +
                "            \"showWordCount\": false,\n" +
                "            \"showCharCount\": false,\n" +
                "            \"tableView\": true,\n" +
                "            \"alwaysEnabled\": false,\n" +
                "            \"type\": \"password\",\n" +
                "            \"input\": true,\n" +
                "            \"key\": \"password2\",\n" +
                "            \"defaultValue\": \"\",\n" +
                "            \"validate\": {\n" +
                "                \"customMessage\": \"\",\n" +
                "                \"json\": \"\"\n" +
                "            },\n" +
                "            \"conditional\": {\n" +
                "                \"show\": \"\",\n" +
                "                \"when\": \"\",\n" +
                "                \"json\": \"\"\n" +
                "            },\n" +
                "            \"reorder\": false,\n" +
                "            \"inputFormat\": \"plain\",\n" +
                "            \"encrypted\": false,\n" +
                "            \"properties\": {},\n" +
                "            \"customConditional\": \"\",\n" +
                "            \"logic\": []\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"button\",\n" +
                "            \"label\": \"Soumettre\",\n" +
                "            \"key\": \"submit\",\n" +
                "            \"disableOnInvalid\": true,\n" +
                "            \"theme\": \"primary\",\n" +
                "            \"input\": true,\n" +
                "            \"tableView\": true\n" +
                "        }\n" +
                "    ],\n" +
                "    \"settings\": {\n" +
                "        \"pdf\": {\n" +
                "            \"id\": \"1ec0f8ee-6685-5d98-a847-26f67b67d6f0\",\n" +
                "            \"src\": \"https://files.form.io/pdf/5692b91fd1028f01000407e3/file/1ec0f8ee-6685-5d98-a847-26f67b67d6f0\"\n" +
                "        }\n" +
                "    }\n" +
                "}" +
                "}";


        mockMvc.perform(post(requestMapping)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", getToken())
                .content(json))
                //      .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
