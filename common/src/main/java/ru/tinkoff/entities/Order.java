package ru.tinkoff.entities;

import java.time.LocalDateTime;
import java.util.Date;

public class Order {
    private Long application_id;
    private Long contact_id;
    private LocalDateTime dt_created;
    private String productName;

    public Order() {
    }

    public void setApplication_id(Long application_id) {
        this.application_id = application_id;
    }

    public void setContact_id(Long contact_id) {
        this.contact_id = contact_id;
    }

    public void setDt_created(LocalDateTime dt_created) {
        this.dt_created = dt_created;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getApplication_id() {
        return application_id;
    }

    public Long getContact_id() {
        return contact_id;
    }

    public LocalDateTime getDt_created() {
        return dt_created;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "application_id=" + application_id +
                ", contact_id=" + contact_id +
                ", dt_created=" + dt_created +
                ", productName='" + productName + '\'' +
                '}';
    }
}
