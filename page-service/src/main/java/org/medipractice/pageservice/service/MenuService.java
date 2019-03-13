package org.medipractice.pageservice.service;

import org.medipractice.pageservice.model.Menu;
import org.medipractice.pageservice.dao.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> findAll(){
        return menuRepository.findAllByRootIsTrueOrderBySortAsc();
    }

    public void save(Menu menu){
        menuRepository.save(menu);
    }

}
