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
import com.iterable.iterableapi.d;
import com.iterable.iterableapi.e0;
import com.iterable.iterableapi.f0;
import com.iterable.iterableapi.f0.f;
import com.iterable.iterableapi.g0;
import com.iterable.iterableapi.i;
import com.iterable.iterableapi.i.c;
import com.iterable.iterableapi.j;
import com.iterable.iterableapi.j0;
import com.iterable.iterableapi.j1.c;
import com.iterable.iterableapi.j1.d;
import com.iterable.iterableapi.z;
import java.text.DateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public class g extends Fragment implements f0.f, com.iterable.iterableapi.ui.inbox.b.e {

    private com.iterable.iterableapi.ui.inbox.c A;
    private com.iterable.iterableapi.ui.inbox.d B;
    private com.iterable.iterableapi.ui.inbox.f C;
    private com.iterable.iterableapi.ui.inbox.e D;
    private final i.c E;
    private com.iterable.iterableapi.ui.inbox.a a;
    private int b;
    private String c;
    private String v;
    TextView w;
    TextView x;
    RecyclerView y;
    private final d z;

    class a implements i.c {

        final com.iterable.iterableapi.ui.inbox.g a;
        a(com.iterable.iterableapi.ui.inbox.g g) {
            this.a = g;
            super();
        }

        @Override // com.iterable.iterableapi.i$c
        public void a() {
            g.B1(this.a).c();
        }

        @Override // com.iterable.iterableapi.i$c
        public void d() {
        }
    }

    private class b implements com.iterable.iterableapi.ui.inbox.c<Object> {

        final com.iterable.iterableapi.ui.inbox.g a;
        private b(com.iterable.iterableapi.ui.inbox.g g) {
            this.a = g;
            super();
        }

        b(com.iterable.iterableapi.ui.inbox.g g, com.iterable.iterableapi.ui.inbox.g.a g$a2) {
            super(g);
        }

        @Override // com.iterable.iterableapi.ui.inbox.c
        public int a(int i) {
            return g.C1(this.a);
        }

        @Override // com.iterable.iterableapi.ui.inbox.c
        public Object b(View view, int i2) {
            return null;
        }

        @Override // com.iterable.iterableapi.ui.inbox.c
        public void c(com.iterable.iterableapi.ui.inbox.b.f b$f, Object object2, g0 g03) {
        }

        @Override // com.iterable.iterableapi.ui.inbox.c
        public int d(g0 g0) {
            return 0;
        }
    }

    private static class c implements com.iterable.iterableapi.ui.inbox.d {
        c(com.iterable.iterableapi.ui.inbox.g.a g$a) {
            super();
        }

        @Override // com.iterable.iterableapi.ui.inbox.d
        public int compare(Object object, Object object2) {
            return m((g0)object, (g0)object2);
        }

        @Override // com.iterable.iterableapi.ui.inbox.d
        public int m(g0 g0, g0 g02) {
            return -obj1;
        }
    }

    private static class d implements com.iterable.iterableapi.ui.inbox.e {
        d(com.iterable.iterableapi.ui.inbox.g.a g$a) {
            super();
        }

        @Override // com.iterable.iterableapi.ui.inbox.e
        public java.lang.CharSequence a(g0 g0) {
            if (g0.f() != null) {
                return DateFormat.getDateTimeInstance(2, 3).format(g0.f());
            }
            return "";
        }
    }

    private static class e implements com.iterable.iterableapi.ui.inbox.f {
        e(com.iterable.iterableapi.ui.inbox.g.a g$a) {
            super();
        }

        @Override // com.iterable.iterableapi.ui.inbox.f
        public boolean a(g0 g0) {
            return 1;
        }
    }
    public g() {
        super();
        this.a = a.POPUP;
        this.b = d.c;
        d dVar = new d();
        this.z = dVar;
        final int i2 = 0;
        g.b bVar = new g.b(this, i2);
        this.A = bVar;
        g.c cVar = new g.c(i2);
        this.B = cVar;
        g.e eVar = new g.e(i2);
        this.C = eVar;
        g.d dVar2 = new g.d(i2);
        this.D = dVar2;
        g.a aVar = new g.a(this);
        this.E = aVar;
    }

    static d B1(com.iterable.iterableapi.ui.inbox.g g) {
        return g.z;
    }

    static int C1(com.iterable.iterableapi.ui.inbox.g g) {
        return g.b;
    }

    private void D1(com.iterable.iterableapi.ui.inbox.b b) {
        RecyclerView obj3;
        final int i = 0;
        final int i2 = 4;
        if (b.getItemCount() == 0) {
            this.w.setVisibility(i);
            this.x.setVisibility(i);
            this.y.setVisibility(i2);
        } else {
            this.w.setVisibility(i2);
            this.x.setVisibility(i2);
            this.y.setVisibility(i);
        }
    }

    public static com.iterable.iterableapi.ui.inbox.g E1() {
        g gVar = new g();
        return gVar;
    }

    public static com.iterable.iterableapi.ui.inbox.g F1(com.iterable.iterableapi.ui.inbox.a a, int i2, String string3, String string4) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        bundle.putSerializable("inboxMode", a);
        bundle.putInt("itemLayoutId", i2);
        bundle.putString("noMessagesTitle", string3);
        bundle.putString("noMessagesBody", string4);
        gVar.setArguments(bundle);
        return gVar;
    }

    private void G1() {
        androidx.recyclerview.widget.RecyclerView.h adapter = this.y.getAdapter();
        (b)adapter.o(j.s().q().j());
        D1(adapter);
    }

    @Override // androidx.fragment.app.Fragment
    public void C() {
        G1();
    }

    @Override // androidx.fragment.app.Fragment
    public void T0(g0 g0) {
        this.z.g(g0);
    }

    @Override // androidx.fragment.app.Fragment
    public void h0(g0 g0) {
        this.z.f(g0);
    }

    @Override // androidx.fragment.app.Fragment
    public void o1(g0 g0) {
        Object intent;
        Object iNBOX;
        Class<com.iterable.iterableapi.ui.inbox.IterableInboxMessageActivity> obj;
        Object obj4;
        j.s().q().E(g0, true);
        if (this.a == a.ACTIVITY) {
            intent = new Intent(getContext(), IterableInboxMessageActivity.class);
            startActivity(intent.putExtra("messageId", g0.i()));
        } else {
            j.s().q().F(g0, e0.INBOX);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i.l().j(this.E);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        String str;
        Object str3;
        String str2;
        String string;
        String string2;
        Object obj11;
        j0.g();
        obj11 = getArguments();
        int i = 0;
        str3 = "inboxMode";
        if (obj11 != null && obj instanceof a) {
            str3 = "inboxMode";
            if (obj instanceof a) {
                this.a = (a)obj11.get(str3);
            }
            str2 = "itemLayoutId";
            if (obj11.getInt(str2, i) != 0) {
                this.b = obj11.getInt(str2);
            }
            string = "noMessagesTitle";
            if (obj11.getString(string) != null) {
                this.c = obj11.getString(string);
            }
            str = "noMessagesBody";
            if (obj11.getString(str) != null) {
                this.v = obj11.getString(str);
            }
        }
        final View obj9 = layoutInflater.inflate(d.b, viewGroup2, i);
        View obj10 = (RelativeLayout)obj9.findViewById(c.f);
        this.y = (RecyclerView)obj10;
        obj11 = new LinearLayoutManager(getContext());
        obj10.setLayoutManager(obj11);
        super(j.s().q().j(), this, this.A, this.B, this.C, this.D);
        this.y.setAdapter(obj10);
        this.w = (TextView)obj9.findViewById(c.d);
        this.x = (TextView)obj9.findViewById(c.c);
        this.w.setText(this.c);
        this.x.setText(this.v);
        i iVar = new i(getContext(), obj10);
        obj11 = new l(iVar);
        obj11.g(this.y);
        return obj9;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        androidx.fragment.app.e changingConfigurations;
        super.onDestroy();
        i.l().o(this.E);
        if (getActivity() != null && !getActivity().isChangingConfigurations()) {
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
    public void v(g0 g0, z z2) {
        j.s().q().z(g0, z2, e0.INBOX);
    }
}
