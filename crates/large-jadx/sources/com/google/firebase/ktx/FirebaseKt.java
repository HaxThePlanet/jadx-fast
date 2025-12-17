package com.google.firebase.ktx;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\u0008\u0004\u0010\u0005\u001a\u001b\u0010\u0008\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008\u0008\u0010\t\u001a!\u0010\u0008\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\u0008\u0008\u0010\u000c\u001a)\u0010\u0008\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\u0008\u0008\u0010\r\"\u0017\u0010\u0004\u001a\u00020\u0003*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000f\"\u0017\u0010\u000b\u001a\u00020\n*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u00018\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0012\u0010\u0013¨\u0006\u0014", d2 = {"Lcom/google/firebase/ktx/Firebase;", "", "name", "Lcom/google/firebase/FirebaseApp;", "app", "(Lcom/google/firebase/ktx/Firebase;Ljava/lang/String;)Lcom/google/firebase/FirebaseApp;", "Landroid/content/Context;", "context", "initialize", "(Lcom/google/firebase/ktx/Firebase;Landroid/content/Context;)Lcom/google/firebase/FirebaseApp;", "Lcom/google/firebase/FirebaseOptions;", "options", "(Lcom/google/firebase/ktx/Firebase;Landroid/content/Context;Lcom/google/firebase/FirebaseOptions;)Lcom/google/firebase/FirebaseApp;", "(Lcom/google/firebase/ktx/Firebase;Landroid/content/Context;Lcom/google/firebase/FirebaseOptions;Ljava/lang/String;)Lcom/google/firebase/FirebaseApp;", "getApp", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/FirebaseApp;", "getOptions", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/FirebaseOptions;", "LIBRARY_NAME", "Ljava/lang/String;", "com.google.firebase-firebase-common-ktx"}, k = 2, mv = {1, 4, 0})
public final class FirebaseKt {

    public static final String LIBRARY_NAME = "fire-core-ktx";
    public static final FirebaseApp app(com.google.firebase.ktx.Firebase firebase, String string2) {
        n.g(firebase, "$this$app");
        n.g(string2, "name");
        FirebaseApp obj1 = FirebaseApp.getInstance(string2);
        n.c(obj1, "FirebaseApp.getInstance(name)");
        return obj1;
    }

    public static final FirebaseApp getApp(com.google.firebase.ktx.Firebase firebase) {
        n.g(firebase, "$this$app");
        final FirebaseApp obj1 = FirebaseApp.getInstance();
        n.c(obj1, "FirebaseApp.getInstance()");
        return obj1;
    }

    public static final FirebaseOptions getOptions(com.google.firebase.ktx.Firebase firebase) {
        n.g(firebase, "$this$options");
        FirebaseOptions obj1 = FirebaseKt.getApp(Firebase.INSTANCE).getOptions();
        n.c(obj1, "Firebase.app.options");
        return obj1;
    }

    public static final FirebaseApp initialize(com.google.firebase.ktx.Firebase firebase, Context context2) {
        n.g(firebase, "$this$initialize");
        n.g(context2, "context");
        return FirebaseApp.initializeApp(context2);
    }

    public static final FirebaseApp initialize(com.google.firebase.ktx.Firebase firebase, Context context2, FirebaseOptions firebaseOptions3) {
        n.g(firebase, "$this$initialize");
        n.g(context2, "context");
        n.g(firebaseOptions3, "options");
        FirebaseApp obj1 = FirebaseApp.initializeApp(context2, firebaseOptions3);
        n.c(obj1, "FirebaseApp.initializeApp(context, options)");
        return obj1;
    }

    public static final FirebaseApp initialize(com.google.firebase.ktx.Firebase firebase, Context context2, FirebaseOptions firebaseOptions3, String string4) {
        n.g(firebase, "$this$initialize");
        n.g(context2, "context");
        n.g(firebaseOptions3, "options");
        n.g(string4, "name");
        FirebaseApp obj1 = FirebaseApp.initializeApp(context2, firebaseOptions3, string4);
        n.c(obj1, "FirebaseApp.initializeApp(context, options, name)");
        return obj1;
    }
}
