package app.dogo.com.dogo_android.model;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.k.d;
import app.dogo.com.dogo_android.k.d.a;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.service.v2.a;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u001b\n\u0002\u0018\u0002\n\u0002\u0008$\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0083\u0001\u0012\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0004\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0013J\u0011\u0010>\u001a\u00020\u000c2\u0006\u0010?\u001a\u00020\u0000H\u0096\u0002J\u000b\u0010@\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010A\u001a\u00020\u0011HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010C\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010G\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010H\u001a\u00020\u000cHÆ\u0003J\t\u0010I\u001a\u00020\u0004HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00108J\u008c\u0001\u0010K\u001a\u00020\u00002\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t2\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u00042\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010LJ\u001a\u0010M\u001a\u00020\u000c2\u0008\u0010N\u001a\u0004\u0018\u00010\u00042\u0008\u0010O\u001a\u0004\u0018\u00010\u0004J\t\u0010P\u001a\u00020\u000cHÖ\u0001J\u0013\u0010Q\u001a\u00020\u00112\u0008\u0010?\u001a\u0004\u0018\u00010RHÖ\u0003J\u0012\u0010S\u001a\u0004\u0018\u00010\u00042\u0006\u0010T\u001a\u00020\u000cH\u0002J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010U\u001a\u00020VJ\t\u0010W\u001a\u00020\u000cHÖ\u0001J\u000e\u0010X\u001a\u00020Y2\u0006\u0010\u000b\u001a\u00020-J\u000e\u0010Z\u001a\u00020Y2\u0006\u0010[\u001a\u00020\u0011J\t\u0010\\\u001a\u00020\u0004HÖ\u0001J\u0019\u0010]\u001a\u00020Y2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\u000cHÖ\u0001R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000c8F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u001e\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010\u0018\"\u0004\u0008!\u0010\u001aR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\u0008\"\u0010\u001c\"\u0004\u0008#\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008$\u0010\u0018\"\u0004\u0008%\u0010\u001aR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008&\u0010\u0018\"\u0004\u0008'\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008(\u0010)\"\u0004\u0008*\u0010+R\u0013\u0010,\u001a\u0004\u0018\u00010-8F¢\u0006\u0006\u001a\u0004\u0008.\u0010/R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00080\u0010\u0018\"\u0004\u00081\u0010\u001aR\u0013\u00102\u001a\u0004\u0018\u00010\u000c8F¢\u0006\u0006\u001a\u0004\u00083\u0010\u0016R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u00104\"\u0004\u00085\u00106R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\u00087\u00108\"\u0004\u00089\u0010:R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008<\u0010\u0018\"\u0004\u0008=\u0010\u001a¨\u0006a", d2 = {"Lapp/dogo/com/dogo_android/model/DogProfileModel;", "", "Landroid/os/Parcelable;", "name", "", "avatar", "breedId", "customBreed", "birthday", "", "creator", "gender", "", "id", "lastSession", "", "isOwner", "", "createTimeMs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Double;ZLjava/lang/Long;)V", "ageInMonths", "getAgeInMonths", "()Ljava/lang/Integer;", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getBirthday", "()Ljava/lang/Long;", "setBirthday", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getBreedId", "setBreedId", "getCreateTimeMs", "setCreateTimeMs", "getCreator", "setCreator", "getCustomBreed", "setCustomBreed", "getGender", "()I", "setGender", "(I)V", "genderEnum", "Lapp/dogo/com/dogo_android/enums/DogGender;", "getGenderEnum", "()Lapp/dogo/com/dogo_android/enums/DogGender;", "getId", "setId", "initialAgeInMonths", "getInitialAgeInMonths", "()Z", "setOwner", "(Z)V", "getLastSession", "()Ljava/lang/Double;", "setLastSession", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getName", "setName", "compareTo", "other", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Double;ZLjava/lang/Long;)Lapp/dogo/com/dogo_android/model/DogProfileModel;", "customCompare", "s1", "s2", "describeContents", "equals", "", "generateThumbnailUrl", "size", "resources", "Landroid/content/res/Resources;", "hashCode", "setGenderEnum", "", "setOwnerFlag", "ownerFlag", "toString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogProfileModel implements Comparable<app.dogo.com.dogo_android.model.DogProfileModel>, Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.model.DogProfileModel> CREATOR;
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
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.model.DogProfileModel> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.model.DogProfileModel createFromParcel(Parcel parcel) {
            Object valueOf;
            Long valueOf2;
            long long;
            Double valueOf3;
            int i;
            Long num;
            n.f(parcel, "parcel");
            int i2 = 0;
            if (parcel.readInt() == 0) {
                valueOf2 = i2;
            } else {
                valueOf2 = Long.valueOf(parcel.readLong());
            }
            if (parcel.readInt() == 0) {
                valueOf3 = i2;
            } else {
                valueOf3 = Double.valueOf(parcel.readDouble());
            }
            i = parcel.readInt() != 0 ? 1 : 0;
            if (parcel.readInt() == 0) {
                num = i2;
            } else {
                num = valueOf;
            }
            super(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), valueOf2, parcel.readString(), parcel.readInt(), parcel.readString(), valueOf3, i, num);
            return dogProfileModel;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.model.DogProfileModel[] newArray(int i) {
            return new DogProfileModel[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        DogProfileModel.Creator creator = new DogProfileModel.Creator();
        DogProfileModel.CREATOR = creator;
    }

    public DogProfileModel() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2047, 0);
    }

    public DogProfileModel(String string, String string2, String string3, String string4, Long long5, String string6, int i7, String string8, Double double9, boolean z10, Long long11) {
        n.f(string8, "id");
        super();
        this.name = string;
        this.avatar = string2;
        this.breedId = string3;
        this.customBreed = string4;
        this.birthday = long5;
        this.creator = string6;
        this.gender = i7;
        this.id = string8;
        this.lastSession = double9;
        this.isOwner = z10;
        this.createTimeMs = long11;
    }

    public DogProfileModel(String string, String string2, String string3, String string4, Long long5, String string6, int i7, String string8, Double double9, boolean z10, Long long11, int i12, g g13) {
        int i4;
        int i5;
        int i3;
        int i6;
        int i10;
        int i9;
        int i;
        int i11;
        String str;
        int i2;
        int i8;
        int i13 = i12;
        i5 = 0;
        i4 = i13 & 1 != 0 ? i5 : string;
        i3 = i13 & 2 != 0 ? i5 : string2;
        i6 = i13 & 4 != 0 ? i5 : string3;
        i10 = i13 & 8 != 0 ? i5 : string4;
        i9 = i13 & 16 != 0 ? i5 : long5;
        i = i13 & 32 != 0 ? i5 : string6;
        i11 = i13 & 64 != 0 ? 0 : i7;
        str = i13 & 128 != 0 ? "" : string8;
        i2 = i13 & 256 != 0 ? i5 : double9;
        i8 = i13 & 512 != 0 ? 1 : z10;
        if (i13 &= 1024 != 0) {
        } else {
            i5 = long11;
        }
        super(i4, i3, i6, i10, i9, i, i11, str, i2, i8, i5);
    }

    public static app.dogo.com.dogo_android.model.DogProfileModel copy$default(app.dogo.com.dogo_android.model.DogProfileModel dogProfileModel, String string2, String string3, String string4, String string5, Long long6, String string7, int i8, String string9, Double double10, boolean z11, Long long12, int i13, Object object14) {
        Long createTimeMs;
        String name;
        String avatar;
        String breedId;
        String customBreed;
        Long birthday;
        String creator;
        int gender;
        String str;
        Double lastSession;
        boolean isOwner;
        Object obj = dogProfileModel;
        int i = i13;
        name = i & 1 != 0 ? obj.name : string2;
        avatar = i & 2 != 0 ? obj.avatar : string3;
        breedId = i & 4 != 0 ? obj.breedId : string4;
        customBreed = i & 8 != 0 ? obj.customBreed : string5;
        birthday = i & 16 != 0 ? obj.birthday : long6;
        creator = i & 32 != 0 ? obj.creator : string7;
        gender = i & 64 != 0 ? obj.gender : i8;
        str = i & 128 != 0 ? obj.id : string9;
        lastSession = i & 256 != 0 ? obj.lastSession : double10;
        isOwner = i & 512 != 0 ? obj.isOwner : z11;
        createTimeMs = i &= 1024 != 0 ? obj.createTimeMs : long12;
        return dogProfileModel.copy(name, avatar, breedId, customBreed, birthday, creator, gender, str, lastSession, isOwner, createTimeMs);
    }

    private final String generateThumbnailUrl(int i) {
        String str;
        String string;
        int i4;
        int i3;
        int i2;
        String obj7;
        final String avatar = this.avatar;
        if (avatar != null) {
            n.d(avatar);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("avatar_");
            stringBuilder.append(i);
            stringBuilder.append(".jpg");
            obj7 = l.G(avatar, "avatar.jpg", stringBuilder.toString(), false, 4, 0);
        } else {
            obj7 = 0;
        }
        return obj7;
    }

    @Override // java.lang.Comparable
    public int compareTo(app.dogo.com.dogo_android.model.DogProfileModel dogProfileModel) {
        int customCompare;
        Object obj3;
        n.f(dogProfileModel, "other");
        if (customCompare(this.name, dogProfileModel.name) == null) {
            customCompare = customCompare(this.id, dogProfileModel.id);
        }
        return customCompare;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return compareTo((DogProfileModel)object);
    }

    @Override // java.lang.Comparable
    public final String component1() {
        return this.name;
    }

    @Override // java.lang.Comparable
    public final boolean component10() {
        return this.isOwner;
    }

    @Override // java.lang.Comparable
    public final Long component11() {
        return this.createTimeMs;
    }

    @Override // java.lang.Comparable
    public final String component2() {
        return this.avatar;
    }

    @Override // java.lang.Comparable
    public final String component3() {
        return this.breedId;
    }

    @Override // java.lang.Comparable
    public final String component4() {
        return this.customBreed;
    }

    @Override // java.lang.Comparable
    public final Long component5() {
        return this.birthday;
    }

    @Override // java.lang.Comparable
    public final String component6() {
        return this.creator;
    }

    @Override // java.lang.Comparable
    public final int component7() {
        return this.gender;
    }

    @Override // java.lang.Comparable
    public final String component8() {
        return this.id;
    }

    @Override // java.lang.Comparable
    public final Double component9() {
        return this.lastSession;
    }

    @Override // java.lang.Comparable
    public final app.dogo.com.dogo_android.model.DogProfileModel copy(String string, String string2, String string3, String string4, Long long5, String string6, int i7, String string8, Double double9, boolean z10, Long long11) {
        final Object obj = string8;
        n.f(obj, "id");
        super(string, string2, string3, string4, long5, string6, i7, obj, double9, z10, long11);
        return dogProfileModel;
    }

    @Override // java.lang.Comparable
    public final int customCompare(String string, String string2) {
        int i;
        if (string == null) {
            return -1;
        }
        if (string2 == null) {
        } else {
            i = l.t(string, string2, true);
        }
        return i;
    }

    @Override // java.lang.Comparable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof DogProfileModel == null) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (!n.b(this.avatar, object.avatar)) {
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
        if (!n.b(this.creator, object.creator)) {
            return i2;
        }
        if (this.gender != object.gender) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.lastSession, object.lastSession)) {
            return i2;
        }
        if (this.isOwner != object.isOwner) {
            return i2;
        }
        if (!n.b(this.createTimeMs, object.createTimeMs)) {
            return i2;
        }
        return i;
    }

    @Override // java.lang.Comparable
    public final Integer getAgeInMonths() {
        Integer valueOf;
        Long birthday;
        long currentTimeMillis;
        int i2;
        int i;
        long l;
        birthday = this.birthday;
        if (birthday != null) {
            n.d(birthday);
            i2 = 0;
            if (Long.compare(longValue, i2) <= 0) {
                valueOf = 0;
            } else {
                Long birthday2 = this.birthday;
                n.d(birthday2);
                valueOf = Integer.valueOf(v2.Companion.d(System.currentTimeMillis(), i2));
            }
        } else {
        }
        return valueOf;
    }

    @Override // java.lang.Comparable
    public final String getAvatar() {
        return this.avatar;
    }

    @Override // java.lang.Comparable
    public final String getAvatar(Resources resources) {
        int cmp;
        String obj2;
        n.f(resources, "resources");
        obj2 = (float)obj2;
        if (Float.compare(obj2, i) < 0) {
            obj2 = generateThumbnailUrl(60);
        } else {
            if (Float.compare(obj2, i2) < 0) {
                obj2 = generateThumbnailUrl(120);
            } else {
                if (Float.compare(obj2, cmp) < 0) {
                    obj2 = generateThumbnailUrl(240);
                } else {
                    obj2 = generateThumbnailUrl(360);
                }
            }
        }
        return obj2;
    }

    @Override // java.lang.Comparable
    public final Long getBirthday() {
        return this.birthday;
    }

    @Override // java.lang.Comparable
    public final String getBreedId() {
        return this.breedId;
    }

    @Override // java.lang.Comparable
    public final Long getCreateTimeMs() {
        return this.createTimeMs;
    }

    @Override // java.lang.Comparable
    public final String getCreator() {
        return this.creator;
    }

    @Override // java.lang.Comparable
    public final String getCustomBreed() {
        return this.customBreed;
    }

    @Override // java.lang.Comparable
    public final int getGender() {
        return this.gender;
    }

    @Override // java.lang.Comparable
    public final d getGenderEnum() {
        return d.Companion.b(this.gender);
    }

    @Override // java.lang.Comparable
    public final String getId() {
        return this.id;
    }

    @Override // java.lang.Comparable
    public final Integer getInitialAgeInMonths() {
        Long birthday;
        int valueOf;
        long currentTimeMillis;
        int i3;
        int i;
        int i2;
        long l;
        birthday = this.birthday;
        if (birthday != null) {
            n.d(birthday);
            i = 0;
            if (Long.compare(longValue, i) <= 0) {
                valueOf = 0;
            } else {
                Long createTimeMs = this.createTimeMs;
                if (createTimeMs == null) {
                    currentTimeMillis = System.currentTimeMillis();
                } else {
                    currentTimeMillis = createTimeMs.longValue();
                }
                Long birthday2 = this.birthday;
                n.d(birthday2);
                valueOf = Integer.valueOf(g.b(v2.Companion.d(currentTimeMillis, i), 0));
            }
        } else {
        }
        return valueOf;
    }

    @Override // java.lang.Comparable
    public final Double getLastSession() {
        return this.lastSession;
    }

    @Override // java.lang.Comparable
    public final String getName() {
        return this.name;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        int i6;
        int i;
        int i8;
        int i2;
        int i7;
        int i5;
        int i3;
        int i4;
        boolean isOwner;
        String name = this.name;
        i = 0;
        if (name == null) {
            i6 = i;
        } else {
            i6 = name.hashCode();
        }
        String avatar = this.avatar;
        if (avatar == null) {
            i8 = i;
        } else {
            i8 = avatar.hashCode();
        }
        String breedId = this.breedId;
        if (breedId == null) {
            i2 = i;
        } else {
            i2 = breedId.hashCode();
        }
        String customBreed = this.customBreed;
        if (customBreed == null) {
            i7 = i;
        } else {
            i7 = customBreed.hashCode();
        }
        Long birthday = this.birthday;
        if (birthday == null) {
            i5 = i;
        } else {
            i5 = birthday.hashCode();
        }
        String creator = this.creator;
        if (creator == null) {
            i3 = i;
        } else {
            i3 = creator.hashCode();
        }
        Double lastSession = this.lastSession;
        if (lastSession == null) {
            i4 = i;
        } else {
            i4 = lastSession.hashCode();
        }
        if (this.isOwner) {
            isOwner = 1;
        }
        Long createTimeMs = this.createTimeMs;
        if (createTimeMs == null) {
        } else {
            i = createTimeMs.hashCode();
        }
        return i27 += i;
    }

    @Override // java.lang.Comparable
    public final boolean isOwner() {
        return this.isOwner;
    }

    @Override // java.lang.Comparable
    public final void setAvatar(String string) {
        this.avatar = string;
    }

    @Override // java.lang.Comparable
    public final void setBirthday(Long long) {
        this.birthday = long;
    }

    @Override // java.lang.Comparable
    public final void setBreedId(String string) {
        this.breedId = string;
    }

    @Override // java.lang.Comparable
    public final void setCreateTimeMs(Long long) {
        this.createTimeMs = long;
    }

    @Override // java.lang.Comparable
    public final void setCreator(String string) {
        this.creator = string;
    }

    @Override // java.lang.Comparable
    public final void setCustomBreed(String string) {
        this.customBreed = string;
    }

    @Override // java.lang.Comparable
    public final void setGender(int i) {
        this.gender = i;
    }

    @Override // java.lang.Comparable
    public final void setGenderEnum(d d) {
        n.f(d, "gender");
        this.gender = d.ordinal();
    }

    @Override // java.lang.Comparable
    public final void setId(String string) {
        n.f(string, "<set-?>");
        this.id = string;
    }

    @Override // java.lang.Comparable
    public final void setLastSession(Double double) {
        this.lastSession = double;
    }

    @Override // java.lang.Comparable
    public final void setName(String string) {
        this.name = string;
    }

    @Override // java.lang.Comparable
    public final void setOwner(boolean z) {
        this.isOwner = z;
    }

    @Override // java.lang.Comparable
    public final void setOwnerFlag(boolean z) {
        this.isOwner = z;
    }

    @Override // java.lang.Comparable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogProfileModel(name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", avatar=");
        stringBuilder.append(this.avatar);
        stringBuilder.append(", breedId=");
        stringBuilder.append(this.breedId);
        stringBuilder.append(", customBreed=");
        stringBuilder.append(this.customBreed);
        stringBuilder.append(", birthday=");
        stringBuilder.append(this.birthday);
        stringBuilder.append(", creator=");
        stringBuilder.append(this.creator);
        stringBuilder.append(", gender=");
        stringBuilder.append(this.gender);
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", lastSession=");
        stringBuilder.append(this.lastSession);
        stringBuilder.append(", isOwner=");
        stringBuilder.append(this.isOwner);
        stringBuilder.append(", createTimeMs=");
        stringBuilder.append(this.createTimeMs);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // java.lang.Comparable
    public void writeToParcel(Parcel parcel, int i2) {
        int longValue;
        long doubleValue;
        n.f(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.avatar);
        parcel.writeString(this.breedId);
        parcel.writeString(this.customBreed);
        Long obj6 = this.birthday;
        longValue = 0;
        final int i = 1;
        if (obj6 == null) {
            parcel.writeInt(longValue);
        } else {
            parcel.writeInt(i);
            parcel.writeLong(obj6.longValue());
        }
        parcel.writeString(this.creator);
        parcel.writeInt(this.gender);
        parcel.writeString(this.id);
        obj6 = this.lastSession;
        if (obj6 == null) {
            parcel.writeInt(longValue);
        } else {
            parcel.writeInt(i);
            parcel.writeDouble(obj6.doubleValue());
        }
        parcel.writeInt(this.isOwner);
        obj6 = this.createTimeMs;
        if (obj6 == null) {
            parcel.writeInt(longValue);
        } else {
            parcel.writeInt(i);
            parcel.writeLong(obj6.longValue());
        }
    }
}
