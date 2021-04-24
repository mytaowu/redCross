package com.red.service;

import com.red.entity.DonationPurpose;
import com.red.entity.DonationType;

import java.util.List;

/**
 * @author: TMingYi
 * @date: 2020/8/30 23:28
 */
public interface DonationPurposeService {
    List<DonationPurpose> selectAll();
}
