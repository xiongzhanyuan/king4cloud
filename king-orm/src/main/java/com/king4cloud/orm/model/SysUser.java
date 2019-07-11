package com.king4cloud.orm.model;

import com.king4cloud.common.core.base.BaseModel;
import com.king4cloud.common.core.constant.CommonConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 */
@Setter
@Getter
@ApiModel(description = "")
public class SysUser extends BaseModel {


	/** 用户名 */
	@ApiModelProperty(value = "用户名")
	private String username;

	/** 密码 */
	@ApiModelProperty(value = "密码")
	private String password;

	/** 是否可用 */
	@ApiModelProperty(value = "是否可用")
	private CommonConstants.DelFlag delFlag;

	/** 备注 */
	@ApiModelProperty(value = "备注")
	private String remark;

	@ApiModelProperty(value = "")
	private CommonConstants.LoginType type;

}
