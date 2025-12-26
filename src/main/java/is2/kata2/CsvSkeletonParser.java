package is2.kata2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CsvSkeletonParser implements SkeletonParser {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public Skeleton parse(String line) {
        String[] fields = line.split(",");

        if (fields.length < 5) {
            throw new IllegalArgumentException("Línea Inválida: " + line);
        }
        return new  Skeleton(
                fields[0],
                Integer.parseInt(fields[1]),
                Integer.parseInt(fields[2]),
                fields[3],
                LocalDate.parse(fields[4], FORMATTER)
        );
    }
}
