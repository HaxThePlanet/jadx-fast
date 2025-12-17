package zendesk.support.requestlist;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.MemoryCache;
import zendesk.support.SupportBlipsProvider;
import zendesk.support.SupportSettingsProvider;

/* loaded from: classes3.dex */
public final class RequestListModule_ModelFactory implements b<zendesk.support.requestlist.RequestListModel> {

    private final a<SupportBlipsProvider> blipsProvider;
    private final a<MemoryCache> memoryCacheProvider;
    private final zendesk.support.requestlist.RequestListModule module;
    private final a<zendesk.support.requestlist.RequestInfoDataSource.Repository> requestInfoDataSourceProvider;
    private final a<SupportSettingsProvider> settingsProvider;
    public RequestListModule_ModelFactory(zendesk.support.requestlist.RequestListModule requestListModule, a<zendesk.support.requestlist.RequestInfoDataSource.Repository> a2, a<MemoryCache> a3, a<SupportBlipsProvider> a4, a<SupportSettingsProvider> a5) {
        super();
        this.module = requestListModule;
        this.requestInfoDataSourceProvider = a2;
        this.memoryCacheProvider = a3;
        this.blipsProvider = a4;
        this.settingsProvider = a5;
    }

    public static zendesk.support.requestlist.RequestListModule_ModelFactory create(zendesk.support.requestlist.RequestListModule requestListModule, a<zendesk.support.requestlist.RequestInfoDataSource.Repository> a2, a<MemoryCache> a3, a<SupportBlipsProvider> a4, a<SupportSettingsProvider> a5) {
        super(requestListModule, a2, a3, a4, a5);
        return requestListModule_ModelFactory;
    }

    public static zendesk.support.requestlist.RequestListModel model(zendesk.support.requestlist.RequestListModule requestListModule, zendesk.support.requestlist.RequestInfoDataSource.Repository requestInfoDataSource$Repository2, MemoryCache memoryCache3, SupportBlipsProvider supportBlipsProvider4, SupportSettingsProvider supportSettingsProvider5) {
        final zendesk.support.requestlist.RequestListModel obj0 = requestListModule.model(repository2, memoryCache3, supportBlipsProvider4, supportSettingsProvider5);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (RequestListModel)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.requestlist.RequestListModel get() {
        return RequestListModule_ModelFactory.model(this.module, (RequestInfoDataSource.Repository)this.requestInfoDataSourceProvider.get(), (MemoryCache)this.memoryCacheProvider.get(), (SupportBlipsProvider)this.blipsProvider.get(), (SupportSettingsProvider)this.settingsProvider.get());
    }
}
