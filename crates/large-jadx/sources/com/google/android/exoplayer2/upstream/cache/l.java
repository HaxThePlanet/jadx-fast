package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.google.android.exoplayer2.util.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public class l {

    private final Map<String, Object> a;
    private final List<String> b;
    public l() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
    }

    private com.google.android.exoplayer2.upstream.cache.l a(String string, Object object2) {
        g.e(string);
        g.e(object2);
        this.a.put((String)string, object2);
        this.b.remove(string);
        return this;
    }

    public static com.google.android.exoplayer2.upstream.cache.l g(com.google.android.exoplayer2.upstream.cache.l l, long l2) {
        l.e("exo_len", l2);
        return l;
    }

    public static com.google.android.exoplayer2.upstream.cache.l h(com.google.android.exoplayer2.upstream.cache.l l, Uri uri2) {
        final String str = "exo_redir";
        if (uri2 == null) {
            l.d(str);
            return l;
        }
        l.f(str, uri2.toString());
        return l;
    }

    public Map<String, Object> b() {
        Object next;
        Object copyOf;
        boolean length;
        HashMap hashMap = new HashMap(this.a);
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            copyOf = (Map.Entry)next.getValue();
            if (copyOf instanceof byte[]) {
            }
            next.setValue(Arrays.copyOf((byte[])copyOf, copyOf.length));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public List<String> c() {
        ArrayList arrayList = new ArrayList(this.b);
        return Collections.unmodifiableList(arrayList);
    }

    public com.google.android.exoplayer2.upstream.cache.l d(String string) {
        this.b.add(string);
        this.a.remove(string);
        return this;
    }

    public com.google.android.exoplayer2.upstream.cache.l e(String string, long l2) {
        a(string, Long.valueOf(l2));
        return this;
    }

    public com.google.android.exoplayer2.upstream.cache.l f(String string, String string2) {
        a(string, string2);
        return this;
    }
}
