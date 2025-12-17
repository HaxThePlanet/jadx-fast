package kotlin.i0.z.e.m0.e.z;

import java.util.LinkedList;
import java.util.List;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.o;
import kotlin.i0.z.e.m0.e.o.c;
import kotlin.i0.z.e.m0.e.o.c.c;
import kotlin.i0.z.e.m0.e.p;
import kotlin.t;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class d implements kotlin.i0.z.e.m0.e.z.c {

    private final p a;
    private final o b;

    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[o.c.c.CLASS.ordinal()] = 1;
            iArr[o.c.c.PACKAGE.ordinal()] = 2;
            iArr[o.c.c.LOCAL.ordinal()] = 3;
            d.a.a = iArr;
        }
    }
    public d(p p, o o2) {
        n.f(p, "strings");
        n.f(o2, "qualifiedNames");
        super();
        this.a = p;
        this.b = o2;
    }

    private final t<List<String>, List<String>, Boolean> c(int i) {
        int i2;
        String str;
        int i5;
        int i3;
        int i4;
        int obj8;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        i2 = 0;
        while (obj8 != -1) {
            obj8 = this.b.p(obj8);
            str = this.a.p(obj8.t());
            o.c.c cVar = obj8.r();
            n.d(cVar);
            i5 = d.a.a[cVar.ordinal()];
            i3 = 1;
            if (i5 != i3) {
            } else {
            }
            linkedList2.addFirst(str);
            obj8 = obj8.s();
            if (i5 != 2) {
            } else {
            }
            linkedList.addFirst(str);
            if (i5 != 3) {
            } else {
            }
            linkedList2.addFirst(str);
            i2 = i3;
        }
        obj8 = new t(linkedList, linkedList2, Boolean.valueOf(i2));
        return obj8;
    }

    @Override // kotlin.i0.z.e.m0.e.z.c
    public String a(int i) {
        boolean stringBuilder;
        Object obj;
        Object str;
        String str2;
        int i6;
        int i5;
        int i3;
        int i2;
        int i4;
        int i7;
        String obj12;
        obj12 = c(i);
        obj = obj2;
        if ((List)obj.isEmpty()) {
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(p.h0(obj, "/", 0, 0, 0, 0, 0, 62, 0));
            stringBuilder.append('/');
            stringBuilder.append(p.h0((List)obj12.b(), ".", 0, 0, 0, 0, 0, 62, 0));
            obj12 = stringBuilder.toString();
        }
        return obj12;
    }

    @Override // kotlin.i0.z.e.m0.e.z.c
    public boolean b(int i) {
        return (Boolean)c(i).d().booleanValue();
    }

    @Override // kotlin.i0.z.e.m0.e.z.c
    public String getString(int i) {
        final String obj2 = this.a.p(i);
        n.e(obj2, "strings.getString(index)");
        return obj2;
    }
}
