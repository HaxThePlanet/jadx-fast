package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: InAppMessageDataHolder.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/InAppMessageDataHolder;", "Landroid/os/Parcelable;", "title", "", "bodyText", "campaignId", "campaignName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBodyText", "()Ljava/lang/String;", "getCampaignId", "getCampaignName", "getTitle", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class InAppMessageDataHolder implements Parcelable {

    public static final Parcelable.Creator<InAppMessageDataHolder> CREATOR = new InAppMessageDataHolder$Creator<>();
    private final String bodyText;
    private final String campaignId;
    private final String campaignName;
    private final String title;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<InAppMessageDataHolder> {
        @Override // android.os.Parcelable$Creator
        public final InAppMessageDataHolder createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new InAppMessageDataHolder(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable$Creator
        public final InAppMessageDataHolder[] newArray(int i) {
            return new InAppMessageDataHolder[i];
        }
    }
    public InAppMessageDataHolder(String str, String str2, String str3, String str4) {
        n.f(str, "title");
        n.f(str2, "bodyText");
        n.f(str3, "campaignId");
        n.f(str4, "campaignName");
        super();
        this.title = str;
        this.bodyText = str2;
        this.campaignId = str3;
        this.campaignName = str4;
    }

    public final String getBodyText() {
        return this.bodyText;
    }

    public final String getCampaignId() {
        return this.campaignId;
    }

    public final String getCampaignName() {
        return this.campaignName;
    }

    public final String getTitle() {
        return this.title;
    }


    public static /* synthetic */ InAppMessageDataHolder copy$default(InAppMessageDataHolder inAppMessageDataHolder, String str, String str2, String str3, String str4, int i, Object object) {
        String title2;
        String bodyText2;
        String campaignId2;
        String campaignName2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        return inAppMessageDataHolder.copy(title2, bodyText2, campaignId2, campaignName2);
    }

    /* operator */ public final String component1() {
        return this.title;
    }

    /* operator */ public final String component2() {
        return this.bodyText;
    }

    /* operator */ public final String component3() {
        return this.campaignId;
    }

    /* operator */ public final String component4() {
        return this.campaignName;
    }

    public final InAppMessageDataHolder copy(String title, String bodyText, String campaignId, String campaignName) {
        n.f(title, "title");
        n.f(bodyText, "bodyText");
        n.f(campaignId, "campaignId");
        n.f(campaignName, "campaignName");
        return new InAppMessageDataHolder(title, bodyText, campaignId, campaignName);
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
        final boolean z6 = false;
        if (!(other instanceof InAppMessageDataHolder)) {
            return false;
        }
        if (!n.b(this.title, other.title)) {
            return false;
        }
        if (!n.b(this.bodyText, other.bodyText)) {
            return false;
        }
        if (!n.b(this.campaignId, other.campaignId)) {
            return false;
        }
        return !n.b(this.campaignName, other.campaignName) ? z6 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.title.hashCode() * 31) + this.bodyText.hashCode() * 31 + this.campaignId.hashCode() * 31 + this.campaignName.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "InAppMessageDataHolder(title=";
        String str3 = ", bodyText=";
        String str4 = ", campaignId=";
        String str5 = ", campaignName=";
        str = str2 + this.title + str3 + this.bodyText + str4 + this.campaignId + str5 + this.campaignName + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.bodyText);
        parcel.writeString(this.campaignId);
        parcel.writeString(this.campaignName);
    }
}
