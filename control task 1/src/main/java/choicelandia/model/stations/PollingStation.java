package choicelandia.model.stations;

import choicelandia.model.parties.Party;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ---------------------------------------------------- <br/>
 * Родительский класс для всех избирательных участков <br/>
 * ---------------------------------------------------- <br/>
 **/
public abstract class PollingStation {
    private String type;
    private String address;
    private final Map<Party, Integer> votes;
    private final int uniqueNumber;
    private static int ids = 1;

    public PollingStation(String type, String address) {
        this.type = type;
        uniqueNumber = ids++;
        this.address = address;
        votes = new LinkedHashMap<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public int getUniqueNumber() {
        return uniqueNumber;
    }

    /**
     * Добавление голосов за конкретную партию
     * @param party - Конкретная партия
     */
    public void acceptVote(Party party) {
        Integer v = votes.get(party);
        if (v == null) v = 0;
        votes.put(party, v+1);
    }

    /**
     * Подсчет голосов за каждую партию
     * @param party - Конкретная партия
     * @return v - Количество голосов за указанную партию
     */
    public int votesForParty(Party party) {
        Integer v = votes.get(party);
        if (v == null) v = 0;
        return v;
    }

    @Override
    public String toString() {
        return "Тип избирательного участка: " + type +
                "; адрес: " + address +
                "; уникальный номер: " + uniqueNumber;
    }
}

// accept(Citizen) {}
// boolean canAccept(Citizen) {}
// Когда человек голосует, он отдает свой голос за партию, и этот метод будет один общий в этом кассе
// и уже у него внутри он будет записывать тому голос, кому нужно