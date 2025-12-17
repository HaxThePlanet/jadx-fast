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

/* loaded from: classes3.dex */
final class o<V>  implements net.time4j.g1.z.h<V> {

    private final p<V> a;
    private final Map<V, String> b;
    private final int c;
    private final boolean v;
    private final Locale w;
    o(p<V> p, Map<V, String> map2) {
        Object hashMap;
        int size;
        int length;
        super();
        Class type = p.getType();
        if (type.isEnum()) {
            if (map2.size() < enumConstants.length) {
            } else {
                hashMap = o.a(type);
                hashMap.putAll(map2);
                this.a = p;
                this.b = Collections.unmodifiableMap(hashMap);
                this.c = 0;
                this.v = true;
                this.w = Locale.getDefault();
            }
            StringBuilder obj5 = new StringBuilder();
            obj5.append("Not enough text resources defined for enum: ");
            obj5.append(type.getName());
            IllegalArgumentException obj4 = new IllegalArgumentException(obj5.toString());
            throw obj4;
        }
        hashMap = new HashMap(map2.size());
    }

    private o(p<V> p, Map<V, String> map2, int i3, boolean z4, Locale locale5) {
        super();
        this.a = p;
        this.b = map2;
        this.c = i3;
        this.v = z4;
        this.w = locale5;
    }

    private static <V, K extends Enum<K>> Map<V, String> a(Class<V> class) {
        EnumMap enumMap = new EnumMap(class);
        return enumMap;
    }

    private String b(V v) {
        Object string;
        if ((String)this.b.get(v) == null) {
            string = v.toString();
        }
        return string;
    }

    private int c(o o, java.lang.Appendable appendable2) {
        String obj2 = b(o.p(this.a));
        appendable2.append(obj2);
        return obj2.length();
    }

    @Override // net.time4j.g1.z.h
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof o) {
            if (this.a.equals(object.a) && this.b.equals(object.b)) {
                if (this.b.equals(object.b)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    public p<V> getElement() {
        return this.a;
    }

    @Override // net.time4j.g1.z.h
    public int hashCode() {
        return i2 += i5;
    }

    @Override // net.time4j.g1.z.h
    public boolean isNumerical() {
        return 0;
    }

    public void parse(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, net.time4j.g1.z.t<?> t4, boolean z5) {
        int length2;
        int intValue;
        boolean booleanValue;
        Integer valueOf;
        int length;
        String upperCase2;
        String upperCase;
        Object obj10;
        net.time4j.engine.c obj12;
        final int i = s2.f();
        if (z5 != null) {
            intValue = this.c;
        } else {
            intValue = (Integer)d3.a(a.s, 0).intValue();
        }
        if (intValue > 0) {
            length2 -= intValue;
        }
        if (i >= length2) {
            StringBuilder obj8 = new StringBuilder();
            obj8.append("Missing chars for: ");
            obj8.append(this.a.name());
            s2.k(i, obj8.toString());
            s2.n();
        }
        if (z5 != null) {
            booleanValue = this.v;
        } else {
            booleanValue = (Boolean)d3.a(a.i, Boolean.TRUE).booleanValue();
        }
        if (z5 != null) {
            obj10 = this.w;
        } else {
            obj10 = d3.a(a.c, Locale.getDefault());
        }
        length2 -= i;
        obj12 = this.b.keySet().iterator();
        for (Object valueOf : obj12) {
            length = b(valueOf);
            upperCase2 = length.length();
            upperCase2 += i;
            length = length.length();
            length += i;
        }
        obj8 = new StringBuilder();
        obj8.append("Element value could not be parsed: ");
        obj8.append(this.a.name());
        s2.k(i, obj8.toString());
    }

    public int print(o o, java.lang.Appendable appendable2, d d3, Set<net.time4j.g1.z.g> set4, boolean z5) {
        p pVar;
        Object obj3;
        Object obj4;
        obj4 = appendable2;
        if (appendable2 instanceof CharSequence && set4 != null) {
            obj4 = appendable2;
            if (set4 != null) {
                obj3 = new g(this.a, (CharSequence)obj4.length(), obj4.length());
                set4.add(obj3);
            }
            return c(o, appendable2);
        }
        return c(o, appendable2);
    }

    public net.time4j.g1.z.h<V> quickPath(net.time4j.g1.z.c<?> c, d d2, int i3) {
        super(this.a, this.b, (Integer)d2.a(a.s, 0).intValue(), (Boolean)d2.a(a.i, Boolean.TRUE).booleanValue(), (Locale)d2.a(a.c, Locale.getDefault()));
        return obj7;
    }

    @Override // net.time4j.g1.z.h
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(512);
        stringBuilder.append(o.class.getName());
        stringBuilder.append("[element=");
        stringBuilder.append(this.a.name());
        stringBuilder.append(", resources=");
        stringBuilder.append(this.b);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public net.time4j.g1.z.h<V> withElement(p<V> p) {
        if (this.a == p) {
            return this;
        }
        o oVar = new o(p, this.b);
        return oVar;
    }
}
