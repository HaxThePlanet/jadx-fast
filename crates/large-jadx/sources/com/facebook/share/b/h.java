package com.facebook.share.b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class h<P extends com.facebook.share.b.h, E extends com.facebook.share.b.h.a>  implements Parcelable {

    private final Bundle a;

    public static abstract class a {

        private Bundle a;
        public a() {
            super();
            Bundle bundle = new Bundle();
            this.a = bundle;
        }

        static Bundle a(com.facebook.share.b.h.a h$a) {
            return a.a;
        }

        public E b(String string, String string2) {
            this.a.putString(string, string2);
            return this;
        }

        public E c(P p) {
            Bundle bundle;
            Bundle obj2;
            if (p != null) {
                this.a.putAll(p.b());
            }
            return this;
        }
    }
    h(Parcel parcel) {
        super();
        this.a = parcel.readBundle(h.a.class.getClassLoader());
    }

    protected h(com.facebook.share.b.h.a<P, E> h$a) {
        super();
        this.a = (Bundle)h.a.a(a).clone();
    }

    @Override // android.os.Parcelable
    public Object a(String string) {
        return this.a.get(string);
    }

    @Override // android.os.Parcelable
    public Bundle b() {
        return (Bundle)this.a.clone();
    }

    @Override // android.os.Parcelable
    public String c(String string) {
        return this.a.getString(string);
    }

    public Set<String> d() {
        return this.a.keySet();
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
