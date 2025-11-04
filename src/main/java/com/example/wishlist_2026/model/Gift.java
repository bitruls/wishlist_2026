package com.example.wishlist_2026.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item; //f.eks. "Iphone 17"
    private String description; // f.eks. "Svart 256 gb"
    private double price;

}
