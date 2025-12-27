package org.mp4parser.aspectj.lang;

import java.io.PrintStream;
import java.io.PrintWriter;

/* compiled from: SoftException.java */
/* loaded from: classes3.dex */
public class SoftException extends RuntimeException {

    private static final boolean a = false;
    Throwable inner;
    static {
        try {
            Class.forName("java.nio.Buffer");
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.RuntimeException
    public Throwable getCause() {
        return this.inner;
    }

    @Override // java.lang.RuntimeException
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.RuntimeException
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (!SoftException.a && this.inner != null) {
            printStream.print("Caused by: ");
            this.inner.printStackTrace(printStream);
        }
    }

    @Override // java.lang.RuntimeException
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (!SoftException.a && this.inner != null) {
            printWriter.print("Caused by: ");
            this.inner.printStackTrace(printWriter);
        }
    }
}
