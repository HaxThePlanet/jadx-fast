package app.dogo.com.dogo_android.repository.domain;

import app.dogo.android.persistencedb.room.entity.PottyReminderEntity;
import app.dogo.com.dogo_android.model.RemindersModelKt;
import app.dogo.externalmodel.model.PottyReminderModel;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002¨\u0006\u0007", d2 = {"toEntity", "Lapp/dogo/android/persistencedb/room/entity/PottyReminderEntity;", "Lapp/dogo/externalmodel/model/PottyReminderModel;", "userId", "", "toItem", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class PottyRemindersItemKt {
    public static final PottyReminderEntity toEntity(PottyReminderModel pottyReminderModel, String string2) {
        n.f(pottyReminderModel, "<this>");
        n.f(string2, "userId");
        super(pottyReminderModel.getId(), pottyReminderModel.getDogId(), string2, RemindersModelKt.convertWeekdaysToList(pottyReminderModel.getWeekdays()), pottyReminderModel.getStartTime(), pottyReminderModel.getEndTime(), Long.valueOf(TimeUnit.MINUTES.toMillis(pottyReminderModel.getIntervalMinutes())), pottyReminderModel.getEnabled());
        return obj12;
    }

    public static final app.dogo.com.dogo_android.repository.domain.PottyRemindersItem toItem(PottyReminderEntity pottyReminderEntity) {
        int longValue;
        n.f(pottyReminderEntity, "<this>");
        Long repeatIntervalMs = pottyReminderEntity.getRepeatIntervalMs();
        if (repeatIntervalMs == null) {
            longValue = 0;
        } else {
            longValue = repeatIntervalMs.longValue();
        }
        super(pottyReminderEntity.getReminderId(), pottyReminderEntity.getDogId(), p.N0(pottyReminderEntity.getDays()), pottyReminderEntity.getStartTime(), pottyReminderEntity.getEndTime(), Long.valueOf(longValue), pottyReminderEntity.isActive());
        return pottyRemindersItem;
    }

    public static final app.dogo.com.dogo_android.repository.domain.PottyRemindersItem toItem(PottyReminderModel pottyReminderModel) {
        n.f(pottyReminderModel, "<this>");
        super(pottyReminderModel.getId(), pottyReminderModel.getDogId(), RemindersModelKt.convertWeekdaysToList(pottyReminderModel.getWeekdays()), pottyReminderModel.getStartTime(), pottyReminderModel.getEndTime(), Long.valueOf(TimeUnit.MINUTES.toMillis(pottyReminderModel.getIntervalMinutes())), pottyReminderModel.getEnabled());
        return pottyRemindersItem;
    }
}
