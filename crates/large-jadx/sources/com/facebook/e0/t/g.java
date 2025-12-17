package com.facebook.e0.t;

import com.facebook.internal.g0.i.a;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B=\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0008\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ$\u0010\r\u001a\u0004\u0018\u00010\u00012\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0010\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0011R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0013", d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;", "", "skuDetailsParamsClazz", "Ljava/lang/Class;", "builderClazz", "newBuilderMethod", "Ljava/lang/reflect/Method;", "setTypeMethod", "setSkusListMethod", "buildMethod", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getSkuDetailsParamsClazz", "()Ljava/lang/Class;", "getSkuDetailsParams", "skuType", "", "skuIDs", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class g {

    private static com.facebook.e0.t.g g;
    private static final AtomicBoolean h;
    public static final com.facebook.e0.t.g.a i;
    private final Class<?> a;
    private final Class<?> b;
    private final Method c;
    private final Method d;
    private final Method e;
    private final Method f;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000e\u001a\u00020\u000fH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper$Companion;", "", "()V", "CLASSNAME_SKU_DETAILS_PARAMS", "", "CLASSNAME_SKU_DETAILS_PARAMS_BUILDER", "METHOD_BUILD", "METHOD_NEW_BUILDER", "METHOD_SET_SKU_LIST", "METHOD_SET_TYPE", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "instance", "Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;", "createInstance", "", "getOrCreateInstance", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        private final void a() {
            Object gVar;
            Object str;
            Method method2;
            Method method3;
            Method method4;
            Method method;
            final Class cls = h.a("com.android.billingclient.api.SkuDetailsParams");
            final Class cls2 = h.a("com.android.billingclient.api.SkuDetailsParams$Builder");
            if (cls != null) {
                if (cls2 == null) {
                } else {
                    int i = 0;
                    method2 = h.b(cls, "newBuilder", new Class[i]);
                    int i2 = 1;
                    Class[] arr3 = new Class[i2];
                    arr3[i] = String.class;
                    method3 = h.b(cls2, "setType", arr3);
                    Class[] arr2 = new Class[i2];
                    arr2[i] = List.class;
                    method4 = h.b(cls2, "setSkusList", arr2);
                    method = h.b(cls2, "build", new Class[i]);
                    if (method2 != null && method3 != null && method4 != null) {
                        if (method3 != null) {
                            if (method4 != null) {
                                if (method == null) {
                                } else {
                                    super(cls, cls2, method2, method3, method4, method);
                                    g.c(gVar);
                                }
                            }
                        }
                    }
                }
            }
        }

        public final com.facebook.e0.t.g b() {
            if (g.a().get()) {
                return g.b();
            }
            a();
            g.a().set(true);
            return g.b();
        }
    }
    static {
        g.a aVar = new g.a(0);
        g.i = aVar;
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        g.h = atomicBoolean;
    }

    public g(Class<?> class, Class<?> class2, Method method3, Method method4, Method method5, Method method6) {
        n.f(class, "skuDetailsParamsClazz");
        n.f(class2, "builderClazz");
        n.f(method3, "newBuilderMethod");
        n.f(method4, "setTypeMethod");
        n.f(method5, "setSkusListMethod");
        n.f(method6, "buildMethod");
        super();
        this.a = class;
        this.b = class2;
        this.c = method3;
        this.d = method4;
        this.e = method5;
        this.f = method6;
    }

    public static final AtomicBoolean a() {
        if (a.d(g.class)) {
            return null;
        }
        return g.h;
    }

    public static final com.facebook.e0.t.g b() {
        if (a.d(g.class)) {
            return null;
        }
        return g.g;
    }

    public static final void c(com.facebook.e0.t.g g) {
        if (a.d(g.class)) {
        }
        g.g = g;
    }

    public final Object d(String string, List<String> list2) {
        Object obj;
        int i2;
        Method arr3;
        Object[] arr;
        int i;
        Object[] arr2;
        Object obj8;
        Object obj9;
        i2 = 0;
        if (a.d(this)) {
            return i2;
        }
        final int i3 = 0;
        obj = h.c(this.a, this.c, i2, new Object[i3]);
        i = 1;
        arr2 = new Object[i];
        arr2[i3] = string;
        obj8 = h.c(this.b, this.d, obj, arr2);
        if (obj != null && obj8 == null) {
            i = 1;
            arr2 = new Object[i];
            arr2[i3] = string;
            obj8 = h.c(this.b, this.d, obj, arr2);
            if (obj8 == null) {
                return i2;
            }
            arr = new Object[i];
            arr[i3] = list2;
            obj8 = h.c(this.b, this.e, obj8, arr);
            if (obj8 == null) {
            } else {
                i2 = h.c(this.b, this.f, obj8, new Object[i3]);
            }
        }
        try {
            return i2;
            a.b(string, this);
            return obj1;
        }
    }

    public final Class<?> e() {
        if (a.d(this)) {
            return 0;
        }
        return this.a;
    }
}
