package zendesk.support.guide;

import java.io.Serializable;
import java.util.Date;
import zendesk.core.User;
import zendesk.support.Article;

/* loaded from: classes3.dex */
class ArticleViewModel implements Serializable {

    private final String authorName;
    private final String body;
    private final Date createdAt;
    private final long id;
    private final String title;
    ArticleViewModel(Article article) {
        int obj3;
        super();
        this.id = article.getId().longValue();
        this.title = article.getTitle();
        this.body = article.getBody();
        this.createdAt = article.getCreatedAt();
        if (article.getAuthor() == null) {
            obj3 = 0;
        } else {
            obj3 = article.getAuthor().getName();
        }
        this.authorName = obj3;
    }

    @Override // java.io.Serializable
    String getAuthorName() {
        return this.authorName;
    }

    @Override // java.io.Serializable
    String getBody() {
        return this.body;
    }

    @Override // java.io.Serializable
    Date getCreatedAt() {
        return this.createdAt;
    }

    @Override // java.io.Serializable
    long getId() {
        return this.id;
    }

    @Override // java.io.Serializable
    String getTitle() {
        return this.title;
    }
}
