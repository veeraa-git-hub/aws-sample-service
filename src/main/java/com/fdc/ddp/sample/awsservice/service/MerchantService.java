package com.fdc.ddp.sample.awsservice.service;

import com.fdc.ddp.sample.awsservice.config.ApplicationProperties;
import com.fdc.ddp.sample.awsservice.model.Merchant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class MerchantService {

    private static final Logger logger = LoggerFactory.getLogger(MerchantService.class);
    private Map<String, Merchant> merchantCache;

    @Autowired
    private ApplicationProperties appProps;

    public MerchantService() {
        merchantCache = new HashMap<>();
    }

    public Merchant saveMerchant(Merchant merchant) {
        if (merchant != null) {
            merchant.setMerchantId(UUID.randomUUID().toString());
            merchant.setAppName(appProps.getAppName());
            merchantCache.put(merchant.getMerchantId(), merchant);
            logger.info("Merchant Info saved. Name : {}, Id : {}", merchant.getMerchantName(), merchant.getMerchantId());
        }
        return merchant;
    }

    public Merchant getMerchant(String merchantId) {
        Merchant merchant = null;
        if (merchantId != null && merchantCache.containsKey(merchantId)) {
            merchant = merchantCache.get(merchantId);
            logger.info("Merchant Info retrieved. Name : {}, Id : {}", merchant.getMerchantName(), merchant.getMerchantId());
        } else {
            logger.info("Merchant Info does not exist. Id : {}, returning default one", merchantId);
            merchant = getDefaultMerchant();
        }
        return merchant;
    }
    
    private Merchant getDefaultMerchant() {
        Merchant merchant = new Merchant();
        merchant.setMerchantId(UUID.randomUUID().toString());
        merchant.setAppName(appProps.getAppName());
        merchant.setMerchantName("State Farm Auto - Default");
        merchant.setMerchantGroup("State Farm");
        return merch
    }
}
