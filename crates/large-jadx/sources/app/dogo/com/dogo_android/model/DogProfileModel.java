package app.dogo.com.dogo_android.model;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import app.dogo.com.dogo_android.k.d;
import app.dogo.com.dogo_android.k.d.a;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.service.v2.a;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* compiled from: DogProfileModel.kt */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u001b\n\u0002\u0018\u0002\n\u0002\u0008$\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0083\u0001\u0012\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0004\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0013J\u0011\u0010>\u001a\u00020\u000c2\u0006\u0010?\u001a\u00020\u0000H\u0096\u0002J\u000b\u0010@\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010A\u001a\u00020\u0011HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010C\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010G\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010H\u001a\u00020\u000cHÆ\u0003J\t\u0010I\u001a\u00020\u0004HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00108J\u008c\u0001\u0010K\u001a\u00020\u00002\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u00042\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010LJ\u001a\u0010M\u001a\u00020\u000c2\u0008\u0010N\u001a\u0004\u0018\u00010\u00042\u0008\u0010O\u001a\u0004\u0018\u00010\u0004J\t\u0010P\u001a\u00020\u000cHÖ\u0001J\u0013\u0010Q\u001a\u00020\u00112\u0008\u0010?\u001a\u0004\u0018\u00010RHÖ\u0003J\u0012\u0010S\u001a\u0004\u0018\u00010\u00042\u0006\u0010T\u001a\u00020\u000cH\u0002J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010U\u001a\u00020VJ\t\u0010W\u001a\u00020\u000cHÖ\u0001J\u000e\u0010X\u001a\u00020Y2\u0006\u0010\u000b\u001a\u00020-J\u000e\u0010Z\u001a\u00020Y2\u0006\u0010[\u001a\u00020\u0011J\t\u0010\\\u001a\u00020\u0004HÖ\u0001J\u0019\u0010]\u001a\u00020Y2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u000cHÖ\u0001R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000c8F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u001e\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010\u0018\"\u0004\u0008!\u0010\u001aR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\u0008\"\u0010\u001c\"\u0004\u0008#\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008$\u0010\u0018\"\u0004\u0008%\u0010\u001aR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008&\u0010\u0018\"\u0004\u0008'\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008(\u0010)\"\u0004\u0008*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010-8F¢\u0006\u0006\u001a\u0004\u0008.\u0010/R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00080\u0010\u0018\"\u0004\u00081\u0010\u001aR\u0013\u00102\u001a\u0004\u0018\u00010\u000c8F¢\u0006\u0006\u001a\u0004\u00083\u0010\u0016R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u00104\"\u0004\u00085\u00106R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\u00087\u00108\"\u0004\u00089\u0010:R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008<\u0010\u0018\"\u0004\u0008=\u0010\u001a¨\u0006a", d2 = {"Lapp/dogo/com/dogo_android/model/DogProfileModel;", "", "Landroid/os/Parcelable;", "name", "", "avatar", "breedId", "customBreed", "birthday", "", "creator", "gender", "", "id", "lastSession", "", "isOwner", "", "createTimeMs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Double;ZLjava/lang/Long;)V", "ageInMonths", "getAgeInMonths", "()Ljava/lang/Integer;", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getBirthday", "()Ljava/lang/Long;", "setBirthday", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getBreedId", "setBreedId", "getCreateTimeMs", "setCreateTimeMs", "getCreator", "setCreator", "getCustomBreed", "setCustomBreed", "getGender", "()I", "setGender", "(I)V", "genderEnum", "Lapp/dogo/com/dogo_android/enums/DogGender;", "getGenderEnum", "()Lapp/dogo/com/dogo_android/enums/DogGender;", "getId", "setId", "initialAgeInMonths", "getInitialAgeInMonths", "()Z", "setOwner", "(Z)V", "getLastSession", "()Ljava/lang/Double;", "setLastSession", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getName", "setName", "compareTo", "other", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Double;ZLjava/lang/Long;)Lapp/dogo/com/dogo_android/model/DogProfileModel;", "customCompare", "s1", "s2", "describeContents", "equals", "", "generateThumbnailUrl", "size", "resources", "Landroid/content/res/Resources;", "hashCode", "setGenderEnum", "", "setOwnerFlag", "ownerFlag", "toString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogProfileModel implements Comparable<DogProfileModel>, Parcelable {

    public static final Parcelable.Creator<DogProfileModel> CREATOR = new DogProfileModel$Creator<>();
    private String avatar;
    private Long birthday;
    private String breedId;
    private Long createTimeMs;
    private String creator;
    private String customBreed;
    private int gender;
    private String id;
    private boolean isOwner;
    private Double lastSession;
    private String name;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogProfileModel> {
        @Override // android.os.Parcelable$Creator
        public final DogProfileModel createFromParcel(Parcel parcel) {
            Long num2;
            Double num3;
            int i2 = 1;
            Long num;
            n.f(parcel, "parcel");
            int i = 0;
            if (parcel.readInt() == 0) {
            } else {
                num2 = Long.valueOf(parcel.readLong());
            }
            if (parcel.readInt() == 0) {
            } else {
                num3 = Double.valueOf(parcel.readDouble());
            }
            double d = parcel.readInt() != 0 ? 1 : 0;
            if (parcel.readInt() == 0) {
            } else {
            }
            DogProfileModel dogProfileModel = new DogProfileModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), num2, string, _int, string2, num3, i2, num);
            return dogProfileModel;
        }

        @Override // android.os.Parcelable$Creator
        public final DogProfileModel[] newArray(int i) {
            return new DogProfileModel[i];
        }
    }
    public DogProfileModel(String str, String str2, String str3, String str4, Long long, String str5, int i, String str6, Double double, boolean z, Long long2) {
        n.f(str6, "id");
        super();
        this.name = str;
        this.avatar = str2;
        this.breedId = str3;
        this.customBreed = str4;
        this.birthday = long;
        this.creator = str5;
        this.gender = i;
        this.id = str6;
        this.lastSession = double;
        this.isOwner = z;
        this.createTimeMs = long2;
    }

    private final String generateThumbnailUrl(int size) {
        String str3 = null;
        if (this.avatar != null) {
            n.d(this.avatar);
            StringBuilder stringBuilder = new StringBuilder();
            String str4 = "avatar_";
            String str5 = ".jpg";
            str2 = str4 + size + str5;
            boolean z = false;
            int i = 4;
            Object obj = null;
            str = "avatar.jpg";
            str3 = l.G(this.avatar, str, str2, z, i, obj);
        } else {
            int i2 = 0;
        }
        return str3;
    }

    public final int customCompare(String s1, String s2) {
        int i = 1;
        if (s1 == null) {
            return -1;
        }
        if (s2 != null) {
            i = l.t(s1, s2, true);
        }
        return i;
    }

    public final Integer getAgeInMonths() {
        Integer num = null;
        long l = 0;
        if (this.birthday != null) {
            n.d(this.birthday);
            long value = this.birthday.longValue();
            l = 0L;
            if (value <= l) {
                int i2 = 0;
            } else {
                n.d(this.birthday);
                l3 = (long)1000;
                l2 = this.birthday.longValue() * l3;
                num = Integer.valueOf(Utilities.Companion.d(System.currentTimeMillis(), l2));
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

    public final Long getCreateTimeMs() {
        return this.createTimeMs;
    }

    public final String getCreator() {
        return this.creator;
    }

    public final String getCustomBreed() {
        return this.customBreed;
    }

    public final int getGender() {
        return this.gender;
    }

    public final d getGenderEnum() {
        return DogGender.INSTANCE.genderIntToEnum(this.gender);
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getInitialAgeInMonths() {
        int i = 0;
        long value;
        long l = 0;
        if (this.birthday != null) {
            n.d(this.birthday);
            long value2 = this.birthday.longValue();
            l = 0L;
            if (value2 <= l) {
                i = 0;
            } else {
                if (this.createTimeMs == null) {
                    value = System.currentTimeMillis();
                } else {
                    value = this.createTimeMs.longValue();
                }
                n.d(this.birthday);
                l3 = (long)1000;
                l2 = this.birthday.longValue() * l3;
                int i2 = 0;
                Integer num = Integer.valueOf(g.b(Utilities.Companion.d(value, l2), i2));
            }
        }
        return i;
    }

    public final Double getLastSession() {
        return this.lastSession;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isOwner() {
        return this.isOwner;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setBirthday(Long long) {
        this.birthday = long;
    }

    public final void setBreedId(String str) {
        this.breedId = str;
    }

    public final void setCreateTimeMs(Long long) {
        this.createTimeMs = long;
    }

    public final void setCreator(String str) {
        this.creator = str;
    }

    public final void setCustomBreed(String str) {
        this.customBreed = str;
    }

    public final void setGender(int i) {
        this.gender = i;
    }

    public final void setGenderEnum(d gender) {
        n.f(gender, "gender");
        this.gender = gender.ordinal();
    }

    public final void setId(String str) {
        n.f(str, "<set-?>");
        this.id = str;
    }

    public final void setLastSession(Double double) {
        this.lastSession = double;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOwner(boolean z) {
        this.isOwner = z;
    }

    public final void setOwnerFlag(boolean ownerFlag) {
        this.isOwner = ownerFlag;
    }

    @Override // java.lang.Comparable
    /* operator */ public int compareTo(DogProfileModel other) {
        int customCompare;
        n.f(other, "other");
        if (customCompare(this.name, other.name) == 0) {
            customCompare = customCompare(this.id, other.id);
        }
        return customCompare;
    }

    public final String getAvatar(Resources resources) {
        String thumbnailUrl;
        n.f(resources, "resources");
        float f2 = (float)resources.getDisplayMetrics().widthPixels;
        if (f2 < 1131413504) {
            thumbnailUrl = generateThumbnailUrl(60);
        } else {
            if (f2 < 1135869952) {
                thumbnailUrl = generateThumbnailUrl(120);
            } else {
                float f = 720f;
                if (f2 < f) {
                    thumbnailUrl = generateThumbnailUrl(240);
                } else {
                    thumbnailUrl = generateThumbnailUrl(360);
                }
            }
        }
        return thumbnailUrl;
    }

    public /* synthetic */ DogProfileModel(String str, String str2, String str3, String str4, Long long, String str5, int i, String str6, Double double, boolean z, Long long2, int i2, kotlin.d0.d.g gVar) {
        int str52;
        int i72 = 0;
        String str82;
        int z102 = 1;
        int i122 = i2;
        str52 = 0;
        int r1 = i122 & 1 != 0 ? str52 : str;
        int r3 = i122 & 2 != 0 ? str52 : str2;
        int r4 = i122 & 4 != 0 ? str52 : str3;
        int r5 = i122 & 8 != 0 ? str52 : str4;
        int r6 = i122 & 16 != 0 ? str52 : long;
        int r7 = i122 & 32 != 0 ? str52 : str5;
        int r8 = i122 & 64 != 0 ? 0 : i;
        String r9 = i122 & 128 != 0 ? "" : str6;
        int r10 = i122 & 256 != 0 ? str52 : double;
        int r11 = i122 & 512 != 0 ? 1 : z;
        if (i122 & 1024 == 0) {
            str52 = long2;
        }
        this(str52, str52, str52, str52, str52, str52, i72, str82, str52, z102, str52);
    }


    public DogProfileModel() {
        this(null, null, null, null, null, null, 0, null, null, false, null, 2047, null);
    }

    public static /* synthetic */ DogProfileModel copy$default(DogProfileModel dogProfileModel, String str, String str2, String str3, String str4, Long long, String str5, int i, String str6, Double double, boolean z, Long long2, int i2, Object object) {
        Long long122;
        String str22;
        String str32;
        String str42;
        String str52;
        Long long62;
        String str72;
        int i82;
        String str92;
        Double double102;
        boolean z112;
        Object dogProfileModel2 = dogProfileModel;
        int i132 = i2;
        String r2 = i132 & 1 != 0 ? dogProfileModel2.name : str;
        String r3 = i132 & 2 != 0 ? dogProfileModel2.avatar : str2;
        String r4 = i132 & 4 != 0 ? dogProfileModel2.breedId : str3;
        String r5 = i132 & 8 != 0 ? dogProfileModel2.customBreed : str4;
        Long r6 = i132 & 16 != 0 ? dogProfileModel2.birthday : long;
        String r7 = i132 & 32 != 0 ? dogProfileModel2.creator : str5;
        int r8 = i132 & 64 != 0 ? dogProfileModel2.gender : i;
        String r9 = i132 & 128 != 0 ? dogProfileModel2.id : str6;
        Double r10 = i132 & 256 != 0 ? dogProfileModel2.lastSession : double;
        boolean r11 = i132 & 512 != 0 ? dogProfileModel2.isOwner : z;
        Long r1 = i132 & 1024 != 0 ? dogProfileModel2.createTimeMs : long2;
        return dogProfileModel.copy(str22, str32, str42, str52, long62, str72, i82, str92, double102, z112, (i132 & 1024 != 0 ? dogProfileModel2.createTimeMs : long2));
    }

    /* operator */ public final String component1() {
        return this.name;
    }

    /* operator */ public final boolean component10() {
        return this.isOwner;
    }

    /* operator */ public final Long component11() {
        return this.createTimeMs;
    }

    /* operator */ public final String component2() {
        return this.avatar;
    }

    /* operator */ public final String component3() {
        return this.breedId;
    }

    /* operator */ public final String component4() {
        return this.customBreed;
    }

    /* operator */ public final Long component5() {
        return this.birthday;
    }

    /* operator */ public final String component6() {
        return this.creator;
    }

    /* operator */ public final int component7() {
        return this.gender;
    }

    /* operator */ public final String component8() {
        return this.id;
    }

    /* operator */ public final Double component9() {
        return this.lastSession;
    }

    public final DogProfileModel copy(String name, String avatar, String breedId, String customBreed, Long birthday, String creator, int gender, String id, Double lastSession, boolean isOwner, Long createTimeMs) {
        final Object id2 = id;
        n.f(id2, "id");
        DogProfileModel dogProfileModel = new DogProfileModel(name, avatar, breedId, customBreed, birthday, creator, gender, id2, lastSession, isOwner, createTimeMs);
        return dogProfileModel;
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
        if (!(other instanceof DogProfileModel)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (!n.b(this.avatar, other.avatar)) {
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
        if (!n.b(this.creator, other.creator)) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.lastSession, other.lastSession)) {
            return false;
        }
        if (this.isOwner != other.isOwner) {
            return false;
        }
        return !n.b(this.createTimeMs, other.createTimeMs) ? z11 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        boolean isOwner2 = true;
        i = 0;
        if (this.name == null) {
        } else {
            i = this.name.hashCode();
        }
        if (this.avatar == null) {
        } else {
            i = this.avatar.hashCode();
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
        if (this.creator == null) {
        } else {
            i = this.creator.hashCode();
        }
        if (this.lastSession == null) {
        } else {
            i = this.lastSession.hashCode();
        }
        if (this.isOwner) {
            int i24 = 1;
        }
        if (this.createTimeMs != null) {
            i = this.createTimeMs.hashCode();
        }
        return (i * 31) + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + Integer.hashCode(this.gender) * 31 + this.id.hashCode() * 31 + i * 31 + isOwner2 * 31 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogProfileModel(name=";
        String str3 = ", avatar=";
        String str4 = ", breedId=";
        String str5 = ", customBreed=";
        String str6 = ", birthday=";
        String str7 = ", creator=";
        String str8 = ", gender=";
        String str9 = ", id=";
        String str10 = ", lastSession=";
        String str11 = ", isOwner=";
        String str12 = ", createTimeMs=";
        str = str2 + this.name + str3 + this.avatar + str4 + this.breedId + str5 + this.customBreed + str6 + this.birthday + str7 + this.creator + str8 + this.gender + str9 + this.id + str10 + this.lastSession + str11 + this.isOwner + str12 + this.createTimeMs + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        long value;
        n.f(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.avatar);
        parcel.writeString(this.breedId);
        parcel.writeString(this.customBreed);
        int i = 0;
        final int i2 = 1;
        if (this.birthday == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeLong(this.birthday.longValue());
        }
        parcel.writeString(this.creator);
        parcel.writeInt(this.gender);
        parcel.writeString(this.id);
        if (this.lastSession == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeDouble(this.lastSession.doubleValue());
        }
        parcel.writeInt(this.isOwner);
        if (this.createTimeMs == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeLong(this.createTimeMs.longValue());
        }
    }
}
