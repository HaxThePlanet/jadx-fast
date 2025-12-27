package f.c.a.e.m;

import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import f.c.a.e.f;

/* compiled from: ChildrenAlphaProperty.java */
/* loaded from: classes2.dex */
public class d extends Property<ViewGroup, Float> {

    public static final Property<ViewGroup, Float> a = new d<>("childrenAlpha");

    private d(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    public Float a(ViewGroup viewGroup) {
        Object tag = viewGroup.getTag(f.N);
        if (tag != null) {
            return tag;
        }
        return 1f;
    }

    @Override // android.util.Property
    public void b(ViewGroup viewGroup, Float float) {
        int i = 0;
        final float value = float.floatValue();
        viewGroup.setTag(f.N, Float.valueOf(value));
        i = 0;
        while (i < viewGroup.getChildCount()) {
            viewGroup.getChildAt(i).setAlpha(value);
            i = i + 1;
        }
    }
}
