package com.zlys.collection.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Description: 部门表
 *
 * @author czx
 * @date: 2019-02-28 09:58:30
 */
@Data
public class DepartmentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

	/**自增id，主键*/
	private Integer id;
	
	/**部门名称*/
	private String name;
	
	/**所属区域*/
	private String area;
	
	/**部门类型，0（收集站）、1（中转站）*/
	private Integer type;
	
	/**地理位置*/
	private String loc;
	
	/**负责人*/
	private String people;
	
	/**负责人电话*/
	private String phone;
	
	/**部门登录账户*/
	private String username;
	
	/**部门登录密码*/
	private String password;
	
	/**创建时间*/
	private Date createdtime;
	
	/**更新时间*/
	private Date updatetime;
	

}