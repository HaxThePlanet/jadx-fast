package f.c.a.e.m;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Property;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class e extends Property<Drawable, Integer> {

    public static final Property<Drawable, Integer> b;
    private final WeakHashMap<Drawable, Integer> a;
    static {
        e eVar = new e();
        e.b = eVar;
    }

    private e() {
        super(Integer.class, "drawableAlphaCompat");
        WeakHashMap weakHashMap = new WeakHashMap();
        this.a = weakHashMap;
    }

    @Override // android.util.Property
    public Integer a(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.a.containsKey(drawable)) {
            return (Integer)this.a.get(drawable);
        }
        return 255;
    }

    @Override // android.util.Property
    public void b(Drawable drawable, Integer integer2) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT < 19) {
            this.a.put(drawable, integer2);
        }
        drawable.setAlpha(integer2.intValue());
    }

    @Override // android.util.Property
    public Object get(Object object) {
        return a((Drawable)object);
    }

    @Override // android.util.Property
    public void set(Object object, Object object2) {
        b((Drawable)object, (Integer)object2);
    }
}
