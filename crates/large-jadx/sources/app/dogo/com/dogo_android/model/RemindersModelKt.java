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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0006\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0007¨\u0006\u000c", d2 = {"convertWeekdaysToList", "", "", "weekdayList", "Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "toEntity", "Lapp/dogo/android/persistencedb/room/entity/ReminderEntity;", "Lapp/dogo/externalmodel/model/TrainingReminderModel;", "userId", "", "toItem", "Lapp/dogo/com/dogo_android/model/RemindersModel;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class RemindersModelKt {
    public static final List<Boolean> convertWeekdaysToList(TrainingReminderModel.Weekdays trainingReminderModel$Weekdays) {
        n.f(weekdays, "weekdayList");
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, Boolean.valueOf(weekdays.getMonday()));
        arrayList.add(1, Boolean.valueOf(weekdays.getTuesday()));
        arrayList.add(2, Boolean.valueOf(weekdays.getWednesday()));
        arrayList.add(3, Boolean.valueOf(weekdays.getThursday()));
        arrayList.add(4, Boolean.valueOf(weekdays.getFriday()));
        arrayList.add(5, Boolean.valueOf(weekdays.getSaturday()));
        arrayList.add(6, Boolean.valueOf(weekdays.getSunday()));
        return arrayList;
    }

    public static final ReminderEntity toEntity(TrainingReminderModel trainingReminderModel, String string2) {
        n.f(trainingReminderModel, "<this>");
        n.f(string2, "userId");
        super(trainingReminderModel.getId(), string2, RemindersModelKt.convertWeekdaysToList(trainingReminderModel.getWeekdays()), "Training Reminder", m.Training.getTag(), trainingReminderModel.getTime(), l.Weekly.getTag(), trainingReminderModel.getEnabled());
        return obj10;
    }

    public static final app.dogo.com.dogo_android.model.RemindersModel toItem(ReminderEntity reminderEntity) {
        n.f(reminderEntity, "<this>");
        super(p.N0(reminderEntity.getDays()), 0, reminderEntity.getName(), reminderEntity.getReminderId(), reminderEntity.getType(), reminderEntity.getTime(), reminderEntity.getRepeating(), reminderEntity.isActive(), 0, 258, 0);
        return remindersModel;
    }

    public static final app.dogo.com.dogo_android.model.RemindersModel toItem(TrainingReminderModel trainingReminderModel) {
        n.f(trainingReminderModel, "<this>");
        super(RemindersModelKt.convertWeekdaysToList(trainingReminderModel.getWeekdays()), 0, "Training Reminder", trainingReminderModel.getId(), m.Training.getTag(), trainingReminderModel.getTime(), l.Weekly.getTag(), trainingReminderModel.getEnabled(), 0, 258, 0);
        return obj13;
    }
}
