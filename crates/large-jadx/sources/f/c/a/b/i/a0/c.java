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

/* compiled from: DefaultScheduler.java */
/* loaded from: classes.dex */
public class c implements e {

    private static final Logger f;
    private final x a;
    private final Executor b;
    private final e c;
    private final i0 d;
    private final a e;
    static {
        c.f = Logger.getLogger(t.class.getName());
    }

    public c(Executor executor, e eVar, x xVar, i0 i0Var, a aVar) {
        super();
        this.b = executor;
        this.c = eVar;
        this.a = xVar;
        this.d = i0Var;
        this.e = aVar;
    }

    private /* synthetic */ Object b(p pVar, j jVar) {
        this.d.v1(pVar, jVar);
        this.a.a(pVar, 1);
        return null;
    }

    private /* synthetic */ void d(p pVar, h hVar, j jVar) {
        try {
            m mVar = this.c.get(pVar.b());
            if (mVar == null) {
                Object[] arr = new Object[1];
                String formatted = String.format("Transport backend '%s' is not registered", new Object[] { pVar.b() });
                c.f.warning(formatted);
                hVar.a(new IllegalArgumentException(formatted));
                return;
            }
        } catch (Exception e) {
            jVar = c.f;
            StringBuilder stringBuilder = new StringBuilder();
            String message = "Error scheduling event ";
            message = e.getMessage();
            stringBuilder = message + message;
            jVar.warning(stringBuilder);
            hVar.a(e);
        }
    }

    public void a(p pVar, j jVar, h hVar) {
        this.b.execute(new a(this, pVar, hVar, jVar));
    }

    public /* synthetic */ Object c(p pVar, j jVar) {
        return b(pVar, jVar);
    }

    public /* synthetic */ void e(p pVar, h hVar, j jVar) {
        d(pVar, hVar, jVar);
    }
}
