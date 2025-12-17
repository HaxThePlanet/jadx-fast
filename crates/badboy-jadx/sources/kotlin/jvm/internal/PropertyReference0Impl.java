package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty0.Getter;

/* loaded from: classes5.dex */
public class PropertyReference0Impl extends kotlin.jvm.internal.PropertyReference0 {
    public PropertyReference0Impl(Class owner, String name, String signature, int flags) {
        super(PropertyReference0Impl.NO_RECEIVER, owner, name, signature, flags);
    }

    public PropertyReference0Impl(Object receiver, Class owner, String name, String signature, int flags) {
        super(receiver, owner, name, signature, flags);
    }

    public PropertyReference0Impl(KDeclarationContainer owner, String name, String signature) {
        super(PropertyReference0Impl.NO_RECEIVER, (ClassBasedDeclarationContainer)owner.getJClass(), name, signature, z ^ 1);
    }

    @Override // kotlin.jvm.internal.PropertyReference0
    public Object get() {
        return getGetter().call(new Object[0]);
    }
}
