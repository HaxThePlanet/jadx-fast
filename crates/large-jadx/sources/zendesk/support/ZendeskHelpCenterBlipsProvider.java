package zendesk.support;

import f.g.c.a;
import f.g.e.d;
import f.g.e.g;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import zendesk.core.BlipsGroup;
import zendesk.core.BlipsProvider;
import zendesk.core.PageView;
import zendesk.core.UserAction;

/* loaded from: classes3.dex */
class ZendeskHelpCenterBlipsProvider implements zendesk.support.HelpCenterBlipsProvider {

    private static final String BLIPS_FIELD_NAME_ARTICLE_ID = "articleId";
    private static final String BLIPS_FIELD_NAME_CODE = "code";
    private static final String BLIPS_FIELD_NAME_QUERY = "query";
    private static final String BLIPS_FIELD_NAME_VOTE = "vote";
    private static final String BLIPS_FIELD_VALUE_CODE = "java";
    private static final String BLIPS_GUIDE_ACTION_SEARCH = "search";
    private static final String BLIPS_GUIDE_ACTION_VOTE = "articleVote";
    private static final String BLIPS_GUIDE_CATEGORY = "GuideSDK";
    private static final String BLIPS_GUIDE_CHANNEL = "guide_sdk";
    private static final String BLIPS_GUIDE_LABEL_HELP_CENTER = "helpCenterForm";
    private static final String BLIPS_GUIDE_VERSION = "1.0.2";
    private static final String LOG_TAG = "HelpCenterBlipsProvider";
    private BlipsProvider blipsProvider;
    private Locale locale;
    ZendeskHelpCenterBlipsProvider(BlipsProvider blipsProvider, Locale locale2) {
        super();
        this.blipsProvider = blipsProvider;
        this.locale = locale2;
    }

    private void sendUserAction(BlipsGroup blipsGroup, String string2, String string3, Map<String, Object> map4) {
        super("1.0.2", "guide_sdk", "GuideSDK", string2, string3, map4);
        this.blipsProvider.sendBlip(userAction2, blipsGroup);
    }

    @Override // zendesk.support.HelpCenterBlipsProvider
    public void articleView(zendesk.support.Article article) {
        String str = "HelpCenterBlipsProvider";
        int i = 0;
        if (article == null) {
            a.b(str, "Aborting articleView blip: Article is null", new Object[i]);
        }
        final String htmlUrl = article.getHtmlUrl();
        final String title = article.getTitle();
        final String locale2 = article.getLocale();
        String[] strArr = new String[3];
        strArr[i] = htmlUrl;
        strArr[1] = title;
        strArr[2] = locale2;
        if (!g.d(strArr)) {
            a.b(str, "Cannot blip articleView: Article required fields are null", new Object[i]);
        }
        final Long id = article.getId();
        if (id == null) {
            a.b(str, "Cannot blip articleView: Id is null", new Object[i]);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("code", "java");
        super("1.0.2", "guide_sdk", htmlUrl, d.d(this.locale), title, id, locale2, hashMap);
        this.blipsProvider.sendBlip(pageView, BlipsGroup.PATHFINDER);
    }

    @Override // zendesk.support.HelpCenterBlipsProvider
    public void articleVote(Long long, int i2) {
        if (long == null) {
        }
        HashMap hashMap = new HashMap();
        hashMap.put("articleId", long);
        hashMap.put("vote", Integer.valueOf(i2));
        sendUserAction(BlipsGroup.BEHAVIOURAL, "articleVote", 0, hashMap);
    }

    @Override // zendesk.support.HelpCenterBlipsProvider
    public void helpCenterSearch(String string) {
        if (!g.c(string)) {
        }
        HashMap hashMap = new HashMap();
        hashMap.put("query", string);
        hashMap.put("code", "java");
        sendUserAction(BlipsGroup.PATHFINDER, "search", "helpCenterForm", hashMap);
    }
}
