package org.mp4parser.aspectj.lang;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes3.dex */
public class SoftException extends RuntimeException {

    private static final boolean a = false;
    Throwable inner;
    static {
        try {
            Class.forName("java.nio.Buffer");
            int i2 = 1;
            int i = 0;
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
        boolean str;
        super.printStackTrace(printStream);
        final Throwable inner = this.inner;
        if (!SoftException.a && inner != null) {
            if (inner != null) {
                printStream.print("Caused by: ");
                inner.printStackTrace(printStream);
            }
        }
    }

    @Override // java.lang.RuntimeException
    public void printStackTrace(PrintWriter printWriter) {
        boolean str;
        super.printStackTrace(printWriter);
        final Throwable inner = this.inner;
        if (!SoftException.a && inner != null) {
            if (inner != null) {
                printWriter.print("Caused by: ");
                inner.printStackTrace(printWriter);
            }
        }
    }
}
