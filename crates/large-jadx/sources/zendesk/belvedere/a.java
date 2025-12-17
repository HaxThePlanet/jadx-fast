package zendesk.belvedere;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class a {

    private static zendesk.belvedere.a e;
    private final Context a;
    private zendesk.belvedere.z b;
    private zendesk.belvedere.o c;
    private zendesk.belvedere.t d;

    public static class a {

        Context a;
        zendesk.belvedere.q.b b;
        boolean c = false;
        public a(Context context) {
            super();
            this.a = context.getApplicationContext();
            q.a obj1 = new q.a();
            this.b = obj1;
            obj1 = 0;
        }

        public zendesk.belvedere.a a() {
            a aVar = new a(this);
            return aVar;
        }
    }
    a(zendesk.belvedere.a.a a$a) {
        super();
        Context context = a.a;
        this.a = context;
        a.b.e(a.c);
        q.d(a.b);
        o obj4 = new o();
        this.c = obj4;
        z zVar = new z();
        this.b = zVar;
        t tVar = new t(context, zVar, obj4);
        this.d = tVar;
        q.a("Belvedere", "Belvedere initialized");
    }

    public static zendesk.belvedere.a c(Context context) {
        Object applicationContext;
        Object obj2;
        final Class<zendesk.belvedere.a> obj = a.class;
        synchronized (obj) {
            if (context == null) {
            } else {
                if (context.getApplicationContext() == null) {
                } else {
                    try {
                        applicationContext = new a.a(context.getApplicationContext());
                        a.e = applicationContext.a();
                        obj2 = new IllegalArgumentException("Invalid context provided");
                        throw obj2;
                        return a.e;
                        throw context;
                    }
                }
            }
        }
    }

    public zendesk.belvedere.r.b a() {
        r.b bVar = new r.b(this.c.d(), this.d, this.c);
        return bVar;
    }

    public zendesk.belvedere.r.c b() {
        r.c cVar = new r.c(this.c.d(), this.d);
        return cVar;
    }

    public zendesk.belvedere.s d(String string, String string2) {
        Object format;
        long contains;
        Object str;
        int intValue;
        Uri uri;
        long i;
        long l;
        long l2;
        final Object obj = this;
        final java.io.File file = obj.b.d(obj.a, string, string2);
        Object[] arr = new Object[1];
        q.a("Belvedere", String.format(Locale.US, "Get internal File: %s", file));
        uri = obj.b.i(obj.a, file);
        if (file != null && uri != null) {
            uri = obj.b.i(obj.a, file);
            if (uri != null) {
                zendesk.belvedere.s sVar = z.j(obj.a, uri);
                if (sVar.i().contains("image")) {
                    android.util.Pair pair = c.a(file);
                    l2 = contains;
                    l = i;
                } else {
                    l2 = l;
                }
                super(file, uri, uri, string2, sVar.i(), sVar.m(), obj10, l, obj12, l2, obj14);
                return sVar2;
            }
        }
        return null;
    }

    public void e(int i, int i2, Intent intent3, zendesk.belvedere.d<List<zendesk.belvedere.s>> d4, boolean z5) {
        this.d.e(this.a, i, i2, intent3, d4, z5);
    }

    public Intent f(Uri uri, String string2) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(string2)) {
            intent.setDataAndType(uri, string2);
        }
        g(intent, uri);
        return intent;
    }

    public void g(Intent intent, Uri uri2) {
        Object[] arr = new Object[2];
        q.a("Belvedere", String.format(Locale.US, "Grant Permission - Intent: %s - Uri: %s", intent, uri2));
        this.b.l(this.a, intent, uri2, 3);
    }

    public void h(List<Uri> list, String string2, zendesk.belvedere.d<List<zendesk.belvedere.s>> d3) {
        int size;
        zendesk.belvedere.z zVar;
        Object obj3;
        int obj4;
        if (list != null && list.size() > 0) {
            if (list.size() > 0) {
                y.d(this.a, this.b, d3, list, string2);
            } else {
                obj3 = new ArrayList(0);
                d3.internalSuccess(obj3);
            }
        } else {
        }
    }
}
