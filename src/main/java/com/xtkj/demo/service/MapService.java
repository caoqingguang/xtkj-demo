package com.xtkj.demo.service;

import com.xtkj.demo.pojo.MapPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoqingguang on 2017/7/2.
 */
public class MapService {

    public List<MapPojo> someMap(){
        List<MapPojo> list=new ArrayList<>();
        MapPojo bgmap = new MapPojo();
        bgmap.setMapName("秦皇岛地图");
        bgmap.setMapType("polygon");
        list.add(bgmap);
        MapPojo line1 = new MapPojo();
        line1.setMapName("京哈铁路");
        line1.setMapType("line");
        list.add(line1);
        MapPojo line2 = new MapPojo();
        line2.setMapName("京秦高速");
        line2.setMapType("line");
        list.add(line2);
        MapPojo point = new MapPojo();
        point.setMapName("市政府");
        point.setMapType("point");
        list.add(point);
        return list;


    }
}
