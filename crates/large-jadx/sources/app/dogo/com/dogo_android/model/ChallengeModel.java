package app.dogo.com.dogo_android.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.service.v2;
import com.google.firebase.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0010\"\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\n\u0018\u0000 h2\u00020\u0001:\u0003hijB\u0007\u0008\u0016¢\u0006\u0002\u0010\u0002B\u000f\u0008\u0014\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010J\u001a\u00020KH\u0016J\u000e\u0010L\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020\u000eJ\u000e\u0010N\u001a\u00020\u000e2\u0006\u0010O\u001a\u00020PJ\u000e\u0010Q\u001a\u00020\u00132\u0006\u0010R\u001a\u00020\u0013J\u0006\u0010S\u001a\u00020\u001bJ\u0006\u0010T\u001a\u00020\u001bJ\u000e\u0010U\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020PJ\u000e\u0010V\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020PJ\u0018\u0010W\u001a\u00020X2\u0010\u0010\n\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010YJ\u0010\u0010Z\u001a\u00020X2\u0008\u0010\u0014\u001a\u0004\u0018\u00010[J\u000e\u0010\\\u001a\u00020X2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010]\u001a\u00020X2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010YJ\u0016\u0010^\u001a\u00020X2\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010YJ \u0010_\u001a\u00020X2\u0018\u0010`\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010a\u0018\u00010\u0007J\u0010\u0010b\u001a\u00020X2\u0008\u0010H\u001a\u0004\u0018\u00010[J\u000e\u0010c\u001a\u00020\u001b2\u0006\u0010d\u001a\u00020KJ\u0018\u0010e\u001a\u00020X2\u0006\u0010f\u001a\u00020\u00042\u0006\u0010g\u001a\u00020KH\u0016R6\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0018\u0010\u0010\"\u0004\u0008\u0019\u0010\u0012R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001d\u0010\u0010\"\u0004\u0008\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010\u0010\"\u0004\u0008!\u0010\u0012R\u0011\u0010\"\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\u0008\"\u0010#R\u001a\u0010$\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008$\u0010#\"\u0004\u0008%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008(\u0010\u0010\"\u0004\u0008)\u0010\u0012R*\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u000e0*2\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u000e0*@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008/\u0010\u0010\"\u0004\u00080\u0010\u0012R\u0011\u00101\u001a\u0002028F¢\u0006\u0006\u001a\u0004\u00083\u00104R\u001c\u00105\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00086\u0010\u0010\"\u0004\u00087\u0010\u0012R*\u00108\u001a\u0008\u0012\u0004\u0012\u00020\u000e0*2\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u000e0*@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010-R\u0013\u0010:\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\u0008;\u0010\u0010R\"\u0010=\u001a\u0004\u0018\u00010<2\u0008\u0010\u0006\u001a\u0004\u0018\u00010<@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010?R\u0013\u0010@\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\u0008A\u0010\u0010R\u0013\u0010B\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\u0008C\u0010\u0010R\u0013\u0010D\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\u0008E\u0010\u0010R\u0013\u0010F\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\u0008G\u0010\u0010R\u001e\u0010H\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008I\u0010\u0016¨\u0006k", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeModel;", "Landroid/os/Parcelable;", "()V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/model/ChallengeFilterItem$FilterTypes;", "Lapp/dogo/com/dogo_android/model/ChallengeFilterItem;", "defaultFilters", "getDefaultFilters", "()Ljava/util/Map;", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "", "endDate", "getEndDate", "()J", "entryType", "getEntryType", "setEntryType", "hasEnded", "", "id", "getId", "setId", "imageUrl", "getImageUrl", "setImageUrl", "isChallengeCountryRestricted", "()Z", "isHasStarted", "setHasStarted", "(Z)V", "locale", "getLocale", "setLocale", "", "locations", "getLocations", "()Ljava/util/Set;", "medalImageUrl", "getMedalImageUrl", "setMedalImageUrl", "mediaType", "Lapp/dogo/com/dogo_android/model/ChallengeModel$MediaTypes;", "getMediaType", "()Lapp/dogo/com/dogo_android/model/ChallengeModel$MediaTypes;", "name", "getName", "setName", "participatingCountries", "getParticipatingCountries", "prizeRules", "getPrizeRules", "Lapp/dogo/com/dogo_android/model/ChallengeModel$SponsorModel;", "sponsor", "getSponsor", "()Lapp/dogo/com/dogo_android/model/ChallengeModel$SponsorModel;", "sponsorDetailsBannerImageUrl", "getSponsorDetailsBannerImageUrl", "sponsorFeedBannerImageUrl", "getSponsorFeedBannerImageUrl", "sponsorHeaderBannerImageUrl", "getSponsorHeaderBannerImageUrl", "sponsorWebsiteUrl", "getSponsorWebsiteUrl", "startDate", "getStartDate", "describeContents", "", "eligibleForPrize", "countryCode", "getTimeLeft", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "getTimeLeftInMillis", "currentTimeInMillis", "hasPrize", "hasSponsor", "isDateExpired", "isHasEnded", "setDefaultFilters", "", "", "setEndDate", "Lcom/google/firebase/Timestamp;", "setHasEnded", "setLocations", "setParticipatingCountries", "setSponsor", "sponsorMap", "", "setStartDate", "sponsorIndexCheck", "entryCount", "writeToParcel", "dest", "flags", "Companion", "MediaTypes", "SponsorModel", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ChallengeModel implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.model.ChallengeModel> CREATOR;
    public static final app.dogo.com.dogo_android.model.ChallengeModel.Companion Companion;
    private static List<? extends app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes> SUPPORTED_ENTRY_TYPES;
    private Map<app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes, app.dogo.com.dogo_android.model.ChallengeFilterItem> defaultFilters;
    private String description;
    private long endDate;
    private String entryType;
    private boolean hasEnded;
    public String id;
    public String imageUrl;
    private boolean isHasStarted;
    private String locale;
    private Set<String> locations;
    private String medalImageUrl;
    private String name;
    private Set<String> participatingCountries;
    private app.dogo.com.dogo_android.model.ChallengeModel.SponsorModel sponsor;
    private long startDate;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000c¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "SUPPORTED_ENTRY_TYPES", "", "Lapp/dogo/com/dogo_android/model/ChallengeModel$MediaTypes;", "getSUPPORTED_ENTRY_TYPES", "()Ljava/util/List;", "setSUPPORTED_ENTRY_TYPES", "(Ljava/util/List;)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final List<app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes> getSUPPORTED_ENTRY_TYPES() {
            return ChallengeModel.access$getSUPPORTED_ENTRY_TYPES$cp();
        }

        public final void setSUPPORTED_ENTRY_TYPES(List<? extends app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes> list) {
            n.f(list, "<set-?>");
            ChallengeModel.access$setSUPPORTED_ENTRY_TYPES$cp(list);
        }
    }

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0008\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0008J\u0008\u0010\t\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000f¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeModel$MediaTypes;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "hasHasPrize", "", "toString", "PHOTO", "PHOTODEBUG", "PHOTO_BARKBOX", "PHOTO_FRIENDLY_COLLAR", "SINGLE_ENTRY_NEVER_ENDING", "UNDEFINED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum MediaTypes {

        PHOTO("typePhoto"),
        PHOTODEBUG("typePhoto"),
        PHOTO_BARKBOX("typePhoto"),
        PHOTO_FRIENDLY_COLLAR("typePhoto"),
        SINGLE_ENTRY_NEVER_ENDING("typePhoto"),
        UNDEFINED("typePhoto");

        private final String type;
        private static final app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes[] $values() {
            app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes[] arr = new ChallengeModel.MediaTypes[6];
            return arr;
        }

        @Override // java.lang.Enum
        public final String getType() {
            return this.type;
        }

        @Override // java.lang.Enum
        public final boolean hasHasPrize() {
            int i;
            int i2;
            int i3;
            int i4 = ChallengeModel.MediaTypes.WhenMappings.$EnumSwitchMapping$0[ordinal()];
            i = 0;
            i2 = 1;
            if (i4 != i2 && i4 != 2) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        i2 = 4;
                    }
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.type;
        }
    }

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B!\u0008\u0016\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006B\u000f\u0008\u0014\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00082\u0006\u0010%\u001a\u00020!H\u0016R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0008\u0010\n\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0008\u0010\n\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\rR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0008\u0010\n\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\rR\"\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0008\u0010\n\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\rR\"\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0008\u0010\n\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\rR2\u0010\u001b\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u00192\u0010\u0010\n\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\"\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0008\u0010\n\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\r¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeModel$SponsorModel;", "Landroid/os/Parcelable;", "snapshot", "", "", "", "(Ljava/util/Map;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "<set-?>", "bannerImageUrl", "getBannerImageUrl", "()Ljava/lang/String;", "detailImageUrl", "getDetailImageUrl", "", "isEnabled", "()Z", "mainImageUrl", "getMainImageUrl", "prizeRules", "getPrizeRules", "title", "getTitle", "", "", "visibleBannerIndices", "getVisibleBannerIndices", "()Ljava/util/List;", "websiteUrl", "getWebsiteUrl", "describeContents", "", "writeToParcel", "", "dest", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SponsorModel implements Parcelable {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.model.ChallengeModel.SponsorModel> CREATOR;
        public static final app.dogo.com.dogo_android.model.ChallengeModel.SponsorModel.Companion Companion;
        private String bannerImageUrl;
        private String detailImageUrl;
        private boolean isEnabled;
        private String mainImageUrl;
        private String prizeRules;
        private String title;
        private List<Long> visibleBannerIndices;
        private String websiteUrl;
        static {
            ChallengeModel.SponsorModel.Companion companion = new ChallengeModel.SponsorModel.Companion(0);
            ChallengeModel.SponsorModel.Companion = companion;
            ChallengeModel.SponsorModel.Companion.CREATOR.1 anon = new ChallengeModel.SponsorModel.Companion.CREATOR.1();
            ChallengeModel.SponsorModel.CREATOR = anon;
        }

        protected SponsorModel(Parcel parcel) {
            int obj3;
            n.f(parcel, "in");
            super();
            ArrayList arrayList = new ArrayList();
            this.visibleBannerIndices = arrayList;
            this.bannerImageUrl = parcel.readString();
            this.detailImageUrl = parcel.readString();
            this.mainImageUrl = parcel.readString();
            this.prizeRules = parcel.readString();
            this.title = parcel.readString();
            this.websiteUrl = parcel.readString();
            List visibleBannerIndices = this.visibleBannerIndices;
            n.d(visibleBannerIndices);
            parcel.readList(visibleBannerIndices, 0);
            obj3 = parcel.readByte() != 0 ? 1 : 0;
            this.isEnabled = obj3;
        }

        public SponsorModel(Map<String, ? extends Object> map) {
            ArrayList arrayList;
            int obj2;
            super();
            arrayList = new ArrayList();
            this.visibleBannerIndices = arrayList;
            if (map != null && !map.isEmpty()) {
                if (!map.isEmpty()) {
                    this.bannerImageUrl = (String)map.get("bannerImageUrl");
                    this.detailImageUrl = (String)map.get("detailImageUrl");
                    this.mainImageUrl = (String)map.get("mainImageUrl");
                    this.prizeRules = (String)map.get("prizeRules");
                    this.title = (String)map.get("title");
                    this.websiteUrl = (String)map.get("websiteUrl");
                    this.visibleBannerIndices = (List)map.get("visibleBannerIndices");
                    this.isEnabled = true;
                }
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final String getBannerImageUrl() {
            return this.bannerImageUrl;
        }

        @Override // android.os.Parcelable
        public final String getDetailImageUrl() {
            return this.detailImageUrl;
        }

        @Override // android.os.Parcelable
        public final String getMainImageUrl() {
            return this.mainImageUrl;
        }

        @Override // android.os.Parcelable
        public final String getPrizeRules() {
            return this.prizeRules;
        }

        @Override // android.os.Parcelable
        public final String getTitle() {
            return this.title;
        }

        public final List<Long> getVisibleBannerIndices() {
            return this.visibleBannerIndices;
        }

        @Override // android.os.Parcelable
        public final String getWebsiteUrl() {
            return this.websiteUrl;
        }

        @Override // android.os.Parcelable
        public final boolean isEnabled() {
            return this.isEnabled;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "dest");
            parcel.writeString(this.bannerImageUrl);
            parcel.writeString(this.detailImageUrl);
            parcel.writeString(this.mainImageUrl);
            parcel.writeString(this.prizeRules);
            parcel.writeString(this.title);
            parcel.writeString(this.websiteUrl);
            parcel.writeList(this.visibleBannerIndices);
            parcel.writeByte((byte)obj2);
        }
    }
    static {
        ChallengeModel.Companion companion = new ChallengeModel.Companion(0);
        ChallengeModel.Companion = companion;
        app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes[] arr = new ChallengeModel.MediaTypes[2];
        ChallengeModel.SUPPORTED_ENTRY_TYPES = p.j(ChallengeModel.MediaTypes.PHOTO, ChallengeModel.MediaTypes.SINGLE_ENTRY_NEVER_ENDING);
        ChallengeModel.Companion.CREATOR.1 anon = new ChallengeModel.Companion.CREATOR.1();
        ChallengeModel.CREATOR = anon;
    }

    public ChallengeModel() {
        super();
        HashSet hashSet = new HashSet();
        this.locations = hashSet;
        HashSet hashSet2 = new HashSet();
        this.participatingCountries = hashSet2;
        EnumMap enumMap = new EnumMap(ChallengeFilterItem.FilterTypes.class);
        this.defaultFilters = enumMap;
        HashMap hashMap = new HashMap();
        ChallengeModel.SponsorModel sponsorModel = new ChallengeModel.SponsorModel(hashMap);
        this.sponsor = sponsorModel;
    }

    protected ChallengeModel(Parcel parcel) {
        int i;
        int i2;
        n.f(parcel, "in");
        super();
        HashSet hashSet = new HashSet();
        this.locations = hashSet;
        HashSet hashSet2 = new HashSet();
        this.participatingCountries = hashSet2;
        EnumMap enumMap = new EnumMap(ChallengeFilterItem.FilterTypes.class);
        this.defaultFilters = enumMap;
        HashMap hashMap = new HashMap();
        ChallengeModel.SponsorModel sponsorModel = new ChallengeModel.SponsorModel(hashMap);
        this.sponsor = sponsorModel;
        this.description = parcel.readString();
        this.endDate = parcel.readLong();
        this.entryType = parcel.readString();
        final int i3 = 0;
        i = parcel.readByte() != 0 ? i2 : i3;
        this.hasEnded = i;
        if (parcel.readByte() != 0) {
        } else {
            i2 = i3;
        }
        this.isHasStarted = i2;
        String string3 = parcel.readString();
        Objects.requireNonNull(string3);
        setId(string3);
        String string4 = parcel.readString();
        Objects.requireNonNull(string4);
        setImageUrl(string4);
        this.locale = parcel.readString();
        this.medalImageUrl = parcel.readString();
        this.name = parcel.readString();
        this.startDate = parcel.readLong();
        this.sponsor = (ChallengeModel.SponsorModel)parcel.readParcelable(ChallengeModel.SponsorModel.class.getClassLoader());
    }

    public static final List access$getSUPPORTED_ENTRY_TYPES$cp() {
        return ChallengeModel.SUPPORTED_ENTRY_TYPES;
    }

    public static final void access$setSUPPORTED_ENTRY_TYPES$cp(List list) {
        ChallengeModel.SUPPORTED_ENTRY_TYPES = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final boolean eligibleForPrize(String string) {
        Set locations;
        int obj3;
        n.f(string, "countryCode");
        if (!this.locations.contains("global")) {
            if (this.locations.contains(string)) {
                obj3 = 1;
            } else {
                obj3 = 0;
            }
        } else {
        }
        return obj3;
    }

    public final Map<app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes, app.dogo.com.dogo_android.model.ChallengeFilterItem> getDefaultFilters() {
        return this.defaultFilters;
    }

    @Override // android.os.Parcelable
    public final String getDescription() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public final long getEndDate() {
        return this.endDate;
    }

    @Override // android.os.Parcelable
    public final String getEntryType() {
        return this.entryType;
    }

    @Override // android.os.Parcelable
    public final String getId() {
        String str = this.id;
        if (str == null) {
        } else {
            return str;
        }
        n.w("id");
        throw 0;
    }

    @Override // android.os.Parcelable
    public final String getImageUrl() {
        String imageUrl = this.imageUrl;
        if (imageUrl == null) {
        } else {
            return imageUrl;
        }
        n.w("imageUrl");
        throw 0;
    }

    @Override // android.os.Parcelable
    public final String getLocale() {
        return this.locale;
    }

    public final Set<String> getLocations() {
        return this.locations;
    }

    @Override // android.os.Parcelable
    public final String getMedalImageUrl() {
        return this.medalImageUrl;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes getMediaType() {
        int i;
        app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes mediaTypes;
        boolean z;
        String entryType;
        app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes[] values = ChallengeModel.MediaTypes.values();
        i = 0;
        while (i < values.length) {
            mediaTypes = values[i];
            i++;
        }
        return ChallengeModel.MediaTypes.UNDEFINED;
    }

    @Override // android.os.Parcelable
    public final String getName() {
        return this.name;
    }

    public final Set<String> getParticipatingCountries() {
        return this.participatingCountries;
    }

    @Override // android.os.Parcelable
    public final String getPrizeRules() {
        app.dogo.com.dogo_android.model.ChallengeModel.SponsorModel sponsor = this.sponsor;
        n.d(sponsor);
        return sponsor.getPrizeRules();
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.model.ChallengeModel.SponsorModel getSponsor() {
        return this.sponsor;
    }

    @Override // android.os.Parcelable
    public final String getSponsorDetailsBannerImageUrl() {
        app.dogo.com.dogo_android.model.ChallengeModel.SponsorModel sponsor = this.sponsor;
        n.d(sponsor);
        return sponsor.getDetailImageUrl();
    }

    @Override // android.os.Parcelable
    public final String getSponsorFeedBannerImageUrl() {
        app.dogo.com.dogo_android.model.ChallengeModel.SponsorModel sponsor = this.sponsor;
        n.d(sponsor);
        return sponsor.getBannerImageUrl();
    }

    @Override // android.os.Parcelable
    public final String getSponsorHeaderBannerImageUrl() {
        app.dogo.com.dogo_android.model.ChallengeModel.SponsorModel sponsor = this.sponsor;
        n.d(sponsor);
        return sponsor.getMainImageUrl();
    }

    @Override // android.os.Parcelable
    public final String getSponsorWebsiteUrl() {
        app.dogo.com.dogo_android.model.ChallengeModel.SponsorModel sponsor = this.sponsor;
        n.d(sponsor);
        return sponsor.getWebsiteUrl();
    }

    @Override // android.os.Parcelable
    public final long getStartDate() {
        return this.startDate;
    }

    @Override // android.os.Parcelable
    public final String getTimeLeft(v2 v2) {
        n.f(v2, "utilities");
        return v2.v(endDate -= timeInMillis);
    }

    @Override // android.os.Parcelable
    public final long getTimeLeftInMillis(long l) {
        return endDate -= l;
    }

    @Override // android.os.Parcelable
    public final boolean hasPrize() {
        int i;
        boolean hasPrize;
        if (!getMediaType().hasHasPrize()) {
            app.dogo.com.dogo_android.model.ChallengeModel.SponsorModel sponsor = this.sponsor;
            n.d(sponsor);
            if (sponsor.isEnabled()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean hasSponsor() {
        app.dogo.com.dogo_android.model.ChallengeModel.SponsorModel sponsor = this.sponsor;
        n.d(sponsor);
        return sponsor.isEnabled();
    }

    @Override // android.os.Parcelable
    public final boolean isChallengeCountryRestricted() {
        boolean contains;
        int i;
        String str;
        if (!this.locations.isEmpty() && !this.locations.contains("global")) {
            i = !this.locations.contains("global") ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean isDateExpired(v2 v2) {
        int obj5;
        n.f(v2, "utilities");
        obj5 = Long.compare(i, i2) <= 0 ? 1 : 0;
        return obj5;
    }

    @Override // android.os.Parcelable
    public final boolean isHasEnded(v2 v2) {
        int obj2;
        n.f(v2, "utilities");
        if (!this.hasEnded) {
            if (isDateExpired(v2)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // android.os.Parcelable
    public final boolean isHasStarted() {
        return this.isHasStarted;
    }

    public final void setDefaultFilters(List<String> list) {
        boolean hashMap;
        boolean filterType;
        Object challengeFilterItem;
        Iterator obj4;
        if (list != null && !list.isEmpty()) {
            if (!list.isEmpty()) {
                hashMap = new HashMap();
                obj4 = list.iterator();
                while (obj4.hasNext()) {
                    Object next = obj4.next();
                    n.d((String)next);
                    filterType = ChallengeFilterItem.FilterTypes.Companion.parseFilterType(next);
                    if (filterType != null) {
                    }
                    challengeFilterItem = new ChallengeFilterItem(filterType);
                    hashMap.put(filterType, challengeFilterItem);
                }
                this.defaultFilters = hashMap;
            }
        }
    }

    @Override // android.os.Parcelable
    public final void setDescription(String string) {
        this.description = string;
    }

    @Override // android.os.Parcelable
    public final void setEndDate(Timestamp timestamp) {
        int i;
        long l;
        int obj5;
        if (timestamp == 0) {
            this.endDate = 0;
        } else {
            this.endDate = seconds *= l;
        }
    }

    @Override // android.os.Parcelable
    public final void setEntryType(String string) {
        this.entryType = string;
    }

    @Override // android.os.Parcelable
    public final void setHasEnded(boolean z) {
        this.hasEnded = z;
    }

    @Override // android.os.Parcelable
    public final void setHasStarted(boolean z) {
        this.isHasStarted = z;
    }

    @Override // android.os.Parcelable
    public final void setId(String string) {
        n.f(string, "<set-?>");
        this.id = string;
    }

    @Override // android.os.Parcelable
    public final void setImageUrl(String string) {
        n.f(string, "<set-?>");
        this.imageUrl = string;
    }

    @Override // android.os.Parcelable
    public final void setLocale(String string) {
        this.locale = string;
    }

    public final void setLocations(List<String> list) {
        HashSet hashSet;
        Object obj2;
        if (list != null) {
            hashSet = new HashSet(list);
            this.locations = hashSet;
        } else {
            obj2 = new HashSet();
            this.locations = obj2;
        }
    }

    @Override // android.os.Parcelable
    public final void setMedalImageUrl(String string) {
        this.medalImageUrl = string;
    }

    @Override // android.os.Parcelable
    public final void setName(String string) {
        this.name = string;
    }

    public final void setParticipatingCountries(List<String> list) {
        ArrayList obj2;
        if (list == null) {
            obj2 = new ArrayList();
        }
        HashSet hashSet = new HashSet(obj2);
        this.participatingCountries = hashSet;
    }

    public final void setSponsor(Map<String, ? extends Object> map) {
        ChallengeModel.SponsorModel sponsorModel = new ChallengeModel.SponsorModel(map);
        this.sponsor = sponsorModel;
    }

    @Override // android.os.Parcelable
    public final void setStartDate(Timestamp timestamp) {
        int i;
        long l;
        int obj5;
        if (timestamp == 0) {
            this.startDate = 0;
        } else {
            this.startDate = seconds *= l;
        }
    }

    @Override // android.os.Parcelable
    public final boolean sponsorIndexCheck(int i) {
        app.dogo.com.dogo_android.model.ChallengeModel.SponsorModel sponsor = this.sponsor;
        n.d(sponsor);
        List visibleBannerIndices = sponsor.getVisibleBannerIndices();
        n.d(visibleBannerIndices);
        return visibleBannerIndices.contains(Long.valueOf((long)i));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "dest");
        parcel.writeString(this.description);
        parcel.writeLong(this.endDate);
        parcel.writeString(this.entryType);
        parcel.writeByte((byte)hasEnded);
        parcel.writeByte((byte)isHasStarted);
        parcel.writeString(getId());
        parcel.writeString(getImageUrl());
        parcel.writeString(this.locale);
        parcel.writeString(this.medalImageUrl);
        parcel.writeString(this.name);
        parcel.writeLong(this.startDate);
        parcel.writeParcelable(this.sponsor, i2);
    }
}
