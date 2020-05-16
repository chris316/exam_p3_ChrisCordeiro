package p3.jdbctemplate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import p3.jpa.model.Dog;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Cat {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    String name;
    String type;
    

    public Cat(String name, String type){
        this.name=name;
        this.type=type;
    }
}
