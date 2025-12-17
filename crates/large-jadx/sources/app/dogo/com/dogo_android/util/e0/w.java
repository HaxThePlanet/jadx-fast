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

/* loaded from: classes.dex */
public abstract class w extends Fragment implements app.dogo.com.dogo_android.util.e0.v {

    private app.dogo.com.dogo_android.util.e0.r a;
    private app.dogo.com.dogo_android.util.e0.a0 b;
    protected final o3 c;
    private f v;
    private u.a w;

    class a extends u.a {

        final app.dogo.com.dogo_android.util.e0.w e;
        a(app.dogo.com.dogo_android.util.e0.w w, q q2, Set set3) {
            this.e = w;
            super(q2, set3);
        }

        @Override // app.dogo.com.dogo_android.util.u$a
        public void d(h h, Bundle bundle2) {
            this.e.W1(h, bundle2);
        }
    }
    protected w() {
        super();
        this.c = App.o();
        w.a aVar = new w.a(this, D1(), E1());
        this.w = aVar;
    }

    private void N1(Integer integer) {
        int obj1;
        if (integer != 0) {
            Z1(integer.intValue());
        }
    }

    private void P1(String string) {
        if (string != null) {
            a2(string);
        }
    }

    private void R1(Boolean boolean) {
        boolean obj1;
        if (boolean) {
            if (boolean.booleanValue()) {
                B1();
            } else {
                C1();
            }
        }
    }

    private void T1(u.b u$b) {
        u.a aVar;
        h hVar;
        Bundle obj3;
        if (b != null) {
            this.w.a(b.a(), b.b());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void B1() {
        app.dogo.com.dogo_android.util.e0.a0 arr;
        String str;
        arr = this.b;
        if (arr != null) {
            arr.m();
        } else {
            a.c("Navigator was null when trying to call loading spinner", new Object[0]);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void C1() {
        app.dogo.com.dogo_android.util.e0.a0 arr;
        String str;
        arr = this.b;
        if (arr != null) {
            arr.s();
        } else {
            a.c("Navigator was null when trying to dismiss loading spinner", new Object[0]);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public abstract q D1();

    protected Set<h> E1() {
        HashSet hashSet = new HashSet();
        return hashSet;
    }

    @Override // androidx.fragment.app.Fragment
    protected f F1() {
        f gVar;
        if (this.v == null) {
            gVar = new g(this);
            this.v = gVar;
        }
        return this.v;
    }

    @Override // androidx.fragment.app.Fragment
    public app.dogo.com.dogo_android.util.e0.a0 G1() {
        return this.b;
    }

    @Override // androidx.fragment.app.Fragment
    public abstract k3 H1();

    @Override // androidx.fragment.app.Fragment
    public String I1() {
        return "";
    }

    @Override // androidx.fragment.app.Fragment
    public app.dogo.com.dogo_android.util.e0.r J1() {
        return this.a;
    }

    public abstract Class<? extends app.dogo.com.dogo_android.util.e0.r> K1();

    @Override // androidx.fragment.app.Fragment
    public boolean L1() {
        return 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void M1() {
        Object windowToken;
        String str;
        if (getContext() == null) {
        }
        Object systemService = getContext().getSystemService("input_method");
        if ((InputMethodManager)systemService != null) {
            (InputMethodManager)systemService.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void O1(Integer integer) {
        N1(integer);
    }

    @Override // androidx.fragment.app.Fragment
    public void Q1(String string) {
        P1(string);
    }

    @Override // androidx.fragment.app.Fragment
    public void S1(Boolean boolean) {
        R1(boolean);
    }

    @Override // androidx.fragment.app.Fragment
    public void U1(u.b u$b) {
        T1(b);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean V1() {
        return 0;
    }

    @Override // androidx.fragment.app.Fragment
    protected void W1(h h, Bundle bundle2) {
    }

    @Override // androidx.fragment.app.Fragment
    public boolean X1(Menu menu) {
        return 1;
    }

    @Override // androidx.fragment.app.Fragment
    public void Y1(View view) {
        boolean requestFocus;
        int i;
        Object obj3;
        obj3 = view.getContext().getSystemService("input_method");
        if (view.requestFocus() && (InputMethodManager)obj3 != null) {
            obj3 = view.getContext().getSystemService("input_method");
            if ((InputMethodManager)(InputMethodManager)obj3 != null) {
                (InputMethodManager)(InputMethodManager)obj3.toggleSoftInput(2, 0);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Z1(int i) {
        final app.dogo.com.dogo_android.util.e0.a0 a0Var = this.b;
        if (a0Var != null) {
            a0Var.t0(i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void a2(String string) {
        final app.dogo.com.dogo_android.util.e0.a0 a0Var = this.b;
        if (a0Var != null) {
            a0Var.u0(string);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void f0(app.dogo.com.dogo_android.util.e0.a0 a0) {
        this.b = a0;
        a0.Z(this.w);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent3) {
        app.dogo.com.dogo_android.util.e0.r rVar;
        app.dogo.com.dogo_android.util.e0.a0 a0Var;
        super.onActivityResult(i, i2, intent3);
        if (J1() != null) {
            J1().m(i, i2, intent3, G1());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.a = (r)h0.a(this).a(K1());
        e eVar = new e(this);
        obj2.c.observe(this, eVar);
        f fVar = new f(this);
        obj2.b.observe(this, fVar);
        h hVar = new h(this);
        obj2.v.observe(this, hVar);
        obj2.w = D1();
        i iVar = new i(this);
        J1().k().observe(this, iVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(Fragment fragment) {
        boolean z;
        super.onAttachFragment(fragment);
        if (fragment instanceof v) {
            (v)fragment.f0(this.b);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        app.dogo.com.dogo_android.util.e0.r rVar;
        String str;
        Bundle obj3;
        super.onCreate(bundle);
        if (bundle != null) {
            J1().p(bundle.getBundle("view_model_bundle"));
        }
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater2) {
        menuInflater2.inflate(2131623936, menu);
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
        int i = 0;
        this.b = i;
        this.a = i;
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
        String str;
        Bundle bundle2 = J1().r();
        if (bundle2 != null) {
            bundle.putBundle("view_model_bundle", bundle2);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        boolean z;
        super.onStart();
        J1().s();
        app.dogo.com.dogo_android.util.e0.a0 a0Var = this.b;
        if (a0Var instanceof MainScreenActivity != null) {
            a0Var.a0(L1());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        J1().t();
        c.c(requireContext()).b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        k3 k3Var;
        Object obj2;
        Object obj3;
        super.onViewCreated(view, bundle2);
        if (H1() != null) {
            this.c.h(requireActivity(), H1());
        }
    }
}
