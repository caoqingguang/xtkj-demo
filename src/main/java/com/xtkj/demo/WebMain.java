package com.xtkj.demo;

import com.google.inject.Injector;
import com.xtkj.demo.conf.ConfManager;
import com.xtkj.demo.guice.WebModule;
import com.xtkj.demo.router.Router;
import ratpack.guice.Guice;
import ratpack.registry.Registry;
import ratpack.server.RatpackServer;

import java.nio.file.Paths;
import java.util.Date;

/**
 * Created by caoqingguang on 2017/7/2.
 */
public class WebMain {

    public static void main(String[] args) throws Exception {
        RatpackServer.start(rss->{
            System.out.println(System.getenv("PORT"));
            rss.serverConfig(ssb->ssb.port(Integer.parseInt(System.getenv("PORT")))).handlers(chain->{
                chain.get("time",ctx->{
                    ctx.render(new Date().toString());
                }).all(ctx->{
                    ctx.render("this is caoqingguang server");
                });
            });
        });
//        //1.全部配置
//        ConfManager confManager = new ConfManager(Paths.get("config.conf").toFile(), "com.xtkj.demo");
//        //2.对象工厂
//        Injector injector = confManager.getInjector().createChildInjector(new WebModule());
//        //3.web框架相关配置
//        RatpackServer.start(rss->{
//            rss.serverConfig(scb->{  //3-1 设置web服务端口
//                scb.port(confManager.getServerPort());
//            }).handlers(chain->{  //3-2设置web路由
//                chain.prefix("demo",Router.class);
//            }).registry(  //3-3设置web服务工厂
//                    Guice.registry(injector)
//            );
//        });
    }
}
