package io.grpc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final class p {

    private static final io.grpc.p b;
    private final ConcurrentMap<String, io.grpc.o> a;
    static {
        io.grpc.o[] arr = new o[2];
        m.a aVar = new m.a();
        p pVar = new p(arr);
        p.b = pVar;
    }

    p(io.grpc.o... oArr) {
        int i;
        Object obj;
        ConcurrentMap map;
        String str;
        super();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.a = concurrentHashMap;
        i = 0;
        while (i < oArr.length) {
            obj = oArr[i];
            this.a.put(obj.a(), obj);
            i++;
        }
    }

    public static io.grpc.p a() {
        return p.b;
    }

    public io.grpc.o b(String string) {
        return (o)this.a.get(string);
    }
}
