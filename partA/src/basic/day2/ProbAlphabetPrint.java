package basic.day2;

public class ProbAlphabetPrint {


    /*
     * ++ 연산자와 print()을 여러번 사용해서
     * A=Z 까지 출력하기.
     * char start = 'A';
     * 
     * Z=A
     */
    public static void main(String[] args) {
        
        char d = 65;

        for(int i =0; i<26; i++){
            
            System.out.print(d);
            d++;
           
            if(i == 25){
                for( int k= 0; k <1; k++){
                    System.out.println("\n");
                }
            }
        }
        char b = 90;
        for(int j = 0; j<26; j++){
            
            System.out.print(b);
            b--;
        }

    }
}
