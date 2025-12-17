package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty2.Getter;

/* loaded from: classes5.dex */
public class PropertyReference2Impl extends kotlin.jvm.internal.PropertyReference2 {
    public PropertyReference2Impl(Class owner, String name, String signature, int flags) {
        super(owner, name, signature, flags);
    }

    public PropertyReference2Impl(KDeclarationContainer owner, String name, String signature) {
        super((ClassBasedDeclarationContainer)owner.getJClass(), name, signature, z ^= 1);
    }

    @Override // kotlin.jvm.internal.PropertyReference2
    public Object get(Object receiver1, Object receiver2) {
        return getGetter().call(/* result */);
    }
}
