package nl.novi.techiteasy.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CI_Module {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    private Double price;

    public CI_Module() {
    }

    public CI_Module(Long id,
                     String name,
                     String type,
                     Double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

//    @ManyToMany
//    @JoinTable(
//            name = "television_whit_CI",
//            joinColumns = @JoinColumn(name = "television_id"),
//            inverseJoinColumns = @JoinColumn(name = "ci_module_id")
//    )

//    private Set<Television> televisionCISet = new HashSet<>();

//    public Set<Television> getTelevision() {
//        return televisionCISet;
//    }


//    public void setTelevision(Set<Television> television) {
//        this.televisionCISet = television;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

//    public void televisionSet(Television television) {
//        televisionCISet.add(television);
//    }
}
