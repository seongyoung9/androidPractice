package com.example.administrator.multitypelistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdapterActor extends ArrayAdapter {
    //Viewtype 선언.
    public static final int VIEW_TYPE_ACTOR = 0;
    public static final int VIEW_TYPE_TITLE = 1;
    public static final int VIEW_TYPE_MOVIE = 2;
    public static final int VIEW_TYPE_DRAMA = 3;
    public static final int VIEW_TYPE_COMMENT = 4;

    private final LayoutInflater inflater;

    private ModelActor actor;
    private final Context context;

    public ModelActor getActor() {
        return actor;
    }

    public void setActor(ModelActor actor) {
        this.actor = actor;
        //앱 실행중 데이터 변경시 화면 새로고침
        notifyDataSetChanged();
    }

    public AdapterActor(@NonNull Context context, ModelActor actor) {
        super(context, -1);
        this.context  = context;
        this.actor    = actor;
        this.inflater = LayoutInflater.from( context );
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (position == 0) {
            ViewActor view;                       //instanceof 타입을 비교함
            if (convertView != null && convertView instanceof ViewActor) {
                view = (ViewActor) convertView;
            } else {
                view = new ViewActor(parent.getContext());
            }
            //데이터 입력 및 화면 새로 고침
            view.setActor( actor );
            return view;
        }
        position = position -1;   //actor를 빼준것

        if ( actor.getMovies().size() > 0){
            if ( position == 0 ){     //title
                TextView view = null;

                if ( convertView != null && convertView instanceof TextView ){
                    view = ( TextView ) convertView;
                }
                else {
                    view = ( TextView ) inflater.inflate(android.R.layout.simple_list_item_1,parent,false);
                }
                view.setText("Movies~~~~");
                return view;
            }

            position = position -1;   //movie의 title 로우를 제거하기 위해

            if ( position < actor.getMovies().size() ) {
                ViewMovie view;

                if (convertView != null && convertView instanceof ViewMovie) {
                    view = (ViewMovie) convertView;
                }
                else {
                    view = new ViewMovie(parent.getContext());
                }
                ModelMovie m = actor.getMovies().get( position );
                view.setMovie( m );

                return view;
            }

            position = position - actor.getMovies().size();   //movie의 movies 로우를 제거하기위해서

        }

        if ( actor.getDramas().size() > 0 ){
            //title처리
            if ( position == 0 ){
                TextView view;
                if ( convertView != null && convertView instanceof TextView ){
                    view = ( TextView ) convertView;   // 재사용
                }
                else {
                    view = ( TextView ) inflater.inflate(android.R.layout.simple_list_item_1,parent,false);
                }
                view.setText("Drama~~~");

                return view;
            }
            position = position -1;

            if ( position < actor.getDramas().size() ){
                ViewDrama view;
                if (convertView != null && convertView instanceof ViewDrama ){
                    view = ( ViewDrama ) convertView;         //재사용
                }
                else {
                    view = new ViewDrama( parent.getContext() );
                }
                ModelDrama d = actor.getDramas().get( position );
                view.setDrama( d );  //화면새로고침이 발생

                return view;
            }
            position = position - actor.getDramas().size();  //drama의 row갯수를 제거함

            if (actor.getComments().size() > 0){

                if (position == 0){
                    TextView view;
                    if ( convertView != null && convertView instanceof TextView ){
                        view = ( TextView ) convertView;
                    }
                    else{
                        view = new TextView(  parent.getContext() );
                        ViewGroup.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                        ,ViewGroup.LayoutParams.WRAP_CONTENT);
                        view.setLayoutParams(lp);
                    }
                    view.setText("Comment~~~");

                    return view;
                }
                position = position -1;

                if (position < actor.getComments().size() ){
                    ViewComment view;
                    if (convertView != null && convertView instanceof ViewComment){
                        view = ( ViewComment ) convertView;
                    }
                    else {
                        view = new ViewComment( parent.getContext() );
                    }
                    ModelComment c = actor.getComments().get( position );
                    view.setComment( c );

                    return view;
                }
                position = position - actor.getComments().size();
            }
        }
        throw new IllegalArgumentException("Invalid position");
    }

    @Override
    public int getItemViewType(int position) {
        int VIEW_TYPE = -1;
        if (position == 0) {
            return VIEW_TYPE_ACTOR;
        }
        position = position - 1;     //actor 때문에 -1해줌

        if (actor.getMovies().size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_TITLE;
            }
            position = position - 1;  // movie의 title 때문에 -1 해줌

            if (position < actor.getMovies().size()) {
                return VIEW_TYPE_MOVIE;
            }
            position = position - actor.getMovies().size();

        }

        if (actor.getDramas().size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_TITLE;
            }
            position = position - 1;  // Dramas의 title 때문에 -1 해줌

            if (position < actor.getDramas().size()) {
                return VIEW_TYPE_DRAMA;
            }
            position = position - actor.getDramas().size();

        }

        if (actor.getComments().size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_TITLE;
            }
            position = position - 1;  // Comment의 title 때문에 -1 해줌

            if (position < actor.getComments().size()) {
                return VIEW_TYPE_COMMENT;
            }
            position = position - actor.getComments().size();

        }
        return VIEW_TYPE;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        if (position == 0) {
            return actor;
        }
        position = position - 1;                   //position = 0

        if (actor.getMovies().size() > 0) {
            if (position == 0) {
                return "ModelMovie";   //movie의 타이틀값을 리턴
            }
            position = position - 1;   //position 값을 0으로 바꿔줌

            if (position < actor.getMovies().size()) {
                return actor.getMovies().get(position);
            }
            position = position - actor.getMovies().size();   //position = 0
        }

        if (actor.getDramas().size() > 0) {
            if (position == 0) {
                return "ModelDrama";   //Drama의 타이틀값을 리턴
            }
            position = position - 1;   //position 값을 0으로 바꿔줌

            if (position < actor.getDramas().size()) {
                return actor.getDramas().get(position);
            }
            position = position - actor.getDramas().size();   //position = 0
        }

        if (actor.getComments().size() > 0) {
            if (position == 0) {
                return "Comment...";   //Comment의 타이틀값을 리턴
            }
            position = position - 1;   //position 값을 0으로 바꿔줌

            if (position < actor.getComments().size()) {
                return actor.getComments().get(position);
            }
            position = position - actor.getComments().size();   //position = 0
        }

        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 5;
    }

    @Override
    public int getCount() {
        /*title이 추가되면서 갯수가 변경되는 문제가 발생
                title의 갯수를 빼줘야 한다.*/
        int count = 0;
        if (actor == null) {
            return 0;
        } else {
            count += 1;
        }
        //movies
        if (actor.getMovies().size() > 0) {
            count = count + (1 + actor.getMovies().size());
        }
        //drama
        if (actor.getDramas().size() > 0) {
            count = count + (1 + actor.getDramas().size());
        }
        //comment
        if (actor.getComments().size() > 0) {
            count = count + (1 + actor.getComments().size());
        }
        return count;
    }
}
