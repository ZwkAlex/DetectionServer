package com.zwk.detection.model;

import com.alibaba.fastjson.JSONObject;

public interface DetectionService {
    JSONObject startDetection(String req);
}
