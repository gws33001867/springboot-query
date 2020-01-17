package com.example.springboottest.service;

import com.example.springboottest.dto.AddQueryBean;
import com.example.springboottest.mapper.smt.InsertMapper;
import com.example.springboottest.po.Query;
import com.example.springboottest.po.QueryParamters;
import com.example.springboottest.util.SplitBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class InsertService {
    @Autowired
    InsertMapper InsertMapper;

    @Transactional
    public int insertQuery(AddQueryBean addQueryBean){

        Query query = SplitBeanUtil.splitQueryFromAddQueryBean(addQueryBean);
        List<QueryParamters> list_param = SplitBeanUtil.splitParametersFromAddQueryBean(addQueryBean);

        int flag=0;

       try{
            flag = InsertMapper.insertQuery(query);
       }catch (Exception e){
           throw e;
       }


        String userqueryid = String.valueOf(Integer.valueOf(query.getUserqueryid())+1);

        System.out.println(userqueryid);

        for (int i=0;i<list_param.size();i++){
            list_param.get(i).setUserqueryid(userqueryid);
            System.out.println(list_param.get(i));
        }

        System.out.println(flag);
        if(list_param.size()==0){
            return flag;
        }
        int flag2 = InsertMapper.insertParameters(list_param);
        return flag2;
    }

    @Transactional
    public int insertConfigList(String label,String envflag){
        int flag = InsertMapper.insertConfigList(label,envflag);
        return flag;
    }
    public int insertConfigList_query(String configlistid,String userqueryid){
        return InsertMapper.insertConfigList_query(configlistid, userqueryid);
    }
}
