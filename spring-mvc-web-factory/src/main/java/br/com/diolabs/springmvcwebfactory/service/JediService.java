package br.com.diolabs.springmvcwebfactory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diolabs.springmvcwebfactory.exception.JediException;
import br.com.diolabs.springmvcwebfactory.exception.JediNotFoundException;
import br.com.diolabs.springmvcwebfactory.model.Jedi;
import br.com.diolabs.springmvcwebfactory.repository.JediRepository;

@Service
public class JediService {
    @Autowired
    private JediRepository jediRepository;

    public List<Jedi> findAll() {
        List<Jedi> listaJedi = jediRepository.findAll();
        if (listaJedi.isEmpty()) {
            throw new JediNotFoundException();
        }
        return listaJedi;
    }

    public Jedi save(Jedi jediDto) {
        try {
            return jediRepository.save(jediDto);

        } catch (Exception e) {
            throw new JediException(e.getMessage());
        }
    }

    public Jedi atualizaJedi(Long id, Jedi jediDto) {
        Optional<Jedi> opJedi = jediRepository.findById(id);

        if (opJedi.isPresent()) {
            opJedi.get().setNome(jediDto.getNome());
            opJedi.get().setSobrenome(jediDto.getSobrenome());
        } else {
            throw new JediNotFoundException();
        }
        return jediRepository.save(opJedi.get());
    }

    public Jedi findById(Long id) {

        Optional<Jedi> opJedi = jediRepository.findById(id);

        if (opJedi.isPresent()) {
            return opJedi.get();
        }

        throw new JediNotFoundException();
    }

    public void delete(Long id) {

        Optional<Jedi> opJedi = jediRepository.findById(id);
        try {
            if (opJedi.isPresent()) {
                jediRepository.delete(opJedi.get());
            } else {
                throw new JediNotFoundException();
            }
        } catch (Exception e) {
            throw new JediException(e.getMessage());
        }

    }

}
