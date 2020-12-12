package file_handling.service;

import file_handling.manager.ClubFileManager;
import file_handling.manager.ConsoleManager;
import file_handling.model.Club;
import file_handling.model.Member;
import file_handling.service.action.ActionConstants;
import file_handling.service.action.ClubActions;

import java.util.Date;
import java.util.List;

public class ClubService extends RunnableServiceAbstractImpl {

    private ClubFileManager fileManager;

    public ClubService() {
        this.fileManager = new ClubFileManager();
    }

    public void run() {
        printTitle("Club Service");

        String answer;

        do {
            answer = printMenu(ClubActions.values());

            handleAction(answer);
        } while (!answer.equalsIgnoreCase(ActionConstants.EXIT_ID));
    }

    protected void handleAction(String action) {
        if (action.equalsIgnoreCase(ClubActions.CREATE_CLUB.getValue())) {
            createClub();
        }

        if (action.equalsIgnoreCase(ClubActions.LIST_CLUBS.getValue())) {
            listClubs();
        }

        if (action.equalsIgnoreCase(ClubActions.LIST_MEMBERS.getValue())) {
            listMembers();
        }

        if (action.equalsIgnoreCase(ClubActions.ADD_MEMBER.getValue())) {
            addMember();
        }

        if (action.equalsIgnoreCase(ClubActions.DELETE_MEMBER.getValue())) {
            deleteMember();
        }
    }

    private void createClub() {
        printTitle("Create club");

        ConsoleManager.getInstance().printToConsole("Give a club id : ", false);
        Long id = ConsoleManager.getInstance().readUserInputLong();
        ConsoleManager.getInstance().printToConsole("Give a club name : ", false);
        String name = ConsoleManager.getInstance().readUserInput();

        Club club = new Club(id, name);
        String fileName = name.trim();

        fileManager.createClubFile(fileName);
        fileManager.writeClub(club);

        ConsoleManager.getInstance().printToConsole("Club created successfully", true);
    }

    private void deleteMember() {
        printTitle("Delete member");

        Club club = selectClub();

        if(club.getMembers() != null && club.getMembers().size() > 0) {
            printMembers(club.getMembers());
            int answer;

            do {
                ConsoleManager.getInstance().printToConsole("Which one to delete : ", false);
                answer = ConsoleManager.getInstance().readUserInputInteger();
            } while (answer < 0 || answer >= club.getMembers().size());

            club.removeMember(answer);

            fileManager.writeClub(club);

            ConsoleManager.getInstance().printToConsole("Member deleted successfully", true);
        } else {
            ConsoleManager.getInstance().printToConsole("Club has no members", true);
        }
    }

    private void addMember() {
        printTitle("Create member");

        Club club = selectClub();

        ConsoleManager.getInstance().printToConsole("Give a member first name : ", false);
        String firstName = ConsoleManager.getInstance().readUserInput();
        ConsoleManager.getInstance().printToConsole("Give a member last name : ", false);
        String lastName = ConsoleManager.getInstance().readUserInput();

        Member member = new Member(firstName, lastName, new Date());
        club.addMember(member);

        fileManager.writeClub(club);

        ConsoleManager.getInstance().printToConsole("Member created successfully", true);
    }

    private void listMembers() {

        Club club = selectClub();

        printTitle("List members");

        printMembers(club.getMembers());
    }

    private Club selectClub() {
        Club selectedClub = null;
        List<Club> clubs = listClubs();

        Long answer;
        Boolean rightAnswer = false;

        do {
            ConsoleManager.getInstance().printToConsole("Select club : ", false);
            answer = ConsoleManager.getInstance().readUserInputLong();

            for (Club club : clubs) {
                if(club.getId().equals(answer)) {
                    rightAnswer = true;
                    break;
                }
            }
        } while (!rightAnswer);

        for (Club club : clubs) {
            if(club.getId().equals(answer)) {
                selectedClub = club;
                break;
            }
        }

        return selectedClub;
    }

    private void printMembers(List<Member> members) {
        if (members != null) {
            int counter = 0;

            for (Member member : members) {
                ConsoleManager.getInstance().printToConsole(counter + " - " +member.toString(), true);
                counter++;
            }
        } else {
            ConsoleManager.getInstance().printToConsole("Club has no member", true);
        }
    }

    private List<Club> listClubs() {
        printTitle("List clubs");
        List<Club> clubs = fileManager.listClubs();

        for (Club club : clubs) {
            ConsoleManager.getInstance().printToConsole(club.toString(), true);
        }

        return clubs;
    }

}
