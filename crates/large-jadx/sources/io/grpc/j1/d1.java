package io.grpc.j1;

import com.google.common.base.n;
import com.google.common.base.t;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        this.a = (Runnable)runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.run();
            Logger assertionError = d1.b;
            StringBuilder string = new StringBuilder();
            String str = "Exception while executing runnable ";
            string.append(str);
            str = this.a;
            string.append(str);
            string = string.toString();
            assertionError.log(Level.SEVERE, string, th);
            t.f(th);
            assertionError = new AssertionError(th);
            throw assertionError;
        }
    }

    @Override // java.lang.Runnable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LogExceptionRunnable(");
        stringBuilder.append(this.a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
