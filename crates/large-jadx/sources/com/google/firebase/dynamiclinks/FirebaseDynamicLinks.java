package com.google.firebase.dynamiclinks;

import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.tasks.j;
import com.google.firebase.FirebaseApp;

/* loaded from: classes2.dex */
public abstract class FirebaseDynamicLinks {
    public static com.google.firebase.dynamiclinks.FirebaseDynamicLinks getInstance() {
        final Class<com.google.firebase.dynamiclinks.FirebaseDynamicLinks> obj = FirebaseDynamicLinks.class;
        return FirebaseDynamicLinks.getInstance(FirebaseApp.getInstance());
        synchronized (obj) {
            obj = FirebaseDynamicLinks.class;
            return FirebaseDynamicLinks.getInstance(FirebaseApp.getInstance());
        }
    }

    public static com.google.firebase.dynamiclinks.FirebaseDynamicLinks getInstance(FirebaseApp firebaseApp) {
        final Class<com.google.firebase.dynamiclinks.FirebaseDynamicLinks> obj = FirebaseDynamicLinks.class;
        return (FirebaseDynamicLinks)firebaseApp.get(obj);
        synchronized (obj) {
            obj = FirebaseDynamicLinks.class;
            return (FirebaseDynamicLinks)firebaseApp.get(obj);
        }
    }

    public abstract com.google.firebase.dynamiclinks.DynamicLink.Builder createDynamicLink();

    public abstract j<com.google.firebase.dynamiclinks.PendingDynamicLinkData> getDynamicLink(Intent intent);

    public abstract j<com.google.firebase.dynamiclinks.PendingDynamicLinkData> getDynamicLink(Uri uri);
}
