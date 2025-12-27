package f.f.a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Headers.java */
/* loaded from: classes2.dex */
public final class b {

    private final String[] a;

    static class a {
    }

    public static final class b {

        private final List<String> a = new ArrayList<>(20);
        public b() {
            super();
            final ArrayList arrayList = new ArrayList(20);
        }

        static /* synthetic */ List a(b.b bVar) {
            return bVar.a;
        }

        private void d(String str, String str2) {
            int i;
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            } else {
                if (str.isEmpty()) {
                    throw new IllegalArgumentException("name is empty");
                } else {
                    i = 0;
                    char c = '\u007f';
                    int i2 = 2;
                    int i3 = 3;
                    char c2 = '\u001f';
                    int i4 = 1;
                    while (i < str.length()) {
                        char charAt = str.charAt(i);
                        if (charAt <= c2) {
                            Object[] arr = new Object[i3];
                            arr[i] = Integer.valueOf(charAt);
                            arr[i4] = Integer.valueOf(i);
                            arr[i2] = str;
                            throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", arr));
                        }
                    }
                    if (str2 == null) {
                        throw new IllegalArgumentException("value == null");
                    } else {
                        while (i < str2.length()) {
                            char charAt2 = str2.charAt(i);
                            if (charAt2 <= c2) {
                                Object[] arr2 = new Object[i3];
                                arr2[i] = Integer.valueOf(charAt2);
                                arr2[i4] = Integer.valueOf(i);
                                arr2[i2] = str2;
                                throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header value: %s", arr2));
                            }
                        }
                        return;
                    }
                }
            }
        }

        b.b b(String str, String str2) {
            this.a.add(str);
            this.a.add(str2.trim());
            return this;
        }

        public b c() {
            return new b(this, null);
        }

        public b.b e(String str) {
            int i = 0;
            boolean equalsIgnoreCase;
            i = 0;
            while (i < this.a.size()) {
                i = i + 2;
            }
            return this;
        }

        public b.b f(String str, String str2) {
            d(str, str2);
            e(str);
            b(str, str2);
            return this;
        }
    }
    /* synthetic */ b(b.b bVar, b.a aVar) {
        this(bVar);
    }

    public String a(int i) {
        i *= 2;
        if (i2 >= 0) {
            length = strArr.length;
            return strArr[i2];
        }
        return null;
    }

    public int b() {
        return this.a.length / 2;
    }

    public String c(int i) {
        int i3 = (i * 2) + 1;
        if (i3 >= 0) {
            length = strArr.length;
            return strArr[i3];
        }
        return null;
    }

    public String toString() {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < b()) {
            stringBuilder.append(a(i));
            stringBuilder.append(": ");
            stringBuilder.append(c(i));
            str = "\n";
            stringBuilder.append(str);
            i = i + 1;
        }
        return stringBuilder.toString();
    }

    private b(b.b bVar) {
        super();
        this.a = (String[])bVar.a.toArray(new String[bVar.a.size()]);
    }
}
