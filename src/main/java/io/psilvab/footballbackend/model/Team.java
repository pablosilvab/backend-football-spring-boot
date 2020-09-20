package io.psilvab.footballbackend.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="team")
public class Team {
    @Id
    private String id;
    private String name;


    public Team() {
    }

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team id(String id) {
        this.id = id;
        return this;
    }

    public Team name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Team)) {
            return false;
        }
        Team team = (Team) o;
        return Objects.equals(id, team.id) && Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

}
