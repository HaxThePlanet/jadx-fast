package f.c.a.b.i;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
abstract class k {
    static Executor a() {
        n nVar = new n(Executors.newSingleThreadExecutor());
        return nVar;
    }
}
