package com.example.springboottest.dto;

import com.example.springboottest.po.Query;
import com.example.springboottest.po.QueryParamters;

import java.util.List;

public class QueryBean {
    private Query query;
    private List<QueryParamters> queryParamters;

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public List<QueryParamters> getQueryParamters() {
        return queryParamters;
    }

    public void setQueryParamters(List<QueryParamters> queryParamters) {
        this.queryParamters = queryParamters;
    }

    @Override
    public String toString() {
        return "QueryBean{" +
                "query=" + query +
                ", queryParamters=" + queryParamters +
                '}';
    }
}
