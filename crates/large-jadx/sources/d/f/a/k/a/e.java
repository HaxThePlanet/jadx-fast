package d.f.a.k.a;

import java.text.DecimalFormat;

/* loaded from: classes.dex */
public abstract class e {

    protected d.f.a.k.a.a a;
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
        return (float)d;
    }

    public String toString() {
        String string;
        int i;
        StringBuilder stringBuilder;
        double d;
        string = this.e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        i = 0;
        while (i < this.d) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("[");
            stringBuilder.append(this.b[i]);
            stringBuilder.append(" , ");
            stringBuilder.append(decimalFormat.format((double)f));
            stringBuilder.append("] ");
            string = stringBuilder.toString();
            i++;
        }
        return string;
    }
}
