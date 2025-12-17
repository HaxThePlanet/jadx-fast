package io.reactivex.exceptions;

/* loaded from: classes3.dex */
public final class OnErrorNotImplementedException extends RuntimeException {

    private static final long serialVersionUID = -6298857009889503852L;
    public OnErrorNotImplementedException(String string, Throwable throwable2) {
        java.lang.NullPointerException obj2;
        if (throwable2 != null) {
        } else {
            obj2 = new NullPointerException();
        }
        super(string, obj2);
    }

    public OnErrorNotImplementedException(Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | ");
        stringBuilder.append(throwable);
        super(stringBuilder.toString(), throwable);
    }
}
