package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.reflect.KDeclarationContainer;

/* loaded from: classes5.dex */
public class AdaptedFunctionReference implements kotlin.jvm.internal.FunctionBase, Serializable {

    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;
    public AdaptedFunctionReference(int arity, Class owner, String name, String signature, int flags) {
        super(arity, CallableReference.NO_RECEIVER, owner, name, signature, flags);
    }

    public AdaptedFunctionReference(int arity, Object receiver, Class owner, String name, String signature, int flags) {
        int i;
        super();
        this.receiver = receiver;
        this.owner = owner;
        this.name = name;
        this.signature = signature;
        if (flags & 1 == 1) {
        } else {
            i = 0;
        }
        this.isTopLevel = i;
        this.arity = arity;
        this.flags = flags >> 1;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public boolean equals(Object o) {
        int i;
        boolean isTopLevel;
        String isTopLevel2;
        if (this == o) {
            return 1;
        }
        final int i2 = 0;
        if (o instanceof AdaptedFunctionReference == null) {
            return i2;
        }
        Object obj = o;
        if (this.isTopLevel == obj.isTopLevel && this.arity == obj.arity && this.flags == obj.flags && Intrinsics.areEqual(this.receiver, obj.receiver) && Intrinsics.areEqual(this.owner, obj.owner) && this.name.equals(obj.name) && this.signature.equals(obj.signature)) {
            if (this.arity == obj.arity) {
                if (this.flags == obj.flags) {
                    if (Intrinsics.areEqual(this.receiver, obj.receiver)) {
                        if (Intrinsics.areEqual(this.owner, obj.owner)) {
                            if (this.name.equals(obj.name)) {
                                if (this.signature.equals(obj.signature)) {
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
        } else {
        }
        return i;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public KDeclarationContainer getOwner() {
        int orCreateKotlinPackage;
        if (this.owner == null) {
            orCreateKotlinPackage = 0;
        } else {
            if (this.isTopLevel) {
                orCreateKotlinPackage = Reflection.getOrCreateKotlinPackage(this.owner);
            } else {
                orCreateKotlinPackage = Reflection.getOrCreateKotlinClass(this.owner);
            }
        }
        return orCreateKotlinPackage;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int hashCode() {
        int i2;
        int i;
        int i3;
        if (this.receiver != null) {
            i2 = this.receiver.hashCode();
        } else {
            i2 = i;
        }
        if (this.owner != null) {
            i = this.owner.hashCode();
        }
        i3 = this.isTopLevel ? 1231 : 1237;
        return result3 += flags;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public String toString() {
        return Reflection.renderLambdaToString(this);
    }
}
