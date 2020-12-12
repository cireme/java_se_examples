/**
 *
 */
package file_handling;

import file_handling.manager.ConsoleManager;
import file_handling.service.FileService;
import file_handling.service.MenuService;

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
        ConsoleManager.getInstance().printToConsole(FileApplication.class.getName() + " - Start", true);
        ConsoleManager.getInstance().consoleLineBreak();

        // launch the menu service
        new MenuService().run();

        ConsoleManager.getInstance().consoleLineBreak();
        ConsoleManager.getInstance().printToConsole(FileApplication.class.getName() + " - End", true);

        ConsoleManager.getInstance().closeScanner();
    }

}
