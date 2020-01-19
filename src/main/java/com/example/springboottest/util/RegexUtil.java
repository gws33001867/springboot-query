package com.example.springboottest.util;

import com.example.springboottest.dto.Param;

import java.util.List;

public class RegexUtil {
    public static String restoreSql(String sql_origin, List<Param> params){

        for(int i=0;i<params.size();i++){
            String pattern_old = "\\?(?i)\\s*"+params.get(i).getKey();
            String pattern_new ="'"+params.get(i).getVal()+"'";


            sql_origin=sql_origin.replaceAll(pattern_old,pattern_new);
        }
        sql_origin = sql_origin.replaceAll(";"," ");

       // System.out.println(sql_origin);
        return sql_origin;
    }

    public static String restoreDeclareSql(String sql_origin, List<Param> params){

        for(int i=0;i<params.size();i++){
            String pattern_old = "\\?(?i)\\s*"+params.get(i).getKey();
            String pattern_new ="'"+params.get(i).getVal()+"'";


            sql_origin=sql_origin.replaceAll(pattern_old,pattern_new);
        }
        sql_origin = sql_origin.replaceAll(";"," ");

        //System.out.println(sql_origin);
        return sql_origin;
    }
}
