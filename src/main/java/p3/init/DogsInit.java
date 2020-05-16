package p3.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import p3.jpa.repository.DogsRepository;
import p3.jpa.model.*;

@Component
public class DogsInit implements CommandLineRunner {

	@Autowired
	private DogsRepository dogsRepository;
	
    @Override
    public void run(String... args) throws Exception{

        Long countOfDogs=dogsRepository.count();
        if(countOfDogs==0) {
            Dog d1 = new Dog("White", "Maltese");
            Dog d2 = new Dog("Yellow", "Chihuahua");
            Dog d3 = new Dog("Black", "German Shepherd");
            Dog d4 = new Dog("Brown", "Yorkie");
            Dog d5 = new Dog("Milky", "Kangal");
            dogsRepository.save(d1);
            dogsRepository.save(d2);
            dogsRepository.save(d3);
            dogsRepository.save(d4);
            dogsRepository.save(d5);
        }
    }
}
