package zendesk.messaging;

import g.b.b;
import g.b.d;
import zendesk.messaging.components.DateProvider;

/* loaded from: classes3.dex */
public final class MessagingActivityModule_DateProviderFactory implements b<DateProvider> {

    private static final zendesk.messaging.MessagingActivityModule_DateProviderFactory INSTANCE;
    static {
        MessagingActivityModule_DateProviderFactory messagingActivityModule_DateProviderFactory = new MessagingActivityModule_DateProviderFactory();
        MessagingActivityModule_DateProviderFactory.INSTANCE = messagingActivityModule_DateProviderFactory;
    }

    public static zendesk.messaging.MessagingActivityModule_DateProviderFactory create() {
        return MessagingActivityModule_DateProviderFactory.INSTANCE;
    }

    public static DateProvider dateProvider() {
        final DateProvider dateProvider = MessagingActivityModule.dateProvider();
        d.c(dateProvider, "Cannot return null from a non-@Nullable @Provides method");
        return (DateProvider)dateProvider;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public DateProvider get() {
        return MessagingActivityModule_DateProviderFactory.dateProvider();
    }
}
