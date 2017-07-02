package com.xtkj.demo.router;

import ratpack.func.Action;
import ratpack.handling.Chain;

import javax.inject.Inject;

/**
 * Created by caoqingguang on 2017/7/2.
 */
public class Router implements Action<Chain> {

    @Inject
    private UserHandler userHandler;
    @Inject
    private MapHandler mapHandler;
    @Inject
    private CellHandler cellHandler;

    @Override
    public void execute(Chain chain) throws Exception {
        chain.get("user",userHandler);
        chain.get("map",mapHandler);
        chain.get("cell",cellHandler);
    }

}
