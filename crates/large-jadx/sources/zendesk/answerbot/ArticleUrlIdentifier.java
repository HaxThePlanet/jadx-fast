package zendesk.answerbot;

import androidx.lifecycle.x;
import f.g.e.a;
import f.g.e.g;
import java.util.List;
import okhttp3.HttpUrl;
import zendesk.core.ApplicationConfiguration;
import zendesk.support.HelpCenterProvider;

/* loaded from: classes3.dex */
class ArticleUrlIdentifier {

    private final HelpCenterProvider helpCenterProvider;
    private final String subdomain;
    ArticleUrlIdentifier(ApplicationConfiguration applicationConfiguration, HelpCenterProvider helpCenterProvider2) {
        super();
        this.subdomain = applicationConfiguration.getZendeskUrl();
        this.helpCenterProvider = helpCenterProvider2;
    }

    zendesk.answerbot.ArticleViewModel articleViewModelFromUrl(String string) {
        int indexOf;
        int i;
        boolean equals;
        String str;
        long long;
        int size;
        Object obj7;
        obj7 = HttpUrl.parse(string);
        int i2 = 0;
        if (obj7 == null) {
            return i2;
        }
        if (!this.subdomain.contains(obj7.host())) {
            return i2;
        }
        obj7 = obj7.pathSegments();
        if (obj7.size() >= 3) {
            if (obj7.size() > 4) {
            } else {
                indexOf = obj7.indexOf("articles");
                i = 0;
                if ("hc".equals(obj7.get(i))) {
                    equals = 1;
                    if (indexOf != equals && indexOf != 2) {
                        if (indexOf != 2) {
                        } else {
                            size = obj7.size();
                            if (indexOf + 2 != size) {
                                return i2;
                            }
                            obj7 = obj7.get(indexOf += equals);
                            indexOf = (String)obj7.split("-");
                            if (a.h(indexOf)) {
                                return i2;
                            }
                            if (g.f(indexOf[i])) {
                                StringBuilder stringBuilder = new StringBuilder(obj7.length());
                                if (indexOf.length > equals) {
                                    while (equals < indexOf.length) {
                                        stringBuilder.append(indexOf[equals]);
                                        stringBuilder.append(32L);
                                        equals++;
                                    }
                                    obj7 = stringBuilder.toString().trim();
                                } else {
                                    obj7 = "";
                                }
                                x xVar = new x();
                                ArticleViewModel articleViewModel = new ArticleViewModel(this.helpCenterProvider, xVar, Long.valueOf(Long.parseLong(indexOf[i])), obj7);
                                return articleViewModel;
                            }
                        }
                    } else {
                    }
                }
            }
        }
        return i2;
    }
}
