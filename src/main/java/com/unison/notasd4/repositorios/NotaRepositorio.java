package com.unison.notasd4.repositorios;

import com.unison.notasd4.modelos.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepositorio extends JpaRepository<Nota, Long> {
}