import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static char[] vowel = {'a','e','i','o','u'};
    public static String password;

    /*
        모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
        모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
        같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
    */

    public static boolean isVowel() {
        char[] passwordCharArray = password.toCharArray();

        for(int i = 0; i < vowel.length; i++) {
            for(int j = 0; j < passwordCharArray.length; j++) {
                if(vowel[i] == passwordCharArray[j])
                    return true;
            }
        }
        return false;
    }

    public static boolean isTriple() {
        String copyPassword = password;

        copyPassword = copyPassword.replaceAll("[eiou]","a");
        copyPassword = copyPassword.replaceAll("[^aeiou]","b");

        char[] copyPasswordCharArray = copyPassword.toCharArray();
        int cnt = 0;

        for(int i = 1; i < copyPasswordCharArray.length; i++) {
            if(copyPasswordCharArray[i-1] == copyPasswordCharArray[i]) cnt++;
            else cnt = 0;

            if(cnt == 2)
                return false;
        }
        return true;
    }

    public static boolean isSameDouble() {
        String copyPassword = password;

        copyPassword = copyPassword.replaceAll("ee","A");
        copyPassword = copyPassword.replaceAll("oo","B");

        char[] copyPasswordCharArray = copyPassword.toCharArray();
        int cnt = 0;

        for(int i = 1; i < copyPasswordCharArray.length; i++) {
            if(copyPasswordCharArray[i - 1] == copyPasswordCharArray[i]) cnt++;
            else cnt = 0;

            if(cnt == 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            password = br.readLine();

            if(password.equals("end"))
                break;

            if(isVowel() && isTriple() && isSameDouble()) {
                sb.append("<").append(password).append(">").append(" is acceptable.").append("\n");
            } else {
                sb.append("<").append(password).append(">").append(" is not acceptable.").append("\n");
            }
        }

        System.out.println(sb);

    }
}