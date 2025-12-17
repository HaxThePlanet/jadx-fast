package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty2.Setter;
import kotlin.reflect.KProperty2.Getter;

/* loaded from: classes5.dex */
public class MutablePropertyReference2Impl extends kotlin.jvm.internal.MutablePropertyReference2 {
    public MutablePropertyReference2Impl(Class owner, String name, String signature, int flags) {
        super(owner, name, signature, flags);
    }

    public MutablePropertyReference2Impl(KDeclarationContainer owner, String name, String signature) {
        super((ClassBasedDeclarationContainer)owner.getJClass(), name, signature, z ^= 1);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference2
    public Object get(Object receiver1, Object receiver2) {
        return getGetter().call(/* result */);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference2
    public void set(Object receiver1, Object receiver2, Object value) {
        getSetter().call(/* result */);
    }
}
