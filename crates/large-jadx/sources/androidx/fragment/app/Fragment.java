package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.b;
import androidx.activity.result.c;
import androidx.activity.result.d;
import androidx.activity.result.f.a;
import androidx.core.app.b;
import androidx.core.app.p;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.d0;
import androidx.lifecycle.g0.b;
import androidx.lifecycle.i;
import androidx.lifecycle.i0;
import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import androidx.lifecycle.j.c;
import androidx.lifecycle.j0;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import androidx.lifecycle.n;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import androidx.lifecycle.x;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.b;
import androidx.savedstate.c;
import androidx.savedstate.d;
import d.b.a.c.a;
import d.h.l.g;
import d.p.a.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, q, j0, i, c {

    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = null;
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    androidx.fragment.app.Fragment.i mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    androidx.fragment.app.n mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    g0.b mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    androidx.fragment.app.n mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    androidx.fragment.app.k<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    s mLifecycleRegistry;
    j.c mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<androidx.fragment.app.Fragment.j> mOnPreAttachedListeners;
    androidx.fragment.app.Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    b mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    androidx.fragment.app.Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;
    androidx.fragment.app.a0 mViewLifecycleOwner;
    x<q> mViewLifecycleOwnerLiveData;
    String mWho;

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String string, Exception exception2) {
            super(string, exception2);
        }
    }

    class a implements Runnable {

        final androidx.fragment.app.Fragment a;
        a(androidx.fragment.app.Fragment fragment) {
            this.a = fragment;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.startPostponedEnterTransition();
        }
    }

    class b implements Runnable {

        final androidx.fragment.app.Fragment a;
        b(androidx.fragment.app.Fragment fragment) {
            this.a = fragment;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.callStartTransitionListener(false);
        }
    }

    class c implements Runnable {

        final androidx.fragment.app.c0 a;
        c(androidx.fragment.app.Fragment fragment, androidx.fragment.app.c0 c02) {
            this.a = c02;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.g();
        }
    }

    static class i {

        View a;
        Animator b;
        boolean c;
        int d;
        int e;
        int f;
        int g;
        int h;
        ArrayList<String> i;
        ArrayList<String> j;
        Object k = null;
        Object l;
        Object m = null;
        Object n;
        Object o = null;
        Object p;
        Boolean q;
        Boolean r;
        p s;
        p t;
        float u = 1f;
        View v = null;
        boolean w;
        androidx.fragment.app.Fragment.k x;
        boolean y;
        i() {
            super();
            final int i = 0;
            Object uSE_DEFAULT_TRANSITION = Fragment.USE_DEFAULT_TRANSITION;
            this.l = uSE_DEFAULT_TRANSITION;
            this.n = uSE_DEFAULT_TRANSITION;
            this.p = uSE_DEFAULT_TRANSITION;
            int i2 = 1065353216;
        }
    }

    private static abstract class j {
        j(androidx.fragment.app.Fragment.a fragment$a) {
            super();
        }

        abstract void a();
    }

    interface k {
        public abstract void a();

        public abstract void b();
    }

    public static class l implements Parcelable {

        public static final Parcelable.Creator<androidx.fragment.app.Fragment.l> CREATOR;
        final Bundle a;
        static {
            Fragment.l.a aVar = new Fragment.l.a();
            Fragment.l.CREATOR = aVar;
        }

        l(Parcel parcel, java.lang.ClassLoader classLoader2) {
            super();
            final Bundle obj1 = parcel.readBundle();
            this.a = obj1;
            if (classLoader2 != null && obj1 != null) {
                if (obj1 != null) {
                    obj1.setClassLoader(classLoader2);
                }
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeBundle(this.a);
        }
    }

    class d extends androidx.fragment.app.g {

        final androidx.fragment.app.Fragment a;
        d(androidx.fragment.app.Fragment fragment) {
            this.a = fragment;
            super();
        }

        @Override // androidx.fragment.app.g
        public View c(int i) {
            View mView = fragment.mView;
            if (mView == null) {
            } else {
                return mView.findViewById(i);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(this.a);
            stringBuilder.append(" does not have a view");
            IllegalStateException obj3 = new IllegalStateException(stringBuilder.toString());
            throw obj3;
        }

        @Override // androidx.fragment.app.g
        public boolean d() {
            int i;
            i = fragment.mView != null ? 1 : 0;
            return i;
        }
    }

    class e implements a<Void, ActivityResultRegistry> {

        final androidx.fragment.app.Fragment a;
        e(androidx.fragment.app.Fragment fragment) {
            this.a = fragment;
            super();
        }

        @Override // d.b.a.c.a
        public ActivityResultRegistry a(Void void) {
            androidx.fragment.app.Fragment obj3 = this.a;
            final androidx.fragment.app.k mHost = obj3.mHost;
            if (mHost instanceof d) {
                return (d)mHost.getActivityResultRegistry();
            }
            return obj3.requireActivity().getActivityResultRegistry();
        }

        @Override // d.b.a.c.a
        public Object apply(Object object) {
            return a((Void)object);
        }
    }

    class f implements a<Void, ActivityResultRegistry> {

        final ActivityResultRegistry a;
        f(androidx.fragment.app.Fragment fragment, ActivityResultRegistry activityResultRegistry2) {
            this.a = activityResultRegistry2;
            super();
        }

        @Override // d.b.a.c.a
        public ActivityResultRegistry a(Void void) {
            return this.a;
        }

        @Override // d.b.a.c.a
        public Object apply(Object object) {
            return a((Void)object);
        }
    }

    class g extends androidx.fragment.app.Fragment.j {

        final a a;
        final AtomicReference b;
        final a c;
        final b d;
        final androidx.fragment.app.Fragment e;
        g(androidx.fragment.app.Fragment fragment, a a2, AtomicReference atomicReference3, a a4, b b5) {
            this.e = fragment;
            this.a = a2;
            this.b = atomicReference3;
            this.c = a4;
            this.d = b5;
            super(0);
        }

        @Override // androidx.fragment.app.Fragment$j
        void a() {
            this.b.set((ActivityResultRegistry)this.a.apply(0).j(this.e.generateActivityResultKey(), this.e, this.c, this.d));
        }
    }

    class h extends c<I> {

        final AtomicReference a;
        h(androidx.fragment.app.Fragment fragment, AtomicReference atomicReference2, a a3) {
            this.a = atomicReference2;
            super();
        }

        public void b(I i, b b2) {
            Object obj = this.a.get();
            if ((c)obj == null) {
            } else {
                (c)obj.b(i, b2);
            }
            IllegalStateException obj2 = new IllegalStateException("Operation cannot be started before fragment is in created state");
            throw obj2;
        }

        @Override // androidx.activity.result.c
        public void c() {
            Object andSet = this.a.getAndSet(0);
            if ((c)andSet != null) {
                (c)andSet.c();
            }
        }
    }
    static {
        Object object = new Object();
        Fragment.USE_DEFAULT_TRANSITION = object;
    }

    public Fragment() {
        super();
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        int i2 = 0;
        this.mTargetWho = i2;
        this.mIsPrimaryNavigationFragment = i2;
        o oVar = new o();
        this.mChildFragmentManager = oVar;
        int i3 = 1;
        this.mMenuVisible = i3;
        this.mUserVisibleHint = i3;
        Fragment.a aVar = new Fragment.a(this);
        this.mPostponedDurationRunnable = aVar;
        this.mMaxState = j.c.RESUMED;
        x xVar = new x();
        this.mViewLifecycleOwnerLiveData = xVar;
        AtomicInteger atomicInteger = new AtomicInteger();
        this.mNextLocalRequestCode = atomicInteger;
        ArrayList arrayList = new ArrayList();
        this.mOnPreAttachedListeners = arrayList;
        initLifecycle();
    }

    public Fragment(int i) {
        super();
        this.mContentLayoutId = i;
    }

    private androidx.fragment.app.Fragment.i ensureAnimationInfo() {
        androidx.fragment.app.Fragment.i mAnimationInfo;
        if (this.mAnimationInfo == null) {
            mAnimationInfo = new Fragment.i();
            this.mAnimationInfo = mAnimationInfo;
        }
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        Object mParentFragment;
        j.c mMaxState = this.mMaxState;
        if (mMaxState != j.c.INITIALIZED && this.mParentFragment == null) {
            if (this.mParentFragment == null) {
            }
            return Math.min(mMaxState.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
        }
        return mMaxState.ordinal();
    }

    private void initLifecycle() {
        s sVar = new s(this);
        this.mLifecycleRegistry = sVar;
        this.mSavedStateRegistryController = b.a(this);
        this.mDefaultFactory = 0;
    }

    @Deprecated
    public static androidx.fragment.app.Fragment instantiate(Context context, String string2) {
        return Fragment.instantiate(context, string2, 0);
    }

    @Deprecated
    public static androidx.fragment.app.Fragment instantiate(Context context, String string2, Bundle bundle3) {
        Object[] classLoader;
        final String str = ": make sure class name exists, is public, and has an empty constructor that is public";
        final String str2 = "Unable to instantiate fragment ";
        int i = 0;
        Object obj4 = j.d(context.getClassLoader(), string2).getConstructor(new Class[i]).newInstance(new Object[i]);
        if (bundle3 != null) {
            bundle3.setClassLoader((Fragment)obj4.getClass().getClassLoader());
            obj4.setArguments(bundle3);
        }
        return obj4;
    }

    private <I, O> c<I> prepareCallInternal(a<I, O> a, a<Void, ActivityResultRegistry> a2, b<O> b3) {
        if (this.mState > 1) {
        } else {
            AtomicReference atomicReference = new AtomicReference();
            super(this, a2, atomicReference, a, b3);
            registerOnPreAttachListener(gVar);
            Fragment.h obj10 = new Fragment.h(this, atomicReference, a);
            return obj10;
        }
        obj10 = new StringBuilder();
        obj10.append("Fragment ");
        obj10.append(this);
        obj10.append(" is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
        IllegalStateException obj9 = new IllegalStateException(obj10.toString());
        throw obj9;
    }

    private void registerOnPreAttachListener(androidx.fragment.app.Fragment.j fragment$j) {
        int mOnPreAttachedListeners;
        if (this.mState >= 0) {
            j.a();
        } else {
            this.mOnPreAttachedListeners.add(j);
        }
    }

    private void restoreViewState() {
        boolean string;
        Object mSavedFragmentState;
        String str;
        if (n.I0(3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("moveto RESTORE_VIEW_STATE: ");
            stringBuilder.append(this);
            Log.d("FragmentManager", stringBuilder.toString());
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = 0;
    }

    @Override // android.content.ComponentCallbacks
    void callStartTransitionListener(boolean z) {
        boolean mAnimationInfo;
        androidx.fragment.app.Fragment.k mFragmentManager;
        androidx.fragment.app.Fragment.k kVar;
        Handler obj4;
        mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
        } else {
            mAnimationInfo.w = false;
            mAnimationInfo.x = 0;
            mFragmentManager = kVar;
        }
        if (mFragmentManager != null) {
            mFragmentManager.b();
        } else {
            mAnimationInfo = this.mContainer;
            mFragmentManager = this.mFragmentManager;
            if (n.P && this.mView != null && mAnimationInfo != null && mFragmentManager != null) {
                if (this.mView != null) {
                    mAnimationInfo = this.mContainer;
                    if (mAnimationInfo != null) {
                        mFragmentManager = this.mFragmentManager;
                        if (mFragmentManager != null) {
                            mAnimationInfo = c0.n(mAnimationInfo, mFragmentManager);
                            mAnimationInfo.p();
                            if (z != null) {
                                mFragmentManager = new Fragment.c(this, mAnimationInfo);
                                this.mHost.g().post(mFragmentManager);
                            } else {
                                mAnimationInfo.g();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    androidx.fragment.app.g createFragmentContainer() {
        Fragment.d dVar = new Fragment.d(this);
        return dVar;
    }

    @Override // android.content.ComponentCallbacks
    public void dump(String string, FileDescriptor fileDescriptor2, PrintWriter printWriter3, String[] string4Arr4) {
        androidx.fragment.app.n mFragmentManager;
        androidx.fragment.app.k mHost;
        androidx.fragment.app.Fragment mParentFragment;
        Bundle mArguments;
        Bundle mSavedFragmentState;
        SparseArray mSavedViewState;
        Bundle mSavedViewRegistryState;
        androidx.fragment.app.Fragment mTargetRequestCode;
        int enterAnim;
        int exitAnim;
        int popEnterAnim;
        int popExitAnim;
        ViewGroup mContainer;
        View mView;
        View animatingAway;
        Object context;
        String str;
        printWriter3.print(string);
        printWriter3.print("mFragmentId=#");
        printWriter3.print(Integer.toHexString(this.mFragmentId));
        printWriter3.print(" mContainerId=#");
        printWriter3.print(Integer.toHexString(this.mContainerId));
        printWriter3.print(" mTag=");
        printWriter3.println(this.mTag);
        printWriter3.print(string);
        printWriter3.print("mState=");
        printWriter3.print(this.mState);
        printWriter3.print(" mWho=");
        printWriter3.print(this.mWho);
        printWriter3.print(" mBackStackNesting=");
        printWriter3.println(this.mBackStackNesting);
        printWriter3.print(string);
        printWriter3.print("mAdded=");
        printWriter3.print(this.mAdded);
        printWriter3.print(" mRemoving=");
        printWriter3.print(this.mRemoving);
        printWriter3.print(" mFromLayout=");
        printWriter3.print(this.mFromLayout);
        printWriter3.print(" mInLayout=");
        printWriter3.println(this.mInLayout);
        printWriter3.print(string);
        printWriter3.print("mHidden=");
        printWriter3.print(this.mHidden);
        printWriter3.print(" mDetached=");
        printWriter3.print(this.mDetached);
        printWriter3.print(" mMenuVisible=");
        printWriter3.print(this.mMenuVisible);
        printWriter3.print(" mHasMenu=");
        printWriter3.println(this.mHasMenu);
        printWriter3.print(string);
        printWriter3.print("mRetainInstance=");
        printWriter3.print(this.mRetainInstance);
        printWriter3.print(" mUserVisibleHint=");
        printWriter3.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter3.print(string);
            printWriter3.print("mFragmentManager=");
            printWriter3.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter3.print(string);
            printWriter3.print("mHost=");
            printWriter3.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter3.print(string);
            printWriter3.print("mParentFragment=");
            printWriter3.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter3.print(string);
            printWriter3.print("mArguments=");
            printWriter3.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter3.print(string);
            printWriter3.print("mSavedFragmentState=");
            printWriter3.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter3.print(string);
            printWriter3.print("mSavedViewState=");
            printWriter3.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter3.print(string);
            printWriter3.print("mSavedViewRegistryState=");
            printWriter3.println(this.mSavedViewRegistryState);
        }
        mTargetRequestCode = getTargetFragment();
        if (mTargetRequestCode != null) {
            printWriter3.print(string);
            printWriter3.print("mTarget=");
            printWriter3.print(mTargetRequestCode);
            printWriter3.print(" mTargetRequestCode=");
            printWriter3.println(this.mTargetRequestCode);
        }
        printWriter3.print(string);
        printWriter3.print("mPopDirection=");
        printWriter3.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter3.print(string);
            printWriter3.print("getEnterAnim=");
            printWriter3.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter3.print(string);
            printWriter3.print("getExitAnim=");
            printWriter3.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter3.print(string);
            printWriter3.print("getPopEnterAnim=");
            printWriter3.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter3.print(string);
            printWriter3.print("getPopExitAnim=");
            printWriter3.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter3.print(string);
            printWriter3.print("mContainer=");
            printWriter3.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter3.print(string);
            printWriter3.print("mView=");
            printWriter3.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter3.print(string);
            printWriter3.print("mAnimatingAway=");
            printWriter3.println(getAnimatingAway());
        }
        if (getContext() != null) {
            a.b(this).a(string, fileDescriptor2, printWriter3, string4Arr4);
        }
        printWriter3.print(string);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Child ");
        stringBuilder.append(this.mChildFragmentManager);
        stringBuilder.append(":");
        printWriter3.println(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string);
        stringBuilder2.append("  ");
        this.mChildFragmentManager.Y(stringBuilder2.toString(), fileDescriptor2, printWriter3, string4Arr4);
    }

    @Override // android.content.ComponentCallbacks
    public final boolean equals(Object object) {
        return super.equals(object);
    }

    @Override // android.content.ComponentCallbacks
    androidx.fragment.app.Fragment findFragmentByWho(String string) {
        if (string.equals(this.mWho)) {
            return this;
        }
        return this.mChildFragmentManager.l0(string);
    }

    @Override // android.content.ComponentCallbacks
    String generateActivityResultKey() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fragment_");
        stringBuilder.append(this.mWho);
        stringBuilder.append("_rq#");
        stringBuilder.append(this.mNextLocalRequestCode.getAndIncrement());
        return stringBuilder.toString();
    }

    @Override // android.content.ComponentCallbacks
    public final androidx.fragment.app.e getActivity() {
        int i;
        androidx.fragment.app.k mHost = this.mHost;
        if (mHost == null) {
            i = 0;
        } else {
            i = mHost.e();
        }
        return i;
    }

    @Override // android.content.ComponentCallbacks
    public boolean getAllowEnterTransitionOverlap() {
        boolean booleanValue;
        Object mAnimationInfo;
        mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo != null) {
            mAnimationInfo = mAnimationInfo.r;
            if (mAnimationInfo == null) {
                booleanValue = 1;
            } else {
                booleanValue = mAnimationInfo.booleanValue();
            }
        } else {
        }
        return booleanValue;
    }

    @Override // android.content.ComponentCallbacks
    public boolean getAllowReturnTransitionOverlap() {
        boolean booleanValue;
        Object mAnimationInfo;
        mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo != null) {
            mAnimationInfo = mAnimationInfo.q;
            if (mAnimationInfo == null) {
                booleanValue = 1;
            } else {
                booleanValue = mAnimationInfo.booleanValue();
            }
        } else {
        }
        return booleanValue;
    }

    @Override // android.content.ComponentCallbacks
    View getAnimatingAway() {
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.a;
    }

    @Override // android.content.ComponentCallbacks
    Animator getAnimator() {
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.b;
    }

    @Override // android.content.ComponentCallbacks
    public final Bundle getArguments() {
        return this.mArguments;
    }

    @Override // android.content.ComponentCallbacks
    public final androidx.fragment.app.n getChildFragmentManager() {
        if (this.mHost == null) {
        } else {
            return this.mChildFragmentManager;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" has not been attached yet.");
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // android.content.ComponentCallbacks
    public Context getContext() {
        int i;
        androidx.fragment.app.k mHost = this.mHost;
        if (mHost == null) {
            i = 0;
        } else {
            i = mHost.f();
        }
        return i;
    }

    @Override // android.content.ComponentCallbacks
    public g0.b getDefaultViewModelProviderFactory() {
        g0.b mDefaultFactory;
        d0 d0Var;
        Context applicationContext;
        Bundle arguments;
        if (this.mFragmentManager == null) {
        } else {
            if (this.mDefaultFactory == null) {
                mDefaultFactory = 0;
                applicationContext = requireContext().getApplicationContext();
                while (applicationContext instanceof ContextWrapper) {
                    if (applicationContext instanceof Application) {
                        break;
                    } else {
                    }
                    applicationContext = (ContextWrapper)applicationContext.getBaseContext();
                }
                if (mDefaultFactory == null && n.I0(3)) {
                    if (n.I0(3)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Could not find Application instance from Context ");
                        stringBuilder.append(requireContext().getApplicationContext());
                        stringBuilder.append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
                        Log.d("FragmentManager", stringBuilder.toString());
                    }
                }
                d0Var = new d0(mDefaultFactory, this, getArguments());
                this.mDefaultFactory = d0Var;
            }
            return this.mDefaultFactory;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Can't access ViewModels from detached fragment");
        throw illegalStateException;
    }

    @Override // android.content.ComponentCallbacks
    int getEnterAnim() {
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 0;
        }
        return mAnimationInfo.d;
    }

    @Override // android.content.ComponentCallbacks
    public Object getEnterTransition() {
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.k;
    }

    @Override // android.content.ComponentCallbacks
    p getEnterTransitionCallback() {
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.s;
    }

    @Override // android.content.ComponentCallbacks
    int getExitAnim() {
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 0;
        }
        return mAnimationInfo.e;
    }

    @Override // android.content.ComponentCallbacks
    public Object getExitTransition() {
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.m;
    }

    @Override // android.content.ComponentCallbacks
    p getExitTransitionCallback() {
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.t;
    }

    @Override // android.content.ComponentCallbacks
    View getFocusedView() {
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.v;
    }

    @Deprecated
    public final androidx.fragment.app.n getFragmentManager() {
        return this.mFragmentManager;
    }

    @Override // android.content.ComponentCallbacks
    public final Object getHost() {
        int i;
        androidx.fragment.app.k mHost = this.mHost;
        if (mHost == null) {
            i = 0;
        } else {
            i = mHost.h();
        }
        return i;
    }

    @Override // android.content.ComponentCallbacks
    public final int getId() {
        return this.mFragmentId;
    }

    @Override // android.content.ComponentCallbacks
    public final LayoutInflater getLayoutInflater() {
        LayoutInflater getLayoutInflater;
        if (this.mLayoutInflater == null) {
            getLayoutInflater = performGetLayoutInflater(0);
        }
        return getLayoutInflater;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        androidx.fragment.app.k obj2 = this.mHost;
        if (obj2 == null) {
        } else {
            obj2 = obj2.i();
            g.b(obj2, this.mChildFragmentManager.x0());
            return obj2;
        }
        obj2 = new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        throw obj2;
    }

    @Override // android.content.ComponentCallbacks
    public j getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public a getLoaderManager() {
        return a.b(this);
    }

    @Override // android.content.ComponentCallbacks
    int getNextTransition() {
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 0;
        }
        return mAnimationInfo.h;
    }

    @Override // android.content.ComponentCallbacks
    public final androidx.fragment.app.Fragment getParentFragment() {
        return this.mParentFragment;
    }

    @Override // android.content.ComponentCallbacks
    public final androidx.fragment.app.n getParentFragmentManager() {
        androidx.fragment.app.n mFragmentManager = this.mFragmentManager;
        if (mFragmentManager == null) {
        } else {
            return mFragmentManager;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" not associated with a fragment manager.");
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // android.content.ComponentCallbacks
    boolean getPopDirection() {
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 0;
        }
        return mAnimationInfo.c;
    }

    @Override // android.content.ComponentCallbacks
    int getPopEnterAnim() {
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 0;
        }
        return mAnimationInfo.f;
    }

    @Override // android.content.ComponentCallbacks
    int getPopExitAnim() {
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 0;
        }
        return mAnimationInfo.g;
    }

    @Override // android.content.ComponentCallbacks
    float getPostOnViewCreatedAlpha() {
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 1065353216;
        }
        return mAnimationInfo.u;
    }

    @Override // android.content.ComponentCallbacks
    public Object getReenterTransition() {
        Object exitTransition;
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        if (mAnimationInfo.n == Fragment.USE_DEFAULT_TRANSITION) {
            exitTransition = getExitTransition();
        }
        return exitTransition;
    }

    @Override // android.content.ComponentCallbacks
    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    @Override // android.content.ComponentCallbacks
    public Object getReturnTransition() {
        Object enterTransition;
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        if (mAnimationInfo.l == Fragment.USE_DEFAULT_TRANSITION) {
            enterTransition = getEnterTransition();
        }
        return enterTransition;
    }

    @Override // android.content.ComponentCallbacks
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Override // android.content.ComponentCallbacks
    public Object getSharedElementEnterTransition() {
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.o;
    }

    @Override // android.content.ComponentCallbacks
    public Object getSharedElementReturnTransition() {
        Object sharedElementEnterTransition;
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        if (mAnimationInfo.p == Fragment.USE_DEFAULT_TRANSITION) {
            sharedElementEnterTransition = getSharedElementEnterTransition();
        }
        return sharedElementEnterTransition;
    }

    ArrayList<String> getSharedElementSourceNames() {
        Object mAnimationInfo;
        mAnimationInfo = this.mAnimationInfo;
        mAnimationInfo = mAnimationInfo.i;
        if (mAnimationInfo != null && mAnimationInfo == null) {
            mAnimationInfo = mAnimationInfo.i;
            if (mAnimationInfo == null) {
            }
            return mAnimationInfo;
        }
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

    ArrayList<String> getSharedElementTargetNames() {
        Object mAnimationInfo;
        mAnimationInfo = this.mAnimationInfo;
        mAnimationInfo = mAnimationInfo.j;
        if (mAnimationInfo != null && mAnimationInfo == null) {
            mAnimationInfo = mAnimationInfo.j;
            if (mAnimationInfo == null) {
            }
            return mAnimationInfo;
        }
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

    @Override // android.content.ComponentCallbacks
    public final String getString(int i) {
        return getResources().getString(i);
    }

    @Override // android.content.ComponentCallbacks
    public final String getString(int i, Object... object2Arr2) {
        return getResources().getString(i, object2Arr2);
    }

    @Override // android.content.ComponentCallbacks
    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final androidx.fragment.app.Fragment getTargetFragment() {
        String mTargetWho;
        androidx.fragment.app.Fragment mTarget = this.mTarget;
        if (mTarget != null) {
            return mTarget;
        }
        androidx.fragment.app.n mFragmentManager = this.mFragmentManager;
        mTargetWho = this.mTargetWho;
        if (mFragmentManager != null && mTargetWho != null) {
            mTargetWho = this.mTargetWho;
            if (mTargetWho != null) {
                return mFragmentManager.i0(mTargetWho);
            }
        }
        return null;
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    @Override // android.content.ComponentCallbacks
    public final java.lang.CharSequence getText(int i) {
        return getResources().getText(i);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @Override // android.content.ComponentCallbacks
    public View getView() {
        return this.mView;
    }

    @Override // android.content.ComponentCallbacks
    public q getViewLifecycleOwner() {
        androidx.fragment.app.a0 mViewLifecycleOwner = this.mViewLifecycleOwner;
        if (mViewLifecycleOwner == null) {
        } else {
            return mViewLifecycleOwner;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
        throw illegalStateException;
    }

    public LiveData<q> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // android.content.ComponentCallbacks
    public i0 getViewModelStore() {
        if (this.mFragmentManager == null) {
        } else {
            if (getMinimumMaxLifecycleState() == j.c.INITIALIZED.ordinal()) {
            } else {
                return this.mFragmentManager.D0(this);
            }
            IllegalStateException illegalStateException = new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
            throw illegalStateException;
        }
        IllegalStateException illegalStateException2 = new IllegalStateException("Can't access ViewModels from detached fragment");
        throw illegalStateException2;
    }

    @Override // android.content.ComponentCallbacks
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    @Override // android.content.ComponentCallbacks
    public final int hashCode() {
        return super.hashCode();
    }

    @Override // android.content.ComponentCallbacks
    void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        int i = 0;
        this.mAdded = i;
        this.mRemoving = i;
        this.mFromLayout = i;
        this.mInLayout = i;
        this.mRestored = i;
        this.mBackStackNesting = i;
        final int i2 = 0;
        this.mFragmentManager = i2;
        o oVar = new o();
        this.mChildFragmentManager = oVar;
        this.mHost = i2;
        this.mFragmentId = i;
        this.mContainerId = i;
        this.mTag = i2;
        this.mHidden = i;
        this.mDetached = i;
    }

    @Override // android.content.ComponentCallbacks
    public final boolean isAdded() {
        androidx.fragment.app.k mAdded;
        int i;
        if (this.mHost != null && this.mAdded) {
            i = this.mAdded ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.content.ComponentCallbacks
    public final boolean isDetached() {
        return this.mDetached;
    }

    @Override // android.content.ComponentCallbacks
    public final boolean isHidden() {
        return this.mHidden;
    }

    @Override // android.content.ComponentCallbacks
    boolean isHideReplaced() {
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 0;
        }
        return mAnimationInfo.y;
    }

    @Override // android.content.ComponentCallbacks
    final boolean isInBackStack() {
        int i;
        i = this.mBackStackNesting > 0 ? 1 : 0;
        return i;
    }

    @Override // android.content.ComponentCallbacks
    public final boolean isInLayout() {
        return this.mInLayout;
    }

    @Override // android.content.ComponentCallbacks
    public final boolean isMenuVisible() {
        androidx.fragment.app.n mFragmentManager;
        int i;
        androidx.fragment.app.Fragment mParentFragment;
        if (this.mMenuVisible) {
            mFragmentManager = this.mFragmentManager;
            if (mFragmentManager != null) {
                i = mFragmentManager.K0(this.mParentFragment) ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.content.ComponentCallbacks
    boolean isPostponed() {
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 0;
        }
        return mAnimationInfo.w;
    }

    @Override // android.content.ComponentCallbacks
    public final boolean isRemoving() {
        return this.mRemoving;
    }

    @Override // android.content.ComponentCallbacks
    final boolean isRemovingParent() {
        androidx.fragment.app.Fragment parentFragment;
        int i;
        boolean removing;
        parentFragment = getParentFragment();
        if (parentFragment != null) {
            if (!parentFragment.isRemoving()) {
                i = parentFragment.isRemovingParent() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.content.ComponentCallbacks
    public final boolean isResumed() {
        int i;
        i = this.mState >= 7 ? 1 : 0;
        return i;
    }

    @Override // android.content.ComponentCallbacks
    public final boolean isStateSaved() {
        androidx.fragment.app.n mFragmentManager = this.mFragmentManager;
        if (mFragmentManager == null) {
            return 0;
        }
        return mFragmentManager.N0();
    }

    @Override // android.content.ComponentCallbacks
    public final boolean isVisible() {
        int i;
        boolean windowToken;
        windowToken = this.mView;
        if (isAdded() && !isHidden() && windowToken != null && windowToken.getWindowToken() != null && this.mView.getVisibility() == 0) {
            if (!isHidden()) {
                windowToken = this.mView;
                if (windowToken != null) {
                    if (windowToken.getWindowToken() != null) {
                        i = this.mView.getVisibility() == 0 ? 1 : 0;
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

    @Override // android.content.ComponentCallbacks
    public Activity j0() {
        return getActivity();
    }

    @Override // android.content.ComponentCallbacks
    void noteStateNotSaved() {
        this.mChildFragmentManager.W0();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent3) {
        boolean stringBuilder;
        String str;
        int obj3;
        int obj4;
        if (n.I0(2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" received the following in onActivityResult(): requestCode: ");
            stringBuilder.append(i);
            stringBuilder.append(" resultCode: ");
            stringBuilder.append(i2);
            stringBuilder.append(" data: ");
            stringBuilder.append(intent3);
            Log.v("FragmentManager", stringBuilder.toString());
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onAttach(Context context) {
        int i;
        int obj2;
        this.mCalled = true;
        obj2 = this.mHost;
        if (obj2 == null) {
            obj2 = 0;
        } else {
            obj2 = obj2.e();
        }
        if (obj2 != null) {
            this.mCalled = false;
            onAttach(obj2);
        }
    }

    @Deprecated
    public void onAttachFragment(androidx.fragment.app.Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public boolean onContextItemSelected(MenuItem menuItem) {
        return 0;
    }

    @Override // android.content.ComponentCallbacks
    public void onCreate(Bundle bundle) {
        boolean obj2;
        final int i = 1;
        this.mCalled = i;
        restoreChildFragmentState(bundle);
        if (!this.mChildFragmentManager.M0(i)) {
            this.mChildFragmentManager.E();
        }
    }

    @Override // android.content.ComponentCallbacks
    public Animation onCreateAnimation(int i, boolean z2, int i3) {
        return null;
    }

    @Override // android.content.ComponentCallbacks
    public Animator onCreateAnimator(int i, boolean z2, int i3) {
        return null;
    }

    @Override // android.content.ComponentCallbacks
    public void onCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenu$ContextMenuInfo3) {
        requireActivity().onCreateContextMenu(contextMenu, view2, contextMenuInfo3);
    }

    @Override // android.content.ComponentCallbacks
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater2) {
    }

    @Override // android.content.ComponentCallbacks
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        final int obj4 = this.mContentLayoutId;
        if (obj4 != null) {
            return layoutInflater.inflate(obj4, viewGroup2, false);
        }
        return null;
    }

    @Override // android.content.ComponentCallbacks
    public void onDestroy() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onDestroyOptionsMenu() {
    }

    @Override // android.content.ComponentCallbacks
    public void onDestroyView() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onDetach() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    @Override // android.content.ComponentCallbacks
    public void onHiddenChanged(boolean z) {
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet2, Bundle bundle3) {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onInflate(Context context, AttributeSet attributeSet2, Bundle bundle3) {
        int i;
        int obj2;
        this.mCalled = true;
        obj2 = this.mHost;
        if (obj2 == null) {
            obj2 = 0;
        } else {
            obj2 = obj2.e();
        }
        if (obj2 != null) {
            this.mCalled = false;
            onInflate(obj2, attributeSet2, bundle3);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onMultiWindowModeChanged(boolean z) {
    }

    @Override // android.content.ComponentCallbacks
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return 0;
    }

    @Override // android.content.ComponentCallbacks
    public void onOptionsMenuClosed(Menu menu) {
    }

    @Override // android.content.ComponentCallbacks
    public void onPause() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onPictureInPictureModeChanged(boolean z) {
    }

    @Override // android.content.ComponentCallbacks
    public void onPrepareOptionsMenu(Menu menu) {
    }

    @Override // android.content.ComponentCallbacks
    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i, String[] string2Arr2, int[] i3Arr3) {
    }

    @Override // android.content.ComponentCallbacks
    public void onResume() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // android.content.ComponentCallbacks
    public void onStart() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onStop() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onViewCreated(View view, Bundle bundle2) {
    }

    @Override // android.content.ComponentCallbacks
    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.W0();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
        } else {
            restoreViewState();
            this.mChildFragmentManager.A();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onActivityCreated()");
        e0 obj3 = new e0(stringBuilder.toString());
        throw obj3;
    }

    @Override // android.content.ComponentCallbacks
    void performAttach() {
        Object next;
        Iterator iterator = this.mOnPreAttachedListeners.iterator();
        for (Fragment.j next : iterator) {
            next.a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.l(this.mHost, createFragmentContainer(), this);
        int i = 0;
        this.mState = i;
        this.mCalled = i;
        onAttach(this.mHost.f());
        if (!this.mCalled) {
        } else {
            this.mFragmentManager.K(this);
            this.mChildFragmentManager.B();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onAttach()");
        e0 e0Var = new e0(stringBuilder.toString());
        throw e0Var;
    }

    @Override // android.content.ComponentCallbacks
    void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.C(configuration);
    }

    @Override // android.content.ComponentCallbacks
    boolean performContextItemSelected(MenuItem menuItem) {
        if (!this.mHidden && onContextItemSelected(menuItem)) {
            if (onContextItemSelected(menuItem)) {
                return 1;
            }
            return this.mChildFragmentManager.D(menuItem);
        }
        return 0;
    }

    @Override // android.content.ComponentCallbacks
    void performCreate(Bundle bundle) {
        int mLifecycleRegistry;
        int anon;
        this.mChildFragmentManager.W0();
        int i = 1;
        this.mState = i;
        this.mCalled = false;
        if (Build.VERSION.SDK_INT >= 19) {
            anon = new Fragment.5(this);
            this.mLifecycleRegistry.a(anon);
        }
        this.mSavedStateRegistryController.c(bundle);
        onCreate(bundle);
        this.mIsCreated = i;
        if (!this.mCalled) {
        } else {
            this.mLifecycleRegistry.h(j.b.ON_CREATE);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onCreate()");
        e0 obj4 = new e0(stringBuilder.toString());
        throw obj4;
    }

    @Override // android.content.ComponentCallbacks
    boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater2) {
        boolean mMenuVisible;
        boolean mChildFragmentManager;
        int i;
        Menu obj3;
        i = 0;
        if (!this.mHidden && this.mHasMenu && this.mMenuVisible) {
            if (this.mHasMenu) {
                if (this.mMenuVisible) {
                    i = 1;
                    onCreateOptionsMenu(menu, menuInflater2);
                }
            }
            i |= obj3;
        }
        return i;
    }

    @Override // android.content.ComponentCallbacks
    void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        x obj3;
        Object obj4;
        this.mChildFragmentManager.W0();
        this.mPerformedCreateView = true;
        a0 a0Var = new a0(this, getViewModelStore());
        this.mViewLifecycleOwner = a0Var;
        obj3 = onCreateView(layoutInflater, viewGroup2, bundle3);
        this.mView = obj3;
        if (obj3 != null) {
            this.mViewLifecycleOwner.b();
            k0.a(this.mView, this.mViewLifecycleOwner);
            l0.a(this.mView, this.mViewLifecycleOwner);
            d.a(this.mView, this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
        } else {
            if (this.mViewLifecycleOwner.c()) {
            } else {
                this.mViewLifecycleOwner = 0;
            }
        }
        obj3 = new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        throw obj3;
    }

    @Override // android.content.ComponentCallbacks
    void performDestroy() {
        this.mChildFragmentManager.G();
        this.mLifecycleRegistry.h(j.b.ON_DESTROY);
        int i = 0;
        this.mState = i;
        this.mCalled = i;
        this.mIsCreated = i;
        onDestroy();
        if (!this.mCalled) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onDestroy()");
        e0 e0Var = new e0(stringBuilder.toString());
        throw e0Var;
    }

    @Override // android.content.ComponentCallbacks
    void performDestroyView() {
        View mViewLifecycleOwner;
        Enum oN_DESTROY;
        this.mChildFragmentManager.H();
        if (this.mView != null && this.mViewLifecycleOwner.getLifecycle().b().isAtLeast(j.c.CREATED)) {
            if (this.mViewLifecycleOwner.getLifecycle().b().isAtLeast(j.c.CREATED)) {
                this.mViewLifecycleOwner.a(j.b.ON_DESTROY);
            }
        }
        this.mState = 1;
        int i2 = 0;
        this.mCalled = i2;
        onDestroyView();
        if (!this.mCalled) {
        } else {
            a.b(this).d();
            this.mPerformedCreateView = i2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onDestroyView()");
        e0 e0Var = new e0(stringBuilder.toString());
        throw e0Var;
    }

    @Override // android.content.ComponentCallbacks
    void performDetach() {
        boolean oVar;
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = 0;
        if (!this.mCalled) {
        } else {
            if (!this.mChildFragmentManager.H0()) {
                this.mChildFragmentManager.G();
                oVar = new o();
                this.mChildFragmentManager = oVar;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onDetach()");
        e0 e0Var = new e0(stringBuilder.toString());
        throw e0Var;
    }

    @Override // android.content.ComponentCallbacks
    LayoutInflater performGetLayoutInflater(Bundle bundle) {
        final LayoutInflater obj1 = onGetLayoutInflater(bundle);
        this.mLayoutInflater = obj1;
        return obj1;
    }

    @Override // android.content.ComponentCallbacks
    void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.I();
    }

    @Override // android.content.ComponentCallbacks
    void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        this.mChildFragmentManager.J(z);
    }

    @Override // android.content.ComponentCallbacks
    boolean performOptionsItemSelected(MenuItem menuItem) {
        boolean onOptionsItemSelected;
        if (!this.mHidden && this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            if (this.mHasMenu) {
                if (this.mMenuVisible) {
                    if (onOptionsItemSelected(menuItem)) {
                        return 1;
                    }
                }
            }
            return this.mChildFragmentManager.L(menuItem);
        }
        return 0;
    }

    @Override // android.content.ComponentCallbacks
    void performOptionsMenuClosed(Menu menu) {
        boolean mMenuVisible;
        boolean mChildFragmentManager;
        if (!this.mHidden && this.mHasMenu && this.mMenuVisible) {
            if (this.mHasMenu) {
                if (this.mMenuVisible) {
                    onOptionsMenuClosed(menu);
                }
            }
            this.mChildFragmentManager.M(menu);
        }
    }

    @Override // android.content.ComponentCallbacks
    void performPause() {
        Object mViewLifecycleOwner;
        j.b oN_PAUSE;
        this.mChildFragmentManager.O();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(j.b.ON_PAUSE);
        }
        this.mLifecycleRegistry.h(j.b.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onPause()");
        e0 e0Var = new e0(stringBuilder.toString());
        throw e0Var;
    }

    @Override // android.content.ComponentCallbacks
    void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        this.mChildFragmentManager.P(z);
    }

    @Override // android.content.ComponentCallbacks
    boolean performPrepareOptionsMenu(Menu menu) {
        boolean mMenuVisible;
        boolean mChildFragmentManager;
        int i;
        Menu obj3;
        i = 0;
        if (!this.mHidden && this.mHasMenu && this.mMenuVisible) {
            if (this.mHasMenu) {
                if (this.mMenuVisible) {
                    i = 1;
                    onPrepareOptionsMenu(menu);
                }
            }
            i |= obj3;
        }
        return i;
    }

    @Override // android.content.ComponentCallbacks
    void performPrimaryNavigationFragmentChanged() {
        boolean mChildFragmentManager;
        boolean mIsPrimaryNavigationFragment;
        mChildFragmentManager = this.mFragmentManager.L0(this);
        mIsPrimaryNavigationFragment = this.mIsPrimaryNavigationFragment;
        if (mIsPrimaryNavigationFragment != null) {
            if (mIsPrimaryNavigationFragment.booleanValue() != mChildFragmentManager) {
                this.mIsPrimaryNavigationFragment = Boolean.valueOf(mChildFragmentManager);
                onPrimaryNavigationFragmentChanged(mChildFragmentManager);
                this.mChildFragmentManager.R();
            }
        } else {
        }
    }

    @Override // android.content.ComponentCallbacks
    void performResume() {
        Object mViewLifecycleOwner;
        this.mChildFragmentManager.W0();
        this.mChildFragmentManager.c0(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
        } else {
            j.b oN_RESUME = j.b.ON_RESUME;
            this.mLifecycleRegistry.h(oN_RESUME);
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(oN_RESUME);
            }
            this.mChildFragmentManager.S();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onResume()");
        e0 e0Var = new e0(stringBuilder.toString());
        throw e0Var;
    }

    @Override // android.content.ComponentCallbacks
    void performSaveInstanceState(Bundle bundle) {
        String str;
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.d(bundle);
        Parcelable parcelable = this.mChildFragmentManager.n1();
        if (parcelable != null) {
            bundle.putParcelable("android:support:fragments", parcelable);
        }
    }

    @Override // android.content.ComponentCallbacks
    void performStart() {
        Object mViewLifecycleOwner;
        this.mChildFragmentManager.W0();
        this.mChildFragmentManager.c0(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
        } else {
            j.b oN_START = j.b.ON_START;
            this.mLifecycleRegistry.h(oN_START);
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(oN_START);
            }
            this.mChildFragmentManager.T();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onStart()");
        e0 e0Var = new e0(stringBuilder.toString());
        throw e0Var;
    }

    @Override // android.content.ComponentCallbacks
    void performStop() {
        Object mViewLifecycleOwner;
        j.b oN_STOP;
        this.mChildFragmentManager.V();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(j.b.ON_STOP);
        }
        this.mLifecycleRegistry.h(j.b.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onStop()");
        e0 e0Var = new e0(stringBuilder.toString());
        throw e0Var;
    }

    @Override // android.content.ComponentCallbacks
    void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.W();
    }

    @Override // android.content.ComponentCallbacks
    public void postponeEnterTransition() {
        ensureAnimationInfo.w = true;
    }

    @Override // android.content.ComponentCallbacks
    public final void postponeEnterTransition(long l, TimeUnit timeUnit2) {
        Handler handler;
        int mainLooper;
        ensureAnimationInfo.w = true;
        androidx.fragment.app.n mFragmentManager = this.mFragmentManager;
        if (mFragmentManager != null) {
            handler = mFragmentManager.w0().g();
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, obj5.toMillis(l));
    }

    public final <I, O> c<I> registerForActivityResult(a<I, O> a, ActivityResultRegistry activityResultRegistry2, b<O> b3) {
        Fragment.f fVar = new Fragment.f(this, activityResultRegistry2);
        return prepareCallInternal(a, fVar, b3);
    }

    public final <I, O> c<I> registerForActivityResult(a<I, O> a, b<O> b2) {
        Fragment.e eVar = new Fragment.e(this);
        return prepareCallInternal(a, eVar, b2);
    }

    @Override // android.content.ComponentCallbacks
    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] stringArr, int i2) {
        if (this.mHost == null) {
        } else {
            getParentFragmentManager().O0(this, stringArr, i2);
        }
        StringBuilder obj3 = new StringBuilder();
        obj3.append("Fragment ");
        obj3.append(this);
        obj3.append(" not attached to Activity");
        IllegalStateException obj2 = new IllegalStateException(obj3.toString());
        throw obj2;
    }

    @Override // android.content.ComponentCallbacks
    public final androidx.fragment.app.e requireActivity() {
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            return activity;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" not attached to an activity.");
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // android.content.ComponentCallbacks
    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments == null) {
        } else {
            return arguments;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" does not have any arguments.");
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // android.content.ComponentCallbacks
    public final Context requireContext() {
        Context context = getContext();
        if (context == null) {
        } else {
            return context;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" not attached to a context.");
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Deprecated
    public final androidx.fragment.app.n requireFragmentManager() {
        return getParentFragmentManager();
    }

    @Override // android.content.ComponentCallbacks
    public final Object requireHost() {
        Object host = getHost();
        if (host == null) {
        } else {
            return host;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" not attached to a host.");
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // android.content.ComponentCallbacks
    public final androidx.fragment.app.Fragment requireParentFragment() {
        androidx.fragment.app.Fragment parentFragment = getParentFragment();
        String str = "Fragment ";
        if (parentFragment == null && getContext() == null) {
            str = "Fragment ";
            if (getContext() == null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append(this);
                stringBuilder2.append(" is not attached to any Fragment or host");
                IllegalStateException illegalStateException2 = new IllegalStateException(stringBuilder2.toString());
                throw illegalStateException2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this);
            stringBuilder.append(" is not a child Fragment, it is directly attached to ");
            stringBuilder.append(getContext());
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
        return parentFragment;
    }

    @Override // android.content.ComponentCallbacks
    public final View requireView() {
        View view = getView();
        if (view == null) {
        } else {
            return view;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not return a View from onCreateView() or this was called before onCreateView().");
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // android.content.ComponentCallbacks
    void restoreChildFragmentState(Bundle bundle) {
        Object mChildFragmentManager;
        Object obj2;
        obj2 = bundle.getParcelable("android:support:fragments");
        if (bundle != null && obj2 != null) {
            obj2 = bundle.getParcelable("android:support:fragments");
            if (obj2 != null) {
                this.mChildFragmentManager.l1(obj2);
                this.mChildFragmentManager.E();
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    final void restoreViewState(Bundle bundle) {
        Object mViewLifecycleOwner;
        int oN_CREATE;
        View mSavedViewRegistryState;
        Object obj4;
        SparseArray mSavedViewState = this.mSavedViewState;
        int i = 0;
        if (mSavedViewState != null) {
            this.mView.restoreHierarchyState(mSavedViewState);
            this.mSavedViewState = i;
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.d(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = i;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
        } else {
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(j.b.ON_CREATE);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onViewStateRestored()");
        obj4 = new e0(stringBuilder.toString());
        throw obj4;
    }

    @Override // android.content.ComponentCallbacks
    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo.r = Boolean.valueOf(z);
    }

    @Override // android.content.ComponentCallbacks
    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo.q = Boolean.valueOf(z);
    }

    @Override // android.content.ComponentCallbacks
    void setAnimatingAway(View view) {
        ensureAnimationInfo.a = view;
    }

    @Override // android.content.ComponentCallbacks
    void setAnimations(int i, int i2, int i3, int i4) {
        if (this.mAnimationInfo == null && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (i == 0) {
                if (i2 == 0) {
                    if (i3 == 0) {
                        if (i4 == 0) {
                        }
                    }
                }
            }
        }
        ensureAnimationInfo.d = i;
        obj2.e = i2;
        obj2.f = i3;
        obj2.g = i4;
    }

    @Override // android.content.ComponentCallbacks
    void setAnimator(Animator animator) {
        ensureAnimationInfo.b = animator;
    }

    @Override // android.content.ComponentCallbacks
    public void setArguments(Bundle bundle) {
        androidx.fragment.app.n mFragmentManager;
        if (this.mFragmentManager != null) {
            if (isStateSaved()) {
            } else {
            }
            IllegalStateException obj2 = new IllegalStateException("Fragment already added and state has been saved");
            throw obj2;
        }
        this.mArguments = bundle;
    }

    @Override // android.content.ComponentCallbacks
    public void setEnterSharedElementCallback(p p) {
        ensureAnimationInfo.s = p;
    }

    @Override // android.content.ComponentCallbacks
    public void setEnterTransition(Object object) {
        ensureAnimationInfo.k = object;
    }

    @Override // android.content.ComponentCallbacks
    public void setExitSharedElementCallback(p p) {
        ensureAnimationInfo.t = p;
    }

    @Override // android.content.ComponentCallbacks
    public void setExitTransition(Object object) {
        ensureAnimationInfo.m = object;
    }

    @Override // android.content.ComponentCallbacks
    void setFocusedView(View view) {
        ensureAnimationInfo.v = view;
    }

    @Override // android.content.ComponentCallbacks
    public void setHasOptionsMenu(boolean z) {
        boolean obj2;
        this.mHasMenu = z;
        if (this.mHasMenu != z && isAdded() && !isHidden()) {
            this.mHasMenu = z;
            if (isAdded()) {
                if (!isHidden()) {
                    this.mHost.o();
                }
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    void setHideReplaced(boolean z) {
        ensureAnimationInfo.y = z;
    }

    @Override // android.content.ComponentCallbacks
    public void setInitialSavedState(androidx.fragment.app.Fragment.l fragment$l) {
        int obj2;
        if (this.mFragmentManager != null) {
        } else {
            if (l != null && l.a != null) {
                if (l.a != null) {
                } else {
                    obj2 = 0;
                }
            } else {
            }
            this.mSavedFragmentState = obj2;
        }
        obj2 = new IllegalStateException("Fragment already added");
        throw obj2;
    }

    @Override // android.content.ComponentCallbacks
    public void setMenuVisibility(boolean z) {
        boolean obj2;
        this.mMenuVisible = z;
        if (this.mMenuVisible != z && this.mHasMenu && isAdded() && !isHidden()) {
            this.mMenuVisible = z;
            if (this.mHasMenu) {
                if (isAdded()) {
                    if (!isHidden()) {
                        this.mHost.o();
                    }
                }
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    void setNextTransition(int i) {
        if (this.mAnimationInfo == null && i == 0) {
            if (i == 0) {
            }
        }
        ensureAnimationInfo();
        mAnimationInfo2.h = i;
    }

    @Override // android.content.ComponentCallbacks
    void setOnStartEnterTransitionListener(androidx.fragment.app.Fragment.k fragment$k) {
        ensureAnimationInfo();
        androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        androidx.fragment.app.Fragment.k kVar = mAnimationInfo.x;
        if (k == kVar) {
        }
        if (k != null) {
            if (kVar != null) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Trying to set a replacement startPostponedEnterTransition on ");
            stringBuilder.append(this);
            IllegalStateException obj3 = new IllegalStateException(stringBuilder.toString());
            throw obj3;
        }
        if (mAnimationInfo.w) {
            mAnimationInfo.x = k;
        }
        if (k != null) {
            k.a();
        }
    }

    @Override // android.content.ComponentCallbacks
    void setPopDirection(boolean z) {
        if (this.mAnimationInfo == null) {
        }
        ensureAnimationInfo.c = z;
    }

    @Override // android.content.ComponentCallbacks
    void setPostOnViewCreatedAlpha(float f) {
        ensureAnimationInfo.u = f;
    }

    @Override // android.content.ComponentCallbacks
    public void setReenterTransition(Object object) {
        ensureAnimationInfo.n = object;
    }

    @Deprecated
    public void setRetainInstance(boolean z) {
        boolean obj2;
        this.mRetainInstance = z;
        final androidx.fragment.app.n mFragmentManager = this.mFragmentManager;
        if (mFragmentManager != null) {
            if (z) {
                mFragmentManager.j(this);
            } else {
                mFragmentManager.j1(this);
            }
        } else {
            this.mRetainInstanceChangedWhileDetached = true;
        }
    }

    @Override // android.content.ComponentCallbacks
    public void setReturnTransition(Object object) {
        ensureAnimationInfo.l = object;
    }

    @Override // android.content.ComponentCallbacks
    public void setSharedElementEnterTransition(Object object) {
        ensureAnimationInfo.o = object;
    }

    void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ensureAnimationInfo();
        final androidx.fragment.app.Fragment.i mAnimationInfo = this.mAnimationInfo;
        mAnimationInfo.i = arrayList;
        mAnimationInfo.j = arrayList2;
    }

    @Override // android.content.ComponentCallbacks
    public void setSharedElementReturnTransition(Object object) {
        ensureAnimationInfo.p = object;
    }

    @Deprecated
    public void setTargetFragment(androidx.fragment.app.Fragment fragment, int i2) {
        Object mFragmentManager2;
        androidx.fragment.app.n mFragmentManager;
        Object obj4;
        androidx.fragment.app.n mFragmentManager3 = this.mFragmentManager;
        int i = 0;
        mFragmentManager = fragment != null ? fragment.mFragmentManager : i;
        if (mFragmentManager3 != null && mFragmentManager != null) {
            if (mFragmentManager != null) {
                if (mFragmentManager3 != mFragmentManager) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Fragment ");
                stringBuilder.append(fragment);
                stringBuilder.append(" must share the same FragmentManager to be set as a target fragment");
                IllegalArgumentException obj5 = new IllegalArgumentException(stringBuilder.toString());
                throw obj5;
            }
        }
        mFragmentManager2 = fragment;
        while (mFragmentManager2 != null) {
            mFragmentManager2 = mFragmentManager2.getTargetFragment();
        }
        if (fragment == null) {
            this.mTargetWho = i;
            this.mTarget = i;
        } else {
            if (this.mFragmentManager != null && fragment.mFragmentManager != null) {
                if (fragment.mFragmentManager != null) {
                    this.mTargetWho = fragment.mWho;
                    this.mTarget = i;
                } else {
                    this.mTargetWho = i;
                    this.mTarget = fragment;
                }
            } else {
            }
        }
        this.mTargetRequestCode = i2;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        boolean mUserVisibleHint;
        int i;
        androidx.fragment.app.u uVar;
        boolean obj4;
        final int i2 = 5;
        if (!this.mUserVisibleHint && z && this.mState < i2 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            if (z) {
                if (this.mState < i2) {
                    if (this.mFragmentManager != null) {
                        if (isAdded()) {
                            if (this.mIsCreated) {
                                mUserVisibleHint = this.mFragmentManager;
                                mUserVisibleHint.Y0(mUserVisibleHint.x(this));
                            }
                        }
                    }
                }
            }
        }
        this.mUserVisibleHint = z;
        if (this.mState < i2 && !z) {
            i = !z ? 1 : 0;
        } else {
        }
        this.mDeferStart = i;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    @Override // android.content.ComponentCallbacks
    public boolean shouldShowRequestPermissionRationale(String string) {
        final androidx.fragment.app.k mHost = this.mHost;
        if (mHost != null) {
            return mHost.l(string);
        }
        return 0;
    }

    @Override // android.content.ComponentCallbacks
    public void startActivity(Intent intent) {
        startActivity(intent, 0);
    }

    @Override // android.content.ComponentCallbacks
    public void startActivity(Intent intent, Bundle bundle2) {
        androidx.fragment.app.k mHost = this.mHost;
        if (mHost == null) {
        } else {
            mHost.m(this, intent, -1, bundle2);
        }
        StringBuilder obj4 = new StringBuilder();
        obj4.append("Fragment ");
        obj4.append(this);
        obj4.append(" not attached to Activity");
        IllegalStateException obj3 = new IllegalStateException(obj4.toString());
        throw obj3;
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i2) {
        startActivityForResult(intent, i2, 0);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i2, Bundle bundle3) {
        if (this.mHost == null) {
        } else {
            getParentFragmentManager().P0(this, intent, i2, bundle3);
        }
        StringBuilder obj3 = new StringBuilder();
        obj3.append("Fragment ");
        obj3.append(this);
        obj3.append(" not attached to Activity");
        IllegalStateException obj2 = new IllegalStateException(obj3.toString());
        throw obj2;
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent3, int i4, int i5, int i6, Bundle bundle7) {
        boolean string;
        String str;
        Object obj2;
        int i;
        Object obj3;
        Object obj;
        str = "Fragment ";
        if (obj7.mHost == null) {
        } else {
            if (n.I0(2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(this);
                stringBuilder.append(" received the following in startIntentSenderForResult() requestCode: ");
                i = i2;
                stringBuilder.append(i2);
                stringBuilder.append(" IntentSender: ");
                obj2 = intentSender;
                stringBuilder.append(intentSender);
                stringBuilder.append(" fillInIntent: ");
                obj3 = intent3;
                stringBuilder.append(intent3);
                stringBuilder.append(" options: ");
                stringBuilder.append(bundle7);
                Log.v("FragmentManager", stringBuilder.toString());
            } else {
                obj2 = intentSender;
                i = i2;
                obj3 = intent3;
                obj = bundle7;
            }
            getParentFragmentManager().Q0(this, intentSender, i2, intent3, i4, i5, i6, bundle7);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(this);
        stringBuilder2.append(" not attached to Activity");
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder2.toString());
        throw illegalStateException;
    }

    @Override // android.content.ComponentCallbacks
    public void startPostponedEnterTransition() {
        androidx.fragment.app.Fragment.i ensureAnimationInfo;
        Looper bVar;
        if (this.mAnimationInfo != null) {
            if (!ensureAnimationInfo2.w) {
            } else {
                if (this.mHost == null) {
                    ensureAnimationInfo.w = false;
                } else {
                    if (Looper.myLooper() != this.mHost.g().getLooper()) {
                        bVar = new Fragment.b(this);
                        this.mHost.g().postAtFrontOfQueue(bVar);
                    } else {
                        callStartTransitionListener(true);
                    }
                }
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public String toString() {
        int mFragmentId;
        String mTag;
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append("}");
        stringBuilder.append(" (");
        stringBuilder.append(this.mWho);
        if (this.mFragmentId != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            stringBuilder.append(" tag=");
            stringBuilder.append(this.mTag);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override // android.content.ComponentCallbacks
    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(0);
    }
}
