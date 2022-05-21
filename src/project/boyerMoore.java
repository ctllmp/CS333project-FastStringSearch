package project;

public class boyerMoore implements algorithm {

    String name = "Boyer Moore Algorithm";

    @Override
    public void search(String pat, String text){
        int patLen = pat.length();
        int textLen = text.length();
        final int NO_OF_CHARS = 256;
        boolean found = false;
        int[] badChar= new int[NO_OF_CHARS];
        preprocessing(pat, patLen, badChar);
        int s = 0;

        while(s <= (textLen - patLen)) {
            int j = patLen-1;
            while(j >= 0 && pat.charAt(j) == text.charAt(s+j)){
                j--;
            }
            if (j < 0) {
                found = true;
                System.out.println(name + " found the pattern at index = " + s);
                s += (s + patLen < textLen) ? patLen - badChar[text.charAt(s + patLen)] : 1;
            }else {
                s += Math.max(1, j - badChar[text.charAt(s + j)]);
            }
        }
        if(!found){
            System.out.println(name+" couldn't find the pattern");
        }
    }
    public void preprocessing(String pat, int patLen, int[] badChar){
        for (int i = 0; i < badChar.length; i++)
            badChar[i] = -1;

        for (int i = 0; i < patLen; i++)
            badChar[pat.charAt(i)] = i;
    }
    @Override
    public String getName(){
        return name;
    }
}
