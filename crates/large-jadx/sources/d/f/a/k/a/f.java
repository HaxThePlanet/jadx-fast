package d.f.a.k.a;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* compiled from: TimeCycleSplineSet.java */
/* loaded from: classes.dex */
public abstract class f {

    protected a a;
    protected int b = 0;
    protected int[] c;
    protected float[][] d;
    protected int e;
    protected String f;
    protected float[] g;
    protected boolean h = false;
    protected long i;
    protected float j = NaNf;
    public f() {
        super();
        this.c = new int[10];
        this.d = (float[][])Array.newInstance(float.class, new int[] { 10, 3 });
        this.g = new float[3];
    }

    public String toString() {
        String str;
        int i = 0;
        i = 0;
        while (i < this.e) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "[";
            int i2 = this.c[i];
            String str3 = " , ";
            String format = new DecimalFormat("##.##").format(this.d[i]);
            String str4 = "] ";
            str = str + str2 + i2 + str3 + format + str4;
            i = i + 1;
        }
        return str;
    }

}
