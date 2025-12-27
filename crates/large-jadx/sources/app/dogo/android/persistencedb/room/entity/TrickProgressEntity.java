package app.dogo.android.persistencedb.room.entity;

import app.dogo.externalmodel.model.TrickKnowledgeEvent;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: TrickProgressEntity.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0015\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0008\u0087\u0008\u0018\u0000 $2\u00020\u0001:\u0003$%&B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JN\u0010\u001d\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00062\u0008\u0008\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\u0008\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0015\u0010\u0008\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0010\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0013\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006'", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity;", "", "trickId", "", "dogId", "updatedAt", "", "lastViewedAt", "lastRatedAt", "knowledge", "", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;I)V", "getDogId", "()Ljava/lang/String;", "getKnowledge", "()I", "getLastRatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLastViewedAt", "getTrickId", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;I)Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity;", "equals", "", "other", "hashCode", "toString", "Companion", "TrickKnowledgeRateData", "TrickKnowledgeViewData", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TrickProgressEntity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final TrickProgressEntity.Companion INSTANCE = new TrickProgressEntity$Companion(0);
    private final String dogId;
    private final int knowledge;
    private final Long lastRatedAt;
    private final Long lastViewedAt;
    private final String trickId;
    private final long updatedAt;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008¨\u0006\t", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$Companion;", "", "()V", "rateDataFormTrickKnowledgeEvent", "Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$TrickKnowledgeRateData;", "dogId", "", "trickEvent", "Lapp/dogo/externalmodel/model/TrickKnowledgeEvent;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public final TrickProgressEntity.TrickKnowledgeRateData rateDataFormTrickKnowledgeEvent(String dogId, TrickKnowledgeEvent trickEvent) {
            n.f(dogId, "dogId");
            n.f(trickEvent, "trickEvent");
            TrickProgressEntity_TrickKnowledgeRateData trickEvent2 = new TrickProgressEntity_TrickKnowledgeRateData(trickEvent.getTrickId(), dogId, trickEvent.getLastTrainedTimeMs(), l, trickEvent.getLastTrainedTimeMs(), obj, trickEvent.getKnowledge());
            return trickEvent2;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0010¨\u0006\u001e", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$TrickKnowledgeRateData;", "", "trickId", "", "dogId", "updatedAt", "", "lastRatedAt", "knowledge", "", "(Ljava/lang/String;Ljava/lang/String;JJI)V", "getDogId", "()Ljava/lang/String;", "getKnowledge", "()I", "getLastRatedAt", "()J", "getTrickId", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickKnowledgeRateData {

        private final String dogId;
        private final int knowledge;
        private final long lastRatedAt;
        private final String trickId;
        private final long updatedAt;
        public TrickKnowledgeRateData(String str, String str2, long j, long j2, int i) {
            n.f(str, "trickId");
            n.f(str2, "dogId");
            super();
            this.trickId = str;
            this.dogId = str2;
            this.updatedAt = j;
            this.lastRatedAt = j2;
            this.knowledge = i;
        }

        public final String getDogId() {
            return this.dogId;
        }

        public final int getKnowledge() {
            return this.knowledge;
        }

        public final long getLastRatedAt() {
            return this.lastRatedAt;
        }

        public final String getTrickId() {
            return this.trickId;
        }

        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        public static /* synthetic */ TrickProgressEntity.TrickKnowledgeRateData copy$default(TrickProgressEntity.TrickKnowledgeRateData trickKnowledgeRateData, String str, String str2, long j, long j2, int i, int i2, Object object) {
            String str22;
            String str32;
            long j42;
            long i62;
            int object82;
            if (i2 & 1 != 0) {
            }
            if (i2 & 2 != 0) {
            }
            if (i2 & 4 != 0) {
            }
            if (i2 & 8 != 0) {
            }
            if (i2 & 16 != 0) {
            }
            return trickKnowledgeRateData.copy(str22, str32, j42, i62, object82);
        }

        /* operator */ public final String component1() {
            return this.trickId;
        }

        /* operator */ public final String component2() {
            return this.dogId;
        }

        /* operator */ public final long component3() {
            return this.updatedAt;
        }

        /* operator */ public final long component4() {
            return this.lastRatedAt;
        }

        /* operator */ public final int component5() {
            return this.knowledge;
        }

        public final TrickProgressEntity.TrickKnowledgeRateData copy(String trickId, String dogId, long updatedAt, long lastRatedAt, int knowledge) {
            n.f(trickId, "trickId");
            n.f(dogId, "dogId");
            TrickProgressEntity_TrickKnowledgeRateData trickProgressEntity_TrickKnowledgeRateData = new TrickProgressEntity_TrickKnowledgeRateData(trickId, dogId, updatedAt, l, lastRatedAt, obj, knowledge);
            return trickProgressEntity_TrickKnowledgeRateData;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z5 = false;
            if (!(other instanceof TrickProgressEntity_TrickKnowledgeRateData)) {
                return false;
            }
            if (!n.b(this.trickId, other.trickId)) {
                return false;
            }
            if (!n.b(this.dogId, other.dogId)) {
                return false;
            }
            if (this.updatedAt != other.updatedAt) {
                return false;
            }
            if (this.lastRatedAt != other.lastRatedAt) {
                return false;
            }
            return this.knowledge != other.knowledge ? z5 : z;
        }

        public int hashCode() {
            return (this.trickId.hashCode() * 31) + this.dogId.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + Long.hashCode(this.lastRatedAt) * 31 + Integer.hashCode(this.knowledge);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TrickKnowledgeRateData(trickId=";
            String str3 = ", dogId=";
            String str4 = ", updatedAt=";
            String str5 = ", lastRatedAt=";
            String str6 = ", knowledge=";
            str = str2 + this.trickId + str3 + this.dogId + str4 + this.updatedAt + str5 + this.lastRatedAt + str6 + this.knowledge + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000c¨\u0006\u001a", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$TrickKnowledgeViewData;", "", "trickId", "", "dogId", "updatedAt", "", "lastViewedAt", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "getDogId", "()Ljava/lang/String;", "getLastViewedAt", "()J", "getTrickId", "getUpdatedAt", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickKnowledgeViewData {

        private final String dogId;
        private final long lastViewedAt;
        private final String trickId;
        private final long updatedAt;
        public TrickKnowledgeViewData(String str, String str2, long j, long j2) {
            n.f(str, "trickId");
            n.f(str2, "dogId");
            super();
            this.trickId = str;
            this.dogId = str2;
            this.updatedAt = j;
            this.lastViewedAt = j2;
        }

        public final String getDogId() {
            return this.dogId;
        }

        public final long getLastViewedAt() {
            return this.lastViewedAt;
        }

        public final String getTrickId() {
            return this.trickId;
        }

        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        public static /* synthetic */ TrickProgressEntity.TrickKnowledgeViewData copy$default(TrickProgressEntity.TrickKnowledgeViewData trickKnowledgeViewData, String str, String str2, long j, long j2, int i, Object object) {
            String str22;
            String str32;
            long j42;
            long i62;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            if (i & 8 != 0) {
            }
            return trickKnowledgeViewData.copy(str22, str32, j42, i62);
        }

        /* operator */ public final String component1() {
            return this.trickId;
        }

        /* operator */ public final String component2() {
            return this.dogId;
        }

        /* operator */ public final long component3() {
            return this.updatedAt;
        }

        /* operator */ public final long component4() {
            return this.lastViewedAt;
        }

        public final TrickProgressEntity.TrickKnowledgeViewData copy(String trickId, String dogId, long updatedAt, long lastViewedAt) {
            n.f(trickId, "trickId");
            n.f(dogId, "dogId");
            TrickProgressEntity_TrickKnowledgeViewData trickProgressEntity_TrickKnowledgeViewData = new TrickProgressEntity_TrickKnowledgeViewData(trickId, dogId, updatedAt, l, lastViewedAt, obj2);
            return trickProgressEntity_TrickKnowledgeViewData;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z5 = false;
            if (!(other instanceof TrickProgressEntity_TrickKnowledgeViewData)) {
                return false;
            }
            if (!n.b(this.trickId, other.trickId)) {
                return false;
            }
            if (!n.b(this.dogId, other.dogId)) {
                return false;
            }
            if (this.updatedAt != other.updatedAt) {
                return false;
            }
            return this.lastViewedAt != other.lastViewedAt ? z5 : z;
        }

        public int hashCode() {
            return (this.trickId.hashCode() * 31) + this.dogId.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + Long.hashCode(this.lastViewedAt);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TrickKnowledgeViewData(trickId=";
            String str3 = ", dogId=";
            String str4 = ", updatedAt=";
            String str5 = ", lastViewedAt=";
            str = str2 + this.trickId + str3 + this.dogId + str4 + this.updatedAt + str5 + this.lastViewedAt + 41;
            return str;
        }
    }
    public TrickProgressEntity(String str, String str2, long j, Long long, Long long2, int i) {
        n.f(str, "trickId");
        n.f(str2, "dogId");
        super();
        this.trickId = str;
        this.dogId = str2;
        this.updatedAt = j;
        this.lastViewedAt = long;
        this.lastRatedAt = long2;
        this.knowledge = i;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final int getKnowledge() {
        return this.knowledge;
    }

    public final Long getLastRatedAt() {
        return this.lastRatedAt;
    }

    public final Long getLastViewedAt() {
        return this.lastViewedAt;
    }

    public final String getTrickId() {
        return this.trickId;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public /* synthetic */ TrickProgressEntity(String str, String str2, long j, Long long, Long long2, int i, int i2, g gVar) {
        Long long52;
        int i62;
        i62 = 0;
        int r7 = i2 & 8 != 0 ? i62 : long;
        int r8 = i2 & 16 != 0 ? i62 : long2;
        this(str, str2, j, l, long52, (i2 & 16 != 0 ? i62 : long2), i);
    }


    public static /* synthetic */ TrickProgressEntity copy$default(TrickProgressEntity trickProgressEntity, String str, String str2, long j, Long long, Long long2, int i, int i2, Object object) {
        String str22;
        String str32;
        long j42;
        Long long62;
        Long i72;
        int i82;
        if (i2 & 1 != 0) {
        }
        if (i2 & 2 != 0) {
        }
        if (i2 & 4 != 0) {
        }
        if (i2 & 8 != 0) {
        }
        if (i2 & 16 != 0) {
        }
        if (i2 & 32 != 0) {
        }
        return trickProgressEntity.copy(str22, str32, j42, long62, i72, i82);
    }

    /* operator */ public final String component1() {
        return this.trickId;
    }

    /* operator */ public final String component2() {
        return this.dogId;
    }

    /* operator */ public final long component3() {
        return this.updatedAt;
    }

    /* operator */ public final Long component4() {
        return this.lastViewedAt;
    }

    /* operator */ public final Long component5() {
        return this.lastRatedAt;
    }

    /* operator */ public final int component6() {
        return this.knowledge;
    }

    public final TrickProgressEntity copy(String trickId, String dogId, long updatedAt, Long lastViewedAt, Long lastRatedAt, int knowledge) {
        n.f(trickId, "trickId");
        n.f(dogId, "dogId");
        TrickProgressEntity trickProgressEntity = new TrickProgressEntity(trickId, dogId, updatedAt, l, lastViewedAt, lastRatedAt, knowledge);
        return trickProgressEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z7 = false;
        if (!(other instanceof TrickProgressEntity)) {
            return false;
        }
        if (!n.b(this.trickId, other.trickId)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (this.updatedAt != other.updatedAt) {
            return false;
        }
        if (!n.b(this.lastViewedAt, other.lastViewedAt)) {
            return false;
        }
        if (!n.b(this.lastRatedAt, other.lastRatedAt)) {
            return false;
        }
        return this.knowledge != other.knowledge ? z7 : z;
    }

    public int hashCode() {
        int i;
        i = 0;
        if (this.lastViewedAt == null) {
        } else {
            i = this.lastViewedAt.hashCode();
        }
        if (this.lastRatedAt != null) {
            i = this.lastRatedAt.hashCode();
        }
        return (this.trickId.hashCode() * 31) + this.dogId.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + i * 31 + i * 31 + Integer.hashCode(this.knowledge);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrickProgressEntity(trickId=";
        String str3 = ", dogId=";
        String str4 = ", updatedAt=";
        String str5 = ", lastViewedAt=";
        String str6 = ", lastRatedAt=";
        String str7 = ", knowledge=";
        str = str2 + this.trickId + str3 + this.dogId + str4 + this.updatedAt + str5 + this.lastViewedAt + str6 + this.lastRatedAt + str7 + this.knowledge + 41;
        return str;
    }
}
