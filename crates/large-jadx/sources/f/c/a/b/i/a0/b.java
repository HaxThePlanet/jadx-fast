package f.c.a.b.i.a0;

import com.google.android.datatransport.runtime.synchronization.a.a;
import f.c.a.b.i.j;
import f.c.a.b.i.p;

/* loaded from: classes.dex */
public final class b implements a.a {

    public final f.c.a.b.i.a0.c a;
    public final p b;
    public final j c;
    public b(f.c.a.b.i.a0.c c, p p2, j j3) {
        super();
        this.a = c;
        this.b = p2;
        this.c = j3;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a$a
    public final Object execute() {
        return this.a.c(this.b, this.c);
    }
}
