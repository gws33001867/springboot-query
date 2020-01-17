package com.example.springboottest.service;

import com.example.springboottest.dto.ConfigBean;
import com.example.springboottest.dto.QueryBean;
import com.example.springboottest.dto.analysis;
import com.example.springboottest.mapper.flex.FlexMapper;
import com.example.springboottest.mapper.smt.QueryMapper;
import com.example.springboottest.po.Query;
import com.example.springboottest.mapper.sqlserver.SqlServerMapper;
import com.example.springboottest.po.QueryParamters;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QueryService {

    //smt查询
    @Autowired
    QueryMapper queryMapper;

    //sqlserver查询
    @Autowired
    SqlServerMapper sqlServerMapper;

    //flex查询
    @Autowired
    FlexMapper flexMapper;

    public List<analysis> bi_anaysis(){
        return queryMapper.bi_anaysis();
    }

    public List<String> queryRoles(String employeeId){
        List<String> list = queryMapper.queryRoles(employeeId);

        return list;
    }

    public List<Map<String,String>> queryFormByName(String queryname){

        String queryid = queryMapper.queryQueryId(queryname);

        System.out.println(queryid);

        List<Map<String,String>> lists= queryMapper.queryFormByName(queryname);

        if (lists==null){
            System.out.println("service null...");
        }

        return lists;

    }

    public List<LinkedHashMap<String,Object>> queryByProcedure(String barcode){

        List<LinkedHashMap<String,String>> lists;
        List<LinkedHashMap<String,Object>> ref = Lists.newArrayList();
        Map<String,Object> mapIn = new HashMap<String, Object>();

        String pro = "mesinterface.bi_report_query_pkg.query_micled_info";
        String params = "'PHYQT19BD0KFF',";

        mapIn.put("params",params);
        mapIn.put("pro",pro);
        mapIn.put("barcode",barcode);

        //mapIn.put("res",refs);

        queryMapper.queryByProcedure(mapIn);

        //lists = (List<LinkedHashMap<String,String>>) mapIn.get("ref");

        return (List) mapIn.get("res");
    }


    public List<Query> queryQueryList(Integer flag){


        List<Query> lists= queryMapper.queryQueryList(flag);

        if (lists==null){
            System.out.println("service null...");
        }

        return lists;

    }

    public String querySql(String queryname){
        return queryMapper.querySql(queryname);
    }

    /**
     * 删除修改查询的列表显示
     * @return
     */
    public List<QueryBean> queryForUpdate(){

        List<QueryBean> list = new ArrayList<QueryBean>();

        List<Query> query = queryMapper.queryForUpdate();

        for(int i=0;i<query.size();i++){
            QueryBean queryBean = new QueryBean();
            queryBean.setQuery(query.get(i));
            List<QueryParamters> queryParamters =
                    queryMapper.queryForUpdate_params(query.get(i).getUserqueryname());
            queryBean.setQueryParamters(queryParamters);
            list.add(queryBean);
        }

        return list;
    }

    public PageInfo<LinkedHashMap<String,String>> useQuery(int page, int limit, String sql,String envflag){

        List<LinkedHashMap<String,String>> lists;

       // PageHelper.startPage(page,limit);

        System.out.println("page:"+page+"limit:"+limit+"sql:"+sql+"envflag:"+envflag);
        Map map = new HashMap();

        map.put("sql",sql);

        if("SMT".equals(envflag)){
            PageHelper.startPage(page,limit);
            lists = queryMapper.useQuery(map);
        }else if("FLEX".equals(envflag)){
            PageHelper.startPage(page,limit);
            lists = flexMapper.useQuery(map);

        }else if("SQLSERVER".equals(envflag)){
            PageHelper.startPage(page,limit);
            lists = sqlServerMapper.useQuery(map);
        }else{
            lists=null;
        }
        System.out.println("list:"+lists);

        PageInfo<LinkedHashMap<String,String>> pageInfo = new PageInfo<LinkedHashMap<String,String>>(lists);

        return pageInfo;
    }

    public List<ConfigBean> queryConfigList(){

        List<LinkedHashMap<String,String>> lists;

        //PageHelper.startPage(page,limit);


        lists = queryMapper.queryConfigList();

        List<ConfigBean> list = new ArrayList<ConfigBean>();

        for(int i=0;i<lists.size();i++){
            ConfigBean configBean = new ConfigBean();
            String configlistid = String.valueOf(lists.get(i).get("CONFIGLISTID"));
            String label = lists.get(i).get("LABEL");
            String envflag = lists.get(i).get("ENVFLAG");
            List<Query> children= queryMapper.queryConfigList_query(configlistid);
            configBean.setLabel(label);
            configBean.setConfiglistid(configlistid);
            configBean.setChildren(children);
            configBean.setEnvflag(envflag);
            list.add(configBean);
        }

        return list;
    }

    public List<Query> queryQueryList_addconfig(String configlist,String envflag){


        List<Query> lists= queryMapper.queryQueryList_addconfig(configlist,envflag);

        if (lists==null){
            System.out.println("service null...");
        }

        return lists;

    }

//    @Transactional(transactionManager = "sqlServerTransactionManager")
//    public List<LinkedHashMap<String,String>> queryCLR(){
//
//        List<LinkedHashMap<String,String>> lists;
//
//      //  PageHelper.startPage(page,limit);
//
//      //  Map map = new HashMap();
//
//       // map.put("sql",sql);
//
//       // lists = queryMapper.useQuery(map);
//
//        lists = sqlServerMapper.queryCLR();
//
//
//        return lists;
//    }


}
