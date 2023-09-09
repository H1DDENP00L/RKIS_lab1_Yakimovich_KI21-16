import java.util.Objects;

/**
 * Производный класс содержащий информацию о дессерте.
 */
public class Dessert extends Food {

    /**
     * "Родная" страна блюда.
     */
    private String originalCounty;

    /**
     * Содержит ли дессерт сахар.
     */
    private Boolean sugarContains;

    /**
     * Колличество калорий.
     */
    private Integer calories;

    /**
     * Конструктор по умолчанию.
     */
    public Dessert(){
        originalCounty = "NoCountry";
        sugarContains = true;
        calories = 0;
    }

    /**
     * Конструктор с параметрами
     *
     * @param foodName Имя блюда.
     * @param orderOfServing Очередь подачи блюда.
     * @param originalCounty Родная страна дессерта.
     * @param sugarContains Содержит ли дессерт сахар.
     * @param calories Колличество каллорий.
     * */
    public Dessert(String foodName, Integer orderOfServing, String originalCounty, Boolean sugarContains, Integer calories){
        super(foodName, orderOfServing);
        this.originalCounty = originalCounty;
        this.sugarContains = sugarContains;
        this.calories = calories;
    }

    /**
     * Сравнение объектов
     *
     * @param o объект для сравнения.
     * @return результат сравнения объектов.
     */
    @Override
    public boolean equals(Object o){
        if(!super.equals(o)) return false;
        Dessert that = (Dessert) o;
        return Objects.equals(originalCounty, that.originalCounty) &&
                Objects.equals(calories, that.calories) &&
                Objects.equals(sugarContains, that.sugarContains);
    }

    /**
     * Устанавливает значение поля originCountry, если переданная строка originCountry не пуста.
     *
     * @param originalCounty Значение, которое будет установлено в поле originCountry.
     */
    public void setOriginalCounty(String originalCounty){
        if (!originalCounty.isEmpty()){
            this.originalCounty = originalCounty;
        }
    }

    /**
     * Устанавливает значение поля calories, если переданное значение calories не равно нулю.
     *
     * @param calories Значение, которое будет установлено в поле calories.
     */
    public void setCalories(Integer calories){
        if (calories !=0){
            this.calories = calories;
        }
    }

    /**
     * Устанавливает значение поля sugarContains, если переданное значение sugarContains было иным изначально.
     *
     * @param sugarContains Значение, которое будет установлено в поле sugarContains.
     */
    public void setSugarContains(Boolean sugarContains){
        if (sugarContains != this.sugarContains){
            this.sugarContains = sugarContains;
        }
    }

    /**
     * Вывод информации об объекте.
     *
     * @return Информация объекта.
     */
    @Override
    public String toString(){
        return " | Название блюда - " + getFoodName() + " | Очередь подачи - " + getOrderOfServing() +
                "й | Страна десерта - " + originalCounty + " | Колличество каллорий - " + calories +
                "ккал | Содержит ли сахар - " + sugarContains;
    }

}