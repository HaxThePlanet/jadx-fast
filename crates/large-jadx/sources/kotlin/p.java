package kotlin;

import java.io.Serializable;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0003\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008\u0087@\u0018\u0000 \"*\u0006\u0008\u0000\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0002\"#B\u0016\u0008\u0001\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0004\u0008\u0006\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\t2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\u0008\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00018\u0000H\u0087\u0008¢\u0006\u0004\u0008\u0019\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001fH\u0016¢\u0006\u0004\u0008 \u0010!R\u0011\u0010\u0008\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000e\u0010\u000f\u0088\u0001\u0004\u0092\u0001\u0004\u0018\u00010\u0005ø\u0001\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006$", d2 = {"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isSuccess-impl", "getValue$annotations", "()V", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class p<T>  implements Serializable {

    public static final kotlin.p.a a;
    private final Object value;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0008J%\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0001\u0010\u00052\u0006\u0010\n\u001a\u0002H\u0005H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000c", d2 = {"Lkotlin/Result$Companion;", "", "()V", "failure", "Lkotlin/Result;", "T", "exception", "", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "success", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0096\u0002J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0008\u0010\u000c\u001a\u00020\rH\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class b implements Serializable {

        public final Throwable exception;
        public b(Throwable throwable) {
            n.f(throwable, "exception");
            super();
            this.exception = throwable;
        }

        @Override // java.io.Serializable
        public boolean equals(Object object) {
            boolean exception;
            Object obj2;
            if (object instanceof p.b && n.b(this.exception, object.exception)) {
                obj2 = n.b(this.exception, object.exception) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // java.io.Serializable
        public int hashCode() {
            return this.exception.hashCode();
        }

        @Override // java.io.Serializable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failure(");
            stringBuilder.append(this.exception);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    static {
        p.a aVar = new p.a(0);
        p.a = aVar;
    }

    public static Object a(Object object) {
        return object;
    }

    public static boolean b(Object object, Object object2) {
        Object obj1;
        Object obj2;
        if (object2 instanceof p && n.b(object, (p)object2.h())) {
            if (n.b(object, (p)object2.h())) {
                return 1;
            }
        }
        return 0;
    }

    public static final Throwable c(Object object) {
        Throwable obj1;
        obj1 = object instanceof p.b ? object.exception : 0;
        return obj1;
    }

    public static int d(Object object) {
        int obj0;
        if (object != null) {
            obj0 = object.hashCode();
        } else {
            obj0 = 0;
        }
        return obj0;
    }

    public static final boolean e(Object object) {
        return object instanceof p.b;
    }

    public static final boolean f(Object object) {
        return obj0 ^= 1;
    }

    public static String g(Object object) {
        boolean stringBuilder;
        String str;
        String obj2;
        if (object instanceof p.b) {
            obj2 = object.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Success(");
            stringBuilder.append(object);
            stringBuilder.append(')');
            obj2 = stringBuilder.toString();
        }
        return obj2;
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        return p.b(this.value, object);
    }

    @Override // java.io.Serializable
    public final Object h() {
        return this.value;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        return p.d(this.value);
    }

    @Override // java.io.Serializable
    public String toString() {
        return p.g(this.value);
    }
}
