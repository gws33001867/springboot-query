package com.example.springboottest.util;

import com.example.springboottest.dto.AddQueryBean;
import com.example.springboottest.dto.TableData;
import com.example.springboottest.po.Query;
import com.example.springboottest.po.QueryParamters;

import java.util.ArrayList;
import java.util.List;

public class SplitBeanUtil {

    /**
     * 从表单输入的参数json数据解析出sql文本
     * @param queryBean
     * @return
     */
    public static Query splitQueryFromAddQueryBean(AddQueryBean queryBean){
        Query query = new Query();
        query.setUserqueryname(queryBean.getUserqueryname());
        query.setDescription(queryBean.getDescription());
        query.setNotes(queryBean.getNotes());
        query.setQuerytext(queryBean.getQuerytext());
        query.setResultsetsizelimit(queryBean.getResultsetsizelimit());
        query.setEnvflag(queryBean.getEnvflag());
        query.setAddtype(queryBean.getAddtype());
        return query;
    }

    /**
     * 从表单输入参数的json数据解析出参数部分
     * @param queryBean
     * @return
     */
    public static List<QueryParamters> splitParametersFromAddQueryBean(AddQueryBean queryBean){
        List<QueryParamters> list = new ArrayList<QueryParamters>();
        List<TableData> tableData = queryBean.getTableData();
        QueryParamters paramters;
        for(int i=0;i<tableData.size();i++){
            TableData data = tableData.get(i);
            paramters = new QueryParamters();
            paramters.setUserqueryparametername(data.getArgs());
            paramters.setParamsequence(Integer.toString(i));
            paramters.setDatatype(data.getType());
            paramters.setDefaultvalue(data.getDefaultValue());
            paramters.setLabel(data.getLabel());
            paramters.setPlaceholder(data.getPlaceholder());
            paramters.setKey(data.getKey());
            list.add(paramters);
        }
        return list;
    }
}
