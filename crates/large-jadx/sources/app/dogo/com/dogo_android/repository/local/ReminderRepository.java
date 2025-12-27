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
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.h0.j1;
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

/* compiled from: ReminderRepository.kt */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0011J\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\u0006\u0010\u0017\u001a\u00020\u0011J\u0014\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001d\u001a\u00020\u0011J\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\u0006\u0010\u0015\u001a\u00020\u0011J\u0014\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020 0\u00192\u0006\u0010\u0015\u001a\u00020\u0011J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0011J\u0016\u0010\"\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u001bJ\u0016\u0010$\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010#\u001a\u00020 J\u000e\u0010%\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011J\u0016\u0010&\u001a\u00020'2\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u00020)0\u001aH\u0002J<\u0010*\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020)0\u001a0+2\u0006\u0010\u0015\u001a\u00020\u00112\u0008\u0010-\u001a\u0004\u0018\u00010 2\u000c\u0010.\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u000e\u0010/\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011J\u0016\u00100\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u00101\u001a\u000202J\u0016\u00103\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u001bJ\u001e\u00105\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0012J\u0016\u00107\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u00108\u001a\u00020 J\u0012\u00109\u001a\u00020'2\u0008\u0010:\u001a\u0004\u0018\u00010,H\u0002J\u0016\u0010;\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0012R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "", "userDao", "Lapp/dogo/android/persistencedb/room/dao/UserEntityDao;", "trainingReminderNotificationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/TrainingReminderNotificationInteractor;", "pottyReminderNotificationInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/PottyReminderNotificationInteractor;", "dogoApiClient", "Lapp/dogo/android/network/DogoApiClient;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lapp/dogo/android/persistencedb/room/dao/UserEntityDao;Lapp/dogo/com/dogo_android/repository/interactor/TrainingReminderNotificationInteractor;Lapp/dogo/com/dogo_android/repository/interactor/PottyReminderNotificationInteractor;Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "hasReminderSetLookupTable", "", "", "", "cancelAllNotifications", "Lio/reactivex/Completable;", "userId", "deactivatePottyRemindersForDog", "dogId", "getPottyReminderByDogId", "Lio/reactivex/Single;", "", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "getPottyReminderOrEmptyById", "reminderId", "getPottyRemindersByUserId", "getTrainingReminderOrEmptyByUserId", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "hasUserTrainingReminder", "savePottyReminder", "reminder", "saveTrainingReminder", "setupAllUsersActivePottyReminders", "updateAllPottyReminderNotifications", "", "pottyReminderEntity", "Lapp/dogo/android/persistencedb/room/entity/PottyReminderEntity;", "updateAppState", "Lkotlin/Pair;", "Lapp/dogo/android/persistencedb/room/entity/ReminderEntity;", "trainingReminderOrEmpty", "pottyReminders", "updateAppStateFromRoom", "updateCacheFromResponse", "response", "Lapp/dogo/externalmodel/model/responses/ReminderResponse;", "updatePottyReminder", "pottyRemindersItem", "updatePottyReminderState", "newState", "updateTrainingReminder", "reminderModel", "updateTrainingReminderNotifications", "trainingReminderEntity", "updateTrainingReminderState", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l1, reason: from kotlin metadata */
public final class ReminderRepository {

    /* renamed from: a, reason: from kotlin metadata */
    private final q0 dogoApiClient;
    /* renamed from: b, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.s.a.o3 hasReminderSetLookupTable;
    /* renamed from: c, reason: from kotlin metadata */
    private final h3 pottyReminderNotificationInteractor;
    /* renamed from: d, reason: from kotlin metadata */
    private final DogoApiClient remoteConfigService;
    /* renamed from: e, reason: from kotlin metadata */
    private final r2 tracker;
    /* renamed from: f, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.w.o3 trainingReminderNotificationInteractor;
    /* renamed from: g, reason: from kotlin metadata */
    private final Map<String, Boolean> userDao = new LinkedHashMap<>();
    public l1(q0 q0Var, app.dogo.com.dogo_android.s.a.o3 o3Var, h3 h3Var, DogoApiClient dogoApiClient, r2 r2Var, app.dogo.com.dogo_android.w.o3 o3Var2) {
        n.f(q0Var, "userDao");
        n.f(o3Var, "trainingReminderNotificationInteractor");
        n.f(h3Var, "pottyReminderNotificationInteractor");
        n.f(dogoApiClient, "dogoApiClient");
        n.f(r2Var, "remoteConfigService");
        n.f(o3Var2, "tracker");
        super();
        this.dogoApiClient = q0Var;
        this.hasReminderSetLookupTable = o3Var;
        this.pottyReminderNotificationInteractor = h3Var;
        this.remoteConfigService = dogoApiClient;
        this.tracker = r2Var;
        this.trainingReminderNotificationInteractor = o3Var2;
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
    }

    private static final f H(l1 l1Var, String str, ReminderResponse reminderResponse) {
        n.f(l1Var, "this$0");
        n.f(str, "$userId");
        n.f(reminderResponse, "response");
        return l1Var.R(str, reminderResponse);
    }

    private static final f J(l1 l1Var, String str, ReminderResponse reminderResponse) {
        n.f(l1Var, "this$0");
        n.f(str, "$userId");
        n.f(reminderResponse, "response");
        return l1Var.R(str, reminderResponse);
    }

    private static final w L(l1 l1Var, String str, List list) {
        n.f(l1Var, "this$0");
        n.f(str, "$userId");
        n.f(list, "reminders");
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        final Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((PottyRemindersItem)it.next().toEntity(str));
        }
        l1Var.getPottyReminderOrEmptyById(arrayList);
        return w.a;
    }

    /* renamed from: M, reason: from kotlin metadata */
    private final void getPottyReminderOrEmptyById(List<PottyReminderEntity> reminderId) {
        PottyRemindersItem item;
        final Iterator it = reminderId.iterator();
        while (it.hasNext()) {
            Object item2 = it.next();
            item = PottyRemindersItemKt.toItem(item2);
            new ArrayList(p.r(reminderId, 10)).add(w.a);
        }
    }

    private final o<ReminderEntity, List<PottyReminderEntity>> N(String str, RemindersModel remindersModel, List<PottyRemindersItem> list) {
        boolean z = true;
        int i;
        ReminderEntity entity = null;
        i = 0;
        int r2 = i;
        if (i == 0) {
            int i4 = 0;
        } else {
            entity = remindersModel.toEntity(str);
        }
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((PottyRemindersItem)it.next().toEntity(str));
        }
        getPottyRemindersByUserId(entity);
        getPottyReminderOrEmptyById(arrayList);
        if (entity == null) {
        }
        this.userDao.put(str, Boolean.valueOf(z));
        return u.a(entity, arrayList);
    }

    private static final f P(l1 l1Var, String str, RemindersModel remindersModel) {
        n.f(l1Var, "this$0");
        n.f(str, "$userId");
        n.f(remindersModel, "trainingReminderOrEmpty");
        return l1Var.j(str).flatMapCompletable(new app.dogo.com.dogo_android.repository.local.j(l1Var, str, remindersModel));
    }

    private static final f Q(l1 l1Var, String str, RemindersModel remindersModel, List list) {
        n.f(l1Var, "this$0");
        n.f(str, "$userId");
        n.f(remindersModel, "$trainingReminderOrEmpty");
        n.f(list, "pottyReminders");
        l1Var.N(str, remindersModel, list);
        return b.f();
    }

    private static final f T(l1 l1Var, String str, ReminderResponse reminderResponse) {
        n.f(l1Var, "this$0");
        n.f(str, "$userId");
        n.f(reminderResponse, "response");
        return l1Var.R(str, reminderResponse);
    }

    private static final f V(l1 l1Var, String str, ReminderResponse reminderResponse) {
        n.f(l1Var, "this$0");
        n.f(str, "$userId");
        n.f(reminderResponse, "response");
        return l1Var.R(str, reminderResponse);
    }

    private static final f X(l1 l1Var, String str, ReminderResponse reminderResponse) {
        n.f(l1Var, "this$0");
        n.f(str, "$userId");
        n.f(reminderResponse, "response");
        return l1Var.R(str, reminderResponse);
    }

    /* renamed from: Y, reason: from kotlin metadata */
    private final void getPottyRemindersByUserId(ReminderEntity userId) {
        boolean active;
        if (userId != null) {
            if (this.tracker.V() || !userId.isActive()) {
                this.hasReminderSetLookupTable.a();
            } else {
                this.hasReminderSetLookupTable.setTrainingReminderNotification(RemindersModelKt.toItem(userId));
            }
        }
    }

    private static final f a0(l1 l1Var, String str, ReminderResponse reminderResponse) {
        n.f(l1Var, "this$0");
        n.f(str, "$userId");
        n.f(reminderResponse, "response");
        return l1Var.R(str, reminderResponse);
    }

    /* renamed from: b, reason: from kotlin metadata */
    private static final w savePottyReminder(l1 userId, List reminder) {
        n.f(userId, "this$0");
        n.f(reminder, "pottyReminders");
        Iterator it = reminder.iterator();
        while (it.hasNext()) {
            userId.pottyReminderNotificationInteractor.isDayCorrect((PottyRemindersItem)it.next().getNotificationId());
            new ArrayList(p.r(reminder, 10)).add(w.a);
        }
        TrainingReminderNotificationInteractor.c(userId.hasReminderSetLookupTable, 0, 1, null);
        return w.a;
    }

    /* renamed from: d, reason: from kotlin metadata */
    private static final List saveTrainingReminder(l1 userId, List reminder) {
        n.f(userId, "this$0");
        n.f(reminder, "pottyReminders");
        ArrayList arrayList = new ArrayList(p.r(reminder, 10));
        final Iterator it = reminder.iterator();
        while (it.hasNext()) {
            userId.pottyReminderNotificationInteractor.isDayCorrect((PottyRemindersItem)it.next().getNotificationId());
            arrayList.add(w.a);
        }
        return arrayList;
    }

    /* renamed from: f, reason: from kotlin metadata */
    private static final List getTrainingReminderOrEmptyByUserId(Throwable userId) {
        n.f(userId, "it");
        return p.g();
    }

    /* renamed from: g, reason: from kotlin metadata */
    private static final List hasUserTrainingReminder(List userId) {
        n.f(userId, "reminders");
        ArrayList arrayList = new ArrayList(p.r(userId, 10));
        final Iterator it = userId.iterator();
        while (it.hasNext()) {
            arrayList.add(PottyRemindersItemKt.toItem((PottyReminderEntity)it.next()));
        }
        return arrayList;
    }

    /* renamed from: i, reason: from kotlin metadata */
    private static final PottyRemindersItem setupAllUsersActivePottyReminders(PottyReminderEntity userId) {
        n.f(userId, "it");
        return PottyRemindersItemKt.toItem(userId);
    }

    /* renamed from: k, reason: from kotlin metadata */
    private static final List updateAllPottyReminderNotifications(Throwable pottyReminderEntity) {
        n.f(pottyReminderEntity, "it");
        return p.g();
    }

    /* renamed from: l, reason: from kotlin metadata */
    private static final List updateAppStateFromRoom(List userId) {
        n.f(userId, "reminders");
        ArrayList arrayList = new ArrayList(p.r(userId, 10));
        final Iterator it = userId.iterator();
        while (it.hasNext()) {
            arrayList.add(PottyRemindersItemKt.toItem((PottyReminderEntity)it.next()));
        }
        return arrayList;
    }

    /* renamed from: n, reason: from kotlin metadata */
    private static final RemindersModel updateTrainingReminderNotifications(List trainingReminderEntity) {
        Object obj;
        RemindersModel remindersModel = null;
        boolean z;
        String tag;
        item = "reminders";
        n.f(trainingReminderEntity, item);
        final Iterator it = trainingReminderEntity.iterator();
        while (it.hasNext()) {
            if (n.b((ReminderEntity)item.getType(), NotificationType.Training.getTag())) {
                break;
            }
        }
        if (obj != null) {
            remindersModel = RemindersModelKt.toItem(obj);
        }
        if (remindersModel == null) {
            Map map = null;
            String str = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            String str5 = null;
            boolean z2 = false;
            Map map2 = null;
            int i2 = 511;
            kotlin.d0.d.g gVar = null;
            remindersModel = new RemindersModel(null, map, str, str2, str3, str4, str5, z2, map2, i2, gVar);
        }
        return remindersModel;
    }

    /* renamed from: G, reason: from kotlin metadata */
    public final b updateTrainingReminder(String userId, PottyRemindersItem reminderModel) {
        String endTime;
        int i = 0;
        n.f(userId, "userId");
        n.f(reminderModel, "reminder");
        if (reminderModel.getEndTime() == null) {
            endTime = "";
        }
        Long repeatIntervalMs = reminderModel.getRepeatIntervalMs();
        if (repeatIntervalMs == null) {
            i = 0;
        } else {
            long value = repeatIntervalMs.longValue();
        }
        PottyReminderModel_PottyReminderCreateModel reminderModel2 = new PottyReminderModel_PottyReminderCreateModel(reminderModel.getStartTime(), endTime, TimeUnit.MILLISECONDS.toMinutes(i), weekdays, app.dogo.com.dogo_android.util.extensionfunction.j1.U0(reminderModel.getDays()), reminderModel.getDogId());
        PottyReminderRequest pottyReminderRequest = new PottyReminderRequest(reminderModel2);
        final b flatMapCompletable = this.remoteConfigService.savePottyReminderSingle(pottyReminderRequest).flatMapCompletable(new app.dogo.com.dogo_android.repository.local.q(this, userId));
        n.e(flatMapCompletable, "dogoApiClient.savePottyReminderSingle(\n            PottyReminderRequest(\n                reminder = PottyReminderModel.PottyReminderCreateModel(\n                    dogId = reminder.dogId,\n                    endTime = reminder.endTime ?: \"\",\n                    startTime = reminder.startTime,\n                    intervalMinutes = TimeUnit.MILLISECONDS.toMinutes(reminder.repeatIntervalMs ?: 0),\n                    weekdays = reminder.days.toWeekdays()\n                )\n            )\n        ).flatMapCompletable { response ->\n            updateCacheFromResponse(userId, response)\n        }");
        return flatMapCompletable;
    }

    /* renamed from: I, reason: from kotlin metadata */
    public final b updateTrainingReminderState(String userId, RemindersModel newState) {
        String time;
        n.f(userId, "userId");
        n.f(newState, "reminder");
        if (newState.getTime() == null) {
            time = "";
        }
        TrainingReminderModel_TrainingReminderCreateModel trainingReminderModel_TrainingReminderCreateModel = new TrainingReminderModel_TrainingReminderCreateModel(time, app.dogo.com.dogo_android.util.extensionfunction.j1.U0(newState.getDays()));
        TrainingReminderRequest trainingReminderRequest = new TrainingReminderRequest(trainingReminderModel_TrainingReminderCreateModel);
        final b flatMapCompletable = this.remoteConfigService.saveTrainingReminderSingle(trainingReminderRequest).flatMapCompletable(new app.dogo.com.dogo_android.repository.local.k(this, userId));
        n.e(flatMapCompletable, "dogoApiClient.saveTrainingReminderSingle(\n            TrainingReminderRequest(\n                reminder = TrainingReminderModel.TrainingReminderCreateModel(\n                    time = reminder.time ?: \"\",\n                    weekdays = reminder.days.toWeekdays()\n                )\n            )\n        ).flatMapCompletable { response ->\n            updateCacheFromResponse(userId, response)\n        }");
        return flatMapCompletable;
    }

    public final b K(String str) {
        n.f(str, "userId");
        b ignoreElement = j(str).map(new app.dogo.com.dogo_android.repository.local.t(this, str)).ignoreElement();
        n.e(ignoreElement, "getPottyRemindersByUserId(userId).map { reminders ->\n            updateAllPottyReminderNotifications(reminders.map { it.toEntity(userId) })\n        }.ignoreElement()");
        return ignoreElement;
    }

    public final b O(String str) {
        n.f(str, "userId");
        final b flatMapCompletable = m(str).flatMapCompletable(new app.dogo.com.dogo_android.repository.local.n(this, str));
        n.e(flatMapCompletable, "getTrainingReminderOrEmptyByUserId(userId).flatMapCompletable { trainingReminderOrEmpty ->\n            getPottyRemindersByUserId(userId).flatMapCompletable { pottyReminders ->\n                updateAppState(userId, trainingReminderOrEmpty, pottyReminders)\n                Completable.complete()\n            }\n        }");
        return flatMapCompletable;
    }

    public final b R(String str, ReminderResponse reminderResponse) {
        RemindersModel item = null;
        b currentDogId;
        n.f(str, "userId");
        n.f(reminderResponse, "response");
        app.dogo.externalmodel.model.TrainingReminderModel trainingReminder = reminderResponse.getTrainingReminder();
        if (trainingReminder == null) {
            int i3 = 0;
        } else {
            item = RemindersModelKt.toItem(trainingReminder);
        }
        List pottyReminders = reminderResponse.getPottyReminders();
        ArrayList arrayList = new ArrayList(p.r(pottyReminders, 10));
        Iterator it = pottyReminders.iterator();
        while (it.hasNext()) {
            arrayList.add(PottyRemindersItemKt.toItem((PottyReminderModel)it.next()));
        }
        o oVar = N(str, item, arrayList);
        Object obj2 = oVar.a();
        int i2 = 1;
        int i4 = 0;
        if (obj2 != null) {
            this.trainingReminderNotificationInteractor.onConversionDataFail(RemindersModelKt.toItem(obj2));
            ReminderEntity[] arr = new ReminderEntity[i2];
            currentDogId = this.dogoApiClient.getCurrentDogId(obj2);
        } else {
            n.e(b.f(), "{\n            Completable.complete()\n        }");
        }
        Object[] array = (List)oVar.b().toArray(new PottyReminderEntity[i4]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        f[] arr2 = new f[2];
        b bVar = b.p(new f[] { currentDogId, this.dogoApiClient.getTrainingReminder((PottyReminderEntity[])Arrays.copyOf(array, array.length)).ignoreElement() });
        n.e(bVar, "mergeArray(\n            trainingReminderUpdate,\n            pottyReminderUpdate\n        )");
        return bVar;
    }

    public final b S(String str, PottyRemindersItem pottyRemindersItem) {
        n.f(str, "userId");
        n.f(pottyRemindersItem, "pottyRemindersItem");
        PottyReminderModel_PottyReminderUpdateModel pottyReminderModel_PottyReminderUpdateModel = new PottyReminderModel_PottyReminderUpdateModel(pottyRemindersItem.getStartTime(), pottyRemindersItem.getEndTime(), pottyRemindersItem.getIntervalMinutes(), app.dogo.com.dogo_android.util.extensionfunction.j1.U0(pottyRemindersItem.getDays()), Boolean.valueOf(pottyRemindersItem.isActive()));
        final b flatMapCompletable = this.remoteConfigService.updatePottyReminderSingle(pottyRemindersItem.getReminderId(), new PottyReminderUpdateRequest(pottyReminderModel_PottyReminderUpdateModel)).flatMapCompletable(new app.dogo.com.dogo_android.repository.local.w(this, str));
        n.e(flatMapCompletable, "dogoApiClient.updatePottyReminderSingle(\n            pottyRemindersItem.reminderId,\n            PottyReminderUpdateRequest(\n                reminder = PottyReminderModel.PottyReminderUpdateModel(\n                    startTime = pottyRemindersItem.startTime,\n                    endTime = pottyRemindersItem.endTime,\n                    intervalMinutes = pottyRemindersItem.getIntervalMinutes(),\n                    weekdays = pottyRemindersItem.days.toWeekdays(),\n                    enabled = pottyRemindersItem.isActive\n                )\n            )\n        ).flatMapCompletable { response ->\n            updateCacheFromResponse(userId, response)\n        }");
        return flatMapCompletable;
    }

    public final b U(String str, String str2, boolean z) {
        n.f(str, "userId");
        n.f(str2, "reminderId");
        PottyReminderModel_PottyReminderUpdateModel pottyReminderModel_PottyReminderUpdateModel = new PottyReminderModel_PottyReminderUpdateModel(null, null, null, null, Boolean.valueOf(z), 15, null);
        final b flatMapCompletable = this.remoteConfigService.updatePottyReminderSingle(str2, new PottyReminderUpdateRequest(pottyReminderModel_PottyReminderUpdateModel)).flatMapCompletable(new app.dogo.com.dogo_android.repository.local.y(this, str));
        n.e(flatMapCompletable, "dogoApiClient.updatePottyReminderSingle(\n            reminderId,\n            PottyReminderUpdateRequest(\n                reminder = PottyReminderModel.PottyReminderUpdateModel(\n                    enabled = newState\n                )\n            )\n        ).flatMapCompletable { response ->\n            updateCacheFromResponse(userId, response)\n        }");
        return flatMapCompletable;
    }

    public final b W(String str, RemindersModel remindersModel) {
        String time;
        n.f(str, "userId");
        n.f(remindersModel, "reminderModel");
        if (remindersModel.getTime() == null) {
            time = "";
        }
        TrainingReminderModel_TrainingReminderUpdateModel trainingReminderModel_TrainingReminderUpdateModel = new TrainingReminderModel_TrainingReminderUpdateModel(time, app.dogo.com.dogo_android.util.extensionfunction.j1.U0(remindersModel.getDays()), Boolean.valueOf(remindersModel.isActive()));
        TrainingReminderUpdateRequest trainingReminderUpdateRequest = new TrainingReminderUpdateRequest(trainingReminderModel_TrainingReminderUpdateModel);
        final b flatMapCompletable = this.remoteConfigService.updateTrainingReminderSingle(trainingReminderUpdateRequest).flatMapCompletable(new app.dogo.com.dogo_android.repository.local.l(this, str));
        n.e(flatMapCompletable, "dogoApiClient.updateTrainingReminderSingle(\n            TrainingReminderUpdateRequest(\n                reminder = TrainingReminderModel.TrainingReminderUpdateModel(\n                    time = reminderModel.time ?: \"\",\n                    weekdays = reminderModel.days.toWeekdays(),\n                    enabled = reminderModel.isActive\n                )\n            )\n        ).flatMapCompletable { response ->\n            updateCacheFromResponse(userId, response)\n        }");
        return flatMapCompletable;
    }

    public final b Z(String str, boolean z) {
        n.f(str, "userId");
        TrainingReminderModel_TrainingReminderUpdateModel trainingReminderModel_TrainingReminderUpdateModel = new TrainingReminderModel_TrainingReminderUpdateModel(null, null, Boolean.valueOf(z), 3, null);
        final b flatMapCompletable = this.remoteConfigService.updateTrainingReminderSingle(new TrainingReminderUpdateRequest(trainingReminderModel_TrainingReminderUpdateModel)).flatMapCompletable(new app.dogo.com.dogo_android.repository.local.z(this, str));
        n.e(flatMapCompletable, "dogoApiClient.updateTrainingReminderSingle(\n            TrainingReminderUpdateRequest(\n                reminder = TrainingReminderModel.TrainingReminderUpdateModel(\n                    enabled = newState\n                )\n            )\n        ).flatMapCompletable { response ->\n            updateCacheFromResponse(userId, response)\n        }");
        return flatMapCompletable;
    }

    public final b a(String str) {
        n.f(str, "userId");
        b ignoreElement = j(str).map(new app.dogo.com.dogo_android.repository.local.o(this)).ignoreElement();
        n.e(ignoreElement, "getPottyRemindersByUserId(userId).map { pottyReminders ->\n            pottyReminders.map {\n                pottyReminderNotificationInteractor.cancelPottyReminderNotificationAlarm(it.notificationId)\n            }\n            trainingReminderNotificationInteractor.cancelTrainingReminderNotificationAlarm()\n        }.ignoreElement()");
        return ignoreElement;
    }

    public final b c(String str) {
        n.f(str, "dogId");
        b ignoreElement = e(str).map(new app.dogo.com.dogo_android.repository.local.p(this)).ignoreElement();
        n.e(ignoreElement, "getPottyReminderByDogId(dogId).map { pottyReminders ->\n            pottyReminders.map {\n                pottyReminderNotificationInteractor.cancelPottyReminderNotificationAlarm(it.notificationId)\n            }\n        }.ignoreElement()");
        return ignoreElement;
    }

    public final a0<List<PottyRemindersItem>> e(String str) {
        n.f(str, "dogId");
        a0 map = this.dogoApiClient.getDogPottyReminders(str).onErrorReturn(app.dogo.com.dogo_android.repository.local.r.a).map(app.dogo.com.dogo_android.repository.local.m.a);
        n.e(map, "userDao.getDogPottyReminders(dogId).onErrorReturn { emptyList() }.map { reminders -> reminders.map { it.toItem() } }");
        return map;
    }

    public final a0<PottyRemindersItem> h(String str) {
        n.f(str, "reminderId");
        a0 map = this.dogoApiClient.doesUserExists(str).map(app.dogo.com.dogo_android.repository.local.v.a);
        n.e(map, "userDao.getPottyReminderOrEmpty(reminderId).map { it.toItem() }");
        return map;
    }

    public final a0<List<PottyRemindersItem>> j(String str) {
        n.f(str, "userId");
        a0 map = this.dogoApiClient.getUser(str).onErrorReturn(app.dogo.com.dogo_android.repository.local.x.a).map(app.dogo.com.dogo_android.repository.local.s.a);
        n.e(map, "userDao.getUserPottyReminders(userId).onErrorReturn { emptyList() }.map { reminders -> reminders.map { it.toItem() } }");
        return map;
    }

    public final a0<RemindersModel> m(String str) {
        n.f(str, "userId");
        a0 map = this.dogoApiClient.getPottyReminderOrEmpty(str).map(app.dogo.com.dogo_android.repository.local.u.a);
        n.e(map, "userDao.getTrainingReminder(userId).map { reminders ->\n            val entity = reminders.firstOrNull { it.type == NotificationType.Training.tag }\n            entity?.toItem() ?: RemindersModel()\n        }");
        return map;
    }

    public final boolean o(String str) {
        boolean booleanValue = false;
        n.f(str, "userId");
        Object value = this.userDao.get(str);
        if (value == null) {
            int i = 0;
        } else {
            booleanValue = value.booleanValue();
        }
        return booleanValue;
    }

    /* renamed from: A, reason: from kotlin metadata */
    public static /* synthetic */ RemindersModel cancelAllNotifications(List userId) {
        return ReminderRepository.updateTrainingReminderNotifications(userId);
    }

    /* renamed from: B, reason: from kotlin metadata */
    public static /* synthetic */ PottyRemindersItem deactivatePottyRemindersForDog(PottyReminderEntity dogId) {
        return ReminderRepository.setupAllUsersActivePottyReminders(dogId);
    }

    /* renamed from: C, reason: from kotlin metadata */
    public static /* synthetic */ f updateAppState(l1 userId, String trainingReminderOrEmpty, ReminderResponse pottyReminders) {
        return ReminderRepository.T(userId, trainingReminderOrEmpty, pottyReminders);
    }

    /* renamed from: D, reason: from kotlin metadata */
    public static /* synthetic */ List getPottyReminderByDogId(Throwable dogId) {
        return ReminderRepository.updateAllPottyReminderNotifications(dogId);
    }

    /* renamed from: E, reason: from kotlin metadata */
    public static /* synthetic */ f updatePottyReminderState(l1 userId, String reminderId, ReminderResponse newState) {
        return ReminderRepository.V(userId, reminderId, newState);
    }

    public static /* synthetic */ f F(l1 l1Var, String str, ReminderResponse reminderResponse) {
        return ReminderRepository.a0(l1Var, str, reminderResponse);
    }

    public static /* synthetic */ f p(l1 l1Var, String str, RemindersModel remindersModel, List list) {
        return ReminderRepository.Q(l1Var, str, remindersModel, list);
    }

    public static /* synthetic */ f q(l1 l1Var, String str, ReminderResponse reminderResponse) {
        return ReminderRepository.J(l1Var, str, reminderResponse);
    }

    public static /* synthetic */ f r(l1 l1Var, String str, ReminderResponse reminderResponse) {
        return ReminderRepository.X(l1Var, str, reminderResponse);
    }

    public static /* synthetic */ List s(List list) {
        return ReminderRepository.hasUserTrainingReminder(list);
    }

    public static /* synthetic */ f t(l1 l1Var, String str, RemindersModel remindersModel) {
        return ReminderRepository.P(l1Var, str, remindersModel);
    }

    /* renamed from: u, reason: from kotlin metadata */
    public static /* synthetic */ w updateCacheFromResponse(l1 userId, List response) {
        return ReminderRepository.savePottyReminder(userId, response);
    }

    /* renamed from: v, reason: from kotlin metadata */
    public static /* synthetic */ List updatePottyReminder(l1 userId, List pottyRemindersItem) {
        return ReminderRepository.saveTrainingReminder(userId, pottyRemindersItem);
    }

    public static /* synthetic */ f w(l1 l1Var, String str, ReminderResponse reminderResponse) {
        return ReminderRepository.H(l1Var, str, reminderResponse);
    }

    public static /* synthetic */ List x(Throwable th) {
        return ReminderRepository.getTrainingReminderOrEmptyByUserId(th);
    }

    public static /* synthetic */ List y(List list) {
        return ReminderRepository.updateAppStateFromRoom(list);
    }

    public static /* synthetic */ w z(l1 l1Var, String str, List list) {
        return ReminderRepository.L(l1Var, str, list);
    }
}
