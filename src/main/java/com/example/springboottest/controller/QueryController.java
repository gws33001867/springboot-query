package com.example.springboottest.controller;

import com.example.springboottest.dto.*;
import com.example.springboottest.model.ResultBean;
import com.example.springboottest.model.ResultInfo;
import com.example.springboottest.po.Query;
import com.example.springboottest.service.QueryService;
import com.example.springboottest.util.RegexUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/query")
@Api(value = "查询的相关接口",tags = "查询Rest API")
public class QueryController {

    @Autowired
    QueryService queryService;

    @RequestMapping("bianalysis")
    @ResponseBody
    @ApiOperation(value = "BI报表分析",httpMethod = "GET")
    public List<analysis> bianalysis(){


        List<analysis> list = queryService.bi_anaysis();


        return  list;
    }


    @RequestMapping("formquery")
    @ResponseBody
    @ApiOperation(value = "查询条件FORM参数",httpMethod = "GET")
    public List<Map<String,String>> queryFormByName(String queryname){


        List<Map<String,String>> list = queryService.queryFormByName(queryname);

       // System.out.println(queryService.queryFormByName(queryname));
        return  list;
    }


    @RequestMapping("queryList")
    @ResponseBody
    @ApiOperation(value = "查询列表查询",httpMethod = "GET")
    public List<Query> queryList(){


        List<Query> list = queryService.queryQueryList(1);

        return  list;
    }


    @RequestMapping("queryForUpdate")
    @ResponseBody
    @ApiOperation(value = "查询待修改",httpMethod = "GET")
    public List<QueryBean> queryForUpdate(){


        List<QueryBean> list = queryService.queryForUpdate();

        return  list;
    }

    /**
     * 查询当前分组可以用来添加的查询（去除已添加和非本环境的查询）
     * @param configlist
     * @return
     */
    @RequestMapping("queryList_config")
    @ResponseBody
    @ApiOperation(value = "查询列表可添加的查询",httpMethod = "GET")
    public List<Query> queryQueryList_addconfig(String configlist,String envflag){


        List<Query> list = queryService.queryQueryList_addconfig(configlist,envflag);

        return  list;
    }

    @RequestMapping("/queryByProcedure")
    @CrossOrigin
    @ResponseBody
    @ApiIgnore
    public List<LinkedHashMap<String,Object>> queryByProcedure(String barcode){
        ResultBean<Map<String,String>> result = new ResultBean<>();
        PageInfo<Map<String,String>> pageInfo;



        return queryService.queryByProcedure(barcode);
    }

    @RequestMapping("/queryData")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "使用查询",httpMethod = "GET")
    public ResultBean<LinkedHashMap<String,String>> QueryResult(@RequestBody QueryParams queryParams){
        ResultBean<LinkedHashMap<String,String>> result = new ResultBean<>();
        PageInfo<LinkedHashMap<String,String>> pageInfo;

       // System.out.println(queryParams.toString());

        String envflag = queryParams.getEnvflag();
        String sqltxt =queryService.querySql(queryParams.getUserqueryname());
        String sql = RegexUtil.restoreSql(sqltxt,queryParams.getParam());
        int page = queryParams.getPage();
        int limit = queryParams.getLimit();

        if(StringUtils.isEmpty(queryParams)){
            result.setCode("200");
            result.setCount(0);
            result.setData(null);
            result.setMsg("success");
        }else {
            pageInfo =  queryService.useQuery(page,limit,sql,envflag);
            result.setCode("200");
            result.setCount((int) pageInfo.getTotal());
            result.setData(pageInfo.getList());
            result.setMsg("success");
        }
        return result;
    }

    @RequestMapping("/queryConfigList")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "查询列表明细",httpMethod = "GET")
    public ResultInfo queryConfigList(){
        ResultInfo result = new ResultInfo();

        List<ConfigBean> list =  queryService.queryConfigList();
            result.setCode(200);
            result.setResult(list);
            result.setMsg("success");

        return result;
    }

    @GetMapping("/Roles")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "查询用户权限列表",httpMethod = "GET")
    public ResultInfo queryUserRoles(@RequestParam(value="employeeId") String employeeId){
        ResultInfo result = new ResultInfo();

        List<String> list =  queryService.queryRoles(employeeId);

        result.setCode(200);
        result.setResult(list);

        result.setMsg("success");

        return result;
    }
}
