package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import androidx.core.app.p;
import androidx.core.os.b;
import androidx.core.os.b.a;
import d.e.a;
import d.e.g;
import d.h.k.i;
import d.h.l.r;
import d.h.l.u;
import d.h.l.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes.dex */
class c extends androidx.fragment.app.c0 {

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            c.a.a = iArr;
            iArr[c0.e.c.GONE.ordinal()] = 1;
            c.a.a[c0.e.c.INVISIBLE.ordinal()] = 2;
            c.a.a[c0.e.c.REMOVED.ordinal()] = 3;
            c.a.a[c0.e.c.VISIBLE.ordinal()] = 4;
        }
    }

    class b implements Runnable {

        final List a;
        final androidx.fragment.app.c0.e b;
        final androidx.fragment.app.c c;
        b(androidx.fragment.app.c c, List list2, androidx.fragment.app.c0.e c0$e3) {
            this.c = c;
            this.a = list2;
            this.b = e3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean contains;
            androidx.fragment.app.c0.e eVar;
            if (this.a.contains(this.b)) {
                this.a.remove(this.b);
                this.c.s(this.b);
            }
        }
    }

    class c extends AnimatorListenerAdapter {

        final ViewGroup a;
        final View b;
        final boolean c;
        final androidx.fragment.app.c0.e d;
        final androidx.fragment.app.c.k e;
        c(androidx.fragment.app.c c, ViewGroup viewGroup2, View view3, boolean z4, androidx.fragment.app.c0.e c0$e5, androidx.fragment.app.c.k c$k6) {
            this.a = viewGroup2;
            this.b = view3;
            this.c = z4;
            this.d = e5;
            this.e = k6;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            View view;
            boolean obj2;
            this.a.endViewTransition(this.b);
            if (this.c) {
                this.d.e().applyState(this.b);
            }
            this.e.a();
        }
    }

    class e implements Animation.AnimationListener {

        final ViewGroup a;
        final View b;
        final androidx.fragment.app.c.k c;
        e(androidx.fragment.app.c c, ViewGroup viewGroup2, View view3, androidx.fragment.app.c.k c$k4) {
            this.a = viewGroup2;
            this.b = view3;
            this.c = k4;
            super();
        }

        @Override // android.view.animation.Animation$AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.e.a aVar = new c.e.a(this);
            this.a.post(aVar);
        }

        @Override // android.view.animation.Animation$AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation$AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class g implements Runnable {

        final androidx.fragment.app.c0.e a;
        final androidx.fragment.app.c0.e b;
        final boolean c;
        final a v;
        g(androidx.fragment.app.c c, androidx.fragment.app.c0.e c0$e2, androidx.fragment.app.c0.e c0$e3, boolean z4, a a5) {
            this.a = e2;
            this.b = e3;
            this.c = z4;
            this.v = a5;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            x.f(this.a.f(), this.b.f(), this.c, this.v, false);
        }
    }

    class h implements Runnable {

        final androidx.fragment.app.z a;
        final View b;
        final Rect c;
        h(androidx.fragment.app.c c, androidx.fragment.app.z z2, View view3, Rect rect4) {
            this.a = z2;
            this.b = view3;
            this.c = rect4;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.k(this.b, this.c);
        }
    }

    class i implements Runnable {

        final ArrayList a;
        i(androidx.fragment.app.c c, ArrayList arrayList2) {
            this.a = arrayList2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            x.B(this.a, 4);
        }
    }

    class j implements Runnable {

        final androidx.fragment.app.c.m a;
        j(androidx.fragment.app.c c, androidx.fragment.app.c.m c$m2) {
            this.a = m2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a();
        }
    }

    private static class l {

        private final androidx.fragment.app.c0.e a;
        private final b b;
        l(androidx.fragment.app.c0.e c0$e, b b2) {
            super();
            this.a = e;
            this.b = b2;
        }

        void a() {
            this.a.d(this.b);
        }

        androidx.fragment.app.c0.e b() {
            return this.a;
        }

        b c() {
            return this.b;
        }

        boolean d() {
            int i;
            androidx.fragment.app.c0.e.c vISIBLE;
            androidx.fragment.app.c0.e.c from = c0.e.c.from(fragment.mView);
            androidx.fragment.app.c0.e.c cVar = this.a.e();
            if (from != cVar) {
                vISIBLE = c0.e.c.VISIBLE;
                if (from != vISIBLE && cVar != vISIBLE) {
                    if (cVar != vISIBLE) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
    }

    class d implements b.a {

        final Animator a;
        d(androidx.fragment.app.c c, Animator animator2) {
            this.a = animator2;
            super();
        }

        @Override // androidx.core.os.b$a
        public void a() {
            this.a.end();
        }
    }

    class f implements b.a {

        final View a;
        final ViewGroup b;
        final androidx.fragment.app.c.k c;
        f(androidx.fragment.app.c c, View view2, ViewGroup viewGroup3, androidx.fragment.app.c.k c$k4) {
            this.a = view2;
            this.b = viewGroup3;
            this.c = k4;
            super();
        }

        @Override // androidx.core.os.b$a
        public void a() {
            this.a.clearAnimation();
            this.b.endViewTransition(this.a);
            this.c.a();
        }
    }

    private static class k extends androidx.fragment.app.c.l {

        private boolean c;
        private boolean d = false;
        private androidx.fragment.app.f.d e;
        k(androidx.fragment.app.c0.e c0$e, b b2, boolean z3) {
            super(e, b2);
            final int obj1 = 0;
            this.c = z3;
        }

        @Override // androidx.fragment.app.c$l
        androidx.fragment.app.f.d e(Context context) {
            int i;
            if (this.d) {
                return this.e;
            }
            final int i2 = 1;
            i = b().e() == c0.e.c.VISIBLE ? i2 : 0;
            androidx.fragment.app.f.d obj5 = f.c(context, b().f(), i, this.c);
            this.e = obj5;
            this.d = i2;
            return obj5;
        }
    }

    private static class m extends androidx.fragment.app.c.l {

        private final Object c;
        private final boolean d = true;
        private final Object e = null;
        m(androidx.fragment.app.c0.e c0$e, b b2, boolean z3, boolean z4) {
            Object obj2;
            Object obj3;
            super(e, b2);
            if (e.e() == c0.e.c.VISIBLE) {
                if (z3) {
                    obj3 = e.f().getReenterTransition();
                } else {
                    obj3 = e.f().getEnterTransition();
                }
                this.c = obj3;
                if (z3) {
                    obj3 = e.f().getAllowReturnTransitionOverlap();
                } else {
                    obj3 = e.f().getAllowEnterTransitionOverlap();
                }
                this.d = obj3;
            } else {
                if (z3) {
                    obj3 = e.f().getReturnTransition();
                } else {
                    obj3 = e.f().getExitTransition();
                }
                this.c = obj3;
                obj3 = 1;
            }
            if (z4) {
                if (z3) {
                    this.e = e.f().getSharedElementReturnTransition();
                } else {
                    this.e = e.f().getSharedElementEnterTransition();
                }
            } else {
                obj2 = 0;
            }
        }

        private androidx.fragment.app.z f(Object object) {
            boolean z;
            if (object == null) {
                return null;
            }
            androidx.fragment.app.z zVar = x.b;
            if (zVar != null && zVar.e(object)) {
                if (zVar.e(object)) {
                    return zVar;
                }
            }
            androidx.fragment.app.z zVar2 = x.c;
            if (zVar2 == null) {
            } else {
                if (!zVar2.e(object)) {
                } else {
                    return zVar2;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Transition ");
            stringBuilder.append(object);
            stringBuilder.append(" for fragment ");
            stringBuilder.append(b().f());
            stringBuilder.append(" is not a valid framework Transition or AndroidX Transition");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        @Override // androidx.fragment.app.c$l
        androidx.fragment.app.z e() {
            androidx.fragment.app.z zVar;
            zVar = f(this.c);
            androidx.fragment.app.z zVar2 = f(this.e);
            if (zVar != null && zVar2 != null) {
                if (zVar2 != null) {
                    if (zVar != zVar2) {
                    } else {
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    stringBuilder.append(b().f());
                    stringBuilder.append(" returned Transition ");
                    stringBuilder.append(this.c);
                    stringBuilder.append(" which uses a different Transition  type than its shared element transition ");
                    stringBuilder.append(this.e);
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                    throw illegalArgumentException;
                }
            }
            if (zVar != null) {
            } else {
                zVar = zVar2;
            }
            return zVar;
        }

        @Override // androidx.fragment.app.c$l
        public Object g() {
            return this.e;
        }

        @Override // androidx.fragment.app.c$l
        Object h() {
            return this.c;
        }

        @Override // androidx.fragment.app.c$l
        public boolean i() {
            int i;
            i = this.e != null ? 1 : 0;
            return i;
        }

        @Override // androidx.fragment.app.c$l
        boolean j() {
            return this.d;
        }
    }
    c(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List<androidx.fragment.app.c.k> list, List<androidx.fragment.app.c0.e> list2, boolean z3, Map<androidx.fragment.app.c0.e, Boolean> map4) {
        int i;
        androidx.fragment.app.Fragment dVar;
        Object str;
        boolean stringBuilder;
        boolean equals;
        androidx.fragment.app.c0.e string;
        Object eVar2;
        Object mView;
        ArrayList arrayList;
        Object eVar;
        Iterator rEMOVED;
        Object obj2;
        androidx.fragment.app.c.c cVar;
        Object obj;
        Animator animator;
        View view;
        final androidx.fragment.app.c cVar6 = this;
        final ViewGroup view3 = m();
        final Context context = view3.getContext();
        arrayList = new ArrayList();
        rEMOVED = list.iterator();
        i = 0;
        str = "FragmentManager";
        stringBuilder = 2;
        while (rEMOVED.hasNext()) {
            obj = next2;
            if ((c.k)obj.d()) {
            } else {
            }
            dVar = obj.e(context);
            if (!dVar) {
            } else {
            }
            animator = dVar.b;
            if (animator == null) {
            } else {
            }
            string = obj.b();
            dVar = string.f();
            if (Boolean.TRUE.equals(map4.get(string))) {
            } else {
            }
            if (string.e() == c0.e.c.GONE) {
            } else {
            }
            equals = 0;
            if (equals != 0) {
            }
            stringBuilder = dVar.mView;
            view3.startViewTransition(stringBuilder);
            super(this, view3, stringBuilder, equals, string, obj);
            animator.addListener(cVar5);
            animator.setTarget(stringBuilder);
            animator.start();
            dVar = new c.d(cVar6, animator);
            obj.c().c(dVar);
            i = 1;
            str = "FragmentManager";
            stringBuilder = 2;
            list2.remove(string);
            equals = 1;
            if (n.I0(stringBuilder)) {
            }
            obj.a();
            stringBuilder = new StringBuilder();
            stringBuilder.append("Ignoring Animator set on ");
            stringBuilder.append(dVar);
            stringBuilder.append(" as this Fragment was involved in a Transition.");
            Log.v(str, stringBuilder.toString());
            arrayList.add(obj);
            mView = map4;
            obj.a();
            obj.a();
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            equals = iterator.next();
            androidx.fragment.app.c0.e eVar3 = (c.k)equals.b();
            mView = eVar3.f();
            arrayList = "Ignoring Animation set on ";
            if (z3) {
            } else {
            }
            if (i != 0) {
            } else {
            }
            mView = mView.mView;
            androidx.fragment.app.f.d dVar2 = equals.e(context);
            i.c(dVar2);
            eVar = dVar2.a;
            i.c(eVar);
            if (eVar3.e() != c0.e.c.REMOVED) {
            } else {
            }
            view3.startViewTransition(mView);
            eVar2 = new f.e((Animation)eVar, view3, mView);
            eVar = new c.e(cVar6, view3, mView, equals);
            eVar2.setAnimationListener(eVar);
            mView.startAnimation(eVar2);
            arrayList = new c.f(cVar6, mView, view3, equals);
            equals.c().c(arrayList);
            mView.startAnimation(eVar);
            equals.a();
            if (n.I0(stringBuilder)) {
            }
            equals.a();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(arrayList);
            stringBuilder3.append(mView);
            stringBuilder3.append(" as Animations cannot run alongside Animators.");
            Log.v(str, stringBuilder3.toString());
            if (n.I0(stringBuilder)) {
            }
            equals.a();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(arrayList);
            stringBuilder2.append(mView);
            stringBuilder2.append(" as Animations cannot run alongside Transitions.");
            Log.v(str, stringBuilder2.toString());
        }
    }

    private Map<androidx.fragment.app.c0.e, Boolean> x(List<androidx.fragment.app.c.m> list, List<androidx.fragment.app.c0.e> list2, boolean z3, androidx.fragment.app.c0.e c0$e4, androidx.fragment.app.c0.e c0$e5) {
        int i;
        ArrayList sharedElementSourceNames;
        int values;
        boolean empty2;
        View view;
        boolean empty;
        Object next2;
        boolean next;
        int i17;
        p enterTransitionCallback;
        ArrayList list7;
        androidx.fragment.app.c0.e eVar;
        androidx.fragment.app.z zVar;
        int indexOf;
        p exitTransitionCallback;
        Boolean fALSE2;
        int size;
        int mView;
        Object eVar3;
        a aVar2;
        boolean hVar;
        ArrayList list5;
        ArrayList list6;
        ArrayList arrayList2;
        androidx.fragment.app.c cVar;
        androidx.fragment.app.c cVar2;
        int i14;
        int i15;
        Object fALSE;
        int i18;
        boolean z;
        Iterator iterator;
        int i6;
        Object obj4;
        Rect rect2;
        Rect string;
        Object obj2;
        int i7;
        View view3;
        View view2;
        int str;
        HashMap hashMap;
        int i11;
        ArrayList sharedElementTargetNames;
        int i16;
        ArrayList arrayList;
        boolean jVar;
        Rect rect;
        int i3;
        int i8;
        androidx.fragment.app.c0.e eVar2;
        View view4;
        int i13;
        int i12;
        Object obj;
        Object vISIBLE;
        boolean z2;
        int i10;
        Object obj3;
        ArrayList list3;
        Iterator iterator2;
        int i9;
        ArrayList list9;
        HashMap map;
        int i2;
        int i5;
        int i4;
        a aVar;
        ArrayList list8;
        androidx.fragment.app.c0.e eVar4;
        ArrayList list10;
        ArrayList list4;
        boolean obj34;
        cVar2 = this;
        z = z3;
        obj4 = e4;
        obj2 = e5;
        hashMap = new HashMap();
        Iterator iterator3 = list.iterator();
        i12 = 0;
        for (c.m next2 : iterator3) {
            zVar = next2.e();
            i12 = zVar;
        }
        if (i12 == 0) {
            Iterator iterator4 = list.iterator();
            for (c.m next : iterator4) {
                hashMap.put(next.b(), Boolean.FALSE);
                next.a();
            }
            return hashMap;
        }
        view4 = new View(m().getContext());
        rect = new Rect();
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        aVar2 = new a();
        iterator2 = list.iterator();
        i = 0;
        indexOf = 0;
        i9 = 0;
        while (iterator2.hasNext()) {
            Object next5 = iterator2.next();
            if ((c.m)next5.i() && obj4 != null && obj2 != null) {
            } else {
            }
            aVar = aVar2;
            next = arrayList2;
            cVar = cVar2;
            fALSE2 = obj4;
            list5 = arrayList;
            rect2 = rect;
            i11 = i12;
            i14 = 0;
            obj = obj2;
            view3 = view4;
            indexOf = i2;
            z = z3;
            arrayList = list5;
            cVar2 = cVar;
            rect = rect2;
            view4 = view3;
            obj2 = obj;
            aVar2 = aVar;
            arrayList2 = next;
            obj4 = fALSE2;
            i12 = i11;
            if (obj4 != null) {
            } else {
            }
            if (obj2 != null) {
            } else {
            }
            sharedElementSourceNames = e5.f().getSharedElementSourceNames();
            sharedElementTargetNames = e4.f().getSharedElementTargetNames();
            obj3 = indexOf;
            i17 = 0;
            while (i17 < sharedElementTargetNames.size()) {
                indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i17));
                if (indexOf != -1) {
                }
                i17++;
                sharedElementTargetNames = list3;
                sharedElementSourceNames.set(indexOf, e4.f().getSharedElementSourceNames().get(i17));
            }
            ArrayList sharedElementTargetNames2 = e5.f().getSharedElementTargetNames();
            if (!z) {
            } else {
            }
            enterTransitionCallback = e4.f().getEnterTransitionCallback();
            exitTransitionCallback = e5.f().getExitTransitionCallback();
            size = sharedElementSourceNames.size();
            i7 = 0;
            while (i7 < size) {
                aVar2.put((String)sharedElementSourceNames.get(i7), (String)sharedElementTargetNames2.get(i7));
                i7++;
                obj4 = e4;
                size = map;
            }
            a aVar4 = new a();
            cVar2.u(aVar4, fragment10.mView);
            aVar4.p(sharedElementSourceNames);
            if (enterTransitionCallback != null) {
            } else {
            }
            list3 = sharedElementSourceNames;
            aVar2.p(aVar4.keySet());
            a aVar5 = new a();
            cVar2.u(aVar5, fragment2.mView);
            aVar5.p(sharedElementTargetNames2);
            aVar5.p(aVar2.values());
            if (exitTransitionCallback != null) {
            } else {
            }
            x.y(aVar2, aVar5);
            cVar2.v(aVar4, aVar2.keySet());
            cVar2.v(aVar5, aVar2.values());
            if (aVar2.isEmpty()) {
            } else {
            }
            int i20 = 1;
            x.f(e5.f(), e4.f(), z, aVar4, i20);
            list9 = list3;
            z = z2;
            View view13 = view4;
            i14 = 0;
            aVar = aVar2;
            super(this, e5, e4, z3, aVar5);
            r.a(m(), gVar2);
            arrayList.addAll(aVar4.values());
            if (!list9.isEmpty()) {
            } else {
            }
            indexOf = i2;
            next = list8;
            next.addAll(aVar5.values());
            empty = aVar5.get((String)sharedElementTargetNames2.get(i14));
            if (!sharedElementTargetNames2.isEmpty() && (View)empty != null) {
            } else {
            }
            cVar = this;
            view = view13;
            i12.z(z, view, arrayList);
            list5 = arrayList;
            rect2 = rect;
            view3 = view;
            i11 = i12;
            i12.t(z, 0, 0, 0, 0, z, next);
            Boolean tRUE = Boolean.TRUE;
            hashMap = map;
            hashMap.put(e4, tRUE);
            hashMap.put(e5, tRUE);
            i = z;
            empty = aVar5.get((String)sharedElementTargetNames2.get(i14));
            if ((View)(View)empty != null) {
            } else {
            }
            hVar = new c.h(this, i12, (View)(View)empty, rect);
            r.a(m(), hVar);
            view = view13;
            i9 = i4;
            empty2 = aVar4.get((String)list9.get(i14));
            i12.v(z, (View)empty2);
            indexOf = empty2;
            arrayList.clear();
            arrayList2.clear();
            fALSE2 = e4;
            aVar = aVar2;
            next = arrayList2;
            cVar = cVar2;
            list5 = arrayList;
            rect2 = rect;
            view3 = view4;
            i11 = i12;
            indexOf = obj3;
            i = 0;
            i14 = 0;
            obj = e5;
            exitTransitionCallback.c(sharedElementTargetNames2, aVar5);
            size2 -= enterTransitionCallback;
            while (values >= 0) {
                enterTransitionCallback = sharedElementTargetNames2.get(values);
                exitTransitionCallback = aVar5.get((String)enterTransitionCallback);
                if ((View)exitTransitionCallback == null) {
                } else {
                }
                enterTransitionCallback = x.q(aVar2, enterTransitionCallback);
                if (!enterTransitionCallback.equals(u.J((View)exitTransitionCallback)) && enterTransitionCallback != null) {
                }
                values--;
                enterTransitionCallback = x.q(aVar2, enterTransitionCallback);
                if (enterTransitionCallback != null) {
                }
                aVar2.put(enterTransitionCallback, u.J(exitTransitionCallback));
                enterTransitionCallback = x.q(aVar2, enterTransitionCallback);
                if (enterTransitionCallback != null) {
                }
                aVar2.remove(enterTransitionCallback);
            }
            enterTransitionCallback = sharedElementTargetNames2.get(values);
            exitTransitionCallback = aVar5.get((String)enterTransitionCallback);
            if ((View)exitTransitionCallback == null) {
            } else {
            }
            enterTransitionCallback = x.q(aVar2, enterTransitionCallback);
            if (!enterTransitionCallback.equals(u.J((View)exitTransitionCallback)) && enterTransitionCallback != null) {
            }
            values--;
            enterTransitionCallback = x.q(aVar2, enterTransitionCallback);
            if (enterTransitionCallback != null) {
            }
            aVar2.put(enterTransitionCallback, u.J(exitTransitionCallback));
            enterTransitionCallback = x.q(aVar2, enterTransitionCallback);
            if (enterTransitionCallback != null) {
            }
            aVar2.remove(enterTransitionCallback);
            enterTransitionCallback.c(sharedElementSourceNames, aVar4);
            size3 -= mView;
            while (enterTransitionCallback >= 0) {
                mView = sharedElementSourceNames.get(enterTransitionCallback);
                i7 = aVar4.get((String)mView);
                if ((View)i7 == 0) {
                } else {
                }
                list3 = sharedElementSourceNames;
                if (!mView.equals(u.J((View)i7))) {
                }
                enterTransitionCallback--;
                sharedElementSourceNames = list3;
                aVar2.put(u.J(i7), (String)aVar2.remove(mView));
                aVar2.remove(mView);
                list3 = sharedElementSourceNames;
            }
            list3 = sharedElementSourceNames;
            mView = sharedElementSourceNames.get(enterTransitionCallback);
            i7 = aVar4.get((String)mView);
            if ((View)i7 == 0) {
            } else {
            }
            list3 = sharedElementSourceNames;
            if (!mView.equals(u.J((View)i7))) {
            }
            enterTransitionCallback--;
            sharedElementSourceNames = list3;
            aVar2.put(u.J(i7), (String)aVar2.remove(mView));
            aVar2.remove(mView);
            list3 = sharedElementSourceNames;
            aVar2.put((String)sharedElementSourceNames.get(i7), (String)sharedElementTargetNames2.get(i7));
            i7++;
            obj4 = e4;
            size = map;
            enterTransitionCallback = e4.f().getExitTransitionCallback();
            exitTransitionCallback = e5.f().getEnterTransitionCallback();
            indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i17));
            if (indexOf != -1) {
            }
            i17++;
            sharedElementTargetNames = list3;
            sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i17));
        }
        i5 = indexOf;
        list7 = arrayList2;
        androidx.fragment.app.c cVar4 = cVar2;
        androidx.fragment.app.c0.e eVar7 = obj4;
        list6 = arrayList;
        int i25 = i12;
        i15 = 0;
        int i31 = 1;
        vISIBLE = obj2;
        view2 = view4;
        ArrayList arrayList3 = new ArrayList();
        iterator = list.iterator();
        i3 = 0;
        i13 = 0;
        while (iterator.hasNext()) {
            iterator2 = next7;
            if ((c.m)iterator2.d()) {
            } else {
            }
            fALSE = i25.g(iterator2.h());
            androidx.fragment.app.c0.e eVar10 = iterator2.b();
            if (i != 0) {
            } else {
            }
            z2 = 0;
            if (fALSE == null) {
            } else {
            }
            obj34 = iterator;
            ArrayList arrayList4 = new ArrayList();
            i10 = i3;
            cVar4.t(arrayList4, fragment12.mView);
            if (z2 != 0) {
            }
            if (arrayList4.isEmpty()) {
            } else {
            }
            i25.b(fALSE, arrayList4);
            list8 = view2;
            eVar4 = eVar11;
            view2 = i10;
            list10 = list6;
            list6 = i13;
            list4 = list7;
            eVar = vISIBLE;
            i25.t(fALSE, fALSE, arrayList4, 0, 0, 0, 0);
            if (eVar4.e() == c0.e.c.GONE) {
            } else {
            }
            arrayList = list2;
            eVar2 = eVar4;
            if (eVar2.e() == c0.e.c.VISIBLE) {
            } else {
            }
            i25.v(fALSE, i5);
            hashMap.put(eVar2, Boolean.TRUE);
            if (iterator2.j()) {
            } else {
            }
            i18 = i25.n(view2, fALSE, 0);
            i13 = list6;
            vISIBLE = eVar;
            i3 = i18;
            i5 = i6;
            view2 = list8;
            list6 = list10;
            list7 = list4;
            i15 = 0;
            iterator = obj34;
            i13 = list6;
            i18 = view2;
            arrayList3.addAll(arrayList4);
            if (i9 != 0) {
            }
            i6 = i5;
            i25.u(fALSE, rect);
            eVar2 = eVar4;
            list2.remove(eVar2);
            ArrayList arrayList5 = new ArrayList(arrayList4);
            arrayList5.remove(fragment13.mView);
            i25.r(fALSE, fragment14.mView, arrayList5);
            vISIBLE = new c.i(cVar4, arrayList4);
            r.a(m(), vISIBLE);
            i25.a(fALSE, view2);
            list4 = list7;
            list10 = list6;
            list8 = view2;
            eVar2 = eVar10;
            list6 = i13;
            eVar = vISIBLE;
            view2 = i10;
            arrayList = list2;
            if (eVar10 == eVar7) {
            } else {
            }
            arrayList4.removeAll(list7);
            arrayList4.removeAll(list6);
            if (z2 == 0) {
            }
            arrayList = list2;
            list4 = list7;
            list10 = list6;
            obj34 = iterator;
            list8 = view2;
            i18 = i3;
            eVar = vISIBLE;
            i6 = i5;
            i8 = 0;
            hashMap.put(eVar10, Boolean.FALSE);
            iterator2.a();
            if (eVar10 != eVar7) {
            } else {
            }
            z2 = i31;
            if (eVar10 == vISIBLE) {
            } else {
            }
            hashMap.put(iterator2.b(), Boolean.FALSE);
            iterator2.a();
            i15 = 0;
        }
        ArrayList list17 = list6;
        Object obj13 = i25.m(i13, i3, i);
        Iterator iterator5 = list.iterator();
        while (iterator5.hasNext()) {
            iterator = iterator5.next();
            if ((c.m)iterator.d() != null) {
            } else {
            }
            str = iterator.b();
            if (i != 0) {
            } else {
            }
            jVar = 0;
            if (iterator.h() == null) {
            } else {
            }
            if (!u.R(m())) {
            } else {
            }
            jVar = new c.j(cVar4, iterator);
            i25.w(iterator.b().f(), obj13, iterator.c(), jVar);
            if (n.I0(2)) {
            }
            iterator.a();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("SpecialEffectsController: Container ");
            stringBuilder2.append(m());
            stringBuilder2.append(" has not been laid out. Completing operation ");
            stringBuilder2.append(str);
            Log.v("FragmentManager", stringBuilder2.toString());
            if (jVar) {
            }
            if (str != eVar7) {
            } else {
            }
            jVar = i31;
            if (str == vISIBLE) {
            } else {
            }
        }
        if (!u.R(m())) {
            return hashMap;
        }
        x.B(arrayList3, 4);
        ArrayList list12 = list18;
        i25.c(m(), obj13);
        i25.y(m(), list17, list12, i25.o(list12), aVar2);
        x.B(arrayList3, 0);
        i25.A(i, list17, list12);
        return hashMap;
    }

    void f(List<androidx.fragment.app.c0.e> list, boolean z2) {
        int next;
        int vISIBLE;
        int i2;
        androidx.fragment.app.c0.e.c from;
        int next2;
        int bVar;
        int i3;
        int i;
        androidx.fragment.app.c.m mVar;
        int i4;
        boolean obj12;
        Iterator iterator = list.iterator();
        i = i3;
        i2 = 1;
        while (iterator.hasNext()) {
            next = iterator.next();
            from = c0.e.c.from(fragment.mView);
            next2 = c.a.a[next.e().ordinal()];
            if (next2 != i2 && next2 != 2 && next2 != 3) {
            } else {
            }
            if (from == c0.e.c.VISIBLE && i3 == 0) {
            }
            i2 = 1;
            if (i3 == 0) {
            }
            i3 = next;
            if (next2 != 2) {
            } else {
            }
            if (next2 != 3) {
            } else {
            }
            if (next2 != 4) {
            } else {
            }
            if (from != c0.e.c.VISIBLE) {
            }
            i = next;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        Iterator obj11 = list.iterator();
        while (obj11.hasNext()) {
            next2 = obj11.next();
            b bVar2 = new b();
            (c0.e)next2.j(bVar2);
            c.k kVar = new c.k(next2, bVar2, z2);
            arrayList.add(kVar);
            b bVar3 = new b();
            next2.j(bVar3);
            i4 = 0;
            if (z2) {
            } else {
            }
            if (next2 == i) {
            }
            mVar = new c.m(next2, bVar3, z2, i4);
            arrayList3.add(mVar);
            bVar = new c.b(this, arrayList2, next2);
            next2.a(bVar);
            i4 = i2;
            if (next2 == i3) {
            }
        }
        obj11 = this.x(arrayList3, arrayList2, z2, i3, i);
        w(arrayList, arrayList2, obj11.containsValue(Boolean.TRUE), obj11);
        obj11 = arrayList2.iterator();
        for (c0.e obj12 : obj11) {
            s(obj12);
        }
        arrayList2.clear();
    }

    @Override // androidx.fragment.app.c0
    void s(androidx.fragment.app.c0.e c0$e) {
        e.e().applyState(fragment.mView);
    }

    void t(ArrayList<View> arrayList, View view2) {
        boolean contains;
        boolean z;
        View childAt;
        int visibility;
        Object obj6;
        if (view2 instanceof ViewGroup) {
            contains = view2;
            if (w.a((ViewGroup)contains)) {
                if (!arrayList.contains(view2)) {
                    arrayList.add(contains);
                }
            } else {
                z = 0;
                while (z < contains.getChildCount()) {
                    childAt = contains.getChildAt(z);
                    if (childAt.getVisibility() == 0) {
                    }
                    z++;
                    t(arrayList, childAt);
                }
            }
        } else {
            if (!arrayList.contains(view2)) {
                arrayList.add(view2);
            }
        }
    }

    void u(Map<String, View> map, View view2) {
        boolean childCount;
        int i;
        View childAt;
        int visibility;
        String str = u.J(view2);
        if (str != null) {
            map.put(str, view2);
        }
        if (view2 instanceof ViewGroup) {
            i = 0;
            while (i < (ViewGroup)view2.getChildCount()) {
                childAt = view2.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                }
                i++;
                u(map, childAt);
            }
        }
    }

    void v(a<String, View> a, Collection<String> collection2) {
        boolean contains;
        Iterator obj2 = a.entrySet().iterator();
        while (obj2.hasNext()) {
            if (!collection2.contains(u.J((View)(Map.Entry)obj2.next().getValue()))) {
            }
            obj2.remove();
        }
    }
}
