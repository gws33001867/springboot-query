package com.example.springboottest.mapper.smt;

import com.example.springboottest.dto.AddQueryBean;
import com.example.springboottest.po.Query;
import com.example.springboottest.po.QueryParamters;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InsertMapper {

    /**
     * 插入查询sql文本
     * @param query
     * @return
     */
    int insertQuery(Query query);

    int insertParameters(List<QueryParamters> list);

    //增加分组信息
    int insertConfigList(String label,String envflag);

    //分组信息下挂查询
    int insertConfigList_query(String configlistid,String userqueryid);
}
