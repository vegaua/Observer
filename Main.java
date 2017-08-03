import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * Created by alex on 03.08.2017.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("sHelper started");
        System.out.println(new Date());
        int iterationsNumber = Integer.parseInt(args[0]);
        System.out.println("Number of iterations: " + iterationsNumber + "\n");

        startHotKeyScript(iterationsNumber);

        System.out.println("\nSuccessfully finished after " + iterationsNumber);
    }

    private static void moveTo(int iterationNumber) {
        for (int iteration = 0; iteration < iterationNumber; iteration++) {
            int x = new Random().ints(0, 10000).findFirst().getAsInt();
            int y = new Random().ints(0, 5000).findFirst().getAsInt();

            try {
                Thread.sleep(4000);
                System.out.println("iteration " + (iteration + 1));
                Runtime.getRuntime().exec("sHelper.bat moveTo " + x + "x" + y);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void scroll(int iterationNumber) {
        for (int iteration = 0; iteration < iterationNumber; iteration++) {
            try {
                Thread.sleep(4000);
                System.out.println("iteration " + (iteration + 1));
                if (iteration % 2 == 0) {
                    Runtime.getRuntime().exec("sHelper.bat ScrollDown 200");
                }
                Runtime.getRuntime().exec("sHelper.bat ScrollUp 200");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void startHotKeyScript(int iterationNumber) {
        for (int iteration = 0; iteration < iterationNumber; iteration++) {
            try {
                Thread.sleep(30000);
                System.out.println("iteration " + (iteration + 1));

                String ahkPath = "C:\\Program Files\\AutoHotkey\\AutoHotkey.exe";
                String scriptPath = "c:\\Users\\alex\\Downloads\\sHelper\\out\\artifacts\\sHelper_jar\\AutoHotkeyScript.ahk";
                Runtime.getRuntime().exec(new String[] { ahkPath, scriptPath, ""} );

//                Runtime.getRuntime().exec("c:\\Users\\alex\\Downloads\\sHelper\\out\\artifacts\\sHelper_jar\\AutoHotkeyScript.ahk",
//                        null, new File("c:\\Users\\alex\\Downloads\\sHelper\\out\\artifacts\\sHelper_jar\\"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
