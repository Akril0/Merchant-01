package app;

import java.util.Scanner;

// Класс-входная точка в приложение.
// App launcher.
public class App {

    static String merchantName;
    static String email;
    static String phone;
    static String productName;
    static int quantity;
    static double price;
    static String roundBonus;
    static ProductA product;
    static MerchantA merchantA;
    static String infoMerchant;
    static String infoProduct;

    // Делаем метод main() наименее загруженным логикой
    public static void main(String[] args) {
        initVars();
        showData(processData());
    }

    // Инициализация переменных.
    // Имитация ввода данных пользователем.
    private static void initVars() {
        Scanner input = new Scanner(System.in);
        merchantName = input.nextLine();
        email = input.nextLine();
        phone = input.nextLine();
        productName = input.nextLine();
        try {
            quantity = input.nextInt();
            price = input.nextDouble();
        }
        catch (NumberFormatException e){
            System.out.println("Ошибка ввода!");
        }

    }

    // Передача данных на обработку.
    // Вызовы методов через экземпляры классов
    // для получения результатов расчетов.
    // Здесь же получение расчета и округления бонуса.
    // Получение шаблона для вывода.
    private static String processData() {
        merchantA = new MerchantA(merchantName, phone, email);
        infoMerchant = merchantA.infoMerchant();
        product = new ProductA(productName, quantity, price);
        infoProduct = product.infoProduct();
        double sales = product.calcSales(quantity, price);
        roundBonus = Rounder.roundValue(merchantA.calcBonus(sales));
        return infoMerchant + infoProduct + "\nБонус (грн.): " + roundBonus;
    }

    // Вывод данных
    private static void showData(String output) {
        System.out.println(output);
    }
}
