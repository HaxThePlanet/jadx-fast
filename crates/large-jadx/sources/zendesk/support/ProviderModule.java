package zendesk.support;

import java.util.Locale;
import zendesk.core.AuthenticationProvider;
import zendesk.core.BlipsProvider;
import zendesk.core.RestServiceProvider;
import zendesk.core.SettingsProvider;
import zendesk.core.ZendeskLocaleConverter;

/* loaded from: classes3.dex */
class ProviderModule {
    zendesk.support.ProviderStore provideProviderStore(zendesk.support.HelpCenterProvider helpCenterProvider, zendesk.support.RequestProvider requestProvider2, zendesk.support.UploadProvider uploadProvider3) {
        ZendeskProviderStore zendeskProviderStore = new ZendeskProviderStore(helpCenterProvider, requestProvider2, uploadProvider3);
        return zendeskProviderStore;
    }

    zendesk.support.RequestProvider provideRequestProvider(zendesk.support.SupportSettingsProvider supportSettingsProvider, AuthenticationProvider authenticationProvider2, zendesk.support.ZendeskRequestService zendeskRequestService3, zendesk.support.RequestStorage requestStorage4, zendesk.support.RequestSessionCache requestSessionCache5, zendesk.support.ZendeskTracker zendeskTracker6, zendesk.support.SupportSdkMetadata supportSdkMetadata7, zendesk.support.SupportBlipsProvider supportBlipsProvider8) {
        super(supportSettingsProvider, zendeskRequestService3, authenticationProvider2, requestStorage4, requestSessionCache5, zendeskTracker6, supportSdkMetadata7, supportBlipsProvider8);
        return zendeskRequestProvider;
    }

    zendesk.support.SupportSettingsProvider provideSdkSettingsProvider(SettingsProvider settingsProvider, Locale locale2, ZendeskLocaleConverter zendeskLocaleConverter3) {
        ZendeskSupportSettingsProvider zendeskSupportSettingsProvider = new ZendeskSupportSettingsProvider(settingsProvider, zendeskLocaleConverter3, locale2);
        return zendeskSupportSettingsProvider;
    }

    zendesk.support.SupportBlipsProvider provideSupportBlipsProvider(BlipsProvider blipsProvider) {
        ZendeskSupportBlipsProvider zendeskSupportBlipsProvider = new ZendeskSupportBlipsProvider(blipsProvider);
        return zendeskSupportBlipsProvider;
    }

    zendesk.support.SupportModule provideSupportModule(zendesk.support.RequestProvider requestProvider, zendesk.support.UploadProvider uploadProvider2, zendesk.support.HelpCenterProvider helpCenterProvider3, zendesk.support.SupportSettingsProvider supportSettingsProvider4, RestServiceProvider restServiceProvider5, zendesk.support.SupportBlipsProvider supportBlipsProvider6, zendesk.support.ZendeskTracker zendeskTracker7, zendesk.support.ArticleVoteStorage articleVoteStorage8) {
        super(requestProvider, uploadProvider2, helpCenterProvider3, supportSettingsProvider4, supportBlipsProvider6, restServiceProvider5.getMediaOkHttpClient(), zendeskTracker7, articleVoteStorage8);
        return supportModule2;
    }

    zendesk.support.UploadProvider provideUploadProvider(zendesk.support.ZendeskUploadService zendeskUploadService) {
        ZendeskUploadProvider zendeskUploadProvider = new ZendeskUploadProvider(zendeskUploadService);
        return zendeskUploadProvider;
    }

    ZendeskLocaleConverter provideZendeskLocaleConverter() {
        ZendeskLocaleConverter zendeskLocaleConverter = new ZendeskLocaleConverter();
        return zendeskLocaleConverter;
    }
}
