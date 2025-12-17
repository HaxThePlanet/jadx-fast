package d.f.a.k.a;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public abstract class f {

    protected d.f.a.k.a.a a;
    protected int b = 0;
    protected int[] c;
    protected float[][] d;
    protected int e;
    protected String f;
    protected float[] g;
    protected boolean h = false;
    protected long i;
    protected float j = NaNf;
    static {
    }

    public f() {
        super();
        int i = 0;
        this.c = new int[10];
        int[] iArr2 = new int[2];
        iArr2 = new int[]{10, 3};
        this.d = (float[][])Array.newInstance(float.class, iArr2);
        this.g = new float[3];
        int i2 = 2143289344;
    }

    public String toString() {
        String string;
        int i;
        StringBuilder stringBuilder;
        string = this.f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        i = 0;
        while (i < this.e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("[");
            stringBuilder.append(this.c[i]);
            stringBuilder.append(" , ");
            stringBuilder.append(decimalFormat.format(this.d[i]));
            stringBuilder.append("] ");
            string = stringBuilder.toString();
            i++;
        }
        return string;
    }
}
