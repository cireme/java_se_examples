package file_handling.service.action;

public enum ClubActions implements ServiceAction {

    CREATE_CLUB("1", "Create club"),
    LIST_CLUBS("2", "List clubs"),
    LIST_MEMBERS("3", "List club members"),
    ADD_MEMBER("4", "Create a member"),
    DELETE_MEMBER("5", "Delete a member"),
    EXIT(ActionConstants.EXIT_ID, ActionConstants.EXIT_ACTION);

    private String value;
    private String title;

    ClubActions(String value, String title) {
        this.value = value;
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    public static boolean containsAction(String value) {
        ClubActions[] actions = ClubActions.values();

        for (ClubActions action : actions) {
            if (action.getValue().equalsIgnoreCase(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return value + " - " + title;
    }
}
