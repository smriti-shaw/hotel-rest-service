package com.agoda.hotel.dto;

public class RateLimitModel {

    private String apiKey;
    private Long lastTry;
    private Integer count;

    public RateLimitModel(String ipAddress, String clientName) {
        this.apiKey = clientName+ipAddress;
        this.lastTry = System.currentTimeMillis();
        this.count = 0;
    }

    public String getApiKey() {
        return apiKey;
    }

    public Long getLastTry() {
        return lastTry;
    }

    public void setLastTry(Long lastTry) {
        this.lastTry = lastTry;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
