package com.example.bbs;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.bbs.http.HttpLogin;
import com.example.bbs.model.*;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(org.junit.runners.MethodSorters.NAME_ASCENDING)
public class TestUser {
    @Test
    public void useAppContext() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.example.menuwidget", appContext.getPackageName());
    }

    @Test
    public void test01_login() throws Exception {
        ModelUser result = new HttpLogin().login("userid","password");

        assertNotNull(result);
        assertEquals("userid" , result.getUserid() );
    }

    @Test
    public void test02_logout() throws Exception {
        int result = new HttpLogin().logout("userid");

        assertNotNull(result);
        assertEquals(0 , result );
    }

    @Test
    public void test03_checkuserid() throws Exception {
        int result = new HttpLogin().checkuserid("userid");

        assertNotNull(result);
        assertEquals(0 , result );
    }

    @Test
    public void test04_SelectUserOne() throws Exception {
        ModelUser user = new ModelUser();
        user.setUserno(1);

        ModelUser result = new HttpLogin().selectUserOne(user);

        assertNotNull(result);
        assertEquals("userid" , result.getUserid() );
    }

    @Test( expected = NotImplementedException.class )
    public void test05_selectUserList() throws Exception {
        ModelUser user = new ModelUser();
        user.setName("u");

        List<ModelUser> result = new HttpLogin().selectUserList(user);

        assertNotNull(result);
        assertTrue(result.size()>0 );
    }

    @Test
    public void test05_insertUser() throws Exception {
        ModelUser user = new ModelUser();
        user.setName("androidtest1name");
        user.setUserid("androidtest1id");
        user.setEmail("androidtest1email");

        int result = new HttpLogin().insertUser(user);

        assertNotNull(result);
        assertTrue(result > 0 );
    }
}
