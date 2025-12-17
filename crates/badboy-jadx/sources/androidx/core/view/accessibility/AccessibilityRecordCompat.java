package androidx.core.view.accessibility;

import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.ReplaceWith;
import java.util.List;

/* loaded from: classes5.dex */
public class AccessibilityRecordCompat {

    private final AccessibilityRecord mRecord;
    @Deprecated
    public AccessibilityRecordCompat(Object record) {
        super();
        this.mRecord = (AccessibilityRecord)record;
    }

    @ReplaceWith(expression = "record.getMaxScrollX()")
    @Deprecated
    public static int getMaxScrollX(AccessibilityRecord record) {
        return record.getMaxScrollX();
    }

    @ReplaceWith(expression = "record.getMaxScrollY()")
    @Deprecated
    public static int getMaxScrollY(AccessibilityRecord record) {
        return record.getMaxScrollY();
    }

    @Deprecated
    public static androidx.core.view.accessibility.AccessibilityRecordCompat obtain() {
        AccessibilityRecordCompat accessibilityRecordCompat = new AccessibilityRecordCompat(AccessibilityRecord.obtain());
        return accessibilityRecordCompat;
    }

    @Deprecated
    public static androidx.core.view.accessibility.AccessibilityRecordCompat obtain(androidx.core.view.accessibility.AccessibilityRecordCompat record) {
        AccessibilityRecordCompat accessibilityRecordCompat = new AccessibilityRecordCompat(AccessibilityRecord.obtain(record.mRecord));
        return accessibilityRecordCompat;
    }

    @ReplaceWith(expression = "record.setMaxScrollX(maxScrollX)")
    @Deprecated
    public static void setMaxScrollX(AccessibilityRecord record, int maxScrollX) {
        record.setMaxScrollX(maxScrollX);
    }

    @ReplaceWith(expression = "record.setMaxScrollY(maxScrollY)")
    @Deprecated
    public static void setMaxScrollY(AccessibilityRecord record, int maxScrollY) {
        record.setMaxScrollY(maxScrollY);
    }

    @ReplaceWith(expression = "record.setSource(root, virtualDescendantId)")
    @Deprecated
    public static void setSource(AccessibilityRecord record, View root, int virtualDescendantId) {
        record.setSource(root, virtualDescendantId);
    }

    @Deprecated
    public boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return 1;
        }
        int i2 = 0;
        if (!obj instanceof AccessibilityRecordCompat) {
            return i2;
        }
        Object obj2 = obj;
        if (this.mRecord == null) {
            if (obj2.mRecord == null) {
            } else {
                i = i2;
            }
            return i;
        }
        return this.mRecord.equals(obj2.mRecord);
    }

    @Deprecated
    public int getAddedCount() {
        return this.mRecord.getAddedCount();
    }

    @Deprecated
    public java.lang.CharSequence getBeforeText() {
        return this.mRecord.getBeforeText();
    }

    @Deprecated
    public java.lang.CharSequence getClassName() {
        return this.mRecord.getClassName();
    }

    @Deprecated
    public java.lang.CharSequence getContentDescription() {
        return this.mRecord.getContentDescription();
    }

    @Deprecated
    public int getCurrentItemIndex() {
        return this.mRecord.getCurrentItemIndex();
    }

    @Deprecated
    public int getFromIndex() {
        return this.mRecord.getFromIndex();
    }

    @Deprecated
    public Object getImpl() {
        return this.mRecord;
    }

    @Deprecated
    public int getItemCount() {
        return this.mRecord.getItemCount();
    }

    @Deprecated
    public int getMaxScrollX() {
        return AccessibilityRecordCompat.getMaxScrollX(this.mRecord);
    }

    @Deprecated
    public int getMaxScrollY() {
        return AccessibilityRecordCompat.getMaxScrollY(this.mRecord);
    }

    @Deprecated
    public Parcelable getParcelableData() {
        return this.mRecord.getParcelableData();
    }

    @Deprecated
    public int getRemovedCount() {
        return this.mRecord.getRemovedCount();
    }

    @Deprecated
    public int getScrollX() {
        return this.mRecord.getScrollX();
    }

    @Deprecated
    public int getScrollY() {
        return this.mRecord.getScrollY();
    }

    @Deprecated
    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getSource() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mRecord.getSource());
    }

    @Deprecated
    public List<java.lang.CharSequence> getText() {
        return this.mRecord.getText();
    }

    @Deprecated
    public int getToIndex() {
        return this.mRecord.getToIndex();
    }

    @Deprecated
    public int getWindowId() {
        return this.mRecord.getWindowId();
    }

    @Deprecated
    public int hashCode() {
        int i;
        if (this.mRecord == null) {
            i = 0;
        } else {
            i = this.mRecord.hashCode();
        }
        return i;
    }

    @Deprecated
    public boolean isChecked() {
        return this.mRecord.isChecked();
    }

    @Deprecated
    public boolean isEnabled() {
        return this.mRecord.isEnabled();
    }

    @Deprecated
    public boolean isFullScreen() {
        return this.mRecord.isFullScreen();
    }

    @Deprecated
    public boolean isPassword() {
        return this.mRecord.isPassword();
    }

    @Deprecated
    public boolean isScrollable() {
        return this.mRecord.isScrollable();
    }

    @Deprecated
    public void recycle() {
        this.mRecord.recycle();
    }

    @Deprecated
    public void setAddedCount(int addedCount) {
        this.mRecord.setAddedCount(addedCount);
    }

    @Deprecated
    public void setBeforeText(java.lang.CharSequence beforeText) {
        this.mRecord.setBeforeText(beforeText);
    }

    @Deprecated
    public void setChecked(boolean isChecked) {
        this.mRecord.setChecked(isChecked);
    }

    @Deprecated
    public void setClassName(java.lang.CharSequence className) {
        this.mRecord.setClassName(className);
    }

    @Deprecated
    public void setContentDescription(java.lang.CharSequence contentDescription) {
        this.mRecord.setContentDescription(contentDescription);
    }

    @Deprecated
    public void setCurrentItemIndex(int currentItemIndex) {
        this.mRecord.setCurrentItemIndex(currentItemIndex);
    }

    @Deprecated
    public void setEnabled(boolean isEnabled) {
        this.mRecord.setEnabled(isEnabled);
    }

    @Deprecated
    public void setFromIndex(int fromIndex) {
        this.mRecord.setFromIndex(fromIndex);
    }

    @Deprecated
    public void setFullScreen(boolean isFullScreen) {
        this.mRecord.setFullScreen(isFullScreen);
    }

    @Deprecated
    public void setItemCount(int itemCount) {
        this.mRecord.setItemCount(itemCount);
    }

    @Deprecated
    public void setMaxScrollX(int maxScrollX) {
        AccessibilityRecordCompat.setMaxScrollX(this.mRecord, maxScrollX);
    }

    @Deprecated
    public void setMaxScrollY(int maxScrollY) {
        AccessibilityRecordCompat.setMaxScrollY(this.mRecord, maxScrollY);
    }

    @Deprecated
    public void setParcelableData(Parcelable parcelableData) {
        this.mRecord.setParcelableData(parcelableData);
    }

    @Deprecated
    public void setPassword(boolean isPassword) {
        this.mRecord.setPassword(isPassword);
    }

    @Deprecated
    public void setRemovedCount(int removedCount) {
        this.mRecord.setRemovedCount(removedCount);
    }

    @Deprecated
    public void setScrollX(int scrollX) {
        this.mRecord.setScrollX(scrollX);
    }

    @Deprecated
    public void setScrollY(int scrollY) {
        this.mRecord.setScrollY(scrollY);
    }

    @Deprecated
    public void setScrollable(boolean scrollable) {
        this.mRecord.setScrollable(scrollable);
    }

    @Deprecated
    public void setSource(View source) {
        this.mRecord.setSource(source);
    }

    @Deprecated
    public void setSource(View root, int virtualDescendantId) {
        AccessibilityRecordCompat.setSource(this.mRecord, root, virtualDescendantId);
    }

    @Deprecated
    public void setToIndex(int toIndex) {
        this.mRecord.setToIndex(toIndex);
    }
}
