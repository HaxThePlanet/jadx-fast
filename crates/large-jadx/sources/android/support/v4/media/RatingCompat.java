package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {

    public static final Parcelable.Creator<android.support.v4.media.RatingCompat> CREATOR;
    private final int a;
    private final float b;

    class a implements Parcelable.Creator<android.support.v4.media.RatingCompat> {
        @Override // android.os.Parcelable$Creator
        public android.support.v4.media.RatingCompat a(Parcel parcel) {
            RatingCompat ratingCompat = new RatingCompat(parcel.readInt(), parcel.readFloat());
            return ratingCompat;
        }

        @Override // android.os.Parcelable$Creator
        public android.support.v4.media.RatingCompat[] b(int i) {
            return new RatingCompat[i];
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
        RatingCompat.a aVar = new RatingCompat.a();
        RatingCompat.CREATOR = aVar;
    }

    RatingCompat(int i, float f2) {
        super();
        this.a = i;
        this.b = f2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public String toString() {
        String valueOf;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rating:style=");
        stringBuilder.append(this.a);
        stringBuilder.append(" rating=");
        float f = this.b;
        if (Float.compare(f, i2) < 0) {
            valueOf = "unrated";
        } else {
            valueOf = String.valueOf(f);
        }
        stringBuilder.append(valueOf);
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeFloat(this.b);
    }
}
