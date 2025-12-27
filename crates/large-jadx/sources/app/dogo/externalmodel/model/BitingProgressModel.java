package app.dogo.externalmodel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.y.j0;

/* compiled from: BitingProgramProgressModel.kt */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008+\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001JB\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0012\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t\u0012\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0017J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u000fHÆ\u0003J\t\u00100\u001a\u00020\u0014HÆ\u0003J\t\u00101\u001a\u00020\u0014HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0015\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u00107\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cHÆ\u0003J\t\u00108\u001a\u00020\u000fHÆ\u0003J\t\u00109\u001a\u00020\u000fHÆ\u0003J\t\u0010:\u001a\u00020\u000fHÆ\u0003Jª\u0001\u0010;\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0014\u0008\u0002\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t2\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00142\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010<J\t\u0010=\u001a\u00020\u0014HÖ\u0001J\u0013\u0010>\u001a\u00020\u000f2\u0008\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\u001a\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\t2\u0006\u0010B\u001a\u00020\u0006J\t\u0010C\u001a\u00020\u0014HÖ\u0001J\t\u0010D\u001a\u00020\u0006HÖ\u0001J\u0019\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u001d\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u001fR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\u0008\u0016\u0010!R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010)\u001a\u0004\u0008'\u0010(R\u0011\u0010\u0015\u001a\u00020\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\u0019R\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010\u001d¨\u0006K", d2 = {"Lapp/dogo/externalmodel/model/BitingProgressModel;", "Landroid/os/Parcelable;", "startedTimeMs", "", "stoppedTimeMs", "certificatePdfUrl", "", "certificateImageUrl", "articles", "", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ReadStatus;", "tricks", "", "Lapp/dogo/externalmodel/model/BitingProgressModel$TrickVariationEvent;", "programIsCompleted", "", "programIsMastered", "articlesAreCompleted", "tricksAreCompleted", "articleCompletionPercentage", "", "trickCompletionPercentage", "isRecommended", "(JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;ZZZZIILjava/lang/Boolean;)V", "getArticleCompletionPercentage", "()I", "getArticles", "()Ljava/util/Map;", "getArticlesAreCompleted", "()Z", "getCertificateImageUrl", "()Ljava/lang/String;", "getCertificatePdfUrl", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getProgramIsCompleted", "getProgramIsMastered", "getStartedTimeMs", "()J", "getStoppedTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTrickCompletionPercentage", "getTricks", "()Ljava/util/List;", "getTricksAreCompleted", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;ZZZZIILjava/lang/Boolean;)Lapp/dogo/externalmodel/model/BitingProgressModel;", "describeContents", "equals", "other", "", "getTrickVariationKnowledgeMap", "trickId", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "TrickVariationEvent", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BitingProgressModel implements Parcelable {

    public static final Parcelable.Creator<BitingProgressModel> CREATOR = new BitingProgressModel$Creator<>();
    private final int articleCompletionPercentage;
    private final Map<String, PottyProgramProgressModel.ReadStatus> articles;
    private final boolean articlesAreCompleted;
    private final String certificateImageUrl;
    private final String certificatePdfUrl;
    private final Boolean isRecommended;
    private final boolean programIsCompleted;
    private final boolean programIsMastered;
    private final long startedTimeMs;
    private final Long stoppedTimeMs;
    private final int trickCompletionPercentage;
    private final List<BitingProgressModel.TrickVariationEvent> tricks;
    private final boolean tricksAreCompleted;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BitingProgressModel> {
        @Override // android.os.Parcelable$Creator
        public final BitingProgressModel createFromParcel(Parcel parcel) {
            int i;
            int i2;
            Object obj;
            boolean z = false;
            Object fromParcel;
            Object parcel2 = parcel;
            n.f(parcel2, "parcel");
            i = 0;
            if (parcel.readInt() == 0) {
            } else {
            }
            int _int4 = parcel.readInt();
            final LinkedHashMap linkedHashMap = new LinkedHashMap(_int4);
            i2 = 0;
            while (i2 != _int4) {
                linkedHashMap.put(parcel.readString(), PottyProgramProgressModel_ReadStatus.CREATOR.createFromParcel(parcel2));
                i2 = i2 + 1;
            }
            int _int5 = parcel.readInt();
            ArrayList arrayList = new ArrayList(_int5);
            while (i2 != _int5) {
                arrayList.add(BitingProgressModel_TrickVariationEvent.CREATOR.createFromParcel(parcel2));
                i2 = i2 + 1;
            }
            i2 = 1;
            int r1 = i2;
            int r12 = i2;
            int r13 = i2;
            int r14 = i2;
            if (parcel.readInt() == 0) {
            } else {
                if (parcel.readInt() != 0) {
                }
                Boolean str = Boolean.valueOf(z);
            }
            BitingProgressModel bitingProgressModel = new BitingProgressModel(parcel.readLong(), l, obj, parcel.readString(), parcel.readString(), linkedHashMap, arrayList, i2, i2, i2, i2, _int2, parcel.readInt(), i);
            return bitingProgressModel;
        }

        @Override // android.os.Parcelable$Creator
        public final BitingProgressModel[] newArray(int i) {
            return new BitingProgressModel[i];
        }
    }

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u001d", d2 = {"Lapp/dogo/externalmodel/model/BitingProgressModel$TrickVariationEvent;", "Landroid/os/Parcelable;", "trickId", "", "variationId", "knowledge", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getKnowledge", "()I", "getTrickId", "()Ljava/lang/String;", "getVariationId", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickVariationEvent implements Parcelable {

        public static final Parcelable.Creator<BitingProgressModel.TrickVariationEvent> CREATOR = new BitingProgressModel$TrickVariationEvent$Creator<>();
        private final int knowledge;
        private final String trickId;
        private final String variationId;
        public TrickVariationEvent(String str, String str2, int i) {
            n.f(str, "trickId");
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


        public static /* synthetic */ BitingProgressModel.TrickVariationEvent copy$default(BitingProgressModel.TrickVariationEvent trickVariationEvent, String str, String str2, int i, int i2, Object object) {
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

        public final BitingProgressModel.TrickVariationEvent copy(String trickId, String variationId, int knowledge) {
            n.f(trickId, "trickId");
            return new BitingProgressModel_TrickVariationEvent(trickId, variationId, knowledge);
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
            if (!(other instanceof BitingProgressModel_TrickVariationEvent)) {
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
            int i = 0;
            if (this.variationId == null) {
                i = 0;
            } else {
                i = this.variationId.hashCode();
            }
            return (this.trickId.hashCode() * 31) + i * 31 + Integer.hashCode(this.knowledge);
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
    public BitingProgressModel(long j, Long long, String str, String str2, Map<String, PottyProgramProgressModel.ReadStatus> map, List<BitingProgressModel.TrickVariationEvent> list, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, Boolean boolean) {
        n.f(map, "articles");
        n.f(list, "tricks");
        super();
        this.startedTimeMs = j;
        this.stoppedTimeMs = long;
        this.certificatePdfUrl = str;
        this.certificateImageUrl = str2;
        this.articles = map;
        this.tricks = list;
        this.programIsCompleted = z;
        this.programIsMastered = z2;
        this.articlesAreCompleted = z3;
        this.tricksAreCompleted = z4;
        this.articleCompletionPercentage = i;
        this.trickCompletionPercentage = i2;
        this.isRecommended = boolean;
    }

    public final int getArticleCompletionPercentage() {
        return this.articleCompletionPercentage;
    }

    public final Map<String, PottyProgramProgressModel.ReadStatus> getArticles() {
        return this.articles;
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

    public final boolean getProgramIsCompleted() {
        return this.programIsCompleted;
    }

    public final boolean getProgramIsMastered() {
        return this.programIsMastered;
    }

    public final long getStartedTimeMs() {
        return this.startedTimeMs;
    }

    public final Long getStoppedTimeMs() {
        return this.stoppedTimeMs;
    }

    public final int getTrickCompletionPercentage() {
        return this.trickCompletionPercentage;
    }

    public final Map<String, Integer> getTrickVariationKnowledgeMap(String trickId) {
        Integer num;
        Object obj = null;
        String variationId;
        n.f(trickId, "trickId");
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.tricks.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        return j0.s(arrayList);
    }

    public final List<BitingProgressModel.TrickVariationEvent> getTricks() {
        return this.tricks;
    }

    public final boolean getTricksAreCompleted() {
        return this.tricksAreCompleted;
    }

    public final Boolean isRecommended() {
        return this.isRecommended;
    }


    public static /* synthetic */ BitingProgressModel copy$default(BitingProgressModel bitingProgressModel, long j, Long long, String str, String str2, Map map, List list, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, Boolean boolean, int i3, Object object) {
        Boolean i152;
        long j22;
        Long str42;
        String str52;
        String map62;
        Map list72;
        List z82;
        boolean z92;
        boolean z102;
        boolean z112;
        boolean i122;
        int i132;
        int boolean142;
        Object bitingProgressModel2 = bitingProgressModel;
        int object162 = i3;
        long r2 = object162 & 1 != 0 ? bitingProgressModel2.startedTimeMs : j;
        Long r4 = object162 & 2 != 0 ? bitingProgressModel2.stoppedTimeMs : long;
        String r5 = object162 & 4 != 0 ? bitingProgressModel2.certificatePdfUrl : str;
        String r6 = object162 & 8 != 0 ? bitingProgressModel2.certificateImageUrl : str2;
        Map r7 = object162 & 16 != 0 ? bitingProgressModel2.articles : map;
        List r8 = object162 & 32 != 0 ? bitingProgressModel2.tricks : list;
        boolean r9 = object162 & 64 != 0 ? bitingProgressModel2.programIsCompleted : z;
        boolean r10 = object162 & 128 != 0 ? bitingProgressModel2.programIsMastered : z2;
        boolean r11 = object162 & 256 != 0 ? bitingProgressModel2.articlesAreCompleted : z3;
        boolean r12 = object162 & 512 != 0 ? bitingProgressModel2.tricksAreCompleted : z4;
        int r13 = object162 & 1024 != 0 ? bitingProgressModel2.articleCompletionPercentage : i;
        int r14 = object162 & 2048 != 0 ? bitingProgressModel2.trickCompletionPercentage : i2;
        Boolean r1 = object162 & 4096 != 0 ? bitingProgressModel2.isRecommended : boolean;
        return bitingProgressModel.copy(j22, r17, str42, str52, map62, list72, z82, z92, z102, z112, i122, i132, boolean142, (object162 & 4096 != 0 ? bitingProgressModel2.isRecommended : boolean));
    }

    /* operator */ public final long component1() {
        return this.startedTimeMs;
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

    /* operator */ public final Boolean component13() {
        return this.isRecommended;
    }

    /* operator */ public final Long component2() {
        return this.stoppedTimeMs;
    }

    /* operator */ public final String component3() {
        return this.certificatePdfUrl;
    }

    /* operator */ public final String component4() {
        return this.certificateImageUrl;
    }

    /* operator */ public final Map<String, PottyProgramProgressModel.ReadStatus> component5() {
        return this.articles;
    }

    /* operator */ public final List<BitingProgressModel.TrickVariationEvent> component6() {
        return this.tricks;
    }

    /* operator */ public final boolean component7() {
        return this.programIsCompleted;
    }

    /* operator */ public final boolean component8() {
        return this.programIsMastered;
    }

    /* operator */ public final boolean component9() {
        return this.articlesAreCompleted;
    }

    public final BitingProgressModel copy(long startedTimeMs, Long stoppedTimeMs, String certificatePdfUrl, String certificateImageUrl, Map<String, PottyProgramProgressModel.ReadStatus> articles, List<BitingProgressModel.TrickVariationEvent> tricks, boolean programIsCompleted, boolean programIsMastered, boolean articlesAreCompleted, boolean tricksAreCompleted, int articleCompletionPercentage, int trickCompletionPercentage, Boolean isRecommended) {
        final Object tricks2 = articles;
        n.f(tricks2, "articles");
        final Object programIsCompleted2 = tricks;
        n.f(programIsCompleted2, "tricks");
        BitingProgressModel bitingProgressModel = new BitingProgressModel(startedTimeMs, l, stoppedTimeMs, certificatePdfUrl, certificateImageUrl, tricks2, programIsCompleted2, programIsCompleted, programIsMastered, articlesAreCompleted, tricksAreCompleted, articleCompletionPercentage, trickCompletionPercentage, isRecommended);
        return bitingProgressModel;
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
        if (!(other instanceof BitingProgressModel)) {
            return false;
        }
        if (this.startedTimeMs != other.startedTimeMs) {
            return false;
        }
        if (!n.b(this.stoppedTimeMs, other.stoppedTimeMs)) {
            return false;
        }
        if (!n.b(this.certificatePdfUrl, other.certificatePdfUrl)) {
            return false;
        }
        if (!n.b(this.certificateImageUrl, other.certificateImageUrl)) {
            return false;
        }
        if (!n.b(this.articles, other.articles)) {
            return false;
        }
        if (!n.b(this.tricks, other.tricks)) {
            return false;
        }
        if (this.programIsCompleted != other.programIsCompleted) {
            return false;
        }
        if (this.programIsMastered != other.programIsMastered) {
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
        return !n.b(this.isRecommended, other.isRecommended) ? z8 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        boolean programIsCompleted2;
        boolean programIsMastered2;
        boolean articlesAreCompleted2;
        boolean tricksAreCompleted2 = true;
        i = 0;
        if (this.stoppedTimeMs == null) {
        } else {
            i = this.stoppedTimeMs.hashCode();
        }
        if (this.certificatePdfUrl == null) {
        } else {
            i = this.certificatePdfUrl.hashCode();
        }
        if (this.certificateImageUrl == null) {
        } else {
            i = this.certificateImageUrl.hashCode();
        }
        int i2 = 1;
        if (this.programIsCompleted) {
        }
        if (this.programIsMastered) {
        }
        if (this.articlesAreCompleted) {
        }
        if (!(this.tricksAreCompleted)) {
        }
        if (this.isRecommended != null) {
            i = this.isRecommended.hashCode();
        }
        return (Long.hashCode(this.startedTimeMs) * 31) + i * 31 + i * 31 + i * 31 + this.articles.hashCode() * 31 + this.tricks.hashCode() * 31 + programIsCompleted2 * 31 + programIsMastered2 * 31 + articlesAreCompleted2 * 31 + tricksAreCompleted2 * 31 + Integer.hashCode(this.articleCompletionPercentage) * 31 + Integer.hashCode(this.trickCompletionPercentage) * 31 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "BitingProgressModel(startedTimeMs=";
        String str3 = ", stoppedTimeMs=";
        String str4 = ", certificatePdfUrl=";
        String str5 = ", certificateImageUrl=";
        String str6 = ", articles=";
        String str7 = ", tricks=";
        String str8 = ", programIsCompleted=";
        String str9 = ", programIsMastered=";
        String str10 = ", articlesAreCompleted=";
        String str11 = ", tricksAreCompleted=";
        String str12 = ", articleCompletionPercentage=";
        String str13 = ", trickCompletionPercentage=";
        String str14 = ", isRecommended=";
        str = str2 + this.startedTimeMs + str3 + this.stoppedTimeMs + str4 + this.certificatePdfUrl + str5 + this.certificateImageUrl + str6 + this.articles + str7 + this.tricks + str8 + this.programIsCompleted + str9 + this.programIsMastered + str10 + this.articlesAreCompleted + str11 + this.tricksAreCompleted + str12 + this.articleCompletionPercentage + str13 + this.trickCompletionPercentage + str14 + this.isRecommended + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeLong(this.startedTimeMs);
        final int i = 0;
        final int i2 = 1;
        if (this.stoppedTimeMs == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeLong(this.stoppedTimeMs.longValue());
        }
        parcel.writeString(this.certificatePdfUrl);
        parcel.writeString(this.certificateImageUrl);
        parcel.writeInt(this.articles.size());
        Iterator it = this.articles.entrySet().iterator();
        while (it.hasNext()) {
            Object item2 = it.next();
            parcel.writeString((String)item2.getKey());
            (PottyProgramProgressModel_ReadStatus)item2.getValue().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.tricks.size());
        Iterator it2 = this.tricks.iterator();
        while (it2.hasNext()) {
            (BitingProgressModel_TrickVariationEvent)it2.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.programIsCompleted);
        parcel.writeInt(this.programIsMastered);
        parcel.writeInt(this.articlesAreCompleted);
        parcel.writeInt(this.tricksAreCompleted);
        parcel.writeInt(this.articleCompletionPercentage);
        parcel.writeInt(this.trickCompletionPercentage);
        if (this.isRecommended == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeInt(this.isRecommended.booleanValue());
        }
    }
}
