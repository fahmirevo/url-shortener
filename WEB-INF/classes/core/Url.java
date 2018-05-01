package core;

import java.io.Serializable;
import java.util.*;

public class Url
{
    long id;
    private String real;
    private String shortened;
    private String password;

    public Url(String real){
        this.real = real;
        this.password = "";
    }

    public Url(long id, String real){
        this.id = id;
        this.real = real;
        this.shortened = null;
        this.password = "";
    }

    public Url(long id, String real, String shortened){
        this.id = id;
        this.real = real;
        this.shortened = shortened;
        this.password = "";
    }

    public Url(long id, String real, String shortened, String password){
        this.id = id;
        this.real = real;
        this.shortened = shortened;
        this.password = password;
    }
    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getReal(){
        return this.real;
    }

    public void setReal(String real){
        this.real = real;
    }

    public String getShortened(){
        return this.shortened;
    }

    public void setCode(String shortened){
        this.shortened = shortened;
    }

    public void shorten(){
        ArrayList<Character> arr = new ArrayList<Character>();
        long num = this.id + (long)(Math.pow(62.0, 3.0));
        char remainder;

        while(num > 0){
            remainder = (char)(num % 62);

            if(remainder <= 9){
                remainder += 48;
            }else if(remainder <= 35){
                remainder += 55;
            }else{
                remainder += 61;
            }

            arr.add(remainder);
            num /= 62;
        }

        Collections.reverse(arr);
        StringBuilder builder = new StringBuilder(arr.size());

        for(Character ch: arr)
        {
            builder.append(ch);
        }

        this.shortened = builder.toString();
    }
}

