package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.View;

/* loaded from: classes5.dex */
public interface AccessibilityViewCommand {

    public static abstract class CommandArguments {

        Bundle mBundle;
        public void setBundle(Bundle bundle) {
            this.mBundle = bundle;
        }
    }

    public static final class MoveAtGranularityArguments extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments {
        @Override // androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
        public boolean getExtendSelection() {
            return this.mBundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
        public int getGranularity() {
            return this.mBundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        }
    }

    public static final class MoveHtmlArguments extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments {
        @Override // androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
        public String getHTMLElement() {
            return this.mBundle.getString("ACTION_ARGUMENT_HTML_ELEMENT_STRING");
        }
    }

    public static final class MoveWindowArguments extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments {
        @Override // androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
        public int getX() {
            return this.mBundle.getInt("ACTION_ARGUMENT_MOVE_WINDOW_X");
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
        public int getY() {
            return this.mBundle.getInt("ACTION_ARGUMENT_MOVE_WINDOW_Y");
        }
    }

    public static final class ScrollToPositionArguments extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments {
        @Override // androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
        public int getColumn() {
            return this.mBundle.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT");
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
        public int getRow() {
            return this.mBundle.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT");
        }
    }

    public static final class SetProgressArguments extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments {
        @Override // androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
        public float getProgress() {
            return this.mBundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE");
        }
    }

    public static final class SetSelectionArguments extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments {
        @Override // androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
        public int getEnd() {
            return this.mBundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
        public int getStart() {
            return this.mBundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT");
        }
    }

    public static final class SetTextArguments extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments {
        @Override // androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments
        public java.lang.CharSequence getText() {
            return this.mBundle.getCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
        }
    }
    public abstract boolean perform(View view, androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments accessibilityViewCommand$CommandArguments2);
}
