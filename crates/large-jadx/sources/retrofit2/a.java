package retrofit2;

/* loaded from: classes3.dex */
public final class a implements Runnable {

    public final retrofit2.DefaultCallAdapterFactory.ExecutorCallbackCall.1 a;
    public final retrofit2.Callback b;
    public final Throwable c;
    public a(retrofit2.DefaultCallAdapterFactory.ExecutorCallbackCall.1 defaultCallAdapterFactory$ExecutorCallbackCall$1, retrofit2.Callback callback2, Throwable throwable3) {
        super();
        this.a = 1;
        this.b = callback2;
        this.c = throwable3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b, this.c);
    }
}
