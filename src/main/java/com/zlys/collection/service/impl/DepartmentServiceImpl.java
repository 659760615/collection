package com.zlys.collection.service.impl;

import com.zlys.collection.dao.DepartmentMapper;
import com.zlys.collection.dao.UserMapper;
import com.zlys.collection.dao.UserRoleMapper;
import com.zlys.collection.entity.DepartmentEntity;
import com.zlys.collection.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @Description:
 * @author czx
 * @date: 2019-02-28 09:58:30
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private static Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
    @Transactional(rollbackFor=Exception.class)
	public Integer insertDepartment(DepartmentEntity entity) {
	   Integer id = null;
	   try {
           departmentMapper.insertSelective(entity);
           /*新增登录表*/
           userMapper.insert(entity.getUsername(),entity.getPassword());
           /*新增登录角色表*/
           id=userMapper.selectByUsername(entity.getUsername());
           userRoleMapper.insert(id,1);
           logger.info("新增部门信息suucess!");
           logger.info("新增部门登录权限信息suucess!");
		} catch (Exception e) {
           logger.info("新增部门信息error!");
           logger.info("新增部门登录权限信息error!");
           /*手动设置事务 注解无效*/
           TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return id;
	}
	
	@Override
	public void insertDepartments(List<DepartmentEntity> records) {
	   try {
	   		departmentMapper.insertRecords(records);
	   } catch(Exception e) {
	   }
	}

	@Override
	public DepartmentEntity queryDepartmentLimitOne(DepartmentEntity entity) {
		try {
			return departmentMapper.queryLimitOne(entity);
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<DepartmentEntity> queryByCond(DepartmentEntity entity) {
		try {
			return departmentMapper.queryByCond(entity);
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<DepartmentEntity> queryAll() {
		try {
			return departmentMapper.queryAll();
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public DepartmentEntity queryDepartmentById (Integer id) {
		try {
			return departmentMapper.queryById(id);
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public List<DepartmentEntity> queryDepartmentByIds (List<Integer> ids) {
		try {
			return departmentMapper.queryByIds(ids);
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
    @Transactional(rollbackFor=Exception.class)
	public boolean updateDepartmentById (DepartmentEntity entity) {
		try {
			departmentMapper.updateDepartmentById(entity);
			/*修改权限表账户密码*/
            int count=userMapper.update(entity.getUsername(),entity.getPassword());
            if(count == 0){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                logger.info("修改部门信息error!");
                return false;
            }
            logger.info("修改部门信息suucess!");
			return true;
        } catch(Exception e) {
            logger.info("修改部门信息error!");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
		}
	}
	
	@Override
	public boolean deleteDepartmentById (Integer id) {
		try {
			return departmentMapper.deleteDepartmentById(id) > 0;
		} catch(Exception e) {
			return false;
		}
	}
}
