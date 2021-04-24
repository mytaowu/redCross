package com.red.service.impl;

import com.red.entity.DonationPurpose;
import com.red.entity.DonationType;
import com.red.mapper.DonationPurposeMapper;
import com.red.service.DonationPurposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: TMingYi
 * @date: 2020/8/30 23:28
 */
@Service
public class DonationPurposeServiceImple implements DonationPurposeService {

    @Autowired
    private DonationPurposeMapper donationPurposeMapper;

    @Override
    public List<DonationPurpose> selectAll() {
        return donationPurposeMapper.selectAll();
    }
}
