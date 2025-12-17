package com.google.firebase.inappmessaging;

import com.google.android.gms.tasks.j;
import com.google.firebase.inappmessaging.model.Action;

/* loaded from: classes2.dex */
public interface FirebaseInAppMessagingDisplayCallbacks {

    public static enum InAppMessagingDismissType {

        UNKNOWN_DISMISS_TYPE,
        AUTO,
        CLICK,
        SWIPE;
    }

    public static enum InAppMessagingErrorReason {

        UNSPECIFIED_RENDER_ERROR,
        IMAGE_FETCH_ERROR,
        IMAGE_DISPLAY_ERROR,
        IMAGE_UNSUPPORTED_FORMAT;
    }
    public abstract j<Void> displayErrorEncountered(com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason firebaseInAppMessagingDisplayCallbacks$InAppMessagingErrorReason);

    public abstract j<Void> impressionDetected();

    public abstract j<Void> messageClicked(Action action);

    public abstract j<Void> messageDismissed(com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType firebaseInAppMessagingDisplayCallbacks$InAppMessagingDismissType);
}
