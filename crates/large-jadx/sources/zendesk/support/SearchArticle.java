package zendesk.support;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class SearchArticle implements Serializable {

    private final zendesk.support.Article article;
    private final zendesk.support.Category category;
    private final zendesk.support.Section section;
    public SearchArticle(zendesk.support.Article article, zendesk.support.Section section2, zendesk.support.Category category3) {
        super();
        this.article = article;
        this.section = section2;
        this.category = category3;
    }

    @Override // java.io.Serializable
    public zendesk.support.Article getArticle() {
        return this.article;
    }

    @Override // java.io.Serializable
    public zendesk.support.Category getCategory() {
        return this.category;
    }

    @Override // java.io.Serializable
    public zendesk.support.Section getSection() {
        return this.section;
    }
}
