package com.zwk.detection.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zwk.detection.dao.TrashDao;
import com.zwk.detection.model.DetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

@Service("detectionService")
public class DetectionServiceImpl implements DetectionService {
    private static final String DETECTION_HOST = getLocalIP();
    private static final int PORT = 11111;
    private final TrashDao trashDao;

    @Autowired
    DetectionServiceImpl(TrashDao trashDao){
        this.trashDao = trashDao;
    }

    private String getDetectionResult(String json_string) throws IOException {
        String line;
        System.out.println("Start socket on "+DETECTION_HOST+" with port "+PORT);
        Socket socket = new Socket(DETECTION_HOST, PORT);
        PrintStream out = new PrintStream(socket.getOutputStream());
        out.print(json_string);
        out.print("OVER");
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null)
            sb.append(line);
        br.close();
        System.out.println("Get a response "+sb.toString());
        if (sb.toString().length() < 3)
            return null;
        try {
            socket.close();
            System.out.println("Close socket");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private static String getLocalIP() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public JSONObject startDetection(String req) {
        JSONObject jsonObject = null;
        try {
            jsonObject=JSONObject.parseObject(this.getDetectionResult(req));
            JSONArray jsonArray= jsonObject.getJSONArray("object");
            for(int i=0;i<jsonArray.size();i++){
                JSONObject j=jsonArray.getJSONObject(i);
                String name_CN=trashDao.getNameCNById(j.getLong("id"));
                j.put("name_CN",name_CN);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }

}
