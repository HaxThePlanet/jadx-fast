package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import o.a.b;
import zendesk.core.AuthenticationProvider;
import zendesk.messaging.MessagingItem;
import zendesk.messaging.components.bot.BotMessageDispatcher;

/* loaded from: classes3.dex */
public final class SupportEngineModule_SupportEngineModelFactory implements b<zendesk.support.SupportEngineModel> {

    private final a<AuthenticationProvider> authenticationProvider;
    private final a<BotMessageDispatcher<MessagingItem>> botMessageDispatcherProvider;
    private final a<b> configurationHelperProvider;
    private final a<zendesk.support.EmailValidator> emailValidatorProvider;
    private final zendesk.support.SupportEngineModule module;
    private final a<zendesk.support.RequestCreator> requestCreatorProvider;
    private final a<zendesk.support.SupportSettingsProvider> settingsProvider;
    public SupportEngineModule_SupportEngineModelFactory(zendesk.support.SupportEngineModule supportEngineModule, a<zendesk.support.SupportSettingsProvider> a2, a<zendesk.support.RequestCreator> a3, a<AuthenticationProvider> a4, a<b> a5, a<zendesk.support.EmailValidator> a6, a<BotMessageDispatcher<MessagingItem>> a7) {
        super();
        this.module = supportEngineModule;
        this.settingsProvider = a2;
        this.requestCreatorProvider = a3;
        this.authenticationProvider = a4;
        this.configurationHelperProvider = a5;
        this.emailValidatorProvider = a6;
        this.botMessageDispatcherProvider = a7;
    }

    public static zendesk.support.SupportEngineModule_SupportEngineModelFactory create(zendesk.support.SupportEngineModule supportEngineModule, a<zendesk.support.SupportSettingsProvider> a2, a<zendesk.support.RequestCreator> a3, a<AuthenticationProvider> a4, a<b> a5, a<zendesk.support.EmailValidator> a6, a<BotMessageDispatcher<MessagingItem>> a7) {
        super(supportEngineModule, a2, a3, a4, a5, a6, a7);
        return supportEngineModule_SupportEngineModelFactory;
    }

    public static zendesk.support.SupportEngineModel supportEngineModel(zendesk.support.SupportEngineModule supportEngineModule, zendesk.support.SupportSettingsProvider supportSettingsProvider2, zendesk.support.RequestCreator requestCreator3, AuthenticationProvider authenticationProvider4, b b5, Object object6, BotMessageDispatcher<MessagingItem> botMessageDispatcher7) {
        final zendesk.support.SupportEngineModel obj7 = supportEngineModule.supportEngineModel(supportSettingsProvider2, requestCreator3, authenticationProvider4, b5, (EmailValidator)object6, botMessageDispatcher7);
        d.c(obj7, "Cannot return null from a non-@Nullable @Provides method");
        return (SupportEngineModel)obj7;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.SupportEngineModel get() {
        return SupportEngineModule_SupportEngineModelFactory.supportEngineModel(this.module, (SupportSettingsProvider)this.settingsProvider.get(), (RequestCreator)this.requestCreatorProvider.get(), (AuthenticationProvider)this.authenticationProvider.get(), (b)this.configurationHelperProvider.get(), this.emailValidatorProvider.get(), (BotMessageDispatcher)this.botMessageDispatcherProvider.get());
    }
}
