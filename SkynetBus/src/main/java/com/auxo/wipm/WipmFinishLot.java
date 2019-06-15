package com.skynet.wipm;

import java.util.List;

import com.skynet.orm.base.DataIn;
import com.skynet.orm.base.DataOut;
import com.skynet.orm.exception.ServiceException;
import com.skynet.orm.pojo.ETCMCGRPDFNT;
import com.skynet.orm.pojo.WIPMLOTTMAST;
import com.skynet.orm.service.AbstractService;

import tmesis.service.JsonBean;

public class WipmFinishLot extends AbstractService {
	@Override
	public void doService(DataIn inData, DataOut outData) throws ServiceException {
		ETCMCGRPDFNT etcmcgrpdfnt = new ETCMCGRPDFNT();
		etcmcgrpdfnt.setVaule("FACTORY", "DEMO");
		etcmcgrpdfnt.setVaule("CARRIER_GRP", "TEST_OK");
		
//		List<ETCMCGRPDFNT> etcmcgrpdfnts = exectorHelper.selectList(etcmcgrpdfnt, "XXXX-001");
//		
//		for (ETCMCGRPDFNT etcmcgrpdfnt2 : etcmcgrpdfnts) {
//			System.out.println(etcmcgrpdfnt2.getValue("CARRIER_GRP"));
//		}
		
		
//		etcmcgrpdfnt.setVaule("CARRIER_GRP_DESC", "TEST");
//		etcmcgrpdfnt.setVaule("USAGE_LIMIT_COUNT", 1);
//		etcmcgrpdfnt.setVaule("USAGE_LIMIT_TIME", 2);
//		etcmcgrpdfnt.setVaule("CLEAN_LIMIT_COUNT", 1);
//		etcmcgrpdfnt.setVaule("PLAN_TERMINATE_TIME", "20190522");
//		etcmcgrpdfnt.setVaule("CREATE_USER_ID", "TEST USER");
//		etcmcgrpdfnt.setVaule("USAGE_LIMIT_ALARM_ID", "TEST");
//		etcmcgrpdfnt.setVaule("CLEAN_LIMIT_ALARM_ID", "TEST");
//		etcmcgrpdfnt.setVaule("CREATE_TIME", "20190522");
		etcmcgrpdfnt.setVaule("UPDATE_USER_ID", "TT");
		etcmcgrpdfnt.setVaule("UPDATE_TIME", "201905221535");
		
//		etcmcgrpdfnt.setWhereVaule("CARRIER_GRP", "TEST_OK");
		
		
//		exectorHelper.insert(etcmcgrpdfnt, "XXXX-001");
//		exectorHelper.update(etcmcgrpdfnt, "XXXX-001");
//		exectorHelper.updateByKey(etcmcgrpdfnt, "XXXX-001");
		exectorHelper.deleteByKey(etcmcgrpdfnt, "XXXX-001");
		
	}

	@Override
	public void isValid(DataIn inData, DataOut outData) {
		System.out.println("check me");
		
	}

}
