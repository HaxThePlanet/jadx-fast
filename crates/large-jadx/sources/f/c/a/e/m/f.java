package f.c.a.e.m;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* compiled from: ImageMatrixProperty.java */
/* loaded from: classes2.dex */
public class f extends Property<ImageView, Matrix> {

    private final Matrix a = new Matrix();
    public f() {
        super(Matrix.class, "imageMatrixProperty");
        Matrix matrix = new Matrix();
    }

    @Override // android.util.Property
    public Matrix a(ImageView imageView) {
        this.a.set(imageView.getImageMatrix());
        return this.a;
    }

    @Override // android.util.Property
    public void b(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
