package com.zwk.detection.contoller;

import com.alibaba.fastjson.JSONObject;
import com.zwk.detection.entity.Response;
import com.zwk.detection.entity.TrashEntity;
import com.zwk.detection.service.DetectionServiceImpl;
import com.zwk.detection.service.TrashDescriptionServiceImpl;
import com.zwk.detection.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MasterController {

    private final DetectionServiceImpl detectionService;
    private final TrashDescriptionServiceImpl trashDescriptionService;

    @Autowired
    MasterController(DetectionServiceImpl detectionService, TrashDescriptionServiceImpl trashDescriptionService){
        this.detectionService = detectionService;
        this.trashDescriptionService = trashDescriptionService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<Response> postImage(@RequestBody String req_json){
        System.out.println("Receive a post request");
        JSONObject resp_json_obj = detectionService.startDetection(req_json);
        if (StringUtils.isEmpty(resp_json_obj)){
            System.out.println("Return "+ResponseUtil.error().toString());
            return new ResponseEntity<>(ResponseUtil.error(),HttpStatus.BAD_REQUEST);
        }else if(resp_json_obj.getInteger("size")==0){
            System.out.println("Return "+ResponseUtil.empty().toString());
            return new ResponseEntity<>(ResponseUtil.empty(),HttpStatus.OK);
        }else{
            System.out.println("Return "+ResponseUtil.success(resp_json_obj).toString());
            return new ResponseEntity<>(ResponseUtil.success(resp_json_obj), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResponseEntity<Response> getTrashDescription(@PathVariable Long id){
        System.out.println("Receive a get request");
        TrashEntity resp_entity = trashDescriptionService.getTrashDescription(id);
        if (ObjectUtils.isEmpty(resp_entity)||resp_entity.getId()==null){
            System.out.println("Return "+ResponseUtil.error().toString());
            return new ResponseEntity<>(ResponseUtil.error(),HttpStatus.BAD_REQUEST);
        }else{
            System.out.println("Return "+ResponseUtil.success(resp_entity).toString());
            return new ResponseEntity<>(ResponseUtil.success(resp_entity), HttpStatus.OK);
        }
    }

}
