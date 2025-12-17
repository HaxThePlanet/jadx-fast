package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.u.k;
import app.dogo.com.dogo_android.u.k.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008%\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u00012\u00020\u0002:\u0001CB\u0093\u0001\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0004\u0012\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u000e\u0008\u0002\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0013\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000f¢\u0006\u0002\u0010\u0016J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u000fHÆ\u0003J\t\u0010*\u001a\u00020\u0013HÆ\u0003J\t\u0010+\u001a\u00020\u0013HÆ\u0003J\t\u0010,\u001a\u00020\u000fHÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0004HÆ\u0003J\t\u00100\u001a\u00020\u0004HÆ\u0003J\u000f\u00101\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000bHÆ\u0003J\u000f\u00102\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000bHÆ\u0003J\t\u00103\u001a\u00020\u000fHÆ\u0003J\t\u00104\u001a\u00020\u000fHÆ\u0003J\u0097\u0001\u00105\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00042\u0008\u0008\u0002\u0010\t\u001a\u00020\u00042\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000b2\u000e\u0008\u0002\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000b2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000fHÆ\u0001J\t\u00106\u001a\u00020\u0013HÖ\u0001J\u0013\u00107\u001a\u00020\u000f2\u0008\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\u0006\u0010:\u001a\u00020\u000fJ\t\u0010;\u001a\u00020\u0013HÖ\u0001J\u0006\u0010<\u001a\u00020\u000fJ\t\u0010=\u001a\u00020\u0004HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0011\u0010\u0008\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u001aR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u001aR\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010#R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u0018R\u0017\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010!R\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u001a¨\u0006D", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/BitingProgramProgress;", "Landroid/os/Parcelable;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramProgress;", "programId", "", "startedTimeMs", "", "stoppedTimeMs", "certificatePdfUrl", "certificateImageUrl", "readArticles", "", "tricks", "Lapp/dogo/com/dogo_android/repository/domain/BitingProgramProgress$TrickVariationEvent;", "programIsCompleted", "", "articlesAreCompleted", "tricksAreCompleted", "articleCompletionPercentage", "", "trickCompletionPercentage", "isRecommended", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZZZIIZ)V", "getArticleCompletionPercentage", "()I", "getArticlesAreCompleted", "()Z", "getCertificateImageUrl", "()Ljava/lang/String;", "getCertificatePdfUrl", "getProgramId", "getProgramIsCompleted", "getReadArticles", "()Ljava/util/List;", "getStartedTimeMs", "()J", "getStoppedTimeMs", "getTrickCompletionPercentage", "getTricks", "getTricksAreCompleted", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hasProgress", "hashCode", "isEnrolled", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "TrickVariationEvent", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BitingProgramProgress implements Parcelable, k {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.BitingProgramProgress> CREATOR;
    private final int articleCompletionPercentage;
    private final boolean articlesAreCompleted;
    private final String certificateImageUrl;
    private final String certificatePdfUrl;
    private final boolean isRecommended;
    private final String programId;
    private final boolean programIsCompleted;
    private final List<String> readArticles;
    private final long startedTimeMs;
    private final long stoppedTimeMs;
    private final int trickCompletionPercentage;
    private final List<app.dogo.com.dogo_android.repository.domain.BitingProgramProgress.TrickVariationEvent> tricks;
    private final boolean tricksAreCompleted;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.BitingProgramProgress> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.BitingProgramProgress createFromParcel(Parcel parcel) {
            int i4;
            int i2;
            Object fromParcel;
            int i5;
            int i3;
            int i;
            Object obj = parcel;
            n.f(obj, "parcel");
            int int2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(int2);
            int i6 = 0;
            i2 = i6;
            while (i2 != int2) {
                arrayList.add(BitingProgramProgress.TrickVariationEvent.CREATOR.createFromParcel(obj));
                i2++;
            }
            int i7 = 1;
            i4 = parcel.readInt() != 0 ? i7 : i6;
            i5 = parcel.readInt() != 0 ? i7 : i6;
            i3 = parcel.readInt() != 0 ? i7 : i6;
            i = parcel.readInt() != 0 ? i7 : i6;
            super(parcel.readString(), parcel.readLong(), obj5, parcel.readLong(), obj7, parcel.readString(), parcel.readString(), parcel.createStringArrayList(), arrayList, i4, i5, i3, parcel.readInt(), parcel.readInt(), i);
            return bitingProgramProgress;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.BitingProgramProgress[] newArray(int i) {
            return new BitingProgramProgress[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/BitingProgramProgress$TrickVariationEvent;", "Landroid/os/Parcelable;", "trickId", "", "variationId", "knowledge", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getKnowledge", "()I", "getTrickId", "()Ljava/lang/String;", "getVariationId", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickVariationEvent implements Parcelable {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.BitingProgramProgress.TrickVariationEvent> CREATOR;
        private final int knowledge;
        private final String trickId;
        private final String variationId;
        static {
            BitingProgramProgress.TrickVariationEvent.Creator creator = new BitingProgramProgress.TrickVariationEvent.Creator();
            BitingProgramProgress.TrickVariationEvent.CREATOR = creator;
        }

        public TrickVariationEvent() {
            super(0, 0, 0, 7, 0);
        }

        public TrickVariationEvent(String string, String string2, int i3) {
            n.f(string, "trickId");
            n.f(string2, "variationId");
            super();
            this.trickId = string;
            this.variationId = string2;
            this.knowledge = i3;
        }

        public TrickVariationEvent(String string, String string2, int i3, int i4, g g5) {
            String obj2;
            String obj3;
            int obj4;
            final String str = "";
            obj2 = i4 & 1 != 0 ? str : obj2;
            obj3 = i4 & 2 != 0 ? str : obj3;
            obj4 = i4 &= 4 != 0 ? 0 : obj4;
            super(obj2, obj3, obj4);
        }

        public static app.dogo.com.dogo_android.repository.domain.BitingProgramProgress.TrickVariationEvent copy$default(app.dogo.com.dogo_android.repository.domain.BitingProgramProgress.TrickVariationEvent bitingProgramProgress$TrickVariationEvent, String string2, String string3, int i4, int i5, Object object6) {
            String obj1;
            String obj2;
            int obj3;
            if (i5 & 1 != 0) {
                obj1 = trickVariationEvent.trickId;
            }
            if (i5 & 2 != 0) {
                obj2 = trickVariationEvent.variationId;
            }
            if (i5 &= 4 != 0) {
                obj3 = trickVariationEvent.knowledge;
            }
            return trickVariationEvent.copy(obj1, obj2, obj3);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.trickId;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.variationId;
        }

        @Override // android.os.Parcelable
        public final int component3() {
            return this.knowledge;
        }

        @Override // android.os.Parcelable
        public final app.dogo.com.dogo_android.repository.domain.BitingProgramProgress.TrickVariationEvent copy(String string, String string2, int i3) {
            n.f(string, "trickId");
            n.f(string2, "variationId");
            BitingProgramProgress.TrickVariationEvent trickVariationEvent = new BitingProgramProgress.TrickVariationEvent(string, string2, i3);
            return trickVariationEvent;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof BitingProgramProgress.TrickVariationEvent) {
                return i2;
            }
            if (!n.b(this.trickId, object.trickId)) {
                return i2;
            }
            if (!n.b(this.variationId, object.variationId)) {
                return i2;
            }
            if (this.knowledge != object.knowledge) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final int getKnowledge() {
            return this.knowledge;
        }

        @Override // android.os.Parcelable
        public final String getTrickId() {
            return this.trickId;
        }

        @Override // android.os.Parcelable
        public final String getVariationId() {
            return this.variationId;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i4 += i7;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TrickVariationEvent(trickId=");
            stringBuilder.append(this.trickId);
            stringBuilder.append(", variationId=");
            stringBuilder.append(this.variationId);
            stringBuilder.append(", knowledge=");
            stringBuilder.append(this.knowledge);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.trickId);
            parcel.writeString(this.variationId);
            parcel.writeInt(this.knowledge);
        }
    }
    static {
        BitingProgramProgress.Creator creator = new BitingProgramProgress.Creator();
        BitingProgramProgress.CREATOR = creator;
    }

    public BitingProgramProgress() {
        super(0, 0, obj3, 0, obj5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8191, 0);
    }

    public BitingProgramProgress(String string, long l2, long l3, String string4, String string5, List<String> list6, List<app.dogo.com.dogo_android.repository.domain.BitingProgramProgress.TrickVariationEvent> list7, boolean z8, boolean z9, boolean z10, int i11, int i12, boolean z13) {
        final Object obj = this;
        final Object obj2 = z8;
        final Object obj3 = z9;
        n.f(string, "programId");
        n.f(list6, "certificatePdfUrl");
        n.f(list7, "certificateImageUrl");
        n.f(obj2, "readArticles");
        n.f(obj3, "tricks");
        super();
        obj.programId = string;
        obj.startedTimeMs = l2;
        obj.stoppedTimeMs = string4;
        obj.certificatePdfUrl = list6;
        obj.certificateImageUrl = list7;
        obj.readArticles = obj2;
        obj.tricks = obj3;
        obj.programIsCompleted = z10;
        obj.articlesAreCompleted = i11;
        obj.tricksAreCompleted = i12;
        obj.articleCompletionPercentage = z13;
        obj.trickCompletionPercentage = obj22;
        obj.isRecommended = obj23;
    }

    public BitingProgramProgress(String string, long l2, long l3, String string4, String string5, List list6, List list7, boolean z8, boolean z9, boolean z10, int i11, int i12, boolean z13, int i14, g g15) {
        String str2;
        String str3;
        int i7;
        int i2;
        String str;
        List list2;
        List list;
        int i3;
        int i5;
        int i8;
        int i6;
        int i4;
        int i;
        int i9 = obj32;
        str2 = i9 & 1 != 0 ? "id_nipping_program" : string;
        i2 = i9 & 2 != 0 ? i7 : l2;
        if (i9 & 4 != 0) {
        } else {
            i7 = string4;
        }
        str3 = i9 & 8 != 0 ? str : list6;
        if (i9 & 16 != 0) {
        } else {
            str = list7;
        }
        if (i9 & 32 != 0) {
            list2 = p.g();
        } else {
            list2 = z8;
        }
        if (i9 & 64 != 0) {
            list = p.g();
        } else {
            list = z9;
        }
        i5 = 0;
        i3 = i9 & 128 != 0 ? i5 : z10;
        i8 = i9 & 256 != 0 ? i5 : i11;
        i6 = i9 & 512 != 0 ? i5 : i12;
        i4 = i9 & 1024 != 0 ? i5 : z13;
        i = i9 & 2048 != 0 ? i5 : i14;
        if (i9 &= 4096 != 0) {
        } else {
            i5 = g15;
        }
        super(str2, i2, string4, i7, list6, str3, str, list2, list, i3, i8, i6, i4, i, i5);
    }

    public static app.dogo.com.dogo_android.repository.domain.BitingProgramProgress copy$default(app.dogo.com.dogo_android.repository.domain.BitingProgramProgress bitingProgramProgress, String string2, long l3, long l4, String string5, String string6, List list7, List list8, boolean z9, boolean z10, boolean z11, int i12, int i13, boolean z14, int i15, Object object16) {
        boolean isRecommended;
        String programId;
        long startedTimeMs;
        long stoppedTimeMs;
        String certificatePdfUrl;
        String certificateImageUrl;
        List readArticles;
        List tricks;
        boolean programIsCompleted;
        boolean articlesAreCompleted;
        boolean tricksAreCompleted;
        int articleCompletionPercentage;
        int trickCompletionPercentage;
        Object obj = bitingProgramProgress;
        int i = obj32;
        programId = i & 1 != 0 ? obj.programId : string2;
        if (i & 2 != 0) {
            startedTimeMs = bitingProgramProgress.getStartedTimeMs();
        } else {
            startedTimeMs = l3;
        }
        if (i & 4 != 0) {
            stoppedTimeMs = bitingProgramProgress.getStoppedTimeMs();
        } else {
            stoppedTimeMs = string5;
        }
        certificatePdfUrl = i & 8 != 0 ? obj.certificatePdfUrl : list7;
        certificateImageUrl = i & 16 != 0 ? obj.certificateImageUrl : list8;
        readArticles = i & 32 != 0 ? obj.readArticles : z9;
        tricks = i & 64 != 0 ? obj.tricks : z10;
        programIsCompleted = i & 128 != 0 ? obj.programIsCompleted : z11;
        articlesAreCompleted = i & 256 != 0 ? obj.articlesAreCompleted : i12;
        tricksAreCompleted = i & 512 != 0 ? obj.tricksAreCompleted : i13;
        articleCompletionPercentage = i & 1024 != 0 ? obj.articleCompletionPercentage : z14;
        trickCompletionPercentage = i & 2048 != 0 ? obj.trickCompletionPercentage : i15;
        isRecommended = i &= 4096 != 0 ? obj.isRecommended : object16;
        return bitingProgramProgress.copy(programId, startedTimeMs, l4, stoppedTimeMs, string6, certificatePdfUrl, certificateImageUrl, readArticles, tricks, programIsCompleted, articlesAreCompleted, tricksAreCompleted, articleCompletionPercentage);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.programId;
    }

    @Override // android.os.Parcelable
    public final boolean component10() {
        return this.tricksAreCompleted;
    }

    @Override // android.os.Parcelable
    public final int component11() {
        return this.articleCompletionPercentage;
    }

    @Override // android.os.Parcelable
    public final int component12() {
        return this.trickCompletionPercentage;
    }

    @Override // android.os.Parcelable
    public final boolean component13() {
        return this.isRecommended;
    }

    @Override // android.os.Parcelable
    public final long component2() {
        return getStartedTimeMs();
    }

    @Override // android.os.Parcelable
    public final long component3() {
        return getStoppedTimeMs();
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.certificatePdfUrl;
    }

    @Override // android.os.Parcelable
    public final String component5() {
        return this.certificateImageUrl;
    }

    public final List<String> component6() {
        return this.readArticles;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.BitingProgramProgress.TrickVariationEvent> component7() {
        return this.tricks;
    }

    @Override // android.os.Parcelable
    public final boolean component8() {
        return this.programIsCompleted;
    }

    @Override // android.os.Parcelable
    public final boolean component9() {
        return this.articlesAreCompleted;
    }

    public final app.dogo.com.dogo_android.repository.domain.BitingProgramProgress copy(String string, long l2, long l3, String string4, String string5, List<String> list6, List<app.dogo.com.dogo_android.repository.domain.BitingProgramProgress.TrickVariationEvent> list7, boolean z8, boolean z9, boolean z10, int i11, int i12, boolean z13) {
        final Object obj = string;
        n.f(obj, "programId");
        final Object obj2 = list6;
        n.f(obj2, "certificatePdfUrl");
        final Object obj3 = list7;
        n.f(obj3, "certificateImageUrl");
        final Object obj4 = z8;
        n.f(obj4, "readArticles");
        final Object obj5 = z9;
        n.f(obj5, "tricks");
        super(obj, l2, obj4, string4, obj6, obj2, obj3, obj4, obj5, z10, i11, i12, z13, obj31, obj32);
        return bitingProgramProgress;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof BitingProgramProgress) {
            return i2;
        }
        if (!n.b(this.programId, object.programId)) {
            return i2;
        }
        if (Long.compare(startedTimeMs, startedTimeMs2) != 0) {
            return i2;
        }
        if (Long.compare(stoppedTimeMs, stoppedTimeMs2) != 0) {
            return i2;
        }
        if (!n.b(this.certificatePdfUrl, object.certificatePdfUrl)) {
            return i2;
        }
        if (!n.b(this.certificateImageUrl, object.certificateImageUrl)) {
            return i2;
        }
        if (!n.b(this.readArticles, object.readArticles)) {
            return i2;
        }
        if (!n.b(this.tricks, object.tricks)) {
            return i2;
        }
        if (this.programIsCompleted != object.programIsCompleted) {
            return i2;
        }
        if (this.articlesAreCompleted != object.articlesAreCompleted) {
            return i2;
        }
        if (this.tricksAreCompleted != object.tricksAreCompleted) {
            return i2;
        }
        if (this.articleCompletionPercentage != object.articleCompletionPercentage) {
            return i2;
        }
        if (this.trickCompletionPercentage != object.trickCompletionPercentage) {
            return i2;
        }
        if (this.isRecommended != object.isRecommended) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final int getArticleCompletionPercentage() {
        return this.articleCompletionPercentage;
    }

    @Override // android.os.Parcelable
    public final boolean getArticlesAreCompleted() {
        return this.articlesAreCompleted;
    }

    @Override // android.os.Parcelable
    public final String getCertificateImageUrl() {
        return this.certificateImageUrl;
    }

    @Override // android.os.Parcelable
    public final String getCertificatePdfUrl() {
        return this.certificatePdfUrl;
    }

    @Override // android.os.Parcelable
    public final String getProgramId() {
        return this.programId;
    }

    @Override // android.os.Parcelable
    public final boolean getProgramIsCompleted() {
        return this.programIsCompleted;
    }

    public final List<String> getReadArticles() {
        return this.readArticles;
    }

    @Override // android.os.Parcelable
    public long getStartedTimeMs() {
        return this.startedTimeMs;
    }

    @Override // android.os.Parcelable
    public long getStoppedTimeMs() {
        return this.stoppedTimeMs;
    }

    @Override // android.os.Parcelable
    public final int getTrickCompletionPercentage() {
        return this.trickCompletionPercentage;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.BitingProgramProgress.TrickVariationEvent> getTricks() {
        return this.tricks;
    }

    @Override // android.os.Parcelable
    public final boolean getTricksAreCompleted() {
        return this.tricksAreCompleted;
    }

    @Override // android.os.Parcelable
    public final boolean hasProgress() {
        boolean active;
        int i;
        i = 1;
        if (!isActive() && empty ^= i == 0) {
            if (empty ^= i == 0) {
                if (empty2 ^= i != 0) {
                } else {
                    i = 0;
                }
            }
        }
        return i;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean programIsCompleted;
        boolean articlesAreCompleted;
        boolean tricksAreCompleted;
        int i;
        i = 1;
        if (this.programIsCompleted) {
            programIsCompleted = i;
        }
        if (this.articlesAreCompleted) {
            articlesAreCompleted = i;
        }
        if (this.tricksAreCompleted) {
            tricksAreCompleted = i;
        }
        boolean isRecommended = this.isRecommended;
        if (isRecommended) {
        } else {
            i = isRecommended;
        }
        return i25 += i;
    }

    @Override // android.os.Parcelable
    public boolean isActive() {
        return k.a.a(this);
    }

    @Override // android.os.Parcelable
    public final boolean isEnrolled() {
        boolean isRecommended;
        int i;
        if (this.isRecommended) {
            if (isStopped()) {
                i = isActive() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean isRecommended() {
        return this.isRecommended;
    }

    @Override // android.os.Parcelable
    public boolean isStopped() {
        return k.a.b(this);
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BitingProgramProgress(programId=");
        stringBuilder.append(this.programId);
        stringBuilder.append(", startedTimeMs=");
        stringBuilder.append(getStartedTimeMs());
        stringBuilder.append(", stoppedTimeMs=");
        stringBuilder.append(getStoppedTimeMs());
        stringBuilder.append(", certificatePdfUrl=");
        stringBuilder.append(this.certificatePdfUrl);
        stringBuilder.append(", certificateImageUrl=");
        stringBuilder.append(this.certificateImageUrl);
        stringBuilder.append(", readArticles=");
        stringBuilder.append(this.readArticles);
        stringBuilder.append(", tricks=");
        stringBuilder.append(this.tricks);
        stringBuilder.append(", programIsCompleted=");
        stringBuilder.append(this.programIsCompleted);
        stringBuilder.append(", articlesAreCompleted=");
        stringBuilder.append(this.articlesAreCompleted);
        stringBuilder.append(", tricksAreCompleted=");
        stringBuilder.append(this.tricksAreCompleted);
        stringBuilder.append(", articleCompletionPercentage=");
        stringBuilder.append(this.articleCompletionPercentage);
        stringBuilder.append(", trickCompletionPercentage=");
        stringBuilder.append(this.trickCompletionPercentage);
        stringBuilder.append(", isRecommended=");
        stringBuilder.append(this.isRecommended);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        parcel.writeString(this.programId);
        parcel.writeLong(this.startedTimeMs);
        parcel.writeLong(this.stoppedTimeMs);
        parcel.writeString(this.certificatePdfUrl);
        parcel.writeString(this.certificateImageUrl);
        parcel.writeStringList(this.readArticles);
        List tricks = this.tricks;
        parcel.writeInt(tricks.size());
        Iterator iterator = tricks.iterator();
        for (BitingProgramProgress.TrickVariationEvent size : iterator) {
            size.writeToParcel(parcel, i2);
        }
        parcel.writeInt(this.programIsCompleted);
        parcel.writeInt(this.articlesAreCompleted);
        parcel.writeInt(this.tricksAreCompleted);
        parcel.writeInt(this.articleCompletionPercentage);
        parcel.writeInt(this.trickCompletionPercentage);
        parcel.writeInt(this.isRecommended);
    }
}
