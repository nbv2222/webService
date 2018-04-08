package ru.tinkoff.entities;

import java.time.LocalDateTime;

public class Order {
    private Long applicationId;
    private Long contactId;
    private LocalDateTime dtCreated;
    private String productName;

    public Order() {
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public void setDtCreated(LocalDateTime dtCreated) {
        this.dtCreated = dtCreated;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public Long getContactId() {
        return contactId;
    }

    public LocalDateTime getDtCreated() {
        return dtCreated;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "applicationId=" + applicationId +
                ", contactId=" + contactId +
                ", dtCreated=" + dtCreated +
                ", productName='" + productName + '\'' +
                '}';
    }
}
