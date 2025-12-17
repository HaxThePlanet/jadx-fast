package zendesk.messaging;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.belvedere.a;

/* loaded from: classes3.dex */
public final class MessagingModule_BelvedereFactory implements b<a> {

    private final a<Context> contextProvider;
    public MessagingModule_BelvedereFactory(a<Context> a) {
        super();
        this.contextProvider = a;
    }

    public static a belvedere(Context context) {
        final a obj1 = MessagingModule.belvedere(context);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (a)obj1;
    }

    public static zendesk.messaging.MessagingModule_BelvedereFactory create(a<Context> a) {
        MessagingModule_BelvedereFactory messagingModule_BelvedereFactory = new MessagingModule_BelvedereFactory(a);
        return messagingModule_BelvedereFactory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public a get() {
        return MessagingModule_BelvedereFactory.belvedere((Context)this.contextProvider.get());
    }
}
