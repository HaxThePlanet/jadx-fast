package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;

/* loaded from: classes3.dex */
public interface b extends kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.y {

    public static enum a {

        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;
        @Override // java.lang.Enum
        public boolean isReal() {
            int i;
            i = this != b.a.FAKE_OVERRIDE ? 1 : 0;
            return i;
        }
    }
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.b a();

    public abstract Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> e();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.b.a f();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.b k0(kotlin.reflect.jvm.internal.impl.descriptors.m m, kotlin.reflect.jvm.internal.impl.descriptors.z z2, kotlin.reflect.jvm.internal.impl.descriptors.u u3, kotlin.reflect.jvm.internal.impl.descriptors.b.a b$a4, boolean z5);

    public abstract void w0(Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collection);
}
