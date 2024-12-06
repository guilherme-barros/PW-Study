package br.com.etechoracio.study.service;

import br.com.etechoracio.study.entity.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.etechoracio.study.repository.DisciplinaRepository;

import java.util.List;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository repository;

    public List<Disciplina> listar()
    {
        return repository.findAll();
    }

    public Disciplina buscaPorId(Long id)
    {
        var existe = repository.findById(id);
        if (existe.isPresent())
            return existe.get();
        return null;
    }

    public Disciplina cadastrar(Disciplina disciplina)
    {
        return repository.save(disciplina);
    }

    public Disciplina alterar(Disciplina disciplina)
    {
        var existe = buscaPorId(disciplina.getId());
        if (existe != null)
            return repository.save(disciplina);
        else
            System.out.println("Disciplina não encontrada");
            return null;
    }

    public Disciplina excluir(Disciplina disciplina)
    {
        // nao fiz ainda
    }

}
