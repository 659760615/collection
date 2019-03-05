package com.zlys.collection.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlys.collection.dao.DriverMapper;
import com.zlys.collection.entity.DriverEntity;
import com.zlys.collection.service.DriverService;
/**
 * @Description:
 * @author czx
 * @date: 2019-03-04 10:35:06
 */
@Service
public class DriverServiceImpl implements DriverService {

    private static Logger logger = LoggerFactory.getLogger(DriverServiceImpl.class);


    @Autowired
	private DriverMapper driverMapper;

	@Override
	public Integer insertDriver(DriverEntity entity) {
	   Integer id = null;
	   try {
			id=driverMapper.insertSelective(entity);
			logger.info("新增成功");
            return 1;
		} catch (Exception e) {
           logger.info("新增司机信息error");
           return 0;
       }
	}
	
	@Override
	public void insertDrivers(List<DriverEntity> records) {
	   try {
	   		driverMapper.insertRecords(records);
	   } catch(Exception e) {
	   }
	}

	@Override
	public DriverEntity queryDriverLimitOne(DriverEntity entity) {
		try {
			return driverMapper.queryLimitOne(entity);
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<DriverEntity> queryByCond(DriverEntity entity) {
		try {
			return driverMapper.queryByCond(entity);
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<DriverEntity> queryAll() {
		try {
			return driverMapper.queryAll();
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public DriverEntity queryDriverById (Integer id) {
		try {
			return driverMapper.queryById(id);
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public List<DriverEntity> queryDriverByIds (List<Integer> ids) {
		try {
			return driverMapper.queryByIds(ids);
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public boolean updateDriverById (DriverEntity entity) {
		try {
			return driverMapper.updateDriverById(entity) > 0;
		} catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean deleteDriverById (Integer id) {
		try {
			return driverMapper.deleteDriverById(id) > 0;
		} catch(Exception e) {
			return false;
		}
	}
}
