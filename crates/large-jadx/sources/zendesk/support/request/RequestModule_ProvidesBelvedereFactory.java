package zendesk.support.request;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.belvedere.a;

/* loaded from: classes3.dex */
public final class RequestModule_ProvidesBelvedereFactory implements b<a> {

    private final a<Context> contextProvider;
    public RequestModule_ProvidesBelvedereFactory(a<Context> a) {
        super();
        this.contextProvider = a;
    }

    public static zendesk.support.request.RequestModule_ProvidesBelvedereFactory create(a<Context> a) {
        RequestModule_ProvidesBelvedereFactory requestModule_ProvidesBelvedereFactory = new RequestModule_ProvidesBelvedereFactory(a);
        return requestModule_ProvidesBelvedereFactory;
    }

    public static a providesBelvedere(Context context) {
        final a obj1 = RequestModule.providesBelvedere(context);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (a)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public a get() {
        return RequestModule_ProvidesBelvedereFactory.providesBelvedere((Context)this.contextProvider.get());
    }
}
