package m.a.c.l;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.d;
import kotlin.o;
import kotlin.y.h;
import m.a.c.a;
import m.a.c.f.b;
import m.a.c.g.b;
import m.a.c.g.c;
import m.a.c.i.a;
import m.a.c.j.a;
import m.a.c.k.a;
import m.a.c.m.a;
import m.a.e.a;
import org.koin.core.error.ClosedScopeException;
import org.koin.core.error.NoBeanDefFoundException;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\t\n\u0002\u0010 \n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0008\u0010-\u001a\u00020.H\u0002J\u0006\u0010/\u001a\u00020.J\t\u00100\u001a\u00020\u0003HÆ\u0003J\r\u00101\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003J\t\u00102\u001a\u00020\u0008HÆ\u0003J\u000e\u00103\u001a\u00020\nHÀ\u0003¢\u0006\u0002\u00084J5\u00105\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000c\u0008\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u001b\u00106\u001a\u00020.2\u000c\u00107\u001a\u0008\u0012\u0004\u0012\u00020\u000008H\u0000¢\u0006\u0002\u00089JH\u0010:\u001a\u00020.\"\u0006\u0008\u0000\u0010;\u0018\u00012\u0006\u0010<\u001a\u0002H;2\n\u0008\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\u0012\u0008\u0002\u0010>\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030?082\u0008\u0008\u0002\u0010@\u001a\u00020\u0008H\u0086\u0008¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020\u00082\u0008\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003JA\u0010D\u001a\u0004\u0018\u0001H;\"\u0004\u0008\u0000\u0010;2\n\u0010E\u001a\u0006\u0012\u0002\u0008\u00030?2\u0008\u0010=\u001a\u0004\u0018\u00010\u00032\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`HH\u0002¢\u0006\u0002\u0010IJA\u0010J\u001a\u0002H;\"\u0004\u0008\u0000\u0010;2\n\u0010E\u001a\u0006\u0012\u0002\u0008\u00030?2\n\u0008\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\u0016\u0008\u0002\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`H¢\u0006\u0002\u0010IJA\u0010J\u001a\u0002H;\"\n\u0008\u0000\u0010;\u0018\u0001*\u00020\u00012\n\u0008\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\u0016\u0008\n\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`HH\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010KJ\u001b\u0010L\u001a\u0008\u0012\u0004\u0012\u0002H;08\"\n\u0008\u0000\u0010;\u0018\u0001*\u00020\u0001H\u0086\u0008J\u001e\u0010L\u001a\u0008\u0012\u0004\u0012\u0002H;08\"\u0004\u0008\u0000\u0010;2\n\u0010E\u001a\u0006\u0012\u0002\u0008\u00030?J!\u0010M\u001a\u0004\u0018\u0001H;\"\u0004\u0008\u0000\u0010;2\n\u0010E\u001a\u0006\u0012\u0002\u0008\u00030?H\u0002¢\u0006\u0002\u0010NJ\u0006\u0010O\u001a\u00020\nJC\u0010P\u001a\u0004\u0018\u0001H;\"\u0004\u0008\u0000\u0010;2\n\u0010E\u001a\u0006\u0012\u0002\u0008\u00030?2\n\u0008\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\u0016\u0008\u0002\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`H¢\u0006\u0002\u0010IJC\u0010P\u001a\u0004\u0018\u0001H;\"\n\u0008\u0000\u0010;\u0018\u0001*\u00020\u00012\n\u0008\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\u0016\u0008\n\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`HH\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010KJ\u000e\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\u0005J\u0016\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0005J\u0010\u0010T\u001a\u0004\u0018\u00010\u00052\u0006\u0010R\u001a\u00020\u0005J\u0012\u0010U\u001a\u00020\u00002\n\u0010V\u001a\u00060\u0005j\u0002`\u0006J\t\u0010W\u001a\u00020XHÖ\u0001JL\u0010Y\u001a\u0008\u0012\u0004\u0012\u0002H;0Z\"\n\u0008\u0000\u0010;\u0018\u0001*\u00020\u00012\n\u0008\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010[\u001a\u00020\\2\u0016\u0008\n\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`HH\u0086\u0008ø\u0001\u0000JN\u0010]\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H;0Z\"\n\u0008\u0000\u0010;\u0018\u0001*\u00020\u00012\n\u0008\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010[\u001a\u00020\\2\u0016\u0008\n\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`HH\u0086\u0008ø\u0001\u0000J\u0006\u0010^\u001a\u00020\u0008J\u001f\u0010_\u001a\u00020.2\u0012\u0010`\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00000a\"\u00020\u0000¢\u0006\u0002\u0010bJ\u000e\u0010c\u001a\u00020.2\u0006\u0010d\u001a\u00020\u000eJ?\u0010e\u001a\u0002H;\"\u0004\u0008\u0000\u0010;2\u0008\u0010=\u001a\u0004\u0018\u00010\u00032\n\u0010E\u001a\u0006\u0012\u0002\u0008\u00030?2\u0014\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`HH\u0002¢\u0006\u0002\u0010gJG\u0010h\u001a\u0002H;\"\u0004\u0008\u0000\u0010;2\u0008\u0010=\u001a\u0004\u0018\u00010\u00032\n\u0010E\u001a\u0006\u0012\u0002\u0008\u00030?2\u0006\u0010i\u001a\u00020j2\u0014\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010Gj\u0004\u0018\u0001`HH\u0002¢\u0006\u0002\u0010kJ\u001e\u0010l\u001a\u00020m2\u0008\u0010=\u001a\u0004\u0018\u00010\u00032\n\u0010E\u001a\u0006\u0012\u0002\u0008\u00030?H\u0002J\u0008\u0010n\u001a\u00020\u0005H\u0016J\u001f\u0010o\u001a\u00020.2\u0012\u0010`\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00000a\"\u00020\u0000¢\u0006\u0002\u0010bR\u001e\u0010\u000c\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\u0008\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\n8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\u0013\u0010\u0014R\"\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0018\u0010\u0012\u001a\u0004\u0008\u0019\u0010\u001aR&\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u001c\u0010\u0012\u001a\u0004\u0008\u001d\u0010\u001e\"\u0004\u0008\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\"\u0010#R\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010#R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00000\rj\u0008\u0012\u0004\u0012\u00020\u0000`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\u0008)\u0010*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006p", d2 = {"Lorg/koin/core/scope/Scope;", "", "scopeQualifier", "Lorg/koin/core/qualifier/Qualifier;", "id", "", "Lorg/koin/core/scope/ScopeID;", "isRoot", "", "_koin", "Lorg/koin/core/Koin;", "(Lorg/koin/core/qualifier/Qualifier;Ljava/lang/String;ZLorg/koin/core/Koin;)V", "_callbacks", "Ljava/util/ArrayList;", "Lorg/koin/core/scope/ScopeCallback;", "Lkotlin/collections/ArrayList;", "_closed", "get_koin$annotations", "()V", "get_koin", "()Lorg/koin/core/Koin;", "_parameterStack", "Lkotlin/collections/ArrayDeque;", "Lorg/koin/core/parameter/ParametersHolder;", "get_parameterStack$annotations", "get_parameterStack", "()Lkotlin/collections/ArrayDeque;", "_source", "get_source$annotations", "get_source", "()Ljava/lang/Object;", "set_source", "(Ljava/lang/Object;)V", "closed", "getClosed", "()Z", "getId", "()Ljava/lang/String;", "linkedScopes", "logger", "Lorg/koin/core/logger/Logger;", "getLogger", "()Lorg/koin/core/logger/Logger;", "getScopeQualifier", "()Lorg/koin/core/qualifier/Qualifier;", "clearData", "", "close", "component1", "component2", "component3", "component4", "component4$koin_core", "copy", "create", "links", "", "create$koin_core", "declare", "T", "instance", "qualifier", "secondaryTypes", "Lkotlin/reflect/KClass;", "allowOverride", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;Z)V", "equals", "other", "findInOtherScope", "clazz", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "get", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAll", "getFromSource", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getKoin", "getOrNull", "getProperty", "key", "defaultValue", "getPropertyOrNull", "getScope", "scopeID", "hashCode", "", "inject", "Lkotlin/Lazy;", "mode", "Lkotlin/LazyThreadSafetyMode;", "injectOrNull", "isNotClosed", "linkTo", "scopes", "", "([Lorg/koin/core/scope/Scope;)V", "registerCallback", "callback", "resolveInstance", "parameterDef", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "resolveValue", "instanceContext", "Lorg/koin/core/instance/InstanceContext;", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lorg/koin/core/instance/InstanceContext;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "throwDefinitionNotFound", "", "toString", "unlink", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a {

    private final a a;
    private final String b;
    private final boolean c;
    private final a d;
    private final ArrayList<m.a.c.l.a> e;
    private Object f;
    private final ArrayList<Object> g;
    private final h<a> h;
    private boolean i;

    @Metadata(d1 = "\u0000\u0004\n\u0002\u0008\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001H\n", d2 = {"<anonymous>", "T"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements a<T> {

        final d<?> $clazz;
        final a<a> $parameters;
        final a $qualifier;
        final m.a.c.l.a this$0;
        a(m.a.c.l.a a, a a2, d<?> d3, a<? extends a> a4) {
            this.this$0 = a;
            this.$qualifier = a2;
            this.$clazz = d3;
            this.$parameters = a4;
            super(0);
        }

        public final T invoke() {
            return a.a(this.this$0, this.$qualifier, this.$clazz, this.$parameters);
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002H\n", d2 = {"<anonymous>", "", "T"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<String> {

        final d<?> $clazz;
        final a $qualifier;
        b(d<?> d, a a2) {
            this.$clazz = d;
            this.$qualifier = a2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final String invoke() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('\'');
            stringBuilder.append(a.a(this.$clazz));
            stringBuilder.append("' - q:'");
            stringBuilder.append(this.$qualifier);
            stringBuilder.append("' look in injected parameters");
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002H\n", d2 = {"<anonymous>", "", "T"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<String> {

        final d<?> $clazz;
        final a $qualifier;
        c(d<?> d, a a2) {
            this.$clazz = d;
            this.$qualifier = a2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final String invoke() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('\'');
            stringBuilder.append(a.a(this.$clazz));
            stringBuilder.append("' - q:'");
            stringBuilder.append(this.$qualifier);
            stringBuilder.append("' look at scope source");
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002H\n", d2 = {"<anonymous>", "", "T"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<String> {

        final d<?> $clazz;
        final a $qualifier;
        d(d<?> d, a a2) {
            this.$clazz = d;
            this.$qualifier = a2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final String invoke() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('\'');
            stringBuilder.append(a.a(this.$clazz));
            stringBuilder.append("' - q:'");
            stringBuilder.append(this.$qualifier);
            stringBuilder.append("' look in other scopes");
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002H\n", d2 = {"<anonymous>", "", "T"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<String> {

        final d<?> $clazz;
        final a $qualifier;
        e(d<?> d, a a2) {
            this.$clazz = d;
            this.$qualifier = a2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final String invoke() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('\'');
            stringBuilder.append(a.a(this.$clazz));
            stringBuilder.append("' - q:'");
            stringBuilder.append(this.$qualifier);
            stringBuilder.append("' not found");
            return stringBuilder.toString();
        }
    }
    public a(a a, String string2, boolean z3, a a4) {
        n.f(a, "scopeQualifier");
        n.f(string2, "id");
        n.f(a4, "_koin");
        super();
        this.a = a;
        this.b = string2;
        this.c = z3;
        this.d = a4;
        ArrayList obj2 = new ArrayList();
        this.e = obj2;
        obj2 = new ArrayList();
        this.g = obj2;
        obj2 = new h();
        this.h = obj2;
    }

    public static final Object a(m.a.c.l.a a, a a2, d d3, a a4) {
        return a.j(a2, d3, a4);
    }

    private final <T> T b(d<?> d, a a2, a<? extends a> a3) {
        int i;
        boolean next;
        Iterator iterator = this.e.iterator();
        i = 0;
        while (iterator.hasNext()) {
            if ((a)iterator.next().e(d, a2, a3) == 0) {
            }
        }
        return i;
    }

    private final <T> T j(a a, d<?> d2, a<? extends a> a3) {
        Object invoke;
        h hVar;
        Object obj5;
        if (this.i) {
        } else {
            if (a3 == null) {
                invoke = 0;
            } else {
                invoke = a3.invoke();
            }
            if (invoke != null) {
                this.h.addFirst(invoke);
            }
            b bVar = new b(this.d, this, invoke);
            if (invoke != null) {
                this.h.removeFirst();
            }
            return k(a, d2, bVar, a3);
        }
        obj5 = new StringBuilder();
        obj5.append("Scope '");
        obj5.append(this.b);
        obj5.append("' is closed");
        ClosedScopeException obj4 = new ClosedScopeException(obj5.toString());
        throw obj4;
    }

    private final <T> T k(a a, d<?> d2, b b3, a<? extends a> a4) {
        Object dEBUG;
        p bVar;
        Object obj6;
        int i = 0;
        if (this.d.b().e(a, d2, this.a, b3) == null) {
            dEBUG = b.DEBUG;
            bVar = new a.b(d2, a);
            g().c().h(dEBUG, bVar);
            obj6 = h().w();
            if ((a)obj6 == null) {
                obj6 = i;
            } else {
                obj6 = (a)obj6.b(d2);
            }
            if (obj6 == null) {
                bVar = new a.c(d2, a);
                g().c().h(dEBUG, bVar);
                obj6 = i();
                if (obj6 == null) {
                    obj6 = i;
                } else {
                    if (d2.q(obj6)) {
                        obj6 = i();
                    } else {
                    }
                }
            }
        }
        if (obj6 == null) {
            dEBUG = b.DEBUG;
            bVar = new a.d(d2, a);
            g().c().h(dEBUG, bVar);
            if (b(d2, a, a4) == null) {
            } else {
            }
            a.e obj7 = new a.e(d2, a);
            g().c().h(dEBUG, obj7);
            h().clear();
            l(a, d2);
            throw i;
        }
        return obj6;
    }

    private final Void l(a a, d<?> d2) {
        String str2;
        StringBuilder stringBuilder;
        String str;
        Object obj5;
        str2 = "";
        final int i = 39;
        if (a == null) {
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(" & qualifier:'");
            stringBuilder.append(a);
            stringBuilder.append(i);
            obj5 = stringBuilder.toString();
            if (obj5 == null) {
            } else {
                str2 = obj5;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("No definition found for class:'");
        stringBuilder2.append(a.a(d2));
        stringBuilder2.append(i);
        stringBuilder2.append(str2);
        stringBuilder2.append(". Check your definitions!");
        obj5 = new NoBeanDefFoundException(stringBuilder2.toString());
        throw obj5;
    }

    public final <T> T c(d<?> d, a a2, a<? extends a> a3) {
        String str2;
        String string;
        String str;
        n.f(d, "clazz");
        if (this.d.c().f(b.DEBUG)) {
            str2 = "";
            int i = 39;
            if (a2 == null) {
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" with qualifier '");
                stringBuilder.append(a2);
                stringBuilder.append(i);
                string = stringBuilder.toString();
                if (string == null) {
                } else {
                    str2 = string;
                }
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("+- '");
            stringBuilder3.append(a.a(d));
            stringBuilder3.append(i);
            stringBuilder3.append(str2);
            this.d.c().b(stringBuilder3.toString());
            a.a aVar2 = new a.a(this, a2, d, a3);
            o obj7 = a.b(aVar2);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("|- '");
            stringBuilder2.append(a.a(d));
            stringBuilder2.append("' in ");
            stringBuilder2.append((Number)obj7.b().doubleValue());
            stringBuilder2.append(" ms");
            this.d.c().b(stringBuilder2.toString());
            return obj7.a();
        }
        return j(a2, d, a3);
    }

    public final String d() {
        return this.b;
    }

    public final <T> T e(d<?> d, a a2, a<? extends a> a3) {
        String str;
        Object obj4;
        a obj5;
        a obj6;
        final String str2 = " on scope ";
        n.f(d, "clazz");
        int i = 0;
        return c(d, a2, a3);
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof a) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        if (this.c != object.c) {
            return i2;
        }
        if (!n.b(this.d, object.d)) {
            return i2;
        }
        return i;
    }

    public final a f() {
        return this.a;
    }

    public final a g() {
        return this.d;
    }

    public final h<a> h() {
        return this.h;
    }

    public int hashCode() {
        boolean z;
        if (this.c) {
            z = 1;
        }
        return i6 += i9;
    }

    public final Object i() {
        return this.f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("['");
        stringBuilder.append(this.b);
        stringBuilder.append("']");
        return stringBuilder.toString();
    }
}
