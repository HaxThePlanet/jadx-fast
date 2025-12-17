package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty.Getter;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty0.Getter;

/* loaded from: classes5.dex */
public abstract class PropertyReference0 extends kotlin.jvm.internal.PropertyReference implements KProperty0 {
    public PropertyReference0(Object receiver) {
        super(receiver);
    }

    public PropertyReference0(Object receiver, Class owner, String name, String signature, int flags) {
        super(receiver, owner, name, signature, flags);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    protected KCallable computeReflected() {
        return Reflection.property0(this);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public Object getDelegate() {
        return (KProperty0)getReflected().getDelegate();
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public KProperty.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public KProperty0.Getter getGetter() {
        return (KProperty0)getReflected().getGetter();
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public Object invoke() {
        return get();
    }
}
