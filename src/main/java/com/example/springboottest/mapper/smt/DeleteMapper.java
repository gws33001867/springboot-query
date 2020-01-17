package com.example.springboottest.mapper.smt;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeleteMapper {

    int deleteConfigList(String configlistid);

    int deleteConfigList_query(int configlistid, List<String> lists);

    int deletequery(String userqueryid);

    int deleteQueryParameters(String userqueryid);
}
