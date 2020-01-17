package com.example.springboottest.mapper.smt;

import com.example.springboottest.dto.Environment;
import com.example.springboottest.dto.analysis;
import com.example.springboottest.po.Query;
import com.example.springboottest.po.QueryParamters;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface QueryMapper {

    List<analysis> bi_anaysis();

    String queryQueryId(String queryname);

    List<String> queryRoles(String employeeId);

   // List<Environment> queryEnvironment();

    List<Map<String,String>> queryFormByName(String queryname);

    List<Query> queryQueryList(Integer flag);

    String querySql(String queryname);

    List<LinkedHashMap<String,String>> useQuery(Map map);

    List<LinkedHashMap<String,String>> queryConfigList();

    List<Query> queryForUpdate();

    List<QueryParamters> queryForUpdate_params(String queryname);

    List<Query> queryQueryList_addconfig(String configlist,String envflag);

    List<Query> queryConfigList_query(String configlistid);

    List<LinkedHashMap<String,String>> queryByProcedure(Map map);

}
