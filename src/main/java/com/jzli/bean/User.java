package com.jzli.bean;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * =======================================================
 *
 * @Company 金色家网络科技有限公司-云存储业务部
 * @Date ：2017/3/21
 * @Author ：li.jinzhao
 * @Version ：0.0.1
 * @Description ：
 * ========================================================
 */
@Document(
        indexName = "test-jzli",
        type = "user",
        shards = 1,
        replicas = 1
)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("name")
    private String name;
    @ApiModelProperty("mobile")
    private String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
