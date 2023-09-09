import java.util.Objects;

/**
 * Производный класс содержащий информацию о первом блюде.
 */
public class FirstDish extends Food {

    /**
     * Объем блюда.
     */
    private Integer volume;

    /**
     * "Родная" страна блюда.
     */
    private String originCountry;

    /**
     * Конструктор по-умолчанию.
     */
    public FirstDish(){

        volume = 0;
        originCountry = "noCountry";
    }

    /**
     * Конструктор с параметрами.
     *
     * @param foodName Имя блюда.
     * @param orderOfServing Номер подачи блюда.
     * @param volume Объем блюда.
     * @param originCountry Родная страна блюда.
     */
    public FirstDish(String foodName, Integer orderOfServing, Integer volume, String originCountry){

        super(foodName, orderOfServing);
        this.originCountry = originCountry;
        this.volume = volume;
    }

    /**
     * Сравнение объектов
     *
     * @param o объект для сравнения.
     * @return результат сравнения объектов.
     */
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        FirstDish that = (FirstDish) o;
        return Objects.equals(volume, that.volume) && Objects.equals(originCountry, that.originCountry);
    }

    /**
     * Возвращает числовое значение фиксированной длины для любого объекта.
     *
     * @return Числовое значение фиксированной длины для любого объекта.
     */
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), volume, originCountry);
    }

    /**
     * Устанавливает значение поля volume, если переданное значение volume не равно нулю.
     *
     * @param volume Значение, которое будет установлено в поле foodName.
     */
    public void setVolume(Integer volume){
        if (volume != 0) {
            this.volume = volume;
        }
    }

    /**
     * Устанавливает значение поля originCountry, если переданная строка originCountry не пуста.
     *
     * @param originCountry Значение, которое будет установлено в поле originCountry.
     */
    public void setOriginCountry(String originCountry){
        if (!originCountry.isEmpty()){
            this.originCountry = originCountry;
        }
    }

    /**
     * Вывод информации об объекте.
     *
     * @return Информация объекта.
     */
    @Override
    public String toString(){
        return " | Название блюда - " + getFoodName() + " | Очередь подачи - " + getOrderOfServing() + "й | Объем блюда" +
                volume + " мл | Страна производитель - " + originCountry + " |";
    }
}