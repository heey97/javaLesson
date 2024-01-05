package object.day6;

import java.util.Random;

public class MyClassEx {

    private String[] galba;

    //getter
    public String[] getGalba(){
        return this.galba;
    }

    //setter
    public void setGalba(String[] galba){
        this.galba = galba;
    }


    public void getData(){
        System.out.println(String.format("0.%s\t 1.%s\t 2.%s", galba[0],galba[1],galba[2]));
    }


    public String select(int choice){
        
        String rs = "";
        
        if(choice == 0){
            rs=galba[0];
        }else if(choice==1){
            rs=galba[1];
        }else if(choice==2){
            rs=galba[2];
        }
        return rs;
    }

    public void random(int choice){
        int a = (int)Math.random()*3;
        if(choice ==0 && a == 1 ){
            System.out.println("내가 이겻당 ㅎ");
        }

    }

}
