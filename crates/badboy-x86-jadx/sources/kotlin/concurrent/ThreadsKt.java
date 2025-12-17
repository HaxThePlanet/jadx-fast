package kotlin.concurrent;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aJ\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c\u001a3\u0010\u000e\u001a\u0002H\u000f\"\u0008\u0008\u0000\u0010\u000f*\u00020\u0010*\u0008\u0012\u0004\u0012\u0002H\u000f0\u00112\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u000f0\u000cH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0014", d2 = {"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", "priority", "", "block", "Lkotlin/Function0;", "", "getOrSet", "T", "", "Ljava/lang/ThreadLocal;", "default", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ThreadsKt {
    private static final <T> T getOrSet(java.lang.ThreadLocal<T> $this$getOrSet, Function0<? extends T> default) {
        Object invoke;
        Object obj;
        int i;
        Intrinsics.checkNotNullParameter($this$getOrSet, "<this>");
        Intrinsics.checkNotNullParameter(default, "default");
        if ($this$getOrSet.get() == null) {
            i = 0;
            $this$getOrSet.set(default.invoke());
        }
        return invoke;
    }

    public static final Thread thread(boolean start, boolean isDaemon, java.lang.ClassLoader contextClassLoader, String name, int priority, Function0<Unit> block) {
        int i;
        Intrinsics.checkNotNullParameter(block, "block");
        ThreadsKt.thread.thread.1 anon = new ThreadsKt.thread.thread.1(block);
        if (isDaemon) {
            anon.setDaemon(true);
        }
        if (priority > 0) {
            anon.setPriority(priority);
        }
        if (name != null) {
            anon.setName(name);
        }
        if (contextClassLoader != null) {
            anon.setContextClassLoader(contextClassLoader);
        }
        if (start) {
            anon.start();
        }
        return (Thread)anon;
    }

    public static Thread thread$default(boolean z, boolean z2, java.lang.ClassLoader classLoader3, String string4, int i5, Function0 function06, int i7, Object object8) {
        int obj1;
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        if (i7 & 1 != 0) {
            obj1 = 1;
        }
        if (i7 & 2 != 0) {
            obj2 = 0;
        }
        final int i = 0;
        if (i7 & 4 != 0) {
            obj3 = i;
        }
        if (i7 & 8 != 0) {
            obj4 = i;
        }
        if (i7 &= 16 != 0) {
            obj5 = -1;
        }
        return ThreadsKt.thread(obj1, obj2, obj3, obj4, obj5, function06);
    }
}
