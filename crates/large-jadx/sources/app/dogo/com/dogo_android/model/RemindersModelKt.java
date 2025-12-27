package app.dogo.com.dogo_android.model;

import app.dogo.android.persistencedb.room.entity.ReminderEntity;
import app.dogo.com.dogo_android.k.l;
import app.dogo.com.dogo_android.k.m;
import app.dogo.externalmodel.model.TrainingReminderModel;
import app.dogo.externalmodel.model.TrainingReminderModel.Weekdays;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: RemindersModel.kt */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0006\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0007¨\u0006\u000c", d2 = {"convertWeekdaysToList", "", "", "weekdayList", "Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "toEntity", "Lapp/dogo/android/persistencedb/room/entity/ReminderEntity;", "Lapp/dogo/externalmodel/model/TrainingReminderModel;", "userId", "", "toItem", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class RemindersModelKt {
    public static final List<Boolean> convertWeekdaysToList(TrainingReminderModel.Weekdays weekdayList) {
        n.f(weekdayList, "weekdayList");
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, Boolean.valueOf(weekdayList.getMonday()));
        arrayList.add(1, Boolean.valueOf(weekdayList.getTuesday()));
        arrayList.add(2, Boolean.valueOf(weekdayList.getWednesday()));
        arrayList.add(3, Boolean.valueOf(weekdayList.getThursday()));
        arrayList.add(4, Boolean.valueOf(weekdayList.getFriday()));
        arrayList.add(5, Boolean.valueOf(weekdayList.getSaturday()));
        arrayList.add(6, Boolean.valueOf(weekdayList.getSunday()));
        return arrayList;
    }

    public static final ReminderEntity toEntity(TrainingReminderModel userId, String str) {
        n.f(userId, "<this>");
        n.f(str, "userId");
        ReminderEntity userId2 = new ReminderEntity(userId.getId(), str, RemindersModelKt.convertWeekdaysToList(userId.getWeekdays()), "Training Reminder", NotificationType.Training.getTag(), userId.getTime(), NotificationRepeating.Weekly.getTag(), userId.getEnabled());
        return userId2;
    }

    public static final RemindersModel toItem(ReminderEntity reminderEntity) {
        n.f(reminderEntity, "<this>");
        RemindersModel remindersModel = new RemindersModel(p.N0(reminderEntity.getDays()), null, reminderEntity.getName(), reminderEntity.getReminderId(), reminderEntity.getType(), reminderEntity.getTime(), reminderEntity.getRepeating(), reminderEntity.isActive(), null, 258, null);
        return remindersModel;
    }

    public static final RemindersModel toItem(TrainingReminderModel trainingReminderModel) {
        n.f(trainingReminderModel, "<this>");
        RemindersModel trainingReminderModel2 = new RemindersModel(RemindersModelKt.convertWeekdaysToList(trainingReminderModel.getWeekdays()), null, "Training Reminder", trainingReminderModel.getId(), NotificationType.Training.getTag(), trainingReminderModel.getTime(), NotificationRepeating.Weekly.getTag(), trainingReminderModel.getEnabled(), null, 258, null);
        return trainingReminderModel2;
    }
}
