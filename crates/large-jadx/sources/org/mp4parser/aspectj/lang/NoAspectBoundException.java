package org.mp4parser.aspectj.lang;

/* compiled from: NoAspectBoundException.java */
/* loaded from: classes3.dex */
public class NoAspectBoundException extends RuntimeException {

    Throwable cause;
    public NoAspectBoundException(String str, Throwable th) {
        String str3;
        if (th != null) {
            StringBuffer stringBuffer = new StringBuffer();
            str2 = "Exception while initializing ";
            String str4 = ": ";
            str3 = str2 + str + str4 + th;
        }
        super(str3);
        this.cause = th;
    }

    @Override // java.lang.RuntimeException
    public Throwable getCause() {
        return this.cause;
    }
}
