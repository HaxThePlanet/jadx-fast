package zendesk.support;

/* loaded from: classes3.dex */
public interface ArticleVoteStorage {
    public abstract zendesk.support.ArticleVote getStoredArticleVote(Long long);

    public abstract void removeStoredArticleVote(Long long);

    public abstract void storeArticleVote(Long long, zendesk.support.ArticleVote articleVote2);
}
