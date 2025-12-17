package kotlin.reflect.jvm.internal.impl.utils;

/* loaded from: classes3.dex */
public class WrappedValues {

    private static final Object a = null;
    public static volatile boolean b = false;

    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable throwable) {
            super("Rethrow stored exception", throwable);
        }
    }

    static class a {
        public String toString() {
            return "NULL_VALUE";
        }
    }

    private static final class b {

        private final Throwable a;
        private b(Throwable throwable) {
            if (throwable == null) {
            } else {
                super();
                this.a = throwable;
            }
            WrappedValues.b.a(0);
            throw 0;
        }

        b(Throwable throwable, kotlin.reflect.jvm.internal.impl.utils.WrappedValues.a wrappedValues$a2) {
            super(throwable);
        }

        private static void a(int i) {
            String str;
            int i2;
            String str2;
            String str3;
            Object obj7;
            final int i3 = 1;
            str = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            final int i4 = 2;
            i2 = i != i3 ? 3 : i4;
            Object[] arr = new Object[i2];
            str2 = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            final int i5 = 0;
            if (i != i3) {
                arr[i5] = "throwable";
            } else {
                arr[i5] = str2;
            }
            if (i != i3) {
                arr[i3] = str2;
            } else {
                arr[i3] = "getThrowable";
            }
            if (i != i3) {
                arr[i4] = "<init>";
            }
            String format = String.format(str, arr);
            if (i != i3) {
                obj7 = new IllegalArgumentException(format);
            } else {
                obj7 = new IllegalStateException(format);
            }
            throw obj7;
        }

        public Throwable b() {
            Throwable th = this.a;
            if (th == null) {
            } else {
                return th;
            }
            WrappedValues.b.a(1);
            throw 0;
        }

        public String toString() {
            return this.a.toString();
        }
    }
    static {
        WrappedValues.a aVar = new WrappedValues.a();
        WrappedValues.a = aVar;
    }

    private static void a(int i) {
        String str4;
        int str;
        int i2;
        String str3;
        String str2;
        Object obj8;
        final int i3 = 1;
        final int i4 = 2;
        if (i != i3 && i != i4) {
            str4 = i != i4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        } else {
        }
        str = 3;
        if (i != i3 && i != i4) {
            i2 = i != i4 ? str : i4;
        } else {
        }
        Object[] arr = new Object[i2];
        str3 = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        final int i6 = 0;
        if (i != i3 && i != i4) {
            if (i != i4) {
                if (i != str) {
                    arr[i6] = "value";
                } else {
                    arr[i6] = "throwable";
                }
            } else {
                arr[i6] = str3;
            }
        } else {
        }
        if (i != i3 && i != i4) {
            if (i != i4) {
                arr[i3] = str3;
            } else {
                arr[i3] = "escapeNull";
            }
        } else {
        }
        if (i != i3 && i != i4) {
            if (i != i4) {
                if (i != str) {
                    if (i != 4) {
                        arr[i4] = "unescapeNull";
                    } else {
                        arr[i4] = "unescapeExceptionOrNull";
                    }
                } else {
                    arr[i4] = "escapeThrowable";
                }
            }
        }
        String format = String.format(str4, arr);
        if (i != i3 && i != i4) {
            if (i != i4) {
                obj8 = new IllegalArgumentException(format);
            } else {
                obj8 = new IllegalStateException(format);
            }
        } else {
        }
        throw obj8;
    }

    public static <V> Object b(V v) {
        final int i = 0;
        if (v == 0) {
            Object obj1 = WrappedValues.a;
            if (obj1 == null) {
            } else {
                return obj1;
            }
            WrappedValues.a(1);
            throw i;
        }
        if (v == 0) {
        } else {
            return v;
        }
        WrappedValues.a(2);
        throw i;
    }

    public static Object c(Throwable throwable) {
        final int i = 0;
        if (throwable == null) {
        } else {
            WrappedValues.b bVar = new WrappedValues.b(throwable, i);
            return bVar;
        }
        WrappedValues.a(3);
        throw i;
    }

    public static <V> V d(Object object) {
        if (object == null) {
        } else {
            WrappedValues.f(object);
            return WrappedValues.e(object);
        }
        WrappedValues.a(4);
        throw 0;
    }

    public static <V> V e(Object object) {
        final int i = 0;
        if (object == null) {
        } else {
            if (object == WrappedValues.a) {
                return i;
            }
            return object;
        }
        WrappedValues.a(0);
        throw i;
    }

    public static <V> V f(Object object) {
        boolean z;
        if (object instanceof WrappedValues.b) {
            Throwable obj1 = (WrappedValues.b)object.b();
            if (!WrappedValues.b) {
            } else {
                if (c.a(obj1)) {
                    WrappedValues.WrappedProcessCanceledException wrappedProcessCanceledException = new WrappedValues.WrappedProcessCanceledException(obj1);
                    throw wrappedProcessCanceledException;
                }
            }
            c.b(obj1);
            throw 0;
        }
        return object;
    }
}
