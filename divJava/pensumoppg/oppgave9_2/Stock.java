class Stock {
    //datafields
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;

    //constructor
    Stock(String newSymbol, String newName){
        symbol = newSymbol;
        name = newName;
    }

    //methods

    double getChangePercent(double newPreviousClosingPrice, double newCurrentPrice){
        double previousClosingPrice = newPreviousClosingPrice;
        double currentPrice = newCurrentPrice;
        double changePercent = previousClosingPrice/currentPrice*100;
        return changePercent;
    }

}
