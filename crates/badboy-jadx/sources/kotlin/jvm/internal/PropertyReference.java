package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* loaded from: classes5.dex */
public abstract class PropertyReference extends kotlin.jvm.internal.CallableReference implements KProperty {

    private final boolean syntheticJavaProperty;
    public PropertyReference() {
        super();
        this.syntheticJavaProperty = false;
    }

    public PropertyReference(Object receiver) {
        super(receiver);
        this.syntheticJavaProperty = false;
    }

    public PropertyReference(Object receiver, Class owner, String name, String signature, int flags) {
        int i2;
        int i;
        final int i4 = 1;
        i = flags & 1 == i4 ? i4 : i2;
        final Object obj = this;
        super(receiver, owner, name, signature, i);
        i2 = flags & 2 == 2 ? i4 : i2;
        obj.syntheticJavaProperty = i2;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KCallable compute() {
        Object compute;
        if (this.syntheticJavaProperty) {
            compute = this;
        } else {
            compute = super.compute();
        }
        return compute;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public boolean equals(Object obj) {
        int i;
        boolean equals;
        kotlin.reflect.KDeclarationContainer boundReceiver;
        if (obj == this) {
            return 1;
        }
        final int i2 = 0;
        if (obj instanceof PropertyReference != null) {
            Object obj2 = obj;
            if (getOwner().equals((PropertyReference)obj2.getOwner()) && getName().equals(obj2.getName()) && getSignature().equals(obj2.getSignature()) && Intrinsics.areEqual(getBoundReceiver(), obj2.getBoundReceiver())) {
                if (getName().equals(obj2.getName())) {
                    if (getSignature().equals(obj2.getSignature())) {
                        if (Intrinsics.areEqual(getBoundReceiver(), obj2.getBoundReceiver())) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        if (obj instanceof KProperty) {
            return obj.equals(compute());
        }
        return i2;
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected KCallable getReflected() {
        return getReflected();
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected KProperty getReflected() {
        if (this.syntheticJavaProperty) {
        } else {
            return (KProperty)super.getReflected();
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        throw unsupportedOperationException;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public int hashCode() {
        return i4 += i7;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String toString() {
        final KCallable compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("property ").append(getName()).append(" (Kotlin reflection is not available)").toString();
    }
}
