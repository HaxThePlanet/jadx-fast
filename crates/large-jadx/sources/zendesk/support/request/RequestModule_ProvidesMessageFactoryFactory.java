package zendesk.support.request;

import android.content.Context;
import com.squareup.picasso.t;
import g.b.b;
import g.b.d;
import j.a.a;
import o.a.b;
import o.b.f;
import zendesk.core.ActionHandlerRegistry;

/* loaded from: classes3.dex */
public final class RequestModule_ProvidesMessageFactoryFactory implements b<zendesk.support.request.CellFactory> {

    private final a<zendesk.support.request.ActionFactory> actionFactoryProvider;
    private final a<b> configHelperProvider;
    private final a<Context> contextProvider;
    private final a<f> dispatcherProvider;
    private final zendesk.support.request.RequestModule module;
    private final a<t> picassoProvider;
    private final a<ActionHandlerRegistry> registryProvider;
    public RequestModule_ProvidesMessageFactoryFactory(zendesk.support.request.RequestModule requestModule, a<Context> a2, a<t> a3, a<zendesk.support.request.ActionFactory> a4, a<f> a5, a<ActionHandlerRegistry> a6, a<b> a7) {
        super();
        this.module = requestModule;
        this.contextProvider = a2;
        this.picassoProvider = a3;
        this.actionFactoryProvider = a4;
        this.dispatcherProvider = a5;
        this.registryProvider = a6;
        this.configHelperProvider = a7;
    }

    public static zendesk.support.request.RequestModule_ProvidesMessageFactoryFactory create(zendesk.support.request.RequestModule requestModule, a<Context> a2, a<t> a3, a<zendesk.support.request.ActionFactory> a4, a<f> a5, a<ActionHandlerRegistry> a6, a<b> a7) {
        super(requestModule, a2, a3, a4, a5, a6, a7);
        return requestModule_ProvidesMessageFactoryFactory;
    }

    public static zendesk.support.request.CellFactory providesMessageFactory(zendesk.support.request.RequestModule requestModule, Context context2, t t3, Object object4, f f5, ActionHandlerRegistry actionHandlerRegistry6, b b7) {
        final zendesk.support.request.CellFactory obj7 = requestModule.providesMessageFactory(context2, t3, (ActionFactory)object4, f5, actionHandlerRegistry6, b7);
        d.c(obj7, "Cannot return null from a non-@Nullable @Provides method");
        return (CellFactory)obj7;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.request.CellFactory get() {
        return RequestModule_ProvidesMessageFactoryFactory.providesMessageFactory(this.module, (Context)this.contextProvider.get(), (t)this.picassoProvider.get(), this.actionFactoryProvider.get(), (f)this.dispatcherProvider.get(), (ActionHandlerRegistry)this.registryProvider.get(), (b)this.configHelperProvider.get());
    }
}
