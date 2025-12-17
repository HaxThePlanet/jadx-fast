package androidx.compose.foundation.content;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0008H\u0007\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u000bH\u0000¨\u0006\u000c", d2 = {"consume", "Landroidx/compose/foundation/content/TransferableContent;", "predicate", "Lkotlin/Function1;", "Landroid/content/ClipData$Item;", "", "hasMediaType", "mediaType", "Landroidx/compose/foundation/content/MediaType;", "readPlainText", "", "Landroidx/compose/ui/platform/ClipEntry;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TransferableContent_androidKt {
    public static final androidx.compose.foundation.content.TransferableContent consume(androidx.compose.foundation.content.TransferableContent $this$consume, Function1<? super ClipData.Item, Boolean> predicate) {
        int remainingItems;
        int i5;
        int i4;
        int i;
        int i3;
        boolean i2;
        int itemCount;
        ClipData.Item itemAt;
        boolean booleanValue;
        ClipData clipData = $this$consume.getClipEntry().getClipData();
        int i7 = 1;
        int i6 = $this$consume;
        int i8 = 0;
        if (clipData.getItemCount() == i7 && !(Boolean)predicate.invoke(clipData.getItemAt(0)).booleanValue()) {
            i6 = $this$consume;
            i8 = 0;
            if (!(Boolean)predicate.invoke(clipData.getItemAt(i4)).booleanValue()) {
                i5 = $this$consume;
            }
            return i5;
        }
        remainingItems = 0;
        i3 = 0;
        while (i3 < clipData.getItemCount()) {
            itemAt = clipData.getItemAt(i3);
            if (!(Boolean)predicate.invoke(itemAt).booleanValue() && remainingItems == 0) {
            }
            i3++;
            if (remainingItems == 0) {
            }
            remainingItems.add(itemAt);
            booleanValue = new ArrayList();
            remainingItems = booleanValue;
        }
        i2 = remainingItems;
        if ((Collection)i2 != 0) {
            if ((Collection)i2.isEmpty()) {
                i4 = i7;
            }
        } else {
        }
        if (i4 != 0) {
            return null;
        }
        if (remainingItems.size() == clipData.getItemCount()) {
            return $this$consume;
        }
        ClipDescription clipDescription = new ClipDescription($this$consume.getClipMetadata().getClipDescription());
        ClipData clipData2 = new ClipData(clipDescription, (ClipData.Item)CollectionsKt.first(remainingItems));
        i = 1;
        while (i < remainingItems.size()) {
            clipData2.addItem((ClipData.Item)remainingItems.get(i));
            i++;
        }
        TransferableContent transferableContent = new TransferableContent(AndroidClipboardManager_androidKt.toClipEntry(clipData2), AndroidClipboardManager_androidKt.toClipMetadata(clipDescription), $this$consume.getSource-kB6V9T0(), $this$consume.getPlatformTransferableContent(), 0);
        return transferableContent;
    }

    public static final boolean hasMediaType(androidx.compose.foundation.content.TransferableContent $this$hasMediaType, androidx.compose.foundation.content.MediaType mediaType) {
        return $this$hasMediaType.getClipMetadata().getClipDescription().hasMimeType(mediaType.getRepresentation());
    }

    public static final String readPlainText(ClipEntry $this$readPlainText) {
        int seenText;
        int i;
        int string;
        int itemCount2;
        int text;
        int seenFirstItem;
        int i2;
        int itemCount;
        java.lang.CharSequence text2;
        int i3;
        String str;
        seenText = 0;
        i = 0;
        while (i < $this$readPlainText.getClipData().getItemCount()) {
            if (seenText == 0) {
            } else {
            }
            text = 1;
            seenText = text;
            i++;
            if ($this$readPlainText.getClipData().getItemAt(i).getText() != null) {
            } else {
            }
            text = 0;
        }
        if (seenText != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder sb = stringBuilder;
            text = 0;
            seenFirstItem = 0;
            i2 = 0;
            while (i2 < $this$readPlainText.getClipData().getItemCount()) {
                text2 = $this$readPlainText.getClipData().getItemAt(i2).getText();
                i3 = 0;
                if (text2 != null && seenFirstItem != 0) {
                }
                i2++;
                i3 = 0;
                if (seenFirstItem != 0) {
                }
                sb.append(text2);
                seenFirstItem = 1;
                sb.append("\n");
            }
            Intrinsics.checkNotNullExpressionValue(stringBuilder.toString(), "StringBuilder().apply(builderAction).toString()");
        } else {
            string = 0;
        }
        return string;
    }
}
