package app.dogo.com.dogo_android.view.main_screen;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class f implements FirebaseInAppMessagingDisplay {

    public final /* synthetic */ MainScreenActivity a;
    public /* synthetic */ f(MainScreenActivity mainScreenActivity) {
        super();
        this.a = mainScreenActivity;
    }

    public final void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        MainScreenActivity.m1(this.a, inAppMessage, firebaseInAppMessagingDisplayCallbacks);
    }
}
