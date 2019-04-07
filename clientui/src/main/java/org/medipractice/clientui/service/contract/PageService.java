package org.medipractice.clientui.service.contract;

import org.medipractice.clientui.beans.page.ModuleBean;
import org.medipractice.clientui.beans.page.PageBean;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PageService {
    PageBean getPageContent(String module, String name);

    List<ModuleBean> findMenu();

    PageBean getIndex();

    ResponseEntity<?> postPage(PageBean page);
}
