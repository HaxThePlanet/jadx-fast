package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;

/* loaded from: classes5.dex */
public class FunctionReferenceImpl extends kotlin.jvm.internal.FunctionReference {
    public FunctionReferenceImpl(int arity, Class owner, String name, String signature, int flags) {
        super(arity, FunctionReferenceImpl.NO_RECEIVER, owner, name, signature, flags);
    }

    public FunctionReferenceImpl(int arity, Object receiver, Class owner, String name, String signature, int flags) {
        super(arity, receiver, owner, name, signature, flags);
    }

    public FunctionReferenceImpl(int arity, KDeclarationContainer owner, String name, String signature) {
        super(arity, FunctionReferenceImpl.NO_RECEIVER, (ClassBasedDeclarationContainer)owner.getJClass(), name, signature, z ^ 1);
    }
}
