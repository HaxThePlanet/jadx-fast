package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.d;
import androidx.activity.f;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.a;
import androidx.activity.result.b;
import androidx.activity.result.c;
import androidx.activity.result.d;
import androidx.activity.result.e;
import androidx.activity.result.e.b;
import androidx.activity.result.f.a;
import androidx.activity.result.f.b;
import androidx.activity.result.f.c;
import androidx.core.os.b;
import androidx.lifecycle.i0;
import androidx.lifecycle.j.c;
import androidx.lifecycle.j0;
import androidx.lifecycle.x;
import d.e.b;
import d.m.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class n {

    private static boolean O = false;
    static boolean P = true;
    private c<e> A;
    private c<String[]> B;
    ArrayDeque<androidx.fragment.app.n.n> C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private ArrayList<androidx.fragment.app.a> I;
    private ArrayList<Boolean> J;
    private ArrayList<androidx.fragment.app.Fragment> K;
    private ArrayList<androidx.fragment.app.n.r> L;
    private androidx.fragment.app.q M;
    private Runnable N;
    private final ArrayList<androidx.fragment.app.n.p> a;
    private boolean b;
    private final androidx.fragment.app.v c;
    ArrayList<androidx.fragment.app.a> d;
    private ArrayList<androidx.fragment.app.Fragment> e;
    private final androidx.fragment.app.l f;
    private OnBackPressedDispatcher g;
    private final d h;
    private final AtomicInteger i;
    private final Map<String, Bundle> j;
    private final Map<String, Object> k;
    private ArrayList<androidx.fragment.app.n.o> l;
    private Map<androidx.fragment.app.Fragment, HashSet<b>> m;
    private final androidx.fragment.app.x.g n;
    private final androidx.fragment.app.m o;
    private final CopyOnWriteArrayList<androidx.fragment.app.r> p;
    int q = -1;
    private androidx.fragment.app.k<?> r;
    private androidx.fragment.app.g s;
    private androidx.fragment.app.Fragment t;
    androidx.fragment.app.Fragment u;
    private androidx.fragment.app.j v = null;
    private androidx.fragment.app.j w;
    private androidx.fragment.app.d0 x = null;
    private androidx.fragment.app.d0 y;
    private c<Intent> z;

    class g implements Runnable {

        final androidx.fragment.app.n a;
        g(androidx.fragment.app.n n) {
            this.a = n;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.c0(true);
        }
    }

    class h extends AnimatorListenerAdapter {

        final ViewGroup a;
        final View b;
        final androidx.fragment.app.Fragment c;
        h(androidx.fragment.app.n n, ViewGroup viewGroup2, View view3, androidx.fragment.app.Fragment fragment4) {
            this.a = viewGroup2;
            this.b = view3;
            this.c = fragment4;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            androidx.fragment.app.Fragment obj3;
            this.a.endViewTransition(this.b);
            animator.removeListener(this);
            obj3 = this.c;
            View mView = obj3.mView;
            if (mView != null && obj3.mHidden) {
                if (obj3.mHidden) {
                    mView.setVisibility(8);
                }
            }
        }
    }

    public interface k {
        public abstract String getName();
    }

    public static abstract class m {
        @Deprecated
        public abstract void a(androidx.fragment.app.n n, androidx.fragment.app.Fragment fragment2, Bundle bundle3);

        public abstract void b(androidx.fragment.app.n n, androidx.fragment.app.Fragment fragment2, Context context3);

        public abstract void c(androidx.fragment.app.n n, androidx.fragment.app.Fragment fragment2, Bundle bundle3);

        public abstract void d(androidx.fragment.app.n n, androidx.fragment.app.Fragment fragment2);

        public abstract void e(androidx.fragment.app.n n, androidx.fragment.app.Fragment fragment2);

        public abstract void f(androidx.fragment.app.n n, androidx.fragment.app.Fragment fragment2);

        public abstract void g(androidx.fragment.app.n n, androidx.fragment.app.Fragment fragment2, Context context3);

        public abstract void h(androidx.fragment.app.n n, androidx.fragment.app.Fragment fragment2, Bundle bundle3);

        public abstract void i(androidx.fragment.app.n n, androidx.fragment.app.Fragment fragment2);

        public abstract void j(androidx.fragment.app.n n, androidx.fragment.app.Fragment fragment2, Bundle bundle3);

        public abstract void k(androidx.fragment.app.n n, androidx.fragment.app.Fragment fragment2);

        public abstract void l(androidx.fragment.app.n n, androidx.fragment.app.Fragment fragment2);

        public abstract void m(androidx.fragment.app.n n, androidx.fragment.app.Fragment fragment2, View view3, Bundle bundle4);

        public abstract void n(androidx.fragment.app.n n, androidx.fragment.app.Fragment fragment2);
    }

    static class n implements Parcelable {

        public static final Parcelable.Creator<androidx.fragment.app.n.n> CREATOR;
        String a;
        int b;
        static {
            n.n.a aVar = new n.n.a();
            n.n.CREATOR = aVar;
        }

        n(Parcel parcel) {
            super();
            this.a = parcel.readString();
            this.b = parcel.readInt();
        }

        n(String string, int i2) {
            super();
            this.a = string;
            this.b = i2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.a);
            parcel.writeInt(this.b);
        }
    }

    public interface o {
        public abstract void onBackStackChanged();
    }

    interface p {
        public abstract boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    class a implements b<a> {

        final androidx.fragment.app.n a;
        a(androidx.fragment.app.n n) {
            this.a = n;
            super();
        }

        @Override // androidx.activity.result.b
        public void a(Object object) {
            b((a)object);
        }

        @Override // androidx.activity.result.b
        public void b(a a) {
            Object pollFirst = nVar.C.pollFirst();
            String str3 = "FragmentManager";
            if ((n.n)pollFirst == null) {
                StringBuilder obj5 = new StringBuilder();
                obj5.append("No IntentSenders were started for ");
                obj5.append(this);
                Log.w(str3, obj5.toString());
            }
            final String str4 = pollFirst.a;
            androidx.fragment.app.Fragment fragment = n.c(this.a).i(str4);
            if (fragment == null) {
                obj5 = new StringBuilder();
                obj5.append("Intent Sender result delivered for unknown Fragment ");
                obj5.append(str4);
                Log.w(str3, obj5.toString());
            }
            fragment.onActivityResult(pollFirst.b, a.b(), a.a());
        }
    }

    class b implements b<Map<String, Boolean>> {

        final androidx.fragment.app.n a;
        b(androidx.fragment.app.n n) {
            this.a = n;
            super();
        }

        @Override // androidx.activity.result.b
        public void a(Object object) {
            b((Map)object);
        }

        public void b(Map<String, Boolean> map) {
            int i2;
            int i;
            int i3 = 0;
            ArrayList arrayList = new ArrayList(map.values());
            int[] obj6 = new int[arrayList.size()];
            i2 = i3;
            while (i2 < arrayList.size()) {
                if ((Boolean)arrayList.get(i2).booleanValue()) {
                } else {
                }
                i = -1;
                obj6[i2] = i;
                i2++;
                i = i3;
            }
            Object pollFirst = nVar.C.pollFirst();
            String str3 = "FragmentManager";
            if ((n.n)pollFirst == null) {
                obj6 = new StringBuilder();
                obj6.append("No permissions were requested for ");
                obj6.append(this);
                Log.w(str3, obj6.toString());
            }
            String str4 = pollFirst.a;
            androidx.fragment.app.Fragment fragment = n.c(this.a).i(str4);
            if (fragment == null) {
                obj6 = new StringBuilder();
                obj6.append("Permission request result delivered for unknown Fragment ");
                obj6.append(str4);
                Log.w(str3, obj6.toString());
            }
            fragment.onRequestPermissionsResult(pollFirst.b, (String[])map.keySet().toArray(new String[i3]), obj6);
        }
    }

    class c extends d {

        final androidx.fragment.app.n c;
        c(androidx.fragment.app.n n, boolean z2) {
            this.c = n;
            super(z2);
        }

        @Override // androidx.activity.d
        public void b() {
            this.c.E0();
        }
    }

    class d implements androidx.fragment.app.x.g {

        final androidx.fragment.app.n a;
        d(androidx.fragment.app.n n) {
            this.a = n;
            super();
        }

        @Override // androidx.fragment.app.x$g
        public void a(androidx.fragment.app.Fragment fragment, b b2) {
            boolean z;
            if (!b2.b()) {
                this.a.g1(fragment, b2);
            }
        }

        @Override // androidx.fragment.app.x$g
        public void b(androidx.fragment.app.Fragment fragment, b b2) {
            this.a.f(fragment, b2);
        }
    }

    class e extends androidx.fragment.app.j {

        final androidx.fragment.app.n b;
        e(androidx.fragment.app.n n) {
            this.b = n;
            super();
        }

        @Override // androidx.fragment.app.j
        public androidx.fragment.app.Fragment a(java.lang.ClassLoader classLoader, String string2) {
            return this.b.w0().b(this.b.w0().f(), string2, 0);
        }
    }

    class f implements androidx.fragment.app.d0 {
        f(androidx.fragment.app.n n) {
            super();
        }

        @Override // androidx.fragment.app.d0
        public androidx.fragment.app.c0 a(ViewGroup viewGroup) {
            c cVar = new c(viewGroup);
            return cVar;
        }
    }

    class i implements androidx.fragment.app.r {

        final androidx.fragment.app.Fragment a;
        i(androidx.fragment.app.n n, androidx.fragment.app.Fragment fragment2) {
            this.a = fragment2;
            super();
        }

        @Override // androidx.fragment.app.r
        public void a(androidx.fragment.app.n n, androidx.fragment.app.Fragment fragment2) {
            this.a.onAttachFragment(fragment2);
        }
    }

    class j implements b<a> {

        final androidx.fragment.app.n a;
        j(androidx.fragment.app.n n) {
            this.a = n;
            super();
        }

        @Override // androidx.activity.result.b
        public void a(Object object) {
            b((a)object);
        }

        @Override // androidx.activity.result.b
        public void b(a a) {
            Object pollFirst = nVar.C.pollFirst();
            String str3 = "FragmentManager";
            if ((n.n)pollFirst == null) {
                StringBuilder obj5 = new StringBuilder();
                obj5.append("No Activities were started for result for ");
                obj5.append(this);
                Log.w(str3, obj5.toString());
            }
            final String str4 = pollFirst.a;
            androidx.fragment.app.Fragment fragment = n.c(this.a).i(str4);
            if (fragment == null) {
                obj5 = new StringBuilder();
                obj5.append("Activity result delivered for unknown Fragment ");
                obj5.append(str4);
                Log.w(str3, obj5.toString());
            }
            fragment.onActivityResult(pollFirst.b, a.b(), a.a());
        }
    }

    static class l extends a<e, a> {
        @Override // androidx.activity.result.f.a
        public Intent a(Context context, Object object2) {
            return d(context, (e)object2);
        }

        @Override // androidx.activity.result.f.a
        public Object c(int i, Intent intent2) {
            return e(i, intent2);
        }

        @Override // androidx.activity.result.f.a
        public Intent d(Context context, e e2) {
            Intent booleanExtra;
            String str;
            String str2;
            Object bundleExtra;
            e obj5;
            Intent obj4 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            booleanExtra = e2.a();
            str2 = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";
            bundleExtra = booleanExtra.getBundleExtra(str2);
            obj4.putExtra(str2, bundleExtra);
            booleanExtra.removeExtra(str2);
            if (booleanExtra != null && bundleExtra != null && booleanExtra.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                str2 = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";
                bundleExtra = booleanExtra.getBundleExtra(str2);
                if (bundleExtra != null) {
                    obj4.putExtra(str2, bundleExtra);
                    booleanExtra.removeExtra(str2);
                    if (booleanExtra.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        booleanExtra = new e.b(e2.d());
                        booleanExtra.b(0);
                        booleanExtra.c(e2.c(), e2.b());
                        obj5 = booleanExtra.a();
                    }
                }
            }
            obj4.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", obj5);
            if (n.I0(2)) {
                obj5 = new StringBuilder();
                obj5.append("CreateIntent created the following intent: ");
                obj5.append(obj4);
                Log.v("FragmentManager", obj5.toString());
            }
            return obj4;
        }

        @Override // androidx.activity.result.f.a
        public a e(int i, Intent intent2) {
            a aVar = new a(i, intent2);
            return aVar;
        }
    }

    private class q implements androidx.fragment.app.n.p {

        final String a;
        final int b;
        final int c;
        final androidx.fragment.app.n d;
        q(androidx.fragment.app.n n, String string2, int i3, int i4) {
            this.d = n;
            super();
            this.a = string2;
            this.b = i3;
            this.c = i4;
        }

        public boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
            androidx.fragment.app.Fragment fragment;
            int i;
            fragment = nVar.u;
            if (fragment != null && this.b < 0 && this.a == null && fragment.getChildFragmentManager().c1()) {
                if (this.b < 0) {
                    if (this.a == null) {
                        if (fragment.getChildFragmentManager().c1()) {
                            return 0;
                        }
                    }
                }
            }
            return this.d.e1(arrayList, arrayList2, this.a, this.b, this.c);
        }
    }

    static class r implements androidx.fragment.app.Fragment.k {

        final boolean a;
        final androidx.fragment.app.a b;
        private int c;
        r(androidx.fragment.app.a a, boolean z2) {
            super();
            this.a = z2;
            this.b = a;
        }

        @Override // androidx.fragment.app.Fragment$k
        public void a() {
            this.c = i++;
        }

        @Override // androidx.fragment.app.Fragment$k
        public void b() {
            i--;
            this.c = i2;
            if (i2 != 0) {
            }
            aVar.r.o1();
        }

        @Override // androidx.fragment.app.Fragment$k
        void c() {
            final androidx.fragment.app.a aVar = this.b;
            final int i = 0;
            aVar.r.v(aVar, this.a, i, i);
        }

        @Override // androidx.fragment.app.Fragment$k
        void d() {
            int i;
            Object next;
            int postponed;
            final int i4 = 1;
            i = this.c > 0 ? i4 : 0;
            Iterator iterator = aVar.r.v0().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                (Fragment)next.setOnStartEnterTransitionListener(0);
                if (i != 0 && next.isPostponed()) {
                }
                if (next.isPostponed()) {
                }
                next.startPostponedEnterTransition();
            }
            androidx.fragment.app.a aVar2 = this.b;
            aVar2.r.v(aVar2, this.a, i ^= i4, i4);
        }

        @Override // androidx.fragment.app.Fragment$k
        public boolean e() {
            int i;
            i = this.c == 0 ? 1 : 0;
            return i;
        }
    }
    static {
    }

    public n() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        v vVar = new v();
        this.c = vVar;
        l lVar = new l(this);
        this.f = lVar;
        n.c cVar = new n.c(this, 0);
        this.h = cVar;
        AtomicInteger atomicInteger = new AtomicInteger();
        this.i = atomicInteger;
        HashMap hashMap = new HashMap();
        this.j = Collections.synchronizedMap(hashMap);
        HashMap hashMap2 = new HashMap();
        this.k = Collections.synchronizedMap(hashMap2);
        HashMap hashMap3 = new HashMap();
        this.m = Collections.synchronizedMap(hashMap3);
        n.d dVar = new n.d(this);
        this.n = dVar;
        m mVar = new m(this);
        this.o = mVar;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.p = copyOnWriteArrayList;
        int i = -1;
        int i2 = 0;
        n.e eVar = new n.e(this);
        this.w = eVar;
        n.f fVar = new n.f(this);
        this.y = fVar;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.C = arrayDeque;
        n.g gVar = new n.g(this);
        this.N = gVar;
    }

    static androidx.fragment.app.Fragment C0(View view) {
        Object obj1 = view.getTag(b.a);
        if (obj1 instanceof Fragment != null) {
            return (Fragment)obj1;
        }
        return null;
    }

    static boolean I0(int i) {
        String str;
        int obj1;
        if (!n.O) {
            if (Log.isLoggable("FragmentManager", i)) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    private boolean J0(androidx.fragment.app.Fragment fragment) {
        boolean mMenuVisible;
        Object obj2;
        if (fragment.mHasMenu) {
            if (!fragment.mMenuVisible) {
                obj2 = fragment.mChildFragmentManager.p() ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    private void N(androidx.fragment.app.Fragment fragment) {
        boolean equals;
        if (fragment != null && fragment.equals(i0(fragment.mWho))) {
            if (fragment.equals(i0(fragment.mWho))) {
                fragment.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    private void R0(b<androidx.fragment.app.Fragment> b) {
        int i;
        Object obj;
        boolean requireView;
        float alpha;
        i = 0;
        while (i < b.size()) {
            obj = b.p(i);
            if (!obj.mAdded) {
            }
            i++;
            requireView = (Fragment)obj.requireView();
            obj.mPostponedAlpha = requireView.getAlpha();
            requireView.setAlpha(0);
        }
    }

    private void U(int i) {
        androidx.fragment.app.v next;
        boolean obj4;
        final int i2 = 1;
        final int i3 = 0;
        this.b = i2;
        this.c.d(i);
        T0(i, i3);
        if (n.P) {
            obj4 = t().iterator();
            try {
                for (c0 next : obj4) {
                    next.j();
                }
                (c0)obj4.next().j();
                this.b = i3;
                c0(i2);
                this.b = obj1;
                throw i;
            }
        }
    }

    private void X() {
        boolean z;
        if (this.H) {
            this.H = false;
            u1();
        }
    }

    private void Z() {
        Iterator iterator;
        boolean next;
        if (n.P) {
            iterator = t().iterator();
            for (c0 next : iterator) {
                next.j();
            }
        } else {
            if (!this.m.isEmpty()) {
                iterator = this.m.keySet().iterator();
                for (Fragment next : iterator) {
                    o(next);
                    U0(next);
                }
            }
        }
    }

    static Map a(androidx.fragment.app.n n) {
        return n.j;
    }

    static Map b(androidx.fragment.app.n n) {
        return n.k;
    }

    private void b0(boolean z) {
        ArrayList obj3;
        if (this.b) {
        } else {
            if (this.r == null && this.G) {
                if (this.G) {
                    obj3 = new IllegalStateException("FragmentManager has been destroyed");
                    throw obj3;
                }
                obj3 = new IllegalStateException("FragmentManager has not been attached to a host.");
                throw obj3;
            }
            if (Looper.myLooper() != this.r.g().getLooper()) {
            } else {
                if (!z) {
                    q();
                }
                if (this.I == null) {
                    obj3 = new ArrayList();
                    this.I = obj3;
                    obj3 = new ArrayList();
                    this.J = obj3;
                }
                this.b = true;
                int i = 0;
                h0(i, i);
                this.b = false;
            }
            obj3 = new IllegalStateException("Must be called from main thread of fragment host");
            throw obj3;
        }
        obj3 = new IllegalStateException("FragmentManager is already executing transactions");
        throw obj3;
    }

    static androidx.fragment.app.v c(androidx.fragment.app.n n) {
        return n.c;
    }

    private void d(b<androidx.fragment.app.Fragment> b) {
        Object next;
        int mIsNewlyAdded;
        int i = this.q;
        if (i < 1) {
        }
        int i2 = Math.min(i, 5);
        Iterator iterator = this.c.n().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            V0((Fragment)next, i2);
            if (next.mState < i2 && next.mView != null && !next.mHidden && next.mIsNewlyAdded) {
            }
            V0(next, i2);
            if (next.mView != null) {
            }
            if (!next.mHidden) {
            }
            if (next.mIsNewlyAdded) {
            }
            b.add(next);
        }
    }

    private boolean d1(String string, int i2, int i3) {
        androidx.fragment.app.Fragment fragment;
        int obj10;
        ArrayList obj11;
        c0(false);
        int i4 = 1;
        b0(i4);
        fragment = this.u;
        if (fragment != null && i2 < 0 && string == null && fragment.getChildFragmentManager().c1()) {
            if (i2 < 0) {
                if (string == null) {
                    if (fragment.getChildFragmentManager().c1()) {
                        return i4;
                    }
                }
            }
        }
        final boolean obj9 = this.e1(this.I, this.J, string, i2, i3);
        if (obj9 != null) {
            this.b = i4;
            i1(this.I, this.J);
            r();
        }
        v1();
        X();
        this.c.b();
        return obj9;
    }

    private static void e0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        boolean booleanValue;
        int i;
        while (i3 < i4) {
            final Object obj = arrayList.get(i3);
            if ((Boolean)arrayList2.get(i3).booleanValue()) {
            } else {
            }
            (a)obj.u(1);
            obj.y();
            i3++;
            obj.u(-1);
            if (i3 == i4 + -1) {
            } else {
            }
            i = 0;
            obj.z(i);
        }
    }

    private void f0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        ArrayList arrayList3;
        androidx.fragment.app.Fragment fragment;
        int list4;
        int i7;
        int i9;
        int iterator;
        int iterator2;
        int i2;
        boolean next2;
        int i8;
        int next;
        ArrayList list;
        int i5;
        int booleanValue;
        Object list3;
        int bVar;
        Object mFragmentManager;
        ArrayList list2;
        ArrayList list5;
        int i10;
        int i6;
        int i11;
        int i;
        int i12;
        final Object obj6 = this;
        final ArrayList list12 = arrayList;
        list3 = arrayList2;
        booleanValue = i3;
        i5 = i4;
        next2 = obj.p;
        arrayList3 = obj6.K;
        if (arrayList3 == null) {
            arrayList3 = new ArrayList();
            obj6.K = arrayList3;
        } else {
            arrayList3.clear();
        }
        obj6.K.addAll(obj6.c.n());
        fragment = A0();
        iterator = 0;
        i12 = iterator;
        bVar = booleanValue;
        i = 1;
        while (bVar < i5) {
            mFragmentManager = list12.get(bVar);
            if (!(Boolean)list3.get(bVar).booleanValue()) {
            } else {
            }
            fragment = (a)mFragmentManager.H(obj6.K, fragment);
            if (i12 == 0) {
            } else {
            }
            i12 = i;
            bVar++;
            i = 1;
            if (mFragmentManager.g) {
            } else {
            }
            i12 = iterator;
            fragment = mFragmentManager.A(obj6.K, fragment);
        }
        obj6.K.clear();
        if (!next2 && obj6.q >= i) {
            if (obj6.q >= i) {
                if (n.P) {
                    list4 = booleanValue;
                    while (list4 < i5) {
                        iterator = obj4.a.iterator();
                        while (iterator.hasNext() != 0) {
                            bVar = next3.b;
                            if (bVar != 0 && bVar.mFragmentManager != null) {
                            }
                            if (bVar.mFragmentManager != null) {
                            }
                            obj6.c.p(obj6.x(bVar));
                        }
                        list4++;
                        bVar = next3.b;
                        if (bVar != 0 && bVar.mFragmentManager != null) {
                        }
                        if (bVar.mFragmentManager != null) {
                        }
                        obj6.c.p(obj6.x(bVar));
                    }
                    iterator2 = i;
                } else {
                    iterator2 = i;
                    x.C(obj6.r.f(), obj6.s, arrayList, arrayList2, i3, i4, false, obj6.n);
                }
            } else {
            }
        } else {
        }
        n.e0(arrayList, arrayList2, i3, i4);
        if (n.P) {
            boolean booleanValue2 = (Boolean)list3.get(i5 + -1).booleanValue();
            i8 = booleanValue;
            while (i8 < i5) {
                bVar = list12.get(i8);
                if (booleanValue2) {
                } else {
                }
                bVar = bVar.a.iterator();
                while (bVar.hasNext()) {
                    mFragmentManager = next4.b;
                    if (mFragmentManager != null) {
                    }
                    obj6.x(mFragmentManager).m();
                }
                i8++;
                mFragmentManager = next4.b;
                if (mFragmentManager != null) {
                }
                obj6.x(mFragmentManager).m();
                size -= iterator2;
                while (mFragmentManager >= 0) {
                    list2 = obj8.b;
                    if (list2 != null) {
                    }
                    mFragmentManager--;
                    obj6.x(list2).m();
                }
                list2 = obj8.b;
                if (list2 != null) {
                }
                mFragmentManager--;
                obj6.x(list2).m();
            }
            obj6.T0(obj6.q, iterator2);
            iterator2 = obj6.u(list12, booleanValue, i5).iterator();
            for (c0 next : iterator2) {
                next.r(booleanValue2);
                next.p();
                next.g();
            }
            i7 = i5;
            list = list3;
        } else {
            if (next2) {
                bVar = new b();
                obj6.d(bVar);
                i = iterator2;
                mFragmentManager = next2;
                i11 = i5;
                i6 = booleanValue;
                i10 = list3;
                i9 = this.f1(arrayList, arrayList2, i3, i4, bVar);
                obj6.R0(bVar);
            } else {
                i = iterator2;
                mFragmentManager = next2;
                i6 = booleanValue;
                i10 = list3;
                i9 = i11;
            }
            if (i9 != i6 && mFragmentManager != null) {
                if (mFragmentManager != null) {
                    if (obj6.q >= i) {
                        list = i10;
                        i7 = i11;
                        iterator2 = i;
                        x.C(obj6.r.f(), obj6.s, arrayList, arrayList2, i3, i9, true, obj6.n);
                    } else {
                        list = i10;
                        i7 = i11;
                        iterator2 = i;
                    }
                    obj6.T0(obj6.q, iterator2);
                } else {
                    list = i10;
                    i7 = i11;
                }
            } else {
            }
        }
        i2 = i3;
        while (i2 < i7) {
            next2 = list12.get(i2);
            if ((Boolean)list.get(i2).booleanValue() && next2.t >= 0) {
            }
            (a)next2.F();
            i2++;
            if (next2.t >= 0) {
            }
            next2.t = -1;
        }
        if (i12 != 0) {
            k1();
        }
    }

    private int f1(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4, b<androidx.fragment.app.Fragment> b5) {
        int i;
        int i2;
        Object obj;
        boolean booleanValue;
        int rVar;
        ArrayList arrayList3;
        boolean z;
        int i5;
        ArrayList list;
        i = i4 + -1;
        i2 = i4;
        while (i >= i3) {
            obj = arrayList.get(i);
            booleanValue = (Boolean)arrayList2.get(i).booleanValue();
            i5 = 0;
            if ((a)obj.E() && !obj.C(arrayList, i + 1, i4)) {
            } else {
            }
            rVar = i5;
            if (rVar != 0 && this.L == null) {
            }
            i--;
            if (this.L == null) {
            }
            rVar = new n.r(obj, booleanValue);
            this.L.add(rVar);
            obj.G(rVar);
            if (booleanValue) {
            } else {
            }
            obj.z(i5);
            i2--;
            if (i != i2) {
            }
            d(b5);
            arrayList.remove(i);
            arrayList.add(i2, obj);
            obj.y();
            arrayList3 = new ArrayList();
            this.L = arrayList3;
            if (!obj.C(arrayList, i + 1, i4)) {
            } else {
            }
            rVar = 1;
        }
        return i2;
    }

    private void h0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        int size;
        int i;
        Object obj;
        int booleanValue;
        ArrayList booleanValue2;
        int size2;
        ArrayList list = this.L;
        final int i2 = 0;
        if (list == null) {
            size = i2;
        } else {
            size = list.size();
        }
        i = i2;
        while (i < size) {
            obj = this.L.get(i);
            booleanValue = -1;
            booleanValue2 = arrayList.indexOf(obj.b);
            if (arrayList != null && !obj.a && booleanValue2 != booleanValue && arrayList2 != null && (Boolean)arrayList2.get(booleanValue2).booleanValue()) {
            } else {
            }
            if (!(n.r)obj.e()) {
            } else {
            }
            this.L.remove(i);
            i--;
            size--;
            booleanValue2 = arrayList.indexOf(obj.b);
            if (arrayList != null && !obj.a && booleanValue2 != booleanValue && arrayList2 != null && (Boolean)arrayList2.get(booleanValue2).booleanValue()) {
            } else {
            }
            obj.d();
            i++;
            if (!obj.a) {
            } else {
            }
            booleanValue2 = arrayList.indexOf(obj.b);
            if (booleanValue2 != booleanValue) {
            } else {
            }
            if (arrayList2 != null) {
            } else {
            }
            if ((Boolean)arrayList2.get(booleanValue2).booleanValue()) {
            } else {
            }
            obj.c();
            if (arrayList != null && obj.b.C(arrayList, i2, arrayList.size())) {
            }
            if (obj.b.C(arrayList, i2, arrayList.size())) {
            }
            if (!obj.a) {
            } else {
            }
            booleanValue2 = arrayList.indexOf(obj.b);
            if (booleanValue2 != booleanValue) {
            } else {
            }
            if (arrayList2 != null) {
            } else {
            }
            if ((Boolean)arrayList2.get(booleanValue2).booleanValue()) {
            } else {
            }
            this.L.remove(i);
            i--;
            size--;
            obj.c();
        }
    }

    private void i1(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        int i2;
        int i;
        boolean booleanValue;
        if (arrayList.isEmpty()) {
        }
        if (arrayList.size() != arrayList2.size()) {
        } else {
            h0(arrayList, arrayList2);
            int size2 = arrayList.size();
            i = i2;
            while (i2 < size2) {
                if (!obj.p && i != i2) {
                }
                i2++;
                if (i != i2) {
                }
                i = i2 + 1;
                if ((Boolean)arrayList2.get(i2).booleanValue()) {
                }
                f0(arrayList, arrayList2, i2, i);
                i2 = i + -1;
                while (i < size2) {
                    if ((Boolean)arrayList2.get(i).booleanValue()) {
                    }
                    if (!obj4.p) {
                    }
                    i++;
                }
                if ((Boolean)arrayList2.get(i).booleanValue()) {
                }
                if (!obj4.p) {
                }
                i++;
                f0(arrayList, arrayList2, i, i2);
            }
            if (i != size2) {
                f0(arrayList, arrayList2, i, size2);
            }
        }
        IllegalStateException obj5 = new IllegalStateException("Internal error with the back stack records");
        throw obj5;
    }

    private void k1() {
        int list;
        Object size;
        if (this.l != null) {
            list = 0;
            while (list < this.l.size()) {
                (n.o)this.l.get(list).onBackStackChanged();
                list++;
            }
        }
    }

    private void m0() {
        Iterator iterator;
        boolean next;
        if (n.P) {
            iterator = t().iterator();
            for (c0 next : iterator) {
                next.k();
            }
        } else {
            if (this.L != null) {
            }
        }
    }

    static int m1(int i) {
        int i2;
        final int i3 = 4099;
        final int i4 = 4097;
        if (i != i4) {
            if (i != i3) {
                i2 = i != 8194 ? 0 : i4;
            } else {
                i2 = i3;
            }
        }
        return i2;
    }

    private boolean n0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        int i;
        int i2;
        boolean z;
        final ArrayList list = this.a;
        i = 0;
        synchronized (list) {
            return i;
        }
    }

    private void o(androidx.fragment.app.Fragment fragment) {
        Object obj;
        Iterator iterator;
        boolean next;
        obj = this.m.get(fragment);
        if ((HashSet)obj != null) {
            iterator = (HashSet)obj.iterator();
            for (b next : iterator) {
                next.a();
            }
            obj.clear();
            y(fragment);
            this.m.remove(fragment);
        }
    }

    private void q() {
        if (N0()) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Can not perform this action after onSaveInstanceState");
        throw illegalStateException;
    }

    private androidx.fragment.app.q q0(androidx.fragment.app.Fragment fragment) {
        return this.M.k(fragment);
    }

    private void r() {
        this.b = false;
        this.J.clear();
        this.I.clear();
    }

    private ViewGroup s0(androidx.fragment.app.Fragment fragment) {
        boolean z;
        Object obj3;
        ViewGroup mContainer = fragment.mContainer;
        if (mContainer != null) {
            return mContainer;
        }
        final int i = 0;
        if (fragment.mContainerId <= 0) {
            return i;
        }
        obj3 = this.s.c(fragment.mContainerId);
        if (this.s.d() && obj3 instanceof ViewGroup) {
            obj3 = this.s.c(fragment.mContainerId);
            if (obj3 instanceof ViewGroup) {
                return (ViewGroup)obj3;
            }
        }
        return i;
    }

    private void s1(androidx.fragment.app.Fragment fragment) {
        Object tag;
        int i;
        int popExitAnim;
        androidx.fragment.app.Fragment obj4;
        tag = s0(fragment);
        i = b.c;
        if (tag != null && i3 += popExitAnim > 0 && tag.getTag(i) == null) {
            if (i3 += popExitAnim > 0) {
                i = b.c;
                if (tag.getTag(i) == null) {
                    tag.setTag(i, fragment);
                }
                (Fragment)tag.getTag(i).setPopDirection(fragment.getPopDirection());
            }
        }
    }

    private Set<androidx.fragment.app.c0> t() {
        Object mContainer;
        androidx.fragment.app.d0 d0Var;
        HashSet hashSet = new HashSet();
        Iterator iterator = this.c.k().iterator();
        while (iterator.hasNext()) {
            mContainer = fragment.mContainer;
            if (mContainer != null) {
            }
            hashSet.add(c0.o(mContainer, B0()));
        }
        return hashSet;
    }

    private Set<androidx.fragment.app.c0> u(ArrayList<androidx.fragment.app.a> arrayList, int i2, int i3) {
        Iterator iterator;
        boolean mContainer;
        int obj5;
        HashSet hashSet = new HashSet();
        while (obj5 < i3) {
            iterator = obj.a.iterator();
            while (iterator.hasNext()) {
                mContainer = next.b;
                mContainer = mContainer.mContainer;
                if (mContainer != null && mContainer != null) {
                }
                mContainer = mContainer.mContainer;
                if (mContainer != null) {
                }
                hashSet.add(c0.n(mContainer, this));
            }
            obj5++;
            mContainer = next.b;
            mContainer = mContainer.mContainer;
            if (mContainer != null && mContainer != null) {
            }
            mContainer = mContainer.mContainer;
            if (mContainer != null) {
            }
            hashSet.add(c0.n(mContainer, this));
        }
        return hashSet;
    }

    private void u1() {
        Object next;
        Iterator iterator = this.c.k().iterator();
        for (u next : iterator) {
            Y0(next);
        }
    }

    private void v1() {
        int i;
        int i2;
        ArrayList list = this.a;
        synchronized (list) {
            this.h.f(true);
        }
        try {
            if (L0(this.t)) {
            } else {
            }
            i2 = 0;
            dVar.f(i2);
            throw th;
        }
    }

    private void w(androidx.fragment.app.Fragment fragment) {
        View hideReplaced2;
        Object dVar;
        boolean hideReplaced;
        int i;
        Object hideReplaced3;
        int mView;
        boolean popDirection;
        Animator animator;
        androidx.fragment.app.n.h hVar;
        final int i2 = 0;
        if (fragment.mView != null) {
            dVar = f.c(this.r.f(), fragment, mHidden2 ^= 1, fragment.getPopDirection());
            mView = dVar.b;
            if (dVar != null && mView != null) {
                mView = dVar.b;
                if (mView != null) {
                    mView.setTarget(fragment.mView);
                    if (fragment.mHidden) {
                        if (fragment.isHideReplaced()) {
                            fragment.setHideReplaced(i2);
                        } else {
                            hideReplaced3 = fragment.mContainer;
                            popDirection = fragment.mView;
                            hideReplaced3.startViewTransition(popDirection);
                            hVar = new n.h(this, hideReplaced3, popDirection, fragment);
                            dVar.b.addListener(hVar);
                        }
                    } else {
                        fragment.mView.setVisibility(i2);
                    }
                    dVar.b.start();
                } else {
                    if (dVar != null) {
                        fragment.mView.startAnimation(dVar.a);
                        dVar.a.start();
                    }
                    if (fragment.mHidden && !fragment.isHideReplaced()) {
                        i = !fragment.isHideReplaced() ? 8 : i2;
                    } else {
                    }
                    fragment.mView.setVisibility(i);
                    if (fragment.isHideReplaced()) {
                        fragment.setHideReplaced(i2);
                    }
                }
            } else {
            }
        }
        G0(fragment);
        fragment.mHiddenChanged = i2;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    private void y(androidx.fragment.app.Fragment fragment) {
        fragment.performDestroyView();
        final int i2 = 0;
        this.o.n(fragment, i2);
        int i = 0;
        fragment.mContainer = i;
        fragment.mView = i;
        fragment.mViewLifecycleOwner = i;
        fragment.mViewLifecycleOwnerLiveData.setValue(i);
        fragment.mInLayout = i2;
    }

    void A() {
        int i = 0;
        this.E = i;
        this.F = i;
        this.M.q(i);
        U(4);
    }

    public androidx.fragment.app.Fragment A0() {
        return this.u;
    }

    void B() {
        final int i = 0;
        this.E = i;
        this.F = i;
        this.M.q(i);
        U(i);
    }

    androidx.fragment.app.d0 B0() {
        androidx.fragment.app.d0 d0Var = this.x;
        if (d0Var != null) {
            return d0Var;
        }
        androidx.fragment.app.Fragment fragment = this.t;
        if (fragment != null) {
            return fragment.mFragmentManager.B0();
        }
        return this.y;
    }

    void C(Configuration configuration) {
        Object next;
        Iterator iterator = this.c.n().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((Fragment)next != null) {
            }
            (Fragment)next.performConfigurationChanged(configuration);
        }
    }

    boolean D(MenuItem menuItem) {
        Object contextItemSelected;
        final int i2 = 0;
        final int i3 = 1;
        if (this.q < i3) {
            return i2;
        }
        Iterator iterator = this.c.n().iterator();
        for (Fragment contextItemSelected : iterator) {
        }
        return i2;
    }

    i0 D0(androidx.fragment.app.Fragment fragment) {
        return this.M.n(fragment);
    }

    void E() {
        int i = 0;
        this.E = i;
        this.F = i;
        this.M.q(i);
        U(1);
    }

    void E0() {
        boolean z;
        c0(true);
        if (this.h.c()) {
            c1();
        } else {
            this.g.d();
        }
    }

    boolean F(Menu menu, MenuInflater menuInflater2) {
        int arrayList;
        int i;
        int i2;
        Object next;
        boolean createOptionsMenu;
        ArrayList obj8;
        MenuInflater obj9;
        i = 0;
        final int i4 = 1;
        if (this.q < i4) {
            return i;
        }
        arrayList = 0;
        Iterator iterator = this.c.n().iterator();
        i2 = i;
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next != null && K0((Fragment)next) && next.performCreateOptionsMenu(menu, menuInflater2) && arrayList == null) {
            }
            if (K0(next)) {
            }
            if (next.performCreateOptionsMenu(menu, menuInflater2)) {
            }
            if (arrayList == null) {
            }
            arrayList.add(next);
            i2 = i4;
            arrayList = new ArrayList();
        }
        if (this.e != null) {
        }
        this.e = arrayList;
        return i2;
    }

    void F0(androidx.fragment.app.Fragment fragment) {
        boolean string;
        boolean mHidden;
        String mHiddenChanged;
        if (n.I0(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("hide: ");
            stringBuilder.append(fragment);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        if (!fragment.mHidden) {
            int i2 = 1;
            fragment.mHidden = i2;
            fragment.mHiddenChanged = i2 ^= mHiddenChanged;
            s1(fragment);
        }
    }

    void G() {
        c cVar;
        Object onBackPressedDispatcher;
        int i = 1;
        this.G = i;
        c0(i);
        Z();
        U(-1);
        int i3 = 0;
        this.r = i3;
        this.s = i3;
        this.t = i3;
        if (this.g != null) {
            this.h.d();
            this.g = i3;
        }
        cVar = this.z;
        if (cVar != null) {
            cVar.c();
            this.A.c();
            this.B.c();
        }
    }

    void G0(androidx.fragment.app.Fragment fragment) {
        Object obj2;
        if (fragment.mAdded && J0(fragment)) {
            if (J0(fragment)) {
                this.D = true;
            }
        }
    }

    void H() {
        U(1);
    }

    public boolean H0() {
        return this.G;
    }

    void I() {
        Object next;
        Iterator iterator = this.c.n().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((Fragment)next != null) {
            }
            (Fragment)next.performLowMemory();
        }
    }

    void J(boolean z) {
        Object next;
        Iterator iterator = this.c.n().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((Fragment)next != null) {
            }
            (Fragment)next.performMultiWindowModeChanged(z);
        }
    }

    void K(androidx.fragment.app.Fragment fragment) {
        Object next;
        Iterator iterator = this.p.iterator();
        for (r next : iterator) {
            next.a(this, fragment);
        }
    }

    boolean K0(androidx.fragment.app.Fragment fragment) {
        if (fragment == null) {
            return 1;
        }
        return fragment.isMenuVisible();
    }

    boolean L(MenuItem menuItem) {
        Object optionsItemSelected;
        final int i2 = 0;
        final int i3 = 1;
        if (this.q < i3) {
            return i2;
        }
        Iterator iterator = this.c.n().iterator();
        for (Fragment optionsItemSelected : iterator) {
        }
        return i2;
    }

    boolean L0(androidx.fragment.app.Fragment fragment) {
        int i;
        boolean obj4;
        if (fragment == null) {
            return 1;
        }
        final androidx.fragment.app.n mFragmentManager = fragment.mFragmentManager;
        if (fragment.equals(mFragmentManager.A0()) && L0(mFragmentManager.t)) {
            if (L0(mFragmentManager.t)) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    void M(Menu menu) {
        int next;
        if (this.q < 1) {
        }
        Iterator iterator = this.c.n().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((Fragment)next != 0) {
            }
            (Fragment)next.performOptionsMenuClosed(menu);
        }
    }

    boolean M0(int i) {
        int obj2;
        obj2 = this.q >= i ? 1 : 0;
        return obj2;
    }

    public boolean N0() {
        int i;
        boolean z;
        if (!this.E) {
            if (this.F) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    void O() {
        U(5);
    }

    void O0(androidx.fragment.app.Fragment fragment, String[] string2Arr2, int i3) {
        Object nVar;
        Object obj2;
        if (this.B != null) {
            nVar = new n.n(fragment.mWho, i3);
            this.C.addLast(nVar);
            this.B.a(string2Arr2);
        } else {
            this.r.j(fragment, string2Arr2, i3);
        }
    }

    void P(boolean z) {
        Object next;
        Iterator iterator = this.c.n().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((Fragment)next != null) {
            }
            (Fragment)next.performPictureInPictureModeChanged(z);
        }
    }

    void P0(androidx.fragment.app.Fragment fragment, Intent intent2, int i3, Bundle bundle4) {
        Object nVar;
        Object obj2;
        if (this.z != null) {
            nVar = new n.n(fragment.mWho, i3);
            this.C.addLast(nVar);
            if (intent2 != null && bundle4 != null) {
                if (bundle4 != null) {
                    intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle4);
                }
            }
            this.z.a(intent2);
        } else {
            this.r.m(fragment, intent2, i3, bundle4);
        }
    }

    boolean Q(Menu menu) {
        int i;
        Object prepareOptionsMenu;
        boolean z;
        final int i3 = 1;
        if (this.q < i3) {
            return 0;
        }
        Iterator iterator = this.c.n().iterator();
        while (iterator.hasNext()) {
            prepareOptionsMenu = iterator.next();
            if (prepareOptionsMenu != null && K0((Fragment)prepareOptionsMenu) && prepareOptionsMenu.performPrepareOptionsMenu(menu)) {
            }
            if (K0(prepareOptionsMenu)) {
            }
            if (prepareOptionsMenu.performPrepareOptionsMenu(menu)) {
            }
            i = i3;
        }
        return i;
    }

    void Q0(androidx.fragment.app.Fragment fragment, IntentSender intentSender2, int i3, Intent intent4, int i5, int i6, int i7, Bundle bundle8) {
        Object obj2;
        Object string2;
        boolean stringBuilder;
        e eVar;
        Intent intent;
        Object nVar;
        int str;
        boolean string;
        ArrayDeque queue;
        String str2;
        int i;
        int i4;
        Object obj;
        int i2;
        final Object obj3 = this;
        obj = bundle8;
        if (obj3.A != null) {
            String str3 = "FragmentManager";
            int i8 = 2;
            if (obj != null) {
                if (intent4 == null) {
                    intent = new Intent();
                    intent.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                } else {
                    intent = intent4;
                }
                if (n.I0(i8)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("ActivityOptions ");
                    stringBuilder2.append(obj);
                    stringBuilder2.append(" were added to fillInIntent ");
                    stringBuilder2.append(intent);
                    stringBuilder2.append(" for fragment ");
                    stringBuilder2.append(fragment);
                    Log.v(str3, stringBuilder2.toString());
                }
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", obj);
            } else {
                intent = intent4;
            }
            IntentSender intent2 = intentSender2;
            e.b bVar = new e.b(intentSender2);
            bVar.b(intent);
            bVar.c(i6, i5);
            i2 = i3;
            nVar = new n.n(string2.mWho, i3);
            obj3.C.addLast(nVar);
            if (n.I0(i8)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Fragment ");
                stringBuilder.append(fragment);
                stringBuilder.append("is launching an IntentSender for result ");
                Log.v(str3, stringBuilder.toString());
            }
            obj3.A.a(bVar.a());
        } else {
            IntentSender intent3 = intentSender2;
            i2 = i3;
            int i9 = i5;
            int i10 = i6;
            obj3.r.n(fragment, intentSender2, i3, intent4, i5, i6, i7, bundle8);
        }
    }

    void R() {
        v1();
        N(this.u);
    }

    void S() {
        int i = 0;
        this.E = i;
        this.F = i;
        this.M.q(i);
        U(7);
    }

    void S0(androidx.fragment.app.Fragment fragment) {
        boolean str;
        Object mView;
        String mIsNewlyAdded;
        boolean popDirection;
        int cmp;
        Object obj5;
        if (!this.c.c(fragment.mWho) && n.I0(3)) {
            if (n.I0(3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Ignoring moving ");
                stringBuilder.append(fragment);
                stringBuilder.append(" to state ");
                stringBuilder.append(this.q);
                stringBuilder.append("since it is not added to ");
                stringBuilder.append(this);
                Log.d("FragmentManager", stringBuilder.toString());
            }
        }
        U0(fragment);
        mView = fragment.mView;
        float mPostponedAlpha = fragment.mPostponedAlpha;
        int i3 = 0;
        if (mView != null && fragment.mIsNewlyAdded && fragment.mContainer != null && Float.compare(mPostponedAlpha, i3) > 0) {
            if (fragment.mIsNewlyAdded) {
                if (fragment.mContainer != null) {
                    mPostponedAlpha = fragment.mPostponedAlpha;
                    i3 = 0;
                    if (Float.compare(mPostponedAlpha, i3) > 0) {
                        mView.setAlpha(mPostponedAlpha);
                    }
                    fragment.mPostponedAlpha = i3;
                    fragment.mIsNewlyAdded = false;
                    mView = f.c(this.r.f(), fragment, true, fragment.getPopDirection());
                    if (mView != null) {
                        mIsNewlyAdded = mView.a;
                        if (mIsNewlyAdded != null) {
                            fragment.mView.startAnimation(mIsNewlyAdded);
                        } else {
                            mView.b.setTarget(fragment.mView);
                            mView.b.start();
                        }
                    }
                }
            }
        }
        if (fragment.mHiddenChanged) {
            w(fragment);
        }
    }

    void T() {
        int i = 0;
        this.E = i;
        this.F = i;
        this.M.q(i);
        U(5);
    }

    void T0(int i, boolean z2) {
        androidx.fragment.app.k next;
        boolean next2;
        int i2;
        androidx.fragment.app.Fragment inBackStack;
        boolean mRemoving;
        Object obj4;
        int obj5;
        if (this.r == null) {
            if (i != -1) {
            } else {
            }
            obj4 = new IllegalStateException("No activity");
            throw obj4;
        }
        if (z2 == 0 && i == this.q) {
            if (i == this.q) {
            }
        }
        this.q = i;
        obj5 = 0;
        if (n.P) {
            this.c.r();
        } else {
            obj4 = this.c.n().iterator();
            for (Fragment next : obj4) {
                S0(next);
            }
            obj4 = this.c.k().iterator();
            while (obj4.hasNext()) {
                next2 = obj4.next();
                inBackStack = (u)next2.k();
                if (!inBackStack.mIsNewlyAdded) {
                }
                if (inBackStack.mRemoving && !inBackStack.isInBackStack()) {
                } else {
                }
                i2 = obj5;
                if (i2 != 0) {
                }
                this.c.q(next2);
                if (!inBackStack.isInBackStack()) {
                } else {
                }
                i2 = 1;
                S0(inBackStack);
            }
        }
        u1();
        obj4 = this.r;
        if (this.D && obj4 != null && this.q == 7) {
            obj4 = this.r;
            if (obj4 != null) {
                if (this.q == 7) {
                    obj4.o();
                    this.D = obj5;
                }
            }
        }
    }

    void U0(androidx.fragment.app.Fragment fragment) {
        V0(fragment, this.q);
    }

    void V() {
        int i = 1;
        this.F = i;
        this.M.q(i);
        U(4);
    }

    void V0(androidx.fragment.app.Fragment fragment, int i2) {
        androidx.fragment.app.u uVar;
        int mState2;
        int mState;
        androidx.fragment.app.m mVar;
        boolean mFromLayout;
        int mSavedViewState;
        int mContainer3;
        boolean string2;
        boolean string;
        androidx.fragment.app.v vVar;
        int str;
        int mContainer;
        int removingParent;
        int popDirection;
        int mContainer2;
        int i;
        int obj12;
        mState = 1;
        if (this.c.m(fragment.mWho) == null) {
            uVar = new u(this.o, this.c, fragment);
            uVar.t(mState);
        }
        str = 2;
        if (fragment.mFromLayout && fragment.mInLayout && fragment.mState == str) {
            if (fragment.mInLayout) {
                if (fragment.mState == str) {
                    obj12 = Math.max(i2, str);
                }
            }
        }
        obj12 = Math.min(obj12, uVar.d());
        mSavedViewState = fragment.mState;
        final int i4 = 3;
        final String str7 = "FragmentManager";
        mContainer = -1;
        removingParent = 5;
        mContainer2 = 4;
        if (mSavedViewState <= obj12) {
            if (mSavedViewState < obj12 && !this.m.isEmpty()) {
                if (!this.m.isEmpty()) {
                    o(fragment);
                }
            }
            mSavedViewState = fragment.mState;
            if (mSavedViewState != mContainer) {
                if (mSavedViewState != 0) {
                    if (mSavedViewState != mState) {
                        if (mSavedViewState != str) {
                            if (mSavedViewState != mContainer2) {
                                if (mSavedViewState != removingParent) {
                                } else {
                                    if (obj12 > removingParent) {
                                        uVar.p();
                                    }
                                }
                            } else {
                                if (obj12 > mContainer2) {
                                    uVar.u();
                                }
                            }
                        } else {
                            if (obj12 > str) {
                                uVar.a();
                            }
                        }
                    } else {
                        if (obj12 > mContainer) {
                            uVar.j();
                        }
                        if (obj12 > mState) {
                            uVar.f();
                        }
                    }
                } else {
                    if (obj12 > 0) {
                        uVar.e();
                    }
                }
            } else {
                if (obj12 > mContainer) {
                    uVar.c();
                }
            }
        } else {
            if (mSavedViewState > obj12) {
                if (mSavedViewState != 0) {
                    if (mSavedViewState != mState) {
                        if (mSavedViewState != str) {
                            if (mSavedViewState != mContainer2) {
                                if (mSavedViewState != removingParent) {
                                    i = 7;
                                    if (mSavedViewState != i) {
                                    } else {
                                        if (obj12 < i) {
                                            uVar.n();
                                        }
                                        if (obj12 < removingParent) {
                                            uVar.v();
                                        }
                                        if (obj12 < mContainer2 && n.I0(i4)) {
                                            if (n.I0(i4)) {
                                                StringBuilder stringBuilder3 = new StringBuilder();
                                                stringBuilder3.append("movefrom ACTIVITY_CREATED: ");
                                                stringBuilder3.append(fragment);
                                                Log.d(str7, stringBuilder3.toString());
                                            }
                                            if (fragment.mView != null && this.r.k(fragment) && fragment.mSavedViewState == null) {
                                                if (this.r.k(fragment)) {
                                                    if (fragment.mSavedViewState == null) {
                                                        uVar.s();
                                                    }
                                                }
                                            }
                                        }
                                        mContainer3 = 0;
                                        removingParent = fragment.mView;
                                        mContainer2 = fragment.mContainer;
                                        mContainer2.endViewTransition(removingParent);
                                        fragment.mView.clearAnimation();
                                        mContainer2 = 0;
                                        if (obj12 < str && removingParent != null && mContainer2 != null && !fragment.isRemovingParent() && this.q > mContainer && !this.G && fragment.mView.getVisibility() == 0 && Float.compare(mPostponedAlpha, mContainer2) >= 0) {
                                            mContainer3 = 0;
                                            removingParent = fragment.mView;
                                            if (removingParent != null) {
                                                mContainer2 = fragment.mContainer;
                                                if (mContainer2 != null) {
                                                    mContainer2.endViewTransition(removingParent);
                                                    fragment.mView.clearAnimation();
                                                    if (!fragment.isRemovingParent()) {
                                                        mContainer2 = 0;
                                                        if (this.q > mContainer) {
                                                            if (!this.G) {
                                                                if (fragment.mView.getVisibility() == 0) {
                                                                    if (Float.compare(mPostponedAlpha, mContainer2) >= 0) {
                                                                        mContainer3 = f.c(this.r.f(), fragment, false, fragment.getPopDirection());
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        fragment.mPostponedAlpha = mContainer2;
                                                        mContainer = fragment.mContainer;
                                                        removingParent = fragment.mView;
                                                        if (mContainer3 != 0) {
                                                            f.a(fragment, mContainer3, this.n);
                                                        }
                                                        mContainer.removeView(removingParent);
                                                        if (n.I0(str)) {
                                                            StringBuilder stringBuilder2 = new StringBuilder();
                                                            stringBuilder2.append("Removing view ");
                                                            stringBuilder2.append(removingParent);
                                                            stringBuilder2.append(" for fragment ");
                                                            stringBuilder2.append(fragment);
                                                            stringBuilder2.append(" from container ");
                                                            stringBuilder2.append(mContainer);
                                                            Log.v(str7, stringBuilder2.toString());
                                                        }
                                                        if (mContainer != fragment.mContainer) {
                                                        }
                                                    }
                                                }
                                            }
                                            if (this.m.get(fragment) == null) {
                                                uVar.h();
                                            }
                                        }
                                        if (obj12 < mState) {
                                            if (this.m.get(fragment) != null) {
                                            } else {
                                                uVar.g();
                                                mState = obj12;
                                            }
                                        } else {
                                        }
                                        if (mState < 0) {
                                            uVar.i();
                                        }
                                        obj12 = mState;
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
            }
        }
        if (fragment.mState != obj12 && n.I0(i4)) {
            if (n.I0(i4)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("moveToState: Fragment state for ");
                stringBuilder.append(fragment);
                stringBuilder.append(" not updated inline; expected state ");
                stringBuilder.append(obj12);
                stringBuilder.append(" found ");
                stringBuilder.append(fragment.mState);
                Log.d(str7, stringBuilder.toString());
            }
            fragment.mState = obj12;
        }
    }

    void W() {
        U(2);
    }

    void W0() {
        androidx.fragment.app.q next;
        if (this.r == null) {
        }
        int i = 0;
        this.E = i;
        this.F = i;
        this.M.q(i);
        Iterator iterator = this.c.n().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((Fragment)next != null) {
            }
            (Fragment)next.noteStateNotSaved();
        }
    }

    void X0(androidx.fragment.app.h h) {
        Object next;
        androidx.fragment.app.Fragment fragment;
        int mContainerId;
        int i;
        Iterator iterator = this.c.k().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            fragment = (u)next.k();
            mContainerId = fragment.mView;
            if (fragment.mContainerId == h.getId() && mContainerId != null && mContainerId.getParent() == null) {
            }
            mContainerId = fragment.mView;
            if (mContainerId != null) {
            }
            if (mContainerId.getParent() == null) {
            }
            fragment.mContainer = h;
            next.b();
        }
    }

    public void Y(String string, FileDescriptor fileDescriptor2, PrintWriter printWriter3, String[] string4Arr4) {
        int str;
        String string2;
        String string3;
        String obj5;
        ArrayList obj6;
        int obj8;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("    ");
        this.c.e(string, fileDescriptor2, printWriter3, string4Arr4);
        obj6 = this.e;
        obj8 = 0;
        obj6 = obj6.size();
        if (obj6 != null && obj6 > 0) {
            obj6 = obj6.size();
            if (obj6 > 0) {
                printWriter3.print(string);
                printWriter3.println("Fragments Created Menus:");
                str = obj8;
                while (str < obj6) {
                    printWriter3.print(string);
                    printWriter3.print("  #");
                    printWriter3.print(str);
                    printWriter3.print(": ");
                    printWriter3.println((Fragment)this.e.get(str).toString());
                    str++;
                }
            }
        }
        obj6 = this.d;
        obj6 = obj6.size();
        if (obj6 != null && obj6 > 0) {
            obj6 = obj6.size();
            if (obj6 > 0) {
                printWriter3.print(string);
                printWriter3.println("Back Stack:");
                str = obj8;
                while (str < obj6) {
                    string2 = this.d.get(str);
                    printWriter3.print(string);
                    printWriter3.print("  #");
                    printWriter3.print(str);
                    printWriter3.print(": ");
                    printWriter3.println((a)string2.toString());
                    string2.w(stringBuilder.toString(), printWriter3);
                    str++;
                }
            }
        }
        printWriter3.print(string);
        obj6 = new StringBuilder();
        obj6.append("Back Stack Index: ");
        obj6.append(this.i.get());
        printWriter3.println(obj6.toString());
        obj6 = this.a;
        int size = this.a.size();
        synchronized (obj6) {
            printWriter3.print(string);
            printWriter3.println("Pending Actions:");
            while (obj8 < size) {
                printWriter3.print(string);
                printWriter3.print("  #");
                printWriter3.print(obj8);
                printWriter3.print(": ");
                printWriter3.println((n.p)this.a.get(obj8));
                obj8++;
            }
            printWriter3.print(string);
            printWriter3.println("FragmentManager misc state:");
            printWriter3.print(string);
            printWriter3.print("  mHost=");
            printWriter3.println(this.r);
            printWriter3.print(string);
            printWriter3.print("  mContainer=");
            printWriter3.println(this.s);
            if (this.t != null) {
            }
            printWriter3.print(string);
            printWriter3.print("  mCurState=");
            printWriter3.print(this.q);
            printWriter3.print(" mStateSaved=");
            printWriter3.print(this.E);
            printWriter3.print(" mStopped=");
            printWriter3.print(this.F);
            printWriter3.print(" mDestroyed=");
            printWriter3.println(this.G);
            if (this.D) {
                printWriter3.print(string);
                printWriter3.print("  mNeedMenuInvalidate=");
                printWriter3.println(this.D);
            }
        }
        printWriter3.print(string);
        printWriter3.print("  mParent=");
        printWriter3.println(this.t);
    }

    void Y0(androidx.fragment.app.u u) {
        boolean mDeferStart;
        final androidx.fragment.app.Fragment fragment = u.k();
        if (fragment.mDeferStart && this.b) {
            if (this.b) {
                this.H = true;
            }
            fragment.mDeferStart = false;
            if (n.P) {
                u.m();
            } else {
                U0(fragment);
            }
        }
    }

    public void Z0() {
        final int i3 = 0;
        n.q qVar = new n.q(this, 0, -1, i3);
        a0(qVar, i3);
    }

    void a0(androidx.fragment.app.n.p n$p, boolean z2) {
        androidx.fragment.app.k kVar;
        if (!z2 && this.r == null && this.G) {
            if (this.r == null) {
                if (this.G) {
                    IllegalStateException obj3 = new IllegalStateException("FragmentManager has been destroyed");
                    throw obj3;
                }
                obj3 = new IllegalStateException("FragmentManager has not been attached to a host.");
                throw obj3;
            }
            q();
        }
        ArrayList list = this.a;
        synchronized (list) {
            if (!z2) {
            } else {
            }
            obj3 = new IllegalStateException("Activity has been destroyed");
            throw obj3;
        }
    }

    public void a1(int i, int i2) {
        if (i < 0) {
        } else {
            n.q qVar = new n.q(this, 0, i, i2);
            a0(qVar, false);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad id: ");
        stringBuilder.append(i);
        IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString());
        throw obj4;
    }

    public void b1(String string, int i2) {
        n.q qVar = new n.q(this, string, -1, i2);
        a0(qVar, false);
    }

    boolean c0(boolean z) {
        int i;
        ArrayList list;
        ArrayList list2;
        b0(z);
        int obj4 = 1;
        i = 0;
        while (n0(this.I, this.J)) {
            this.b = obj4;
            i1(this.I, this.J);
            r();
            i = obj4;
        }
        v1();
        X();
        this.c.b();
        return i;
    }

    public boolean c1() {
        return d1(0, -1, 0);
    }

    void d0(androidx.fragment.app.n.p n$p, boolean z2) {
        androidx.fragment.app.k kVar;
        boolean obj2;
        ArrayList obj3;
        if (z2 && this.r != null && this.G) {
            if (this.r != null) {
                if (this.G) {
                }
            }
        }
        b0(z2);
        if (p.a(this.I, this.J)) {
            this.b = true;
            i1(this.I, this.J);
            r();
        }
        v1();
        X();
        this.c.b();
    }

    void e(androidx.fragment.app.a a) {
        ArrayList arrayList;
        if (this.d == null) {
            arrayList = new ArrayList();
            this.d = arrayList;
        }
        this.d.add(a);
    }

    boolean e1(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String string3, int i4, int i5) {
        ArrayList list;
        int equals2;
        boolean equals;
        Boolean obj6;
        int obj8;
        int obj9;
        int obj10;
        list = this.d;
        final int i = 0;
        if (list == null) {
            return i;
        }
        final int i2 = 1;
        if (string3 == null && i4 < 0 && i5 & 1 == 0) {
            if (i4 < 0) {
                if (i5 & 1 == 0) {
                    obj8 -= i2;
                    if (obj8 < 0) {
                        return i;
                    }
                    arrayList.add(this.d.remove(obj8));
                    arrayList2.add(Boolean.TRUE);
                } else {
                    if (string3 == null) {
                        if (i4 >= 0) {
                            size -= i2;
                            while (list >= 0) {
                                equals2 = this.d.get(list);
                                list--;
                            }
                            if (list < 0) {
                                return i;
                            }
                            if (i5 &= i2 != 0) {
                            }
                            obj8 = list;
                        } else {
                            obj8 = -1;
                        }
                    } else {
                    }
                    if (obj8 == obj9 -= i2) {
                        return i;
                    }
                    obj9 -= i2;
                    while (obj9 > obj8) {
                        arrayList.add(this.d.remove(obj9));
                        arrayList2.add(Boolean.TRUE);
                        obj9--;
                    }
                }
            } else {
            }
        } else {
        }
        return i2;
    }

    void f(androidx.fragment.app.Fragment fragment, b b2) {
        Object obj;
        HashSet hashSet;
        if (this.m.get(fragment) == null) {
            hashSet = new HashSet();
            this.m.put(fragment, hashSet);
        }
        (HashSet)this.m.get(fragment).add(b2);
    }

    androidx.fragment.app.u g(androidx.fragment.app.Fragment fragment) {
        boolean string;
        String str;
        boolean mDetached;
        View mView;
        Object obj4;
        if (n.I0(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("add: ");
            stringBuilder.append(fragment);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        androidx.fragment.app.u uVar = x(fragment);
        fragment.mFragmentManager = this;
        this.c.p(uVar);
        this.c.a(fragment);
        mDetached = 0;
        fragment.mRemoving = mDetached;
        if (!fragment.mDetached && fragment.mView == null) {
            this.c.a(fragment);
            mDetached = 0;
            fragment.mRemoving = mDetached;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = mDetached;
            }
            if (J0(fragment)) {
                this.D = true;
            }
        }
        return uVar;
    }

    public boolean g0() {
        m0();
        return c0(true);
    }

    void g1(androidx.fragment.app.Fragment fragment, b b2) {
        Object obj;
        Object obj3;
        obj = this.m.get(fragment);
        this.m.remove(fragment);
        if (obj != null && (HashSet)obj.remove(b2) && obj.isEmpty() && fragment.mState < 5) {
            if (obj.remove(b2)) {
                if (obj.isEmpty()) {
                    this.m.remove(fragment);
                    if (fragment.mState < 5) {
                        y(fragment);
                        U0(fragment);
                    }
                }
            }
        }
    }

    public void h(androidx.fragment.app.r r) {
        this.p.add(r);
    }

    void h1(androidx.fragment.app.Fragment fragment) {
        boolean string;
        int i;
        String str;
        if (n.I0(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("remove: ");
            stringBuilder.append(fragment);
            stringBuilder.append(" nesting=");
            stringBuilder.append(fragment.mBackStackNesting);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        int i3 = 1;
        if (fragment.mDetached) {
            this.c.s(fragment);
            if (inBackStack ^= i3 != 0 && J0(fragment)) {
                this.c.s(fragment);
                if (J0(fragment)) {
                    this.D = i3;
                }
                fragment.mRemoving = i3;
                s1(fragment);
            }
        } else {
        }
    }

    public void i(androidx.fragment.app.n.o n$o) {
        ArrayList arrayList;
        if (this.l == null) {
            arrayList = new ArrayList();
            this.l = arrayList;
        }
        this.l.add(o);
    }

    androidx.fragment.app.Fragment i0(String string) {
        return this.c.f(string);
    }

    void j(androidx.fragment.app.Fragment fragment) {
        this.M.h(fragment);
    }

    public androidx.fragment.app.Fragment j0(int i) {
        return this.c.g(i);
    }

    void j1(androidx.fragment.app.Fragment fragment) {
        this.M.p(fragment);
    }

    int k() {
        return this.i.getAndIncrement();
    }

    public androidx.fragment.app.Fragment k0(String string) {
        return this.c.h(string);
    }

    void l(androidx.fragment.app.k<?> k, androidx.fragment.app.g g2, androidx.fragment.app.Fragment fragment3) {
        Object onBackPressedDispatcher;
        d aVar;
        androidx.fragment.app.q obj3;
        boolean obj4;
        Object obj5;
        if (this.r != null) {
        } else {
            this.r = k;
            this.s = g2;
            this.t = fragment3;
            if (fragment3 != null) {
                obj4 = new n.i(this, fragment3);
                h(obj4);
            } else {
                if (k instanceof r) {
                    h((r)k);
                }
            }
            if (this.t != null) {
                v1();
            }
            onBackPressedDispatcher = (f)k.getOnBackPressedDispatcher();
            this.g = onBackPressedDispatcher;
            if (k instanceof f && fragment3 != null) {
                onBackPressedDispatcher = (f)k.getOnBackPressedDispatcher();
                this.g = onBackPressedDispatcher;
                if (fragment3 != null) {
                    obj4 = fragment3;
                }
                onBackPressedDispatcher.b(obj4, this.h);
            }
            if (fragment3 != null) {
                this.M = fragment3.mFragmentManager.q0(fragment3);
            } else {
                if (k instanceof j0) {
                    this.M = q.l((j0)k.getViewModelStore());
                } else {
                    obj3 = new q(0);
                    this.M = obj3;
                }
            }
            this.M.q(N0());
            this.c.x(this.M);
            obj3 = this.r;
            if (obj3 instanceof d) {
                obj3 = (d)obj3.getActivityResultRegistry();
                if (fragment3 != null) {
                    obj4 = new StringBuilder();
                    obj4.append(fragment3.mWho);
                    obj4.append(":");
                    obj4 = obj4.toString();
                } else {
                    obj4 = "";
                }
                obj5 = new StringBuilder();
                obj5.append("FragmentManager:");
                obj5.append(obj4);
                obj4 = obj5.toString();
                obj5 = new StringBuilder();
                obj5.append(obj4);
                obj5.append("StartActivityForResult");
                c cVar = new c();
                n.j jVar = new n.j(this);
                this.z = obj3.i(obj5.toString(), cVar, jVar);
                obj5 = new StringBuilder();
                obj5.append(obj4);
                obj5.append("StartIntentSenderForResult");
                n.l lVar = new n.l();
                aVar = new n.a(this);
                this.A = obj3.i(obj5.toString(), lVar, aVar);
                obj5 = new StringBuilder();
                obj5.append(obj4);
                obj5.append("RequestPermissions");
                obj5 = new b();
                onBackPressedDispatcher = new n.b(this);
                this.B = obj3.i(obj5.toString(), obj5, onBackPressedDispatcher);
            }
        }
        obj3 = new IllegalStateException("Already attached");
        throw obj3;
    }

    androidx.fragment.app.Fragment l0(String string) {
        return this.c.i(string);
    }

    void l1(Parcelable parcelable) {
        int i;
        Object str4;
        Object next2;
        Object uVar;
        Object string2;
        boolean next;
        int i2;
        String str2;
        int size;
        int stringBuilder;
        String str3;
        androidx.fragment.app.u uVar2;
        boolean string;
        int length;
        boolean string3;
        androidx.fragment.app.m mWho;
        boolean str;
        androidx.fragment.app.v printWriter;
        java.lang.ClassLoader classLoader;
        androidx.fragment.app.j jVar;
        Object obj;
        if (parcelable == null) {
        }
        if (parcelable.a == null) {
        }
        this.c.t();
        Iterator iterator = parcelable.a.iterator();
        str2 = "): ";
        stringBuilder = 2;
        str3 = "FragmentManager";
        while (iterator.hasNext()) {
            obj = next2;
            if ((t)obj != null) {
            }
            str2 = "): ";
            stringBuilder = 2;
            str3 = "FragmentManager";
            uVar = this.M.j(obj.b);
            if (uVar != null) {
            } else {
            }
            super(this.o, this.c, this.r.f().getClassLoader(), t0(), (t)obj);
            string2 = uVar2.k();
            string2.mFragmentManager = this;
            if (n.I0(stringBuilder)) {
            }
            uVar2.o(this.r.f().getClassLoader());
            this.c.p(uVar2);
            uVar2.t(this.q);
            stringBuilder = new StringBuilder();
            stringBuilder.append("restoreSaveState: active (");
            stringBuilder.append(string2.mWho);
            stringBuilder.append(str2);
            stringBuilder.append(string2);
            Log.v(str3, stringBuilder.toString());
            if (n.I0(stringBuilder)) {
            }
            uVar2 = new u(this.o, this.c, uVar, obj);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("restoreSaveState: re-attaching retained ");
            stringBuilder2.append(uVar);
            Log.v(str3, stringBuilder2.toString());
        }
        Iterator iterator2 = this.M.m().iterator();
        while (iterator2.hasNext()) {
            next = iterator2.next();
            if (!this.c.c(next.mWho) && n.I0(stringBuilder)) {
            }
            if (n.I0(stringBuilder)) {
            }
            this.M.p((Fragment)next);
            next.mFragmentManager = this;
            uVar2 = new u(this.o, this.c, next);
            mWho = 1;
            uVar2.t(mWho);
            uVar2.m();
            next.mRemoving = mWho;
            uVar2.m();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Discarding retained Fragment ");
            stringBuilder3.append(next);
            stringBuilder3.append(" that was not found in the set of active Fragments ");
            stringBuilder3.append(parcelable.a);
            Log.v(str3, stringBuilder3.toString());
        }
        this.c.u(parcelable.b);
        i2 = 0;
        if (parcelable.c != null) {
            ArrayList arrayList = new ArrayList(objArr2.length);
            this.d = arrayList;
            i = i2;
            uVar2 = parcelable.c;
            while (i < uVar2.length) {
                length = uVar2[i].a(this);
                if (n.I0(stringBuilder)) {
                }
                this.d.add(length);
                i++;
                uVar2 = parcelable.c;
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("restoreAllState: back stack #");
                stringBuilder4.append(i);
                stringBuilder4.append(" (index ");
                stringBuilder4.append(length.t);
                stringBuilder4.append(str2);
                stringBuilder4.append(length);
                Log.v(str3, stringBuilder4.toString());
                b0 b0Var = new b0(str3);
                printWriter = new PrintWriter(b0Var);
                length.x("  ", printWriter, i2);
                printWriter.close();
            }
        } else {
            this.d = 0;
        }
        this.i.set(parcelable.v);
        str4 = parcelable.w;
        if (str4 != null) {
            str4 = i0(str4);
            this.u = str4;
            N(str4);
        }
        ArrayList list3 = parcelable.x;
        if (list3 != null) {
        }
        ArrayDeque arrayDeque = new ArrayDeque(parcelable.z);
        this.C = arrayDeque;
    }

    void m(androidx.fragment.app.Fragment fragment) {
        boolean string;
        boolean string2;
        Object mDetached;
        String str;
        Object obj5;
        string = 2;
        final String str2 = "FragmentManager";
        if (n.I0(string)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("attach: ");
            stringBuilder2.append(fragment);
            Log.v(str2, stringBuilder2.toString());
        }
        fragment.mDetached = false;
        this.c.a(fragment);
        if (fragment.mDetached && !fragment.mAdded && n.I0(string)) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.c.a(fragment);
                if (n.I0(string)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("add from attach: ");
                    stringBuilder.append(fragment);
                    Log.v(str2, stringBuilder.toString());
                }
                if (J0(fragment)) {
                    this.D = true;
                }
            }
        }
    }

    public androidx.fragment.app.w n() {
        a aVar = new a(this);
        return aVar;
    }

    Parcelable n1() {
        boolean str;
        Object mWho;
        int arr;
        ArrayList size;
        int i;
        boolean string;
        Object obj;
        m0();
        Z();
        int i2 = 1;
        c0(i2);
        this.E = i2;
        this.M.q(i2);
        ArrayList list = this.c.v();
        String str2 = "FragmentManager";
        final int i4 = 2;
        if (list.isEmpty() && n.I0(i4)) {
            if (n.I0(i4)) {
                Log.v(str2, "saveAllState: no fragments!");
            }
            return null;
        }
        size = this.d;
        size = size.size();
        if (size != null && size > 0) {
            size = size.size();
            if (size > 0) {
                i = 0;
                while (i < size) {
                    b bVar = new b((a)this.d.get(i));
                    new b[size][i] = bVar;
                    if (n.I0(i4)) {
                    }
                    i++;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("saveAllState: adding back stack #");
                    stringBuilder.append(i);
                    stringBuilder.append(": ");
                    stringBuilder.append(this.d.get(i));
                    Log.v(str2, stringBuilder.toString());
                }
            }
        }
        p pVar = new p();
        pVar.a = list;
        pVar.b = this.c.w();
        pVar.c = arr;
        pVar.v = this.i.get();
        mWho = this.u;
        if (mWho != null) {
            pVar.w = mWho.mWho;
        }
        pVar.x.addAll(this.j.keySet());
        pVar.y.addAll(this.j.values());
        ArrayList arrayList = new ArrayList(this.C);
        pVar.z = arrayList;
        return pVar;
    }

    public androidx.fragment.app.n.k o0(int i) {
        return (n.k)this.d.get(i);
    }

    void o1() {
        ArrayList empty;
        int i;
        int i2;
        final ArrayList list = this.a;
        empty = this.L;
        final int i3 = 1;
        synchronized (list) {
            if (!empty.isEmpty()) {
                i = i3;
            } else {
                try {
                    i = i2;
                    if (this.a.size() == i3) {
                    }
                    i2 = i3;
                    if (i == 0) {
                    } else {
                    }
                    if (i2 != 0) {
                    }
                    this.r.g().removeCallbacks(this.N);
                    this.r.g().post(this.N);
                    v1();
                    throw th;
                }
            }
        }
    }

    boolean p() {
        int i;
        Object next;
        Iterator iterator = this.c.l().iterator();
        final int i3 = 0;
        i = i3;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((Fragment)next != null) {
            }
            i = J0((Fragment)next);
        }
        return i3;
    }

    public int p0() {
        int size;
        ArrayList list = this.d;
        if (list != null) {
            size = list.size();
        } else {
            size = 0;
        }
        return size;
    }

    void p1(androidx.fragment.app.Fragment fragment, boolean z2) {
        boolean z;
        int obj3;
        final ViewGroup obj2 = s0(fragment);
        if (obj2 != null && obj2 instanceof h) {
            if (obj2 instanceof h) {
                (h)obj2.setDrawDisappearingViewsLast(z2 ^= 1);
            }
        }
    }

    void q1(androidx.fragment.app.Fragment fragment, j.c j$c2) {
        Object mFragmentManager;
        if (!fragment.equals(i0(fragment.mWho))) {
        } else {
            if (fragment.mHost != null) {
                if (fragment.mFragmentManager != this) {
                } else {
                }
            }
            fragment.mMaxState = c2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(fragment);
        stringBuilder.append(" is not an active fragment of FragmentManager ");
        stringBuilder.append(this);
        IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString());
        throw obj4;
    }

    androidx.fragment.app.g r0() {
        return this.s;
    }

    void r1(androidx.fragment.app.Fragment fragment) {
        boolean mFragmentManager;
        if (fragment != null) {
            if (!fragment.equals(i0(fragment.mWho))) {
            } else {
                if (fragment.mHost != null) {
                    if (fragment.mFragmentManager != this) {
                    } else {
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(fragment);
            stringBuilder.append(" is not an active fragment of FragmentManager ");
            stringBuilder.append(this);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        this.u = fragment;
        N(this.u);
        N(this.u);
    }

    public final void s(String string) {
        this.j.remove(string);
    }

    public androidx.fragment.app.j t0() {
        androidx.fragment.app.j jVar = this.v;
        if (jVar != null) {
            return jVar;
        }
        androidx.fragment.app.Fragment fragment = this.t;
        if (fragment != null) {
            return fragment.mFragmentManager.t0();
        }
        return this.w;
    }

    void t1(androidx.fragment.app.Fragment fragment) {
        boolean string;
        boolean mHidden;
        String str;
        if (n.I0(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("show: ");
            stringBuilder.append(fragment);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = mHiddenChanged ^= 1;
        }
    }

    public String toString() {
        String hexString;
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        androidx.fragment.app.Fragment fragment = this.t;
        final String str4 = "}";
        final String str5 = "{";
        if (fragment != null) {
            stringBuilder.append(fragment.getClass().getSimpleName());
            stringBuilder.append(str5);
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this.t)));
            stringBuilder.append(str4);
        } else {
            androidx.fragment.app.k kVar = this.r;
            if (kVar != null) {
                stringBuilder.append(kVar.getClass().getSimpleName());
                stringBuilder.append(str5);
                stringBuilder.append(Integer.toHexString(System.identityHashCode(this.r)));
                stringBuilder.append(str4);
            } else {
                stringBuilder.append("null");
            }
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    androidx.fragment.app.v u0() {
        return this.c;
    }

    void v(androidx.fragment.app.a a, boolean z2, boolean z3, boolean z4) {
        Context mPostponedAlpha;
        androidx.fragment.app.g gVar2;
        ArrayList arrayList;
        int i;
        int i3;
        int i2;
        androidx.fragment.app.x.g gVar;
        Boolean obj11;
        Object obj12;
        if (z2) {
            a.z(z4);
        } else {
            a.y();
        }
        final int i5 = 1;
        arrayList = new ArrayList(i5);
        ArrayList arrayList2 = new ArrayList(i5);
        arrayList.add(a);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3 != null && this.q >= i5) {
            if (this.q >= i5) {
                x.C(this.r.f(), this.s, arrayList, arrayList2, 0, 1, true, this.n);
            }
        }
        if (z4) {
            T0(this.q, i5);
        }
        obj11 = this.c.l().iterator();
        while (obj11.hasNext()) {
            obj12 = obj11.next();
            mPostponedAlpha = obj12.mPostponedAlpha;
            gVar2 = null;
            if ((Fragment)obj12 != null && obj12.mView != null && obj12.mIsNewlyAdded != null && a.B(obj12.mContainerId) != null && Float.compare(mPostponedAlpha, gVar2) > 0) {
            }
            if (obj12.mView != null) {
            }
            if (obj12.mIsNewlyAdded != null) {
            }
            if (a.B(obj12.mContainerId) != null) {
            }
            mPostponedAlpha = obj12.mPostponedAlpha;
            gVar2 = null;
            if (Float.compare(mPostponedAlpha, gVar2) > 0) {
            }
            if (z4) {
            } else {
            }
            obj12.mPostponedAlpha = -1082130432;
            obj12.mIsNewlyAdded = null;
            obj12.mPostponedAlpha = gVar2;
            obj12.mView.setAlpha(mPostponedAlpha);
        }
    }

    public List<androidx.fragment.app.Fragment> v0() {
        return this.c.n();
    }

    androidx.fragment.app.k<?> w0() {
        return this.r;
    }

    androidx.fragment.app.u x(androidx.fragment.app.Fragment fragment) {
        androidx.fragment.app.u uVar = this.c.m(fragment.mWho);
        if (uVar != null) {
            return uVar;
        }
        u uVar2 = new u(this.o, this.c, fragment);
        uVar2.o(this.r.f().getClassLoader());
        uVar2.t(this.q);
        return uVar2;
    }

    LayoutInflater.Factory2 x0() {
        return this.f;
    }

    androidx.fragment.app.m y0() {
        return this.o;
    }

    void z(androidx.fragment.app.Fragment fragment) {
        boolean string;
        int i;
        boolean string2;
        boolean mDetached;
        String mAdded;
        i = 2;
        final String str = "FragmentManager";
        if (n.I0(i)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("detach: ");
            stringBuilder2.append(fragment);
            Log.v(str, stringBuilder2.toString());
        }
        mDetached = 1;
        fragment.mDetached = mDetached;
        if (!fragment.mDetached && fragment.mAdded && n.I0(i)) {
            mDetached = 1;
            fragment.mDetached = mDetached;
            if (fragment.mAdded) {
                if (n.I0(i)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("remove from detach: ");
                    stringBuilder.append(fragment);
                    Log.v(str, stringBuilder.toString());
                }
                this.c.s(fragment);
                if (J0(fragment)) {
                    this.D = mDetached;
                }
                s1(fragment);
            }
        }
    }

    androidx.fragment.app.Fragment z0() {
        return this.t;
    }
}
