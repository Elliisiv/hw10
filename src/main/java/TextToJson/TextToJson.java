package TextToJson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;

class TextToJson {
    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        BufferedReader reader = new BufferedReader(new FileReader("./files/file.txt"));
        String str;
        ArrayList<String> textUsers = new ArrayList<>();
        while((str = reader.readLine()) != null ){
            if(!str.isEmpty()){
                textUsers.add(str);
            }}

        User[] users = new User[] { new User(textUsers.get(1).split(" ")[0], Integer.valueOf(textUsers.get(1).split(" ")[1])), new User(textUsers.get(2).split(" ")[0],Integer.valueOf(textUsers.get(2).split(" ")[1])) };

        try (PrintWriter out = new PrintWriter(new FileWriter("./files/user.json"))) {
            String s = gson.toJson(users);
            out.write(s);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}