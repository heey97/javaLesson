package collection.myapp;

public class JavaWord {
    private String english;
    private String korean;
    private int level;

    public JavaWord(String english, String korean, int level){
        this.english = english;
        this.korean = korean;
        this.level = level;
    }

    @Override
    public String toString() {
        return "JavaWord [english=" + english + ", korean=" + korean + ", level=" + level + "]";
    }

    public String getEnglish() {
        return english;
    }

    public String getKorean() {
        return korean;
    }

    public int getLevel() {
        return level;
    }
    
    
}
