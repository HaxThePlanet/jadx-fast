package app.dogo.com.dogo_android.repository.domain;

import app.dogo.com.dogo_android.s.b.f1.b;
import app.dogo.externalmodel.model.DogLogModel;
import app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus;
import app.dogo.externalmodel.model.PottyProgramProgressModel.ReadStatus;
import app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays;
import app.dogo.externalmodel.model.PottyProgramProgressModel.Streaks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003", d2 = {"toPottyProgramProgressItem", "Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class PottyProgramProgressKt {
    public static final app.dogo.com.dogo_android.repository.domain.PottyProgramProgress toPottyProgramProgressItem(PottyProgramProgressModel.ProgramStatus pottyProgramProgressModel$ProgramStatus) {
        int cleanDaysStreak;
        int logStreak;
        boolean booleanValue2;
        boolean booleanValue;
        long longValue;
        int i;
        int i3;
        Object value;
        boolean read;
        int i2;
        boolean z;
        f1.b bVar;
        boolean z2;
        String str3;
        String str2;
        String dogId;
        String str;
        String str4;
        long l;
        long eventTimeMs;
        n.f(programStatus, "<this>");
        Long stoppedTimeMs = programStatus.getStoppedTimeMs();
        if (stoppedTimeMs == null) {
            longValue = 0;
        } else {
            longValue = stoppedTimeMs.longValue();
        }
        cleanDaysStreak = programStatus.getStreaks().getCleanDaysStreak();
        int i4 = 0;
        if (cleanDaysStreak == null) {
            i = i4;
        } else {
            i = cleanDaysStreak;
        }
        logStreak = programStatus.getStreaks().getLogStreak();
        if (logStreak == null) {
            i3 = i4;
        } else {
            i3 = logStreak;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator = programStatus.getArticles().entrySet().iterator();
        while (iterator.hasNext()) {
            value = iterator.next();
            if ((PottyProgramProgressModel.ReadStatus)(Map.Entry)value.getValue().isRead()) {
            }
            linkedHashMap.put(value.getKey(), value.getValue());
        }
        java.util.List logs = programStatus.getLogs();
        ArrayList arrayList = new ArrayList(p.r(logs, 10));
        Iterator iterator2 = logs.iterator();
        for (DogLogModel next3 : iterator2) {
            eventTimeMs = next3.getEventTimeMs();
            super(next3.getId(), next3.getDogId(), next3.getType(), eventTimeMs, eventTimeMs);
            arrayList.add(bVar2);
        }
        booleanValue2 = programStatus.isRecommended();
        if (booleanValue2 == null) {
            z = i4;
        } else {
            z = booleanValue2;
        }
        booleanValue = programStatus.isCompleted();
        if (booleanValue == null) {
            z2 = i4;
        } else {
            z2 = booleanValue;
        }
        String certificatePdfUrl = programStatus.getCertificatePdfUrl();
        String str6 = "";
        str2 = certificatePdfUrl == null ? str6 : certificatePdfUrl;
        String certificateImageUrl = programStatus.getCertificateImageUrl();
        str = certificateImageUrl == null ? str6 : certificateImageUrl;
        super(0, programStatus.getStartedTimeMs(), obj4, longValue, obj6, i, i3, p.L0(linkedHashMap.keySet()), arrayList, z, z2, str2, str, 1, 0);
        return pottyProgramProgress;
    }
}
