package d.u;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* loaded from: classes.dex */
class h<T>  extends Property<T, Float> {

    private final Property<T, PointF> a;
    private final PathMeasure b;
    private final float c;
    private final float[] d;
    private final PointF e;
    private float f;
    h(Property<T, PointF> property, Path path2) {
        super(Float.class, property.getName());
        this.d = new float[2];
        PointF pointF = new PointF();
        this.e = pointF;
        this.a = property;
        PathMeasure obj3 = new PathMeasure(path2, 0);
        this.b = obj3;
        this.c = obj3.getLength();
    }

    public Float a(T t) {
        return Float.valueOf(this.f);
    }

    public void b(T t, Float float2) {
        this.f = float2.floatValue();
        this.b.getPosTan(f2 *= obj5, this.d, 0);
        PointF obj5 = this.e;
        float[] fArr = this.d;
        obj5.x = fArr[0];
        obj5.y = fArr[1];
        this.a.set(t, obj5);
    }

    @Override // android.util.Property
    public Object get(Object object) {
        return a(object);
    }

    @Override // android.util.Property
    public void set(Object object, Object object2) {
        b(object, (Float)object2);
    }
}
