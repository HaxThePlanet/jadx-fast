package kotlin.i0.z.e.l0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.a;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.i0.d;
import kotlin.i0.l;
import kotlin.i0.z.e.a0;
import kotlin.j;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class b {

    static final class c implements InvocationHandler {

        final Class a;
        final h b;
        final l c;
        final h d;
        final l e;
        final kotlin.i0.z.e.l0.b.a f;
        final Map g;
        c(Class class, h h2, l l3, h h4, l l5, kotlin.i0.z.e.l0.b.a b$a6, Map map7) {
            this.a = class;
            this.b = h2;
            this.c = l3;
            this.d = h4;
            this.e = l5;
            this.f = a6;
            this.g = map7;
            super();
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object object, Method method2, Object[] object3Arr3) {
            boolean length;
            int i;
            Object obj3;
            String obj4;
            Object[] obj5;
            n.e(method2, "method");
            obj3 = method2.getName();
            if (obj3 == null) {
                if (n.b(obj3, "equals") && object3Arr3 != null && object3Arr3.length == 1) {
                    if (object3Arr3 != null) {
                        if (object3Arr3.length == 1) {
                            obj3 = Boolean.valueOf(this.f.a(i.N(object3Arr3)));
                            return obj3;
                        } else {
                            if (this.g.containsKey(obj3)) {
                                obj3 = this.g.get(obj3);
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
                length = obj3.hashCode();
                if (length != -1776922004) {
                    if (length != 147696667) {
                        if (length != 1444986633) {
                        } else {
                            if (obj3.equals("annotationType")) {
                                obj3 = this.a;
                            } else {
                            }
                        }
                    } else {
                        if (obj3.equals("hashCode")) {
                            obj3 = this.d.getValue();
                        } else {
                        }
                    }
                } else {
                    if (obj3.equals("toString")) {
                        obj3 = this.b.getValue();
                    } else {
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Method is not supported: ");
            stringBuilder.append(method2);
            stringBuilder.append(" (args: ");
            if (object3Arr3 != null) {
            } else {
                obj5 = new Object[0];
            }
            stringBuilder.append(i.a0(obj5));
            stringBuilder.append(')');
            obj3 = new a0(stringBuilder.toString());
            throw obj3;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0010\u0004\u001a\u00020\u0003\"\u0008\u0008\u0000\u0010\u0001*\u00020\u00002\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\u0008\u0004\u0010\u0005", d2 = {"", "T", "other", "", "a", "(Ljava/lang/Object;)Z"}, k = 3, mv = {1, 4, 1})
    static final class a extends p implements l<Object, Boolean> {

        final Class $annotationClass;
        final List $methods;
        final Map $values;
        a(Class class, List list2, Map map3) {
            this.$annotationClass = class;
            this.$methods = list2;
            this.$values = map3;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final boolean a(Object object) {
            Object obj;
            List $methods;
            int i2;
            int i;
            boolean equals;
            Object obj2;
            String str;
            int obj7;
            obj = !object instanceof Annotation ? i2 : object;
            obj = a.a((Annotation)obj);
            if (obj != null && obj != null) {
                obj = a.a(obj);
                if (obj != null) {
                    i2 = a.b(obj);
                }
            }
            final int i3 = 0;
            if (n.b(i2, this.$annotationClass)) {
                $methods = this.$methods;
                if ($methods instanceof Collection != null && $methods.isEmpty()) {
                    if ($methods.isEmpty()) {
                        obj7 = i;
                    } else {
                        $methods = $methods.iterator();
                        while ($methods.hasNext()) {
                            Object next = $methods.next();
                            obj2 = this.$values.get((Method)next.getName());
                            Object invoke = next.invoke(object, new Object[i3]);
                            if (obj2 instanceof boolean[]) {
                            } else {
                            }
                            if (obj2 instanceof char[]) {
                            } else {
                            }
                            if (obj2 instanceof byte[]) {
                            } else {
                            }
                            if (obj2 instanceof short[]) {
                            } else {
                            }
                            if (obj2 instanceof int[]) {
                            } else {
                            }
                            if (obj2 instanceof float[]) {
                            } else {
                            }
                            if (obj2 instanceof long[]) {
                            } else {
                            }
                            if (obj2 instanceof double[]) {
                            } else {
                            }
                            if (obj2 instanceof Object[]) {
                            } else {
                            }
                            equals = n.b(obj2, invoke);
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.Array<*>");
                            equals = Arrays.equals((Object[])obj2, (Object[])invoke);
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.DoubleArray");
                            equals = Arrays.equals((double[])obj2, (double[])invoke);
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.LongArray");
                            equals = Arrays.equals((long[])obj2, (long[])invoke);
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.FloatArray");
                            equals = Arrays.equals((float[])obj2, (float[])invoke);
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.IntArray");
                            equals = Arrays.equals((int[])obj2, (int[])invoke);
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.ShortArray");
                            equals = Arrays.equals((short[])obj2, (short[])invoke);
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.ByteArray");
                            equals = Arrays.equals((byte[])obj2, (byte[])invoke);
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.CharArray");
                            equals = Arrays.equals((char[])obj2, (char[])invoke);
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.BooleanArray");
                            equals = Arrays.equals((boolean[])obj2, (boolean[])invoke);
                        }
                    }
                } else {
                }
                if (obj7 != null) {
                } else {
                    i = i3;
                }
            } else {
            }
            return i;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return Boolean.valueOf(a(object));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0010\u0003\u001a\u00020\u0002\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"", "T", "", "a", "()I"}, k = 3, mv = {1, 4, 1})
    static final class b extends p implements a<Integer> {

        final Map $values;
        b(Map map) {
            this.$values = map;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final int a() {
            int i2;
            int i;
            int i3;
            int i4;
            boolean z;
            Iterator iterator = this.$values.entrySet().iterator();
            i2 = 0;
            while (iterator.hasNext()) {
                Object next2 = iterator.next();
                Object value = next2.getValue();
                if (value instanceof boolean[]) {
                } else {
                }
                if (value instanceof char[]) {
                } else {
                }
                if (value instanceof byte[]) {
                } else {
                }
                if (value instanceof short[]) {
                } else {
                }
                if (value instanceof int[]) {
                } else {
                }
                if (value instanceof float[]) {
                } else {
                }
                if (value instanceof long[]) {
                } else {
                }
                if (value instanceof double[]) {
                } else {
                }
                if (value instanceof Object[]) {
                } else {
                }
                i3 = value.hashCode();
                i2 += i;
                i3 = Arrays.hashCode((Object[])value);
                i3 = Arrays.hashCode((double[])value);
                i3 = Arrays.hashCode((long[])value);
                i3 = Arrays.hashCode((float[])value);
                i3 = Arrays.hashCode((int[])value);
                i3 = Arrays.hashCode((short[])value);
                i3 = Arrays.hashCode((byte[])value);
                i3 = Arrays.hashCode((char[])value);
                i3 = Arrays.hashCode((boolean[])value);
            }
            return i2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return Integer.valueOf(a());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0010\u0005\u001a\u00020\u0002\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"", "T", "", "invoke", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class d extends p implements a<String> {

        final Class $annotationClass;
        final Map $values;
        d(Class class, Map map2) {
            this.$annotationClass = class;
            this.$values = map2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final String invoke() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('@');
            stringBuilder.append(this.$annotationClass.getCanonicalName());
            p.f0(this.$values.entrySet(), stringBuilder, ", ", "(", ")", 0, 0, b.d.a.a, 48, 0);
            String string = stringBuilder.toString();
            n.e(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }
    public static final Void a(int i, String string2, Class class3) {
        b.e(i, string2, class3);
        throw 0;
    }

    public static final Object b(Object object, Class class2) {
        return b.f(object, class2);
    }

    public static final <T> T c(Class<T> class, Map<String, ? extends Object> map2, List<Method> list3) {
        n.f(class, "annotationClass");
        n.f(map2, "values");
        n.f(list3, "methods");
        b.a aVar = new b.a(class, list3, map2);
        b.b obj12 = new b.b(map2);
        obj12 = new b.d(class, map2);
        Class[] arr = new Class[1];
        super(class, j.b(obj12), 0, j.b(obj12), 0, aVar, map2);
        final Object obj10 = Proxy.newProxyInstance(class.getClassLoader(), arr, cVar2);
        Objects.requireNonNull(obj10, "null cannot be cast to non-null type T");
        return obj10;
    }

    public static Object d(Class class, Map map2, List list3, int i4, Object object5) {
        Class[] arr;
        ArrayList obj3;
        int obj4;
        boolean obj5;
        if (i4 &= 4 != 0) {
            obj3 = map2.keySet();
            obj4 = new ArrayList(p.r(obj3, 10));
            obj3 = obj3.iterator();
            for (String obj5 : obj3) {
                obj4.add(class.getDeclaredMethod(obj5, new Class[0]));
            }
            obj3 = obj4;
        }
        return b.c(class, map2, obj3);
    }

    private static final Void e(int i, String string2, Class<?> class3) {
        boolean array;
        StringBuilder stringBuilder;
        Class<Class> obj;
        String str;
        d obj5;
        if (n.b(class3, Class.class)) {
            obj5 = c0.b(d.class);
        } else {
            if (class3.isArray() && n.b(class3.getComponentType(), Class.class)) {
                if (n.b(class3.getComponentType(), Class.class)) {
                    obj5 = c0.b(d[].class);
                } else {
                    obj5 = a.e(class3);
                }
            } else {
            }
        }
        if (n.b(obj5.n(), c0.b(Object[].class).n())) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(obj5.n());
            stringBuilder.append('<');
            obj5 = a.b(obj5).getComponentType();
            n.e(obj5, "kotlinClass.java.componentType");
            stringBuilder.append(a.e(obj5).n());
            stringBuilder.append('>');
            obj5 = stringBuilder.toString();
        } else {
            obj5 = obj5.n();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Argument #");
        stringBuilder2.append(i);
        stringBuilder2.append(' ');
        stringBuilder2.append(string2);
        stringBuilder2.append(" is not of the required type ");
        stringBuilder2.append(obj5);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
        throw illegalArgumentException;
    }

    private static final Object f(Object object, Class<?> class2) {
        boolean str;
        int i2;
        boolean length;
        int i;
        int i3;
        Class cls;
        Object obj6;
        i2 = 0;
        if (object instanceof Class) {
            return i2;
        }
        if (object instanceof d) {
            obj6 = a.b((d)object);
        } else {
            str = object;
            if (object instanceof Object[] && str instanceof Class[]) {
                str = object;
                if (str instanceof Class[]) {
                    return i2;
                }
                if (str instanceof d[]) {
                    Objects.requireNonNull(object, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                    ArrayList arrayList = new ArrayList(object.length);
                    i = 0;
                    i3 = i;
                    while (i3 < object.length) {
                        arrayList.add(a.b((d[])object[i3]));
                        i3++;
                    }
                    Objects.requireNonNull(arrayList.toArray(new Class[i]), "null cannot be cast to non-null type kotlin.Array<T>");
                } else {
                    obj6 = str;
                }
            }
        }
        if (class2.isInstance(obj6)) {
            i2 = obj6;
        }
        return i2;
    }
}
