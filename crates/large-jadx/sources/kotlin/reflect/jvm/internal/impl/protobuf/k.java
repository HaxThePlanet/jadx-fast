package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* loaded from: classes3.dex */
public class k {

    private kotlin.reflect.jvm.internal.impl.protobuf.d a;
    private kotlin.reflect.jvm.internal.impl.protobuf.f b;
    private volatile boolean c;
    protected volatile kotlin.reflect.jvm.internal.impl.protobuf.o d;
    protected void a(kotlin.reflect.jvm.internal.impl.protobuf.o o) {
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar;
        kotlin.reflect.jvm.internal.impl.protobuf.f fVar;
        Object obj3;
        if (this.d != null) {
        }
        synchronized (this) {
        }
    }

    public int b() {
        if (this.c) {
            return this.d.getSerializedSize();
        }
        return this.a.size();
    }

    public kotlin.reflect.jvm.internal.impl.protobuf.o c(kotlin.reflect.jvm.internal.impl.protobuf.o o) {
        a(o);
        return this.d;
    }

    public kotlin.reflect.jvm.internal.impl.protobuf.o d(kotlin.reflect.jvm.internal.impl.protobuf.o o) {
        this.d = o;
        this.a = 0;
        this.c = true;
        return this.d;
    }
}
