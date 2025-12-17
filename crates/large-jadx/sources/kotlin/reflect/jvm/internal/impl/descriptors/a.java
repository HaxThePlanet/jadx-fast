package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.i0.z.e.m0.l.b0;

/* loaded from: classes3.dex */
public interface a extends kotlin.reflect.jvm.internal.impl.descriptors.n, kotlin.reflect.jvm.internal.impl.descriptors.q, kotlin.reflect.jvm.internal.impl.descriptors.w0<kotlin.reflect.jvm.internal.impl.descriptors.a> {

    public interface a {
    }
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    public abstract boolean D();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.a a();

    public abstract Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> e();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.r0 f0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    public abstract b0 getReturnType();

    public abstract List<kotlin.reflect.jvm.internal.impl.descriptors.z0> getTypeParameters();

    public abstract List<kotlin.reflect.jvm.internal.impl.descriptors.c1> h();

    public abstract <V> V i0(kotlin.reflect.jvm.internal.impl.descriptors.a.a<V> a$a);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.r0 m0();
}
