package sample;

/**
 * класс, описывающий водителя автобус
 * @author nastyabaturkina
 *
 */
public class BusDrivers {
    private int id;
    private String name;
    private String bus_number;
    private String route_number;
    private String mark;
    private int start_year;
    private int run;

    public BusDrivers() {}

    public BusDrivers(int nID, String nName, String nBusNum, String nRouteNum, String nMark, int nStartYear, int nRun)
    {
        set_id(nID);
        set_name(nName);
        set_bus_number(nBusNum);
        set_route_number(nRouteNum);
        set_mark(nMark);
        set_start_year(nStartYear);
        set_run(nRun);
    }


    /**
     * функция, преображающая информацию об объекте в формат json
     * @return возвращает строку для json файла
     */
    public String toJson()
    {
        return	("\n   \"name\": " + "\"" + get_name() + "\""
                + ",\n   \"bus number\": " + "\"" + get_bus_number() + "\""
                + ",\n   \"route number\": " + "\"" + get_route_number() + "\""
                + ",\n   \"mark\": "  + "\" " + get_mark() + "\""
                + ",\n   \"start year\": " + get_start_year()
                + ",\n   \"mileage\": " + get_run() );

    }

    @Override
    public String toString()
    {
    return this.get_id() + "\t" + this.get_name() + "\t" + this.get_bus_number();
    }

    /**
     * функция-геттер для получения имени объекта
     * @return возвращает строку с именем водителя
     */
    public String get_name()
    {
        return name;
    }

    public void set_id(int ID) { id = ID; }
    public int get_id() { return id; }
    /**
     * функция-геттер для получения номера автобуса
     * @return возвращает строку с номером автобуса
     */
    public String get_bus_number()
    {
        return bus_number;
    }

    /**
     * функция-геттер для получения номера маршрута
     * @return возвращает строку с номером маршрута
     */
    public String get_route_number()
    {
        return route_number;
    }

    /**
     * функция-геттер для получения марки автобуса
     * @return возвращает строку с названием марки автобуса
     */
    public String get_mark()
    {
        return mark;
    }

    /**
     * функция-геттер для получения года, с которого автобус в эксплуатации
     * @return возвращает год
     */
    public int get_start_year()
    {
        return start_year;
    }

    /**
     * функция-геттер для получения пробега
     * @return возвращает пробег
     */
    public int get_run()
    {
        return run;
    }

    /**
     * функция-cеттер для инициализации имени водителя
     * @param _name строка с именем водителя
     */
    public void set_name(String _name)
    {
        name = _name;
    }


    /**
     * функция-cеттер для инициализации номера автобуса
     * @param _busNumber строка с номером автобуса
     */
    public void set_bus_number(String _busNumber)
    {
        bus_number = _busNumber;
    }

    /**
     * функция-cеттер для инициализации номера маршрута
     * @param _routeNumber строка с номером маршрута
     */
    public void set_route_number(String _routeNumber)
    {
        route_number = _routeNumber;
    }

    /**
     * функция-cеттер для инициализации марки автобуса
     * @param _mark строка с названием марки автобуса
     */
    public void set_mark(String _mark)
    {
        mark = _mark;
    }

    /**
     * функция-cеттер для инициализации года, с которого автобус в эксплуатации
     * @param _startYear номер года, с которого автобус в эксплуатации
     */
    public void set_start_year(int _startYear)
    {
        start_year = _startYear;
    }

    /**
     * перегруженная функция-cеттер для инициализации года, с которого автобус в эксплуатации, преображая строку в целочисельный тип данных
     * @param _startYear строка с годом, с которого автобус в эксплуатации
     * @throws MyException если входящая строка, то выбрасывается исключение
     */
    public void set_start_year(String _startYear) throws MyException
    {
        try
        {
            set_start_year(Integer.parseInt(_startYear));
        }
        catch ( NumberFormatException exc)
        {
            throw new MyException(exc.getLocalizedMessage() + " col \"start_year\" not valid");
        }
    }

    /**
     * функция-cеттер для инициализации пробега автобуса
     * @param _run пробег автобуса
     */
    public void set_run(int _run)
    {
        run = _run;
    }

    /**
     * перегруженная функция-cеттер для инициализации пробега, преображая строку в целочисельный тип данных
     * @param _run строка с пробегом
     * @throws MyException если входящая строка не валидна, выбрасывается исключение
     */
    public void set_run(String _run) throws MyException
    {
        try
        {
            set_run(Integer.parseInt(_run));
        }
        catch(NumberFormatException exc)
        {
            throw new MyException(exc.getLocalizedMessage() + " col \"mileage\" not valid");
        }
    }

}