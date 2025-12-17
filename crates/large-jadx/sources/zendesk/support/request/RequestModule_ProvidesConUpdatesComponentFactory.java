package zendesk.support.request;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.ActionHandlerRegistry;
import zendesk.support.requestlist.RequestInfoDataSource.LocalDataSource;

/* loaded from: classes3.dex */
public final class RequestModule_ProvidesConUpdatesComponentFactory implements b<zendesk.support.request.ComponentUpdateActionHandlers> {

    private final a<ActionHandlerRegistry> actionHandlerRegistryProvider;
    private final a<Context> contextProvider;
    private final a<RequestInfoDataSource.LocalDataSource> dataSourceProvider;
    public RequestModule_ProvidesConUpdatesComponentFactory(a<Context> a, a<ActionHandlerRegistry> a2, a<RequestInfoDataSource.LocalDataSource> a3) {
        super();
        this.contextProvider = a;
        this.actionHandlerRegistryProvider = a2;
        this.dataSourceProvider = a3;
    }

    public static zendesk.support.request.RequestModule_ProvidesConUpdatesComponentFactory create(a<Context> a, a<ActionHandlerRegistry> a2, a<RequestInfoDataSource.LocalDataSource> a3) {
        RequestModule_ProvidesConUpdatesComponentFactory requestModule_ProvidesConUpdatesComponentFactory = new RequestModule_ProvidesConUpdatesComponentFactory(a, a2, a3);
        return requestModule_ProvidesConUpdatesComponentFactory;
    }

    public static zendesk.support.request.ComponentUpdateActionHandlers providesConUpdatesComponent(Context context, ActionHandlerRegistry actionHandlerRegistry2, RequestInfoDataSource.LocalDataSource requestInfoDataSource$LocalDataSource3) {
        final zendesk.support.request.ComponentUpdateActionHandlers obj0 = RequestModule.providesConUpdatesComponent(context, actionHandlerRegistry2, localDataSource3);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (ComponentUpdateActionHandlers)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.request.ComponentUpdateActionHandlers get() {
        return RequestModule_ProvidesConUpdatesComponentFactory.providesConUpdatesComponent((Context)this.contextProvider.get(), (ActionHandlerRegistry)this.actionHandlerRegistryProvider.get(), (RequestInfoDataSource.LocalDataSource)this.dataSourceProvider.get());
    }
}
