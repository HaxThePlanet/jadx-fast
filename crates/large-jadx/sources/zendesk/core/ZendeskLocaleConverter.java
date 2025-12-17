package zendesk.core;

import f.g.e.g;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public class ZendeskLocaleConverter {

    private static final Map<String, String> forwardLookupMap;
    static {
        HashMap hashMap = new HashMap();
        ZendeskLocaleConverter.forwardLookupMap = hashMap;
        hashMap.put("iw", "he");
        hashMap.put("nb", "no");
        hashMap.put("in", "id");
        hashMap.put("ji", "yi");
    }

    public String toHelpCenterLocaleString(Locale locale) {
        boolean z;
        int i;
        Object language;
        boolean str;
        Locale obj4;
        if (locale != null && g.c(locale.getLanguage())) {
            i = g.c(locale.getLanguage()) ? 1 : 0;
        } else {
        }
        if (i != 0) {
        } else {
            obj4 = Locale.getDefault();
        }
        if (g.c((String)ZendeskLocaleConverter.forwardLookupMap.get(obj4.getLanguage()))) {
        } else {
            language = obj4.getLanguage();
        }
        StringBuilder stringBuilder = new StringBuilder(language);
        if (g.c(obj4.getCountry())) {
            stringBuilder.append("-");
            stringBuilder.append(obj4.getCountry());
        }
        return stringBuilder.toString().toLowerCase();
    }
}
