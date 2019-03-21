package com.zlys.collection.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Description: 角色管理
 *
 * @author czx
 * @date: 2019-03-21 09:36:31
 */
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
	
	/**排班开始时间*/
	private String startTime;
	
	/**排班结束时间*/
	private String endTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDriverCheck() {
        return driverCheck;
    }

    public void setDriverCheck(String driverCheck) {
        this.driverCheck = driverCheck;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIdCrad() {
        return idCrad;
    }

    public void setIdCrad(String idCrad) {
        this.idCrad = idCrad;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "DriverEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", type=" + type +
                ", department='" + department + '\'' +
                ", driverCheck='" + driverCheck + '\'' +
                ", createdTime=" + createdTime +
                ", updateTime=" + updateTime +
                ", idCrad='" + idCrad + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}