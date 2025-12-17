package androidx.compose.ui.autofill;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillValue;
import androidx.compose.ui.geometry.Rect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004H\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0008H\u0001¨\u0006\t", d2 = {"performAutofill", "", "Landroidx/compose/ui/autofill/AndroidAutofill;", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "populateViewStructure", "root", "Landroid/view/ViewStructure;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidAutofill_androidKt {
    public static final void performAutofill(androidx.compose.ui.autofill.AndroidAutofill $this$performAutofill, SparseArray<AutofillValue> values) {
        int index;
        int keyAt;
        Object obj;
        androidx.compose.ui.autofill.AutofillTree autofillTree;
        String string;
        index = 0;
        while (index < values.size()) {
            keyAt = values.keyAt(index);
            obj = values.get(keyAt);
            string = "An operation is not implemented: ";
            index++;
            $this$performAutofill.getAutofillTree().performAutofill(keyAt, AutofillApi26Helper.INSTANCE.textValue(obj).toString());
        }
    }

    public static final void populateViewStructure(androidx.compose.ui.autofill.AndroidAutofill $this$populateViewStructure, ViewStructure root) {
        ViewStructure boundingBox;
        int $this$fastRoundToInt$iv;
        Object value;
        int iNSTANCE2;
        String $this$fastRoundToInt$iv2;
        ViewStructure child;
        int intValue;
        ArrayList iNSTANCE;
        String[] strArr;
        ArrayList arrayList;
        List round;
        int i;
        int index$iv$iv;
        int size;
        int i3;
        Object obj;
        int i4;
        Object obj2;
        int i2;
        int index;
        $this$fastRoundToInt$iv = AutofillApi23Helper.INSTANCE.addChildCount(root, $this$populateViewStructure.getAutofillTree().getChildren().size());
        Iterator iterator = $this$populateViewStructure.getAutofillTree().getChildren().entrySet().iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            intValue = (Number)(Map.Entry)next2.getKey().intValue();
            value = next2.getValue();
            child = AutofillApi23Helper.INSTANCE.newChild(boundingBox, $this$fastRoundToInt$iv);
            if (child != null) {
            } else {
            }
            index = $this$fastRoundToInt$iv;
            $this$fastRoundToInt$iv = index + 1;
            boundingBox = root;
            iNSTANCE2 = 0;
            android.view.autofill.AutofillId autofillId = AutofillApi26Helper.INSTANCE.getAutofillId(boundingBox);
            Intrinsics.checkNotNull(autofillId);
            AutofillApi26Helper.INSTANCE.setAutofillId(child, autofillId, intValue);
            AutofillApi23Helper.INSTANCE.setId(child, intValue, $this$populateViewStructure.getView().getContext().getPackageName(), 0, 0);
            AutofillApi26Helper.INSTANCE.setAutofillType(child, ContentDataType.Companion.getText-A48pgw8());
            List autofillTypes = (AutofillNode)value.getAutofillTypes();
            int i11 = 0;
            arrayList = new ArrayList(autofillTypes.size());
            round = autofillTypes;
            i = 0;
            index$iv$iv = 0;
            while (index$iv$iv < round.size()) {
                i4 = 0;
                i2 = 0;
                (Collection)arrayList.add(AndroidAutofillType_androidKt.getAndroidType((AutofillType)round.get(index$iv$iv)));
                index$iv$iv++;
                boundingBox = root;
                $this$fastRoundToInt$iv = index;
            }
            index = $this$fastRoundToInt$iv;
            int i5 = 0;
            AutofillApi26Helper.INSTANCE.setAutofillHints(child, (String[])(Collection)(List)arrayList.toArray(new String[0]));
            boundingBox = value.getBoundingBox();
            if (boundingBox == null) {
            } else {
            }
            int i6 = 0;
            arrayList = Math.round(boundingBox.getLeft());
            int i7 = 0;
            round = Math.round(boundingBox.getTop());
            int i8 = 0;
            int i9 = 0;
            AutofillApi23Helper.INSTANCE.setDimens(child, arrayList, round, 0, 0, $this$fastRoundToInt$iv - arrayList, $this$fastRoundToInt$iv2 - round);
            Log.w("Autofill Warning", "Bounding box not set.\n                        Did you call perform autofillTree before the component was positioned? ");
            i4 = 0;
            i2 = 0;
            (Collection)arrayList.add(AndroidAutofillType_androidKt.getAndroidType((AutofillType)round.get(index$iv$iv)));
            index$iv$iv++;
            boundingBox = root;
            $this$fastRoundToInt$iv = index;
        }
    }
}
