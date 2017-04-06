package com.gospelware.moltin;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    public static final String DEBUG_TAG = "MoltinTest";
    public static final String CLIENT_ID = "B7H9MthG8jYduHlGrmKnqO613XCEvsrZ6bwSYo1TWM";

    private Moltin moltinApi;

    @Before
    public void createLogHistory() {
        MoltinPreferences moltinPreferences = new MoltinPreferences("GBP", "", CLIENT_ID,"");
        moltinApi = new Moltin(moltinPreferences);
    }

    @Test
    public void testAuthentication() throws Exception {
        
        Observable<AccessTokenResponse> response = moltinApi.requestAuthentication();
        response.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<AccessTokenResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        fail();
                    }

                    @Override
                    public void onNext(AccessTokenResponse accessTokenResponse) {
                        //handleAccessToken(accessTokenResponse);
                        assertNotNull(accessTokenResponse);
                        assertNotNull(accessTokenResponse.getAccessToken());
                        assertTrue(accessTokenResponse.getAccessToken().trim().isEmpty() == false);
                    }
                });

    }
}
