package o.b;

/* compiled from: Reducer.java */
/* loaded from: classes3.dex */
public abstract class n<E> {
    public String getStateKey() {
        return o.e(getInitialState().getClass());
    }

    public abstract E getInitialState();

    public abstract E reduce(E e, a<?> aVar);
}
