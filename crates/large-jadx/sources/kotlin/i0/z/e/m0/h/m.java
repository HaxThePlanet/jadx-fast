package kotlin.i0.z.e.m0.h;

import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes3.dex */
public enum m {

    PLAIN,
    HTML;

    static final class a extends kotlin.i0.z.e.m0.h.m {
        a(String string, int i2) {
            super(string, i2, 0);
        }

        @Override // kotlin.i0.z.e.m0.h.m
        public String escape(String string) {
            n.f(string, "string");
            return l.G(l.G(string, "<", "&lt;", false, 4, 0), ">", "&gt;", false, 4, 0);
        }
    }

    static final class b extends kotlin.i0.z.e.m0.h.m {
        b(String string, int i2) {
            super(string, i2, 0);
        }

        @Override // kotlin.i0.z.e.m0.h.m
        public String escape(String string) {
            n.f(string, "string");
            return string;
        }
    }
    @Override // java.lang.Enum
    public abstract String escape(String string);
}
