package f.f.a;

import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import l.f;

/* compiled from: HttpUrl.java */
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
        String b = "";
        String c = "";
        String d;
        int e = -1;
        final List<String> f = new ArrayList<>();
        List<String> g;
        String h;
        public b() {
            super();
            new ArrayList().add("");
        }

        private static String b(String str, int i, int i2) {
            String str2 = c.f(str, i, i2, false);
            if (str2.startsWith("[")) {
                if (str2.endsWith("]")) {
                    int i6 = 1;
                    InetAddress inetAddress = c.b.e(str2, i6, str2.length() - i6);
                    if (inetAddress == null) {
                        return null;
                    }
                    byte[] address = inetAddress.getAddress();
                    if (address.length != 16) {
                        throw new AssertionError();
                    } else {
                        return c.b.i(address);
                    }
                }
            }
            return c.b.f(str2);
        }

        private static boolean c(String str) {
            int i;
            i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                char c = '\u001f';
                boolean z = true;
                c = '\u007f';
                int i2 = -1;
                if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                    return true;
                }
            }
            return false;
        }

        private static boolean d(String str, int i, int i2, byte[] bArr, int i3) {
            int i52;
            int i22;
            char charAt;
            char c2;
            char c3;
            i52 = i3;
            i = 0;
            while (i22 < i2) {
                length = bArr.length;
                while (i22 < i2) {
                    charAt = str.charAt(i22);
                    c2 = '0';
                    c3 = '9';
                    i = (i * 10) + charAt - c2;
                    if (i * 10 + charAt - c2 > 255) {
                        return false;
                    }
                }
                if (i22 - i22 == 0) {
                    return false;
                }
                charAt = str.charAt(i22);
                c2 = '0';
                c3 = '9';
                i = (i * 10 + charAt) - c2;
                if (i * 10 + charAt - c2 > 255) {
                    return false;
                }
                char c = '.';
                i22 = i22 + 1;
            }
            if (i52 != i3 + 4) {
                return false;
            }
            return true;
        }

        private static InetAddress e(String str, int i, int i2) {
            int i22;
            byte b;
            byte b2;
            boolean regionMatches;
            int i5 = 4;
            boolean z;
            i = 16;
            final byte[] bArr = new byte[i];
            i22 = -1;
            i22 = 0;
            int i7 = 0;
            while (i22 < i2) {
                i22 = i22 + 2;
                while (i22 < i2) {
                    int i11 = c.a(str.charAt(i22));
                    if (i11 == i22) {
                        break loop_21;
                    }
                }
                int i12 = i22 - i22;
                i5 = 4;
                i11 = c.a(str.charAt(i22));
                int i10 = 1;
                i22 = i22 + 1;
                i5 = 2;
                i22 = i22 + 2;
            }
            if (i22 != i && i22 == i22) {
                return null;
            }
            try {
            } catch (java.net.UnknownHostException unused) {
                str = new AssertionError();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) str;
            }
            return InetAddress.getByAddress(bArr);
        }

        private static String f(String str) {
            final int i = 0;
            try {
                String str2 = IDN.toASCII(str).toLowerCase(Locale.US);
                if (str2.isEmpty()) {
                    return i;
                }
            } catch (java.lang.IllegalArgumentException unused) {
                return obj;
            }
            return c.b.c(str2) ? i : str2;
        }

        private static String i(byte[] bArr) {
            int i = 0;
            byte b;
            long l;
            i = 0;
            i = -1;
            length = bArr.length;
            int i4 = 16;
            while (i < bArr.length) {
                while (bArr.length < i4) {
                }
                i = i - i;
                i = i + 2;
                length = bArr.length;
                i4 = 16;
            }
            f fVar = new f();
            while (i < bArr.length) {
                int length = 58;
            }
            return fVar.r1();
        }

        public c a() {
            if (this.a == null) {
                throw new IllegalStateException("scheme == null");
            } else {
                if (this.d == null) {
                    throw new IllegalStateException("host == null");
                } else {
                    return new c(this, null);
                }
            }
        }

        int g() {
            int i;
            if (this.e == -1) {
                i = c.b(this.a);
            }
            return i;
        }

        public c.b h(String str) {
            if (str == null) {
                throw new IllegalArgumentException("host == null");
            } else {
                String str2 = c.b.b(str, 0, str.length());
                if (str2 == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    final String str4 = "unexpected host: ";
                    str = str4 + str;
                    throw new IllegalArgumentException(str);
                } else {
                    this.d = str2;
                    return this;
                }
            }
        }

        public c.b j(int i) {
            if (i <= 0) {
                final StringBuilder stringBuilder = new StringBuilder();
                final String str = "unexpected port: ";
                i = str + i;
                throw new IllegalArgumentException(i);
            } else {
                int i2 = 65535;
                if (i <= 65535) {
                    this.e = i;
                    return this;
                }
            }
        }

        public c.b k(String str) {
            if (str == null) {
                throw new IllegalArgumentException("scheme == null");
            } else {
                str2 = "http";
                if (str.equalsIgnoreCase(str2)) {
                    this.a = str2;
                    return this;
                } else {
                    str2 = "https";
                    if (str.equalsIgnoreCase(str2)) {
                        this.a = str2;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                final String str4 = "unexpected scheme: ";
                str = str4 + str;
                throw new IllegalArgumentException(str);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("://");
            final char c3 = ':';
            if (this.b.isEmpty()) {
                if (!this.c.isEmpty()) {
                    stringBuilder.append(this.b);
                    if (!this.c.isEmpty()) {
                        stringBuilder.append(c3);
                        stringBuilder.append(this.c);
                    }
                    stringBuilder.append('@');
                }
            }
            if (this.d.indexOf(c3) != -1) {
                stringBuilder.append('[');
                stringBuilder.append(this.d);
                char c = ']';
                stringBuilder.append(c);
            } else {
                stringBuilder.append(this.d);
            }
            int i2 = g();
            if (i2 != c.b(this.a)) {
                stringBuilder.append(c3);
                stringBuilder.append(i2);
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
    /* synthetic */ c(c.b bVar, c.a aVar) {
        this(bVar);
    }

    public static int b(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return 443;
        }
        return -1;
    }

    static void d(StringBuilder sb, List<String> list) {
        int i = 0;
        Object item;
        char c;
        i = 0;
        while (i < list.size()) {
            Object item2 = list.get(i + 1);
            sb.append((String)list.get(i));
            i = i + 2;
        }
    }

    static void e(StringBuilder sb, List<String> list) {
        int i = 0;
        i = 0;
        while (i < list.size()) {
            sb.append('/');
            sb.append((String)list.get(i));
            i = i + 1;
        }
    }

    static String f(String str, int i, int i2, boolean z) {
        int i22;
        i22 = i;
        while (i22 < i2) {
            char charAt = str.charAt(i22);
            char c = '%';
            c = '+';
            if (charAt == '+') {
            }
        }
        return str.substring(i, i2);
    }

    static String g(String str, boolean z) {
        return c.f(str, 0, str.length(), z);
    }

    private List<String> h(List<String> list, boolean z) {
        String str = null;
        final ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            arrayList.add(str);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void i(f fVar, String str, int i, int i2, boolean z) {
        int i5;
        int i6 = -1;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            i = 37;
        }
    }

    public String c() {
        return this.a;
    }

    public boolean equals(Object object) {
        boolean z;
        boolean z2 = false;
        z = object instanceof c;
        if (object instanceof c) {
            object = object.e.equals(this.e) ? 1 : 0;
        }
        return (object.e.equals(this.e) ? 1 : 0);
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

    private c(c.b bVar) {
        List list = null;
        super();
        final boolean z2 = false;
        c.g(bVar.b, z2);
        c.g(bVar.c, z2);
        this.a = bVar.d;
        this.b = bVar.g();
        this.c = h(bVar.f, z2);
        if (bVar.g != null) {
            boolean z = true;
            list = h(bVar.g, z);
        } else {
            int i2 = 0;
        }
        this.d = list;
        if (bVar.h != null) {
            c.g(bVar.h, z2);
        }
        this.e = bVar.toString();
    }


    static int a(char c) {
        int i = 65;
        int i2 = 57;
        int i3 = 48;
        if (c >= i3 && c <= 57) {
            return c - i3;
        }
        i = 97;
        if (c >= 97 && c <= 102) {
            return (c - i) + 10;
        }
        return -1;
    }
}
