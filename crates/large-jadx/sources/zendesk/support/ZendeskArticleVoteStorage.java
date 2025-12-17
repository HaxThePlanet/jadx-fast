package zendesk.support;

import java.util.HashMap;
import java.util.Map;
import zendesk.core.BaseStorage;

/* loaded from: classes3.dex */
class ZendeskArticleVoteStorage implements zendesk.support.ArticleVoteStorage {

    private static final String ARTICLE_VOTE_KEY = "help_center_stored_article_votes";
    private final BaseStorage baseStorage;

    static class ArticleVoteMapWrapper {

        Map<Long, zendesk.support.ArticleVote> map;
    }
    ZendeskArticleVoteStorage(BaseStorage baseStorage) {
        super();
        this.baseStorage = baseStorage;
    }

    private Map<Long, zendesk.support.ArticleVote> getStoredArticleVotes() {
        Map map;
        Object obj = this.baseStorage.get("help_center_stored_article_votes", ZendeskArticleVoteStorage.ArticleVoteMapWrapper.class);
        map = (ZendeskArticleVoteStorage.ArticleVoteMapWrapper)obj != null ? obj.map : 0;
        return map;
    }

    private void storeArticleVoteHolder(Map<Long, zendesk.support.ArticleVote> map) {
        ZendeskArticleVoteStorage.ArticleVoteMapWrapper articleVoteMapWrapper = new ZendeskArticleVoteStorage.ArticleVoteMapWrapper();
        articleVoteMapWrapper.map = map;
        this.baseStorage.put("help_center_stored_article_votes", articleVoteMapWrapper);
    }

    @Override // zendesk.support.ArticleVoteStorage
    public zendesk.support.ArticleVote getStoredArticleVote(Long long) {
        boolean key;
        final Map storedArticleVotes = getStoredArticleVotes();
        if (storedArticleVotes != null && storedArticleVotes.containsKey(long)) {
            if (storedArticleVotes.containsKey(long)) {
                return (ArticleVote)storedArticleVotes.get(long);
            }
        }
        return null;
    }

    @Override // zendesk.support.ArticleVoteStorage
    public void removeStoredArticleVote(Long long) {
        Map storedArticleVotes;
        boolean key;
        storedArticleVotes = getStoredArticleVotes();
        if (long != null && storedArticleVotes != null && storedArticleVotes.containsKey(long)) {
            storedArticleVotes = getStoredArticleVotes();
            if (storedArticleVotes != null) {
                if (storedArticleVotes.containsKey(long)) {
                    storedArticleVotes.remove(long);
                    storeArticleVoteHolder(storedArticleVotes);
                }
            }
        }
    }

    @Override // zendesk.support.ArticleVoteStorage
    public void storeArticleVote(Long long, zendesk.support.ArticleVote articleVote2) {
        Object storedArticleVotes;
        if (getStoredArticleVotes() == null) {
            storedArticleVotes = new HashMap();
        }
        if (articleVote2 != null) {
            storedArticleVotes.put(long, articleVote2);
            storeArticleVoteHolder(storedArticleVotes);
        }
    }
}
