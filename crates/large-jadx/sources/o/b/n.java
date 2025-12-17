package o.b;

/* loaded from: classes3.dex */
public abstract class n<E>  {
    public abstract E getInitialState();

    public String getStateKey() {
        return o.e(getInitialState().getClass());
    }

    public abstract E reduce(E e, o.b.a<?> a2);
}
