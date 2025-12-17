package zendesk.commonui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import f.g.e.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class AlmostRealProgressBar extends ProgressBar {

    public static final List<zendesk.commonui.AlmostRealProgressBar.e> y;
    private zendesk.commonui.AlmostRealProgressBar.d a;
    private zendesk.commonui.AlmostRealProgressBar.d b;
    private List<zendesk.commonui.AlmostRealProgressBar.e> c;
    private Handler v;
    private Runnable w;
    private Runnable x;

    class a implements Runnable {

        final List a;
        final zendesk.commonui.AlmostRealProgressBar b;
        a(zendesk.commonui.AlmostRealProgressBar almostRealProgressBar, List list2) {
            this.b = almostRealProgressBar;
            this.a = list2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            AlmostRealProgressBar.a(this.b, 0);
            List list2 = a.c(this.a);
            Collections.sort(list2);
            AlmostRealProgressBar.c(this.b, list2);
            zendesk.commonui.AlmostRealProgressBar almostRealProgressBar2 = this.b;
            AlmostRealProgressBar.d(almostRealProgressBar2, AlmostRealProgressBar.b(almostRealProgressBar2), 0);
        }
    }

    class b implements Runnable {

        final long a;
        final zendesk.commonui.AlmostRealProgressBar b;
        b(zendesk.commonui.AlmostRealProgressBar almostRealProgressBar, long l2) {
            this.b = almostRealProgressBar;
            this.a = l2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            AlmostRealProgressBar.e(this.b, 0);
            AlmostRealProgressBar.f(this.b, this.a);
        }
    }

    static class c extends View.BaseSavedState {

        public static final Parcelable.Creator<zendesk.commonui.AlmostRealProgressBar.c> CREATOR;
        private final int a;
        private final List<zendesk.commonui.AlmostRealProgressBar.e> b;
        static {
            AlmostRealProgressBar.c.a aVar = new AlmostRealProgressBar.c.a();
            AlmostRealProgressBar.c.CREATOR = aVar;
        }

        private c(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            parcel.readTypedList(arrayList, AlmostRealProgressBar.e.CREATOR);
        }

        c(Parcel parcel, zendesk.commonui.AlmostRealProgressBar.a almostRealProgressBar$a2) {
            super(parcel);
        }

        public c(Parcelable parcelable, int i2, List<zendesk.commonui.AlmostRealProgressBar.e> list3) {
            super(parcelable);
            this.a = i2;
            this.b = list3;
        }

        static int a(zendesk.commonui.AlmostRealProgressBar.c almostRealProgressBar$c) {
            return c.a;
        }

        static List b(zendesk.commonui.AlmostRealProgressBar.c almostRealProgressBar$c) {
            return c.b;
        }

        @Override // android.view.View$BaseSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.a);
            parcel.writeTypedList(this.b);
        }
    }

    private static class d extends AnimatorListenerAdapter {

        private final Animator a;
        private boolean b = false;
        private boolean c = false;
        d(Animator animator) {
            super();
            final int i = 0;
            this.a = animator;
            animator.addListener(this);
        }

        @Override // android.animation.AnimatorListenerAdapter
        Animator a() {
            return this.a;
        }

        @Override // android.animation.AnimatorListenerAdapter
        boolean b() {
            return this.c;
        }

        @Override // android.animation.AnimatorListenerAdapter
        boolean c() {
            return this.b;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationCancel(Animator animator) {
            this.b = false;
            this.c = true;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.b = false;
            this.c = true;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationRepeat(Animator animator) {
            this.b = true;
            this.c = false;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            this.b = true;
            this.c = false;
        }
    }

    static class e implements Parcelable, Comparable<zendesk.commonui.AlmostRealProgressBar.e> {

        public static final Parcelable.Creator<zendesk.commonui.AlmostRealProgressBar.e> CREATOR;
        private final int a;
        private final long b;
        static {
            AlmostRealProgressBar.e.a aVar = new AlmostRealProgressBar.e.a();
            AlmostRealProgressBar.e.CREATOR = aVar;
        }

        e(int i, long l2) {
            super();
            this.a = i;
            this.b = l2;
        }

        e(Parcel parcel) {
            super();
            this.a = parcel.readInt();
            this.b = parcel.readLong();
        }

        static int a(zendesk.commonui.AlmostRealProgressBar.e almostRealProgressBar$e) {
            return e.a;
        }

        static long c(zendesk.commonui.AlmostRealProgressBar.e almostRealProgressBar$e) {
            return e.b;
        }

        @Override // android.os.Parcelable
        public int compareTo(Object object) {
            return e((AlmostRealProgressBar.e)object);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public int e(zendesk.commonui.AlmostRealProgressBar.e almostRealProgressBar$e) {
            return i -= obj2;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeLong(this.b);
        }
    }
    static {
        zendesk.commonui.AlmostRealProgressBar.e[] arr = new AlmostRealProgressBar.e[2];
        AlmostRealProgressBar.e eVar = new AlmostRealProgressBar.e(60, 4000, obj4);
        AlmostRealProgressBar.e eVar2 = new AlmostRealProgressBar.e(90, 15000, obj4);
        AlmostRealProgressBar.y = Arrays.asList(eVar, eVar2);
    }

    public AlmostRealProgressBar(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        Handler obj1 = new Handler(Looper.getMainLooper());
        this.v = obj1;
    }

    static Runnable a(zendesk.commonui.AlmostRealProgressBar almostRealProgressBar, Runnable runnable2) {
        almostRealProgressBar.x = runnable2;
        return runnable2;
    }

    static List b(zendesk.commonui.AlmostRealProgressBar almostRealProgressBar) {
        return almostRealProgressBar.c;
    }

    static List c(zendesk.commonui.AlmostRealProgressBar almostRealProgressBar, List list2) {
        almostRealProgressBar.c = list2;
        return list2;
    }

    static void d(zendesk.commonui.AlmostRealProgressBar almostRealProgressBar, List list2, int i3) {
        almostRealProgressBar.j(list2, i3);
    }

    static Runnable e(zendesk.commonui.AlmostRealProgressBar almostRealProgressBar, Runnable runnable2) {
        almostRealProgressBar.w = runnable2;
        return runnable2;
    }

    static void f(zendesk.commonui.AlmostRealProgressBar almostRealProgressBar, long l2) {
        almostRealProgressBar.i(l2);
    }

    private zendesk.commonui.AlmostRealProgressBar.e g(int i, int i2, zendesk.commonui.AlmostRealProgressBar.e almostRealProgressBar$e3) {
        obj5 *= i6;
        AlmostRealProgressBar.e eVar = new AlmostRealProgressBar.e(AlmostRealProgressBar.e.a(e3), (long)obj5, obj5);
        return eVar;
    }

    private zendesk.commonui.AlmostRealProgressBar.d h(long l) {
        int i = 100;
        int i2 = 1065353216;
        int i3 = 0;
        final int i6 = 0;
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.play(k(getProgress(), i, l)).before(l(i2, i3, 100));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(k(i, 0, i6)).before(l(i3, i2, i6));
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(l);
        animatorSet2.play(animatorSet3).before(animatorSet);
        AlmostRealProgressBar.d obj9 = new AlmostRealProgressBar.d(animatorSet2);
        return obj9;
    }

    private void i(long l) {
        zendesk.commonui.AlmostRealProgressBar.d dVar;
        long obj2;
        dVar = this.a;
        if (dVar != null) {
            dVar.a().cancel();
            this.a = 0;
            obj2 = h(l);
            this.b = obj2;
            obj2.a().start();
        }
    }

    private void j(List<zendesk.commonui.AlmostRealProgressBar.e> list, int i2) {
        int duration;
        zendesk.commonui.AlmostRealProgressBar.d dVar;
        int i;
        Object obj4;
        duration = 0;
        dVar = this.b;
        if (this.a == null && dVar != null && dVar.c() && !this.b.b()) {
            duration = 0;
            dVar = this.b;
            if (dVar != null) {
                if (dVar.c()) {
                    if (!this.b.b()) {
                        duration = this.b.a().getDuration();
                    }
                }
            }
            this.b = 0;
            obj4 = o(list, i2, duration);
            this.a = obj4;
            obj4.a().start();
        }
    }

    private Animator k(int i, int i2, long l3) {
        int[] iArr = new int[2];
        ObjectAnimator obj3 = ObjectAnimator.ofInt(this, "progress", i, i2);
        DecelerateInterpolator obj4 = new DecelerateInterpolator();
        obj3.setInterpolator(obj4);
        obj3.setDuration(l3);
        return obj3;
    }

    private Animator l(float f, float f2, long l3) {
        float[] fArr = new float[2];
        ObjectAnimator obj3 = ObjectAnimator.ofFloat(this, "alpha", f, f2);
        obj3.setDuration(l3);
        return obj3;
    }

    private void m(zendesk.commonui.AlmostRealProgressBar.c almostRealProgressBar$c) {
        int arrayList;
        ArrayList arrayList2;
        boolean z;
        int i2;
        boolean next;
        int i;
        int i3;
        zendesk.commonui.AlmostRealProgressBar.c obj9;
        final int i4 = 0;
        if (AlmostRealProgressBar.c.a(c) > 0) {
            arrayList = new ArrayList(AlmostRealProgressBar.c.b(c));
            arrayList2 = new ArrayList();
            Iterator iterator = AlmostRealProgressBar.c.b(c).iterator();
            i2 = i4;
            while (iterator.hasNext()) {
                next = iterator.next();
                if (AlmostRealProgressBar.c.a(c) < AlmostRealProgressBar.e.a((AlmostRealProgressBar.e)next)) {
                } else {
                }
                i2 = AlmostRealProgressBar.e.a(next);
                arrayList2.add(next);
            }
            if (a.i(arrayList2)) {
                arrayList2.add(i4, g(AlmostRealProgressBar.c.a(c), i2, (AlmostRealProgressBar.e)arrayList2.remove(i4)));
            }
            j(arrayList2, AlmostRealProgressBar.c.a(c));
            this.c = arrayList;
        } else {
            setProgress(i4);
        }
    }

    private zendesk.commonui.AlmostRealProgressBar.d o(List<zendesk.commonui.AlmostRealProgressBar.e> list, int i2, long l3) {
        int size;
        int i;
        long l;
        int obj7;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator obj6 = list.iterator();
        for (AlmostRealProgressBar.e next2 : obj6) {
            arrayList.add(k(obj7, AlmostRealProgressBar.e.a(next2), AlmostRealProgressBar.e.c(next2)));
            obj7 = size;
        }
        obj6 = new AnimatorSet();
        obj6.playSequentially(arrayList);
        obj6.setStartDelay(l3);
        obj7 = new AlmostRealProgressBar.d(obj6);
        return obj7;
    }

    public void n(List<zendesk.commonui.AlmostRealProgressBar.e> list) {
        Runnable aVar;
        int i;
        int obj4;
        aVar = this.w;
        if (aVar != null) {
            this.v.removeCallbacks(aVar);
            this.w = 0;
        } else {
            if (this.x == null) {
                aVar = new AlmostRealProgressBar.a(this, list);
                this.x = aVar;
                this.v.postDelayed(aVar, 100);
            }
        }
    }

    @Override // android.widget.ProgressBar
    public void onRestoreInstanceState(Parcelable parcelable) {
        Object obj2;
        if (parcelable instanceof AlmostRealProgressBar.c) {
            m((AlmostRealProgressBar.c)parcelable);
            obj2 = parcelable.getSuperState();
        }
        super.onRestoreInstanceState(obj2);
    }

    @Override // android.widget.ProgressBar
    public Parcelable onSaveInstanceState() {
        Object dVar;
        if (this.a != null && this.w == null) {
            if (this.w == null) {
                AlmostRealProgressBar.c cVar = new AlmostRealProgressBar.c(super.onSaveInstanceState(), getProgress(), this.c);
                return cVar;
            }
        }
        setProgress(0);
        return super.onSaveInstanceState();
    }

    @Override // android.widget.ProgressBar
    public void p(long l) {
        Runnable bVar;
        int i;
        int obj4;
        bVar = this.x;
        if (bVar != null) {
            this.v.removeCallbacks(bVar);
            this.x = 0;
        } else {
            if (this.w == null) {
                bVar = new AlmostRealProgressBar.b(this, l, obj5);
                this.w = bVar;
                this.v.postDelayed(bVar, 200);
            }
        }
    }
}
