package org.medipractice.pageserver.service;

import org.medipractice.pageserver.model.Menu;
import org.medipractice.pageserver.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> findAll(){
        return menuRepository.findAllByOrderBySortAsc();
    }

    public void save(Menu menu){
        menuRepository.save(menu);
    }

}
