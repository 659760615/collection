package com.zlys.collection.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Description: 角色管理
 *
 * @author czx
 * @date: 2019-03-04 11:05:36
 */
@Data
public class DriverEntity implements Serializable {

    private static final long serialVersionUID = 1L;

	/***/
	private Integer id;
	
	/**司机姓名*/
	private String name;
	
	/**司机性别( 0 女, 1男 )*/
	private Integer sex;
	
	/**司机类别( 0 收运司机, 1转运司机)*/
	private Integer type;
	
	/**所属部门*/
	private String department;
	
	/**考核项*/
	private String driverCheck;
	
	/**创建时间*/
	private Date createdTime;
	
	/**更新时间*/
	private Date updateTime;
	
	/**身份证号*/
	private String idCrad;
	

}