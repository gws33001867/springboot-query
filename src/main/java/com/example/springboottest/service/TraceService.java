package com.example.springboottest.service;

import com.example.springboottest.mapper.smt.TraceOracleMapper;
import com.example.springboottest.po.CLRData;
import com.example.springboottest.po.FQC;
import com.example.springboottest.po.MachineData;
import com.example.springboottest.mapper.sqlserver.SqlServerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class TraceService {

    @Autowired
    TraceOracleMapper traceOracleMapper;

    @Autowired
    SqlServerMapper sqlServerMapper;

    public List<LinkedHashMap<String,String>> queryLotHistory(String barcode){

        List<LinkedHashMap<String,String>> lists;

        lists = traceOracleMapper.queryLotHistory(barcode);

        return lists;
    }

    public List<CLRData> queryCLR(String barcode){

        List<CLRData> lists;

        String panelId = "";
        String parentPanelId = "";
        String panelSeq = "";
        String parentPanelSeq = "";

        List<LinkedHashMap<String,String>> panelinfo = traceOracleMapper.queryPanelInfo(barcode);

        if(panelinfo.size()>0){
            panelId = panelinfo.get(0).get("Panel_Id") ==null ? "":panelinfo.get(0).get("Panel_Id").toString().trim().toUpperCase();
            parentPanelId = panelinfo.get(0).get("ParentPanel_Id") ==null ? "":panelinfo.get(0).get("ParentPanel_Id").toString().trim().toUpperCase();
            parentPanelSeq = panelinfo.get(0).get("BarCode_Seq") ==null ? "":panelinfo.get(0).get("BarCode_Seq").toString().trim().toUpperCase();
            panelSeq = panelinfo.get(0).get("BarCode_Seq2") ==null ? "":panelinfo.get(0).get("BarCode_Seq2").toString().trim().toUpperCase();

            lists = sqlServerMapper.queryCLR_pcs(barcode,panelId,panelSeq);
        }else{
            lists = sqlServerMapper.queryCLR_panel(barcode);
        }

        return lists;
    }

    public List<LinkedHashMap<String,String>> queryET(String barcode){

        List<LinkedHashMap<String,String>> lists = null;

        int flag = traceOracleMapper.isPack(barcode);

        if(flag==0){
            lists = sqlServerMapper.queryET_1(barcode);
        }else{
            List<String> list = traceOracleMapper.querylot(barcode);

            for(int i=0;i<list.size();i++){
                List<LinkedHashMap<String,String>> list2 = sqlServerMapper.queryET_2(list.get(i));

                for(int j=0;j<list2.size();j++){
                    lists.add(list2.get(j));
                }
            }
        }

        return lists;
    }

    public List<LinkedHashMap<String,String>> queryLot_Mat(String barcode){

        List<LinkedHashMap<String,String>> lists;

        lists = traceOracleMapper.queryLot_Mat(barcode);

        return lists;
    }

    public List<LinkedHashMap<String,String>> queryLotByMat(String barcode){

        List<LinkedHashMap<String,String>> lists;

        lists = traceOracleMapper.queryLotByMat(barcode);

        return lists;
    }

//    public String queryLot_Pack(String barcode)  {
//
//        List<LinkedHashMap<String,String>> lists;
//
//        String result="";
//        String url = "http://MESINBND01/ShippingLotLinkBoxid/webService.asmx?wsdl";
//        String namespace = "http://tempuri.org/";
//        String method = "GetBarCode";
//        String soapActionURI = "http://tempuri.org/GetBarCode";
//        String info = "";
//
//        org.apache.axis.client.Service service = new org.apache.axis.client.Service();
//        Call call;
//        try{
//             call = (Call) service.createCall();
//             call.setTargetEndpointAddress(url);
//             call.setSOAPActionURI(soapActionURI);
//             call.setOperationName(new QName(namespace,method));
//             call.addParameter("barcode",XMLType.XSD_STRING,ParameterMode.IN);
//             call.setReturnType(XMLType.XSD_STRING);
//             String[] str = new String[1];
//             str[0]=barcode;
//             Object obj = call.invoke(str);
//             result = (String) obj;
//            System.out.println(obj);
//        }catch (ServiceException e){
//            e.printStackTrace();
//        }catch (RemoteException e){
//            e.printStackTrace();
//        }
//
//
//
//        return result;
//    }

    public List<LinkedHashMap<String,String>> queryMICLED(String barcode){

        List<LinkedHashMap<String,String>> lists;

        lists = traceOracleMapper.queryMICLED(barcode);

        return lists;
    }

    public List<LinkedHashMap<String,String>> queryPack(String barcode){

        List<LinkedHashMap<String,String>> lists;

        lists = traceOracleMapper.queryPack(barcode);

        return lists;
    }
//待重写
    public List<LinkedHashMap<String,String>> queryXRAY(String barcode){

        List<LinkedHashMap<String,String>> lists;

        String panelId = "";
        String parentPanelId = "";
        String panelSeq = "";
        String parentPanelSeq = "";

        List<LinkedHashMap<String,String>> panelinfo = traceOracleMapper.queryPanelInfo(barcode);

        if(panelinfo.size()>0){
            panelId = panelinfo.get(0).get("Panel_Id") ==null ? "":panelinfo.get(0).get("Panel_Id").toString().trim().toUpperCase();
            parentPanelId = panelinfo.get(0).get("ParentPanel_Id") ==null ? "":panelinfo.get(0).get("ParentPanel_Id").toString().trim().toUpperCase();
            parentPanelSeq = panelinfo.get(0).get("BarCode_Seq") ==null ? "":panelinfo.get(0).get("BarCode_Seq").toString().trim().toUpperCase();
            panelSeq = panelinfo.get(0).get("BarCode_Seq2") ==null ? "":panelinfo.get(0).get("BarCode_Seq2").toString().trim().toUpperCase();
        }

        List<LinkedHashMap<String,String>> list1 = sqlServerMapper.queryXRAY(barcode,panelId,panelSeq,parentPanelId,parentPanelSeq);

        for(int i=0;i<list1.size();i++){
            String testType = list1.get(i).get("TestType")==null ? "":list1.get(i).get("TestType").toString().trim().toUpperCase();
            String resourceName = list1.get(i).get("ResourceName")==null ? "":list1.get(i).get("ResourceName").toString().trim().toUpperCase();
            String optTime = list1.get(i).get("OptTime")==null ? "":list1.get(i).get("OptTime").toString().trim().toUpperCase();

           // if(testType.contains("X-"))
               // list1.get(i).get("ImagePath") =
        }

        lists = traceOracleMapper.queryMICLED(barcode);

        return lists;
    }

    public  String GetImageServerPath(String resource,String opttime,String lot) throws ParseException {
        String imagepath = "";
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        Date timespan = formatter.parse(opttime);

        String strMap ="";

        String server = "xrayfileser1".toUpperCase();
        String productionip = "10.1.10.32";
        String mesip = "172.16.193.67";
        String username = "";
        String pwd = "";
        String sharefilename = "";
        String resourcefamilyname = "";

        List<LinkedHashMap<String,String>> list = traceOracleMapper.queryImageServerPath();

        return "1";
    }

    public List<MachineData> queryMachineData(String barcode){

        return traceOracleMapper.queryMachineData(barcode);
    }

    public List<FQC> queryFQC(String barcode){
        return traceOracleMapper.queryFQC(barcode);
    }

    public List<LinkedHashMap<String,String>> queryMachineTotal(String barcode){

        List<String> workareas = traceOracleMapper.queryWorkArea(barcode);

        //System.out.println(workareas.toString());

        List<String> Loop = new ArrayList<>();
        for(String workarea : workareas){
            System.out.println(workarea);
            if("SMT-FEA".equals(workarea) ||"SMT-FEB".equals(workarea) || "SMT-FEC".equals(workarea)){
                Loop.add(workarea.substring(6,7));
                System.out.println(workarea.substring(6,7));
            }

        }
        System.out.println(Loop);
        List<String> header = new ArrayList<>();
        header.add("Panel");
        header.add("Position");
        header.add("PcsBarcode");
        header.add("BadMark");

        if(Loop.size()==1){
            header.add("A面SPI");
            header.add("A面AOI");
        }else if(Loop.size()==2){
            header.add("A面SPI");
            header.add("A面AOI");
            header.add("B面SPI");
            header.add("B面AOI");
        }else if(Loop.size()==3){
            header.add("A面SPI");
            header.add("A面AOI");
            header.add("B面SPI");
            header.add("B面AOI");
            header.add("C面SPI");
            header.add("C面AOI");
        }
        header.add("归咎工序");
        header.add("汇总");
        List<LinkedHashMap<String,String>> badmark = traceOracleMapper.querybadark(barcode);

        List<String> MachineType = new ArrayList<>();
        MachineType.add("SPI");
        MachineType.add("AOI");
        int Q=0;
        for(String LoopVal : Loop){
            for(String type : MachineType){
                Q += 1;
                String barcode_seq = badmark.get(0).get("PANEL_ID")+
                        Integer.parseInt(String.valueOf(badmark.get(0).get("BARCODE_SEQ")));
                List<LinkedHashMap<String,String>> results = traceOracleMapper.queryTestResult(barcode,barcode_seq,type,LoopVal);

                //System.out.println(results);
                for(int i=0;i<badmark.size();i++){
                    if(results!=null && results.size()>0){
                        if(Q==1)
                            badmark.get(i).put("A面SPI",results.get(i).get("TRESULT"));
                        else if (Q==2)
                            badmark.get(i).put("A面AOI",results.get(i).get("TRESULT"));
                        else if (Q==3)
                            badmark.get(i).put("B面SPI",results.get(i).get("TRESULT"));
                        else if (Q==4)
                            badmark.get(i).put("B面AOI",results.get(i).get("TRESULT"));
                        else if (Q==5)
                            badmark.get(i).put("C面SPI",results.get(i).get("TRESULT"));
                        else if (Q==6)
                            badmark.get(i).put("C面AOI",results.get(i).get("TRESULT"));
                    }

                }

            }
        }
        try{
            if(Loop.size()==1){
                for(int i=0;i<badmark.size();i++) {
                    if ("NG".equals(badmark.get(i).get("STATUS"))) {
                        badmark.get(i).put("归咎工序", "");
                        badmark.get(i).put("汇总", "FAIL");
                    } else if ("FAIL".equals(badmark.get(i).get("A面SPI"))) {
                        badmark.get(i).put("归咎工序", "SMT-FEA");
                        badmark.get(i).put("汇总", "FAIL");
                    } else if (StringUtils.isEmpty(badmark.get(i).get("A面SPI").trim())) {
                        badmark.get(i).put("归咎工序", "");
                        badmark.get(i).put("汇总", "A面SPI不存在");
                    } else {
                        badmark.get(i).put("归咎工序", "");
                        badmark.get(i).put("汇总", "PASS");
                    }
                }
            }else if (Loop.size()==2){
                for(int i=0;i<badmark.size();i++) {
                    if ("NG".equals(badmark.get(i).get("STATUS"))) {
                        badmark.get(i).put("归咎工序", "");
                        badmark.get(i).put("汇总", "FAIL");
                    } else if ("FAIL".equals(badmark.get(i).get("A面SPI"))) {
                        badmark.get(i).put("归咎工序", "SMT-FEA");
                        badmark.get(i).put("汇总", "FAIL");
                    } else if (StringUtils.isEmpty(badmark.get(i).get("A面SPI").trim())) {
                        badmark.get(i).put("归咎工序", "");
                        badmark.get(i).put("汇总", "A面SPI不存在");
                    }else if("FAIL".equals(badmark.get(i).get("B面SPI"))){
                        badmark.get(i).put("归咎工序","SMT-FEB");
                        badmark.get(i).put("汇总","FAIL");
                    }else if(StringUtils.isEmpty(badmark.get(i).get("B面SPI").trim())){
                        badmark.get(i).put("归咎工序","");
                        badmark.get(i).put("汇总","B面SPI不存在");
                    }else {
                        badmark.get(i).put("归咎工序", "");
                        badmark.get(i).put("汇总", "PASS");
                    }
                }
            }else if(Loop.size()==3){
                System.out.println("333:"+badmark.toString());
                for(int i=0;i<badmark.size();i++){
                    if("NG".equals(badmark.get(i).get("STATUS"))){
                        badmark.get(i).put("归咎工序","");
                        badmark.get(i).put("汇总","FAIL");
                    }else if("FAIL".equals(badmark.get(i).get("A面SPI"))){
                        badmark.get(i).put("归咎工序","SMT-FEA");
                        badmark.get(i).put("汇总","FAIL");
                    }else if(StringUtils.isEmpty(badmark.get(i).get("A面SPI").trim())){
                        badmark.get(i).put("归咎工序","");
                        badmark.get(i).put("汇总","A面SPI不存在");
                    }else if("FAIL".equals(badmark.get(i).get("B面SPI"))){
                        badmark.get(i).put("归咎工序","SMT-FEB");
                        badmark.get(i).put("汇总","FAIL");
                    }else if(StringUtils.isEmpty(badmark.get(i).get("B面SPI").trim())){
                        badmark.get(i).put("归咎工序","");
                        badmark.get(i).put("汇总","B面SPI不存在");
                    }else if("FAIL".equals(badmark.get(i).get("C面SPI"))){
                        badmark.get(i).put("归咎工序","SMT-FEC");
                        badmark.get(i).put("汇总","FAIL");
                    }else if(StringUtils.isEmpty(badmark.get(i).get("C面SPI").trim())){
                        badmark.get(i).put("归咎工序","");
                        badmark.get(i).put("汇总","C面SPI不存在");
                    }else{
                        badmark.get(i).put("归咎工序","");
                        badmark.get(i).put("汇总","PASS");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return  badmark;
        }
    }
}














