package kotlin.b0.k.a;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008Â\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0008H\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0008R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
final class i {

    private static final kotlin.b0.k.a.i.a a;
    private static kotlin.b0.k.a.i.a b;
    public static final kotlin.b0.k.a.i c;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u00020\u0001B#\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    private static final class a {

        public final Method a;
        public final Method b;
        public final Method c;
        public a(Method method, Method method2, Method method3) {
            super();
            this.a = method;
            this.b = method2;
            this.c = method3;
        }
    }
    static {
        i iVar = new i();
        i.c = iVar;
        final int i = 0;
        i.a aVar = new i.a(i, i, i);
        i.a = aVar;
    }

    private final kotlin.b0.k.a.i.a a(kotlin.b0.k.a.a a) {
        try {
            int i = 0;
            i.a aVar = new i.a(Class.class.getDeclaredMethod("getModule", new Class[i]), a.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[i]), a.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[i]));
            i.b = aVar;
            return aVar;
            a = i.a;
            i.b = a;
            return a;
        }
    }

    public final String b(kotlin.b0.k.a.a a) {
        kotlin.b0.k.a.i.a aVar;
        Method arr2;
        int i;
        int i2;
        Object[] arr;
        int obj6;
        n.f(a, "continuation");
        if (i.b != null) {
        } else {
            aVar = a(a);
        }
        i = 0;
        if (aVar == i.a) {
            return i;
        }
        arr2 = aVar.a;
        i2 = 0;
        obj6 = arr2.invoke(a.getClass(), new Object[i2]);
        arr2 = aVar.b;
        obj6 = arr2.invoke(obj6, new Object[i2]);
        if (arr2 != null && obj6 != null && arr2 != null && obj6 != null) {
            i2 = 0;
            obj6 = arr2.invoke(a.getClass(), new Object[i2]);
            if (obj6 != null) {
                arr2 = aVar.b;
                if (arr2 != null) {
                    obj6 = arr2.invoke(obj6, new Object[i2]);
                    if (obj6 != null) {
                        Method method = aVar.c;
                        if (method != null) {
                            obj6 = method.invoke(obj6, new Object[i2]);
                        } else {
                            obj6 = i;
                        }
                        if (obj6 instanceof String == null) {
                        } else {
                            i = obj6;
                        }
                    }
                }
            }
        }
        return i;
    }
}
