package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty.Setter;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KMutableProperty2.Setter;
import kotlin.reflect.KProperty.Getter;
import kotlin.reflect.KProperty2.Getter;

/* loaded from: classes5.dex */
public abstract class MutablePropertyReference2 extends kotlin.jvm.internal.MutablePropertyReference implements KMutableProperty2 {
    public MutablePropertyReference2(Class owner, String name, String signature, int flags) {
        super(MutablePropertyReference2.NO_RECEIVER, owner, name, signature, flags);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    protected KCallable computeReflected() {
        return Reflection.mutableProperty2(this);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public Object getDelegate(Object receiver1, Object receiver2) {
        return (KMutableProperty2)getReflected().getDelegate(receiver1, receiver2);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public KProperty.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public KProperty2.Getter getGetter() {
        return (KMutableProperty2)getReflected().getGetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public KMutableProperty.Setter getSetter() {
        return getSetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public KMutableProperty2.Setter getSetter() {
        return (KMutableProperty2)getReflected().getSetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public Object invoke(Object receiver1, Object receiver2) {
        return get(receiver1, receiver2);
    }
}
