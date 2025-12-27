package d.h.e;

import java.util.List;

/* compiled from: Keyframes.java */
/* loaded from: classes.dex */
interface p<T> extends java.lang.Cloneable {

    public interface a extends p<Float> {
        float n1(float f);
    }

    public interface b extends p<Integer> {
        int N0(float f);
    }
    T I1(float f);

    @Override // java.lang.Object
    p clone();

    void l0(u<T> uVar);

    List<n<T>> q();
}
