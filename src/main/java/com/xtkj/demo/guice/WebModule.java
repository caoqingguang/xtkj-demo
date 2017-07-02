package com.xtkj.demo.guice;

import com.google.inject.AbstractModule;
import com.xtkj.demo.router.CellHandler;
import com.xtkj.demo.router.MapHandler;
import com.xtkj.demo.router.Router;
import com.xtkj.demo.router.UserHandler;
import com.xtkj.demo.service.CellService;
import com.xtkj.demo.service.MapService;

import javax.inject.Singleton;

/**
 * Created by caoqingguang on 2017/7/2.
 */
public class WebModule extends AbstractModule{

    @Override
    protected void configure() {
        //路由相关类
        bind(Router.class).in(Singleton.class);
        bind(UserHandler.class).in(Singleton.class);
        bind(CellHandler.class).in(Singleton.class);
        bind(MapHandler.class).in(Singleton.class);
        //service 相关类
        bind(UserHandler.class).in(Singleton.class);
        bind(CellService.class).in(Singleton.class);
        bind(MapService.class).in(Singleton.class);
        //数据库相关类

    }
}
