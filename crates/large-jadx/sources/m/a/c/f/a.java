package m.a.c.f;

import kotlin.Metadata;
import kotlin.d0.d.n;
import m.a.c.e.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0016J\u0008\u0010\n\u001a\u00020\u0007H\u0016J\u0015\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u000c\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u0011", d2 = {"Lorg/koin/core/instance/FactoryInstanceFactory;", "T", "Lorg/koin/core/instance/InstanceFactory;", "beanDefinition", "Lorg/koin/core/definition/BeanDefinition;", "(Lorg/koin/core/definition/BeanDefinition;)V", "drop", "", "scope", "Lorg/koin/core/scope/Scope;", "dropAll", "get", "context", "Lorg/koin/core/instance/InstanceContext;", "(Lorg/koin/core/instance/InstanceContext;)Ljava/lang/Object;", "isCreated", "", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a<T>  extends m.a.c.f.c<T> {
    public a(a<T> a) {
        n.f(a, "beanDefinition");
        super(a);
    }

    public T b(m.a.c.f.b b) {
        n.f(b, "context");
        return a(b);
    }
}
