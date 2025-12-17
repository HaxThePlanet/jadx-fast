package com.google.firebase.database.ktx;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.ktx.Firebase;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\u0008\u0004\u0010\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008\u0004\u0010\u0008\u001a!\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\u0008\u0004\u0010\t\u001a\u001e\u0010\u000c\u001a\u0004\u0018\u00018\u0000\"\u0006\u0008\u0000\u0010\n\u0018\u0001*\u00020\u000bH\u0086\u0008¢\u0006\u0004\u0008\u000c\u0010\r\u001a\u001e\u0010\u000c\u001a\u0004\u0018\u00018\u0000\"\u0006\u0008\u0000\u0010\n\u0018\u0001*\u00020\u000eH\u0086\u0008¢\u0006\u0004\u0008\u000c\u0010\u000f\"\u0017\u0010\u0004\u001a\u00020\u0003*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u00018\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0012\u0010\u0013¨\u0006\u0014", d2 = {"Lcom/google/firebase/ktx/Firebase;", "", "url", "Lcom/google/firebase/database/FirebaseDatabase;", "database", "(Lcom/google/firebase/ktx/Firebase;Ljava/lang/String;)Lcom/google/firebase/database/FirebaseDatabase;", "Lcom/google/firebase/FirebaseApp;", "app", "(Lcom/google/firebase/ktx/Firebase;Lcom/google/firebase/FirebaseApp;)Lcom/google/firebase/database/FirebaseDatabase;", "(Lcom/google/firebase/ktx/Firebase;Lcom/google/firebase/FirebaseApp;Ljava/lang/String;)Lcom/google/firebase/database/FirebaseDatabase;", "T", "Lcom/google/firebase/database/DataSnapshot;", "getValue", "(Lcom/google/firebase/database/DataSnapshot;)Ljava/lang/Object;", "Lcom/google/firebase/database/MutableData;", "(Lcom/google/firebase/database/MutableData;)Ljava/lang/Object;", "getDatabase", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/database/FirebaseDatabase;", "LIBRARY_NAME", "Ljava/lang/String;", "com.google.firebase-firebase-database-ktx"}, k = 2, mv = {1, 4, 0})
public final class DatabaseKt {

    public static final String LIBRARY_NAME = "fire-db-ktx";
    public static final FirebaseDatabase database(Firebase firebase, FirebaseApp firebaseApp2) {
        n.g(firebase, "$this$database");
        n.g(firebaseApp2, "app");
        FirebaseDatabase obj1 = FirebaseDatabase.getInstance(firebaseApp2);
        n.c(obj1, "FirebaseDatabase.getInstance(app)");
        return obj1;
    }

    public static final FirebaseDatabase database(Firebase firebase, FirebaseApp firebaseApp2, String string3) {
        n.g(firebase, "$this$database");
        n.g(firebaseApp2, "app");
        n.g(string3, "url");
        FirebaseDatabase obj1 = FirebaseDatabase.getInstance(firebaseApp2, string3);
        n.c(obj1, "FirebaseDatabase.getInstance(app, url)");
        return obj1;
    }

    public static final FirebaseDatabase database(Firebase firebase, String string2) {
        n.g(firebase, "$this$database");
        n.g(string2, "url");
        FirebaseDatabase obj1 = FirebaseDatabase.getInstance(string2);
        n.c(obj1, "FirebaseDatabase.getInstance(url)");
        return obj1;
    }

    public static final FirebaseDatabase getDatabase(Firebase firebase) {
        n.g(firebase, "$this$database");
        final FirebaseDatabase obj1 = FirebaseDatabase.getInstance();
        n.c(obj1, "FirebaseDatabase.getInstance()");
        return obj1;
    }

    public static final <T> T getValue(DataSnapshot dataSnapshot) {
        n.g(dataSnapshot, "$this$getValue");
        n.k();
        throw 0;
    }

    public static final <T> T getValue(MutableData mutableData) {
        n.g(mutableData, "$this$getValue");
        n.k();
        throw 0;
    }
}
