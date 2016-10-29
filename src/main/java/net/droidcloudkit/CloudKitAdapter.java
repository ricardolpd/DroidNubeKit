package net.droidcloudkit;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Ricardo on 29/10/2016.
 */

public class CloudKitAdapter {

    public enum Environment {
        development,
        production;

        public String toString() {
            String env = "development";
            if (this == production){
                env = "production";
            }

            return env;
        }
    }

    public static final String CLOUDKIT_URL_STRING = "https://api.apple-cloudkit.com";

    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    Interceptor requestInterceptor = new RequestInterceptor();
    OkHttpClient client = new OkHttpClient.Builder().build();


    private String apiToken;
    private String containerID;
    private Environment environment;

    public CloudKitAdapter(String apiToken,
                            String containerID,
                            Environment env) {
        this.apiToken = apiToken;
        this.containerID = containerID;
        this.environment = env;
        this.setupClient();
    }

    private void setupClient() {
        client.interceptors().add(loggingInterceptor);
        client.networkInterceptors().add(new RequestInterceptor());


    }

    public void ModifyRecords() {

    }


}
