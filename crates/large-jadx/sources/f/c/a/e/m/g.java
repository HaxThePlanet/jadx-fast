package f.c.a.e.m;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* compiled from: MatrixEvaluator.java */
/* loaded from: classes2.dex */
public class g implements TypeEvaluator<Matrix> {

    private final float[] a;
    private final float[] b;
    private final Matrix c = new Matrix();
    public g() {
        super();
        int i = 9;
        this.a = new float[i];
        this.b = new float[i];
        Matrix matrix = new Matrix();
    }

    public Matrix a(float f, Matrix matrix, Matrix matrix2) {
        int i = 0;
        matrix.getValues(this.a);
        matrix2.getValues(this.b);
        i = 0;
        while (this.b < 9) {
            fArr = (fArr2[i] - fArr3[i]) * f;
            f2 = fArr3[i] + fArr;
            this.b[i] = f2;
            i = i + 1;
        }
        this.c.setValues(this.b);
        return this.c;
    }
}
