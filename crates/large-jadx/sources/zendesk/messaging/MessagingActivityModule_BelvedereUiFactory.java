package zendesk.messaging;

import androidx.appcompat.app.d;
import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.belvedere.e;

/* loaded from: classes3.dex */
public final class MessagingActivityModule_BelvedereUiFactory implements b<e> {

    private final a<d> activityProvider;
    public MessagingActivityModule_BelvedereUiFactory(a<d> a) {
        super();
        this.activityProvider = a;
    }

    public static e belvedereUi(d d) {
        final e obj1 = MessagingActivityModule.belvedereUi(d);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (e)obj1;
    }

    public static zendesk.messaging.MessagingActivityModule_BelvedereUiFactory create(a<d> a) {
        MessagingActivityModule_BelvedereUiFactory messagingActivityModule_BelvedereUiFactory = new MessagingActivityModule_BelvedereUiFactory(a);
        return messagingActivityModule_BelvedereUiFactory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public e get() {
        return MessagingActivityModule_BelvedereUiFactory.belvedereUi((d)this.activityProvider.get());
    }
}
