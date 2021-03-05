/**
 * Copyright (C), 2015-2020, bogewang
 * FileName: User
 * Author:   foren236598164@aliyun.com
 * Date:     2020/5/12 19:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.bogewang.model;

import lombok.Setter;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉
 * 〈〉
 *
 * @author foren236598164@aliyun.com
 * @create 2020/5/12
 * @since 1.0.0
 */
public class User implements Serializable {
    private static final long serialVersionUID = 2L;
    @Setter
    private String name;
    @Setter
    private Integer age;



}
