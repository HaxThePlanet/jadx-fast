package app.dogo.com.dogo_android.exam;

import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements FirebaseInAppMessagingDisplay {

    public final /* synthetic */ ExamFlowActivity a;
    public /* synthetic */ a(ExamFlowActivity examFlowActivity) {
        super();
        this.a = examFlowActivity;
    }

    public final void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        ExamFlowActivity.o(this.a, inAppMessage, firebaseInAppMessagingDisplayCallbacks);
    }
}
