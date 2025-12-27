package f.c.a.e.m;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

/* compiled from: MotionTiming.java */
/* loaded from: classes2.dex */
public class i {

    private long a = 0;
    private long b = 300;
    private TimeInterpolator c = null;
    private int d = 0;
    private int e = 1;
    public i(long j, long j2) {
        super();
        this.a = j;
        this.b = j2;
    }

    static i b(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), l, valueAnimator.getDuration(), obj, i.f(valueAnimator));
        iVar.d = valueAnimator.getRepeatCount();
        iVar.e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator;
        interpolator = valueAnimator.getInterpolator();
        return a.b;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        z = animator instanceof ValueAnimator;
        if (animator instanceof ValueAnimator) {
            animator.setRepeatCount(g());
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
        TimeInterpolator timeInterpolator;
        if (this.c == null) {
            timeInterpolator = a.b;
        }
        return timeInterpolator;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (!(object instanceof i)) {
            return false;
        }
        long l = c();
        long l3 = object.c();
        if (l != l3) {
            return false;
        }
        long l2 = d();
        long l4 = object.d();
        if (l2 != l4) {
            return false;
        }
        if (g() != object.g()) {
            return false;
        }
        if (h() != object.h()) {
            return false;
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
        final int i14 = 32;
        return (int)(c() ^ (c() >>> i14)) * 31 + (int)(d() ^ (d() >>> i14)) * 31 + e().getClass().hashCode() * 31 + g() * 31 + h();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String name = i.class.getName();
        String str2 = Integer.toHexString(System.identityHashCode(this));
        String str3 = " delay: ";
        long l = c();
        String str4 = " duration: ";
        long l2 = d();
        String str5 = " interpolator: ";
        Class cls = e().getClass();
        String str6 = " repeatCount: ";
        int i3 = g();
        String str7 = " repeatMode: ";
        int i4 = h();
        String str8 = "}\n";
        str = 10 + name + 123 + str2 + str3 + l + str4 + l2 + str5 + cls + str6 + i3 + str7 + i4 + str8;
        return str;
    }

    public i(long j, long j2, TimeInterpolator timeInterpolator) {
        super();
        this.a = j;
        this.b = j2;
        this.c = timeInterpolator;
    }
}
