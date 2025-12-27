package net.time4j.g1;

import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.time4j.engine.d;

/* compiled from: TextAccessor.java */
/* loaded from: classes3.dex */
public final class s {

    private final List<String> a;
    s(String[] strArr) {
        super();
        this.a = Collections.unmodifiableList(Arrays.asList(strArr));
    }

    private boolean a(char c, char c2) {
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        char lowerCase;
        char c4;
        char c5;
        char lowerCase2;
        int i2 = 0;
        final int i = 1;
        char c6 = 'Z';
        char c7 = 'a';
        final char c8 = 'A';
        if (c >= c7 && c <= 'z' && c2 >= c8 && c2 <= c6) {
            c4 = (char)(c2 + 97) - c8;
            if (c == c4) {
            }
            return z;
        }
        if (c >= c8 && c <= c6) {
            if (c2 >= c8 && c2 <= c6) {
                c5 = (char)(c2 + 97) - c8;
            }
            if ((char)(c + c7) - c8 == c5) {
            }
            return z2;
        }
        if (Character.toUpperCase(c) != Character.toUpperCase(c2)) {
            if (Character.toLowerCase(c) == Character.toLowerCase(c2)) {
            }
        }
        return z3;
    }

    private <V extends Enum<V>> V f(java.lang.CharSequence charSequence, ParsePosition parsePosition, Class<V> cls, boolean z, boolean z2, boolean z3) {
        int size;
        int i = 1;
        char charAt;
        int i2 = 1;
        int index;
        String name;
        char charAt2;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        final Object charSequence2 = this;
        Object parsePosition22 = charSequence;
        final Object cls32 = parsePosition;
        final Object[] enumConstants = cls.getEnumConstants();
        size = charSequence2.a.size();
        index = parsePosition.getIndex();
        final int length2 = charSequence.length();
        name = "";
        i5 = 0;
        i6 = 0;
        index = 0;
        while (i5 < enumConstants.length) {
            boolean empty = name.isEmpty();
            while (i2 != 0) {
            }
            if (z3 && empty && length == 5) {
            }
        }
        if (i6 == 0) {
            cls32.setErrorIndex(index);
        } else {
            index = index + index;
            cls32.setIndex(index);
        }
        return i6;
    }

    public List<String> b() {
        return this.a;
    }

    public <V extends Enum<V>> V c(java.lang.CharSequence charSequence, ParsePosition parsePosition, Class<V> cls) {
        return this.f(charSequence, parsePosition, cls, true, false, true);
    }

    public <V extends Enum<V>> V d(java.lang.CharSequence charSequence, ParsePosition parsePosition, Class<V> cls, d dVar) {
        final Boolean tRUE2 = Boolean.TRUE;
        return this.f(charSequence, parsePosition, cls, (Boolean)dVar.a(a.i, tRUE2).booleanValue(), (Boolean)dVar.a(a.j, Boolean.FALSE).booleanValue(), (Boolean)dVar.a(a.k, tRUE2).booleanValue());
    }

    public <V extends Enum<V>> V e(java.lang.CharSequence charSequence, ParsePosition parsePosition, Class<V> cls, g gVar) {
        net.time4j.g1.g sTRICT2;
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        i = 0;
        i = 1;
        if (gVar == g.STRICT) {
        }
        return this.f(charSequence, parsePosition, cls, z, z2, z3);
    }

    public String g(Enum<?> enum_) {
        final int ordinal = enum_.ordinal();
        if (this.a.size() <= ordinal) {
            return enum_.name();
        }
        return (String)this.a.get(ordinal);
    }

    public String toString() {
        int i = 1;
        Object item;
        int size = this.a.size();
        final StringBuilder stringBuilder = new StringBuilder((size * 16) + 2);
        stringBuilder.append('{');
        i = 0;
        i = 1;
        while (i < this.a) {
            stringBuilder.append((String)this.a.get(i));
            i = i + 1;
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

}
