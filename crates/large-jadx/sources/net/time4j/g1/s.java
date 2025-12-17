package net.time4j.g1;

import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.time4j.engine.d;

/* loaded from: classes3.dex */
public final class s {

    private final List<String> a;
    static {
    }

    s(String[] stringArr) {
        super();
        this.a = Collections.unmodifiableList(Arrays.asList(stringArr));
    }

    private boolean a(char c, char c2) {
        int i2;
        int i;
        int obj7;
        int obj8;
        i2 = 0;
        final int i3 = 1;
        int i4 = 90;
        int i5 = 97;
        final int i6 = 65;
        if (c >= i5 && c <= 122 && c2 >= i6 && c2 <= i4) {
            if (c <= 122) {
                if (c2 >= i6) {
                    if (c2 <= i4) {
                        obj8 = (char)obj8;
                    }
                }
                if (c == obj8) {
                    i2 = i3;
                }
                return i2;
            }
        }
        if (c >= i6 && c <= i4 && c2 >= i6 && c2 <= i4) {
            if (c <= i4) {
                if (c2 >= i6) {
                    if (c2 <= i4) {
                        obj8 = (char)obj8;
                    }
                }
                if ((char)obj7 == obj8) {
                    i2 = i3;
                }
                return i2;
            }
        }
        if (Character.toUpperCase(c) != Character.toUpperCase(c2)) {
            if (Character.toLowerCase(c) == Character.toLowerCase(c2)) {
                i2 = i3;
            }
        } else {
        }
        return i2;
    }

    private <V extends Enum<V>> V f(java.lang.CharSequence charSequence, ParsePosition parsePosition2, Class<V> class3, boolean z4, boolean z5, boolean z6) {
        int charAt;
        int i2;
        int i;
        char charAt3;
        int index;
        int stringBuilder;
        String charAt2;
        int charAt4;
        int i3;
        int i7;
        String name;
        int i5;
        boolean empty;
        int length;
        int i8;
        int i4;
        String str;
        int i6;
        final Object obj = this;
        Object obj2 = charSequence;
        final Object obj4 = parsePosition2;
        final Object[] enumConstants = class3.getEnumConstants();
        charAt = obj.a.size();
        index = parsePosition2.getIndex();
        final int length2 = charSequence.length();
        name = charAt2;
        i3 = 0;
        i7 = 0;
        i5 = 0;
        while (i3 < enumConstants.length) {
            empty = name.isEmpty();
            if (empty) {
            }
            length = name.length();
            stringBuilder = index;
            charAt4 = 0;
            i8 = 1;
            while (i8 != 0) {
                if (charAt4 < length) {
                }
                i = index + charAt4;
                if (i >= length2) {
                } else {
                }
                str = charAt2;
                int i10 = 32;
                i6 = i7;
                i7 = 160;
                if (z6 && obj2.charAt(i) == i7) {
                }
                if (z4) {
                } else {
                }
                if (charAt3 == charAt2) {
                } else {
                }
                i = 0;
                if (i != 0) {
                }
                i8 = i;
                charAt4++;
                charAt = i4;
                charAt2 = str;
                i7 = i6;
                stringBuilder++;
                i = 1;
                if (charAt3 != charAt2) {
                } else {
                }
                if (obj.a(charAt3, charAt2)) {
                } else {
                }
                i7 = 160;
                if (obj2.charAt(i) == i7) {
                }
                if (name.charAt(charAt4) == i7) {
                }
                charAt2 = i10;
                charAt3 = i10;
                str = charAt2;
                i6 = i7;
                i8 = 0;
            }
            str = charAt2;
            stringBuilder -= index;
            if (i5 < stringBuilder) {
            } else {
            }
            if (i5 == stringBuilder) {
            } else {
            }
            name = str;
            i7 = i6;
            i2 = 1;
            i3 += i2;
            charAt = i4;
            charAt2 = str;
            name = str;
            i2 = 1;
            i7 = 0;
            i7 = (Enum[])enumConstants[i3];
            i5 = stringBuilder;
            name = str;
            charAt2 = 46;
            charAt = index + 3;
            stringBuilder = new StringBuilder();
            stringBuilder.append(name.subSequence(index, charAt));
            stringBuilder.append(".");
            i3--;
            name = charAt;
            if (charAt4 < length) {
            }
            i = index + charAt4;
            if (i >= length2) {
            } else {
            }
            str = charAt2;
            i10 = 32;
            i6 = i7;
            i7 = 160;
            if (z6 && obj2.charAt(i) == i7) {
            }
            if (z4) {
            } else {
            }
            if (charAt3 == charAt2) {
            } else {
            }
            i = 0;
            if (i != 0) {
            }
            i8 = i;
            charAt4++;
            charAt = i4;
            charAt2 = str;
            i7 = i6;
            stringBuilder++;
            i = 1;
            if (charAt3 != charAt2) {
            } else {
            }
            if (obj.a(charAt3, charAt2)) {
            } else {
            }
            i7 = 160;
            if (obj2.charAt(i) == i7) {
            }
            if (name.charAt(charAt4) == i7) {
            }
            charAt2 = i10;
            charAt3 = i10;
            str = charAt2;
            i6 = i7;
            i8 = 0;
            if (i3 >= charAt) {
            } else {
            }
            name = obj.a.get(i3);
            name = enumConstants[i3].name();
        }
        int i11 = i7;
        if (i11 == 0) {
            obj4.setErrorIndex(index);
        } else {
            obj4.setIndex(index += i5);
        }
        return i11;
    }

    public List<String> b() {
        return this.a;
    }

    public <V extends Enum<V>> V c(java.lang.CharSequence charSequence, ParsePosition parsePosition2, Class<V> class3) {
        return this.f(charSequence, parsePosition2, class3, true, false, true);
    }

    public <V extends Enum<V>> V d(java.lang.CharSequence charSequence, ParsePosition parsePosition2, Class<V> class3, d d4) {
        final Boolean tRUE = Boolean.TRUE;
        return this.f(charSequence, parsePosition2, class3, (Boolean)d4.a(a.i, tRUE).booleanValue(), (Boolean)d4.a(a.j, Boolean.FALSE).booleanValue(), (Boolean)d4.a(a.k, tRUE).booleanValue());
    }

    public <V extends Enum<V>> V e(java.lang.CharSequence charSequence, ParsePosition parsePosition2, Class<V> class3, net.time4j.g1.g g4) {
        net.time4j.g1.g sTRICT;
        int i3;
        int i2;
        int i;
        final int i4 = 0;
        final int i5 = 1;
        if (g4 == g.STRICT) {
            i3 = i4;
            i = i2;
        } else {
        }
        return this.f(charSequence, parsePosition2, class3, i3, i2, i);
    }

    public String g(Enum<?> enum) {
        final int ordinal = enum.ordinal();
        if (this.a.size() <= ordinal) {
            return enum.name();
        }
        return (String)this.a.get(ordinal);
    }

    public String toString() {
        int i;
        int i2;
        Object obj;
        int size = this.a.size();
        StringBuilder stringBuilder = new StringBuilder(i4 += 2);
        stringBuilder.append('{');
        int i7 = 0;
        i = 1;
        i2 = i7;
        while (i2 < size) {
            if (i != 0) {
            } else {
            }
            stringBuilder.append(',');
            stringBuilder.append((String)this.a.get(i2));
            i2++;
            i = i7;
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
