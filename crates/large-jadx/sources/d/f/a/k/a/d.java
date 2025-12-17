package d.f.a.k.a;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class d {

    private d.f.a.k.a.d.a a;
    private String b;
    private int c = 0;
    private String d = null;
    public int e = 0;
    ArrayList<d.f.a.k.a.d.b> f;

    static class a {
        public double a(float f) {
            throw 0;
        }
    }

    static class b {

        int a;
        float b;
    }
    public d() {
        super();
        int i = 0;
        final int i2 = 0;
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
    }

    public float a(float f) {
        return (float)d;
    }

    public String toString() {
        String string;
        Object next;
        StringBuilder stringBuilder;
        double d;
        string = this.b;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator iterator = this.f.iterator();
        for (d.b next : iterator) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("[");
            stringBuilder.append(next.a);
            stringBuilder.append(" , ");
            stringBuilder.append(decimalFormat.format((double)f));
            stringBuilder.append("] ");
            string = stringBuilder.toString();
        }
        return string;
    }
}
