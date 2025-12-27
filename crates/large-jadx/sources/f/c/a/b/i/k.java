package f.c.a.b.i;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: ExecutionModule.java */
/* loaded from: classes.dex */
abstract class k {
    static Executor a() {
        return new n(Executors.newSingleThreadExecutor());
    }
}
