package org.example;

import org.example.Finder.Finder;
import org.example.types.TYPES;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Boolean isMock = true;
        String searchText = "bc";
        String criticality_level = "3";
        TYPES type = TYPES.OBJECT;
        Address address = new Address();
        JSONArray list;
        if (isMock) {
            list = (JSONArray) address.getMock().get("models");
        } else {
            address.requestApi();
            list = (JSONArray) address.getResponse().get("models");
        }
        list = uniq(list, "url");
        if (type == TYPES.LIST) {
            //.withCustomParams(searchText, "url")
            JSONArray findResult = new Finder().withCustomParams(criticality_level, "criticality_level").buildToList(list);
            if (!findResult.isEmpty()) {
                System.out.println("---Found---size:" + findResult.length());
                int ac = 0;
                for (Object i : findResult) {
                    ac++;
                    System.out.println("-------------" + ac + "-------------");
                    System.out.println(ac + "-criticality_level:" + ((JSONObject) i).get("criticality_level"));
                    System.out.println(ac + "-url:" + ((JSONObject) i).get("url"));
                }
            } else {
                System.out.println("---Not-Found--in:" + searchText + "--");
            }
        } else {
            JSONObject findResult = new Finder().withCustomParams(searchText, "url").withCustomParams(criticality_level, "criticality_level").build(list);
            if (findResult != null) {
                System.out.println(findResult);
            } else {
                System.out.println("---Not-Found--in:" + searchText + "--");
            }
        }

//        JSONObject isFind=(JSONObject) address.findObject("basvuruformudenizarap.com");
//        if(!isFind.isEmpty()){
//            System.out.println("found: criticality_level:"+ isFind.get("criticality_level"));
//            System.out.println("found: id:"+ isFind.get("id"));
//        }
        //Find find = new Find.Builder()
        //       .withId(1)
        //      .withUrl("t-teknosa.com")
        //     .withDate("2023-04-26")
        //     .withCriticalityLevel(4)
        //    .build();

        // System.out.println("Arama sonucu: " + find.toString());

    }

    public static JSONArray uniq(JSONArray list, String keyName) {
        JSONArray listFiltered = new JSONArray();
        ArrayList<String> tmpCache = new ArrayList<String>();
        list.forEach(i -> {
            String key = ((JSONObject) i).get(keyName).toString();
            if (tmpCache.isEmpty() || !tmpCache.stream().anyMatch(x -> x.equals(key))) {
                tmpCache.add(key);
                listFiltered.put(i);
            }
        });
        return listFiltered;
    }
}