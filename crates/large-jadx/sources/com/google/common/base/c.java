package com.google.common.base;

/* loaded from: classes2.dex */
public abstract class c implements com.google.common.base.o<Character> {

    static abstract class a extends com.google.common.base.c {
        @Deprecated
        public boolean apply(Object object) {
            return super.b((Character)object);
        }
    }

    private static final class b extends com.google.common.base.c.a {

        private final char a;
        b(char c) {
            super();
            this.a = c;
        }

        @Override // com.google.common.base.c$a
        public boolean d(char c) {
            int obj2;
            obj2 = c == this.a ? 1 : 0;
            return obj2;
        }

        @Override // com.google.common.base.c$a
        public String toString() {
            String str = c.a(this.a);
            StringBuilder stringBuilder = new StringBuilder(length += 18);
            stringBuilder.append("CharMatcher.is('");
            stringBuilder.append(str);
            stringBuilder.append("')");
            return stringBuilder.toString();
        }
    }

    static abstract class c extends com.google.common.base.c.a {

        private final String a;
        c(String string) {
            super();
            n.o(string);
            this.a = (String)string;
        }

        @Override // com.google.common.base.c$a
        public final String toString() {
            return this.a;
        }
    }

    private static final class d extends com.google.common.base.c.c {

        static final com.google.common.base.c.d b;
        static {
            c.d dVar = new c.d();
            c.d.b = dVar;
        }

        private d() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.c$c
        public boolean d(char c) {
            return 0;
        }
    }

    static final class e extends com.google.common.base.c.c {

        static final int b;
        static final com.google.common.base.c.e c;
        static {
            c.e.b = Integer.numberOfLeadingZeros(31);
            c.e eVar = new c.e();
            c.e.c = eVar;
        }

        e() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.c$c
        public boolean d(char c) {
            int obj3;
            obj3 = " 　\r\u0085   　 \u000b　   　 \t     \u000c 　 　　 \n 　".charAt(i2 >>>= i4) == c ? 1 : 0;
            return obj3;
        }
    }
    static String a(char c) {
        return c.f(c);
    }

    public static com.google.common.base.c c(char c) {
        c.b bVar = new c.b(c);
        return bVar;
    }

    public static com.google.common.base.c e() {
        return c.d.b;
    }

    private static String f(char c) {
        int i3;
        int i2;
        int i;
        char charAt;
        String str;
        int obj6;
        char[] cArr = new char[6];
        cArr = new short[]{'\', 'u', 0, 0, 0, 0};
        i3 = 0;
        i2 = 4;
        while (i3 < i2) {
            cArr[i3 - 5] = "0123456789ABCDEF".charAt(obj6 & 15);
            obj6 = (char)obj6;
            i3++;
            i2 = 4;
        }
        return String.copyValueOf(cArr);
    }

    public static com.google.common.base.c g() {
        return c.e.c;
    }

    @Deprecated
    public boolean b(Character character) {
        return d(character.charValue());
    }

    @Override // com.google.common.base.o
    public abstract boolean d(char c);
}
