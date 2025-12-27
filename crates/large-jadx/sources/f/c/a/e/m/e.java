package f.c.a.e.m;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Property;
import java.util.WeakHashMap;

/* compiled from: DrawableAlphaProperty.java */
/* loaded from: classes2.dex */
public class e extends Property<Drawable, Integer> {

    public static final Property<Drawable, Integer> b = new e<>();
    private final WeakHashMap<Drawable, Integer> a = new WeakHashMap<>();

    private e() {
        super(Integer.class, "drawableAlphaCompat");
        WeakHashMap weakHashMap = new WeakHashMap();
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
    public void b(Drawable drawable, Integer integer) {
        if (Build.VERSION.SDK_INT < 19) {
            this.a.put(drawable, integer);
        }
        drawable.setAlpha(integer.intValue());
    }
}
