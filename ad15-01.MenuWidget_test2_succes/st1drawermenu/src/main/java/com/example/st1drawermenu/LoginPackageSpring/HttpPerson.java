package com.example.st1drawermenu.LoginPackageSpring;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpPerson implements IPerson {

    private final static String HTTP_URL_CURTIME = AppConstants.HTT_URL_BASE + "/rest/curtime";
    private final static String HTTP_URL_LOGINPERSON = AppConstants.HTT_URL_BASE + "/rest/loginperson";
    private final static String HTTP_URL_SELECTPARAM = AppConstants.HTT_URL_BASE + "/rest/selectparam";
    private final static String HTTP_URL_SELECTMODEL = AppConstants.HTT_URL_BASE + "/rest/selectmodel";
    private final static String HTTP_URL_SELECTJSON = AppConstants.HTT_URL_BASE + "/rest/selectjson";
    private final static String HTTP_URL_SELECTMAP = AppConstants.HTT_URL_BASE + "/rest/selectmap";
    private final static String HTTP_URL_SELECTPAGING = AppConstants.HTT_URL_BASE + "/rest/selectpaging";
    private final static String HTTP_URL_INSERTPARAM = AppConstants.HTT_URL_BASE + "/rest/insertparam";
    private final static String HTTP_URL_INSERTMODEL = AppConstants.HTT_URL_BASE + "/rest/insertmodel";
    private final static String HTTP_URL_INSERTJSONOBJECT = AppConstants.HTT_URL_BASE + "/rest/insertjsonobject";
    private final static String HTTP_URL_INSERTJSONARRAY = AppConstants.HTT_URL_BASE + "/rest/insertjsonarray";

    private HttpRequest request = null;
    private int httpCode = 0;

    @Override
    public long curtime() {

        long result = -1;
        String response = "";

        try {
            request = new HttpRequest(HTTP_URL_CURTIME);             // url전송
            request.configPostType(HttpRequest.MineType.VALUES);     // 전송 타입 설정

            httpCode = request.post();

            if (httpCode == HttpURLConnection.HTTP_OK) {  //200이 정상
                response = request.getStringResponse();
            }

            result = Long.valueOf(response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // request  : values
    // response : values
    @Override
    public long loginperson(String id, String pw) {

        long result = -1;
        String response = "";

        try {
            request = new HttpRequest(HTTP_URL_LOGINPERSON);
            request.configPostType(HttpRequest.MineType.VALUES);

            // 전송 데이터 만들기  넘겨야 하는 변수가 있을때
            request.addBody("id", id);     // "" 안의 id는 서버의 아이디   ,뒤의 id는 매베변수 id
            request.addBody("pw", pw);

            httpCode = request.post();

            if (httpCode == HttpURLConnection.HTTP_OK) {
                response = request.getStringResponse();    // VALUES로 보냈으니 String
            }

            result = Long.valueOf(response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // request  : values
    // response : JSONArray
    @Override
    public List<ModelPerson> selectparam(String name) {

        List<ModelPerson> result = null;
        JSONArray response = null;

        try {
            request = new HttpRequest(HTTP_URL_SELECTPARAM);
            request.configPostType(HttpRequest.MineType.VALUES);

            request.addBody("name", name);

            httpCode = request.post();

            if (httpCode == HttpURLConnection.HTTP_OK) {
                response = request.getJSONArrayResponse();
            }

            // GSon으로 JSONArray를 List<ModelPerson>로 변환   이렇게 써야함
            result = new Gson().fromJson(response.toString(), new TypeToken<List<ModelPerson>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }

    // request  : values
    // response : JSONArray
    @Override
    public List<ModelPerson> selectmodel(ModelPerson person) {
        List<ModelPerson> result = null;
        JSONArray response = null;

        try {
            request = new HttpRequest(HTTP_URL_SELECTMODEL);
            request.configPostType(HttpRequest.MineType.VALUES);

            request.addBody("id"   , person.getId()   );
            request.addBody("pw"   , person.getPw()   );
            request.addBody("name" , person.getName() );
            request.addBody("email", person.getEmail());

            httpCode = request.post();

            if (httpCode == HttpURLConnection.HTTP_OK) {
                response = request.getJSONArrayResponse();
            }
            // GSon으로 JSONArray를 List<ModelPerson>로 변환   이렇게 써야함
            result = new Gson().fromJson(response.toString(), new TypeToken<List<ModelPerson>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // request  : JSONObject
    // response : JSONArray
    @Override
    public List<ModelPerson> selectjson(ModelPerson person) {
        List<ModelPerson> result   = null;
        JSONArray         response = null;
        Gson gson = new Gson();

        try {
            request = new HttpRequest( HTTP_URL_SELECTJSON );
            request.configPostType( HttpRequest.MineType.JSONObject );

            // GSON을 이용하여 ModelPerson을 JSONObject변환
            String jsonString = gson.toJson( person );

            httpCode = request.post( jsonString );

            if (httpCode == HttpURLConnection.HTTP_OK) {
                response = request.getJSONArrayResponse();
            }

            // GSon으로 JSONArray를 List<ModelPerson>로 변환   이렇게 써야함
            result = gson.fromJson(response.toString(), new TypeToken< List<ModelPerson> >(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // request  : JSONObject( map )
    // response : JSONArray
    @Override
    public List<ModelPerson> selectmap(ModelPerson searchvalue, String orderby) {
        List<ModelPerson> result   = null;
        JSONArray         response = null;
        Gson gson = new Gson();

        try {
            request = new HttpRequest( HTTP_URL_SELECTMAP );
            request.configPostType( HttpRequest.MineType.JSONObject );

            Map<String , Object > map = new HashMap<>();
            map.put( "searchvalue" , searchvalue );
            map.put( "orderby"     , orderby     );

            // GSON을 이용하여 ModelPerson을 JSONObject변환
            String jsonString = gson.toJson( map );
            httpCode = request.post( jsonString );

            if ( httpCode == HttpURLConnection.HTTP_OK ){
                response = request.getJSONArrayResponse();
            }

            // GSon으로 JSONArray를 List<ModelPerson>로 변환   이렇게 써야함
            result = gson.fromJson(response.toString(), new TypeToken< List<ModelPerson> >(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }

    // request  : values
    // response : JSONArray
    @Override
    public List<ModelPerson> selectpaging(int start, int end) {

        List<ModelPerson> result    = null;
        JSONArray         response  = null;

        try {
            request = new HttpRequest( HTTP_URL_SELECTPAGING );
            request.configPostType( HttpRequest.MineType.VALUES );

            request.addBody( "start" ,  start + "" );
            request.addBody( "end"   ,  end + "" );

            httpCode = request.post();

            if ( httpCode == HttpURLConnection.HTTP_OK ){
                response = request.getJSONArrayResponse();
            }

            result = new Gson().fromJson(response.toString(), new TypeToken< List<ModelPerson> >(){}.getType() );

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // request  : values
    // response : values
    @Override
    public boolean insertparam(String name) {
        boolean result  = false;
        String response = ""   ;

        try {
            request = new HttpRequest( HTTP_URL_INSERTPARAM );
            request.configPostType( HttpRequest.MineType.VALUES );

            request.addBody( "name", name );

            httpCode = request.post();

            if ( httpCode == HttpURLConnection.HTTP_OK ){
                response = request.getStringResponse();
            }
            result = Boolean.valueOf( response );

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // request  : values( Model )
    // response : values
    @Override
    public boolean insertmodel(ModelPerson person) {
        boolean result   = false;
        String  response = ""   ;

        try {
            request = new HttpRequest( HTTP_URL_INSERTMODEL );
            request.configPostType( HttpRequest.MineType.VALUES );

            request.addBody( "id"    , person.getId()    );
            request.addBody( "pw"    , person.getPw()    );
            request.addBody( "email" , person.getEmail() );
            request.addBody( "name"  , person.getName()  );

            httpCode = request.post();
            if ( httpCode == HttpURLConnection.HTTP_OK ){
                response = request.getStringResponse();
            }
            result = Boolean.valueOf( response );

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
            return result;
    }

    // request  : JSONObject
    // response : values
    @Override
    public boolean insertjsonobject(ModelPerson person) {
        boolean result   = false;
        String  response = ""   ;

        try {
            request = new HttpRequest( HTTP_URL_INSERTJSONOBJECT );
            request.configPostType( HttpRequest.MineType.JSONObject );

            String jsonString = new Gson().toJson( person );
            httpCode = request.post( jsonString );

            if ( httpCode == HttpURLConnection.HTTP_OK ){
                response = request.getStringResponse();
            }

            result = Boolean.valueOf( response );

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // request  : JSONArray
    // response : values
    @Override
    public boolean insertjsonarray(List<ModelPerson> person) {
        boolean result   = false;
        String  response = ""   ;

        try {
            request = new HttpRequest( HTTP_URL_INSERTJSONARRAY );
            request.configPostType( HttpRequest.MineType.JSONArray );

            String jsonString = new Gson().toJson( person );
            httpCode = request.post( jsonString );

            if ( httpCode == HttpURLConnection.HTTP_OK ){
                response = request.getStringResponse();
            }

            result = Boolean.valueOf( response );

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }
}
