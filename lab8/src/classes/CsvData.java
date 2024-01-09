package classes;

public class CsvData implements Comparable<CsvData>{
    String MonthYear;
    int Number_Trucks_Sold;

    public CsvData(String MonthYear,int Number_Trucks_Sold) {
        this.MonthYear=MonthYear;
        this.Number_Trucks_Sold=Number_Trucks_Sold;

    }

    public int compareTo(CsvData other){
        return Integer.compare(this.Number_Trucks_Sold, other.Number_Trucks_Sold);
    }

    @Override
    public String toString() {
        return  "MonthYear : "+MonthYear+" , Number_Truck_Sold : "+Number_Trucks_Sold;
    }
}