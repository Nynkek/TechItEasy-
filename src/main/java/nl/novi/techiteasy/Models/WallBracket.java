package nl.novi.techiteasy.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class WallBracket {

    @Id
    @GeneratedValue
    private Long id;
    private String size;
    private Boolean ajustable;
    private String name;
    private Double price;

    public WallBracket() {
    }

    @ManyToMany
    @JoinTable(
            name = "tvWallSet",
            joinColumns = @JoinColumn(name = "wall_bracket_id"),
            inverseJoinColumns = @JoinColumn(name = "television_id")
    )
    private Set<Television> televisionsWallSet = new HashSet<>();

    public Set<Television> getTelevisionsWallSet() {
        return televisionsWallSet;
    }

    public void setTelevisionsWallSet(Set<Television> televisionsWallSet) {
        this.televisionsWallSet = televisionsWallSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAjustable() {
        return ajustable;
    }

    public void setAjustable(Boolean ajustable) {
        this.ajustable = ajustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
