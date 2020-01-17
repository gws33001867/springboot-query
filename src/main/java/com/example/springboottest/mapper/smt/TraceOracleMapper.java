package com.example.springboottest.mapper.smt;

import com.example.springboottest.po.FQC;
import com.example.springboottest.po.MachineData;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface TraceOracleMapper {

    List<LinkedHashMap<String,String>> queryLotHistory(String barcode);

    //
    @Select("select count(*) qty from container c where c.containername=#{barcode} and m_ispacklot=1")
    int isPack(String barcode);

    @Select("select c.containername from container c " +
            "inner join container cc on cc.containerid=c.parentcontainerid " +
            "where cc.containername=#{barcode}")
    List<String> querylot(String barcode);

    List<LinkedHashMap<String,String>> queryLot_Mat(String barcode);

    List<LinkedHashMap<String,String>> queryLotByMat(String barcode);

    List<LinkedHashMap<String,String>> queryMICLED(String barcode);

    List<LinkedHashMap<String,String>> queryPanelInfo(String barcode);

    List<LinkedHashMap<String,String>> queryImageServerPath();

    List<MachineData> queryMachineData(String barcode);

    List<FQC> queryFQC(String barcode);

    List<String> queryWorkArea(String barcode);

    @Select("select panel_id,barcode_seq,barcode,status from mesinterface.m_labelprint_barcode_list " +
            "       where (panel_id=#{barcode} or barcode=#{barcode})order by to_number(barcode_seq) ASC")
    List<LinkedHashMap<String,String>> querybadark(String barcode);

    List<LinkedHashMap<String,String>> queryTestResult(String barcode,String barcode_seq,String type,String side);

    List<LinkedHashMap<String,String>> queryPack(String barcode);
}
