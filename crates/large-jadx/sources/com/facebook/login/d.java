package com.facebook.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.a;
import com.facebook.common.b;
import com.facebook.common.c;
import com.facebook.common.d;
import com.facebook.common.e;
import com.facebook.e0.m;
import com.facebook.f;
import com.facebook.f0.a.a;
import com.facebook.internal.a0;
import com.facebook.internal.b0;
import com.facebook.internal.b0.b;
import com.facebook.internal.c0;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.p;
import com.facebook.internal.q;
import com.facebook.n;
import com.facebook.o;
import com.facebook.p;
import com.facebook.p.b;
import com.facebook.q;
import com.facebook.s;
import com.facebook.t;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d extends d {

    private boolean A = false;
    private boolean B = false;
    private com.facebook.login.l.d C = null;
    private View a;
    private TextView b;
    private TextView c;
    private com.facebook.login.e v;
    private AtomicBoolean w;
    private volatile q x;
    private volatile ScheduledFuture y;
    private volatile com.facebook.login.d.i z;

    class a extends Dialog {

        final com.facebook.login.d a;
        a(com.facebook.login.d d, Context context2, int i3) {
            this.a = d;
            super(context2, i3);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            this.a.S1();
            super.onBackPressed();
        }
    }

    class c implements View.OnClickListener {

        final com.facebook.login.d a;
        c(com.facebook.login.d d) {
            this.a = d;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            if (a.d(this)) {
            }
            this.a.T1();
        }
    }

    class d implements Runnable {

        final com.facebook.login.d a;
        d(com.facebook.login.d d) {
            this.a = d;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.d(this)) {
            }
            d.E1(this.a);
        }
    }

    class f implements DialogInterface.OnClickListener {

        final com.facebook.login.d a;
        f(com.facebook.login.d d) {
            this.a = d;
            super();
        }

        @Override // android.content.DialogInterface$OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            this.a.getDialog().setContentView(this.a.R1(false));
            com.facebook.login.d obj1 = this.a;
            obj1.a2(d.I1(obj1));
        }
    }

    class g implements DialogInterface.OnClickListener {

        final String a;
        final b0.b b;
        final String c;
        final Date v;
        final Date w;
        final com.facebook.login.d x;
        g(com.facebook.login.d d, String string2, b0.b b0$b3, String string4, Date date5, Date date6) {
            this.x = d;
            this.a = string2;
            this.b = b3;
            this.c = string4;
            this.v = date5;
            this.w = date6;
            super();
        }

        @Override // android.content.DialogInterface$OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            d.K1(this.x, this.a, this.b, this.c, this.v, this.w);
        }
    }

    private static class i implements Parcelable {

        public static final Parcelable.Creator<com.facebook.login.d.i> CREATOR;
        private String a;
        private String b;
        private String c;
        private long v;
        private long w;
        static {
            d.i.a aVar = new d.i.a();
            d.i.CREATOR = aVar;
        }

        protected i(Parcel parcel) {
            super();
            this.a = parcel.readString();
            this.b = parcel.readString();
            this.c = parcel.readString();
            this.v = parcel.readLong();
            this.w = parcel.readLong();
        }

        @Override // android.os.Parcelable
        public String a() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public long b() {
            return this.v;
        }

        @Override // android.os.Parcelable
        public String c() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public String d() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void e(long l) {
            this.v = l;
        }

        @Override // android.os.Parcelable
        public void f(long l) {
            this.w = l;
        }

        @Override // android.os.Parcelable
        public void g(String string) {
            this.c = string;
        }

        @Override // android.os.Parcelable
        public void h(String string) {
            this.b = string;
            Object[] arr = new Object[1];
            this.a = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", string);
        }

        @Override // android.os.Parcelable
        public boolean i() {
            int i;
            final int i2 = 0;
            if (Long.compare(l, i2) == 0) {
                return 0;
            }
            Date date = new Date();
            if (Long.compare(i4, i2) < 0) {
                i = 1;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeLong(this.v);
            parcel.writeLong(this.w);
        }
    }

    class b implements p.b {

        final com.facebook.login.d a;
        b(com.facebook.login.d d) {
            this.a = d;
            super();
        }

        @Override // com.facebook.p$b
        public void b(s s) {
            if (d.B1(this.a)) {
            }
            if (s.b() != null) {
                this.a.U1(s.b().e());
            }
            JSONObject obj4 = s.c();
            d.i iVar = new d.i();
            iVar.h(obj4.getString("user_code"));
            iVar.g(obj4.getString("code"));
            iVar.e(obj4.getLong("interval"));
            d.C1(this.a, iVar);
        }
    }

    class e implements p.b {

        final com.facebook.login.d a;
        e(com.facebook.login.d d) {
            this.a = d;
            super();
        }

        @Override // com.facebook.p$b
        public void b(s s) {
            int i;
            com.facebook.login.d dVar;
            String string;
            Object obj6;
            if (d.F1(this.a).get()) {
            }
            n nVar = s.b();
            if (nVar != null) {
                i = nVar.g();
                if (i != 1349152) {
                    switch (i) {
                        case 1349172:
                            d.G1(this.a);
                            break;
                        case 1349173:
                            this.a.T1();
                            break;
                        default:
                            this.a.U1(s.b().e());
                    }
                } else {
                    if (d.H1(this.a) != null) {
                        a.a(d.H1(this.a).d());
                    }
                    if (d.I1(this.a) != null) {
                        obj6 = this.a;
                        obj6.a2(d.I1(obj6));
                    } else {
                        this.a.T1();
                    }
                }
            }
            obj6 = s.c();
            d.J1(this.a, obj6.getString("access_token"), Long.valueOf(obj6.getLong("expires_in")), Long.valueOf(obj6.optLong("data_access_expiration_time")));
        }
    }

    class h implements p.b {

        final String a;
        final Date b;
        final Date c;
        final com.facebook.login.d d;
        h(com.facebook.login.d d, String string2, Date date3, Date date4) {
            this.d = d;
            this.a = string2;
            this.b = date3;
            this.c = date4;
            super();
        }

        @Override // com.facebook.p$b
        public void b(s s) {
            boolean obj9;
            if (d.F1(this.d).get()) {
            }
            if (s.b() != null) {
                this.d.U1(s.b().e());
            }
            obj9 = s.c();
            final String string = obj9.getString("id");
            final b0.b bVar = b0.J(obj9);
            a.a(d.H1(this.d).d());
            if (q.j(o.g()).j().contains(a0.RequireConfirm) && !d.L1(this.d)) {
                if (!d.L1(this.d)) {
                    d.M1(this.d, true);
                    d.D1(this.d, string, bVar, this.a, obj9.getString("name"), this.b, this.c);
                }
            }
            d.K1(this.d, string, bVar, this.a, this.b, this.c);
        }
    }
    public d() {
        super();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        this.w = atomicBoolean;
        int i = 0;
        int i2 = 0;
    }

    static boolean B1(com.facebook.login.d d) {
        return d.A;
    }

    static void C1(com.facebook.login.d d, com.facebook.login.d.i d$i2) {
        d.Z1(i2);
    }

    static void D1(com.facebook.login.d d, String string2, b0.b b0$b3, String string4, String string5, Date date6, Date date7) {
        d.X1(string2, b3, string4, string5, date6, date7);
    }

    static void E1(com.facebook.login.d d) {
        d.W1();
    }

    static AtomicBoolean F1(com.facebook.login.d d) {
        return d.w;
    }

    static void G1(com.facebook.login.d d) {
        d.Y1();
    }

    static com.facebook.login.d.i H1(com.facebook.login.d d) {
        return d.z;
    }

    static com.facebook.login.l.d I1(com.facebook.login.d d) {
        return d.C;
    }

    static void J1(com.facebook.login.d d, String string2, Long long3, Long long4) {
        d.V1(string2, long3, long4);
    }

    static void K1(com.facebook.login.d d, String string2, b0.b b0$b3, String string4, Date date5, Date date6) {
        d.O1(string2, b3, string4, date5, date6);
    }

    static boolean L1(com.facebook.login.d d) {
        return d.B;
    }

    static boolean M1(com.facebook.login.d d, boolean z2) {
        d.B = z2;
        return z2;
    }

    private void O1(String string, b0.b b0$b2, String string3, Date date4, Date date5) {
        obj.v.t(string3, o.g(), string, b2.c(), b2.a(), b2.b(), f.DEVICE_AUTH, date4, 0, date5);
        getDialog().dismiss();
    }

    private p Q1() {
        Bundle bundle = new Bundle();
        bundle.putString("code", this.z.c());
        d.e eVar = new d.e(this);
        super(0, "device/login_status", bundle, t.POST, eVar);
        return pVar2;
    }

    private void V1(String string, Long long2, Long long3) {
        Date date;
        int cmp;
        int date2;
        int i2;
        int i;
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,permissions,name");
        int i4 = 0;
        int i3 = 1000;
        if (Long.compare(longValue, i4) != 0) {
            Date date3 = new Date();
            date = new Date(time += i, obj8);
        } else {
            date = date2;
        }
        if (Long.compare(longValue3, i4) != 0 && long3 != null) {
            if (long3 != null) {
                date2 = new Date(longValue2 *= i3, obj5);
            }
        }
        super(string, o.g(), "0", 0, 0, 0, 0, date, 0, date2);
        d.h hVar = new d.h(this, string, date, date2);
        super(aVar, "me", bundle, t.GET, hVar);
        pVar2.j();
    }

    private void W1() {
        Date date = new Date();
        this.z.f(date.getTime());
        this.x = Q1().j();
    }

    private void X1(String string, b0.b b0$b2, String string3, String string4, Date date5, Date date6) {
        int i4 = 1;
        Object[] arr = new Object[i4];
        arr[0] = string4;
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        super(this, string, b2, string3, date5, date6);
        com.facebook.login.d dVar = this;
        d.f fVar = new d.f(this);
        builder.setMessage(getResources().getString(d.g)).setCancelable(i4).setNegativeButton(String.format(getResources().getString(d.f), arr), gVar).setPositiveButton(getResources().getString(d.e), fVar);
        builder.create().show();
    }

    private void Y1() {
        d.d dVar = new d.d(this);
        this.y = e.q().schedule(dVar, this.z.b(), obj3);
    }

    private void Z1(com.facebook.login.d.i d$i) {
        boolean mVar;
        int str;
        this.z = i;
        this.b.setText(i.d());
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), a.c(i.a()));
        int i3 = 0;
        this.c.setCompoundDrawablesWithIntrinsicBounds(i3, bitmapDrawable, i3, i3);
        this.b.setVisibility(0);
        this.a.setVisibility(8);
        if (!this.B && a.g(i.d())) {
            if (a.g(i.d())) {
                mVar = new m(getContext());
                mVar.f("fb_smart_login_service");
            }
        }
        if (i.i()) {
            Y1();
        } else {
            W1();
        }
    }

    Map<String, String> N1() {
        return 0;
    }

    @Override // androidx.fragment.app.d
    protected int P1(boolean z) {
        int obj1;
        obj1 = z ? c.d : c.b;
        return obj1;
    }

    @Override // androidx.fragment.app.d
    protected View R1(boolean z) {
        View obj3 = getActivity().getLayoutInflater().inflate(P1(z), 0);
        this.a = obj3.findViewById(b.f);
        this.b = (TextView)obj3.findViewById(b.e);
        d.c cVar = new d.c(this);
        (Button)obj3.findViewById(b.a).setOnClickListener(cVar);
        View viewById4 = obj3.findViewById(b.b);
        this.c = (TextView)viewById4;
        viewById4.setText(Html.fromHtml(getString(d.a)));
        return obj3;
    }

    @Override // androidx.fragment.app.d
    protected void S1() {
    }

    @Override // androidx.fragment.app.d
    protected void T1() {
        Object iVar;
        if (!this.w.compareAndSet(false, true)) {
        }
        if (this.z != null) {
            a.a(this.z.d());
        }
        com.facebook.login.e eVar = this.v;
        if (eVar != null) {
            eVar.r();
        }
        getDialog().dismiss();
    }

    @Override // androidx.fragment.app.d
    protected void U1(FacebookException facebookException) {
        Object iVar;
        if (!this.w.compareAndSet(false, true)) {
        }
        if (this.z != null) {
            a.a(this.z.d());
        }
        this.v.s(facebookException);
        getDialog().dismiss();
    }

    @Override // androidx.fragment.app.d
    public void a2(com.facebook.login.l.d l$d) {
        String str2;
        String str;
        this.C = d;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", d.k()));
        str2 = d.f();
        if (str2 != null) {
            bundle.putString("redirect_uri", str2);
        }
        String obj7 = d.e();
        if (obj7 != null) {
            bundle.putString("target_user_id", obj7);
        }
        obj7 = new StringBuilder();
        obj7.append(c0.b());
        obj7.append("|");
        obj7.append(c0.c());
        bundle.putString("access_token", obj7.toString());
        bundle.putString("device_info", a.e(N1()));
        d.b bVar = new d.b(this);
        super(0, "device/login", bundle, t.POST, bVar);
        obj7.j();
    }

    @Override // androidx.fragment.app.d
    public Dialog onCreateDialog(Bundle bundle) {
        boolean z;
        int i;
        d.a obj3 = new d.a(this, getActivity(), e.b);
        if (a.f() && !this.B) {
            i = !this.B ? 1 : 0;
        } else {
        }
        obj3.setContentView(R1(i));
        return obj3;
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        Parcelable obj2;
        this.v = (e)(n)(FacebookActivity)getActivity().getCurrentFragment().E1().j();
        obj2 = bundle3.getParcelable("request_state");
        if (bundle3 != null && (d.i)obj2 != null) {
            obj2 = bundle3.getParcelable("request_state");
            if ((d.i)(d.i)obj2 != null) {
                Z1((d.i)(d.i)obj2);
            }
        }
        return super.onCreateView(layoutInflater, viewGroup2, bundle3);
    }

    @Override // androidx.fragment.app.d
    public void onDestroyView() {
        q qVar;
        ScheduledFuture future;
        int i = 1;
        this.A = i;
        this.w.set(i);
        super.onDestroyView();
        if (this.x != null) {
            this.x.cancel(i);
        }
        if (this.y != null) {
            this.y.cancel(i);
        }
        int i2 = 0;
        this.a = i2;
        this.b = i2;
        this.c = i2;
    }

    @Override // androidx.fragment.app.d
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (!this.A) {
            T1();
        }
    }

    @Override // androidx.fragment.app.d
    public void onSaveInstanceState(Bundle bundle) {
        com.facebook.login.d.i iVar;
        String str;
        super.onSaveInstanceState(bundle);
        if (this.z != null) {
            bundle.putParcelable("request_state", this.z);
        }
    }
}
