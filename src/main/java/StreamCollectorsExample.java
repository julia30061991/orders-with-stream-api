
import java.util.*;
import java.util.stream.Collectors;

public class StreamCollectorsExample {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );
        //группировка по категории товара
        Map<String, List<Order>> sortedMap = orders.stream().collect(Collectors.groupingBy(Order::getProduct));
        //нахождение товара с самой высокой ценой
        Order max = orders.stream().max(Order::compare).get();
        //нахождение товара с самой низкой ценой
        Order min = orders.stream().min(Order::compare).get();
        //сортировка товаров от самого дешевого к самому дорогому
        List<Order> sortedResult = orders.stream().sorted(Comparator.comparingDouble(Order::getCost)).collect(Collectors.toList());
        //выборка трех самых дорогих продуктов
        List<Order> maxCostOrders = sortedResult.stream().skip(sortedResult.size() - 3).collect(Collectors.toList());
        //вывод их в консоль
        maxCostOrders.forEach(System.out::println);
        //получение общей стоимости трех самых дорогих продуктов
        Optional<Double> sum = maxCostOrders.stream().map(order -> order.getCost()).reduce((a, b) -> a+b);
        //вывод в консоль общей стоимости трех самых дорогих продуктов
        System.out.println("Общая стоимость: " + sum);
    }
}