package zendesk.belvedere;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class i implements zendesk.belvedere.j {

    private final zendesk.belvedere.m a;
    private final List<zendesk.belvedere.r> b;
    private final List<zendesk.belvedere.s> c;
    private final List<zendesk.belvedere.s> d;
    private final long e;
    private final boolean f;
    i(Context context, zendesk.belvedere.b.c b$c2) {
        super();
        m mVar = new m(context);
        this.a = mVar;
        this.b = c2.b();
        this.c = c2.d();
        this.d = c2.a();
        this.e = c2.c();
        this.f = c2.f();
    }

    private zendesk.belvedere.r m(int i) {
        Object next;
        int i2;
        Iterator iterator = this.b.iterator();
        for (r next : iterator) {
        }
        return null;
    }

    private List<zendesk.belvedere.s> n(List<zendesk.belvedere.s> list, List<zendesk.belvedere.s> list2) {
        android.net.Uri uri;
        int i;
        int contains;
        int obj5;
        HashSet hashSet = new HashSet(list.size());
        Iterator iterator = list.iterator();
        for (s next2 : iterator) {
            hashSet.add(next2.k());
        }
        ArrayList arrayList = new ArrayList(size2 += contains);
        arrayList.addAll(list);
        obj5--;
        while (obj5 >= 0) {
            i = list2.get(obj5);
            if (!hashSet.contains((s)i.k())) {
            }
            obj5--;
            arrayList.add(0, i);
        }
        return arrayList;
    }

    @Override // zendesk.belvedere.j
    public zendesk.belvedere.r a() {
        zendesk.belvedere.r rVar = k();
        if (rVar == null) {
            return null;
        }
        final Intent intent = rVar.a();
        intent.setPackage("com.google.android.apps.photos");
        intent.setAction("android.intent.action.GET_CONTENT");
        return rVar;
    }

    @Override // zendesk.belvedere.j
    public zendesk.belvedere.r b() {
        return m(2);
    }

    @Override // zendesk.belvedere.j
    public long c() {
        return this.e;
    }

    public List<zendesk.belvedere.s> d(zendesk.belvedere.s s) {
        this.c.add(s);
        return this.c;
    }

    @Override // zendesk.belvedere.j
    public boolean e() {
        int i;
        i = k() != null ? 1 : 0;
        return i;
    }

    @Override // zendesk.belvedere.j
    public boolean f() {
        zendesk.belvedere.r rVar;
        int i;
        String str;
        if (k() != null && this.a.a("com.google.android.apps.photos")) {
            i = this.a.a("com.google.android.apps.photos") ? 1 : 0;
        } else {
        }
        return i;
    }

    public List<zendesk.belvedere.s> g() {
        return n(this.a.b(500), n(this.d, this.c));
    }

    @Override // zendesk.belvedere.j
    public boolean h() {
        int i;
        i = b() != null ? 1 : 0;
        return i;
    }

    public List<zendesk.belvedere.s> i(zendesk.belvedere.s s) {
        this.c.remove(s);
        return this.c;
    }

    public List<zendesk.belvedere.s> j() {
        return this.c;
    }

    @Override // zendesk.belvedere.j
    public zendesk.belvedere.r k() {
        return m(1);
    }

    @Override // zendesk.belvedere.j
    public boolean l() {
        return this.f;
    }
}
