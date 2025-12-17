package com.google.firebase.functions;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
class FunctionsMultiResourceComponent {

    private final FirebaseApp app;
    private final Context applicationContext;
    private final com.google.firebase.functions.ContextProvider contextProvider;
    private final Map<String, com.google.firebase.functions.FirebaseFunctions> instances;
    FunctionsMultiResourceComponent(Context context, com.google.firebase.functions.ContextProvider contextProvider2, FirebaseApp firebaseApp3) {
        super();
        HashMap hashMap = new HashMap();
        this.instances = hashMap;
        this.applicationContext = context;
        this.contextProvider = contextProvider2;
        this.app = firebaseApp3;
    }

    com.google.firebase.functions.FirebaseFunctions get(String string) {
        Object firebaseFunctions;
        Object instances;
        com.google.firebase.functions.FirebaseFunctions firebaseFunctions2;
        FirebaseApp app;
        Context applicationContext;
        Object obj;
        com.google.firebase.functions.ContextProvider contextProvider;
        synchronized (this) {
            try {
                super(this.app, this.applicationContext, this.app.getOptions().getProjectId(), string, this.contextProvider);
                this.instances.put(string, firebaseFunctions);
                return firebaseFunctions;
                throw string;
            }
        }
    }
}
