package com.example.loginconcept;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class login {
    private String username;
    private String password;

    public login(String username,String password) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String encryptlvl1(String input) {
        ArrayList<Integer> encryptedpassword = new ArrayList<>();
        String str = input.toUpperCase();
        for (char ch : str.toCharArray()) {
            if(Character.isDigit(ch)) {
                int number = ch;
                encryptedpassword.add(number);
            } else {
                int number = ch - 'A' + 1;
                encryptedpassword.add(number);
            }
        }

        Random rand = new Random();
        int x = rand.nextInt(2,8);
        encryptedpassword.add(x);
        int key = encryptedpassword.get(encryptedpassword.size() - 1);

        String fullEncryption = encryptlvl2(encryptedpassword,key);


        return fullEncryption;
    }

    public String encryptlvl2(ArrayList<Integer> encrypt1, int key) {
        ArrayList<Integer> mult = new ArrayList<>();
        System.out.println(key);
        for(int x:encrypt1) {
            int newnum = x * key;
            newnum = newnum % 26; //Number of Letters in alphabet
            mult.add(newnum);
        }
        Object[] multAsArray = mult.toArray();
        String fullEncryption = "";
        for(int y = 0; y < mult.size(); y = y + 2) {
            if(y + 1 < mult.size()-1) {
                int temp = (int)(multAsArray[y]);
                multAsArray[y] = multAsArray[y + 1];
                multAsArray[y + 1]  = temp;
            }

        }
        int x = mult.size() - 1;
        for(int y = 0; y < (mult.size()-1)/2; y++) {
            if(y + 1 < mult.size()-1) {
                int temp = (int) (multAsArray[y]);
                multAsArray[y] = multAsArray[x];
                multAsArray[x] = temp;
                x--;
            }
        }
        StringBuilder str = new StringBuilder();

        for(Object j : multAsArray) {
            str.append(j);
        }

        fullEncryption = str.toString();

        return fullEncryption;
    }
}

