package io.grpc;

import com.google.common.base.n;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: InternalLogId.java */
/* loaded from: classes2.dex */
public final class i0 {

    private static final AtomicLong d = new AtomicLong();
    private final String a;
    private final String b;
    private final long c;

    i0(String str, String str2, long j) {
        super();
        n.p(str, "typeName");
        n.e(!str.isEmpty(), "empty type");
        this.a = str;
        this.b = str2;
        this.c = j;
    }

    public static i0 a(Class<?> cls, String str) {
        return i0.b(i0.c(cls), str);
    }

    public static i0 b(String str, String str2) {
        return new i0(str, str2, i0.e(), r2);
    }

    private static String c(Class<?> cls) {
        n.p(cls, "type");
        String simpleName = (Class)cls.getSimpleName();
        if (!simpleName.isEmpty()) {
            return simpleName;
        }
        return cls.getName().substring(cls.getPackage().getName().length() + 1);
    }

    static long e() {
        return i0.d.incrementAndGet();
    }

    public long d() {
        return this.c;
    }

    public String f() {
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = "<";
        String str4 = ">";
        str = this.a + str3 + this.c + str4;
        return str;
    }

    public String toString() {
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
