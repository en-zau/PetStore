package org.PetStore.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.PetStore.entities.enumere.ProdType;

import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    private String code;
    private String label;
    @Enumerated(EnumType.STRING)
    private ProdType prodType;
    private Double price;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "product_petstore",
            joinColumns = { @JoinColumn(name = "product_id") },
            inverseJoinColumns = { @JoinColumn(name = "id") }
    )
    Set<PetStore> petStores;

    public Product(String code, String label, ProdType prodType, Double price) {
        this.code = code;
        this.label = label;
        this.prodType = prodType;
        this.price = price;
    }
}
