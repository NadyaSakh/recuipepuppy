package com.s.recipepuppy;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.s.recipepuppy.domain.remote.ApiClient;
import com.s.recipepuppy.domain.remote.PuppyRecipesAPI;


public class App extends Application {
    // todo: m? или s? +
    private static ApiClient sApiCient;

    @NonNull
    public static PuppyRecipesAPI api() { return sApiCient.puppyRecipesAPI(); }

    @Override
    public void onCreate() {
        super.onCreate();

        sApiCient = ApiClient.instance();

        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                Log.d("APP", activity.toString());
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {

            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {

            }
        });
    }



}
