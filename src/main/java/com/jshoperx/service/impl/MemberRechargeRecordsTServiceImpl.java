package com.jshoperx.service.impl;

import com.jshoperx.entity.MemberRechargeRecordsT;
import com.jshoperx.service.MemberRechargeRecordsTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("memberRechargeRecordsTService")
@Scope("prototype")
public class MemberRechargeRecordsTServiceImpl extends BaseTServiceImpl<MemberRechargeRecordsT>implements
		MemberRechargeRecordsTService {


}
