package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.android.persistencedb.room.entity.DogEntity;
import app.dogo.com.dogo_android.k.d;
import app.dogo.com.dogo_android.k.d.a;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.service.v2.a;
import app.dogo.externalmodel.model.responses.UserApiModel.DogApiModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.i;
import kotlin.y.p;
import n.a.a;

/* compiled from: DogProfile.kt */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008 \n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 C2\u00020\u0001:\u0001CBo\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u000eHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017Jz\u0010.\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u0010/J\t\u00100\u001a\u00020\u0011HÖ\u0001J\u0006\u00101\u001a\u000202J\u0013\u00103\u001a\u0002022\u0008\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0011HÖ\u0001J\u000e\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0003J\u000e\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0003J\t\u0010=\u001a\u00020\u0003HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\u0008\u0016\u0010\u0017R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0015R\u0015\u0010\u000c\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\u0008\u001b\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0015R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0015R\u0013\u0010!\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\u0008\"\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u0015¨\u0006D", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "Landroid/os/Parcelable;", "name", "", "avatar", "id", "birthday", "", "breedId", "breedTitle", "customBreed", "creatorId", "createTimeMs", "gender", "Lapp/dogo/com/dogo_android/enums/DogGender;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lapp/dogo/com/dogo_android/enums/DogGender;)V", "ageInMonths", "", "getAgeInMonths", "()Ljava/lang/Integer;", "getAvatar", "()Ljava/lang/String;", "getBirthday", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBreedId", "getBreedTitle", "getCreateTimeMs", "getCreatorId", "getCustomBreed", "getGender", "()Lapp/dogo/com/dogo_android/enums/DogGender;", "getId", "initialAgeInMonths", "getInitialAgeInMonths", "getName", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lapp/dogo/com/dogo_android/enums/DogGender;)Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "describeContents", "dogOnlyHasName", "", "equals", "other", "", "hashCode", "toDogEntity", "Lapp/dogo/android/persistencedb/room/entity/DogEntity;", "parentId", "toModel", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "userId", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogProfile implements Parcelable {

    public static final Parcelable.Creator<DogProfile> CREATOR = null;
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final DogProfile.Companion INSTANCE = null;
    public static final int NAME_MAX_LENGTH = 21;
    private final String avatar;
    private final Long birthday;
    private final String breedId;
    private final String breedTitle;
    private final Long createTimeMs;
    private final String creatorId;
    private final String customBreed;
    private final d gender;
    private final String id;
    private final String name;

    @Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008J%\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00060\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\r0\u000c\"\u00020\r¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogProfile$Companion;", "", "()V", "NAME_MAX_LENGTH", "", "fromApiDog", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "it", "Lapp/dogo/externalmodel/model/responses/UserApiModel$DogApiModel;", "fromEntities", "", "dogEntities", "", "Lapp/dogo/android/persistencedb/room/entity/DogEntity;", "([Lapp/dogo/android/persistencedb/room/entity/DogEntity;)Ljava/util/List;", "getDogsBirthdayTimeMs", "", "birthDate", "", "(Ljava/lang/String;)Ljava/lang/Long;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public final DogProfile fromApiDog(UserApiModel.DogApiModel it) {
            String it2;
            n.f(it, "it");
            it2 = it.getName();
            it2 = "";
            String r3 = it2;
            it2 = it.getAvatarUrl();
            String r4 = it2;
            it2 = it.getGender();
            if (it2 != null) {
            }
            DogProfile dogProfile = new DogProfile(it2, it2, str, dogsBirthdayTimeMs, breedId, it3, it.getCustomBreed(), it.getCreatorId(), it.getCreatedTimeMs(), DogGender.INSTANCE.enumFromApiGender(it2));
            return dogProfile;
        }

        public final List<DogProfile> fromEntities(DogEntity... dogEntities) {
            String avatarUrl;
            n.f(dogEntities, "dogEntities");
            List list = i.a0(dogEntities);
            ArrayList arrayList = new ArrayList(p.r(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                avatarUrl = item.getName();
                avatarUrl = "";
                String r4 = avatarUrl;
                avatarUrl = item.getAvatarUrl();
                String r5 = avatarUrl;
                avatarUrl = item.getGender();
                str = "";
                DogProfile dogProfile = new DogProfile(avatarUrl, avatarUrl, str2, dogsBirthdayTimeMs, breedId, str, item.getCustomBreed(), item.getCreatorId(), item.getCreateTimeMs(), DogGender.INSTANCE.enumFromApiGender(avatarUrl));
                arrayList.add(dogProfile);
            }
            return arrayList;
        }

        public final Long getDogsBirthdayTimeMs(String birthDate) {
            int i = 0;
            str = "yyyy-MM-dd";
            i = 0;
            return i;
        }

        public /* synthetic */ Companion(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogProfile> {
        @Override // android.os.Parcelable$Creator
        public final DogProfile createFromParcel(Parcel parcel) {
            int i;
            Long num;
            n.f(parcel, "parcel");
            i = 0;
            if (parcel.readInt() == 0) {
            } else {
            }
            if (parcel.readInt() == 0) {
            } else {
            }
            DogProfile dogProfile = new DogProfile(parcel.readString(), parcel.readString(), parcel.readString(), i, string, string2, string3, string4, num, parcel2);
            return dogProfile;
        }

        @Override // android.os.Parcelable$Creator
        public final DogProfile[] newArray(int i) {
            return new DogProfile[i];
        }
    }
    public DogProfile(String str, String str2, String str3, Long long, String str4, String str5, String str6, String str7, Long long2, d dVar) {
        n.f(str, "name");
        n.f(str2, "avatar");
        n.f(str3, "id");
        n.f(str5, "breedTitle");
        n.f(str7, "creatorId");
        n.f(dVar, "gender");
        super();
        this.name = str;
        this.avatar = str2;
        this.id = str3;
        this.birthday = long;
        this.breedId = str4;
        this.breedTitle = str5;
        this.customBreed = str6;
        this.creatorId = str7;
        this.createTimeMs = long2;
        this.gender = dVar;
    }

    public final boolean dogOnlyHasName() {
        int i;
        d gender2;
        boolean z4 = true;
        i = 1;
        i = 0;
        if (this.gender == DogGender.UNKNOWN) {
            if (this.breedId == null || l.z(this.breedId)) {
            }
            if (this.breedId != 0) {
                if (this.customBreed == null || l.z(this.customBreed)) {
                }
                if (this.gender != 0 && this.birthday == null) {
                    if (!(l.z(this.avatar))) {
                    }
                }
            }
        }
        return z4;
    }

    public final Integer getAgeInMonths() {
        Integer num = null;
        long l = 0;
        if (this.birthday != null) {
            long value2 = this.birthday.longValue();
            l = 0L;
            if (value2 <= l) {
                int i2 = 0;
            } else {
                num = Integer.valueOf(Utilities.Companion.d(System.currentTimeMillis(), this.birthday.longValue()));
            }
        }
        return num;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final Long getBirthday() {
        return this.birthday;
    }

    public final String getBreedId() {
        return this.breedId;
    }

    public final String getBreedTitle() {
        return this.breedTitle;
    }

    public final Long getCreateTimeMs() {
        return this.createTimeMs;
    }

    public final String getCreatorId() {
        return this.creatorId;
    }

    public final String getCustomBreed() {
        return this.customBreed;
    }

    public final d getGender() {
        return this.gender;
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getInitialAgeInMonths() {
        int i = 0;
        long value;
        long l = 0;
        if (this.birthday != null) {
            long value3 = this.birthday.longValue();
            l = 0L;
            if (value3 <= l) {
                i = 0;
            } else {
                if (this.createTimeMs == null) {
                    value = System.currentTimeMillis();
                } else {
                    value = this.createTimeMs.longValue();
                }
                int i2 = 0;
                Integer num = Integer.valueOf(g.b(Utilities.Companion.d(value, this.birthday.longValue()), i2));
            }
        }
        return i;
    }

    public final String getName() {
        return this.name;
    }

    public final DogEntity toDogEntity(String parentId) {
        String format = null;
        n.f(parentId, "parentId");
        if (this.birthday != null) {
            format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(this.birthday.longValue(), r3));
        } else {
            int i = 0;
        }
        DogEntity dogEntity = new DogEntity(this.id, this.creatorId, this.name, this.breedId, this.customBreed, format, Boolean.TRUE, this.gender.getTrackTag(), this.avatar, parentId, this.createTimeMs);
        return dogEntity;
    }

    public final DogProfileModel toModel(String userId) {
        String name2;
        String avatar2;
        int i;
        n.f(userId, "userId");
        double d = 0.0d;
        int i3 = l.z(this.name) ? d : name2;
        int i4 = l.z(this.avatar) ? d : avatar2;
        i = l.z(this.creatorId) ? d : creatorId2;
        DogProfileModel dogProfileModel = new DogProfileModel(name2, avatar2, breedId2, customBreed2, birthday2, i, ordinal, id2, num, userId2, this.createTimeMs);
        return dogProfileModel;
    }

    public /* synthetic */ DogProfile(String str, String str2, String str3, Long long, String str4, String str5, String str6, String str7, Long long2, d dVar, int i, kotlin.d0.d.g gVar) {
        Long long42;
        String str52;
        String str72;
        Long long92;
        d dVar102;
        int i112 = i;
        str4 = "";
        String r4 = i112 & 1 != 0 ? str4 : str;
        String r5 = i112 & 2 != 0 ? str4 : str2;
        i = 0;
        int r7 = i112 & 8 != 0 ? i : long;
        int r8 = i112 & 16 != 0 ? i : str4;
        String r9 = i112 & 32 != 0 ? str4 : str5;
        int r10 = i112 & 64 != 0 ? i : str6;
        String r11 = i112 & 128 != 0 ? str4 : str7;
        int r12 = i112 & 256 != 0 ? i : long2;
        dVar102 = i112 & 512 != 0 ? dVar102 : dVar;
        this(str4, str4, str3, long42, str52, str4, str72, str4, long92, dVar102);
    }

    static {
        DogProfile.INSTANCE = new DogProfile_Companion(null);
        DogProfile.CREATOR = new DogProfile.Creator();
    }

    public static /* synthetic */ DogProfile copy$default(DogProfile dogProfile, String str, String str2, String str3, Long long, String str4, String str5, String str6, String str7, Long long2, d dVar, int i, Object object) {
        d dVar112;
        String str22;
        String str32;
        String str42;
        Long long52;
        String str62;
        String str72;
        String str82;
        String str92;
        Long long102;
        Object dogProfile2 = dogProfile;
        int i122 = i;
        String r2 = i122 & 1 != 0 ? dogProfile2.name : str;
        String r3 = i122 & 2 != 0 ? dogProfile2.avatar : str2;
        String r4 = i122 & 4 != 0 ? dogProfile2.id : str3;
        Long r5 = i122 & 8 != 0 ? dogProfile2.birthday : long;
        String r6 = i122 & 16 != 0 ? dogProfile2.breedId : str4;
        String r7 = i122 & 32 != 0 ? dogProfile2.breedTitle : str5;
        String r8 = i122 & 64 != 0 ? dogProfile2.customBreed : str6;
        String r9 = i122 & 128 != 0 ? dogProfile2.creatorId : str7;
        Long r10 = i122 & 256 != 0 ? dogProfile2.createTimeMs : long2;
        d r1 = i122 & 512 != 0 ? dogProfile2.gender : dVar;
        return dogProfile.copy(str22, str32, str42, long52, str62, str72, str82, str92, long102, (i122 & 512 != 0 ? dogProfile2.gender : dVar));
    }

    /* operator */ public final String component1() {
        return this.name;
    }

    /* operator */ public final d component10() {
        return this.gender;
    }

    /* operator */ public final String component2() {
        return this.avatar;
    }

    /* operator */ public final String component3() {
        return this.id;
    }

    /* operator */ public final Long component4() {
        return this.birthday;
    }

    /* operator */ public final String component5() {
        return this.breedId;
    }

    /* operator */ public final String component6() {
        return this.breedTitle;
    }

    /* operator */ public final String component7() {
        return this.customBreed;
    }

    /* operator */ public final String component8() {
        return this.creatorId;
    }

    /* operator */ public final Long component9() {
        return this.createTimeMs;
    }

    public final DogProfile copy(String name, String avatar, String id, Long birthday, String breedId, String breedTitle, String customBreed, String creatorId, Long createTimeMs, d gender) {
        n.f(name, "name");
        n.f(avatar, "avatar");
        n.f(id, "id");
        final Object breedTitle2 = breedTitle;
        n.f(breedTitle2, "breedTitle");
        final Object creatorId2 = creatorId;
        n.f(creatorId2, "creatorId");
        final Object gender2 = gender;
        n.f(gender2, "gender");
        DogProfile dogProfile = new DogProfile(name, avatar, id, birthday, breedId, breedTitle2, customBreed, creatorId2, createTimeMs, gender2);
        return dogProfile;
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
        final boolean z12 = false;
        if (!(other instanceof DogProfile)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (!n.b(this.avatar, other.avatar)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.birthday, other.birthday)) {
            return false;
        }
        if (!n.b(this.breedId, other.breedId)) {
            return false;
        }
        if (!n.b(this.breedTitle, other.breedTitle)) {
            return false;
        }
        if (!n.b(this.customBreed, other.customBreed)) {
            return false;
        }
        if (!n.b(this.creatorId, other.creatorId)) {
            return false;
        }
        if (!n.b(this.createTimeMs, other.createTimeMs)) {
            return false;
        }
        return this.gender != other.gender ? z12 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        i = 0;
        if (this.birthday == null) {
        } else {
            i = this.birthday.hashCode();
        }
        if (this.breedId == null) {
        } else {
            i = this.breedId.hashCode();
        }
        if (this.customBreed == null) {
        } else {
            i = this.customBreed.hashCode();
        }
        if (this.createTimeMs != null) {
            i = this.createTimeMs.hashCode();
        }
        return (this.name.hashCode() * 31) + this.avatar.hashCode() * 31 + this.id.hashCode() * 31 + i * 31 + i * 31 + this.breedTitle.hashCode() * 31 + i * 31 + this.creatorId.hashCode() * 31 + i * 31 + this.gender.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogProfile(name=";
        String str3 = ", avatar=";
        String str4 = ", id=";
        String str5 = ", birthday=";
        String str6 = ", breedId=";
        String str7 = ", breedTitle=";
        String str8 = ", customBreed=";
        String str9 = ", creatorId=";
        String str10 = ", createTimeMs=";
        String str11 = ", gender=";
        str = str2 + this.name + str3 + this.avatar + str4 + this.id + str5 + this.birthday + str6 + this.breedId + str7 + this.breedTitle + str8 + this.customBreed + str9 + this.creatorId + str10 + this.createTimeMs + str11 + this.gender + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.avatar);
        parcel.writeString(this.id);
        int i = 0;
        final int i2 = 1;
        if (this.birthday == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeLong(this.birthday.longValue());
        }
        parcel.writeString(this.breedId);
        parcel.writeString(this.breedTitle);
        parcel.writeString(this.customBreed);
        parcel.writeString(this.creatorId);
        if (this.createTimeMs == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeLong(this.createTimeMs.longValue());
        }
        parcel.writeString(this.gender.name());
    }
}
