package m.a.c.e;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.d;
import kotlin.y.p;
import m.a.c.i.a;
import m.a.c.j.a;
import m.a.c.k.c;
import m.a.c.k.c.a;
import m.a.c.l.a;
import m.a.e.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0019\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002Bj\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012'\u0010\u0008\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\tj\u0008\u0012\u0004\u0012\u00028\u0000`\u000c¢\u0006\u0002\u0008\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0012\u0008\u0002\u0010\u0010\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00060\u0011¢\u0006\u0002\u0010\u0012J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\r\u0010'\u001a\u0006\u0012\u0002\u0008\u00030\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J*\u0010)\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\tj\u0008\u0012\u0004\u0012\u00028\u0000`\u000c¢\u0006\u0002\u0008\rHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\u0013\u0010+\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00060\u0011HÆ\u0003J|\u0010,\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u000c\u0008\u0002\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042)\u0008\u0002\u0010\u0008\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\tj\u0008\u0012\u0004\u0012\u00028\u0000`\u000c¢\u0006\u0002\u0008\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0012\u0008\u0002\u0010\u0010\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00060\u0011HÆ\u0001J\u0013\u0010-\u001a\u00020.2\u0008\u0010/\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0012\u00100\u001a\u00020.2\n\u00101\u001a\u0006\u0012\u0002\u0008\u00030\u0006J\u0008\u00102\u001a\u000203H\u0016J$\u00104\u001a\u00020.2\n\u00101\u001a\u0006\u0012\u0002\u0008\u00030\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u00105\u001a\u00020\u0004J\u0008\u00106\u001a\u000207H\u0016R \u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R2\u0010\u0008\u001a#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\tj\u0008\u0012\u0004\u0012\u00028\u0000`\u000c¢\u0006\u0002\u0008\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0015\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010 R$\u0010\u0010\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00060\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\"\u0010#\"\u0004\u0008$\u0010%¨\u00068", d2 = {"Lorg/koin/core/definition/BeanDefinition;", "T", "", "scopeQualifier", "Lorg/koin/core/qualifier/Qualifier;", "primaryType", "Lkotlin/reflect/KClass;", "qualifier", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "kind", "Lorg/koin/core/definition/Kind;", "secondaryTypes", "", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function2;Lorg/koin/core/definition/Kind;Ljava/util/List;)V", "callbacks", "Lorg/koin/core/definition/Callbacks;", "getCallbacks", "()Lorg/koin/core/definition/Callbacks;", "setCallbacks", "(Lorg/koin/core/definition/Callbacks;)V", "getDefinition", "()Lkotlin/jvm/functions/Function2;", "getKind", "()Lorg/koin/core/definition/Kind;", "getPrimaryType", "()Lkotlin/reflect/KClass;", "getQualifier", "()Lorg/koin/core/qualifier/Qualifier;", "getScopeQualifier", "getSecondaryTypes", "()Ljava/util/List;", "setSecondaryTypes", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hasType", "clazz", "hashCode", "", "is", "scopeDefinition", "toString", "", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a<T>  {

    private final a a;
    private final d<?> b;
    private final a c;
    private final p<a, a, T> d;
    private final m.a.c.e.d e;
    private List<? extends d<?>> f;
    private m.a.c.e.c<T> g;

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\n", d2 = {"<anonymous>", "", "T", "it", "Lkotlin/reflect/KClass;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<d<?>, java.lang.CharSequence> {

        public static final m.a.c.e.a.a a;
        static {
            a.a aVar = new a.a();
            a.a.a = aVar;
        }

        a() {
            super(1);
        }

        public final java.lang.CharSequence a(d<?> d) {
            n.f(d, "it");
            return a.a(d);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((d)object);
        }
    }
    public a(a a, d<?> d2, a a3, p<? super a, ? super a, ? extends T> p4, m.a.c.e.d d5, List<? extends d<?>> list6) {
        n.f(a, "scopeQualifier");
        n.f(d2, "primaryType");
        n.f(p4, "definition");
        n.f(d5, "kind");
        n.f(list6, "secondaryTypes");
        super();
        this.a = a;
        this.b = d2;
        this.c = a3;
        this.d = p4;
        this.e = d5;
        this.f = list6;
        final int obj3 = 0;
        c obj2 = new c(obj3, 1, obj3);
        this.g = obj2;
    }

    public final p<a, a, T> a() {
        return this.d;
    }

    public final d<?> b() {
        return this.b;
    }

    public final a c() {
        return this.c;
    }

    public final a d() {
        return this.a;
    }

    public final List<d<?>> e() {
        return this.f;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        Objects.requireNonNull(object, "null cannot be cast to non-null type org.koin.core.definition.BeanDefinition<*>");
        int i2 = 0;
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        if (!n.b(this.c, object.c)) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        return i;
    }

    public final void f(List<? extends d<?>> list) {
        n.f(list, "<set-?>");
        this.f = list;
    }

    public int hashCode() {
        int i;
        a aVar = this.c;
        if (aVar == null) {
            i = 0;
        } else {
            i = aVar.hashCode();
        }
        return i4 += i7;
    }

    public String toString() {
        a aVar;
        String str3;
        String str4;
        String str6;
        Object str5;
        int str2;
        List list;
        String str;
        int i4;
        int i6;
        int i5;
        int i;
        m.a.c.e.a.a aVar2;
        int i3;
        int i2;
        StringBuilder stringBuilder = new StringBuilder();
        int i9 = 39;
        stringBuilder.append(i9);
        stringBuilder.append(a.a(this.b));
        stringBuilder.append(i9);
        str3 = "";
        if (this.c == null) {
            aVar = str3;
        } else {
        }
        if (n.b(this.a, c.e.a())) {
            str6 = str3;
        } else {
            str6 = n.o(",scope:", d());
        }
        if (empty ^= 1 != 0) {
            str3 = n.o(",binds:", p.h0(this.f, ",", 0, 0, 0, 0, a.a.a, 30, 0));
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append('[');
        stringBuilder2.append(this.e.toString());
        stringBuilder2.append(':');
        stringBuilder2.append(stringBuilder.toString());
        stringBuilder2.append(aVar);
        stringBuilder2.append(str6);
        stringBuilder2.append(str3);
        stringBuilder2.append(']');
        return stringBuilder2.toString();
    }
}
