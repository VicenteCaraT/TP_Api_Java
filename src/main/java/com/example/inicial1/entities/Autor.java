package com.example.inicial1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "autor")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Autor extends Base {
    private String nombre;
    private String apellido;
    private String biografía;
}
