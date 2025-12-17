package f.c.a.e.m;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class f extends Property<ImageView, Matrix> {

    private final Matrix a;
    public f() {
        super(Matrix.class, "imageMatrixProperty");
        Matrix matrix = new Matrix();
        this.a = matrix;
    }

    @Override // android.util.Property
    public Matrix a(ImageView imageView) {
        this.a.set(imageView.getImageMatrix());
        return this.a;
    }

    @Override // android.util.Property
    public void b(ImageView imageView, Matrix matrix2) {
        imageView.setImageMatrix(matrix2);
    }

    @Override // android.util.Property
    public Object get(Object object) {
        return a((ImageView)object);
    }

    @Override // android.util.Property
    public void set(Object object, Object object2) {
        b((ImageView)object, (Matrix)object2);
    }
}
