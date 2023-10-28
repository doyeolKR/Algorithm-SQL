import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        List<Character> list = new LinkedList<>();

        for(int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        ListIterator<Character> iterator = list.listIterator();

        while(iterator.hasNext()) {
            iterator.next();
        }

        for(int i = 0; i < N; i++) {
            String commandLine = br.readLine();
            char command = commandLine.charAt(0);

            switch(command) {
                case 'L' :
                    if(iterator.hasPrevious()) iterator.previous();
                    break;
                case 'D' :
                    if(iterator.hasNext()) iterator.next();
                    break;
                case 'B' :
                    if(iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case 'P' :
                    iterator.add(commandLine.charAt(2));
                    break;
            }
        }

        for(char c : list) {
            bw.write(c);
        }

        bw.flush();
        bw.close();

    }
}
