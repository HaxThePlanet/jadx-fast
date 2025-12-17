package org.mp4parser.aspectj.lang;

/* loaded from: classes3.dex */
public class NoAspectBoundException extends RuntimeException {

    Throwable cause;
    public NoAspectBoundException(String string, Throwable throwable2) {
        StringBuffer stringBuffer;
        String str;
        String obj3;
        if (throwable2 == null) {
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("Exception while initializing ");
            stringBuffer.append(string);
            stringBuffer.append(": ");
            stringBuffer.append(throwable2);
            obj3 = stringBuffer.toString();
        }
        super(obj3);
        this.cause = throwable2;
    }

    @Override // java.lang.RuntimeException
    public Throwable getCause() {
        return this.cause;
    }
}
