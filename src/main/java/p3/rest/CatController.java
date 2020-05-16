package p3.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import p3.jdbctemplate.dao.CatDAO;
import p3.jdbctemplate.model.Cat;
import p3.jpa.model.Dog;


@RestController
@RequestMapping("/rest/v1/cats")
public class CatController {
	
	@Autowired
	@Qualifier("catDAOimpl")
	private CatDAO catDAO;
	
	
    @GetMapping("/echoMessage")
    public String echoMessage(@RequestParam(name="msg", defaultValue="Chris")String message){
        return "echoMessage echoes: "+message;
    }
    
    @GetMapping({"","/all"})
    public List<Cat> findAll(){
        return catDAO.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Cat> findById(@PathVariable(name="id")Long id){
    	return catDAO.findById(id);
    }
    
    @GetMapping("/byType/{type}")
    public Optional<List<Cat>> findByType(@PathVariable(name="type")String type){
    	return catDAO.findByType(type);
    }
    
    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(name="id")Long id) {
    	catDAO.deleteById(id);
    	return true;
    }
    
    

}
