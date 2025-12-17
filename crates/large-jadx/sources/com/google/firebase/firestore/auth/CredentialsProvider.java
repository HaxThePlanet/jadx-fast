package com.google.firebase.firestore.auth;

import com.google.android.gms.tasks.j;
import com.google.firebase.firestore.util.Listener;

/* loaded from: classes2.dex */
public abstract class CredentialsProvider<T>  {
    public abstract j<String> getToken();

    public abstract void invalidateToken();

    public abstract void removeChangeListener();

    public abstract void setChangeListener(Listener<T> listener);
}
