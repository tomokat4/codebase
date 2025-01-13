public class TestStock {
    public static void main(String[] args) {
        Stock OCLA = new Stock("OCLA", "Oriental Corporation Limited");
        double changePercent = OCLA.getChangePercent(34.5, 34.35);
        System.out.println("Price percent change is " + changePercent);
    }
}
