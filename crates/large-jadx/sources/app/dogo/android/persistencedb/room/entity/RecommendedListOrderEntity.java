package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: RecommendedListOrderEntity.kt */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u0016B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0010J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0017", d2 = {"Lapp/dogo/android/persistencedb/room/entity/RecommendedListOrderEntity;", "", "dogId", "", "recommendedProgramIds", "", "Lapp/dogo/android/persistencedb/room/entity/RecommendedListOrderEntity$ProgramCompatibility;", "(Ljava/lang/String;Ljava/util/List;)V", "getDogId", "()Ljava/lang/String;", "getRecommendedProgramIds", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isEmpty", "toString", "ProgramCompatibility", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class RecommendedListOrderEntity {

    private final String dogId;
    private final List<RecommendedListOrderEntity.ProgramCompatibility> recommendedProgramIds;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0008J$\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0015", d2 = {"Lapp/dogo/android/persistencedb/room/entity/RecommendedListOrderEntity$ProgramCompatibility;", "", "programId", "", "compatibility", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getCompatibility", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProgramId", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lapp/dogo/android/persistencedb/room/entity/RecommendedListOrderEntity$ProgramCompatibility;", "equals", "", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ProgramCompatibility {

        private final Integer compatibility;
        private final String programId;
        public ProgramCompatibility(String str, Integer integer) {
            n.f(str, "programId");
            super();
            this.programId = str;
            this.compatibility = integer;
        }

        public final Integer getCompatibility() {
            return this.compatibility;
        }

        public final String getProgramId() {
            return this.programId;
        }

        public /* synthetic */ ProgramCompatibility(String str, Integer integer, int i, g gVar) {
            Integer num = null;
            i = i & 2 != 0 ? 0 : i;
            this(str, num);
        }

        public static /* synthetic */ RecommendedListOrderEntity.ProgramCompatibility copy$default(RecommendedListOrderEntity.ProgramCompatibility list, String str, Integer integer, int i, Object object) {
            String programId2;
            Integer compatibility2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            return list.copy(programId2, compatibility2);
        }

        /* operator */ public final String component1() {
            return this.programId;
        }

        /* operator */ public final Integer component2() {
            return this.compatibility;
        }

        public final RecommendedListOrderEntity.ProgramCompatibility copy(String programId, Integer compatibility) {
            n.f(programId, "programId");
            return new RecommendedListOrderEntity_ProgramCompatibility(programId, compatibility);
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z4 = false;
            if (!(other instanceof RecommendedListOrderEntity_ProgramCompatibility)) {
                return false;
            }
            if (!n.b(this.programId, other.programId)) {
                return false;
            }
            return !n.b(this.compatibility, other.compatibility) ? z4 : z;
        }

        public int hashCode() {
            int i = 0;
            if (this.compatibility == null) {
                i = 0;
            } else {
                i = this.compatibility.hashCode();
            }
            return (this.programId.hashCode() * 31) + i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "ProgramCompatibility(programId=";
            String str3 = ", compatibility=";
            str = str2 + this.programId + str3 + this.compatibility + 41;
            return str;
        }
    }
    public RecommendedListOrderEntity(String str, List<RecommendedListOrderEntity.ProgramCompatibility> list) {
        n.f(str, "dogId");
        n.f(list, "recommendedProgramIds");
        super();
        this.dogId = str;
        this.recommendedProgramIds = list;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final List<RecommendedListOrderEntity.ProgramCompatibility> getRecommendedProgramIds() {
        return this.recommendedProgramIds;
    }

    public final boolean isEmpty() {
        return this.recommendedProgramIds.isEmpty();
    }

    public static /* synthetic */ RecommendedListOrderEntity copy$default(RecommendedListOrderEntity list, String str, List list2, int i, Object object) {
        String dogId2;
        List recommendedProgramIds2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return list.copy(dogId2, recommendedProgramIds2);
    }

    /* operator */ public final String component1() {
        return this.dogId;
    }

    /* operator */ public final List<RecommendedListOrderEntity.ProgramCompatibility> component2() {
        return this.recommendedProgramIds;
    }

    public final RecommendedListOrderEntity copy(String dogId, List<RecommendedListOrderEntity.ProgramCompatibility> recommendedProgramIds) {
        n.f(dogId, "dogId");
        n.f(recommendedProgramIds, "recommendedProgramIds");
        return new RecommendedListOrderEntity(dogId, recommendedProgramIds);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z4 = false;
        if (!(other instanceof RecommendedListOrderEntity)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        return !n.b(this.recommendedProgramIds, other.recommendedProgramIds) ? z4 : z;
    }

    public int hashCode() {
        return (this.dogId.hashCode() * 31) + this.recommendedProgramIds.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "RecommendedListOrderEntity(dogId=";
        String str3 = ", recommendedProgramIds=";
        str = str2 + this.dogId + str3 + this.recommendedProgramIds + 41;
        return str;
    }
}
