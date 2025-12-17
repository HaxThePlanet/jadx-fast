package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.Transition.TransitionListener;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class y extends androidx.fragment.app.z {

    class a extends Transition.EpicenterCallback {

        final Rect a;
        a(androidx.fragment.app.y y, Rect rect2) {
            this.a = rect2;
            super();
        }

        @Override // android.transition.Transition$EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            return this.a;
        }
    }

    class b implements Transition.TransitionListener {

        final View a;
        final ArrayList b;
        b(androidx.fragment.app.y y, View view2, ArrayList arrayList3) {
            this.a = view2;
            this.b = arrayList3;
            super();
        }

        @Override // android.transition.Transition$TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition$TransitionListener
        public void onTransitionEnd(Transition transition) {
            int i;
            Object obj;
            transition.removeListener(this);
            this.a.setVisibility(8);
            int i3 = 0;
            i = i3;
            while (i < this.b.size()) {
                (View)this.b.get(i).setVisibility(i3);
                i++;
            }
        }

        @Override // android.transition.Transition$TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition$TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition$TransitionListener
        public void onTransitionStart(Transition transition) {
            transition.removeListener(this);
            transition.addListener(this);
        }
    }

    class c implements Transition.TransitionListener {

        final Object a;
        final ArrayList b;
        final Object c;
        final ArrayList d;
        final Object e;
        final ArrayList f;
        final androidx.fragment.app.y g;
        c(androidx.fragment.app.y y, Object object2, ArrayList arrayList3, Object object4, ArrayList arrayList5, Object object6, ArrayList arrayList7) {
            this.g = y;
            this.a = object2;
            this.b = arrayList3;
            this.c = object4;
            this.d = arrayList5;
            this.e = object6;
            this.f = arrayList7;
            super();
        }

        @Override // android.transition.Transition$TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition$TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        @Override // android.transition.Transition$TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition$TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition$TransitionListener
        public void onTransitionStart(Transition transition) {
            androidx.fragment.app.y yVar;
            ArrayList list;
            Object obj4 = this.a;
            final int i = 0;
            if (obj4 != null) {
                this.g.q(obj4, this.b, i);
            }
            obj4 = this.c;
            if (obj4 != null) {
                this.g.q(obj4, this.d, i);
            }
            obj4 = this.e;
            if (obj4 != null) {
                this.g.q(obj4, this.f, i);
            }
        }
    }

    class d implements Transition.TransitionListener {

        final Runnable a;
        d(androidx.fragment.app.y y, Runnable runnable2) {
            this.a = runnable2;
            super();
        }

        @Override // android.transition.Transition$TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition$TransitionListener
        public void onTransitionEnd(Transition transition) {
            this.a.run();
        }

        @Override // android.transition.Transition$TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition$TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition$TransitionListener
        public void onTransitionStart(Transition transition) {
        }
    }

    class e extends Transition.EpicenterCallback {

        final Rect a;
        e(androidx.fragment.app.y y, Rect rect2) {
            this.a = rect2;
            super();
        }

        @Override // android.transition.Transition$EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            Rect obj1;
            obj1 = this.a;
            if (obj1 != null && obj1.isEmpty()) {
                if (obj1.isEmpty()) {
                }
                return this.a;
            }
            return null;
        }
    }
    private static boolean C(Transition transition) {
        boolean z;
        boolean obj1;
        if (z.l(transition.getTargetIds()) && z.l(transition.getTargetNames())) {
            if (z.l(transition.getTargetNames())) {
                if (!z.l(transition.getTargetTypes())) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    public void A(Object object, ArrayList<View> arrayList2, ArrayList<View> arrayList3) {
        List targets;
        if ((TransitionSet)object != null) {
            (TransitionSet)object.getTargets().clear();
            object.getTargets().addAll(arrayList3);
            q(object, arrayList2, arrayList3);
        }
    }

    @Override // androidx.fragment.app.z
    public Object B(Object object) {
        if (object == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition)object);
        return transitionSet;
    }

    @Override // androidx.fragment.app.z
    public void a(Object object, View view2) {
        if (object != null) {
            (Transition)object.addTarget(view2);
        }
    }

    public void b(Object object, ArrayList<View> arrayList2) {
        int transitionCount;
        int i;
        Transition transitionAt;
        if ((Transition)object == null) {
        }
        i = 0;
        if (object instanceof TransitionSet != null) {
            while (i < (TransitionSet)(Transition)object.getTransitionCount()) {
                b(object.getTransitionAt(i), arrayList2);
                i++;
            }
        } else {
            if (!y.C(object) && z.l(object.getTargets())) {
                if (z.l(object.getTargets())) {
                    while (i < arrayList2.size()) {
                        object.addTarget((View)arrayList2.get(i));
                        i++;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.z
    public void c(ViewGroup viewGroup, Object object2) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition)object2);
    }

    @Override // androidx.fragment.app.z
    public boolean e(Object object) {
        return object instanceof Transition;
    }

    @Override // androidx.fragment.app.z
    public Object g(Object object) {
        Transition obj1;
        if (object != null) {
            obj1 = (Transition)object.clone();
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    @Override // androidx.fragment.app.z
    public Object m(Object object, Object object2, Object object3) {
        TransitionSet transitionSet;
        int obj2;
        Transition obj3;
        if ((Transition)object != null && (Transition)object2 != null) {
            if ((Transition)object2 != null) {
                transitionSet = new TransitionSet();
                obj2 = transitionSet.addTransition((Transition)object).addTransition((Transition)object2).setOrdering(1);
            } else {
                if (object != null) {
                } else {
                    obj2 = object2 != null ? object2 : 0;
                }
            }
        } else {
        }
        obj3 = new TransitionSet();
        if ((Transition)object3 != null && obj2 != null) {
            obj3 = new TransitionSet();
            if (obj2 != null) {
                obj3.addTransition(obj2);
            }
            obj3.addTransition((Transition)object3);
            return obj3;
        }
        return obj2;
    }

    @Override // androidx.fragment.app.z
    public Object n(Object object, Object object2, Object object3) {
        TransitionSet transitionSet = new TransitionSet();
        if (object != null) {
            transitionSet.addTransition((Transition)object);
        }
        if (object2 != null) {
            transitionSet.addTransition((Transition)object2);
        }
        if (object3 != null) {
            transitionSet.addTransition((Transition)object3);
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.z
    public void p(Object object, View view2) {
        if (object != null) {
            (Transition)object.removeTarget(view2);
        }
    }

    public void q(Object object, ArrayList<View> arrayList2, ArrayList<View> arrayList3) {
        int transitionCount;
        int i;
        Transition transitionAt;
        int size;
        int obj7;
        if (object instanceof TransitionSet != null) {
            while (i < (TransitionSet)(Transition)object.getTransitionCount()) {
                q(object.getTransitionAt(i), arrayList2, arrayList3);
                i++;
            }
        } else {
            transitionCount = object.getTargets();
            if (!y.C(object) && transitionCount != null && transitionCount.size() == arrayList2.size() && transitionCount.containsAll(arrayList2)) {
                transitionCount = object.getTargets();
                if (transitionCount != null) {
                    if (transitionCount.size() == arrayList2.size()) {
                        if (transitionCount.containsAll(arrayList2)) {
                            if (arrayList3 == null) {
                                transitionCount = i;
                            } else {
                                transitionCount = arrayList3.size();
                            }
                            while (i < transitionCount) {
                                object.addTarget((View)arrayList3.get(i));
                                i++;
                            }
                            obj7--;
                            while (obj7 >= 0) {
                                object.removeTarget((View)arrayList2.get(obj7));
                                obj7--;
                            }
                        }
                    }
                }
            }
        }
    }

    public void r(Object object, View view2, ArrayList<View> arrayList3) {
        y.b bVar = new y.b(this, view2, arrayList3);
        (Transition)object.addListener(bVar);
    }

    public void t(Object object, Object object2, ArrayList<View> arrayList3, Object object4, ArrayList<View> arrayList5, Object object6, ArrayList<View> arrayList7) {
        super(this, object2, arrayList3, object4, arrayList5, object6, arrayList7);
        (Transition)object.addListener(cVar2);
    }

    @Override // androidx.fragment.app.z
    public void u(Object object, Rect rect2) {
        androidx.fragment.app.y.e eVar;
        if (object != null) {
            eVar = new y.e(this, rect2);
            (Transition)object.setEpicenterCallback(eVar);
        }
    }

    @Override // androidx.fragment.app.z
    public void v(Object object, View view2) {
        Rect rect;
        Object obj3;
        if (view2 != null) {
            rect = new Rect();
            k(view2, rect);
            obj3 = new y.a(this, rect);
            (Transition)object.setEpicenterCallback(obj3);
        }
    }

    @Override // androidx.fragment.app.z
    public void w(androidx.fragment.app.Fragment fragment, Object object2, b b3, Runnable runnable4) {
        y.d obj1 = new y.d(this, runnable4);
        (Transition)object2.addListener(obj1);
    }

    public void z(Object object, View view2, ArrayList<View> arrayList3) {
        int i;
        Object obj;
        final List targets = (TransitionSet)object.getTargets();
        targets.clear();
        i = 0;
        while (i < arrayList3.size()) {
            z.d(targets, (View)arrayList3.get(i));
            i++;
        }
        targets.add(view2);
        arrayList3.add(view2);
        b(object, arrayList3);
    }
}
