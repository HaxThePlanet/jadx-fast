package i.b.m0.j;

import i.b.y;
import java.io.Serializable;
import m.c.c;

/* compiled from: NotificationLite.java */
/* loaded from: classes3.dex */
public enum n {

    COMPLETE;

    static final class a implements Serializable {

        private static final long serialVersionUID = -7482590109178395495L;
        final i.b.j0.b upstream;
        a(i.b.j0.b bVar) {
            super();
            this.upstream = bVar;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "NotificationLite.Disposable[";
            String str3 = "]";
            str = str2 + this.upstream + str3;
            return str;
        }
    }

    static final class b implements Serializable {

        private static final long serialVersionUID = -8759979445933046293L;
        final Throwable e;
        b(Throwable th) {
            super();
            this.e = th;
        }

        @Override // java.lang.Object
        public boolean equals(Object object) {
            if (object instanceof n.b) {
                return b.c(this.e, object.e);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.e.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "NotificationLite.Error[";
            String str3 = "]";
            str = str2 + this.e + str3;
            return str;
        }
    }

    static final class c implements Serializable {

        private static final long serialVersionUID = -1322257508628817540L;
        final c upstream;
        c(c cVar) {
            super();
            this.upstream = cVar;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "NotificationLite.Subscription[";
            String str3 = "]";
            str = str2 + this.upstream + str3;
            return str;
        }
    }
    public static <T> boolean accept(Object object, m.c.b<? super T> bVar) {
        final boolean z2 = true;
        if (object == n.COMPLETE) {
            bVar.onComplete();
            return true;
        }
        if (object instanceof n.b) {
            bVar.onError(object.e);
            return true;
        }
        bVar.onNext(object);
        return false;
    }

    public static <T> boolean acceptFull(Object object, m.c.b<? super T> bVar) {
        boolean z3 = true;
        if (object == n.COMPLETE) {
            bVar.onComplete();
            return true;
        }
        if (object instanceof n.b) {
            bVar.onError(object.e);
            return true;
        }
        boolean z4 = false;
        if (object instanceof n.c) {
            bVar.onSubscribe(object.upstream);
            return false;
        }
        bVar.onNext(object);
        return false;
    }

    public static Object complete() {
        return n.COMPLETE;
    }

    public static Object disposable(i.b.j0.b bVar) {
        return new n.a(bVar);
    }

    public static Object error(Throwable th) {
        return new n.b(th);
    }

    public static i.b.j0.b getDisposable(Object object) {
        return object.upstream;
    }

    public static Throwable getError(Object object) {
        return object.e;
    }

    public static c getSubscription(Object object) {
        return object.upstream;
    }

    public static boolean isComplete(Object object) {
        boolean z = true;
        object = object == n.COMPLETE ? 1 : 0;
        return (object == n.COMPLETE ? 1 : 0);
    }

    public static boolean isDisposable(Object object) {
        return object instanceof n.a;
    }

    public static boolean isError(Object object) {
        return object instanceof n.b;
    }

    public static boolean isSubscription(Object object) {
        return object instanceof n.c;
    }

    public static Object subscription(c cVar) {
        return new n.c(cVar);
    }

    public static <T> boolean accept(Object object, y<? super T> yVar) {
        final boolean z2 = true;
        if (object == n.COMPLETE) {
            yVar.onComplete();
            return true;
        }
        if (object instanceof n.b) {
            yVar.onError(object.e);
            return true;
        }
        yVar.onNext(object);
        return false;
    }

    public static <T> boolean acceptFull(Object object, y<? super T> yVar) {
        boolean z3 = true;
        if (object == n.COMPLETE) {
            yVar.onComplete();
            return true;
        }
        if (object instanceof n.b) {
            yVar.onError(object.e);
            return true;
        }
        boolean z4 = false;
        if (object instanceof n.a) {
            yVar.onSubscribe(object.upstream);
            return false;
        }
        yVar.onNext(object);
        return false;
    }

    public static <T> T getValue(Object object) {
        return object;
    }

    public static <T> Object next(T t) {
        return t;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }
}
