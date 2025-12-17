package zendesk.messaging;

import g.b.b;
import j.a.a;

/* loaded from: classes3.dex */
public final class MessagingActivityModule_MultilineResponseOptionsEnabledFactory implements b<Boolean> {

    private final a<zendesk.messaging.MessagingComponent> messagingComponentProvider;
    public MessagingActivityModule_MultilineResponseOptionsEnabledFactory(a<zendesk.messaging.MessagingComponent> a) {
        super();
        this.messagingComponentProvider = a;
    }

    public static zendesk.messaging.MessagingActivityModule_MultilineResponseOptionsEnabledFactory create(a<zendesk.messaging.MessagingComponent> a) {
        MessagingActivityModule_MultilineResponseOptionsEnabledFactory messagingActivityModule_MultilineResponseOptionsEnabledFactory = new MessagingActivityModule_MultilineResponseOptionsEnabledFactory(a);
        return messagingActivityModule_MultilineResponseOptionsEnabledFactory;
    }

    public static boolean multilineResponseOptionsEnabled(Object object) {
        return MessagingActivityModule.multilineResponseOptionsEnabled((MessagingComponent)object);
    }

    @Override // g.b.b
    public Boolean get() {
        return Boolean.valueOf(MessagingActivityModule_MultilineResponseOptionsEnabledFactory.multilineResponseOptionsEnabled(this.messagingComponentProvider.get()));
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
