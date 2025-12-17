package zendesk.belvedere;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
class u {

    private zendesk.belvedere.v a;
    private zendesk.belvedere.u.c b = null;

    private interface c {
        public abstract void a(Map<String, Boolean> map, List<String> list2);
    }

    interface d {
        public abstract void a(List<zendesk.belvedere.r> list);

        public abstract void b();
    }

    class a implements zendesk.belvedere.u.c {

        final Context a;
        final List b;
        final zendesk.belvedere.u.d c;
        final zendesk.belvedere.u d;
        a(zendesk.belvedere.u u, Context context2, List list3, zendesk.belvedere.u.d u$d4) {
            this.d = u;
            this.a = context2;
            this.b = list3;
            this.c = d4;
            super();
        }

        public void a(Map<String, Boolean> map, List<String> list2) {
            Object obj2;
            zendesk.belvedere.u.d obj3;
            if (u.b(this.d, this.a)) {
                this.c.a(u.a(this.d, this.a, this.b));
            } else {
                this.c.b();
            }
        }
    }

    class b implements zendesk.belvedere.u.c {

        final zendesk.belvedere.u.c a;
        final zendesk.belvedere.u b;
        b(zendesk.belvedere.u u, zendesk.belvedere.u.c u$c2) {
            this.b = u;
            this.a = c2;
            super();
        }

        public void a(Map<String, Boolean> map, List<String> list2) {
            Object next;
            zendesk.belvedere.v vVar;
            Iterator iterator = list2.iterator();
            for (String next : iterator) {
                u.c(this.b).a(next);
            }
            this.a.a(map, list2);
            u.d(this.b, 0);
        }
    }
    u(Context context) {
        super();
        int i = 0;
        v vVar = new v(context);
        this.a = vVar;
    }

    static List a(zendesk.belvedere.u u, Context context2, List list3) {
        return u.g(context2, list3);
    }

    static boolean b(zendesk.belvedere.u u, Context context2) {
        return u.f(context2);
    }

    static zendesk.belvedere.v c(zendesk.belvedere.u u) {
        return u.a;
    }

    static void d(zendesk.belvedere.u u, zendesk.belvedere.u.c u$c2) {
        u.m(c2);
    }

    private void e(Fragment fragment, List<String> list2, zendesk.belvedere.u.c u$c3) {
        u.b bVar = new u.b(this, c3);
        m(bVar);
        fragment.requestPermissions((String[])list2.toArray(new String[list2.size()]), 9842);
    }

    private boolean f(Context context) {
        int i;
        int i2;
        final int i3 = 0;
        i = Build.VERSION.SDK_INT < 19 ? i2 : i3;
        if (i == 0) {
            if (k(context, "android.permission.READ_EXTERNAL_STORAGE") != null) {
            } else {
                i2 = i3;
            }
        }
        return i2;
    }

    private List<zendesk.belvedere.r> g(Context context, List<zendesk.belvedere.r> list2) {
        Object next;
        boolean empty;
        ArrayList arrayList = new ArrayList();
        final Iterator obj5 = list2.iterator();
        while (obj5.hasNext()) {
            next = obj5.next();
            if ((r)next.d()) {
            }
            if (TextUtils.isEmpty(next.b())) {
            } else {
            }
            if (k(context, next.b())) {
            }
            arrayList.add(next);
            arrayList.add(next);
        }
        return arrayList;
    }

    private List<String> h(Context context) {
        ArrayList arrayList = new ArrayList();
        final String str = "android.permission.READ_EXTERNAL_STORAGE";
        if (!f(context) && z ^= 1 != 0) {
            if (z ^= 1 != 0) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private List<String> i(List<zendesk.belvedere.r> list) {
        Object next;
        boolean empty;
        String str;
        ArrayList arrayList = new ArrayList();
        final Iterator obj5 = list.iterator();
        while (obj5.hasNext()) {
            next = obj5.next();
            if (!TextUtils.isEmpty((r)next.b()) && !this.a.b(next.b()) && next.d()) {
            }
            if (!this.a.b(next.b())) {
            }
            if (next.d()) {
            }
            arrayList.add(next.b());
        }
        return arrayList;
    }

    private boolean k(Context context, String string2) {
        return w.b(context, string2);
    }

    private void m(zendesk.belvedere.u.c u$c) {
        this.b = c;
    }

    void j(Fragment fragment, List<zendesk.belvedere.r> list2, zendesk.belvedere.u.d u$d3) {
        zendesk.belvedere.u.a aVar;
        Object obj4;
        final Context context = fragment.getContext();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(h(context));
        arrayList.addAll(i(list2));
        if (f(context) && arrayList.isEmpty()) {
            if (arrayList.isEmpty()) {
                d3.a(g(context, list2));
            } else {
                if (!f(context) && arrayList.isEmpty()) {
                    if (arrayList.isEmpty()) {
                        d3.b();
                    } else {
                        aVar = new u.a(this, context, list2, d3);
                        e(fragment, arrayList, aVar);
                    }
                } else {
                }
            }
        } else {
        }
    }

    boolean l(Fragment fragment, int i2, String[] string3Arr3, int[] i4Arr4) {
        int i;
        int showRequestPermissionRationale;
        int fALSE;
        if (i2 == 9842) {
            HashMap obj7 = new HashMap();
            ArrayList arrayList = new ArrayList();
            while (i < string3Arr3.length) {
                if (i4Arr4[i] == 0) {
                } else {
                }
                obj7.put(string3Arr3[i], Boolean.FALSE);
                if (i4Arr4[i] == -1 && !fragment.shouldShowRequestPermissionRationale(string3Arr3[i])) {
                }
                i++;
                obj7.put(string3Arr3[i], Boolean.FALSE);
                if (!fragment.shouldShowRequestPermissionRationale(string3Arr3[i])) {
                }
                arrayList.add(string3Arr3[i]);
                obj7.put(string3Arr3[i], Boolean.TRUE);
            }
            zendesk.belvedere.u.c obj6 = this.b;
            if (obj6 != null) {
                obj6.a(obj7, arrayList);
            }
            return 1;
        }
        return 0;
    }
}
