/**
 * Copyright (C), 2015-2020, bogewang
 * FileName: RabbitMqController
 * Author:   foren236598164@aliyun.com
 * Date:     2020/5/13 12:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.bogewang.web.controller;

import com.bogewang.sender.Tut3Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author foren236598164@aliyun.com
 * @create 2020/5/13
 * @since 1.0.0
 */
@RestController
public class RabbitMqController {
    //发布
    @Autowired
    private Tut3Sender tut3Sender;


    @RequestMapping("/sendFanout")
    @ResponseBody
    private String sendFanout(){
        for(int i =0;i<10;i++) {
            tut3Sender.send();
        }
        return "ok";
    }
}
