package zendesk.support.request;

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
public class ViewAlmostRealProgressBar extends ProgressBar {

    public static final long ALPHA_FADE_DURATION = 100L;
    public static final List<zendesk.support.request.ViewAlmostRealProgressBar.Step> DONT_STOP_MOVING = null;
    public static final List<zendesk.support.request.ViewAlmostRealProgressBar.Step> SIMPLE_PROGRESSBAR = null;
    public static final long START_DEBOUNCE_TIME = 100L;
    public static final long STOP_ANIMATION_DURATION = 300L;
    public static final long STOP_DEBOUNCE_TIME = 200L;
    private zendesk.support.request.ViewAlmostRealProgressBar.StateAwareAnimator finishAnimator;
    private Handler handler;
    private zendesk.support.request.ViewAlmostRealProgressBar.StateAwareAnimator progressAnimator;
    private Runnable startDebounceRunnable;
    private List<zendesk.support.request.ViewAlmostRealProgressBar.Step> steps;
    private Runnable stopDebounceRunnable;

    static class State extends View.BaseSavedState {

        public static final Parcelable.Creator<zendesk.support.request.ViewAlmostRealProgressBar.State> CREATOR;
        private final int progress;
        private final List<zendesk.support.request.ViewAlmostRealProgressBar.Step> steps;
        static {
            ViewAlmostRealProgressBar.State.1 anon = new ViewAlmostRealProgressBar.State.1();
            ViewAlmostRealProgressBar.State.CREATOR = anon;
        }

        private State(Parcel parcel) {
            super(parcel);
            this.progress = parcel.readInt();
            ArrayList arrayList = new ArrayList();
            this.steps = arrayList;
            parcel.readTypedList(arrayList, ViewAlmostRealProgressBar.Step.CREATOR);
        }

        State(Parcel parcel, zendesk.support.request.ViewAlmostRealProgressBar.1 viewAlmostRealProgressBar$12) {
            super(parcel);
        }

        public State(Parcelable parcelable, int i2, List<zendesk.support.request.ViewAlmostRealProgressBar.Step> list3) {
            super(parcelable);
            this.progress = i2;
            this.steps = list3;
        }

        static int access$700(zendesk.support.request.ViewAlmostRealProgressBar.State viewAlmostRealProgressBar$State) {
            return state.progress;
        }

        static List access$800(zendesk.support.request.ViewAlmostRealProgressBar.State viewAlmostRealProgressBar$State) {
            return state.steps;
        }

        @Override // android.view.View$BaseSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.progress);
            parcel.writeTypedList(this.steps);
        }
    }

    private static class StateAwareAnimator extends AnimatorListenerAdapter {

        private final Animator animatorSet;
        private boolean ended = false;
        private boolean started = false;
        StateAwareAnimator(Animator animator) {
            super();
            final int i = 0;
            this.animatorSet = animator;
            animator.addListener(this);
        }

        @Override // android.animation.AnimatorListenerAdapter
        Animator get() {
            return this.animatorSet;
        }

        @Override // android.animation.AnimatorListenerAdapter
        boolean isEnded() {
            return this.ended;
        }

        @Override // android.animation.AnimatorListenerAdapter
        boolean isStarted() {
            return this.started;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationCancel(Animator animator) {
            this.started = false;
            this.ended = true;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.started = false;
            this.ended = true;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationRepeat(Animator animator) {
            this.started = true;
            this.ended = false;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            this.started = true;
            this.ended = false;
        }
    }

    static class Step implements Parcelable, Comparable<zendesk.support.request.ViewAlmostRealProgressBar.Step> {

        public static final Parcelable.Creator<zendesk.support.request.ViewAlmostRealProgressBar.Step> CREATOR;
        private final int target;
        private final long time;
        static {
            ViewAlmostRealProgressBar.Step.1 anon = new ViewAlmostRealProgressBar.Step.1();
            ViewAlmostRealProgressBar.Step.CREATOR = anon;
        }

        Step(int i, long l2) {
            super();
            this.target = i;
            this.time = l2;
        }

        Step(Parcel parcel) {
            super();
            this.target = parcel.readInt();
            this.time = parcel.readLong();
        }

        static int access$500(zendesk.support.request.ViewAlmostRealProgressBar.Step viewAlmostRealProgressBar$Step) {
            return step.target;
        }

        static long access$600(zendesk.support.request.ViewAlmostRealProgressBar.Step viewAlmostRealProgressBar$Step) {
            return step.time;
        }

        @Override // android.os.Parcelable
        public int compareTo(Object object) {
            return compareTo((ViewAlmostRealProgressBar.Step)object);
        }

        @Override // android.os.Parcelable
        public int compareTo(zendesk.support.request.ViewAlmostRealProgressBar.Step viewAlmostRealProgressBar$Step) {
            return target -= obj2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.target);
            parcel.writeLong(this.time);
        }
    }
    static {
        int i2 = 60;
        int i4 = 4000;
        ViewAlmostRealProgressBar.Step step = new ViewAlmostRealProgressBar.Step(i2, i4, obj3);
        ViewAlmostRealProgressBar.SIMPLE_PROGRESSBAR = Collections.singletonList(step);
        zendesk.support.request.ViewAlmostRealProgressBar.Step[] arr = new ViewAlmostRealProgressBar.Step[2];
        ViewAlmostRealProgressBar.Step step3 = new ViewAlmostRealProgressBar.Step(i2, i4, obj3);
        ViewAlmostRealProgressBar.Step step2 = new ViewAlmostRealProgressBar.Step(90, 15000, step3);
        ViewAlmostRealProgressBar.DONT_STOP_MOVING = Arrays.asList(step3, step2);
    }

    public ViewAlmostRealProgressBar(Context context) {
        super(context);
        Handler obj2 = new Handler(Looper.getMainLooper());
        this.handler = obj2;
    }

    public ViewAlmostRealProgressBar(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        Handler obj1 = new Handler(Looper.getMainLooper());
        this.handler = obj1;
    }

    public ViewAlmostRealProgressBar(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        Handler obj1 = new Handler(Looper.getMainLooper());
        this.handler = obj1;
    }

    static Runnable access$002(zendesk.support.request.ViewAlmostRealProgressBar viewAlmostRealProgressBar, Runnable runnable2) {
        viewAlmostRealProgressBar.startDebounceRunnable = runnable2;
        return runnable2;
    }

    static List access$100(zendesk.support.request.ViewAlmostRealProgressBar viewAlmostRealProgressBar) {
        return viewAlmostRealProgressBar.steps;
    }

    static List access$102(zendesk.support.request.ViewAlmostRealProgressBar viewAlmostRealProgressBar, List list2) {
        viewAlmostRealProgressBar.steps = list2;
        return list2;
    }

    static void access$200(zendesk.support.request.ViewAlmostRealProgressBar viewAlmostRealProgressBar, List list2, int i3) {
        viewAlmostRealProgressBar.kickOffAnimation(list2, i3);
    }

    static Runnable access$302(zendesk.support.request.ViewAlmostRealProgressBar viewAlmostRealProgressBar, Runnable runnable2) {
        viewAlmostRealProgressBar.stopDebounceRunnable = runnable2;
        return runnable2;
    }

    static void access$400(zendesk.support.request.ViewAlmostRealProgressBar viewAlmostRealProgressBar, long l2) {
        viewAlmostRealProgressBar.finishAnimation(l2);
    }

    private zendesk.support.request.ViewAlmostRealProgressBar.Step adjustTime(int i, int i2, zendesk.support.request.ViewAlmostRealProgressBar.Step viewAlmostRealProgressBar$Step3) {
        obj5 *= i6;
        ViewAlmostRealProgressBar.Step step = new ViewAlmostRealProgressBar.Step(ViewAlmostRealProgressBar.Step.access$500(step3), (long)obj5, obj5);
        return step;
    }

    private zendesk.support.request.ViewAlmostRealProgressBar.StateAwareAnimator endAnimation(long l) {
        int i = 100;
        int i2 = 1065353216;
        int i3 = 0;
        final int i6 = 0;
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.play(progressAnimator(getProgress(), i, l)).before(progressBarAlphaAnimator(i2, i3, 100));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(progressAnimator(i, 0, i6)).before(progressBarAlphaAnimator(i3, i2, i6));
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(l);
        animatorSet2.play(animatorSet3).before(animatorSet);
        ViewAlmostRealProgressBar.StateAwareAnimator obj9 = new ViewAlmostRealProgressBar.StateAwareAnimator(animatorSet2);
        return obj9;
    }

    private void finishAnimation(long l) {
        zendesk.support.request.ViewAlmostRealProgressBar.StateAwareAnimator progressAnimator;
        long obj2;
        progressAnimator = this.progressAnimator;
        if (progressAnimator != null) {
            progressAnimator.get().cancel();
            this.progressAnimator = 0;
            obj2 = endAnimation(l);
            this.finishAnimator = obj2;
            obj2.get().start();
        }
    }

    private void kickOffAnimation(List<zendesk.support.request.ViewAlmostRealProgressBar.Step> list, int i2) {
        int progressAnimator;
        zendesk.support.request.ViewAlmostRealProgressBar.StateAwareAnimator finishAnimator;
        int i;
        Object obj4;
        progressAnimator = 0;
        finishAnimator = this.finishAnimator;
        if (this.progressAnimator == null && finishAnimator != null && finishAnimator.isStarted() && !this.finishAnimator.isEnded()) {
            progressAnimator = 0;
            finishAnimator = this.finishAnimator;
            if (finishAnimator != null) {
                if (finishAnimator.isStarted()) {
                    if (!this.finishAnimator.isEnded()) {
                        progressAnimator = this.finishAnimator.get().getDuration();
                    }
                }
            }
            this.finishAnimator = 0;
            obj4 = startAnimation(list, i2, progressAnimator);
            this.progressAnimator = obj4;
            obj4.get().start();
        }
    }

    private Animator progressAnimator(int i, int i2, long l3) {
        int[] iArr = new int[2];
        ObjectAnimator obj3 = ObjectAnimator.ofInt(this, "progress", i, i2);
        DecelerateInterpolator obj4 = new DecelerateInterpolator();
        obj3.setInterpolator(obj4);
        obj3.setDuration(l3);
        return obj3;
    }

    private Animator progressBarAlphaAnimator(float f, float f2, long l3) {
        float[] fArr = new float[2];
        ObjectAnimator obj3 = ObjectAnimator.ofFloat(this, "alpha", f, f2);
        obj3.setDuration(l3);
        return obj3;
    }

    private void restoreProgress(zendesk.support.request.ViewAlmostRealProgressBar.State viewAlmostRealProgressBar$State) {
        int arrayList;
        ArrayList arrayList2;
        boolean adjustTime;
        int i3;
        boolean next;
        int i2;
        int i;
        zendesk.support.request.ViewAlmostRealProgressBar.State obj9;
        final int i4 = 0;
        if (ViewAlmostRealProgressBar.State.access$700(state) > 0) {
            arrayList = new ArrayList(ViewAlmostRealProgressBar.State.access$800(state));
            arrayList2 = new ArrayList();
            Iterator iterator = ViewAlmostRealProgressBar.State.access$800(state).iterator();
            i3 = i4;
            while (iterator.hasNext()) {
                next = iterator.next();
                if (ViewAlmostRealProgressBar.State.access$700(state) < ViewAlmostRealProgressBar.Step.access$500((ViewAlmostRealProgressBar.Step)next)) {
                } else {
                }
                i3 = ViewAlmostRealProgressBar.Step.access$500(next);
                arrayList2.add(next);
            }
            if (a.i(arrayList2)) {
                arrayList2.add(i4, adjustTime(ViewAlmostRealProgressBar.State.access$700(state), i3, (ViewAlmostRealProgressBar.Step)arrayList2.remove(i4)));
            }
            kickOffAnimation(arrayList2, ViewAlmostRealProgressBar.State.access$700(state));
            this.steps = arrayList;
        } else {
            setProgress(i4);
        }
    }

    private zendesk.support.request.ViewAlmostRealProgressBar.StateAwareAnimator startAnimation(List<zendesk.support.request.ViewAlmostRealProgressBar.Step> list, int i2, long l3) {
        int size;
        int i;
        long l;
        int obj7;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator obj6 = list.iterator();
        for (ViewAlmostRealProgressBar.Step next2 : obj6) {
            arrayList.add(progressAnimator(obj7, ViewAlmostRealProgressBar.Step.access$500(next2), ViewAlmostRealProgressBar.Step.access$600(next2)));
            obj7 = size;
        }
        obj6 = new AnimatorSet();
        obj6.playSequentially(arrayList);
        obj6.setStartDelay(l3);
        obj7 = new ViewAlmostRealProgressBar.StateAwareAnimator(obj6);
        return obj7;
    }

    @Override // android.widget.ProgressBar
    public void onRestoreInstanceState(Parcelable parcelable) {
        Object obj2;
        if (parcelable instanceof ViewAlmostRealProgressBar.State) {
            restoreProgress((ViewAlmostRealProgressBar.State)parcelable);
            obj2 = parcelable.getSuperState();
        }
        super.onRestoreInstanceState(obj2);
    }

    @Override // android.widget.ProgressBar
    public Parcelable onSaveInstanceState() {
        Object stopDebounceRunnable;
        if (this.progressAnimator != null && this.stopDebounceRunnable == null) {
            if (this.stopDebounceRunnable == null) {
                ViewAlmostRealProgressBar.State state = new ViewAlmostRealProgressBar.State(super.onSaveInstanceState(), getProgress(), this.steps);
                return state;
            }
        }
        setProgress(0);
        return super.onSaveInstanceState();
    }

    public void start(List<zendesk.support.request.ViewAlmostRealProgressBar.Step> list) {
        Runnable stopDebounceRunnable;
        int i;
        int obj4;
        stopDebounceRunnable = this.stopDebounceRunnable;
        if (stopDebounceRunnable != null) {
            this.handler.removeCallbacks(stopDebounceRunnable);
            this.stopDebounceRunnable = 0;
        } else {
            if (this.startDebounceRunnable == null) {
                stopDebounceRunnable = new ViewAlmostRealProgressBar.1(this, list);
                this.startDebounceRunnable = stopDebounceRunnable;
                this.handler.postDelayed(stopDebounceRunnable, 100);
            }
        }
    }

    @Override // android.widget.ProgressBar
    public void stop(long l) {
        Runnable startDebounceRunnable;
        int i;
        int obj4;
        startDebounceRunnable = this.startDebounceRunnable;
        if (startDebounceRunnable != null) {
            this.handler.removeCallbacks(startDebounceRunnable);
            this.startDebounceRunnable = 0;
        } else {
            if (this.stopDebounceRunnable == null) {
                startDebounceRunnable = new ViewAlmostRealProgressBar.2(this, l, obj5);
                this.stopDebounceRunnable = startDebounceRunnable;
                this.handler.postDelayed(startDebounceRunnable, 200);
            }
        }
    }
}
