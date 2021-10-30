package choicelandia.model.elections;

public class Citizen {
    private String name;
    private String passport;
    private long itn;
    private int fullYears;

    private boolean specialServicesWorker;
    private boolean inQuarantine;
    private int pollingStationNumber;

    public Citizen(String name, String passport, long itn, int fullYears) {
        this.name = name;
        this.passport = passport;
        this.itn = itn;
        this.fullYears = fullYears;

        this.specialServicesWorker = false;
        this.inQuarantine = false;
        this.pollingStationNumber = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public long getItn() {
        return itn;
    }

    public void setItn(long itn) {
        this.itn = itn;
    }

    public int getFullYears() {
        return fullYears;
    }

    public void setFullYears(int fullYears) {
        this.fullYears = fullYears;
    }

    public int getPollingStationNumber() {
        return pollingStationNumber;
    }

    public void setPollingStationNumber(int pollingStationNumber) {
        this.pollingStationNumber = pollingStationNumber;
    }

    public boolean isSpecialServicesWorker() {
        return specialServicesWorker;
    }

    public void setSpecialServicesWorker(boolean specialServicesWorker) {
        this.specialServicesWorker = specialServicesWorker;
    }

    public boolean isInQuarantine() {
        return inQuarantine;
    }

    public void setInQuarantine(boolean inQuarantine) {
        this.inQuarantine = inQuarantine;
    }

    @Override
    public String toString() {
        return "Имя: " + name +
                ", паспорт: " + passport +
                ", ИНН: " + itn +
                ", полных лет: " + fullYears +
                ", номер избирательного участка: " + pollingStationNumber +
                ", работник спецслужб: " + specialServicesWorker +
                ", на карантине: " + inQuarantine + '.';
    }
}
