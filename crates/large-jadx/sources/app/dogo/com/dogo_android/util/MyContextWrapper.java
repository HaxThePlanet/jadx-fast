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

/* compiled from: MyContextWrapper.kt */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u000f\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/util/MyContextWrapper;", "Landroid/content/ContextWrapper;", "base", "Landroid/content/Context;", "(Landroid/content/Context;)V", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: t, reason: from kotlin metadata */
public final class MyContextWrapper extends ContextWrapper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final t.a INSTANCE = new t$a(0);

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0003J\u0016\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\u00082\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/util/MyContextWrapper$Companion;", "", "()V", "getLocale", "Ljava/util/Locale;", "res", "Landroid/content/res/Resources;", "setLocaleForApi24", "", "config", "Landroid/content/res/Configuration;", "target", "updateResources", "Landroid/content/Context;", "context", "locale", "updateResourcesUpTo25Api", "wrap", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        private final void setLocaleForApi24(Configuration config, Locale target) {
            int i;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            linkedHashSet.add(target);
            LocaleList _default = LocaleList.getDefault();
            n.e(_default, "getDefault()");
            int size = _default.size();
            i = 0;
            if (size > 0) {
                i = i + 1;
                Locale item = _default.get(i);
                str = "all[i]";
                n.e(item, str);
                linkedHashSet.add(item);
                while (i >= size) {
                    i = i + 1;
                    item = _default.get(i);
                    str = "all[i]";
                    n.e(item, "all[i]");
                    linkedHashSet.add(item);
                }
            }
            Object[] array = linkedHashSet.toArray(new Locale[i]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            config.setLocales(new LocaleList((Locale[])Arrays.copyOf(array, array.length)));
        }

        /* renamed from: b, reason: from kotlin metadata */
        public final Context updateResources(Context context, Locale locale) {
            n.f(context, "context");
            n.f(locale, "locale");
            Resources resources = context.getResources();
            n.e(resources, "newContext.resources");
            Configuration configuration3 = new Configuration(resources.getConfiguration());
            setLocaleForApi24(configuration3, locale);
            Locale[] arr = new Locale[1];
            LocaleList.setDefault(new LocaleList(arr));
            final Context configurationContext = context.createConfigurationContext(configuration3);
            n.e(configurationContext, "context.createConfigurationContext(config)");
            configurationContext.getResources().getConfiguration().setLocale(locale);
            a.a(configurationContext);
            return configurationContext;
        }

        /* renamed from: c, reason: from kotlin metadata */
        public final void updateResourcesUpTo25Api(Resources res, Context context) {
            n.f(res, "res");
            n.f(context, "context");
            if (Build.VERSION.SDK_INT <= 25) {
                res.updateConfiguration(context.getResources().getConfiguration(), context.getResources().getDisplayMetrics());
            }
        }

        /* renamed from: d, reason: from kotlin metadata */
        public final Context wrap(Context context, p2 preferenceService) {
            n.f(context, "context");
            n.f(preferenceService, "preferenceService");
            return updateResources(context, LocaleService.b(preferenceService.W()));
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
}
