package com.xtkj.demo.conf;

import com.github.racc.tscg.TypesafeConfig;
import com.github.racc.tscg.TypesafeConfigModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.Data;

import javax.inject.Inject;
import java.io.File;

/**
 * Created by caoqingguang on 2017/7/2.
 */
@Data
public class ConfManager {

    @Inject
    @TypesafeConfig("databaseConfig")
    private DatabaseConfig databaseConfig;

    @Inject
    @TypesafeConfig("ssdbConfig")
    private SsdbConfig ssdbConfig;

    @Inject
    @TypesafeConfig("server.port")
    private Integer serverPort;


    private final Config config;
    private final Module module;
    private final Injector injector;

    public ConfManager(File configFile, String scanPath){
        config = ConfigFactory.parseFile(configFile);
        System.out.println(config);
        module = TypesafeConfigModule.fromConfigWithPackage(config, scanPath);
        injector = Guice.createInjector(module);
        injector.injectMembers(this);
    }
}
