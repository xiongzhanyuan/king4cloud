package com.king4cloud.orm.model;

import com.king4cloud.common.core.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 *
 */
@Getter
@Setter
public class UnAccount extends BaseModel {

	private String customerId;

	private String customerType;

	private BigDecimal accountAmount;

	private String accountStatus;

}
