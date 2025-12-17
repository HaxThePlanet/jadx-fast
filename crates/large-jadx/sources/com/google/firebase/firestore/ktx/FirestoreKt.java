package com.google.firebase.firestore.ktx;

import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.DocumentSnapshot.ServerTimestampBehavior;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.FirebaseFirestoreSettings.Builder;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.ktx.Firebase;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.w;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\u0008\u0004\u0010\u0005\u001a\u001e\u0010\u0008\u001a\u0004\u0018\u00018\u0000\"\u0006\u0008\u0000\u0010\u0006\u0018\u0001*\u00020\u0007H\u0086\u0008¢\u0006\u0004\u0008\u0008\u0010\t\u001a&\u0010\u0008\u001a\u0004\u0018\u00018\u0000\"\u0006\u0008\u0000\u0010\u0006\u0018\u0001*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0086\u0008¢\u0006\u0004\u0008\u0008\u0010\u000c\u001a&\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0006\u0008\u0000\u0010\u0006\u0018\u0001*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0086\u0008¢\u0006\u0004\u0008\u000f\u0010\u0010\u001a.\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0006\u0008\u0000\u0010\u0006\u0018\u0001*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0086\u0008¢\u0006\u0004\u0008\u000f\u0010\u0011\u001a&\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0006\u0008\u0000\u0010\u0006\u0018\u0001*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0086\u0008¢\u0006\u0004\u0008\u000f\u0010\u0014\u001a.\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0006\u0008\u0000\u0010\u0006\u0018\u0001*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\nH\u0086\u0008¢\u0006\u0004\u0008\u000f\u0010\u0015\u001a \u0010\u0008\u001a\u00028\u0000\"\n\u0008\u0000\u0010\u0006\u0018\u0001*\u00020\u0016*\u00020\u0017H\u0086\u0008¢\u0006\u0004\u0008\u0008\u0010\u0018\u001a(\u0010\u0008\u001a\u00028\u0000\"\n\u0008\u0000\u0010\u0006\u0018\u0001*\u00020\u0016*\u00020\u00172\u0006\u0010\u000b\u001a\u00020\nH\u0086\u0008¢\u0006\u0004\u0008\u0008\u0010\u0019\u001a&\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001b\"\n\u0008\u0000\u0010\u0006\u0018\u0001*\u00020\u0016*\u00020\u001aH\u0086\u0008¢\u0006\u0004\u0008\u001c\u0010\u001d\u001a.\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001b\"\n\u0008\u0000\u0010\u0006\u0018\u0001*\u00020\u0016*\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\nH\u0086\u0008¢\u0006\u0004\u0008\u001c\u0010\u001e\u001a!\u0010$\u001a\u00020#2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f¢\u0006\u0004\u0008$\u0010%\"\u0017\u0010\u0004\u001a\u00020\u0003*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\u0008&\u0010'\"\u0016\u0010(\u001a\u00020\r8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008(\u0010)¨\u0006*", d2 = {"Lcom/google/firebase/ktx/Firebase;", "Lcom/google/firebase/FirebaseApp;", "app", "Lcom/google/firebase/firestore/FirebaseFirestore;", "firestore", "(Lcom/google/firebase/ktx/Firebase;Lcom/google/firebase/FirebaseApp;)Lcom/google/firebase/firestore/FirebaseFirestore;", "T", "Lcom/google/firebase/firestore/DocumentSnapshot;", "toObject", "(Lcom/google/firebase/firestore/DocumentSnapshot;)Ljava/lang/Object;", "Lcom/google/firebase/firestore/DocumentSnapshot$ServerTimestampBehavior;", "serverTimestampBehavior", "(Lcom/google/firebase/firestore/DocumentSnapshot;Lcom/google/firebase/firestore/DocumentSnapshot$ServerTimestampBehavior;)Ljava/lang/Object;", "", "field", "getField", "(Lcom/google/firebase/firestore/DocumentSnapshot;Ljava/lang/String;)Ljava/lang/Object;", "(Lcom/google/firebase/firestore/DocumentSnapshot;Ljava/lang/String;Lcom/google/firebase/firestore/DocumentSnapshot$ServerTimestampBehavior;)Ljava/lang/Object;", "Lcom/google/firebase/firestore/FieldPath;", "fieldPath", "(Lcom/google/firebase/firestore/DocumentSnapshot;Lcom/google/firebase/firestore/FieldPath;)Ljava/lang/Object;", "(Lcom/google/firebase/firestore/DocumentSnapshot;Lcom/google/firebase/firestore/FieldPath;Lcom/google/firebase/firestore/DocumentSnapshot$ServerTimestampBehavior;)Ljava/lang/Object;", "", "Lcom/google/firebase/firestore/QueryDocumentSnapshot;", "(Lcom/google/firebase/firestore/QueryDocumentSnapshot;)Ljava/lang/Object;", "(Lcom/google/firebase/firestore/QueryDocumentSnapshot;Lcom/google/firebase/firestore/DocumentSnapshot$ServerTimestampBehavior;)Ljava/lang/Object;", "Lcom/google/firebase/firestore/QuerySnapshot;", "", "toObjects", "(Lcom/google/firebase/firestore/QuerySnapshot;)Ljava/util/List;", "(Lcom/google/firebase/firestore/QuerySnapshot;Lcom/google/firebase/firestore/DocumentSnapshot$ServerTimestampBehavior;)Ljava/util/List;", "Lkotlin/Function1;", "Lcom/google/firebase/firestore/FirebaseFirestoreSettings$Builder;", "Lkotlin/w;", "init", "Lcom/google/firebase/firestore/FirebaseFirestoreSettings;", "firestoreSettings", "(Lkotlin/d0/c/l;)Lcom/google/firebase/firestore/FirebaseFirestoreSettings;", "getFirestore", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/firestore/FirebaseFirestore;", "LIBRARY_NAME", "Ljava/lang/String;", "com.google.firebase-firebase-firestore-ktx"}, k = 2, mv = {1, 4, 0})
public final class FirestoreKt {

    public static final String LIBRARY_NAME = "fire-fst-ktx";
    public static final FirebaseFirestore firestore(Firebase firebase, FirebaseApp firebaseApp2) {
        n.g(firebase, "$this$firestore");
        n.g(firebaseApp2, "app");
        FirebaseFirestore obj1 = FirebaseFirestore.getInstance(firebaseApp2);
        n.c(obj1, "FirebaseFirestore.getInstance(app)");
        return obj1;
    }

    public static final FirebaseFirestoreSettings firestoreSettings(l<? super FirebaseFirestoreSettings.Builder, w> l) {
        n.g(l, "init");
        FirebaseFirestoreSettings.Builder builder = new FirebaseFirestoreSettings.Builder();
        l.invoke(builder);
        final FirebaseFirestoreSettings obj1 = builder.build();
        n.c(obj1, "builder.build()");
        return obj1;
    }

    public static final <T> T getField(DocumentSnapshot documentSnapshot, FieldPath fieldPath2) {
        n.g(documentSnapshot, "$this$getField");
        n.g(fieldPath2, "fieldPath");
        n.l(4, "T");
        throw 0;
    }

    public static final <T> T getField(DocumentSnapshot documentSnapshot, FieldPath fieldPath2, DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior3) {
        n.g(documentSnapshot, "$this$getField");
        n.g(fieldPath2, "fieldPath");
        n.g(serverTimestampBehavior3, "serverTimestampBehavior");
        n.l(4, "T");
        throw 0;
    }

    public static final <T> T getField(DocumentSnapshot documentSnapshot, String string2) {
        n.g(documentSnapshot, "$this$getField");
        n.g(string2, "field");
        n.l(4, "T");
        throw 0;
    }

    public static final <T> T getField(DocumentSnapshot documentSnapshot, String string2, DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior3) {
        n.g(documentSnapshot, "$this$getField");
        n.g(string2, "field");
        n.g(serverTimestampBehavior3, "serverTimestampBehavior");
        n.l(4, "T");
        throw 0;
    }

    public static final FirebaseFirestore getFirestore(Firebase firebase) {
        n.g(firebase, "$this$firestore");
        final FirebaseFirestore obj1 = FirebaseFirestore.getInstance();
        n.c(obj1, "FirebaseFirestore.getInstance()");
        return obj1;
    }

    public static final <T> T toObject(DocumentSnapshot documentSnapshot) {
        n.g(documentSnapshot, "$this$toObject");
        n.l(4, "T");
        throw 0;
    }

    public static final <T> T toObject(DocumentSnapshot documentSnapshot, DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior2) {
        n.g(documentSnapshot, "$this$toObject");
        n.g(serverTimestampBehavior2, "serverTimestampBehavior");
        n.l(4, "T");
        throw 0;
    }

    public static final <T> T toObject(QueryDocumentSnapshot queryDocumentSnapshot) {
        n.g(queryDocumentSnapshot, "$this$toObject");
        n.l(4, "T");
        throw 0;
    }

    public static final <T> T toObject(QueryDocumentSnapshot queryDocumentSnapshot, DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior2) {
        n.g(queryDocumentSnapshot, "$this$toObject");
        n.g(serverTimestampBehavior2, "serverTimestampBehavior");
        n.l(4, "T");
        throw 0;
    }

    public static final <T> List<T> toObjects(QuerySnapshot querySnapshot) {
        n.g(querySnapshot, "$this$toObjects");
        n.l(4, "T");
        throw 0;
    }

    public static final <T> List<T> toObjects(QuerySnapshot querySnapshot, DocumentSnapshot.ServerTimestampBehavior documentSnapshot$ServerTimestampBehavior2) {
        n.g(querySnapshot, "$this$toObjects");
        n.g(serverTimestampBehavior2, "serverTimestampBehavior");
        n.l(4, "T");
        throw 0;
    }
}
