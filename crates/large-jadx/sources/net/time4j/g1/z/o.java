package net.time4j.g1.z;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.g1.a;

/* compiled from: LookupProcessor.java */
/* loaded from: classes3.dex */
final class o<V> implements h<V> {

    private final p<V> a;
    private final Map<V, String> b;
    private final int c;
    private final boolean v;
    private final Locale w;
    o(p<V> pVar, Map<V, String> map) {
        super();
        Class type = pVar.getType();
        if (type.isEnum()) {
            length = type.getEnumConstants().length;
            if (map.size() < type.getEnumConstants().length) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Not enough text resources defined for enum: ";
                String name = type.getName();
                map = str + name;
                throw new IllegalArgumentException(map);
            } else {
                map = o.a(type);
                map.putAll(map);
                this.a = pVar;
                this.b = Collections.unmodifiableMap(map);
                this.c = 0;
                this.v = true;
                this.w = Locale.getDefault();
                return;
            }
        }
        HashMap hashMap = new HashMap(map.size());
    }

    private static <V, K extends Enum<K>> Map<V, String> a(Class<V> cls) {
        return new EnumMap(cls);
    }

    private String b(V v) {
        Object value;
        if ((String)this.b.get(v) == null) {
            String object = v.toString();
        }
        return value;
    }

    private int c(o oVar, java.lang.Appendable appendable) throws java.io.IOException {
        String str = b(oVar.p(this.a));
        appendable.append(str);
        return str.length();
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        boolean equals2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof o) {
            if (this.a.equals(object.a)) {
                if (!(this.b.equals(object.b))) {
                }
            }
            return z;
        }
        return false;
    }

    public p<V> getElement() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.a.hashCode() * 7) + (this.b.hashCode() * 31);
    }

    public void parse(java.lang.CharSequence charSequence, s sVar, d dVar, t<?> tVar, boolean z) {
        int length;
        int value;
        boolean booleanValue;
        Integer num;
        Boolean item;
        String charSequence2;
        Locale locale;
        final int i = sVar.f();
        if (z) {
        } else {
            value = (Integer)dVar.a(a.s, null).intValue();
        }
        if (this.c > 0) {
            length = charSequence.length() - value;
        }
        if (i >= length) {
            StringBuilder stringBuilder = new StringBuilder();
            String str5 = "Missing chars for: ";
            String name = this.a.name();
            str3 = str5 + name;
            sVar.k(i, str3);
            sVar.n();
            return;
        }
        if (z) {
        } else {
            booleanValue = (Boolean)dVar.a(a.i, Boolean.TRUE).booleanValue();
        }
        if (z) {
        } else {
            Object obj3 = dVar.a(a.c, Locale.getDefault());
        }
        length -= i;
        Iterator it = this.b.keySet().iterator();
        while (it.hasNext()) {
            item = it.next();
            String str2 = b(item);
            int length3 = str2.length();
            if (length3 <= i2) {
                length3 += i;
            }
            int length2 = str2.length();
            if (length2 <= i2) {
                length2 = length2 + i;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        String str6 = "Element value could not be parsed: ";
        String name2 = this.a.name();
        str4 = str6 + name2;
        sVar.k(i, str4);
    }

    public int print(o oVar, java.lang.Appendable appendable, d dVar, Set<g> set, boolean z) {
        if (appendable instanceof CharSequence) {
            appendable22 = appendable;
            if (set != null) {
                set.add(new g(this.a, appendable22.length(), appendable22.length()));
            }
            return c(oVar, appendable);
        }
        return c(oVar, appendable);
    }

    public h<V> quickPath(c<?> cVar, d dVar, int i) {
        o cVar2 = new o(this.a, this.b, (Integer)dVar.a(a.s, null).intValue(), (Boolean)dVar.a(a.i, Boolean.TRUE).booleanValue(), (Locale)dVar.a(a.c, Locale.getDefault()));
        return cVar2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(512);
        String name = o.class.getName();
        String str2 = "[element=";
        String name2 = this.a.name();
        String str3 = ", resources=";
        str = 512 + name + str2 + name2 + str3 + this.b + 93;
        return str;
    }

    public h<V> withElement(p<V> pVar) {
        if (this.a == pVar) {
            return this;
        }
        return new o(pVar, this.b);
    }

    private o(p<V> pVar, Map<V, String> map, int i, boolean z, Locale locale) {
        super();
        this.a = pVar;
        this.b = map;
        this.c = i;
        this.v = z;
        this.w = locale;
    }

    public boolean isNumerical() {
        return false;
    }
}
