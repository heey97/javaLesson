package object.day6;

import java.util.Arrays;

public class Product {
    private String productName;
    private int price;
    private String company;
    private String[] etc;
    private String[] ss;

    //커스텀 생성자 만들기
    public Product(String productName,int price,String company,String[] etc,String[] ss){
        this.productName = productName;
        this.price = price;
        this.company = company;
        this.etc = etc;
        this.ss = ss;
        
    }

    //getter 생성자 만들기
    public String getProductName(){
        return this.productName;
    }
    public int getPrice(){
        return this.price;
    }
    public String getCompany(){
        return this.company;
    }
    public String[] getEtc(){
        return this.etc;
    }
    public String[] getSs(){
        return this.ss;
    }

    public String getData(){
        return String.format("%s\t %d\t %s\t %s\t %s",productName,price,company, Arrays.toString(etc),Arrays.toString(ss));
    }
}
