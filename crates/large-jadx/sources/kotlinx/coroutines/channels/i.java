package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0003\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0087@\u0018\u0000 %*\u0006\u0008\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003$%&B\u0016\u0008\u0001\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0010\u001a\u00020\t2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\u0008\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\u0008\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\u0008\u0019\u0010\u0005J\r\u0010\u001a\u001a\u00028\u0000¢\u0006\u0004\u0008\u001b\u0010\u0005J\u0010\u0010\u001c\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020!H\u0016¢\u0006\u0004\u0008\"\u0010#R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0008\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u000b\u0088\u0001\u0003\u0092\u0001\u0004\u0018\u00010\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006'", d2 = {"Lkotlinx/coroutines/channels/ChannelResult;", "T", "", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getHolder$annotations", "()V", "isClosed", "", "isClosed-impl", "(Ljava/lang/Object;)Z", "isFailure", "isFailure-impl", "isSuccess", "isSuccess-impl", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "getOrThrow", "getOrThrow-impl", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Closed", "Companion", "Failed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i<T>  {

    public static final kotlinx.coroutines.channels.i.b b;
    private static final kotlinx.coroutines.channels.i.c c;
    private final Object a;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0002\u0008\n\u0008\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\u0008\u0001\u0010\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ$\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\u0008\u0001\u0010\u0007H\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ,\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\u0008\u0001\u0010\u00072\u0006\u0010\u0010\u001a\u0002H\u0007H\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\u0008\u0019\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0013", d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Companion;", "", "()V", "failed", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "closed", "Lkotlinx/coroutines/channels/ChannelResult;", "E", "cause", "", "closed-JP2dKIU", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "failure", "failure-PtdJZtk", "()Ljava/lang/Object;", "success", "value", "success-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {
        public b(g g) {
            super();
        }

        public final <E> Object a(Throwable throwable) {
            i.a aVar = new i.a(throwable);
            i.c(aVar);
            return aVar;
        }

        public final <E> Object b() {
            final kotlinx.coroutines.channels.i.c cVar = i.a();
            i.c(cVar);
            return cVar;
        }

        public final <E> Object c(E e) {
            i.c(e);
            return e;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005", d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Failed;", "", "()V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0096\u0002J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Closed;", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "cause", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends kotlinx.coroutines.channels.i.c {

        public final Throwable a;
        public a(Throwable throwable) {
            super();
            this.a = throwable;
        }

        @Override // kotlinx.coroutines.channels.i$c
        public boolean equals(Object object) {
            boolean z;
            Object obj2;
            if (object instanceof i.a && n.b(this.a, object.a)) {
                obj2 = n.b(this.a, object.a) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // kotlinx.coroutines.channels.i$c
        public int hashCode() {
            int i;
            Throwable th = this.a;
            if (th != null) {
                i = th.hashCode();
            } else {
                i = 0;
            }
            return i;
        }

        @Override // kotlinx.coroutines.channels.i$c
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Closed(");
            stringBuilder.append(this.a);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    static {
        i.b bVar = new i.b(0);
        i.b = bVar;
        i.c cVar = new i.c();
        i.c = cVar;
    }

    private i(Object object) {
        super();
        this.a = object;
    }

    public static final kotlinx.coroutines.channels.i.c a() {
        return i.c;
    }

    public static final kotlinx.coroutines.channels.i b(Object object) {
        i iVar = new i(object);
        return iVar;
    }

    public static <T> Object c(Object object) {
        return object;
    }

    public static boolean d(Object object, Object object2) {
        final int i = 0;
        if (!object2 instanceof i) {
            return i;
        }
        if (!n.b(object, (i)object2.k())) {
            return i;
        }
        return 1;
    }

    public static final Throwable e(Object object) {
        Throwable i;
        Object obj2;
        if (object instanceof i.a) {
        } else {
            obj2 = i;
        }
        if (obj2 == null) {
        } else {
            i = obj2.a;
        }
        return i;
    }

    public static final T f(Object object) {
        boolean th;
        if (!object instanceof i.c) {
            return object;
        }
        if (!object instanceof i.a) {
        } else {
            th = obj.a;
            if (th != null) {
                throw th;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException(n.o("Trying to call 'getOrThrow' on a failed channel result: ", object).toString());
        throw illegalStateException;
    }

    public static int g(Object object) {
        int obj0;
        if (object == null) {
            obj0 = 0;
        } else {
            obj0 = object.hashCode();
        }
        return obj0;
    }

    public static final boolean h(Object object) {
        return object instanceof i.a;
    }

    public static final boolean i(Object object) {
        return obj0 ^= 1;
    }

    public static String j(Object object) {
        boolean stringBuilder;
        String str;
        String obj2;
        if (object instanceof i.a) {
            obj2 = object.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Value(");
            stringBuilder.append(object);
            stringBuilder.append(')');
            obj2 = stringBuilder.toString();
        }
        return obj2;
    }

    public boolean equals(Object object) {
        return i.d(this.a, object);
    }

    public int hashCode() {
        return i.g(this.a);
    }

    public final Object k() {
        return this.a;
    }

    public String toString() {
        return i.j(this.a);
    }
}
