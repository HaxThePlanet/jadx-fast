package m.a.c.f;

import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import m.a.c.a;
import m.a.c.e.a;
import m.a.c.g.b;
import m.a.c.g.c;
import m.a.c.i.b;
import m.a.f.a;
import org.koin.core.error.InstanceCreationException;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008&\u0018\u0000 \u0014*\u0004\u0008\u0000\u0010\u00012\u00020\u0002:\u0001\u0014B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0008\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u000c\u001a\u00020\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0008\u0010\u0010\u001a\u00020\rH&J\u0015\u0010\u0011\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u0012\u001a\u00020\u00132\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0015", d2 = {"Lorg/koin/core/instance/InstanceFactory;", "T", "", "beanDefinition", "Lorg/koin/core/definition/BeanDefinition;", "(Lorg/koin/core/definition/BeanDefinition;)V", "getBeanDefinition", "()Lorg/koin/core/definition/BeanDefinition;", "create", "context", "Lorg/koin/core/instance/InstanceContext;", "(Lorg/koin/core/instance/InstanceContext;)Ljava/lang/Object;", "drop", "", "scope", "Lorg/koin/core/scope/Scope;", "dropAll", "get", "isCreated", "", "Companion", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class c<T>  {

    private final a<T> a;
    static {
    }

    public c(a<T> a) {
        n.f(a, "beanDefinition");
        super();
        this.a = a;
    }

    public T a(m.a.c.f.b b) {
        boolean z;
        m.a.c.i.a aVar;
        Object dEBUG;
        String str;
        n.f(b, "context");
        a aVar2 = b.a();
        if (aVar2.c().f(b.DEBUG)) {
            aVar2.c().b(n.o("| create instance for ", this.a));
        }
        if (b.b() == null) {
            aVar = b.a();
        }
        return this.a.a().invoke(b.c(), aVar);
    }

    public abstract T b(m.a.c.f.b b);

    public final a<T> c() {
        return this.a;
    }
}
