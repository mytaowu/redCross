package com.red.service;

import com.red.entity.DonationType;

import java.util.List;

/**
 * @author: TMingYi
 * @date: 2020/8/30 23:23
 */
public interface DonationTypeService {
    List<DonationType> selectAll();
}
