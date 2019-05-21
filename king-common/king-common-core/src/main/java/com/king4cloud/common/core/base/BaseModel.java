package com.king4cloud.common.core.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
public abstract class BaseModel implements Serializable {


    private static final long serialVersionUID = -3723719264393734515L;


    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    /**
     *  创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
//    /**
//     * 修改时间
//     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    /**
     * 创建用户Id
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUserId;
    /**
     * 创建用户名称
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUserName;
    /**
     * 修改用户Id
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateUserId;
    /**
     * 修改用户名称
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateUserName;

//    /**
//     * 逻辑删除字段
//     */
//    private Integer flagDelete;

}
