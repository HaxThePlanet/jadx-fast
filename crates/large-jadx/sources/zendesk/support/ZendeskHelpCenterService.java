package zendesk.support;

import com.zendesk.service.b;
import com.zendesk.service.d;
import com.zendesk.service.d.b;
import com.zendesk.service.f;
import f.g.c.a;
import f.g.e.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import retrofit2.Call;
import zendesk.core.User;
import zendesk.core.ZendeskLocaleConverter;

/* loaded from: classes3.dex */
class ZendeskHelpCenterService {

    private static final String LOG_TAG = "ZendeskHelpCenterService";
    private static final int NUMBER_PER_PAGE = 1000;
    private final zendesk.support.HelpCenterService helpCenterService;
    private final ZendeskLocaleConverter localeConverter;
    ZendeskHelpCenterService(zendesk.support.HelpCenterService helpCenterService, ZendeskLocaleConverter zendeskLocaleConverter2) {
        super();
        this.helpCenterService = helpCenterService;
        this.localeConverter = zendeskLocaleConverter2;
    }

    public void deleteVote(Long long, f<Void> f2) {
        Object[] obj3;
        final String str2 = "The vote id was null, can not delete the vote";
        a.e("ZendeskHelpCenterService", str2, new Object[0]);
        if (long == null && f2 != null) {
            str2 = "The vote id was null, can not delete the vote";
            a.e("ZendeskHelpCenterService", str2, new Object[0]);
            if (f2 != null) {
                obj3 = new b(str2);
                f2.onError(obj3);
            }
        }
        d dVar = new d(f2);
        this.helpCenterService.deleteVote(long).enqueue(dVar);
    }

    public void downvoteArticle(Long long, String string2, f<zendesk.support.ArticleVoteResponse> f3) {
        Object[] obj2;
        String str = "The article id was null, can not create down vote";
        a.e("ZendeskHelpCenterService", str, new Object[0]);
        if (long == null && f3 != null) {
            str = "The article id was null, can not create down vote";
            a.e("ZendeskHelpCenterService", str, new Object[0]);
            if (f3 != null) {
                obj2 = new b(str);
                f3.onError(obj2);
            }
        }
        d obj3 = new d(f3);
        this.helpCenterService.downvoteArticle(long, string2).enqueue(obj3);
    }

    public void getArticle(Long long, Locale locale2, String string3, f<zendesk.support.Article> f4) {
        ZendeskHelpCenterService.4 anon = new ZendeskHelpCenterService.4(this);
        d dVar = new d(f4, anon);
        this.helpCenterService.getArticle(this.localeConverter.toHelpCenterLocaleString(locale2), long, string3).enqueue(dVar);
    }

    void getArticlesForSection(Long long, Locale locale2, String string3, String string4, f<List<zendesk.support.Article>> f5) {
        ZendeskHelpCenterService.3 obj9 = new ZendeskHelpCenterService.3(this);
        d obj8 = new d(f5, obj9);
        this.helpCenterService.getArticles(this.localeConverter.toHelpCenterLocaleString(locale2), long, string4, string3, 1000).enqueue(obj8);
    }

    public void getAttachments(Locale locale, Long long2, zendesk.support.AttachmentType attachmentType3, f<List<zendesk.support.HelpCenterAttachment>> f4) {
        Object[] obj2;
        String obj4 = "getAttachments() was called with null attachment type";
        a.e("ZendeskHelpCenterService", obj4, new Object[0]);
        if (attachmentType3 == null && f4 != null) {
            obj4 = "getAttachments() was called with null attachment type";
            a.e("ZendeskHelpCenterService", obj4, new Object[0]);
            if (f4 != null) {
                obj2 = new b(obj4);
                f4.onError(obj2);
            }
        }
        obj4 = new ZendeskHelpCenterService.7(this);
        d obj3 = new d(f4, obj4);
        this.helpCenterService.getAttachments(this.localeConverter.toHelpCenterLocaleString(locale), long2, attachmentType3.getAttachmentType()).enqueue(obj3);
    }

    public void getCategories(Locale locale, f<List<zendesk.support.Category>> f2) {
        ZendeskHelpCenterService.1 anon = new ZendeskHelpCenterService.1(this);
        d dVar = new d(f2, anon);
        this.helpCenterService.getCategories(this.localeConverter.toHelpCenterLocaleString(locale)).enqueue(dVar);
    }

    public void getCategoryById(Long long, Locale locale2, f<zendesk.support.Category> f3) {
        ZendeskHelpCenterService.6 anon = new ZendeskHelpCenterService.6(this);
        d obj3 = new d(f3, anon);
        this.helpCenterService.getCategoryById(this.localeConverter.toHelpCenterLocaleString(locale2), long).enqueue(obj3);
    }

    void getHelp(Locale locale, String string2, String string3, String string4, int i5, String string6, f<zendesk.support.HelpResponse> f7) {
        final Object obj = this;
        Locale locale2 = locale;
        d dVar = new d(f7);
        obj.helpCenterService.getHelp(obj.localeConverter.toHelpCenterLocaleString(locale), string2, string3, string4, i5, string6, 1000, SortBy.CREATED_AT.getApiValue(), SortOrder.DESCENDING.getApiValue()).enqueue(dVar);
    }

    public void getSectionById(Long long, Locale locale2, f<zendesk.support.Section> f3) {
        ZendeskHelpCenterService.5 anon = new ZendeskHelpCenterService.5(this);
        d obj3 = new d(f3, anon);
        this.helpCenterService.getSectionById(this.localeConverter.toHelpCenterLocaleString(locale2), long).enqueue(obj3);
    }

    public void getSectionsForCategory(Long long, Locale locale2, f<List<zendesk.support.Section>> f3) {
        ZendeskHelpCenterService.2 anon = new ZendeskHelpCenterService.2(this);
        d obj4 = new d(f3, anon);
        this.helpCenterService.getSections(this.localeConverter.toHelpCenterLocaleString(locale2), long, 1000).enqueue(obj4);
    }

    public void getSuggestedArticles(String string, Locale locale2, String string3, Long long4, Long long5, f<Object> f6) {
        d obj9 = new d(f6);
        this.helpCenterService.getSuggestedArticles(string, this.localeConverter.toHelpCenterLocaleString(locale2), string3, long4, long5).enqueue(obj9);
    }

    public void listArticles(String string, Locale locale2, String string3, String string4, String string5, Integer integer6, Integer integer7, f<zendesk.support.ArticlesListResponse> f8) {
        final Object obj = this;
        Locale locale = locale2;
        d dVar = new d(f8);
        obj.helpCenterService.listArticles(obj.localeConverter.toHelpCenterLocaleString(locale2), string, string3, string4, string5, integer6, integer7).enqueue(dVar);
    }

    zendesk.support.Article matchArticleWithUsers(zendesk.support.Article article, List<User> list2) {
        Object next;
        Long equals;
        Long authorId;
        if (article == null) {
            Article obj4 = new Article();
            return obj4;
        }
        final Iterator obj5 = list2.iterator();
        while (obj5.hasNext()) {
            next = obj5.next();
            if ((User)next.getId() != null) {
                break;
            } else {
            }
            if (next.getId().equals(article.getAuthorId())) {
                break;
            } else {
            }
        }
        return article;
    }

    List<zendesk.support.Article> matchArticlesWithUsers(List<User> list, List<zendesk.support.Article> list2) {
        Object next2;
        boolean next;
        Long num;
        HashMap hashMap = new HashMap();
        Iterator obj4 = list.iterator();
        for (User next2 : obj4) {
            hashMap.put(next2.getId(), next2);
        }
        obj4 = new ArrayList();
        final Iterator obj5 = list2.iterator();
        while (obj5.hasNext()) {
            next = obj5.next();
            num = hashMap.get((Article)next.getAuthorId());
            if ((User)num != null) {
            }
            obj4.add(next);
            next.setAuthor((User)num);
        }
        return obj4;
    }

    public void searchArticles(String string, Locale locale2, String string3, String string4, String string5, String string6, Integer integer7, Integer integer8, f<zendesk.support.ArticlesSearchResponse> f9) {
        final Object obj = this;
        Locale locale = locale2;
        d dVar = new d(f9);
        obj.helpCenterService.searchArticles(string, obj.localeConverter.toHelpCenterLocaleString(locale2), string3, string4, string5, string6, integer7, integer8).enqueue(dVar);
    }

    public void submitRecordArticleView(Long long, Locale locale2, zendesk.support.RecordArticleViewRequest recordArticleViewRequest3, f<Void> f4) {
        d obj4 = new d(f4);
        this.helpCenterService.submitRecordArticleView(long, this.localeConverter.toHelpCenterLocaleString(locale2), recordArticleViewRequest3).enqueue(obj4);
    }

    public void upvoteArticle(Long long, String string2, f<zendesk.support.ArticleVoteResponse> f3) {
        Object[] obj2;
        String str = "The article id was null, can not create up vote";
        a.e("ZendeskHelpCenterService", str, new Object[0]);
        if (long == null && f3 != null) {
            str = "The article id was null, can not create up vote";
            a.e("ZendeskHelpCenterService", str, new Object[0]);
            if (f3 != null) {
                obj2 = new b(str);
                f3.onError(obj2);
            }
        }
        d obj3 = new d(f3);
        this.helpCenterService.upvoteArticle(long, string2).enqueue(obj3);
    }
}
