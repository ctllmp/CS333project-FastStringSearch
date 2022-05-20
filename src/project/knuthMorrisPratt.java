package project;

public class knuthMorrisPratt implements algorithm {

    final String name = "Knuth-Morris-Pratt Algorithm";

    @Override
    public void search(String pat, String text){
        int patLen = pat.length();
        int textLen = text.length();

        int[] longest = new int[patLen];
        int j = 0; // index for pat[]

        boolean found =false;

        // Preprocessing the pattern
        preprocess(pat, patLen, longest);

        int i = 0;
        while (i < textLen) {
            if (pat.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == patLen) {
                System.out.println(name+" found the pattern at index " + (i - j));
                found = true;
                j = longest[j - 1];
            }

            else if (i < textLen && pat.charAt(j) != text.charAt(i)) {
                if (j != 0)
                    j = longest[j - 1];
                else
                    i = i + 1;
            }
        }
        if(patLen==0 && textLen==0){ //empty search
            System.out.println(name+" found the pattern at index 0");
            found=true;
        }
        if(!found){
            System.out.println(name+" couldn't find the pattern");
        }
    }
    public void preprocess(String pat, int patLen, int[] longest){
        int len = 0;
        int i = 1;
        if(patLen>0){
            longest[0] = 0; // longest[0] is always 0
        }
        //calculates longest[i] for i = 1 to patLen-1
        while (i < patLen) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                longest[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = longest[len - 1];
                }
                else {
                    longest[i] = len;
                    i++;
                }
            }
        }
    }
    @Override
    public String getName(){
        return name;
    }
}


