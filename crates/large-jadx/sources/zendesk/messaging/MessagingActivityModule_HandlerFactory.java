package zendesk.messaging;

import android.os.Handler;
import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class MessagingActivityModule_HandlerFactory implements b<Handler> {

    private static final zendesk.messaging.MessagingActivityModule_HandlerFactory INSTANCE;
    static {
        MessagingActivityModule_HandlerFactory messagingActivityModule_HandlerFactory = new MessagingActivityModule_HandlerFactory();
        MessagingActivityModule_HandlerFactory.INSTANCE = messagingActivityModule_HandlerFactory;
    }

    public static zendesk.messaging.MessagingActivityModule_HandlerFactory create() {
        return MessagingActivityModule_HandlerFactory.INSTANCE;
    }

    public static Handler handler() {
        final Handler handler = MessagingActivityModule.handler();
        d.c(handler, "Cannot return null from a non-@Nullable @Provides method");
        return (Handler)handler;
    }

    @Override // g.b.b
    public Handler get() {
        return MessagingActivityModule_HandlerFactory.handler();
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
