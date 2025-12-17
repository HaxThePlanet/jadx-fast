package androidx.fragment.app;

import android.app.Activity;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.j.c;
import androidx.lifecycle.x;
import d.h.l.u;
import d.m.b;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class u {

    private final androidx.fragment.app.m a;
    private final androidx.fragment.app.v b;
    private final androidx.fragment.app.Fragment c;
    private boolean d = false;
    private int e = -1;

    class a implements View.OnAttachStateChangeListener {

        final View a;
        a(androidx.fragment.app.u u, View view2) {
            this.a = view2;
            super();
        }

        @Override // android.view.View$OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.a.removeOnAttachStateChangeListener(this);
            u.i0(this.a);
        }

        @Override // android.view.View$OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static class b {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            u.b.a = iArr;
            iArr[j.c.RESUMED.ordinal()] = 1;
            u.b.a[j.c.STARTED.ordinal()] = 2;
            u.b.a[j.c.CREATED.ordinal()] = 3;
            u.b.a[j.c.INITIALIZED.ordinal()] = 4;
        }
    }
    u(androidx.fragment.app.m m, androidx.fragment.app.v v2, androidx.fragment.app.Fragment fragment3) {
        super();
        int i = 0;
        int i2 = -1;
        this.a = m;
        this.b = v2;
        this.c = fragment3;
    }

    u(androidx.fragment.app.m m, androidx.fragment.app.v v2, androidx.fragment.app.Fragment fragment3, androidx.fragment.app.t t4) {
        Bundle obj3;
        String obj4;
        super();
        final int i = 0;
        final int i2 = -1;
        this.a = m;
        this.b = v2;
        this.c = fragment3;
        obj3 = 0;
        fragment3.mSavedViewState = obj3;
        fragment3.mSavedViewRegistryState = obj3;
        fragment3.mBackStackNesting = i;
        fragment3.mInLayout = i;
        fragment3.mAdded = i;
        obj4 = fragment3.mTarget;
        obj4 = obj4 != null ? obj4.mWho : obj3;
        fragment3.mTargetWho = obj4;
        fragment3.mTarget = obj3;
        obj3 = t4.E;
        if (obj3 != null) {
            fragment3.mSavedFragmentState = obj3;
        } else {
            obj3 = new Bundle();
            fragment3.mSavedFragmentState = obj3;
        }
    }

    u(androidx.fragment.app.m m, androidx.fragment.app.v v2, java.lang.ClassLoader classLoader3, androidx.fragment.app.j j4, androidx.fragment.app.t t5) {
        Object obj2;
        Bundle obj3;
        int obj4;
        super();
        int i = 0;
        int i2 = -1;
        this.a = m;
        this.b = v2;
        obj2 = j4.a(classLoader3, t5.a);
        this.c = obj2;
        obj3 = t5.B;
        if (obj3 != null) {
            obj3.setClassLoader(classLoader3);
        }
        obj2.setArguments(t5.B);
        obj2.mWho = t5.b;
        obj2.mFromLayout = t5.c;
        obj2.mRestored = true;
        obj2.mFragmentId = t5.v;
        obj2.mContainerId = t5.w;
        obj2.mTag = t5.x;
        obj2.mRetainInstance = t5.y;
        obj2.mRemoving = t5.z;
        obj2.mDetached = t5.A;
        obj2.mHidden = t5.C;
        obj2.mMaxState = j.c.values()[t5.D];
        obj3 = t5.E;
        if (obj3 != null) {
            obj2.mSavedFragmentState = obj3;
        } else {
            obj3 = new Bundle();
            obj2.mSavedFragmentState = obj3;
        }
        if (n.I0(2)) {
            obj3 = new StringBuilder();
            obj3.append("Instantiated fragment ");
            obj3.append(obj2);
            Log.v("FragmentManager", obj3.toString());
        }
    }

    private boolean l(View view) {
        View mView;
        ViewParent obj3;
        final int i = 1;
        if (view == fragment.mView) {
            return i;
        }
        obj3 = view.getParent();
        while (obj3 != null) {
            obj3 = obj3.getParent();
        }
        return 0;
    }

    private Bundle q() {
        Bundle bundle;
        SparseArray mSavedViewState;
        Bundle mSavedViewRegistryState;
        boolean mUserVisibleHint;
        Object str;
        bundle = new Bundle();
        this.c.performSaveInstanceState(bundle);
        this.a.j(this.c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = 0;
        }
        if (fragment2.mView != null) {
            s();
        }
        if (fragment3.mSavedViewState != null && bundle == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment4.mSavedViewState);
        }
        if (fragment5.mSavedViewRegistryState != null && bundle == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", fragment6.mSavedViewRegistryState);
        }
        if (!fragment7.mUserVisibleHint && bundle == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment8.mUserVisibleHint);
        }
        return bundle;
    }

    void a() {
        boolean string;
        String str;
        if (n.I0(3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("moveto ACTIVITY_CREATED: ");
            stringBuilder.append(this.c);
            Log.d("FragmentManager", stringBuilder.toString());
        }
        androidx.fragment.app.Fragment fragment = this.c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        androidx.fragment.app.Fragment fragment2 = this.c;
        this.a.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    void b() {
        androidx.fragment.app.Fragment fragment2 = this.c;
        fragment2.mContainer.addView(fragment2.mView, this.b.j(this.c));
    }

    void c() {
        boolean string;
        Object mTargetWho;
        String str;
        Object mTarget;
        String mWho;
        androidx.fragment.app.u i;
        if (n.I0(3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("moveto ATTACHED: ");
            stringBuilder.append(this.c);
            Log.d("FragmentManager", stringBuilder.toString());
        }
        androidx.fragment.app.Fragment fragment = this.c;
        mTarget = fragment.mTarget;
        mWho = " that does not belong to this FragmentManager!";
        String str3 = " declared target fragment ";
        String str4 = "Fragment ";
        if (mTarget != null) {
            mTargetWho = this.b.m(mTarget.mWho);
            if (mTargetWho == null) {
            } else {
                mTarget = this.c;
                mTarget.mTargetWho = mTarget2.mWho;
                mTarget.mTarget = 0;
                i = mTargetWho;
                if (i != null) {
                    if (!n.P) {
                        if (fragment2.mState < 1) {
                            i.m();
                        }
                    } else {
                    }
                }
                androidx.fragment.app.Fragment fragment3 = this.c;
                fragment3.mHost = fragment3.mFragmentManager.w0();
                androidx.fragment.app.Fragment fragment4 = this.c;
                fragment4.mParentFragment = fragment4.mFragmentManager.z0();
                int i3 = 0;
                this.a.g(this.c, i3);
                this.c.performAttach();
                this.a.b(this.c, i3);
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str4);
            stringBuilder2.append(this.c);
            stringBuilder2.append(str3);
            stringBuilder2.append(fragment10.mTarget);
            stringBuilder2.append(mWho);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder2.toString());
            throw illegalStateException;
        }
        mTargetWho = fragment.mTargetWho;
        if (mTargetWho != null) {
            if (this.b.m(mTargetWho) == null) {
            } else {
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str4);
            stringBuilder3.append(this.c);
            stringBuilder3.append(str3);
            stringBuilder3.append(fragment11.mTargetWho);
            stringBuilder3.append(mWho);
            IllegalStateException illegalStateException2 = new IllegalStateException(stringBuilder3.toString());
            throw illegalStateException2;
        }
    }

    int d() {
        int i;
        androidx.fragment.app.Fragment mState2;
        int inBackStack;
        androidx.fragment.app.Fragment mState;
        boolean string;
        int i2;
        boolean mDeferStart;
        boolean mRemoving;
        boolean mFromLayout;
        boolean z;
        androidx.fragment.app.c0.e.b rEMOVING;
        ViewGroup mContainer;
        androidx.fragment.app.Fragment fragment = this.c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        i2 = this.e;
        i = u.b.a[fragment.mMaxState.ordinal()];
        int i4 = -1;
        final int i5 = 5;
        mRemoving = 3;
        final int i6 = 4;
        final int i7 = 2;
        final int i8 = 1;
        if (i != i8) {
            if (i != i7) {
                if (i != mRemoving) {
                    if (i != i6) {
                        i2 = Math.min(i2, i4);
                    } else {
                        i2 = Math.min(i2, 0);
                    }
                } else {
                    i2 = Math.min(i2, i8);
                }
            } else {
                i2 = Math.min(i2, i5);
            }
        }
        mState2 = this.c;
        if (mState2.mFromLayout) {
            if (mState2.mInLayout) {
                mState2 = fragment3.mView;
                if (mState2 != null && mState2.getParent() == null) {
                    if (mState2.getParent() == null) {
                        i2 = Math.min(Math.max(this.e, i7), i7);
                    }
                }
            } else {
                if (this.e < i6) {
                    i2 = Math.min(i2, mState2.mState);
                } else {
                    i2 = Math.min(i2, i8);
                }
            }
        }
        if (!fragment2.mAdded) {
            i2 = Math.min(i2, i8);
        }
        inBackStack = 0;
        z = this.c;
        mContainer = z.mContainer;
        if (n.P && mContainer != null) {
            z = this.c;
            mContainer = z.mContainer;
            if (mContainer != null) {
                inBackStack = c0.n(mContainer, z.getParentFragmentManager()).l(this);
            }
        }
        if (inBackStack == c0.e.b.ADDING) {
            i2 = Math.min(i2, 6);
        } else {
            if (inBackStack == c0.e.b.REMOVING) {
                i2 = Math.max(i2, mRemoving);
            } else {
                inBackStack = this.c;
                if (inBackStack.mRemoving) {
                    if (inBackStack.isInBackStack()) {
                        i2 = Math.min(i2, i8);
                    } else {
                        i2 = Math.min(i2, i4);
                    }
                }
            }
        }
        mState = this.c;
        if (mState.mDeferStart && mState.mState < i5) {
            if (mState.mState < i5) {
                i2 = Math.min(i2, i6);
            }
        }
        if (n.I0(i7)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("computeExpectedState() of ");
            stringBuilder.append(i2);
            stringBuilder.append(" for ");
            stringBuilder.append(this.c);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        return i2;
    }

    void e() {
        boolean string;
        Object mVar;
        String str;
        androidx.fragment.app.Fragment fragment;
        Bundle mSavedFragmentState;
        int i;
        if (n.I0(3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("moveto CREATED: ");
            stringBuilder.append(this.c);
            Log.d("FragmentManager", stringBuilder.toString());
        }
        androidx.fragment.app.Fragment fragment2 = this.c;
        if (!fragment2.mIsCreated) {
            i = 0;
            this.a.h(fragment2, fragment2.mSavedFragmentState, i);
            androidx.fragment.app.Fragment fragment3 = this.c;
            fragment3.performCreate(fragment3.mSavedFragmentState);
            fragment = this.c;
            this.a.c(fragment, fragment.mSavedFragmentState, i);
        } else {
            fragment2.restoreChildFragmentState(fragment2.mSavedFragmentState);
            mVar.mState = 1;
        }
    }

    void f() {
        boolean string;
        String resourceName;
        View mContainer;
        Object mView;
        View mView2;
        Object string2;
        String str;
        androidx.fragment.app.Fragment fragment;
        int stringBuilder;
        boolean mHidden;
        androidx.fragment.app.Fragment mContainerId2;
        int mContainerId;
        Bundle mSavedFragmentState;
        boolean z;
        Bundle mSavedFragmentState2;
        if (fragment2.mFromLayout) {
        }
        str = "FragmentManager";
        if (n.I0(3)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("moveto CREATE_VIEW: ");
            stringBuilder2.append(this.c);
            Log.d(str, stringBuilder2.toString());
        }
        androidx.fragment.app.Fragment fragment3 = this.c;
        stringBuilder = 0;
        mContainerId2 = this.c;
        mContainerId = mContainerId2.mContainer;
        if (mContainerId != null) {
            stringBuilder = mContainerId;
        } else {
            mContainerId = mContainerId2.mContainerId;
            if (mContainerId != 0) {
                if (mContainerId == -1) {
                } else {
                    if ((ViewGroup)mContainerId2.mFragmentManager.r0().c(fragment20.mContainerId) == null) {
                        mContainerId2 = this.c;
                        if (mContainerId2.mRestored) {
                        } else {
                            resourceName = mContainerId2.getResources().getResourceName(fragment15.mContainerId);
                        }
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("No view found for id 0x");
                        stringBuilder4.append(Integer.toHexString(fragment21.mContainerId));
                        stringBuilder4.append(" (");
                        stringBuilder4.append(resourceName);
                        stringBuilder4.append(") for fragment ");
                        stringBuilder4.append(this.c);
                        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder4.toString());
                        throw illegalArgumentException2;
                    }
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Cannot create fragment ");
                stringBuilder3.append(this.c);
                stringBuilder3.append(" for a container view with no id");
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder3.toString());
                throw illegalArgumentException;
            }
        }
        androidx.fragment.app.Fragment fragment22 = this.c;
        fragment22.mContainer = stringBuilder;
        fragment22.performCreateView(fragment3.performGetLayoutInflater(fragment3.mSavedFragmentState), stringBuilder, fragment22.mSavedFragmentState);
        mContainer = fragment5.mView;
        int i3 = 2;
        mSavedFragmentState = 0;
        mContainer.setSaveFromParentEnabled(mSavedFragmentState);
        androidx.fragment.app.Fragment fragment7 = this.c;
        fragment7.mView.setTag(b.a, fragment7);
        if (mContainer != null && stringBuilder != null) {
            mSavedFragmentState = 0;
            mContainer.setSaveFromParentEnabled(mSavedFragmentState);
            fragment7 = this.c;
            fragment7.mView.setTag(b.a, fragment7);
            if (stringBuilder != null) {
                b();
            }
            mView = this.c;
            if (mView.mHidden) {
                mView.mView.setVisibility(8);
            }
            if (u.Q(fragment8.mView)) {
                u.i0(fragment10.mView);
            } else {
                mView2 = fragment9.mView;
                mHidden = new u.a(this, mView2);
                mView2.addOnAttachStateChangeListener(mHidden);
            }
            this.c.performViewCreated();
            androidx.fragment.app.Fragment fragment17 = this.c;
            this.a.m(fragment17, fragment17.mView, fragment17.mSavedFragmentState, mSavedFragmentState);
            mContainer = fragment12.mView.getVisibility();
            if (n.P) {
                this.c.setPostOnViewCreatedAlpha(fragment18.mView.getAlpha());
                stringBuilder = this.c;
                string2 = stringBuilder.mView.findFocus();
                this.c.setFocusedView(string2);
                if (stringBuilder.mContainer != null && mContainer == 0 && string2 != null && n.I0(i3)) {
                    if (mContainer == 0) {
                        string2 = stringBuilder.mView.findFocus();
                        if (string2 != null) {
                            this.c.setFocusedView(string2);
                            if (n.I0(i3)) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("requestFocus: Saved focused view ");
                                stringBuilder.append(string2);
                                stringBuilder.append(" for Fragment ");
                                stringBuilder.append(this.c);
                                Log.v(str, stringBuilder.toString());
                            }
                        }
                        fragment14.mView.setAlpha(0);
                    }
                }
            } else {
                str = this.c;
                if (mContainer == 0 && str.mContainer != null) {
                    if (str.mContainer != null) {
                        mSavedFragmentState = 1;
                    }
                }
                str.mIsNewlyAdded = mSavedFragmentState;
            }
        }
        fragment6.mState = i3;
    }

    void g() {
        boolean string;
        int i;
        Object mTargetWho;
        Object vVar;
        androidx.fragment.app.Fragment inBackStack;
        String str;
        int mRetainInstance;
        androidx.fragment.app.k changingConfigurations;
        androidx.fragment.app.Fragment next;
        boolean mRemoving;
        int equals;
        int mTargetWho2;
        androidx.fragment.app.Fragment fragment;
        if (n.I0(3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("movefrom CREATED: ");
            stringBuilder.append(this.c);
            Log.d("FragmentManager", stringBuilder.toString());
        }
        inBackStack = this.c;
        equals = 1;
        mTargetWho2 = 0;
        if (inBackStack.mRemoving && !inBackStack.isInBackStack()) {
            i = !inBackStack.isInBackStack() ? equals : mTargetWho2;
        } else {
        }
        if (i == 0) {
            if (this.b.o().r(this.c)) {
                mRetainInstance = equals;
            } else {
                mRetainInstance = mTargetWho2;
            }
        } else {
        }
        if (mRetainInstance != null) {
            changingConfigurations = fragment5.mHost;
            if (changingConfigurations instanceof j0) {
                equals = this.b.o().o();
            } else {
                if (context2 instanceof Activity != null) {
                    equals ^= changingConfigurations;
                }
            }
            if (i == 0) {
                if (equals != 0) {
                    this.b.o().i(this.c);
                }
            } else {
            }
            this.c.performDestroy();
            this.a.d(this.c, mTargetWho2);
            Iterator iterator = this.b.k().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                next = (u)next.k();
                if (next != null && fragment7.mWho.equals(next.mTargetWho) != 0) {
                }
                next = next.k();
                if (fragment7.mWho.equals(next.mTargetWho) != 0) {
                }
                next.mTarget = this.c;
                next.mTargetWho = 0;
            }
            androidx.fragment.app.Fragment fragment3 = this.c;
            mRetainInstance = fragment3.mTargetWho;
            if (mRetainInstance != null) {
                fragment3.mTarget = this.b.f(mRetainInstance);
            }
            this.b.q(this);
        } else {
            mTargetWho = fragment4.mTargetWho;
            mTargetWho = this.b.f(mTargetWho);
            if (mTargetWho != null && mTargetWho != null && mTargetWho.mRetainInstance != null) {
                mTargetWho = this.b.f(mTargetWho);
                if (mTargetWho != null) {
                    if (mTargetWho.mRetainInstance != null) {
                        mRetainInstance.mTarget = mTargetWho;
                    }
                }
            }
            vVar.mState = mTargetWho2;
        }
    }

    void h() {
        boolean string;
        Object mView;
        String str;
        if (n.I0(3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("movefrom CREATE_VIEW: ");
            stringBuilder.append(this.c);
            Log.d("FragmentManager", stringBuilder.toString());
        }
        mView = this.c;
        ViewGroup mContainer = mView.mContainer;
        mView = mView.mView;
        if (mContainer != null && mView != null) {
            mView = mView.mView;
            if (mView != null) {
                mContainer.removeView(mView);
            }
        }
        this.c.performDestroyView();
        final int i3 = 0;
        this.a.n(this.c, i3);
        androidx.fragment.app.Fragment fragment2 = this.c;
        int i2 = 0;
        fragment2.mContainer = i2;
        fragment2.mView = i2;
        fragment2.mViewLifecycleOwner = i2;
        fragment2.mViewLifecycleOwnerLiveData.setValue(i2);
        fragment3.mInLayout = i3;
    }

    void i() {
        boolean string2;
        androidx.fragment.app.Fragment i;
        boolean string;
        androidx.fragment.app.Fragment inBackStack;
        androidx.fragment.app.Fragment fragment;
        boolean mRemoving;
        int i2;
        i = 3;
        final String str2 = "FragmentManager";
        if (n.I0(i)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("movefrom ATTACHED: ");
            stringBuilder2.append(this.c);
            Log.d(str2, stringBuilder2.toString());
        }
        this.c.performDetach();
        this.a.e(this.c, false);
        inBackStack = this.c;
        inBackStack.mState = -1;
        int i4 = 0;
        inBackStack.mHost = i4;
        inBackStack.mParentFragment = i4;
        inBackStack.mFragmentManager = i4;
        if (inBackStack.mRemoving && !inBackStack.isInBackStack()) {
            if (!inBackStack.isInBackStack()) {
                i2 = 1;
            }
        }
        if (i2 == 0) {
            if (this.b.o().r(this.c) && n.I0(i)) {
                if (n.I0(i)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("initState called for fragment: ");
                    stringBuilder.append(this.c);
                    Log.d(str2, stringBuilder.toString());
                }
                this.c.initState();
            }
        } else {
        }
    }

    void j() {
        androidx.fragment.app.Fragment mPerformedCreateView;
        boolean string;
        Object mView;
        boolean getLayoutInflater;
        int i;
        boolean mHidden;
        Object mSavedFragmentState;
        Bundle mSavedFragmentState2;
        mPerformedCreateView = this.c;
        if (mPerformedCreateView.mFromLayout && mPerformedCreateView.mInLayout && mPerformedCreateView.mPerformedCreateView == null && n.I0(3)) {
            if (mPerformedCreateView.mInLayout) {
                if (mPerformedCreateView.mPerformedCreateView == null) {
                    if (n.I0(3)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("moveto CREATE_VIEW: ");
                        stringBuilder.append(this.c);
                        Log.d("FragmentManager", stringBuilder.toString());
                    }
                    androidx.fragment.app.Fragment fragment = this.c;
                    fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), 0, fragment6.mSavedFragmentState);
                    mPerformedCreateView = fragment2.mView;
                    int i3 = 0;
                    mPerformedCreateView.setSaveFromParentEnabled(i3);
                    androidx.fragment.app.Fragment fragment3 = this.c;
                    fragment3.mView.setTag(b.a, fragment3);
                    mView = this.c;
                    if (mPerformedCreateView != null && mView.mHidden) {
                        i3 = 0;
                        mPerformedCreateView.setSaveFromParentEnabled(i3);
                        fragment3 = this.c;
                        fragment3.mView.setTag(b.a, fragment3);
                        mView = this.c;
                        if (mView.mHidden) {
                            mView.mView.setVisibility(8);
                        }
                        this.c.performViewCreated();
                        i = this.c;
                        this.a.m(i, i.mView, i.mSavedFragmentState, i3);
                        mPerformedCreateView.mState = 2;
                    }
                }
            }
        }
    }

    androidx.fragment.app.Fragment k() {
        return this.c;
    }

    void m() {
        boolean string2;
        Object mContainer2;
        boolean mHiddenChanged;
        int mHidden;
        int i;
        Object mContainer3;
        androidx.fragment.app.Fragment from;
        boolean string;
        Object mSavedViewState;
        Object fragment;
        int mContainer;
        String str = "FragmentManager";
        mHidden = 2;
        if (this.d && n.I0(mHidden)) {
            if (n.I0(mHidden)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Ignoring re-entrant call to moveToExpectedState() for ");
                stringBuilder.append(k());
                Log.v(str, stringBuilder.toString());
            }
        }
        int i2 = 0;
        final int i3 = 1;
        this.d = i3;
        i = d();
        from = this.c;
        int mState = from.mState;
        while (i != mState) {
            if (i > mState) {
            } else {
            }
            i = d();
            from = this.c;
            mState = from.mState;
            n();
            from.mState = 5;
            v();
            i = 3;
            if (n.I0(i)) {
            }
            mSavedViewState = this.c;
            if (mSavedViewState.mView != null && mSavedViewState.mSavedViewState == null) {
            }
            fragment = this.c;
            mContainer = fragment.mContainer;
            if (fragment.mView != null && mContainer != null) {
            }
            from.mState = i;
            mContainer = fragment.mContainer;
            if (mContainer != null) {
            }
            c0.n(mContainer, fragment.getParentFragmentManager()).d(this);
            if (mSavedViewState.mSavedViewState == null) {
            }
            s();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("movefrom ACTIVITY_CREATED: ");
            stringBuilder2.append(this.c);
            Log.d(str, stringBuilder2.toString());
            from.mInLayout = i2;
            from.mState = mHidden;
            h();
            i.mState = i3;
            g();
            i();
            p();
            from.mState = 6;
            u();
            mContainer3 = from.mContainer;
            if (from.mView != null && mContainer3 != null) {
            }
            i.mState = 4;
            mContainer3 = from.mContainer;
            if (mContainer3 != null) {
            }
            c0.n(mContainer3, from.getParentFragmentManager()).b(c0.e.c.from(fragment4.mView.getVisibility()), this);
            a();
            j();
            f();
            e();
            c();
        }
        mContainer2 = from.mContainer;
        if (n.P && from.mHiddenChanged && from.mView != null && mContainer2 != null) {
            if (from.mHiddenChanged) {
                try {
                    if (from.mView != null) {
                    }
                    mContainer2 = from.mContainer;
                    if (mContainer2 != null) {
                    }
                    mContainer2 = c0.n(mContainer2, from.getParentFragmentManager());
                    if (fragment3.mHidden) {
                    } else {
                    }
                    mContainer2.c(this);
                    mContainer2.e(this);
                    androidx.fragment.app.Fragment fragment2 = this.c;
                    androidx.fragment.app.n mFragmentManager = fragment2.mFragmentManager;
                    if (mFragmentManager != null) {
                    }
                    mFragmentManager.G0(fragment2);
                    mHiddenChanged = this.c;
                    mHiddenChanged.mHiddenChanged = i2;
                    mHiddenChanged.onHiddenChanged(mHiddenChanged.mHidden);
                    this.d = i2;
                    this.d = z;
                    throw th;
                    boolean z = z;
                    z = z[z];
                    while (!z) {
                    }
                    while (z < z) {
                    }
                    return z;
                    z = /* result */;
                    z = z;
                    z = z;
                    z = obj65535;
                    obj255 = 105;
                    z = ActivityManager.ProcessErrorStateInfo.condition;
                    z.condition = z;
                    z = z.condition;
                    return z;
                    z = /* result */;
                    z = z;
                    z = z;
                }
            }
        }
    }

    void n() {
        boolean string;
        String str;
        if (n.I0(3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("movefrom RESUMED: ");
            stringBuilder.append(this.c);
            Log.d("FragmentManager", stringBuilder.toString());
        }
        this.c.performPause();
        this.a.f(this.c, false);
    }

    void o(java.lang.ClassLoader classLoader) {
        String mTargetWho;
        boolean boolean;
        String str;
        String str2;
        androidx.fragment.app.Fragment obj4;
        Bundle mSavedFragmentState = fragment.mSavedFragmentState;
        if (mSavedFragmentState == null) {
        }
        mSavedFragmentState.setClassLoader(classLoader);
        obj4 = this.c;
        obj4.mSavedViewState = obj4.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        obj4 = this.c;
        obj4.mSavedViewRegistryState = obj4.mSavedFragmentState.getBundle("android:view_registry_state");
        obj4 = this.c;
        obj4.mTargetWho = obj4.mSavedFragmentState.getString("android:target_state");
        obj4 = this.c;
        if (obj4.mTargetWho != null) {
            obj4.mTargetRequestCode = obj4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        obj4 = this.c;
        Boolean mSavedUserVisibleHint = obj4.mSavedUserVisibleHint;
        int i = 1;
        if (mSavedUserVisibleHint != null) {
            obj4.mUserVisibleHint = mSavedUserVisibleHint.booleanValue();
            obj4.mSavedUserVisibleHint = 0;
        } else {
            obj4.mUserVisibleHint = obj4.mSavedFragmentState.getBoolean("android:user_visible_hint", i);
        }
        obj4 = this.c;
        if (!obj4.mUserVisibleHint) {
            obj4.mDeferStart = i;
        }
    }

    void p() {
        boolean string;
        String str;
        Object focusedView;
        androidx.fragment.app.Fragment requestFocus;
        boolean stringBuilder;
        String str2;
        String str6 = "FragmentManager";
        if (n.I0(3)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("moveto RESUMED: ");
            stringBuilder2.append(this.c);
            Log.d(str6, stringBuilder2.toString());
        }
        focusedView = this.c.getFocusedView();
        if (focusedView != null && l(focusedView) && n.I0(2)) {
            if (l(focusedView)) {
                if (n.I0(2)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("requestFocus: Restoring focused view ");
                    stringBuilder.append(focusedView);
                    stringBuilder.append(" ");
                    str = focusedView.requestFocus() ? "succeeded" : "failed";
                    stringBuilder.append(str);
                    stringBuilder.append(" on Fragment ");
                    stringBuilder.append(this.c);
                    stringBuilder.append(" resulting in focused view ");
                    stringBuilder.append(fragment3.mView.findFocus());
                    Log.v(str6, stringBuilder.toString());
                }
            }
        }
        int i2 = 0;
        this.c.setFocusedView(i2);
        this.c.performResume();
        this.a.i(this.c, false);
        androidx.fragment.app.Fragment fragment6 = this.c;
        fragment6.mSavedFragmentState = i2;
        fragment6.mSavedViewState = i2;
        fragment6.mSavedViewRegistryState = i2;
    }

    androidx.fragment.app.t r() {
        Bundle mSavedFragmentState;
        int mTargetWho;
        int str;
        t tVar = new t(this.c);
        androidx.fragment.app.Fragment fragment2 = this.c;
        if (fragment2.mState > -1 && tVar.E == null) {
            if (tVar.E == null) {
                mSavedFragmentState = q();
                tVar.E = mSavedFragmentState;
                if (fragment4.mTargetWho != null && mSavedFragmentState == null) {
                    if (mSavedFragmentState == null) {
                        mSavedFragmentState = new Bundle();
                        tVar.E = mSavedFragmentState;
                    }
                    tVar.E.putString("android:target_state", fragment5.mTargetWho);
                    mSavedFragmentState = fragment3.mTargetRequestCode;
                    if (mSavedFragmentState != 0) {
                        tVar.E.putInt("android:target_req_state", mSavedFragmentState);
                    }
                }
            } else {
                tVar.E = fragment2.mSavedFragmentState;
            }
        } else {
        }
        return tVar;
    }

    void s() {
        int size;
        boolean empty;
        if (fragment.mView == null) {
        }
        SparseArray sparseArray = new SparseArray();
        fragment2.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            size.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        fragment3.mViewLifecycleOwner.e(bundle);
        if (!bundle.isEmpty()) {
            empty.mSavedViewRegistryState = bundle;
        }
    }

    void t(int i) {
        this.e = i;
    }

    void u() {
        boolean string;
        String str;
        if (n.I0(3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("moveto STARTED: ");
            stringBuilder.append(this.c);
            Log.d("FragmentManager", stringBuilder.toString());
        }
        this.c.performStart();
        this.a.k(this.c, false);
    }

    void v() {
        boolean string;
        String str;
        if (n.I0(3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("movefrom STARTED: ");
            stringBuilder.append(this.c);
            Log.d("FragmentManager", stringBuilder.toString());
        }
        this.c.performStop();
        this.a.l(this.c, false);
    }
}
