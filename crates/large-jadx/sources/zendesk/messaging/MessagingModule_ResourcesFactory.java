package zendesk.messaging;

import android.content.Context;
import android.content.res.Resources;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class MessagingModule_ResourcesFactory implements b<Resources> {

    private final a<Context> contextProvider;
    public MessagingModule_ResourcesFactory(a<Context> a) {
        super();
        this.contextProvider = a;
    }

    public static zendesk.messaging.MessagingModule_ResourcesFactory create(a<Context> a) {
        MessagingModule_ResourcesFactory messagingModule_ResourcesFactory = new MessagingModule_ResourcesFactory(a);
        return messagingModule_ResourcesFactory;
    }

    public static Resources resources(Context context) {
        final Resources obj1 = MessagingModule.resources(context);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (Resources)obj1;
    }

    @Override // g.b.b
    public Resources get() {
        return MessagingModule_ResourcesFactory.resources((Context)this.contextProvider.get());
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
