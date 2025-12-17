package io.grpc;

import com.google.common.base.n;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class i0 {

    private static final AtomicLong d;
    private final String a;
    private final String b;
    private final long c;
    static {
        AtomicLong atomicLong = new AtomicLong();
        i0.d = atomicLong;
    }

    i0(String string, String string2, long l3) {
        super();
        n.p(string, "typeName");
        n.e(empty ^= 1, "empty type");
        this.a = string;
        this.b = string2;
        this.c = l3;
    }

    public static io.grpc.i0 a(Class<?> class, String string2) {
        return i0.b(i0.c(class), string2);
    }

    public static io.grpc.i0 b(String string, String string2) {
        i0 i0Var = new i0(string, string2, i0.e(), obj2);
        return i0Var;
    }

    private static String c(Class<?> class) {
        n.p(class, "type");
        String simpleName = (Class)class.getSimpleName();
        if (!simpleName.isEmpty()) {
            return simpleName;
        }
        return class.getName().substring(obj2++);
    }

    static long e() {
        return i0.d.incrementAndGet();
    }

    public long d() {
        return this.c;
    }

    public String f() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("<");
        stringBuilder.append(this.c);
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f());
        if (this.b != null) {
            stringBuilder.append(": (");
            stringBuilder.append(this.b);
            stringBuilder.append(')');
        }
        return stringBuilder.toString();
    }
}
