package io.psilvab.footballbackend.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="team")
public class Team {
    @Id
    private String id;
    private String name;
    private Tournament tournament;

    public Team() {
    }

    public Team(String id, String name, Tournament tournament) {
        this.id = id;
        this.name = name;
        this.tournament = tournament;
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

    public Tournament getTournament() {
        return this.tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Team id(String id) {
        this.id = id;
        return this;
    }

    public Team name(String name) {
        this.name = name;
        return this;
    }

    public Team tournament(Tournament tournament) {
        this.tournament = tournament;
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
        return Objects.equals(id, team.id) && Objects.equals(name, team.name) && Objects.equals(tournament, team.tournament);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tournament);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", tournament='" + getTournament() + "'" +
            "}";
    }
 

}
