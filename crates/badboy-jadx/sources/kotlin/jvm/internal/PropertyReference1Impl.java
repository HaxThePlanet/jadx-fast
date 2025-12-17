package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty1.Getter;

/* loaded from: classes5.dex */
public class PropertyReference1Impl extends kotlin.jvm.internal.PropertyReference1 {
    public PropertyReference1Impl(Class owner, String name, String signature, int flags) {
        super(PropertyReference1Impl.NO_RECEIVER, owner, name, signature, flags);
    }

    public PropertyReference1Impl(Object receiver, Class owner, String name, String signature, int flags) {
        super(receiver, owner, name, signature, flags);
    }

    public PropertyReference1Impl(KDeclarationContainer owner, String name, String signature) {
        super(PropertyReference1Impl.NO_RECEIVER, (ClassBasedDeclarationContainer)owner.getJClass(), name, signature, z ^ 1);
    }

    @Override // kotlin.jvm.internal.PropertyReference1
    public Object get(Object receiver) {
        return getGetter().call(/* result */);
    }
}
