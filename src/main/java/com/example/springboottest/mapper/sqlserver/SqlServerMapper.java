package com.example.springboottest.mapper.sqlserver;

import com.example.springboottest.po.CLRData;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface SqlServerMapper {

    List<LinkedHashMap<String,String>> useQuery(Map map);

    List<CLRData> queryCLR_pcs(String barcode, String panelId, String panelSeq);

    List<CLRData> queryCLR_panel(String barcode);

    List<LinkedHashMap<String,String>> queryET_1(String barcode);

    List<LinkedHashMap<String,String>> queryET_2(String barcode);

    List<LinkedHashMap<String,String>> queryXRAY(String barcode,String panelId,String panelSeq,String parentPanelId,String parentPanelSeq);
}
