package i.b.m0.j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public enum m implements Callable<Map<Object, Object>> {

    INSTANCE;
    public static <K, V> Callable<Map<K, V>> asCallable() {
        return m.INSTANCE;
    }

    @Override // java.lang.Enum
    public Object call() {
        return call();
    }

    public Map<Object, Object> call() {
        HashMap hashMap = new HashMap();
        return hashMap;
    }
}
