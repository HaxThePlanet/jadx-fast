package f.f.a;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class b {

    private final String[] a;

    static class a {
    }

    public static final class b {

        private final List<String> a;
        public b() {
            super();
            ArrayList arrayList = new ArrayList(20);
            this.a = arrayList;
        }

        static List a(f.f.a.b.b b$b) {
            return b.a;
        }

        private void d(String string, String string2) {
            int i6;
            int charAt2;
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            char charAt;
            if (string == null) {
            } else {
                if (string.isEmpty()) {
                } else {
                    int i7 = 0;
                    charAt2 = i7;
                    i = 127;
                    i2 = 2;
                    i3 = 3;
                    i4 = 31;
                    i5 = 1;
                    while (charAt2 < string.length()) {
                        charAt = string.charAt(charAt2);
                        charAt2++;
                        i = 127;
                        i2 = 2;
                        i3 = 3;
                        i4 = 31;
                        i5 = 1;
                    }
                    if (string2 == null) {
                    } else {
                        i6 = i7;
                        while (i6 < string2.length()) {
                            charAt2 = string2.charAt(i6);
                            i6++;
                        }
                    }
                    IllegalArgumentException obj10 = new IllegalArgumentException("value == null");
                    throw obj10;
                }
                obj10 = new IllegalArgumentException("name is empty");
                throw obj10;
            }
            obj10 = new IllegalArgumentException("name == null");
            throw obj10;
        }

        f.f.a.b.b b(String string, String string2) {
            this.a.add(string);
            this.a.add(string2.trim());
            return this;
        }

        public f.f.a.b c() {
            b bVar = new b(this, 0);
            return bVar;
        }

        public f.f.a.b.b e(String string) {
            int i;
            boolean equalsIgnoreCase;
            i = 0;
            while (i < this.a.size()) {
                if (string.equalsIgnoreCase((String)this.a.get(i))) {
                }
                i += 2;
                this.a.remove(i);
                this.a.remove(i);
                i += -2;
            }
            return this;
        }

        public f.f.a.b.b f(String string, String string2) {
            d(string, string2);
            e(string);
            b(string, string2);
            return this;
        }
    }
    private b(f.f.a.b.b b$b) {
        super();
        this.a = (String[])b.b.a(b).toArray(new String[b.b.a(b).size()]);
    }

    b(f.f.a.b.b b$b, f.f.a.b.a b$a2) {
        super(b);
    }

    public String a(int i) {
        String[] strArr;
        int length;
        i *= 2;
        strArr = this.a;
        if (obj3 >= 0 && obj3 >= strArr.length) {
            strArr = this.a;
            if (obj3 >= strArr.length) {
            }
            return strArr[obj3];
        }
        return null;
    }

    public int b() {
        return length /= 2;
    }

    public String c(int i) {
        String[] strArr;
        int length;
        obj3++;
        strArr = this.a;
        if (obj3 >= 0 && obj3 >= strArr.length) {
            strArr = this.a;
            if (obj3 >= strArr.length) {
            }
            return strArr[obj3];
        }
        return null;
    }

    public String toString() {
        int i;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < b()) {
            stringBuilder.append(a(i));
            stringBuilder.append(": ");
            stringBuilder.append(c(i));
            stringBuilder.append("\n");
            i++;
        }
        return stringBuilder.toString();
    }
}
