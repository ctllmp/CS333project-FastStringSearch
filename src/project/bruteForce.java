package project;

public class bruteForce implements algorithm {
    String name = "Brute Force Algorithm";

    @Override
    public void search(String pat, String text){
        int textLen = text.length();
        int patLen = pat.length();
        boolean found = false;
        int i;
        for(i = 0; i < textLen - patLen + 1; i++) {
            int j;
            for (j = 0; j < patLen; j++) {
                if (text.charAt(i + j) != pat.charAt(j))
                    break;
            }
            if (j == patLen) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println(name+" found the pattern at index: " + i);
        } else {
            System.out.println(name+" couldn't find the pattern");
        }
    }
    @Override
    public String getName(){
        return name;
    }
}

