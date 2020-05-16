package p3.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import p3.jpa.model.Dog;

public interface DogsRepository extends JpaRepository<Dog,Long>{
    public Optional<List<Dog>>findByType(String type);
}
