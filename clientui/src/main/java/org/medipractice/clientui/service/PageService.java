package org.medipractice.clientui.service;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.page.ModuleBean;
import org.medipractice.clientui.beans.page.PageBean;
import org.medipractice.clientui.proxy.ProxyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PageService{


    @Autowired
    private ProxyManager proxyManager;

    @Autowired
    private TokenService tokenService;

    public PageBean getPageContent(String module, String name) {
        PageBean pageBean;
        try {
            pageBean = this.proxyManager.getPage().getPage(tokenService.getToken(), module, name);
        } catch (Exception e) {
            pageBean = new PageBean();
            pageBean.setName(name);
            pageBean.setSchema("{}");
        }

        return pageBean;
    }


    public List<ModuleBean> findMenu() {
        return this.proxyManager.getPage().findMenu(tokenService.getToken());
    }

    public PageBean getIndex() {
        return this.proxyManager.getPage().getIndex(tokenService.getToken());
    }

    public ResponseEntity<?> postPage(PageBean page) {
        return this.proxyManager.getPage().postPage(tokenService.getToken(), page);
    }
}
