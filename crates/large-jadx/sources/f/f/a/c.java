package f.f.a;

import java.net.IDN;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import l.f;

/* loaded from: classes2.dex */
public final class c {

    private final String a;
    private final int b;
    private final List<String> c;
    private final List<String> d;
    private final String e;

    static class a {
    }

    public static final class b {

        String a;
        String b;
        String c;
        String d;
        int e = -1;
        final List<String> f;
        List<String> g;
        String h;
        public b() {
            super();
            final String str = "";
            this.b = str;
            this.c = str;
            int i = -1;
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add(str);
        }

        private static String b(String string, int i2, int i3) {
            boolean obj2;
            String obj1 = c.f(string, i2, i3, false);
            int obj3 = 1;
            obj1 = c.b.e(obj1, obj3, obj2 -= obj3);
            if (obj1.startsWith("[") && obj1.endsWith("]") && obj1 == null) {
                if (obj1.endsWith("]")) {
                    obj3 = 1;
                    obj1 = c.b.e(obj1, obj3, obj2 -= obj3);
                    if (obj1 == null) {
                        return null;
                    }
                    obj1 = obj1.getAddress();
                    if (obj1.length != 16) {
                    } else {
                        return c.b.i(obj1);
                    }
                    obj1 = new AssertionError();
                    throw obj1;
                }
            }
            return c.b.f(obj1);
        }

        private static boolean c(String string) {
            int i2;
            int indexOf;
            int i;
            int i4;
            int i3;
            final int i5 = 0;
            i2 = i5;
            while (i2 < string.length()) {
                char charAt = string.charAt(i2);
                i3 = 1;
                i2++;
            }
            return i5;
        }

        private static boolean d(String string, int i2, int i3, byte[] b4Arr4, int i5) {
            int i6;
            byte b;
            int i8;
            int charAt;
            int i;
            char charAt2;
            int i7;
            int i4;
            int obj8;
            i6 = i5;
            int i9 = 0;
            while (obj8 < i3) {
                i8 = obj8;
                i = i9;
                while (i8 < i3) {
                    charAt2 = string.charAt(i8);
                    i7 = 48;
                    i8++;
                }
                b4Arr4[i6] = (byte)i;
                i6 = obj8;
                obj8 = i8;
                i9 = 0;
                charAt2 = string.charAt(i8);
                i7 = 48;
                i8++;
                obj8++;
            }
            if (i6 != i5 += 4) {
                return i9;
            }
            return 1;
        }

        private static InetAddress e(String string, int i2, int i3) {
            int i6;
            int i8;
            int i;
            int i4;
            int i5;
            byte regionMatches;
            int i7;
            byte regionMatches2;
            int i9;
            String obj11;
            int obj12;
            i6 = 16;
            final byte[] bArr = new byte[i6];
            final int i11 = -1;
            final int i12 = 0;
            i4 = i;
            i8 = i12;
            int i13 = 0;
            while (obj12 < i3) {
                regionMatches = obj12 + 2;
                i4 = obj12;
                i7 = i12;
                obj12 = i4;
                while (obj12 < i3) {
                    regionMatches2 = c.a(string.charAt(obj12));
                    if (regionMatches2 == i11) {
                        break loop_21;
                    } else {
                    }
                    i14 += regionMatches2;
                    obj12++;
                }
                int i16 = obj12 - i4;
                i5 = i8 + 1;
                bArr[i8] = (byte)i18;
                i8 = i5 + 1;
                bArr[i5] = (byte)i15;
                i13 = 0;
                regionMatches2 = c.a(string.charAt(obj12));
                if (regionMatches2 == i11) {
                } else {
                }
                i14 += regionMatches2;
                obj12++;
                regionMatches2 = 1;
                obj12++;
                i = i8;
                i4 = regionMatches;
            }
            if (i8 != i6 && i == i11) {
                if (i == i11) {
                    return i13;
                }
                obj11 = i8 - i;
                System.arraycopy(bArr, i, bArr, obj11 - 16, obj11);
                Arrays.fill(bArr, i, i10 += i, i12);
            }
            return InetAddress.getByAddress(bArr);
        }

        private static String f(String string) {
            final int i = 0;
            String obj2 = IDN.toASCII(string).toLowerCase(Locale.US);
            if (obj2.isEmpty()) {
                try {
                    return i;
                    if (c.b.c(obj2)) {
                    }
                    return i;
                    return obj2;
                    return obj0;
                }
            }
        }

        private static String i(byte[] bArr) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i;
            int length;
            int i6;
            byte b;
            i3 = -1;
            i5 = i4;
            int i9 = 16;
            while (i4 < bArr.length) {
                i = i4;
                while (i < i9) {
                    if (bArr[i] == 0) {
                    }
                    if (bArr[i + 1] == 0) {
                    }
                    i += 2;
                }
                i6 = i - i4;
                if (i6 > i5) {
                }
                i4 = i + 2;
                i9 = 16;
                i3 = i4;
                i5 = i6;
                if (bArr[i] == 0) {
                }
                if (bArr[i + 1] == 0) {
                }
                i += 2;
            }
            f fVar = new f();
            while (i2 < bArr.length) {
                length = 58;
                if (i2 == i3) {
                } else {
                }
                if (i2 > 0) {
                }
                fVar.C0((long)length);
                i2 += 2;
                fVar.z0(length);
                fVar.z0(length);
                if (i2 += i5 == i9) {
                }
                fVar.z0(length);
            }
            return fVar.r1();
        }

        public f.f.a.c a() {
            if (this.a == null) {
            } else {
                if (this.d == null) {
                } else {
                    c cVar = new c(this, 0);
                    return cVar;
                }
                IllegalStateException illegalStateException = new IllegalStateException("host == null");
                throw illegalStateException;
            }
            IllegalStateException illegalStateException2 = new IllegalStateException("scheme == null");
            throw illegalStateException2;
        }

        int g() {
            int i;
            if (this.e != -1) {
            } else {
                i = c.b(this.a);
            }
            return i;
        }

        public f.f.a.c.b h(String string) {
            if (string == null) {
            } else {
                String str = c.b.b(string, 0, string.length());
                if (str == null) {
                } else {
                    this.d = str;
                    return this;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unexpected host: ");
                stringBuilder.append(string);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
            }
            IllegalArgumentException obj4 = new IllegalArgumentException("host == null");
            throw obj4;
        }

        public f.f.a.c.b j(int i) {
            int i2;
            if (i <= 0) {
            } else {
                if (i > 65535) {
                } else {
                    this.e = i;
                    return this;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected port: ");
            stringBuilder.append(i);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        public f.f.a.c.b k(String string) {
            String str;
            boolean equalsIgnoreCase;
            if (string == null) {
            } else {
                str = "http";
                if (string.equalsIgnoreCase(str)) {
                    this.a = str;
                    return this;
                } else {
                    str = "https";
                    if (!string.equalsIgnoreCase(str)) {
                    } else {
                        this.a = str;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("unexpected scheme: ");
                stringBuilder.append(string);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
            }
            IllegalArgumentException obj4 = new IllegalArgumentException("scheme == null");
            throw obj4;
        }

        public String toString() {
            boolean empty2;
            boolean empty;
            int i;
            List list;
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("://");
            final int i6 = 58;
            if (this.b.isEmpty()) {
                stringBuilder.append(this.b);
                if (!this.c.isEmpty() && !this.c.isEmpty()) {
                    stringBuilder.append(this.b);
                    if (!this.c.isEmpty()) {
                        stringBuilder.append(i6);
                        stringBuilder.append(this.c);
                    }
                    stringBuilder.append('@');
                }
            } else {
            }
            if (this.d.indexOf(i6) != -1) {
                stringBuilder.append('[');
                stringBuilder.append(this.d);
                stringBuilder.append(']');
            } else {
                stringBuilder.append(this.d);
            }
            int i3 = g();
            if (i3 != c.b(this.a)) {
                stringBuilder.append(i6);
                stringBuilder.append(i3);
            }
            c.e(stringBuilder, this.f);
            if (this.g != null) {
                stringBuilder.append('?');
                c.d(stringBuilder, this.g);
            }
            if (this.h != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.h);
            }
            return stringBuilder.toString();
        }
    }
    static {
    }

    private c(f.f.a.c.b c$b) {
        List list;
        int i;
        super();
        String str = b.a;
        final int i3 = 0;
        c.g(b.b, i3);
        c.g(b.c, i3);
        this.a = b.d;
        this.b = b.g();
        this.c = h(b.f, i3);
        List list4 = b.g;
        if (list4 != null) {
            list = h(list4, true);
        } else {
            list = 0;
        }
        this.d = list;
        String str5 = b.h;
        if (str5 != null) {
            c.g(str5, i3);
        }
        this.e = b.toString();
    }

    c(f.f.a.c.b c$b, f.f.a.c.a c$a2) {
        super(b);
    }

    static int a(char c) {
        int i;
        int i2;
        int i3 = 48;
        if (c >= i3 && c <= 57) {
            if (c <= 57) {
                return c -= i3;
            }
        }
        if (c >= 97 && c <= 102) {
            if (c <= 102) {
                return obj2 += 10;
            } else {
            }
        } else {
        }
        return -1;
    }

    public static int b(String string) {
        if (string.equals("http")) {
            return 80;
        }
        if (string.equals("https")) {
            return 443;
        }
        return -1;
    }

    static void d(StringBuilder stringBuilder, List<String> list2) {
        int i;
        Object obj;
        Object obj2;
        int i2;
        i = 0;
        while (i < list2.size()) {
            obj2 = list2.get(i + 1);
            if (i > 0) {
            }
            stringBuilder.append((String)list2.get(i));
            if ((String)obj2 != null) {
            }
            i += 2;
            stringBuilder.append('=');
            stringBuilder.append((String)obj2);
            stringBuilder.append('&');
        }
    }

    static void e(StringBuilder stringBuilder, List<String> list2) {
        int i;
        Object obj;
        i = 0;
        while (i < list2.size()) {
            stringBuilder.append('/');
            stringBuilder.append((String)list2.get(i));
            i++;
        }
    }

    static String f(String string, int i2, int i3, boolean z4) {
        int i;
        char charAt;
        int i4;
        i = i2;
        while (i < i3) {
            charAt = string.charAt(i);
            i++;
        }
        return string.substring(i2, i3);
    }

    static String g(String string, boolean z2) {
        return c.f(string, 0, string.length(), z2);
    }

    private List<String> h(List<String> list, boolean z2) {
        int size;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator obj3 = list.iterator();
        while (obj3.hasNext()) {
            Object next2 = obj3.next();
            if ((String)next2 != null) {
            } else {
            }
            size = 0;
            arrayList.add(size);
            size = c.g((String)next2, z2);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void i(f f, String string2, int i3, int i4, boolean z5) {
        int i5;
        int i2;
        int i6;
        int i;
        int obj7;
        while (i3 < i4) {
            int codePointAt = string2.codePointAt(i3);
            i5 = i3 + 2;
            if (codePointAt == 37 && i5 < i4) {
            } else {
            }
            if (codePointAt == 43 && z5) {
            } else {
            }
            f.g1(codePointAt);
            obj7 += charCount;
            if (z5) {
            } else {
            }
            f.z0(32);
            i5 = i3 + 2;
            if (i5 < i4) {
            } else {
            }
            i2 = c.a(string2.charAt(i3 + 1));
            i6 = c.a(string2.charAt(i5));
            i = -1;
            if (i2 != i && i6 != i) {
            } else {
            }
            if (i6 != i) {
            } else {
            }
            f.z0(obj7 += i6);
            obj7 = i5;
        }
    }

    public String c() {
        return this.a;
    }

    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof c && object.e.equals(this.e)) {
            obj2 = object.e.equals(this.e) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public int hashCode() {
        return this.e.hashCode();
    }

    public int j() {
        return this.b;
    }

    public String toString() {
        return this.e;
    }
}
