/**
 * Copyright (C), 2015-2020, bogewang
 * FileName: MyModel
 * Author:   foren236598164@aliyun.com
 * Date:     2020/5/12 19:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.bogewang.model;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author foren236598164@aliyun.com
 * @create 2020/5/12
 * @since 1.0.0
 */
@Data
public class MyModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID id;
    private String info;

}
