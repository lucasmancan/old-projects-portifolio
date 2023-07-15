package br.com.lucasmancan.medtech.api.infraestructure.security.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ParseUtils {
    public static String parseDate(Date date) {
        var formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }

    public static String parseDate(LocalDate string) {

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return string.format(formatters);
    }
}
