package choicelandia.model.parties;

import choicelandia.model.elections.Citizen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Party {
    private String name;
    private String fraction;
    private LocalDate partyFoundationDate;

    private Map<Citizen, Double> candidates;
    private List<Map> candidateList;

    public Party(String name, String fraction, LocalDate partyFoundationDate) {
        this.name = name;
        this.fraction = fraction;
        this.partyFoundationDate = partyFoundationDate;
        this.candidates = new LinkedHashMap<>();
        this.candidateList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    public LocalDate getPartyFoundationDate() {
        return partyFoundationDate;
    }

    public void setPartyFoundationDate(LocalDate partyFoundationDate) {
        this.partyFoundationDate = partyFoundationDate;
    }

    @Override
    public String toString() {
        return "Party{" +
                "name='" + name + '\'' +
                ", fraction='" + fraction + '\'' +
                ", partyFoundationDate=" + partyFoundationDate +
                '}';
    }
}
