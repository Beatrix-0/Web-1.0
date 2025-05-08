public class Main {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.setBrand("Ford");
        Car c2 = new Car("Tyoto");
        Car c3 = new Car("sfgg" , "agdgd");
        Car c4 = new Car("gggw4" , "neguw" , -10.0 );

        System.out.println(c1.getBrand() + " " + c2.getBrand() + " " + c3.getModel() + " " + c4.getFuel());

    } // Need restart
}