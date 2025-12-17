package zendesk.support;

import android.content.Context;
import f.g.c.a;
import java.util.Locale;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.AuthenticationProvider;
import zendesk.core.CoreModule;
import zendesk.core.Zendesk;

/* loaded from: classes3.dex */
public enum Support {

    INSTANCE;

    ActionHandlerRegistry actionHandlerRegistry;
    private zendesk.support.ApplicationScope applicationScope;
    AuthenticationProvider authenticationProvider;
    zendesk.support.SupportBlipsProvider blipsProvider;
    private boolean initialised;
    zendesk.support.ProviderStore providerStore;
    zendesk.support.RequestMigrator requestMigrator;
    zendesk.support.RequestProvider requestProvider;
    zendesk.support.SupportModule supportModule;
    private void initApplicationScope(CoreModule coreModule, zendesk.support.ApplicationScope applicationScope2) {
        this.applicationScope = applicationScope2;
        final zendesk.support.Guide iNSTANCE = Guide.INSTANCE;
        iNSTANCE.init(Zendesk.INSTANCE);
        ProviderModule providerModule = new ProviderModule();
        StorageModule storageModule = new StorageModule();
        SupportApplicationModule supportApplicationModule = new SupportApplicationModule(applicationScope2);
        DaggerSupportSdkProvidersComponent.builder().coreModule(coreModule).providerModule(providerModule).storageModule(storageModule).supportApplicationModule(supportApplicationModule).guideModule(iNSTANCE.guideModule()).build().inject(this);
    }

    @Override // java.lang.Enum
    public Locale getHelpCenterLocaleOverride() {
        return Guide.INSTANCE.getHelpCenterLocaleOverride();
    }

    @Override // java.lang.Enum
    zendesk.support.SupportModule getSupportModule() {
        return this.supportModule;
    }

    @Override // java.lang.Enum
    public void init(Zendesk zendesk) {
        Object build;
        String str;
        int obj3;
        if (zendesk.isInitialized()) {
            ApplicationScope.Builder builder = new ApplicationScope.Builder();
            initApplicationScope(zendesk.coreModule(), builder.build());
            this.initialised = true;
        } else {
            a.e("ZendeskConfiguration", "Cannot use SupportSDK without initializing Zendesk. Call Zendesk.INSTANCE.init(...)", new Object[0]);
        }
    }

    @Override // java.lang.Enum
    void installTracker(zendesk.support.ZendeskTracker zendeskTracker) {
        initApplicationScope(Zendesk.INSTANCE.coreModule(), this.applicationScope.newBuilder().zendeskTracker(zendeskTracker).build());
    }

    @Override // java.lang.Enum
    boolean isAuthenticated() {
        Object authenticationProvider;
        int i;
        authenticationProvider = this.authenticationProvider;
        if (authenticationProvider != null && authenticationProvider.getIdentity() != null) {
            i = authenticationProvider.getIdentity() != null ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.lang.Enum
    public boolean isInitialized() {
        return this.initialised;
    }

    @Override // java.lang.Enum
    public zendesk.support.ProviderStore provider() {
        final int i = 0;
        int i2 = 0;
        final String str3 = "ZendeskConfiguration";
        if (!isInitialized()) {
            a.e(str3, "Cannot get ProviderStore before SDK has been initialized. init() must be called before provider().", new Object[i2]);
            return i;
        }
        if (!isAuthenticated()) {
            a.e(str3, "Cannot get ProviderStore before an identity has been set. Zendesk.INSTANCE.setIdentity() must be called before provider().", new Object[i2]);
            return i;
        }
        return this.providerStore;
    }

    @Override // java.lang.Enum
    public boolean refreshRequest(String string, Context context2) {
        Object obj6;
        String str = "ZendeskConfiguration";
        final int i2 = 0;
        if (!isInitialized()) {
            a.e(str, "Cannot use Support SDK without initializing Zendesk. Call Zendesk.INSTANCE.init(...) and Support.INSTANCE.init(Zendesk)", new Object[i2]);
            return i2;
        }
        if (!isAuthenticated()) {
            a.e(str, "Cannot use Support SDK without setting an identity. Zendesk.INSTANCE.setIdentity(...) must be called before refreshRequest(...).", new Object[i2]);
            return i2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("request_conversation_refresh");
        stringBuilder.append(string);
        ActionHandler handlerByAction = this.actionHandlerRegistry.handlerByAction(stringBuilder.toString());
        int i = 0;
        if (handlerByAction != null) {
            handlerByAction.handle(i, context2);
            return 1;
        }
        ActionHandler handlerByAction2 = this.actionHandlerRegistry.handlerByAction("request_list_refresh");
        if (handlerByAction2 != null) {
            handlerByAction2.handle(i, context2);
        } else {
            this.requestProvider.markRequestAsUnread(string);
        }
        return i2;
    }

    @Override // java.lang.Enum
    void reset() {
        this.initialised = false;
    }

    @Override // java.lang.Enum
    public void setHelpCenterLocaleOverride(Locale locale) {
        Guide.INSTANCE.setHelpCenterLocaleOverride(locale);
    }
}
