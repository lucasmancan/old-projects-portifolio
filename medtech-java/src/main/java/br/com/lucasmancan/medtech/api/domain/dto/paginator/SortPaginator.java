package br.com.lucasmancan.medtech.api.domain.dto.paginator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class SortPaginator {
    private String propertyName;
    private Order order;

    public static SortPaginator of(String propertyName, Order order) {
        return new SortPaginator(propertyName, order);
    }

    @Override
    public String toString() {
        return "SortPaginator{" +
                "propertyName='" + propertyName + '\'' +
                ", order=" + order +
                '}';
    }

    public enum Order {
        asc, desc
    }
}
