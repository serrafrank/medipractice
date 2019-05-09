package org.medipractice.pageservice.dao;

import lombok.Data;
import org.medipractice.pageservice.dao.repository.FieldRepository;
import org.medipractice.pageservice.dao.repository.ModuleRepository;
import org.medipractice.pageservice.dao.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class DaoManager {

     @Autowired
    private FieldRepository fieldRepository;

     @Autowired
    private ModuleRepository moduleRepository;

     @Autowired
    private PageRepository pageRepository;

}
