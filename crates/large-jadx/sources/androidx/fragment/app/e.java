package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.f;
import androidx.activity.g.b;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.d;
import androidx.core.app.a;
import androidx.core.app.a.c;
import androidx.core.app.a.e;
import androidx.core.app.p;
import androidx.lifecycle.i0;
import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import androidx.lifecycle.j.c;
import androidx.lifecycle.j0;
import androidx.lifecycle.s;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistry.b;
import d.p.a.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class e extends ComponentActivity implements a.c, a.e {

    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final s mFragmentLifecycleRegistry;
    final androidx.fragment.app.i mFragments;
    boolean mResumed;
    boolean mStopped = true;

    class a implements SavedStateRegistry.b {

        final androidx.fragment.app.e a;
        a(androidx.fragment.app.e e) {
            this.a = e;
            super();
        }

        @Override // androidx.savedstate.SavedStateRegistry$b
        public Bundle a() {
            Object oN_STOP;
            Bundle bundle = new Bundle();
            this.a.markFragmentsCreated();
            eVar2.mFragmentLifecycleRegistry.h(j.b.ON_STOP);
            android.os.Parcelable parcelable = eVar3.mFragments.x();
            if (parcelable != null) {
                bundle.putParcelable("android:support:fragments", parcelable);
            }
            return bundle;
        }
    }

    class b implements b {

        final androidx.fragment.app.e a;
        b(androidx.fragment.app.e e) {
            this.a = e;
            super();
        }

        @Override // androidx.activity.g.b
        public void a(Context context) {
            Object mFragments;
            Object obj2;
            obj2.mFragments.a(0);
            mFragments = "android:support:fragments";
            obj2 = this.a.getSavedStateRegistry().a(mFragments);
            if (obj2 != null) {
                eVar.mFragments.w(obj2.getParcelable(mFragments));
            }
        }
    }

    class c extends androidx.fragment.app.k<androidx.fragment.app.e> implements j0, f, d, androidx.fragment.app.r {

        final androidx.fragment.app.e w;
        public c(androidx.fragment.app.e e) {
            this.w = e;
            super(e);
        }

        @Override // androidx.fragment.app.k
        public void a(androidx.fragment.app.n n, androidx.fragment.app.Fragment fragment2) {
            this.w.onAttachFragment(fragment2);
        }

        @Override // androidx.fragment.app.k
        public View c(int i) {
            return this.w.findViewById(i);
        }

        @Override // androidx.fragment.app.k
        public boolean d() {
            Object peekDecorView;
            int i;
            peekDecorView = this.w.getWindow();
            if (peekDecorView != null && peekDecorView.peekDecorView() != null) {
                i = peekDecorView.peekDecorView() != null ? 1 : 0;
            } else {
            }
            return i;
        }

        @Override // androidx.fragment.app.k
        public ActivityResultRegistry getActivityResultRegistry() {
            return this.w.getActivityResultRegistry();
        }

        @Override // androidx.fragment.app.k
        public j getLifecycle() {
            return eVar.mFragmentLifecycleRegistry;
        }

        @Override // androidx.fragment.app.k
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return this.w.getOnBackPressedDispatcher();
        }

        @Override // androidx.fragment.app.k
        public i0 getViewModelStore() {
            return this.w.getViewModelStore();
        }

        @Override // androidx.fragment.app.k
        public Object h() {
            return p();
        }

        @Override // androidx.fragment.app.k
        public LayoutInflater i() {
            return this.w.getLayoutInflater().cloneInContext(this.w);
        }

        @Override // androidx.fragment.app.k
        public boolean k(androidx.fragment.app.Fragment fragment) {
            return obj1 ^= 1;
        }

        @Override // androidx.fragment.app.k
        public boolean l(String string) {
            return a.v(this.w, string);
        }

        @Override // androidx.fragment.app.k
        public void o() {
            this.w.supportInvalidateOptionsMenu();
        }

        @Override // androidx.fragment.app.k
        public androidx.fragment.app.e p() {
            return this.w;
        }
    }
    public e() {
        super();
        e.c cVar = new e.c(this);
        this.mFragments = i.b(cVar);
        s sVar = new s(this);
        this.mFragmentLifecycleRegistry = sVar;
        int i = 1;
        init();
    }

    public e(int i) {
        super(i);
        e.c obj1 = new e.c(this);
        this.mFragments = i.b(obj1);
        obj1 = new s(this);
        this.mFragmentLifecycleRegistry = obj1;
        obj1 = 1;
        init();
    }

    private void init() {
        e.a aVar = new e.a(this);
        getSavedStateRegistry().d("android:support:fragments", aVar);
        e.b bVar = new e.b(this);
        addOnContextAvailableListener(bVar);
    }

    private static boolean markState(androidx.fragment.app.n n, j.c j$c2) {
        int i;
        Object next;
        boolean atLeast;
        Object markState;
        androidx.fragment.app.a0 mViewLifecycleOwner;
        int i2;
        j.c sTARTED;
        Iterator obj5 = n.v0().iterator();
        i = 0;
        while (obj5.hasNext()) {
            next = obj5.next();
            if ((Fragment)next == null) {
            } else {
            }
            if ((Fragment)next.getHost() != null) {
            }
            mViewLifecycleOwner = next.mViewLifecycleOwner;
            i2 = 1;
            if (mViewLifecycleOwner != null && mViewLifecycleOwner.getLifecycle().b().isAtLeast(j.c.STARTED)) {
            }
            if (next.mLifecycleRegistry.b().isAtLeast(j.c.STARTED)) {
            }
            next.mLifecycleRegistry.o(c2);
            i = i2;
            if (mViewLifecycleOwner.getLifecycle().b().isAtLeast(j.c.STARTED)) {
            }
            next.mViewLifecycleOwner.f(c2);
            i = i2;
            i |= markState;
        }
        return i;
    }

    @Override // androidx.activity.ComponentActivity
    final View dispatchFragmentsOnCreateView(View view, String string2, Context context3, AttributeSet attributeSet4) {
        return this.mFragments.v(view, string2, context3, attributeSet4);
    }

    @Override // androidx.activity.ComponentActivity
    public void dump(String string, FileDescriptor fileDescriptor2, PrintWriter printWriter3, String[] string4Arr4) {
        Object application;
        super.dump(string, fileDescriptor2, printWriter3, string4Arr4);
        printWriter3.print(string);
        printWriter3.print("Local FragmentActivity ");
        printWriter3.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter3.println(" State:");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("  ");
        String string2 = stringBuilder.toString();
        printWriter3.print(string2);
        printWriter3.print("mCreated=");
        printWriter3.print(this.mCreated);
        printWriter3.print(" mResumed=");
        printWriter3.print(this.mResumed);
        printWriter3.print(" mStopped=");
        printWriter3.print(this.mStopped);
        if (getApplication() != null) {
            a.b(this).a(string2, fileDescriptor2, printWriter3, string4Arr4);
        }
        this.mFragments.t().Y(string, fileDescriptor2, printWriter3, string4Arr4);
    }

    @Override // androidx.activity.ComponentActivity
    public androidx.fragment.app.n getSupportFragmentManager() {
        return this.mFragments.t();
    }

    @Deprecated
    public a getSupportLoaderManager() {
        return a.b(this);
    }

    @Override // androidx.activity.ComponentActivity
    void markFragmentsCreated() {
        while (!e.markState(getSupportFragmentManager(), j.c.CREATED)) {
        }
    }

    @Override // androidx.activity.ComponentActivity
    protected void onActivityResult(int i, int i2, Intent intent3) {
        this.mFragments.u();
        super.onActivityResult(i, i2, intent3);
    }

    @Deprecated
    public void onAttachFragment(androidx.fragment.app.Fragment fragment) {
    }

    @Override // androidx.activity.ComponentActivity
    public void onConfigurationChanged(Configuration configuration) {
        this.mFragments.u();
        super.onConfigurationChanged(configuration);
        this.mFragments.d(configuration);
    }

    @Override // androidx.activity.ComponentActivity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.h(j.b.ON_CREATE);
        this.mFragments.f();
    }

    @Override // androidx.activity.ComponentActivity
    public boolean onCreatePanelMenu(int i, Menu menu2) {
        if (i == 0) {
            return obj3 |= obj4;
        }
        return super.onCreatePanelMenu(i, menu2);
    }

    @Override // androidx.activity.ComponentActivity
    public View onCreateView(View view, String string2, Context context3, AttributeSet attributeSet4) {
        final View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, string2, context3, attributeSet4);
        if (dispatchFragmentsOnCreateView == null) {
            return super.onCreateView(view, string2, context3, attributeSet4);
        }
        return dispatchFragmentsOnCreateView;
    }

    @Override // androidx.activity.ComponentActivity
    public View onCreateView(String string, Context context2, AttributeSet attributeSet3) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(0, string, context2, attributeSet3);
        if (dispatchFragmentsOnCreateView == null) {
            return super.onCreateView(string, context2, attributeSet3);
        }
        return dispatchFragmentsOnCreateView;
    }

    @Override // androidx.activity.ComponentActivity
    protected void onDestroy() {
        super.onDestroy();
        this.mFragments.h();
        this.mFragmentLifecycleRegistry.h(j.b.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.i();
    }

    @Override // androidx.activity.ComponentActivity
    public boolean onMenuItemSelected(int i, MenuItem menuItem2) {
        if (super.onMenuItemSelected(i, menuItem2)) {
            return 1;
        }
        if (i != 0 && i != 6) {
            if (i != 6) {
                return 0;
            }
            return this.mFragments.e(menuItem2);
        }
        return this.mFragments.k(menuItem2);
    }

    @Override // androidx.activity.ComponentActivity
    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.j(z);
    }

    @Override // androidx.activity.ComponentActivity
    protected void onNewIntent(Intent intent) {
        this.mFragments.u();
        super.onNewIntent(intent);
    }

    @Override // androidx.activity.ComponentActivity
    public void onPanelClosed(int i, Menu menu2) {
        androidx.fragment.app.i mFragments;
        if (i == 0) {
            this.mFragments.l(menu2);
        }
        super.onPanelClosed(i, menu2);
    }

    @Override // androidx.activity.ComponentActivity
    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.m();
        this.mFragmentLifecycleRegistry.h(j.b.ON_PAUSE);
    }

    @Override // androidx.activity.ComponentActivity
    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.n(z);
    }

    @Override // androidx.activity.ComponentActivity
    protected void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Deprecated
    protected boolean onPrepareOptionsPanel(View view, Menu menu2) {
        return super.onPreparePanel(0, view, menu2);
    }

    @Override // androidx.activity.ComponentActivity
    public boolean onPreparePanel(int i, View view2, Menu menu3) {
        if (i == 0) {
            return obj1 |= obj2;
        }
        return super.onPreparePanel(i, view2, menu3);
    }

    @Override // androidx.activity.ComponentActivity
    public void onRequestPermissionsResult(int i, String[] string2Arr2, int[] i3Arr3) {
        this.mFragments.u();
        super.onRequestPermissionsResult(i, string2Arr2, i3Arr3);
    }

    @Override // androidx.activity.ComponentActivity
    protected void onResume() {
        this.mFragments.u();
        super.onResume();
        this.mResumed = true;
        this.mFragments.s();
    }

    @Override // androidx.activity.ComponentActivity
    protected void onResumeFragments() {
        this.mFragmentLifecycleRegistry.h(j.b.ON_RESUME);
        this.mFragments.p();
    }

    @Override // androidx.activity.ComponentActivity
    protected void onStart() {
        boolean mFragments;
        this.mFragments.u();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.s();
        this.mFragmentLifecycleRegistry.h(j.b.ON_START);
        this.mFragments.q();
    }

    @Override // androidx.activity.ComponentActivity
    public void onStateNotSaved() {
        this.mFragments.u();
    }

    @Override // androidx.activity.ComponentActivity
    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.r();
        this.mFragmentLifecycleRegistry.h(j.b.ON_STOP);
    }

    @Override // androidx.activity.ComponentActivity
    public void setEnterSharedElementCallback(p p) {
        a.t(this, p);
    }

    @Override // androidx.activity.ComponentActivity
    public void setExitSharedElementCallback(p p) {
        a.u(this, p);
    }

    @Override // androidx.activity.ComponentActivity
    public void startActivityFromFragment(androidx.fragment.app.Fragment fragment, Intent intent2, int i3) {
        startActivityFromFragment(fragment, intent2, i3, 0);
    }

    @Override // androidx.activity.ComponentActivity
    public void startActivityFromFragment(androidx.fragment.app.Fragment fragment, Intent intent2, int i3, Bundle bundle4) {
        final int i = -1;
        if (i3 == i) {
            a.w(this, intent2, i, bundle4);
        }
        fragment.startActivityForResult(intent2, i3, bundle4);
    }

    @Deprecated
    public void startIntentSenderFromFragment(androidx.fragment.app.Fragment fragment, IntentSender intentSender2, int i3, Intent intent4, int i5, int i6, int i7, Bundle bundle8) {
        if (i3 == -1) {
            a.x(this, intentSender2, i3, intent4, i5, i6, i7, bundle8);
        }
        fragment.startIntentSenderForResult(intentSender2, i3, intent4, i5, i6, i7, bundle8);
    }

    @Override // androidx.activity.ComponentActivity
    public void supportFinishAfterTransition() {
        a.p(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    @Override // androidx.activity.ComponentActivity
    public void supportPostponeEnterTransition() {
        a.q(this);
    }

    @Override // androidx.activity.ComponentActivity
    public void supportStartPostponedEnterTransition() {
        a.y(this);
    }

    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i) {
    }
}
