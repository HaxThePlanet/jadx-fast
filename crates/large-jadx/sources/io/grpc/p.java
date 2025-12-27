package io.grpc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: CompressorRegistry.java */
/* loaded from: classes2.dex */
public final class p {

    private static final p b = new p();
    private final ConcurrentMap<String, o> a = new ConcurrentHashMap<>();
    static {
        io.grpc.o[] arr = new o[2];
    }

    p(o... oVarArr) {
        int i = 0;
        super();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        i = 0;
        for (Object obj : oVarArr) {
            this.a.put(obj.a(), obj);
        }
    }

    public static p a() {
        return p.b;
    }

    public o b(String str) {
        return (o)this.a.get(str);
    }
}
