package app.dogo.com.dogo_android.dogcreation;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements FirebaseInAppMessagingDisplay {

    public final /* synthetic */ DogCreationActivity a;
    public /* synthetic */ a(DogCreationActivity dogCreationActivity) {
        super();
        this.a = dogCreationActivity;
    }

    public final void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        DogCreationActivity.x(this.a, inAppMessage, firebaseInAppMessagingDisplayCallbacks);
    }
}
