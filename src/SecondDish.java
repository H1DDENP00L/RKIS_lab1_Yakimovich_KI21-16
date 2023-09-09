import java.util.Objects;

/**
 * Производный класс содержащий информацию о втором блюде.
 */
public class SecondDish extends Food {


    /**
     * Масса блюда.
     */
    private Double mass;

    /**
     * Колличество калорий.
     */
    private Integer calories;

    /**
     * Тип блюда (Азиатское/Европейское/Русское и т.д.).
     */
    private String foodType;

    /**
     * Конструктор по умолчанию.
     */
    public SecondDish(){
        mass = 0.0;
        calories = 0;
        foodType = "NoType";
    }


    /**
     * Конструктор с параметрами
     *
     * @param foodName Имя блюда.
     * @param orderOfServing Очередь подачи блюда.
     * @param mass Масса блюда.
     * @param calories Колличество каллорий.
     * @param foodType Тип блюда.
     * */
    public SecondDish(String foodName, Integer orderOfServing, Double mass, Integer calories, String foodType){

        super(foodName, orderOfServing);
        this.mass = mass;
        this. calories = calories;
        this.foodType = foodType;
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
        SecondDish that = (SecondDish) o;
        return Objects.equals(mass, that.mass) &&
                Objects.equals(calories, that.calories) &&
                Objects.equals(foodType, that.foodType);
    }

    /**
     * Возвращает числовое значение фиксированной длины для любого объекта.
     *
     * @return Числовое значение фиксированной длины для любого объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(mass, calories, foodType);

    }

    /**
     * Устанавливает значение поля mass, если переданное значение mass не равна нулю.
     *
     * @param mass Значение, которое будет установлено в поле mass.
     */
    public void setMass(Double mass){
        if ( mass != 0){
            this.mass = mass;
        }
    }

    /**
     * Устанавливает значение поля calories, если переданное значение calories не равно нулю.
     *
     * @param calories Значение, которое будет установлено в поле calories.
     */
    public void setCalories(Integer calories){
        if (calories != 0){
            this.calories = calories;
        }
    }

    public void setFoodType(String foodType){
        if(!foodType.isEmpty()){
            this.foodType = foodType;
        }
    }

    /**
     * Вывод информации об объекте.
     *
     * @return Информация объекта.
     */
    @Override
    public String toString() {
        return " | Название блюда - " + getFoodName() + " | Очередь подачи - " + getOrderOfServing() +
                "й | Масса блюда - " + mass + " г. | Колличество каллорий - " + calories +
                "ккал | Тип блюда (из какого региона) - " + foodType;
    }
}