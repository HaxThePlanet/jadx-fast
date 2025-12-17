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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u0018B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u000cHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000cHÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0019", d2 = {"Lapp/dogo/externalmodel/model/requests/UserPolicyUpdateRequest;", "Landroid/os/Parcelable;", "policies", "", "", "Lapp/dogo/externalmodel/model/requests/UserPolicyUpdateRequest$UserPolicy;", "(Ljava/util/Map;)V", "getPolicies", "()Ljava/util/Map;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "UserPolicy", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UserPolicyUpdateRequest implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest> CREATOR;
    private final Map<String, app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest.UserPolicy> policies;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest createFromParcel(Parcel parcel) {
            int i;
            String string;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(int);
            i = 0;
            while (i != int) {
                linkedHashMap.put(parcel.readString(), UserPolicyUpdateRequest.UserPolicy.CREATOR.createFromParcel(parcel));
                i++;
            }
            UserPolicyUpdateRequest obj6 = new UserPolicyUpdateRequest(linkedHashMap);
            return obj6;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest[] newArray(int i) {
            return new UserPolicyUpdateRequest[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0019", d2 = {"Lapp/dogo/externalmodel/model/requests/UserPolicyUpdateRequest$UserPolicy;", "Landroid/os/Parcelable;", "policyId", "", "status", "(Ljava/lang/String;Ljava/lang/String;)V", "getPolicyId", "()Ljava/lang/String;", "getStatus", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UserPolicy implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest.UserPolicy> CREATOR;
        private final String policyId;
        private final String status;
        static {
            UserPolicyUpdateRequest.UserPolicy.Creator creator = new UserPolicyUpdateRequest.UserPolicy.Creator();
            UserPolicyUpdateRequest.UserPolicy.CREATOR = creator;
        }

        public UserPolicy(String string, String string2) {
            n.f(string, "policyId");
            n.f(string2, "status");
            super();
            this.policyId = string;
            this.status = string2;
        }

        public static app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest.UserPolicy copy$default(app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest.UserPolicy userPolicyUpdateRequest$UserPolicy, String string2, String string3, int i4, Object object5) {
            String obj1;
            String obj2;
            if (i4 & 1 != 0) {
                obj1 = userPolicy.policyId;
            }
            if (i4 &= 2 != 0) {
                obj2 = userPolicy.status;
            }
            return userPolicy.copy(obj1, obj2);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.policyId;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.status;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest.UserPolicy copy(String string, String string2) {
            n.f(string, "policyId");
            n.f(string2, "status");
            UserPolicyUpdateRequest.UserPolicy userPolicy = new UserPolicyUpdateRequest.UserPolicy(string, string2);
            return userPolicy;
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
            if (!object instanceof UserPolicyUpdateRequest.UserPolicy) {
                return i2;
            }
            if (!n.b(this.policyId, object.policyId)) {
                return i2;
            }
            if (!n.b(this.status, object.status)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getPolicyId() {
            return this.policyId;
        }

        @Override // android.os.Parcelable
        public final String getStatus() {
            return this.status;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i2 += i4;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("UserPolicy(policyId=");
            stringBuilder.append(this.policyId);
            stringBuilder.append(", status=");
            stringBuilder.append(this.status);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.policyId);
            parcel.writeString(this.status);
        }
    }
    static {
        UserPolicyUpdateRequest.Creator creator = new UserPolicyUpdateRequest.Creator();
        UserPolicyUpdateRequest.CREATOR = creator;
    }

    public UserPolicyUpdateRequest(Map<String, app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest.UserPolicy> map) {
        n.f(map, "policies");
        super();
        this.policies = map;
    }

    public static app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest copy$default(app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest userPolicyUpdateRequest, Map map2, int i3, Object object4) {
        Map obj1;
        if (i3 &= 1 != 0) {
            obj1 = userPolicyUpdateRequest.policies;
        }
        return userPolicyUpdateRequest.copy(obj1);
    }

    public final Map<String, app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest.UserPolicy> component1() {
        return this.policies;
    }

    public final app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest copy(Map<String, app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest.UserPolicy> map) {
        n.f(map, "policies");
        UserPolicyUpdateRequest userPolicyUpdateRequest = new UserPolicyUpdateRequest(map);
        return userPolicyUpdateRequest;
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
        if (object instanceof UserPolicyUpdateRequest == null) {
            return i2;
        }
        if (!n.b(this.policies, object.policies)) {
            return i2;
        }
        return i;
    }

    public final Map<String, app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest.UserPolicy> getPolicies() {
        return this.policies;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return this.policies.hashCode();
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserPolicyUpdateRequest(policies=");
        stringBuilder.append(this.policies);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int value;
        Object key;
        n.f(parcel, "out");
        Map policies = this.policies;
        parcel.writeInt(policies.size());
        Iterator iterator = policies.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            parcel.writeString((String)next2.getKey());
            (UserPolicyUpdateRequest.UserPolicy)next2.getValue().writeToParcel(parcel, i2);
        }
    }
}
