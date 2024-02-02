package SS.bugerVo;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class FoodVo {
    private String fcode;
    private String fname;
    private String category;
    private int price;
    private int gram;
    private int kal;
 
    public FoodVo(String fcode, String fname, String category, int price, int gram, int kal) {
        this.fcode = fcode;
        this.fname = fname;
        this.category = category;
        this.price = price;
        this.gram = gram;
        this.kal = kal;
    }
    String hang = "항목";
    @Override
    public String toString() {
        
        return String.format("||%4s%-20s %-35s\t %s %9d%1s %8d%1s %8d%-8s||\n","",fcode,fname,category,price,"원",gram,"g",kal,"kcal");
    }

}
