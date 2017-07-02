package com.xtkj.demo.router;

import com.xtkj.demo.pojo.CellPojo;
import com.xtkj.demo.service.CellService;
import com.xtkj.demo.tools.JsonTool;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import javax.inject.Inject;

/**
 * Created by caoqingguang on 2017/7/2.
 */
public class CellHandler implements Handler {

    @Inject
    private CellService cellService;
    @Override
    public void handle(Context ctx) throws Exception {
        CellPojo cell = cellService.getCellById(10001);
        ctx.getResponse().send(JsonTool.obj2Str(cell));
    }
}
