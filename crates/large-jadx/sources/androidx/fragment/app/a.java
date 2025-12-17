package androidx.fragment.app;

import android.content.Context;
import android.util.Log;
import java.io.PrintWriter;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class a extends androidx.fragment.app.w implements androidx.fragment.app.n.k, androidx.fragment.app.n.p {

    final androidx.fragment.app.n r;
    boolean s;
    int t = -1;
    a(androidx.fragment.app.n n) {
        java.lang.ClassLoader classLoader;
        if (n.w0() != null) {
            classLoader = n.w0().f().getClassLoader();
        } else {
            classLoader = 0;
        }
        super(n.t0(), classLoader);
        int i = -1;
        this.r = n;
    }

    private static boolean D(androidx.fragment.app.w.a w$a) {
        boolean mDetached;
        androidx.fragment.app.Fragment obj1;
        obj1 = a.b;
        if (obj1 != null && obj1.mAdded && obj1.mView != null && !obj1.mDetached && !obj1.mHidden && obj1.isPostponed()) {
            if (obj1.mAdded) {
                if (obj1.mView != null) {
                    if (!obj1.mDetached) {
                        if (!obj1.mHidden) {
                            obj1 = obj1.isPostponed() ? 1 : 0;
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
        return obj1;
    }

    androidx.fragment.app.Fragment A(ArrayList<androidx.fragment.app.Fragment> arrayList, androidx.fragment.app.Fragment fragment2) {
        ArrayList list;
        androidx.fragment.app.Fragment fragment;
        int i3;
        Object obj;
        androidx.fragment.app.Fragment aVar2;
        int aVar;
        int i6;
        int mContainerId;
        int i;
        int i5;
        int i2;
        int i4;
        Object obj2;
        int mContainerId2;
        final Object obj3 = this;
        final Object obj4 = arrayList;
        fragment = fragment2;
        i3 = 0;
        while (i3 < obj3.a.size()) {
            obj = obj3.a.get(i3);
            aVar2 = obj.a;
            aVar = 0;
            i6 = 1;
            if (aVar2 != i6) {
            } else {
            }
            obj4.add(obj.b);
            i3 += i6;
            i = 3;
            i5 = 9;
            if (aVar2 != 2) {
            } else {
            }
            aVar2 = obj.b;
            size2 -= i6;
            i4 = 0;
            while (i2 >= 0) {
                obj2 = obj4.get(i2);
                if (obj2.mContainerId == aVar2.mContainerId) {
                }
                i2--;
                if ((Fragment)obj2 == aVar2) {
                } else {
                }
                if ((Fragment)obj2 == fragment) {
                }
                mContainerId2 = new w.a(i, (Fragment)obj2);
                mContainerId2.c = obj.c;
                mContainerId2.e = obj.e;
                mContainerId2.d = obj.d;
                mContainerId2.f = obj.f;
                obj3.a.add(i3, mContainerId2);
                obj4.remove(obj2);
                i3 += i6;
                mContainerId2 = new w.a(i5, obj2);
                obj3.a.add(i3, mContainerId2);
                i3++;
                fragment = aVar;
                i4 = i6;
            }
            if (i4 != 0) {
            } else {
            }
            obj.a = i6;
            obj4.add(aVar2);
            obj3.a.remove(i3);
            i3--;
            obj2 = obj4.get(i2);
            if (obj2.mContainerId == aVar2.mContainerId) {
            }
            i2--;
            if ((Fragment)obj2 == aVar2) {
            } else {
            }
            if ((Fragment)obj2 == fragment) {
            }
            mContainerId2 = new w.a(i, (Fragment)obj2);
            mContainerId2.c = obj.c;
            mContainerId2.e = obj.e;
            mContainerId2.d = obj.d;
            mContainerId2.f = obj.f;
            obj3.a.add(i3, mContainerId2);
            obj4.remove(obj2);
            i3 += i6;
            mContainerId2 = new w.a(i5, obj2);
            obj3.a.add(i3, mContainerId2);
            i3++;
            fragment = aVar;
            i4 = i6;
            if (aVar2 != i && aVar2 != 6) {
            } else {
            }
            obj4.remove(obj.b);
            obj = obj.b;
            if (obj == fragment) {
            }
            aVar2 = new w.a(i5, obj);
            obj3.a.add(i3, aVar2);
            i3++;
            fragment = aVar;
            if (aVar2 != 6) {
            } else {
            }
            if (aVar2 != 7) {
            } else {
            }
            if (aVar2 != 8) {
            } else {
            }
            aVar = new w.a(i5, fragment);
            obj3.a.add(i3, aVar);
            i3++;
            fragment = obj.b;
        }
        return fragment;
    }

    @Override // androidx.fragment.app.w
    boolean B(int i) {
        int i2;
        int mContainerId;
        final int i3 = 0;
        i2 = i3;
        while (i2 < this.a.size()) {
            androidx.fragment.app.Fragment fragment = obj.b;
            if (fragment != null) {
            } else {
            }
            mContainerId = i3;
            i2++;
            mContainerId = fragment.mContainerId;
        }
        return i3;
    }

    boolean C(ArrayList<androidx.fragment.app.a> arrayList, int i2, int i3) {
        int i4;
        int i6;
        int i5;
        int mContainerId;
        Object obj;
        int size;
        int i;
        int mContainerId2;
        final int i7 = 0;
        if (i3 == i2) {
            return i7;
        }
        i4 = -1;
        i5 = i7;
        while (i5 < this.a.size()) {
            androidx.fragment.app.Fragment fragment = obj2.b;
            if (fragment != null) {
            } else {
            }
            mContainerId = i7;
            if (mContainerId != 0) {
            } else {
            }
            i5++;
            if (mContainerId != i4) {
            } else {
            }
            i6 = i2;
            while (i6 < i3) {
                obj = arrayList.get(i6);
                i = i7;
                while (i < obj.a.size()) {
                    androidx.fragment.app.Fragment fragment2 = obj3.b;
                    if (fragment2 != null) {
                    } else {
                    }
                    mContainerId2 = i7;
                    i++;
                    mContainerId2 = fragment2.mContainerId;
                }
                i6++;
                fragment2 = obj3.b;
                if (fragment2 != null) {
                } else {
                }
                mContainerId2 = i7;
                i++;
                mContainerId2 = fragment2.mContainerId;
            }
            i4 = mContainerId;
            obj = arrayList.get(i6);
            i = i7;
            while (i < obj.a.size()) {
                fragment2 = obj3.b;
                if (fragment2 != null) {
                } else {
                }
                mContainerId2 = i7;
                i++;
                mContainerId2 = fragment2.mContainerId;
            }
            i6++;
            fragment2 = obj3.b;
            if (fragment2 != null) {
            } else {
            }
            mContainerId2 = i7;
            i++;
            mContainerId2 = fragment2.mContainerId;
            mContainerId = fragment.mContainerId;
        }
        return i7;
    }

    @Override // androidx.fragment.app.w
    boolean E() {
        int i;
        boolean z;
        int i2 = 0;
        i = i2;
        while (i < this.a.size()) {
            i++;
        }
        return i2;
    }

    @Override // androidx.fragment.app.w
    public void F() {
        ArrayList list;
        int i;
        int size;
        if (this.q != null) {
            i = 0;
            while (i < this.q.size()) {
                (Runnable)this.q.get(i).run();
                i++;
            }
            this.q = 0;
        }
    }

    @Override // androidx.fragment.app.w
    void G(androidx.fragment.app.Fragment.k fragment$k) {
        int i;
        Object obj;
        boolean z;
        i = 0;
        while (i < this.a.size()) {
            obj = this.a.get(i);
            if (a.D((w.a)obj)) {
            }
            i++;
            obj.b.setOnStartEnterTransitionListener(k);
        }
    }

    androidx.fragment.app.Fragment H(ArrayList<androidx.fragment.app.Fragment> arrayList, androidx.fragment.app.Fragment fragment2) {
        int i;
        androidx.fragment.app.Fragment fragment;
        int i3;
        int i2;
        androidx.fragment.app.Fragment obj7;
        final int i5 = 1;
        size -= i5;
        while (i >= 0) {
            fragment = this.a.get(i);
            i3 = fragment.a;
            if (i3 != i5) {
            } else {
            }
            arrayList.remove(fragment.b);
            i--;
            if (i3 != 3) {
            } else {
            }
            arrayList.add(fragment.b);
            fragment.h = fragment.g;
            obj7 = fragment.b;
            obj7 = 0;
        }
        return obj7;
    }

    public boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        boolean string;
        String str;
        boolean obj3;
        if (n.I0(2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Run: ");
            stringBuilder.append(this);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.g) {
            this.r.e(this);
        }
        return 1;
    }

    @Override // androidx.fragment.app.w
    public int g() {
        return v(false);
    }

    @Override // androidx.fragment.app.w
    public String getName() {
        return this.i;
    }

    @Override // androidx.fragment.app.w
    public int h() {
        return v(true);
    }

    @Override // androidx.fragment.app.w
    public void i() {
        k();
        this.r.d0(this, false);
    }

    @Override // androidx.fragment.app.w
    public void j() {
        k();
        this.r.d0(this, true);
    }

    @Override // androidx.fragment.app.w
    void l(int i, androidx.fragment.app.Fragment fragment2, String string3, int i4) {
        super.l(i, fragment2, string3, i4);
        fragment2.mFragmentManager = this.r;
    }

    @Override // androidx.fragment.app.w
    public androidx.fragment.app.w m(androidx.fragment.app.Fragment fragment) {
        androidx.fragment.app.n nVar;
        androidx.fragment.app.n mFragmentManager = fragment.mFragmentManager;
        if (mFragmentManager != null) {
            if (mFragmentManager != this.r) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot hide Fragment attached to a different FragmentManager. Fragment ");
            stringBuilder.append(fragment.toString());
            stringBuilder.append(" is already attached to a FragmentManager.");
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
        super.m(fragment);
        return this;
    }

    @Override // androidx.fragment.app.w
    public androidx.fragment.app.w n(androidx.fragment.app.Fragment fragment) {
        androidx.fragment.app.n nVar;
        androidx.fragment.app.n mFragmentManager = fragment.mFragmentManager;
        if (mFragmentManager != null) {
            if (mFragmentManager != this.r) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
            stringBuilder.append(fragment.toString());
            stringBuilder.append(" is already attached to a FragmentManager.");
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
        super.n(fragment);
        return this;
    }

    @Override // androidx.fragment.app.w
    public androidx.fragment.app.w t(androidx.fragment.app.Fragment fragment) {
        androidx.fragment.app.n nVar;
        androidx.fragment.app.n mFragmentManager = fragment.mFragmentManager;
        if (mFragmentManager != null) {
            if (mFragmentManager != this.r) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot show Fragment attached to a different FragmentManager. Fragment ");
            stringBuilder.append(fragment.toString());
            stringBuilder.append(" is already attached to a FragmentManager.");
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
        super.t(fragment);
        return this;
    }

    @Override // androidx.fragment.app.w
    public String toString() {
        int i;
        String str;
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.t >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.t);
        }
        if (this.i != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.i);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override // androidx.fragment.app.w
    void u(int i) {
        boolean string;
        String str2;
        int i2;
        Object string2;
        androidx.fragment.app.Fragment stringBuilder;
        int str;
        if (!this.g) {
        }
        int i3 = 2;
        final String str3 = "FragmentManager";
        if (n.I0(i3)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Bump nesting in ");
            stringBuilder2.append(this);
            stringBuilder2.append(" by ");
            stringBuilder2.append(i);
            Log.v(str3, stringBuilder2.toString());
        }
        i2 = 0;
        while (i2 < this.a.size()) {
            string2 = this.a.get(i2);
            stringBuilder = string2.b;
            stringBuilder.mBackStackNesting = mBackStackNesting2 += i;
            if (stringBuilder != null && n.I0(i3)) {
            }
            i2++;
            stringBuilder.mBackStackNesting = mBackStackNesting2 += i;
            if (n.I0(i3)) {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Bump nesting of ");
            stringBuilder.append(string2.b);
            stringBuilder.append(" to ");
            stringBuilder.append(fragment.mBackStackNesting);
            Log.v(str3, stringBuilder.toString());
        }
    }

    @Override // androidx.fragment.app.w
    int v(boolean z) {
        boolean str;
        int i;
        PrintWriter printWriter;
        if (this.s) {
        } else {
            if (n.I0(2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Commit: ");
                stringBuilder.append(this);
                String str4 = "FragmentManager";
                Log.v(str4, stringBuilder.toString());
                b0 b0Var = new b0(str4);
                printWriter = new PrintWriter(b0Var);
                w("  ", printWriter);
                printWriter.close();
            }
            this.s = true;
            if (this.g) {
                this.t = this.r.k();
            } else {
                this.t = -1;
            }
            this.r.a0(this, z);
            return this.t;
        }
        IllegalStateException obj3 = new IllegalStateException("commit already called");
        throw obj3;
    }

    @Override // androidx.fragment.app.w
    public void w(String string, PrintWriter printWriter2) {
        x(string, printWriter2, true);
    }

    @Override // androidx.fragment.app.w
    public void x(String string, PrintWriter printWriter2, boolean z3) {
        java.lang.CharSequence str2;
        boolean empty;
        int hexString4;
        String hexString2;
        String hexString;
        java.lang.CharSequence i2;
        int i;
        Object hexString5;
        androidx.fragment.app.Fragment str3;
        String string2;
        int hexString3;
        String str;
        printWriter2.print(string);
        printWriter2.print("mName=");
        printWriter2.print(this.i);
        printWriter2.print(" mIndex=");
        printWriter2.print(this.t);
        printWriter2.print(" mCommitted=");
        printWriter2.println(this.s);
        if (z3 && this.f != 0) {
            printWriter2.print(string);
            printWriter2.print("mName=");
            printWriter2.print(this.i);
            printWriter2.print(" mIndex=");
            printWriter2.print(this.t);
            printWriter2.print(" mCommitted=");
            printWriter2.println(this.s);
            if (this.f != 0) {
                printWriter2.print(string);
                printWriter2.print("mTransition=#");
                printWriter2.print(Integer.toHexString(this.f));
            }
            if (this.b == 0) {
                if (this.c != 0) {
                    printWriter2.print(string);
                    printWriter2.print("mEnterAnim=#");
                    printWriter2.print(Integer.toHexString(this.b));
                    printWriter2.print(" mExitAnim=#");
                    printWriter2.println(Integer.toHexString(this.c));
                }
            } else {
            }
            if (this.d == 0) {
                if (this.e != 0) {
                    printWriter2.print(string);
                    printWriter2.print("mPopEnterAnim=#");
                    printWriter2.print(Integer.toHexString(this.d));
                    printWriter2.print(" mPopExitAnim=#");
                    printWriter2.println(Integer.toHexString(this.e));
                }
            } else {
            }
            if (this.j == 0) {
                if (this.k != null) {
                    printWriter2.print(string);
                    printWriter2.print("mBreadCrumbTitleRes=#");
                    printWriter2.print(Integer.toHexString(this.j));
                    printWriter2.print(" mBreadCrumbTitleText=");
                    printWriter2.println(this.k);
                }
            } else {
            }
            if (this.l == 0) {
                if (this.m != null) {
                    printWriter2.print(string);
                    printWriter2.print("mBreadCrumbShortTitleRes=#");
                    printWriter2.print(Integer.toHexString(this.l));
                    printWriter2.print(" mBreadCrumbShortTitleText=");
                    printWriter2.println(this.m);
                }
            } else {
            }
        }
        if (!this.a.isEmpty()) {
            printWriter2.print(string);
            printWriter2.println("Operations:");
            i = 0;
            while (i < this.a.size()) {
                hexString5 = this.a.get(i);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("cmd=");
                stringBuilder.append(hexString5.a);
                string2 = stringBuilder.toString();
                printWriter2.print(string);
                printWriter2.print("  Op #");
                printWriter2.print(i);
                printWriter2.print(": ");
                printWriter2.print(string2);
                printWriter2.print(" ");
                printWriter2.println(hexString5.b);
                if (z3) {
                }
                i++;
                if (hexString5.c == 0) {
                } else {
                }
                printWriter2.print(string);
                printWriter2.print("enterAnim=#");
                printWriter2.print(Integer.toHexString(hexString5.c));
                printWriter2.print(" exitAnim=#");
                printWriter2.println(Integer.toHexString(hexString5.d));
                if (hexString5.e == 0) {
                } else {
                }
                printWriter2.print(string);
                printWriter2.print("popEnterAnim=#");
                printWriter2.print(Integer.toHexString(hexString5.e));
                printWriter2.print(" popExitAnim=#");
                printWriter2.println(Integer.toHexString(hexString5.f));
                if (hexString5.f != 0) {
                }
                if (hexString5.d != 0) {
                }
                string2 = "OP_SET_MAX_LIFECYCLE";
                string2 = "UNSET_PRIMARY_NAV";
                string2 = "SET_PRIMARY_NAV";
                string2 = "ATTACH";
                string2 = "DETACH";
                string2 = "SHOW";
                string2 = "HIDE";
                string2 = "REMOVE";
                string2 = "REPLACE";
                string2 = "ADD";
                string2 = "NULL";
            }
        }
    }

    @Override // androidx.fragment.app.w
    void y() {
        boolean z;
        int i2;
        int i3;
        int i;
        Object obj;
        androidx.fragment.app.Fragment fragment;
        boolean z2;
        androidx.fragment.app.n nVar;
        int i6;
        int i4;
        int i5;
        i2 = 0;
        i3 = i2;
        i = 1;
        while (i3 < this.a.size()) {
            obj = this.a.get(i3);
            fragment = obj.b;
            if (fragment != null) {
            }
            this.r.q1(fragment, obj.h);
            if (!this.p && obj.a != i && fragment != null && !n.P) {
            }
            i3++;
            i = 1;
            if (obj.a != i) {
            }
            if (fragment != null) {
            }
            if (!n.P) {
            }
            this.r.S0(fragment);
            this.r.r1(0);
            this.r.r1(fragment);
            fragment.setAnimations(obj.c, obj.d, obj.e, obj.f);
            this.r.p1(fragment, i2);
            this.r.m(fragment);
            fragment.setAnimations(obj.c, obj.d, obj.e, obj.f);
            this.r.z(fragment);
            fragment.setAnimations(obj.c, obj.d, obj.e, obj.f);
            this.r.p1(fragment, i2);
            this.r.t1(fragment);
            fragment.setAnimations(obj.c, obj.d, obj.e, obj.f);
            this.r.F0(fragment);
            fragment.setAnimations(obj.c, obj.d, obj.e, obj.f);
            this.r.h1(fragment);
            fragment.setAnimations(obj.c, obj.d, obj.e, obj.f);
            this.r.p1(fragment, i2);
            this.r.g(fragment);
            fragment.setPopDirection(i2);
            fragment.setNextTransition(this.f);
            fragment.setSharedElementNames(this.n, this.o);
        }
        if (!this.p && !n.P) {
            if (!n.P) {
                z = this.r;
                z.T0(z.q, i);
            }
        }
    }

    @Override // androidx.fragment.app.w
    void z(boolean z) {
        int i4;
        boolean z3;
        Object obj;
        androidx.fragment.app.Fragment fragment;
        boolean z2;
        androidx.fragment.app.n nVar;
        int i3;
        int i2;
        int i;
        boolean obj9;
        int i5 = 1;
        size -= i5;
        while (i4 >= 0) {
            obj = this.a.get(i4);
            fragment = obj.b;
            if (fragment != null) {
            }
            this.r.q1(fragment, obj.g);
            if (!this.p && obj.a != 3 && fragment != null && !n.P) {
            }
            i4--;
            if (obj.a != 3) {
            }
            if (fragment != null) {
            }
            if (!n.P) {
            }
            this.r.S0(fragment);
            this.r.r1(fragment);
            this.r.r1(0);
            fragment.setAnimations(obj.c, obj.d, obj.e, obj.f);
            this.r.p1(fragment, i5);
            this.r.z(fragment);
            fragment.setAnimations(obj.c, obj.d, obj.e, obj.f);
            this.r.m(fragment);
            fragment.setAnimations(obj.c, obj.d, obj.e, obj.f);
            this.r.p1(fragment, i5);
            this.r.F0(fragment);
            fragment.setAnimations(obj.c, obj.d, obj.e, obj.f);
            this.r.t1(fragment);
            fragment.setAnimations(obj.c, obj.d, obj.e, obj.f);
            this.r.g(fragment);
            fragment.setAnimations(obj.c, obj.d, obj.e, obj.f);
            this.r.p1(fragment, i5);
            this.r.h1(fragment);
            fragment.setPopDirection(i5);
            fragment.setNextTransition(n.m1(this.f));
            fragment.setSharedElementNames(this.o, this.n);
        }
        if (!this.p && z && !n.P) {
            if (z) {
                if (!n.P) {
                    obj9 = this.r;
                    obj9.T0(obj9.q, i5);
                }
            }
        }
    }
}
