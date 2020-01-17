package com.example.springboottest.mapper.flex;

import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface FlexMapper {

    List<LinkedHashMap<String,String>> useQuery(Map map);
}
