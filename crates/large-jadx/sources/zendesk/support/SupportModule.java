package zendesk.support;

import java.util.UUID;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public class SupportModule {

    private final zendesk.support.ArticleVoteStorage articleVoteStorage;
    private final zendesk.support.SupportBlipsProvider blipsProvider;
    private final zendesk.support.HelpCenterProvider helpCenterProvider;
    private final UUID id;
    private final OkHttpClient okHttpClient;
    private final zendesk.support.RequestProvider requestProvider;
    private final zendesk.support.SupportSettingsProvider settingsProvider;
    private final zendesk.support.UploadProvider uploadProvider;
    private final zendesk.support.ZendeskTracker zendeskTracker;
    public SupportModule(zendesk.support.RequestProvider requestProvider, zendesk.support.UploadProvider uploadProvider2, zendesk.support.HelpCenterProvider helpCenterProvider3, zendesk.support.SupportSettingsProvider supportSettingsProvider4, zendesk.support.SupportBlipsProvider supportBlipsProvider5, OkHttpClient okHttpClient6, zendesk.support.ZendeskTracker zendeskTracker7, zendesk.support.ArticleVoteStorage articleVoteStorage8) {
        super();
        this.id = UUID.randomUUID();
        this.requestProvider = requestProvider;
        this.uploadProvider = uploadProvider2;
        this.helpCenterProvider = helpCenterProvider3;
        this.settingsProvider = supportSettingsProvider4;
        this.blipsProvider = supportBlipsProvider5;
        this.okHttpClient = okHttpClient6;
        this.zendeskTracker = zendeskTracker7;
        this.articleVoteStorage = articleVoteStorage8;
    }

    public UUID getId() {
        return this.id;
    }

    zendesk.support.ArticleVoteStorage providesArticleVoteStorage() {
        return this.articleVoteStorage;
    }

    zendesk.support.SupportBlipsProvider providesBlipsProvider() {
        return this.blipsProvider;
    }

    zendesk.support.HelpCenterProvider providesHelpCenterProvider() {
        return this.helpCenterProvider;
    }

    OkHttpClient providesOkHttpClient() {
        return this.okHttpClient;
    }

    zendesk.support.RequestProvider providesRequestProvider() {
        return this.requestProvider;
    }

    zendesk.support.SupportSettingsProvider providesSettingsProvider() {
        return this.settingsProvider;
    }

    zendesk.support.UploadProvider providesUploadProvider() {
        return this.uploadProvider;
    }

    zendesk.support.ZendeskTracker providesZendeskTracker() {
        return this.zendeskTracker;
    }
}
