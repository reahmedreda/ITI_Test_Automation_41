package Wrappers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.management.ServiceNotFoundException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class JsonFileParser {

    public static String jsonFile = "Config.json";

    JSONObject jsonObject;

    public JsonFileParser(String file){

        parseJson(file);
    }

    public JSONObject parseJson(String file) {

        try{
            InputStream is = new FileInputStream(file);
            JSONTokener tokener = new JSONTokener(is);
            jsonObject= new JSONObject(tokener);
            return jsonObject;

        } catch (JSONException | FileNotFoundException e) {
            LoggingHandling.logError(e);
            return null;
        }
    }

    public String getValueOfNode(String node){
        return jsonObject.getString(node);
    }

    public List<String> getValuesOfNode(String node){
        JSONArray jsonArray = jsonObject.getJSONArray(node);
        List<String> list = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                list.add(jsonArray.getString(i));

            } catch (JSONException e) {
                LoggingHandling.logError(e);


            }
        }
        return list;
    }


    public String getValueOfChildByFullPath(String parent){

        String [] tree= parent.split("/");

        int i=1;
        JSONObject parentNode;
        parentNode = (JSONObject) jsonObject.get(tree[0]);

        while(i< tree.length-1){
            parentNode = (JSONObject) parentNode.get(tree[i]);
            i++;

        }
        return parentNode.getString(tree[i]);
    }

    public List<String> getValuesOfChildByFullPath(String parent){

        String [] tree= parent.split("/");

        int i=1;
        JSONObject parentNode;
        parentNode = jsonObject.getJSONObject(tree[0]);

        while(i< tree.length-1){
            parentNode =  parentNode.getJSONObject(tree[i]);
            i++;

        }
        JSONArray value = null;
        boolean isArray = false;
        String singleVal = null;
        Object ob = null;
            try {
                ob = parentNode.get(tree[i]);
                if (ob instanceof JSONArray) {
                    value = parentNode.getJSONArray(tree[i]);
                    isArray = true;
                }
                else {
                    singleVal=  parentNode.getString(tree[i]);
                }
            } catch (JSONException e) {
                LoggingHandling.logError(e);

            }

        List<String> list = new ArrayList<String>();
        if (isArray) {
            for (int j = 0; j < value.length(); j++) {
                try {
                    list.add(value.getString(j));
                } catch (JSONException e) {
                    LoggingHandling.logError(e);
                    return null;

                }
            }
        }
        else {
            if(singleVal !=null)
                list.add(singleVal);
        }
        return list;

    }
    public JSONObject getJsonObjectOfNode(String node){
        return jsonObject.getJSONObject(node);
    }

    public List<String> getValuesOf(String parent, String child) {
        JSONArray value = null;
        boolean isArray = false;
        String singleVal = null;
        Object ob = null;
        if (child == null) {
            try {
                ob = jsonObject.get(parent);
                if (ob instanceof JSONArray) {
                    value = new JSONArray(jsonObject.getJSONArray(parent).toString());
                    isArray = true;
                }
                else {
                   singleVal=  jsonObject.getString(parent);
                }
            } catch (JSONException e) {
                LoggingHandling.logError(e);

            }
        } else {
            JSONObject parentNode;
            try {
                parentNode = (JSONObject) jsonObject.get(parent);
                ob = parentNode.get(child);
                if (ob instanceof JSONArray) {
                    value= new JSONArray(parentNode.getJSONArray(child).toString());
                    isArray = true;
                }
                else{
                    singleVal = parentNode.getString(child);
                }

            } catch (JSONException e) {
                System.out.println(e.getMessage());
                LoggingHandling.logError(e);
                return null;
            }

        }
        List<String> list = new ArrayList<String>();
        if (isArray) {
            for (int i = 0; i < value.length(); i++) {
                try {
                    list.add(value.getString(i));
                } catch (JSONException e) {
                    LoggingHandling.logError(e);
                    return null;

                }
            }
        }
        else {
            if(singleVal !=null)
            list.add(singleVal);
        }
        return list;
    }


}
