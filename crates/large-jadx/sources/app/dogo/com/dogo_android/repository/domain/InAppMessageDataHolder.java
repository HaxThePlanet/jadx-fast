package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "Landroid/os/Parcelable;", "title", "", "bodyText", "campaignId", "campaignName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBodyText", "()Ljava/lang/String;", "getCampaignId", "getCampaignName", "getTitle", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InAppMessageDataHolder implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder> CREATOR;
    private final String bodyText;
    private final String campaignId;
    private final String campaignName;
    private final String title;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            InAppMessageDataHolder inAppMessageDataHolder = new InAppMessageDataHolder(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            return inAppMessageDataHolder;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder[] newArray(int i) {
            return new InAppMessageDataHolder[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        InAppMessageDataHolder.Creator creator = new InAppMessageDataHolder.Creator();
        InAppMessageDataHolder.CREATOR = creator;
    }

    public InAppMessageDataHolder(String string, String string2, String string3, String string4) {
        n.f(string, "title");
        n.f(string2, "bodyText");
        n.f(string3, "campaignId");
        n.f(string4, "campaignName");
        super();
        this.title = string;
        this.bodyText = string2;
        this.campaignId = string3;
        this.campaignName = string4;
    }

    public static app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder copy$default(app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder inAppMessageDataHolder, String string2, String string3, String string4, String string5, int i6, Object object7) {
        String obj1;
        String obj2;
        String obj3;
        String obj4;
        if (i6 & 1 != 0) {
            obj1 = inAppMessageDataHolder.title;
        }
        if (i6 & 2 != 0) {
            obj2 = inAppMessageDataHolder.bodyText;
        }
        if (i6 & 4 != 0) {
            obj3 = inAppMessageDataHolder.campaignId;
        }
        if (i6 &= 8 != 0) {
            obj4 = inAppMessageDataHolder.campaignName;
        }
        return inAppMessageDataHolder.copy(obj1, obj2, obj3, obj4);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.bodyText;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.campaignId;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.campaignName;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder copy(String string, String string2, String string3, String string4) {
        n.f(string, "title");
        n.f(string2, "bodyText");
        n.f(string3, "campaignId");
        n.f(string4, "campaignName");
        InAppMessageDataHolder inAppMessageDataHolder = new InAppMessageDataHolder(string, string2, string3, string4);
        return inAppMessageDataHolder;
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
        if (!object instanceof InAppMessageDataHolder) {
            return i2;
        }
        if (!n.b(this.title, object.title)) {
            return i2;
        }
        if (!n.b(this.bodyText, object.bodyText)) {
            return i2;
        }
        if (!n.b(this.campaignId, object.campaignId)) {
            return i2;
        }
        if (!n.b(this.campaignName, object.campaignName)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getBodyText() {
        return this.bodyText;
    }

    @Override // android.os.Parcelable
    public final String getCampaignId() {
        return this.campaignId;
    }

    @Override // android.os.Parcelable
    public final String getCampaignName() {
        return this.campaignName;
    }

    @Override // android.os.Parcelable
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i6 += i10;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InAppMessageDataHolder(title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", bodyText=");
        stringBuilder.append(this.bodyText);
        stringBuilder.append(", campaignId=");
        stringBuilder.append(this.campaignId);
        stringBuilder.append(", campaignName=");
        stringBuilder.append(this.campaignName);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.bodyText);
        parcel.writeString(this.campaignId);
        parcel.writeString(this.campaignName);
    }
}
