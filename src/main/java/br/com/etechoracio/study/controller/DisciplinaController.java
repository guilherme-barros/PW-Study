package br.com.etechoracio.study.controller;

import br.com.etechoracio.study.entity.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.etechoracio.study.service.DisciplinaService;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaService service;

    @GetMapping
    public List<Disciplina> listar()
    {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Disciplina buscarPorId(@PathVariable("id") Long id)
    {
        return service.buscaPorId(id);
    }

    @PostMapping
    public Disciplina cadastrar(@RequestBody Disciplina disciplina)
    {
        return service.cadastrar(disciplina);
    }

    public Disciplina alterar(@RequestBody Disciplina disciplina, @PathVariable("id") Long id)
    {
        if (id == disciplina.getId())
            return service.alterar(disciplina);
        else
            return null;
    }

    @DeleteMapping("{/id}")
    public void excluir(@PathVariable("id") Long id)
    {
        return service.excluir(id);
    }

}