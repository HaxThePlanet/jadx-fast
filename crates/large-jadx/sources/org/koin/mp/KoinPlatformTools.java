package m.a.f;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.i0.d;
import kotlin.k0.l;
import kotlin.m;
import kotlin.y.p;
import m.a.c.d.b;
import m.a.c.d.c;

/* compiled from: PlatformToolsJVM.kt */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u000cJ\u0012\u0010\r\u001a\u00020\u000c2\n\u0010\u000e\u001a\u0006\u0012\u0002\u0008\u00030\u000fJ\u0012\u0010\u0010\u001a\u00020\u000c2\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013J\u001e\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u00170\u0015\"\u0004\u0008\u0000\u0010\u0016\"\u0004\u0008\u0001\u0010\u0017J'\u0010\u0018\u001a\u0002H\u0019\"\u0004\u0008\u0000\u0010\u00192\u0006\u0010\u001a\u001a\u00020\u00012\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u0002H\u00190\u001c¢\u0006\u0002\u0010\u001d¨\u0006\u001e", d2 = {"Lorg/koin/mp/KoinPlatformTools;", "", "()V", "defaultContext", "Lorg/koin/core/context/KoinContext;", "defaultLazyMode", "Lkotlin/LazyThreadSafetyMode;", "defaultLogger", "Lorg/koin/core/logger/Logger;", "level", "Lorg/koin/core/logger/Level;", "generateId", "", "getClassName", "kClass", "Lkotlin/reflect/KClass;", "getStackTrace", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "safeHashMap", "", "K", "V", "synchronized", "R", "lock", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
/* renamed from: a, reason: from kotlin metadata */
public final class KoinPlatformTools {

    public static final a a = new a();
    private a() {
        super();
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final c defaultContext() {
        return GlobalContext.a;
    }

    public final m b() {
        return LazyThreadSafetyMode.SYNCHRONIZED;
    }

    /* renamed from: c, reason: from kotlin metadata */
    public final String defaultLogger(d<?> level) {
        n.f(level, "kClass");
        String name = a.b(level).getName();
        n.e(name, "kClass.java.name");
        return name;
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final String getClassName(Exception kClass) {
        int i;
        Object obj;
        int i2;
        int i3 = 2;
        Object obj2 = null;
        java.lang.CharSequence charSequence;
        n.f(kClass, "e");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(kClass);
        stringBuilder.append("\n\t");
        java.lang.StackTraceElement[] stackTrace = kClass.getStackTrace();
        n.e(stackTrace, "e.stackTrace");
        final ArrayList arrayList = new ArrayList();
        boolean z = false;
        i = z;
        for (java.lang.StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            n.e(className, "it.className");
            i3 = 2;
            obj2 = null;
            i2 = !(v.R(className, "sun.reflect", z, i3, obj2));
            if (!l.R(className, "sun.reflect", z, 2, null) == 0) {
                break;
            }
        }
        stringBuilder.append(z.h0(arrayList, "\n\t", 0, 0, 0, 0, 0, 62, 0));
        return stringBuilder.toString();
    }

    public final <K, V> Map<K, V> e() {
        return new ConcurrentHashMap();
    }

    /* renamed from: f, reason: from kotlin metadata */
    public final <R> R synchronized(Object lock, kotlin.d0.c.a<? extends R> block) {
        n.f(lock, "lock");
        n.f(block, "block");
        synchronized (lock) {
            return block.invoke();
        }
    }

}
