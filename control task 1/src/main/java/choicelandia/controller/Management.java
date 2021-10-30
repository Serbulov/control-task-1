package choicelandia.controller;

import choicelandia.model.elections.Citizen;
import choicelandia.model.parties.Party;
import choicelandia.model.stations.*;
import choicelandia.view.View;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Management {
    private final View view;
    private final Scanner scanner;

    private final List<OrdinaryPolSt> ordinaryPolStList;
    private final List<QuarantinePolSt> quarantinePolStList;
    private final List<ClosedPolSt> closedPolStList;

    private final List<Citizen> listCitizen;
    private final List<Citizen> voterRegister;

    private final List<Party> listParties;

    private final Map<Citizen, Double> candidates;

    public Management() {
        this.view = new View();
        this.scanner = new Scanner(System.in);

        ordinaryPolStList = new ArrayList<>();
        quarantinePolStList = new ArrayList<>();
        closedPolStList = new ArrayList<>();

        listCitizen = new ArrayList<>();
        voterRegister = new ArrayList<>();

        listParties = new ArrayList<>();

        candidates = new LinkedHashMap<>();
    }

    /**
     * ---------------------------------------------------- <br/>
     * 1. Добавление избирательного участка <br/>
     * ---------------------------------------------------- <br/>
     **/
    public void addPollingStation() {
        view.printChooseTypeOfStation();
        int c = scanner.nextInt();
        scanner.nextLine();
        String type;
        switch (c) {
            case 1:
                type = "обычный";
                break;
            case 2:
                type = "для людей на карантине";
                break;
            case 3:
                type = "для армии и спецслужб";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
        view.printEnterAddress();
        String address = scanner.nextLine();
        PollingStation station = PollingStationFactory.createPolSt(type, address);
        switch (type) {
            case "обычный":
                ordinaryPolStList.add((OrdinaryPolSt) station);
                break;
            case "для людей на карантине":
                quarantinePolStList.add((QuarantinePolSt) station);
                break;
            case "для армии и спецслужб":
                closedPolStList.add((ClosedPolSt) station);
                break;
        }
    }

    /**
     * ---------------------------------------------------- <br/>
     * 2. Добавление гражданина <br/>
     * ---------------------------------------------------- <br/>
     **/
    public void addCitizen() {
        /*
            Процесс создания нового гражданина
         */
        view.printNewCitizen();
        view.printName();
        String name = scanner.nextLine();
        view.printPassport();
        String passport = scanner.nextLine();
        view.printITN();
        long itn = scanner.nextLong();
        scanner.nextLine();
        if (itn <= 999999999L || itn > 9999999999L) throw new IllegalArgumentException("Illegal set of arguments");
        view.printFullYears();
        int fullYears = scanner.nextInt();
        scanner.nextLine();
        Citizen citizen = new Citizen(name, passport, itn, fullYears);
        if (citizen.getFullYears() > 18) {
            listCitizen.add(citizen);
            voterRegister.add(citizen);
        } else listCitizen.add(citizen);
        /*
            Процесс указания второстепенных значений
         */
        view.printDetermineStation();
        view.printIntelligenceOfficer();
        int c = scanner.nextInt();
        scanner.nextLine();
        citizen.setSpecialServicesWorker(choice(c));
        view.printInQuarantine();
        c = scanner.nextInt();
        citizen.setInQuarantine(choice(c));
        view.printChoiceStation();
        if (citizen.isInQuarantine()) {
            quarantinePolStList();
        } else if (citizen.isSpecialServicesWorker()) {
            closedPolStList();
        } else ordinaryPolStList();
        citizen.setPollingStationNumber(scanner.nextInt());
        scanner.nextLine();
    }

    /**
     * ---------------------------------------------------- <br/>
     * 3. Добавление партии <br/>
     * ---------------------------------------------------- <br/>
     **/
    public void addParty() {
        view.printAddParty();
        view.printName();
        String name = scanner.nextLine();
        view.printFraction();
        view.printFactionList();
        String fraction;
        int c = scanner.nextInt();
        scanner.nextLine();
        switch (c) {
            case 1:
                fraction = "Правая";
            case 2:
                fraction = "Левая";
            case 3:
                fraction = "Центральная";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
        LocalDate partyFoundationDate = LocalDate.now();
        Party party = new Party(name, fraction, partyFoundationDate);
        listParties.add(party);
    }

    /**
     * ---------------------------------------------------- <br/>
     * 4. Указать гражданину принадлежность к партии <br/>
     * ---------------------------------------------------- <br/>
     **/
    public void addCitizenToParty() {
        view.printEnterITNCitizen();
        view.printITN();
        long itn = scanner.nextLong();

        view.printAllParty();
        listParties.forEach(System.out::println);
        view.printEnterPartyName();
        String partyName = scanner.nextLine();
        view.printEnterRating();
        double rating = scanner.nextDouble();

        for (Citizen c : listCitizen) {
            if (c.getItn() == itn) {
                candidates.put(c, rating);
                // Добавляем гражданина в мапу, присваиваем ему рейтинг
                // Мы проходим по списку ВСЕХ партий, ищем нужную нам партию по названию
                // И в список кандидатов этой конкретной партии добавляем мапу с гражданином и рейтингом
            }
        }
    }

    /**
     * ---------------------------------------------------- <br/>
     * 5. Показать избирательные участки <br/>
     * ---------------------------------------------------- <br/>
     **/
    public void showPollingStations() {
        view.printSelectionOfDisplayOfStations();
        int m = scanner.nextInt();
        switch (m) {
            case 1:
                allPolSt();
                break;
            case 2:
                ordinaryPolSt();
                break;
            case 3:
                quarantinePolSt();
                break;
            case 4:
                closedPolSt();
                break;
        }
    }

    private void allPolSt() {
        allPolStList();
        voters();
    }

    private void ordinaryPolSt() {
        ordinaryPolStList();
        voters();
    }

    private void quarantinePolSt() {
        quarantinePolStList();
        voters();
    }

    private void closedPolSt() {
        closedPolStList();
        voters();
    }

    //------------------------------------------------------------------------------------------------------------------
    public void voters() {
        view.showVoters();
        int c = scanner.nextInt();
        switch (c) {
            case 1:
                showAllVoters();
                break;
            case 2:
                votersForConcreteStation();
                break;
            case 3:
                break;
        }
    }

    private void showAllVoters() {
        view.printAllVotersList();
        voterRegister.forEach(System.out::println);
        addAndRemoveVoter();
    }

    private void votersForConcreteStation() {
        view.printEnterUniqueStationNumber();
        int k = scanner.nextInt();
        System.out.println(voterRegister.stream()
                .filter(v -> v.getPollingStationNumber() == k)
                .collect(Collectors.toList()));
        addAndRemoveVoter();
    }

    //------------------------------------------------------------------------------------------------------------------
    private void addAndRemoveVoter() {
        view.printMenuAddRemoveVoter();
        int c = scanner.nextInt();
        switch (c) {
            case 1:
                addVoter();
                break;
            case 2:
                removeVoter();
                break;
            case 3:
                break;
        }
    }

    private void addVoter() {
        view.printEnterITNForAdding();
        long itn = scanner.nextLong();
        view.printEnterRegistrationArea();
        int uniqueNumber = scanner.nextInt();

        for (Citizen v : listCitizen)
            if (v.getItn() == itn) {
                v.setPollingStationNumber(uniqueNumber);
                voterRegister.add(v);
            }
    }

    private void removeVoter() {
        view.printEnterITNForRemove();
        long itn = scanner.nextLong();
        voterRegister.removeIf(c -> c.getItn() == itn);
    }

    /**
     * ---------------------------------------------------- <br/>
     * 6. Показать всех граждан <br/>
     * ---------------------------------------------------- <br/>
     **/
    public void showAllCitizens() {
        view.printAllCitizen();
        listCitizen.forEach(System.out::println);
    }

    /**
     * ---------------------------------------------------- <br/>
     * 7. Показать все партии <br/>
     * ---------------------------------------------------- <br/>
     **/
    public void showAllParty() {
        view.printAllParty();
        listParties.forEach(System.out::println);
        view.workWithParties();
        int c = scanner.nextInt();
        switch (c) {
            case 1:
        }
    }

    /**
     * ---------------------------------------------------- <br/>
     * 8. Провести выборы <br/>
     * ---------------------------------------------------- <br/>
     **/
    public void conductElections() {
        view.printPollOfVoters();
        for (Citizen citizen : voterRegister) {
            String cit = citizen.toString();
            view.appeal(cit);
            int c = scanner.nextInt();
            switch (c) {
                case 1:
                    partySelection();
                    break;
                case 2: break;
            }

        }
    }

    private void partySelection() {
        view.printPartySelection();
        for (int i = 0; i < listParties.size(); i++) {
            int number = i + 1;
            String p = listParties.get(i).toString();
            view.printNumbering(number, p);
        }
    }

    /**
     * ---------------------------------------------------- <br/>
     * 9. Показать результаты выборов <br/>
     * ---------------------------------------------------- <br/>
     **/
    public void showElectionResults() {
        view.printListAllElections();
        // Список всех выборов
        // Указание, результаты каких конкретно выборов нужно отобразить
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * Метод, определяющий выбор ДА/НЕТ
     *
     * @param c - Вводимое число с клавиатуры (1 = ДА, 2 = НЕТ)
     * @return - ДА = true, НЕТ = false
     */
    private boolean choice(int c) {
        boolean choice;
        switch (c) {
            case 1:
                choice = true;
                break;
            case 2:
                choice = false;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
        return choice;
    }

    /**
     * 4 метода, выводящие на экран списки избирательных участков
     */
    public void allPolStList() {
        ordinaryPolStList();
        quarantinePolStList();
        closedPolStList();
    }

    public void ordinaryPolStList() {
        view.printOrdinaryPolStList();
        ordinaryPolStList.forEach(System.out::println);
    }

    public void quarantinePolStList() {
        view.printQuarantinePolStList();
        quarantinePolStList.forEach(System.out::println);
    }

    public void closedPolStList() {
        view.printClosedPolStList();
        closedPolStList.forEach(System.out::println);
    }
}