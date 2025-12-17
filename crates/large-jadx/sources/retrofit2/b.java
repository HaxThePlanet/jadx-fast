package retrofit2;

/* loaded from: classes3.dex */
public final class b implements Runnable {

    public final retrofit2.DefaultCallAdapterFactory.ExecutorCallbackCall.1 a;
    public final retrofit2.Callback b;
    public final retrofit2.Response c;
    public b(retrofit2.DefaultCallAdapterFactory.ExecutorCallbackCall.1 defaultCallAdapterFactory$ExecutorCallbackCall$1, retrofit2.Callback callback2, retrofit2.Response response3) {
        super();
        this.a = 1;
        this.b = callback2;
        this.c = response3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d(this.b, this.c);
    }
}
