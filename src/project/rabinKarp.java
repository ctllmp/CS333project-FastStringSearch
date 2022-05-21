package project;

public class rabinKarp implements algorithm {

    final String name = "Rabin-Karp Algorithm";

    @Override
    public void search(String pat, String text){
        int patLen = pat.length();
        int textLen = text.length();
        int i, j;
        int p = 0; // hash value for pat
        int t = 0; // hash value for text
        int h = 1;
        int q = 11; //any prime number
        //int d = textLen;
        boolean found = false;
        for (i = 0; i < patLen - 1; i++){
            h = (h * textLen) % q;
        }
        if(textLen>=patLen) { //to prevent errors while patLen>textLen
        //hash of pat and first patLength number of chars of text
            for (i = 0; i < patLen; i++) {
                p = (textLen * p + pat.charAt(i)) % q;
             t = (textLen * t + text.charAt(i)) % q;
            }

            for (i = 0; i <= textLen - patLen; i++) {
                if (p == t) {  //check pat chars on text one by one if hash values are equal
                    for (j = 0; j < patLen; j++) {
                        if (text.charAt(i + j) != pat.charAt(j))
                            break;
                    }
                    if (j == patLen) {
                        System.out.println(name + " found the pattern at index " + i);
                        found = true;
                    }
                }
                if (i < textLen - patLen) {
                    t = (textLen * (t - text.charAt(i) * h) + text.charAt(i + patLen)) % q;
                    if (t < 0)
                        t = (t + q);
                }
            }
        }
        if(!found){
            System.out.println(name+" couldn't find the pattern");
        }
    }

    @Override
    public String getName(){
        return name;
    }
}


