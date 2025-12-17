package com.google.firebase.inappmessaging.ktx;

import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.ktx.Firebase;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\"\u0016\u0010\u0001\u001a\u00020\u00008\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0001\u0010\u0002\"\u0017\u0010\u0007\u001a\u00020\u0004*\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0008", d2 = {"", "LIBRARY_NAME", "Ljava/lang/String;", "Lcom/google/firebase/ktx/Firebase;", "Lcom/google/firebase/inappmessaging/FirebaseInAppMessaging;", "getInAppMessaging", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/inappmessaging/FirebaseInAppMessaging;", "inAppMessaging", "com.google.firebase-firebase-inappmessaging-ktx"}, k = 2, mv = {1, 4, 0})
public final class InAppMessagingKt {

    public static final String LIBRARY_NAME = "fire-iam-ktx";
    public static final FirebaseInAppMessaging getInAppMessaging(Firebase firebase) {
        n.g(firebase, "$this$inAppMessaging");
        final FirebaseInAppMessaging obj1 = FirebaseInAppMessaging.getInstance();
        n.c(obj1, "FirebaseInAppMessaging.getInstance()");
        return obj1;
    }
}
