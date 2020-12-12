package file_handling.service;

import file_handling.service.action.ActionConstants;
import file_handling.service.action.ClubActions;

public class ClubService extends RunnableServiceAbstractImpl {

    public void run() {
        printTitle("Club Service");

        String answer;

        do {
            answer = printMenu(ClubActions.values());

            // handle the user action
            handleAction(answer);
        } while (!answer.equalsIgnoreCase(ActionConstants.EXIT_ID)); // loop while until user wants to exit
    }

    protected void handleAction(String action) {
        if (action.equalsIgnoreCase(ClubActions.LIST_CLUBS.getValue())) {

        }

        if (action.equalsIgnoreCase(ClubActions.LIST_MEMBERS.getValue())) {

        }

        if (action.equalsIgnoreCase(ClubActions.ADD_MEMBER.getValue())) {

        }

        if (action.equalsIgnoreCase(ClubActions.DELETE_MEMBER.getValue())) {

        }
    }

}
