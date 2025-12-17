package zendesk.answerbot;

import f.g.e.g;
import zendesk.support.Article;

/* loaded from: classes3.dex */
class ArticleViewState {

    private final Article article;
    private final boolean hasFailed;
    private final boolean isLoading;
    private final String title;
    private ArticleViewState(String string, Article article2, boolean z3, boolean z4) {
        super();
        this.title = string;
        this.article = article2;
        this.isLoading = z3;
        this.hasFailed = z4;
    }

    static zendesk.answerbot.ArticleViewState error(String string) {
        ArticleViewState articleViewState = new ArticleViewState(string, 0, 0, 1);
        return articleViewState;
    }

    static zendesk.answerbot.ArticleViewState init(String string) {
        ArticleViewState articleViewState = new ArticleViewState(string, 0, 1, 0);
        return articleViewState;
    }

    static zendesk.answerbot.ArticleViewState success(Article article) {
        final int i = 0;
        ArticleViewState articleViewState = new ArticleViewState(g.a(article.getTitle()), article, i, i);
        return articleViewState;
    }

    Article getArticle() {
        return this.article;
    }

    String getTitle() {
        return this.title;
    }

    boolean isFailed() {
        return this.hasFailed;
    }

    boolean isLoading() {
        return this.isLoading;
    }
}
