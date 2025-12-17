package com.google.firebase.inappmessaging.display.ktx;

import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay;
import com.google.firebase.ktx.Firebase;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\"\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Lcom/google/firebase/ktx/Firebase;", "Lcom/google/firebase/inappmessaging/display/FirebaseInAppMessagingDisplay;", "getInAppMessagingDisplay", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/inappmessaging/display/FirebaseInAppMessagingDisplay;", "inAppMessagingDisplay", "", "LIBRARY_NAME", "Ljava/lang/String;", "com.google.firebase-firebase-inappmessaging-display-ktx"}, k = 2, mv = {1, 4, 0})
public final class InAppMessagingDisplayKt {

    public static final String LIBRARY_NAME = "fire-iamd-ktx";
    public static final FirebaseInAppMessagingDisplay getInAppMessagingDisplay(Firebase firebase) {
        n.g(firebase, "$this$inAppMessagingDisplay");
        final FirebaseInAppMessagingDisplay obj1 = FirebaseInAppMessagingDisplay.getInstance();
        n.c(obj1, "FirebaseInAppMessagingDisplay.getInstance()");
        return obj1;
    }
}
