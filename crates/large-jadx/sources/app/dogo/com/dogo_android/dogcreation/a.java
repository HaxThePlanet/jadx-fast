package app.dogo.com.dogo_android.dogcreation;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes.dex */
public final class a implements FirebaseInAppMessagingDisplay {

    public final app.dogo.com.dogo_android.dogcreation.DogCreationActivity a;
    public a(app.dogo.com.dogo_android.dogcreation.DogCreationActivity dogCreationActivity) {
        super();
        this.a = dogCreationActivity;
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
    public final void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks2) {
        DogCreationActivity.o(this.a, inAppMessage, firebaseInAppMessagingDisplayCallbacks2);
    }
}
