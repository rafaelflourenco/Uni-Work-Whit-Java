import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
public class Client {
    static final String TOTIME = "asTime";
    static final String TOSECS = "asSeconds";
    static final String ADDTIME = "add";
    static public void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String aString = sc.nextLine();
        String operator = sc.nextLine();
        String output="";
        T2time receiver;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        switch (operator) {
            case TOTIME:
                receiver = new T2time(Integer.parseInt(aString));
                output = receiver.toString();
                break;
            case TOSECS:
                String[] timeComponents = aString.split(":");
                int hours = Integer.parseInt(timeComponents[0]);
                int minutes = Integer.parseInt(timeComponents[1]);
                int seconds = Integer.parseInt(timeComponents[2]);
                receiver = new T2time(hours,minutes,seconds);
                output = "" + receiver.asSeconds();
                break;
            case ADDTIME:
                if(aString.length() == 8) {
                    String[] timeComponents2 = aString.split(":");
                    int hours2 = Integer.parseInt(timeComponents2[0]);
                    int minutes2 = Integer.parseInt(timeComponents2[1]);
                    int seconds2 = Integer.parseInt(timeComponents2[2]);
                    receiver = new T2time(hours2, minutes2, seconds2);
                }
                else receiver = new T2time(Integer.parseInt(aString));

                T2time argument;
                String bString = sc.nextLine();
                if(bString.length() == 8) {
                    String[] timeComponents3 = bString.split(":");
                    int hours3 = Integer.parseInt(timeComponents3[0]);
                    int minutes3 = Integer.parseInt(timeComponents3[1]);
                    int seconds3 = Integer.parseInt(timeComponents3[2]);
                    argument = new T2time(hours3, minutes3, seconds3);
                }
                else argument = new T2time(Integer.parseInt(bString));
                output = receiver.add(argument).toString();
                break;
            default:
//Seems right to have a default statement ...
        }
        System.out.println(output);
    }
}
