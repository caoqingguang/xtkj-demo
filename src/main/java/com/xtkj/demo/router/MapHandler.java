package com.xtkj.demo.router;

import com.xtkj.demo.pojo.MapPojo;
import com.xtkj.demo.service.MapService;
import com.xtkj.demo.tools.JsonTool;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by caoqingguang on 2017/7/2.
 */
public class MapHandler implements Handler {

    @Inject
    private MapService mapService;
    @Override
    public void handle(Context ctx) throws Exception {
        List<MapPojo> mapPojos = mapService.someMap();
        ctx.getResponse().send(JsonTool.obj2Str(mapPojos));
    }
}
