package d.f.a.k.a;

import java.text.DecimalFormat;

/* compiled from: SplineSet.java */
/* loaded from: classes.dex */
public abstract class e {

    protected a a;
    protected int[] b;
    protected float[] c;
    private int d;
    private String e;
    public e() {
        super();
        int i = 10;
        this.b = new int[i];
        this.c = new float[i];
    }

    public float a(float f) {
        return (float)(this.a.a((double)f, 0));
    }

    public String toString() {
        String str;
        int i = 0;
        i = 0;
        while (i < this.d) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "[";
            int i2 = this.b[i];
            String str3 = " , ";
            d = (double)this.c[i];
            String format = new DecimalFormat("##.##").format(d);
            String str4 = "] ";
            str = str + str2 + i2 + str3 + format + str4;
            i = i + 1;
        }
        return str;
    }
}
