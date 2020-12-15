package file_handling.service.action;

public enum MenuActions implements ServiceAction {

    FILE_SERVICE("1", "Launch File Service"),
    CLUB_SERVICE("2", "Launch Club Service"),
    EXIT(ActionConstants.EXIT_ID, ActionConstants.EXIT_ACTION);

    private String value;
    private String title;

    MenuActions(String value, String title) {
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
        MenuActions[] actions = MenuActions.values();

        for (MenuActions action : actions) {
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
