package kotlin.reflect.jvm.internal.impl.descriptors;

/* loaded from: classes3.dex */
public interface u0 {

    public static final kotlin.reflect.jvm.internal.impl.descriptors.u0 a;

    static class a implements kotlin.reflect.jvm.internal.impl.descriptors.u0 {
        private static void d(int i) {
            Object[] obj2 = new Object[2];
            IllegalStateException illegalStateException = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"));
            throw illegalStateException;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u0
        public kotlin.reflect.jvm.internal.impl.descriptors.v0 a() {
            kotlin.reflect.jvm.internal.impl.descriptors.v0 v0Var = v0.a;
            if (v0Var == null) {
            } else {
                return v0Var;
            }
            u0.a.d(0);
            throw 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.u0
        public String toString() {
            return "NO_SOURCE";
        }
    }
    static {
        u0.a aVar = new u0.a();
        u0.a = aVar;
    }

    public abstract kotlin.reflect.jvm.internal.impl.descriptors.v0 a();
}
