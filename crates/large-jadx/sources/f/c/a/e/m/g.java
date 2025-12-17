package f.c.a.e.m;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* loaded from: classes2.dex */
public class g implements TypeEvaluator<Matrix> {

    private final float[] a;
    private final float[] b;
    private final Matrix c;
    public g() {
        super();
        int i = 9;
        this.a = new float[i];
        this.b = new float[i];
        Matrix matrix = new Matrix();
        this.c = matrix;
    }

    @Override // android.animation.TypeEvaluator
    public Matrix a(float f, Matrix matrix2, Matrix matrix3) {
        float[] fArr;
        int i;
        float f2;
        int obj5;
        float[] obj6;
        matrix2.getValues(this.a);
        matrix3.getValues(this.b);
        obj5 = 0;
        while (obj5 < 9) {
            obj6 = this.b;
            float[] fArr2 = this.a;
            obj6[obj5] = f4 += fArr;
            obj5++;
        }
        this.c.setValues(this.b);
        return this.c;
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f, Object object2, Object object3) {
        return a(f, (Matrix)object2, (Matrix)object3);
    }
}
