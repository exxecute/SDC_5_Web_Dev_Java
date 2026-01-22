package com.webdev.sdc.lifecycle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LifecycleBean {

    private static final Log log = LogFactory.getLog(LifecycleBean.class);

    public void init() {
        log.info("LyfecycleBean: init");
    }
    public void destroy() {
        log.info("LyfecycleBean: destroy");
    }
}
