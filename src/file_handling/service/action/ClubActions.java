package file_handling.service.action;

public enum ClubActions implements ServiceAction {

    LIST_CLUBS("1", "List clubs"),
    LIST_MEMBERS("2", "List club members"),
    ADD_MEMBER("3", "Create a member"),
    DELETE_MEMBER("4", "Delete a member"),
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
