package f.c.a.e.m;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import d.e.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class h {

    private final g<String, f.c.a.e.m.i> a;
    private final g<String, PropertyValuesHolder[]> b;
    public h() {
        super();
        g gVar = new g();
        this.a = gVar;
        g gVar2 = new g();
        this.b = gVar2;
    }

    private static void a(f.c.a.e.m.h h, Animator animator2) {
        if (!animator2 instanceof ObjectAnimator) {
        } else {
            h.h((ObjectAnimator)animator2.getPropertyName(), animator2.getValues());
            h.i(animator2.getPropertyName(), i.b(animator2));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Animator must be an ObjectAnimator: ");
        stringBuilder.append(animator2);
        IllegalArgumentException obj2 = new IllegalArgumentException(stringBuilder.toString());
        throw obj2;
    }

    public static f.c.a.e.m.h b(Context context, TypedArray typedArray2, int i3) {
        boolean value;
        int obj2;
        obj2 = typedArray2.getResourceId(i3, 0);
        if (typedArray2.hasValue(i3) && obj2 != null) {
            obj2 = typedArray2.getResourceId(i3, 0);
            if (obj2 != null) {
                return h.c(context, obj2);
            }
        }
        return null;
    }

    public static f.c.a.e.m.h c(Context context, int i2) {
        Animator obj3 = AnimatorInflater.loadAnimator(context, i2);
        if (obj3 instanceof AnimatorSet != null) {
            try {
                return h.d((AnimatorSet)obj3.getChildAnimations());
                if (obj3 != null) {
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(obj3);
                return h.d(arrayList);
                return null;
                StringBuilder str = new StringBuilder();
                str.append("Can't load animation resource ID #0x");
                i2 = Integer.toHexString(i2);
                str.append(i2);
                i2 = str.toString();
                str = "MotionSpec";
                Log.w(str, i2, context);
                return obj0;
            }
        }
    }

    private static f.c.a.e.m.h d(List<Animator> list) {
        int i;
        Object obj;
        h hVar = new h();
        i = 0;
        while (i < list.size()) {
            h.a(hVar, (Animator)list.get(i));
            i++;
        }
        return hVar;
    }

    public f.c.a.e.m.i e(String string) {
        if (!g(string)) {
        } else {
            return (i)this.a.get(string);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException();
        throw obj2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (!object instanceof h) {
            return 0;
        }
        return this.a.equals(object.a);
    }

    public long f() {
        int i2;
        int i3;
        Object obj;
        int i;
        long l;
        i2 = 0;
        i3 = 0;
        while (i3 < this.a.size()) {
            obj = this.a.n(i3);
            i2 = Math.max(i2, obj2);
            i3++;
        }
        return i2;
    }

    public boolean g(String string) {
        int obj2;
        obj2 = this.a.get(string) != null ? 1 : 0;
        return obj2;
    }

    public void h(String string, PropertyValuesHolder[] propertyValuesHolder2Arr2) {
        this.b.put(string, propertyValuesHolder2Arr2);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void i(String string, f.c.a.e.m.i i2) {
        this.a.put(string, i2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        stringBuilder.append(h.class.getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" timings: ");
        stringBuilder.append(this.a);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}
