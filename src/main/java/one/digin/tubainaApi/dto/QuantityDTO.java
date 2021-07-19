package one.digin.tubainaApi.dto;

import javax.validation.constraints.*;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuantityDTO {

    @NotNull
    @Max(100)
    private Integer quantity;
}
