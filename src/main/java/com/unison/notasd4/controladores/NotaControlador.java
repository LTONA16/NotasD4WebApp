package com.unison.notasd4.controladores;

import com.unison.notasd4.modelos.Nota;
import com.unison.notasd4.repositorios.NotaRepositorio;
import com.unison.notasd4.exepciones.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/notas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NotaControlador {

    @Autowired
    private NotaRepositorio notaRep;

    @RequestMapping("/*")
    public String mostrarNotas(Model modelo){
        List<Nota> notas = listar();
        modelo.addAttribute("notas", notas);
        return "notas";
    }

    @RequestMapping("/nuevaNota/*")
    public String nuevaNota(Model modelo){
        Nota nota = new Nota();
        modelo.addAttribute("nota", nota);
        return "nuevaNota";
    }

    @RequestMapping("/verNota/{id}")
    public String verNota(Model modelo, @PathVariable long id){
        Nota nota = notaRep.findById(id).orElseThrow(NotFoundException::new);
        modelo.addAttribute("nota", nota);
        return "verNota";
    }

    @GetMapping("/listar")
    public List<Nota> listar(){ return notaRep.findAll().stream().toList();}

    @PostMapping("/agregar")
    public String agregar(Nota Nota){
        Nota n = new Nota();
        n.setTitulo(Nota.getTitulo());
        n.setContenido(Nota.getContenido());
        n.setColor(Nota.getColor());
        n.setFechaEditado(LocalDate.now());
        notaRep.save(n);
        return "redirect:/notas/";
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificar(@PathVariable long id, @RequestBody Nota nota){
        Nota n = notaRep.findById(id).orElseThrow(NotFoundException::new);
        n.setTitulo(nota.getTitulo());
        n.setContenido(nota.getContenido());
        n.setColor(nota.getColor());
        n.setFechaEditado(LocalDate.now());
        Nota notaActualizada = notaRep.save(n);
        return ResponseEntity.ok(notaActualizada);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable long id){
        notaRep.deleteById(id);
        return "redirect:/notas/notas/";
    }
}
