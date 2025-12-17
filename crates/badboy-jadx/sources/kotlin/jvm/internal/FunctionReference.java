package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

/* loaded from: classes5.dex */
public class FunctionReference extends kotlin.jvm.internal.CallableReference implements kotlin.jvm.internal.FunctionBase, KFunction {

    private final int arity;
    private final int flags;
    public FunctionReference(int arity) {
        super(arity, FunctionReference.NO_RECEIVER, 0, 0, 0, 0);
    }

    public FunctionReference(int arity, Object receiver) {
        super(arity, receiver, 0, 0, 0, 0);
    }

    public FunctionReference(int arity, Object receiver, Class owner, String name, String signature, int flags) {
        int i;
        if (flags & 1 == 1) {
        } else {
            i = 0;
        }
        final Object obj = this;
        super(receiver, owner, name, signature, i);
        obj.arity = arity;
        obj.flags = flags >> 1;
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected KCallable computeReflected() {
        return Reflection.function(this);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public boolean equals(Object obj) {
        int i;
        boolean equals;
        Object boundReceiver;
        if (obj == this) {
            return 1;
        }
        final int i2 = 0;
        if (obj instanceof FunctionReference != null) {
            Object obj2 = obj;
            if (getName().equals((FunctionReference)obj2.getName()) && getSignature().equals(obj2.getSignature()) && this.flags == obj2.flags && this.arity == obj2.arity && Intrinsics.areEqual(getBoundReceiver(), obj2.getBoundReceiver()) && Intrinsics.areEqual(getOwner(), obj2.getOwner())) {
                if (getSignature().equals(obj2.getSignature())) {
                    if (this.flags == obj2.flags) {
                        if (this.arity == obj2.arity) {
                            if (Intrinsics.areEqual(getBoundReceiver(), obj2.getBoundReceiver())) {
                                if (Intrinsics.areEqual(getOwner(), obj2.getOwner())) {
                                } else {
                                    i = i2;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        if (obj instanceof KFunction) {
            return obj.equals(compute());
        }
        return i2;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected KCallable getReflected() {
        return getReflected();
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected KFunction getReflected() {
        return (KFunction)super.getReflected();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public int hashCode() {
        int i;
        if (getOwner() == null) {
            i = 0;
        } else {
            i5 *= 31;
        }
        return i3 += i7;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String toString() {
        String string;
        String name;
        final KCallable compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            string = "constructor (Kotlin reflection is not available)";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append("function ").append(getName()).append(" (Kotlin reflection is not available)").toString();
        }
        return string;
    }
}
