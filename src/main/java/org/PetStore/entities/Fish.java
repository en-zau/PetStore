package org.PetStore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.NoArgsConstructor;
import org.PetStore.entities.enumere.FishLivEnv;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Fish extends Animal{
    @Enumerated(EnumType.STRING)
    private FishLivEnv livEnv;

    public Fish(LocalDate birth, String color, PetStore petStore, FishLivEnv livEnv) {
        super(birth, color, petStore);
        this.livEnv = livEnv;
    }
}

