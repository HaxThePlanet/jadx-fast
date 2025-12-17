package f.c.a.e.m;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

/* loaded from: classes2.dex */
public class i {

    private long a = 0;
    private long b = 300;
    private TimeInterpolator c = null;
    private int d = 0;
    private int e = 1;
    public i(long l, long l2) {
        super();
        int i = 0;
        int i2 = 300;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        this.a = l;
        this.b = obj5;
    }

    public i(long l, long l2, TimeInterpolator timeInterpolator3) {
        super();
        int i = 0;
        int i2 = 300;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        this.a = l;
        this.b = timeInterpolator3;
        this.c = obj7;
    }

    static f.c.a.e.m.i b(ValueAnimator valueAnimator) {
        super(valueAnimator.getStartDelay(), obj2, valueAnimator.getDuration(), obj4, i.f(valueAnimator));
        iVar2.d = valueAnimator.getRepeatCount();
        iVar2.e = valueAnimator.getRepeatMode();
        return iVar2;
    }

    private static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator obj1;
        obj1 = valueAnimator.getInterpolator();
        if (!obj1 instanceof AccelerateDecelerateInterpolator) {
            if (obj1 == null) {
            } else {
                if (obj1 instanceof AccelerateInterpolator) {
                    return a.c;
                }
                if (obj1 instanceof DecelerateInterpolator) {
                    obj1 = a.d;
                }
            }
            return obj1;
        }
        return a.b;
    }

    public void a(Animator animator) {
        boolean z;
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            (ValueAnimator)animator.setRepeatCount(g());
            animator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.a;
    }

    public long d() {
        return this.b;
    }

    public TimeInterpolator e() {
        TimeInterpolator time;
        if (this.c != null) {
        } else {
            time = a.b;
        }
        return time;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        final int i3 = 0;
        if (!object instanceof i) {
            return i3;
        }
        if (Long.compare(l, l3) != 0) {
            return i3;
        }
        if (Long.compare(l2, l4) != 0) {
            return i3;
        }
        if (g() != object.g()) {
            return i3;
        }
        if (h() != object.h()) {
            return i3;
        }
        return e().getClass().equals(object.e().getClass());
    }

    public int g() {
        return this.d;
    }

    public int h() {
        return this.e;
    }

    public int hashCode() {
        final int i18 = 32;
        return i9 += i15;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        stringBuilder.append(i.class.getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" delay: ");
        stringBuilder.append(c());
        stringBuilder.append(" duration: ");
        stringBuilder.append(d());
        stringBuilder.append(" interpolator: ");
        stringBuilder.append(e().getClass());
        stringBuilder.append(" repeatCount: ");
        stringBuilder.append(g());
        stringBuilder.append(" repeatMode: ");
        stringBuilder.append(h());
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}
