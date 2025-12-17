package zendesk.support;

/* loaded from: classes3.dex */
public class FlatArticle implements Comparable<zendesk.support.FlatArticle> {

    private zendesk.support.Article article;
    private zendesk.support.Category category;
    private zendesk.support.Section section;
    public FlatArticle(zendesk.support.Category category, zendesk.support.Section section2, zendesk.support.Article article3) {
        zendesk.support.Category obj1;
        zendesk.support.Section obj2;
        zendesk.support.Article obj3;
        super();
        if (category == null) {
            obj1 = new Category();
        }
        this.category = obj1;
        if (section2 == null) {
            obj2 = new Section();
        }
        this.section = obj2;
        if (article3 == null) {
            obj3 = new Article();
        }
        this.article = obj3;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return compareTo((FlatArticle)object);
    }

    @Override // java.lang.Comparable
    public int compareTo(zendesk.support.FlatArticle flatArticle) {
        if (flatArticle == null) {
            return -1;
        }
        return toString().compareTo(flatArticle.toString());
    }

    @Override // java.lang.Comparable
    public zendesk.support.Article getArticle() {
        return this.article;
    }

    @Override // java.lang.Comparable
    public zendesk.support.Category getCategory() {
        return this.category;
    }

    @Override // java.lang.Comparable
    public zendesk.support.Section getSection() {
        return this.section;
    }

    @Override // java.lang.Comparable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.category.getName());
        String str = ", ";
        stringBuilder.append(str);
        stringBuilder.append(this.section.getName());
        stringBuilder.append(str);
        stringBuilder.append(this.article.getTitle());
        return stringBuilder.toString();
    }
}
