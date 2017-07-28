package com.xtkj.demo;

import com.google.common.base.Strings;
import com.google.inject.Injector;
import com.xtkj.demo.conf.ConfManager;
import com.xtkj.demo.guice.WebModule;
import com.xtkj.demo.router.AllRouter;
import com.xtkj.demo.router.Router;
import ratpack.guice.Guice;
import ratpack.registry.Registry;
import ratpack.server.RatpackServer;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * Created by caoqingguang on 2017/7/2.
 */
public class WebMain {

    public static void main(String[] args) throws Exception {
//        String portStr = System.getenv("PORT");
//        int port=5432;
//        if(!Strings.isNullOrEmpty(portStr)){
//            port=Integer.valueOf(portStr);
//        }
//        int portLast=port;
        //1.全部配置
        ConfManager confManager = new ConfManager(Paths.get("config.conf").toFile(), "com.xtkj.demo");
        //2.对象工厂
        Injector injector = confManager.getInjector().createChildInjector(new WebModule());
        //3.web框架相关配置
        RatpackServer.start(rss->{
            Path staticDir = Paths.get("static").toAbsolutePath();
            rss.serverConfig(scb -> {  //3-1 设置web服务端口
                scb.port(confManager.getServerPort()).baseDir(staticDir);
            }).registry(  //3-2设置web服务工厂
                    Guice.registry(injector)
            ).handlers(injector.getInstance(AllRouter.class));//3-3 设置路由
        });
    }
}
