package i.b.m0.j;

import i.b.l0.n;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

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
    public Object apply(Object object) {
        return apply(object);
    }

    public List<Object> apply(Object object) {
        ArrayList obj1 = new ArrayList();
        return obj1;
    }

    @Override // java.lang.Enum
    public Object call() {
        return call();
    }

    public List<Object> call() {
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }
}
