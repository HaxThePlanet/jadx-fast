package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty.Setter;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty1.Setter;
import kotlin.reflect.KProperty.Getter;
import kotlin.reflect.KProperty1.Getter;

/* loaded from: classes5.dex */
public abstract class MutablePropertyReference1 extends kotlin.jvm.internal.MutablePropertyReference implements KMutableProperty1 {
    public MutablePropertyReference1(Object receiver) {
        super(receiver);
    }

    public MutablePropertyReference1(Object receiver, Class owner, String name, String signature, int flags) {
        super(receiver, owner, name, signature, flags);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    protected KCallable computeReflected() {
        return Reflection.mutableProperty1(this);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public Object getDelegate(Object receiver) {
        return (KMutableProperty1)getReflected().getDelegate(receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public KProperty.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public KProperty1.Getter getGetter() {
        return (KMutableProperty1)getReflected().getGetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public KMutableProperty.Setter getSetter() {
        return getSetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public KMutableProperty1.Setter getSetter() {
        return (KMutableProperty1)getReflected().getSetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference
    public Object invoke(Object receiver) {
        return get(receiver);
    }
}
