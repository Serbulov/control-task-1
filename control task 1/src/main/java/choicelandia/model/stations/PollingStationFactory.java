package choicelandia.model.stations;

/**
 * ---------------------------------------------------- <br/>
 * Паттерн "Фабричный метод". <br/>
 * Создание избирательного участка исходя из вводимых параметров. <br/>
 * ---------------------------------------------------- <br/>
 **/

public class PollingStationFactory {

    public static PollingStation createPolSt(String type, String address) {
        if (type.equalsIgnoreCase("обычный")) return new OrdinaryPolSt(type, address);
        if (type.equalsIgnoreCase("для людей на карантине")) return new QuarantinePolSt(type, address);
        if (type.equalsIgnoreCase("для армии и спецслужб")) return new ClosedPolSt(type, address);

        throw new IllegalArgumentException("Illegal set of arguments");
    }
}
