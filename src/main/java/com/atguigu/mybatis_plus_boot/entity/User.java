package com.atguigu.mybatis_plus_boot.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;


@Data
public class User {

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;

    @Version
    private Integer version;

   // @TableId(type = IdType.ID_WORKER)
    private long id;
    private String name;
    private Integer age;
    private String email;

}
