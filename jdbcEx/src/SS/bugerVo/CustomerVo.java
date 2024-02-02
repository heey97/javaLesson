package SS.bugerVo;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode

public class CustomerVo {
    private String id;
    private String name;
    private int age;
    private String phone;
   
    public CustomerVo(String id, String name, int age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "TBL_CustomerVo [id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + "]";
    } 
    
}
