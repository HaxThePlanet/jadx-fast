package com.google.firebase.firestore.local;

import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.util.Supplier;

/* loaded from: classes2.dex */
public abstract class Persistence {

    public static boolean INDEXING_SUPPORT_ENABLED = false;
    public static boolean OVERLAY_SUPPORT_ENABLED = false;
    static final String TAG = "Persistence";
    static {
    }

    abstract com.google.firebase.firestore.local.BundleCache getBundleCache();

    abstract com.google.firebase.firestore.local.DocumentOverlay getDocumentOverlay(User user);

    abstract com.google.firebase.firestore.local.IndexManager getIndexManager();

    abstract com.google.firebase.firestore.local.MutationQueue getMutationQueue(User user);

    abstract com.google.firebase.firestore.local.ReferenceDelegate getReferenceDelegate();

    abstract com.google.firebase.firestore.local.RemoteDocumentCache getRemoteDocumentCache();

    abstract com.google.firebase.firestore.local.TargetCache getTargetCache();

    public abstract boolean isStarted();

    abstract <T> T runTransaction(String string, Supplier<T> supplier2);

    abstract void runTransaction(String string, Runnable runnable2);

    public abstract void shutdown();

    public abstract void start();
}
