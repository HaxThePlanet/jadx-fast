package m.a.c.e;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.i0.d;
import m.a.c.k.c;
import m.a.c.k.c.a;

/* compiled from: BeanDefinition.kt */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0019\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002Bj\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012'\u0010\u0008\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\tj\u0008\u0012\u0004\u0012\u00028\u0000`\u000c¢\u0006\u0002\u0008\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0012\u0008\u0002\u0010\u0010\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00060\u0011¢\u0006\u0002\u0010\u0012J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\r\u0010'\u001a\u0006\u0012\u0002\u0008\u00030\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J*\u0010)\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\tj\u0008\u0012\u0004\u0012\u00028\u0000`\u000c¢\u0006\u0002\u0008\rHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\u0013\u0010+\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00060\u0011HÆ\u0003J|\u0010,\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u000c\u0008\u0002\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042)\u0008\u0002\u0010\u0008\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\tj\u0008\u0012\u0004\u0012\u00028\u0000`\u000c¢\u0006\u0002\u0008\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0012\u0008\u0002\u0010\u0010\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00060\u0011HÆ\u0001J\u0013\u0010-\u001a\u00020.2\u0008\u0010/\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0012\u00100\u001a\u00020.2\n\u00101\u001a\u0006\u0012\u0002\u0008\u00030\u0006J\u0008\u00102\u001a\u000203H\u0016J$\u00104\u001a\u00020.2\n\u00101\u001a\u0006\u0012\u0002\u0008\u00030\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u00105\u001a\u00020\u0004J\u0008\u00106\u001a\u000207H\u0016R \u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R2\u0010\u0008\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\tj\u0008\u0012\u0004\u0012\u00028\u0000`\u000c¢\u0006\u0002\u0008\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0015\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010 R$\u0010\u0010\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00060\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\"\u0010#\"\u0004\u0008$\u0010%¨\u00068", d2 = {"Lorg/koin/core/definition/BeanDefinition;", "T", "", "scopeQualifier", "Lorg/koin/core/qualifier/Qualifier;", "primaryType", "Lkotlin/reflect/KClass;", "qualifier", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "kind", "Lorg/koin/core/definition/Kind;", "secondaryTypes", "", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function2;Lorg/koin/core/definition/Kind;Ljava/util/List;)V", "callbacks", "Lorg/koin/core/definition/Callbacks;", "getCallbacks", "()Lorg/koin/core/definition/Callbacks;", "setCallbacks", "(Lorg/koin/core/definition/Callbacks;)V", "getDefinition", "()Lkotlin/jvm/functions/Function2;", "getKind", "()Lorg/koin/core/definition/Kind;", "getPrimaryType", "()Lkotlin/reflect/KClass;", "getQualifier", "()Lorg/koin/core/qualifier/Qualifier;", "getScopeQualifier", "getSecondaryTypes", "()Ljava/util/List;", "setSecondaryTypes", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hasType", "clazz", "hashCode", "", "is", "scopeDefinition", "toString", "", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
/* renamed from: a, reason: from kotlin metadata */
public final /* data */ class BeanDefinition<T> {

    private final m.a.c.j.a a;
    private final d<?> b;
    private final m.a.c.j.a c;
    private final kotlin.d0.c.p<m.a.c.l.a, m.a.c.i.a, T> d;
    private final d e;
    private List<? extends d<?>> f;
    private c<T> g = new c<>(0, 1, 0);

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\n", d2 = {"<anonymous>", "", "T", "it", "Lkotlin/reflect/KClass;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements l<d<?>, java.lang.CharSequence> {

        public static final a.a a = new a$a();
        @Override // kotlin.d0.d.p
        public final java.lang.CharSequence a(d<?> dVar) {
            n.f(dVar, "it");
            return a.a(dVar);
        }


        a() {
            super(1);
        }
    }
    public a(m.a.c.j.a aVar, d<?> dVar, m.a.c.j.a aVar2, kotlin.d0.c.p<? super m.a.c.l.a, ? super m.a.c.i.a, ? extends T> pVar, d dVar2, List<? extends d<?>> list) {
        n.f(aVar, "scopeQualifier");
        n.f(dVar, "primaryType");
        n.f(pVar, "definition");
        n.f(dVar2, "kind");
        n.f(list, "secondaryTypes");
        super();
        this.a = aVar;
        this.b = dVar;
        this.c = aVar2;
        this.d = pVar;
        this.e = dVar2;
        this.f = list;
        final l lVar = null;
        final m.a.c.e.c callbacks = new Callbacks(lVar, 1, lVar);
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final kotlin.d0.c.p<m.a.c.l.a, m.a.c.i.a, T> component1() {
        return this.d;
    }

    public final d<?> b() {
        return this.b;
    }

    public final m.a.c.j.a c() {
        return this.c;
    }

    public final m.a.c.j.a d() {
        return this.a;
    }

    public final List<d<?>> e() {
        return this.f;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        Objects.requireNonNull(other, "null cannot be cast to non-null type org.koin.core.definition.BeanDefinition<*>");
        boolean z4 = false;
        if (!n.b(this.b, other.b)) {
            return false;
        }
        if (!n.b(this.c, other.c)) {
            return false;
        }
        return !n.b(this.a, other.a) ? z4 : z;
    }

    /* renamed from: f, reason: from kotlin metadata */
    public final void hasType(List<? extends d<?>> clazz) {
        n.f(clazz, "<set-?>");
        this.f = clazz;
    }

    public int hashCode() {
        int i = 0;
        if (this.c == null) {
            i = 0;
        } else {
            i = this.c.hashCode();
        }
        return (i * 31) + this.b.hashCode() * 31 + this.a.hashCode();
    }

    public String toString() {
        String str;
        String str2;
        String obj2 = this.e.toString();
        StringBuilder stringBuilder = new StringBuilder();
        char c = '\'';
        String str7 = a.a(this.b);
        str6 = c + str7 + c;
        str = "";
        String r2 = str;
        if (n.b(this.a, ScopeRegistry.e.a())) {
        } else {
            str3 = ",scope:";
            str = n.o(str3, d());
        }
        i = !this.f.isEmpty();
        if (!this.f.isEmpty()) {
            java.lang.CharSequence charSequence = null;
            java.lang.CharSequence charSequence2 = null;
            int i2 = 0;
            java.lang.CharSequence charSequence3 = null;
            int i3 = 30;
            Object obj = null;
            str4 = ",";
            str = n.o(",binds:", z.h0(this.f, str4, charSequence, charSequence2, i2, charSequence3, org.koin.core.definition.a.a.a, i3, obj));
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        str5 = 91 + obj2 + 58 + str6 + str + str + str + 93;
        return str5;
    }
}
