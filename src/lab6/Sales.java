package lab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Sales {
    private static TreeMap<String,Integer> sales;
    private static int countSales;

    public Sales(){
        sales=new TreeMap<>();
        countSales=0;
    }

    public void addSale(String product, int count){
        if(sales.containsKey(product)){
            sales.put(product,sales.get(product)+count);
        }else {
            sales.put(product,count);
        }
        countSales+=count;
    }

    public void getAllSales(){
        System.out.println("All sales:");
        System.out.println(sales.toString());
        System.out.println("__________________________");
    }

    public int getCountSales(){
        return countSales;
    }

    public String mostPopularProduct(){
        List<Integer> values = new ArrayList<>(sales.values());
        Collections.sort(values);
        int c = values.get(values.size()-1);
        for (String key: sales.keySet()){
            if(sales.get(key).equals(c)){
                return key;
            }
        }
        return null;
    }
}
