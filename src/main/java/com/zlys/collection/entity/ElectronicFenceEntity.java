package com.zlys.collection.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Description: 电子围栏
 *
 * @author czx
 * @date: 2019-03-20 10:54:11
 */
@Data
public class ElectronicFenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

	/***/
	private Integer id;
	
	/**电子围栏名称*/
	private String name;
	
	/**所属部门*/
	private String department;
	
	/**创建时间*/
	private Date createdTime;
	
	/**修改时间*/
	private Date updateTime;
	
	/**经纬度集合*/
	private String fence;
	
	/**备注信息*/
	private String remark;
	

}