package zendesk.answerbot;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.e0;
import androidx.lifecycle.x;
import com.zendesk.service.a;
import com.zendesk.service.f;
import zendesk.support.Article;
import zendesk.support.HelpCenterProvider;

/* loaded from: classes3.dex */
class ArticleViewModel extends e0 {

    private final Long articleId;
    private final String articleTitle;
    private final HelpCenterProvider helpCenterProvider;
    private final x<zendesk.answerbot.ArticleViewState> liveArticleViewState;
    ArticleViewModel(HelpCenterProvider helpCenterProvider, x<zendesk.answerbot.ArticleViewState> x2, Long long3, String string4) {
        super();
        this.helpCenterProvider = helpCenterProvider;
        this.liveArticleViewState = x2;
        this.articleId = long3;
        this.articleTitle = string4;
    }

    static x access$000(zendesk.answerbot.ArticleViewModel articleViewModel) {
        return articleViewModel.liveArticleViewState;
    }

    static String access$100(zendesk.answerbot.ArticleViewModel articleViewModel) {
        return articleViewModel.articleTitle;
    }

    @Override // androidx.lifecycle.e0
    String getArticleTitle() {
        return this.articleTitle;
    }

    LiveData<zendesk.answerbot.ArticleViewState> liveArticleViewState() {
        return this.liveArticleViewState;
    }

    @Override // androidx.lifecycle.e0
    void load() {
        this.liveArticleViewState.postValue(ArticleViewState.init(this.articleTitle));
        ArticleViewModel.1 anon = new ArticleViewModel.1(this);
        this.helpCenterProvider.getArticle(this.articleId, anon);
    }
}
