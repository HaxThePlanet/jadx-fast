package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008Â\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0008H\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0008R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ModuleNameRetriever {

    public static final kotlin.coroutines.jvm.internal.ModuleNameRetriever INSTANCE;
    private static kotlin.coroutines.jvm.internal.ModuleNameRetriever.Cache cache;
    private static final kotlin.coroutines.jvm.internal.ModuleNameRetriever.Cache notOnJava9;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u00020\u0001B#\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Cache {

        public final Method getDescriptorMethod;
        public final Method getModuleMethod;
        public final Method nameMethod;
        public Cache(Method getModuleMethod, Method getDescriptorMethod, Method nameMethod) {
            super();
            this.getModuleMethod = getModuleMethod;
            this.getDescriptorMethod = getDescriptorMethod;
            this.nameMethod = nameMethod;
        }
    }
    static {
        ModuleNameRetriever moduleNameRetriever = new ModuleNameRetriever();
        ModuleNameRetriever.INSTANCE = moduleNameRetriever;
        final int i = 0;
        ModuleNameRetriever.Cache cache = new ModuleNameRetriever.Cache(i, i, i);
        ModuleNameRetriever.notOnJava9 = cache;
    }

    private final kotlin.coroutines.jvm.internal.ModuleNameRetriever.Cache buildCache(kotlin.coroutines.jvm.internal.BaseContinuationImpl continuation) {
        int i = 0;
        ModuleNameRetriever.Cache cache2 = new ModuleNameRetriever.Cache(Class.class.getDeclaredMethod("getModule", new Class[i]), continuation.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[i]), continuation.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[i]));
        final int i3 = 0;
        ModuleNameRetriever.cache = cache2;
        return cache2;
    }

    public final String getModuleName(kotlin.coroutines.jvm.internal.BaseContinuationImpl continuation) {
        kotlin.coroutines.jvm.internal.ModuleNameRetriever.Cache cache;
        int invoke3;
        int i;
        Object invoke2;
        Class class;
        int invoke;
        Object[] arr;
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        if (ModuleNameRetriever.cache == null) {
            cache = buildCache(continuation);
        }
        i = 0;
        if (cache == ModuleNameRetriever.notOnJava9) {
            return i;
        }
        Method getModuleMethod = cache.getModuleMethod;
        int i2 = 0;
        if (getModuleMethod != null) {
            invoke3 = getModuleMethod.invoke(continuation.getClass(), new Object[i2]);
        } else {
            invoke3 = i;
        }
        if (invoke3 == 0) {
            return i;
        }
        Method getDescriptorMethod = cache.getDescriptorMethod;
        if (getDescriptorMethod != null) {
            invoke = getDescriptorMethod.invoke(invoke3, new Object[i2]);
        } else {
            invoke = i;
        }
        if (invoke == 0) {
            return i;
        }
        Method nameMethod = cache.nameMethod;
        if (nameMethod != null) {
            invoke2 = nameMethod.invoke(invoke, new Object[i2]);
        } else {
            invoke2 = i;
        }
        if (invoke2 instanceof String != null) {
            i = invoke2;
        }
        return i;
    }
}
