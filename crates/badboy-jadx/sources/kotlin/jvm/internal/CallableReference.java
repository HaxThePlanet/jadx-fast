package kotlin.jvm.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;

/* loaded from: classes5.dex */
public abstract class CallableReference implements KCallable, Serializable {

    public static final Object NO_RECEIVER;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient KCallable reflected;
    private final String signature;

    private static class NoReceiver implements Serializable {

        private static final kotlin.jvm.internal.CallableReference.NoReceiver INSTANCE;
        static {
            CallableReference.NoReceiver noReceiver = new CallableReference.NoReceiver();
            CallableReference.NoReceiver.INSTANCE = noReceiver;
        }

        static kotlin.jvm.internal.CallableReference.NoReceiver access$000() {
            return CallableReference.NoReceiver.INSTANCE;
        }

        private Object readResolve() throws ObjectStreamException {
            return CallableReference.NoReceiver.INSTANCE;
        }
    }
    static {
        CallableReference.NO_RECEIVER = CallableReference.NoReceiver.access$000();
    }

    public CallableReference() {
        super(CallableReference.NO_RECEIVER);
    }

    protected CallableReference(Object receiver) {
        super(receiver, 0, 0, 0, 0);
    }

    protected CallableReference(Object receiver, Class owner, String name, String signature, boolean isTopLevel) {
        super();
        this.receiver = receiver;
        this.owner = owner;
        this.name = name;
        this.signature = signature;
        this.isTopLevel = isTopLevel;
    }

    @Override // kotlin.reflect.KCallable
    public Object call(Object... args) {
        return getReflected().call(args);
    }

    @Override // kotlin.reflect.KCallable
    public Object callBy(Map args) {
        return getReflected().callBy(args);
    }

    @Override // kotlin.reflect.KCallable
    public KCallable compute() {
        KCallable result;
        if (this.reflected == null) {
            this.reflected = computeReflected();
        }
        return result;
    }

    @Override // kotlin.reflect.KCallable
    protected abstract KCallable computeReflected();

    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @Override // kotlin.reflect.KCallable
    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return this.name;
    }

    @Override // kotlin.reflect.KCallable
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

    public List<KParameter> getParameters() {
        return getReflected().getParameters();
    }

    @Override // kotlin.reflect.KCallable
    protected KCallable getReflected() {
        final KCallable compute = compute();
        if (compute == this) {
        } else {
            return compute;
        }
        KotlinReflectionNotSupportedError kotlinReflectionNotSupportedError = new KotlinReflectionNotSupportedError();
        throw kotlinReflectionNotSupportedError;
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        return getReflected().getReturnType();
    }

    @Override // kotlin.reflect.KCallable
    public String getSignature() {
        return this.signature;
    }

    public List<KTypeParameter> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
