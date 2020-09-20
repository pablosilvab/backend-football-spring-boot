package io.psilvab.footballbackend.model;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="match")
public class Match {
    @Id
    private String id;
    private String teamLocal;
    private int goalsLocal;
    private List<String> scorersLocal;
    private String teamVisit;
    private int goalsVisit;
    private List<String> scorersVisit;
    private String tournament;


    public Match() {
    }

    public Match(String id, String teamLocal, int goalsLocal, List<String> scorersLocal, String teamVisit, int goalsVisit, List<String> scorersVisit, String tournament) {
        this.id = id;
        this.teamLocal = teamLocal;
        this.goalsLocal = goalsLocal;
        this.scorersLocal = scorersLocal;
        this.teamVisit = teamVisit;
        this.goalsVisit = goalsVisit;
        this.scorersVisit = scorersVisit;
        this.tournament = tournament;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeamLocal() {
        return this.teamLocal;
    }

    public void setTeamLocal(String teamLocal) {
        this.teamLocal = teamLocal;
    }

    public int getGoalsLocal() {
        return this.goalsLocal;
    }

    public void setGoalsLocal(int goalsLocal) {
        this.goalsLocal = goalsLocal;
    }

    public List<String> getScorersLocal() {
        return this.scorersLocal;
    }

    public void setScorersLocal(List<String> scorersLocal) {
        this.scorersLocal = scorersLocal;
    }

    public String getTeamVisit() {
        return this.teamVisit;
    }

    public void setTeamVisit(String teamVisit) {
        this.teamVisit = teamVisit;
    }

    public int getGoalsVisit() {
        return this.goalsVisit;
    }

    public void setGoalsVisit(int goalsVisit) {
        this.goalsVisit = goalsVisit;
    }

    public List<String> getScorersVisit() {
        return this.scorersVisit;
    }

    public void setScorersVisit(List<String> scorersVisit) {
        this.scorersVisit = scorersVisit;
    }

    public String getTournament() {
        return this.tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public Match id(String id) {
        this.id = id;
        return this;
    }

    public Match teamLocal(String teamLocal) {
        this.teamLocal = teamLocal;
        return this;
    }

    public Match goalsLocal(int goalsLocal) {
        this.goalsLocal = goalsLocal;
        return this;
    }

    public Match scorersLocal(List<String> scorersLocal) {
        this.scorersLocal = scorersLocal;
        return this;
    }

    public Match teamVisit(String teamVisit) {
        this.teamVisit = teamVisit;
        return this;
    }

    public Match goalsVisit(int goalsVisit) {
        this.goalsVisit = goalsVisit;
        return this;
    }

    public Match scorersVisit(List<String> scorersVisit) {
        this.scorersVisit = scorersVisit;
        return this;
    }

    public Match tournament(String tournament) {
        this.tournament = tournament;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Match)) {
            return false;
        }
        Match match = (Match) o;
        return Objects.equals(id, match.id) && Objects.equals(teamLocal, match.teamLocal) && goalsLocal == match.goalsLocal && Objects.equals(scorersLocal, match.scorersLocal) && Objects.equals(teamVisit, match.teamVisit) && goalsVisit == match.goalsVisit && Objects.equals(scorersVisit, match.scorersVisit) && Objects.equals(tournament, match.tournament);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamLocal, goalsLocal, scorersLocal, teamVisit, goalsVisit, scorersVisit, tournament);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", teamLocal='" + getTeamLocal() + "'" +
            ", goalsLocal='" + getGoalsLocal() + "'" +
            ", scorersLocal='" + getScorersLocal() + "'" +
            ", teamVisit='" + getTeamVisit() + "'" +
            ", goalsVisit='" + getGoalsVisit() + "'" +
            ", scorersVisit='" + getScorersVisit() + "'" +
            ", tournament='" + getTournament() + "'" +
            "}";
    }
    
   

}
