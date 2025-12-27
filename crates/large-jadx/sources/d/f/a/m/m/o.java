package d.f.a.m.m;

import d.f.a.d;
import d.f.a.m.b;
import d.f.a.m.e;
import d.f.a.m.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: WidgetGroup.java */
/* loaded from: classes.dex */
public class o {

    static int f;
    ArrayList<e> a = new ArrayList<>();
    int b = -1;
    int c = 0;
    ArrayList<o.a> d = null;
    private int e = -1;

    class a {
        public a(e eVar, d dVar, int i) {
            super();
            WeakReference weakReference = new WeakReference(eVar);
            dVar.x(eVar.K);
            dVar.x(eVar.L);
            dVar.x(eVar.M);
            dVar.x(eVar.N);
            dVar.x(eVar.O);
        }
    }
    public o(int i) {
        super();
        ArrayList arrayList = new ArrayList();
        int i3 = o.f;
        o.f++;
        this.b = i3;
        this.c = i;
    }

    private String e() {
        if (this.c == 0) {
            return "Horizontal";
        }
        if (this.c == 1) {
            return "Vertical";
        }
        if (this.c == 2) {
            return "Both";
        }
        return "Unknown";
    }

    private int j(d dVar, ArrayList<e> arrayList, int i) {
        int size;
        int i4;
        int i5;
        i = 0;
        e eVar = (e)arrayList.get(i).I();
        dVar.D();
        eVar.g(dVar, false);
        while (i < arrayList.size()) {
            (e)arrayList.get(i).g(dVar, false);
            i = i + 1;
        }
        if (i == 0 && eVar.E0 > 0) {
            b.b(eVar, dVar, arrayList, i);
        }
        int i2 = 1;
        if (i == i2 && eVar.F0 > 0) {
            b.b(eVar, dVar, arrayList, i2);
        }
        try {
            dVar.z();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d = new ArrayList();
        while (i < arrayList.size()) {
            this.d.add(new o.a(this, (e)arrayList.get(i), dVar, i));
            i = i + 1;
        }
        if (i == 0) {
            i4 = dVar.x(eVar.K);
            i5 = dVar.x(eVar.M);
            dVar.D();
        } else {
            i4 = dVar.x(eVar.L);
            i5 = dVar.x(eVar.N);
            dVar.D();
        }
        return i5 - i4;
    }

    public boolean a(e eVar) {
        if (this.a.contains(eVar)) {
            return false;
        }
        this.a.add(eVar);
        return true;
    }

    public void b(ArrayList<o> arrayList) {
        int i = 0;
        int i2;
        int i3;
        int size2 = this.a.size();
        int size = -1;
        if (this.e != -1 && size2 > 0) {
            i = 0;
            while (this.e < arrayList.size()) {
                Object item = arrayList.get(i);
                i = i + 1;
            }
        }
        if (size2 == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public int f(d dVar, int i) {
        if (this.a.size() == 0) {
            return 0;
        }
        return j(dVar, this.a, i);
    }

    public void g(int i, o oVar) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            oVar.a(item);
        }
        this.e = oVar.b;
    }

    public void i(int i) {
        this.c = i;
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder2 = new StringBuilder();
        String str6 = e();
        String str7 = " [";
        String str8 = "] <";
        str = str6 + str7 + this.b + str8;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str4 = " ";
            String str5 = (e)it.next().r();
            str = str + str4 + str5;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        String str2 = " >";
        str3 = str + str2;
        return str3;
    }


    public void h(boolean z) {
    }
}
