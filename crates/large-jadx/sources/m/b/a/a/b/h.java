package m.b.a.a.b;

import java.lang.reflect.Modifier;

/* loaded from: classes3.dex */
class h {

    static m.b.a.a.b.h g;
    static m.b.a.a.b.h h;
    static m.b.a.a.b.h i;
    boolean a = true;
    boolean b = true;
    boolean c = false;
    boolean d = false;
    boolean e = false;
    int f;
    static {
        h hVar = new h();
        h.g = hVar;
        int i = 1;
        hVar.a = i;
        final int i3 = 0;
        hVar.b = i3;
        hVar.c = i3;
        hVar.d = i3;
        hVar.e = i;
        hVar.f = i3;
        h hVar3 = new h();
        h.h = hVar3;
        hVar3.a = i;
        hVar3.b = i;
        hVar3.c = i3;
        hVar3.d = i3;
        hVar3.e = i3;
        hVar.f = i;
        h hVar2 = new h();
        h.i = hVar2;
        hVar2.a = i3;
        hVar2.b = i;
        hVar2.c = i3;
        hVar2.d = i;
        hVar2.e = i3;
        hVar2.f = 2;
    }

    h() {
        super();
        int i = 1;
        int i2 = 0;
    }

    public void a(StringBuffer stringBuffer, Class[] class2Arr2) {
        if (class2Arr2 == null) {
        }
        if (!this.b && class2Arr2.length == 0) {
            if (class2Arr2.length == 0) {
                stringBuffer.append("()");
            }
            stringBuffer.append("(..)");
        }
        stringBuffer.append("(");
        c(stringBuffer, class2Arr2);
        stringBuffer.append(")");
    }

    public void b(StringBuffer stringBuffer, Class[] class2Arr2) {
        boolean length;
        if (this.c && class2Arr2 != null) {
            if (class2Arr2 != null) {
                if (class2Arr2.length == 0) {
                } else {
                    stringBuffer.append(" throws ");
                    c(stringBuffer, class2Arr2);
                }
            }
        }
    }

    public void c(StringBuffer stringBuffer, Class[] class2Arr2) {
        int i;
        String str;
        int length;
        i = 0;
        for (Object obj : class2Arr2) {
            if (i > 0) {
            }
            stringBuffer.append(g(obj));
            stringBuffer.append(", ");
        }
    }

    String d(String string) {
        int lastIndexOf = string.lastIndexOf(45);
        if (lastIndexOf == -1) {
            return string;
        }
        return string.substring(lastIndexOf++);
    }

    String e(int i) {
        final String str = "";
        if (!this.d) {
            return str;
        }
        String obj3 = Modifier.toString(i);
        if (obj3.length() == 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(obj3);
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }

    public String f(Class class, String string2) {
        return h(class, string2, this.e);
    }

    public String g(Class class) {
        return h(class, class.getName(), this.a);
    }

    String h(Class class, String string2, boolean z3) {
        if (class == null) {
            return "ANONYMOUS";
        }
        if (class.isArray()) {
            Class obj2 = class.getComponentType();
            StringBuffer obj3 = new StringBuffer();
            obj3.append(h(obj2, obj2.getName(), z3));
            obj3.append("[]");
            return obj3.toString();
        }
        obj2 = 46;
        int i = 36;
        if (z3) {
            return i(string2).replace(i, obj2);
        }
        return string2.replace(i, obj2);
    }

    String i(String string) {
        int lastIndexOf = string.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return string;
        }
        return string.substring(lastIndexOf++);
    }
}
