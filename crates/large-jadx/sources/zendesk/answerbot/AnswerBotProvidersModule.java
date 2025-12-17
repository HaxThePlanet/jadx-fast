package zendesk.answerbot;

import java.util.UUID;
import zendesk.core.RestServiceProvider;
import zendesk.core.SettingsProvider;
import zendesk.core.ZendeskLocaleConverter;
import zendesk.support.Guide;
import zendesk.support.HelpCenterProvider;

/* loaded from: classes3.dex */
class AnswerBotProvidersModule {

    private final String interactionReference;
    AnswerBotProvidersModule() {
        super();
        this.interactionReference = UUID.randomUUID().toString();
    }

    zendesk.answerbot.AnswerBotProvider getAnswerBotProvider(zendesk.answerbot.AnswerBotService answerBotService, zendesk.answerbot.LocaleProvider localeProvider2, HelpCenterProvider helpCenterProvider3, zendesk.answerbot.AnswerBotSettingsProvider answerBotSettingsProvider4) {
        super(answerBotService, localeProvider2, this.interactionReference, helpCenterProvider3, answerBotSettingsProvider4);
        return zendeskAnswerBotProvider2;
    }

    zendesk.answerbot.AnswerBotService getAnswerBotService(RestServiceProvider restServiceProvider) {
        return (AnswerBotService)restServiceProvider.createRestService(AnswerBotService.class, "3.0.2", "AnswerBot");
    }

    zendesk.answerbot.AnswerBotSettingsProvider getAnswerBotSettingsProvider(SettingsProvider settingsProvider) {
        ZendeskAnswerBotSettingsProvider zendeskAnswerBotSettingsProvider = new ZendeskAnswerBotSettingsProvider(settingsProvider);
        return zendeskAnswerBotSettingsProvider;
    }

    zendesk.answerbot.AnswerBotModule getAnswerBotShadow(zendesk.answerbot.AnswerBotProvider answerBotProvider, zendesk.answerbot.AnswerBotSettingsProvider answerBotSettingsProvider2) {
        AnswerBotModule answerBotModule = new AnswerBotModule(answerBotProvider, answerBotSettingsProvider2);
        return answerBotModule;
    }

    HelpCenterProvider getHelpCenterProvider() {
        return Guide.INSTANCE.provider();
    }

    zendesk.answerbot.LocaleProvider getLocaleProvider(SettingsProvider settingsProvider) {
        ZendeskLocaleConverter zendeskLocaleConverter = new ZendeskLocaleConverter();
        LocaleProvider localeProvider = new LocaleProvider(Guide.INSTANCE, settingsProvider, zendeskLocaleConverter);
        return localeProvider;
    }
}
