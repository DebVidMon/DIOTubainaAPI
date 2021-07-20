package one.digin.tubainaApi.dto;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;
import one.digin.tubainaApi.enums.TubainaType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TubainaDTO {

    private Long id;

    @NotNull
    @Size(min = 1, max = 200)
    private String name;

    @NotNull
    @Size(min = 1, max = 200)
    private String brand;

    @NotNull
    @Max(500)
    private Integer max;

    @NotNull
    @Max(100)
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TubainaType type;
}
