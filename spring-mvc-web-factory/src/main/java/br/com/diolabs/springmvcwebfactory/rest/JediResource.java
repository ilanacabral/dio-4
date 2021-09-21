package br.com.diolabs.springmvcwebfactory.rest;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.diolabs.springmvcwebfactory.model.Jedi;
import br.com.diolabs.springmvcwebfactory.service.JediService;

@RestController
public class JediResource {

    @Autowired
    private JediService jediService;

    @GetMapping("/jedi")
    @ResponseStatus(HttpStatus.OK)
    public List<Jedi> getAllJedi() {
        return jediService.findAll();      
    }

    @PostMapping("/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi addJedi(@Valid @RequestBody Jedi jediDto) {
        return  jediService.save(jediDto);      
    }

    @GetMapping("/jedi/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Jedi findById(@PathVariable("id") Long id) {
        return jediService.findById(id);
    }

    @PutMapping("/jedi/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Jedi atualizaById(@PathVariable("id") Long id, @Valid @RequestBody Jedi jediDto) {
        return jediService.atualizaJedi(id, jediDto);
    }

    @DeleteMapping("/jedi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        jediService.delete(id);       
    }

}