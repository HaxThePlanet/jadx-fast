package zendesk.answerbot;

import androidx.lifecycle.v;
import androidx.lifecycle.x;
import zendesk.core.ApplicationConfiguration;
import zendesk.core.RestServiceProvider;
import zendesk.messaging.components.Timer.Factory;
import zendesk.support.HelpCenterProvider;

/* loaded from: classes3.dex */
class AnswerBotArticleModule {

    private final zendesk.answerbot.AnswerBotArticleConfiguration answerBotArticleUiConfig;
    private final HelpCenterProvider helpCenterProvider;
    AnswerBotArticleModule(zendesk.answerbot.AnswerBotArticleConfiguration answerBotArticleConfiguration, HelpCenterProvider helpCenterProvider2) {
        super();
        this.answerBotArticleUiConfig = answerBotArticleConfiguration;
        this.helpCenterProvider = helpCenterProvider2;
    }

    zendesk.answerbot.ArticleViewModel articleViewModel() {
        x xVar = new x();
        ArticleViewModel articleViewModel = new ArticleViewModel(this.helpCenterProvider, xVar, Long.valueOf(this.answerBotArticleUiConfig.getArticleId()), this.answerBotArticleUiConfig.getArticleTitle());
        return articleViewModel;
    }

    zendesk.answerbot.ArticleUrlIdentifier getArticleUrlIdentifier(ApplicationConfiguration applicationConfiguration) {
        ArticleUrlIdentifier articleUrlIdentifier = new ArticleUrlIdentifier(applicationConfiguration, this.helpCenterProvider);
        return articleUrlIdentifier;
    }

    zendesk.answerbot.AnswerBotArticleViewModel getViewModel(zendesk.answerbot.AnswerBotProvider answerBotProvider, zendesk.answerbot.ArticleViewModel articleViewModel2, Timer.Factory timer$Factory3, zendesk.answerbot.ArticleUrlIdentifier articleUrlIdentifier4) {
        v vVar = new v();
        super(this.answerBotArticleUiConfig, articleViewModel2, vVar, answerBotProvider, factory3, articleUrlIdentifier4);
        return answerBotArticleViewModel;
    }

    zendesk.answerbot.ZendeskWebViewClient getWebViewClient(ApplicationConfiguration applicationConfiguration, RestServiceProvider restServiceProvider2) {
        ZendeskWebViewClient zendeskWebViewClient = new ZendeskWebViewClient(applicationConfiguration.getZendeskUrl(), restServiceProvider2.getMediaOkHttpClient());
        return zendeskWebViewClient;
    }
}
