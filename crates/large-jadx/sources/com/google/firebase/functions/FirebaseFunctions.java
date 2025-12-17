package com.google.firebase.functions;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.emulators.EmulatedServiceSettings;
import f.c.a.d.d.a;
import f.c.a.d.d.a.a;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FirebaseFunctions {

    private static boolean providerInstallStarted;
    private static final k<Void> providerInstalled;
    private final FirebaseApp app;
    private final OkHttpClient client;
    private final com.google.firebase.functions.ContextProvider contextProvider;
    private final String customDomain = null;
    private EmulatedServiceSettings emulatorSettings;
    private final String projectId;
    private final String region;
    private final com.google.firebase.functions.Serializer serializer;
    private String urlFormat;
    static {
        k kVar = new k();
        FirebaseFunctions.providerInstalled = kVar;
        FirebaseFunctions.providerInstallStarted = false;
    }

    FirebaseFunctions(FirebaseApp firebaseApp, Context context2, String string3, String string4, com.google.firebase.functions.ContextProvider contextProvider5) {
        int obj2;
        super();
        this.urlFormat = "https://%1$s-%2$s.cloudfunctions.net/%3$s";
        this.app = firebaseApp;
        obj2 = new OkHttpClient();
        this.client = obj2;
        obj2 = new Serializer();
        this.serializer = obj2;
        r.j(contextProvider5);
        this.contextProvider = (ContextProvider)contextProvider5;
        r.j(string3);
        this.projectId = (String)string3;
        obj2 = new URL(string4);
        obj2 = 0;
        if (obj2 != null) {
            this.region = string4;
            obj2 = 0;
        } else {
            this.region = "us-central1";
            this.customDomain = string4;
        }
        FirebaseFunctions.maybeInstallProviders(context2);
    }

    private j a(j j) {
        return this.contextProvider.getContext();
    }

    static com.google.firebase.functions.Serializer access$000(com.google.firebase.functions.FirebaseFunctions firebaseFunctions) {
        return firebaseFunctions.serializer;
    }

    static k access$100() {
        return FirebaseFunctions.providerInstalled;
    }

    private j c(String string, Object object2, com.google.firebase.functions.HttpsCallOptions httpsCallOptions3, j j4) {
        if (!j4.isSuccessful()) {
            return m.d(j4.getException());
        }
        return call(string, object2, (HttpsCallableContext)j4.getResult(), httpsCallOptions3);
    }

    private j<com.google.firebase.functions.HttpsCallableResult> call(String string, Object object2, com.google.firebase.functions.HttpsCallableContext httpsCallableContext3, com.google.firebase.functions.HttpsCallOptions httpsCallOptions4) {
        Object builder;
        Request.Builder obj3;
        String obj4;
        String obj5;
        r.k(string, "name cannot be null");
        HashMap hashMap = new HashMap();
        hashMap.put("data", this.serializer.encode(object2));
        obj4 = new JSONObject(hashMap);
        builder = new Request.Builder();
        if (httpsCallableContext3.getAuthToken() != null) {
            obj4 = new StringBuilder();
            obj4.append("Bearer ");
            obj4.append(httpsCallableContext3.getAuthToken());
            obj3 = builder.url(getURL(string)).post(RequestBody.create(MediaType.parse("application/json"), obj4.toString())).header("Authorization", obj4.toString());
        }
        if (httpsCallableContext3.getInstanceIdToken() != null) {
            obj3 = obj3.header("Firebase-Instance-ID-Token", httpsCallableContext3.getInstanceIdToken());
        }
        if (httpsCallableContext3.getAppCheckToken() != null) {
            obj3 = obj3.header("X-Firebase-AppCheck", httpsCallableContext3.getAppCheckToken());
        }
        obj4 = new k();
        obj5 = new FirebaseFunctions.2(this, obj4);
        httpsCallOptions4.apply(this.client).newCall(obj3.build()).enqueue(obj5);
        return obj4.a();
    }

    static void e(Context context) {
        FirebaseFunctions.1 anon = new FirebaseFunctions.1();
        a.b(context, anon);
    }

    public static com.google.firebase.functions.FirebaseFunctions getInstance() {
        return FirebaseFunctions.getInstance(FirebaseApp.getInstance(), "us-central1");
    }

    public static com.google.firebase.functions.FirebaseFunctions getInstance(FirebaseApp firebaseApp) {
        return FirebaseFunctions.getInstance(firebaseApp, "us-central1");
    }

    public static com.google.firebase.functions.FirebaseFunctions getInstance(FirebaseApp firebaseApp, String string2) {
        r.k(firebaseApp, "You must call FirebaseApp.initializeApp first.");
        r.j(string2);
        Object obj1 = firebaseApp.get(FunctionsMultiResourceComponent.class);
        r.k((FunctionsMultiResourceComponent)obj1, "Functions component does not exist.");
        return obj1.get(string2);
    }

    public static com.google.firebase.functions.FirebaseFunctions getInstance(String string) {
        return FirebaseFunctions.getInstance(FirebaseApp.getInstance(), string);
    }

    private static void maybeInstallProviders(Context context) {
        k providerInstalled = FirebaseFunctions.providerInstalled;
        synchronized (providerInstalled) {
        }
    }

    public j b(j j) {
        return a(j);
    }

    j<com.google.firebase.functions.HttpsCallableResult> call(String string, Object object2, com.google.firebase.functions.HttpsCallOptions httpsCallOptions3) {
        g gVar = new g(this);
        f fVar = new f(this, string, object2, httpsCallOptions3);
        return FirebaseFunctions.providerInstalled.a().continueWithTask(gVar).continueWithTask(fVar);
    }

    public j d(String string, Object object2, com.google.firebase.functions.HttpsCallOptions httpsCallOptions3, j j4) {
        return c(string, object2, httpsCallOptions3, j4);
    }

    public com.google.firebase.functions.HttpsCallableReference getHttpsCallable(String string) {
        HttpsCallableReference httpsCallableReference = new HttpsCallableReference(this, string);
        return httpsCallableReference;
    }

    URL getURL(String string) {
        Object emulatorSettings;
        String string2;
        String format;
        String str;
        emulatorSettings = this.emulatorSettings;
        if (emulatorSettings != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://");
            stringBuilder.append(emulatorSettings.getHost());
            stringBuilder.append(":");
            stringBuilder.append(emulatorSettings.getPort());
            stringBuilder.append("/%2$s/%1$s/%3$s");
            this.urlFormat = stringBuilder.toString();
        }
        Object[] arr = new Object[3];
        format = String.format(this.urlFormat, this.region, this.projectId, string);
        if (this.customDomain != null && emulatorSettings == null) {
            if (emulatorSettings == null) {
                emulatorSettings = new StringBuilder();
                emulatorSettings.append(this.customDomain);
                emulatorSettings.append("/");
                emulatorSettings.append(string);
                format = emulatorSettings.toString();
            }
        }
        URL obj6 = new URL(format);
        return obj6;
    }

    public void useEmulator(String string, int i2) {
        EmulatedServiceSettings emulatedServiceSettings = new EmulatedServiceSettings(string, i2);
        this.emulatorSettings = emulatedServiceSettings;
    }

    public void useFunctionsEmulator(String string) {
        r.k(string, "origin cannot be null");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("/%2$s/%1$s/%3$s");
        this.urlFormat = stringBuilder.toString();
    }
}
