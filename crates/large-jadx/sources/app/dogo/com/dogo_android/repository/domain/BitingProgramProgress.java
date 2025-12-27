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

/* compiled from: BitingProgramProgress.kt */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008%\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u00012\u00020\u0002:\u0001CB\u0093\u0001\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0004\u0012\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u000e\u0008\u0002\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0013\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000f¢\u0006\u0002\u0010\u0016J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u000fHÆ\u0003J\t\u0010*\u001a\u00020\u0013HÆ\u0003J\t\u0010+\u001a\u00020\u0013HÆ\u0003J\t\u0010,\u001a\u00020\u000fHÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0004HÆ\u0003J\t\u00100\u001a\u00020\u0004HÆ\u0003J\u000f\u00101\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000bHÆ\u0003J\u000f\u00102\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000bHÆ\u0003J\t\u00103\u001a\u00020\u000fHÆ\u0003J\t\u00104\u001a\u00020\u000fHÆ\u0003J\u0097\u0001\u00105\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00042\u0008\u0008\u0002\u0010\t\u001a\u00020\u00042\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000b2\u000e\u0008\u0002\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000b2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000fHÆ\u0001J\t\u00106\u001a\u00020\u0013HÖ\u0001J\u0013\u00107\u001a\u00020\u000f2\u0008\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\u0006\u0010:\u001a\u00020\u000fJ\t\u0010;\u001a\u00020\u0013HÖ\u0001J\u0006\u0010<\u001a\u00020\u000fJ\t\u0010=\u001a\u00020\u0004HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0011\u0010\u0008\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u001aR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u001aR\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010#R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u0018R\u0017\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010!R\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u001a¨\u0006D", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/BitingProgramProgress;", "Landroid/os/Parcelable;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramProgress;", "programId", "", "startedTimeMs", "", "stoppedTimeMs", "certificatePdfUrl", "certificateImageUrl", "readArticles", "", "tricks", "Lapp/dogo/com/dogo_android/repository/domain/BitingProgramProgress$TrickVariationEvent;", "programIsCompleted", "", "articlesAreCompleted", "tricksAreCompleted", "articleCompletionPercentage", "", "trickCompletionPercentage", "isRecommended", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZZZIIZ)V", "getArticleCompletionPercentage", "()I", "getArticlesAreCompleted", "()Z", "getCertificateImageUrl", "()Ljava/lang/String;", "getCertificatePdfUrl", "getProgramId", "getProgramIsCompleted", "getReadArticles", "()Ljava/util/List;", "getStartedTimeMs", "()J", "getStoppedTimeMs", "getTrickCompletionPercentage", "getTricks", "getTricksAreCompleted", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hasProgress", "hashCode", "isEnrolled", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "TrickVariationEvent", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BitingProgramProgress implements Parcelable, k {

    public static final Parcelable.Creator<BitingProgramProgress> CREATOR = new BitingProgramProgress$Creator<>();
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
    private final List<BitingProgramProgress.TrickVariationEvent> tricks;
    private final boolean tricksAreCompleted;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BitingProgramProgress> {
        @Override // android.os.Parcelable$Creator
        public final BitingProgramProgress createFromParcel(Parcel parcel) {
            int i;
            Object parcel2 = parcel;
            n.f(parcel2, "parcel");
            int _int2 = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int2);
            i = 0;
            while (i != _int2) {
                arrayList.add(BitingProgramProgress_TrickVariationEvent.CREATOR.createFromParcel(parcel2));
                i = i + 1;
            }
            i = 1;
            int r1 = i;
            int r13 = i;
            int r14 = i;
            int r17 = i;
            BitingProgramProgress bitingProgramProgress = new BitingProgramProgress(parcel.readString(), parcel.readLong(), l, parcel.readLong(), str2, parcel.readString(), parcel.readString(), parcel.createStringArrayList(), arrayList, i, i, i, parcel.readInt(), parcel.readInt(), i);
            return bitingProgramProgress;
        }

        @Override // android.os.Parcelable$Creator
        public final BitingProgramProgress[] newArray(int i) {
            return new BitingProgramProgress[i];
        }
    }

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/BitingProgramProgress$TrickVariationEvent;", "Landroid/os/Parcelable;", "trickId", "", "variationId", "knowledge", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getKnowledge", "()I", "getTrickId", "()Ljava/lang/String;", "getVariationId", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickVariationEvent implements Parcelable {

        public static final Parcelable.Creator<BitingProgramProgress.TrickVariationEvent> CREATOR = new BitingProgramProgress$TrickVariationEvent$Creator<>();
        private final int knowledge;
        private final String trickId;
        private final String variationId;
        public TrickVariationEvent(String str, String str2, int i) {
            n.f(str, "trickId");
            n.f(str2, "variationId");
            super();
            this.trickId = str;
            this.variationId = str2;
            this.knowledge = i;
        }

        public final int getKnowledge() {
            return this.knowledge;
        }

        public final String getTrickId() {
            return this.trickId;
        }

        public final String getVariationId() {
            return this.variationId;
        }

        public /* synthetic */ TrickVariationEvent(String str, String str2, int i, int i2, g gVar) {
            String str3;
            str3 = "";
            str3 = i2 & 1 != 0 ? str3 : str3;
            str3 = i2 & 2 != 0 ? str3 : str3;
            i = i2 & 4 != 0 ? 0 : i;
            this(str3, str3, i);
        }


        public TrickVariationEvent() {
            this(null, null, 0, 7, null);
        }

        public static /* synthetic */ BitingProgramProgress.TrickVariationEvent copy$default(BitingProgramProgress.TrickVariationEvent trickVariationEvent, String str, String str2, int i, int i2, Object object) {
            String trickId2;
            String variationId2;
            int knowledge2;
            if (i2 & 1 != 0) {
            }
            if (i2 & 2 != 0) {
            }
            if (i2 & 4 != 0) {
            }
            return trickVariationEvent.copy(trickId2, variationId2, knowledge2);
        }

        /* operator */ public final String component1() {
            return this.trickId;
        }

        /* operator */ public final String component2() {
            return this.variationId;
        }

        /* operator */ public final int component3() {
            return this.knowledge;
        }

        public final BitingProgramProgress.TrickVariationEvent copy(String trickId, String variationId, int knowledge) {
            n.f(trickId, "trickId");
            n.f(variationId, "variationId");
            return new BitingProgramProgress_TrickVariationEvent(trickId, variationId, knowledge);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z5 = false;
            if (!(other instanceof BitingProgramProgress_TrickVariationEvent)) {
                return false;
            }
            if (!n.b(this.trickId, other.trickId)) {
                return false;
            }
            if (!n.b(this.variationId, other.variationId)) {
                return false;
            }
            return this.knowledge != other.knowledge ? z5 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.trickId.hashCode() * 31) + this.variationId.hashCode() * 31 + Integer.hashCode(this.knowledge);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TrickVariationEvent(trickId=";
            String str3 = ", variationId=";
            String str4 = ", knowledge=";
            str = str2 + this.trickId + str3 + this.variationId + str4 + this.knowledge + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.trickId);
            parcel.writeString(this.variationId);
            parcel.writeInt(this.knowledge);
        }
    }
    public BitingProgramProgress(String str, long j, long j2, String str2, String str3, List<String> list, List<BitingProgramProgress.TrickVariationEvent> list2, boolean z, boolean z2, boolean z3, int i, int i2, boolean z4) {
        final Object str32 = this;
        final Object z82 = list;
        final Object z92 = list2;
        n.f(str, "programId");
        n.f(str2, "certificatePdfUrl");
        n.f(str3, "certificateImageUrl");
        n.f(z82, "readArticles");
        n.f(z92, "tricks");
        super();
        str32.programId = str;
        str32.startedTimeMs = j;
        str32.stoppedTimeMs = j2;
        str32.certificatePdfUrl = str2;
        str32.certificateImageUrl = str3;
        str32.readArticles = z82;
        str32.tricks = z92;
        str32.programIsCompleted = z;
        str32.articlesAreCompleted = z2;
        str32.tricksAreCompleted = z3;
        str32.articleCompletionPercentage = i;
        str32.trickCompletionPercentage = i2;
        str32.isRecommended = z4;
    }

    public final int getArticleCompletionPercentage() {
        return this.articleCompletionPercentage;
    }

    public final boolean getArticlesAreCompleted() {
        return this.articlesAreCompleted;
    }

    public final String getCertificateImageUrl() {
        return this.certificateImageUrl;
    }

    public final String getCertificatePdfUrl() {
        return this.certificatePdfUrl;
    }

    public final String getProgramId() {
        return this.programId;
    }

    public final boolean getProgramIsCompleted() {
        return this.programIsCompleted;
    }

    public final List<String> getReadArticles() {
        return this.readArticles;
    }

    public long getStartedTimeMs() {
        return this.startedTimeMs;
    }

    public long getStoppedTimeMs() {
        return this.stoppedTimeMs;
    }

    public final int getTrickCompletionPercentage() {
        return this.trickCompletionPercentage;
    }

    public final List<BitingProgramProgress.TrickVariationEvent> getTricks() {
        return this.tricks;
    }

    public final boolean getTricksAreCompleted() {
        return this.tricksAreCompleted;
    }

    public final boolean hasProgress() {
        boolean z = true;
        int i3 = 1;
        if (!isActive()) {
            if (!this.tricks.isEmpty() ^ i3) {
                if (!(this.readArticles.isEmpty() ^ i3)) {
                    int i4 = 0;
                }
            }
        }
        return z;
    }

    public boolean isActive() {
        return app.dogo.com.dogo_android.specialprograms.k.a.a(this);
    }

    public final boolean isEnrolled() {
        boolean z = true;
        if (!this.isRecommended || this.isStopped()) {
            int r0 = isActive() ? 1 : 0;
        }
        return (isActive() ? 1 : 0);
    }

    public final boolean isRecommended() {
        return this.isRecommended;
    }

    public boolean isStopped() {
        return app.dogo.com.dogo_android.specialprograms.k.a.b(this);
    }

    public /* synthetic */ BitingProgramProgress(String str, long j, long j2, String str2, String str3, List list, List list2, boolean z, boolean z2, boolean z3, int i, int i2, boolean z4, int i3, g gVar) {
        String list62;
        long str42 = 0;
        int j22;
        List z82;
        List z92;
        int z102;
        i = i3;
        String r1 = i & 1 != 0 ? "id_nipping_program" : str;
        int r5 = i & 2 != 0 ? 0 : j;
        if (i & 4 == 0) {
            str42 = j2;
        }
        list62 = "";
        String r2 = i & 8 != 0 ? "" : str2;
        if (i & 16 == 0) {
            list62 = str3;
        }
        if (i & 32 != 0) {
            z82 = p.g();
        } else {
            z82 = list;
        }
        if (i & 64 != 0) {
            z92 = p.g();
        } else {
            z92 = list2;
        }
        z102 = 0;
        int r10 = i & 128 != 0 ? z102 : z;
        int r12 = i & 256 != 0 ? z102 : z2;
        int r13 = i & 512 != 0 ? z102 : z3;
        int r14 = i & 1024 != 0 ? z102 : i;
        int r15 = i & 2048 != 0 ? z102 : i2;
        if (i & 4096 == 0) {
            z102 = z4;
        }
        this(str2, j22, j2, str42, str2, list62, list62, z82, z92, z102, z102, z102, z102, z102, z102);
    }


    public BitingProgramProgress() {
        this(null, 0L, l, null, str, null, null, false, false, false, 0, 0, false, 0, null, 8191, 0);
    }

    public static /* synthetic */ BitingProgramProgress copy$default(BitingProgramProgress bitingProgramProgress, String str, long j, long j2, String str2, String str3, List list, List list2, boolean z, boolean z2, boolean z3, int i, int i2, boolean z4, int i3, Object object) {
        boolean object162;
        String str22;
        long j32;
        long str52;
        String list72;
        String list82;
        List z92;
        List z102;
        boolean z112;
        boolean i122;
        boolean i132;
        int z142;
        int i152;
        Object bitingProgramProgress2 = bitingProgramProgress;
        i = i3;
        String r2 = i & 1 != 0 ? bitingProgramProgress2.programId : str;
        if (i & 2 != 0) {
            j32 = bitingProgramProgress.getStartedTimeMs();
        } else {
            j32 = j;
        }
        if (i & 4 != 0) {
            str52 = bitingProgramProgress.getStoppedTimeMs();
        } else {
            str52 = j2;
        }
        String r7 = i & 8 != 0 ? bitingProgramProgress2.certificatePdfUrl : str2;
        String r8 = i & 16 != 0 ? bitingProgramProgress2.certificateImageUrl : str3;
        List r9 = i & 32 != 0 ? bitingProgramProgress2.readArticles : list;
        List r10 = i & 64 != 0 ? bitingProgramProgress2.tricks : list2;
        boolean r11 = i & 128 != 0 ? bitingProgramProgress2.programIsCompleted : z;
        boolean r12 = i & 256 != 0 ? bitingProgramProgress2.articlesAreCompleted : z2;
        boolean r13 = i & 512 != 0 ? bitingProgramProgress2.tricksAreCompleted : z3;
        int r14 = i & 1024 != 0 ? bitingProgramProgress2.articleCompletionPercentage : i;
        int r15 = i & 2048 != 0 ? bitingProgramProgress2.trickCompletionPercentage : i2;
        boolean r1 = i & 4096 != 0 ? bitingProgramProgress2.isRecommended : z4;
        return bitingProgramProgress.copy(str22, j32, r19, str52, r21, list72, list82, z92, z102, z112, i122, i132, z142, i152, (i & 4096 != 0 ? bitingProgramProgress2.isRecommended : z4));
    }

    /* operator */ public final String component1() {
        return this.programId;
    }

    /* operator */ public final boolean component10() {
        return this.tricksAreCompleted;
    }

    /* operator */ public final int component11() {
        return this.articleCompletionPercentage;
    }

    /* operator */ public final int component12() {
        return this.trickCompletionPercentage;
    }

    /* operator */ public final boolean component13() {
        return this.isRecommended;
    }

    /* operator */ public final long component2() {
        return getStartedTimeMs();
    }

    /* operator */ public final long component3() {
        return getStoppedTimeMs();
    }

    /* operator */ public final String component4() {
        return this.certificatePdfUrl;
    }

    /* operator */ public final String component5() {
        return this.certificateImageUrl;
    }

    /* operator */ public final List<String> component6() {
        return this.readArticles;
    }

    /* operator */ public final List<BitingProgramProgress.TrickVariationEvent> component7() {
        return this.tricks;
    }

    /* operator */ public final boolean component8() {
        return this.programIsCompleted;
    }

    /* operator */ public final boolean component9() {
        return this.articlesAreCompleted;
    }

    public final BitingProgramProgress copy(String programId, long startedTimeMs, long stoppedTimeMs, String certificatePdfUrl, String certificateImageUrl, List<String> readArticles, List<BitingProgramProgress.TrickVariationEvent> tricks, boolean programIsCompleted, boolean articlesAreCompleted, boolean tricksAreCompleted, int articleCompletionPercentage, int trickCompletionPercentage, boolean isRecommended) {
        final Object programId2 = programId;
        n.f(programId2, "programId");
        final Object readArticles2 = certificatePdfUrl;
        n.f(readArticles2, "certificatePdfUrl");
        final Object tricks2 = certificateImageUrl;
        n.f(tricks2, "certificateImageUrl");
        final Object programIsCompleted2 = readArticles;
        n.f(programIsCompleted2, "readArticles");
        final Object articlesAreCompleted2 = tricks;
        n.f(articlesAreCompleted2, "tricks");
        BitingProgramProgress bitingProgramProgress = new BitingProgramProgress(programId2, startedTimeMs, l, stoppedTimeMs, str6, readArticles2, tricks2, programIsCompleted2, articlesAreCompleted2, programIsCompleted, articlesAreCompleted, tricksAreCompleted, articleCompletionPercentage, trickCompletionPercentage, isRecommended);
        return bitingProgramProgress;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z8 = false;
        if (!(other instanceof BitingProgramProgress)) {
            return false;
        }
        if (!n.b(this.programId, other.programId)) {
            return false;
        }
        long startedTimeMs = getStartedTimeMs();
        long startedTimeMs2 = other.getStartedTimeMs();
        if (startedTimeMs != startedTimeMs2) {
            return false;
        }
        long stoppedTimeMs = getStoppedTimeMs();
        long stoppedTimeMs2 = other.getStoppedTimeMs();
        if (stoppedTimeMs != stoppedTimeMs2) {
            return false;
        }
        if (!n.b(this.certificatePdfUrl, other.certificatePdfUrl)) {
            return false;
        }
        if (!n.b(this.certificateImageUrl, other.certificateImageUrl)) {
            return false;
        }
        if (!n.b(this.readArticles, other.readArticles)) {
            return false;
        }
        if (!n.b(this.tricks, other.tricks)) {
            return false;
        }
        if (this.programIsCompleted != other.programIsCompleted) {
            return false;
        }
        if (this.articlesAreCompleted != other.articlesAreCompleted) {
            return false;
        }
        if (this.tricksAreCompleted != other.tricksAreCompleted) {
            return false;
        }
        if (this.articleCompletionPercentage != other.articleCompletionPercentage) {
            return false;
        }
        if (this.trickCompletionPercentage != other.trickCompletionPercentage) {
            return false;
        }
        return this.isRecommended != other.isRecommended ? z8 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean programIsCompleted2;
        boolean articlesAreCompleted2;
        boolean tricksAreCompleted2;
        int i = 1;
        i = 1;
        if (this.programIsCompleted) {
        }
        if (this.articlesAreCompleted) {
        }
        if (this.tricksAreCompleted) {
        }
        if (!(this.isRecommended)) {
        }
        return (this.programId.hashCode() * 31) + Long.hashCode(getStartedTimeMs()) * 31 + Long.hashCode(getStoppedTimeMs()) * 31 + this.certificatePdfUrl.hashCode() * 31 + this.certificateImageUrl.hashCode() * 31 + this.readArticles.hashCode() * 31 + this.tricks.hashCode() * 31 + programIsCompleted2 * 31 + articlesAreCompleted2 * 31 + tricksAreCompleted2 * 31 + Integer.hashCode(this.articleCompletionPercentage) * 31 + Integer.hashCode(this.trickCompletionPercentage) * 31 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "BitingProgramProgress(programId=";
        String str3 = ", startedTimeMs=";
        long startedTimeMs = getStartedTimeMs();
        String str4 = ", stoppedTimeMs=";
        long stoppedTimeMs = getStoppedTimeMs();
        String str5 = ", certificatePdfUrl=";
        String str6 = ", certificateImageUrl=";
        String str7 = ", readArticles=";
        String str8 = ", tricks=";
        String str9 = ", programIsCompleted=";
        String str10 = ", articlesAreCompleted=";
        String str11 = ", tricksAreCompleted=";
        String str12 = ", articleCompletionPercentage=";
        String str13 = ", trickCompletionPercentage=";
        String str14 = ", isRecommended=";
        str = str2 + this.programId + str3 + startedTimeMs + str4 + stoppedTimeMs + str5 + this.certificatePdfUrl + str6 + this.certificateImageUrl + str7 + this.readArticles + str8 + this.tricks + str9 + this.programIsCompleted + str10 + this.articlesAreCompleted + str11 + this.tricksAreCompleted + str12 + this.articleCompletionPercentage + str13 + this.trickCompletionPercentage + str14 + this.isRecommended + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.programId);
        parcel.writeLong(this.startedTimeMs);
        parcel.writeLong(this.stoppedTimeMs);
        parcel.writeString(this.certificatePdfUrl);
        parcel.writeString(this.certificateImageUrl);
        parcel.writeStringList(this.readArticles);
        parcel.writeInt(this.tricks.size());
        Iterator it = this.tricks.iterator();
        while (it.hasNext()) {
            (BitingProgramProgress_TrickVariationEvent)it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.programIsCompleted);
        parcel.writeInt(this.articlesAreCompleted);
        parcel.writeInt(this.tricksAreCompleted);
        parcel.writeInt(this.articleCompletionPercentage);
        parcel.writeInt(this.trickCompletionPercentage);
        parcel.writeInt(this.isRecommended);
    }
}
