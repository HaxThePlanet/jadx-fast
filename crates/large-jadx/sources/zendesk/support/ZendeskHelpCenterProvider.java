package zendesk.support;

import com.zendesk.service.a;
import com.zendesk.service.b;
import com.zendesk.service.f;
import f.g.c.a;
import f.g.e.a;
import f.g.e.d;
import f.g.e.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import zendesk.core.User;

/* loaded from: classes3.dex */
class ZendeskHelpCenterProvider implements zendesk.support.HelpCenterProvider {

    private static final String EMPTY_JSON_BODY = "{}";
    private static final String LOG_TAG = "ZendeskHelpCenterProvider";
    private final zendesk.support.HelpCenterBlipsProvider blipsProvider;
    private final zendesk.support.ZendeskHelpCenterService helpCenterService;
    private final zendesk.support.HelpCenterSessionCache helpCenterSessionCache;
    private final zendesk.support.HelpCenterTracker helpCenterTracker;
    private final zendesk.support.HelpCenterSettingsProvider settingsProvider;

    static abstract class ZendeskCallbackSuccess extends f<E> {

        private final f callback;
        ZendeskCallbackSuccess(f f) {
            super();
            this.callback = f;
        }

        @Override // com.zendesk.service.f
        public void onError(a a) {
            final f callback = this.callback;
            if (callback != null) {
                callback.onError(a);
            }
        }

        public abstract void onSuccess(E e);
    }
    ZendeskHelpCenterProvider(zendesk.support.HelpCenterSettingsProvider helpCenterSettingsProvider, zendesk.support.HelpCenterBlipsProvider helpCenterBlipsProvider2, zendesk.support.ZendeskHelpCenterService zendeskHelpCenterService3, zendesk.support.HelpCenterSessionCache helpCenterSessionCache4, zendesk.support.HelpCenterTracker helpCenterTracker5) {
        super();
        this.settingsProvider = helpCenterSettingsProvider;
        this.blipsProvider = helpCenterBlipsProvider2;
        this.helpCenterService = zendeskHelpCenterService3;
        this.helpCenterSessionCache = helpCenterSessionCache4;
        this.helpCenterTracker = helpCenterTracker5;
    }

    static zendesk.support.HelpCenterTracker access$000(zendesk.support.ZendeskHelpCenterProvider zendeskHelpCenterProvider) {
        return zendeskHelpCenterProvider.helpCenterTracker;
    }

    static List access$100(zendesk.support.ZendeskHelpCenterProvider zendeskHelpCenterProvider, zendesk.support.HelpResponse helpResponse2) {
        return zendeskHelpCenterProvider.convert(helpResponse2);
    }

    static zendesk.support.ZendeskHelpCenterService access$200(zendesk.support.ZendeskHelpCenterProvider zendeskHelpCenterProvider) {
        return zendeskHelpCenterProvider.helpCenterService;
    }

    static zendesk.support.HelpCenterSessionCache access$300(zendesk.support.ZendeskHelpCenterProvider zendeskHelpCenterProvider) {
        return zendeskHelpCenterProvider.helpCenterSessionCache;
    }

    static boolean access$400(zendesk.support.ZendeskHelpCenterProvider zendeskHelpCenterProvider, f f2, zendesk.support.HelpCenterSettings helpCenterSettings3) {
        return zendeskHelpCenterProvider.checkSettingsAndVotingEnabled(f2, helpCenterSettings3);
    }

    static zendesk.support.HelpCenterBlipsProvider access$500(zendesk.support.ZendeskHelpCenterProvider zendeskHelpCenterProvider) {
        return zendeskHelpCenterProvider.blipsProvider;
    }

    private boolean checkSettingsAndVotingEnabled(f<?> f, zendesk.support.HelpCenterSettings helpCenterSettings2) {
        boolean sanityCheckHelpCenterSettings;
        String str;
        Object obj5;
        final int i = 0;
        if (!sanityCheckHelpCenterSettings(f, helpCenterSettings2) && helpCenterSettings2.isArticleVotingEnabled()) {
            if (helpCenterSettings2.isArticleVotingEnabled()) {
                return 1;
            }
            str = "Help Center voting is disabled in your app's settings. Can not continue with the call";
            a.e("ZendeskHelpCenterProvider", str, new Object[i]);
            if (f != null) {
                obj5 = new b(str);
                f.onError(obj5);
            }
        }
        return i;
    }

    private List<zendesk.support.HelpItem> convert(zendesk.support.HelpResponse helpResponse) {
        Iterator iterator;
        boolean children;
        if (helpResponse == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator obj4 = helpResponse.getCategories().iterator();
        for (CategoryItem next2 : obj4) {
            arrayList.add(next2);
            iterator = next2.getSections().iterator();
            for (SectionItem next3 : iterator) {
                arrayList.add(next3);
                arrayList.addAll(next3.getChildren());
            }
            Object next3 = iterator.next();
            arrayList.add((SectionItem)next3);
            arrayList.addAll(next3.getChildren());
        }
        return arrayList;
    }

    List<zendesk.support.FlatArticle> asFlatArticleList(zendesk.support.ArticlesResponse articlesResponse) {
        Iterator iterator;
        boolean next;
        List sections;
        boolean next3;
        Object arrayList;
        boolean next2;
        Long flatArticle;
        Iterator obj8;
        if (articlesResponse == null) {
            obj8 = new ArrayList();
            return obj8;
        }
        obj8 = articlesResponse.getArticles();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        arrayList = new ArrayList();
        if (a.i(obj8)) {
            Iterator iterator2 = articlesResponse.getCategories().iterator();
            for (Category next2 : iterator2) {
                hashMap.put(next2.getId(), next2);
            }
            iterator = articlesResponse.getSections().iterator();
            for (Section sections : iterator) {
                hashMap2.put(sections.getId(), sections);
            }
            obj8 = obj8.iterator();
            for (Article iterator : obj8) {
                next3 = hashMap2.get(iterator.getSectionId());
                flatArticle = new FlatArticle((Category)hashMap.get((Section)next3.getCategoryId()), next3, iterator);
                arrayList.add(flatArticle);
            }
        } else {
            a.b("ZendeskHelpCenterProvider", "There are no articles contained in this account", new Object[0]);
            arrayList = Collections.emptyList();
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    List<zendesk.support.SearchArticle> asSearchArticleList(zendesk.support.ArticlesResponse articlesResponse) {
        List next4;
        Iterator iterator;
        boolean next3;
        List next5;
        boolean next2;
        Object next;
        boolean searchArticle;
        Object[] arr;
        Long str2;
        String categoryId;
        String str;
        ArrayList arrayList = new ArrayList();
        if (articlesResponse == null) {
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        Iterator iterator2 = a.e(articlesResponse.getSections()).iterator();
        while (iterator2.hasNext()) {
            next = iterator2.next();
            if ((Section)next.getId() != null) {
            }
            hashMap.put(next.getId(), next);
        }
        iterator = a.e(articlesResponse.getCategories()).iterator();
        while (iterator.hasNext()) {
            next5 = iterator.next();
            if ((Category)next5.getId()) {
            }
            hashMap2.put(next5.getId(), next5);
        }
        Iterator obj12 = a.e(articlesResponse.getUsers()).iterator();
        while (obj12.hasNext()) {
            iterator = obj12.next();
            if ((User)iterator.getId()) {
            }
            hashMap3.put(iterator.getId(), iterator);
        }
        obj12 = a.e(articlesResponse.getArticles()).iterator();
        while (obj12.hasNext()) {
            next4 = obj12.next();
            int i = 0;
            str2 = "ZendeskHelpCenterProvider";
            if ((Article)next4.getSectionId() != null) {
            } else {
            }
            a.k(str2, "Unable to determine section as section id was null.", new Object[i]);
            next3 = next2;
            if (next3 && next3.getCategoryId() != null) {
            } else {
            }
            a.k(str2, "Unable to determine category as section was null.", new Object[i]);
            if (next4.getAuthorId() != null) {
            } else {
            }
            a.k(str2, "Unable to determine author as author id was null.", new Object[i]);
            searchArticle = new SearchArticle(next4, next3, next2);
            arrayList.add(searchArticle);
            next4.setAuthor((User)hashMap3.get(next4.getAuthorId()));
            if (next3.getCategoryId() != null) {
            } else {
            }
            next2 = hashMap2.get(next3.getCategoryId());
            next3 = hashMap.get(next4.getSectionId());
        }
        return arrayList;
    }

    public void deleteVote(Long long, f<Void> f2) {
        Object[] arr = new Object[1];
        if (sanityCheck(f2, long)) {
        }
        ZendeskHelpCenterProvider.14 anon = new ZendeskHelpCenterProvider.14(this, f2, f2, long);
        this.settingsProvider.getSettings(anon);
    }

    public void downvoteArticle(Long long, f<zendesk.support.ArticleVote> f2) {
        Object[] arr = new Object[1];
        if (sanityCheck(f2, long)) {
        }
        ZendeskHelpCenterProvider.13 anon = new ZendeskHelpCenterProvider.13(this, f2, f2, long);
        this.settingsProvider.getSettings(anon);
    }

    public void getArticle(Long long, f<zendesk.support.Article> f2) {
        Object[] arr = new Object[1];
        if (sanityCheck(f2, long)) {
        }
        ZendeskHelpCenterProvider.8 anon = new ZendeskHelpCenterProvider.8(this, f2, f2, long);
        this.settingsProvider.getSettings(anon);
    }

    public void getArticles(Long long, f<List<zendesk.support.Article>> f2) {
        getArticles(long, 0, f2);
    }

    public void getArticles(Long long, String string2, f<List<zendesk.support.Article>> f3) {
        Object[] arr = new Object[1];
        if (sanityCheck(f3, long)) {
        }
        super(this, f3, f3, long, string2);
        this.settingsProvider.getSettings(anon2);
    }

    public void getAttachments(Long long, zendesk.support.AttachmentType attachmentType2, f<List<zendesk.support.HelpCenterAttachment>> f3) {
        Object[] arr = new Object[2];
        if (sanityCheck(f3, long, attachmentType2)) {
        }
        super(this, f3, f3, long, attachmentType2);
        this.settingsProvider.getSettings(anon2);
    }

    public void getCategories(f<List<zendesk.support.Category>> f) {
        if (sanityCheck(f, new Object[0])) {
        }
        ZendeskHelpCenterProvider.2 anon = new ZendeskHelpCenterProvider.2(this, f, f);
        this.settingsProvider.getSettings(anon);
    }

    public void getCategory(Long long, f<zendesk.support.Category> f2) {
        Object[] arr = new Object[1];
        if (sanityCheck(f2, long)) {
        }
        ZendeskHelpCenterProvider.10 anon = new ZendeskHelpCenterProvider.10(this, f2, f2, long);
        this.settingsProvider.getSettings(anon);
    }

    public void getHelp(zendesk.support.HelpRequest helpRequest, f<List<zendesk.support.HelpItem>> f2) {
        ZendeskHelpCenterProvider.1 anon = new ZendeskHelpCenterProvider.1(this, f2, f2, helpRequest);
        this.settingsProvider.getSettings(anon);
    }

    @Override // zendesk.support.HelpCenterProvider
    Locale getLocale(zendesk.support.HelpCenterSettings helpCenterSettings) {
        String obj3;
        zendesk.support.Guide iNSTANCE = Guide.INSTANCE;
        if (iNSTANCE.getHelpCenterLocaleOverride() != null) {
            return iNSTANCE.getHelpCenterLocaleOverride();
        }
        if (helpCenterSettings != null) {
            obj3 = helpCenterSettings.getLocale();
        } else {
            obj3 = "";
        }
        if (g.e(obj3)) {
            obj3 = Locale.getDefault();
        } else {
            obj3 = d.c(obj3);
        }
        return obj3;
    }

    public void getSection(Long long, f<zendesk.support.Section> f2) {
        Object[] arr = new Object[1];
        if (sanityCheck(f2, long)) {
        }
        ZendeskHelpCenterProvider.9 anon = new ZendeskHelpCenterProvider.9(this, f2, f2, long);
        this.settingsProvider.getSettings(anon);
    }

    public void getSections(Long long, f<List<zendesk.support.Section>> f2) {
        Object[] arr = new Object[1];
        if (sanityCheck(f2, long)) {
        }
        ZendeskHelpCenterProvider.3 anon = new ZendeskHelpCenterProvider.3(this, f2, f2, long);
        this.settingsProvider.getSettings(anon);
    }

    public void getSuggestedArticles(zendesk.support.SuggestedArticleSearch suggestedArticleSearch, f<Object> f2) {
        Object[] arr = new Object[1];
        if (sanityCheck(f2, suggestedArticleSearch)) {
        }
        ZendeskHelpCenterProvider.15 anon = new ZendeskHelpCenterProvider.15(this, f2, f2, suggestedArticleSearch);
        this.settingsProvider.getSettings(anon);
    }

    public void listArticles(zendesk.support.ListArticleQuery listArticleQuery, f<List<zendesk.support.SearchArticle>> f2) {
        Object[] arr = new Object[1];
        if (sanityCheck(f2, listArticleQuery)) {
        }
        ZendeskHelpCenterProvider.5 anon = new ZendeskHelpCenterProvider.5(this, f2, f2, listArticleQuery);
        this.settingsProvider.getSettings(anon);
    }

    public void listArticlesFlat(zendesk.support.ListArticleQuery listArticleQuery, f<List<zendesk.support.FlatArticle>> f2) {
        Object[] arr = new Object[1];
        if (sanityCheck(f2, listArticleQuery)) {
        }
        ZendeskHelpCenterProvider.6 anon = new ZendeskHelpCenterProvider.6(this, f2, f2, listArticleQuery);
        this.settingsProvider.getSettings(anon);
    }

    boolean sanityCheck(f<?> f, Object... object2Arr2) {
        int length;
        int i3;
        int i;
        int i2;
        Object obj;
        Object[] obj8;
        int i4 = 0;
        if (object2Arr2 != null) {
            i3 = 1;
            i = i4;
            i2 = i3;
            while (i < object2Arr2.length) {
                if (object2Arr2[i] == null) {
                }
                i++;
                i2 = i4;
            }
            String str2 = "One or more provided parameters are null.";
            a.e("ZendeskHelpCenterProvider", str2, new Object[i4]);
            if (i2 == 0 && f != null) {
                str2 = "One or more provided parameters are null.";
                a.e("ZendeskHelpCenterProvider", str2, new Object[i4]);
                if (f != null) {
                    obj8 = new b(str2);
                    f.onError(obj8);
                }
                return i3;
            }
        }
        return i4;
    }

    boolean sanityCheckHelpCenterSettings(f<?> f, zendesk.support.HelpCenterSettings helpCenterSettings2) {
        Object[] obj5;
        final int i = 1;
        final String str = "ZendeskHelpCenterProvider";
        int i2 = 0;
        String str2 = "Help Center settings are null. Can not continue with the call";
        a.e(str, str2, new Object[i2]);
        if (helpCenterSettings2 == null && f != null) {
            str2 = "Help Center settings are null. Can not continue with the call";
            a.e(str, str2, new Object[i2]);
            if (f != null) {
                obj5 = new b(str2);
                f.onError(obj5);
            }
            return i;
        }
        String str3 = "Help Center is disabled in your app's settings. Can not continue with the call";
        a.e(str, str3, new Object[i2]);
        if (!helpCenterSettings2.isEnabled() && f != null) {
            str3 = "Help Center is disabled in your app's settings. Can not continue with the call";
            a.e(str, str3, new Object[i2]);
            if (f != null) {
                obj5 = new b(str3);
                f.onError(obj5);
            }
            return i;
        }
        return i2;
    }

    public void searchArticles(zendesk.support.HelpCenterSearch helpCenterSearch, f<List<zendesk.support.SearchArticle>> f2) {
        Object[] arr = new Object[1];
        if (sanityCheck(f2, helpCenterSearch)) {
        }
        this.blipsProvider.helpCenterSearch(helpCenterSearch.getQuery());
        ZendeskHelpCenterProvider.7 anon = new ZendeskHelpCenterProvider.7(this, f2, f2, helpCenterSearch);
        this.settingsProvider.getSettings(anon);
    }

    public void submitRecordArticleView(zendesk.support.Article article, Locale locale2, f<Void> f3) {
        Object[] arr = new Object[1];
        if (sanityCheck(f3, article)) {
        }
        this.helpCenterTracker.helpCenterArticleViewed();
        this.blipsProvider.articleView(article);
        super(this, f3, f3, article, locale2);
        this.settingsProvider.getSettings(anon2);
    }

    public void upvoteArticle(Long long, f<zendesk.support.ArticleVote> f2) {
        Object[] arr = new Object[1];
        if (sanityCheck(f2, long)) {
        }
        ZendeskHelpCenterProvider.12 anon = new ZendeskHelpCenterProvider.12(this, f2, f2, long);
        this.settingsProvider.getSettings(anon);
    }
}
