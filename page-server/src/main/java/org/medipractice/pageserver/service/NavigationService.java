package org.medipractice.pageserver.service;

import org.medipractice.pageserver.model.Navigation;
import org.medipractice.pageserver.repository.NavigationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class NavigationService {

    private final NavigationRepository navigationRepository;

    @Autowired
    public NavigationService(NavigationRepository navigationRepository) {
        this.navigationRepository = navigationRepository;
    }

    public List<Navigation> findAllNavigation(){
        return navigationRepository.findAllByParentIsNull().orElse(Collections.emptyList());
    }

    public void save(Navigation navigation){
        navigationRepository.save(navigation);
    }

}
