package com.google.android.play.core.splitinstall;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class c {

    private final List<String> a;
    private final List<Locale> b;

    public static class a {

        private final List<String> a;
        private final List<Locale> b;
        a(com.google.android.play.core.splitinstall.q q) {
            super();
            ArrayList obj1 = new ArrayList();
            this.a = obj1;
            obj1 = new ArrayList();
            this.b = obj1;
        }

        static List c(com.google.android.play.core.splitinstall.c.a c$a) {
            return a.b;
        }

        static List d(com.google.android.play.core.splitinstall.c.a c$a) {
            return a.a;
        }

        public com.google.android.play.core.splitinstall.c.a a(Locale locale) {
            this.b.add(locale);
            return this;
        }

        public com.google.android.play.core.splitinstall.c b() {
            c cVar = new c(this, 0);
            return cVar;
        }
    }
    c(com.google.android.play.core.splitinstall.c.a c$a, com.google.android.play.core.splitinstall.r r2) {
        super();
        ArrayList obj3 = new ArrayList(c.a.d(a));
        this.a = obj3;
        obj3 = new ArrayList(c.a.c(a));
        this.b = obj3;
    }

    public static com.google.android.play.core.splitinstall.c.a c() {
        c.a aVar = new c.a(0);
        return aVar;
    }

    public List<Locale> a() {
        return this.b;
    }

    public List<String> b() {
        return this.a;
    }

    public String toString() {
        Object[] arr = new Object[2];
        return String.format("SplitInstallRequest{modulesNames=%s,languages=%s}", this.a, this.b);
    }
}
