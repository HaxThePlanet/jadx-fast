package com.google.android.gms.cloudmessaging;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* loaded from: classes2.dex */
public final class i implements Parcelable {

    public static final Parcelable.Creator<com.google.android.gms.cloudmessaging.i> CREATOR;
    Messenger a;
    com.google.android.gms.cloudmessaging.c b;
    static {
        g gVar = new g();
        i.CREATOR = gVar;
    }

    public i(IBinder iBinder) {
        super();
        if (Build.VERSION.SDK_INT >= 21) {
            Messenger messenger = new Messenger(iBinder);
            this.a = messenger;
        }
        c.a aVar = new c.a(iBinder);
        this.b = aVar;
    }

    @Override // android.os.Parcelable
    public final IBinder a() {
        IBinder binder;
        Messenger messenger = this.a;
        if (messenger != null) {
            binder = messenger.getBinder();
        } else {
            binder = this.b.asBinder();
        }
        return binder;
    }

    @Override // android.os.Parcelable
    public final void b(Message message) {
        Messenger messenger = this.a;
        if (messenger != null) {
            messenger.send(message);
        }
        this.b.L(message);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final boolean equals(Object object) {
        if (object == null) {
            return 0;
        }
        return a().equals((i)object.a());
    }

    @Override // android.os.Parcelable
    public final int hashCode() {
        return a().hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        Messenger obj2 = this.a;
        if (obj2 != null) {
            parcel.writeStrongBinder(obj2.getBinder());
        }
        parcel.writeStrongBinder(this.b.asBinder());
    }
}
