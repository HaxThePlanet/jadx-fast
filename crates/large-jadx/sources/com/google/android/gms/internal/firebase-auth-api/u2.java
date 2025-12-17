package com.google.android.gms.internal.firebase-auth-api;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final class u2<P>  {

    private final ConcurrentMap<com.google.android.gms.internal.firebase-auth-api.t2, List<com.google.android.gms.internal.firebase-auth-api.s2<P>>> a;
    private final Class<P> b;
    private u2(Class<P> class) {
        super();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.a = concurrentHashMap;
        this.b = class;
    }

    public static <P> com.google.android.gms.internal.firebase-auth-api.u2<P> b(Class<P> class) {
        u2 u2Var = new u2(class);
        return u2Var;
    }

    public final com.google.android.gms.internal.firebase-auth-api.s2<P> a(P p, com.google.android.gms.internal.firebase-auth-api.ma ma2) {
        byte[] array;
        Object unmodifiableList;
        int i2;
        int i;
        Object obj9;
        if (ma2.B() != ca.zzb) {
        } else {
            com.google.android.gms.internal.firebase-auth-api.hb zza = hb.zza;
            int ordinal = ma2.E().ordinal();
            i2 = 5;
            i = 1;
            if (ordinal != i) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                        } else {
                            array = ByteBuffer.allocate(i2).put(0).putInt(ma2.z()).array();
                        }
                        obj9 = new GeneralSecurityException("unknown output prefix type");
                        throw obj9;
                    }
                    array = x1.a;
                } else {
                }
            } else {
                array = ByteBuffer.allocate(i2).put(i).putInt(ma2.z()).array();
            }
            super(p, array, ma2.B(), ma2.E(), ma2.z());
            obj9 = new ArrayList();
            obj9.add(s2Var);
            t2 obj10 = new t2(s2Var.d(), 0);
            obj9 = this.a.put(obj10, Collections.unmodifiableList(obj9));
            if ((List)obj9 != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List)obj9);
                arrayList.add(s2Var);
                this.a.put(obj10, Collections.unmodifiableList(arrayList));
            }
            return s2Var;
        }
        obj9 = new GeneralSecurityException("only ENABLED key is allowed");
        throw obj9;
    }

    public final Class<P> c() {
        return this.b;
    }

    public final List<com.google.android.gms.internal.firebase-auth-api.s2<P>> d(byte[] bArr) {
        t2 t2Var = new t2(bArr, 0);
        Object obj4 = this.a.get(t2Var);
        if ((List)obj4 != null) {
            return (List)obj4;
        }
        return Collections.emptyList();
    }

    public final void e(com.google.android.gms.internal.firebase-auth-api.s2<P> s2) {
        if (s2.a() != ca.zzb) {
        } else {
            if (d(s2.d()).isEmpty()) {
            } else {
            }
            IllegalArgumentException obj3 = new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
            throw obj3;
        }
        obj3 = new IllegalArgumentException("the primary entry has to be ENABLED");
        throw obj3;
    }
}
