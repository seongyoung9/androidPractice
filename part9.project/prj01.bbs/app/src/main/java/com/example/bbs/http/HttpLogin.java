package com.example.bbs.http;

import com.example.bbs.inf.IUser;
import com.example.bbs.model.*;
import com.google.gson.Gson;

import org.apache.commons.lang3.NotImplementedException;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;


public class HttpLogin implements IUser {
    private final static String HTT_URL_BASE = "http://10.0.2.2:8080";
    private final static String HTTP_URL_LOGIN  = HTT_URL_BASE + "/rest/login";
    private final static String HTTP_URL_LOGOUT = HTT_URL_BASE + "/rest/logout";
    private static final String HTTP_URL_CHECKUSERID = HTT_URL_BASE + "/rest/checkuserid";
    private static final String HTTP_URL_SELECTUSERONE = HTT_URL_BASE + "/rest/selectuserone";
    private static final String HTTP_URL_INSERTUSER = HTT_URL_BASE + "/rest/insertuser";

    private HttpRequest request = null;
    private int         httpCode = 0;

    @Override
    public ModelUser login(String userid, String passwd) {
        ModelUser   result = null;
        JSONObject  response = null;

        //입력받은 id와 pw를 서버에 입력한다. (---> mapper)
        try {
            request = new HttpRequest(HTTP_URL_LOGIN);
            request.addParameter("userid", userid);
            request.addParameter("passwd", passwd);
            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getJSONObjectResponse();
            }
            //JSONObject(json string) -> ModelUser객체(java object)
            Gson gson = new Gson();
            result = gson.fromJson(String.valueOf(response), ModelUser.class);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int logout(String userid) {
        int   result = -1;
        String  response = null;

        //입력받은 id와 pw를 서버에 입력한다. (---> mapper)
        try {
            request = new HttpRequest(HTTP_URL_LOGOUT);
            request.addParameter("userid", userid);
            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getStringResponse();
            }
            //JSONObject(json string) -> ModelUser객체(java object)
            result = Integer.valueOf(response);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int checkuserid(String userid) {
        int   result = -1;
        String  response = null;

        //입력받은 id와 pw를 서버에 입력한다. (---> mapper)
        try {
            request = new HttpRequest(HTTP_URL_CHECKUSERID);
            request.addParameter("userid", userid);
            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getStringResponse();
            }
            //JSONObject(json string) -> ModelUser객체(java object)
            result = Integer.valueOf(response);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public ModelUser selectUserOne(ModelUser user) {
        ModelUser   result = null;
        JSONObject  response = null;

        //입력받은 id와 pw를 서버에 입력한다. (---> mapper)
        try {
            request = new HttpRequest(HTTP_URL_SELECTUSERONE);
            request.addHeader("Content-Type", "application/json");
            request.addHeader("Accept"      , "application/json");

            // Convert Java object to JSON : toJson
            String jsonString = new Gson().toJson(user);

            httpCode = request.post(jsonString);

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getJSONObjectResponse();
            }

            //JSONObject(json string) -> ModelUser객체(java object)
            Gson gson = new Gson();
            result = gson.fromJson(String.valueOf(response), ModelUser.class);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        throw new NotImplementedException("필요없어 안 만듬");
    }

    @Override
    public int insertUser(ModelUser user) {
        int   result = -1;
        String  response = "";

        //입력받은 id와 pw를 서버에 입력한다. (---> mapper)
        try {
            request = new HttpRequest(HTTP_URL_INSERTUSER);
            request.addHeader("Content-Type", "application/json");
            request.addHeader("Accept"      , "application/json");

            // Convert Java object to JSON : toJson
            String jsonString = new Gson().toJson(user);

            httpCode = request.post(jsonString);

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getStringResponse();
            }

            result = Integer.valueOf( response );

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int updatePasswd(String userid, String currentPasswd, String newPasswd) {
        return 0;
    }

    @Override
    public int updateUserInfo(ModelUser setValue, ModelUser whereValue) {
        return 0;
    }

    @Override
    public int updateRetire(ModelUser user) {
        return 0;
    }

    @Override
    public int checkpassword(String id, String curpw) {
        return 0;
    }

}
