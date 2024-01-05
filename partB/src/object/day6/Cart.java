package object.day6;

public class Cart {
    private String userid;
    private String[] productNames;
    private int[] prices;
    private int total_Money;

    //getter
    public String getUserid() {
        return this.userid;
    }
    public String[] getProductNames() {
        return this.productNames;
    }
    public int[] getPrices() {
        return this.prices;
    }
    public int getTotal_Money() {
        return this.total_Money;
    }

    //setter
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public void setProductNames(String[] productNames) {
        this.productNames = productNames;
    }
    public void setPrices(int[] prices) {
        this.prices = prices;
    }
    public void setTotal_Money(int[] select) {
        int sum =0;
        for(int i =0; i<select.length; i++){
             sum+=select[i];
        }
        this.total_Money=sum;
    }

}
