package f.c.a.b.i.a0;

import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.backends.m;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.x;
import com.google.android.datatransport.runtime.synchronization.a;
import f.c.a.b.h;
import f.c.a.b.i.a0.j.i0;
import f.c.a.b.i.j;
import f.c.a.b.i.p;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class c implements f.c.a.b.i.a0.e {

    private static final Logger f;
    private final x a;
    private final Executor b;
    private final e c;
    private final i0 d;
    private final a e;
    static {
        c.f = Logger.getLogger(t.class.getName());
    }

    public c(Executor executor, e e2, x x3, i0 i04, a a5) {
        super();
        this.b = executor;
        this.c = e2;
        this.a = x3;
        this.d = i04;
        this.e = a5;
    }

    private Object b(p p, j j2) {
        this.d.v1(p, j2);
        this.a.a(p, 1);
        return null;
    }

    private void d(p p, h h2, j j3) {
        a aVar;
        f.c.a.b.i.a0.b bVar;
        int obj3;
        j obj5;
        try {
            m mVar = this.c.get(p.b());
            if (mVar == null) {
            }
            Object[] arr = new Object[1];
            obj3 = String.format("Transport backend '%s' is not registered", p.b());
            c.f.warning(obj3);
            obj5 = new IllegalArgumentException(obj3);
            h2.a(obj5);
            bVar = new b(this, p, mVar.b(j3));
            this.e.a(bVar);
            h2.a(0);
            j3 = c.f;
            StringBuilder string = new StringBuilder();
            String message = "Error scheduling event ";
            string.append(message);
            message = p.getMessage();
            string.append(message);
            string = string.toString();
            j3.warning(string);
            h2.a(p);
        }
    }

    @Override // f.c.a.b.i.a0.e
    public void a(p p, j j2, h h3) {
        a aVar = new a(this, p, h3, j2);
        this.b.execute(aVar);
    }

    @Override // f.c.a.b.i.a0.e
    public Object c(p p, j j2) {
        return b(p, j2);
    }

    @Override // f.c.a.b.i.a0.e
    public void e(p p, h h2, j j3) {
        d(p, h2, j3);
    }
}
