package br.com.lucasmancan.medtech.api.domain.dto.paginator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class Paginator {

    //default value
    SortPaginator sort;
    // default values
    private int page;
    // default values
    private int size;

    public Paginator() {
        this.page = 1;
        this.size = 10;
        this.sort = new SortPaginator("id", SortPaginator.Order.desc);
    }

    public Paginator(int page, int size, SortPaginator sort) {
        this.page = page;
        this.size = size;
        this.sort = sort;
    }

    public static Paginator of(int page, int size, SortPaginator sort) {
        return new Paginator(page, size, sort);
    }

    @Override
    public String toString() {
        return "Paginator{" +
                "page=" + page +
                ", size=" + size +
                ", sort=" + sort +
                '}';
    }
}