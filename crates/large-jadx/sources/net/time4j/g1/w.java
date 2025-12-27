package net.time4j.g1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import net.time4j.engine.j0;

/* compiled from: TimeSpanFormatter.java */
/* loaded from: classes3.dex */
public abstract class w<U, S extends j0<U>> {

    private final List<w.b<U>> a;

    static class a {
    }

    private static abstract class b<U> {
        b(int i) {
            super();
        }

        abstract int a();

        abstract w.b<U> b(int i);
    }

    private static class c<U> extends w.b<U> {

        private final int a;
        private final U b;
        /* synthetic */ c(int i, int i2, Object object, w.a aVar) {
            this(i, i2, object);
        }

        @Override // net.time4j.g1.w$b
        int a() {
            return this.a;
        }

        @Override // net.time4j.g1.w$b
        w.b<U> b(int i) {
            return new w.c(i, this.a, this.b);
        }

        private c(int i, int i2, U u) {
            super(i);
            int i3 = 1;
            if (i2 < 1) {
                final StringBuilder stringBuilder = new StringBuilder();
                final String str = "Fraction width out of bounds: ";
                i2 = str + i2;
                throw new IllegalArgumentException(i2);
            } else {
                i3 = 9;
                if (i2 <= 9) {
                    this.a = i2;
                    this.b = u;
                    return;
                }
            }
        }
    }

    private static class d<U> extends w.b<U> {

        private final String a;
        /* synthetic */ d(String str, w.a aVar) {
            this(str);
        }

        @Override // net.time4j.g1.w$b
        int a() {
            return this.a.length();
        }

        @Override // net.time4j.g1.w$b
        w.b<U> b(int i) {
            return new w.d(i, this.a);
        }

        /* synthetic */ d(String str, boolean z, w.a aVar) {
            this(str, z);
        }

        private d(String str) {
            this(str, false);
        }

        private d(String str, boolean z) {
            super(0);
            this.a = str;
        }

        private d(int i, String str) {
            super(i);
            this.a = str;
        }
    }

    private static class e<U> extends w.b<U> {

        private final int a;
        private final int b;
        private final U c;
        /* synthetic */ e(int i, int i2, int i3, Object object, w.a aVar) {
            this(i, i2, i3, object);
        }

        @Override // net.time4j.g1.w$b
        int a() {
            return this.a;
        }

        @Override // net.time4j.g1.w$b
        w.b<U> b(int i) {
            return new w.e(i, this.a, this.b, this.c);
        }

        private e(int i, int i2, int i3, U u) {
            super(i);
            int i4 = 1;
            if (i2 < 1) {
                final StringBuilder stringBuilder2 = new StringBuilder();
                String str3 = "Min width out of bounds: ";
                i2 = str3 + i2;
                throw new IllegalArgumentException(i2);
            } else {
                i4 = 18;
                if (i2 <= i4) {
                    if (i3 < i2) {
                        throw new IllegalArgumentException("Max width smaller than min width.");
                    } else {
                        if (i3 > i4) {
                            StringBuilder stringBuilder = new StringBuilder();
                            String str4 = "Max width out of bounds: ";
                            i2 = str4 + i3;
                            throw new IllegalArgumentException(i2);
                        } else {
                            Objects.requireNonNull(u, "Missing unit.");
                            this.a = i2;
                            this.b = i3;
                            this.c = u;
                            return;
                        }
                    }
                }
            }
        }
    }

    private static class f<U> extends w.b<U> {

        private final List<w.b<U>> a;
        /* synthetic */ f(List list, w.a aVar) {
            this(list);
        }

        @Override // net.time4j.g1.w$b
        w.b<U> b(int i) {
            int i2;
            int i4;
            final ArrayList arrayList = new ArrayList(this.a);
            i2 = arrayList.size() - 1;
            while (i2 >= 0) {
                Object item = arrayList.get(i2);
                arrayList.set(i2, item.b(i4));
                i4 = i4 + item.a();
                i2 = i2 - 1;
            }
            return new w.f(arrayList);
        }

        private f(List<w.b<U>> list) {
            int i = 0;
            super(i);
            if (list.isEmpty()) {
                throw new IllegalArgumentException("Optional section is empty.");
            } else {
                net.time4j.g1.w.g gVar = w.g.a;
                if (list.get(i) == w.g.a) {
                    throw new IllegalArgumentException("Optional section must not start or end with an or-operator.");
                } else {
                    if (list.get(list.size() - 1) != w.g.a) {
                        this.a = Collections.unmodifiableList(list);
                        return;
                    }
                }
            }
        }

        @Override // net.time4j.g1.w$b
        int a() {
            return 0;
        }
    }

    private static class g<U> extends w.b<U> {

        static final w.g a = new w$g();

        private g() {
            super(0);
        }

        static <U> w.b<U> c() {
            return w.g.a;
        }

        @Override // net.time4j.g1.w$b
        int a() {
            return 0;
        }

        @Override // net.time4j.g1.w$b
        w.b<U> b(int i) {
            return this;
        }
    }

    private static class h<U> extends w.b<U> {

        private final w.e<U> a;
        private final w.b<U> b;
        private final p c;
        private final Map<n, String> d;
        private final int e;
        /* synthetic */ h(Object object, String str, p pVar, Map map, w.a aVar) {
            this(object, str, pVar, map);
        }

        @Override // net.time4j.g1.w$b
        int a() {
            return this.e;
        }

        @Override // net.time4j.g1.w$b
        w.b<U> b(int i) {
            w.h hVar = new w.h(i, this.a, this.b, this.c, this.d, this.e);
            return hVar;
        }

        private h(U u, String str, p pVar, Map<n, String> map) {
            int length = 2147483647;
            super(0);
            super(0, 1, 18, u, null);
            this.a = eVar;
            this.b = new w.d(str, true, null);
            this.c = pVar;
            this.d = map;
            Iterator it = map.values().iterator();
            length = Integer.MAX_VALUE;
            while (it.hasNext()) {
                Object item = it.next();
            }
            this.e = length;
        }

        private h(int i, w.e<U> eVar, w.b<U> bVar, p pVar, Map<n, String> map, int i2) {
            super(i);
            this.a = eVar;
            this.b = bVar;
            this.c = pVar;
            this.d = map;
            this.e = i2;
        }
    }

    private static class i<U> extends w.b<U> {

        private final char a;
        private final char b;
        /* synthetic */ i(char c, char c2, w.a aVar) {
            this(c, c2);
        }

        @Override // net.time4j.g1.w$b
        w.b<U> b(int i) {
            return new w.i(i, this.a, this.b);
        }

        private i(char c, char c2) {
            this(0, c, c2);
        }

        private i(int i, char c, char c2) {
            super(i);
            this.a = c;
            this.b = c2;
        }

        @Override // net.time4j.g1.w$b
        int a() {
            return 1;
        }
    }

    private static class j<U> extends w.b<U> {

        private final boolean a;
        /* synthetic */ j(boolean z, w.a aVar) {
            this(z);
        }

        @Override // net.time4j.g1.w$b
        int a() {
            return this.a;
        }

        @Override // net.time4j.g1.w$b
        w.b<U> b(int i) {
            return new w.j(i, this.a);
        }

        private j(boolean z) {
            super(0);
            this.a = z;
        }

        private j(int i, boolean z) {
            super(i);
            this.a = z;
        }
    }
    protected w(Class<U> cls, String str) {
        int i;
        int i2;
        char charAt;
        int i4;
        char charAt2 = 123;
        char charAt3;
        String str3;
        net.time4j.g1.w.a aVar;
        char charAt4;
        net.time4j.g1.w.i iVar;
        int i5;
        super();
        Objects.requireNonNull(cls, "Missing unit type.");
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ArrayList());
        boolean z = false;
        int i3 = 1;
        while (i2 < length) {
            charAt = str.charAt(i2);
            if (charAt != '#') {
            }
        }
        if (arrayList.size() > i3) {
            throw new IllegalArgumentException("Open square bracket without closing one.");
        } else {
            if (arrayList.isEmpty()) {
                throw new IllegalArgumentException("Empty or invalid pattern.");
            } else {
                Object item4 = arrayList.get(z);
                if (item4.isEmpty()) {
                    throw new IllegalArgumentException("Missing format pattern.");
                } else {
                    net.time4j.g1.w.g gVar = w.g.a;
                    if (item4.get(z) == w.g.a) {
                        throw new IllegalArgumentException("Pattern must not start or end with an or-operator.");
                    } else {
                        if (item4.get(item4.size() - i3) != w.g.a) {
                            int size3 = item4.size();
                            i = (w.b)item4.get(size3 - 1).a();
                            i5 = size3 - 2;
                            while (i5 >= 0) {
                                Object item3 = item4.get(i5);
                                i5 = i5 - 1;
                            }
                            this.a = Collections.unmodifiableList(item4);
                            return;
                        }
                    }
                }
            }
        }
    }

    private void a(char c, List<List<w.b<U>>> list) {
        b(String.valueOf(c), list);
    }

    private void b(String str, List<List<w.b<U>>> list) {
        w.h(list).add(new w.d(str, null));
    }

    private void c(String str, List<List<w.b<U>>> list) {
        Locale locale;
        int i2 = 3;
        String[] parts = str.split(":");
        length = parts.length;
        final String str8 = "Plural information has wrong format: ";
        int i = 9;
        if (parts.length > 9) {
            StringBuilder stringBuilder6 = new StringBuilder();
            str = str8 + str;
            throw new IllegalArgumentException(str);
        } else {
            length = parts.length;
            i = 4;
            if (parts.length >= 4) {
                int i4 = 0;
                final int i6 = 1;
                if (parts[i4].length() != i6) {
                    StringBuilder stringBuilder5 = new StringBuilder();
                    String str7 = "Plural information has wrong symbol: ";
                    str = str7 + str;
                    throw new IllegalArgumentException(str);
                } else {
                    int i5 = 2;
                    String[] parts2 = parts[i5].split("-|_");
                    String str14 = parts2[i4];
                    length2 = parts2.length;
                    i2 = 3;
                    if (parts2.length > i6) {
                        String str19 = parts2[i6];
                        if (parts2.length > i5) {
                            if (parts2.length > 3) {
                                StringBuilder stringBuilder = new StringBuilder();
                                String str4 = "Plural information has wrong locale: ";
                                str = str4 + str;
                                throw new IllegalArgumentException(str);
                            } else {
                                locale = new Locale(str14, str19, parts2[i5]);
                            }
                        }
                        locale = new Locale(str14, str19);
                    } else {
                        locale = new Locale(str14);
                    }
                    EnumMap enumMap = new EnumMap(n.class);
                    for (String str12 : parts) {
                        String[] parts3 = str12.split("=");
                        if (parts3.length != i5) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            str = str8 + str;
                            throw new IllegalArgumentException(str);
                        }
                    }
                    if (enumMap.isEmpty()) {
                        StringBuilder stringBuilder4 = new StringBuilder();
                        String str6 = "Missing plural forms: ";
                        str = str6 + str;
                        throw new IllegalArgumentException(str);
                    } else {
                        if (!enumMap.containsKey(n.OTHER)) {
                            StringBuilder stringBuilder3 = new StringBuilder();
                            String str5 = "Missing plural category OTHER: ";
                            str = str5 + str;
                            throw new IllegalArgumentException(str);
                        } else {
                            w.h list22 = new w.h(f(parts[i4].charAt(i4)), parts[i6], p.g(locale, k.CARDINALS), enumMap, null);
                            w.h(list).add(list22);
                            return;
                        }
                    }
                }
            }
        }
    }

    private void d(char c, int i, int i2, List<List<w.b<U>>> list) {
        final Object item = list.get(list.size() - 1);
        if (c == 102 && i2 <= 0) {
            i = 0;
            net.time4j.g1.w.a aVar = null;
            item.add(new w.c(i, i, f(c), aVar));
            return;
        }
        i4 = i + i2;
        net.time4j.g1.w.a aVar2 = null;
        w.e c2 = new w.e(0, i, i4, f(c), aVar2);
        item.add(c2);
    }

    private static <U> void e(List<List<w.b<U>>> list) {
        int i3 = 1;
        int i = list.size() - i3;
        if (i < i3) {
            throw new IllegalArgumentException("Closing square bracket without open one.");
        } else {
            (List)list.get(i - i3).add(new w.f((List)list.remove(i), null));
            return;
        }
    }

    private static <U> List<w.b<U>> h(List<List<w.b<U>>> list) {
        return (List)list.get(list.size() - 1);
    }

    private static <U> void i(List<List<w.b<U>>> list) {
        list.add(new ArrayList());
    }


    private static boolean g(char c) {
        int i = 90;
        boolean z = true;
        i = 65;
        if (c < 65 || c > 90) {
            i = 97;
            c = c >= 97 && c <= 122 ? 1 : 0;
        }
        return (c >= 97 && c <= 122 ? 1 : 0);
    }

    protected abstract U f(char c);
}
