package zendesk.support;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class SectionItem implements zendesk.support.HelpItem {

    private List<zendesk.support.ArticleItem> articles;
    @SerializedName("category_id")
    private Long categoryId;
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private Long sectionId;
    @SerializedName("article_count")
    private int totalArticlesCount;
    @Override // zendesk.support.HelpItem
    public void addArticle(zendesk.support.ArticleItem articleItem) {
        Object arrayList;
        if (this.articles == null) {
            arrayList = new ArrayList();
            this.articles = arrayList;
        }
        this.articles.add(articleItem);
    }

    @Override // zendesk.support.HelpItem
    public boolean equals(Object object) {
        boolean equals;
        boolean sectionId2;
        Class class;
        Object sectionId;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                Long sectionId3 = this.sectionId;
                if (sectionId3 != null) {
                    if (!sectionId3.equals(object.sectionId)) {
                        return i;
                    }
                } else {
                    if (object.sectionId != null) {
                    }
                }
                Long categoryId = this.categoryId;
                final Long obj5 = object.categoryId;
                if (categoryId != null) {
                    equals = categoryId.equals(obj5);
                } else {
                    if (obj5 == null) {
                    } else {
                        equals = i;
                    }
                }
            }
            return equals;
        }
        return i;
    }

    public List<zendesk.support.HelpItem> getChildren() {
        int seeAllArticlesItem;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.articles);
        if (this.articles.size() < this.totalArticlesCount) {
            seeAllArticlesItem = new SeeAllArticlesItem(this);
            arrayList.add(seeAllArticlesItem);
        }
        return arrayList;
    }

    @Override // zendesk.support.HelpItem
    public Long getId() {
        return this.sectionId;
    }

    @Override // zendesk.support.HelpItem
    public String getName() {
        String name;
        if (this.name == null) {
            name = "";
        }
        return name;
    }

    @Override // zendesk.support.HelpItem
    public Long getParentId() {
        return this.categoryId;
    }

    @Override // zendesk.support.HelpItem
    public int getTotalArticlesCount() {
        return this.totalArticlesCount;
    }

    @Override // zendesk.support.HelpItem
    public int getViewType() {
        return 2;
    }

    @Override // zendesk.support.HelpItem
    public int hashCode() {
        int i;
        int i2;
        Long sectionId = this.sectionId;
        if (sectionId != null) {
            i = sectionId.hashCode();
        } else {
            i = i2;
        }
        final Long categoryId = this.categoryId;
        if (categoryId != null) {
            i2 = categoryId.hashCode();
        }
        return i3 += i2;
    }
}
