package m.b.a.a.b;

import java.lang.reflect.Modifier;

/* compiled from: StringMaker.java */
/* loaded from: classes3.dex */
class h {

    static h g;
    static h h;
    static h i;
    boolean a = true;
    boolean b = true;
    boolean c = false;
    boolean d = false;
    boolean e = false;
    int f;
    static {
        m.b.a.a.b.h hVar = new h();
        h.g = hVar;
        boolean z = true;
        hVar.a = z;
        final boolean z2 = false;
        hVar.b = z2;
        hVar.c = z2;
        hVar.d = z2;
        hVar.e = z;
        hVar.f = z2;
        final m.b.a.a.b.h hVar3 = new h();
        h.h = hVar3;
        hVar3.a = z;
        hVar3.b = z;
        hVar3.c = z2;
        hVar3.d = z2;
        hVar3.e = z2;
        hVar.f = z;
        m.b.a.a.b.h hVar2 = new h();
        h.i = hVar2;
        hVar2.a = z2;
        hVar2.b = z;
        hVar2.c = z2;
        hVar2.d = z;
        hVar2.e = z2;
        hVar2.f = 2;
    }

    h() {
        super();
    }

    public void a(StringBuffer sb, Class[] clsArr) {
        if (clsArr == null) {
            return;
        }
        if (!this.b) {
            if (clsArr.length == 0) {
                sb.append("()");
                return;
            }
            sb.append("(..)");
            return;
        }
        sb.append("(");
        c(sb, clsArr);
        sb.append(")");
    }

    public void b(StringBuffer sb, Class[] clsArr) {
        if (this.c && clsArr != null) {
            if (clsArr.length != 0) {
                sb.append(" throws ");
                c(sb, clsArr);
            }
        }
    }

    public void c(StringBuffer sb, Class[] clsArr) {
        int i = 0;
        i = 0;
        length = clsArr.length;
        while (i < clsArr.length) {
            sb.append(g(clsArr[i]));
            i = i + 1;
            length = clsArr.length;
        }
    }

    String d(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(lastIndexOf + 1);
    }

    String e(int i) {
        final String str = "";
        if (!this.d) {
            return str;
        }
        String modifier = Modifier.toString(i);
        if (modifier.length() == 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = " ";
        str3 = modifier + str2;
        return str3;
    }

    public String f(Class cls, String str) {
        return h(cls, str, this.e);
    }

    public String g(Class cls) {
        return h(cls, cls.getName(), this.a);
    }

    String h(Class cls, String str, boolean z) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (cls.isArray()) {
            Class cls2 = cls.getComponentType();
            StringBuffer stringBuffer = new StringBuffer();
            String str3 = h(cls2, cls2.getName(), z);
            String str4 = "[]";
            str5 = str3 + str4;
            return str5;
        }
        char c2 = '.';
        char c = '$';
        if (z) {
            return i(str).replace(c, '.');
        }
        return str.replace(c, '.');
    }

    String i(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(lastIndexOf + 1);
    }
}
