package file_handling.manager;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class FileManager {

	private String currentPath;
	private StringBuilder sb;

	public FileManager() {
		currentPath = "\\test\\";
		this.sb = new StringBuilder();
	}

	/**
	 * Listing folder files
	 * 
	 * @return
	 */
	public List<File> listFiles() {
		File currentFolder = new File(currentPath);

		File[] files = currentFolder.listFiles();

		return files != null ? Arrays.asList(files) : new LinkedList<>();
	}

	/**
	 * Listing folder files
	 * 
	 * @return
	 */
	public void deleteFileFromList(int index) {
		File currentFolder = new File(currentPath);

		currentFolder.listFiles()[index].delete();
	}

	/**
	 * Create a .txt file
	 * 
	 * @param name the name of the file to create (with no extension)
	 * @return
	 */
	public File createTxtFile(String name) {
		File file = new File(currentPath + name + ".txt");

		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file;
	}


	/**
	 * Move the path to a folder
	 * 
	 * @param index of the folder to move into
	 */
	public void enterFolder(int index) {
		File currentFolder = new File(currentPath);
		List<File> folders = new LinkedList<>();

		for (File file : currentFolder.listFiles()) {
			if (!file.isFile()) {
				folders.add(file);
			}
		}

		currentPath += folders.get(index).getName() + "\\";
	}

	/**
	 * Go back one folder from the current path
	 */
	public void backOneFolder() {
		List<String> paths = Arrays.asList(currentPath.split(Pattern.quote("\\")));

		if(paths.size() > 0) {
			ConsoleManager.getInstance().printToConsole(""+paths.size(), true);
			paths = paths.subList(0, paths.size() - 1);

			currentPath = String.join("\\", paths);
			currentPath += "\\";
		}

		if (currentPath.isEmpty()) {
			currentPath = "\\";
		}
	}

	public void createFolder(String name) {
		File file = new File(currentPath + name);

		file.mkdir();
	}


	/**
	 * Get the current path
	 *
	 * @return
	 */
	public String getCurrentPath() {
		return currentPath;
	}

	public void readTxtFile(int index) {
		File currentFolder = new File(currentPath);

		File file = currentFolder.listFiles()[index];

		try(FileInputStream fis = new FileInputStream(file)) {
			int data;
			String content = "";

			while((data = fis.read()) >= 0) {
				char character = (char) data;
				content += character;
			}

			ConsoleManager.getInstance().printToConsole(content, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void copyFile(int index) {
		File currentFolder = new File(currentPath);

		File fileToRead = currentFolder.listFiles()[index];
		File fileCopy = new File(fileToRead.getParentFile().getAbsolutePath()+"\\copy_"+fileToRead.getName());

		ConsoleManager.getInstance().printToConsole(fileCopy.getAbsolutePath(), true);

		try(FileInputStream fis = new FileInputStream(fileToRead);
			FileOutputStream fos = new FileOutputStream(fileCopy)) {

			int data = 0;
			String content = "";

			while((data = fis.read()) >= 0) {
				char character = (char) data;
				fos.write(data);
				content += character;
			}

			fos.flush();

			ConsoleManager.getInstance().printToConsole(content, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
