package app.dogo.com.dogo_android.s.b;

import app.dogo.android.network.DogoApiClient;
import app.dogo.android.persistencedb.room.entity.PottyReminderEntity;
import app.dogo.android.persistencedb.room.entity.ReminderEntity;
import app.dogo.com.dogo_android.k.m;
import app.dogo.com.dogo_android.model.RemindersModel;
import app.dogo.com.dogo_android.model.RemindersModelKt;
import app.dogo.com.dogo_android.repository.domain.PottyRemindersItem;
import app.dogo.com.dogo_android.repository.domain.PottyRemindersItemKt;
import app.dogo.com.dogo_android.s.a.h3;
import app.dogo.com.dogo_android.s.a.o3;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.externalmodel.model.PottyReminderModel.PottyReminderCreateModel;
import app.dogo.externalmodel.model.PottyReminderModel.PottyReminderUpdateModel;
import app.dogo.externalmodel.model.TrainingReminderModel.TrainingReminderCreateModel;
import app.dogo.externalmodel.model.TrainingReminderModel.TrainingReminderUpdateModel;
import app.dogo.externalmodel.model.requests.PottyReminderRequest;
import app.dogo.externalmodel.model.requests.PottyReminderUpdateRequest;
import app.dogo.externalmodel.model.requests.TrainingReminderRequest;
import app.dogo.externalmodel.model.requests.TrainingReminderUpdateRequest;
import app.dogo.externalmodel.model.responses.ReminderResponse;
import e.a.a.a.b.b.q0;
import i.b.a0;
import i.b.b;
import i.b.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.u;
import kotlin.w;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0011J\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\u0006\u0010\u0017\u001a\u00020\u0011J\u0014\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001d\u001a\u00020\u0011J\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\u0006\u0010\u0015\u001a\u00020\u0011J\u0014\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020 0\u00192\u0006\u0010\u0015\u001a\u00020\u0011J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0011J\u0016\u0010\"\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u001bJ\u0016\u0010$\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010#\u001a\u00020 J\u000e\u0010%\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011J\u0016\u0010&\u001a\u00020'2\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u00020)0\u001aH\u0002J<\u0010*\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020)0\u001a0+2\u0006\u0010\u0015\u001a\u00020\u00112\u0008\u0010-\u001a\u0004\u0018\u00010 2\u000c\u0010.\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u000e\u0010/\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011J\u0016\u00100\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u00101\u001a\u000202J\u0016\u00103\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u001bJ\u001e\u00105\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0012J\u0016\u00107\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u00108\u001a\u00020 J\u0012\u00109\u001a\u00020'2\u0008\u0010:\u001a\u0004\u0018\u00010,H\u0002J\u0016\u0010;\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0012R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "", "userDao", "Lapp/dogo/android/persistencedb/room/dao/UserEntityDao;", "trainingReminderNotificationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/TrainingReminderNotificationInteractor;", "pottyReminderNotificationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/PottyReminderNotificationInteractor;", "dogoApiClient", "Lapp/dogo/android/network/DogoApiClient;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lapp/dogo/android/persistencedb/room/dao/UserEntityDao;Lapp/dogo/com/dogo_android/repository/interactor/TrainingReminderNotificationInteractor;Lapp/dogo/com/dogo_android/repository/interactor/PottyReminderNotificationInteractor;Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "hasReminderSetLookupTable", "", "", "", "cancelAllNotifications", "Lio/reactivex/Completable;", "userId", "deactivatePottyRemindersForDog", "dogId", "getPottyReminderByDogId", "Lio/reactivex/Single;", "", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "getPottyReminderOrEmptyById", "reminderId", "getPottyRemindersByUserId", "getTrainingReminderOrEmptyByUserId", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "hasUserTrainingReminder", "savePottyReminder", "reminder", "saveTrainingReminder", "setupAllUsersActivePottyReminders", "updateAllPottyReminderNotifications", "", "pottyReminderEntity", "Lapp/dogo/android/persistencedb/room/entity/PottyReminderEntity;", "updateAppState", "Lkotlin/Pair;", "Lapp/dogo/android/persistencedb/room/entity/ReminderEntity;", "trainingReminderOrEmpty", "pottyReminders", "updateAppStateFromRoom", "updateCacheFromResponse", "response", "Lapp/dogo/externalmodel/model/responses/ReminderResponse;", "updatePottyReminder", "pottyRemindersItem", "updatePottyReminderState", "newState", "updateTrainingReminder", "reminderModel", "updateTrainingReminderNotifications", "trainingReminderEntity", "updateTrainingReminderState", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l1 {

    private final q0 a;
    private final o3 b;
    private final h3 c;
    private final DogoApiClient d;
    private final r2 e;
    private final o3 f;
    private final Map<String, Boolean> g;
    public l1(q0 q0, o3 o32, h3 h33, DogoApiClient dogoApiClient4, r2 r25, o3 o36) {
        n.f(q0, "userDao");
        n.f(o32, "trainingReminderNotificationInteractor");
        n.f(h33, "pottyReminderNotificationInteractor");
        n.f(dogoApiClient4, "dogoApiClient");
        n.f(r25, "remoteConfigService");
        n.f(o36, "tracker");
        super();
        this.a = q0;
        this.b = o32;
        this.c = h33;
        this.d = dogoApiClient4;
        this.e = r25;
        this.f = o36;
        LinkedHashMap obj2 = new LinkedHashMap();
        this.g = obj2;
    }

    public static RemindersModel A(List list) {
        return l1.n(list);
    }

    public static PottyRemindersItem B(PottyReminderEntity pottyReminderEntity) {
        return l1.i(pottyReminderEntity);
    }

    public static f C(app.dogo.com.dogo_android.s.b.l1 l1, String string2, ReminderResponse reminderResponse3) {
        return l1.T(l1, string2, reminderResponse3);
    }

    public static List D(Throwable throwable) {
        return l1.k(throwable);
    }

    public static f E(app.dogo.com.dogo_android.s.b.l1 l1, String string2, ReminderResponse reminderResponse3) {
        return l1.V(l1, string2, reminderResponse3);
    }

    public static f F(app.dogo.com.dogo_android.s.b.l1 l1, String string2, ReminderResponse reminderResponse3) {
        return l1.a0(l1, string2, reminderResponse3);
    }

    private static final f H(app.dogo.com.dogo_android.s.b.l1 l1, String string2, ReminderResponse reminderResponse3) {
        n.f(l1, "this$0");
        n.f(string2, "$userId");
        n.f(reminderResponse3, "response");
        return l1.R(string2, reminderResponse3);
    }

    private static final f J(app.dogo.com.dogo_android.s.b.l1 l1, String string2, ReminderResponse reminderResponse3) {
        n.f(l1, "this$0");
        n.f(string2, "$userId");
        n.f(reminderResponse3, "response");
        return l1.R(string2, reminderResponse3);
    }

    private static final w L(app.dogo.com.dogo_android.s.b.l1 l1, String string2, List list3) {
        int entity;
        n.f(l1, "this$0");
        n.f(string2, "$userId");
        n.f(list3, "reminders");
        ArrayList arrayList = new ArrayList(p.r(list3, 10));
        final Iterator obj4 = list3.iterator();
        for (PottyRemindersItem next2 : obj4) {
            arrayList.add(next2.toEntity(string2));
        }
        l1.M(arrayList);
        return w.a;
    }

    private final void M(List<PottyReminderEntity> list) {
        int i;
        h3 h3Var;
        boolean active;
        PottyRemindersItem notificationId;
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        final Iterator obj4 = list.iterator();
        while (obj4.hasNext()) {
            Object next2 = obj4.next();
            notificationId = PottyRemindersItemKt.toItem((PottyReminderEntity)next2);
            if (next2.isActive() && !this.e.V()) {
            } else {
            }
            this.c.a(notificationId.getNotificationId());
            arrayList.add(w.a);
            if (!this.e.V()) {
            } else {
            }
            this.c.h(notificationId);
        }
    }

    private final o<ReminderEntity, List<PottyReminderEntity>> N(String string, RemindersModel remindersModel2, List<PottyRemindersItem> list3) {
        int i;
        boolean empty;
        int i2;
        int entity;
        ReminderEntity obj6;
        final int i3 = 0;
        if (remindersModel2 == null) {
            i2 = i3;
        } else {
        }
        if (i2 == 0) {
            obj6 = 0;
        } else {
            obj6 = remindersModel2.toEntity(string);
        }
        ArrayList arrayList = new ArrayList(p.r(list3, 10));
        Iterator obj7 = list3.iterator();
        for (PottyRemindersItem next2 : obj7) {
            arrayList.add(next2.toEntity(string));
        }
        Y(obj6);
        M(arrayList);
        if (obj6 != null) {
        } else {
            i = i3;
        }
        this.g.put(string, Boolean.valueOf(i));
        return u.a(obj6, arrayList);
    }

    private static final f P(app.dogo.com.dogo_android.s.b.l1 l1, String string2, RemindersModel remindersModel3) {
        n.f(l1, "this$0");
        n.f(string2, "$userId");
        n.f(remindersModel3, "trainingReminderOrEmpty");
        j jVar = new j(l1, string2, remindersModel3);
        return l1.j(string2).flatMapCompletable(jVar);
    }

    private static final f Q(app.dogo.com.dogo_android.s.b.l1 l1, String string2, RemindersModel remindersModel3, List list4) {
        n.f(l1, "this$0");
        n.f(string2, "$userId");
        n.f(remindersModel3, "$trainingReminderOrEmpty");
        n.f(list4, "pottyReminders");
        l1.N(string2, remindersModel3, list4);
        return b.f();
    }

    private static final f T(app.dogo.com.dogo_android.s.b.l1 l1, String string2, ReminderResponse reminderResponse3) {
        n.f(l1, "this$0");
        n.f(string2, "$userId");
        n.f(reminderResponse3, "response");
        return l1.R(string2, reminderResponse3);
    }

    private static final f V(app.dogo.com.dogo_android.s.b.l1 l1, String string2, ReminderResponse reminderResponse3) {
        n.f(l1, "this$0");
        n.f(string2, "$userId");
        n.f(reminderResponse3, "response");
        return l1.R(string2, reminderResponse3);
    }

    private static final f X(app.dogo.com.dogo_android.s.b.l1 l1, String string2, ReminderResponse reminderResponse3) {
        n.f(l1, "this$0");
        n.f(string2, "$userId");
        n.f(reminderResponse3, "response");
        return l1.R(string2, reminderResponse3);
    }

    private final void Y(ReminderEntity reminderEntity) {
        boolean active;
        Object obj2;
        if (reminderEntity != null) {
            if (!this.e.V() && reminderEntity.isActive()) {
                if (reminderEntity.isActive()) {
                    this.b.m(RemindersModelKt.toItem(reminderEntity));
                } else {
                    this.b.a();
                }
            } else {
            }
        }
    }

    private static final f a0(app.dogo.com.dogo_android.s.b.l1 l1, String string2, ReminderResponse reminderResponse3) {
        n.f(l1, "this$0");
        n.f(string2, "$userId");
        n.f(reminderResponse3, "response");
        return l1.R(string2, reminderResponse3);
    }

    private static final w b(app.dogo.com.dogo_android.s.b.l1 l1, List list2) {
        int i;
        h3 h3Var;
        n.f(l1, "this$0");
        n.f(list2, "pottyReminders");
        ArrayList arrayList = new ArrayList(p.r(list2, 10));
        Iterator obj4 = list2.iterator();
        for (PottyRemindersItem next2 : obj4) {
            l1.c.a(next2.getNotificationId());
            arrayList.add(w.a);
        }
        o3.c(l1.b, 0, 1, 0);
        return w.a;
    }

    private static final List d(app.dogo.com.dogo_android.s.b.l1 l1, List list2) {
        int i;
        h3 h3Var;
        n.f(l1, "this$0");
        n.f(list2, "pottyReminders");
        ArrayList arrayList = new ArrayList(p.r(list2, 10));
        final Iterator obj4 = list2.iterator();
        for (PottyRemindersItem next2 : obj4) {
            l1.c.a(next2.getNotificationId());
            arrayList.add(w.a);
        }
        return arrayList;
    }

    private static final List f(Throwable throwable) {
        n.f(throwable, "it");
        return p.g();
    }

    private static final List g(List list) {
        int item;
        n.f(list, "reminders");
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        final Iterator obj2 = list.iterator();
        for (PottyReminderEntity next2 : obj2) {
            arrayList.add(PottyRemindersItemKt.toItem(next2));
        }
        return arrayList;
    }

    private static final PottyRemindersItem i(PottyReminderEntity pottyReminderEntity) {
        n.f(pottyReminderEntity, "it");
        return PottyRemindersItemKt.toItem(pottyReminderEntity);
    }

    private static final List k(Throwable throwable) {
        n.f(throwable, "it");
        return p.g();
    }

    private static final List l(List list) {
        int item;
        n.f(list, "reminders");
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        final Iterator obj2 = list.iterator();
        for (PottyReminderEntity next2 : obj2) {
            arrayList.add(PottyRemindersItemKt.toItem(next2));
        }
        return arrayList;
    }

    private static final RemindersModel n(List list) {
        String next;
        int remindersModel;
        boolean z;
        String tag;
        int i;
        int i4;
        int i10;
        int i6;
        int i5;
        int i7;
        int i2;
        int i3;
        int i8;
        int i9;
        n.f(list, "reminders");
        final Iterator obj14 = list.iterator();
        for (Object next : obj14) {
        }
        next = remindersModel;
        if ((ReminderEntity)next == null) {
        } else {
            remindersModel = RemindersModelKt.toItem((ReminderEntity)next);
        }
        if (remindersModel == null) {
            super(0, 0, 0, 0, 0, 0, 0, 0, 0, 511, 0);
        }
        return remindersModel;
    }

    public static f p(app.dogo.com.dogo_android.s.b.l1 l1, String string2, RemindersModel remindersModel3, List list4) {
        return l1.Q(l1, string2, remindersModel3, list4);
    }

    public static f q(app.dogo.com.dogo_android.s.b.l1 l1, String string2, ReminderResponse reminderResponse3) {
        return l1.J(l1, string2, reminderResponse3);
    }

    public static f r(app.dogo.com.dogo_android.s.b.l1 l1, String string2, ReminderResponse reminderResponse3) {
        return l1.X(l1, string2, reminderResponse3);
    }

    public static List s(List list) {
        return l1.g(list);
    }

    public static f t(app.dogo.com.dogo_android.s.b.l1 l1, String string2, RemindersModel remindersModel3) {
        return l1.P(l1, string2, remindersModel3);
    }

    public static w u(app.dogo.com.dogo_android.s.b.l1 l1, List list2) {
        return l1.b(l1, list2);
    }

    public static List v(app.dogo.com.dogo_android.s.b.l1 l1, List list2) {
        return l1.d(l1, list2);
    }

    public static f w(app.dogo.com.dogo_android.s.b.l1 l1, String string2, ReminderResponse reminderResponse3) {
        return l1.H(l1, string2, reminderResponse3);
    }

    public static List x(Throwable throwable) {
        return l1.f(throwable);
    }

    public static List y(List list) {
        return l1.l(list);
    }

    public static w z(app.dogo.com.dogo_android.s.b.l1 l1, String string2, List list3) {
        return l1.L(l1, string2, list3);
    }

    public final b G(String string, PottyRemindersItem pottyRemindersItem2) {
        String endTime;
        int longValue;
        n.f(string, "userId");
        n.f(pottyRemindersItem2, "reminder");
        if (pottyRemindersItem2.getEndTime() == null) {
            endTime = "";
        }
        Long repeatIntervalMs = pottyRemindersItem2.getRepeatIntervalMs();
        if (repeatIntervalMs == null) {
            longValue = 0;
        } else {
            longValue = repeatIntervalMs.longValue();
        }
        super(pottyRemindersItem2.getStartTime(), endTime, TimeUnit.MILLISECONDS.toMinutes(longValue), obj6, j1.U0(pottyRemindersItem2.getDays()), pottyRemindersItem2.getDogId());
        PottyReminderRequest pottyReminderRequest = new PottyReminderRequest(obj11);
        q qVar = new q(this, string);
        final b obj10 = this.d.savePottyReminderSingle(pottyReminderRequest).flatMapCompletable(qVar);
        n.e(obj10, "dogoApiClient.savePottyReminderSingle(\n            PottyReminderRequest(\n                reminder = PottyReminderModel.PottyReminderCreateModel(\n                    dogId = reminder.dogId,\n                    endTime = reminder.endTime ?: \"\",\n                    startTime = reminder.startTime,\n                    intervalMinutes = TimeUnit.MILLISECONDS.toMinutes(reminder.repeatIntervalMs ?: 0),\n                    weekdays = reminder.days.toWeekdays()\n                )\n            )\n        ).flatMapCompletable { response ->\n            updateCacheFromResponse(userId, response)\n        }");
        return obj10;
    }

    public final b I(String string, RemindersModel remindersModel2) {
        String time;
        n.f(string, "userId");
        n.f(remindersModel2, "reminder");
        if (remindersModel2.getTime() == null) {
            time = "";
        }
        TrainingReminderModel.TrainingReminderCreateModel trainingReminderCreateModel = new TrainingReminderModel.TrainingReminderCreateModel(time, j1.U0(remindersModel2.getDays()));
        TrainingReminderRequest trainingReminderRequest = new TrainingReminderRequest(trainingReminderCreateModel);
        k kVar = new k(this, string);
        final b obj5 = this.d.saveTrainingReminderSingle(trainingReminderRequest).flatMapCompletable(kVar);
        n.e(obj5, "dogoApiClient.saveTrainingReminderSingle(\n            TrainingReminderRequest(\n                reminder = TrainingReminderModel.TrainingReminderCreateModel(\n                    time = reminder.time ?: \"\",\n                    weekdays = reminder.days.toWeekdays()\n                )\n            )\n        ).flatMapCompletable { response ->\n            updateCacheFromResponse(userId, response)\n        }");
        return obj5;
    }

    public final b K(String string) {
        n.f(string, "userId");
        t tVar = new t(this, string);
        b obj3 = j(string).map(tVar).ignoreElement();
        n.e(obj3, "getPottyRemindersByUserId(userId).map { reminders ->\n            updateAllPottyReminderNotifications(reminders.map { it.toEntity(userId) })\n        }.ignoreElement()");
        return obj3;
    }

    public final b O(String string) {
        n.f(string, "userId");
        n nVar = new n(this, string);
        final b obj3 = m(string).flatMapCompletable(nVar);
        n.e(obj3, "getTrainingReminderOrEmptyByUserId(userId).flatMapCompletable { trainingReminderOrEmpty ->\n            getPottyRemindersByUserId(userId).flatMapCompletable { pottyReminders ->\n                updateAppState(userId, trainingReminderOrEmpty, pottyReminders)\n                Completable.complete()\n            }\n        }");
        return obj3;
    }

    public final b R(String string, ReminderResponse reminderResponse2) {
        RemindersModel item2;
        int item;
        Object str;
        ReminderEntity[] arr;
        b obj6;
        n.f(string, "userId");
        n.f(reminderResponse2, "response");
        app.dogo.externalmodel.model.TrainingReminderModel trainingReminder = reminderResponse2.getTrainingReminder();
        if (trainingReminder == null) {
            item2 = 0;
        } else {
            item2 = RemindersModelKt.toItem(trainingReminder);
        }
        obj6 = reminderResponse2.getPottyReminders();
        ArrayList arrayList = new ArrayList(p.r(obj6, 10));
        obj6 = obj6.iterator();
        for (PottyReminderModel next2 : obj6) {
            arrayList.add(PottyRemindersItemKt.toItem(next2));
        }
        o obj5 = N(string, item2, arrayList);
        obj6 = obj5.a();
        int i = 1;
        int i2 = 0;
        if ((ReminderEntity)obj6 != null) {
            this.f.o(RemindersModelKt.toItem((ReminderEntity)obj6));
            arr = new ReminderEntity[i];
            arr[i2] = obj6;
            obj6 = this.a.i(arr);
        } else {
            n.e(b.f(), "{\n            Completable.complete()\n        }");
        }
        obj5 = (List)obj5.b().toArray(new PottyReminderEntity[i2]);
        Objects.requireNonNull(obj5, "null cannot be cast to non-null type kotlin.Array<T>");
        f[] arr2 = new f[2];
        arr2[i2] = obj6;
        arr2[i] = this.a.p((PottyReminderEntity[])Arrays.copyOf((PottyReminderEntity[])obj5, obj5.length)).ignoreElement();
        obj5 = b.p(arr2);
        n.e(obj5, "mergeArray(\n            trainingReminderUpdate,\n            pottyReminderUpdate\n        )");
        return obj5;
    }

    public final b S(String string, PottyRemindersItem pottyRemindersItem2) {
        n.f(string, "userId");
        n.f(pottyRemindersItem2, "pottyRemindersItem");
        super(pottyRemindersItem2.getStartTime(), pottyRemindersItem2.getEndTime(), pottyRemindersItem2.getIntervalMinutes(), j1.U0(pottyRemindersItem2.getDays()), Boolean.valueOf(pottyRemindersItem2.isActive()));
        PottyReminderUpdateRequest pottyReminderUpdateRequest = new PottyReminderUpdateRequest(pottyReminderUpdateModel2);
        w wVar = new w(this, string);
        final b obj11 = this.d.updatePottyReminderSingle(pottyRemindersItem2.getReminderId(), pottyReminderUpdateRequest).flatMapCompletable(wVar);
        n.e(obj11, "dogoApiClient.updatePottyReminderSingle(\n            pottyRemindersItem.reminderId,\n            PottyReminderUpdateRequest(\n                reminder = PottyReminderModel.PottyReminderUpdateModel(\n                    startTime = pottyRemindersItem.startTime,\n                    endTime = pottyRemindersItem.endTime,\n                    intervalMinutes = pottyRemindersItem.getIntervalMinutes(),\n                    weekdays = pottyRemindersItem.days.toWeekdays(),\n                    enabled = pottyRemindersItem.isActive\n                )\n            )\n        ).flatMapCompletable { response ->\n            updateCacheFromResponse(userId, response)\n        }");
        return obj11;
    }

    public final b U(String string, String string2, boolean z3) {
        n.f(string, "userId");
        n.f(string2, "reminderId");
        super(0, 0, 0, 0, Boolean.valueOf(z3), 15, 0);
        PottyReminderUpdateRequest pottyReminderUpdateRequest = new PottyReminderUpdateRequest(pottyReminderUpdateModel2);
        y obj14 = new y(this, string);
        final b obj12 = this.d.updatePottyReminderSingle(string2, pottyReminderUpdateRequest).flatMapCompletable(obj14);
        n.e(obj12, "dogoApiClient.updatePottyReminderSingle(\n            reminderId,\n            PottyReminderUpdateRequest(\n                reminder = PottyReminderModel.PottyReminderUpdateModel(\n                    enabled = newState\n                )\n            )\n        ).flatMapCompletable { response ->\n            updateCacheFromResponse(userId, response)\n        }");
        return obj12;
    }

    public final b W(String string, RemindersModel remindersModel2) {
        String time;
        n.f(string, "userId");
        n.f(remindersModel2, "reminderModel");
        if (remindersModel2.getTime() == null) {
            time = "";
        }
        TrainingReminderModel.TrainingReminderUpdateModel trainingReminderUpdateModel = new TrainingReminderModel.TrainingReminderUpdateModel(time, j1.U0(remindersModel2.getDays()), Boolean.valueOf(remindersModel2.isActive()));
        TrainingReminderUpdateRequest trainingReminderUpdateRequest = new TrainingReminderUpdateRequest(trainingReminderUpdateModel);
        l lVar = new l(this, string);
        final b obj6 = this.d.updateTrainingReminderSingle(trainingReminderUpdateRequest).flatMapCompletable(lVar);
        n.e(obj6, "dogoApiClient.updateTrainingReminderSingle(\n            TrainingReminderUpdateRequest(\n                reminder = TrainingReminderModel.TrainingReminderUpdateModel(\n                    time = reminderModel.time ?: \"\",\n                    weekdays = reminderModel.days.toWeekdays(),\n                    enabled = reminderModel.isActive\n                )\n            )\n        ).flatMapCompletable { response ->\n            updateCacheFromResponse(userId, response)\n        }");
        return obj6;
    }

    public final b Z(String string, boolean z2) {
        n.f(string, "userId");
        super(0, 0, Boolean.valueOf(z2), 3, 0);
        TrainingReminderUpdateRequest trainingReminderUpdateRequest = new TrainingReminderUpdateRequest(trainingReminderUpdateModel2);
        z zVar = new z(this, string);
        final b obj10 = this.d.updateTrainingReminderSingle(trainingReminderUpdateRequest).flatMapCompletable(zVar);
        n.e(obj10, "dogoApiClient.updateTrainingReminderSingle(\n            TrainingReminderUpdateRequest(\n                reminder = TrainingReminderModel.TrainingReminderUpdateModel(\n                    enabled = newState\n                )\n            )\n        ).flatMapCompletable { response ->\n            updateCacheFromResponse(userId, response)\n        }");
        return obj10;
    }

    public final b a(String string) {
        n.f(string, "userId");
        o oVar = new o(this);
        b obj2 = j(string).map(oVar).ignoreElement();
        n.e(obj2, "getPottyRemindersByUserId(userId).map { pottyReminders ->\n            pottyReminders.map {\n                pottyReminderNotificationInteractor.cancelPottyReminderNotificationAlarm(it.notificationId)\n            }\n            trainingReminderNotificationInteractor.cancelTrainingReminderNotificationAlarm()\n        }.ignoreElement()");
        return obj2;
    }

    public final b c(String string) {
        n.f(string, "dogId");
        p pVar = new p(this);
        b obj2 = e(string).map(pVar).ignoreElement();
        n.e(obj2, "getPottyReminderByDogId(dogId).map { pottyReminders ->\n            pottyReminders.map {\n                pottyReminderNotificationInteractor.cancelPottyReminderNotificationAlarm(it.notificationId)\n            }\n        }.ignoreElement()");
        return obj2;
    }

    public final a0<List<PottyRemindersItem>> e(String string) {
        n.f(string, "dogId");
        a0 obj2 = this.a.j(string).onErrorReturn(r.a).map(m.a);
        n.e(obj2, "userDao.getDogPottyReminders(dogId).onErrorReturn { emptyList() }.map { reminders -> reminders.map { it.toItem() } }");
        return obj2;
    }

    public final a0<PottyRemindersItem> h(String string) {
        n.f(string, "reminderId");
        a0 obj2 = this.a.a(string).map(v.a);
        n.e(obj2, "userDao.getPottyReminderOrEmpty(reminderId).map { it.toItem() }");
        return obj2;
    }

    public final a0<List<PottyRemindersItem>> j(String string) {
        n.f(string, "userId");
        a0 obj2 = this.a.t(string).onErrorReturn(x.a).map(s.a);
        n.e(obj2, "userDao.getUserPottyReminders(userId).onErrorReturn { emptyList() }.map { reminders -> reminders.map { it.toItem() } }");
        return obj2;
    }

    public final a0<RemindersModel> m(String string) {
        n.f(string, "userId");
        a0 obj2 = this.a.l(string).map(u.a);
        n.e(obj2, "userDao.getTrainingReminder(userId).map { reminders ->\n            val entity = reminders.firstOrNull { it.type == NotificationType.Training.tag }\n            entity?.toItem() ?: RemindersModel()\n        }");
        return obj2;
    }

    public final boolean o(String string) {
        int obj2;
        n.f(string, "userId");
        obj2 = this.g.get(string);
        if ((Boolean)obj2 == null) {
            obj2 = 0;
        } else {
            obj2 = (Boolean)obj2.booleanValue();
        }
        return obj2;
    }
}
