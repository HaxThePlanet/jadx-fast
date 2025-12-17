package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class j {

    AtomicReference<Object> a;

    static class a {

        static final int[] a;
        static final int[] b;
        static {
            int[] iArr = new int[values.length];
            j.a.b = iArr;
            int i2 = 1;
            iArr[j.b.ON_CREATE.ordinal()] = i2;
            int i = 2;
            j.a.b[j.b.ON_STOP.ordinal()] = i;
            int i3 = 3;
            j.a.b[j.b.ON_START.ordinal()] = i3;
            int i4 = 4;
            j.a.b[j.b.ON_PAUSE.ordinal()] = i4;
            int i5 = 5;
            j.a.b[j.b.ON_RESUME.ordinal()] = i5;
            j.a.b[j.b.ON_DESTROY.ordinal()] = 6;
            j.a.b[j.b.ON_ANY.ordinal()] = 7;
            int[] iArr12 = new int[values2.length];
            j.a.a = iArr12;
            iArr12[j.c.CREATED.ordinal()] = i2;
            j.a.a[j.c.STARTED.ordinal()] = i;
            j.a.a[j.c.RESUMED.ordinal()] = i3;
            j.a.a[j.c.DESTROYED.ordinal()] = i4;
            j.a.a[j.c.INITIALIZED.ordinal()] = i5;
        }
    }

    public static enum b {

        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;
        public static androidx.lifecycle.j.b downFrom(androidx.lifecycle.j.c j$c) {
            int obj1 = j.a.a[c.ordinal()];
            if (obj1 != 1 && obj1 != 2 && obj1 != 3) {
                if (obj1 != 2) {
                    if (obj1 != 3) {
                        return null;
                    }
                    return j.b.ON_PAUSE;
                }
                return j.b.ON_STOP;
            }
            return j.b.ON_DESTROY;
        }

        public static androidx.lifecycle.j.b downTo(androidx.lifecycle.j.c j$c) {
            int obj1 = j.a.a[c.ordinal()];
            if (obj1 != 1 && obj1 != 2 && obj1 != 4) {
                if (obj1 != 2) {
                    if (obj1 != 4) {
                        return null;
                    }
                    return j.b.ON_DESTROY;
                }
                return j.b.ON_PAUSE;
            }
            return j.b.ON_STOP;
        }

        public static androidx.lifecycle.j.b upFrom(androidx.lifecycle.j.c j$c) {
            int obj1 = j.a.a[c.ordinal()];
            if (obj1 != 1 && obj1 != 2 && obj1 != 5) {
                if (obj1 != 2) {
                    if (obj1 != 5) {
                        return null;
                    }
                    return j.b.ON_CREATE;
                }
                return j.b.ON_RESUME;
            }
            return j.b.ON_START;
        }

        public static androidx.lifecycle.j.b upTo(androidx.lifecycle.j.c j$c) {
            int obj1 = j.a.a[c.ordinal()];
            if (obj1 != 1 && obj1 != 2 && obj1 != 3) {
                if (obj1 != 2) {
                    if (obj1 != 3) {
                        return null;
                    }
                    return j.b.ON_RESUME;
                }
                return j.b.ON_START;
            }
            return j.b.ON_CREATE;
        }

        @Override // java.lang.Enum
        public androidx.lifecycle.j.c getTargetState() {
            switch (i) {
                case 1:
                    return j.c.CREATED;
                case 2:
                    return j.c.STARTED;
                case 3:
                    return j.c.RESUMED;
                case 4:
                    return j.c.DESTROYED;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this);
                    stringBuilder.append(" has no target state");
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                    throw illegalArgumentException;
            }
        }
    }

    public static enum c {

        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;
        @Override // java.lang.Enum
        public boolean isAtLeast(androidx.lifecycle.j.c j$c) {
            int obj1;
            obj1 = compareTo(c) >= 0 ? 1 : 0;
            return obj1;
        }
    }
    public j() {
        super();
        AtomicReference atomicReference = new AtomicReference();
        this.a = atomicReference;
    }

    public abstract void a(androidx.lifecycle.p p);

    public abstract androidx.lifecycle.j.c b();

    public abstract void c(androidx.lifecycle.p p);
}
