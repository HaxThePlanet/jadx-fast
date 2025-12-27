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

/* compiled from: RemindersModel.kt */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010$\n\u0002\u0008\u001b\n\u0002\u0010\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 P2\u00020\u0001:\u0001PB\u0085\u0001\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\u0008\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0004\u0012\u0016\u0008\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0008J\u000f\u0010.\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\t\u00105\u001a\u00020\u0004HÆ\u0003J\u0017\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010HÆ\u0003J\u0089\u0001\u00107\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0014\u0008\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u00062\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00072\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\r\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00042\u0016\u0008\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010HÆ\u0001J\t\u00108\u001a\u00020\u0008HÖ\u0001J\u0013\u00109\u001a\u00020\u00042\u0008\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0008H\u0002J\u000e\u0010>\u001a\u0008\u0012\u0004\u0012\u00020\u00070?H\u0007J\u000f\u0010@\u001a\u0004\u0018\u00010\u0008H\u0007¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010?H\u0007J\t\u0010C\u001a\u00020\u0008HÖ\u0001J\u0006\u0010D\u001a\u00020\u0004J\u0016\u0010E\u001a\u00020,2\u0006\u0010F\u001a\u00020\u00082\u0006\u0010G\u001a\u00020\u0008J\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0007H\u0007J\t\u0010K\u001a\u00020\u0007HÖ\u0001J\u0019\u0010L\u001a\u00020,2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0008HÖ\u0001R \u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b\"\u0004\u0008\u001c\u0010\u001dR\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u001e\"\u0004\u0008\u001f\u0010 R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\u001b\"\u0004\u0008\"\u0010\u001dR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008#\u0010\u001b\"\u0004\u0008$\u0010\u001dR\u001c\u0010\u000c\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010\u001b\"\u0004\u0008&\u0010\u001dR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008'\u0010\u001b\"\u0004\u0008(\u0010\u001dR&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008)\u0010\u0017\"\u0004\u0008*\u0010\u0019¨\u0006Q", d2 = {"Lapp/dogo/com/dogo_android/model/RemindersModel;", "Landroid/os/Parcelable;", "days", "", "", "users", "", "", "", "name", "id", "type", "time", "repeating", "isActive", "dogs", "", "(Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;)V", "getDays", "()Ljava/util/List;", "setDays", "(Ljava/util/List;)V", "getDogs", "()Ljava/util/Map;", "setDogs", "(Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "()Z", "setActive", "(Z)V", "getName", "setName", "getRepeating", "setRepeating", "getTime", "setTime", "getType", "setType", "getUsers", "setUsers", "addUsers", "", "uid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "getDoubleDigitReminder", "hoursReminder", "getReminderShortWeekdayStrings", "", "getReminderTimeInMinutes", "()Ljava/lang/Integer;", "getReminderWeekdayStrings", "hashCode", "isEmpty", "setTimeWithInt", "hours", "minutes", "toEntity", "Lapp/dogo/android/persistencedb/room/entity/ReminderEntity;", "userId", "toString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class RemindersModel implements Parcelable {

    public static final Parcelable.Creator<RemindersModel> CREATOR = null;
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final RemindersModel.Companion INSTANCE = null;
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
        private Companion() {
            super();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RemindersModel> {
        @Override // android.os.Parcelable$Creator
        public final RemindersModel createFromParcel(Parcel parcel) {
            int i2;
            boolean z = true;
            LinkedHashMap linkedHashMap;
            String string7;
            Boolean str2;
            boolean z3;
            n.f(parcel, "parcel");
            int _int3 = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int3);
            i2 = 0;
            i2 = 1;
            while (i2 != _int3) {
                arrayList.add(Boolean.valueOf(z));
                i2 = i2 + 1;
            }
            int _int4 = parcel.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(_int4);
            while (i2 != _int4) {
                linkedHashMap2.put(parcel.readString(), Integer.valueOf(parcel.readInt()));
                i2 = i2 + 1;
            }
            int r10 = i2;
            if (parcel.readInt() == 0) {
            } else {
                int _int2 = parcel.readInt();
                while (i2 != _int2) {
                    int r15 = i2;
                    new LinkedHashMap(_int2).put(parcel.readString(), i2);
                    i2 = i2 + 1;
                }
            }
            RemindersModel remindersModel = new RemindersModel(arrayList, linkedHashMap2, string, string2, string3, string5, string6, i2, linkedHashMap);
            return remindersModel;
        }

        @Override // android.os.Parcelable$Creator
        public final RemindersModel[] newArray(int i) {
            return new RemindersModel[i];
        }
    }
    public RemindersModel(List<Boolean> list, Map<String, Integer> map, String str, String str2, String str3, String str4, String str5, boolean z, Map<String, Boolean> map2) {
        int map22 = 0;
        n.f(list, "days");
        n.f(map, "users");
        n.f(str3, "type");
        n.f(str5, "repeating");
        super();
        this.days = list;
        this.users = map;
        this.name = str;
        this.id = str2;
        this.type = str3;
        this.time = str4;
        this.repeating = str5;
        this.isActive = z;
        this.dogs = map2;
        map22 = 7;
        if (list.size() < 7) {
            map22 = 0;
            map22 = map22 + 1;
            this.days.add(map22, Boolean.TRUE);
            int size = 6;
            while (map22 > 6) {
                map22 = map22 + 1;
                this.days.add(map22, Boolean.TRUE);
                size = 6;
            }
        }
    }

    private final String getDoubleDigitReminder(int hoursReminder) {
        String str2;
        if (hoursReminder < 10) {
            str = "0";
            str2 = n.o(str, Integer.valueOf(hoursReminder));
        } else {
            str2 = String.valueOf(hoursReminder);
        }
        return str2;
    }

    public final void addUsers(String uid, int type) {
        n.f(uid, "uid");
        this.users.put(uid, Integer.valueOf(type));
    }

    public final List<Boolean> getDays() {
        return this.days;
    }

    public final Map<String, Boolean> getDogs() {
        return this.dogs;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    @Exclude
    public final List<String> getReminderShortWeekdayStrings() {
        List list;
        int i2 = 0;
        Object obj;
        String str = null;
        int i = 7;
        if (this.days.size() == 7) {
            ArrayList arrayList = new ArrayList(p.r(this.days, 10));
            i2 = 0;
            Iterator it = this.days.iterator();
            while (it.hasNext()) {
                i2 = i2 + 1;
                if (i2 < 0) {
                    p.q();
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) 0;
                }
            }
            list = p.U(arrayList);
        } else {
            list = p.g();
        }
        return list;
    }

    @Exclude
    public final Integer getReminderTimeInMinutes() {
        Object[] array;
        int i = 0;
        h regex;
        String length;
        int i2;
        i = 0;
        i2 = 0;
        int r0 = this.time == null ? 0 : i;
        i2 = 1;
        int r4 = i2;
        if (i2 != 0) {
            Object obj3 = array[i2];
            i2 = obj3.length() - i2;
            int i3 = 32;
            while (i2 <= i2) {
                int r8 = i2;
                r8 = i2;
                if (i2 != 0) {
                    break;
                }
            }
            Object obj2 = array[i2];
            i2 = obj2.length() - i2;
            while (i2 <= i2) {
                r8 = i2;
                r8 = i2;
                if (i2 != 0) {
                    break;
                }
            }
            i2 = i2 + i2;
            Integer num = Integer.valueOf((Integer.parseInt(obj3.subSequence(i2, i2 + i2).toString())) * 60 + (Integer.parseInt(obj2.subSequence(i2, i2).toString())));
        }
        return i;
    }

    @Exclude
    public final List<String> getReminderWeekdayStrings() {
        int i = 0;
        int i3 = 0;
        String str;
        i = 0;
        int i2 = 7;
        if (this.days.size() == 7) {
            ArrayList arrayList = new ArrayList(p.r(this.days, 10));
            i3 = 0;
            Iterator it = this.days.iterator();
            while (it.hasNext()) {
                i3 = i3 + 1;
                if (i3 < 0) {
                    p.q();
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                }
            }
            List list = p.U(arrayList);
        }
        return i;
    }

    public final String getRepeating() {
        return this.repeating;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getType() {
        return this.type;
    }

    public final Map<String, Integer> getUsers() {
        return this.users;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isEmpty() {
        boolean z = true;
        int r0 = this.id == null ? 1 : 0;
        return (this.id == null ? 1 : 0);
    }

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

    public final void setId(String str) {
        this.id = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setRepeating(String str) {
        n.f(str, "<set-?>");
        this.repeating = str;
    }

    public final void setTime(String str) {
        this.time = str;
    }

    public final void setTimeWithInt(int hours, int minutes) {
        final StringBuilder stringBuilder = new StringBuilder();
        String doubleDigitReminder = getDoubleDigitReminder(hours % 24);
        String doubleDigitReminder2 = getDoubleDigitReminder(minutes % 60);
        str = doubleDigitReminder + 58 + doubleDigitReminder2;
        this.time = str;
    }

    public final void setType(String str) {
        n.f(str, "<set-?>");
        this.type = str;
    }

    public final void setUsers(Map<String, Integer> map) {
        n.f(map, "<set-?>");
        this.users = map;
    }

    @Exclude
    public final ReminderEntity toEntity(String userId) {
        String str2;
        String str;
        n.f(userId, "userId");
        str = "";
        String r3 = str;
        String r5 = str;
        if (this.time == null) {
            str2 = "00:00";
        }
        ReminderEntity reminderEntity = new ReminderEntity(str, userId, this.days, str, this.type, str2, this.repeating, this.isActive);
        return reminderEntity;
    }

    public /* synthetic */ RemindersModel(List list, Map map, String str, String str2, String str3, String str4, String str5, boolean z, Map map2, int i, g gVar) {
        ArrayList list2;
        HashMap map22;
        int str32;
        String str52;
        int z82 = 0;
        int i102 = i;
        ArrayList r1 = i102 & 1 != 0 ? new ArrayList() : list;
        HashMap r2 = i102 & 2 != 0 ? new HashMap() : map;
        str32 = 0;
        int r3 = i102 & 4 != 0 ? str32 : str;
        int r5 = i102 & 8 != 0 ? str32 : str2;
        str52 = "";
        String r6 = i102 & 16 != 0 ? "" : str3;
        int r8 = i102 & 32 != 0 ? str32 : str4;
        if (i102 & 64 == 0) {
            str52 = str5;
        }
        int r9 = i102 & 128 != 0 ? 0 : z;
        if (i102 & 256 == 0) {
            str32 = map2;
        }
        this(list2, map22, str32, str32, str52, str32, str52, z82, str32);
    }

    static {
        RemindersModel.INSTANCE = new RemindersModel_Companion(null);
        RemindersModel.CREATOR = new RemindersModel.Creator();
    }

    public RemindersModel() {
        this(null, null, null, null, null, null, null, false, null, 511, null);
    }

    public static /* synthetic */ RemindersModel copy$default(RemindersModel remindersModel, List list, Map map, String str, String str2, String str3, String str4, String str5, boolean z, Map map2, int i, Object object) {
        Map map102;
        List list22;
        Map map32;
        String str42;
        String str52;
        String str62;
        String str72;
        String str82;
        boolean z92;
        Object remindersModel2 = remindersModel;
        int i112 = i;
        List r2 = i112 & 1 != 0 ? remindersModel2.days : list;
        Map r3 = i112 & 2 != 0 ? remindersModel2.users : map;
        String r4 = i112 & 4 != 0 ? remindersModel2.name : str;
        String r5 = i112 & 8 != 0 ? remindersModel2.id : str2;
        String r6 = i112 & 16 != 0 ? remindersModel2.type : str3;
        String r7 = i112 & 32 != 0 ? remindersModel2.time : str4;
        String r8 = i112 & 64 != 0 ? remindersModel2.repeating : str5;
        boolean r9 = i112 & 128 != 0 ? remindersModel2.isActive : z;
        Map r1 = i112 & 256 != 0 ? remindersModel2.dogs : map2;
        return remindersModel.copy(list22, map32, str42, str52, str62, str72, str82, z92, (i112 & 256 != 0 ? remindersModel2.dogs : map2));
    }

    /* operator */ public final List<Boolean> component1() {
        return this.days;
    }

    /* operator */ public final Map<String, Integer> component2() {
        return this.users;
    }

    /* operator */ public final String component3() {
        return this.name;
    }

    /* operator */ public final String component4() {
        return this.id;
    }

    /* operator */ public final String component5() {
        return this.type;
    }

    /* operator */ public final String component6() {
        return this.time;
    }

    /* operator */ public final String component7() {
        return this.repeating;
    }

    /* operator */ public final boolean component8() {
        return this.isActive;
    }

    /* operator */ public final Map<String, Boolean> component9() {
        return this.dogs;
    }

    public final RemindersModel copy(List<Boolean> days, Map<String, Integer> users, String name, String id, String type, String time, String repeating, boolean isActive, Map<String, Boolean> dogs) {
        n.f(days, "days");
        n.f(users, "users");
        final Object type2 = type;
        n.f(type2, "type");
        final Object repeating2 = repeating;
        n.f(repeating2, "repeating");
        RemindersModel remindersModel = new RemindersModel(days, users, name, id, type2, time, repeating2, isActive, dogs);
        return remindersModel;
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
        final boolean z10 = false;
        if (!(other instanceof RemindersModel)) {
            return false;
        }
        if (!n.b(this.days, other.days)) {
            return false;
        }
        if (!n.b(this.users, other.users)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.type, other.type)) {
            return false;
        }
        if (!n.b(this.time, other.time)) {
            return false;
        }
        if (!n.b(this.repeating, other.repeating)) {
            return false;
        }
        if (this.isActive != other.isActive) {
            return false;
        }
        return !n.b(this.dogs, other.dogs) ? z10 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        boolean isActive2 = true;
        i = 0;
        if (this.name == null) {
        } else {
            i = this.name.hashCode();
        }
        if (this.id == null) {
        } else {
            i = this.id.hashCode();
        }
        if (this.time == null) {
        } else {
            i = this.time.hashCode();
        }
        if (this.isActive) {
            int i22 = 1;
        }
        if (this.dogs != null) {
            i = this.dogs.hashCode();
        }
        return (this.days.hashCode() * 31) + this.users.hashCode() * 31 + i * 31 + i * 31 + this.type.hashCode() * 31 + i * 31 + this.repeating.hashCode() * 31 + isActive2 * 31 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "RemindersModel(days=";
        String str3 = ", users=";
        String str4 = ", name=";
        String str5 = ", id=";
        String str6 = ", type=";
        String str7 = ", time=";
        String str8 = ", repeating=";
        String str9 = ", isActive=";
        String str10 = ", dogs=";
        str = str2 + this.days + str3 + this.users + str4 + this.name + str5 + this.id + str6 + this.type + str7 + this.time + str8 + this.repeating + str9 + this.isActive + str10 + this.dogs + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Object key;
        n.f(parcel, "out");
        parcel.writeInt(this.days.size());
        Iterator it = this.days.iterator();
        while (it.hasNext()) {
            parcel.writeInt((Boolean)it.next().booleanValue());
        }
        parcel.writeInt(this.users.size());
        Iterator it2 = this.users.entrySet().iterator();
        while (it2.hasNext()) {
            Object item2 = it2.next();
            parcel.writeString((String)item2.getKey());
            parcel.writeInt((Number)item2.getValue().intValue());
        }
        parcel.writeString(this.name);
        parcel.writeString(this.id);
        parcel.writeString(this.type);
        parcel.writeString(this.time);
        parcel.writeString(this.repeating);
        parcel.writeInt(this.isActive);
        if (this.dogs == null) {
            int i = 0;
            parcel.writeInt(i);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(this.dogs.size());
            Iterator it3 = this.dogs.entrySet().iterator();
            while (it3.hasNext()) {
                Object item = it3.next();
                parcel.writeString((String)item.getKey());
                parcel.writeInt((Boolean)item.getValue().booleanValue());
            }
        }
    }
}
