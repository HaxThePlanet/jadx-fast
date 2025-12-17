package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {

    public static final Parcelable.Creator<android.support.v4.media.session.ParcelableVolumeInfo> CREATOR;
    public int a;
    public int b;
    public int c;
    public int v;
    public int w;

    class a implements Parcelable.Creator<android.support.v4.media.session.ParcelableVolumeInfo> {
        @Override // android.os.Parcelable$Creator
        public android.support.v4.media.session.ParcelableVolumeInfo a(Parcel parcel) {
            ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo(parcel);
            return parcelableVolumeInfo;
        }

        @Override // android.os.Parcelable$Creator
        public android.support.v4.media.session.ParcelableVolumeInfo[] b(int i) {
            return new ParcelableVolumeInfo[i];
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
        ParcelableVolumeInfo.a aVar = new ParcelableVolumeInfo.a();
        ParcelableVolumeInfo.CREATOR = aVar;
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        super();
        this.a = parcel.readInt();
        this.c = parcel.readInt();
        this.v = parcel.readInt();
        this.w = parcel.readInt();
        this.b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.c);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeInt(this.b);
    }
}
