package com.google.firebase.iid.internal;

import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public interface FirebaseInstanceIdInternal {

    public interface NewTokenListener {
        public abstract void onNewToken(String string);
    }
    public abstract void addNewTokenListener(com.google.firebase.iid.internal.FirebaseInstanceIdInternal.NewTokenListener firebaseInstanceIdInternal$NewTokenListener);

    public abstract void deleteToken(String string, String string2);

    public abstract String getId();

    public abstract String getToken();

    public abstract j<String> getTokenTask();
}
