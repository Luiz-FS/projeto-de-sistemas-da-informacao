package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.Anuncio;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnuncioServiceImpl implements AnuncioService {

    private AnuncioRepository anuncioRepository;

    @Autowired
    public AnuncioServiceImpl(AnuncioRepository anuncioRepository) {
        this.anuncioRepository = anuncioRepository;
    }

    public AnuncioRepository getAnuncioRepository(){
        return this.anuncioRepository;
    }

    @Override
    public Anuncio create(Anuncio anuncio) {
        return anuncioRepository.save(anuncio);
    }

    @Override
    public Optional<Anuncio> getById(Long id) {
        return Optional.ofNullable(anuncioRepository.findOne(id));
    }

    @Override
    public Collection<Anuncio> get(String tipo) {

        return anuncioRepository.findByTipo(tipo);

        /*
        return anuncioRepository.findAll().stream()
                .filter(anuncio -> anuncio.getTipo().equals(tipo))
                .collect(Collectors.toCollection(ArrayList::new));*/
    }

    @Override
    public Collection<Anuncio> getAll() {
        return anuncioRepository.findAll();
    }

    @Override
    public boolean update(Anuncio anuncio) {
        if (anuncioRepository.exists(anuncio.get_id())) {
            anuncioRepository.save(anuncio);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (anuncioRepository.exists(id)) {
            anuncioRepository.delete(id);
            return true;
        }

        return false;
    }
}
