package com.google.android.play.core.internal;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class f1 {

    private final Context a;
    public f1(Context context) {
        super();
        this.a = context;
    }

    private static String b(Locale locale) {
        String empty;
        int length;
        String obj3;
        String valueOf = String.valueOf(locale.getLanguage());
        if (locale.getCountry().isEmpty()) {
            obj3 = "";
        } else {
            obj3 = String.valueOf(locale.getCountry());
            empty = "_";
            if (obj3.length() != 0) {
                obj3 = empty.concat(obj3);
            } else {
                obj3 = new String(empty);
            }
        }
        obj3 = String.valueOf(obj3);
        if (obj3.length() != 0) {
            obj3 = valueOf.concat(obj3);
        } else {
            obj3 = new String(valueOf);
        }
        return obj3;
    }

    public final List<String> a() {
        int i;
        String str;
        Configuration configuration = this.a.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList locales = configuration.getLocales();
            ArrayList arrayList = new ArrayList(locales.size());
            i = 0;
            while (i < locales.size()) {
                arrayList.add(f1.b(locales.get(i)));
                i++;
            }
            return arrayList;
        }
        return Collections.singletonList(f1.b(configuration.locale));
    }
}
