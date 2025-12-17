package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

/* loaded from: classes5.dex */
public class FunInterfaceConstructorReference extends kotlin.jvm.internal.FunctionReference implements Serializable {

    private final Class funInterface;
    public FunInterfaceConstructorReference(Class funInterface) {
        super(1);
        this.funInterface = funInterface;
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public boolean equals(Object o) {
        if (this == o) {
            return 1;
        }
        if (o instanceof FunInterfaceConstructorReference == null) {
            return 0;
        }
        return this.funInterface.equals(obj.funInterface);
    }

    @Override // kotlin.jvm.internal.FunctionReference
    protected KCallable getReflected() {
        return getReflected();
    }

    @Override // kotlin.jvm.internal.FunctionReference
    protected KFunction getReflected() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Functional interface constructor does not support reflection");
        throw unsupportedOperationException;
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public int hashCode() {
        return this.funInterface.hashCode();
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("fun interface ").append(this.funInterface.getName()).toString();
    }
}
