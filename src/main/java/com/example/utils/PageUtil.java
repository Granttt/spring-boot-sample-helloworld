package com.example.utils;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: list分页
 * @Author: gxy
 * @Date: 2020/6/27 11:20
 * @Version: 1.0
 */
public class PageUtil {

    public static <T> List<T> startPage(List<T> list, Integer pageIndex, Integer pageSize) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<>();
        }
        Integer count = list.size(); // 记录总数
        int pageCount = 0; // 页数
        if (count % pageSize == 0) {
            pageCount = count / pageSize;
        } else {
            pageCount = count / pageSize + 1;
        }

        int fromIndex = 0; // 开始索引
        int toIndex = 0; // 结束索引

        if (pageIndex.longValue() != pageCount) {
            fromIndex = (pageIndex - 1) * pageSize;
            toIndex = fromIndex + pageSize;
        } else {
            fromIndex = (pageIndex - 1) * pageSize;
            toIndex = count;
        }
        if(toIndex > count){
            return new ArrayList<>();
        }
        return list.subList(fromIndex, toIndex);
    }


}
