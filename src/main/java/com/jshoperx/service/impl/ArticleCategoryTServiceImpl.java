package com.jshoperx.service.impl;

import com.jshoperx.entity.ArticleCategoryT;
import com.jshoperx.service.ArticleCategoryTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("articleCategoryTService")
@Scope("prototype")
public class ArticleCategoryTServiceImpl extends BaseTServiceImpl<ArticleCategoryT>implements ArticleCategoryTService {

}
