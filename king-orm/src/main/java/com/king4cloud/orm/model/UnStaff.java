package com.king4cloud.orm.model;


import com.king4cloud.common.core.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * 教职工表（学生+教师）
 */
@Setter
@Getter
public class UnStaff extends BaseModel {


	private String staffName;

	private String idcard;

	private String staffCode;

	private String professionNum;

	private String professionName;

	private String professionId;

	private String openId;

	private String campusId;

	private String collegeId;

	private String classId;

	private String grade;

}
