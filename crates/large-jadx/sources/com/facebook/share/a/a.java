package com.facebook.share.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.n;
import androidx.fragment.app.w;
import com.facebook.common.b;
import com.facebook.common.c;
import com.facebook.common.d;
import com.facebook.common.e;
import com.facebook.f0.a.a;
import com.facebook.internal.c0;
import com.facebook.internal.g0.i.a;
import com.facebook.n;
import com.facebook.p;
import com.facebook.p.b;
import com.facebook.s;
import com.facebook.share.b.a;
import com.facebook.t;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Deprecated
public class a extends d {

    private static ScheduledThreadPoolExecutor y;
    private ProgressBar a;
    private TextView b;
    private Dialog c;
    private volatile com.facebook.share.a.a.d v;
    private volatile ScheduledFuture w;
    private a x;

    class a implements View.OnClickListener {

        final com.facebook.share.a.a a;
        a(com.facebook.share.a.a a) {
            this.a = a;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            if (a.d(this)) {
            }
            a.B1(this.a).dismiss();
        }
    }

    class c implements Runnable {

        final com.facebook.share.a.a a;
        c(com.facebook.share.a.a a) {
            this.a = a;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.d(this)) {
            }
            a.B1(this.a).dismiss();
        }
    }

    private static class d implements Parcelable {

        public static final Parcelable.Creator<com.facebook.share.a.a.d> CREATOR;
        private String a;
        private long b;
        static {
            a.d.a aVar = new a.d.a();
            a.d.CREATOR = aVar;
        }

        protected d(Parcel parcel) {
            super();
            this.a = parcel.readString();
            this.b = parcel.readLong();
        }

        @Override // android.os.Parcelable
        public long a() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public String b() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void c(long l) {
            this.b = l;
        }

        @Override // android.os.Parcelable
        public void d(String string) {
            this.a = string;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.a);
            parcel.writeLong(this.b);
        }
    }

    class b implements p.b {

        final com.facebook.share.a.a a;
        b(com.facebook.share.a.a a) {
            this.a = a;
            super();
        }

        @Override // com.facebook.p$b
        public void b(s s) {
            n nVar2 = s.b();
            if (nVar2 != null) {
                a.C1(this.a, nVar2);
            }
            JSONObject obj5 = s.c();
            a.d dVar = new a.d();
            dVar.d(obj5.getString("user_code"));
            dVar.c(obj5.getLong("expires_in"));
            a.D1(this.a, dVar);
        }
    }
    static Dialog B1(com.facebook.share.a.a a) {
        return a.c;
    }

    static void C1(com.facebook.share.a.a a, n n2) {
        a.G1(n2);
    }

    static void D1(com.facebook.share.a.a a, com.facebook.share.a.a.d a$d2) {
        a.J1(d2);
    }

    private void E1() {
        boolean added;
        if (isAdded()) {
            added = getFragmentManager().n();
            added.n(this);
            added.g();
        }
    }

    private void F1(int i, Intent intent2) {
        Object dVar;
        Object parcelableExtra;
        boolean activity;
        android.content.Context context;
        int i2;
        if (this.v != null) {
            a.a(this.v.b());
        }
        parcelableExtra = intent2.getParcelableExtra("error");
        if ((n)parcelableExtra != null) {
            Toast.makeText(getContext(), (n)parcelableExtra.c(), 0).show();
        }
        if (isAdded()) {
            activity = getActivity();
            activity.setResult(i, intent2);
            activity.finish();
        }
    }

    private void G1(n n) {
        E1();
        Intent intent = new Intent();
        intent.putExtra("error", n);
        F1(-1, intent);
    }

    private static ScheduledThreadPoolExecutor H1() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        int i;
        final Class<com.facebook.share.a.a> obj = a.class;
        synchronized (obj) {
            scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
            a.y = scheduledThreadPoolExecutor;
            return a.y;
        }
    }

    private Bundle I1() {
        a aVar = this.x;
        final int i = 0;
        if (aVar == null) {
            return i;
        }
        if (aVar instanceof c) {
            return d.a((c)aVar);
        }
        if (aVar instanceof f) {
            return d.b((f)aVar);
        }
        return i;
    }

    private void J1(com.facebook.share.a.a.d a$d) {
        this.v = d;
        this.b.setText(d.b());
        this.b.setVisibility(0);
        this.a.setVisibility(8);
        a.c cVar = new a.c(this);
        this.w = a.H1().schedule(cVar, d.a(), obj3);
    }

    private void L1() {
        int nVar;
        int i;
        String str2;
        String str;
        final Bundle bundle = I1();
        if (bundle != null) {
            if (bundle.size() == 0) {
                nVar = new n(0, "", "Failed to get share content");
                G1(nVar);
            }
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c0.b());
        stringBuilder.append("|");
        stringBuilder.append(c0.c());
        bundle.putString("access_token", stringBuilder.toString());
        bundle.putString("device_info", a.d());
        a.b bVar = new a.b(this);
        super(0, "device/share", bundle, t.POST, bVar);
        pVar2.j();
    }

    @Override // androidx.fragment.app.d
    public void K1(a a) {
        this.x = a;
    }

    @Override // androidx.fragment.app.d
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog obj3 = new Dialog(getActivity(), e.b);
        this.c = obj3;
        obj3 = getActivity().getLayoutInflater().inflate(c.b, 0);
        this.a = (ProgressBar)obj3.findViewById(b.f);
        this.b = (TextView)obj3.findViewById(b.e);
        a.a aVar = new a.a(this);
        (Button)obj3.findViewById(b.a).setOnClickListener(aVar);
        (TextView)obj3.findViewById(b.b).setText(Html.fromHtml(getString(d.a)));
        this.c.setContentView(obj3);
        L1();
        return this.c;
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        Object obj2;
        obj2 = bundle3.getParcelable("request_state");
        if (bundle3 != null && (a.d)obj2 != null) {
            obj2 = bundle3.getParcelable("request_state");
            if ((a.d)(a.d)obj2 != null) {
                J1((a.d)(a.d)obj2);
            }
        }
        return super.onCreateView(layoutInflater, viewGroup2, bundle3);
    }

    @Override // androidx.fragment.app.d
    public void onDismiss(DialogInterface dialogInterface) {
        int i;
        ScheduledFuture obj2;
        super.onDismiss(dialogInterface);
        if (this.w != null) {
            this.w.cancel(true);
        }
        obj2 = new Intent();
        F1(-1, obj2);
    }

    @Override // androidx.fragment.app.d
    public void onSaveInstanceState(Bundle bundle) {
        com.facebook.share.a.a.d dVar;
        String str;
        super.onSaveInstanceState(bundle);
        if (this.v != null) {
            bundle.putParcelable("request_state", this.v);
        }
    }
}
