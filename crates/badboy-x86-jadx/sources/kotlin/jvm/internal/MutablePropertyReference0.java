package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty.Setter;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty0.Setter;
import kotlin.reflect.KProperty.Getter;
import kotlin.reflect.KProperty0.Getter;

/* loaded from: classes5.dex */
public abstract class MutablePropertyReference0 extends kotlin.jvm.internal.MutablePropertyReference implements KMutableProperty0 {
    public MutablePropertyReference0(Object receiver) {
        super(receiver);
    }

    public MutablePropertyReference0(Object receiver, Class owner, String name, String signature, int flags) {
        super(receiver, owner, name, signature, flags);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    protected KCallable computeReflected() {
        return Reflection.mutableProperty0(this);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public Object getDelegate() {
        return (KMutableProperty0)getReflected().getDelegate();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public KProperty.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public KProperty0.Getter getGetter() {
        return (KMutableProperty0)getReflected().getGetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public KMutableProperty.Setter getSetter() {
        return getSetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public KMutableProperty0.Setter getSetter() {
        return (KMutableProperty0)getReflected().getSetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public Object invoke() {
        return get();
    }
}
