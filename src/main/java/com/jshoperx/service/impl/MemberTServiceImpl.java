package com.jshoperx.service.impl;

import com.jshoperx.entity.MemberT;
import com.jshoperx.service.MemberTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("memberTService")
@Scope("prototype")
public class MemberTServiceImpl extends BaseTServiceImpl<MemberT> implements MemberTService{

}
