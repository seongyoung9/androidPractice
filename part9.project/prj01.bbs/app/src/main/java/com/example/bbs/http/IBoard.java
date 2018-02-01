package com.spring61.rest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring61.rest.model.ModelArticle;
import com.spring61.rest.model.ModelAttachFile;
import com.spring61.rest.model.ModelBoard;
import com.spring61.rest.model.ModelComments;
import com.spring61.rest.model.ModelUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IBoard {
    
    ModelUser login(String userid, String passwd);
    
    int logout(String userid);
    
    int checkuserid(String userid);
    
    List<ModelUser> selectuserlist(Model model);
    
    ModelUser selectuserone(Model model);
    
    int insertuser(ModelUser user);
    
    int updatepasswd(String userid, String currentPasswd, String newPasswd);
    
    int updateuserinfo(Map<String, Object> maps);
    
    int updateretire(ModelUser user);
    
    /**
     * 클라이언트 변수명: cd
     * 서버       변수명: boardcd
     */
    ModelBoard getboardone(String boardcd);
    
    String getboardname(String boardcd);
    
    int getboardtotalrecord(String searchWord);
    
    List<ModelBoard> getBoardPaging(String searchWord, int start, int end);
    
    List<ModelBoard> getBoardList(String searchWord);
    
    int insertBoard(ModelBoard board);
    
    int updateBoard(ModelBoard setValue, ModelBoard whereValue);
    
    int deleteBoard(ModelBoard board);
    
    int insertBoardList(List<ModelBoard> list);
    
    int getArticleTotalRecord(String boardcd, String searchWord);
    
    List<ModelArticle> getArticleList(String boardcd, String searchWord,
            int start, int end);
    
    ModelArticle getArticle(int articleno);
    
    int insertArticle(ModelArticle article);
    
    int updateArticle(ModelArticle setValue, ModelArticle whereValue);
    
    int deleteArticle(ModelArticle article);
    
    int increaseHit(int articleno);
    
    ModelArticle getNextArticle(int articleno, String boardcd,
            String searchWord);
    
    ModelArticle getPrevArticle(int articleno, String boardcd,
            String searchWord);
    
    ModelAttachFile getAttachFile(int attachFileNo);
    
    List<ModelAttachFile> getAttachFileList(int articleno);
    
    int insertAttachFile(ModelAttachFile attachFile);
    
    int deleteAttachFile(ModelAttachFile attachFile);
    
    ModelComments getComment(int commentNo);
    
    List<ModelComments> getCommentList(int articleno);
    
    int insertComment(ModelComments comment);
    
    int updateComment(ModelComments setValue, ModelComments whereValue);
    
    int deleteComment(ModelComments comment);
    
}
