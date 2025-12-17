package androidx.core.telephony.mbms;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.LocaleList;
import android.telephony.mbms.ServiceInfo;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes5.dex */
public final class MbmsHelper {

    static class Api28Impl {
        static java.lang.CharSequence getBestNameForService(Context context, ServiceInfo serviceInfo) {
            java.lang.CharSequence nameForLocale;
            int i;
            Object next;
            String languageTag;
            final Set namedContentLocales = serviceInfo.getNamedContentLocales();
            if (namedContentLocales.isEmpty()) {
                return null;
            }
            String[] strArr = new String[namedContentLocales.size()];
            i = 0;
            Iterator iterator = serviceInfo.getNamedContentLocales().iterator();
            for (Locale next : iterator) {
                strArr[i] = next.toLanguageTag();
                i++;
            }
            Locale firstMatch = context.getResources().getConfiguration().getLocales().getFirstMatch(strArr);
            if (firstMatch == null) {
            } else {
                nameForLocale = serviceInfo.getNameForLocale(firstMatch);
            }
            return nameForLocale;
        }
    }
    public static java.lang.CharSequence getBestNameForService(Context context, ServiceInfo serviceInfo) {
        return MbmsHelper.Api28Impl.getBestNameForService(context, serviceInfo);
    }
}
