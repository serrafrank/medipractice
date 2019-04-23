package org.medipractice.clientui.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.medipractice.clientui.beans.page.ModuleBean;
import org.medipractice.clientui.beans.page.PageBean;
import org.medipractice.clientui.proxy.ProxyManager;
import org.medipractice.clientui.service.AbstractService;
import org.medipractice.clientui.service.contract.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("pageService")
public class PageServiceImpl extends AbstractService implements PageService {

    @Override
    public PageBean getPageContent(String module, String name) {
        PageBean pageBean;
        try {
            pageBean = this.proxyManager.getPage().getPage(this.serviceManager.getTokenService().getToken(), module, name);
        } catch (Exception e) {
            pageBean = new PageBean();
            pageBean.setName(name);
            pageBean.setSchema("{}");
        }

        return pageBean;
    }

    @Override
    public List<ModuleBean> findMenu() {
        List<ModuleBean> moduleBeans = new ArrayList<>();
        if (this.serviceManager.getTokenService().isConnected())
            moduleBeans = this.proxyManager.getPage().findMenu(this.serviceManager.getTokenService().getToken());

        return moduleBeans;
    }

    @Override
    public PageBean getIndex() {
        return this.proxyManager.getPage().getIndex(this.serviceManager.getTokenService().getToken());
    }

    @Override
    public ResponseEntity<?> postPage(PageBean page) {
        return this.proxyManager.getPage().postPage(this.serviceManager.getTokenService().getToken(), page);
    }
}
