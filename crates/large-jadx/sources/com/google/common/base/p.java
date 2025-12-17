package com.google.common.base;

/* loaded from: classes2.dex */
public final class p {

    private final boolean a;
    private final com.google.common.base.p.b b;
    private final int c;

    private interface b {
    }

    class a implements com.google.common.base.p.b {
        a(com.google.common.base.c c) {
            super();
        }
    }
    private p(com.google.common.base.p.b p$b) {
        super(b, 0, c.e(), Integer.MAX_VALUE);
    }

    private p(com.google.common.base.p.b p$b, boolean z2, com.google.common.base.c c3, int i4) {
        super();
        this.b = b;
        this.a = z2;
        this.c = i4;
    }

    public static com.google.common.base.p a(char c) {
        return p.b(c.c(c));
    }

    public static com.google.common.base.p b(com.google.common.base.c c) {
        n.o(c);
        p.a aVar = new p.a(c);
        p pVar = new p(aVar);
        return pVar;
    }

    public com.google.common.base.p c() {
        return d(c.g());
    }

    public com.google.common.base.p d(com.google.common.base.c c) {
        n.o(c);
        p pVar = new p(this.b, this.a, c, this.c);
        return pVar;
    }
}
