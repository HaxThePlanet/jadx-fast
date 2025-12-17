package zendesk.messaging;

import com.squareup.picasso.t;
import g.a;
import zendesk.messaging.ui.MessagingCellFactory;
import zendesk.messaging.ui.MessagingComposer;

/* loaded from: classes3.dex */
public final class MessagingActivity_MembersInjector implements a<zendesk.messaging.MessagingActivity> {
    public static void injectEventFactory(zendesk.messaging.MessagingActivity messagingActivity, zendesk.messaging.EventFactory eventFactory2) {
        messagingActivity.eventFactory = eventFactory2;
    }

    public static void injectMessagingCellFactory(zendesk.messaging.MessagingActivity messagingActivity, MessagingCellFactory messagingCellFactory2) {
        messagingActivity.messagingCellFactory = messagingCellFactory2;
    }

    public static void injectMessagingComposer(zendesk.messaging.MessagingActivity messagingActivity, MessagingComposer messagingComposer2) {
        messagingActivity.messagingComposer = messagingComposer2;
    }

    public static void injectMessagingDialog(zendesk.messaging.MessagingActivity messagingActivity, Object object2) {
        messagingActivity.messagingDialog = (MessagingDialog)object2;
    }

    public static void injectPicasso(zendesk.messaging.MessagingActivity messagingActivity, t t2) {
        messagingActivity.picasso = t2;
    }

    public static void injectViewModel(zendesk.messaging.MessagingActivity messagingActivity, zendesk.messaging.MessagingViewModel messagingViewModel2) {
        messagingActivity.viewModel = messagingViewModel2;
    }
}
