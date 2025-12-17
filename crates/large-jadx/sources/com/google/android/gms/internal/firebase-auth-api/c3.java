package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class c3 {

    private static final Logger a;
    private static final ConcurrentMap<String, com.google.android.gms.internal.firebase-auth-api.b3> b;
    private static final ConcurrentMap<String, com.google.android.gms.internal.firebase-auth-api.a3> c;
    private static final ConcurrentMap<String, Boolean> d;
    private static final ConcurrentMap<Class<?>, com.google.android.gms.internal.firebase-auth-api.v2<?, ?>> e;
    private static final ConcurrentMap<String, com.google.android.gms.internal.firebase-auth-api.e2> f;
    static {
        c3.a = Logger.getLogger(c3.class.getName());
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        c3.b = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        c3.c = concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
        c3.d = concurrentHashMap3;
        ConcurrentHashMap concurrentHashMap4 = new ConcurrentHashMap();
        ConcurrentHashMap concurrentHashMap5 = new ConcurrentHashMap();
        c3.e = concurrentHashMap5;
        ConcurrentHashMap concurrentHashMap6 = new ConcurrentHashMap();
        c3.f = concurrentHashMap6;
    }

    public static com.google.android.gms.internal.firebase-auth-api.b2<?> a(String string) {
        return c3.p(string).zzb();
    }

    public static com.google.android.gms.internal.firebase-auth-api.aa b(String string, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        com.google.android.gms.internal.firebase-auth-api.b2 b2Var = c3.o(string, 0);
        if (!b2Var instanceof w2) {
        } else {
            return (w2)b2Var.g(wq2);
        }
        StringBuilder stringBuilder = new StringBuilder(length += 48);
        stringBuilder.append("manager for key type ");
        stringBuilder.append(string);
        stringBuilder.append(" is not a PrivateKeyManager");
        GeneralSecurityException obj3 = new GeneralSecurityException(stringBuilder.toString());
        throw obj3;
    }

    public static com.google.android.gms.internal.firebase-auth-api.aa c(com.google.android.gms.internal.firebase-auth-api.fa fa) {
        String obj4;
        final Class<com.google.android.gms.internal.firebase-auth-api.c3> obj = c3.class;
        synchronized (obj) {
            return c3.a(fa.E()).b(fa.D());
        }
    }

    public static com.google.android.gms.internal.firebase-auth-api.y d(com.google.android.gms.internal.firebase-auth-api.fa fa) {
        String obj4;
        final Class<com.google.android.gms.internal.firebase-auth-api.c3> obj = c3.class;
        synchronized (obj) {
            return c3.a(fa.E()).d(fa.D());
        }
    }

    public static Class<?> e(Class<?> class) {
        Object obj1 = c3.e.get(class);
        if ((v2)obj1 == null) {
            return 0;
        }
        return (v2)obj1.zza();
    }

    @Deprecated
    public static <P> P f(com.google.android.gms.internal.firebase-auth-api.aa aa) {
        return c3.q(aa.E(), aa.D(), 0);
    }

    public static <P> P g(com.google.android.gms.internal.firebase-auth-api.aa aa, Class<P> class2) {
        return c3.q(aa.E(), aa.D(), class2);
    }

    public static <P> P h(String string, com.google.android.gms.internal.firebase-auth-api.y y2, Class<P> class3) {
        return c3.o(string, class3).a(y2);
    }

    public static <P> P i(String string, byte[] b2Arr2, Class<P> class3) {
        return c3.q(string, wq.v(b2Arr2), class3);
    }

    public static <B, P> P j(com.google.android.gms.internal.firebase-auth-api.u2<B> u2, Class<P> class2) {
        String obj4;
        Object obj5 = c3.e.get(class2);
        if ((v2)obj5 == null) {
            obj4 = String.valueOf(u2.c().getName());
            String str = "No wrapper found for ";
            if (obj4.length() != 0) {
                obj4 = str.concat(obj4);
            } else {
                obj4 = new String(str);
            }
            obj5 = new GeneralSecurityException(obj4);
            throw obj5;
        }
        if (!(v2)obj5.zza().equals(u2.c())) {
        } else {
            return obj5.a(u2);
        }
        obj5 = String.valueOf(obj5.zza());
        obj4 = String.valueOf(u2.c());
        StringBuilder stringBuilder = new StringBuilder(i += length3);
        stringBuilder.append("Wrong input primitive class, expected ");
        stringBuilder.append(obj5);
        stringBuilder.append(", got ");
        stringBuilder.append(obj4);
        GeneralSecurityException generalSecurityException = new GeneralSecurityException(stringBuilder.toString());
        throw generalSecurityException;
    }

    static Map<String, com.google.android.gms.internal.firebase-auth-api.e2> k() {
        final Class<com.google.android.gms.internal.firebase-auth-api.c3> obj = c3.class;
        return Collections.unmodifiableMap(c3.f);
        synchronized (obj) {
            obj = c3.class;
            return Collections.unmodifiableMap(c3.f);
        }
    }

    public static <KeyProtoT extends com.google.android.gms.internal.firebase-auth-api.y, PublicKeyProtoT extends com.google.android.gms.internal.firebase-auth-api.y> void l(com.google.android.gms.internal.firebase-auth-api.x2<KeyProtoT, PublicKeyProtoT> x2, com.google.android.gms.internal.firebase-auth-api.j2<PublicKeyProtoT> j22, boolean z3) {
        boolean y2Var;
        boolean key;
        boolean a3Var;
        boolean equals;
        String name;
        Object obj8;
        final Class<com.google.android.gms.internal.firebase-auth-api.c3> obj10 = c3.class;
        String str = "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
        int i2 = 1;
        c3.r(str, x2.getClass(), x2.a().d(), i2);
        String str2 = "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
        final int i3 = 0;
        c3.r(str2, j22.getClass(), Collections.emptyMap(), i3);
        ConcurrentMap map2 = c3.b;
        synchronized (obj10) {
            a3Var = (b3)map2.get(str).b();
            if (a3Var != null) {
                if (!a3Var.getName().equals(j22.getClass().getName())) {
                } else {
                    try {
                        c3.a.logp(Level.WARNING, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", "Attempted overwrite of a registered key manager for key type type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey with inconsistent public key type type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
                        Object[] arr = new Object[3];
                        arr[i3] = x2.getClass().getName();
                        arr[i2] = a3Var.getName();
                        arr[2] = j22.getClass().getName();
                        GeneralSecurityException generalSecurityException = new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", arr));
                        throw generalSecurityException;
                        if (map2.containsKey(str)) {
                        } else {
                        }
                        if ((b3)map2.get(str).b() == null) {
                        }
                        z2 z2Var = new z2(x2, j22);
                        map2.put(str, z2Var);
                        a3Var = new a3(x2);
                        c3.c.put(str, a3Var);
                        c3.s("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", x2.a().d());
                        obj8 = c3.d;
                        obj8.put(str, Boolean.TRUE);
                        if (!map2.containsKey(str2)) {
                        }
                        y2Var = new y2(j22);
                        map2.put(str2, y2Var);
                        obj8.put(str2, Boolean.FALSE);
                        throw x2;
                    }
                }
            }
        }
    }

    public static <KeyProtoT extends com.google.android.gms.internal.firebase-auth-api.y> void m(com.google.android.gms.internal.firebase-auth-api.j2<KeyProtoT> j2, boolean z2) {
        ConcurrentMap map;
        boolean a3Var;
        Object obj4;
        final Class<com.google.android.gms.internal.firebase-auth-api.c3> obj5 = c3.class;
        final String str = j2.g();
        c3.r(str, j2.getClass(), j2.a().d(), true);
        map = c3.b;
        synchronized (obj5) {
            y2 y2Var = new y2(j2);
            map.put(str, y2Var);
            a3Var = new a3(j2);
            c3.c.put(str, a3Var);
            c3.s(str, j2.a().d());
            c3.d.put(str, Boolean.TRUE);
        }
    }

    public static <B, P> void n(com.google.android.gms.internal.firebase-auth-api.v2<B, P> v2) {
        boolean key;
        boolean equals;
        String name;
        final Class<com.google.android.gms.internal.firebase-auth-api.c3> obj = c3.class;
        synchronized (obj) {
            Class cls = v2.zzb();
            ConcurrentMap map = c3.e;
            if (map.containsKey(cls)) {
                key = map.get(cls);
                if (!v2.getClass().getName().equals((v2)key.getClass().getName())) {
                } else {
                }
                String valueOf = String.valueOf(cls);
                StringBuilder stringBuilder = new StringBuilder(length += 62);
                stringBuilder.append("Attempted overwrite of a registered PrimitiveWrapper for type ");
                stringBuilder.append(valueOf);
                c3.a.logp(Level.WARNING, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", stringBuilder.toString());
                Object[] arr = new Object[3];
                GeneralSecurityException generalSecurityException = new GeneralSecurityException(String.format("PrimitiveWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", cls.getName(), key.getClass().getName(), v2.getClass().getName()));
                throw generalSecurityException;
            }
            try {
                map.put(cls, v2);
                IllegalArgumentException obj8 = new IllegalArgumentException("wrapper must be non-null");
                throw obj8;
                throw v2;
            }
        }
    }

    private static <P> com.google.android.gms.internal.firebase-auth-api.b2<P> o(String string, Class<P> class2) {
        int str;
        Object next;
        com.google.android.gms.internal.firebase-auth-api.b3 obj6 = c3.p(string);
        if (class2 == null) {
            return obj6.zzb();
        }
        if (obj6.a().contains(class2)) {
            return obj6.c(class2);
        }
        String obj7 = class2.getName();
        String valueOf = String.valueOf(obj6.zzc());
        StringBuilder stringBuilder = new StringBuilder();
        obj6 = obj6.a().iterator();
        str = 1;
        while (obj6.hasNext()) {
            if (str == null) {
            }
            stringBuilder.append((Class)obj6.next().getCanonicalName());
            str = 0;
            stringBuilder.append(", ");
        }
        obj6 = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder(i2 += length3);
        stringBuilder2.append("Primitive type ");
        stringBuilder2.append(obj7);
        stringBuilder2.append(" not supported by key manager of type ");
        stringBuilder2.append(valueOf);
        stringBuilder2.append(", supported primitives: ");
        stringBuilder2.append(obj6);
        GeneralSecurityException generalSecurityException = new GeneralSecurityException(stringBuilder2.toString());
        throw generalSecurityException;
    }

    private static com.google.android.gms.internal.firebase-auth-api.b3 p(String string) {
        String obj4;
        final Class<com.google.android.gms.internal.firebase-auth-api.c3> obj = c3.class;
        ConcurrentMap map = c3.b;
        synchronized (obj) {
            obj4 = String.valueOf(string);
            String str = "No key manager found for key type ";
            if (obj4.length() != 0) {
                obj4 = str.concat(obj4);
            } else {
                try {
                    obj4 = new String(str);
                    GeneralSecurityException generalSecurityException = new GeneralSecurityException(obj4);
                    throw generalSecurityException;
                    return (b3)map.get(string);
                    throw string;
                }
            }
        }
    }

    private static <P> P q(String string, com.google.android.gms.internal.firebase-auth-api.wq wq2, Class<P> class3) {
        return c3.o(string, class3).c(wq2);
    }

    private static <KeyProtoT extends com.google.android.gms.internal.firebase-auth-api.y, KeyFormatProtoT extends com.google.android.gms.internal.firebase-auth-api.y> void r(String string, Class class2, Map<String, com.google.android.gms.internal.firebase-auth-api.g2<KeyFormatProtoT>> map3, boolean z4) {
        ConcurrentMap key;
        String concat;
        boolean equals;
        int length;
        Object obj5;
        Object obj6;
        boolean obj7;
        boolean obj8;
        final Class<com.google.android.gms.internal.firebase-auth-api.c3> obj = c3.class;
        key = c3.b;
        Object obj2 = key.get(string);
        synchronized (obj) {
            if (!(b3)obj2.zzc().equals(class2)) {
                String str = "Attempted overwrite of a registered key manager for key type ";
                if (string.length() != 0) {
                    try {
                        concat = str.concat(string);
                        length = new String(str);
                        concat = length;
                        c3.a.logp(Level.WARNING, "com.google.crypto.tink.Registry", "ensureKeyManagerInsertable", concat);
                        obj8 = new Object[3];
                        obj7 = new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", string, obj2.zzc().getName(), class2.getName()));
                        throw obj7;
                        obj6 = c3.d;
                        if (z4 && obj6.containsKey(string) && !(Boolean)obj6.get(string).booleanValue()) {
                        }
                        obj6 = c3.d;
                        if (obj6.containsKey(string)) {
                        }
                        if (!(Boolean)obj6.get(string).booleanValue()) {
                        }
                        obj7 = "New keys are already disallowed for key type ";
                        if (string.length() != 0) {
                        } else {
                        }
                        obj5 = obj7.concat(string);
                        obj5 = new String(obj7);
                        obj6 = new GeneralSecurityException(obj5);
                        throw obj6;
                        if (key.containsKey(string)) {
                        } else {
                        }
                        obj6 = map3.entrySet().iterator();
                        for (Map.Entry obj7 : obj6) {
                        }
                        obj7 = obj6.next();
                        if (!c3.f.containsKey((Map.Entry)obj7.getKey())) {
                        } else {
                        }
                        obj7 = obj7.getKey();
                        StringBuilder stringBuilder = new StringBuilder(obj8 += length2);
                        stringBuilder.append("Attempted to register a new key template ");
                        stringBuilder.append(obj7);
                        stringBuilder.append(" from an existing key manager of type ");
                        stringBuilder.append(string);
                        obj6 = new GeneralSecurityException(stringBuilder.toString());
                        throw obj6;
                        obj5 = map3.entrySet().iterator();
                        for (Map.Entry obj6 : obj5) {
                        }
                        obj6 = obj5.next();
                        if (c3.f.containsKey((Map.Entry)obj6.getKey())) {
                        } else {
                        }
                        obj6 = String.valueOf((String)obj6.getKey());
                        obj7 = "Attempted overwrite of a registered key template ";
                        if (obj6.length() != 0) {
                        } else {
                        }
                        obj6 = obj7.concat(obj6);
                        obj6 = new String(obj7);
                        obj5 = new GeneralSecurityException(obj6);
                        throw obj5;
                        throw string;
                    }
                } else {
                }
            }
        }
    }

    private static <KeyFormatProtoT extends com.google.android.gms.internal.firebase-auth-api.y> void s(String string, Map<String, com.google.android.gms.internal.firebase-auth-api.g2<KeyFormatProtoT>> map2) {
        com.google.android.gms.internal.firebase-auth-api.e2 e2Var;
        ConcurrentMap map;
        Object key;
        byte[] bArr;
        Iterator obj5 = map2.entrySet().iterator();
        for (Map.Entry next2 : obj5) {
            c3.f.put((String)next2.getKey(), e2.e(string, value2.a.k(), value.b));
        }
    }
}
