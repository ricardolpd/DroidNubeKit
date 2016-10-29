package net.droidcloudkit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Ricardo on 29/10/2016.
 */

public class RequestInterceptor implements Interceptor {

    public RequestInterceptor() {



    }


    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
//        request.url().newBuilder().addQueryParameter();


        return chain.proceed(request);
    }
}
