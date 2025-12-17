package zendesk.support;

import java.util.List;
import zendesk.core.User;

/* loaded from: classes3.dex */
interface ArticlesResponse {
    public abstract List<zendesk.support.Article> getArticles();

    public abstract List<zendesk.support.Category> getCategories();

    public abstract List<zendesk.support.Section> getSections();

    public abstract List<User> getUsers();
}
