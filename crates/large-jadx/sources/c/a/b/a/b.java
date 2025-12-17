package c.a.b.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* loaded from: classes.dex */
public class b implements Parcelable {

    public static final Parcelable.Creator<c.a.b.a.b> CREATOR;
    final Handler a = null;
    c.a.b.a.a b;

    class a implements Parcelable.Creator<c.a.b.a.b> {
        @Override // android.os.Parcelable$Creator
        public c.a.b.a.b a(Parcel parcel) {
            b bVar = new b(parcel);
            return bVar;
        }

        @Override // android.os.Parcelable$Creator
        public c.a.b.a.b[] b(int i) {
            return new b[i];
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

    class c implements Runnable {

        final int a;
        final Bundle b;
        final c.a.b.a.b c;
        c(c.a.b.a.b b, int i2, Bundle bundle3) {
            this.c = b;
            super();
            this.a = i2;
            this.b = bundle3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.a(this.a, this.b);
        }
    }

    class b extends c.a.b.a.a.a {

        final c.a.b.a.b a;
        b(c.a.b.a.b b) {
            this.a = b;
            super();
        }

        @Override // c.a.b.a.a$a
        public void l2(int i, Bundle bundle2) {
            c.a.b.a.b.c cVar;
            final c.a.b.a.b bVar = this.a;
            final Handler handler = bVar.a;
            if (handler != null) {
                cVar = new b.c(bVar, i, bundle2);
                handler.post(cVar);
            } else {
                bVar.a(i, bundle2);
            }
        }
    }
    static {
        b.a aVar = new b.a();
        b.CREATOR = aVar;
    }

    b(Parcel parcel) {
        super();
        final int i = 0;
        this.b = a.a.j(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable
    protected void a(int i, Bundle bundle2) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        c.a.b.a.a obj2;
        synchronized (this) {
            try {
                obj2 = new b.b(this);
                this.b = obj2;
                parcel.writeStrongBinder(this.b.asBinder());
                throw parcel;
            }
        }
    }
}
