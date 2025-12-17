package f.c.a.e.m;

import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import f.c.a.e.f;

/* loaded from: classes2.dex */
public class d extends Property<ViewGroup, Float> {

    public static final Property<ViewGroup, Float> a;
    static {
        d dVar = new d("childrenAlpha");
        d.a = dVar;
    }

    private d(String string) {
        super(Float.class, string);
    }

    @Override // android.util.Property
    public Float a(ViewGroup viewGroup) {
        Object obj2 = viewGroup.getTag(f.N);
        if ((Float)obj2 != null) {
            return (Float)obj2;
        }
        return 1f;
    }

    @Override // android.util.Property
    public void b(ViewGroup viewGroup, Float float2) {
        int i;
        View childAt;
        final float obj5 = float2.floatValue();
        viewGroup.setTag(f.N, Float.valueOf(obj5));
        i = 0;
        while (i < viewGroup.getChildCount()) {
            viewGroup.getChildAt(i).setAlpha(obj5);
            i++;
        }
    }

    @Override // android.util.Property
    public Object get(Object object) {
        return a((ViewGroup)object);
    }

    @Override // android.util.Property
    public void set(Object object, Object object2) {
        b((ViewGroup)object, (Float)object2);
    }
}
