package file_handling.manager;

import file_handling.model.Club;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ClubFileManager {

    private final String clubPath = "\\test\\clubs\\";

    public void writeClub(Club club) {
        File file = new File(clubPath + constructFileName(club.getName()));

        try (FileOutputStream fis = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fis)) {

            oos.writeObject(club);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Club> listClubs() {
        File clubFolder = new File(clubPath);

        File[] clubFiles = clubFolder.listFiles();

        List<Club> clubs = new LinkedList<>();

        for (File clubFile : clubFiles) {
            try (FileInputStream fis = new FileInputStream(clubFile);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {

                Club club = (Club) ois.readObject();

                clubs.add(club);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return clubs;
    }

    public File createClubFile(String name) {
        File file = new File(clubPath + constructFileName(name));

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    private String constructFileName(String name) {
        return name.trim().toLowerCase().replaceAll(" ", "-");
    }
}
