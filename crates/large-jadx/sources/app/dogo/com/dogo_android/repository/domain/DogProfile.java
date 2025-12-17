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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.k0.l;
import kotlin.y.i;
import kotlin.y.p;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008 \n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 C2\u00020\u0001:\u0001CBo\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u000eHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017Jz\u0010.\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u0010/J\t\u00100\u001a\u00020\u0011HÖ\u0001J\u0006\u00101\u001a\u000202J\u0013\u00103\u001a\u0002022\u0008\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0011HÖ\u0001J\u000e\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0003J\u000e\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0003J\t\u0010=\u001a\u00020\u0003HÖ\u0001J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\u0008\u0016\u0010\u0017R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0015R\u0015\u0010\u000c\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\u0008\u001b\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0015R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0015R\u0013\u0010!\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\u0008\"\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u0015¨\u0006D", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "Landroid/os/Parcelable;", "name", "", "avatar", "id", "birthday", "", "breedId", "breedTitle", "customBreed", "creatorId", "createTimeMs", "gender", "Lapp/dogo/com/dogo_android/enums/DogGender;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lapp/dogo/com/dogo_android/enums/DogGender;)V", "ageInMonths", "", "getAgeInMonths", "()Ljava/lang/Integer;", "getAvatar", "()Ljava/lang/String;", "getBirthday", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBreedId", "getBreedTitle", "getCreateTimeMs", "getCreatorId", "getCustomBreed", "getGender", "()Lapp/dogo/com/dogo_android/enums/DogGender;", "getId", "initialAgeInMonths", "getInitialAgeInMonths", "getName", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lapp/dogo/com/dogo_android/enums/DogGender;)Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "describeContents", "dogOnlyHasName", "", "equals", "other", "", "hashCode", "toDogEntity", "Lapp/dogo/android/persistencedb/room/entity/DogEntity;", "parentId", "toModel", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "userId", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogProfile implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.DogProfile> CREATOR = null;
    public static final app.dogo.com.dogo_android.repository.domain.DogProfile.Companion Companion = null;
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
        public Companion(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.repository.domain.DogProfile fromApiDog(UserApiModel.DogApiModel userApiModel$DogApiModel) {
            String str3;
            String str2;
            String str;
            n.f(dogApiModel, "it");
            String name = dogApiModel.getName();
            str3 = "";
            str2 = name == null ? str3 : name;
            String avatarUrl = dogApiModel.getAvatarUrl();
            str = avatarUrl == null ? str3 : avatarUrl;
            String obj13 = dogApiModel.getGender();
            if (obj13 == null) {
            } else {
                str3 = obj13;
            }
            super(str2, str, dogApiModel.getId(), getDogsBirthdayTimeMs(dogApiModel.getBirthday()), dogApiModel.getBreedId(), "", dogApiModel.getCustomBreed(), dogApiModel.getCreatorId(), dogApiModel.getCreatedTimeMs(), d.Companion.a(str3));
            return dogProfile;
        }

        public final List<app.dogo.com.dogo_android.repository.domain.DogProfile> fromEntities(DogEntity... dogEntityArr) {
            int str7;
            app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile2;
            String str8;
            String str6;
            String str2;
            String str5;
            String str4;
            String str;
            Long num;
            String str3;
            int i;
            String customBreed;
            String creatorId;
            Long createTimeMs;
            d dVar;
            app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile;
            n.f(dogEntityArr, "dogEntities");
            List obj15 = i.a0(dogEntityArr);
            ArrayList arrayList = new ArrayList(p.r(obj15, 10));
            obj15 = obj15.iterator();
            while (obj15.hasNext()) {
                Object next2 = obj15.next();
                String name = (DogEntity)next2.getName();
                str6 = "";
                if (name == null) {
                } else {
                }
                str5 = name;
                String avatarUrl = next2.getAvatarUrl();
                if (avatarUrl == null) {
                } else {
                }
                str = avatarUrl;
                String gender = next2.getGender();
                if (gender == null) {
                } else {
                }
                str6 = gender;
                super(str5, str, next2.getId(), DogProfile.Companion.getDogsBirthdayTimeMs(next2.getBirthday()), next2.getBreedId(), "", next2.getCustomBreed(), next2.getCreatorId(), next2.getCreateTimeMs(), d.Companion.a(str6));
                arrayList.add(dogProfile);
                str = str6;
                str5 = str6;
            }
            return arrayList;
        }

        public final Long getDogsBirthdayTimeMs(String string) {
            int valueOf;
            String time;
            Object obj5;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            valueOf = 0;
            if (string != null) {
                obj5 = simpleDateFormat.parse(string);
                if (obj5 == null) {
                } else {
                    valueOf = Long.valueOf(obj5.getTime());
                }
            }
            return valueOf;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.DogProfile> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.DogProfile createFromParcel(Parcel parcel) {
            int valueOf2;
            Long valueOf;
            int i;
            Long num;
            n.f(parcel, "parcel");
            int i2 = 0;
            if (parcel.readInt() == 0) {
                i = i2;
            } else {
                i = valueOf2;
            }
            if (parcel.readInt() == 0) {
                num = i2;
            } else {
                num = valueOf;
            }
            super(parcel.readString(), parcel.readString(), parcel.readString(), i, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), num, d.valueOf(parcel.readString()));
            return dogProfile;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.DogProfile[] newArray(int i) {
            return new DogProfile[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        DogProfile.Companion companion = new DogProfile.Companion(0);
        DogProfile.Companion = companion;
        DogProfile.Creator creator = new DogProfile.Creator();
        DogProfile.CREATOR = creator;
    }

    public DogProfile(String string, String string2, String string3, Long long4, String string5, String string6, String string7, String string8, Long long9, d d10) {
        n.f(string, "name");
        n.f(string2, "avatar");
        n.f(string3, "id");
        n.f(string6, "breedTitle");
        n.f(string8, "creatorId");
        n.f(d10, "gender");
        super();
        this.name = string;
        this.avatar = string2;
        this.id = string3;
        this.birthday = long4;
        this.breedId = string5;
        this.breedTitle = string6;
        this.customBreed = string7;
        this.creatorId = string8;
        this.createTimeMs = long9;
        this.gender = d10;
    }

    public DogProfile(String string, String string2, String string3, Long long4, String string5, String string6, String string7, String string8, Long long9, d d10, int i11, g g12) {
        d uNKNOWN;
        String str2;
        String str3;
        int i;
        int i4;
        String str4;
        int i3;
        String str;
        int i2;
        d dVar;
        int i5 = i11;
        final String str5 = "";
        str2 = i5 & 1 != 0 ? str5 : string;
        str3 = i5 & 2 != 0 ? str5 : string2;
        int i15 = 0;
        i = i5 & 8 != 0 ? i15 : long4;
        i4 = i5 & 16 != 0 ? i15 : string5;
        str4 = i5 & 32 != 0 ? str5 : string6;
        i3 = i5 & 64 != 0 ? i15 : string7;
        str = i5 & 128 != 0 ? str5 : string8;
        i2 = i5 & 256 != 0 ? i15 : long9;
        dVar = i5 &= 512 != 0 ? uNKNOWN : d10;
        super(str2, str3, string3, i, i4, str4, i3, str, i2, dVar);
    }

    public static app.dogo.com.dogo_android.repository.domain.DogProfile copy$default(app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile, String string2, String string3, String string4, Long long5, String string6, String string7, String string8, String string9, Long long10, d d11, int i12, Object object13) {
        d gender;
        String name;
        String avatar;
        String str;
        Long birthday;
        String breedId;
        String breedTitle;
        String customBreed;
        String creatorId;
        Long createTimeMs;
        Object obj = dogProfile;
        int i = i12;
        name = i & 1 != 0 ? obj.name : string2;
        avatar = i & 2 != 0 ? obj.avatar : string3;
        str = i & 4 != 0 ? obj.id : string4;
        birthday = i & 8 != 0 ? obj.birthday : long5;
        breedId = i & 16 != 0 ? obj.breedId : string6;
        breedTitle = i & 32 != 0 ? obj.breedTitle : string7;
        customBreed = i & 64 != 0 ? obj.customBreed : string8;
        creatorId = i & 128 != 0 ? obj.creatorId : string9;
        createTimeMs = i & 256 != 0 ? obj.createTimeMs : long10;
        gender = i &= 512 != 0 ? obj.gender : d11;
        return dogProfile.copy(name, avatar, str, birthday, breedId, breedTitle, customBreed, creatorId, createTimeMs, gender);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public final d component10() {
        return this.gender;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.avatar;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final Long component4() {
        return this.birthday;
    }

    @Override // android.os.Parcelable
    public final String component5() {
        return this.breedId;
    }

    @Override // android.os.Parcelable
    public final String component6() {
        return this.breedTitle;
    }

    @Override // android.os.Parcelable
    public final String component7() {
        return this.customBreed;
    }

    @Override // android.os.Parcelable
    public final String component8() {
        return this.creatorId;
    }

    @Override // android.os.Parcelable
    public final Long component9() {
        return this.createTimeMs;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.DogProfile copy(String string, String string2, String string3, Long long4, String string5, String string6, String string7, String string8, Long long9, d d10) {
        n.f(string, "name");
        n.f(string2, "avatar");
        n.f(string3, "id");
        final Object obj = string6;
        n.f(obj, "breedTitle");
        final Object obj2 = string8;
        n.f(obj2, "creatorId");
        final Object obj3 = d10;
        n.f(obj3, "gender");
        super(string, string2, string3, long4, string5, obj, string7, obj2, long9, obj3);
        return dogProfile;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final boolean dogOnlyHasName() {
        boolean birthday;
        String customBreed;
        String breedId;
        int i;
        i = 1;
        final int i2 = 0;
        if (this.gender == d.UNKNOWN) {
            breedId = this.breedId;
            if (breedId != null) {
                if (l.z(breedId)) {
                    birthday = i;
                } else {
                    birthday = i2;
                }
            } else {
            }
            if (birthday != 0) {
                customBreed = this.customBreed;
                if (customBreed != null) {
                    if (l.z(customBreed)) {
                        birthday = i;
                    } else {
                        birthday = i2;
                    }
                } else {
                }
                if (birthday != 0 && this.birthday == null && l.z(this.avatar)) {
                    if (this.birthday == null) {
                        if (l.z(this.avatar)) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof DogProfile == null) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (!n.b(this.avatar, object.avatar)) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.birthday, object.birthday)) {
            return i2;
        }
        if (!n.b(this.breedId, object.breedId)) {
            return i2;
        }
        if (!n.b(this.breedTitle, object.breedTitle)) {
            return i2;
        }
        if (!n.b(this.customBreed, object.customBreed)) {
            return i2;
        }
        if (!n.b(this.creatorId, object.creatorId)) {
            return i2;
        }
        if (!n.b(this.createTimeMs, object.createTimeMs)) {
            return i2;
        }
        if (this.gender != object.gender) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final Integer getAgeInMonths() {
        Integer valueOf;
        Long birthday;
        long currentTimeMillis;
        int i;
        long longValue;
        birthday = this.birthday;
        if (birthday != null) {
            i = 0;
            if (Long.compare(longValue2, i) <= 0) {
                valueOf = 0;
            } else {
                valueOf = Integer.valueOf(v2.Companion.d(System.currentTimeMillis(), i));
            }
        } else {
        }
        return valueOf;
    }

    @Override // android.os.Parcelable
    public final String getAvatar() {
        return this.avatar;
    }

    @Override // android.os.Parcelable
    public final Long getBirthday() {
        return this.birthday;
    }

    @Override // android.os.Parcelable
    public final String getBreedId() {
        return this.breedId;
    }

    @Override // android.os.Parcelable
    public final String getBreedTitle() {
        return this.breedTitle;
    }

    @Override // android.os.Parcelable
    public final Long getCreateTimeMs() {
        return this.createTimeMs;
    }

    @Override // android.os.Parcelable
    public final String getCreatorId() {
        return this.creatorId;
    }

    @Override // android.os.Parcelable
    public final String getCustomBreed() {
        return this.customBreed;
    }

    @Override // android.os.Parcelable
    public final d getGender() {
        return this.gender;
    }

    @Override // android.os.Parcelable
    public final String getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final Integer getInitialAgeInMonths() {
        Long birthday;
        int valueOf;
        long currentTimeMillis;
        int i2;
        int i;
        long longValue;
        birthday = this.birthday;
        if (birthday != null) {
            i = 0;
            if (Long.compare(longValue2, i) <= 0) {
                valueOf = 0;
            } else {
                Long createTimeMs = this.createTimeMs;
                if (createTimeMs == null) {
                    currentTimeMillis = System.currentTimeMillis();
                } else {
                    currentTimeMillis = createTimeMs.longValue();
                }
                valueOf = Integer.valueOf(g.b(v2.Companion.d(currentTimeMillis, i), 0));
            }
        } else {
        }
        return valueOf;
    }

    @Override // android.os.Parcelable
    public final String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i4;
        int i2;
        int i3;
        int i;
        Long birthday = this.birthday;
        i = 0;
        if (birthday == null) {
            i4 = i;
        } else {
            i4 = birthday.hashCode();
        }
        String breedId = this.breedId;
        if (breedId == null) {
            i2 = i;
        } else {
            i2 = breedId.hashCode();
        }
        String customBreed = this.customBreed;
        if (customBreed == null) {
            i3 = i;
        } else {
            i3 = customBreed.hashCode();
        }
        Long createTimeMs = this.createTimeMs;
        if (createTimeMs == null) {
        } else {
            i = createTimeMs.hashCode();
        }
        return i22 += i28;
    }

    @Override // android.os.Parcelable
    public final DogEntity toDogEntity(String string) {
        String format;
        Object birthday;
        long longValue;
        n.f(string, "parentId");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        if (this.birthday != null) {
            birthday = new Date(this.birthday.longValue(), obj3);
            format = simpleDateFormat.format(birthday);
        } else {
            format = 0;
        }
        super(this.id, this.creatorId, this.name, this.breedId, this.customBreed, format, Boolean.TRUE, this.gender.getTrackTag(), this.avatar, string, this.createTimeMs);
        return dogEntity;
    }

    @Override // android.os.Parcelable
    public final DogProfileModel toModel(String string) {
        String name;
        String avatar;
        boolean creatorId;
        String str;
        String str2;
        int i;
        n.f(string, "userId");
        int i3 = 0;
        str = l.z(this.name) ? i3 : name;
        str2 = l.z(this.avatar) ? i3 : avatar;
        i = l.z(this.creatorId) ? i3 : creatorId;
        super(str, str2, this.breedId, this.customBreed, this.birthday, i, this.gender.ordinal(), this.id, Double.valueOf(0), n.b(this.creatorId, string), this.createTimeMs);
        return dogProfileModel;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogProfile(name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", avatar=");
        stringBuilder.append(this.avatar);
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", birthday=");
        stringBuilder.append(this.birthday);
        stringBuilder.append(", breedId=");
        stringBuilder.append(this.breedId);
        stringBuilder.append(", breedTitle=");
        stringBuilder.append(this.breedTitle);
        stringBuilder.append(", customBreed=");
        stringBuilder.append(this.customBreed);
        stringBuilder.append(", creatorId=");
        stringBuilder.append(this.creatorId);
        stringBuilder.append(", createTimeMs=");
        stringBuilder.append(this.createTimeMs);
        stringBuilder.append(", gender=");
        stringBuilder.append(this.gender);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        long longValue;
        long longValue2;
        n.f(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.avatar);
        parcel.writeString(this.id);
        Long obj6 = this.birthday;
        longValue = 0;
        final int i = 1;
        if (obj6 == null) {
            parcel.writeInt(longValue);
        } else {
            parcel.writeInt(i);
            parcel.writeLong(obj6.longValue());
        }
        parcel.writeString(this.breedId);
        parcel.writeString(this.breedTitle);
        parcel.writeString(this.customBreed);
        parcel.writeString(this.creatorId);
        obj6 = this.createTimeMs;
        if (obj6 == null) {
            parcel.writeInt(longValue);
        } else {
            parcel.writeInt(i);
            parcel.writeLong(obj6.longValue());
        }
        parcel.writeString(this.gender.name());
    }
}
