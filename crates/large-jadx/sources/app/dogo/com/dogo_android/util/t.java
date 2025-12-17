package app.dogo.com.dogo_android.util;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import f.c.a.f.a.d.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u000f\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/util/MyContextWrapper;", "Landroid/content/ContextWrapper;", "base", "Landroid/content/Context;", "(Landroid/content/Context;)V", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class t extends ContextWrapper {

    public static final app.dogo.com.dogo_android.util.t.a Companion;

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0003J\u0016\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\u00082\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/util/MyContextWrapper$Companion;", "", "()V", "getLocale", "Ljava/util/Locale;", "res", "Landroid/content/res/Resources;", "setLocaleForApi24", "", "config", "Landroid/content/res/Configuration;", "target", "updateResources", "Landroid/content/Context;", "context", "locale", "updateResourcesUpTo25Api", "wrap", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        private final void a(Configuration configuration, Locale locale2) {
            int i;
            Locale locale;
            int i2;
            String str;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            linkedHashSet.add(locale2);
            LocaleList obj8 = LocaleList.getDefault();
            n.e(obj8, "getDefault()");
            int size = obj8.size();
            final int i3 = 0;
            if (size > 0) {
                i = i3;
                i2 = i + 1;
                locale = obj8.get(i);
                n.e(locale, "all[i]");
                linkedHashSet.add(locale);
                while (i2 >= size) {
                    i = i2;
                    i2 = i + 1;
                    locale = obj8.get(i);
                    n.e(locale, "all[i]");
                    linkedHashSet.add(locale);
                }
            }
            obj8 = linkedHashSet.toArray(new Locale[i3]);
            Objects.requireNonNull(obj8, "null cannot be cast to non-null type kotlin.Array<T>");
            LocaleList localeList = new LocaleList((Locale[])Arrays.copyOf((Locale[])obj8, obj8.length));
            configuration.setLocales(localeList);
        }

        public final Context b(Context context, Locale locale2) {
            n.f(context, "context");
            n.f(locale2, "locale");
            Resources resources = context.getResources();
            n.e(resources, "newContext.resources");
            Configuration configuration3 = new Configuration(resources.getConfiguration());
            a(configuration3, locale2);
            Locale[] arr = new Locale[1];
            LocaleList localeList = new LocaleList(arr);
            LocaleList.setDefault(localeList);
            final Context obj5 = context.createConfigurationContext(configuration3);
            n.e(obj5, "context.createConfigurationContext(config)");
            obj5.getResources().getConfiguration().setLocale(locale2);
            a.a(obj5);
            return obj5;
        }

        public final void c(Resources resources, Context context2) {
            int configuration;
            Object obj4;
            n.f(resources, "res");
            n.f(context2, "context");
            if (Build.VERSION.SDK_INT <= 25) {
                resources.updateConfiguration(context2.getResources().getConfiguration(), context2.getResources().getDisplayMetrics());
            }
        }

        public final Context d(Context context, p2 p22) {
            n.f(context, "context");
            n.f(p22, "preferenceService");
            return b(context, n2.b(p22.W()));
        }
    }
    static {
        t.a aVar = new t.a(0);
        t.Companion = aVar;
    }
}
