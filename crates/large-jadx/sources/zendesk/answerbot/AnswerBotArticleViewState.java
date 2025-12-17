package zendesk.answerbot;

/* loaded from: classes3.dex */
class AnswerBotArticleViewState {

    private final zendesk.answerbot.AnswerBotArticleResult articleResult;
    private final zendesk.answerbot.ArticleViewState articleViewState;
    AnswerBotArticleViewState(zendesk.answerbot.ArticleViewState articleViewState, zendesk.answerbot.AnswerBotArticleResult answerBotArticleResult2) {
        super();
        this.articleViewState = articleViewState;
        this.articleResult = answerBotArticleResult2;
    }

    static zendesk.answerbot.AnswerBotArticleViewState initState(zendesk.answerbot.ArticleViewState articleViewState, zendesk.answerbot.AnswerBotArticleResult answerBotArticleResult2) {
        AnswerBotArticleViewState answerBotArticleViewState = new AnswerBotArticleViewState(articleViewState, answerBotArticleResult2);
        return answerBotArticleViewState;
    }

    zendesk.answerbot.AnswerBotArticleResult getArticleResult() {
        return this.articleResult;
    }

    zendesk.answerbot.ArticleViewState getArticleViewState() {
        return this.articleViewState;
    }

    zendesk.answerbot.AnswerBotArticleViewState withArticleResult(zendesk.answerbot.AnswerBotArticleResult answerBotArticleResult) {
        AnswerBotArticleViewState answerBotArticleViewState = new AnswerBotArticleViewState(this.articleViewState, answerBotArticleResult);
        return answerBotArticleViewState;
    }

    zendesk.answerbot.AnswerBotArticleViewState withArticleViewState(zendesk.answerbot.ArticleViewState articleViewState) {
        AnswerBotArticleViewState answerBotArticleViewState = new AnswerBotArticleViewState(articleViewState, this.articleResult);
        return answerBotArticleViewState;
    }
}
