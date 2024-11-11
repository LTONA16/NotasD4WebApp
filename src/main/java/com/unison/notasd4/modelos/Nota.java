package com.unison.notasd4.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notas")
public class Nota implements Serializable {
    @Serial
    private static final long serialVersionUID = -1804125755088228191L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    @NotBlank(message = "titulo no valido")
    @NotNull(message = "El titulo de la nota es requerido")
    private String titulo;

    @Column(name = "contenido")
    @NotBlank(message = "El contenido de la nota no es valido")
    @NotNull(message = "El contenido de la nota es requerido")
    private String contenido;

    @Column(name = "fechaEditado")
    private LocalDate fechaEditado;

    @Column(name = "color")
    @NotBlank(message = "El color de la nota no es valido")
    @NotNull(message = "El color de la nota es requerido")
    private String color;
}
