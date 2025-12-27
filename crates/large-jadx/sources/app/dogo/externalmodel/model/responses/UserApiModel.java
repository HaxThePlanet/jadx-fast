package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.externalmodel.model.PottyReminderModel;
import app.dogo.externalmodel.model.TrainingReminderModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.j0;
import kotlin.y.p;

/* compiled from: UserApiModel.kt */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0087\u0008\u0018\u0000 I2\u00020\u0001:\u0006HIJKLMB¯\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\u0008\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00080\u0005\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\u0014\u0008\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000c0\u0005\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\n\u0012\u0010\u0008\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0002\u0010\u0019J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000f\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u0014HÆ\u0003J\u0015\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0015\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00080\u0005HÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\u0015\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000c0\u0005HÆ\u0003J\t\u00105\u001a\u00020\u000eHÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0011HÆ\u0003J\t\u00108\u001a\u00020\nHÆ\u0003Jµ\u0001\u00109\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u0014\u0008\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00080\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0014\u0008\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000c0\u00052\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\n2\u0010\u0008\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u000e\u0008\u0002\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u0014HÆ\u0001J\t\u0010:\u001a\u00020\u0011HÖ\u0001J\u0013\u0010;\u001a\u00020<2\u0008\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\t\u0010?\u001a\u00020\u0011HÖ\u0001J\u000e\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020\nJ\t\u0010B\u001a\u00020\u0003HÖ\u0001J\u0019\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00080\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0011\u0010\u0012\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010%R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000c0\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u001fR\u0017\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010)R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,¨\u0006N", d2 = {"Lapp/dogo/externalmodel/model/responses/UserApiModel;", "Landroid/os/Parcelable;", "id", "", "entitlements", "", "Lapp/dogo/externalmodel/model/responses/UserApiModel$Entitlement;", "dogs", "Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;", "abTestBucket", "", "policies", "Lapp/dogo/externalmodel/model/responses/UserApiModel$Policy;", "challenges", "Lapp/dogo/externalmodel/model/responses/UserApiModel$Challenges;", "firstAppOpenVersion", "firstAppOpenBuild", "", "firstAppOpenTimeMs", "reminderIds", "", "trainingReminder", "Lapp/dogo/externalmodel/model/TrainingReminderModel;", "pottyReminders", "Lapp/dogo/externalmodel/model/PottyReminderModel;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;JLjava/util/Map;Lapp/dogo/externalmodel/model/responses/UserApiModel$Challenges;Ljava/lang/String;IJLjava/util/List;Lapp/dogo/externalmodel/model/TrainingReminderModel;Ljava/util/List;)V", "getAbTestBucket", "()J", "getChallenges", "()Lapp/dogo/externalmodel/model/responses/UserApiModel$Challenges;", "getDogs", "()Ljava/util/Map;", "getEntitlements", "getFirstAppOpenBuild", "()I", "getFirstAppOpenTimeMs", "getFirstAppOpenVersion", "()Ljava/lang/String;", "getId", "getPolicies", "getPottyReminders", "()Ljava/util/List;", "getReminderIds", "getTrainingReminder", "()Lapp/dogo/externalmodel/model/TrainingReminderModel;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "isPremium", "currentTimeMs", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Challenges", "Companion", "DogApiModel", "Entitlement", "Policy", "PublicApiDogModel", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class UserApiModel implements Parcelable {

    public static final Parcelable.Creator<UserApiModel> CREATOR = null;
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final UserApiModel.Companion INSTANCE = null;
    public static final String DOG_PREMIUM_ID = "premium_dog";
    public static final String USER_PREMIUM_ID = "premium";
    private final long abTestBucket;
    private final UserApiModel.Challenges challenges;
    private final Map<String, UserApiModel.DogApiModel> dogs;
    private final Map<String, UserApiModel.Entitlement> entitlements;
    private final int firstAppOpenBuild;
    private final long firstAppOpenTimeMs;
    private final String firstAppOpenVersion;
    private final String id;
    private final Map<String, UserApiModel.Policy> policies;
    private final List<PottyReminderModel> pottyReminders;
    private final List<String> reminderIds;
    private final TrainingReminderModel trainingReminder;

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0017", d2 = {"Lapp/dogo/externalmodel/model/responses/UserApiModel$Challenges;", "Landroid/os/Parcelable;", "participatedInChallengeIds", "", "", "(Ljava/util/List;)V", "getParticipatedInChallengeIds", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Challenges implements Parcelable {

        public static final Parcelable.Creator<UserApiModel.Challenges> CREATOR = new UserApiModel$Challenges$Creator<>();
        private final List<String> participatedInChallengeIds;
        public Challenges(List<String> list) {
            n.f(list, "participatedInChallengeIds");
            super();
            this.participatedInChallengeIds = list;
        }

        public final List<String> getParticipatedInChallengeIds() {
            return this.participatedInChallengeIds;
        }

        public /* synthetic */ Challenges(List list, int i, g gVar) {
            List list2;
            if (i & 1 != 0) {
                list2 = p.g();
            }
            this(list2);
        }


        public Challenges() {
            final List list = null;
            this(list, 1, list);
        }

        public static /* synthetic */ UserApiModel.Challenges copy$default(UserApiModel.Challenges challenges, List list, int i, Object object) {
            List participatedInChallengeIds2;
            if (i & 1 != 0) {
            }
            return challenges.copy(participatedInChallengeIds2);
        }

        /* operator */ public final List<String> component1() {
            return this.participatedInChallengeIds;
        }

        public final UserApiModel.Challenges copy(List<String> participatedInChallengeIds) {
            n.f(participatedInChallengeIds, "participatedInChallengeIds");
            return new UserApiModel_Challenges(participatedInChallengeIds);
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
            final boolean z3 = false;
            if (!(other instanceof UserApiModel_Challenges)) {
                return false;
            }
            return !n.b(this.participatedInChallengeIds, other.participatedInChallengeIds) ? z3 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.participatedInChallengeIds.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Challenges(participatedInChallengeIds=";
            str = str2 + this.participatedInChallengeIds + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeStringList(this.participatedInChallengeIds);
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lapp/dogo/externalmodel/model/responses/UserApiModel$Companion;", "", "()V", "DOG_PREMIUM_ID", "", "USER_PREMIUM_ID", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserApiModel> {
        @Override // android.os.Parcelable$Creator
        public final UserApiModel createFromParcel(Parcel parcel) {
            Object fromParcel = null;
            int _int;
            int i = 0;
            Object fromParcel2;
            Map map;
            Object parcel2 = parcel;
            n.f(parcel2, "parcel");
            int _int2 = parcel.readInt();
            final LinkedHashMap linkedHashMap = new LinkedHashMap(_int2);
            i = 0;
            while (i != _int2) {
                linkedHashMap.put(parcel.readString(), UserApiModel_Entitlement.CREATOR.createFromParcel(parcel2));
                i = i + 1;
            }
            int _int3 = parcel.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(_int3);
            while (i != _int3) {
                linkedHashMap2.put(parcel.readString(), UserApiModel_DogApiModel.CREATOR.createFromParcel(parcel2));
                i = i + 1;
            }
            int _int4 = parcel.readInt();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(_int4);
            while (i != _int4) {
                linkedHashMap3.put(parcel.readString(), UserApiModel_Policy.CREATOR.createFromParcel(parcel2));
                i = i + 1;
            }
            if (parcel.readInt() == 0) {
                int i2 = 0;
            } else {
                fromParcel = TrainingReminderModel.CREATOR.createFromParcel(parcel2);
            }
            ArrayList arrayList = new ArrayList(parcel.readInt());
            while (i != TrainingReminderModel.CREATOR) {
                arrayList.add(PottyReminderModel.CREATOR.createFromParcel(parcel2));
                i = i + 1;
            }
            UserApiModel userApiModel = new UserApiModel(parcel.readString(), linkedHashMap, linkedHashMap2, parcel.readLong(), map, linkedHashMap3, (UserApiModel_Challenges)UserApiModel_Challenges.CREATOR.createFromParcel(parcel2), parcel.readString(), parcel.readInt(), parcel.readLong(), trainingReminderModel, parcel.createStringArrayList(), fromParcel, arrayList);
            return userApiModel;
        }

        @Override // android.os.Parcelable$Creator
        public final UserApiModel[] newArray(int i) {
            return new UserApiModel[i];
        }
    }

    @Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008 \n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0015\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0098\u0001\u0010/\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0014\u0008\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001¢\u0006\u0002\u00100J\t\u00101\u001a\u000202HÖ\u0001J\u0013\u00103\u001a\u00020\n2\u0008\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u000202HÖ\u0001J\u000e\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\u000eJ\t\u00109\u001a\u00020\u0003HÖ\u0001J\u0019\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u000202HÖ\u0001R\u0013\u0010\u000c\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\u0008\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0014R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0014R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u0014¨\u0006?", d2 = {"Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;", "Landroid/os/Parcelable;", "id", "", "creatorId", "name", "breedId", "customBreed", "birthday", "birthdayExact", "", "gender", "avatarUrl", "createdTimeMs", "", "entitlements", "", "Lapp/dogo/externalmodel/model/responses/UserApiModel$Entitlement;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)V", "getAvatarUrl", "()Ljava/lang/String;", "getBirthday", "getBirthdayExact", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBreedId", "getCreatedTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCreatorId", "getCustomBreed", "getEntitlements", "()Ljava/util/Map;", "getGender", "getId", "getName", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;", "describeContents", "", "equals", "other", "", "hashCode", "isPremium", "currentTimeMs", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DogApiModel implements Parcelable {

        public static final Parcelable.Creator<UserApiModel.DogApiModel> CREATOR = new UserApiModel$DogApiModel$Creator<>();
        private final String avatarUrl;
        private final String birthday;
        private final Boolean birthdayExact;
        private final String breedId;
        private final Long createdTimeMs;
        private final String creatorId;
        private final String customBreed;
        private final Map<String, UserApiModel.Entitlement> entitlements;
        private final String gender;
        private final String id;
        private final String name;
        public DogApiModel(String str, String str2, String str3, String str4, String str5, String str6, Boolean boolean, String str7, String str8, Long long, Map<String, UserApiModel.Entitlement> map) {
            n.f(str, "id");
            n.f(str2, "creatorId");
            n.f(map, "entitlements");
            super();
            this.id = str;
            this.creatorId = str2;
            this.name = str3;
            this.breedId = str4;
            this.customBreed = str5;
            this.birthday = str6;
            this.birthdayExact = boolean;
            this.gender = str7;
            this.avatarUrl = str8;
            this.createdTimeMs = long;
            this.entitlements = map;
        }

        public final String getAvatarUrl() {
            return this.avatarUrl;
        }

        public final String getBirthday() {
            return this.birthday;
        }

        public final Boolean getBirthdayExact() {
            return this.birthdayExact;
        }

        public final String getBreedId() {
            return this.breedId;
        }

        public final Long getCreatedTimeMs() {
            return this.createdTimeMs;
        }

        public final String getCreatorId() {
            return this.creatorId;
        }

        public final String getCustomBreed() {
            return this.customBreed;
        }

        public final Map<String, UserApiModel.Entitlement> getEntitlements() {
            return this.entitlements;
        }

        public final String getGender() {
            return this.gender;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean isPremium(long currentTimeMs) {
            boolean entitlementActive = false;
            Object value = this.entitlements.get("premium_dog");
            if (value == null) {
                int i = 0;
            } else {
                entitlementActive = value.isEntitlementActive(currentTimeMs);
            }
            return entitlementActive;
        }

        public /* synthetic */ DogApiModel(String str, String str2, String str3, String str4, String str5, String str6, Boolean boolean, String str7, String str8, Long long, Map map, int i, g gVar) {
            String str32;
            String str42;
            String str52;
            String str62;
            Boolean boolean72;
            String str82;
            String str92;
            Long long102;
            int i122 = i;
            i = 0;
            int r6 = i122 & 4 != 0 ? i : str3;
            int r7 = i122 & 8 != 0 ? i : str4;
            int r8 = i122 & 16 != 0 ? i : str5;
            int r9 = i122 & 32 != 0 ? i : str6;
            int r10 = i122 & 64 != 0 ? i : boolean;
            int r11 = i122 & 128 != 0 ? i : str7;
            int r12 = i122 & 256 != 0 ? i : str8;
            int r13 = i122 & 512 != 0 ? i : long;
            this(str, str2, str32, str42, str52, str62, boolean72, str82, str92, (i122 & 512 != 0 ? i : long), map);
        }


        public static /* synthetic */ UserApiModel.DogApiModel copy$default(UserApiModel.DogApiModel dogApiModel, String str, String str2, String str3, String str4, String str5, String str6, Boolean boolean, String str7, String str8, Long long, Map map, int i, Object object) {
            Map map122;
            String str22;
            String str32;
            String str42;
            String str52;
            String str62;
            String str72;
            Boolean boolean82;
            String str92;
            String str102;
            Long long112;
            Object dogApiModel2 = dogApiModel;
            int i132 = i;
            String r2 = i132 & 1 != 0 ? dogApiModel2.id : str;
            String r3 = i132 & 2 != 0 ? dogApiModel2.creatorId : str2;
            String r4 = i132 & 4 != 0 ? dogApiModel2.name : str3;
            String r5 = i132 & 8 != 0 ? dogApiModel2.breedId : str4;
            String r6 = i132 & 16 != 0 ? dogApiModel2.customBreed : str5;
            String r7 = i132 & 32 != 0 ? dogApiModel2.birthday : str6;
            Boolean r8 = i132 & 64 != 0 ? dogApiModel2.birthdayExact : boolean;
            String r9 = i132 & 128 != 0 ? dogApiModel2.gender : str7;
            String r10 = i132 & 256 != 0 ? dogApiModel2.avatarUrl : str8;
            Long r11 = i132 & 512 != 0 ? dogApiModel2.createdTimeMs : long;
            Map r1 = i132 & 1024 != 0 ? dogApiModel2.entitlements : map;
            return dogApiModel.copy(str22, str32, str42, str52, str62, str72, boolean82, str92, str102, long112, (i132 & 1024 != 0 ? dogApiModel2.entitlements : map));
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final Long component10() {
            return this.createdTimeMs;
        }

        /* operator */ public final Map<String, UserApiModel.Entitlement> component11() {
            return this.entitlements;
        }

        /* operator */ public final String component2() {
            return this.creatorId;
        }

        /* operator */ public final String component3() {
            return this.name;
        }

        /* operator */ public final String component4() {
            return this.breedId;
        }

        /* operator */ public final String component5() {
            return this.customBreed;
        }

        /* operator */ public final String component6() {
            return this.birthday;
        }

        /* operator */ public final Boolean component7() {
            return this.birthdayExact;
        }

        /* operator */ public final String component8() {
            return this.gender;
        }

        /* operator */ public final String component9() {
            return this.avatarUrl;
        }

        public final UserApiModel.DogApiModel copy(String id, String creatorId, String name, String breedId, String customBreed, String birthday, Boolean birthdayExact, String gender, String avatarUrl, Long createdTimeMs, Map<String, UserApiModel.Entitlement> entitlements) {
            n.f(id, "id");
            n.f(creatorId, "creatorId");
            final Object entitlements2 = entitlements;
            n.f(entitlements2, "entitlements");
            UserApiModel_DogApiModel userApiModel_DogApiModel = new UserApiModel_DogApiModel(id, creatorId, name, breedId, customBreed, birthday, birthdayExact, gender, avatarUrl, createdTimeMs, entitlements2);
            return userApiModel_DogApiModel;
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
            final boolean z13 = false;
            if (!(other instanceof UserApiModel_DogApiModel)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            if (!n.b(this.creatorId, other.creatorId)) {
                return false;
            }
            if (!n.b(this.name, other.name)) {
                return false;
            }
            if (!n.b(this.breedId, other.breedId)) {
                return false;
            }
            if (!n.b(this.customBreed, other.customBreed)) {
                return false;
            }
            if (!n.b(this.birthday, other.birthday)) {
                return false;
            }
            if (!n.b(this.birthdayExact, other.birthdayExact)) {
                return false;
            }
            if (!n.b(this.gender, other.gender)) {
                return false;
            }
            if (!n.b(this.avatarUrl, other.avatarUrl)) {
                return false;
            }
            if (!n.b(this.createdTimeMs, other.createdTimeMs)) {
                return false;
            }
            return !n.b(this.entitlements, other.entitlements) ? z13 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i;
            i = 0;
            if (this.name == null) {
            } else {
                i = this.name.hashCode();
            }
            if (this.breedId == null) {
            } else {
                i = this.breedId.hashCode();
            }
            if (this.customBreed == null) {
            } else {
                i = this.customBreed.hashCode();
            }
            if (this.birthday == null) {
            } else {
                i = this.birthday.hashCode();
            }
            if (this.birthdayExact == null) {
            } else {
                i = this.birthdayExact.hashCode();
            }
            if (this.gender == null) {
            } else {
                i = this.gender.hashCode();
            }
            if (this.avatarUrl == null) {
            } else {
                i = this.avatarUrl.hashCode();
            }
            if (this.createdTimeMs != null) {
                i = this.createdTimeMs.hashCode();
            }
            return (this.id.hashCode() * 31) + this.creatorId.hashCode() * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + this.entitlements.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "DogApiModel(id=";
            String str3 = ", creatorId=";
            String str4 = ", name=";
            String str5 = ", breedId=";
            String str6 = ", customBreed=";
            String str7 = ", birthday=";
            String str8 = ", birthdayExact=";
            String str9 = ", gender=";
            String str10 = ", avatarUrl=";
            String str11 = ", createdTimeMs=";
            String str12 = ", entitlements=";
            str = str2 + this.id + str3 + this.creatorId + str4 + this.name + str5 + this.breedId + str6 + this.customBreed + str7 + this.birthday + str8 + this.birthdayExact + str9 + this.gender + str10 + this.avatarUrl + str11 + this.createdTimeMs + str12 + this.entitlements + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeString(this.creatorId);
            parcel.writeString(this.name);
            parcel.writeString(this.breedId);
            parcel.writeString(this.customBreed);
            parcel.writeString(this.birthday);
            int i2 = 0;
            int i = 1;
            if (this.birthdayExact == null) {
                parcel.writeInt(i2);
            } else {
                parcel.writeInt(i);
                parcel.writeInt(this.birthdayExact.booleanValue());
            }
            parcel.writeString(this.gender);
            parcel.writeString(this.avatarUrl);
            if (this.createdTimeMs == null) {
                parcel.writeInt(i2);
            } else {
                parcel.writeInt(i);
                parcel.writeLong(this.createdTimeMs.longValue());
            }
            parcel.writeInt(this.entitlements.size());
            Iterator it = this.entitlements.entrySet().iterator();
            while (it.hasNext()) {
                Object item = it.next();
                parcel.writeString((String)item.getKey());
                (UserApiModel_Entitlement)item.getValue().writeToParcel(parcel, flags);
            }
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000e\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B!\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J0\u0010\u0011\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\t¨\u0006\"", d2 = {"Lapp/dogo/externalmodel/model/responses/UserApiModel$Entitlement;", "Landroid/os/Parcelable;", "expirationTimeMs", "", "expirationDate", "", "id", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getExpirationDate", "()Ljava/lang/String;", "getExpirationTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getId", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lapp/dogo/externalmodel/model/responses/UserApiModel$Entitlement;", "describeContents", "", "equals", "", "other", "", "hashCode", "isEntitlementActive", "currentTimeMs", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Entitlement implements Parcelable {

        public static final Parcelable.Creator<UserApiModel.Entitlement> CREATOR = new UserApiModel$Entitlement$Creator<>();
        private final String expirationDate;
        private final Long expirationTimeMs;
        private final String id;
        public Entitlement(Long long, String str, String str2) {
            n.f(str2, "id");
            super();
            this.expirationTimeMs = long;
            this.expirationDate = str;
            this.id = str2;
        }

        public final String getExpirationDate() {
            return this.expirationDate;
        }

        public final Long getExpirationTimeMs() {
            return this.expirationTimeMs;
        }

        public final String getId() {
            return this.id;
        }

        public final boolean isEntitlementActive(long currentTimeMs) {
            Long expirationTimeMs2;
            boolean z = false;
            if (this.expirationTimeMs != null) {
                long value = this.expirationTimeMs.longValue();
                if (value > currentTimeMs) {
                    int i2 = 1;
                } else {
                    int i = 0;
                }
            }
            return z;
        }


        public static /* synthetic */ UserApiModel.Entitlement copy$default(UserApiModel.Entitlement entitlement, Long long, String str, String str2, int i, Object object) {
            Long expirationTimeMs2;
            String expirationDate2;
            String id2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            return entitlement.copy(expirationTimeMs2, expirationDate2, id2);
        }

        /* operator */ public final Long component1() {
            return this.expirationTimeMs;
        }

        /* operator */ public final String component2() {
            return this.expirationDate;
        }

        /* operator */ public final String component3() {
            return this.id;
        }

        public final UserApiModel.Entitlement copy(Long expirationTimeMs, String expirationDate, String id) {
            n.f(id, "id");
            return new UserApiModel_Entitlement(expirationTimeMs, expirationDate, id);
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
            if (!(other instanceof UserApiModel_Entitlement)) {
                return false;
            }
            if (!n.b(this.expirationTimeMs, other.expirationTimeMs)) {
                return false;
            }
            if (!n.b(this.expirationDate, other.expirationDate)) {
                return false;
            }
            return !n.b(this.id, other.id) ? z5 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i;
            i = 0;
            if (this.expirationTimeMs == null) {
            } else {
                i = this.expirationTimeMs.hashCode();
            }
            if (this.expirationDate != null) {
                i = this.expirationDate.hashCode();
            }
            return (i * 31) + i * 31 + this.id.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Entitlement(expirationTimeMs=";
            String str3 = ", expirationDate=";
            String str4 = ", id=";
            str = str2 + this.expirationTimeMs + str3 + this.expirationDate + str4 + this.id + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            if (this.expirationTimeMs == null) {
                int i = 0;
                parcel.writeInt(i);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(this.expirationTimeMs.longValue());
            }
            parcel.writeString(this.expirationDate);
            parcel.writeString(this.id);
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u001f", d2 = {"Lapp/dogo/externalmodel/model/responses/UserApiModel$Policy;", "Landroid/os/Parcelable;", "id", "", "status", "consentedTimeMs", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getConsentedTimeMs", "()J", "getId", "()Ljava/lang/String;", "getStatus", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Policy implements Parcelable {

        public static final Parcelable.Creator<UserApiModel.Policy> CREATOR = null;
        /* renamed from: Companion, reason: from kotlin metadata */
        public static final UserApiModel.Policy.Companion INSTANCE = null;
        public static final String POLICY_ACCEPTED = "accepted";
        public static final String POLICY_SEEN = "seen";
        private final long consentedTimeMs;
        private final String id;
        private final String status;
        public Policy(String str, String str2, long j) {
            n.f(str, "id");
            n.f(str2, "status");
            super();
            this.id = str;
            this.status = str2;
            this.consentedTimeMs = j;
        }

        public final long getConsentedTimeMs() {
            return this.consentedTimeMs;
        }

        public final String getId() {
            return this.id;
        }

        public final String getStatus() {
            return this.status;
        }

        static {
            UserApiModel_Policy.INSTANCE = new UserApiModel_Policy_Companion(null);
            UserApiModel_Policy.CREATOR = new UserApiModel.Policy.Creator();
        }

        public static /* synthetic */ UserApiModel.Policy copy$default(UserApiModel.Policy policy, String str, String str2, long j, int i, Object object) {
            String id2;
            String status2;
            long consentedTimeMs2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            return policy.copy(id2, status2, consentedTimeMs2);
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final String component2() {
            return this.status;
        }

        /* operator */ public final long component3() {
            return this.consentedTimeMs;
        }

        public final UserApiModel.Policy copy(String id, String status, long consentedTimeMs) {
            n.f(id, "id");
            n.f(status, "status");
            return new UserApiModel_Policy(id, status, consentedTimeMs, r5);
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
            if (!(other instanceof UserApiModel_Policy)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            if (!n.b(this.status, other.status)) {
                return false;
            }
            return this.consentedTimeMs != other.consentedTimeMs ? z5 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.id.hashCode() * 31) + this.status.hashCode() * 31 + Long.hashCode(this.consentedTimeMs);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Policy(id=";
            String str3 = ", status=";
            String str4 = ", consentedTimeMs=";
            str = str2 + this.id + str3 + this.status + str4 + this.consentedTimeMs + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeString(this.status);
            parcel.writeLong(this.consentedTimeMs);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0015\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BM\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0017\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000b¨\u0006%", d2 = {"Lapp/dogo/externalmodel/model/responses/UserApiModel$PublicApiDogModel;", "Landroid/os/Parcelable;", "id", "", "name", "breedId", "customBreed", "gender", "avatarUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "getBreedId", "getCustomBreed", "getGender", "getId", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PublicApiDogModel implements Parcelable {

        public static final Parcelable.Creator<UserApiModel.PublicApiDogModel> CREATOR = new UserApiModel$PublicApiDogModel$Creator<>();
        private final String avatarUrl;
        private final String breedId;
        private final String customBreed;
        private final String gender;
        private final String id;
        private final String name;
        public PublicApiDogModel(String str, String str2, String str3, String str4, String str5, String str6) {
            super();
            this.id = str;
            this.name = str2;
            this.breedId = str3;
            this.customBreed = str4;
            this.gender = str5;
            this.avatarUrl = str6;
        }

        public final String getAvatarUrl() {
            return this.avatarUrl;
        }

        public final String getBreedId() {
            return this.breedId;
        }

        public final String getCustomBreed() {
            return this.customBreed;
        }

        public final String getGender() {
            return this.gender;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public /* synthetic */ PublicApiDogModel(String str, String str2, String str3, String str4, String str5, String str6, int i, g gVar) {
            int str22;
            String str62;
            str22 = 0;
            gVar = i & 1 != 0 ? str22 : str;
            int r1 = i & 2 != 0 ? str22 : str2;
            int r2 = i & 4 != 0 ? str22 : str3;
            int r3 = i & 8 != 0 ? str22 : str4;
            int r4 = i & 16 != 0 ? str22 : str5;
            i = i & 32 != 0 ? str22 : str6;
            this(str22, str22, str22, str22, str22, (i & 32 != 0 ? str22 : str6));
        }


        public PublicApiDogModel() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ UserApiModel.PublicApiDogModel copy$default(UserApiModel.PublicApiDogModel publicApiDogModel, String str, String str2, String str3, String str4, String str5, String str6, int i, Object object) {
            String str22;
            String object92;
            String str42;
            String str52;
            String str62;
            String str72;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            if (i & 8 != 0) {
            }
            if (i & 16 != 0) {
            }
            if (i & 32 != 0) {
            }
            return publicApiDogModel.copy(str22, object92, str42, str52, str62, str72);
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final String component2() {
            return this.name;
        }

        /* operator */ public final String component3() {
            return this.breedId;
        }

        /* operator */ public final String component4() {
            return this.customBreed;
        }

        /* operator */ public final String component5() {
            return this.gender;
        }

        /* operator */ public final String component6() {
            return this.avatarUrl;
        }

        public final UserApiModel.PublicApiDogModel copy(String id, String name, String breedId, String customBreed, String gender, String avatarUrl) {
            UserApiModel_PublicApiDogModel userApiModel_PublicApiDogModel = new UserApiModel_PublicApiDogModel(id, name, breedId, customBreed, gender, avatarUrl);
            return userApiModel_PublicApiDogModel;
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
            if (!(other instanceof UserApiModel_PublicApiDogModel)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            if (!n.b(this.name, other.name)) {
                return false;
            }
            if (!n.b(this.breedId, other.breedId)) {
                return false;
            }
            if (!n.b(this.customBreed, other.customBreed)) {
                return false;
            }
            if (!n.b(this.gender, other.gender)) {
                return false;
            }
            return !n.b(this.avatarUrl, other.avatarUrl) ? z8 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i;
            i = 0;
            if (this.id == null) {
            } else {
                i = this.id.hashCode();
            }
            if (this.name == null) {
            } else {
                i = this.name.hashCode();
            }
            if (this.breedId == null) {
            } else {
                i = this.breedId.hashCode();
            }
            if (this.customBreed == null) {
            } else {
                i = this.customBreed.hashCode();
            }
            if (this.gender == null) {
            } else {
                i = this.gender.hashCode();
            }
            if (this.avatarUrl != null) {
                i = this.avatarUrl.hashCode();
            }
            return (i * 31) + i * 31 + i * 31 + i * 31 + i * 31 + i;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "PublicApiDogModel(id=";
            String str3 = ", name=";
            String str4 = ", breedId=";
            String str5 = ", customBreed=";
            String str6 = ", gender=";
            String str7 = ", avatarUrl=";
            str = str2 + this.id + str3 + this.name + str4 + this.breedId + str5 + this.customBreed + str6 + this.gender + str7 + this.avatarUrl + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeString(this.name);
            parcel.writeString(this.breedId);
            parcel.writeString(this.customBreed);
            parcel.writeString(this.gender);
            parcel.writeString(this.avatarUrl);
        }
    }
    public UserApiModel(String str, Map<String, UserApiModel.Entitlement> map, Map<String, UserApiModel.DogApiModel> map2, long j, Map<String, UserApiModel.Policy> map3, UserApiModel.Challenges challenges, String str2, int i, long j2, List<String> list, TrainingReminderModel trainingReminderModel, List<PottyReminderModel> list2) {
        n.f(str, "id");
        n.f(map, "entitlements");
        n.f(map2, "dogs");
        n.f(map3, "policies");
        n.f(challenges, "challenges");
        n.f(str2, "firstAppOpenVersion");
        n.f(list2, "pottyReminders");
        super();
        this.id = str;
        this.entitlements = map;
        this.dogs = map2;
        this.abTestBucket = j;
        this.policies = map3;
        this.challenges = challenges;
        this.firstAppOpenVersion = str2;
        this.firstAppOpenBuild = i;
        this.firstAppOpenTimeMs = j2;
        this.reminderIds = list;
        this.trainingReminder = trainingReminderModel;
        this.pottyReminders = list2;
    }

    public final long getAbTestBucket() {
        return this.abTestBucket;
    }

    public final UserApiModel.Challenges getChallenges() {
        return this.challenges;
    }

    public final Map<String, UserApiModel.DogApiModel> getDogs() {
        return this.dogs;
    }

    public final Map<String, UserApiModel.Entitlement> getEntitlements() {
        return this.entitlements;
    }

    public final int getFirstAppOpenBuild() {
        return this.firstAppOpenBuild;
    }

    public final long getFirstAppOpenTimeMs() {
        return this.firstAppOpenTimeMs;
    }

    public final String getFirstAppOpenVersion() {
        return this.firstAppOpenVersion;
    }

    public final String getId() {
        return this.id;
    }

    public final Map<String, UserApiModel.Policy> getPolicies() {
        return this.policies;
    }

    public final List<PottyReminderModel> getPottyReminders() {
        return this.pottyReminders;
    }

    public final List<String> getReminderIds() {
        return this.reminderIds;
    }

    public final TrainingReminderModel getTrainingReminder() {
        return this.trainingReminder;
    }

    public final boolean isPremium(long currentTimeMs) {
        boolean entitlementActive = false;
        Object value = this.entitlements.get("premium");
        if (value == null) {
            int i = 0;
        } else {
            entitlementActive = value.isEntitlementActive(currentTimeMs);
        }
        return entitlementActive;
    }

    public /* synthetic */ UserApiModel(String str, Map map, Map map2, long j, Map map3, UserApiModel.Challenges challenges, String str2, int i, long j2, List list, TrainingReminderModel trainingReminderModel, List list2, int i2, g gVar) {
        List i132;
        Map challenges62;
        String i82;
        Map map22;
        Map map32;
        int j42;
        app.dogo.externalmodel.model.responses.UserApiModel.Challenges str72;
        int j92;
        Object obj;
        i = i2;
        i82 = "";
        String r4 = i & 1 != 0 ? "" : str;
        i2 = i & 2;
        map22 = i & 2 != 0 ? map22 : map;
        i3 = i & 4;
        map32 = i & 4 != 0 ? map32 : map2;
        j42 = 0;
        int r9 = i & 8 != 0 ? j42 : j;
        if (i & 16 != 0) {
            challenges62 = j0.h();
        } else {
            challenges62 = map3;
        }
        i4 = i & 32;
        i132 = null;
        UserApiModel_Challenges r12 = i & 32 != 0 ? new UserApiModel_Challenges(i132, 1, i132) : challenges;
        if (i & 64 == 0) {
            i82 = str2;
        }
        j92 = i & 128;
        j92 = i & 128 != 0 ? j92 : i;
        int r14 = i & 256 != 0 ? j42 : j2;
        List r16 = i & 512 != 0 ? i132 : list;
        List r0 = i & 1024 != 0 ? i132 : trainingReminderModel;
        this(i82, map22, map32, j42, map, challenges62, str72, i82, j92, obj, obj, i132, (i & 1024 != 0 ? i132 : trainingReminderModel), list2);
    }

    static {
        UserApiModel.INSTANCE = new UserApiModel_Companion(null);
        UserApiModel.CREATOR = new UserApiModel.Creator();
    }

    public static /* synthetic */ UserApiModel copy$default(UserApiModel userApiModel, String str, Map map, Map map2, long j, Map map3, UserApiModel.Challenges challenges, String str2, int i, long j2, List list, TrainingReminderModel trainingReminderModel, List list2, int i2, Object object) {
        List object152;
        String str22;
        Map map32;
        Map map42;
        long j52;
        Map challenges72;
        app.dogo.externalmodel.model.responses.UserApiModel.Challenges str82;
        String i92;
        int j102;
        long list112;
        List list132;
        TrainingReminderModel i142;
        Object userApiModel2 = userApiModel;
        i = i2;
        String r2 = i & 1 != 0 ? userApiModel2.id : str;
        Map r3 = i & 2 != 0 ? userApiModel2.entitlements : map;
        Map r4 = i & 4 != 0 ? userApiModel2.dogs : map2;
        long r5 = i & 8 != 0 ? userApiModel2.abTestBucket : j;
        Map r7 = i & 16 != 0 ? userApiModel2.policies : map3;
        app.dogo.externalmodel.model.responses.UserApiModel.Challenges r8 = i & 32 != 0 ? userApiModel2.challenges : challenges;
        String r9 = i & 64 != 0 ? userApiModel2.firstAppOpenVersion : str2;
        int r10 = i & 128 != 0 ? userApiModel2.firstAppOpenBuild : i;
        long r11 = i & 256 != 0 ? userApiModel2.firstAppOpenTimeMs : j2;
        List r13 = i & 512 != 0 ? userApiModel2.reminderIds : list;
        TrainingReminderModel r14 = i & 1024 != 0 ? userApiModel2.trainingReminder : trainingReminderModel;
        List r1 = i & 2048 != 0 ? userApiModel2.pottyReminders : list2;
        return userApiModel.copy(str22, map32, map42, j52, r20, challenges72, str82, i92, j102, list112, r26, list132, i142, (i & 2048 != 0 ? userApiModel2.pottyReminders : list2));
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final List<String> component10() {
        return this.reminderIds;
    }

    /* operator */ public final TrainingReminderModel component11() {
        return this.trainingReminder;
    }

    /* operator */ public final List<PottyReminderModel> component12() {
        return this.pottyReminders;
    }

    /* operator */ public final Map<String, UserApiModel.Entitlement> component2() {
        return this.entitlements;
    }

    /* operator */ public final Map<String, UserApiModel.DogApiModel> component3() {
        return this.dogs;
    }

    /* operator */ public final long component4() {
        return this.abTestBucket;
    }

    /* operator */ public final Map<String, UserApiModel.Policy> component5() {
        return this.policies;
    }

    /* operator */ public final UserApiModel.Challenges component6() {
        return this.challenges;
    }

    /* operator */ public final String component7() {
        return this.firstAppOpenVersion;
    }

    /* operator */ public final int component8() {
        return this.firstAppOpenBuild;
    }

    /* operator */ public final long component9() {
        return this.firstAppOpenTimeMs;
    }

    public final UserApiModel copy(String id, Map<String, UserApiModel.Entitlement> entitlements, Map<String, UserApiModel.DogApiModel> dogs, long abTestBucket, Map<String, UserApiModel.Policy> policies, UserApiModel.Challenges challenges, String firstAppOpenVersion, int firstAppOpenBuild, long firstAppOpenTimeMs, List<String> reminderIds, TrainingReminderModel trainingReminder, List<PottyReminderModel> pottyReminders) {
        final Object id2 = id;
        n.f(id2, "id");
        final Object entitlements2 = entitlements;
        n.f(entitlements2, "entitlements");
        final Object dogs2 = dogs;
        n.f(dogs2, "dogs");
        final Object challenges2 = policies;
        n.f(challenges2, "policies");
        final Object firstAppOpenVersion2 = challenges;
        n.f(firstAppOpenVersion2, "challenges");
        final Object firstAppOpenBuild2 = firstAppOpenVersion;
        n.f(firstAppOpenBuild2, "firstAppOpenVersion");
        final Object obj = pottyReminders;
        n.f(obj, "pottyReminders");
        UserApiModel userApiModel = new UserApiModel(id2, entitlements2, dogs2, abTestBucket, map, challenges2, firstAppOpenVersion2, firstAppOpenBuild2, firstAppOpenBuild, firstAppOpenTimeMs, trainingReminderModel, reminderIds, trainingReminder, obj);
        return userApiModel;
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
        final boolean z11 = false;
        if (!(other instanceof UserApiModel)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.entitlements, other.entitlements)) {
            return false;
        }
        if (!n.b(this.dogs, other.dogs)) {
            return false;
        }
        if (this.abTestBucket != other.abTestBucket) {
            return false;
        }
        if (!n.b(this.policies, other.policies)) {
            return false;
        }
        if (!n.b(this.challenges, other.challenges)) {
            return false;
        }
        if (!n.b(this.firstAppOpenVersion, other.firstAppOpenVersion)) {
            return false;
        }
        if (this.firstAppOpenBuild != other.firstAppOpenBuild) {
            return false;
        }
        if (this.firstAppOpenTimeMs != other.firstAppOpenTimeMs) {
            return false;
        }
        if (!n.b(this.reminderIds, other.reminderIds)) {
            return false;
        }
        if (!n.b(this.trainingReminder, other.trainingReminder)) {
            return false;
        }
        return !n.b(this.pottyReminders, other.pottyReminders) ? z11 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        i = 0;
        if (this.reminderIds == null) {
        } else {
            i = this.reminderIds.hashCode();
        }
        if (this.trainingReminder != null) {
            i = this.trainingReminder.hashCode();
        }
        return (this.id.hashCode() * 31) + this.entitlements.hashCode() * 31 + this.dogs.hashCode() * 31 + Long.hashCode(this.abTestBucket) * 31 + this.policies.hashCode() * 31 + this.challenges.hashCode() * 31 + this.firstAppOpenVersion.hashCode() * 31 + Integer.hashCode(this.firstAppOpenBuild) * 31 + Long.hashCode(this.firstAppOpenTimeMs) * 31 + i * 31 + i * 31 + this.pottyReminders.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "UserApiModel(id=";
        String str3 = ", entitlements=";
        String str4 = ", dogs=";
        String str5 = ", abTestBucket=";
        String str6 = ", policies=";
        String str7 = ", challenges=";
        String str8 = ", firstAppOpenVersion=";
        String str9 = ", firstAppOpenBuild=";
        String str10 = ", firstAppOpenTimeMs=";
        String str11 = ", reminderIds=";
        String str12 = ", trainingReminder=";
        String str13 = ", pottyReminders=";
        str = str2 + this.id + str3 + this.entitlements + str4 + this.dogs + str5 + this.abTestBucket + str6 + this.policies + str7 + this.challenges + str8 + this.firstAppOpenVersion + str9 + this.firstAppOpenBuild + str10 + this.firstAppOpenTimeMs + str11 + this.reminderIds + str12 + this.trainingReminder + str13 + this.pottyReminders + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Object key;
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeInt(this.entitlements.size());
        Iterator it = this.entitlements.entrySet().iterator();
        while (it.hasNext()) {
            Object item4 = it.next();
            parcel.writeString((String)item4.getKey());
            (UserApiModel_Entitlement)item4.getValue().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.dogs.size());
        Iterator it2 = this.dogs.entrySet().iterator();
        boolean hasNext2 = it2.hasNext();
        while (hasNext2) {
            Object item3 = it2.next();
            parcel.writeString((String)item3.getKey());
            (UserApiModel_DogApiModel)item3.getValue().writeToParcel(parcel, flags);
            hasNext2 = it2.hasNext();
        }
        parcel.writeLong(this.abTestBucket);
        parcel.writeInt(this.policies.size());
        Iterator it3 = this.policies.entrySet().iterator();
        boolean hasNext3 = it3.hasNext();
        while (hasNext3) {
            Object item2 = it3.next();
            parcel.writeString((String)item2.getKey());
            (UserApiModel_Policy)item2.getValue().writeToParcel(parcel, flags);
            hasNext3 = it3.hasNext();
        }
        this.challenges.writeToParcel(parcel, flags);
        parcel.writeString(this.firstAppOpenVersion);
        parcel.writeInt(this.firstAppOpenBuild);
        parcel.writeLong(this.firstAppOpenTimeMs);
        parcel.writeStringList(this.reminderIds);
        if (this.trainingReminder == null) {
            parcel.writeInt(0);
        } else {
            int i = 1;
            parcel.writeInt(i);
            this.trainingReminder.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.pottyReminders.size());
        Iterator it4 = this.pottyReminders.iterator();
        while (it4.hasNext()) {
            (PottyReminderModel)it4.next().writeToParcel(parcel, flags);
        }
    }
}
