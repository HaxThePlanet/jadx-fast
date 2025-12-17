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

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001BK\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\u0008\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u0007\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0008¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\t\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\r¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/InAppFeedbackExtras;", "Landroid/os/Parcelable;", "examId", "", "trickId", "trainerId", "country", "isDogPremium", "", "isExamPassed", "trainerEmail", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getCountry", "()Ljava/lang/String;", "getExamId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTrainerEmail", "getTrainerId", "getTrickId", "describeContents", "", "toMap", "", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InAppFeedbackExtras implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.InAppFeedbackExtras> CREATOR;
    private final String country;
    private final String examId;
    private final Boolean isDogPremium;
    private final Boolean isExamPassed;
    private final String trainerEmail;
    private final String trainerId;
    private final String trickId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.InAppFeedbackExtras> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.InAppFeedbackExtras createFromParcel(Parcel parcel) {
            Boolean valueOf2;
            int valueOf;
            int i2;
            int i;
            int i3;
            Boolean bool;
            n.f(parcel, "parcel");
            int i4 = 0;
            int i5 = 0;
            if (parcel.readInt() == 0) {
                bool = i5;
            } else {
                i2 = parcel.readInt() != 0 ? i : i4;
                bool = valueOf2;
            }
            if (parcel.readInt() == 0) {
                i3 = i5;
            } else {
                if (parcel.readInt() != 0) {
                } else {
                    i = i4;
                }
                i3 = valueOf;
            }
            super(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), bool, i3, parcel.readString());
            return inAppFeedbackExtras;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.InAppFeedbackExtras[] newArray(int i) {
            return new InAppFeedbackExtras[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        InAppFeedbackExtras.Creator creator = new InAppFeedbackExtras.Creator();
        InAppFeedbackExtras.CREATOR = creator;
    }

    public InAppFeedbackExtras(String string, String string2, String string3, String string4, Boolean boolean5, Boolean boolean6, String string7) {
        super();
        this.examId = string;
        this.trickId = string2;
        this.trainerId = string3;
        this.country = string4;
        this.isDogPremium = boolean5;
        this.isExamPassed = boolean6;
        this.trainerEmail = string7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final String getCountry() {
        return this.country;
    }

    @Override // android.os.Parcelable
    public final String getExamId() {
        return this.examId;
    }

    @Override // android.os.Parcelable
    public final String getTrainerEmail() {
        return this.trainerEmail;
    }

    @Override // android.os.Parcelable
    public final String getTrainerId() {
        return this.trainerId;
    }

    @Override // android.os.Parcelable
    public final String getTrickId() {
        return this.trickId;
    }

    @Override // android.os.Parcelable
    public final Boolean isDogPremium() {
        return this.isDogPremium;
    }

    @Override // android.os.Parcelable
    public final Boolean isExamPassed() {
        return this.isExamPassed;
    }

    public final Map<String, Object> toMap() {
        LinkedHashMap linkedHashMap;
        int value;
        int value2;
        boolean next;
        String str;
        o[] arr = new o[7];
        o oVar = new o("examId", this.examId);
        int i3 = 0;
        arr[i3] = oVar;
        o oVar2 = new o("trickId", this.trickId);
        int i4 = 1;
        arr[i4] = oVar2;
        o oVar3 = new o("trainerId", this.trainerId);
        arr[2] = oVar3;
        o oVar4 = new o("country", this.country);
        arr[3] = oVar4;
        o oVar5 = new o("isDogPremium", this.isDogPremium);
        arr[4] = oVar5;
        o oVar6 = new o("isExamPassed", this.isExamPassed);
        arr[5] = oVar6;
        o oVar7 = new o("trainerEmail", this.trainerEmail);
        arr[6] = oVar7;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator iterator = j0.k(arr).entrySet().iterator();
        while (iterator.hasNext()) {
            value2 = iterator.next();
            if ((Map.Entry)value2.getValue() != null) {
            } else {
            }
            str = i3;
            if (str != null) {
            }
            linkedHashMap2.put(value2.getKey(), value2.getValue());
            str = i4;
        }
        linkedHashMap = new LinkedHashMap(j0.d(linkedHashMap2.size()));
        Iterator iterator2 = linkedHashMap2.entrySet().iterator();
        for (Map.Entry next3 : iterator2) {
            value = next3.getValue();
            Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Any");
            linkedHashMap.put(next3.getKey(), value);
        }
        if (empty ^= i4 != 0) {
        } else {
            linkedHashMap = 0;
        }
        return linkedHashMap;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Boolean obj4;
        n.f(parcel, "out");
        parcel.writeString(this.examId);
        parcel.writeString(this.trickId);
        parcel.writeString(this.trainerId);
        parcel.writeString(this.country);
        obj4 = this.isDogPremium;
        final int i = 0;
        final int i3 = 1;
        if (obj4 == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeInt(obj4.booleanValue());
        }
        obj4 = this.isExamPassed;
        if (obj4 == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeInt(obj4.booleanValue());
        }
        parcel.writeString(this.trainerEmail);
    }
}
