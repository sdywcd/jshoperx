package com.jshoperx.service.impl;

import com.jshoperx.entity.OrderSnapshotT;
import com.jshoperx.service.OrderSnapshotTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service("orderSnapshotTService")
@Scope("prototype")
public class OrderSnapshotTServiceImpl extends BaseTServiceImpl<OrderSnapshotT> implements OrderSnapshotTService {

}
