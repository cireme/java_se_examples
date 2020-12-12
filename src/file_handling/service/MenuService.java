package file_handling.service;

import file_handling.service.action.ActionConstants;
import file_handling.service.action.MenuActions;

public class MenuService extends RunnableServiceAbstractImpl {

    public void run() {
        printTitle("Menu Service");

        String answer;

        do {
            answer = printMenu(MenuActions.values());

            // handle the user action
            handleAction(answer);
        } while (!answer.equalsIgnoreCase(ActionConstants.EXIT_ID)); // loop while until user wants to exit
    }

    protected void handleAction(String action) {
        if (action.equalsIgnoreCase(MenuActions.FILE_SERVICE.getValue())) {
            new FileService().run();
        }

        if (action.equalsIgnoreCase(MenuActions.CLUB_SERVICE.getValue())) {
            new ClubService().run();
        }
    }

}
