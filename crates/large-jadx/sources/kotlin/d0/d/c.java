package kotlin.d0.d;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.d0.b;
import kotlin.i0.b;
import kotlin.i0.c;
import kotlin.i0.f;
import kotlin.i0.k;
import kotlin.i0.o;
import kotlin.i0.p;
import kotlin.i0.t;

/* loaded from: classes3.dex */
public abstract class c implements c, Serializable {

    public static final Object NO_RECEIVER;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient c reflected;
    private final String signature;

    private static class a implements Serializable {

        private static final kotlin.d0.d.c.a a;
        static {
            c.a aVar = new c.a();
            c.a.a = aVar;
        }

        static kotlin.d0.d.c.a a() {
            return c.a.a;
        }

        private Object readResolve() {
            return c.a.a;
        }
    }
    static {
        c.NO_RECEIVER = c.a.a();
    }

    public c() {
        super(c.NO_RECEIVER);
    }

    protected c(Object object) {
        super(object, 0, 0, 0, 0);
    }

    protected c(Object object, Class class2, String string3, String string4, boolean z5) {
        super();
        this.receiver = object;
        this.owner = class2;
        this.name = string3;
        this.signature = string4;
        this.isTopLevel = z5;
    }

    @Override // kotlin.i0.c
    public Object call(Object... objectArr) {
        return getReflected().call(objectArr);
    }

    @Override // kotlin.i0.c
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    @Override // kotlin.i0.c
    public c compute() {
        c reflected;
        if (this.reflected == null) {
            this.reflected = computeReflected();
        }
        return reflected;
    }

    @Override // kotlin.i0.c
    protected abstract c computeReflected();

    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @Override // kotlin.i0.c
    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // kotlin.i0.c
    public String getName() {
        return this.name;
    }

    @Override // kotlin.i0.c
    public f getOwner() {
        int i;
        boolean isTopLevel;
        Class owner = this.owner;
        if (owner == null) {
            i = 0;
        } else {
            if (this.isTopLevel) {
                i = c0.c(owner);
            } else {
                i = c0.b(owner);
            }
        }
        return i;
    }

    public List<k> getParameters() {
        return getReflected().getParameters();
    }

    @Override // kotlin.i0.c
    protected c getReflected() {
        c compute = compute();
        if (compute == this) {
        } else {
            return compute;
        }
        b bVar = new b();
        throw bVar;
    }

    @Override // kotlin.i0.c
    public o getReturnType() {
        return getReflected().getReturnType();
    }

    @Override // kotlin.i0.c
    public String getSignature() {
        return this.signature;
    }

    public List<p> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // kotlin.i0.c
    public t getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // kotlin.i0.c
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // kotlin.i0.c
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // kotlin.i0.c
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // kotlin.i0.c
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
