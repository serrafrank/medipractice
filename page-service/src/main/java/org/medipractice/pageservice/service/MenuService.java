package org.medipractice.pageservice.service;

import org.medipractice.pageservice.dao.repository.ModuleRepository;
import org.medipractice.pageservice.model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final ModuleRepository moduleRepository;

    @Autowired
    public MenuService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public void save(Module module){
        this.moduleRepository.save(module);
    }

    public List<Module> findAll(){
        return this.moduleRepository.findAllByOrderBySortAsc();
    }

}
