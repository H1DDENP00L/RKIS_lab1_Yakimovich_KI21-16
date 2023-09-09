import java.util.Objects;

/**
 * Базовый класс содержащий информацию об объектах.
 */
public class Food {
    /**
     * Название блюда.
     */
    private String foodName;
    /**
     * Номер подачи блюда.
     */
    private Integer orderOfServing;


    /**
     * Конструктор по умолчанию.
     */
    public Food(){
        foodName = "Dish";
        orderOfServing = 0;
    }

    /**
     * Конструктор с параметрами.
     *
     * @param foodName Название блюда.
     * @param orderOfServing Номер подачи блюда.
     */
    public Food(String foodName, Integer orderOfServing){

        this.orderOfServing = orderOfServing;
        this.foodName = foodName;
    }

    /**
     * Сравнение объектов
     *
     * @param o объект для сравнения.
     * @return результат сравнения объектов.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(foodName, food.foodName) && Objects.equals(orderOfServing, food.orderOfServing);
    }

    /**
     * Возвращает числовое значение фиксированной длины для любого объекта.
     *
     * @return Числовое значение фиксированной длины для любого объекта.
     */
    @Override
    public int hashCode(){
        return Objects.hash(foodName, orderOfServing);
    }

    /**
     * Возвращает название блюда.
     *
     * @return Название блюда.
     */
    public String getFoodName(){
        return foodName;
    }

    /**
     * Возвращает очередь подачи блюда.
     *
     * @return Очередь подачи блюда.
     */
    public int getOrderOfServing(){
        return orderOfServing;
    }

    /**
     * Устанавливает значение поля foodName, если переданная строка foodName не пуста.
     *
     * @param foodName Значение, которое будет установлено в поле foodName.
     */
    public void setFoodName(String foodName){
        if(!foodName.isEmpty()){
            this.foodName = foodName;
        }
    }

    /**
     * Устанавливает значение поля orderOfServing, если переданное значение orderOfServing не равно нулю.
     *
     * @param orderOfServing Значение, которое будет установлено в поле orderOfServing.
     */
    public void setOrderOfServing(int orderOfServing){
        if(orderOfServing != 0){
            this.orderOfServing = orderOfServing;
        }
    }

    /**
     * Вывод информации об объекте.
     *
     * @return Информация объекта.
     */
    @Override
    public String toString() {
        return " | Блюдо - " + foodName + " | Очередь в списке подачи - " + orderOfServing + " й |";
    }
}
