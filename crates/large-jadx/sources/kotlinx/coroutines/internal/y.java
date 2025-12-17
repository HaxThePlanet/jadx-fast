package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.b0.k.a.e;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.o;
import kotlin.p;
import kotlin.q;
import kotlin.u;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0008\u001a\u0014\u0010\u0006\u001a\u00060\u0007j\u0002`\u00082\u0006\u0010\t\u001a\u00020\u0001H\u0007\u001a9\u0010\n\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c2\u0006\u0010\r\u001a\u0002H\u000b2\u0006\u0010\u000e\u001a\u0002H\u000b2\u0010\u0010\u000f\u001a\u000c\u0012\u0008\u0012\u00060\u0007j\u0002`\u00080\u0010H\u0002¢\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0012\u001a\u000c\u0012\u0008\u0012\u00060\u0007j\u0002`\u00080\u00102\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002\u001a1\u0010\u0016\u001a\u00020\u00172\u0010\u0010\u0018\u001a\u000c\u0012\u0008\u0012\u00060\u0007j\u0002`\u00080\u00192\u0010\u0010\u000e\u001a\u000c\u0012\u0008\u0012\u00060\u0007j\u0002`\u00080\u0010H\u0002¢\u0006\u0002\u0010\u001a\u001a\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000cH\u0080Hø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a+\u0010\u001f\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c2\u0006\u0010\u001d\u001a\u0002H\u000b2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002¢\u0006\u0002\u0010 \u001a\u001f\u0010!\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\"\u001a,\u0010!\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c2\u0006\u0010\u001d\u001a\u0002H\u000b2\n\u0010\u0013\u001a\u0006\u0012\u0002\u0008\u00030#H\u0080\u0008¢\u0006\u0002\u0010$\u001a!\u0010%\u001a\u0004\u0018\u0001H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0002¢\u0006\u0002\u0010\"\u001a \u0010&\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0080\u0008¢\u0006\u0002\u0010\"\u001a\u001f\u0010'\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\"\u001a1\u0010(\u001a\u0018\u0012\u0004\u0012\u0002H\u000b\u0012\u000e\u0012\u000c\u0012\u0008\u0012\u00060\u0007j\u0002`\u00080\u00190)\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c*\u0002H\u000bH\u0002¢\u0006\u0002\u0010*\u001a\u001c\u0010+\u001a\u00020,*\u00060\u0007j\u0002`\u00082\n\u0010-\u001a\u00060\u0007j\u0002`\u0008H\u0002\u001a#\u0010.\u001a\u00020/*\u000c\u0012\u0008\u0012\u00060\u0007j\u0002`\u00080\u00192\u0006\u00100\u001a\u00020\u0001H\u0002¢\u0006\u0002\u00101\u001a\u0014\u00102\u001a\u00020\u0017*\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cH\u0000\u001a\u0010\u00103\u001a\u00020,*\u00060\u0007j\u0002`\u0008H\u0000\u001a\u001b\u00104\u001a\u0002H\u000b\"\u0008\u0008\u0000\u0010\u000b*\u00020\u000c*\u0002H\u000bH\u0002¢\u0006\u0002\u0010\"\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000*\u000c\u0008\u0000\u00105\"\u00020\u00142\u00020\u0014*\u000c\u0008\u0000\u00106\"\u00020\u00072\u00020\u0007\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00067", d2 = {"baseContinuationImplClass", "", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "stackTraceRecoveryClass", "stackTraceRecoveryClassName", "artificialFrame", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "message", "createFinalException", "E", "", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "createStackTrace", "continuation", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "mergeRecoveredTraces", "", "recoveredStacktrace", "", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "exception", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "tryCopyAndVerify", "unwrap", "unwrapImpl", "causeAndStacktrace", "Lkotlin/Pair;", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "elementWiseEquals", "", "e", "frameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "initCause", "isArtificial", "sanitizeStackTrace", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class y {

    private static final String a;
    static {
        String canonicalName;
        String canonicalName2;
        kotlin.p.a aVar;
        Throwable th;
        try {
            kotlin.p.a aVar2 = p.a;
            p.a(Class.forName("kotlin.b0.k.a.a").getCanonicalName());
            aVar = p.a;
            Throwable th2 = q.a(th2);
            p.a(th2);
            if (p.c(canonicalName) == null) {
            } else {
            }
            canonicalName = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
            y.a = (String)canonicalName;
            kotlin.p.a aVar3 = p.a;
            p.a(Class.forName("kotlinx.coroutines.internal.y").getCanonicalName());
            aVar = p.a;
            th2 = q.a(th2);
            p.a(th2);
            if (p.c(canonicalName2) == null) {
            } else {
            }
            canonicalName2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        } catch (Throwable th) {
        }
    }

    public static final Throwable a(Throwable throwable, e e2) {
        return y.j(throwable, e2);
    }

    public static final java.lang.StackTraceElement b(String string) {
        String str2 = "\u0008";
        StackTraceElement stackTraceElement = new StackTraceElement(n.o("\u0008\u0008\u0008(", string), str2, str2, -1);
        return stackTraceElement;
    }

    private static final <E extends Throwable> o<E, java.lang.StackTraceElement[]> c(E e) {
        java.lang.StackTraceElement[] cause;
        boolean stackTrace;
        Class class;
        int i;
        boolean z;
        o obj6;
        cause = e.getCause();
        final int i2 = 0;
        if (cause != null && n.b(cause.getClass(), e.getClass())) {
            if (n.b(cause.getClass(), e.getClass())) {
                stackTrace = e.getStackTrace();
                i = i2;
                while (i < stackTrace.length) {
                    i++;
                }
                class = i2;
                if (class != null) {
                    obj6 = u.a(cause, stackTrace);
                } else {
                    obj6 = u.a(e, new StackTraceElement[i2]);
                }
            } else {
                obj6 = u.a(e, new StackTraceElement[i2]);
            }
        } else {
        }
        return obj6;
    }

    private static final <E extends Throwable> E d(E e, E e2, ArrayDeque<java.lang.StackTraceElement> arrayDeque3) {
        int i;
        int next;
        int i2;
        java.lang.StackTraceElement stack;
        int obj8;
        arrayDeque3.addFirst(y.b("Coroutine boundary"));
        java.lang.StackTraceElement[] obj6 = e.getStackTrace();
        int i3 = y.g(obj6, y.a);
        i = 0;
        if (i3 == -1) {
            obj6 = arrayDeque3.toArray(new StackTraceElement[i]);
            Objects.requireNonNull(obj6, "null cannot be cast to non-null type kotlin.Array<T>");
            e2.setStackTrace((StackTraceElement[])obj6);
            return e2;
        }
        java.lang.StackTraceElement[] arr = new StackTraceElement[size += i3];
        if (i3 > 0) {
            next = i;
            i2 = next + 1;
            arr[next] = obj6[next];
            while (i2 >= i3) {
                next = i2;
                i2 = next + 1;
                arr[next] = obj6[next];
            }
        }
        obj6 = arrayDeque3.iterator();
        for (StackTraceElement next : obj6) {
            arr[i += i3] = next;
            i = obj8;
        }
        e2.setStackTrace(arr);
        return e2;
    }

    private static final ArrayDeque<java.lang.StackTraceElement> e(e e) {
        java.lang.StackTraceElement stackTraceElement;
        int i;
        Object obj3;
        ArrayDeque arrayDeque = new ArrayDeque();
        stackTraceElement = e.getStackTraceElement();
        if (stackTraceElement == null) {
        } else {
            arrayDeque.add(stackTraceElement);
        }
        i = 0;
        while (obj3 instanceof e) {
            if (obj3 == null) {
            } else {
            }
            obj3 = obj3.getCallerFrame();
            if (obj3 != null) {
            }
            stackTraceElement = obj3.getStackTraceElement();
            if (stackTraceElement == null) {
            } else {
            }
            arrayDeque.add(stackTraceElement);
            i = 0;
            obj3 = i;
            obj3 = i;
        }
        return arrayDeque;
    }

    private static final boolean f(java.lang.StackTraceElement stackTraceElement, java.lang.StackTraceElement stackTraceElement2) {
        int lineNumber;
        int lineNumber2;
        boolean obj2;
        String obj3;
        if (stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && n.b(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && n.b(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) != null && n.b(stackTraceElement.getClassName(), stackTraceElement2.getClassName())) {
            if (n.b(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName())) {
                if (n.b(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) != null) {
                    obj2 = n.b(stackTraceElement.getClassName(), stackTraceElement2.getClassName()) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    private static final int g(java.lang.StackTraceElement[] stackTraceElementArr, String string2) {
        int i;
        boolean z;
        i = 0;
        while (i < stackTraceElementArr.length) {
            i++;
        }
        i = -1;
        return i;
    }

    public static final boolean h(java.lang.StackTraceElement stackTraceElement) {
        return l.M(stackTraceElement.getClassName(), "\u0008\u0008\u0008", false, 2, 0);
    }

    private static final void i(java.lang.StackTraceElement[] stackTraceElementArr, ArrayDeque<java.lang.StackTraceElement> arrayDeque2) {
        int i;
        int i2;
        boolean z;
        Object obj;
        Object last;
        i2 = 0;
        while (i2 < stackTraceElementArr.length) {
            i2++;
        }
        i2 = -1;
        i2++;
        if (i3 <= length2--) {
        }
    }

    private static final <E extends Throwable> E j(E e, e e2) {
        o oVar = y.c(e);
        final Object obj2 = oVar.a();
        final Throwable th = y.k((Throwable)obj2);
        if (th == null) {
            return e;
        }
        final ArrayDeque obj5 = y.e(e2);
        if (obj5.isEmpty()) {
            return e;
        }
        if (obj2 != e) {
            y.i((StackTraceElement[])oVar.b(), obj5);
        }
        y.d(obj2, th, obj5);
        return th;
    }

    private static final <E extends Throwable> E k(E e) {
        boolean message;
        Throwable obj3;
        final Throwable th = i.e(e);
        final int i = 0;
        if (th == null) {
            return i;
        }
        if (!e instanceof f0 && !n.b(th.getMessage(), e.getMessage())) {
            if (!n.b(th.getMessage(), e.getMessage())) {
                return i;
            }
        }
        return th;
    }

    public static final <E extends Throwable> E l(E e) {
        java.lang.StackTraceElement[] stackTrace;
        int length;
        int i;
        int i2;
        boolean z;
        final Throwable cause = e.getCause();
        if (cause != null) {
            if (!n.b(cause.getClass(), e.getClass())) {
            } else {
                stackTrace = e.getStackTrace();
                i2 = i;
                while (i2 < stackTrace.length) {
                    if (y.h(stackTrace[i2])) {
                        break;
                    } else {
                    }
                    i2++;
                }
                if (i != 0) {
                    return cause;
                }
            }
        }
        return e;
    }
}
