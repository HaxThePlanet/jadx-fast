package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty.Getter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty1.Getter;

/* loaded from: classes5.dex */
public abstract class PropertyReference1 extends kotlin.jvm.internal.PropertyReference implements KProperty1 {
    public PropertyReference1(Object receiver) {
        super(receiver);
    }

    public PropertyReference1(Object receiver, Class owner, String name, String signature, int flags) {
        super(receiver, owner, name, signature, flags);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    protected KCallable computeReflected() {
        return Reflection.property1(this);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public Object getDelegate(Object receiver) {
        return (KProperty1)getReflected().getDelegate(receiver);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public KProperty.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public KProperty1.Getter getGetter() {
        return (KProperty1)getReflected().getGetter();
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public Object invoke(Object receiver) {
        return get(receiver);
    }
}
