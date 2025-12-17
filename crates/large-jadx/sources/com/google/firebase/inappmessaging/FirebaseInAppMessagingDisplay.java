package com.google.firebase.inappmessaging;

import androidx.annotation.Keep;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes2.dex */
public interface FirebaseInAppMessagingDisplay {
    public abstract void displayMessage(InAppMessage inAppMessage, com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks2);
}
