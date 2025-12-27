package m.a.c.f;

import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: SingleInstanceFactory.kt */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0008\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0008\u0010\u0010\u001a\u00020\rH\u0016J\u0015\u0010\u0011\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\r\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u00020\u00152\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0016", d2 = {"Lorg/koin/core/instance/SingleInstanceFactory;", "T", "Lorg/koin/core/instance/InstanceFactory;", "beanDefinition", "Lorg/koin/core/definition/BeanDefinition;", "(Lorg/koin/core/definition/BeanDefinition;)V", "value", "Ljava/lang/Object;", "create", "context", "Lorg/koin/core/instance/InstanceContext;", "(Lorg/koin/core/instance/InstanceContext;)Ljava/lang/Object;", "drop", "", "scope", "Lorg/koin/core/scope/Scope;", "dropAll", "get", "getValue", "()Ljava/lang/Object;", "isCreated", "", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class SingleInstanceFactory<T> extends c<T> {

    /* renamed from: b, reason: from kotlin metadata */
    private T value;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002H\n", d2 = {"<anonymous>", "", "T"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements kotlin.d0.c.a<w> {

        final /* synthetic */ b $context;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            if (!d.this.get(this.$context)) {
                d.this.value = d.this.create(this.$context);
            }
        }

        a(d<T> dVar, b bVar) {
            this.$context = bVar;
            super(0);
        }
    }
    public d(m.a.c.e.a<T> aVar) {
        n.f(aVar, "beanDefinition");
        super(aVar);
    }

    public static final /* synthetic */ void d(d dVar, Object object) {
        dVar.value = object;
    }

    /* renamed from: e, reason: from kotlin metadata */
    private final T dropAll() {
        if (this.value == null) {
            throw new IllegalStateException("Single instance created couldn't return value".toString());
        } else {
            return this.value;
        }
    }

    @Override // m.a.c.f.c
    /* renamed from: a, reason: from kotlin metadata */
    public T create(b context) {
        Object dropAll;
        n.f(context, "context");
        if (this.value == null) {
            dropAll = super.a(context);
        } else {
            dropAll = dropAll();
        }
        return dropAll;
    }

    @Override // m.a.c.f.c
    /* renamed from: b, reason: from kotlin metadata */
    public T drop(b scope) {
        n.f(scope, "context");
        KoinPlatformTools.a.f(this, new org.koin.core.instance.d.a(this, scope));
        return dropAll();
    }

    @Override // m.a.c.f.c
    /* renamed from: f, reason: from kotlin metadata */
    public boolean get(b context) {
        boolean z = true;
        context = this.value != null ? 1 : 0;
        return (this.value != null ? 1 : 0);
    }
}
