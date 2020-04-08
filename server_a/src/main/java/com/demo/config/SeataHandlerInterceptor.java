package com.demo.config;

import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author x_holic@outlook.com
 * @date 2020/4/9
 */
@Slf4j
public class SeataHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String xid = RootContext.getXID();
        String rpcXid = request.getHeader("TX_XID");
        //获取全局事务编号
        if(log.isDebugEnabled()) {
            log.debug("xid in RootContext {} xid in RpcContext {}", xid, rpcXid);
        }

        if(xid == null && rpcXid != null) {
            //设置全局事务编号
            RootContext.bind(rpcXid);
            if(log.isDebugEnabled()) {
                log.debug("bind {} to RootContext", rpcXid);
            }
        }

        return true;
    }
}
