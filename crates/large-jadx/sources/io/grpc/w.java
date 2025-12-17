package io.grpc;

import com.google.common.base.i;
import com.google.common.base.n;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class w {

    static final i c;
    private static final io.grpc.w d;
    private final Map<String, io.grpc.w.a> a;
    private final byte[] b;

    private static final class a {

        final io.grpc.v a;
        final boolean b;
        a(io.grpc.v v, boolean z2) {
            super();
            n.p(v, "decompressor");
            this.a = (v)v;
            this.b = z2;
        }
    }
    static {
        w.c = i.e(',');
        m.a aVar = new m.a();
        w.d = w.a().f(aVar, true).f(m.b.a, false);
    }

    private w() {
        super();
        final int i = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap(i);
        this.a = linkedHashMap;
        this.b = new byte[i];
    }

    private w(io.grpc.v v, boolean z2, io.grpc.w w3) {
        int size;
        String str;
        boolean aVar;
        io.grpc.v vVar;
        super();
        final String str2 = v.a();
        n.e(contains ^= 1, "Comma is currently not allowed in message encoding");
        size = !w3.a.containsKey(v.a()) ? size + 1 : size;
        LinkedHashMap linkedHashMap = new LinkedHashMap(size);
        Iterator obj9 = w3.a.values().iterator();
        while (obj9.hasNext()) {
            size = obj9.next();
            str = size.a.a();
            if (!str.equals(str2)) {
            }
            aVar = new w.a(size.a, size.b);
            linkedHashMap.put(str, aVar);
        }
        obj9 = new w.a(v, z2);
        linkedHashMap.put(str2, obj9);
        this.a = Collections.unmodifiableMap(linkedHashMap);
        this.b = w.c.c(b()).getBytes(Charset.forName("US-ASCII"));
    }

    public static io.grpc.w a() {
        w wVar = new w();
        return wVar;
    }

    public static io.grpc.w c() {
        return w.d;
    }

    public Set<String> b() {
        Object next;
        boolean z;
        HashSet hashSet = new HashSet(this.a.size());
        Iterator iterator = this.a.entrySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (value.b) {
            }
            hashSet.add(next.getKey());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    byte[] d() {
        return this.b;
    }

    public io.grpc.v e(String string) {
        io.grpc.v obj2;
        obj2 = this.a.get(string);
        obj2 = (w.a)obj2 != null ? obj2.a : 0;
        return obj2;
    }

    public io.grpc.w f(io.grpc.v v, boolean z2) {
        w wVar = new w(v, z2, this);
        return wVar;
    }
}
