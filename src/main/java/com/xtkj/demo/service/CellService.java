package com.xtkj.demo.service;

import com.xtkj.demo.pojo.CellPojo;

/**
 * Created by caoqingguang on 2017/7/2.
 */
public class CellService {

    public CellPojo getCellById(Integer id){
        CellPojo cellPojo = new CellPojo();
        cellPojo.setId(id);
        cellPojo.setSiteName("QHD001");
        cellPojo.setCellName("QHD001A");
        cellPojo.setLongitude(119.2532);
        cellPojo.setLatitude(46.5306);
        return cellPojo;
    }
}
