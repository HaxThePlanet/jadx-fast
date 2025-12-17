package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {

    public static final Parcelable.Creator<androidx.versionedparcelable.ParcelImpl> CREATOR;
    private final androidx.versionedparcelable.c a;

    static class a implements Parcelable.Creator<androidx.versionedparcelable.ParcelImpl> {
        @Override // android.os.Parcelable$Creator
        public androidx.versionedparcelable.ParcelImpl a(Parcel parcel) {
            ParcelImpl parcelImpl = new ParcelImpl(parcel);
            return parcelImpl;
        }

        @Override // android.os.Parcelable$Creator
        public androidx.versionedparcelable.ParcelImpl[] b(int i) {
            return new ParcelImpl[i];
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
        ParcelImpl.a aVar = new ParcelImpl.a();
        ParcelImpl.CREATOR = aVar;
    }

    protected ParcelImpl(Parcel parcel) {
        super();
        b bVar = new b(parcel);
        this.a = bVar.u();
    }

    public <T extends androidx.versionedparcelable.c> T a() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        b obj2 = new b(parcel);
        obj2.L(this.a);
    }
}
