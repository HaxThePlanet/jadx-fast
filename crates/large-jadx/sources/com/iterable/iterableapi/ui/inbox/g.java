package com.iterable.iterableapi.ui.inbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import com.iterable.iterableapi.e0;
import com.iterable.iterableapi.f0;
import com.iterable.iterableapi.f0.f;
import com.iterable.iterableapi.g0;
import com.iterable.iterableapi.i;
import com.iterable.iterableapi.i.c;
import com.iterable.iterableapi.j;
import com.iterable.iterableapi.j0;
import com.iterable.iterableapi.j1.c;
import com.iterable.iterableapi.z;
import java.text.DateFormat;
import java.util.Date;

/* compiled from: IterableInboxFragment.java */
/* loaded from: classes2.dex */
public class g extends Fragment implements f0.f, b.e {

    private c A = new g$b();
    private d B = new g$c(0);
    private f C = new g$e(0);
    private e D = new g$d(0);
    private final i.c E = new g$a();
    private a a;
    private int b;
    private String c;
    private String v;
    TextView w;
    TextView x;
    RecyclerView y;
    private final com.iterable.iterableapi.d z = new d();

    class a implements i.c {

        final /* synthetic */ g a;
        a() {
            this.a = gVar;
            super();
        }

        public void a() {
            this.a.z.c();
        }

        public void d() {
        }
    }

    private class b implements c<Object> {

        final /* synthetic */ g a;
        private b() {
            this.a = gVar;
            super();
        }

        public int a(int i) {
            return this.a.b;
        }

        /* synthetic */ b(g.a aVar) {
            this(gVar);
        }

        public Object b(View view, int i) {
            return null;
        }

        public void c(b.f fVar, Object object, g0 g0Var) {
        }

        public int d(g0 g0Var) {
            return 0;
        }
    }

    private static class c implements d {
        private c() {
            super();
        }

        public int m(g0 g0Var, g0 g0Var2) {
            return -g0Var.f().compareTo(g0Var2.f());
        }

        /* synthetic */ c(g.a aVar) {
            this();
        }
    }

    private static class d implements e {
        private d() {
            super();
        }

        public java.lang.CharSequence a(g0 g0Var) {
            if (g0Var.f() != null) {
                return DateFormat.getDateTimeInstance(2, 3).format(g0Var.f());
            }
            return "";
        }

        /* synthetic */ d(g.a aVar) {
            this();
        }
    }

    private static class e implements f {
        private e() {
            super();
        }

        /* synthetic */ e(g.a aVar) {
            this();
        }

        public boolean a(g0 g0Var) {
            return true;
        }
    }
    public g() {
        super();
        this.a = a.POPUP;
        this.b = d.c;
        com.iterable.iterableapi.d dVar = new d();
        final com.iterable.iterableapi.ui.inbox.g.a aVar2 = null;
        com.iterable.iterableapi.ui.inbox.g.b bVar = new g.b(this, aVar2);
        com.iterable.iterableapi.ui.inbox.g.c cVar = new g.c(aVar2);
        com.iterable.iterableapi.ui.inbox.g.e eVar = new g.e(aVar2);
        com.iterable.iterableapi.ui.inbox.g.d dVar2 = new g.d(aVar2);
        com.iterable.iterableapi.ui.inbox.g.a aVar = new g.a(this);
    }

    static /* synthetic */ com.iterable.iterableapi.d B1(g gVar) {
        return gVar.z;
    }

    static /* synthetic */ int C1(g gVar) {
        return gVar.b;
    }

    private void D1(b bVar) {
        final int i = 0;
        final int i2 = 4;
        if (bVar.getItemCount() == 0) {
            this.w.setVisibility(i);
            this.x.setVisibility(i);
            this.y.setVisibility(i2);
        } else {
            this.w.setVisibility(i2);
            this.x.setVisibility(i2);
            this.y.setVisibility(i);
        }
    }

    public static g E1() {
        return new g();
    }

    public static g F1(a aVar, int i, String str, String str2) {
        final com.iterable.iterableapi.ui.inbox.g gVar = new g();
        final Bundle bundle = new Bundle();
        bundle.putSerializable("inboxMode", aVar);
        bundle.putInt("itemLayoutId", i);
        bundle.putString("noMessagesTitle", str);
        bundle.putString("noMessagesBody", str2);
        gVar.setArguments(bundle);
        return gVar;
    }

    private void G1() {
        androidx.recyclerview.widget.RecyclerView.h adapter = this.y.getAdapter();
        adapter.o(j.s().q().j());
        D1(adapter);
    }

    @Override // androidx.fragment.app.Fragment
    public void C() {
        G1();
    }

    @Override // androidx.fragment.app.Fragment
    public void T0(g0 g0Var) {
        this.z.g(g0Var);
    }

    @Override // androidx.fragment.app.Fragment
    public void h0(g0 g0Var) {
        this.z.f(g0Var);
    }

    @Override // androidx.fragment.app.Fragment
    public void o1(g0 g0Var) {
        j.s().q().E(g0Var, true);
        if (this.a == a.ACTIVITY) {
            obj = IterableInboxMessageActivity.class;
            str = "messageId";
            startActivity(new Intent(getContext(), obj).putExtra(str, g0Var.i()));
        } else {
            j.s().q().F(g0Var, e0.INBOX);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i.l().j(this.E);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j0.g();
        Bundle arguments = getArguments();
        int i = 0;
        if (arguments != null) {
            str2 = "inboxMode";
            if (arguments.get(str2) instanceof a) {
                this.a = (a)arguments.get(str2);
            }
            str3 = "itemLayoutId";
            if (arguments.getInt(str3, i) != 0) {
                this.b = arguments.getInt(str3);
            }
            string = "noMessagesTitle";
            if (arguments.getString(string) != null) {
                this.c = arguments.getString(string);
            }
            str = "noMessagesBody";
            if (arguments.getString(str) != null) {
                this.v = arguments.getString(str);
            }
        }
        final View inflate = layoutInflater.inflate(d.b, viewGroup, false);
        View viewById = inflate.findViewById(c.f);
        this.y = viewById;
        viewById.setLayoutManager(new LinearLayoutManager(getContext()));
        b viewGroup22 = new b(j.s().q().j(), this, this.A, this.B, this.C, this.D);
        this.y.setAdapter(viewGroup22);
        this.w = (TextView)inflate.findViewById(c.d);
        this.x = (TextView)inflate.findViewById(c.c);
        this.w.setText(this.c);
        this.x.setText(this.v);
        new l(new i(getContext(), viewGroup22)).g(this.y);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        i.l().o(this.E);
        if (getActivity() != null) {
            if (!getActivity().isChangingConfigurations()) {
                this.z.c();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        j.s().q().x(this);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        G1();
        j.s().q().h(this);
        this.z.i();
    }

    @Override // androidx.fragment.app.Fragment
    public void v(g0 g0Var, z zVar) {
        j.s().q().z(g0Var, zVar, e0.INBOX);
    }
}
