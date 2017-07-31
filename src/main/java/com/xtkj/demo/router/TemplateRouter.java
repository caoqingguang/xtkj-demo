package com.xtkj.demo.router;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import ratpack.handling.Chain;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.io.StringWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoqingguang on 2017/7/31.
 */
public class TemplateRouter {

    public static void templatePages(Chain chain) {
        List<Group> nav = new ArrayList<>();
        Group sys = new Group().setTitle("我的系统")
                .addPage("Home", "home");
        Group map = new Group().setTitle("地图相关")
                .addPage("地图功能1", "module1page1")
                .addPage("地图功能2", "module1page2");
        Group table = new Group().setTitle("报表系统")
                .addPage("报表系统1", "module2page1")
                .addPage("报表系统2", "module2page2");
        Group task = new Group().setTitle("任务系统")
                .addPage("任务系统1","module3page1")
                .addPage("任务系统2","module3page2");
        Group user = new Group().setTitle("用户管理")
                .addPage("用户管理1","module4page1")
                .addPage("用户管理2","module4page2");
        nav.add(sys);
        nav.add(map);
        nav.add(table);
        nav.add(task);
        nav.add(user);
        for (Group group : nav) {
            for (Page page : group.pages) {
                TemplateHandler templateHandler = new TemplateHandler(page, group, nav);
                chain.get(templateHandler.getUri(), templateHandler);
            }
        }
    }

    //模板
    private static class TemplateHandler implements Handler{
        private Page page;
        private Group group;
        private List<Group> nav;
        public TemplateHandler(Page page,Group group,List<Group> nav){
            this.page=page;
            this.group=group;
            this.nav=nav;
        }

        public String getUri(){
            return this.page.getPosition();
        }

        @Override
        public void handle(Context context) throws Exception {
            VelocityEngine ve = new VelocityEngine();
            System.out.println(Paths.get("static").toAbsolutePath().toString());
            ve.addProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, Paths.get("static").toAbsolutePath().toString());
            ve.addProperty(RuntimeConstants.INPUT_ENCODING,"UTF8");
            ve.addProperty(RuntimeConstants.OUTPUT_ENCODING,"UTF8");
            ve.init();
            Template template = ve.getTemplate("template.html","utf-8");
            VelocityContext ctx = new VelocityContext();
            ctx.put("group",group);
            ctx.put("page",page);
            ctx.put("nav",nav);
            ctx.put("username","曹庆光");
            StringWriter sw = new StringWriter();
            template.merge(ctx,sw);
            context.getResponse().getHeaders().add("content-type","text/html;charset=UTF-8");
            String result = sw.toString();
            System.out.println(result);
            context.render(result);
        }
    }


    public static class Group{
        private String title;
        private List<Page> pages=new ArrayList<>();

        public String getTitle() {
            return title;
        }

        public List<Page> getPages() {
            return pages;
        }

        public Group setTitle(String title) {
            this.title = title;
            return this;
        }

        public Group addPage(Page page) {
            pages.add(page);
            return this;
        }

        public Group addPage(String pageTitle,String pagePosition){
            return this.addPage(new Page(pageTitle,pagePosition));
        }
    }

    public static class Page{
        private String title;
        private String position;

        public Page(String title, String position) {
            this.title = title;
            this.position = position;
        }

        public String getTitle() {
            return title;
        }

        public String getPosition() {
            return position;
        }

    }
}
