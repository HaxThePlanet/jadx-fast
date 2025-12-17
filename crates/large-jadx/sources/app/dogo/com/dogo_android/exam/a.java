package app.dogo.com.dogo_android.exam;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* loaded from: classes.dex */
public final class a implements FirebaseInAppMessagingDisplay {

    public final app.dogo.com.dogo_android.exam.ExamFlowActivity a;
    public a(app.dogo.com.dogo_android.exam.ExamFlowActivity examFlowActivity) {
        super();
        this.a = examFlowActivity;
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
    public final void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks2) {
        ExamFlowActivity.n(this.a, inAppMessage, firebaseInAppMessagingDisplayCallbacks2);
    }
}
