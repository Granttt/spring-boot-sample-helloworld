package com.example.utils;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author GXY
 * @Package com.example.utils
 * @date 2020/8/31 14:51
 * @Copyright © 2020-2021 新流通
 * @Description:List实现分页
 * https://blog.csdn.net/qq_28009065/article/details/88565998
 */
@Data
public class ListPageUtil<T> {
    /**原集合*/
    private List<T> data;

    /** 上一页 */
    private int lastPage;

    /** 当前页 */
    private int nowPage;

    /** 下一页 */
    private int nextPage;
//
    /** 每页条数 */
    private int pageSize;

    /** 总页数 */
    private int totalPage;

    /** 总数据条数 */
    private int totalCount;

    public ListPageUtil(List<T> data,int nowPage,int pageSize) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("data must be not empty!");
        }

        this.data = data;
        this.pageSize = pageSize;
        /*this.totalPage = data.size()/pageSize;
        if(data.size()%pageSize!=0){
            this.totalPage++;
        }*/

        this.nowPage = nowPage;
        this.totalCount = data.size();
        this.totalPage = (totalCount + pageSize - 1) / pageSize;
        this.lastPage = nowPage-1>1? nowPage-1:1;
        this.nextPage = nowPage>=totalPage? totalPage: nowPage + 1;
        System.out.println("当前页："+this.nowPage+"; 总记录数："+this.totalCount+"; 总页数："+this.totalPage+"; 上一页："
                    +this.lastPage+"; 下一页："+this.nextPage);

    }

    public List<T> getPagedList(){
        //开始索引
        int fromIndex = (nowPage - 1) * pageSize;
        if (fromIndex >= data.size()){
            return Collections.emptyList();//已经没有数据了,返回空数组
        }
        if (fromIndex < 0) {
            return Collections.emptyList();
        }

        //结束索引
        int toIndex = nowPage * pageSize;
        if (toIndex >= data.size()){
            toIndex = data.size();
        }
        return data.subList(fromIndex,toIndex);

    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        List<Integer> list = Arrays.asList(array);

        ListPageUtil<Integer> listPageUtil  = new ListPageUtil<>(list, 1, 5);
        List<Integer> pagedList = listPageUtil.getPagedList();
        System.out.println(JSON.toJSONString(pagedList));
    }
}
