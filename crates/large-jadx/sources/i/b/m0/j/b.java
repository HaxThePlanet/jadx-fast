package i.b.m0.j;

import i.b.l0.n;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: ArrayListSupplier.java */
/* loaded from: classes3.dex */
public enum b implements Callable<List<Object>>, n<Object, List<Object>> {

    INSTANCE;
    public static <T> Callable<List<T>> asCallable() {
        return b.INSTANCE;
    }

    public static <T, O> n<O, List<T>> asFunction() {
        return b.INSTANCE;
    }

    @Override // java.lang.Enum
    public List<Object> apply(Object object) {
        return new ArrayList();
    }

    @Override // java.lang.Enum
    public List<Object> call() {
        return new ArrayList();
    }
}
