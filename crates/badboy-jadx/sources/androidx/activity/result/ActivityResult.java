package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0008\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\u000e\u001a\u00020\u0006H\u0016J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0006H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u0016", d2 = {"Landroidx/activity/result/ActivityResult;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "resultCode", "", "data", "Landroid/content/Intent;", "(ILandroid/content/Intent;)V", "getData", "()Landroid/content/Intent;", "getResultCode", "()I", "describeContents", "toString", "", "writeToParcel", "", "dest", "flags", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActivityResult implements Parcelable {

    public static final Parcelable.Creator<androidx.activity.result.ActivityResult> CREATOR;
    public static final androidx.activity.result.ActivityResult.Companion Companion;
    private final Intent data;
    private final int resultCode;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0007R\u001c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0002¨\u0006\u000b", d2 = {"Landroidx/activity/result/ActivityResult$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/activity/result/ActivityResult;", "getCREATOR$annotations", "resultCodeToString", "", "resultCode", "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getCREATOR$annotations() {
        }

        @JvmStatic
        public final String resultCodeToString(int resultCode) {
            String valueOf;
            switch (resultCode) {
                case -1:
                    valueOf = "RESULT_OK";
                    break;
                case 0:
                    valueOf = "RESULT_CANCELED";
                    break;
                default:
                    valueOf = String.valueOf(resultCode);
            }
            return valueOf;
        }
    }
    static {
        ActivityResult.Companion companion = new ActivityResult.Companion(0);
        ActivityResult.Companion = companion;
        ActivityResult.Companion.CREATOR.1 anon = new ActivityResult.Companion.CREATOR.1();
        ActivityResult.CREATOR = (Parcelable.Creator)anon;
    }

    public ActivityResult(int resultCode, Intent data) {
        super();
        this.resultCode = resultCode;
        this.data = data;
    }

    public ActivityResult(Parcel parcel) {
        int fromParcel;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (parcel.readInt() == 0) {
            fromParcel = 0;
        } else {
            fromParcel = Intent.CREATOR.createFromParcel(parcel);
        }
        super(parcel.readInt(), fromParcel);
    }

    @JvmStatic
    public static final String resultCodeToString(int resultCode) {
        return ActivityResult.Companion.resultCodeToString(resultCode);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final Intent getData() {
        return this.data;
    }

    @Override // android.os.Parcelable
    public final int getResultCode() {
        return this.resultCode;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ActivityResult{resultCode=").append(ActivityResult.Companion.resultCodeToString(this.resultCode)).append(", data=").append(this.data).append('}').toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        int i;
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.resultCode);
        i = this.data == null ? 0 : 1;
        dest.writeInt(i);
        Intent data2 = this.data;
        if (data2 != null) {
            data2.writeToParcel(dest, flags);
        }
    }
}
