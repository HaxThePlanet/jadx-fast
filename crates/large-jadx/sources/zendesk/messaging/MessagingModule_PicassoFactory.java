package zendesk.messaging;

import android.content.Context;
import com.squareup.picasso.t;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class MessagingModule_PicassoFactory implements b<t> {

    private final a<Context> contextProvider;
    public MessagingModule_PicassoFactory(a<Context> a) {
        super();
        this.contextProvider = a;
    }

    public static zendesk.messaging.MessagingModule_PicassoFactory create(a<Context> a) {
        MessagingModule_PicassoFactory messagingModule_PicassoFactory = new MessagingModule_PicassoFactory(a);
        return messagingModule_PicassoFactory;
    }

    public static t picasso(Context context) {
        final t obj1 = MessagingModule.picasso(context);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (t)obj1;
    }

    @Override // g.b.b
    public t get() {
        return MessagingModule_PicassoFactory.picasso((Context)this.contextProvider.get());
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}
