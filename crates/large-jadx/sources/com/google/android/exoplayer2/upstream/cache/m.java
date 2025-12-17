package com.google.android.exoplayer2.upstream.cache;

import com.google.common.base.d;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class m implements com.google.android.exoplayer2.upstream.cache.k {

    public static final com.google.android.exoplayer2.upstream.cache.m c;
    private int a;
    private final Map<String, byte[]> b;
    static {
        m mVar = new m(Collections.emptyMap());
        m.c = mVar;
    }

    public m() {
        super(Collections.emptyMap());
    }

    public m(Map<String, byte[]> map) {
        super();
        this.b = Collections.unmodifiableMap(map);
    }

    private static void e(HashMap<String, byte[]> hashMap, Map<String, Object> map2) {
        byte[] bArr;
        Object key;
        Iterator obj3 = map2.entrySet().iterator();
        for (Map.Entry next2 : obj3) {
            hashMap.put((String)next2.getKey(), m.i(next2.getValue()));
        }
    }

    private static Map<String, byte[]> f(Map<String, byte[]> map, com.google.android.exoplayer2.upstream.cache.l l2) {
        HashMap hashMap = new HashMap(map);
        m.k(hashMap, l2.c());
        m.e(hashMap, l2.b());
        return hashMap;
    }

    private static byte[] i(Object object) {
        if (object instanceof Long) {
            return ByteBuffer.allocate(8).putLong((Long)object.longValue()).array();
        }
        if (object instanceof String != null) {
            return (String)object.getBytes(d.c);
        }
        if (!object instanceof byte[]) {
        } else {
            return (byte[])object;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException();
        throw obj3;
    }

    private static boolean j(Map<String, byte[]> map, Map<String, byte[]> map2) {
        int equals;
        int value;
        final int i = 0;
        if (map.size() != map2.size()) {
            return i;
        }
        Iterator obj3 = map.entrySet().iterator();
        for (Map.Entry next2 : obj3) {
        }
        return 1;
    }

    private static void k(HashMap<String, byte[]> hashMap, List<String> list2) {
        int i;
        Object obj;
        i = 0;
        while (i < list2.size()) {
            hashMap.remove(list2.get(i));
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.k
    public final String b(String string, String string2) {
        Object map;
        String obj3;
        final Object obj2 = this.b.get(string);
        if ((byte[])obj2 != null) {
            obj3 = new String((byte[])obj2, d.c);
        }
        return obj3;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.k
    public final long c(String string, long l2) {
        Object obj2 = this.b.get(string);
        if ((byte[])obj2 != null) {
            return ByteBuffer.wrap((byte[])obj2).getLong();
        }
        return l2;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.k
    public boolean equals(Object object) {
        Class<com.google.android.exoplayer2.upstream.cache.m> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        if (object != null && m.class != object.getClass()) {
            if (m.class != object.getClass()) {
            }
            return m.j(this.b, object.b);
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.k
    public com.google.android.exoplayer2.upstream.cache.m g(com.google.android.exoplayer2.upstream.cache.l l) {
        final Map obj2 = m.f(this.b, l);
        if (m.j(this.b, obj2)) {
            return this;
        }
        m mVar = new m(obj2);
        return mVar;
    }

    public Set<Map.Entry<String, byte[]>> h() {
        return this.b.entrySet();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.k
    public int hashCode() {
        int i;
        Iterator iterator;
        boolean next;
        int i2;
        if (this.a == 0) {
            i = 0;
            iterator = this.b.entrySet().iterator();
            for (Map.Entry next2 : iterator) {
                i += next;
            }
            this.a = i;
        }
        return this.a;
    }
}
