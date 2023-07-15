package br.com.lucasmancan.medtech.api.domain.dto;

import lombok.Data;

@Data
public class SearchText {
    private final String search;

    public SearchText(String search) {
        if (search != null) {
            this.search = search.trim().toLowerCase();
        } else {
            this.search = null;
        }
    }

    @Override
    public String toString() {
        return search != null ? search.trim().toLowerCase() : null;
    }

    public boolean isEmpty() {
        return search == null || search.isEmpty() || search.isBlank();
    }
}
