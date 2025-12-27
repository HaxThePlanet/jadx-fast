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

/* compiled from: ChallengeModel.kt */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0010\"\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\n\u0018\u0000 h2\u00020\u0001:\u0003hijB\u0007\u0008\u0016¢\u0006\u0002\u0010\u0002B\u000f\u0008\u0014\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010J\u001a\u00020KH\u0016J\u000e\u0010L\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020\u000eJ\u000e\u0010N\u001a\u00020\u000e2\u0006\u0010O\u001a\u00020PJ\u000e\u0010Q\u001a\u00020\u00132\u0006\u0010R\u001a\u00020\u0013J\u0006\u0010S\u001a\u00020\u001bJ\u0006\u0010T\u001a\u00020\u001bJ\u000e\u0010U\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020PJ\u000e\u0010V\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020PJ\u0018\u0010W\u001a\u00020X2\u0010\u0010\n\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010YJ\u0010\u0010Z\u001a\u00020X2\u0008\u0010\u0014\u001a\u0004\u0018\u00010[J\u000e\u0010\\\u001a\u00020X2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010]\u001a\u00020X2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010YJ\u0016\u0010^\u001a\u00020X2\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010YJ \u0010_\u001a\u00020X2\u0018\u0010`\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010a\u0018\u00010\u0007J\u0010\u0010b\u001a\u00020X2\u0008\u0010H\u001a\u0004\u0018\u00010[J\u000e\u0010c\u001a\u00020\u001b2\u0006\u0010d\u001a\u00020KJ\u0018\u0010e\u001a\u00020X2\u0006\u0010f\u001a\u00020\u00042\u0006\u0010g\u001a\u00020KH\u0016R6\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0018\u0010\u0010\"\u0004\u0008\u0019\u0010\u0012R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001d\u0010\u0010\"\u0004\u0008\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010\u0010\"\u0004\u0008!\u0010\u0012R\u0011\u0010\"\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\u0008\"\u0010#R\u001a\u0010$\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008$\u0010#\"\u0004\u0008%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008(\u0010\u0010\"\u0004\u0008)\u0010\u0012R*\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u000e0*2\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u000e0*@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008/\u0010\u0010\"\u0004\u00080\u0010\u0012R\u0011\u00101\u001a\u0002028F¢\u0006\u0006\u001a\u0004\u00083\u00104R\u001c\u00105\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00086\u0010\u0010\"\u0004\u00087\u0010\u0012R*\u00108\u001a\u0008\u0012\u0004\u0012\u00020\u000e0*2\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u000e0*@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010-R\u0013\u0010:\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\u0008;\u0010\u0010R\"\u0010=\u001a\u0004\u0018\u00010<2\u0008\u0010\u0006\u001a\u0004\u0018\u00010<@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010?R\u0013\u0010@\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\u0008A\u0010\u0010R\u0013\u0010B\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\u0008C\u0010\u0010R\u0013\u0010D\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\u0008E\u0010\u0010R\u0013\u0010F\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\u0008G\u0010\u0010R\u001e\u0010H\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008I\u0010\u0016¨\u0006k", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeModel;", "Landroid/os/Parcelable;", "()V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/model/ChallengeFilterItem$FilterTypes;", "Lapp/dogo/com/dogo_android/model/ChallengeFilterItem;", "defaultFilters", "getDefaultFilters", "()Ljava/util/Map;", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "", "endDate", "getEndDate", "()J", "entryType", "getEntryType", "setEntryType", "hasEnded", "", "id", "getId", "setId", "imageUrl", "getImageUrl", "setImageUrl", "isChallengeCountryRestricted", "()Z", "isHasStarted", "setHasStarted", "(Z)V", "locale", "getLocale", "setLocale", "", "locations", "getLocations", "()Ljava/util/Set;", "medalImageUrl", "getMedalImageUrl", "setMedalImageUrl", "mediaType", "Lapp/dogo/com/dogo_android/model/ChallengeModel$MediaTypes;", "getMediaType", "()Lapp/dogo/com/dogo_android/model/ChallengeModel$MediaTypes;", "name", "getName", "setName", "participatingCountries", "getParticipatingCountries", "prizeRules", "getPrizeRules", "Lapp/dogo/com/dogo_android/model/ChallengeModel$SponsorModel;", "sponsor", "getSponsor", "()Lapp/dogo/com/dogo_android/model/ChallengeModel$SponsorModel;", "sponsorDetailsBannerImageUrl", "getSponsorDetailsBannerImageUrl", "sponsorFeedBannerImageUrl", "getSponsorFeedBannerImageUrl", "sponsorHeaderBannerImageUrl", "getSponsorHeaderBannerImageUrl", "sponsorWebsiteUrl", "getSponsorWebsiteUrl", "startDate", "getStartDate", "describeContents", "", "eligibleForPrize", "countryCode", "getTimeLeft", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "getTimeLeftInMillis", "currentTimeInMillis", "hasPrize", "hasSponsor", "isDateExpired", "isHasEnded", "setDefaultFilters", "", "", "setEndDate", "Lcom/google/firebase/Timestamp;", "setHasEnded", "setLocations", "setParticipatingCountries", "setSponsor", "sponsorMap", "", "setStartDate", "sponsorIndexCheck", "entryCount", "writeToParcel", "dest", "flags", "Companion", "MediaTypes", "SponsorModel", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ChallengeModel implements Parcelable {

    public static final Parcelable.Creator<ChallengeModel> CREATOR = new ChallengeModel$Companion$CREATOR$1<>();
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final ChallengeModel.Companion INSTANCE = new ChallengeModel$Companion(0);
    private static List<? extends ChallengeModel.MediaTypes> SUPPORTED_ENTRY_TYPES;
    private Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> defaultFilters = new EnumMap<>();
    private String description;
    private long endDate;
    private String entryType;
    private boolean hasEnded;
    public String id;
    public String imageUrl;
    private boolean isHasStarted;
    private String locale;
    private Set<String> locations = new HashSet<>();
    private String medalImageUrl;
    private String name;
    private Set<String> participatingCountries = new HashSet<>();
    private ChallengeModel.SponsorModel sponsor = new ChallengeModel$SponsorModel();
    private long startDate;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000c¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "SUPPORTED_ENTRY_TYPES", "", "Lapp/dogo/com/dogo_android/model/ChallengeModel$MediaTypes;", "getSUPPORTED_ENTRY_TYPES", "()Ljava/util/List;", "setSUPPORTED_ENTRY_TYPES", "(Ljava/util/List;)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public final List<ChallengeModel.MediaTypes> getSUPPORTED_ENTRY_TYPES() {
            return ChallengeModel.SUPPORTED_ENTRY_TYPES;
        }

        public final void setSUPPORTED_ENTRY_TYPES(List<? extends ChallengeModel.MediaTypes> list) {
            n.f(list, "<set-?>");
            ChallengeModel.SUPPORTED_ENTRY_TYPES = list;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0008\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0008J\u0008\u0010\t\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000f¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeModel$MediaTypes;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "hasHasPrize", "", "toString", "PHOTO", "PHOTODEBUG", "PHOTO_BARKBOX", "PHOTO_FRIENDLY_COLLAR", "SINGLE_ENTRY_NEVER_ENDING", "UNDEFINED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum MediaTypes {

        PHOTO,
        PHOTODEBUG,
        PHOTO_BARKBOX,
        PHOTO_FRIENDLY_COLLAR,
        SINGLE_ENTRY_NEVER_ENDING,
        UNDEFINED;

        private final String type;
        @Override // java.lang.Enum
        public final String getType() {
            return this.type;
        }

        @Override // java.lang.Enum
        public final boolean hasHasPrize() {
            boolean z = false;
            int i2 = 2;
            int i3 = ChallengeModel.MediaTypes.WhenMappings.$EnumSwitchMapping$0[ordinal()];
            int i4 = 0;
            int i = 1;
            if (ChallengeModel.MediaTypes.WhenMappings.$EnumSwitchMapping$0 == i || ChallengeModel.MediaTypes.WhenMappings.$EnumSwitchMapping$0 == 2) {
            } else {
                i = 3;
                if (ChallengeModel.MediaTypes.WhenMappings.$EnumSwitchMapping$0 != 3) {
                    i = 4;
                }
            }
            return z;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.type;
        }

        private static final /* synthetic */ ChallengeModel.MediaTypes[] $values() {
            app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes[] arr = new ChallengeModel.MediaTypes[6];
            return new ChallengeModel.MediaTypes[] { ChallengeModel_MediaTypes.PHOTO, ChallengeModel_MediaTypes.PHOTODEBUG, ChallengeModel_MediaTypes.PHOTO_BARKBOX, ChallengeModel_MediaTypes.PHOTO_FRIENDLY_COLLAR, ChallengeModel_MediaTypes.SINGLE_ENTRY_NEVER_ENDING, ChallengeModel_MediaTypes.UNDEFINED };
        }
    }

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B!\u0008\u0016\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006B\u000f\u0008\u0014\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00082\u0006\u0010%\u001a\u00020!H\u0016R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0008\u0010\n\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0008\u0010\n\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\rR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0008\u0010\n\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\rR\"\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0008\u0010\n\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\rR\"\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0008\u0010\n\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\rR2\u0010\u001b\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u00192\u0010\u0010\n\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\"\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0008\u0010\n\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\r¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeModel$SponsorModel;", "Landroid/os/Parcelable;", "snapshot", "", "", "", "(Ljava/util/Map;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "<set-?>", "bannerImageUrl", "getBannerImageUrl", "()Ljava/lang/String;", "detailImageUrl", "getDetailImageUrl", "", "isEnabled", "()Z", "mainImageUrl", "getMainImageUrl", "prizeRules", "getPrizeRules", "title", "getTitle", "", "", "visibleBannerIndices", "getVisibleBannerIndices", "()Ljava/util/List;", "websiteUrl", "getWebsiteUrl", "describeContents", "", "writeToParcel", "", "dest", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SponsorModel implements Parcelable {

        public static final Parcelable.Creator<ChallengeModel.SponsorModel> CREATOR = new ChallengeModel$SponsorModel$Companion$CREATOR$1<>();
        /* renamed from: Companion, reason: from kotlin metadata */
        public static final ChallengeModel.SponsorModel.Companion INSTANCE = new ChallengeModel$SponsorModel$Companion(0);
        private String bannerImageUrl;
        private String detailImageUrl;
        private boolean isEnabled;
        private String mainImageUrl;
        private String prizeRules;
        private String title;
        private List<Long> visibleBannerIndices = new ArrayList<>();
        private String websiteUrl;

        public SponsorModel(Map<String, ? extends Object> map) {
            super();
            ArrayList arrayList = new ArrayList();
            if (map != null && !map.isEmpty()) {
                this.bannerImageUrl = (String)map.get("bannerImageUrl");
                this.detailImageUrl = (String)map.get("detailImageUrl");
                this.mainImageUrl = (String)map.get("mainImageUrl");
                this.prizeRules = (String)map.get("prizeRules");
                this.title = (String)map.get("title");
                this.websiteUrl = (String)map.get("websiteUrl");
                this.visibleBannerIndices = (List)map.get("visibleBannerIndices");
                boolean z = true;
                this.isEnabled = z;
            }
        }

        public final String getBannerImageUrl() {
            return this.bannerImageUrl;
        }

        public final String getDetailImageUrl() {
            return this.detailImageUrl;
        }

        public final String getMainImageUrl() {
            return this.mainImageUrl;
        }

        public final String getPrizeRules() {
            return this.prizeRules;
        }

        public final String getTitle() {
            return this.title;
        }

        public final List<Long> getVisibleBannerIndices() {
            return this.visibleBannerIndices;
        }

        public final String getWebsiteUrl() {
            return this.websiteUrl;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            n.f(dest, "dest");
            dest.writeString(this.bannerImageUrl);
            dest.writeString(this.detailImageUrl);
            dest.writeString(this.mainImageUrl);
            dest.writeString(this.prizeRules);
            dest.writeString(this.title);
            dest.writeString(this.websiteUrl);
            dest.writeList(this.visibleBannerIndices);
            dest.writeByte(this.isEnabled != 0 ? 1 : 0);
        }

        protected SponsorModel(Parcel parcel) {
            int i = 1;
            n.f(parcel, "in");
            super();
            ArrayList arrayList = new ArrayList();
            this.bannerImageUrl = parcel.readString();
            this.detailImageUrl = parcel.readString();
            this.mainImageUrl = parcel.readString();
            this.prizeRules = parcel.readString();
            this.title = parcel.readString();
            this.websiteUrl = parcel.readString();
            n.d(this.visibleBannerIndices);
            parcel.readList(this.visibleBannerIndices, null);
            parcel = parcel.readByte() != 0 ? 1 : 0;
            this.isEnabled = (parcel.readByte() != 0 ? 1 : 0);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }
    static {
        app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes[] arr = new ChallengeModel.MediaTypes[2];
        ChallengeModel.SUPPORTED_ENTRY_TYPES = p.j(new ChallengeModel.MediaTypes[] { ChallengeModel_MediaTypes.PHOTO, ChallengeModel_MediaTypes.SINGLE_ENTRY_NEVER_ENDING });
    }

    public ChallengeModel() {
        super();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        EnumMap enumMap = new EnumMap(ChallengeFilterItem_FilterTypes.class);
        app.dogo.com.dogo_android.model.ChallengeModel.SponsorModel challengeModel_SponsorModel = new ChallengeModel_SponsorModel(new HashMap());
    }

    public static final /* synthetic */ List access$getSUPPORTED_ENTRY_TYPES$cp() {
        return ChallengeModel.SUPPORTED_ENTRY_TYPES;
    }

    public static final /* synthetic */ void access$setSUPPORTED_ENTRY_TYPES$cp(List list) {
        ChallengeModel.SUPPORTED_ENTRY_TYPES = list;
    }

    public final boolean eligibleForPrize(String countryCode) {
        boolean contains;
        boolean z = false;
        n.f(countryCode, "countryCode");
        if (!this.locations.contains("global")) {
            if (this.locations.contains(countryCode)) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z;
    }

    public final Map<ChallengeFilterItem.FilterTypes, ChallengeFilterItem> getDefaultFilters() {
        return this.defaultFilters;
    }

    public final String getDescription() {
        return this.description;
    }

    public final long getEndDate() {
        return this.endDate;
    }

    public final String getEntryType() {
        return this.entryType;
    }

    public final String getId() {
        if (this.id == null) {
            n.w("id");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.id;
        }
    }

    public final String getImageUrl() {
        if (this.imageUrl == null) {
            n.w("imageUrl");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.imageUrl;
        }
    }

    public final String getLocale() {
        return this.locale;
    }

    public final Set<String> getLocations() {
        return this.locations;
    }

    public final String getMedalImageUrl() {
        return this.medalImageUrl;
    }

    public final ChallengeModel.MediaTypes getMediaType() {
        int i = 0;
        app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes[] values = ChallengeModel_MediaTypes.values();
        i = 0;
        for (app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes mediaTypes : values) {
            if (n.b(mediaTypes.getType(), this.entryType)) {
                return mediaTypes;
            }
        }
        return ChallengeModel_MediaTypes.UNDEFINED;
    }

    public final String getName() {
        return this.name;
    }

    public final Set<String> getParticipatingCountries() {
        return this.participatingCountries;
    }

    public final String getPrizeRules() {
        n.d(this.sponsor);
        return this.sponsor.getPrizeRules();
    }

    public final ChallengeModel.SponsorModel getSponsor() {
        return this.sponsor;
    }

    public final String getSponsorDetailsBannerImageUrl() {
        n.d(this.sponsor);
        return this.sponsor.getDetailImageUrl();
    }

    public final String getSponsorFeedBannerImageUrl() {
        n.d(this.sponsor);
        return this.sponsor.getBannerImageUrl();
    }

    public final String getSponsorHeaderBannerImageUrl() {
        n.d(this.sponsor);
        return this.sponsor.getMainImageUrl();
    }

    public final String getSponsorWebsiteUrl() {
        n.d(this.sponsor);
        return this.sponsor.getWebsiteUrl();
    }

    public final long getStartDate() {
        return this.startDate;
    }

    public final String getTimeLeft(v2 utilities) {
        n.f(utilities, "utilities");
        return utilities.v(this.endDate - Calendar.getInstance().getTimeInMillis());
    }

    public final long getTimeLeftInMillis(long currentTimeInMillis) {
        return this.endDate - currentTimeInMillis;
    }

    public final boolean hasPrize() {
        boolean z = false;
        if (!getMediaType().hasHasPrize()) {
            n.d(this.sponsor);
            if (this.sponsor.isEnabled()) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z;
    }

    public final boolean hasSponsor() {
        n.d(this.sponsor);
        return this.sponsor.isEnabled();
    }

    public final boolean isChallengeCountryRestricted() {
        boolean z = false;
        String str;
        if (!this.locations.isEmpty()) {
            str = "global";
            int r0 = !this.locations.contains(str) ? 1 : 0;
        }
        return (!this.locations.contains(str) ? 1 : 0);
    }

    public final boolean isDateExpired(v2 utilities) {
        boolean z = true;
        n.f(utilities, "utilities");
        long l = this.endDate - utilities.g();
        utilities = this.endDate <= 0 ? 1 : 0;
        return (this.endDate <= 0 ? 1 : 0);
    }

    public final boolean isHasEnded(v2 utilities) {
        boolean z = false;
        n.f(utilities, "utilities");
        if (this.hasEnded || this.isDateExpired(utilities)) {
            int i2 = 1;
        }
        return z;
    }

    public final boolean isHasStarted() {
        return this.isHasStarted;
    }

    public final void setDefaultFilters(List<String> defaultFilters) {
        app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes.Companion iNSTANCE2;
        if (defaultFilters != null && !defaultFilters.isEmpty()) {
            HashMap hashMap = new HashMap();
            Iterator it = defaultFilters.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                n.d(item);
                app.dogo.com.dogo_android.model.ChallengeFilterItem.FilterTypes filterType = ChallengeFilterItem_FilterTypes.INSTANCE.parseFilterType(item);
            }
            this.defaultFilters = hashMap;
        }
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setEndDate(Timestamp endDate) {
        if (endDate == null) {
            long l = 0L;
            this.endDate = l;
        } else {
            int i = 1000;
            l2 = (long)i;
            l = endDate.getSeconds() * l2;
            this.endDate = l;
        }
    }

    public final void setEntryType(String str) {
        this.entryType = str;
    }

    public final void setHasEnded(boolean hasEnded) {
        this.hasEnded = hasEnded;
    }

    public final void setHasStarted(boolean z) {
        this.isHasStarted = z;
    }

    public final void setId(String str) {
        n.f(str, "<set-?>");
        this.id = str;
    }

    public final void setImageUrl(String str) {
        n.f(str, "<set-?>");
        this.imageUrl = str;
    }

    public final void setLocale(String str) {
        this.locale = str;
    }

    public final void setLocations(List<String> locations) {
        if (locations != null) {
            this.locations = new HashSet(locations);
        } else {
            this.locations = new HashSet();
        }
    }

    public final void setMedalImageUrl(String str) {
        this.medalImageUrl = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setParticipatingCountries(List<String> participatingCountries) {
        ArrayList arrayList;
        if (participatingCountries == null) {
            arrayList = new ArrayList();
        }
        HashSet hashSet = new HashSet(arrayList);
        this.participatingCountries = hashSet;
    }

    public final void setSponsor(Map<String, ? extends Object> sponsorMap) {
        this.sponsor = new ChallengeModel_SponsorModel(sponsorMap);
    }

    public final void setStartDate(Timestamp startDate) {
        if (startDate == null) {
            long l = 0L;
            this.startDate = l;
        } else {
            int i = 1000;
            l2 = (long)i;
            l = startDate.getSeconds() * l2;
            this.startDate = l;
        }
    }

    public final boolean sponsorIndexCheck(int entryCount) {
        n.d(this.sponsor);
        List visibleBannerIndices = this.sponsor.getVisibleBannerIndices();
        n.d(visibleBannerIndices);
        return visibleBannerIndices.contains(Long.valueOf((long)entryCount));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        n.f(dest, "dest");
        dest.writeString(this.description);
        dest.writeLong(this.endDate);
        dest.writeString(this.entryType);
        dest.writeByte(this.hasEnded != 0 ? 1 : 0);
        dest.writeByte(this.isHasStarted != 0 ? 1 : 0);
        dest.writeString(getId());
        dest.writeString(getImageUrl());
        dest.writeString(this.locale);
        dest.writeString(this.medalImageUrl);
        dest.writeString(this.name);
        dest.writeLong(this.startDate);
        dest.writeParcelable(this.sponsor, flags);
    }

    protected ChallengeModel(Parcel parcel) {
        int i;
        n.f(parcel, "in");
        super();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        EnumMap enumMap = new EnumMap(ChallengeFilterItem_FilterTypes.class);
        app.dogo.com.dogo_android.model.ChallengeModel.SponsorModel challengeModel_SponsorModel = new ChallengeModel_SponsorModel(new HashMap());
        this.description = parcel.readString();
        this.endDate = parcel.readLong();
        this.entryType = parcel.readString();
        i = 1;
        i = 0;
        int r0 = parcel.readByte() != 0 ? 1 : i;
        this.hasEnded = (parcel.readByte() != 0 ? 1 : i);
        if (parcel.readByte() == 0) {
        }
        this.isHasStarted = i;
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
        this.sponsor = (ChallengeModel_SponsorModel)parcel.readParcelable(ChallengeModel_SponsorModel.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
