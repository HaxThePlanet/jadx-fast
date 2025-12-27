package app.dogo.externalmodel.model.requests;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: UserPolicyUpdateRequest.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u0018B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u000cHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000cHÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0019", d2 = {"Lapp/dogo/externalmodel/model/requests/UserPolicyUpdateRequest;", "Landroid/os/Parcelable;", "policies", "", "", "Lapp/dogo/externalmodel/model/requests/UserPolicyUpdateRequest$UserPolicy;", "(Ljava/util/Map;)V", "getPolicies", "()Ljava/util/Map;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "UserPolicy", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class UserPolicyUpdateRequest implements Parcelable {

    public static final Parcelable.Creator<UserPolicyUpdateRequest> CREATOR = new UserPolicyUpdateRequest$Creator<>();
    private final Map<String, UserPolicyUpdateRequest.UserPolicy> policies;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserPolicyUpdateRequest> {
        @Override // android.os.Parcelable$Creator
        public final UserPolicyUpdateRequest createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final LinkedHashMap linkedHashMap = new LinkedHashMap(_int);
            i = 0;
            while (i != _int) {
                linkedHashMap.put(parcel.readString(), UserPolicyUpdateRequest_UserPolicy.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new UserPolicyUpdateRequest(linkedHashMap);
        }

        @Override // android.os.Parcelable$Creator
        public final UserPolicyUpdateRequest[] newArray(int i) {
            return new UserPolicyUpdateRequest[i];
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0019", d2 = {"Lapp/dogo/externalmodel/model/requests/UserPolicyUpdateRequest$UserPolicy;", "Landroid/os/Parcelable;", "policyId", "", "status", "(Ljava/lang/String;Ljava/lang/String;)V", "getPolicyId", "()Ljava/lang/String;", "getStatus", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UserPolicy implements Parcelable {

        public static final Parcelable.Creator<UserPolicyUpdateRequest.UserPolicy> CREATOR = new UserPolicyUpdateRequest$UserPolicy$Creator<>();
        private final String policyId;
        private final String status;
        public UserPolicy(String str, String str2) {
            n.f(str, "policyId");
            n.f(str2, "status");
            super();
            this.policyId = str;
            this.status = str2;
        }

        public final String getPolicyId() {
            return this.policyId;
        }

        public final String getStatus() {
            return this.status;
        }


        public static /* synthetic */ UserPolicyUpdateRequest.UserPolicy copy$default(UserPolicyUpdateRequest.UserPolicy userPolicy, String str, String str2, int i, Object object) {
            String policyId2;
            String status2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            return userPolicy.copy(policyId2, status2);
        }

        /* operator */ public final String component1() {
            return this.policyId;
        }

        /* operator */ public final String component2() {
            return this.status;
        }

        public final UserPolicyUpdateRequest.UserPolicy copy(String policyId, String status) {
            n.f(policyId, "policyId");
            n.f(status, "status");
            return new UserPolicyUpdateRequest_UserPolicy(policyId, status);
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
            final boolean z4 = false;
            if (!(other instanceof UserPolicyUpdateRequest_UserPolicy)) {
                return false;
            }
            if (!n.b(this.policyId, other.policyId)) {
                return false;
            }
            return !n.b(this.status, other.status) ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.policyId.hashCode() * 31) + this.status.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "UserPolicy(policyId=";
            String str3 = ", status=";
            str = str2 + this.policyId + str3 + this.status + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.policyId);
            parcel.writeString(this.status);
        }
    }
    public UserPolicyUpdateRequest(Map<String, UserPolicyUpdateRequest.UserPolicy> map) {
        n.f(map, "policies");
        super();
        this.policies = map;
    }

    public final Map<String, UserPolicyUpdateRequest.UserPolicy> getPolicies() {
        return this.policies;
    }


    public static /* synthetic */ UserPolicyUpdateRequest copy$default(UserPolicyUpdateRequest userPolicyUpdateRequest, Map map, int i, Object object) {
        Map policies2;
        if (i & 1 != 0) {
        }
        return userPolicyUpdateRequest.copy(policies2);
    }

    /* operator */ public final Map<String, UserPolicyUpdateRequest.UserPolicy> component1() {
        return this.policies;
    }

    public final UserPolicyUpdateRequest copy(Map<String, UserPolicyUpdateRequest.UserPolicy> policies) {
        n.f(policies, "policies");
        return new UserPolicyUpdateRequest(policies);
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
        if (!(other instanceof UserPolicyUpdateRequest)) {
            return false;
        }
        return !n.b(this.policies, other.policies) ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.policies.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "UserPolicyUpdateRequest(policies=";
        str = str2 + this.policies + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.policies.size());
        Iterator it = this.policies.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            parcel.writeString((String)item.getKey());
            (UserPolicyUpdateRequest_UserPolicy)item.getValue().writeToParcel(parcel, flags);
        }
    }
}
