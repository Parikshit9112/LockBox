package views;

import dao.DataDAO;
import model.Data;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserView {
    private String email;
    private String name;

    UserView(String email,String name) {
        this.email = email;
        this.name=name;
    }

    public void home() {
        do {
            System.out.println("Wlcome " + this.name);
            System.out.println("Press 1 to show hidden files");
            System.out.println("Press 2 to hide a new file");
            System.out.println("Press 3 to unhide a file");
            System.out.println("Press 4 to exit");
            Scanner sc = new Scanner(System.in);
            int ch = Integer.parseInt(sc.nextLine());
            switch (ch) {
                case 1 :  try {
                                List<Data> files = DataDAO.getAllFiles(this.email);
                                
                                if(files.isEmpty()) 
                                    System.out.println("Empty!! No hidden file is present");
                                else{
                                    System.out.println("ID       File Name");
                                for (Data file : files) {
                                    System.out.println(file.getId() + "  -     " + file.getFileName());
                                }}
                            } catch (SQLException e) {
                                e.printStackTrace();
                            } 
                            break;
                
                case 2 :    System.out.println("Enter the file path");
                            String path = sc.nextLine();
                            File f = new File(path);
                            Data file = new Data(0, f.getName(), path, this.email);
                            try {
                                if(DataDAO.hideFile(file)!=0)
                                    System.out.println("Successfully Hidden");
                            } catch (SQLException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                              e.printStackTrace();
                            }
                            break;
                case 3 :    List<Data> files = null;
                            try {
                            files = DataDAO.getAllFiles(this.email);
                            System.out.println("ID - File Name");
                            for (Data File : files) {
                                System.out.println(File.getId() + " - " + File.getFileName());
                            }
                            System.out.println("Enter the id of file to unhide");
                            int id = Integer.parseInt(sc.nextLine());
                            boolean isValidID = false;
                            for (Data File : files) {
                                if (File.getId() == id) {
                                isValidID = true;
                                break;
                                }
                            }
                            if (isValidID) {
                                DataDAO.unhide(id);
                            } else {
                                System.out.println("Wrong ID");
                            }
                            } catch (SQLException  e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                
                case 4  :   System.exit(0);
                            break;
                 }
            } while (true);
    }
}
