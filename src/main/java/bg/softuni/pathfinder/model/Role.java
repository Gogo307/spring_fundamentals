package bg.softuni.pathfinder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automatic ++
    private long id;

    @Enumerated(EnumType.STRING) // gets the "string value", not the id number (ordinals does that)
    private UserRoles name;

    public Role() {}

    public long getId() {
        return id;
    }

    public UserRoles getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(UserRoles name) {
        this.name = name;
    }
}
