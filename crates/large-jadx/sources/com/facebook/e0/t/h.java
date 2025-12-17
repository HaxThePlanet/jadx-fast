package com.facebook.e0.t;

import com.facebook.internal.g0.i.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0006\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007JC\u0010\u0007\u001a\u0004\u0018\u00010\u00082\n\u0010\t\u001a\u0006\u0012\u0002\u0008\u00030\u00042\u0006\u0010\n\u001a\u00020\u00062\u001e\u0010\u000b\u001a\u0010\u0012\u000c\u0008\u0001\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00040\u000c\"\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\rJE\u0010\u000e\u001a\u0004\u0018\u00010\u00012\n\u0010\t\u001a\u0006\u0012\u0002\u0008\u00030\u00042\u0006\u0010\u000f\u001a\u00020\u00082\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u000b\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00010\u000c\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012", d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseUtils;", "", "()V", "getClass", "Ljava/lang/Class;", "className", "", "getMethod", "Ljava/lang/reflect/Method;", "clazz", "methodName", "args", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "invokeMethod", "method", "obj", "(Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class h {
    static {
    }

    public static final Class<?> a(String string) {
        if (a.d(h.class)) {
            return 0;
        }
        n.f(string, "className");
        return Class.forName(string);
    }

    public static final Method b(Class<?> class, String string2, Class<?>... class3Arr3) {
        if (a.d(h.class)) {
            return null;
        }
        n.f(class, "clazz");
        n.f(string2, "methodName");
        n.f(class3Arr3, "args");
        return class.getMethod(string2, (Class[])Arrays.copyOf(class3Arr3, class3Arr3.length));
    }

    public static final Object c(Class<?> class, Method method2, Object object3, Object... object4Arr4) {
        Object obj5;
        if (a.d(h.class)) {
            return null;
        }
        n.f(class, "clazz");
        n.f(method2, "method");
        n.f(object4Arr4, "args");
        if (object3 != null) {
            obj5 = class.cast(object3);
        }
        return method2.invoke(obj5, Arrays.copyOf(object4Arr4, object4Arr4.length));
    }
}
