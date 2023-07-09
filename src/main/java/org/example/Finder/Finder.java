package org.example.Finder;

import org.example.types.TYPES;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Finder {
    int id;
    String text;
    List<FinderObj> searchParams = new ArrayList<>();
    private TYPES resultType = TYPES.OBJECT;


    public void withId(int id) {
        this.id = id;
    }

    public void withString(String text) {
        this.text = text;
    }

    public Finder withCustomParams(String text, String key) {
        this.searchParams.add(new FinderObj(text, key));
        return this;
    }

    public void printSearchParams() {
        this.searchParams.forEach((i) -> {
            System.out.println("key:" + i.key + " :" + i.text);
        });
    }

    public JSONObject findEquals(JSONObject temp) {
        JSONObject foundObject = null;
        if (!this.searchParams.isEmpty() && temp != null) {
            Boolean isTrue = this.searchParams.stream().allMatch(x -> temp.get(x.key).toString().contains(x.text));
            if (isTrue) {
                foundObject = temp;
            }
        } else if (!this.text.isEmpty()) {
            if (this.text.contains(temp.get("url").toString())) {
                foundObject = temp;
            }
        }
        return foundObject;
    }

    public JSONObject build(JSONArray listArray) {
        this.printSearchParams();
        JSONObject foundObject = null;
        for (Object line1 : listArray) {
            JSONObject temp = (JSONObject) line1;
            if (!this.searchParams.isEmpty()) {
                JSONObject findTmp = findEquals(temp);
                if (findTmp != null) {
                    foundObject = findTmp;
                }
            } else if (!this.text.isEmpty()) {
                if (this.text.contains(temp.get("url").toString())) {
                    foundObject = temp;
                }
            }
        }
        return foundObject;
    }

    public JSONArray buildToList(JSONArray listArray) {
        this.printSearchParams();
        JSONObject foundObject;
        JSONArray listResult = new JSONArray();
        for (Object line1 : listArray) {
            JSONObject temp = (JSONObject) line1;
            if (!this.searchParams.isEmpty()) {
                JSONObject findTmp = findEquals(temp);
                if (findTmp != null) {
                    foundObject = findTmp;
                    listResult.put(foundObject);
                }
            } else if (!this.text.isEmpty()) {
                if (this.text.contains(temp.get("url").toString())) {
                    foundObject = temp;
                    listResult.put(foundObject);
                }
            }
        }
        return listResult;
    }
}
