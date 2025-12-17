package m.a.c.f;

import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;
import m.a.c.e.a;
import m.a.f.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0008\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0008\u0010\u0010\u001a\u00020\rH\u0016J\u0015\u0010\u0011\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\r\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u00020\u00152\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0016", d2 = {"Lorg/koin/core/instance/SingleInstanceFactory;", "T", "Lorg/koin/core/instance/InstanceFactory;", "beanDefinition", "Lorg/koin/core/definition/BeanDefinition;", "(Lorg/koin/core/definition/BeanDefinition;)V", "value", "Ljava/lang/Object;", "create", "context", "Lorg/koin/core/instance/InstanceContext;", "(Lorg/koin/core/instance/InstanceContext;)Ljava/lang/Object;", "drop", "", "scope", "Lorg/koin/core/scope/Scope;", "dropAll", "get", "getValue", "()Ljava/lang/Object;", "isCreated", "", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d<T>  extends m.a.c.f.c<T> {

    private T b;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002H\n", d2 = {"<anonymous>", "", "T"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements a<w> {

        final m.a.c.f.b $context;
        final m.a.c.f.d<T> this$0;
        a(m.a.c.f.d<T> d, m.a.c.f.b b2) {
            this.this$0 = d;
            this.$context = b2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            boolean this$0;
            Object $context;
            if (!this.this$0.f(this.$context)) {
                this$0 = this.this$0;
                d.d(this$0, this$0.a(this.$context));
            }
        }
    }
    public d(a<T> a) {
        n.f(a, "beanDefinition");
        super(a);
    }

    public static final void d(m.a.c.f.d d, Object object2) {
        d.b = object2;
    }

    private final T e() {
        Object obj = this.b;
        if (obj == null) {
        } else {
            return obj;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Single instance created couldn't return value".toString());
        throw illegalStateException;
    }

    public T a(m.a.c.f.b b) {
        Object obj2;
        n.f(b, "context");
        if (this.b == null) {
            obj2 = super.a(b);
        } else {
            obj2 = e();
        }
        return obj2;
    }

    public T b(m.a.c.f.b b) {
        n.f(b, "context");
        d.a aVar2 = new d.a(this, b);
        a.a.f(this, aVar2);
        return e();
    }

    @Override // m.a.c.f.c
    public boolean f(m.a.c.f.b b) {
        int obj1;
        obj1 = this.b != null ? 1 : 0;
        return obj1;
    }
}
