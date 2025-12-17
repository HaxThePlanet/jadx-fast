package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty1.Setter;
import kotlin.reflect.KProperty1.Getter;

/* loaded from: classes5.dex */
public class MutablePropertyReference1Impl extends kotlin.jvm.internal.MutablePropertyReference1 {
    public MutablePropertyReference1Impl(Class owner, String name, String signature, int flags) {
        super(MutablePropertyReference1Impl.NO_RECEIVER, owner, name, signature, flags);
    }

    public MutablePropertyReference1Impl(Object receiver, Class owner, String name, String signature, int flags) {
        super(receiver, owner, name, signature, flags);
    }

    public MutablePropertyReference1Impl(KDeclarationContainer owner, String name, String signature) {
        super(MutablePropertyReference1Impl.NO_RECEIVER, (ClassBasedDeclarationContainer)owner.getJClass(), name, signature, z ^ 1);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1
    public Object get(Object receiver) {
        return getGetter().call(/* result */);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1
    public void set(Object receiver, Object value) {
        getSetter().call(/* result */);
    }
}
