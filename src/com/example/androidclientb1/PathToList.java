package com.example.androidclientb1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 11/17/13
 * Time: 7:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class PathToList<T> {


    public  List<T> ret(String path){

        List<T> list = null;

        String tal = HttpUtil.getInputStreamFromUrl("http://app-bares.herokuapp.com/"+path);

        Gson gson = new Gson();

        TypeToken<List<T>> token = new TypeToken<List<T>>(){};
        List<T> personList = gson.fromJson(tal, token.getType());

        return personList;
    }



}
