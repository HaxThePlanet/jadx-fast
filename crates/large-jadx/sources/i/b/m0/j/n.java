package i.b.m0.j;

import i.b.j0.b;
import i.b.m0.b.b;
import i.b.y;
import java.io.Serializable;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public enum n {

    COMPLETE;

    static final class a implements Serializable {

        private static final long serialVersionUID = -7482590109178395495L;
        final b upstream;
        a(b b) {
            super();
            this.upstream = b;
        }

        @Override // java.io.Serializable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NotificationLite.Disposable[");
            stringBuilder.append(this.upstream);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    static final class b implements Serializable {

        private static final long serialVersionUID = -8759979445933046293L;
        final Throwable e;
        b(Throwable throwable) {
            super();
            this.e = throwable;
        }

        @Override // java.io.Serializable
        public boolean equals(Object object) {
            if (object instanceof n.b) {
                return b.c(this.e, object.e);
            }
            return 0;
        }

        @Override // java.io.Serializable
        public int hashCode() {
            return this.e.hashCode();
        }

        @Override // java.io.Serializable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NotificationLite.Error[");
            stringBuilder.append(this.e);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    static final class c implements Serializable {

        private static final long serialVersionUID = -1322257508628817540L;
        final c upstream;
        c(c c) {
            super();
            this.upstream = c;
        }

        @Override // java.io.Serializable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("NotificationLite.Subscription[");
            stringBuilder.append(this.upstream);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }
    public static <T> boolean accept(Object object, y<? super T> y2) {
        final int i = 1;
        if (object == n.COMPLETE) {
            y2.onComplete();
            return i;
        }
        if (object instanceof n.b) {
            y2.onError(object.e);
            return i;
        }
        y2.onNext((n.b)object);
        return 0;
    }

    public static <T> boolean accept(Object object, b<? super T> b2) {
        final int i = 1;
        if (object == n.COMPLETE) {
            b2.onComplete();
            return i;
        }
        if (object instanceof n.b) {
            b2.onError(object.e);
            return i;
        }
        b2.onNext((n.b)object);
        return 0;
    }

    public static <T> boolean acceptFull(Object object, y<? super T> y2) {
        int i = 1;
        if (object == n.COMPLETE) {
            y2.onComplete();
            return i;
        }
        if (object instanceof n.b) {
            y2.onError(object.e);
            return i;
        }
        int i2 = 0;
        if (object instanceof n.a) {
            y2.onSubscribe(object.upstream);
            return i2;
        }
        y2.onNext((n.a)(n.b)object);
        return i2;
    }

    public static <T> boolean acceptFull(Object object, b<? super T> b2) {
        int i = 1;
        if (object == n.COMPLETE) {
            b2.onComplete();
            return i;
        }
        if (object instanceof n.b) {
            b2.onError(object.e);
            return i;
        }
        int i2 = 0;
        if (object instanceof n.c) {
            b2.onSubscribe(object.upstream);
            return i2;
        }
        b2.onNext((n.c)(n.b)object);
        return i2;
    }

    public static Object complete() {
        return n.COMPLETE;
    }

    public static Object disposable(b b) {
        n.a aVar = new n.a(b);
        return aVar;
    }

    public static Object error(Throwable throwable) {
        n.b bVar = new n.b(throwable);
        return bVar;
    }

    public static b getDisposable(Object object) {
        return object.upstream;
    }

    public static Throwable getError(Object object) {
        return object.e;
    }

    public static c getSubscription(Object object) {
        return object.upstream;
    }

    public static <T> T getValue(Object object) {
        return object;
    }

    public static boolean isComplete(Object object) {
        int obj1;
        obj1 = object == n.COMPLETE ? 1 : 0;
        return obj1;
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

    public static <T> Object next(T t) {
        return t;
    }

    public static Object subscription(c c) {
        n.c cVar = new n.c(c);
        return cVar;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }
}
