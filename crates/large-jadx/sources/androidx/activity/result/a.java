package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* loaded from: classes.dex */
public final class a implements Parcelable {

    public static final Parcelable.Creator<androidx.activity.result.a> CREATOR;
    private final int a;
    private final Intent b;

    class a implements Parcelable.Creator<androidx.activity.result.a> {
        @Override // android.os.Parcelable$Creator
        public androidx.activity.result.a a(Parcel parcel) {
            a aVar = new a(parcel);
            return aVar;
        }

        @Override // android.os.Parcelable$Creator
        public androidx.activity.result.a[] b(int i) {
            return new a[i];
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
        a.a aVar = new a.a();
        a.CREATOR = aVar;
    }

    public a(int i, Intent intent2) {
        super();
        this.a = i;
        this.b = intent2;
    }

    a(Parcel parcel) {
        int cREATOR;
        int obj2;
        super();
        this.a = parcel.readInt();
        if (parcel.readInt() == 0) {
            obj2 = 0;
        } else {
            obj2 = Intent.CREATOR.createFromParcel(parcel);
        }
        this.b = obj2;
    }

    public static String c(int i) {
        if (i != -1 && i != 0) {
            if (i != 0) {
                return String.valueOf(i);
            }
            return "RESULT_CANCELED";
        }
        return "RESULT_OK";
    }

    @Override // android.os.Parcelable
    public Intent a() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int b() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActivityResult{resultCode=");
        stringBuilder.append(a.c(this.a));
        stringBuilder.append(", data=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        parcel.writeInt(this.a);
        i = this.b == null ? 0 : 1;
        parcel.writeInt(i);
        Intent intent2 = this.b;
        if (intent2 != null) {
            intent2.writeToParcel(parcel, i2);
        }
    }
}
