package file_handling.service;

import file_handling.manager.ConsoleManager;
import file_handling.manager.FileManager;
import file_handling.service.action.FileActions;

import java.io.File;
import java.util.Date;

public class FileService extends RunnableServiceAbstractImpl {

    private FileManager fileManager;

    public FileService() {
        fileManager = new FileManager();
    }

    public void run() {
        printTitle("File Service");

        String answer;

        do {
            ConsoleManager.getInstance().printLine();
            ConsoleManager.getInstance().printToConsole("Current path - " + fileManager.getCurrentPath(), true);
            answer = printMenu(FileActions.values());

            // handle the user action
            handleAction(answer);
        } while (!answer.equalsIgnoreCase(FileActions.EXIT.getValue())); // loop while until user wants to exit
    }

    protected void handleAction(String action) {
        if (action.equalsIgnoreCase(FileActions.LIST_FILES.getValue())) {
            listFiles();
        }

        if (action.equalsIgnoreCase(FileActions.CREATE_FILE.getValue())) {
            createFile();
        }

        if (action.equalsIgnoreCase(FileActions.CREATE_FOLDER.getValue())) {
            createFolder();
        }

        if (action.equalsIgnoreCase(FileActions.DELETE_FILE.getValue())) {
        	deleteAFile();
        }

        if (action.equalsIgnoreCase(FileActions.GO_IN_FOLDER.getValue())) {
            moveInto();
        }

        if (action.equalsIgnoreCase(FileActions.READ_TXT_FILE.getValue())) {
            readTxtFile();
        }

        if (action.equalsIgnoreCase(FileActions.COPY_FILE.getValue())) {
            copyFile();
        }

        if (action.equalsIgnoreCase(FileActions.READ_FILE_BENCHMARK.getValue())) {
            copyBenchmark();
        }

        if (action.equalsIgnoreCase(FileActions.HANDLE_PRIMITIVES.getValue())) {
            testPrimitives();
        }

        if (action.equalsIgnoreCase(FileActions.BACK_FOLDER.getValue())) {
        	back();
        }
    }

    private Integer listFiles() {
        printActionTitle("Files listing");

        int counter = 0;

        for (File file : fileManager.listFiles()) {
            ConsoleManager.getInstance().printToConsole(counter + " - " + file.getName(), true);

            counter++;
        }

        if(counter == 0) {
            ConsoleManager.getInstance().printToConsole("There's no file here", true);
        }

        return counter;
    }

    private Integer listFolders() {
        int counter = 0;

        for (File file : fileManager.listFiles()) {
            // test if its a folder
            if(!file.isFile()) {
                ConsoleManager.getInstance().printToConsole(counter + " - " + file.getName(), true);

                counter++;
            }
        }

        if(counter == 0) {
            ConsoleManager.getInstance().printToConsole("There's no folder here", true);
        }

        return counter;
    }

    private void createFile() {
        printActionTitle("File creation");

        ConsoleManager.getInstance().printToConsole("Type file name to create : ", true);

        ConsoleManager.getInstance().consoleLineBreak();

        String name = ConsoleManager.getInstance().readUserInput();
        File file = fileManager.createTxtFile(name);

        if (file == null) {
            ConsoleManager.getInstance().printToConsole("Une erreur est survenue lors de la création...", true);
        } else {
            ConsoleManager.getInstance().printToConsole("Fichier créé", true);
        }
    }

    private void createFolder() {
        printActionTitle("Folder creation");

        ConsoleManager.getInstance().printToConsole("Type folder name to create : ", true);

        String name = ConsoleManager.getInstance().readUserInput();
        fileManager.createFolder(name);

        ConsoleManager.getInstance().printToConsole("Dossier créé", true);
    }

    private void deleteAFile() {
        printActionTitle("File deletion");

        // list files for user to choose
        int nbFiles = listFiles();

        int answer;

        do {
            ConsoleManager.getInstance().printToConsole("Which file do you want to delete ? ", true);
            answer = ConsoleManager.getInstance().readUserInputInteger();
        } while(answer < 0 || answer >= nbFiles);

        fileManager.deleteFileFromList(answer);
    }

    private void back() {
		fileManager.backOneFolder();
	}

	private void moveInto() {
		printActionTitle("List Folders");

        // list folders for user to choose
        int nbFolders = listFolders();

        int answer;

        do {
            ConsoleManager.getInstance().printToConsole("Which folder do you want to enter ? ", true);
            answer = ConsoleManager.getInstance().readUserInputInteger();
        } while(answer < 0 || answer >= nbFolders);

        fileManager.enterFolder(answer);
	}

    private void printActionTitle(String title) {
        ConsoleManager.getInstance().printLine();
        ConsoleManager.getInstance().printToConsole(title, true);
        ConsoleManager.getInstance().printLine();
        ConsoleManager.getInstance().consoleLineBreak();
    }

    public void readTxtFile() {
        printActionTitle("Read txt file");

        // list files for user to choose
        int nbFiles = listFiles();

        int answer;

        do {
            ConsoleManager.getInstance().printToConsole("Which file do you want to read ? ", true);
            answer = ConsoleManager.getInstance().readUserInputInteger();
        } while(answer < 0 || answer >= nbFiles);

        fileManager.readTxtFile(answer);
    }

    public void copyFile() {
        printActionTitle("Copy file");

        // list files for user to choose
        int nbFiles = listFiles();

        int answer;

        do {
            ConsoleManager.getInstance().printToConsole("Which file do you want to read ? ", true);
            answer = ConsoleManager.getInstance().readUserInputInteger();
        } while(answer < 0 || answer >= nbFiles);

        fileManager.copyFile(answer);
    }

    private void copyBenchmark() {
        printActionTitle("Copy file");

        // list files for user to choose
        int nbFiles = listFiles();

        int answer;

        do {
            ConsoleManager.getInstance().printToConsole("Which file do you want to read ? ", true);
            answer = ConsoleManager.getInstance().readUserInputInteger();
        } while(answer < 0 || answer >= nbFiles);

        Date start = new Date();
        fileManager.copyFile(answer);
        Date end = new Date();

        long difference = (end.getTime() - start.getTime());
        ConsoleManager.getInstance().printToConsole("FIS - copy in "+ difference + "ms", true);

        start = new Date();
        fileManager.copyFileBufferedStream(answer);
        end = new Date();

        difference = (end.getTime() - start.getTime());
        ConsoleManager.getInstance().printToConsole("BIS - copy in "+ difference + "ms", true);
    }

    private void testPrimitives() {
        printActionTitle("Copy file");

        // list files for user to choose
        int nbFiles = listFiles();

        int answer;

        do {
            ConsoleManager.getInstance().printToConsole("Which file do you want to write & read from ? ", true);
            answer = ConsoleManager.getInstance().readUserInputInteger();
        } while(answer < 0 || answer >= nbFiles);

        fileManager.writePrimitives(answer);
        fileManager.readPrimitives(answer);
    }
}
