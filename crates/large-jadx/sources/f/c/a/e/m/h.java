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

/* compiled from: MotionSpec.java */
/* loaded from: classes2.dex */
public class h {

    private final g<String, i> a = new g<>();
    private final g<String, PropertyValuesHolder[]> b = new g<>();
    public h() {
        super();
        g gVar = new g();
        g gVar2 = new g();
    }

    private static void a(h hVar, Animator animator) {
        if (!(animator instanceof ObjectAnimator)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Animator must be an ObjectAnimator: ";
            animator = str + animator;
            throw new IllegalArgumentException(animator);
        } else {
            hVar.h(animator.getPropertyName(), animator.getValues());
            hVar.i(animator.getPropertyName(), i.b(animator));
            return;
        }
    }

    public static h b(Context context, TypedArray typedArray, int i) {
        if (typedArray.hasValue(i)) {
            int resourceId = typedArray.getResourceId(i, 0);
            if (resourceId != 0) {
                return h.c(context, resourceId);
            }
        }
        return null;
    }

    public static h c(Context context, int i) throws android.content.res.Resources.NotFoundException {
        try {
            Animator animator = AnimatorInflater.loadAnimator(context, i);
            if (animator instanceof AnimatorSet) {
                return h.d(animator.getChildAnimations());
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animator);
        } catch (Exception e) {
            StringBuilder str = new StringBuilder();
            String str2 = "Can't load animation resource ID #0x";
            i = Integer.toHexString(i);
            i = str2 + i;
            str = "MotionSpec";
            Log.w(str, i, e);
            return obj;
        }
        return null;
    }

    private static h d(List<Animator> list) {
        int i = 0;
        final f.c.a.e.m.h hVar = new h();
        i = 0;
        while (i < list.size()) {
            h.a(hVar, (Animator)list.get(i));
            i = i + 1;
        }
        return hVar;
    }

    public i e(String str) {
        if (!g(str)) {
            throw new IllegalArgumentException();
        } else {
            return (i)this.a.get(str);
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof h)) {
            return false;
        }
        return this.a.equals(object.a);
    }

    public long f() {
        int max = 0;
        int i = 0;
        max = 0;
        i = 0;
        while (i < this.a.size()) {
            Object obj = this.a.n(i);
            l = obj.c() + obj.d();
            max = Math.max(max, l);
            i = i + 1;
        }
        return max;
    }

    public boolean g(String str) {
        boolean z = true;
        str = this.a.get(str) != null ? 1 : 0;
        return (this.a.get(str) != null ? 1 : 0);
    }

    public void h(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.b.put(str, propertyValuesHolderArr);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void i(String str, i iVar) {
        this.a.put(str, iVar);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String name = h.class.getName();
        String str2 = Integer.toHexString(System.identityHashCode(this));
        String str3 = " timings: ";
        String str4 = "}\n";
        str = 10 + name + 123 + str2 + str3 + this.a + str4;
        return str;
    }
}
