class Order {
    private String product;
    private double cost;

    public Order(String product, double cost) {
        this.product = product;
        this.cost = cost;
    }

    public String getProduct() {
        return product;
    }

    public double getCost() {
        return cost;
    }

    public static int compare (Order order1, Order order2){
        if(order1.getCost() > order2.getCost())
            return 1;
        return -1;
    }

    @Override
    public String toString() {
            return "Товар: " + product + ", цена: " + cost;
    }
}
