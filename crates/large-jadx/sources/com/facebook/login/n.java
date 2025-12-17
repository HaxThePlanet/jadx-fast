package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.facebook.common.b;
import com.facebook.common.c;

/* loaded from: classes.dex */
public class n extends Fragment {

    private String a;
    private com.facebook.login.l b;
    private com.facebook.login.l.d c;

    class a implements com.facebook.login.l.c {

        final com.facebook.login.n a;
        a(com.facebook.login.n n) {
            this.a = n;
            super();
        }

        @Override // com.facebook.login.l$c
        public void a(com.facebook.login.l.e l$e) {
            n.B1(this.a, e);
        }
    }

    class b implements com.facebook.login.l.b {

        final View a;
        b(com.facebook.login.n n, View view2) {
            this.a = view2;
            super();
        }

        @Override // com.facebook.login.l$b
        public void a() {
            this.a.setVisibility(0);
        }

        @Override // com.facebook.login.l$b
        public void b() {
            this.a.setVisibility(8);
        }
    }
    static void B1(com.facebook.login.n n, com.facebook.login.l.e l$e2) {
        n.G1(e2);
    }

    private void F1(Activity activity) {
        ComponentName obj1 = activity.getCallingActivity();
        if (obj1 == null) {
        }
        this.a = obj1.getPackageName();
    }

    private void G1(com.facebook.login.l.e l$e) {
        int i;
        boolean activity;
        Object obj4;
        this.c = 0;
        i = e.a == l.e.b.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.facebook.LoginFragment:Result", e);
        obj4 = new Intent();
        obj4.putExtras(bundle);
        if (isAdded()) {
            getActivity().setResult(i, obj4);
            getActivity().finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    protected com.facebook.login.l C1() {
        l lVar = new l(this);
        return lVar;
    }

    @Override // androidx.fragment.app.Fragment
    protected int D1() {
        return c.c;
    }

    @Override // androidx.fragment.app.Fragment
    com.facebook.login.l E1() {
        return this.b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent3) {
        super.onActivityResult(i, i2, intent3);
        this.b.x(i, i2, intent3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String str;
        Object aVar;
        android.os.Parcelable obj2;
        super.onCreate(bundle);
        if (bundle != null) {
            obj2 = bundle.getParcelable("loginClient");
            this.b = (l)obj2;
            obj2.z(this);
        } else {
            this.b = C1();
        }
        aVar = new n.a(this);
        this.b.A(aVar);
        obj2 = getActivity();
        if (obj2 == null) {
        }
        F1(obj2);
        obj2 = obj2.getIntent();
        obj2 = obj2.getBundleExtra("com.facebook.LoginFragment:Request");
        if (obj2 != null && obj2 != null) {
            obj2 = obj2.getBundleExtra("com.facebook.LoginFragment:Request");
            if (obj2 != null) {
                this.c = (l.d)obj2.getParcelable("request");
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        final View obj2 = layoutInflater.inflate(D1(), viewGroup2, false);
        n.b bVar = new n.b(this, obj2.findViewById(b.d));
        this.b.y(bVar);
        return obj2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.b.c();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        int viewById;
        int i;
        super.onPause();
        if (getView() == null) {
            viewById = 0;
        } else {
            viewById = getView().findViewById(b.d);
        }
        if (viewById != 0) {
            viewById.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.a == null) {
            Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            getActivity().finish();
        }
        this.b.B(this.c);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("loginClient", this.b);
    }
}
