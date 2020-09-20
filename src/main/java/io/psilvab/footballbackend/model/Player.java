package io.psilvab.footballbackend.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="player")
public class Player {
    @Id
    private String id;
    private String name;
    private String team;
    private int goals;
    

    public Player() {
    }

    public Player(String id, String name, String team, int goals) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.goals = goals;
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

    public String getTeam() {
        return this.team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGoals() {
        return this.goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public Player id(String id) {
        this.id = id;
        return this;
    }

    public Player name(String name) {
        this.name = name;
        return this;
    }

    public Player team(String team) {
        this.team = team;
        return this;
    }

    public Player goals(int goals) {
        this.goals = goals;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Player)) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(id, player.id) && Objects.equals(name, player.name) && Objects.equals(team, player.team) && goals == player.goals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, team, goals);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", team='" + getTeam() + "'" +
            ", goals='" + getGoals() + "'" +
            "}";
    }



}
