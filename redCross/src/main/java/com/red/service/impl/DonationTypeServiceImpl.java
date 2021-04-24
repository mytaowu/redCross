package com.red.service.impl;

import com.red.entity.DonationType;
import com.red.mapper.DonationTypeMapper;
import com.red.service.DonationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: TMingYi
 * @date: 2020/8/30 23:24
 */
@Service
public class DonationTypeServiceImpl implements DonationTypeService {

    @Autowired
    private DonationTypeMapper donationTypeMapper;

    @Override
    public List<DonationType> selectAll() {
        return donationTypeMapper.selectAll();
    }
}
