package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.y.j0;

/* compiled from: InAppFeedbackExtras.kt */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001BK\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\u0008\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u0007\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0008¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\t\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\r¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "Landroid/os/Parcelable;", "examId", "", "trickId", "trainerId", "country", "isDogPremium", "", "isExamPassed", "trainerEmail", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getCountry", "()Ljava/lang/String;", "getExamId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTrainerEmail", "getTrainerId", "getTrickId", "describeContents", "", "toMap", "", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class InAppFeedbackExtras implements Parcelable {

    public static final Parcelable.Creator<InAppFeedbackExtras> CREATOR = new InAppFeedbackExtras$Creator<>();
    private final String country;
    private final String examId;
    private final Boolean isDogPremium;
    private final Boolean isExamPassed;
    private final String trainerEmail;
    private final String trainerId;
    private final String trickId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<InAppFeedbackExtras> {
        @Override // android.os.Parcelable$Creator
        public final InAppFeedbackExtras createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            Boolean str2;
            Boolean str;
            n.f(parcel, "parcel");
            int i = 1;
            int i2 = 0;
            int i3 = 0;
            if (parcel.readInt() == 0) {
            } else {
                int r1 = parcel.readInt() != 0 ? 1 : i2;
                str = (parcel.readInt() != 0 ? 1 : i2);
            }
            if (parcel.readInt() == 0) {
            } else {
                if (parcel.readInt() == 0) {
                }
            }
            InAppFeedbackExtras inAppFeedbackExtras = new InAppFeedbackExtras(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), str, str2, parcel.readString());
            return inAppFeedbackExtras;
        }

        @Override // android.os.Parcelable$Creator
        public final InAppFeedbackExtras[] newArray(int i) {
            return new InAppFeedbackExtras[i];
        }
    }
    public InAppFeedbackExtras(String str, String str2, String str3, String str4, Boolean boolean, Boolean boolean2, String str5) {
        super();
        this.examId = str;
        this.trickId = str2;
        this.trainerId = str3;
        this.country = str4;
        this.isDogPremium = boolean;
        this.isExamPassed = boolean2;
        this.trainerEmail = str5;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getExamId() {
        return this.examId;
    }

    public final String getTrainerEmail() {
        return this.trainerEmail;
    }

    public final String getTrainerId() {
        return this.trainerId;
    }

    public final String getTrickId() {
        return this.trickId;
    }

    public final Boolean isDogPremium() {
        return this.isDogPremium;
    }

    public final Boolean isExamPassed() {
        return this.isExamPassed;
    }

    public final Map<String, Object> toMap() {
        LinkedHashMap linkedHashMap = null;
        String str;
        o[] arr = new o[7];
        int i = 0;
        arr[i] = new Pair("examId", this.examId);
        int i3 = 1;
        arr[i3] = new Pair("trickId", this.trickId);
        arr[2] = new Pair("trainerId", this.trainerId);
        arr[3] = new Pair("country", this.country);
        arr[4] = new Pair("isDogPremium", this.isDogPremium);
        arr[5] = new Pair("isExamPassed", this.isExamPassed);
        str = "trainerEmail";
        int i4 = 6;
        arr[i4] = new Pair(str, this.trainerEmail);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator it = j0.k(arr).entrySet().iterator();
        while (it.hasNext()) {
            Object item2 = it.next();
            int r5 = item2.getValue() != null ? i3 : i;
        }
        linkedHashMap = new LinkedHashMap(j0.d(linkedHashMap2.size()));
        Iterator it2 = linkedHashMap2.entrySet().iterator();
        while (it2.hasNext()) {
            Object item = it2.next();
            Object value = item.getValue();
            str = "null cannot be cast to non-null type kotlin.Any";
            Objects.requireNonNull(value, str);
            linkedHashMap.put(item.getKey(), value);
        }
        if (!(linkedHashMap.isEmpty() ^ i3)) {
            int i6 = 0;
        }
        return linkedHashMap;
    }


    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.examId);
        parcel.writeString(this.trickId);
        parcel.writeString(this.trainerId);
        parcel.writeString(this.country);
        final int i = 0;
        final int i2 = 1;
        if (this.isDogPremium == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeInt(this.isDogPremium.booleanValue());
        }
        if (this.isExamPassed == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeInt(this.isExamPassed.booleanValue());
        }
        parcel.writeString(this.trainerEmail);
    }
}
