package com.example.bbs.http;

import com.example.bbs.AppConstants;
import com.example.bbs.inf.IBoard;
import com.example.bbs.model.*;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpBoard implements IBoard {

    private final static String HTTP_URL_GETBOARDONE           = AppConstants.HTT_URL_BASE + "/rest/getboardone";
    private final static String HTTP_URL_GETBOARDNAME          = AppConstants.HTT_URL_BASE + "/rest/getboardname";
    private final static String HTTP_URL_GETBOARDTOTALRECORD   = AppConstants.HTT_URL_BASE + "/rest/getboardtotalrecord";
    private final static String HTTP_URL_GETBOARDPAGING        = AppConstants.HTT_URL_BASE + "/rest/getboardpaging";
    private final static String HTTP_URL_GETBOARDLIST          = AppConstants.HTT_URL_BASE + "/rest/getboardlist";
    private final static String HTTP_URL_INSERTBOARD           = AppConstants.HTT_URL_BASE + "/rest/insertboard";
    private final static String HTTP_URL_UPDATEBOARD           = AppConstants.HTT_URL_BASE + "/rest/updateboard";
    private final static String HTTP_URL_DELETEBOARD           = AppConstants.HTT_URL_BASE + "/rest/deleteboard";
    private final static String HTTP_URL_INSERTBOARDLIST       = AppConstants.HTT_URL_BASE + "/rest/insertboardlist";
    private final static String HTTP_URL_GETARTICLETOTALRECORD = AppConstants.HTT_URL_BASE + "/rest/getarticletotalrecord";
    private final static String HTTP_URL_GETARTICLELIST        = AppConstants.HTT_URL_BASE + "/rest/getarticlelist";
    private final static String HTTP_URL_GETARTICLE            = AppConstants.HTT_URL_BASE + "/rest/getarticle";
    private final static String HTTP_URL_INSERTARTICLE         = AppConstants.HTT_URL_BASE + "/rest/insertarticle";
    private final static String HTTP_URL_UPDATEARTICLE         = AppConstants.HTT_URL_BASE + "/rest/updatearticle";
    private final static String HTTP_URL_DELETEARTICLE         = AppConstants.HTT_URL_BASE + "/rest/deletearticle";
    private final static String HTTP_URL_INCREASEHIT           = AppConstants.HTT_URL_BASE + "/rest/increasehit";
    private final static String HTTP_URL_GETNEXTARTICLE        = AppConstants.HTT_URL_BASE + "/rest/getnextarticle";
    private final static String HTTP_URL_GETPREVARTICLE        = AppConstants.HTT_URL_BASE + "/rest/getprevarticle";
    private final static String HTTP_URL_GETATTACHFILE         = AppConstants.HTT_URL_BASE + "/rest/getattachfile";
    private final static String HTTP_URL_GETATTACHFILELIST     = AppConstants.HTT_URL_BASE + "/rest/getattachfilelist";
    private final static String HTTP_URL_INSERTATTACHFILE      = AppConstants.HTT_URL_BASE + "/rest/insertattachfile";
    private final static String HTTP_URL_DELETEATTACHFILE      = AppConstants.HTT_URL_BASE + "/rest/deleteattachfile";
    private final static String HTTP_URL_GETCOMMENT            = AppConstants.HTT_URL_BASE + "/rest/getcomment";
    private final static String HTTP_URL_GETCOMMENTLIST        = AppConstants.HTT_URL_BASE + "/rest/getcommentlist";
    private final static String HTTP_URL_INSERTCOMMENT         = AppConstants.HTT_URL_BASE + "/rest/insertcomment";
    private final static String HTTP_URL_UPDATECOMMENT         = AppConstants.HTT_URL_BASE + "/rest/updatecomment";
    private final static String HTTP_URL_DELETECOMMENT         = AppConstants.HTT_URL_BASE + "/rest/deletecomment";

}
