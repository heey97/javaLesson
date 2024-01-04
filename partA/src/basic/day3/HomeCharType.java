package basic.day3;

public class HomeCharType {
    public static void main(String[] args) {
        //1) 문자열을 임의로 저장 : "Hello" Java Hi" Linux~~~"
        //2) 1)번의 문자열을 구성하는 문자 하나하나가 '대문자','소문자','숫자','기호' 중 어떤 종류의 문자인지 검사합니다.
        /*변수명 대문자의 갯수 upperCount,
         *       소문자의 갯수 lowerCount,
         *       숫자의 갯수 numberCount,
         *       기호의 갯수 symbolCount
         * 
         * 출력 예시:
         * --------------------------------
         * 문자열: Hello* Java Hi* Linux~~~
         * 문자종류 : 대문자 4개, 소문자 12개, 숫자 0개, 기호 8개
         */
        String message = ("Hello\" Java Hi\" Linux~~~");

        int upperCount = 0;
        int lowerCount = 0;
        int numberCount = 0;
        int symbolCount = 0;
        char temp;
    
        for(int i=0; i<message.length(); i++){
             temp = message.charAt(i);
            
            if( Character.isUpperCase(temp)== true ){
                upperCount++;
            }else if(Character.isLowerCase(temp)== true){
                lowerCount++;
            }else if(Character.isDigit(temp)== true){
                numberCount++;
            }else{
                symbolCount++;
            }
        }
        System.out.println("upper : "+upperCount);
        System.out.println("lower : "+lowerCount);
        System.out.println("number : "+numberCount);
        System.out.println("symbol : "+symbolCount);
    }
}
