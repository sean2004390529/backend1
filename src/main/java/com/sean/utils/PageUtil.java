package com.sean.utils;

import com.github.pagehelper.Page;
import com.sean.vo.resp.PageVO;

import java.util.List;

/*
 * 根据com.github.pagehelper.Page，自定义PageVO的返回数据
 */

public class PageUtil {
    private PageUtil(){}
    
    public static <T> PageVO<T> getPageVO(List<T> list){
        PageVO<T> result=new PageVO<>();
        if(list instanceof Page){
            Page<T> page= (Page<T>) list;
            result.setTotalRows(page.getTotal());
            result.setTotalPages(page.getPages());
            result.setPageNum(page.getPageNum());
            result.setCurPageSize(page.getPageSize());
            result.setPageSize(page.size());
            result.setList(page.getResult());
        }
        return result;
    }
}
