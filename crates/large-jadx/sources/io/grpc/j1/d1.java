package io.grpc.j1;

import com.google.common.base.n;
import com.google.common.base.t;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: LogExceptionRunnable.java */
/* loaded from: classes3.dex */
public final class d1 implements Runnable {

    private static final Logger b;
    private final Runnable a;
    static {
        d1.b = Logger.getLogger(d1.class.getName());
    }

    public d1(Runnable runnable) {
        super();
        n.p(runnable, "task");
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.run();
        } finally {
            Logger assertionError = d1.b;
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Exception while executing runnable ";
            stringBuilder = this.a + this.a;
            assertionError.log(Level.SEVERE, stringBuilder, th);
            t.f(th);
            assertionError = new AssertionError(th);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) assertionError;
        }
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "LogExceptionRunnable(";
        String str3 = ")";
        str = str2 + this.a + str3;
        return str;
    }
}
