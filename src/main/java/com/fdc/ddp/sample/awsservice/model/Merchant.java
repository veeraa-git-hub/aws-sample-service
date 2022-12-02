package com.fdc.ddp.sample.awsservice.model;

public class Merchant {

    private String merchantId;
    private String merchantName;
    private String merchantGroup;
    private String appName;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantGroup() {
        return merchantGroup;
    }

    public void setMerchantGroup(String merchantGroup) {
        this.merchantGroup = merchantGroup;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
