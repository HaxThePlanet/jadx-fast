package kotlin.i0.z.e.l0;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.b;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class a implements kotlin.i0.z.e.l0.d {

    private final List<Type> a;
    private final List<Class<?>> b;
    private final List<Object> c;
    private final Class<?> d;
    private final List<String> e;
    private final kotlin.i0.z.e.l0.a.a f;
    private final List<Method> g;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006¨\u0006\u0007", d2 = {"kotlin/i0/z/e/l0/a$a", "", "Lkotlin/i0/z/e/l0/a$a;", "<init>", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static enum a {

        CALL_BY_NAME,
        POSITIONAL_CALL;
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006¨\u0006\u0007", d2 = {"kotlin/i0/z/e/l0/a$b", "", "Lkotlin/i0/z/e/l0/a$b;", "<init>", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static enum b {

        JAVA,
        KOTLIN;
    }
    public a(Class<?> class, List<String> list2, kotlin.i0.z.e.l0.a.a a$a3, kotlin.i0.z.e.l0.a.b a$b4, List<Method> list5) {
        String str;
        kotlin.i0.z.e.l0.a.a obj2;
        int obj3;
        Object obj6;
        n.f(class, "jClass");
        n.f(list2, "parameterNames");
        n.f(a3, "callMode");
        n.f(b4, "origin");
        n.f(list5, "methods");
        super();
        this.d = class;
        this.e = list2;
        this.f = a3;
        this.g = list5;
        obj3 = 10;
        obj2 = new ArrayList(p.r(list5, obj3));
        Iterator obj4 = list5.iterator();
        for (Method obj6 : obj4) {
            obj2.add(obj6.getGenericReturnType());
        }
        this.a = obj2;
        obj2 = this.g;
        obj4 = new ArrayList(p.r(obj2, obj3));
        obj2 = obj2.iterator();
        while (obj2.hasNext()) {
            obj6 = (Method)obj2.next().getReturnType();
            n.e(obj6, "it");
            str = b.h(obj6);
            if (str != null) {
            }
            obj4.add(obj6);
            obj6 = str;
        }
        this.b = obj4;
        obj2 = this.g;
        obj4 = new ArrayList(p.r(obj2, obj3));
        obj2 = obj2.iterator();
        for (Method obj3 : obj2) {
            obj4.add(obj3.getDefaultValue());
        }
        this.c = obj4;
        if (this.f == a.a.POSITIONAL_CALL && b4 == a.b.JAVA) {
            if (b4 == a.b.JAVA) {
                if (obj2 ^= 1 != 0) {
                } else {
                }
                obj2 = new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
                throw obj2;
            }
        }
    }

    public a(Class class, List list2, kotlin.i0.z.e.l0.a.a a$a3, kotlin.i0.z.e.l0.a.b a$b4, List list5, int i6, g g7) {
        Class[] arr;
        ArrayList obj11;
        int obj12;
        Method obj13;
        if (i6 &= 16 != 0) {
            obj11 = new ArrayList(p.r(list2, 10));
            obj12 = list2.iterator();
            for (String obj13 : obj12) {
                obj11.add(class.getDeclaredMethod(obj13, new Class[0]));
            }
        }
        super(class, list2, a3, b4, obj11);
    }

    public List<Type> a() {
        return this.a;
    }

    @Override // kotlin.i0.z.e.l0.d
    public Member b() {
        return (Member)d();
    }

    @Override // kotlin.i0.z.e.l0.d
    public void c(Object[] objectArr) {
        n.f(objectArr, "args");
        d.a.a(this, objectArr);
    }

    @Override // kotlin.i0.z.e.l0.d
    public Object call(Object[] objectArr) {
        int i2;
        int i3;
        Object obj;
        int i;
        kotlin.i0.z.e.l0.a.a aVar;
        kotlin.i0.z.e.l0.a.a cALL_BY_NAME;
        n.f(objectArr, "args");
        c(objectArr);
        ArrayList arrayList = new ArrayList(objectArr.length);
        i3 = i2;
        while (i2 < objectArr.length) {
            Object obj3 = objectArr[i2];
            if (obj3 == null && this.f == a.a.CALL_BY_NAME) {
            } else {
            }
            obj = b.b(obj3, (Class)this.b.get(i3));
            arrayList.add(obj);
            i2++;
            i3 = i;
            if (this.f == a.a.CALL_BY_NAME) {
            } else {
            }
            obj = this.c.get(i3);
        }
        return b.c(this.d, j0.s(p.S0(this.e, arrayList)), this.g);
    }

    @Override // kotlin.i0.z.e.l0.d
    public Void d() {
        return null;
    }

    @Override // kotlin.i0.z.e.l0.d
    public Type getReturnType() {
        return this.d;
    }
}
