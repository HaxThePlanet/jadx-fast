package com.google.common.io;

import com.google.common.base.b;
import com.google.common.base.k;
import com.google.common.base.n;
import f.c.c.a.a;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class BaseEncoding {

    private static final com.google.common.io.BaseEncoding a;
    private static final com.google.common.io.BaseEncoding b;

    public static final class DecodingException extends IOException {
        DecodingException(String string) {
            super(string);
        }
    }

    private static final class a {

        private final String a;
        private final char[] b;
        final int c;
        final int d;
        final int e = 8;
        final int f;
        private final byte[] g;
        private final boolean[] h;
        a(String string, char[] c2Arr2) {
            byte[] bArr;
            int cEILING;
            int i2;
            int i3;
            char c;
            byte b;
            int i;
            int i4;
            String str;
            Object obj10;
            super();
            n.o(string);
            this.a = (String)string;
            n.o(c2Arr2);
            this.b = (char[])c2Arr2;
            int obj9 = a.d(c2Arr2.length, RoundingMode.UNNECESSARY);
            this.d = obj9;
            int i7 = 8;
            int i5 = Math.min(i7, Integer.lowestOneBit(obj9));
            i7 /= i5;
            this.f = obj9 /= i5;
            int i6 = 1;
            this.c = obj9 -= i6;
            obj9 = 128;
            bArr = new byte[obj9];
            cEILING = -1;
            Arrays.fill(bArr, cEILING);
            i2 = 0;
            i3 = i2;
            while (i3 < c2Arr2.length) {
                c = c2Arr2[i3];
                if (c < obj9) {
                } else {
                }
                i = i2;
                n.f(i, "Non-ASCII character: %s", c);
                if (bArr[c] == cEILING) {
                } else {
                }
                i4 = i2;
                n.f(i4, "Duplicate character: %s", c);
                bArr[c] = (byte)i3;
                i3++;
                i4 = i6;
                i = i6;
            }
            this.g = bArr;
            obj9 = new boolean[this.e];
            while (i2 < this.f) {
                obj9[a.a(i2 * 8, this.d, RoundingMode.CEILING)] = i6;
                i2++;
            }
            this.h = obj9;
        }

        static char[] a(com.google.common.io.BaseEncoding.a baseEncoding$a) {
            return a.b;
        }

        private boolean d() {
            int i;
            boolean z;
            char[] cArr = this.b;
            final int i3 = 0;
            i = i3;
            while (i < cArr.length) {
                i++;
            }
            return i3;
        }

        private boolean e() {
            int i;
            boolean z;
            char[] cArr = this.b;
            final int i3 = 0;
            i = i3;
            while (i < cArr.length) {
                i++;
            }
            return i3;
        }

        int b(char c) {
            String obj5;
            String str = "Unrecognized character: 0x";
            int i = 127;
            if (c > i) {
                obj5 = String.valueOf(Integer.toHexString(c));
                if (obj5.length() != 0) {
                    obj5 = str.concat(obj5);
                } else {
                    obj5 = new String(str);
                }
                BaseEncoding.DecodingException decodingException2 = new BaseEncoding.DecodingException(obj5);
                throw decodingException2;
            }
            byte b = this.g[c];
            if (b == -1 && c > 32) {
                if (c > 32) {
                    if (c != i) {
                    } else {
                    }
                    StringBuilder stringBuilder = new StringBuilder(25);
                    stringBuilder.append("Unrecognized character: ");
                    stringBuilder.append(c);
                    BaseEncoding.DecodingException decodingException = new BaseEncoding.DecodingException(stringBuilder.toString());
                    throw decodingException;
                }
                obj5 = String.valueOf(Integer.toHexString(c));
                if (obj5.length() != 0) {
                    obj5 = str.concat(obj5);
                } else {
                    obj5 = new String(str);
                }
                BaseEncoding.DecodingException decodingException3 = new BaseEncoding.DecodingException(obj5);
                throw decodingException3;
            }
            return b;
        }

        char c(int i) {
            return this.b[i];
        }

        public boolean equals(Object object) {
            if (object instanceof BaseEncoding.a) {
                return Arrays.equals(this.b, object.b);
            }
            return 0;
        }

        boolean f(int i) {
            return this.h[i %= i2];
        }

        public boolean g(char c) {
            byte[] bArr;
            int obj3;
            bArr = this.g;
            if (c < bArr.length && bArr[c] != -1) {
                obj3 = bArr[c] != -1 ? 1 : 0;
            } else {
            }
            return obj3;
        }

        com.google.common.io.BaseEncoding.a h() {
            int i;
            char c;
            int length;
            if (!d()) {
                return this;
            }
            n.v(z2 ^= 1, "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr2 = new char[cArr.length];
            i = 0;
            char[] cArr3 = this.b;
            for (char c2 : obj2) {
                cArr2[i] = b.d(c2);
                cArr3 = this.b;
            }
            BaseEncoding.a aVar = new BaseEncoding.a(String.valueOf(this.a).concat(".upperCase()"), cArr2);
            return aVar;
        }

        public int hashCode() {
            return Arrays.hashCode(this.b);
        }

        public String toString() {
            return this.a;
        }
    }

    static class d extends com.google.common.io.BaseEncoding {

        final com.google.common.io.BaseEncoding.a c;
        final Character d;
        private transient com.google.common.io.BaseEncoding e;
        d(com.google.common.io.BaseEncoding.a baseEncoding$a, Character character2) {
            char charValue;
            int obj2;
            super();
            n.o(a);
            this.c = (BaseEncoding.a)a;
            if (character2 != null) {
                if (!a.g(character2.charValue())) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
            n.k(obj2, "Padding character %s was already in alphabet", character2);
            this.d = character2;
        }

        d(String string, String string2, Character character3) {
            BaseEncoding.a aVar = new BaseEncoding.a(string, string2.toCharArray());
            super(aVar, character3);
        }

        @Override // com.google.common.io.BaseEncoding
        int e(byte[] bArr, java.lang.CharSequence charSequence2) {
            int i4;
            int i5;
            int i6;
            int i10;
            int i9;
            int i11;
            int i8;
            int i3;
            int i;
            int length;
            int i7;
            int i2;
            n.o(bArr);
            java.lang.CharSequence obj15 = m(charSequence2);
            if (!this.c.f(obj15.length())) {
            } else {
                int i13 = 0;
                i5 = i4;
                while (i4 < obj15.length()) {
                    i10 = 0;
                    i3 = i11;
                    com.google.common.io.BaseEncoding.a aVar3 = this.c;
                    while (i11 < aVar3.e) {
                        if (i4 + i11 < obj15.length()) {
                        }
                        i11++;
                        aVar3 = this.c;
                        i10 |= l;
                        i3 = length;
                    }
                    int i14 = aVar3.f;
                    i15 *= 8;
                    while (i9 >= i21 -= i8) {
                        bArr[i5] = (byte)i19;
                        i9 += -8;
                        i5 = i8;
                    }
                    i4 += i6;
                    bArr[i5] = (byte)i19;
                    i9 += -8;
                    i5 = i8;
                    if (i4 + i11 < obj15.length()) {
                    }
                    i11++;
                    i10 |= l;
                    i3 = length;
                }
                return i5;
            }
            StringBuilder stringBuilder = new StringBuilder(32);
            stringBuilder.append("Invalid input length ");
            stringBuilder.append(obj15.length());
            BaseEncoding.DecodingException obj14 = new BaseEncoding.DecodingException(stringBuilder.toString());
            throw obj14;
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean equals(Object object) {
            boolean equals;
            int i;
            com.google.common.io.BaseEncoding.a aVar;
            Object obj4;
            i = 0;
            if (object instanceof BaseEncoding.d && this.c.equals(object.c) && k.a(this.d, object.d)) {
                if (this.c.equals(object.c)) {
                    if (k.a(this.d, object.d)) {
                        i = 1;
                    }
                }
            }
            return i;
        }

        @Override // com.google.common.io.BaseEncoding
        void h(java.lang.Appendable appendable, byte[] b2Arr2, int i3, int i4) {
            int i5;
            int length;
            int i2;
            int i;
            n.o(appendable);
            n.t(i3, i3 + i4, b2Arr2.length);
            i5 = 0;
            while (i5 < i4) {
                o(appendable, b2Arr2, i3 + i5, Math.min(aVar2.f, i4 - i5));
                i5 += length;
            }
        }

        @Override // com.google.common.io.BaseEncoding
        public int hashCode() {
            Object[] arr = new Object[1];
            return i ^= i4;
        }

        @Override // com.google.common.io.BaseEncoding
        int j(int i) {
            return (int)i5;
        }

        @Override // com.google.common.io.BaseEncoding
        int k(int i) {
            com.google.common.io.BaseEncoding.a aVar = this.c;
            return i3 *= obj4;
        }

        @Override // com.google.common.io.BaseEncoding
        public com.google.common.io.BaseEncoding l() {
            Object obj;
            int i;
            if (this.d == null) {
                obj = this;
            } else {
                obj = p(this.c, 0);
            }
            return obj;
        }

        @Override // com.google.common.io.BaseEncoding
        java.lang.CharSequence m(java.lang.CharSequence charSequence) {
            int i;
            char charAt;
            n.o(charSequence);
            Character character = this.d;
            if (character == null) {
                return charSequence;
            }
            length--;
            while (i >= 0) {
                if (charSequence.charAt(i) != character.charValue()) {
                    break;
                } else {
                }
                i--;
            }
            return charSequence.subSequence(0, i++);
        }

        @Override // com.google.common.io.BaseEncoding
        public com.google.common.io.BaseEncoding n() {
            Object baseEncoding;
            Object aVar;
            if (this.e == null) {
                com.google.common.io.BaseEncoding.a aVar3 = this.c.h();
                if (aVar3 == this.c) {
                    baseEncoding = this;
                } else {
                    baseEncoding = p(aVar3, this.d);
                }
                this.e = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        void o(java.lang.Appendable appendable, byte[] b2Arr2, int i3, int i4) {
            int i6;
            int i5;
            int i;
            int i7;
            int i2;
            long l;
            Character obj9;
            int obj10;
            n.o(appendable);
            n.t(i3, i3 + i4, b2Arr2.length);
            i = 0;
            i6 = i4 <= aVar.f ? 1 : i;
            n.d(i6);
            i7 = 0;
            i5 = i;
            i2 = 8;
            while (i5 < i4) {
                i10 <<= i2;
                i5++;
                i2 = 8;
            }
            while (i < i4 * 8) {
                i5 = this.c;
                appendable.append(i5.c(obj10 &= l));
                i += obj10;
            }
            if (this.d != null) {
            }
        }

        @Override // com.google.common.io.BaseEncoding
        com.google.common.io.BaseEncoding p(com.google.common.io.BaseEncoding.a baseEncoding$a, Character character2) {
            BaseEncoding.d dVar = new BaseEncoding.d(a, character2);
            return dVar;
        }

        @Override // com.google.common.io.BaseEncoding
        public String toString() {
            int str;
            StringBuilder stringBuilder = new StringBuilder("BaseEncoding.");
            stringBuilder.append(this.c.toString());
            if (i %= str != 0) {
                if (this.d == null) {
                    stringBuilder.append(".omitPadding()");
                } else {
                    stringBuilder.append(".withPadChar('");
                    stringBuilder.append(this.d);
                    stringBuilder.append("')");
                }
            }
            return stringBuilder.toString();
        }
    }

    static final class b extends com.google.common.io.BaseEncoding.d {

        final char[] f;
        private b(com.google.common.io.BaseEncoding.a baseEncoding$a) {
            int i;
            int i2;
            int i3;
            char c;
            super(a, 0);
            this.f = new char[512];
            i = cArr2.length == 16 ? 1 : i2;
            n.d(i);
            while (i2 < 256) {
                this.f[i2] = a.c(i2 >>> 4);
                this.f[i2 | 256] = a.c(i2 & 15);
                i2++;
            }
        }

        b(String string, String string2) {
            BaseEncoding.a aVar = new BaseEncoding.a(string, string2.toCharArray());
            super(aVar);
        }

        @Override // com.google.common.io.BaseEncoding$d
        int e(byte[] bArr, java.lang.CharSequence charSequence2) {
            int i;
            int i2;
            byte b;
            int i3;
            char charAt;
            n.o(bArr);
            if (length %= 2 == 1) {
            } else {
                i2 = i;
                while (i < charSequence2.length()) {
                    bArr[i2] = (byte)i9;
                    i += 2;
                    i2 = i3;
                }
                return i2;
            }
            StringBuilder stringBuilder = new StringBuilder(32);
            stringBuilder.append("Invalid input length ");
            stringBuilder.append(charSequence2.length());
            BaseEncoding.DecodingException obj6 = new BaseEncoding.DecodingException(stringBuilder.toString());
            throw obj6;
        }

        @Override // com.google.common.io.BaseEncoding$d
        void h(java.lang.Appendable appendable, byte[] b2Arr2, int i3, int i4) {
            int i;
            int length;
            char[] cArr;
            n.o(appendable);
            n.t(i3, i3 + i4, b2Arr2.length);
            i = 0;
            while (i < i4) {
                b &= 255;
                appendable.append(this.f[i6]);
                appendable.append(this.f[i6 |= 256]);
                i++;
            }
        }

        @Override // com.google.common.io.BaseEncoding$d
        com.google.common.io.BaseEncoding p(com.google.common.io.BaseEncoding.a baseEncoding$a, Character character2) {
            BaseEncoding.b obj2 = new BaseEncoding.b(a);
            return obj2;
        }
    }

    static final class c extends com.google.common.io.BaseEncoding.d {
        private c(com.google.common.io.BaseEncoding.a baseEncoding$a, Character character2) {
            int obj1;
            super(a, character2);
            obj1 = obj1.length == 64 ? 1 : 0;
            n.d(obj1);
        }

        c(String string, String string2, Character character3) {
            BaseEncoding.a aVar = new BaseEncoding.a(string, string2.toCharArray());
            super(aVar, character3);
        }

        @Override // com.google.common.io.BaseEncoding$d
        int e(byte[] bArr, java.lang.CharSequence charSequence2) {
            int i2;
            int i3;
            int length2;
            int length;
            byte charAt;
            int i;
            n.o(bArr);
            java.lang.CharSequence obj7 = m(charSequence2);
            if (!this.c.f(obj7.length())) {
            } else {
                length2 = i2;
                while (i2 < obj7.length()) {
                    int i15 = i2 + 1;
                    i = i15 + 1;
                    i6 |= i13;
                    length = length2 + 1;
                    bArr[length2] = (byte)i16;
                    if (i < obj7.length()) {
                    } else {
                    }
                    length2 = length;
                    i2 = i;
                    charAt = i + 1;
                    i3 |= i11;
                    length2 = length + 1;
                    bArr[length] = (byte)i18;
                    if (charAt < obj7.length()) {
                    } else {
                    }
                    i2 = charAt;
                    i = charAt + 1;
                    length = length2 + 1;
                    bArr[length2] = (byte)i9;
                }
                return length2;
            }
            StringBuilder stringBuilder = new StringBuilder(32);
            stringBuilder.append("Invalid input length ");
            stringBuilder.append(obj7.length());
            BaseEncoding.DecodingException obj6 = new BaseEncoding.DecodingException(stringBuilder.toString());
            throw obj6;
        }

        @Override // com.google.common.io.BaseEncoding$d
        void h(java.lang.Appendable appendable, byte[] b2Arr2, int i3, int i4) {
            int i;
            int length;
            com.google.common.io.BaseEncoding.a aVar;
            int i2;
            int obj7;
            int obj8;
            n.o(appendable);
            i = i3 + i4;
            n.t(i3, i, b2Arr2.length);
            while (obj8 >= 3) {
                int i6 = obj7 + 1;
                int i9 = i6 + 1;
                obj7 |= i10;
                appendable.append(this.c.c(obj7 >>> 18));
                appendable.append(this.c.c(i12 &= 63));
                appendable.append(this.c.c(i14 &= 63));
                appendable.append(this.c.c(obj7 &= 63));
                obj8 += -3;
                obj7 = length;
            }
            if (obj7 < i) {
                o(appendable, b2Arr2, obj7, i -= obj7);
            }
        }

        @Override // com.google.common.io.BaseEncoding$d
        com.google.common.io.BaseEncoding p(com.google.common.io.BaseEncoding.a baseEncoding$a, Character character2) {
            BaseEncoding.c cVar = new BaseEncoding.c(a, character2);
            return cVar;
        }
    }
    static {
        Character valueOf = '=';
        BaseEncoding.c cVar = new BaseEncoding.c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", valueOf);
        BaseEncoding.a = cVar;
        BaseEncoding.c cVar2 = new BaseEncoding.c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", valueOf);
        BaseEncoding.d dVar = new BaseEncoding.d("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", valueOf);
        BaseEncoding.d dVar2 = new BaseEncoding.d("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", valueOf);
        BaseEncoding.b bVar = new BaseEncoding.b("base16()", "0123456789ABCDEF");
        BaseEncoding.b = bVar;
    }

    public static com.google.common.io.BaseEncoding a() {
        return BaseEncoding.b;
    }

    public static com.google.common.io.BaseEncoding b() {
        return BaseEncoding.a;
    }

    private static byte[] i(byte[] bArr, int i2) {
        if (i2 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i2];
        final int i = 0;
        System.arraycopy(bArr, i, bArr2, i, i2);
        return bArr2;
    }

    public final byte[] c(java.lang.CharSequence charSequence) {
        try {
            return d(charSequence);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(charSequence);
            throw illegalArgumentException;
        }
    }

    final byte[] d(java.lang.CharSequence charSequence) {
        java.lang.CharSequence obj2 = m(charSequence);
        byte[] bArr = new byte[j(obj2.length())];
        return BaseEncoding.i(bArr, e(bArr, obj2));
    }

    abstract int e(byte[] bArr, java.lang.CharSequence charSequence2);

    public String f(byte[] bArr) {
        return g(bArr, 0, bArr.length);
    }

    public final String g(byte[] bArr, int i2, int i3) {
        n.t(i2, i2 + i3, bArr.length);
        StringBuilder stringBuilder = new StringBuilder(k(i3));
        h(stringBuilder, bArr, i2, i3);
        return stringBuilder.toString();
    }

    abstract void h(java.lang.Appendable appendable, byte[] b2Arr2, int i3, int i4);

    abstract int j(int i);

    abstract int k(int i);

    public abstract com.google.common.io.BaseEncoding l();

    abstract java.lang.CharSequence m(java.lang.CharSequence charSequence);

    public abstract com.google.common.io.BaseEncoding n();
}
