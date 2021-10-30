package choicelandia.view;

import java.util.Scanner;

/**
 * ---------------------------------------------------- <br/>
 * View - класс, который содержит в себе всё <br/>
 * выводимое на экран для взаимодействия с пользователем <br/>
 * ---------------------------------------------------- <br/>
 **/
public class View {
    Scanner scanner = new Scanner(System.in);

    //----------------------------------------------Главное меню--------------------------------------------------------
    public int menu() {
        String menu = "\n1. Добавить избирательный участок\n" +
                "2. Добавить гражданина\n" +
                "3. Добавить партию\n" +
                "4. Указать, что гражданин является кандидатом от определенной партии\n" +
                "5. Показать избирательные участки\n" +
                "6. Показать всех граждан\n" +
                "7. Показать все партии\n" +
                "8. Провести выборы\n" +
                "9. Показать результаты выборов\n" +
                "10. Выход из программы\n";
        System.out.println(menu);
        return scanner.nextInt();
    }
    //------------------------------------------------------------------------------------------------------------------

    public void printChooseTypeOfStation() {
        String menuTypeOfStation = "\n========= Пожалуйста, выберите один из вариантов =========\n" +
                "1. Обычный избирательный участок;\n" +
                "2. Участок для граждан, находящихся на карантине;\n" +
                "3. Закрытый участок для армии и спецслужб;";
        System.out.println(menuTypeOfStation);
    }

    public void printEnterAddress() {
        System.out.print("Адрес: ");
    }

    public void printSelectionOfDisplayOfStations() {
        String menuSelectionOfDisplayOfStations = "\n========= Пожалуйста, выберите один из вариантов =========\n" +
                "1. Показать ВСЕ избирательные участки;\n" +
                "2. Показать список обычных избирательных участков;\n" +
                "3. Показать список участков для граждан, находящихся на карантине;\n" +
                "4. Показать список закрытых участков для армии и спецслужб;";
        System.out.println(menuSelectionOfDisplayOfStations);
    }

    public void printOrdinaryPolStList() {
        System.out.println("========== Обычные избирательные участки ==========");
    }

    public void printQuarantinePolStList() {
        System.out.println("========== Участки для граждан, находящихся на карантине ==========");
    }

    public void printClosedPolStList() {
        System.out.println("========== Закрытые участки для армии и спецслужб ==========");
    }

    public void printNewCitizen() {
        System.out.println("======= Новый гражданин Выборландии =======");
    }

    public void printName() {
        System.out.print("Имя: ");
    }

    public void printPassport() {
        System.out.print("Паспорт: ");
    }

    public void printITN() {
        System.out.print("ИНН: ");
    }

    public void printFullYears() {
        System.out.print("Полных лет: ");
    }

    public void printDetermineStation() {
        System.out.println("-----Определяем избирательный участок-----");
    }

    public void menuYesNo() {
        String menuYesNo = "1. Да\n" +
                "2. Нет";
        System.out.println(menuYesNo);
    }

    public void printIntelligenceOfficer() {
        System.out.println("Является ли военным, либо сотрудником спецслужб?");
        menuYesNo();
    }

    public void printInQuarantine() {
        System.out.println("Находится ли в карантине?");
        menuYesNo();
    }

    public void printChoiceStation() {
        String printChoiceStation = "-----Выберите из списка избирательный участок-----\n" +
                "           (введите уникальный номер)";
        System.out.println(printChoiceStation);
    }

    public void printAllCitizen() {
        System.out.println("========== Все граждане Выборландии ==========");
    }

    public void printAddParty() {
        System.out.println("========== Добавление новой партии ==========");
    }

    public void printFraction() {
        System.out.println("------- К какой фракции она принадлежит? -------");
    }

    public void printFactionList() {
        String printFactionList = "1. Левая\n" +
                "2. Правая\n" +
                "3. Центральная";
        System.out.println(printFactionList);
    }

    public void printAllParty() {
        System.out.println("========== Все партии Выборландии ==========");
    }

    public void workWithParties() {
        String workWithParties = "============================================\n" +
                "1. Просмотреть всех членов конкретной партии\n" +
                "0. Выход в главное меню";
        System.out.println(workWithParties);
    }

    public void printPollOfVoters() {
        System.out.println("========== Опрос избирателей на согласие принять участие в выборах ==========");
    }

    public void appeal(String c) {
        System.out.println("Уважаемый " + c + " желаете ли вы принять участие в выборах?");
        menuYesNo();
    }

    public void printPartySelection() {
        System.out.println("Пожалуйста, выберите партию, за которую хотите отдать свой голос: ");
    }

    public void printNumbering(int number, String p) {
        System.out.println(number + ". " + p);
    }

    public void showVoters() {
        String showVoters = "============================================\n" +
                "1. Просмотреть всех избирателей\n" +
                "2. Просмотреть избирателей конкретного участка\n" +
                "0. Выход в главное меню";
        System.out.println(showVoters);
    }

    public void printAllVotersList() {
        System.out.println("========== Все избиратели ==========");
    }

    public void printEnterUniqueStationNumber() {
        System.out.println("----- Пожалуйста, введите уникальный номер избирательного участка -----");
    }

    public void printMenuAddRemoveVoter() {
        String menuAddRemoveVoter = "====================================\n" +
                "1. Добавить избирателя\n" +
                "2. Удалить избирателя\n" +
                "0. Выход в главное меню";
        System.out.println(menuAddRemoveVoter);
    }

    public void printEnterITNForAdding() {
        System.out.println("----- Пожалуйста, укажите ИИН гражданина, которого вы ходите добавить к списку избирателей -----");
        printITN();
    }

    public void printEnterRegistrationArea() {
        printEnterUniqueStationNumber();
        System.out.println("-----             к которому будет приписан гражданин             -----");
    }

    public void printEnterITNForRemove() {
        System.out.println("----- Пожалуйста, укажите ИИН гражданина, которого вы ходите удалить из списка избирателей -----");
    }

    public void printEnterITNCitizen() {
        System.out.println("----- Пожалуйста, укажите ИИН гражданина, которого вы ходите добавить в партию -----");
    }

    public void printEnterPartyName() {
        System.out.println("----- Пожалуйста, введи имя партии, в которую нужно добавить гражданина -----");
        printName();
    }

    public void printEnterRating() {
        System.out.println("----- Пожалуйста, укажите начальный рейтинг для кандидата -----");
        System.out.print("Рейтинг: ");
    }

    public void printListAllElections() {
        System.out.println("========== Список всех выборов Выборландии ==========");
    }
}
