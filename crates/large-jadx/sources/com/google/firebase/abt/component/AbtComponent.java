package com.google.firebase.abt.component;

import android.content.Context;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class AbtComponent {

    private final Map<String, FirebaseABTesting> abtOriginInstances;
    private final Provider<AnalyticsConnector> analyticsConnector;
    private final Context appContext;
    protected AbtComponent(Context context, Provider<AnalyticsConnector> provider2) {
        super();
        HashMap hashMap = new HashMap();
        this.abtOriginInstances = hashMap;
        this.appContext = context;
        this.analyticsConnector = provider2;
    }

    protected FirebaseABTesting createAbtInstance(String string) {
        FirebaseABTesting firebaseABTesting = new FirebaseABTesting(this.appContext, this.analyticsConnector, string);
        return firebaseABTesting;
    }

    public FirebaseABTesting get(String string) {
        boolean abtOriginInstances;
        FirebaseABTesting abtInstance;
        synchronized (this) {
            try {
                this.abtOriginInstances.put(string, createAbtInstance(string));
                return (FirebaseABTesting)this.abtOriginInstances.get(string);
                throw string;
            }
        }
    }
}
