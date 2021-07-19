package one.digin.tubainaApi.enums;

import lombok.*;

@Getter
@AllArgsConstructor
public enum TubainaType {

    NORMAL("Normal"),
    MACA("Maçã"),
    GROSELHA("Groselha"),
    JABUTICABA("Jabuticaba"),
    DIET("Diet");

    private final String description;
}
