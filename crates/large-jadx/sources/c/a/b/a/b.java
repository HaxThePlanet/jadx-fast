package c.a.b.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: ResultReceiver.java */
/* loaded from: classes.dex */
public class b implements Parcelable {

    public static final Parcelable.Creator<b> CREATOR = new b$a<>();
    final Handler a = null;
    a b;

    class a implements Parcelable.Creator<b> {
        a() {
            super();
        }

        public b a(Parcel parcel) {
            return new b(parcel);
        }

        public b[] b(int i) {
            return new b[i];
        }
    }

    class c implements Runnable {

        final int a;
        final Bundle b;
        final /* synthetic */ b c;
        c(int i, Bundle bundle) {
            this.c = bVar;
            super();
            this.a = i;
            this.b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.a(this.a, this.b);
        }
    }

    class b extends a.a {

        final /* synthetic */ b a;
        b() {
            this.a = bVar;
            super();
        }

        @Override // c.a.b.a.a$a
        public void l2(int i, Bundle bundle) {
            if (bVar.a != null) {
                bVar.a.post(new b.c(bVar, i, bundle));
            } else {
                this.a.a(i, bundle);
            }
        }
    }

    b(Parcel parcel) {
        super();
        this.b = a.a.j(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            try {
                if (this.b == null) {
                    this.b = new b.b(this);
                }
                parcel.writeStrongBinder(this.b.asBinder());
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    protected void a(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
