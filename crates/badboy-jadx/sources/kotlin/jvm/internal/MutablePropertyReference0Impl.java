package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty0.Setter;
import kotlin.reflect.KProperty0.Getter;

/* loaded from: classes5.dex */
public class MutablePropertyReference0Impl extends kotlin.jvm.internal.MutablePropertyReference0 {
    public MutablePropertyReference0Impl(Class owner, String name, String signature, int flags) {
        super(MutablePropertyReference0Impl.NO_RECEIVER, owner, name, signature, flags);
    }

    public MutablePropertyReference0Impl(Object receiver, Class owner, String name, String signature, int flags) {
        super(receiver, owner, name, signature, flags);
    }

    public MutablePropertyReference0Impl(KDeclarationContainer owner, String name, String signature) {
        super(MutablePropertyReference0Impl.NO_RECEIVER, (ClassBasedDeclarationContainer)owner.getJClass(), name, signature, z ^ 1);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0
    public Object get() {
        return getGetter().call(new Object[0]);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0
    public void set(Object value) {
        getSetter().call(/* result */);
    }
}
