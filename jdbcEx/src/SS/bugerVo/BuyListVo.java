package SS.bugerVo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.sql.Date;


@Getter
@EqualsAndHashCode
public class BuyListVo {
    private int idx;
    private String id;
    private String fcode;
    private int quantity;
    private Date buy_date;

    public BuyListVo(int idx,String id, String fcode, int quantity, Date buy_date){
        this.idx = idx;
        this.id = id;
        this.fcode = fcode;
        this.quantity = quantity;
        this.buy_date = buy_date;
    }
    @Override
    public String toString() {
        return "No"+idx + ". 아이디: " + id + "\t음식코드: " + fcode + "\t수량: " + quantity
                + "\t주문일자: " + buy_date;
    }
}
