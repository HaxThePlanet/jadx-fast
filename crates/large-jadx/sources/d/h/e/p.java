package d.h.e;

import java.util.List;

/* loaded from: classes.dex */
interface p<T>  extends java.lang.Cloneable {

    public interface a extends d.h.e.p<Float> {
        @Override // d.h.e.p
        public abstract float n1(float f);
    }

    public interface b extends d.h.e.p<Integer> {
        @Override // d.h.e.p
        public abstract int N0(float f);
    }
    public abstract T I1(float f);

    @Override // java.lang.Cloneable
    public abstract d.h.e.p clone();

    public abstract void l0(d.h.e.u<T> u);

    public abstract List<d.h.e.n<T>> q();
}
