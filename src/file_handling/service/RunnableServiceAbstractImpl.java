package file_handling.service;

import file_handling.manager.ConsoleManager;
import file_handling.service.action.FileActions;
import file_handling.service.action.RunnableService;
import file_handling.service.action.ServiceAction;

public abstract class RunnableServiceAbstractImpl implements RunnableService {

    /**
     * Print the title
     *
     * @param title the title to print
     */
    protected void printTitle(String title) {
        ConsoleManager.getInstance().consoleLineBreak();
        ConsoleManager.getInstance().printLine();
        ConsoleManager.getInstance().printToConsole(title, true);
        ConsoleManager.getInstance().printLine();
        ConsoleManager.getInstance().consoleLineBreak();
    }

    /**
     * Print the menu
     *
     * @return the action answer number
     */
    protected String printMenu(ServiceAction[] actions) {
        boolean rightAnswer = false;
        String answer = "";

        do {
            // print the option menu
            ConsoleManager.getInstance().printLine();
            ConsoleManager.getInstance().consoleLineBreak();

            for (ServiceAction action : actions) {
                ConsoleManager.getInstance().printToConsole(action.toString(), true);
            }

            ConsoleManager.getInstance().printToConsole("What do you want to do : ", false);

            // ask user answer
            answer = ConsoleManager.getInstance().readUserInput();

            if (FileActions.containsAction(answer)) {
                rightAnswer = true;
            }
        } while (!rightAnswer);

        return answer;
    }

}
