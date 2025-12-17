package zendesk.answerbot;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import androidx.lifecycle.x;
import com.zendesk.service.a;
import com.zendesk.service.f;
import zendesk.messaging.components.Timer;
import zendesk.messaging.components.Timer.Factory;

/* loaded from: classes3.dex */
class AnswerBotArticleViewModel {

    private static final f<Void> NO_OP_CALLBACK;
    private final zendesk.answerbot.AnswerBotArticleConfiguration answerBotArticleUiConfig;
    private final zendesk.answerbot.AnswerBotProvider answerBotProvider;
    private zendesk.answerbot.ArticleViewModel articleViewModel;
    private final v<zendesk.answerbot.AnswerBotArticleViewState> liveAnswerBotArticleViewState;
    private final Timer timer;
    private final zendesk.answerbot.ArticleUrlIdentifier urlIdentifier;
    static {
        AnswerBotArticleViewModel.3 anon = new AnswerBotArticleViewModel.3();
        AnswerBotArticleViewModel.NO_OP_CALLBACK = anon;
    }

    AnswerBotArticleViewModel(zendesk.answerbot.AnswerBotArticleConfiguration answerBotArticleConfiguration, zendesk.answerbot.ArticleViewModel articleViewModel2, v<zendesk.answerbot.AnswerBotArticleViewState> v3, zendesk.answerbot.AnswerBotProvider answerBotProvider4, Timer.Factory timer$Factory5, zendesk.answerbot.ArticleUrlIdentifier articleUrlIdentifier6) {
        super();
        this.answerBotArticleUiConfig = answerBotArticleConfiguration;
        this.articleViewModel = articleViewModel2;
        this.liveAnswerBotArticleViewState = v3;
        this.answerBotProvider = answerBotProvider4;
        this.urlIdentifier = articleUrlIdentifier6;
        AnswerBotArticleViewModel.1 obj1 = new AnswerBotArticleViewModel.1(this);
        this.timer = factory5.create(obj1, 3000);
        observeArticleViewState(articleViewModel2.liveArticleViewState());
    }

    static v access$000(zendesk.answerbot.AnswerBotArticleViewModel answerBotArticleViewModel) {
        return answerBotArticleViewModel.liveAnswerBotArticleViewState;
    }

    static Timer access$100(zendesk.answerbot.AnswerBotArticleViewModel answerBotArticleViewModel) {
        return answerBotArticleViewModel.timer;
    }

    zendesk.answerbot.AnswerBotArticleConfiguration getAnswerBotArticleUiConfig() {
        return this.answerBotArticleUiConfig;
    }

    zendesk.answerbot.AnswerBotArticleResult getArticleResult() {
        zendesk.answerbot.AnswerBotArticleResult articleResult;
        if ((AnswerBotArticleViewState)this.liveAnswerBotArticleViewState.getValue().getArticleResult() != null) {
        } else {
            articleResult = AnswerBotArticleResult.NOT_SET;
        }
        return articleResult;
    }

    LiveData<zendesk.answerbot.AnswerBotArticleViewState> getLiveAnswerBotArticleViewState() {
        return this.liveAnswerBotArticleViewState;
    }

    void init() {
        if (this.liveAnswerBotArticleViewState.getValue() != null) {
        }
        loadArticle(0);
    }

    void loadArticle(zendesk.answerbot.AnswerBotArticleResult answerBotArticleResult) {
        this.liveAnswerBotArticleViewState.postValue(AnswerBotArticleViewState.initState(ArticleViewState.init(this.articleViewModel.getArticleTitle()), answerBotArticleResult));
        this.articleViewModel.load();
    }

    void observeArticleViewState(LiveData<zendesk.answerbot.ArticleViewState> liveData) {
        AnswerBotArticleViewModel.2 anon = new AnswerBotArticleViewModel.2(this);
        this.liveAnswerBotArticleViewState.b(liveData, anon);
    }

    boolean onLinkClicked(String string) {
        zendesk.answerbot.ArticleViewModel obj2 = this.urlIdentifier.articleViewModelFromUrl(string);
        if (obj2 != null) {
            this.articleViewModel = obj2;
            observeArticleViewState(obj2.liveArticleViewState());
            loadArticle(getArticleResult());
            return 1;
        }
        return 0;
    }

    void onNegativeBtnClicked() {
        Object liveAnswerBotArticleViewState;
        Object aRTICLE_NOT_HELPFUL;
        zendesk.answerbot.AnswerBotArticleResult aRTICLE_NOT_HELPFUL2;
        long deflectionId;
        long articleId;
        String interactionAccessToken;
        zendesk.answerbot.RejectionReason nOT_RELATED;
        f nO_OP_CALLBACK;
        liveAnswerBotArticleViewState = getArticleResult();
        if (liveAnswerBotArticleViewState == AnswerBotArticleResult.NOT_SET) {
            liveAnswerBotArticleViewState = this.liveAnswerBotArticleViewState;
            liveAnswerBotArticleViewState.postValue((AnswerBotArticleViewState)liveAnswerBotArticleViewState.getValue().withArticleResult(AnswerBotArticleResult.ARTICLE_NOT_HELPFUL));
        } else {
            if (liveAnswerBotArticleViewState == AnswerBotArticleResult.ARTICLE_NOT_HELPFUL) {
                this.answerBotProvider.rejectWithArticle(this.answerBotArticleUiConfig.getDeflectionId(), obj4, this.answerBotArticleUiConfig.getArticleId(), obj6, this.answerBotArticleUiConfig.getInteractionAccessToken());
                liveAnswerBotArticleViewState = this.liveAnswerBotArticleViewState;
                liveAnswerBotArticleViewState.postValue((AnswerBotArticleViewState)liveAnswerBotArticleViewState.getValue().withArticleResult(AnswerBotArticleResult.ARTICLE_NOT_RELATED));
            }
        }
    }

    void onPositiveBtnClicked() {
        Object liveAnswerBotArticleViewState;
        Object aRTICLE_NOT_HELPFUL;
        zendesk.answerbot.AnswerBotArticleResult aRTICLE_RELATED_DIDNT_ANSWER;
        long deflectionId;
        long articleId;
        String interactionAccessToken;
        Object rELATED_DIDNT_ANSWER;
        f nO_OP_CALLBACK;
        liveAnswerBotArticleViewState = getArticleResult();
        if (liveAnswerBotArticleViewState == AnswerBotArticleResult.NOT_SET) {
            this.answerBotProvider.resolveWithArticle(this.answerBotArticleUiConfig.getDeflectionId(), obj4, this.answerBotArticleUiConfig.getArticleId(), obj6);
            liveAnswerBotArticleViewState = this.liveAnswerBotArticleViewState;
            liveAnswerBotArticleViewState.postValue((AnswerBotArticleViewState)liveAnswerBotArticleViewState.getValue().withArticleResult(AnswerBotArticleResult.ARTICLE_HELPFUL));
        } else {
            if (liveAnswerBotArticleViewState == AnswerBotArticleResult.ARTICLE_NOT_HELPFUL) {
                this.answerBotProvider.rejectWithArticle(this.answerBotArticleUiConfig.getDeflectionId(), obj4, this.answerBotArticleUiConfig.getArticleId(), obj6, this.answerBotArticleUiConfig.getInteractionAccessToken());
                liveAnswerBotArticleViewState = this.liveAnswerBotArticleViewState;
                liveAnswerBotArticleViewState.postValue((AnswerBotArticleViewState)liveAnswerBotArticleViewState.getValue().withArticleResult(AnswerBotArticleResult.ARTICLE_RELATED_DIDNT_ANSWER));
            }
        }
    }

    void onRetryBtnClicked() {
        this.articleViewModel.load();
    }
}
