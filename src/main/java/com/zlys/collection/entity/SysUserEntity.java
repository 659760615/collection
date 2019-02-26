package com.zlys.collection.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Description: 司机角色表
 *
 * @author czx
 * @date: 2019-02-26 13:50:54
 */
@Data
public class SysUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

	/**自增id，主键*/
	private Integer ID;
	
	/**用户姓名*/
	private String FULLNAME;
	
	/**用户身份证号*/
	private String SID;
	
	/**司机性别，0（男）、1（女）*/
	private Integer SEX;
	
	/**司机类别，0（转运司机）、1（收运司机）*/
	private Integer type;
	
	/**手机号码*/
	private String MOBILE;
	
	/**备注说明*/
	private String REMARK;
	
	/**司机部门名称*/
	private String COMPANYNAME;
	
	/**司机部门id*/
	private Integer COMPANYID;
	
	/**片区名*/
	private String AREANAME;
	
	/**创建时间*/
	private Date LASTTIME;
	
	/**更新时间*/
	private Date updateTime;
	

}