package com.jshoperx.service.impl;

import com.jshoperx.entity.MemberGradeT;
import com.jshoperx.service.MemberGradeTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service("memberGradeTService")
@Scope("prototype")
public class MemberGradeTServiceImpl extends BaseTServiceImpl<MemberGradeT>implements MemberGradeTService {



}
