package choicelandia.controller;

import choicelandia.view.View;

public class Controller {
    private final View view;
    private final Management management;

    public Controller() {
        this.view = new View();
        this.management = new Management();
    }

    /**
     * ---------------------------------------------------- <br/>
     * Взаимодействие с пользователем <br/>
     * ---------------------------------------------------- <br/>
     **/
    public void userInteraction() {
        int m;
        while ((m = view.menu()) != 10) {
            try {
                switch (m) {
                    case 1:
                        management.addPollingStation();
                        break;
                    case 2:
                        management.addCitizen();
                        break;
                    case 3:
                        management.addParty();
                        break;
                    case 4:
                        management.addCitizenToParty();
                        break;
                    case 5:
                        management.showPollingStations();
                        break;
                    case 6:
                        management.showAllCitizens();
                        break;
                    case 7:
                        management.showAllParty();
                        break;
                    case 8:
                        management.conductElections();
                        break;
                    case 9:
                        management.showElectionResults();
                        break;
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
