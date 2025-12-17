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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0087\u0008\u0018\u0000 I2\u00020\u0001:\u0006HIJKLMB¯\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\u0008\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00080\u0005\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\u0014\u0008\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000c0\u0005\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\n\u0012\u0010\u0008\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0002\u0010\u0019J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000f\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u0014HÆ\u0003J\u0015\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0015\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00080\u0005HÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\u0015\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000c0\u0005HÆ\u0003J\t\u00105\u001a\u00020\u000eHÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0011HÆ\u0003J\t\u00108\u001a\u00020\nHÆ\u0003Jµ\u0001\u00109\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u0014\u0008\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00080\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0014\u0008\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000c0\u00052\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\n2\u0010\u0008\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u000e\u0008\u0002\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u0014HÆ\u0001J\t\u0010:\u001a\u00020\u0011HÖ\u0001J\u0013\u0010;\u001a\u00020<2\u0008\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\t\u0010?\u001a\u00020\u0011HÖ\u0001J\u000e\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020\nJ\t\u0010B\u001a\u00020\u0003HÖ\u0001J\u0019\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00080\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0011\u0010\u0012\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010%R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000c0\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u001fR\u0017\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010)R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,¨\u0006N", d2 = {"Lapp/dogo/externalmodel/model/responses/UserApiModel;", "Landroid/os/Parcelable;", "id", "", "entitlements", "", "Lapp/dogo/externalmodel/model/responses/UserApiModel$Entitlement;", "dogs", "Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;", "abTestBucket", "", "policies", "Lapp/dogo/externalmodel/model/responses/UserApiModel$Policy;", "challenges", "Lapp/dogo/externalmodel/model/responses/UserApiModel$Challenges;", "firstAppOpenVersion", "firstAppOpenBuild", "", "firstAppOpenTimeMs", "reminderIds", "", "trainingReminder", "Lapp/dogo/externalmodel/model/TrainingReminderModel;", "pottyReminders", "Lapp/dogo/externalmodel/model/PottyReminderModel;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;JLjava/util/Map;Lapp/dogo/externalmodel/model/responses/UserApiModel$Challenges;Ljava/lang/String;IJLjava/util/List;Lapp/dogo/externalmodel/model/TrainingReminderModel;Ljava/util/List;)V", "getAbTestBucket", "()J", "getChallenges", "()Lapp/dogo/externalmodel/model/responses/UserApiModel$Challenges;", "getDogs", "()Ljava/util/Map;", "getEntitlements", "getFirstAppOpenBuild", "()I", "getFirstAppOpenTimeMs", "getFirstAppOpenVersion", "()Ljava/lang/String;", "getId", "getPolicies", "getPottyReminders", "()Ljava/util/List;", "getReminderIds", "getTrainingReminder", "()Lapp/dogo/externalmodel/model/TrainingReminderModel;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "isPremium", "currentTimeMs", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Challenges", "Companion", "DogApiModel", "Entitlement", "Policy", "PublicApiDogModel", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UserApiModel implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.UserApiModel> CREATOR = null;
    public static final app.dogo.externalmodel.model.responses.UserApiModel.Companion Companion = null;
    public static final String DOG_PREMIUM_ID = "premium_dog";
    public static final String USER_PREMIUM_ID = "premium";
    private final long abTestBucket;
    private final app.dogo.externalmodel.model.responses.UserApiModel.Challenges challenges;
    private final Map<String, app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel> dogs;
    private final Map<String, app.dogo.externalmodel.model.responses.UserApiModel.Entitlement> entitlements;
    private final int firstAppOpenBuild;
    private final long firstAppOpenTimeMs;
    private final String firstAppOpenVersion;
    private final String id;
    private final Map<String, app.dogo.externalmodel.model.responses.UserApiModel.Policy> policies;
    private final List<PottyReminderModel> pottyReminders;
    private final List<String> reminderIds;
    private final TrainingReminderModel trainingReminder;

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0017", d2 = {"Lapp/dogo/externalmodel/model/responses/UserApiModel$Challenges;", "Landroid/os/Parcelable;", "participatedInChallengeIds", "", "", "(Ljava/util/List;)V", "getParticipatedInChallengeIds", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Challenges implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.UserApiModel.Challenges> CREATOR;
        private final List<String> participatedInChallengeIds;
        static {
            UserApiModel.Challenges.Creator creator = new UserApiModel.Challenges.Creator();
            UserApiModel.Challenges.CREATOR = creator;
        }

        public Challenges() {
            final int i = 0;
            super(i, 1, i);
        }

        public Challenges(List<String> list) {
            n.f(list, "participatedInChallengeIds");
            super();
            this.participatedInChallengeIds = list;
        }

        public Challenges(List list, int i2, g g3) {
            List obj1;
            if (i2 &= 1 != 0) {
                obj1 = p.g();
            }
            super(obj1);
        }

        public static app.dogo.externalmodel.model.responses.UserApiModel.Challenges copy$default(app.dogo.externalmodel.model.responses.UserApiModel.Challenges userApiModel$Challenges, List list2, int i3, Object object4) {
            List obj1;
            if (i3 &= 1 != 0) {
                obj1 = challenges.participatedInChallengeIds;
            }
            return challenges.copy(obj1);
        }

        public final List<String> component1() {
            return this.participatedInChallengeIds;
        }

        public final app.dogo.externalmodel.model.responses.UserApiModel.Challenges copy(List<String> list) {
            n.f(list, "participatedInChallengeIds");
            UserApiModel.Challenges challenges = new UserApiModel.Challenges(list);
            return challenges;
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
            if (!object instanceof UserApiModel.Challenges) {
                return i2;
            }
            if (!n.b(this.participatedInChallengeIds, object.participatedInChallengeIds)) {
                return i2;
            }
            return i;
        }

        public final List<String> getParticipatedInChallengeIds() {
            return this.participatedInChallengeIds;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return this.participatedInChallengeIds.hashCode();
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Challenges(participatedInChallengeIds=");
            stringBuilder.append(this.participatedInChallengeIds);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeStringList(this.participatedInChallengeIds);
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lapp/dogo/externalmodel/model/responses/UserApiModel$Companion;", "", "()V", "DOG_PREMIUM_ID", "", "USER_PREMIUM_ID", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.responses.UserApiModel> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.UserApiModel createFromParcel(Parcel parcel) {
            Object fromParcel2;
            int int;
            int i2;
            int i4;
            String string;
            int i;
            Object fromParcel3;
            Object fromParcel;
            int i3;
            String string2;
            Object fromParcel4;
            int i5;
            Object obj = parcel;
            n.f(obj, "parcel");
            int int2 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(int2);
            i2 = 0;
            i4 = i2;
            while (i4 != int2) {
                linkedHashMap.put(parcel.readString(), UserApiModel.Entitlement.CREATOR.createFromParcel(obj));
                i4++;
            }
            int int3 = parcel.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(int3);
            i = i2;
            while (i != int3) {
                linkedHashMap2.put(parcel.readString(), UserApiModel.DogApiModel.CREATOR.createFromParcel(obj));
                i++;
            }
            int int4 = parcel.readInt();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(int4);
            i3 = i2;
            while (i3 != int4) {
                linkedHashMap3.put(parcel.readString(), UserApiModel.Policy.CREATOR.createFromParcel(obj));
                i3++;
            }
            if (parcel.readInt() == 0) {
                fromParcel2 = 0;
            } else {
                fromParcel2 = TrainingReminderModel.CREATOR.createFromParcel(obj);
            }
            ArrayList arrayList = new ArrayList(parcel.readInt());
            while (i2 != int) {
                arrayList.add(PottyReminderModel.CREATOR.createFromParcel(obj));
                i2++;
                int = i5;
            }
            super(parcel.readString(), linkedHashMap, linkedHashMap2, parcel.readLong(), fromParcel3, linkedHashMap3, (UserApiModel.Challenges)UserApiModel.Challenges.CREATOR.createFromParcel(obj), parcel.readString(), parcel.readInt(), parcel.readLong(), obj13, parcel.createStringArrayList(), (TrainingReminderModel)fromParcel2, arrayList);
            return userApiModel;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.UserApiModel[] newArray(int i) {
            return new UserApiModel[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008 \n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0015\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0098\u0001\u0010/\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0014\u0008\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001¢\u0006\u0002\u00100J\t\u00101\u001a\u000202HÖ\u0001J\u0013\u00103\u001a\u00020\n2\u0008\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u000202HÖ\u0001J\u000e\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\u000eJ\t\u00109\u001a\u00020\u0003HÖ\u0001J\u0019\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u000202HÖ\u0001R\u0013\u0010\u000c\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\u0008\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0014R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0014R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u0014¨\u0006?", d2 = {"Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;", "Landroid/os/Parcelable;", "id", "", "creatorId", "name", "breedId", "customBreed", "birthday", "birthdayExact", "", "gender", "avatarUrl", "createdTimeMs", "", "entitlements", "", "Lapp/dogo/externalmodel/model/responses/UserApiModel$Entitlement;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)V", "getAvatarUrl", "()Ljava/lang/String;", "getBirthday", "getBirthdayExact", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBreedId", "getCreatedTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCreatorId", "getCustomBreed", "getEntitlements", "()Ljava/util/Map;", "getGender", "getId", "getName", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;", "describeContents", "", "equals", "other", "", "hashCode", "isPremium", "currentTimeMs", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DogApiModel implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel> CREATOR;
        private final String avatarUrl;
        private final String birthday;
        private final Boolean birthdayExact;
        private final String breedId;
        private final Long createdTimeMs;
        private final String creatorId;
        private final String customBreed;
        private final Map<String, app.dogo.externalmodel.model.responses.UserApiModel.Entitlement> entitlements;
        private final String gender;
        private final String id;
        private final String name;
        static {
            UserApiModel.DogApiModel.Creator creator = new UserApiModel.DogApiModel.Creator();
            UserApiModel.DogApiModel.CREATOR = creator;
        }

        public DogApiModel(String string, String string2, String string3, String string4, String string5, String string6, Boolean boolean7, String string8, String string9, Long long10, Map<String, app.dogo.externalmodel.model.responses.UserApiModel.Entitlement> map11) {
            n.f(string, "id");
            n.f(string2, "creatorId");
            n.f(map11, "entitlements");
            super();
            this.id = string;
            this.creatorId = string2;
            this.name = string3;
            this.breedId = string4;
            this.customBreed = string5;
            this.birthday = string6;
            this.birthdayExact = boolean7;
            this.gender = string8;
            this.avatarUrl = string9;
            this.createdTimeMs = long10;
            this.entitlements = map11;
        }

        public DogApiModel(String string, String string2, String string3, String string4, String string5, String string6, Boolean boolean7, String string8, String string9, Long long10, Map map11, int i12, g g13) {
            int i2;
            int i;
            int i6;
            int i3;
            int i8;
            int i5;
            int i7;
            int i4;
            int i9 = i12;
            final int i19 = 0;
            i2 = i9 & 4 != 0 ? i19 : string3;
            i = i9 & 8 != 0 ? i19 : string4;
            i6 = i9 & 16 != 0 ? i19 : string5;
            i3 = i9 & 32 != 0 ? i19 : string6;
            i8 = i9 & 64 != 0 ? i19 : boolean7;
            i5 = i9 & 128 != 0 ? i19 : string8;
            i7 = i9 & 256 != 0 ? i19 : string9;
            i4 = i9 &= 512 != 0 ? i19 : long10;
            super(string, string2, i2, i, i6, i3, i8, i5, i7, i4, map11);
        }

        public static app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel copy$default(app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel userApiModel$DogApiModel, String string2, String string3, String string4, String string5, String string6, String string7, Boolean boolean8, String string9, String string10, Long long11, Map map12, int i13, Object object14) {
            Map entitlements;
            String str;
            String creatorId;
            String name;
            String breedId;
            String customBreed;
            String birthday;
            Boolean birthdayExact;
            String gender;
            String avatarUrl;
            Long createdTimeMs;
            Object obj = dogApiModel;
            int i = i13;
            str = i & 1 != 0 ? obj.id : string2;
            creatorId = i & 2 != 0 ? obj.creatorId : string3;
            name = i & 4 != 0 ? obj.name : string4;
            breedId = i & 8 != 0 ? obj.breedId : string5;
            customBreed = i & 16 != 0 ? obj.customBreed : string6;
            birthday = i & 32 != 0 ? obj.birthday : string7;
            birthdayExact = i & 64 != 0 ? obj.birthdayExact : boolean8;
            gender = i & 128 != 0 ? obj.gender : string9;
            avatarUrl = i & 256 != 0 ? obj.avatarUrl : string10;
            createdTimeMs = i & 512 != 0 ? obj.createdTimeMs : long11;
            entitlements = i &= 1024 != 0 ? obj.entitlements : map12;
            return dogApiModel.copy(str, creatorId, name, breedId, customBreed, birthday, birthdayExact, gender, avatarUrl, createdTimeMs, entitlements);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final Long component10() {
            return this.createdTimeMs;
        }

        public final Map<String, app.dogo.externalmodel.model.responses.UserApiModel.Entitlement> component11() {
            return this.entitlements;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.creatorId;
        }

        @Override // android.os.Parcelable
        public final String component3() {
            return this.name;
        }

        @Override // android.os.Parcelable
        public final String component4() {
            return this.breedId;
        }

        @Override // android.os.Parcelable
        public final String component5() {
            return this.customBreed;
        }

        @Override // android.os.Parcelable
        public final String component6() {
            return this.birthday;
        }

        @Override // android.os.Parcelable
        public final Boolean component7() {
            return this.birthdayExact;
        }

        @Override // android.os.Parcelable
        public final String component8() {
            return this.gender;
        }

        @Override // android.os.Parcelable
        public final String component9() {
            return this.avatarUrl;
        }

        public final app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel copy(String string, String string2, String string3, String string4, String string5, String string6, Boolean boolean7, String string8, String string9, Long long10, Map<String, app.dogo.externalmodel.model.responses.UserApiModel.Entitlement> map11) {
            n.f(string, "id");
            n.f(string2, "creatorId");
            final Object obj = map11;
            n.f(obj, "entitlements");
            super(string, string2, string3, string4, string5, string6, boolean7, string8, string9, long10, obj);
            return dogApiModel;
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
            if (!object instanceof UserApiModel.DogApiModel) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (!n.b(this.creatorId, object.creatorId)) {
                return i2;
            }
            if (!n.b(this.name, object.name)) {
                return i2;
            }
            if (!n.b(this.breedId, object.breedId)) {
                return i2;
            }
            if (!n.b(this.customBreed, object.customBreed)) {
                return i2;
            }
            if (!n.b(this.birthday, object.birthday)) {
                return i2;
            }
            if (!n.b(this.birthdayExact, object.birthdayExact)) {
                return i2;
            }
            if (!n.b(this.gender, object.gender)) {
                return i2;
            }
            if (!n.b(this.avatarUrl, object.avatarUrl)) {
                return i2;
            }
            if (!n.b(this.createdTimeMs, object.createdTimeMs)) {
                return i2;
            }
            if (!n.b(this.entitlements, object.entitlements)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getAvatarUrl() {
            return this.avatarUrl;
        }

        @Override // android.os.Parcelable
        public final String getBirthday() {
            return this.birthday;
        }

        @Override // android.os.Parcelable
        public final Boolean getBirthdayExact() {
            return this.birthdayExact;
        }

        @Override // android.os.Parcelable
        public final String getBreedId() {
            return this.breedId;
        }

        @Override // android.os.Parcelable
        public final Long getCreatedTimeMs() {
            return this.createdTimeMs;
        }

        @Override // android.os.Parcelable
        public final String getCreatorId() {
            return this.creatorId;
        }

        @Override // android.os.Parcelable
        public final String getCustomBreed() {
            return this.customBreed;
        }

        public final Map<String, app.dogo.externalmodel.model.responses.UserApiModel.Entitlement> getEntitlements() {
            return this.entitlements;
        }

        @Override // android.os.Parcelable
        public final String getGender() {
            return this.gender;
        }

        @Override // android.os.Parcelable
        public final String getId() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final String getName() {
            return this.name;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            int i2;
            int i4;
            int i3;
            int i;
            int i8;
            int i5;
            int i7;
            int i6;
            String name = this.name;
            i6 = 0;
            if (name == null) {
                i2 = i6;
            } else {
                i2 = name.hashCode();
            }
            String breedId = this.breedId;
            if (breedId == null) {
                i4 = i6;
            } else {
                i4 = breedId.hashCode();
            }
            String customBreed = this.customBreed;
            if (customBreed == null) {
                i3 = i6;
            } else {
                i3 = customBreed.hashCode();
            }
            String birthday = this.birthday;
            if (birthday == null) {
                i = i6;
            } else {
                i = birthday.hashCode();
            }
            Boolean birthdayExact = this.birthdayExact;
            if (birthdayExact == null) {
                i8 = i6;
            } else {
                i8 = birthdayExact.hashCode();
            }
            String gender = this.gender;
            if (gender == null) {
                i5 = i6;
            } else {
                i5 = gender.hashCode();
            }
            String avatarUrl = this.avatarUrl;
            if (avatarUrl == null) {
                i7 = i6;
            } else {
                i7 = avatarUrl.hashCode();
            }
            Long createdTimeMs = this.createdTimeMs;
            if (createdTimeMs == null) {
            } else {
                i6 = createdTimeMs.hashCode();
            }
            return i28 += i31;
        }

        @Override // android.os.Parcelable
        public final boolean isPremium(long l) {
            int obj3;
            Object obj = this.entitlements.get("premium_dog");
            if ((UserApiModel.Entitlement)obj == null) {
                obj3 = 0;
            } else {
                obj3 = (UserApiModel.Entitlement)obj.isEntitlementActive(l);
            }
            return obj3;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DogApiModel(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", creatorId=");
            stringBuilder.append(this.creatorId);
            stringBuilder.append(", name=");
            stringBuilder.append(this.name);
            stringBuilder.append(", breedId=");
            stringBuilder.append(this.breedId);
            stringBuilder.append(", customBreed=");
            stringBuilder.append(this.customBreed);
            stringBuilder.append(", birthday=");
            stringBuilder.append(this.birthday);
            stringBuilder.append(", birthdayExact=");
            stringBuilder.append(this.birthdayExact);
            stringBuilder.append(", gender=");
            stringBuilder.append(this.gender);
            stringBuilder.append(", avatarUrl=");
            stringBuilder.append(this.avatarUrl);
            stringBuilder.append(", createdTimeMs=");
            stringBuilder.append(this.createdTimeMs);
            stringBuilder.append(", entitlements=");
            stringBuilder.append(this.entitlements);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            boolean birthdayExact;
            long createdTimeMs;
            int value;
            int key;
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeString(this.creatorId);
            parcel.writeString(this.name);
            parcel.writeString(this.breedId);
            parcel.writeString(this.customBreed);
            parcel.writeString(this.birthday);
            birthdayExact = this.birthdayExact;
            int i = 0;
            key = 1;
            if (birthdayExact == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(key);
                parcel.writeInt(birthdayExact.booleanValue());
            }
            parcel.writeString(this.gender);
            parcel.writeString(this.avatarUrl);
            createdTimeMs = this.createdTimeMs;
            if (createdTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(key);
                parcel.writeLong(createdTimeMs.longValue());
            }
            Map entitlements = this.entitlements;
            parcel.writeInt(entitlements.size());
            Iterator iterator = entitlements.entrySet().iterator();
            for (Map.Entry next2 : iterator) {
                parcel.writeString((String)next2.getKey());
                (UserApiModel.Entitlement)next2.getValue().writeToParcel(parcel, i2);
            }
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000e\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B!\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J0\u0010\u0011\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\t¨\u0006\"", d2 = {"Lapp/dogo/externalmodel/model/responses/UserApiModel$Entitlement;", "Landroid/os/Parcelable;", "expirationTimeMs", "", "expirationDate", "", "id", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getExpirationDate", "()Ljava/lang/String;", "getExpirationTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getId", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lapp/dogo/externalmodel/model/responses/UserApiModel$Entitlement;", "describeContents", "", "equals", "", "other", "", "hashCode", "isEntitlementActive", "currentTimeMs", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Entitlement implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.UserApiModel.Entitlement> CREATOR;
        private final String expirationDate;
        private final Long expirationTimeMs;
        private final String id;
        static {
            UserApiModel.Entitlement.Creator creator = new UserApiModel.Entitlement.Creator();
            UserApiModel.Entitlement.CREATOR = creator;
        }

        public Entitlement(Long long, String string2, String string3) {
            n.f(string3, "id");
            super();
            this.expirationTimeMs = long;
            this.expirationDate = string2;
            this.id = string3;
        }

        public static app.dogo.externalmodel.model.responses.UserApiModel.Entitlement copy$default(app.dogo.externalmodel.model.responses.UserApiModel.Entitlement userApiModel$Entitlement, Long long2, String string3, String string4, int i5, Object object6) {
            Long obj1;
            String obj2;
            String obj3;
            if (i5 & 1 != 0) {
                obj1 = entitlement.expirationTimeMs;
            }
            if (i5 & 2 != 0) {
                obj2 = entitlement.expirationDate;
            }
            if (i5 &= 4 != 0) {
                obj3 = entitlement.id;
            }
            return entitlement.copy(obj1, obj2, obj3);
        }

        @Override // android.os.Parcelable
        public final Long component1() {
            return this.expirationTimeMs;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.expirationDate;
        }

        @Override // android.os.Parcelable
        public final String component3() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.UserApiModel.Entitlement copy(Long long, String string2, String string3) {
            n.f(string3, "id");
            UserApiModel.Entitlement entitlement = new UserApiModel.Entitlement(long, string2, string3);
            return entitlement;
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
            if (!object instanceof UserApiModel.Entitlement) {
                return i2;
            }
            if (!n.b(this.expirationTimeMs, object.expirationTimeMs)) {
                return i2;
            }
            if (!n.b(this.expirationDate, object.expirationDate)) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getExpirationDate() {
            return this.expirationDate;
        }

        @Override // android.os.Parcelable
        public final Long getExpirationTimeMs() {
            return this.expirationTimeMs;
        }

        @Override // android.os.Parcelable
        public final String getId() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            int i;
            int i2;
            Long expirationTimeMs = this.expirationTimeMs;
            if (expirationTimeMs == null) {
                i = i2;
            } else {
                i = expirationTimeMs.hashCode();
            }
            final String expirationDate = this.expirationDate;
            if (expirationDate == null) {
            } else {
                i2 = expirationDate.hashCode();
            }
            return i5 += i7;
        }

        @Override // android.os.Parcelable
        public final boolean isEntitlementActive(long l) {
            long expirationTimeMs;
            int obj3;
            expirationTimeMs = this.expirationTimeMs;
            if (expirationTimeMs != null) {
                if (Long.compare(expirationTimeMs, l) > 0) {
                    obj3 = 1;
                } else {
                    obj3 = 0;
                }
            } else {
            }
            return obj3;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Entitlement(expirationTimeMs=");
            stringBuilder.append(this.expirationTimeMs);
            stringBuilder.append(", expirationDate=");
            stringBuilder.append(this.expirationDate);
            stringBuilder.append(", id=");
            stringBuilder.append(this.id);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            long longValue;
            int obj4;
            n.f(parcel, "out");
            obj4 = this.expirationTimeMs;
            if (obj4 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(obj4.longValue());
            }
            parcel.writeString(this.expirationDate);
            parcel.writeString(this.id);
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u001f", d2 = {"Lapp/dogo/externalmodel/model/responses/UserApiModel$Policy;", "Landroid/os/Parcelable;", "id", "", "status", "consentedTimeMs", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getConsentedTimeMs", "()J", "getId", "()Ljava/lang/String;", "getStatus", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Policy implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.UserApiModel.Policy> CREATOR = null;
        public static final app.dogo.externalmodel.model.responses.UserApiModel.Policy.Companion Companion = null;
        public static final String POLICY_ACCEPTED = "accepted";
        public static final String POLICY_SEEN = "seen";
        private final long consentedTimeMs;
        private final String id;
        private final String status;
        static {
            UserApiModel.Policy.Companion companion = new UserApiModel.Policy.Companion(0);
            UserApiModel.Policy.Companion = companion;
            UserApiModel.Policy.Creator creator = new UserApiModel.Policy.Creator();
            UserApiModel.Policy.CREATOR = creator;
        }

        public Policy(String string, String string2, long l3) {
            n.f(string, "id");
            n.f(string2, "status");
            super();
            this.id = string;
            this.status = string2;
            this.consentedTimeMs = l3;
        }

        public static app.dogo.externalmodel.model.responses.UserApiModel.Policy copy$default(app.dogo.externalmodel.model.responses.UserApiModel.Policy userApiModel$Policy, String string2, String string3, long l4, int i5, Object object6) {
            String obj1;
            String obj2;
            long obj3;
            if (object6 & 1 != 0) {
                obj1 = policy.id;
            }
            if (object6 & 2 != 0) {
                obj2 = policy.status;
            }
            if (object6 &= 4 != 0) {
                obj3 = policy.consentedTimeMs;
            }
            return policy.copy(obj1, obj2, obj3);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.status;
        }

        @Override // android.os.Parcelable
        public final long component3() {
            return this.consentedTimeMs;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.UserApiModel.Policy copy(String string, String string2, long l3) {
            n.f(string, "id");
            n.f(string2, "status");
            UserApiModel.Policy policy = new UserApiModel.Policy(string, string2, l3, obj5);
            return policy;
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
            if (!object instanceof UserApiModel.Policy) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (!n.b(this.status, object.status)) {
                return i2;
            }
            if (Long.compare(consentedTimeMs, consentedTimeMs2) != 0) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final long getConsentedTimeMs() {
            return this.consentedTimeMs;
        }

        @Override // android.os.Parcelable
        public final String getId() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final String getStatus() {
            return this.status;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i4 += i7;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Policy(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", status=");
            stringBuilder.append(this.status);
            stringBuilder.append(", consentedTimeMs=");
            stringBuilder.append(this.consentedTimeMs);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeString(this.status);
            parcel.writeLong(this.consentedTimeMs);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0015\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BM\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0017\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000b¨\u0006%", d2 = {"Lapp/dogo/externalmodel/model/responses/UserApiModel$PublicApiDogModel;", "Landroid/os/Parcelable;", "id", "", "name", "breedId", "customBreed", "gender", "avatarUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "getBreedId", "getCustomBreed", "getGender", "getId", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PublicApiDogModel implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.UserApiModel.PublicApiDogModel> CREATOR;
        private final String avatarUrl;
        private final String breedId;
        private final String customBreed;
        private final String gender;
        private final String id;
        private final String name;
        static {
            UserApiModel.PublicApiDogModel.Creator creator = new UserApiModel.PublicApiDogModel.Creator();
            UserApiModel.PublicApiDogModel.CREATOR = creator;
        }

        public PublicApiDogModel() {
            super(0, 0, 0, 0, 0, 0, 63, 0);
        }

        public PublicApiDogModel(String string, String string2, String string3, String string4, String string5, String string6) {
            super();
            this.id = string;
            this.name = string2;
            this.breedId = string3;
            this.customBreed = string4;
            this.gender = string5;
            this.avatarUrl = string6;
        }

        public PublicApiDogModel(String string, String string2, String string3, String string4, String string5, String string6, int i7, g g8) {
            int i3;
            int i4;
            int i;
            int i2;
            int obj12;
            int obj13;
            final int i5 = 0;
            obj13 = i7 & 1 != 0 ? i5 : string;
            i3 = i7 & 2 != 0 ? i5 : string2;
            i4 = i7 & 4 != 0 ? i5 : string3;
            i = i7 & 8 != 0 ? i5 : string4;
            i2 = i7 & 16 != 0 ? i5 : string5;
            obj12 = i7 & 32 != 0 ? i5 : string6;
            super(obj13, i3, i4, i, i2, obj12);
        }

        public static app.dogo.externalmodel.model.responses.UserApiModel.PublicApiDogModel copy$default(app.dogo.externalmodel.model.responses.UserApiModel.PublicApiDogModel userApiModel$PublicApiDogModel, String string2, String string3, String string4, String string5, String string6, String string7, int i8, Object object9) {
            String obj5;
            String obj6;
            String obj7;
            String obj8;
            String obj9;
            String obj10;
            if (i8 & 1 != 0) {
                obj5 = publicApiDogModel.id;
            }
            if (i8 & 2 != 0) {
                obj6 = publicApiDogModel.name;
            }
            if (i8 & 4 != 0) {
                obj7 = publicApiDogModel.breedId;
            }
            if (i8 & 8 != 0) {
                obj8 = publicApiDogModel.customBreed;
            }
            if (i8 & 16 != 0) {
                obj9 = publicApiDogModel.gender;
            }
            if (i8 & 32 != 0) {
                obj10 = publicApiDogModel.avatarUrl;
            }
            return publicApiDogModel.copy(obj5, obj6, obj7, obj8, obj9, obj10);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.name;
        }

        @Override // android.os.Parcelable
        public final String component3() {
            return this.breedId;
        }

        @Override // android.os.Parcelable
        public final String component4() {
            return this.customBreed;
        }

        @Override // android.os.Parcelable
        public final String component5() {
            return this.gender;
        }

        @Override // android.os.Parcelable
        public final String component6() {
            return this.avatarUrl;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.UserApiModel.PublicApiDogModel copy(String string, String string2, String string3, String string4, String string5, String string6) {
            super(string, string2, string3, string4, string5, string6);
            return publicApiDogModel2;
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
            if (!object instanceof UserApiModel.PublicApiDogModel) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (!n.b(this.name, object.name)) {
                return i2;
            }
            if (!n.b(this.breedId, object.breedId)) {
                return i2;
            }
            if (!n.b(this.customBreed, object.customBreed)) {
                return i2;
            }
            if (!n.b(this.gender, object.gender)) {
                return i2;
            }
            if (!n.b(this.avatarUrl, object.avatarUrl)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getAvatarUrl() {
            return this.avatarUrl;
        }

        @Override // android.os.Parcelable
        public final String getBreedId() {
            return this.breedId;
        }

        @Override // android.os.Parcelable
        public final String getCustomBreed() {
            return this.customBreed;
        }

        @Override // android.os.Parcelable
        public final String getGender() {
            return this.gender;
        }

        @Override // android.os.Parcelable
        public final String getId() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final String getName() {
            return this.name;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            int i6;
            int i4;
            int i3;
            int i;
            int i2;
            int i5;
            String str = this.id;
            i4 = 0;
            if (str == null) {
                i6 = i4;
            } else {
                i6 = str.hashCode();
            }
            String name = this.name;
            if (name == null) {
                i3 = i4;
            } else {
                i3 = name.hashCode();
            }
            String breedId = this.breedId;
            if (breedId == null) {
                i = i4;
            } else {
                i = breedId.hashCode();
            }
            String customBreed = this.customBreed;
            if (customBreed == null) {
                i2 = i4;
            } else {
                i2 = customBreed.hashCode();
            }
            String gender = this.gender;
            if (gender == null) {
                i5 = i4;
            } else {
                i5 = gender.hashCode();
            }
            String avatarUrl = this.avatarUrl;
            if (avatarUrl == null) {
            } else {
                i4 = avatarUrl.hashCode();
            }
            return i15 += i4;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PublicApiDogModel(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", name=");
            stringBuilder.append(this.name);
            stringBuilder.append(", breedId=");
            stringBuilder.append(this.breedId);
            stringBuilder.append(", customBreed=");
            stringBuilder.append(this.customBreed);
            stringBuilder.append(", gender=");
            stringBuilder.append(this.gender);
            stringBuilder.append(", avatarUrl=");
            stringBuilder.append(this.avatarUrl);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeString(this.name);
            parcel.writeString(this.breedId);
            parcel.writeString(this.customBreed);
            parcel.writeString(this.gender);
            parcel.writeString(this.avatarUrl);
        }
    }
    static {
        UserApiModel.Companion companion = new UserApiModel.Companion(0);
        UserApiModel.Companion = companion;
        UserApiModel.Creator creator = new UserApiModel.Creator();
        UserApiModel.CREATOR = creator;
    }

    public UserApiModel(String string, Map<String, app.dogo.externalmodel.model.responses.UserApiModel.Entitlement> map2, Map<String, app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel> map3, long l4, Map<String, app.dogo.externalmodel.model.responses.UserApiModel.Policy> map5, app.dogo.externalmodel.model.responses.UserApiModel.Challenges userApiModel$Challenges6, String string7, int i8, long l9, List<String> list10, TrainingReminderModel trainingReminderModel11, List<PottyReminderModel> list12) {
        n.f(string, "id");
        n.f(map2, "entitlements");
        n.f(map3, "dogs");
        n.f(challenges6, "policies");
        n.f(string7, "challenges");
        n.f(i8, "firstAppOpenVersion");
        n.f(obj15, "pottyReminders");
        super();
        this.id = string;
        this.entitlements = map2;
        this.dogs = map3;
        this.abTestBucket = l4;
        this.policies = challenges6;
        this.challenges = string7;
        this.firstAppOpenVersion = i8;
        this.firstAppOpenBuild = l9;
        this.firstAppOpenTimeMs = list10;
        this.reminderIds = list12;
        this.trainingReminder = obj14;
        this.pottyReminders = obj15;
    }

    public UserApiModel(String string, Map map2, Map map3, long l4, Map map5, app.dogo.externalmodel.model.responses.UserApiModel.Challenges userApiModel$Challenges6, String string7, int i8, long l9, List list10, TrainingReminderModel trainingReminderModel11, List list12, int i13, g g14) {
        int i4;
        int i;
        int i3;
        Map map;
        String str;
        int challenges2;
        int i5;
        String str2;
        Map map4;
        Map map6;
        int i2;
        app.dogo.externalmodel.model.responses.UserApiModel.Challenges challenges;
        int i6;
        int i7;
        int i9;
        int i10 = obj33;
        str2 = i10 & 1 != 0 ? str : string;
        if (i10 & 2 != 0) {
            map4 = i;
        } else {
            map4 = map2;
        }
        if (i10 & 4 != 0) {
            map6 = i3;
        } else {
            map6 = map3;
        }
        int i19 = 0;
        i2 = i10 & 8 != 0 ? i19 : l4;
        if (i10 & 16 != 0) {
            map = j0.h();
        } else {
            map = challenges6;
        }
        int i21 = 0;
        if (i10 & 32 != 0) {
            challenges2 = new UserApiModel.Challenges(i21, 1, i21);
            challenges = challenges2;
        } else {
            challenges = string7;
        }
        if (i10 & 64 != 0) {
        } else {
            str = i8;
        }
        i6 = i10 & 128 != 0 ? i5 : l9;
        i7 = i10 & 256 != 0 ? i19 : list10;
        i9 = i10 & 512 != 0 ? i21 : list12;
        i4 = i10 &= 1024 != 0 ? i21 : i13;
        super(str2, map4, map6, i2, obj8, map, challenges, str, i6, i7, i7, i9, i4, g14);
    }

    public static app.dogo.externalmodel.model.responses.UserApiModel copy$default(app.dogo.externalmodel.model.responses.UserApiModel userApiModel, String string2, Map map3, Map map4, long l5, Map map6, app.dogo.externalmodel.model.responses.UserApiModel.Challenges userApiModel$Challenges7, String string8, int i9, long l10, List list11, TrainingReminderModel trainingReminderModel12, List list13, int i14, Object object15) {
        List pottyReminders;
        String str;
        Map entitlements;
        Map dogs;
        long abTestBucket;
        Map policies;
        app.dogo.externalmodel.model.responses.UserApiModel.Challenges challenges;
        String firstAppOpenVersion;
        int firstAppOpenBuild;
        long firstAppOpenTimeMs;
        List reminderIds;
        TrainingReminderModel trainingReminder;
        Object obj = userApiModel;
        int i = obj30;
        str = i & 1 != 0 ? obj.id : string2;
        entitlements = i & 2 != 0 ? obj.entitlements : map3;
        dogs = i & 4 != 0 ? obj.dogs : map4;
        abTestBucket = i & 8 != 0 ? obj.abTestBucket : l5;
        policies = i & 16 != 0 ? obj.policies : challenges7;
        challenges = i & 32 != 0 ? obj.challenges : string8;
        firstAppOpenVersion = i & 64 != 0 ? obj.firstAppOpenVersion : i9;
        firstAppOpenBuild = i & 128 != 0 ? obj.firstAppOpenBuild : l10;
        firstAppOpenTimeMs = i & 256 != 0 ? obj.firstAppOpenTimeMs : list11;
        reminderIds = i & 512 != 0 ? obj.reminderIds : list13;
        trainingReminder = i & 1024 != 0 ? obj.trainingReminder : i14;
        pottyReminders = i &= 2048 != 0 ? obj.pottyReminders : object15;
        return userApiModel.copy(str, entitlements, dogs, abTestBucket, map6, policies, challenges, firstAppOpenVersion, firstAppOpenBuild, firstAppOpenTimeMs, trainingReminderModel12, reminderIds);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.id;
    }

    public final List<String> component10() {
        return this.reminderIds;
    }

    @Override // android.os.Parcelable
    public final TrainingReminderModel component11() {
        return this.trainingReminder;
    }

    public final List<PottyReminderModel> component12() {
        return this.pottyReminders;
    }

    public final Map<String, app.dogo.externalmodel.model.responses.UserApiModel.Entitlement> component2() {
        return this.entitlements;
    }

    public final Map<String, app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel> component3() {
        return this.dogs;
    }

    @Override // android.os.Parcelable
    public final long component4() {
        return this.abTestBucket;
    }

    public final Map<String, app.dogo.externalmodel.model.responses.UserApiModel.Policy> component5() {
        return this.policies;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.UserApiModel.Challenges component6() {
        return this.challenges;
    }

    @Override // android.os.Parcelable
    public final String component7() {
        return this.firstAppOpenVersion;
    }

    @Override // android.os.Parcelable
    public final int component8() {
        return this.firstAppOpenBuild;
    }

    @Override // android.os.Parcelable
    public final long component9() {
        return this.firstAppOpenTimeMs;
    }

    public final app.dogo.externalmodel.model.responses.UserApiModel copy(String string, Map<String, app.dogo.externalmodel.model.responses.UserApiModel.Entitlement> map2, Map<String, app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel> map3, long l4, Map<String, app.dogo.externalmodel.model.responses.UserApiModel.Policy> map5, app.dogo.externalmodel.model.responses.UserApiModel.Challenges userApiModel$Challenges6, String string7, int i8, long l9, List<String> list10, TrainingReminderModel trainingReminderModel11, List<PottyReminderModel> list12) {
        final Object obj = string;
        n.f(obj, "id");
        final Object obj2 = map2;
        n.f(obj2, "entitlements");
        final Object obj3 = map3;
        n.f(obj3, "dogs");
        final Object obj4 = challenges6;
        n.f(obj4, "policies");
        final Object obj5 = string7;
        n.f(obj5, "challenges");
        final Object obj6 = i8;
        n.f(obj6, "firstAppOpenVersion");
        final Object obj8 = obj30;
        n.f(obj8, "pottyReminders");
        super(obj, obj2, obj3, l4, obj6, obj4, obj5, obj6, l9, list10, obj12, list12, obj29, obj8);
        return userApiModel;
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
        if (!object instanceof UserApiModel) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.entitlements, object.entitlements)) {
            return i2;
        }
        if (!n.b(this.dogs, object.dogs)) {
            return i2;
        }
        if (Long.compare(abTestBucket, abTestBucket2) != 0) {
            return i2;
        }
        if (!n.b(this.policies, object.policies)) {
            return i2;
        }
        if (!n.b(this.challenges, object.challenges)) {
            return i2;
        }
        if (!n.b(this.firstAppOpenVersion, object.firstAppOpenVersion)) {
            return i2;
        }
        if (this.firstAppOpenBuild != object.firstAppOpenBuild) {
            return i2;
        }
        if (Long.compare(firstAppOpenTimeMs, firstAppOpenTimeMs2) != 0) {
            return i2;
        }
        if (!n.b(this.reminderIds, object.reminderIds)) {
            return i2;
        }
        if (!n.b(this.trainingReminder, object.trainingReminder)) {
            return i2;
        }
        if (!n.b(this.pottyReminders, object.pottyReminders)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final long getAbTestBucket() {
        return this.abTestBucket;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.UserApiModel.Challenges getChallenges() {
        return this.challenges;
    }

    public final Map<String, app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel> getDogs() {
        return this.dogs;
    }

    public final Map<String, app.dogo.externalmodel.model.responses.UserApiModel.Entitlement> getEntitlements() {
        return this.entitlements;
    }

    @Override // android.os.Parcelable
    public final int getFirstAppOpenBuild() {
        return this.firstAppOpenBuild;
    }

    @Override // android.os.Parcelable
    public final long getFirstAppOpenTimeMs() {
        return this.firstAppOpenTimeMs;
    }

    @Override // android.os.Parcelable
    public final String getFirstAppOpenVersion() {
        return this.firstAppOpenVersion;
    }

    @Override // android.os.Parcelable
    public final String getId() {
        return this.id;
    }

    public final Map<String, app.dogo.externalmodel.model.responses.UserApiModel.Policy> getPolicies() {
        return this.policies;
    }

    public final List<PottyReminderModel> getPottyReminders() {
        return this.pottyReminders;
    }

    public final List<String> getReminderIds() {
        return this.reminderIds;
    }

    @Override // android.os.Parcelable
    public final TrainingReminderModel getTrainingReminder() {
        return this.trainingReminder;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        int i2;
        List reminderIds = this.reminderIds;
        if (reminderIds == null) {
            i = i2;
        } else {
            i = reminderIds.hashCode();
        }
        TrainingReminderModel trainingReminder = this.trainingReminder;
        if (trainingReminder == null) {
        } else {
            i2 = trainingReminder.hashCode();
        }
        return i24 += i34;
    }

    @Override // android.os.Parcelable
    public final boolean isPremium(long l) {
        int obj3;
        Object obj = this.entitlements.get("premium");
        if ((UserApiModel.Entitlement)obj == null) {
            obj3 = 0;
        } else {
            obj3 = (UserApiModel.Entitlement)obj.isEntitlementActive(l);
        }
        return obj3;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserApiModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", entitlements=");
        stringBuilder.append(this.entitlements);
        stringBuilder.append(", dogs=");
        stringBuilder.append(this.dogs);
        stringBuilder.append(", abTestBucket=");
        stringBuilder.append(this.abTestBucket);
        stringBuilder.append(", policies=");
        stringBuilder.append(this.policies);
        stringBuilder.append(", challenges=");
        stringBuilder.append(this.challenges);
        stringBuilder.append(", firstAppOpenVersion=");
        stringBuilder.append(this.firstAppOpenVersion);
        stringBuilder.append(", firstAppOpenBuild=");
        stringBuilder.append(this.firstAppOpenBuild);
        stringBuilder.append(", firstAppOpenTimeMs=");
        stringBuilder.append(this.firstAppOpenTimeMs);
        stringBuilder.append(", reminderIds=");
        stringBuilder.append(this.reminderIds);
        stringBuilder.append(", trainingReminder=");
        stringBuilder.append(this.trainingReminder);
        stringBuilder.append(", pottyReminders=");
        stringBuilder.append(this.pottyReminders);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        TrainingReminderModel trainingReminder;
        int value;
        int value2;
        int value3;
        int next;
        int size;
        Object key;
        n.f(parcel, "out");
        parcel.writeString(this.id);
        Map entitlements = this.entitlements;
        parcel.writeInt(entitlements.size());
        Iterator iterator = entitlements.entrySet().iterator();
        for (Map.Entry next7 : iterator) {
            parcel.writeString((String)next7.getKey());
            (UserApiModel.Entitlement)next7.getValue().writeToParcel(parcel, i2);
        }
        Map dogs = this.dogs;
        parcel.writeInt(dogs.size());
        Iterator iterator2 = dogs.entrySet().iterator();
        boolean next3 = iterator2.hasNext();
        for (Map.Entry next6 : iterator2) {
            parcel.writeString((String)next6.getKey());
            (UserApiModel.DogApiModel)next6.getValue().writeToParcel(parcel, i2);
            next3 = iterator2.hasNext();
        }
        parcel.writeLong(this.abTestBucket);
        Map policies = this.policies;
        parcel.writeInt(policies.size());
        Iterator iterator3 = policies.entrySet().iterator();
        next = iterator3.hasNext();
        for (Map.Entry next5 : iterator3) {
            parcel.writeString((String)next5.getKey());
            (UserApiModel.Policy)next5.getValue().writeToParcel(parcel, i2);
            next = iterator3.hasNext();
        }
        this.challenges.writeToParcel(parcel, i2);
        parcel.writeString(this.firstAppOpenVersion);
        parcel.writeInt(this.firstAppOpenBuild);
        parcel.writeLong(this.firstAppOpenTimeMs);
        parcel.writeStringList(this.reminderIds);
        trainingReminder = this.trainingReminder;
        if (trainingReminder == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            trainingReminder.writeToParcel(parcel, i2);
        }
        List pottyReminders = this.pottyReminders;
        parcel.writeInt(pottyReminders.size());
        Iterator iterator4 = pottyReminders.iterator();
        for (PottyReminderModel size : iterator4) {
            size.writeToParcel(parcel, i2);
        }
    }
}
