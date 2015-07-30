package com.jshoperx.service.impl;

import com.jshoperx.entity.MemberGroupT;
import com.jshoperx.service.MemberGroupTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("memberGroupTService")
@Scope("prototype")
public class MemberGroupTServiceImpl extends BaseTServiceImpl<MemberGroupT>implements MemberGroupTService{

}
