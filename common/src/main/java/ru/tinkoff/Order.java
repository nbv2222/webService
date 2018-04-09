package ru.tinkoff;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Order {
    private Long applicationId;
    private Long contactId;
    private LocalDateTime dtCreated;
    private String productName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!applicationId.equals(order.applicationId)) return false;
        return contactId.equals(order.contactId);
    }

    @Override
    public int hashCode() {
        int result = applicationId.hashCode();
        result = 31 * result + contactId.hashCode();
        return result;
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
