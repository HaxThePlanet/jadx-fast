package com.google.firebase.inappmessaging.display;

import android.app.Activity;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes2.dex */
public final class a implements FirebaseInAppMessagingDisplay {

    public final com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay a;
    public final Activity b;
    public a(com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay, Activity activity2) {
        super();
        this.a = firebaseInAppMessagingDisplay;
        this.b = activity2;
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
    public final void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks2) {
        this.a.b(this.b, inAppMessage, firebaseInAppMessagingDisplayCallbacks2);
    }
}
