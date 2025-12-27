package net.time4j.g1.z;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import net.time4j.tz.k;

/* compiled from: ZoneLabels.java */
/* loaded from: classes3.dex */
class g0 {

    private final g0.b a;

    static class a {
    }

    static class b {

        private final char a;
        private final g0.b b;
        private final g0.b c;
        private final g0.b d;
        private final List<k> e;
        /* synthetic */ b(char c, g0.a aVar) {
            this(c);
        }

        static /* synthetic */ char a(g0.b bVar) {
            return bVar.a;
        }

        static /* synthetic */ g0.b b(g0.b bVar) {
            return bVar.b;
        }

        static /* synthetic */ g0.b c(g0.b bVar) {
            return bVar.d;
        }

        static /* synthetic */ List d(g0.b bVar) {
            return bVar.e;
        }

        static /* synthetic */ g0.b e(g0.b bVar) {
            return bVar.c;
        }

        static /* synthetic */ g0.b f(g0.b bVar, g0.b bVar2) {
            return bVar.k(bVar2);
        }

        static /* synthetic */ g0.b g(g0.b bVar, g0.b bVar2) {
            return bVar.m(bVar2);
        }

        static /* synthetic */ g0.b h(g0.b bVar, g0.b bVar2) {
            return bVar.l(bVar2);
        }

        static /* synthetic */ g0.b i(g0.b bVar, k kVar) {
            return bVar.j(kVar);
        }

        private g0.b j(k kVar) {
            final ArrayList arrayList = new ArrayList();
            if (this.e != null) {
                arrayList.addAll(this.e);
            }
            arrayList.add(kVar);
            g0.b kVar2 = new g0.b(this.a, this.b, this.c, this.d, arrayList);
            return kVar2;
        }

        private g0.b k(g0.b bVar) {
            g0.b bVar2 = new g0.b(this.a, bVar, this.c, this.d, this.e);
            return bVar2;
        }

        private g0.b l(g0.b bVar) {
            g0.b bVar2 = new g0.b(this.a, this.b, bVar, this.d, this.e);
            return bVar2;
        }

        private g0.b m(g0.b bVar) {
            g0.b bVar2 = new g0.b(this.a, this.b, this.c, bVar, this.e);
            return bVar2;
        }

        private b(char c) {
            this(c, null, null, null, null);
        }

        private b(char c, g0.b bVar, g0.b bVar2, g0.b bVar3, List<k> list) {
            super();
            this.a = c;
            this.b = bVar;
            this.c = bVar2;
            this.d = bVar3;
            this.e = list;
        }
    }
    g0(g0.b bVar) {
        super();
        this.a = bVar;
    }

    private void a(g0.b bVar, StringBuilder sb, List<String> list) {
        if (bVar == null) {
            return;
        }
        a(bVar.b, sb, list);
        if (bVar.e != null) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = sb.toString();
            char c = bVar.a;
            str = str2 + c;
            list.add(str);
        }
        sb.append(bVar.a);
        a(bVar.c, sb, list);
        sb.deleteCharAt(sb.length() - 1);
        a(bVar.d, sb, list);
    }

    private static g0.b c(g0.b bVar, String str, int i) {
        net.time4j.g1.z.g0.b bVar2;
        if (bVar == null) {
            return null;
        }
        char charAt = str.charAt(i);
        if (charAt < bVar.a) {
            return g0.c(bVar.b, str, i);
        }
        if (charAt > bVar.a) {
            return g0.c(bVar.d, str, i);
        }
        if (i < str.length() - 1) {
            i = i + 1;
            bVar2 = g0.c(bVar.c, str, i);
        }
        return bVar2;
    }

    static g0.b d(g0.b bVar, String str, k kVar) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Empty key cannot be inserted.");
        } else {
            Objects.requireNonNull(kVar, "Missing timezone id.");
            return g0.e(bVar, str, kVar, 0);
        }
    }

    private static g0.b e(g0.b bVar, String str, k kVar, int i) {
        net.time4j.g1.z.g0.b bVar3;
        net.time4j.g1.z.g0.b bVar4;
        char charAt = str.charAt(i);
        if (bVar == null) {
            net.time4j.g1.z.g0.a aVar = null;
            bVar3 = new g0.b(charAt, aVar);
        }
        if (charAt < bVar3.a) {
            bVar4 = bVar3.k(g0.e(bVar3.b, str, kVar, i));
        } else {
            if (charAt > bVar3.a) {
                bVar4 = bVar3.m(g0.e(bVar3.d, str, kVar, i));
            } else {
                if (i < str.length() - 1) {
                    i = i + 1;
                    bVar4 = bVar3.l(g0.e(bVar3.c, str, kVar, i));
                } else {
                    bVar4 = bVar3.j(kVar);
                }
            }
        }
        return bVar4;
    }

    List<k> b(String str) {
        if (str.isEmpty()) {
            return Collections.emptyList();
        }
        net.time4j.g1.z.g0.b bVar2 = g0.c(this.a, str, 0);
        if (bVar2 == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(bVar2.e);
    }

    String f(java.lang.CharSequence charSequence, int i) {
        net.time4j.g1.z.g0.b bVar;
        int i22;
        String charSequence2;
        while (this.a != null) {
        }
        if (i >= i22) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence.subSequence(i, i22).toString();
        }
        return charSequence2;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        a(this.a, new StringBuilder(), arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count=");
        stringBuilder.append(arrayList.size());
        str = ",labels={";
        stringBuilder.append(str);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            stringBuilder.append(item);
            str2 = "=>";
            stringBuilder.append(str2);
            stringBuilder.append(b(item));
            stringBuilder.append(',');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1).append('}');
        return stringBuilder.toString();
    }
}
