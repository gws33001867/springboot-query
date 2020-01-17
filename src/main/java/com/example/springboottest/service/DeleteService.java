package com.example.springboottest.service;

import com.example.springboottest.dto.DeleteConfigList_query;
import com.example.springboottest.mapper.smt.DeleteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeleteService {

    @Autowired
    DeleteMapper deleteMapper;

    @Transactional
    public int deleteConfigList(String configlistid){
        return deleteMapper.deleteConfigList(configlistid);
    }

    @Transactional
    public int deleteConfigList_query(List<DeleteConfigList_query> lists){
        int flag=0;
        for(int i=0;i<lists.size();i++){
            deleteMapper.deleteConfigList_query(Integer.valueOf(lists.get(i).getConfiglistid()),lists.get(i).getLists());
            flag++;
        }
        return flag;
    }

    @Transactional
    public int deletequery(String userqueryid){

        System.out.println("delete:"+deleteMapper.deletequery(userqueryid));
        return 1;
    }
}
