package airlines.pojos;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@AllArgsConstructor
@EqualsAndHashCode
public class Employee {

    private int id;
    private String name;
    private String gender;

//    @Override
//    public boolean equals(Object obj){
//        Employee e = (Employee)obj;
//        return this.id == e.id && this.name == e.name;
//    }
//
//
//    public int hashCode(){
//        return Objects.hash(id, name);
//    }
}
