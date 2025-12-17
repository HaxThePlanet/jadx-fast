package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class q {

    private static boolean b = true;
    private static volatile com.google.protobuf.q c;
    static final com.google.protobuf.q d;
    private final Map<com.google.protobuf.q.a, com.google.protobuf.z.e<?, ?>> a;

    private static final class a {

        private final Object a;
        private final int b;
        a(Object object, int i2) {
            super();
            this.a = object;
            this.b = i2;
        }

        public boolean equals(Object object) {
            Object obj;
            int i;
            Object obj4;
            if (!object instanceof q.a) {
                return 0;
            }
            if (this.a == object.a && this.b == object.b) {
                if (this.b == object.b) {
                    i = 1;
                }
            }
            return i;
        }

        public int hashCode() {
            return i += i4;
        }
    }
    static {
        q qVar = new q(1);
        q.d = qVar;
    }

    q() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
    }

    q(boolean z) {
        super();
        this.a = Collections.emptyMap();
    }

    public static com.google.protobuf.q b() {
        com.google.protobuf.q qVar;
        Class<com.google.protobuf.q> obj;
        obj = q.class;
        if (q.c == null && q.c == null) {
            obj = q.class;
            synchronized (obj) {
                if (q.b) {
                    qVar = p.a();
                } else {
                    qVar = q.d;
                }
                q.c = qVar;
            }
        }
        return qVar;
    }

    public <ContainingType extends com.google.protobuf.t0> com.google.protobuf.z.e<ContainingType, ?> a(ContainingType containingtype, int i2) {
        q.a aVar = new q.a(containingtype, i2);
        return (z.e)this.a.get(aVar);
    }
}
