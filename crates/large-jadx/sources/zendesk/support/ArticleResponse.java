package zendesk.support;

import f.g.e.a;
import java.util.List;
import zendesk.core.User;

/* loaded from: classes3.dex */
class ArticleResponse {

    private zendesk.support.Article article;
    private List<User> users;
    zendesk.support.Article getArticle() {
        return this.article;
    }

    List<User> getUsers() {
        return a.c(this.users);
    }
}
