package zendesk.support;

import java.util.UUID;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public class GuideModule {

    private final zendesk.support.ArticleVoteStorage articleVoteStorage;
    private final zendesk.support.HelpCenterBlipsProvider blipsProvider;
    private final zendesk.support.HelpCenterProvider helpCenterProvider;
    private final zendesk.support.HelpCenterTracker helpCenterTracker;
    private final UUID id;
    private final OkHttpClient okHttpClient;
    private final zendesk.support.HelpCenterSettingsProvider settingsProvider;
    public GuideModule(zendesk.support.HelpCenterProvider helpCenterProvider, zendesk.support.HelpCenterSettingsProvider helpCenterSettingsProvider2, zendesk.support.HelpCenterBlipsProvider helpCenterBlipsProvider3, zendesk.support.HelpCenterTracker helpCenterTracker4, zendesk.support.ArticleVoteStorage articleVoteStorage5, OkHttpClient okHttpClient6) {
        super();
        this.helpCenterProvider = helpCenterProvider;
        this.settingsProvider = helpCenterSettingsProvider2;
        this.blipsProvider = helpCenterBlipsProvider3;
        this.helpCenterTracker = helpCenterTracker4;
        this.articleVoteStorage = articleVoteStorage5;
        this.okHttpClient = okHttpClient6;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return this.id;
    }

    zendesk.support.ArticleVoteStorage providesArticleVoteStorage() {
        return this.articleVoteStorage;
    }

    zendesk.support.HelpCenterBlipsProvider providesBlipsProvider() {
        return this.blipsProvider;
    }

    zendesk.support.HelpCenterProvider providesHelpCenterProvider() {
        return this.helpCenterProvider;
    }

    zendesk.support.HelpCenterTracker providesHelpCenterTracker() {
        return this.helpCenterTracker;
    }

    OkHttpClient providesOkHttpClient() {
        return this.okHttpClient;
    }

    zendesk.support.HelpCenterSettingsProvider providesSettingsProvider() {
        return this.settingsProvider;
    }
}
