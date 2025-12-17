package zendesk.support.request;

import g.b.b;
import g.b.d;
import j.a.a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import zendesk.belvedere.a;
import zendesk.core.AuthenticationProvider;
import zendesk.support.RequestProvider;
import zendesk.support.SupportBlipsProvider;
import zendesk.support.SupportSettingsProvider;
import zendesk.support.SupportUiStorage;
import zendesk.support.UploadProvider;

/* loaded from: classes3.dex */
public final class RequestModule_ProvidesActionFactoryFactory implements b<zendesk.support.request.ActionFactory> {

    private final a<AuthenticationProvider> authProvider;
    private final a<a> belvedereProvider;
    private final a<SupportBlipsProvider> blipsProvider;
    private final a<ExecutorService> executorProvider;
    private final a<Executor> mainThreadExecutorProvider;
    private final a<RequestProvider> requestProvider;
    private final a<SupportSettingsProvider> settingsProvider;
    private final a<SupportUiStorage> supportUiStorageProvider;
    private final a<UploadProvider> uploadProvider;
    public RequestModule_ProvidesActionFactoryFactory(a<RequestProvider> a, a<SupportSettingsProvider> a2, a<UploadProvider> a3, a<a> a4, a<SupportUiStorage> a5, a<ExecutorService> a6, a<Executor> a7, a<AuthenticationProvider> a8, a<SupportBlipsProvider> a9) {
        super();
        this.requestProvider = a;
        this.settingsProvider = a2;
        this.uploadProvider = a3;
        this.belvedereProvider = a4;
        this.supportUiStorageProvider = a5;
        this.executorProvider = a6;
        this.mainThreadExecutorProvider = a7;
        this.authProvider = a8;
        this.blipsProvider = a9;
    }

    public static zendesk.support.request.RequestModule_ProvidesActionFactoryFactory create(a<RequestProvider> a, a<SupportSettingsProvider> a2, a<UploadProvider> a3, a<a> a4, a<SupportUiStorage> a5, a<ExecutorService> a6, a<Executor> a7, a<AuthenticationProvider> a8, a<SupportBlipsProvider> a9) {
        super(a, a2, a3, a4, a5, a6, a7, a8, a9);
        return requestModule_ProvidesActionFactoryFactory;
    }

    public static zendesk.support.request.ActionFactory providesActionFactory(RequestProvider requestProvider, SupportSettingsProvider supportSettingsProvider2, UploadProvider uploadProvider3, a a4, SupportUiStorage supportUiStorage5, ExecutorService executorService6, Executor executor7, AuthenticationProvider authenticationProvider8, SupportBlipsProvider supportBlipsProvider9) {
        final zendesk.support.request.ActionFactory obj0 = RequestModule.providesActionFactory(requestProvider, supportSettingsProvider2, uploadProvider3, a4, supportUiStorage5, executorService6, executor7, authenticationProvider8, supportBlipsProvider9);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (ActionFactory)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.request.ActionFactory get() {
        return RequestModule_ProvidesActionFactoryFactory.providesActionFactory((RequestProvider)this.requestProvider.get(), (SupportSettingsProvider)this.settingsProvider.get(), (UploadProvider)this.uploadProvider.get(), (a)this.belvedereProvider.get(), (SupportUiStorage)this.supportUiStorageProvider.get(), (ExecutorService)this.executorProvider.get(), (Executor)this.mainThreadExecutorProvider.get(), (AuthenticationProvider)this.authProvider.get(), (SupportBlipsProvider)this.blipsProvider.get());
    }
}
