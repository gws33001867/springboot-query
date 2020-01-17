package com.example.springboottest.controller;


import com.example.springboottest.dto.ConfigBean;
import com.example.springboottest.model.ResultInfo;
import com.example.springboottest.po.CLRData;
import com.example.springboottest.po.FQC;
import com.example.springboottest.po.MachineData;
import com.example.springboottest.service.TraceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/trace")
@Api(value = "SMT追溯查询接口",tags = "接口Rest API")
public class TraceabilityController {

    @Autowired
    TraceService traceService;

    @RequestMapping("/Lot_History")
//    @SystemControllerLog(description = "查询WIPLOT")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "根据LOT查询明细",httpMethod = "GET")
    public ResultInfo queryLotHistory(String barcode){
        ResultInfo result = new ResultInfo();

        if(StringUtils.isEmpty(barcode.trim())){
            result.setCode(200);
            result.setResult(null);
            result.setMsg("success");
            return result;
        }

        List<LinkedHashMap<String,String>> list =  traceService.queryLotHistory(barcode);
        result.setCode(200);
        result.setResult(list);
        result.setMsg("success");

        return result;
    }

    @RequestMapping("/CLR")
//    @SystemControllerLog(description = "查询CLR")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "根据barcode查询弱弹数据",httpMethod = "GET")
    public ResultInfo queryCLR(String barcode){
        ResultInfo result = new ResultInfo();
        if(StringUtils.isEmpty(barcode.trim())){
            result.setCode(200);
            result.setResult(null);
            result.setMsg("success");
            return result;
        }
        List<CLRData> list =  traceService.queryCLR(barcode);
        result.setCode(200);
        result.setResult(list);
        result.setMsg("success");

        return result;
    }


    @RequestMapping("/ET")
//    @SystemControllerLog(description = "查询ET")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "根据barcode查询ET数据",httpMethod = "GET")
    public ResultInfo queryET(String barcode){
        ResultInfo result = new ResultInfo();

        if(StringUtils.isEmpty(barcode.trim())){
            result.setCode(200);
            result.setResult(null);
            result.setMsg("success");
            return result;
        }
        List<LinkedHashMap<String,String>> list =  traceService.queryET(barcode);
        result.setCode(200);
        result.setResult(list);
        result.setMsg("success");

        return result;
    }

    @RequestMapping("/Lot_Mat")
//    @SystemControllerLog(description = "查询物料消耗")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "根据LOT查物料",httpMethod = "GET")
    public ResultInfo queryLot_Mat(String barcode){
        ResultInfo result = new ResultInfo();

        if(StringUtils.isEmpty(barcode.trim())){
            result.setCode(200);
            result.setResult(null);
            result.setMsg("success");
            return result;
        }
        List<LinkedHashMap<String,String>> list =  traceService.queryLot_Mat(barcode);
        result.setCode(200);
        result.setResult(list);
        result.setMsg("success");

        return result;
    }

    @RequestMapping("/LotByMat")
//    @SystemControllerLog(description = "物料LOT查询WIP")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "根据物料查询LOT",httpMethod = "GET")
    public ResultInfo queryLotByMat(String barcode){
        ResultInfo result = new ResultInfo();

        if(StringUtils.isEmpty(barcode.trim())){
            result.setCode(200);
            result.setResult(null);
            result.setMsg("success");
            return result;
        }
        List<LinkedHashMap<String,String>> list =  traceService.queryLotByMat(barcode);
        result.setCode(200);
        result.setResult(list);
        result.setMsg("success");

        return result;
    }


    @RequestMapping("/MICLED")
//    @SystemControllerLog(description = "查询MICLED")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "根据LOT查询MICLED",httpMethod = "GET")
    public ResultInfo queryMICLED(String barcode) {
        ResultInfo result = new ResultInfo();

        if(StringUtils.isEmpty(barcode.trim())){
            result.setCode(200);
            result.setResult(null);
            result.setMsg("success");
            return result;
        }
        List<LinkedHashMap<String,String>> list =  traceService.queryMICLED(barcode);
        result.setCode(200);
        result.setResult(list);
        result.setMsg("success");

        return result;
    }


    @RequestMapping("/PACK")
//    @SystemControllerLog(description = "查询PACK")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "根据LOT查询PACK",httpMethod = "GET")
    public ResultInfo queryPACK(String barcode) {
        ResultInfo result = new ResultInfo();

        if(StringUtils.isEmpty(barcode.trim())){
            result.setCode(200);
            result.setResult(null);
            result.setMsg("success");
            return result;
        }
        List<LinkedHashMap<String,String>> list =  traceService.queryPack(barcode);
        result.setCode(200);
        result.setResult(list);
        result.setMsg("success");

        return result;
    }


    @RequestMapping("/MachineData")
//    @SystemControllerLog(description = "查询设备采集")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "查询设备采集",httpMethod = "GET")
    public ResultInfo queryMachineData(String barcode){
        ResultInfo result = new ResultInfo();

        if(StringUtils.isEmpty(barcode.trim())){
            result.setCode(200);
            result.setResult(null);
            result.setMsg("success");
            return result;
        }
        List<MachineData> list =  traceService.queryMachineData(barcode);
        result.setCode(200);
        result.setResult(list);
        result.setMsg("success");

        return result;
    }

    @RequestMapping("/FQC")
//    @SystemControllerLog(description = "查询FQC")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "查询FQC",httpMethod = "GET")
    public ResultInfo queryFQC(String barcode){
        ResultInfo result = new ResultInfo();

        if(StringUtils.isEmpty(barcode.trim())){
            result.setCode(200);
            result.setResult(null);
            result.setMsg("success");
            return result;
        }
        List<FQC> list =  traceService.queryFQC(barcode);
        result.setCode(200);
        result.setResult(list);
        result.setMsg("success");

        return result;
    }

    @RequestMapping("/MachineTotal")
//    @SystemControllerLog(description = "查询设备信息汇总")
    @CrossOrigin
    @ResponseBody
    @ApiOperation(value = "查询设备信息汇总",httpMethod = "GET")
    public ResultInfo queryMachineTotal(String barcode){
        ResultInfo result = new ResultInfo();

        if(StringUtils.isEmpty(barcode.trim())){
            result.setCode(200);
            result.setResult(null);
            result.setMsg("success");
            return result;
        }
        List<LinkedHashMap<String,String>> list =  traceService.queryMachineTotal(barcode);
        result.setCode(200);
        result.setResult(list);
        result.setMsg("success");

        return result;
    }
}
