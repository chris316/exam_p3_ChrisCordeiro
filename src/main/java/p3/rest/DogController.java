package p3.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import p3.jpa.model.Dog;
import p3.jpa.repository.DogsRepository;


@RestController
@RequestMapping("/rest/v1/dogs")
public class DogController {

    @Autowired
    private DogsRepository dogRepository;

    @GetMapping("/echoMessage")
    public String echoMessage(@RequestParam(name="msg", defaultValue="Chris")String message){
        return "echoMessage echoes: "+message;
    }

    @GetMapping("/dogs")
    public Page<Dog> findAll(@RequestParam(name="page",defaultValue = "0")int page, @RequestParam(name="size",defaultValue = "2")int size){
        Page<Dog> dogs=dogRepository.findAll(PageRequest.of(page, size));
    	return dogRepository.findAll(PageRequest.of(page,size));
    }


    @GetMapping("/dogs/all")
    public List<Dog> findAll(){
        return dogRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Dog> findById(@PathVariable(name="id")Long id){
        return dogRepository.findById(id);
    }

    @GetMapping("/dogs/byType/{type}")
    public Optional<List<Dog>> findByType(@PathVariable(name="type")String type){
        return dogRepository.findByType(type);
    }
}
