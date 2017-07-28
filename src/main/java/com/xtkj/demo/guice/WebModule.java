package com.xtkj.demo.guice;

import com.google.inject.AbstractModule;
import com.xtkj.demo.annotation.BgUrl;
import com.xtkj.demo.annotation.RegBean;
import com.xtkj.demo.router.*;
import com.xtkj.demo.service.CellService;
import com.xtkj.demo.service.MapService;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import javax.inject.Singleton;
import java.util.Set;

/**
 * Created by caoqingguang on 2017/7/2.
 */
public class WebModule extends AbstractModule{

    @Override
    protected void configure() {
        scan("com.xtkj.demo").forEach(clazz->{
            bind(clazz).in(Singleton.class);
        });
    }

    private Set<Class<?>> scan(String packageNamePrefix){
        ConfigurationBuilder configBuilder =
                new ConfigurationBuilder()
                        .filterInputsBy(new FilterBuilder().includePackage(packageNamePrefix))
                        .setUrls(ClasspathHelper.forPackage(packageNamePrefix))
                        .setScanners(new TypeAnnotationsScanner(),new SubTypesScanner());
        return new Reflections(configBuilder).getTypesAnnotatedWith(RegBean.class);
    }
}
