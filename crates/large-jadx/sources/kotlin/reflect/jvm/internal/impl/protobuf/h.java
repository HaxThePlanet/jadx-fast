package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class h extends kotlin.reflect.jvm.internal.impl.protobuf.a implements Serializable {

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            h.a.a = iArr;
            iArr[w.c.MESSAGE.ordinal()] = 1;
            h.a.a[w.c.ENUM.ordinal()] = 2;
        }
    }

    public static class f {

        final ContainingType a;
        final Type b;
        final kotlin.reflect.jvm.internal.impl.protobuf.o c;
        final kotlin.reflect.jvm.internal.impl.protobuf.h.e d;
        final Method e = null;
        f(ContainingType containingtype, Type type2, kotlin.reflect.jvm.internal.impl.protobuf.o o3, kotlin.reflect.jvm.internal.impl.protobuf.h.e h$e4, Class class5) {
            int obj3;
            Object obj4;
            Object obj5;
            super();
            if (containingtype == null) {
            } else {
                if (e4.d() == w.b.MESSAGE) {
                    if (o3 == null) {
                    } else {
                    }
                    obj3 = new IllegalArgumentException("Null messageDefaultInstance");
                    throw obj3;
                }
                this.a = containingtype;
                this.b = type2;
                this.c = o3;
                this.d = e4;
                if (i.a.class.isAssignableFrom(class5)) {
                    obj3 = new Class[1];
                    this.e = h.e(class5, "valueOf", Integer.TYPE);
                } else {
                    obj3 = 0;
                }
            }
            obj3 = new IllegalArgumentException("Null containingTypeDefaultInstance");
            throw obj3;
        }

        Object a(Object object) {
            kotlin.reflect.jvm.internal.impl.protobuf.w.c eNUM;
            if (this.d.b() && this.d.g() == w.c.ENUM) {
                if (this.d.g() == w.c.ENUM) {
                    ArrayList arrayList = new ArrayList();
                    Iterator obj3 = (List)object.iterator();
                    for (Object next2 : obj3) {
                        arrayList.add(e(next2));
                    }
                    return arrayList;
                }
                return object;
            }
            return e(object);
        }

        public ContainingType b() {
            return this.a;
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.o c() {
            return this.c;
        }

        public int d() {
            return this.d.getNumber();
        }

        Object e(Object object) {
            Object cVar;
            kotlin.reflect.jvm.internal.impl.protobuf.w.c eNUM;
            Object[] arr;
            int i;
            Object obj5;
            if (this.d.g() == w.c.ENUM) {
                arr = new Object[1];
                obj5 = h.f(this.e, 0, (Integer)object);
            }
            return obj5;
        }

        Object f(Object object) {
            Integer obj3;
            if (this.d.g() == w.c.ENUM) {
                obj3 = Integer.valueOf((i.a)object.getNumber());
            }
            return obj3;
        }
    }

    static final class e implements kotlin.reflect.jvm.internal.impl.protobuf.g.b<kotlin.reflect.jvm.internal.impl.protobuf.h.e> {

        final kotlin.reflect.jvm.internal.impl.protobuf.i.b<?> a;
        final int b;
        final kotlin.reflect.jvm.internal.impl.protobuf.w.b c;
        final boolean v;
        final boolean w;
        e(kotlin.reflect.jvm.internal.impl.protobuf.i.b<?> i$b, int i2, kotlin.reflect.jvm.internal.impl.protobuf.w.b w$b3, boolean z4, boolean z5) {
            super();
            this.a = b;
            this.b = i2;
            this.c = b3;
            this.v = z4;
            this.w = z5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g$b
        public int a(kotlin.reflect.jvm.internal.impl.protobuf.h.e h$e) {
            return i -= obj2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g$b
        public boolean b() {
            return this.v;
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.i.b<?> c() {
            return this.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g$b
        public int compareTo(Object object) {
            return a((h.e)object);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g$b
        public kotlin.reflect.jvm.internal.impl.protobuf.w.b d() {
            return this.c;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g$b
        public kotlin.reflect.jvm.internal.impl.protobuf.w.c g() {
            return this.c.getJavaType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g$b
        public int getNumber() {
            return this.b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g$b
        public kotlin.reflect.jvm.internal.impl.protobuf.o.a h(kotlin.reflect.jvm.internal.impl.protobuf.o.a o$a, kotlin.reflect.jvm.internal.impl.protobuf.o o2) {
            return (h.b)a.f((h)o2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g$b
        public boolean isPacked() {
            return this.w;
        }
    }

    public static abstract class b extends kotlin.reflect.jvm.internal.impl.protobuf.a.a<BuilderType> {

        private kotlin.reflect.jvm.internal.impl.protobuf.d a;
        protected b() {
            super();
            this.a = d.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a$a
        public Object clone() {
            return d();
        }

        public BuilderType d() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
            throw unsupportedOperationException;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a$a
        public final kotlin.reflect.jvm.internal.impl.protobuf.d e() {
            return this.a;
        }

        public abstract BuilderType f(MessageType messagetype);

        public final BuilderType g(kotlin.reflect.jvm.internal.impl.protobuf.d d) {
            this.a = d;
            return this;
        }
    }

    public static abstract class c extends kotlin.reflect.jvm.internal.impl.protobuf.h.b<MessageType, BuilderType> implements kotlin.reflect.jvm.internal.impl.protobuf.p {

        private kotlin.reflect.jvm.internal.impl.protobuf.g<kotlin.reflect.jvm.internal.impl.protobuf.h.e> b;
        private boolean c;
        protected c() {
            super();
            this.b = g.g();
        }

        static kotlin.reflect.jvm.internal.impl.protobuf.g h(kotlin.reflect.jvm.internal.impl.protobuf.h.c h$c) {
            return c.j();
        }

        private kotlin.reflect.jvm.internal.impl.protobuf.g<kotlin.reflect.jvm.internal.impl.protobuf.h.e> j() {
            this.b.q();
            this.c = false;
            return this.b;
        }

        private void k() {
            boolean z;
            if (!this.c) {
                this.b = this.b.b();
                this.c = true;
            }
        }

        protected final void l(MessageType messagetype) {
            k();
            this.b.r(h.d.l(messagetype));
        }
    }

    public static abstract class d extends kotlin.reflect.jvm.internal.impl.protobuf.h implements kotlin.reflect.jvm.internal.impl.protobuf.p {

        private final kotlin.reflect.jvm.internal.impl.protobuf.g<kotlin.reflect.jvm.internal.impl.protobuf.h.e> extensions;
        protected d() {
            super();
            this.extensions = g.t();
        }

        protected d(kotlin.reflect.jvm.internal.impl.protobuf.h.c<MessageType, ?> h$c) {
            super();
            this.extensions = h.c.h(c);
        }

        static kotlin.reflect.jvm.internal.impl.protobuf.g l(kotlin.reflect.jvm.internal.impl.protobuf.h.d h$d) {
            return d.extensions;
        }

        private void t(kotlin.reflect.jvm.internal.impl.protobuf.h.f<MessageType, ?> h$f) {
            if (f.b() != getDefaultInstanceForType()) {
            } else {
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            throw obj2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        protected void g() {
            this.extensions.q();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        protected boolean j(kotlin.reflect.jvm.internal.impl.protobuf.e e, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream codedOutputStream2, kotlin.reflect.jvm.internal.impl.protobuf.f f3, int i4) {
            return h.d(this.extensions, getDefaultInstanceForType(), e, codedOutputStream2, f3, i4);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        protected boolean m() {
            return this.extensions.n();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        protected int n() {
            return this.extensions.k();
        }

        public final <Type> Type o(kotlin.reflect.jvm.internal.impl.protobuf.h.f<MessageType, Type> h$f) {
            t(f);
            Object obj = this.extensions.h(f.d);
            if (obj == null) {
                return f.b;
            }
            return f.a(obj);
        }

        public final <Type> Type p(kotlin.reflect.jvm.internal.impl.protobuf.h.f<MessageType, List<Type>> h$f, int i2) {
            t(f);
            return f.e(this.extensions.i(f.d, i2));
        }

        public final <Type> int q(kotlin.reflect.jvm.internal.impl.protobuf.h.f<MessageType, List<Type>> h$f) {
            t(f);
            return this.extensions.j(f.d);
        }

        public final <Type> boolean r(kotlin.reflect.jvm.internal.impl.protobuf.h.f<MessageType, Type> h$f) {
            t(f);
            return this.extensions.m(f.d);
        }

        protected kotlin.reflect.jvm.internal.impl.protobuf.h.d.a<MessageType> s() {
            h.d.a aVar = new h.d.a(this, 0, 0);
            return aVar;
        }
    }
    protected h(kotlin.reflect.jvm.internal.impl.protobuf.h.b h$b) {
        super();
    }

    static boolean d(kotlin.reflect.jvm.internal.impl.protobuf.g g, kotlin.reflect.jvm.internal.impl.protobuf.o o2, kotlin.reflect.jvm.internal.impl.protobuf.e e3, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream codedOutputStream4, kotlin.reflect.jvm.internal.impl.protobuf.f f5, int i6) {
        return h.k(g, o2, e3, codedOutputStream4, f5, i6);
    }

    static Method e(Class class, String string2, Class... class3Arr3) {
        try {
            return class.getMethod(string2, class3Arr3);
            class = class.getName();
            class = String.valueOf(class);
            class = String.valueOf(class);
            string2 = String.valueOf(string2);
            string2 = String.valueOf(string2);
            int str = class.length();
            str += 45;
            str += length;
            StringBuilder stringBuilder = new StringBuilder(str);
            str = "Generated message class \"";
            stringBuilder.append(str);
            stringBuilder.append(class);
            class = "\" missing method \"";
            stringBuilder.append(class);
            stringBuilder.append(string2);
            class = "\".";
            stringBuilder.append(class);
            class = stringBuilder.toString();
            RuntimeException runtimeException = new RuntimeException(class, class3Arr3);
            throw runtimeException;
        }
    }

    static Object f(Method method, Object object2, Object... object3Arr3) {
        try {
            return method.invoke(object2, object3Arr3);
            method = method.getCause();
            object2 = method instanceof RuntimeException;
            object2 = method instanceof Error;
            if (object2 != null) {
            }
            throw (Error)method;
        }
        throw (RuntimeException)method;
    }

    public static <ContainingType extends kotlin.reflect.jvm.internal.impl.protobuf.o, Type> kotlin.reflect.jvm.internal.impl.protobuf.h.f<ContainingType, Type> h(ContainingType containingtype, kotlin.reflect.jvm.internal.impl.protobuf.o o2, kotlin.reflect.jvm.internal.impl.protobuf.i.b<?> i$b3, int i4, kotlin.reflect.jvm.internal.impl.protobuf.w.b w$b5, boolean z6, Class class7) {
        super(b3, i4, b5, 1, z6);
        super(containingtype, Collections.emptyList(), o2, eVar, class7);
        return fVar2;
    }

    public static <ContainingType extends kotlin.reflect.jvm.internal.impl.protobuf.o, Type> kotlin.reflect.jvm.internal.impl.protobuf.h.f<ContainingType, Type> i(ContainingType containingtype, Type type2, kotlin.reflect.jvm.internal.impl.protobuf.o o3, kotlin.reflect.jvm.internal.impl.protobuf.i.b<?> i$b4, int i5, kotlin.reflect.jvm.internal.impl.protobuf.w.b w$b6, Class class7) {
        super(b4, i5, b6, 0, 0);
        super(containingtype, type2, o3, eVar3, class7);
        return fVar2;
    }

    private static <MessageType extends kotlin.reflect.jvm.internal.impl.protobuf.o> boolean k(kotlin.reflect.jvm.internal.impl.protobuf.g<kotlin.reflect.jvm.internal.impl.protobuf.h.e> g, MessageType messagetype2, kotlin.reflect.jvm.internal.impl.protobuf.e e3, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream codedOutputStream4, kotlin.reflect.jvm.internal.impl.protobuf.f f5, int i6) {
        int gROUP;
        int ordinal;
        kotlin.reflect.jvm.internal.impl.protobuf.h.e packable;
        boolean z;
        Object obj6;
        Object obj7;
        int obj8;
        int obj9;
        kotlin.reflect.jvm.internal.impl.protobuf.w.b obj10;
        int i = w.b(i6);
        obj6 = f5.b(messagetype2, w.a(i6));
        int i3 = 0;
        final int i4 = 1;
        if (obj6 == null) {
            ordinal = i3;
            gROUP = i4;
        } else {
        }
        if (gROUP != 0) {
            return e3.P(i6, codedOutputStream4);
        }
        if (ordinal != 0) {
            if (obj6.d.d() == w.b.ENUM) {
            }
            e3.i(e3.j(e3.A()));
        } else {
            gROUP = h.a.a[obj6.d.g().ordinal()];
            if (gROUP != i4) {
                if (gROUP != 2) {
                    obj7 = g.u(e3, obj6.d.d(), i3);
                } else {
                    obj7 = e3.n();
                    obj9 = obj6.d.c().findValueByNumber(obj7);
                    if (obj9 == null) {
                        codedOutputStream4.o0(i6);
                        codedOutputStream4.y0(obj7);
                        return i4;
                    }
                    obj7 = obj9;
                }
            } else {
                obj8 = 0;
                obj10 = g.h(obj6.d);
                if (!obj6.d.b() && (o)obj10 != null) {
                    obj10 = g.h(obj6.d);
                    if ((o)(o)obj10 != null) {
                        obj8 = (o)(o)obj10.toBuilder();
                    }
                }
                if (obj8 == null) {
                    obj8 = obj6.c().newBuilderForType();
                }
                if (obj6.d.d() == w.b.GROUP) {
                    e3.r(obj6.d(), obj8, f5);
                } else {
                    e3.v(obj8, f5);
                }
                obj7 = obj8.build();
            }
            if (obj6.d.b()) {
                g.a(obj6.d, obj6.f(obj7));
            } else {
                g.v(obj6.d, obj6.f(obj7));
            }
        }
        return i4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.a
    protected void g() {
    }

    public kotlin.reflect.jvm.internal.impl.protobuf.q<? extends kotlin.reflect.jvm.internal.impl.protobuf.o> getParserForType() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        throw unsupportedOperationException;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.a
    protected boolean j(kotlin.reflect.jvm.internal.impl.protobuf.e e, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream codedOutputStream2, kotlin.reflect.jvm.internal.impl.protobuf.f f3, int i4) {
        return e.P(i4, codedOutputStream2);
    }
}
