package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty.Getter;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KProperty2.Getter;

/* loaded from: classes5.dex */
public abstract class PropertyReference2 extends kotlin.jvm.internal.PropertyReference implements KProperty2 {
    public PropertyReference2(Class owner, String name, String signature, int flags) {
        super(PropertyReference2.NO_RECEIVER, owner, name, signature, flags);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    protected KCallable computeReflected() {
        return Reflection.property2(this);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public Object getDelegate(Object receiver1, Object receiver2) {
        return (KProperty2)getReflected().getDelegate(receiver1, receiver2);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public KProperty.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public KProperty2.Getter getGetter() {
        return (KProperty2)getReflected().getGetter();
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public Object invoke(Object receiver1, Object receiver2) {
        return get(receiver1, receiver2);
    }
}
