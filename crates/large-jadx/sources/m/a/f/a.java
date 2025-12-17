package m.a.f;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.d0.a;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.i0.d;
import kotlin.k0.l;
import kotlin.m;
import kotlin.y.p;
import m.a.c.d.b;
import m.a.c.d.c;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u000cJ\u0012\u0010\r\u001a\u00020\u000c2\n\u0010\u000e\u001a\u0006\u0012\u0002\u0008\u00030\u000fJ\u0012\u0010\u0010\u001a\u00020\u000c2\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013J\u001e\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u00170\u0015\"\u0004\u0008\u0000\u0010\u0016\"\u0004\u0008\u0001\u0010\u0017J'\u0010\u0018\u001a\u0002H\u0019\"\u0004\u0008\u0000\u0010\u00192\u0006\u0010\u001a\u001a\u00020\u00012\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u0002H\u00190\u001c¢\u0006\u0002\u0010\u001d¨\u0006\u001e", d2 = {"Lorg/koin/mp/KoinPlatformTools;", "", "()V", "defaultContext", "Lorg/koin/core/context/KoinContext;", "defaultLazyMode", "Lkotlin/LazyThreadSafetyMode;", "defaultLogger", "Lorg/koin/core/logger/Logger;", "level", "Lorg/koin/core/logger/Level;", "generateId", "", "getClassName", "kClass", "Lkotlin/reflect/KClass;", "getStackTrace", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "safeHashMap", "", "K", "V", "synchronized", "R", "lock", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a {

    public static final m.a.f.a a;
    static {
        a aVar = new a();
        a.a = aVar;
    }

    public final c a() {
        return b.a;
    }

    public final m b() {
        return m.SYNCHRONIZED;
    }

    public final String c(d<?> d) {
        n.f(d, "kClass");
        String obj2 = a.b(d).getName();
        n.e(obj2, "kClass.java.name");
        return obj2;
    }

    public final String d(Exception exception) {
        int i2;
        java.lang.StackTraceElement stack;
        int i3;
        int i;
        int i4;
        String str;
        n.f(exception, "e");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(exception);
        stringBuilder.append("\n\t");
        java.lang.StackTraceElement[] obj12 = exception.getStackTrace();
        n.e(obj12, "e.stackTrace");
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        i2 = i5;
        while (i2 < obj12.length) {
            stack = obj12[i2];
            String className = stack.getClassName();
            n.e(className, "it.className");
            if (z ^= 1 == 0) {
                break;
            } else {
            }
            arrayList.add(stack);
            i2++;
        }
        stringBuilder.append(p.h0(arrayList, "\n\t", 0, 0, 0, 0, 0, 62, 0));
        return stringBuilder.toString();
    }

    public final <K, V> Map<K, V> e() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        return concurrentHashMap;
    }

    public final <R> R f(Object object, a<? extends R> a2) {
        n.f(object, "lock");
        n.f(a2, "block");
        return a2.invoke();
        synchronized (object) {
            n.f(object, "lock");
            n.f(a2, "block");
            return a2.invoke();
        }
    }
}
