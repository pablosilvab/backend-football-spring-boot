package io.psilvab.footballbackend.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "match")
public class Match {
    @Id
    private String id;
    private Team teamLocal;
    private int goalsLocal;
    private List<String> scorersLocal;
    private Team teamVisit;
    private int goalsVisit;
    private List<String> scorersVisit;
    private Tournament tournament;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date date;
    private String stadium;

    public Match() {
    }

    public Match(String id, Team teamLocal, int goalsLocal, List<String> scorersLocal, Team teamVisit, int goalsVisit,
            List<String> scorersVisit, Tournament tournament, Date date, String stadium) {
        this.id = id;
        this.teamLocal = teamLocal;
        this.goalsLocal = goalsLocal;
        this.scorersLocal = scorersLocal;
        this.teamVisit = teamVisit;
        this.goalsVisit = goalsVisit;
        this.scorersVisit = scorersVisit;
        this.tournament = tournament;
        this.date = date;
        this.stadium = stadium;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Team getTeamLocal() {
        return this.teamLocal;
    }

    public void setTeamLocal(Team teamLocal) {
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

    public Team getTeamVisit() {
        return this.teamVisit;
    }

    public void setTeamVisit(Team teamVisit) {
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

    public Tournament getTournament() {
        return this.tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStadium() {
        return this.stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public Match id(String id) {
        this.id = id;
        return this;
    }

    public Match teamLocal(Team teamLocal) {
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

    public Match teamVisit(Team teamVisit) {
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

    public Match tournament(Tournament tournament) {
        this.tournament = tournament;
        return this;
    }

    public Match date(Date date) {
        this.date = date;
        return this;
    }

    public Match stadium(String stadium) {
        this.stadium = stadium;
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
        return Objects.equals(id, match.id) && Objects.equals(teamLocal, match.teamLocal)
                && goalsLocal == match.goalsLocal && Objects.equals(scorersLocal, match.scorersLocal)
                && Objects.equals(teamVisit, match.teamVisit) && goalsVisit == match.goalsVisit
                && Objects.equals(scorersVisit, match.scorersVisit) && Objects.equals(tournament, match.tournament)
                && Objects.equals(date, match.date) && Objects.equals(stadium, match.stadium);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamLocal, goalsLocal, scorersLocal, teamVisit, goalsVisit, scorersVisit, tournament,
                date, stadium);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", teamLocal='" + getTeamLocal() + "'" + ", goalsLocal='"
                + getGoalsLocal() + "'" + ", scorersLocal='" + getScorersLocal() + "'" + ", teamVisit='"
                + getTeamVisit() + "'" + ", goalsVisit='" + getGoalsVisit() + "'" + ", scorersVisit='"
                + getScorersVisit() + "'" + ", tournament='" + getTournament() + "'" + ", date='" + getDate() + "'"
                + ", stadium='" + getStadium() + "'" + "}";
    }

}
