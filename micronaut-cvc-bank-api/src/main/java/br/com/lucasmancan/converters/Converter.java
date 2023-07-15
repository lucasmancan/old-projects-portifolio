package br.com.lucasmancan.converters;

public interface Converter<T, Z> {
    T dtoToEntity(Z z);

    Z entityToDTO(T t);
}
