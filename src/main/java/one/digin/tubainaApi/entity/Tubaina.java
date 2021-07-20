package one.digin.tubainaApi.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import lombok.*;
import one.digin.tubainaApi.enums.TubainaType;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Tubaina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private int max;

    @Column(nullable = false)
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TubainaType type;

}
