package com.facebook.internal.g0.g;

import com.facebook.internal.b0;
import com.facebook.internal.g0.b;
import com.facebook.internal.g0.b.a;
import com.facebook.internal.g0.f;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import com.facebook.p.b;
import com.facebook.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.y.h0;
import kotlin.y.p;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0007\u001a\u00020\u0008H\u0007J\u0008\u0010\t\u001a\u00020\u0008H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lcom/facebook/internal/instrument/anrreport/ANRHandler;", "", "()V", "MAX_ANR_REPORT_NUM", "", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "enable", "", "sendANRReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    private static final AtomicBoolean a;

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\u0008\u0006", d2 = {"<anonymous>", "", "o1", "Lcom/facebook/internal/instrument/InstrumentData;", "kotlin.jvm.PlatformType", "o2", "compare"}, k = 3, mv = {1, 5, 1})
    static final class b implements Comparator {

        public static final com.facebook.internal.g0.g.b.b a;
        static {
            b.b bVar = new b.b();
            b.b.a = bVar;
        }

        @Override // java.util.Comparator
        public final int a(b b, b b2) {
            n.e(b2, "o2");
            return b.b(b2);
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((b)object, (b)object2);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "response", "Lcom/facebook/GraphResponse;", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class a implements p.b {

        final List a;
        a(List list) {
            this.a = list;
            super();
        }

        @Override // com.facebook.p$b
        public final void b(s s) {
            int next;
            Object obj2;
            n.f(s, "response");
            obj2 = s.d();
            if (s.b() == null && obj2 != null && obj2.getBoolean("success") == 1) {
                obj2 = s.d();
                if (obj2 != null) {
                    if (obj2.getBoolean("success") == 1) {
                        obj2 = this.a.iterator();
                        for (b next : obj2) {
                            next.a();
                        }
                    }
                }
            }
        }
    }
    static {
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        b.a = atomicBoolean;
    }

    public static final void a() {
        final Class<com.facebook.internal.g0.g.b> obj = b.class;
        synchronized (obj) {
        }
    }

    public static final void b() {
        int length;
        int i;
        int i2;
        b bVar;
        if (a.d(b.class)) {
        }
        if (b0.T()) {
        }
        java.io.File[] objArr = f.h();
        ArrayList arrayList2 = new ArrayList(objArr.length);
        i = 0;
        i2 = i;
        while (i2 < objArr.length) {
            arrayList2.add(b.a.d(objArr[i2]));
            i2++;
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = arrayList2.iterator();
        while (iterator.hasNext()) {
            length = iterator.next();
            if ((b)length.f() != 0) {
            }
            arrayList.add(length);
        }
        List list = p.D0(arrayList, b.b.a);
        JSONArray jSONArray = new JSONArray();
        Iterator iterator2 = g.l(i, Math.min(list.size(), 5)).iterator();
        while (iterator2.hasNext()) {
            jSONArray.put(list.get((h0)iterator2.d()));
        }
        b.a aVar = new b.a(list);
        f.l("anr_reports", jSONArray, aVar);
    }
}
