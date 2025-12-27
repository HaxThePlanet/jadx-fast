package app.dogo.com.dogo_android.repository.domain;

import app.dogo.android.persistencedb.room.entity.PottyReminderEntity;
import app.dogo.com.dogo_android.model.RemindersModelKt;
import app.dogo.externalmodel.model.PottyReminderModel;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: PottyRemindersItem.kt */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002¨\u0006\u0007", d2 = {"toEntity", "Lapp/dogo/android/persistencedb/room/entity/PottyReminderEntity;", "Lapp/dogo/externalmodel/model/PottyReminderModel;", "userId", "", "toItem", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class PottyRemindersItemKt {
    public static final PottyReminderEntity toEntity(PottyReminderModel userId, String str) {
        n.f(userId, "<this>");
        n.f(str, "userId");
        PottyReminderEntity userId2 = new PottyReminderEntity(userId.getId(), userId.getDogId(), str, RemindersModelKt.convertWeekdaysToList(userId.getWeekdays()), userId.getStartTime(), userId.getEndTime(), Long.valueOf(TimeUnit.MINUTES.toMillis(userId.getIntervalMinutes())), userId.getEnabled());
        return userId2;
    }

    public static final PottyRemindersItem toItem(PottyReminderEntity pottyReminderEntity) {
        int i = 0;
        n.f(pottyReminderEntity, "<this>");
        Long repeatIntervalMs = pottyReminderEntity.getRepeatIntervalMs();
        if (repeatIntervalMs == null) {
            i = 0;
        } else {
            long value = repeatIntervalMs.longValue();
        }
        PottyRemindersItem pottyRemindersItem = new PottyRemindersItem(pottyReminderEntity.getReminderId(), pottyReminderEntity.getDogId(), p.N0(pottyReminderEntity.getDays()), pottyReminderEntity.getStartTime(), pottyReminderEntity.getEndTime(), Long.valueOf(i), pottyReminderEntity.isActive());
        return pottyRemindersItem;
    }

    public static final PottyRemindersItem toItem(PottyReminderModel pottyReminderModel) {
        n.f(pottyReminderModel, "<this>");
        PottyRemindersItem pottyRemindersItem = new PottyRemindersItem(pottyReminderModel.getId(), pottyReminderModel.getDogId(), RemindersModelKt.convertWeekdaysToList(pottyReminderModel.getWeekdays()), pottyReminderModel.getStartTime(), pottyReminderModel.getEndTime(), Long.valueOf(TimeUnit.MINUTES.toMillis(pottyReminderModel.getIntervalMinutes())), pottyReminderModel.getEnabled());
        return pottyRemindersItem;
    }
}
