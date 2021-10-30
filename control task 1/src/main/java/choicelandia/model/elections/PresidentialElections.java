package choicelandia.model.elections;

import choicelandia.model.parties.Party;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class PresidentialElections {
    private String month;
    private int year;
    private LocalDate electionDate;

    private Map<Party, Integer> votes;

    public PresidentialElections(String month, int year) {
        this.month = month;
        this.year = year;
        votes = new LinkedHashMap<>();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Presidential elections: " + month + " " + year;
    }
}
