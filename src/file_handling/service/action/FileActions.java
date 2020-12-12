package file_handling.service.action;

public enum FileActions implements ServiceAction {

    LIST_FILES("1", "List files"),
    CREATE_FILE("2", "Create a file"),
    CREATE_FOLDER("3", "Create a folder"),
    EDIT_FILE("4", "Edit a file"),
    DELETE_FILE("5", "Delete a file"),
    GO_IN_FOLDER("6", "Go into folder"),
    BACK_FOLDER("7", "Move back one folder"),
    READ_TXT_FILE("8", "Read a txt file"),
    COPY_FILE("9", "Copy a file"),
    READ_FILE_BENCHMARK("10", "Copy benchmark"),
    HANDLE_PRIMITIVES("11", "Test primitives (Data*Stream)"),
    EXIT(ActionConstants.EXIT_ID, ActionConstants.EXIT_ACTION);

    private String value;
    private String title;

    FileActions(String value, String title) {
        this.title = title;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    public static boolean containsAction(String value) {
        FileActions[] actions = FileActions.values();

        for (FileActions action : actions) {
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
