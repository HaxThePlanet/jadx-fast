package zendesk.messaging;

import androidx.appcompat.app.d;

/* loaded from: classes3.dex */
interface MessagingActivityComponent {

    public interface Builder {
        public abstract zendesk.messaging.MessagingActivityComponent.Builder activity(d d);

        public abstract zendesk.messaging.MessagingActivityComponent build();

        public abstract zendesk.messaging.MessagingActivityComponent.Builder messagingComponent(zendesk.messaging.MessagingComponent messagingComponent);
    }
    public abstract void inject(zendesk.messaging.MessagingActivity messagingActivity);
}
