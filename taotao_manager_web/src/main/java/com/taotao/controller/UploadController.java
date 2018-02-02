package com.taotao.controller;

import com.taotao.utils.FastDFSClient;
import com.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {


    @Value("${TAOTAO_IMAGE_URL}")
    private String TAOTAO_IMAGE_URL;
    //文件上傳

  /*  @RequestMapping(value = "/pic/upload",produces = MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    @ResponseBody
    public Map<String,Object> uploadFile(MultipartFile uploadFile){


        try {
            //获取文件的扩展名
            System.out.println(uploadFile==null);
            String originalFilename = uploadFile.getOriginalFilename();
            String extname = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            //2創建一個fastdfs的客戶端
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
            //執行上傳處理
           // fastDFSClient.uploadFile()
            String path = fastDFSClient.uploadFile(uploadFile.getBytes(),extname);
            //拼接返回的url和ip地址,拼接成完整的url
            String url = TAOTAO_IMAGE_URL + path;
            //返回map
            Map<String, Object> reult = new HashMap<String, Object>();
            reult.put("error",0);
            reult.put("url",url);
            return reult;

        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> reult = new HashMap<String, Object>();
            reult.put("error",1);
            reult.put("message","圖片上傳失敗");
            return reult;
        }

    }*/
  @RequestMapping(value = "/pic/upload",produces = MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
  @ResponseBody
  public String uploadFile(MultipartFile uploadFile){
      try {
          //1、取文件的扩展名
          String originalFilename = uploadFile.getOriginalFilename();
          String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
          //2、创建一个FastDFS的客户端
          FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
          //3、执行上传处理
          String path = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
          //4、拼接返回的url和ip地址，拼装成完整的url
          String url = TAOTAO_IMAGE_URL + path;
          //5、返回map
          Map result = new HashMap<>();
          result.put("error", 0);
          result.put("url", url);
          return JsonUtils.objectToJson(result);
      } catch (Exception e) {
          e.printStackTrace();
          //5、返回map
          Map result = new HashMap<>();
          result.put("error", 1);
          result.put("message", "图片上传失败");
          return JsonUtils.objectToJson(result);
      }
  }


}
