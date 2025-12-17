package app.dogo.com.dogo_android.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.android.persistencedb.room.entity.ReminderEntity;
import com.google.firebase.database.Exclude;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.h;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010$\n\u0002\u0008\u001b\n\u0002\u0010\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 P2\u00020\u0001:\u0001PB\u0085\u0001\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\u0008\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0004\u0012\u0016\u0008\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0008J\u000f\u0010.\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\t\u00105\u001a\u00020\u0004HÆ\u0003J\u0017\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010HÆ\u0003J\u0089\u0001\u00107\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0014\u0008\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u00062\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00072\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\r\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00042\u0016\u0008\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010HÆ\u0001J\t\u00108\u001a\u00020\u0008HÖ\u0001J\u0013\u00109\u001a\u00020\u00042\u0008\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0008H\u0002J\u000e\u0010>\u001a\u0008\u0012\u0004\u0012\u00020\u00070?H\u0007J\u000f\u0010@\u001a\u0004\u0018\u00010\u0008H\u0007¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010?H\u0007J\t\u0010C\u001a\u00020\u0008HÖ\u0001J\u0006\u0010D\u001a\u00020\u0004J\u0016\u0010E\u001a\u00020,2\u0006\u0010F\u001a\u00020\u00082\u0006\u0010G\u001a\u00020\u0008J\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0007H\u0007J\t\u0010K\u001a\u00020\u0007HÖ\u0001J\u0019\u0010L\u001a\u00020,2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0008HÖ\u0001R \u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b\"\u0004\u0008\u001c\u0010\u001dR\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u001e\"\u0004\u0008\u001f\u0010 R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\u001b\"\u0004\u0008\"\u0010\u001dR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008#\u0010\u001b\"\u0004\u0008$\u0010\u001dR\u001c\u0010\u000c\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010\u001b\"\u0004\u0008&\u0010\u001dR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008'\u0010\u001b\"\u0004\u0008(\u0010\u001dR&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008)\u0010\u0017\"\u0004\u0008*\u0010\u0019¨\u0006Q", d2 = {"Lapp/dogo/com/dogo_android/model/RemindersModel;", "Landroid/os/Parcelable;", "days", "", "", "users", "", "", "", "name", "id", "type", "time", "repeating", "isActive", "dogs", "", "(Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;)V", "getDays", "()Ljava/util/List;", "setDays", "(Ljava/util/List;)V", "getDogs", "()Ljava/util/Map;", "setDogs", "(Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "()Z", "setActive", "(Z)V", "getName", "setName", "getRepeating", "setRepeating", "getTime", "setTime", "getType", "setType", "getUsers", "setUsers", "addUsers", "", "uid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "getDoubleDigitReminder", "hoursReminder", "getReminderShortWeekdayStrings", "", "getReminderTimeInMinutes", "()Ljava/lang/Integer;", "getReminderWeekdayStrings", "hashCode", "isEmpty", "setTimeWithInt", "hours", "minutes", "toEntity", "Lapp/dogo/android/persistencedb/room/entity/ReminderEntity;", "userId", "toString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RemindersModel implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.model.RemindersModel> CREATOR = null;
    public static final app.dogo.com.dogo_android.model.RemindersModel.Companion Companion = null;
    public static final String TRAINING_REMINDER_ID = "training_reminder";
    private List<Boolean> days;
    private Map<String, Boolean> dogs;
    private String id;
    private boolean isActive;
    private String name;
    private String repeating;
    private String time;
    private String type;
    private Map<String, Integer> users;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/model/RemindersModel$Companion;", "", "()V", "TRAINING_REMINDER_ID", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.model.RemindersModel> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.model.RemindersModel createFromParcel(Parcel parcel) {
            Object obj;
            int i4;
            Boolean valueOf3;
            int i;
            int int;
            int i3;
            String string2;
            Integer valueOf;
            int i6;
            int int2;
            LinkedHashMap linkedHashMap;
            int i2;
            String string;
            Boolean valueOf2;
            int i5;
            n.f(parcel, "parcel");
            int int3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(int3);
            int i7 = 0;
            i4 = i7;
            i = 1;
            while (i4 != int3) {
                if (parcel.readInt() != 0) {
                } else {
                }
                i = i7;
                arrayList.add(Boolean.valueOf(i));
                i4++;
                i = 1;
            }
            int int4 = parcel.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(int4);
            i3 = i7;
            while (i3 != int4) {
                linkedHashMap2.put(parcel.readString(), Integer.valueOf(parcel.readInt()));
                i3++;
            }
            i6 = parcel.readInt() != 0 ? i : i7;
            if (parcel.readInt() == 0) {
                linkedHashMap = obj;
            } else {
                int2 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(int2);
                i2 = i7;
                while (i2 != int2) {
                    if (parcel.readInt() != 0) {
                    } else {
                    }
                    i5 = i7;
                    linkedHashMap.put(parcel.readString(), Boolean.valueOf(i5));
                    i2++;
                    i5 = i;
                }
            }
            super(arrayList, linkedHashMap2, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), i6, linkedHashMap);
            return remindersModel2;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.model.RemindersModel[] newArray(int i) {
            return new RemindersModel[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        RemindersModel.Companion companion = new RemindersModel.Companion(0);
        RemindersModel.Companion = companion;
        RemindersModel.Creator creator = new RemindersModel.Creator();
        RemindersModel.CREATOR = creator;
    }

    public RemindersModel() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 511, 0);
    }

    public RemindersModel(List<Boolean> list, Map<String, Integer> map2, String string3, String string4, String string5, String string6, String string7, boolean z8, Map<String, Boolean> map9) {
        int obj2;
        int obj3;
        String obj4;
        String obj5;
        n.f(list, "days");
        n.f(map2, "users");
        n.f(string5, "type");
        n.f(string7, "repeating");
        super();
        this.days = list;
        this.users = map2;
        this.name = string3;
        this.id = string4;
        this.type = string5;
        this.time = string6;
        this.repeating = string7;
        this.isActive = z8;
        this.dogs = map9;
        if (list.size() < 7) {
            obj2 = 0;
            obj3 = obj2 + 1;
            this.days.add(obj2, Boolean.TRUE);
            while (obj3 > 6) {
                obj2 = obj3;
                obj3 = obj2 + 1;
                this.days.add(obj2, Boolean.TRUE);
            }
        }
    }

    public RemindersModel(List list, Map map2, String string3, String string4, String string5, String string6, String string7, boolean z8, Map map9, int i10, g g11) {
        ArrayList arrayList;
        HashMap hashMap;
        int i2;
        int i5;
        int i;
        String str;
        String str2;
        int i3;
        int i4;
        int i6 = i10;
        if (i6 & 1 != 0) {
            arrayList = new ArrayList();
        } else {
            arrayList = list;
        }
        if (i6 & 2 != 0) {
            hashMap = new HashMap();
        } else {
            hashMap = map2;
        }
        i5 = 0;
        i2 = i6 & 4 != 0 ? i5 : string3;
        i = i6 & 8 != 0 ? i5 : string4;
        str = i6 & 16 != 0 ? str2 : string5;
        i3 = i6 & 32 != 0 ? i5 : string6;
        if (i6 & 64 != 0) {
        } else {
            str2 = string7;
        }
        i4 = i6 & 128 != 0 ? 0 : z8;
        if (i6 &= 256 != 0) {
        } else {
            i5 = map9;
        }
        super(arrayList, hashMap, i2, i, str, i3, str2, i4, i5);
    }

    public static app.dogo.com.dogo_android.model.RemindersModel copy$default(app.dogo.com.dogo_android.model.RemindersModel remindersModel, List list2, Map map3, String string4, String string5, String string6, String string7, String string8, boolean z9, Map map10, int i11, Object object12) {
        Map dogs;
        List days;
        Map users;
        String name;
        String str;
        String type;
        String time;
        String repeating;
        boolean isActive;
        Object obj = remindersModel;
        int i = i11;
        days = i & 1 != 0 ? obj.days : list2;
        users = i & 2 != 0 ? obj.users : map3;
        name = i & 4 != 0 ? obj.name : string4;
        str = i & 8 != 0 ? obj.id : string5;
        type = i & 16 != 0 ? obj.type : string6;
        time = i & 32 != 0 ? obj.time : string7;
        repeating = i & 64 != 0 ? obj.repeating : string8;
        isActive = i & 128 != 0 ? obj.isActive : z9;
        dogs = i &= 256 != 0 ? obj.dogs : map10;
        return remindersModel.copy(days, users, name, str, type, time, repeating, isActive, dogs);
    }

    private final String getDoubleDigitReminder(int i) {
        String str;
        String obj2;
        if (i < 10) {
            obj2 = n.o("0", Integer.valueOf(i));
        } else {
            obj2 = String.valueOf(i);
        }
        return obj2;
    }

    @Override // android.os.Parcelable
    public final void addUsers(String string, int i2) {
        n.f(string, "uid");
        this.users.put(string, Integer.valueOf(i2));
    }

    public final List<Boolean> component1() {
        return this.days;
    }

    public final Map<String, Integer> component2() {
        return this.users;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String component5() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public final String component6() {
        return this.time;
    }

    @Override // android.os.Parcelable
    public final String component7() {
        return this.repeating;
    }

    @Override // android.os.Parcelable
    public final boolean component8() {
        return this.isActive;
    }

    public final Map<String, Boolean> component9() {
        return this.dogs;
    }

    public final app.dogo.com.dogo_android.model.RemindersModel copy(List<Boolean> list, Map<String, Integer> map2, String string3, String string4, String string5, String string6, String string7, boolean z8, Map<String, Boolean> map9) {
        n.f(list, "days");
        n.f(map2, "users");
        final Object obj = string5;
        n.f(obj, "type");
        final Object obj2 = string7;
        n.f(obj2, "repeating");
        super(list, map2, string3, string4, obj, string6, obj2, z8, map9);
        return remindersModel;
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
        if (!object instanceof RemindersModel) {
            return i2;
        }
        if (!n.b(this.days, object.days)) {
            return i2;
        }
        if (!n.b(this.users, object.users)) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.type, object.type)) {
            return i2;
        }
        if (!n.b(this.time, object.time)) {
            return i2;
        }
        if (!n.b(this.repeating, object.repeating)) {
            return i2;
        }
        if (this.isActive != object.isActive) {
            return i2;
        }
        if (!n.b(this.dogs, object.dogs)) {
            return i2;
        }
        return i;
    }

    public final List<Boolean> getDays() {
        return this.days;
    }

    public final Map<String, Boolean> getDogs() {
        return this.dogs;
    }

    @Override // android.os.Parcelable
    public final String getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String getName() {
        return this.name;
    }

    @Exclude
    public final List<String> getReminderShortWeekdayStrings() {
        List list;
        int arrayList;
        int i2;
        boolean booleanValue;
        int i;
        int str;
        if (this.days.size() != 7) {
            list = p.g();
        } else {
            List days2 = this.days;
            arrayList = new ArrayList(p.r(days2, 10));
            i2 = 0;
            Iterator iterator = days2.iterator();
            for (Object next : iterator) {
                if ((Boolean)next.booleanValue()) {
                }
                arrayList.add(str);
                i2 = i;
                str = "sun";
                str = "sat";
                str = "fri";
                str = "thu";
                str = "wed";
                str = "tue";
                str = "mon";
            }
            list = p.U(arrayList);
        }
        return list;
    }

    @Exclude
    public final Integer getReminderTimeInMinutes() {
        Object[] array;
        String time;
        int valueOf;
        Object hVar;
        String length;
        int i8;
        int i4;
        int i7;
        int i11;
        int i5;
        int i2;
        int i10;
        int i9;
        int i;
        int i3;
        int i6;
        time = this.time;
        final int i14 = 0;
        if (time == null) {
            array = valueOf;
        } else {
        }
        int i15 = 1;
        if (array == null) {
            i8 = i14;
        } else {
        }
        if (i8 != 0) {
            Object obj2 = array[i14];
            length2 -= i15;
            i2 = i5;
            i9 = 32;
            while (i5 <= i4) {
                if (i2 == 0) {
                } else {
                }
                i6 = i4;
                if (n.h(obj2.charAt(i6), i9) <= 0) {
                } else {
                }
                i = i14;
                if (i2 != 0) {
                    break;
                } else {
                }
                if (i == 0) {
                    break;
                } else {
                }
                i4--;
                i9 = 32;
                if (i == 0) {
                } else {
                }
                i5++;
                i2 = i15;
                i = i15;
                i6 = i5;
            }
            Object obj = array[i15];
            length3 -= i15;
            i10 = i11;
            while (i11 <= i7) {
                if (i10 == 0) {
                } else {
                }
                i3 = i7;
                if (n.h(obj.charAt(i3), i9) <= 0) {
                } else {
                }
                i = i14;
                if (i10 != 0) {
                    break;
                } else {
                }
                if (i == 0) {
                    break;
                } else {
                }
                i7--;
                if (i == 0) {
                } else {
                }
                i11++;
                i10 = i15;
                i = i15;
                i3 = i11;
            }
            valueOf = Integer.valueOf(i12 += array);
        }
        return valueOf;
    }

    @Exclude
    public final List<String> getReminderWeekdayStrings() {
        int iterator;
        int i3;
        int arrayList;
        int i;
        String str;
        boolean booleanValue;
        int i2;
        i3 = 0;
        if (this.days.size() != 7) {
        } else {
            List days2 = this.days;
            arrayList = new ArrayList(p.r(days2, 10));
            i = 0;
            iterator = days2.iterator();
            for (Object next : iterator) {
                if ((Boolean)next.booleanValue()) {
                } else {
                }
                str = i3;
                arrayList.add(str);
                i = i2;
                str = "sunday";
                str = "saturday";
                str = "friday";
                str = "thursday";
                str = "wednesday";
                str = "tuesday";
                str = "monday";
            }
            i3 = p.U(arrayList);
        }
        return i3;
    }

    @Override // android.os.Parcelable
    public final String getRepeating() {
        return this.repeating;
    }

    @Override // android.os.Parcelable
    public final String getTime() {
        return this.time;
    }

    @Override // android.os.Parcelable
    public final String getType() {
        return this.type;
    }

    public final Map<String, Integer> getUsers() {
        return this.users;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i3;
        int i2;
        int i4;
        boolean isActive;
        int i;
        String name = this.name;
        i = 0;
        if (name == null) {
            i3 = i;
        } else {
            i3 = name.hashCode();
        }
        String str = this.id;
        if (str == null) {
            i2 = i;
        } else {
            i2 = str.hashCode();
        }
        String time = this.time;
        if (time == null) {
            i4 = i;
        } else {
            i4 = time.hashCode();
        }
        if (this.isActive) {
            isActive = 1;
        }
        Map dogs = this.dogs;
        if (dogs == null) {
        } else {
            i = dogs.hashCode();
        }
        return i20 += i;
    }

    @Override // android.os.Parcelable
    public final boolean isActive() {
        return this.isActive;
    }

    @Override // android.os.Parcelable
    public final boolean isEmpty() {
        int i;
        i = this.id == null ? 1 : 0;
        return i;
    }

    @Override // android.os.Parcelable
    public final void setActive(boolean z) {
        this.isActive = z;
    }

    public final void setDays(List<Boolean> list) {
        n.f(list, "<set-?>");
        this.days = list;
    }

    public final void setDogs(Map<String, Boolean> map) {
        this.dogs = map;
    }

    @Override // android.os.Parcelable
    public final void setId(String string) {
        this.id = string;
    }

    @Override // android.os.Parcelable
    public final void setName(String string) {
        this.name = string;
    }

    @Override // android.os.Parcelable
    public final void setRepeating(String string) {
        n.f(string, "<set-?>");
        this.repeating = string;
    }

    @Override // android.os.Parcelable
    public final void setTime(String string) {
        this.time = string;
    }

    @Override // android.os.Parcelable
    public final void setTimeWithInt(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getDoubleDigitReminder(i %= 24));
        stringBuilder.append(':');
        stringBuilder.append(getDoubleDigitReminder(i2 %= 60));
        this.time = stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public final void setType(String string) {
        n.f(string, "<set-?>");
        this.type = string;
    }

    public final void setUsers(Map<String, Integer> map) {
        n.f(map, "<set-?>");
        this.users = map;
    }

    @Exclude
    public final ReminderEntity toEntity(String string) {
        String time;
        String str2;
        String str;
        n.f(string, "userId");
        String str4 = this.id;
        String str5 = "";
        str2 = str4 == null ? str5 : str4;
        String name = this.name;
        str = name == null ? str5 : name;
        if (this.time == null) {
            time = "00:00";
        }
        super(str2, string, this.days, str, this.type, time, this.repeating, this.isActive);
        return reminderEntity;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RemindersModel(days=");
        stringBuilder.append(this.days);
        stringBuilder.append(", users=");
        stringBuilder.append(this.users);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", time=");
        stringBuilder.append(this.time);
        stringBuilder.append(", repeating=");
        stringBuilder.append(this.repeating);
        stringBuilder.append(", isActive=");
        stringBuilder.append(this.isActive);
        stringBuilder.append(", dogs=");
        stringBuilder.append(this.dogs);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int booleanValue2;
        int intValue;
        boolean next;
        int booleanValue;
        Object key;
        int obj4;
        n.f(parcel, "out");
        obj4 = this.days;
        parcel.writeInt(obj4.size());
        obj4 = obj4.iterator();
        for (Boolean next5 : obj4) {
            parcel.writeInt(next5.booleanValue());
        }
        obj4 = this.users;
        parcel.writeInt(obj4.size());
        obj4 = obj4.entrySet().iterator();
        for (Map.Entry next4 : obj4) {
            parcel.writeString((String)next4.getKey());
            parcel.writeInt((Number)next4.getValue().intValue());
        }
        parcel.writeString(this.name);
        parcel.writeString(this.id);
        parcel.writeString(this.type);
        parcel.writeString(this.time);
        parcel.writeString(this.repeating);
        parcel.writeInt(this.isActive);
        obj4 = this.dogs;
        if (obj4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(obj4.size());
            obj4 = obj4.entrySet().iterator();
            for (Map.Entry next3 : obj4) {
                parcel.writeString((String)next3.getKey());
                parcel.writeInt((Boolean)next3.getValue().booleanValue());
            }
        }
    }
}
