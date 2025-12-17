package zendesk.support;

import f.g.e.a;
import java.util.List;
import zendesk.core.User;

/* loaded from: classes3.dex */
class ArticlesListResponse implements zendesk.support.ArticlesResponse {

    private List<zendesk.support.Article> articles;
    private List<zendesk.support.Category> categories;
    private String nextPage;
    private String previousPage;
    private List<zendesk.support.Section> sections;
    private List<User> users;
    public List<zendesk.support.Article> getArticles() {
        return a.c(this.articles);
    }

    public List<zendesk.support.Category> getCategories() {
        return a.c(this.categories);
    }

    @Override // zendesk.support.ArticlesResponse
    public String getNextPage() {
        return this.nextPage;
    }

    @Override // zendesk.support.ArticlesResponse
    public String getPreviousPage() {
        return this.previousPage;
    }

    public List<zendesk.support.Section> getSections() {
        return a.c(this.sections);
    }

    public List<User> getUsers() {
        return a.c(this.users);
    }
}
