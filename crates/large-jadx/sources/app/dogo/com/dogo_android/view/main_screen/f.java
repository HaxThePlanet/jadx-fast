package app.dogo.com.dogo_android.view.main_screen;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes.dex */
public final class f implements FirebaseInAppMessagingDisplay {

    public final app.dogo.com.dogo_android.view.main_screen.MainScreenActivity a;
    public f(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity) {
        super();
        this.a = mainScreenActivity;
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
    public final void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks2) {
        MainScreenActivity.a1(this.a, inAppMessage, firebaseInAppMessagingDisplayCallbacks2);
    }
}
