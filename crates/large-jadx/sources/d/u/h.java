package d.u;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: PathProperty.java */
/* loaded from: classes.dex */
class h<T> extends Property<T, Float> {

    private final Property<T, PointF> a;
    private final PathMeasure b = new PathMeasure();
    private final float c;
    private final float[] d;
    private final PointF e = new PointF();
    private float f;
    h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.d = new float[2];
        PointF pointF = new PointF();
        this.a = property;
        this.c = new PathMeasure(path, false).getLength();
    }

    @Override // android.util.Property
    public Float a(T t) {
        return Float.valueOf(this.f);
    }

    @Override // android.util.Property
    public void b(T t, Float float) {
        this.f = float.floatValue();
        this.b.getPosTan(this.c * float.floatValue(), this.d, null);
        this.e.x = fArr[0];
        this.e.y = fArr[1];
        this.a.set(t, this.e);
    }
}
