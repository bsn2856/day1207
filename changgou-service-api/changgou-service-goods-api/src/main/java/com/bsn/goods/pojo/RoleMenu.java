package com.bsn.goods.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.*;

/****
 * @Author:shenkunlin
 * @Description:RoleMenu构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "RoleMenu",value = "RoleMenu")
@Table(name="tb_role_menu")
public class RoleMenu implements Serializable {

	@ApiModelProperty(value = "",required = false)
	@Id
    @Column(name = "role_id")
	private Integer roleId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "menu_id")
	private String menuId;//



	//get方法
	public Integer getRoleId() {
		return roleId;
	}

	//set方法
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	//get方法
	public String getMenuId() {
		return menuId;
	}

	//set方法
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}


}
