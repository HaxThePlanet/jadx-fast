package app.dogo.android.persistencedb.room.entity;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008!\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u0019J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008c\u0001\u0010,\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\n2\u0008\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000c\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\u0008\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0012R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0012¨\u00063", d2 = {"Lapp/dogo/android/persistencedb/room/entity/DogEntity;", "", "id", "", "creatorId", "name", "breedId", "customBreed", "birthday", "birthdayExact", "", "gender", "avatarUrl", "parentId", "createTimeMs", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getAvatarUrl", "()Ljava/lang/String;", "getBirthday", "getBirthdayExact", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBreedId", "getCreateTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCreatorId", "getCustomBreed", "getGender", "getId", "getName", "getParentId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lapp/dogo/android/persistencedb/room/entity/DogEntity;", "equals", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogEntity {

    private final String avatarUrl;
    private final String birthday;
    private final Boolean birthdayExact;
    private final String breedId;
    private final Long createTimeMs;
    private final String creatorId;
    private final String customBreed;
    private final String gender;
    private final String id;
    private final String name;
    private final String parentId;
    public DogEntity(String string, String string2, String string3, String string4, String string5, String string6, Boolean boolean7, String string8, String string9, String string10, Long long11) {
        n.f(string, "id");
        n.f(string2, "creatorId");
        n.f(string10, "parentId");
        super();
        this.id = string;
        this.creatorId = string2;
        this.name = string3;
        this.breedId = string4;
        this.customBreed = string5;
        this.birthday = string6;
        this.birthdayExact = boolean7;
        this.gender = string8;
        this.avatarUrl = string9;
        this.parentId = string10;
        this.createTimeMs = long11;
    }

    public DogEntity(String string, String string2, String string3, String string4, String string5, String string6, Boolean boolean7, String string8, String string9, String string10, Long long11, int i12, g g13) {
        Long valueOf;
        int i2;
        int i;
        int i6;
        int i7;
        int i3;
        int i4;
        int i5;
        Long num;
        int i8 = i12;
        final int i18 = 0;
        i2 = i8 & 4 != 0 ? i18 : string3;
        i = i8 & 8 != 0 ? i18 : string4;
        i6 = i8 & 16 != 0 ? i18 : string5;
        i7 = i8 & 32 != 0 ? i18 : string6;
        i3 = i8 & 64 != 0 ? i18 : boolean7;
        i4 = i8 & 128 != 0 ? i18 : string8;
        int i17 = i8 & 256;
        i5 = i17 != 0 ? i18 : string9;
        if (i8 &= 1024 != 0) {
            num = valueOf;
        } else {
            num = long11;
        }
        super(string, string2, i2, i, i6, i7, i3, i4, i5, string10, num);
    }

    public static app.dogo.android.persistencedb.room.entity.DogEntity copy$default(app.dogo.android.persistencedb.room.entity.DogEntity dogEntity, String string2, String string3, String string4, String string5, String string6, String string7, Boolean boolean8, String string9, String string10, String string11, Long long12, int i13, Object object14) {
        Long createTimeMs;
        String str;
        String creatorId;
        String name;
        String breedId;
        String customBreed;
        String birthday;
        Boolean birthdayExact;
        String gender;
        String avatarUrl;
        String parentId;
        Object obj = dogEntity;
        int i = i13;
        str = i & 1 != 0 ? obj.id : string2;
        creatorId = i & 2 != 0 ? obj.creatorId : string3;
        name = i & 4 != 0 ? obj.name : string4;
        breedId = i & 8 != 0 ? obj.breedId : string5;
        customBreed = i & 16 != 0 ? obj.customBreed : string6;
        birthday = i & 32 != 0 ? obj.birthday : string7;
        birthdayExact = i & 64 != 0 ? obj.birthdayExact : boolean8;
        gender = i & 128 != 0 ? obj.gender : string9;
        avatarUrl = i & 256 != 0 ? obj.avatarUrl : string10;
        parentId = i & 512 != 0 ? obj.parentId : string11;
        createTimeMs = i &= 1024 != 0 ? obj.createTimeMs : long12;
        return dogEntity.copy(str, creatorId, name, breedId, customBreed, birthday, birthdayExact, gender, avatarUrl, parentId, createTimeMs);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.parentId;
    }

    public final Long component11() {
        return this.createTimeMs;
    }

    public final String component2() {
        return this.creatorId;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.breedId;
    }

    public final String component5() {
        return this.customBreed;
    }

    public final String component6() {
        return this.birthday;
    }

    public final Boolean component7() {
        return this.birthdayExact;
    }

    public final String component8() {
        return this.gender;
    }

    public final String component9() {
        return this.avatarUrl;
    }

    public final app.dogo.android.persistencedb.room.entity.DogEntity copy(String string, String string2, String string3, String string4, String string5, String string6, Boolean boolean7, String string8, String string9, String string10, Long long11) {
        n.f(string, "id");
        n.f(string2, "creatorId");
        final Object obj = string10;
        n.f(obj, "parentId");
        super(string, string2, string3, string4, string5, string6, boolean7, string8, string9, obj, long11);
        return dogEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof DogEntity) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.creatorId, object.creatorId)) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
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
        if (!n.b(this.birthdayExact, object.birthdayExact)) {
            return i2;
        }
        if (!n.b(this.gender, object.gender)) {
            return i2;
        }
        if (!n.b(this.avatarUrl, object.avatarUrl)) {
            return i2;
        }
        if (!n.b(this.parentId, object.parentId)) {
            return i2;
        }
        if (!n.b(this.createTimeMs, object.createTimeMs)) {
            return i2;
        }
        return i;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getBirthday() {
        return this.birthday;
    }

    public final Boolean getBirthdayExact() {
        return this.birthdayExact;
    }

    public final String getBreedId() {
        return this.breedId;
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

    public final String getGender() {
        return this.gender;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public int hashCode() {
        int i5;
        int i7;
        int i;
        int i2;
        int i3;
        int i6;
        int i8;
        int i4;
        String name = this.name;
        i4 = 0;
        if (name == null) {
            i5 = i4;
        } else {
            i5 = name.hashCode();
        }
        String breedId = this.breedId;
        if (breedId == null) {
            i7 = i4;
        } else {
            i7 = breedId.hashCode();
        }
        String customBreed = this.customBreed;
        if (customBreed == null) {
            i = i4;
        } else {
            i = customBreed.hashCode();
        }
        String birthday = this.birthday;
        if (birthday == null) {
            i2 = i4;
        } else {
            i2 = birthday.hashCode();
        }
        Boolean birthdayExact = this.birthdayExact;
        if (birthdayExact == null) {
            i3 = i4;
        } else {
            i3 = birthdayExact.hashCode();
        }
        String gender = this.gender;
        if (gender == null) {
            i6 = i4;
        } else {
            i6 = gender.hashCode();
        }
        String avatarUrl = this.avatarUrl;
        if (avatarUrl == null) {
            i8 = i4;
        } else {
            i8 = avatarUrl.hashCode();
        }
        Long createTimeMs = this.createTimeMs;
        if (createTimeMs == null) {
        } else {
            i4 = createTimeMs.hashCode();
        }
        return i28 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogEntity(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", creatorId=");
        stringBuilder.append(this.creatorId);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", breedId=");
        stringBuilder.append(this.breedId);
        stringBuilder.append(", customBreed=");
        stringBuilder.append(this.customBreed);
        stringBuilder.append(", birthday=");
        stringBuilder.append(this.birthday);
        stringBuilder.append(", birthdayExact=");
        stringBuilder.append(this.birthdayExact);
        stringBuilder.append(", gender=");
        stringBuilder.append(this.gender);
        stringBuilder.append(", avatarUrl=");
        stringBuilder.append(this.avatarUrl);
        stringBuilder.append(", parentId=");
        stringBuilder.append(this.parentId);
        stringBuilder.append(", createTimeMs=");
        stringBuilder.append(this.createTimeMs);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
