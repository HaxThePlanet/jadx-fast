package m.a.c.f;

import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import m.a.c.g.c;
import org.koin.core.error.InstanceCreationException;

/* compiled from: InstanceFactory.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008&\u0018\u0000 \u0014*\u0004\u0008\u0000\u0010\u00012\u00020\u0002:\u0001\u0014B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0008\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u000c\u001a\u00020\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0008\u0010\u0010\u001a\u00020\rH&J\u0015\u0010\u0011\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u0012\u001a\u00020\u00132\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0015", d2 = {"Lorg/koin/core/instance/InstanceFactory;", "T", "", "beanDefinition", "Lorg/koin/core/definition/BeanDefinition;", "(Lorg/koin/core/definition/BeanDefinition;)V", "getBeanDefinition", "()Lorg/koin/core/definition/BeanDefinition;", "create", "context", "Lorg/koin/core/instance/InstanceContext;", "(Lorg/koin/core/instance/InstanceContext;)Ljava/lang/Object;", "drop", "", "scope", "Lorg/koin/core/scope/Scope;", "dropAll", "get", "isCreated", "", "Companion", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
/* renamed from: c, reason: from kotlin metadata */
public abstract class InstanceFactory<T> {

    private final m.a.c.e.a<T> a;
    public c(m.a.c.e.a<T> aVar) {
        n.f(aVar, "beanDefinition");
        super();
        this.a = aVar;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public T create(b context) throws InstanceCreationException {
        m.a.c.i.a aVar;
        n.f(context, "context");
        m.a.c.a aVar2 = context.a();
        if (aVar2.c().f(Level.DEBUG)) {
            str = "| create instance for ";
            aVar2.c().b(n.o(str, this.a));
        }
        try {
            if (context.b() == null) {
                aVar = org.koin.core.parameter.b.a();
            }
        } catch (Exception e) {
            m.a.f.a aVar3 = KoinPlatformTools.a;
            aVar3 = aVar3.d(e);
            c instanceCreationException = instanceCreationException.c();
            StringBuilder str3 = new StringBuilder();
            String str5 = "Instance creation error : could not create instance for ";
            str5 = ": ";
            aVar3 = this.a + this.a + this.a + aVar3;
            instanceCreationException.d(aVar3);
            str3 = "Could not create instance for ";
            aVar3 = n.o(str3, this.a);
            instanceCreationException = new InstanceCreationException(aVar3, e);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) instanceCreationException;
        }
        return this.a.a().invoke(context.c(), aVar);
    }

    /* renamed from: c, reason: from kotlin metadata */
    public final m.a.c.e.a<T> dropAll() {
        return this.a;
    }


    /* renamed from: b, reason: from kotlin metadata */
    public abstract T drop(b scope);
}
