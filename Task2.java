package Module10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Task2 {
    {
        LinkedList<User> users = new LinkedList<User>();
        try
        {
            FileInputStream fis = new FileInputStream("users.txt");
            Scanner sc=new Scanner(fis);
            sc.nextLine();
            while(sc.hasNextLine())
            {
                String s = sc.nextLine();
                String[] arr = s.strip().split(" ");
                User user = new User(arr[0], Integer.parseInt(arr[1]));
                users.add(user);
            }
            sc.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);
        System.out.println(json);

        File file = new File("user.json");
        try (FileWriter writer = new FileWriter(file))
        {
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private class User {
        private String name;
        private int age;

        public User(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
