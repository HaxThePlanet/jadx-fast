package zendesk.support.guide;

import android.content.Context;
import com.google.gson.JsonElement;
import f.g.c.a;
import f.g.e.a;
import f.g.e.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o.a.a;
import o.a.c;
import okhttp3.HttpUrl;
import zendesk.core.ActionDescription;
import zendesk.core.ActionHandler;

/* loaded from: classes3.dex */
class ViewArticleActionHandler implements ActionHandler {

    private static final String HC_PATH_ELEMENT_ARTICLE = "articles";
    private static final String HC_PATH_ELEMENT_HC = "hc";
    private static final String HC_PATH_ELEMENT_NAME_SEPARATOR = "-";
    private static final String HELP_CENTER_ARTICLE_ID = "help_center_article_id";
    private static final String HELP_CENTER_ARTICLE_TITLE = "help_center_article_title";
    static final String HELP_CENTER_VIEW_ARTICLE = "help_center_view_article";
    private static final String LOG_TAG = "ViewArticleActionHandle";

    static class ActionPayload {

        private final String action;
        private final Map<String, Object> payload;
        private ActionPayload(String string, Map<String, Object> map2) {
            super();
            this.action = string;
            this.payload = map2;
        }

        static Map access$000(zendesk.support.guide.ViewArticleActionHandler.ActionPayload viewArticleActionHandler$ActionPayload) {
            return actionPayload.payload;
        }

        static zendesk.support.guide.ViewArticleActionHandler.ActionPayload invalid(String string) {
            ViewArticleActionHandler.ActionPayload actionPayload = new ViewArticleActionHandler.ActionPayload(string, 0);
            return actionPayload;
        }

        static zendesk.support.guide.ViewArticleActionHandler.ActionPayload valid(String string, Map<String, Object> map2) {
            ViewArticleActionHandler.ActionPayload actionPayload = new ViewArticleActionHandler.ActionPayload(string, map2);
            return actionPayload;
        }

        public String getAction() {
            return this.action;
        }

        public Map<String, Object> getPayload() {
            return this.payload;
        }

        boolean isValid() {
            boolean payload;
            int i;
            if (g.c(this.action) && this.payload != null) {
                i = this.payload != null ? 1 : 0;
            } else {
            }
            return i;
        }
    }
    public static Map<String, Object> data(long l, String string2) {
        HashMap hashMap = new HashMap();
        hashMap.put("help_center_article_id", Long.valueOf(l));
        hashMap.put("help_center_article_title", obj3);
        return hashMap;
    }

    @Override // zendesk.core.ActionHandler
    public boolean canHandle(String string) {
        HttpUrl obj1 = HttpUrl.parse(string);
        if (obj1 == null) {
            return 0;
        }
        return parse(obj1).isValid();
    }

    @Override // zendesk.core.ActionHandler
    public ActionDescription getActionDescription() {
        return null;
    }

    @Override // zendesk.core.ActionHandler
    public int getPriority() {
        return 0;
    }

    public void handle(Map<String, Object> map, Context context2) {
        Object builder;
        String str;
        List obj4;
        if (map == null) {
            a.k("ViewArticleActionHandle", "Property map is null, cannot open article.", new Object[0]);
        }
        Object obj = map.get("help_center_view_article");
        if (g.e((String)obj)) {
        }
        HttpUrl parse = HttpUrl.parse(obj);
        if (parse == null) {
        }
        builder = parse(parse);
        if (!builder.isValid()) {
        }
        str = "help_center_article_id";
        boolean key = ViewArticleActionHandler.ActionPayload.access$000(builder).containsKey(str);
        if (key != null) {
            obj4 = c.f(map, a.class);
            if (obj4 != null) {
                obj4 = obj4.getConfigurations();
            } else {
                obj4 = Collections.emptyList();
            }
            ViewArticleActivity.builder((Long)ViewArticleActionHandler.ActionPayload.access$000(builder).get(str).longValue()).show(context2, obj4);
        }
    }

    @Override // zendesk.core.ActionHandler
    zendesk.support.guide.ViewArticleActionHandler.ActionPayload parse(HttpUrl httpUrl) {
        int size2;
        int i;
        int equals;
        String str;
        int size;
        String obj7;
        obj7 = httpUrl.pathSegments();
        final String str4 = "help_center_view_article";
        if (obj7.size() >= 3) {
            if (obj7.size() > 4) {
            } else {
                int indexOf = obj7.indexOf("articles");
                int i3 = 0;
                if ("hc".equals(obj7.get(i3))) {
                    equals = 1;
                    if (indexOf != equals && indexOf != 2) {
                        if (indexOf != 2) {
                        } else {
                            size = obj7.size();
                            if (indexOf + 2 != size) {
                                return ViewArticleActionHandler.ActionPayload.invalid(str4);
                            }
                            obj7 = obj7.get(indexOf += equals);
                            String[] split = (String)obj7.split("-");
                            if (a.h(split)) {
                                return ViewArticleActionHandler.ActionPayload.invalid(str4);
                            }
                            StringBuilder stringBuilder = new StringBuilder(obj7.length());
                            if (split.length > equals) {
                                while (equals < split.length) {
                                    stringBuilder.append(split[equals]);
                                    stringBuilder.append(' ');
                                    equals++;
                                }
                                obj7 = stringBuilder.toString().trim();
                            } else {
                                obj7 = "";
                            }
                        }
                    } else {
                    }
                    return ViewArticleActionHandler.ActionPayload.valid(str4, ViewArticleActionHandler.data(Long.valueOf(Long.parseLong(split[i3])).longValue(), equals));
                }
            }
            return ViewArticleActionHandler.ActionPayload.invalid(str4);
        }
        return ViewArticleActionHandler.ActionPayload.invalid(str4);
    }

    public void updateSettings(Map<String, JsonElement> map) {
    }
}
