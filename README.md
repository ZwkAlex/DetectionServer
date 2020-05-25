# DetectionServer
基于SpringBoot 负责前端与python后端通讯
垃圾识别服务端 
基本流程 前端post发送图片 -> 此服务端 通过socket 端口 将图片发送至python识别端-> 识别端识别结果返回此服务端 -> 此服务端返回至前端  
