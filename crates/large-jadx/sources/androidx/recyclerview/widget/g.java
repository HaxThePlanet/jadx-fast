package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import d.h.l.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class g extends androidx.recyclerview.widget.x {

    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    ArrayList<androidx.recyclerview.widget.RecyclerView.e0> mAddAnimations;
    ArrayList<ArrayList<androidx.recyclerview.widget.RecyclerView.e0>> mAdditionsList;
    ArrayList<androidx.recyclerview.widget.RecyclerView.e0> mChangeAnimations;
    ArrayList<ArrayList<androidx.recyclerview.widget.g.i>> mChangesList;
    ArrayList<androidx.recyclerview.widget.RecyclerView.e0> mMoveAnimations;
    ArrayList<ArrayList<androidx.recyclerview.widget.g.j>> mMovesList;
    private ArrayList<androidx.recyclerview.widget.RecyclerView.e0> mPendingAdditions;
    private ArrayList<androidx.recyclerview.widget.g.i> mPendingChanges;
    private ArrayList<androidx.recyclerview.widget.g.j> mPendingMoves;
    private ArrayList<androidx.recyclerview.widget.RecyclerView.e0> mPendingRemovals;
    ArrayList<androidx.recyclerview.widget.RecyclerView.e0> mRemoveAnimations;

    class a implements Runnable {

        final ArrayList a;
        final androidx.recyclerview.widget.g b;
        a(androidx.recyclerview.widget.g g, ArrayList arrayList2) {
            this.b = g;
            this.a = arrayList2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object next;
            androidx.recyclerview.widget.g gVar;
            androidx.recyclerview.widget.RecyclerView.e0 view;
            int i2;
            int i;
            int i4;
            int i3;
            Iterator iterator = this.a.iterator();
            for (g.j next : iterator) {
                this.b.animateMoveImpl(next.a, next.b, next.c, next.d, next.e);
            }
            this.a.clear();
            gVar2.mMovesList.remove(this.a);
        }
    }

    class b implements Runnable {

        final ArrayList a;
        final androidx.recyclerview.widget.g b;
        b(androidx.recyclerview.widget.g g, ArrayList arrayList2) {
            this.b = g;
            this.a = arrayList2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object next;
            androidx.recyclerview.widget.g gVar;
            Iterator iterator = this.a.iterator();
            for (g.i next : iterator) {
                this.b.animateChangeImpl(next);
            }
            this.a.clear();
            gVar2.mChangesList.remove(this.a);
        }
    }

    class c implements Runnable {

        final ArrayList a;
        final androidx.recyclerview.widget.g b;
        c(androidx.recyclerview.widget.g g, ArrayList arrayList2) {
            this.b = g;
            this.a = arrayList2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object next;
            androidx.recyclerview.widget.g gVar;
            Iterator iterator = this.a.iterator();
            for (RecyclerView.e0 next : iterator) {
                this.b.animateAddImpl(next);
            }
            this.a.clear();
            gVar2.mAdditionsList.remove(this.a);
        }
    }

    class d extends AnimatorListenerAdapter {

        final androidx.recyclerview.widget.RecyclerView.e0 a;
        final ViewPropertyAnimator b;
        final View c;
        final androidx.recyclerview.widget.g d;
        d(androidx.recyclerview.widget.g g, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02, ViewPropertyAnimator viewPropertyAnimator3, View view4) {
            this.d = g;
            this.a = e02;
            this.b = viewPropertyAnimator3;
            this.c = view4;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.b.setListener(0);
            this.c.setAlpha(1065353216);
            this.d.dispatchRemoveFinished(this.a);
            obj2.mRemoveAnimations.remove(this.a);
            this.d.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            this.d.dispatchRemoveStarting(this.a);
        }
    }

    class e extends AnimatorListenerAdapter {

        final androidx.recyclerview.widget.RecyclerView.e0 a;
        final View b;
        final ViewPropertyAnimator c;
        final androidx.recyclerview.widget.g d;
        e(androidx.recyclerview.widget.g g, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02, View view3, ViewPropertyAnimator viewPropertyAnimator4) {
            this.d = g;
            this.a = e02;
            this.b = view3;
            this.c = viewPropertyAnimator4;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationCancel(Animator animator) {
            this.b.setAlpha(1065353216);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.c.setListener(0);
            this.d.dispatchAddFinished(this.a);
            obj2.mAddAnimations.remove(this.a);
            this.d.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            this.d.dispatchAddStarting(this.a);
        }
    }

    class f extends AnimatorListenerAdapter {

        final androidx.recyclerview.widget.RecyclerView.e0 a;
        final int b;
        final View c;
        final int d;
        final ViewPropertyAnimator e;
        final androidx.recyclerview.widget.g f;
        f(androidx.recyclerview.widget.g g, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02, int i3, View view4, int i5, ViewPropertyAnimator viewPropertyAnimator6) {
            this.f = g;
            this.a = e02;
            this.b = i3;
            this.c = view4;
            this.d = i5;
            this.e = viewPropertyAnimator6;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationCancel(Animator animator) {
            int obj2;
            final int i = 0;
            if (this.b != 0) {
                this.c.setTranslationX(i);
            }
            if (this.d != 0) {
                this.c.setTranslationY(i);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.e.setListener(0);
            this.f.dispatchMoveFinished(this.a);
            obj2.mMoveAnimations.remove(this.a);
            this.f.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            this.f.dispatchMoveStarting(this.a);
        }
    }

    class g extends AnimatorListenerAdapter {

        final androidx.recyclerview.widget.g.i a;
        final ViewPropertyAnimator b;
        final View c;
        final androidx.recyclerview.widget.g d;
        g(androidx.recyclerview.widget.g g, androidx.recyclerview.widget.g.i g$i2, ViewPropertyAnimator viewPropertyAnimator3, View view4) {
            this.d = g;
            this.a = i2;
            this.b = viewPropertyAnimator3;
            this.c = view4;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.b.setListener(0);
            this.c.setAlpha(1065353216);
            int i3 = 0;
            this.c.setTranslationX(i3);
            this.c.setTranslationY(i3);
            this.d.dispatchChangeFinished(iVar.a, true);
            obj3.mChangeAnimations.remove(iVar2.a);
            this.d.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            this.d.dispatchChangeStarting(iVar.a, true);
        }
    }

    class h extends AnimatorListenerAdapter {

        final androidx.recyclerview.widget.g.i a;
        final ViewPropertyAnimator b;
        final View c;
        final androidx.recyclerview.widget.g d;
        h(androidx.recyclerview.widget.g g, androidx.recyclerview.widget.g.i g$i2, ViewPropertyAnimator viewPropertyAnimator3, View view4) {
            this.d = g;
            this.a = i2;
            this.b = viewPropertyAnimator3;
            this.c = view4;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.b.setListener(0);
            this.c.setAlpha(1065353216);
            int i3 = 0;
            this.c.setTranslationX(i3);
            this.c.setTranslationY(i3);
            this.d.dispatchChangeFinished(iVar.b, false);
            obj3.mChangeAnimations.remove(iVar2.b);
            this.d.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            this.d.dispatchChangeStarting(iVar.b, false);
        }
    }

    private static class i {

        public androidx.recyclerview.widget.RecyclerView.e0 a;
        public androidx.recyclerview.widget.RecyclerView.e0 b;
        public int c;
        public int d;
        public int e;
        public int f;
        private i(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02) {
            super();
            this.a = e0;
            this.b = e02;
        }

        i(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02, int i3, int i4, int i5, int i6) {
            super(e0, e02);
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ChangeInfo{oldHolder=");
            stringBuilder.append(this.a);
            stringBuilder.append(", newHolder=");
            stringBuilder.append(this.b);
            stringBuilder.append(", fromX=");
            stringBuilder.append(this.c);
            stringBuilder.append(", fromY=");
            stringBuilder.append(this.d);
            stringBuilder.append(", toX=");
            stringBuilder.append(this.e);
            stringBuilder.append(", toY=");
            stringBuilder.append(this.f);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private static class j {

        public androidx.recyclerview.widget.RecyclerView.e0 a;
        public int b;
        public int c;
        public int d;
        public int e;
        j(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, int i2, int i3, int i4, int i5) {
            super();
            this.a = e0;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
        }
    }
    public g() {
        super();
        ArrayList arrayList = new ArrayList();
        this.mPendingRemovals = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.mPendingAdditions = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.mPendingMoves = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        this.mPendingChanges = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        this.mAdditionsList = arrayList5;
        ArrayList arrayList6 = new ArrayList();
        this.mMovesList = arrayList6;
        ArrayList arrayList7 = new ArrayList();
        this.mChangesList = arrayList7;
        ArrayList arrayList8 = new ArrayList();
        this.mAddAnimations = arrayList8;
        ArrayList arrayList9 = new ArrayList();
        this.mMoveAnimations = arrayList9;
        ArrayList arrayList10 = new ArrayList();
        this.mRemoveAnimations = arrayList10;
        ArrayList arrayList11 = new ArrayList();
        this.mChangeAnimations = arrayList11;
    }

    private void animateRemoveImpl(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        final View itemView = e0.itemView;
        final ViewPropertyAnimator animate = itemView.animate();
        this.mRemoveAnimations.add(e0);
        g.d dVar = new g.d(this, e0, animate, itemView);
        animate.setDuration(getRemoveDuration()).alpha(0).setListener(dVar).start();
    }

    private void endChangeAnimation(List<androidx.recyclerview.widget.g.i> list, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02) {
        int i;
        Object obj;
        boolean endChangeAnimationIfNecessary;
        size--;
        while (i >= 0) {
            obj = list.get(i);
            if (endChangeAnimationIfNecessary((g.i)obj, e02) && obj.a == null && obj.b == null) {
            }
            i--;
            if (obj.a == null) {
            }
            if (obj.b == null) {
            }
            list.remove(obj);
        }
    }

    private void endChangeAnimationIfNecessary(androidx.recyclerview.widget.g.i g$i) {
        androidx.recyclerview.widget.RecyclerView.e0 view = i.a;
        if (view != null) {
            endChangeAnimationIfNecessary(i, view);
        }
        androidx.recyclerview.widget.RecyclerView.e0 view2 = i.b;
        if (view2 != null) {
            endChangeAnimationIfNecessary(i, view2);
        }
    }

    private boolean endChangeAnimationIfNecessary(androidx.recyclerview.widget.g.i g$i, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02) {
        androidx.recyclerview.widget.RecyclerView.e0 view;
        int i2;
        final int i5 = 1;
        final int i6 = 0;
        if (i.b == e02) {
            i.b = i6;
            e02.itemView.setAlpha(1065353216);
            int i4 = 0;
            e02.itemView.setTranslationX(i4);
            e02.itemView.setTranslationY(i4);
            dispatchChangeFinished(e02, i2);
            return i5;
        } else {
            if (i.a == e02) {
                i.a = i6;
                i2 = i5;
            }
        }
        return 0;
    }

    private void resetAnimation(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        TimeInterpolator sDefaultInterpolator;
        if (g.sDefaultInterpolator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            g.sDefaultInterpolator = valueAnimator.getInterpolator();
        }
        e0.itemView.animate().setInterpolator(g.sDefaultInterpolator);
        endAnimation(e0);
    }

    @Override // androidx.recyclerview.widget.x
    public boolean animateAdd(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        resetAnimation(e0);
        e0.itemView.setAlpha(0);
        this.mPendingAdditions.add(e0);
        return 1;
    }

    @Override // androidx.recyclerview.widget.x
    void animateAddImpl(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        final View itemView = e0.itemView;
        final ViewPropertyAnimator animate = itemView.animate();
        this.mAddAnimations.add(e0);
        g.e eVar = new g.e(this, e0, itemView, animate);
        animate.alpha(1065353216).setDuration(getAddDuration()).setListener(eVar).start();
    }

    @Override // androidx.recyclerview.widget.x
    public boolean animateChange(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e02, int i3, int i4, int i5, int i6) {
        View itemView;
        float translationY;
        if (e0 == e02) {
            return this.animateMove(e0, i3, i4, i5, i6);
        }
        float translationX = e0.itemView.getTranslationX();
        translationY = e0.itemView.getTranslationY();
        resetAnimation(e0);
        e0.itemView.setTranslationX(translationX);
        e0.itemView.setTranslationY(translationY);
        e0.itemView.setAlpha(e0.itemView.getAlpha());
        if (e02 != null) {
            resetAnimation(e02);
            e02.itemView.setTranslationX((float)i);
            e02.itemView.setTranslationY((float)i2);
            e02.itemView.setAlpha(0);
        }
        super(e0, e02, i3, i4, i5, i6);
        this.mPendingChanges.add(iVar2);
        return 1;
    }

    @Override // androidx.recyclerview.widget.x
    void animateChangeImpl(androidx.recyclerview.widget.g.i g$i) {
        View itemView;
        int itemView2;
        int alpha2;
        ViewPropertyAnimator hVar;
        ViewPropertyAnimator alpha;
        androidx.recyclerview.widget.g.g gVar;
        Object obj7;
        androidx.recyclerview.widget.RecyclerView.e0 view = i.a;
        itemView = view == null ? itemView2 : view.itemView;
        androidx.recyclerview.widget.RecyclerView.e0 view2 = i.b;
        if (view2 != null) {
            itemView2 = view2.itemView;
        }
        alpha2 = 0;
        if (itemView != null) {
            hVar = itemView.animate().setDuration(getChangeDuration());
            this.mChangeAnimations.add(i.a);
            hVar.translationX((float)i4);
            hVar.translationY((float)i6);
            gVar = new g.g(this, i, hVar, itemView);
            hVar.alpha(alpha2).setListener(gVar).start();
        }
        if (itemView2 != 0) {
            itemView = itemView2.animate();
            alpha = i.b;
            this.mChangeAnimations.add(alpha);
            hVar = new g.h(this, i, itemView, itemView2);
            itemView.translationX(alpha2).translationY(alpha2).setDuration(getChangeDuration()).alpha(1065353216).setListener(hVar).start();
        }
    }

    @Override // androidx.recyclerview.widget.x
    public boolean animateMove(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, int i2, int i3, int i4, int i5) {
        int obj10;
        final View itemView = e0.itemView;
        final int i6 = i2 + i;
        final int i7 = i3 + obj10;
        resetAnimation(e0);
        obj10 = i4 - i6;
        int obj11 = i5 - i7;
        if (obj10 == null && obj11 == null) {
            if (obj11 == null) {
                dispatchMoveFinished(e0);
                return 0;
            }
        }
        if (obj10 != null) {
            itemView.setTranslationX((float)obj10);
        }
        if (obj11 != null) {
            itemView.setTranslationY((float)obj10);
        }
        super(e0, i6, i7, i4, i5);
        this.mPendingMoves.add(obj11);
        return 1;
    }

    @Override // androidx.recyclerview.widget.x
    void animateMoveImpl(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, int i2, int i3, int i4, int i5) {
        int obj10;
        final View itemView = e0.itemView;
        final int i = i4 - i2;
        final int i6 = i5 - i3;
        int obj9 = 0;
        if (i != 0) {
            itemView.animate().translationX(obj9);
        }
        if (i6 != 0) {
            itemView.animate().translationY(obj9);
        }
        final ViewPropertyAnimator animate = itemView.animate();
        this.mMoveAnimations.add(e0);
        super(this, e0, i, itemView, i6, animate);
        animate.setDuration(getMoveDuration()).setListener(obj10).start();
    }

    @Override // androidx.recyclerview.widget.x
    public boolean animateRemove(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        resetAnimation(e0);
        this.mPendingRemovals.add(e0);
        return 1;
    }

    public boolean canReuseUpdatedViewHolder(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0, List<Object> list2) {
        int obj2;
        if (list2.isEmpty()) {
            if (super.canReuseUpdatedViewHolder(e0, list2)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    void cancelAll(List<androidx.recyclerview.widget.RecyclerView.e0> list) {
        int i;
        ViewPropertyAnimator animate;
        size--;
        while (i >= 0) {
            obj.itemView.animate().cancel();
            i--;
        }
    }

    @Override // androidx.recyclerview.widget.x
    void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    @Override // androidx.recyclerview.widget.x
    public void endAnimation(androidx.recyclerview.widget.RecyclerView.e0 recyclerView$e0) {
        int i3;
        int i4;
        int i;
        int i2;
        int mAdditionsList;
        androidx.recyclerview.widget.RecyclerView.e0 view2;
        boolean mChangesList;
        int i5;
        androidx.recyclerview.widget.RecyclerView.e0 view;
        View itemView = e0.itemView;
        itemView.animate().cancel();
        size--;
        mAdditionsList = 0;
        while (i3 >= 0) {
            if (obj.a == e0) {
            }
            i3--;
            mAdditionsList = 0;
            itemView.setTranslationY(mAdditionsList);
            itemView.setTranslationX(mAdditionsList);
            dispatchMoveFinished(e0);
            this.mPendingMoves.remove(i3);
        }
        endChangeAnimation(this.mPendingChanges, e0);
        int i6 = 1065353216;
        if (this.mPendingRemovals.remove(e0)) {
            itemView.setAlpha(i6);
            dispatchRemoveFinished(e0);
        }
        if (this.mPendingAdditions.remove(e0)) {
            itemView.setAlpha(i6);
            dispatchAddFinished(e0);
        }
        size2--;
        while (i4 >= 0) {
            Object obj2 = this.mChangesList.get(i4);
            endChangeAnimation((ArrayList)obj2, e0);
            if (obj2.isEmpty()) {
            }
            i4--;
            this.mChangesList.remove(i4);
        }
        size3--;
        while (i >= 0) {
            mChangesList = this.mMovesList.get(i);
            size5--;
            while (i5 >= 0) {
                if (obj3.a == e0) {
                    break loop_17;
                } else {
                }
                i5--;
            }
            i--;
            if (obj3.a == e0) {
            } else {
            }
            i5--;
            itemView.setTranslationY(mAdditionsList);
            itemView.setTranslationX(mAdditionsList);
            dispatchMoveFinished(e0);
            mChangesList.remove(i5);
            if (mChangesList.isEmpty()) {
            }
            this.mMovesList.remove(i);
        }
        size4--;
        while (i2 >= 0) {
            mAdditionsList = this.mAdditionsList.get(i2);
            itemView.setAlpha(i6);
            dispatchAddFinished(e0);
            if ((ArrayList)mAdditionsList.remove(e0) && mAdditionsList.isEmpty()) {
            }
            i2--;
            itemView.setAlpha(i6);
            dispatchAddFinished(e0);
            if (mAdditionsList.isEmpty()) {
            }
            this.mAdditionsList.remove(i2);
        }
        this.mRemoveAnimations.remove(e0);
        this.mAddAnimations.remove(e0);
        this.mChangeAnimations.remove(e0);
        this.mMoveAnimations.remove(e0);
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.x
    public void endAnimations() {
        int i;
        int i4;
        int i8;
        int i7;
        int i3;
        int i5;
        int i6;
        ArrayList mPendingMoves;
        int i9;
        Object mPendingAdditions;
        int i2;
        View mChangesList;
        View mAdditionsList;
        boolean mMovesList;
        View itemView;
        size--;
        i9 = 0;
        while (i >= 0) {
            mPendingAdditions = this.mPendingMoves.get(i);
            mChangesList = view2.itemView;
            mChangesList.setTranslationY(i9);
            mChangesList.setTranslationX(i9);
            dispatchMoveFinished(mPendingAdditions.a);
            this.mPendingMoves.remove(i);
            i--;
            i9 = 0;
        }
        size2--;
        while (i4 >= 0) {
            dispatchRemoveFinished((RecyclerView.e0)this.mPendingRemovals.get(i4));
            this.mPendingRemovals.remove(i4);
            i4--;
        }
        size3--;
        i2 = 1065353216;
        while (i8 >= 0) {
            mChangesList = this.mPendingAdditions.get(i8);
            mChangesList.itemView.setAlpha(i2);
            dispatchAddFinished((RecyclerView.e0)mChangesList);
            this.mPendingAdditions.remove(i8);
            i8--;
            i2 = 1065353216;
        }
        size4--;
        while (i7 >= 0) {
            endChangeAnimationIfNecessary((g.i)this.mPendingChanges.get(i7));
            i7--;
        }
        this.mPendingChanges.clear();
        if (!isRunning()) {
        }
        size5--;
        while (i3 >= 0) {
            mChangesList = this.mMovesList.get(i3);
            size10--;
            while (mAdditionsList >= 0) {
                Object obj4 = mChangesList.get(mAdditionsList);
                itemView = view4.itemView;
                itemView.setTranslationY(i9);
                itemView.setTranslationX(i9);
                dispatchMoveFinished(obj4.a);
                mChangesList.remove(mAdditionsList);
                if (mChangesList.isEmpty()) {
                }
                mAdditionsList--;
                this.mMovesList.remove(mChangesList);
            }
            i3--;
            obj4 = mChangesList.get(mAdditionsList);
            itemView = view4.itemView;
            itemView.setTranslationY(i9);
            itemView.setTranslationX(i9);
            dispatchMoveFinished(obj4.a);
            mChangesList.remove(mAdditionsList);
            if (mChangesList.isEmpty()) {
            }
            mAdditionsList--;
            this.mMovesList.remove(mChangesList);
        }
        size6--;
        while (i5 >= 0) {
            i9 = this.mAdditionsList.get(i5);
            size9--;
            while (mChangesList >= 0) {
                Object obj3 = i9.get(mChangesList);
                obj3.itemView.setAlpha(i2);
                dispatchAddFinished((RecyclerView.e0)obj3);
                i9.remove(mChangesList);
                if (i9.isEmpty()) {
                }
                mChangesList--;
                this.mAdditionsList.remove(i9);
            }
            i5--;
            obj3 = i9.get(mChangesList);
            obj3.itemView.setAlpha(i2);
            dispatchAddFinished((RecyclerView.e0)obj3);
            i9.remove(mChangesList);
            if (i9.isEmpty()) {
            }
            mChangesList--;
            this.mAdditionsList.remove(i9);
        }
        size7--;
        while (i6 >= 0) {
            i9 = this.mChangesList.get(i6);
            size8--;
            while (i2 >= 0) {
                endChangeAnimationIfNecessary((g.i)i9.get(i2));
                if (i9.isEmpty()) {
                }
                i2--;
                this.mChangesList.remove(i9);
            }
            i6--;
            endChangeAnimationIfNecessary((g.i)i9.get(i2));
            if (i9.isEmpty()) {
            }
            i2--;
            this.mChangesList.remove(i9);
        }
        cancelAll(this.mRemoveAnimations);
        cancelAll(this.mMoveAnimations);
        cancelAll(this.mAddAnimations);
        cancelAll(this.mChangeAnimations);
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.x
    public boolean isRunning() {
        int i;
        boolean empty;
        if (this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty()) {
            if (this.mPendingChanges.isEmpty()) {
                if (this.mPendingMoves.isEmpty()) {
                    if (this.mPendingRemovals.isEmpty()) {
                        if (this.mMoveAnimations.isEmpty()) {
                            if (this.mRemoveAnimations.isEmpty()) {
                                if (this.mAddAnimations.isEmpty()) {
                                    if (this.mChangeAnimations.isEmpty()) {
                                        if (this.mMovesList.isEmpty()) {
                                            if (this.mAdditionsList.isEmpty()) {
                                                if (!this.mChangesList.isEmpty()) {
                                                    i = 1;
                                                } else {
                                                    i = 0;
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.x
    public void runPendingAnimations() {
        int itemView;
        int moveDuration;
        int arrayList;
        Object next;
        boolean arrayList2;
        androidx.recyclerview.widget.g.a changeDuration;
        long removeDuration2;
        long l;
        int removeDuration;
        empty ^= 1;
        empty2 ^= 1;
        empty3 ^= 1;
        empty4 ^= 1;
        if (itemView == null && i == 0 && arrayList == null && i2 == 0) {
            if (i == 0) {
                if (arrayList == null) {
                    if (i2 == 0) {
                    }
                }
            }
        }
        Iterator iterator = this.mPendingRemovals.iterator();
        for (RecyclerView.e0 next : iterator) {
            animateRemoveImpl(next);
        }
        this.mPendingRemovals.clear();
        int i3 = 0;
        if (i != 0) {
            arrayList2 = new ArrayList();
            arrayList2.addAll(this.mPendingMoves);
            this.mMovesList.add(arrayList2);
            this.mPendingMoves.clear();
            changeDuration = new g.a(this, arrayList2);
            if (itemView != null) {
                u.e0(view.itemView, changeDuration, getRemoveDuration());
            } else {
                changeDuration.run();
            }
        }
        if (i2 != 0) {
            arrayList2 = new ArrayList();
            arrayList2.addAll(this.mPendingChanges);
            this.mChangesList.add(arrayList2);
            this.mPendingChanges.clear();
            changeDuration = new g.b(this, arrayList2);
            if (itemView != null) {
                u.e0(view2.itemView, changeDuration, getRemoveDuration());
            } else {
                changeDuration.run();
            }
        }
        if (arrayList != null) {
            arrayList = new ArrayList();
            arrayList.addAll(this.mPendingAdditions);
            this.mAdditionsList.add(arrayList);
            this.mPendingAdditions.clear();
            arrayList2 = new g.c(this, arrayList);
            if (itemView == null && i == 0) {
                if (i == 0) {
                    if (i2 != 0) {
                        changeDuration = 0;
                        if (itemView != null) {
                            removeDuration = getRemoveDuration();
                        } else {
                            removeDuration = changeDuration;
                        }
                        if (i != 0) {
                            moveDuration = getMoveDuration();
                        } else {
                            moveDuration = changeDuration;
                        }
                        if (i2 != 0) {
                            changeDuration = getChangeDuration();
                        }
                        u.e0(obj.itemView, arrayList2, removeDuration += l2);
                    } else {
                        arrayList2.run();
                    }
                } else {
                }
            } else {
            }
        }
    }
}
