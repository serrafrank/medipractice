package org.medipractice.clientui.service;

import org.medipractice.clientui.beans.page.MenuBean;
import org.medipractice.clientui.beans.page.ModuleBean;
import org.medipractice.clientui.beans.page.PageBean;
import org.medipractice.clientui.proxy.ProxyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PageService {


    @Autowired
    private ProxyManager proxyManager;

    public PageBean getPageContent(String module, String name) {
        PageBean pageBean;
        try {
            pageBean = this.proxyManager.getPage().getPage(module, name);
        } catch (Exception e) {
            pageBean = new PageBean();
            pageBean.setModule(new ModuleBean());
            pageBean.getModule().setName(module);
            pageBean.setName(name);
            pageBean.setSchema("{}");
        }

        return pageBean;
    }


    public List<MenuBean> findMenu() {
        return this.proxyManager.getPage().findMenu();
    }

    public PageBean getIndex() {
        return this.proxyManager.getPage().getIndex();
    }
}
