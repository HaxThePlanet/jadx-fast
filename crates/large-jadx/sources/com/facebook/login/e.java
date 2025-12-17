package com.facebook.login;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.d;
import androidx.fragment.app.e;
import com.facebook.a;
import com.facebook.f;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes.dex */
class e extends com.facebook.login.q {

    public static final Parcelable.Creator<com.facebook.login.e> CREATOR;
    private static ScheduledThreadPoolExecutor v;

    static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable$Creator
        public com.facebook.login.e a(Parcel parcel) {
            e eVar = new e(parcel);
            return eVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.login.e[] b(int i) {
            return new e[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }
    static {
        e.a aVar = new e.a();
        e.CREATOR = aVar;
    }

    protected e(Parcel parcel) {
        super(parcel);
    }

    e(com.facebook.login.l l) {
        super(l);
    }

    public static ScheduledThreadPoolExecutor q() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        int i;
        final Class<com.facebook.login.e> obj = e.class;
        synchronized (obj) {
            scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
            e.v = scheduledThreadPoolExecutor;
            return e.v;
        }
    }

    private void u(com.facebook.login.l.d l$d) {
        Object supportFragmentManager;
        com.facebook.login.d finishing;
        String str;
        supportFragmentManager = f().i();
        if (supportFragmentManager != null) {
            if (supportFragmentManager.isFinishing()) {
            } else {
                finishing = p();
                finishing.show(supportFragmentManager.getSupportFragmentManager(), "login_with_facebook");
                finishing.a2(d);
            }
        }
    }

    @Override // com.facebook.login.q
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.q
    public String h() {
        return "device_auth";
    }

    @Override // com.facebook.login.q
    public int o(com.facebook.login.l.d l$d) {
        u(d);
        return 1;
    }

    @Override // com.facebook.login.q
    protected com.facebook.login.d p() {
        d dVar = new d();
        return dVar;
    }

    @Override // com.facebook.login.q
    public void r() {
        f().g(l.e.a(f().q(), "User canceled log in."));
    }

    @Override // com.facebook.login.q
    public void s(Exception exception) {
        f().g(l.e.c(f().q(), 0, exception.getMessage()));
    }

    public void t(String string, String string2, String string3, Collection<String> collection4, Collection<String> collection5, Collection<String> collection6, f f7, Date date8, Date date9, Date date10) {
        super(string, string2, string3, collection4, collection5, collection6, f7, date8, date9, date10);
        f().g(l.e.e(f().q(), aVar2));
    }

    @Override // com.facebook.login.q
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
    }
}
