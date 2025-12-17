package f.c.a.b.i.z;

/* loaded from: classes.dex */
public final class b {
    public static <TInput, TResult, TException extends Throwable> TResult a(int i, TInput tinput2, f.c.a.b.i.z.a<TInput, TResult, TException> a3, f.c.a.b.i.z.c<TInput, TResult> c4) {
        Object apply;
        int obj2;
        Object obj3;
        final int i2 = 1;
        if (i < i2) {
            return a3.apply(tinput2);
        }
        apply = a3.apply(obj3);
        while (c4.a(obj3, apply) != null) {
            if (obj2-- >= i2) {
            }
            apply = a3.apply(obj3);
        }
        return apply;
    }
}
