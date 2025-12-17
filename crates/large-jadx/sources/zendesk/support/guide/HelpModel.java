package zendesk.support.guide;

import com.zendesk.service.a;
import com.zendesk.service.b;
import com.zendesk.service.f;
import f.g.e.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zendesk.support.Article;
import zendesk.support.ArticleItem;
import zendesk.support.HelpCenterProvider;
import zendesk.support.HelpItem;
import zendesk.support.HelpRequest.Builder;
import zendesk.support.SectionItem;

/* loaded from: classes3.dex */
class HelpModel implements zendesk.support.guide.HelpMvp.Model {

    private HelpCenterProvider provider;
    HelpModel(HelpCenterProvider helpCenterProvider) {
        super();
        this.provider = helpCenterProvider;
    }

    static ArticleItem access$000(zendesk.support.guide.HelpModel helpModel, Article article2) {
        return helpModel.convertArticle(article2);
    }

    private ArticleItem convertArticle(Article article) {
        ArticleItem articleItem = new ArticleItem(article.getId(), article.getSectionId(), article.getTitle());
        return articleItem;
    }

    public void getArticles(List<Long> list, List<Long> list2, String[] string3Arr3, f<List<HelpItem>> f4) {
        HelpRequest.Builder builder = new HelpRequest.Builder();
        this.provider.getHelp(builder.withCategoryIds(list).withSectionIds(list2).withLabelNames(string3Arr3).includeCategories().includeSections().build(), f4);
    }

    public void getArticlesForSection(SectionItem sectionItem, String[] string2Arr2, f<List<ArticleItem>> f3) {
        Long num;
        if (sectionItem != null && sectionItem.getId() == null) {
            if (sectionItem.getId() == null) {
            }
            HelpModel.1 anon = new HelpModel.1(this, f3);
            this.provider.getArticles(sectionItem.getId(), g.h(string2Arr2), anon);
        }
        b obj3 = new b("SectionItem or its ID was null, cannot load more articles.");
        f3.onError(obj3);
    }
}
