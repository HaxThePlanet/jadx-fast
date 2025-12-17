package androidx.room;

import d.s.a.h;
import d.s.a.h.b;
import d.s.a.h.c;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
class a1 implements h.c {

    private final String a;
    private final File b;
    private final Callable<InputStream> c;
    private final h.c d;
    a1(String string, File file2, Callable<InputStream> callable3, h.c h$c4) {
        super();
        this.a = string;
        this.b = file2;
        this.c = callable3;
        this.d = c4;
    }

    @Override // d.s.a.h$c
    public h a(h.b h$b) {
        super(b.a, this.a, this.b, this.c, aVar.a, this.d.a(b));
        return z0Var2;
    }
}
