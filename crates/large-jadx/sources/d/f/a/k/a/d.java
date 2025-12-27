package d.f.a.k.a;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: KeyCycleOscillator.java */
/* loaded from: classes.dex */
public abstract class d {

    private d.a a;
    private String b;
    private int c = 0;
    private String d = null;
    public int e = 0;
    ArrayList<d.b> f = new ArrayList<>();

    static class a {
        public double a(float f) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }
    }

    static class b {

        int a;
        float b;
    }
    public d() {
        super();
        ArrayList arrayList = new ArrayList();
    }

    public float a(float f) {
        return (float)this.a.a(f);
    }

    public String toString() {
        String str;
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "[";
            String str3 = " , ";
            d = (double)item.b;
            String format = new DecimalFormat("##.##").format(d);
            String str4 = "] ";
            str = str + str2 + item.a + str3 + format + str4;
        }
        return str;
    }
}
