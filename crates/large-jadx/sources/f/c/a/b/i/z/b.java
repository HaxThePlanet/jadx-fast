package f.c.a.b.i.z;

/* compiled from: Retries.java */
/* loaded from: classes.dex */
public final class b {
    public static <TInput, TResult, TException extends Throwable> TResult a(int i, TInput tinput, a<TInput, TResult, TException> aVar, c<TInput, TResult> cVar) {
        int i2;
        Object obj;
        final int i3 = 1;
        if (i < i3) {
            return aVar.apply(tinput);
        }
        Object apply = aVar.apply(obj);
        while (cVar.a(obj, apply) != null) {
            i2 = i2 - 1;
            if (i2 - 1 < i3) {
                return apply;
            }
            apply = aVar.apply(obj);
        }
        return apply;
    }
}
