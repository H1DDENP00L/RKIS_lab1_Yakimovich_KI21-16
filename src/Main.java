// Вариант 24
// Для каждого варианта имеется набор из четырех сущностей.
// Необходимо выстроить иерархию наследования.
// В каждом классе (базовом и производных) должно быть
// не менее одного числового и одного строкового поля.
// При вводе числовых параметров обязательна проверка на
// число и на диапазон (даже если число может быть любое, проверку необходимо реализовать).

import java.util.*;

/**
 * Класс Main используется для управления объектами блюд.
 */
public class Main {

    /**
     * Основное меню программы.
     */
    private static void printMenu(){
        System.out.print("""
                | ___ГЛАВНОЕ МЕНЮ___ |
                1 - Добавить блюдо
                2 - Удалить блюдо
                3 - Вывод всех блюд
                4 - Сравнение двух блюд на равенство (по индексам)
                5 - Завершение работы \n \n""");
    }


    /**
     * Меню добавления блюд.
     */
    private static void printDishesMenu(){
        System.out.println("""
                | ___МЕНЮ ДОБАВЛЕНИЯ БЛЮД___ |
                1 - Добавить простое блюдо
                2 - Добавить первое блюдо
                3 - Добавить второе блюдо
                4 - Добавить дессер
                5 - Отмена \n \n""");
    }

    /**
     * Меню параметров.
     */
    private static void printConfigMenu(){
        System.out.println("""
                | ___МЕНЮ ДОБАВЛЕНИЯ БЛЮД___ |
                1 - Добавить блюдо с параметрами
                2 - Добавить блюдо без параметров
                3 - Отмена \n \n""");
    }

    /**
     * Функция для получения целочисленного ввода.
     *
     * @return Целое число.
     */
    private static int getIntInput() {

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        int userInt = 0;
        boolean allowedInput = false;

        do {
            try {
                userInt = Integer.parseInt(userInput);
                allowedInput = true;
            } catch (NumberFormatException ex) {
                System.out.println("Некорректный ввод! Введите целое число:");
                userInput = input.nextLine();
            }
        } while (!allowedInput);
        return userInt;
    }

    /**
     * Функция для получения строки от ввода пользователя.
     *
     * @return Введенная строка.
     */
    private static String getStringInput() {

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        while (userInput.isEmpty()) {
            System.out.println("Ввод не может быть пустым! Повторите ввод:");
            userInput = input.nextLine();
        }
        return userInput;
    }

    /**
     * Функция для получения булевого значения от ввода пользователя.
     *
     * @return Булевое значение true или false.
     */
    private static boolean getBoolChoice() {
        boolean result;
        String userChoice = getStringInput();

        if (userChoice.equalsIgnoreCase("Да")) {
            result = true;
        } else if (userChoice.equalsIgnoreCase("Нет")) {
            result = false;
        } else {
            System.out.println("Отвечайте Да или Нет");
            result = getBoolChoice();
        }

        return result;
    }

    /**
     * Функция для получения целочисленного ввода в заданном диапазоне от пользователя.
     *
     * @param lowerLimit Нижний предел.
     * @param upperLimit Верхний предел.
     * @return Целочисленное число в заданном диапазоне.
     */
    private static int getIntInputWithParams(int lowerLimit, int upperLimit) {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        int userInt = 0;
        boolean allowedInput = false;

        do{
            try{
                userInt = Integer.parseInt(userInput);
                if (userInt < lowerLimit || userInt > upperLimit){
                    System.out.println("Число находится вне заданного диапазона, " +
                            "Введите число от " + lowerLimit + "до " + upperLimit);
                    userInput = input.nextLine();
                } else {
                    allowedInput = true;
                }
            } catch (NumberFormatException ex) {
                System.out.println(" НЕВЕРНЫЙ ФОРМАТ ВВОДА. ВВЕДИТЕ ЧИСЛО!!!");
                userInput = input.nextLine();
            }
        }while (!allowedInput);
        return userInt;
    }

    /**
     * Функция для получения ввода числа с плавающей точкой в заданном диапазоне от пользователя.
     *
     * @param lowerLimit Нижний предел.
     * @param upperLimit Верхний предел.
     * @return Число с плавающей точкой число в заданном диапазоне.
     */
    private static double getDoubleInputWithParams(double lowerLimit, double upperLimit) {

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        double userDouble = 0.0;
        boolean allowedInput = false;

        do {
            try {
                userDouble = Double.parseDouble(userInput);
                if (userDouble < lowerLimit || userDouble > upperLimit) {
                    System.out.print("Число не в заданном диапазоне! введите число " +
                            "(от " + lowerLimit + " до " + upperLimit + ")");
                    userInput = input.nextLine();
                } else {
                    allowedInput = true;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Некорректный ввод! Введите вещественное число:");
                userInput = input.nextLine();
            }
        } while (!allowedInput);
        return userDouble;
    }

    /**
     * Функция предоставляет пользователю выбор добавить блюдо с параметрами или без.
     *
     * @param dishesList Массив с блюдами.
     */
    private static void DishesType(ArrayList<Food> dishesList){

        printConfigMenu();
        int choice = getIntInput();
        switch (choice){
            case 1 -> getNewDishWithParams(dishesList);
            case 2 -> getNewDish(dishesList);
            case 3 -> System.out.println("Отмена.....\n");
            default -> System.out.println("Такого пункта нет в меню");
        }
    }

    /**
     * Функция предоставляет выбор добавить блюдо с выбранной пользователем конфигурацией.
     *
     * @param dishesList Массив с блюдами.
     */
    private static void getNewDish(ArrayList<Food> dishesList){

        printDishesMenu();
        int userChoice = getIntInput();
        switch (userChoice){
            case 1 -> dishesList.add(new Food());
            case 2 -> dishesList.add(new FirstDish());
            case 3 -> dishesList.add(new SecondDish());
            case 4 -> dishesList.add(new Dessert());
            case 5 -> System.out.println("Отмена... \n");
            default -> System.out.println("Такого пункта нет в меню");
        }
    }

    /**
     * Функция предоставляет пользователю выбор блюда, который после создания
     * будет добавлен массив с остальными блюдами.
     *
     * @param dishesList Массив с блюдами.
     */
    private static void getNewDishWithParams(ArrayList<Food> dishesList){

        printDishesMenu();
        int userChoice = getIntInput();
        switch (userChoice) {
            case 1 -> dishesList.add(createNewBasicDish());
            case 2 -> dishesList.add(createNewFirstDish());
            case 3 -> dishesList.add(createNewSecondDish());
            case 4 -> dishesList.add(createNewDessert());
            case 5 -> System.out.println("Отмена... \n");
            default -> System.out.println("Такого пункта нет в меню");
        }
    }


    /**
     * Функция возвращает название блюда.
     *
     * @return Название блюда.
     */
    private static String getNewDishName(){

        System.out.println("Введите название блюда");
        return getStringInput();
    }

    /**
     * Функция возвращает очередь подачи блюда.
     *
     * @return Очередь подачи блюда.
     */
    private static int getOrderOfDish(){

        System.out.println("Введите очередь подачи  блюда");
        return getIntInputWithParams(1,3);
    }

    /**
     * Функция удаляет объект блюда из массива по индексу.
     *
     * @param dishesList Массив с блюдами.
     */
    private static void deleteDish(ArrayList<Food> dishesList){
        printAllDishes(dishesList);
        if(!dishesList.isEmpty()){
            System.out.println("Введите номер блюда для удаления");
            int numToDelete = getValidIndex(dishesList);
            dishesList.remove(numToDelete - 1);
            System.out.println("блюдо номер |" + numToDelete + "| Удалено!");
        }
    }

    /**
     * Функция выводит все информацию о всех блюдах в массиве.
     *
     * @param dishesList Массив с блюдами.
     */
    private static void printAllDishes(ArrayList<Food> dishesList){
        int counter = 1;
        if(dishesList.isEmpty()){
            System.out.println("Блюд нет!!!");
        }else {
            for (Food i: dishesList){
                System.out.println("#" + counter + i.toString());
                counter++;
            }
        }
    }

    /**
     * Функция создает новое базовое блюдо.
     *
     * @return Созданное базовое блюдо.
     */
    private static Food createNewBasicDish() {
        String foodName = getNewDishName();
        int orderOfServing = getOrderOfDish();

        System.out.println("Блюдо создано!");
        return new Food(foodName, orderOfServing);
    }

    /**
     * Функция создает новое первое блюдо.
     *
     * @return Созданное первое блюдо.
     */
    private static Food createNewFirstDish(){
        String foodName = getNewDishName();
        int orderOfServing = getOrderOfDish();

        System.out.println("Введите объем блюда от 100 до 750 мл");
        int volume = getIntInputWithParams(100, 750);

        System.out.println("Введите родную страну блюда");
        String originCountry = getStringInput();

        return new FirstDish(foodName, orderOfServing, volume, originCountry);
    }

    /**
     * Функция создает новое второе блюдо.
     *
     * @return Созданное второе блюдо.
     */
    private static Food createNewSecondDish(){
        String foodName = getNewDishName();
        int orderOfServing = getOrderOfDish();

        System.out.println("Введите массу блюда (от 100.0 до 500.0 грамм)");
        double mass = getDoubleInputWithParams(100, 500);

        System.out.println("Введите калорийность блюда, ккал");
        int calories = getIntInput();

        System.out.println("Введите тип блюда (Азиатское, Русское и тд...)");
        String foodType = getStringInput();

        return new SecondDish(foodName, orderOfServing, mass, calories, foodType);
    }


    /**
     * Функция создает новый дессерт.
     *
     * @return Созданный дессерт.
     */
    private static Food createNewDessert(){
        String foodName = getNewDishName();
        int orderOfServing = getOrderOfDish();

        System.out.println("Введите родную страну дессерта");
        String originCounty = getStringInput();

        System.out.println("Содержит ли дессерт сахар? (да / нет)");
        boolean sugarContains = getBoolChoice();

        System.out.println("Введите клорийность дессерта (от 0 до 1000 ккал)");
        int calories = getIntInputWithParams(0, 1000);

        return new Dessert(foodName, orderOfServing, originCounty, sugarContains, calories);
    }

    /**
     * Функция получает корректный ввод индекса элемента массива от пользователя.
     *
     * @param dishesList Массив со всеми блюдами.
     * @return Индекс элемента массива.
     */
    private static int getValidIndex(ArrayList<Food> dishesList){
        int index = getIntInput();
        while (index < 1 || index > dishesList.size()){
            System.out.println("Введите корректный индекс (от 1 до " + dishesList.size() +"): \n");
            index = getIntInput();
        }
        return index;
    }

    /**
     * Функция проверяет два объекта на равенство по индексам.
     *
     * @param dishesList Массив блюд.
     */
    private static void compareDishes(ArrayList<Food> dishesList){

        printAllDishes(dishesList);
        if (!dishesList.isEmpty()){
            System.out.println("Введите номер первого блюда: ");
            int firstDishIndex = getValidIndex(dishesList) -1;

            System.out.println("Введите номер второго блюда");
            int secondDishIndex = getValidIndex(dishesList) -1;


            if(!(firstDishIndex == secondDishIndex)){
                if (dishesList.get(firstDishIndex).hashCode() == dishesList.get(secondDishIndex).hashCode()) {
                    System.out.println("Хэш-коды двух объектов равны");
                }else {
                    System.out.println("Объекты не равны из-за неравенства хэш-кодов");
                }

//                if (dishesList.get(firstDishIndex).equals(dishesList.get(secondDishIndex))){
//                    System.out.println("Объекты равны, так как хэш-коды и операция равенства двух объектов равны");
//                }
//                else {
//                    System.out.println("Объекты не равны из-за операции равенства");
//                }
            }else {
                System.out.println("Нельзя сравнить одинаковы индексы");
            }

        }
    }

    /**
     * Главная функция программы с возможностью вывода информации и
     * реализацией алгоритма.
     *
     * @param args массив последовательностей символов (строк),
     * которые передаются в функцию main.
     */
    public static void main(String[] args) {

        ArrayList<Food> dishesList = new ArrayList<>();
        int menuChoice;

        do{
            printMenu();
            System.out.println("Выберите пункт");
            menuChoice = getIntInput();

            switch (menuChoice){
                case 1 -> DishesType(dishesList);
                case 2 -> deleteDish(dishesList);
                case 3 -> printAllDishes(dishesList);
                case 4 -> compareDishes(dishesList);
                case 5 -> System.out.println("Конец работы");
                default -> System.out.println("Такого пункта нет в меню");
            }
        } while (menuChoice != 5);
    }
}