package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CsvSkeletonParser implements SkeletonParser {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    @Override
    public Skeleton parse(String line) {
        String[] parts = line.split(",");

        if (parts.length < 5) {
            throw new IllegalArgumentException("Línea inválida: " + line);
        }

        return new Skeleton(
                parts[0],
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2]),
                parts[3],
                LocalDate.parse(parts[4], FORMATTER)
        );
    }
}
