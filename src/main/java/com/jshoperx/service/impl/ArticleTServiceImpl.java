package com.jshoperx.service.impl;

import com.jshoperx.entity.ArticleT;
import com.jshoperx.service.ArticleTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("articleTService")
@Scope("prototype")
public class ArticleTServiceImpl extends BaseTServiceImpl<ArticleT> implements ArticleTService {

}
