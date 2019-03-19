package com.zlys.collection.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Description: 车辆信息表
 *
 * @author czx
 * @date: 2019-03-18 10:07:04
 */
@Data
public class CarEntity implements Serializable {

    private static final long serialVersionUID = 1L;

	/***/
	private Integer id;
	
	/**车牌号*/
	private String plateNumber;
	
	/**车辆颜色*/
	private String colour;
	
	/**终端号*/
	private String deviceSerial;
	
	/**部门名称*/
	private String departmentName;
	
	/**所属区域*/
	private String departmentArea;
	
	/**车辆类型:0-转运车，1-收运车*/
	private Integer type;
	
	/**车辆生产厂家*/
	private String manufacturer;
	
	/**车辆型号*/
	private String modelNum;
	
	/**车辆载重量*/
	private String loadCapacity;
	
	/**车辆自重*/
	private String weight;
	
	/**车辆购买时间*/
	private Date purchasingDate;
	
	/**车辆初始公里数*/
	private String initialMileage;
	
	/**车辆备注信息*/
	private String remark;
	
	/**车辆图片-图片地址*/
	private String images;
	
	/**创建时间*/
	private Date createdtime;
	
	/**更新时间*/
	private Date updatetime;
	

}