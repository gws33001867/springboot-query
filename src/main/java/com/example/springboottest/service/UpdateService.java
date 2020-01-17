package com.example.springboottest.service;

import com.example.springboottest.dto.UpdateBean;
import com.example.springboottest.mapper.smt.DeleteMapper;
import com.example.springboottest.mapper.smt.InsertMapper;
import com.example.springboottest.mapper.smt.UpdateMapper;
import com.example.springboottest.po.QueryParamters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UpdateService {

    @Autowired
    UpdateMapper updateMapper;

    @Autowired
    InsertMapper insertMapper;

    @Autowired
    DeleteMapper deleteMapper;

    @Transactional
    public int updateQuery(UpdateBean updateBean){

        List<QueryParamters> queryParamtersList = updateBean.getParams();

        System.out.println(updateBean);

        for(int i=0;i<queryParamtersList.size();i++){
            queryParamtersList.get(i).setParamsequence(Integer.toString(i));
        }

        System.out.println("userqueryid:"+updateBean.getUserqueryid());

        deleteMapper.deleteQueryParameters(updateBean.getUserqueryid());



        insertMapper.insertParameters(queryParamtersList);

        return updateMapper.updatequery(updateBean);
    }
}
