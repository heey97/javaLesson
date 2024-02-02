package collection.day11;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String Phone;
    private int group;


    public Customer (String name, String phone, Integer group) {
        this.name = name;
        this.Phone = phone;
        this.group = group;
    }


    public String getName() {
        return name;
    }


    public String getPhone() {
        return Phone;
    }


    public int getGroup() {
        return group;
    }

    public void modify(String phone,int group){
        this.Phone = phone;
        this.group = group;
    }
    //수정 시 한개의 값이 널이면 변경한 값만 바뀌게 수정
}





