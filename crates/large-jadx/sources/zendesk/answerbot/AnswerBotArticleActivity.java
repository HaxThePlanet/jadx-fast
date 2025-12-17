package zendesk.answerbot;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import f.g.c.a;
import o.a.c;
import zendesk.commonui.a;
import zendesk.commonui.a.a;
import zendesk.messaging.components.Timer.Factory;

/* loaded from: classes3.dex */
public class AnswerBotArticleActivity extends d {

    private zendesk.answerbot.ArticleView articleView;
    Timer.Factory timerFactory;
    zendesk.answerbot.AnswerBotArticleViewModel viewModel;
    zendesk.answerbot.ZendeskWebViewClient zendeskWebViewClient;

    static class Renderer extends zendesk.answerbot.SafeObserver<zendesk.answerbot.AnswerBotArticleViewState> {

        private Activity activity;
        private final zendesk.answerbot.AnswerBotArticleResultRenderer articleResultRenderer;
        private final zendesk.answerbot.ArticleView articleView;
        private zendesk.answerbot.AnswerBotArticleViewState currentState = null;
        private zendesk.answerbot.AnswerBotArticleViewModel viewModel;
        Renderer(zendesk.answerbot.ArticleView articleView, zendesk.answerbot.AnswerBotArticleResultRenderer answerBotArticleResultRenderer2, zendesk.answerbot.AnswerBotArticleActivity answerBotArticleActivity3, zendesk.answerbot.AnswerBotArticleViewModel answerBotArticleViewModel4) {
            super();
            final int i = 0;
            this.articleView = articleView;
            this.articleResultRenderer = answerBotArticleResultRenderer2;
            this.activity = answerBotArticleActivity3;
            this.viewModel = answerBotArticleViewModel4;
        }

        @Override // zendesk.answerbot.SafeObserver
        void onUpdated(Object object) {
            onUpdated((AnswerBotArticleViewState)object);
        }

        @Override // zendesk.answerbot.SafeObserver
        void onUpdated(zendesk.answerbot.AnswerBotArticleViewState answerBotArticleViewState) {
            boolean articleViewState;
            Object articleResult2;
            Object articleResultRenderer;
            zendesk.answerbot.AnswerBotArticleResult aRTICLE_RELATED_DIDNT_ANSWER;
            int resultIntent;
            boolean articleResult;
            articleViewState = answerBotArticleViewState.getArticleViewState();
            articleResultRenderer = this.currentState;
            resultIntent = articleResultRenderer != null ? 1 : 0;
            if (resultIntent != null) {
                if (articleViewState != articleResultRenderer.getArticleViewState()) {
                    this.articleView.setTitle(articleViewState.getTitle());
                    this.articleView.showArticle(articleViewState.getArticle());
                    this.articleView.showError(articleViewState.isFailed());
                    this.articleView.showLoading(articleViewState.isLoading());
                }
            } else {
            }
            articleResult2 = answerBotArticleViewState.getArticleResult();
            if (resultIntent != null) {
                if (articleResult2 != this.currentState.getArticleResult()) {
                    this.articleResultRenderer.render(articleResult2);
                }
            } else {
            }
            if (articleResult2 != AnswerBotArticleResult.ARTICLE_NOT_RELATED) {
                if (articleResult2 == AnswerBotArticleResult.ARTICLE_RELATED_DIDNT_ANSWER) {
                    AnswerBotArticleConfiguration.Builder builder = new AnswerBotArticleConfiguration.Builder(this.viewModel.getAnswerBotArticleUiConfig());
                    this.activity.setResult(-1, builder.resultIntent(this.viewModel.getArticleResult()));
                    this.activity.finish();
                }
            } else {
            }
            this.currentState = answerBotArticleViewState;
        }
    }
    static zendesk.answerbot.AnswerBotArticleConfiguration.Builder builder(zendesk.answerbot.DeflectionResponse deflectionResponse, zendesk.answerbot.DeflectionArticle deflectionArticle2) {
        super(deflectionArticle2.getArticleId(), obj2, deflectionArticle2.getTitle(), deflectionResponse.getDeflection().getId(), obj5, deflectionResponse.getInteractionAccessToken());
        return builder2;
    }

    @Override // androidx.appcompat.app.d
    public void onBackPressed() {
        Object resultIntent;
        int sDK_INT;
        int i;
        zendesk.answerbot.AnswerBotArticleConfiguration.Builder builder;
        if (Build.VERSION.SDK_INT >= 25 && this.articleView.canGoBack()) {
            if (this.articleView.canGoBack()) {
                this.articleView.goBack();
            } else {
                zendesk.answerbot.AnswerBotArticleViewModel viewModel = this.viewModel;
                if (viewModel == null) {
                    setResult(0);
                } else {
                    builder = new AnswerBotArticleConfiguration.Builder(viewModel.getAnswerBotArticleUiConfig());
                    setResult(-1, builder.resultIntent(this.viewModel.getArticleResult()));
                }
                finish();
            }
        } else {
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getTheme().applyStyle(R.style.ZendeskActivityDefaultTheme, true);
        setContentView(R.layout.zab_activity_article);
        o.a.a obj5 = c.e(getIntent().getExtras(), AnswerBotArticleConfiguration.class);
        String str3 = "AnswerBotArticleActivity";
        int i2 = 0;
        if (!AnswerBot.INSTANCE.isInitialized()) {
            a.e(str3, "Answer Bot SDK needs to be initialized first. Call AnswerBot.INSTANCE.init(...)", new Object[i2]);
            setResult(i2);
            finish();
        }
        if ((AnswerBotArticleConfiguration)obj5 == null) {
            a.e(str3, "No configuration found. Please use AnswerBotArticleActivity.builder()", new Object[i2]);
            setResult(i2);
            finish();
        }
        AnswerBotArticleActivity.1 anon3 = new AnswerBotArticleActivity.1(this, (AnswerBotArticleConfiguration)obj5);
        (AnswerBotArticleComponent)a.B1(this).D1("ANSWER_BOT_ARTICLE_VIEW_MODEL", anon3).inject(this);
        obj5 = findViewById(R.id.zab_view_article);
        this.articleView = (ArticleView)obj5;
        AnswerBotArticleActivity.2 anon4 = new AnswerBotArticleActivity.2(this);
        this.zendeskWebViewClient.setOnLinkClickListener(anon4);
        this.articleView.setWebViewClient(this.zendeskWebViewClient);
        AnswerBotArticleActivity.3 anon5 = new AnswerBotArticleActivity.3(this);
        this.articleView.setOnRetryListener(anon5);
        AnswerBotArticleActivity.4 anon = new AnswerBotArticleActivity.4(this);
        (Toolbar)obj5.findViewById(R.id.zui_toolbar).setNavigationOnClickListener(anon);
        AnswerBotArticleActivity.5 anon2 = new AnswerBotArticleActivity.5(this);
        AnswerBotArticleActivity.6 anon6 = new AnswerBotArticleActivity.6(this);
        AnswerBotArticleActivity.Renderer renderer = new AnswerBotArticleActivity.Renderer(this.articleView, AnswerBotArticleResultRenderer.install(this, this.timerFactory, anon2, anon6), this, this.viewModel);
        this.viewModel.getLiveAnswerBotArticleViewState().observe(this, renderer);
        this.viewModel.init();
    }
}
