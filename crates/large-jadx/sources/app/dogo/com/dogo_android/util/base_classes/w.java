package app.dogo.com.dogo_android.util.e0;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.g0;
import androidx.lifecycle.h0;
import app.dogo.com.dogo_android.k.h;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.util.k0.f;
import app.dogo.com.dogo_android.util.u.a;
import app.dogo.com.dogo_android.util.u.b;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.w.o3;
import com.bumptech.glide.c;
import java.util.HashSet;
import java.util.Set;
import n.a.a;

/* compiled from: LegacyBaseNavFragment.java */
/* loaded from: classes.dex */
public abstract class w extends Fragment implements v {

    private r a;
    private a0 b;
    protected final o3 c;
    private f v;
    private u.a w = new w$a();

    class a extends u.a {

        final /* synthetic */ w e;
        a(q qVar, Set set) {
            this.e = wVar;
            super(qVar, set);
        }

        @Override // app.dogo.com.dogo_android.util.u$a
        public void d(h hVar, Bundle bundle) {
            this.e.W1(hVar, bundle);
        }
    }
    protected w() {
        super();
        this.c = App.o();
        app.dogo.com.dogo_android.util.e0.w.a aVar = new app.dogo.com.dogo_android.util.base_classes.w.a(this, D1(), E1());
    }

    private /* synthetic */ void N1(Integer integer) {
        if (integer != null) {
            Z1(integer.intValue());
        }
    }

    private /* synthetic */ void P1(String str) {
        if (str != null) {
            a2(str);
        }
    }

    private /* synthetic */ void R1(Boolean boolean) {
        if (boolean != null && boolean.booleanValue()) {
            B1();
        }
    }

    private /* synthetic */ void T1(u.b bVar) {
        if (bVar != null) {
            this.w.a(bVar.a(), bVar.b());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void B1() {
        if (this.b != null) {
            this.b.m();
        } else {
            str = "Navigator was null when trying to call loading spinner";
            a.c(str, new Object[0]);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void C1() {
        if (this.b != null) {
            this.b.s();
        } else {
            str = "Navigator was null when trying to dismiss loading spinner";
            a.c(str, new Object[0]);
        }
    }

    @Override // androidx.fragment.app.Fragment
    protected Set<h> E1() {
        return new HashSet();
    }

    @Override // androidx.fragment.app.Fragment
    protected f F1() {
        if (this.v == null) {
            this.v = new app.dogo.com.dogo_android.util.base_classes.g(this);
        }
        return this.v;
    }

    @Override // androidx.fragment.app.Fragment
    public a0 G1() {
        return this.b;
    }

    @Override // androidx.fragment.app.Fragment
    public r J1() {
        return this.a;
    }

    @Override // androidx.fragment.app.Fragment
    public void M1() {
        if (getContext() == null) {
            return;
        }
        str = "input_method";
        Object systemService = getContext().getSystemService(str);
        if (systemService != null) {
            systemService.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Y1(View view) {
        if (view.requestFocus()) {
            Object systemService = view.getContext().getSystemService("input_method");
            if (systemService != null) {
                int i = 0;
                systemService.toggleSoftInput(2, i);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Z1(int i) {
        if (this.b != null) {
            this.b.t0(i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void a2(String str) {
        if (this.b != null) {
            this.b.u0(str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void f0(a0 a0Var) {
        this.b = a0Var;
        a0Var.Z(this.w);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (J1() != null) {
            J1().onActivityResult(i, i2, intent, G1());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.a = (BaseViewModel)h0.a(this).a(K1());
        J1().c.observe(this, new app.dogo.com.dogo_android.util.base_classes.e(this));
        J1().loadingDialogTrigger.observe(this, new app.dogo.com.dogo_android.util.base_classes.f(this));
        J1().parent.observe(this, new app.dogo.com.dogo_android.util.base_classes.h(this));
        J1().registry = D1();
        J1().k().observe(this, new app.dogo.com.dogo_android.util.base_classes.i(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        z = fragment instanceof app.dogo.com.dogo_android.util.base_classes.v;
        if (fragment instanceof app.dogo.com.dogo_android.util.base_classes.v) {
            fragment.f0(this.b);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            str = "view_model_bundle";
            J1().onRestoreState(bundle.getBundle(str));
        }
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(2131623936, menu);
        X1(menu);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        J1().n();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.w.g();
        this.w.f();
        app.dogo.com.dogo_android.util.e0.a0 a0Var = null;
        this.b = a0Var;
        this.a = a0Var;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        J1().o();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        J1().q();
        this.b.c0(I1());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = J1().r();
        if (bundle2 != null) {
            str = "view_model_bundle";
            bundle.putBundle(str, bundle2);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        J1().s();
        z = a0Var instanceof MainScreenActivity;
        if (a0Var instanceof MainScreenActivity) {
            this.b.a0(L1());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        J1().t();
        c.c(requireContext()).b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (H1() != null) {
            this.c.logScreenView(requireActivity(), H1());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public abstract q D1();

    @Override // androidx.fragment.app.Fragment
    public abstract k3 H1();

    @Override // androidx.fragment.app.Fragment
    public String I1() {
        return "";
    }

    @Override // androidx.fragment.app.Fragment
    public abstract Class<? extends r> K1();

    @Override // androidx.fragment.app.Fragment
    public boolean L1() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void O1(Integer integer) {
        N1(integer);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void Q1(String str) {
        P1(str);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void S1(Boolean boolean) {
        R1(boolean);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void U1(u.b bVar) {
        T1(bVar);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean V1() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    protected void W1(h hVar, Bundle bundle) {
    }

    @Override // androidx.fragment.app.Fragment
    public boolean X1(Menu menu) {
        return true;
    }
}
