/**
 *
 */
package file_handling;

import file_handling.manager.ConsoleManager;
import file_handling.model.Club;
import file_handling.model.Member;

import java.util.Date;

/**
 * @author EmericStophe
 *
 */
public class FileApplication {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
//        ConsoleManager.getInstance().printToConsole(FileApplication.class.getName() + " - Start", true);
//        ConsoleManager.getInstance().consoleLineBreak();
//
//        // launch the menu service
//        new MenuService().run();
//
//        ConsoleManager.getInstance().consoleLineBreak();
//        ConsoleManager.getInstance().printToConsole(FileApplication.class.getName() + " - End", true);
//
//        ConsoleManager.getInstance().closeScanner();

        Member member = new Member(1L, "emeric", "stophe", new Date());
        Member member2 = new Member(1L, "emeric", "stophe", new Date());

        Object obj = new Member(1L, "emeric", "stophe", new Date());
        Object obj2 = new Club(1L, "Olympique de Marseille");

        Club club = new Club(1L, "Olympique de Marseille");

        ConsoleManager.getInstance().printToConsole("" + member.equals(member2), true);
        ConsoleManager.getInstance().printToConsole("" + member.equals(obj), true);
        ConsoleManager.getInstance().printToConsole("" + member.equals("club"), true);

    }

}
