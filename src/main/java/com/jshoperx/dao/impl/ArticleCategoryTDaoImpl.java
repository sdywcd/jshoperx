package com.jshoperx.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jshoperx.dao.ArticleCategoryTDao;
import com.jshoperx.entity.ArticleCategoryT;

/**
 * A data access object (DAO) providing persistence and search support for
 * ArticleCategoryT entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshoperx.entity.ArticleCategoryT
 * @author MyEclipse Persistence Tools
 */
@Repository("articleCategoryTDao")
public class ArticleCategoryTDaoImpl extends BaseTDaoImpl<ArticleCategoryT> implements ArticleCategoryTDao {

	private static final Logger log = LoggerFactory.getLogger(ArticleCategoryTDaoImpl.class);

}