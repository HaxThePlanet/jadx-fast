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

/* compiled from: DecompressorRegistry.java */
/* loaded from: classes2.dex */
public final class w {

    static final i c;
    private static final w d;
    private final Map<String, w.a> a;
    private final byte[] b;

    private static final class a {

        final v a;
        final boolean b;
        a(v vVar, boolean z) {
            super();
            n.p(vVar, "decompressor");
            this.a = vVar;
            this.b = z;
        }
    }
    static {
        w.c = i.e(',');
        w.d = w.a().f(new m.a(), true).f(m.b.a, false);
    }

    private w(v vVar, boolean z, w wVar) throws java.io.UnsupportedEncodingException {
        int size;
        io.grpc.v vVar2;
        super();
        final String str2 = vVar.a();
        n.e(!str2.contains(","), "Comma is currently not allowed in message encoding");
        size = !wVar.a.containsKey(vVar.a()) ? size + 1 : size;
        LinkedHashMap linkedHashMap = new LinkedHashMap(size);
        Iterator it = wVar.a.values().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            String str = item.a.a();
        }
        linkedHashMap.put(str2, new w.a(vVar, z));
        this.a = Collections.unmodifiableMap(linkedHashMap);
        this.b = w.c.c(b()).getBytes(Charset.forName("US-ASCII"));
    }

    public static w a() {
        return new w();
    }

    public static w c() {
        return w.d;
    }

    public Set<String> b() {
        HashSet hashSet = new HashSet(this.a.size());
        Iterator it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        return Collections.unmodifiableSet(hashSet);
    }

    byte[] d() {
        return this.b;
    }

    public v e(String str) {
        io.grpc.v vVar = null;
        Object value = this.a.get(str);
        str = value != null ? value.a : 0;
        return (value != null ? value.a : 0);
    }

    public w f(v vVar, boolean z) {
        return new w(vVar, z, this);
    }

    private w() {
        super();
        final int i = 0;
        this.a = new LinkedHashMap(i);
        this.b = new byte[i];
    }
}
