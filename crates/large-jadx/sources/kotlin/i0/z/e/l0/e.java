package kotlin.i0.z.e.l0;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.d0.d.e0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public abstract class e<M extends Member>  implements kotlin.i0.z.e.l0.d<M> {

    public static final kotlin.i0.z.e.l0.e.d e;
    private final List<Type> a;
    private final M b;
    private final Type c;
    private final Class<?> d;

    public static final class d {
        public d(g g) {
            super();
        }
    }

    public static final class a extends kotlin.i0.z.e.l0.e<Constructor<?>> implements kotlin.i0.z.e.l0.c {

        private final Object f;
        public a(Constructor<?> constructor, Object object2) {
            Type[] arr;
            int length;
            int i;
            n.f(constructor, "constructor");
            final Class declaringClass = constructor.getDeclaringClass();
            n.e(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            n.e(genericParameterTypes, "constructor.genericParameterTypes");
            if (genericParameterTypes.length <= 2) {
                arr = new Type[0];
            } else {
                i = 1;
                Objects.requireNonNull(i.j(genericParameterTypes, i, length2 -= i), "null cannot be cast to non-null type kotlin.Array<T>");
            }
            super(constructor, declaringClass, 0, (Type[])arr, 0);
            this.f = object2;
        }

        @Override // kotlin.i0.z.e.l0.e
        public Object call(Object[] objectArr) {
            n.f(objectArr, "args");
            c(objectArr);
            e0 e0Var = new e0(3);
            e0Var.a(this.f);
            e0Var.b(objectArr);
            e0Var.a(0);
            return (Constructor)b().newInstance(e0Var.d(new Object[e0Var.c()]));
        }
    }

    public static final class b extends kotlin.i0.z.e.l0.e<Constructor<?>> {
        public b(Constructor<?> constructor) {
            Type[] arr;
            int length;
            n.f(constructor, "constructor");
            final Class declaringClass = constructor.getDeclaringClass();
            n.e(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            n.e(genericParameterTypes, "constructor.genericParameterTypes");
            int i2 = 0;
            int i3 = 1;
            if (genericParameterTypes.length <= i3) {
                arr = new Type[i2];
            } else {
                Objects.requireNonNull(i.j(genericParameterTypes, i2, length2 -= i3), "null cannot be cast to non-null type kotlin.Array<T>");
            }
            super(constructor, declaringClass, 0, (Type[])arr, 0);
        }

        @Override // kotlin.i0.z.e.l0.e
        public Object call(Object[] objectArr) {
            n.f(objectArr, "args");
            c(objectArr);
            e0 e0Var = new e0(2);
            e0Var.b(objectArr);
            e0Var.a(0);
            return (Constructor)b().newInstance(e0Var.d(new Object[e0Var.c()]));
        }
    }

    public static final class c extends kotlin.i0.z.e.l0.e<Constructor<?>> implements kotlin.i0.z.e.l0.c {

        private final Object f;
        public c(Constructor<?> constructor, Object object2) {
            n.f(constructor, "constructor");
            final Class declaringClass = constructor.getDeclaringClass();
            n.e(declaringClass, "constructor.declaringClass");
            final Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            n.e(genericParameterTypes, "constructor.genericParameterTypes");
            super(constructor, declaringClass, 0, genericParameterTypes, 0);
            this.f = object2;
        }

        @Override // kotlin.i0.z.e.l0.e
        public Object call(Object[] objectArr) {
            n.f(objectArr, "args");
            c(objectArr);
            e0 e0Var = new e0(2);
            e0Var.a(this.f);
            e0Var.b(objectArr);
            return (Constructor)b().newInstance(e0Var.d(new Object[e0Var.c()]));
        }
    }

    public static final class e extends kotlin.i0.z.e.l0.e<Constructor<?>> {
        public e(Constructor<?> constructor) {
            Class declaringClass;
            int i;
            n.f(constructor, "constructor");
            final Class declaringClass3 = constructor.getDeclaringClass();
            n.e(declaringClass3, "constructor.declaringClass");
            declaringClass = constructor.getDeclaringClass();
            n.e(declaringClass, "klass");
            Class declaringClass2 = declaringClass.getDeclaringClass();
            if (declaringClass2 != null && !Modifier.isStatic(declaringClass.getModifiers())) {
                i = !Modifier.isStatic(declaringClass.getModifiers()) ? declaringClass2 : declaringClass;
            } else {
            }
            final Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            n.e(genericParameterTypes, "constructor.genericParameterTypes");
            super(constructor, declaringClass3, i, genericParameterTypes, 0);
        }

        @Override // kotlin.i0.z.e.l0.e
        public Object call(Object[] objectArr) {
            n.f(objectArr, "args");
            c(objectArr);
            return (Constructor)b().newInstance(Arrays.copyOf(objectArr, objectArr.length));
        }
    }

    public static abstract class f extends kotlin.i0.z.e.l0.e<Field> {
        private f(Field field, boolean z2) {
            Class obj8;
            final Type genericType = field.getGenericType();
            n.e(genericType, "field.genericType");
            if (z2) {
                obj8 = field.getDeclaringClass();
            } else {
                obj8 = 0;
            }
            super(field, genericType, obj8, new Type[0], 0);
        }

        public f(Field field, boolean z2, g g3) {
            super(field, z2);
        }

        @Override // kotlin.i0.z.e.l0.e
        public Object call(Object[] objectArr) {
            Object obj3;
            n.f(objectArr, "args");
            c(objectArr);
            if (e() != null) {
                obj3 = i.x(objectArr);
            } else {
                obj3 = 0;
            }
            return (Field)b().get(obj3);
        }
    }

    public static abstract class g extends kotlin.i0.z.e.l0.e<Field> {

        private final boolean f;
        private g(Field field, boolean z2, boolean z3) {
            Class obj9;
            final Class tYPE = Void.TYPE;
            n.e(tYPE, "Void.TYPE");
            if (z3) {
                obj9 = field.getDeclaringClass();
            } else {
                obj9 = 0;
            }
            final Type[] arr = new Type[1];
            Type genericType = field.getGenericType();
            n.e(genericType, "field.genericType");
            super(field, tYPE, obj9, arr, 0);
            this.f = z2;
        }

        public g(Field field, boolean z2, boolean z3, g g4) {
            super(field, z2, z3);
        }

        @Override // kotlin.i0.z.e.l0.e
        public void c(Object[] objectArr) {
            Object obj2;
            n.f(objectArr, "args");
            super.c(objectArr);
            if (this.f) {
                if (i.J(objectArr) == null) {
                } else {
                }
                obj2 = new IllegalArgumentException("null is not allowed as a value for this property.");
                throw obj2;
            }
        }

        @Override // kotlin.i0.z.e.l0.e
        public Object call(Object[] objectArr) {
            Object obj;
            n.f(objectArr, "args");
            c(objectArr);
            if (e() != null) {
                obj = i.x(objectArr);
            } else {
                obj = 0;
            }
            (Field)b().set(obj, i.J(objectArr));
            return w.a;
        }
    }

    public static abstract class h extends kotlin.i0.z.e.l0.e<Method> {

        private final boolean f;
        private h(Method method, boolean z2, Type[] type3Arr3) {
            Class obj8;
            final Type genericReturnType = method.getGenericReturnType();
            n.e(genericReturnType, "method.genericReturnType");
            if (z2) {
                obj8 = method.getDeclaringClass();
            } else {
                obj8 = 0;
            }
            super(method, genericReturnType, obj8, type3Arr3, 0);
            this.f = n.b(getReturnType(), Void.TYPE);
        }

        h(Method method, boolean z2, Type[] type3Arr3, int i4, g g5) {
            int obj2;
            Type[] obj3;
            int obj4;
            if (i4 & 2 != 0) {
                obj2 ^= 1;
            }
            if (i4 &= 4 != 0) {
                n.e(method.getGenericParameterTypes(), "method.genericParameterTypes");
            }
            super(method, obj2, obj3);
        }

        public h(Method method, boolean z2, Type[] type3Arr3, g g4) {
            super(method, z2, type3Arr3);
        }

        @Override // kotlin.i0.z.e.l0.e
        protected final Object f(Object object, Object[] object2Arr2) {
            Object obj3;
            n.f(object2Arr2, "args");
            obj3 = (Method)b().invoke(object, Arrays.copyOf(object2Arr2, object2Arr2.length));
            if (this.f) {
                obj3 = w.a;
            }
            return obj3;
        }
    }
    static {
        e.d dVar = new e.d(0);
        e.e = dVar;
    }

    private e(M m, Type type2, Class<?> class3, Type[] type4Arr4) {
        Object obj1;
        Type obj2;
        super();
        this.b = m;
        this.c = type2;
        this.d = class3;
        obj1 = new e0(2);
        obj1.a(class3);
        obj1.b(type4Arr4);
        if (class3 != null && p.j((Type[])obj1.d(new Type[obj1.c()])) != null) {
            obj1 = new e0(2);
            obj1.a(class3);
            obj1.b(type4Arr4);
            if (p.j((Type[])obj1.d(new Type[obj1.c()])) != null) {
            } else {
                obj1 = i.a0(type4Arr4);
            }
        } else {
        }
        this.a = obj1;
    }

    public e(Member member, Type type2, Class class3, Type[] type4Arr4, g g5) {
        super(member, type2, class3, type4Arr4);
    }

    public List<Type> a() {
        return this.a;
    }

    public final M b() {
        return this.b;
    }

    @Override // kotlin.i0.z.e.l0.d
    public void c(Object[] objectArr) {
        n.f(objectArr, "args");
        d.a.a(this, objectArr);
    }

    @Override // kotlin.i0.z.e.l0.d
    protected final void d(Object object) {
        Class declaringClass;
        Object obj2;
        if (object == null) {
        } else {
            if (!this.b.getDeclaringClass().isInstance(object)) {
            } else {
            }
        }
        obj2 = new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        throw obj2;
    }

    public final Class<?> e() {
        return this.d;
    }

    @Override // kotlin.i0.z.e.l0.d
    public final Type getReturnType() {
        return this.c;
    }
}
