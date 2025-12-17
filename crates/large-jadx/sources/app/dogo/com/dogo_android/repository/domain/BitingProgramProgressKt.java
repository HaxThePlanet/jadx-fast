package app.dogo.com.dogo_android.repository.domain;

import app.dogo.externalmodel.model.BitingProgressModel;
import app.dogo.externalmodel.model.BitingProgressModel.TrickVariationEvent;
import app.dogo.externalmodel.model.PottyProgramProgressModel.ReadStatus;
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
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003", d2 = {"toBitingProgramProgressItem", "Lapp/dogo/com/dogo_android/repository/domain/BitingProgramProgress;", "Lapp/dogo/externalmodel/model/BitingProgressModel;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class BitingProgramProgressKt {
    public static final app.dogo.com.dogo_android.repository.domain.BitingProgramProgress toBitingProgramProgressItem(BitingProgressModel bitingProgressModel) {
        boolean booleanValue;
        int longValue;
        Object value;
        String str2;
        boolean read;
        String str;
        int knowledge;
        app.dogo.com.dogo_android.repository.domain.BitingProgramProgress.TrickVariationEvent trickVariationEvent;
        String trickId;
        String variationId;
        n.f(bitingProgressModel, "<this>");
        Long stoppedTimeMs = bitingProgressModel.getStoppedTimeMs();
        if (stoppedTimeMs == null) {
            longValue = 0;
        } else {
            longValue = stoppedTimeMs.longValue();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator = bitingProgressModel.getArticles().entrySet().iterator();
        while (iterator.hasNext()) {
            value = iterator.next();
            if ((PottyProgramProgressModel.ReadStatus)(Map.Entry)value.getValue().isRead()) {
            }
            linkedHashMap.put(value.getKey(), value.getValue());
        }
        String certificatePdfUrl = bitingProgressModel.getCertificatePdfUrl();
        String str4 = "";
        str2 = certificatePdfUrl == null ? str4 : certificatePdfUrl;
        String certificateImageUrl = bitingProgressModel.getCertificateImageUrl();
        str = certificateImageUrl == null ? str4 : certificateImageUrl;
        java.util.List tricks = bitingProgressModel.getTricks();
        ArrayList arrayList = new ArrayList(p.r(tricks, 10));
        Iterator iterator2 = tricks.iterator();
        while (iterator2.hasNext()) {
            Object next3 = iterator2.next();
            if (next3.getVariationId() == null) {
            }
            trickVariationEvent = new BitingProgramProgress.TrickVariationEvent((BitingProgressModel.TrickVariationEvent)next3.getTrickId(), variationId, next3.getKnowledge());
            arrayList.add(trickVariationEvent);
            variationId = str4;
        }
        Boolean recommended = bitingProgressModel.isRecommended();
        if (recommended == null) {
            booleanValue = 0;
        } else {
            booleanValue = recommended.booleanValue();
        }
        super(0, bitingProgressModel.getStartedTimeMs(), obj4, longValue, obj6, str2, str, p.L0(linkedHashMap.keySet()), arrayList, bitingProgressModel.getProgramIsCompleted(), bitingProgressModel.getArticlesAreCompleted(), bitingProgressModel.getTricksAreCompleted(), bitingProgressModel.getArticleCompletionPercentage(), bitingProgressModel.getTrickCompletionPercentage(), booleanValue, 1, 0);
        return bitingProgramProgress;
    }
}
