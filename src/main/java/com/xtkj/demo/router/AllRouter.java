package com.xtkj.demo.router;

import com.xtkj.demo.annotation.BgMethod;
import com.xtkj.demo.annotation.BgUrl;
import com.xtkj.demo.annotation.RegBean;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.MethodParameterScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import ratpack.func.Action;
import ratpack.handling.Chain;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.registry.Registry;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by caoqingguang on 2017/7/28.
 */
@RegBean
public class AllRouter implements Action<Chain> {

    @Override
    public void execute(Chain chain) throws Exception {
        chain.files(fhs->fhs.indexFiles("index.html"));
        regUrls(chain.getRegistry(),"com.xtkj.demo.router").forEach(handler->handler.regUrl(chain));
    }

    private List<AutoRegHandler> regUrls(Registry registry, String packageNamePrefix) {
        ConfigurationBuilder configBuilder =
                new ConfigurationBuilder()
                        .filterInputsBy(new FilterBuilder().includePackage(packageNamePrefix))
                        .setUrls(ClasspathHelper.forPackage(packageNamePrefix))
                        .setScanners(new MethodAnnotationsScanner());
        return new Reflections(configBuilder).getMethodsAnnotatedWith(BgUrl.class)
                .stream()
                .map(method -> {
                    Class<?> declaringClass = method.getDeclaringClass();
                    BgUrl annotation = method.getAnnotation(BgUrl.class);
                    Object target = registry.get(declaringClass);
                    return new AutoRegHandler(method, target, annotation);
                }).collect(Collectors.toList());
    }

    public static class AutoRegHandler implements Handler{

        private Method method;
        private Object target;
        private BgUrl bgUrl;

        public AutoRegHandler(Method method, Object target, BgUrl bgUrl) {
            this.method = method;
            this.target = target;
            this.bgUrl = bgUrl;
        }

        public void regUrl(Chain chain){
            String url = bgUrl.value();
            if(url.startsWith("/")){
                url=url.substring(1);
            }
            for (BgMethod bgMethod : bgUrl.methods()) {
                if(bgMethod==BgMethod.GET){
                    chain.get(url,this);
                }else if(bgMethod==BgMethod.POST){
                    chain.post(url,this);
                }
            }
        }

        @Override
        public void handle(Context ctx) throws Exception {
            method.invoke(target,ctx);
        }
    }

}
