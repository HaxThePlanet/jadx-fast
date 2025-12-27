package i.b.m0.j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: HashMapSupplier.java */
/* loaded from: classes3.dex */
public enum m implements Callable<Map<Object, Object>> {

    INSTANCE;
    public static <K, V> Callable<Map<K, V>> asCallable() {
        return m.INSTANCE;
    }

    @Override // java.lang.Enum
    public Map<Object, Object> call() {
        return new HashMap();
    }
}
