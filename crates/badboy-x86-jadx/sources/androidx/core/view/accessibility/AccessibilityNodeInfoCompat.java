package androidx.core.view.accessibility;

import _COROUTINE.ArtificialStackFrames;
import android.app.Notification.Action;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo.Builder;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo.Builder;
import android.view.accessibility.AccessibilityNodeInfo.ExtraRenderingInfo;
import android.view.accessibility.AccessibilityNodeInfo.RangeInfo;
import android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo;
import androidx.core.R.id;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class AccessibilityNodeInfoCompat {

    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String ACTION_ARGUMENT_DIRECTION_INT = "androidx.core.view.accessibility.action.ARGUMENT_DIRECTION_INT";
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";
    public static final String ACTION_ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT = "android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT";
    public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String ACTION_ARGUMENT_SCROLL_AMOUNT_FLOAT = "androidx.core.view.accessibility.action.ARGUMENT_SCROLL_AMOUNT_FLOAT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    private static final int BOOLEAN_PROPERTY_ACCESSIBILITY_DATA_SENSITIVE = 64;
    private static final int BOOLEAN_PROPERTY_HAS_REQUEST_INITIAL_ACCESSIBILITY_FOCUS = 32;
    private static final int BOOLEAN_PROPERTY_IS_HEADING = 2;
    private static final int BOOLEAN_PROPERTY_IS_SHOWING_HINT = 4;
    private static final int BOOLEAN_PROPERTY_IS_TEXT_ENTRY_KEY = 8;
    private static final String BOOLEAN_PROPERTY_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
    private static final int BOOLEAN_PROPERTY_SCREEN_READER_FOCUSABLE = 1;
    private static final int BOOLEAN_PROPERTY_SUPPORTS_GRANULAR_SCROLLING = 67108864;
    private static final int BOOLEAN_PROPERTY_TEXT_SELECTABLE = 8388608;
    private static final String BOUNDS_IN_WINDOW_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY";
    private static final String CONTAINER_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH = "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH";
    public static final int EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH = 20000;
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX = "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_IN_WINDOW_KEY = "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_IN_WINDOW_KEY";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY = "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY";
    public static final int FLAG_PREFETCH_ANCESTORS = 1;
    public static final int FLAG_PREFETCH_DESCENDANTS_BREADTH_FIRST = 16;
    public static final int FLAG_PREFETCH_DESCENDANTS_DEPTH_FIRST = 8;
    public static final int FLAG_PREFETCH_DESCENDANTS_HYBRID = 4;
    public static final int FLAG_PREFETCH_SIBLINGS = 2;
    public static final int FLAG_PREFETCH_UNINTERRUPTIBLE = 32;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final String HINT_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";
    private static final String IS_REQUIRED_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.IS_REQUIRED_KEY";
    public static final int MAX_NUMBER_OF_PREFETCHED_NODES = 50;
    private static final String MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY";
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private static final String PANE_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";
    private static final String ROLE_DESCRIPTION_KEY = "AccessibilityNodeInfo.roleDescription";
    private static final String SPANS_ACTION_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
    private static final String SPANS_END_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";
    private static final String SPANS_FLAGS_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";
    private static final String SPANS_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";
    private static final String SPANS_START_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";
    private static final String STATE_DESCRIPTION_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY";
    private static final String TOOLTIP_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
    private static final String UNIQUE_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY";
    private static int sClickableSpanId;
    private final AccessibilityNodeInfo mInfo;
    public int mParentVirtualDescendantId = -1;
    private int mVirtualDescendantId = -1;

    public static class AccessibilityActionCompat {

        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLEAR_FOCUS = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLEAR_SELECTION = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CLICK = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_COLLAPSE = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CONTEXT_CLICK = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_COPY = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_CUT = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_DISMISS = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_DRAG_CANCEL = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_DRAG_DROP = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_DRAG_START = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_EXPAND = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_FOCUS = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_HIDE_TOOLTIP = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_IME_ENTER = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_LONG_CLICK = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_MOVE_WINDOW = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PAGE_DOWN = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PAGE_LEFT = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PAGE_RIGHT = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PAGE_UP = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PASTE = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PRESS_AND_HOLD = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_BACKWARD = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_DOWN = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_FORWARD = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_IN_DIRECTION = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_LEFT = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_RIGHT = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_TO_POSITION = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SCROLL_UP = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SELECT = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SET_PROGRESS = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SET_SELECTION = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SET_TEXT = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SHOW_ON_SCREEN = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SHOW_TEXT_SUGGESTIONS = null;
        public static final androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat ACTION_SHOW_TOOLTIP = null;
        private static final String TAG = "A11yActionCompat";
        final Object mAction;
        protected final androidx.core.view.accessibility.AccessibilityViewCommand mCommand;
        private final int mId;
        private final Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;
        static {
            AccessibilityNodeInfo.AccessibilityAction aCTION_PRESS_AND_HOLD;
            AccessibilityNodeInfo.AccessibilityAction aCTION_IME_ENTER;
            AccessibilityNodeInfo.AccessibilityAction aCTION_DRAG_START;
            int aCTION_DRAG_DROP;
            int aCTION_DRAG_CANCEL;
            int aCTION_SHOW_TEXT_SUGGESTIONS;
            int actionScrollInDirection;
            int i;
            int i3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            int i2;
            actionScrollInDirection = 0;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1, actionScrollInDirection);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS = accessibilityActionCompat;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2, actionScrollInDirection);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS = accessibilityActionCompat2;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat3 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(4, actionScrollInDirection);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SELECT = accessibilityActionCompat3;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat4 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(8, actionScrollInDirection);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_SELECTION = accessibilityActionCompat4;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat5 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, actionScrollInDirection);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK = accessibilityActionCompat5;
            int i9 = 32;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat6 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i9, actionScrollInDirection);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_LONG_CLICK = accessibilityActionCompat6;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat7 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(64, actionScrollInDirection);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS = accessibilityActionCompat7;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat8 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(128, actionScrollInDirection);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS = accessibilityActionCompat8;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat9 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(256, actionScrollInDirection, AccessibilityViewCommand.MoveAtGranularityArguments.class);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY = accessibilityActionCompat9;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat10 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(512, actionScrollInDirection, AccessibilityViewCommand.MoveAtGranularityArguments.class);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = accessibilityActionCompat10;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat11 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1024, actionScrollInDirection, AccessibilityViewCommand.MoveHtmlArguments.class);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_NEXT_HTML_ELEMENT = accessibilityActionCompat11;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat12 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2048, actionScrollInDirection, AccessibilityViewCommand.MoveHtmlArguments.class);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_PREVIOUS_HTML_ELEMENT = accessibilityActionCompat12;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat13 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(4096, actionScrollInDirection);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD = accessibilityActionCompat13;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat14 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(8192, actionScrollInDirection);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD = accessibilityActionCompat14;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat15 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, actionScrollInDirection);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COPY = accessibilityActionCompat15;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat16 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, actionScrollInDirection);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_PASTE = accessibilityActionCompat16;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat17 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, actionScrollInDirection);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CUT = accessibilityActionCompat17;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat18 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, actionScrollInDirection, AccessibilityViewCommand.SetSelectionArguments.class);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_SELECTION = accessibilityActionCompat18;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat19 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, actionScrollInDirection);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND = accessibilityActionCompat19;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat20 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, actionScrollInDirection);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE = accessibilityActionCompat20;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat21 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, actionScrollInDirection);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS = accessibilityActionCompat21;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat22 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, actionScrollInDirection, AccessibilityViewCommand.SetTextArguments.class);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_TEXT = accessibilityActionCompat22;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat29 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, 16908342, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SHOW_ON_SCREEN = accessibilityActionCompat29;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat33 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, 16908343, 0, 0, AccessibilityViewCommand.ScrollToPositionArguments.class);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_TO_POSITION = accessibilityActionCompat33;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat36 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, 16908344, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP = accessibilityActionCompat36;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat39 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, 16908345, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT = accessibilityActionCompat39;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat42 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, 16908346, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN = accessibilityActionCompat42;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat23 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, 16908347, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT = accessibilityActionCompat23;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat26 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP, 16908358, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_PAGE_UP = accessibilityActionCompat26;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat30 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN, 16908359, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_PAGE_DOWN = accessibilityActionCompat30;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat34 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT, 16908360, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_PAGE_LEFT = accessibilityActionCompat34;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat37 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT, 16908361, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_PAGE_RIGHT = accessibilityActionCompat37;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat40 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, 16908348, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CONTEXT_CLICK = accessibilityActionCompat40;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat43 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, 16908349, 0, 0, AccessibilityViewCommand.SetProgressArguments.class);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS = accessibilityActionCompat43;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat24 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, 16908354, 0, 0, AccessibilityViewCommand.MoveWindowArguments.class);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_MOVE_WINDOW = accessibilityActionCompat24;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat27 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, 16908356, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SHOW_TOOLTIP = accessibilityActionCompat27;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat31 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, 16908357, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_HIDE_TOOLTIP = accessibilityActionCompat31;
            int i28 = 30;
            accessibilityAction3 = Build.VERSION.SDK_INT >= i28 ? aCTION_PRESS_AND_HOLD : actionScrollInDirection;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat35 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction3, 16908362, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_PRESS_AND_HOLD = accessibilityActionCompat35;
            accessibilityAction = Build.VERSION.SDK_INT >= i28 ? aCTION_IME_ENTER : actionScrollInDirection;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat38 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction, 16908372, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_IME_ENTER = accessibilityActionCompat38;
            accessibilityAction2 = Build.VERSION.SDK_INT >= i9 ? aCTION_DRAG_START : actionScrollInDirection;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat41 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction2, 16908373, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DRAG_START = accessibilityActionCompat41;
            i2 = Build.VERSION.SDK_INT >= i9 ? aCTION_DRAG_DROP : actionScrollInDirection;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat44 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i2, 16908374, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DRAG_DROP = accessibilityActionCompat44;
            i = Build.VERSION.SDK_INT >= i9 ? aCTION_DRAG_CANCEL : actionScrollInDirection;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat25 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i, 16908375, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DRAG_CANCEL = accessibilityActionCompat25;
            i3 = Build.VERSION.SDK_INT >= 33 ? aCTION_SHOW_TEXT_SUGGESTIONS : actionScrollInDirection;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat28 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i3, 16908376, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SHOW_TEXT_SUGGESTIONS = accessibilityActionCompat28;
            if (Build.VERSION.SDK_INT >= 34) {
                actionScrollInDirection = AccessibilityNodeInfoCompat.Api34Impl.getActionScrollInDirection();
            }
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat32 = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionScrollInDirection, 16908382, 0, 0, 0);
            AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_IN_DIRECTION = accessibilityActionCompat32;
        }

        public AccessibilityActionCompat(int actionId, java.lang.CharSequence label) {
            super(0, actionId, label, 0, 0);
        }

        public AccessibilityActionCompat(int actionId, java.lang.CharSequence label, androidx.core.view.accessibility.AccessibilityViewCommand command) {
            super(0, actionId, label, command, 0);
        }

        private AccessibilityActionCompat(int actionId, java.lang.CharSequence label, Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments> class3) {
            super(0, actionId, label, 0, class3);
        }

        AccessibilityActionCompat(Object action) {
            super(action, 0, 0, 0, 0);
        }

        AccessibilityActionCompat(Object action, int id, java.lang.CharSequence label, androidx.core.view.accessibility.AccessibilityViewCommand command, Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments> class5) {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            super();
            this.mId = id;
            this.mCommand = command;
            if (action == null) {
                accessibilityAction = new AccessibilityNodeInfo.AccessibilityAction(id, label);
                this.mAction = accessibilityAction;
            } else {
                this.mAction = action;
            }
            this.mViewCommandArgumentClass = class5;
        }

        public androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat createReplacementAction(java.lang.CharSequence label, androidx.core.view.accessibility.AccessibilityViewCommand command) {
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(0, this.mId, label, command, this.mViewCommandArgumentClass);
            return accessibilityActionCompat;
        }

        public boolean equals(Object obj) {
            boolean mAction2;
            Object mAction;
            int i = 0;
            if (obj == null) {
                return i;
            }
            if (!obj instanceof AccessibilityNodeInfoCompat.AccessibilityActionCompat) {
                return i;
            }
            Object obj2 = obj;
            if (this.mAction == null) {
                if (obj2.mAction != null) {
                    return i;
                }
            } else {
                if (!this.mAction.equals(obj2.mAction)) {
                    return i;
                }
            }
            return 1;
        }

        public int getId() {
            return (AccessibilityNodeInfo.AccessibilityAction)this.mAction.getId();
        }

        public java.lang.CharSequence getLabel() {
            return (AccessibilityNodeInfo.AccessibilityAction)this.mAction.getLabel();
        }

        public int hashCode() {
            int i;
            if (this.mAction != null) {
                i = this.mAction.hashCode();
            } else {
                i = 0;
            }
            return i;
        }

        public boolean perform(View view, Bundle arguments) {
            int viewCommandArgument;
            int instance;
            Class name;
            Object mViewCommandArgumentClass;
            StringBuilder string;
            String str;
            instance = 0;
            viewCommandArgument = 0;
            if (this.mCommand != null && this.mViewCommandArgumentClass != null) {
                viewCommandArgument = 0;
                if (this.mViewCommandArgumentClass != null) {
                    (AccessibilityViewCommand.CommandArguments)this.mViewCommandArgumentClass.getDeclaredConstructor(new Class[instance]).newInstance(new Object[instance]).setBundle(arguments);
                }
                return this.mCommand.perform(view, viewCommandArgument);
            }
            return instance;
        }

        public String toString() {
            String actionName;
            boolean equals;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AccessibilityActionCompat: ");
            if (AccessibilityNodeInfoCompat.getActionSymbolicName(this.mId).equals("ACTION_UNKNOWN") && getLabel() != null) {
                if (getLabel() != null) {
                    actionName = getLabel().toString();
                }
            }
            stringBuilder.append(actionName);
            return stringBuilder.toString();
        }
    }

    private static class Api30Impl {
        public static Object createRangeInfo(int type, float min, float max, float current) {
            AccessibilityNodeInfo.RangeInfo rangeInfo = new AccessibilityNodeInfo.RangeInfo(type, min, max, current);
            return rangeInfo;
        }

        public static java.lang.CharSequence getStateDescription(AccessibilityNodeInfo info) {
            return info.getStateDescription();
        }

        public static void setStateDescription(AccessibilityNodeInfo info, java.lang.CharSequence stateDescription) {
            info.setStateDescription(stateDescription);
        }
    }

    private static class Api33Impl {
        public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat buildCollectionItemInfoCompat(boolean heading, int columnIndex, int rowIndex, int columnSpan, int rowSpan, boolean selected, String rowTitle, String columnTitle) {
            AccessibilityNodeInfo.CollectionItemInfo.Builder builder = new AccessibilityNodeInfo.CollectionItemInfo.Builder();
            AccessibilityNodeInfoCompat.CollectionItemInfoCompat collectionItemInfoCompat = new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(builder.setHeading(heading).setColumnIndex(columnIndex).setRowIndex(rowIndex).setColumnSpan(columnSpan).setRowSpan(rowSpan).setSelected(selected).setRowTitle(rowTitle).setColumnTitle(columnTitle).build());
            return collectionItemInfoCompat;
        }

        public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat getChild(AccessibilityNodeInfo info, int index, int prefetchingStrategy) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(info.getChild(index, prefetchingStrategy));
        }

        public static String getCollectionItemColumnTitle(Object info) {
            return (AccessibilityNodeInfo.CollectionItemInfo)info.getColumnTitle();
        }

        public static String getCollectionItemRowTitle(Object info) {
            return (AccessibilityNodeInfo.CollectionItemInfo)info.getRowTitle();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo(AccessibilityNodeInfo info) {
            return info.getExtraRenderingInfo();
        }

        public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat getParent(AccessibilityNodeInfo info, int prefetchingStrategy) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(info.getParent(prefetchingStrategy));
        }

        public static String getUniqueId(AccessibilityNodeInfo info) {
            return info.getUniqueId();
        }

        public static boolean isTextSelectable(AccessibilityNodeInfo info) {
            return info.isTextSelectable();
        }

        public static void setTextSelectable(AccessibilityNodeInfo info, boolean selectable) {
            info.setTextSelectable(selectable);
        }

        public static void setUniqueId(AccessibilityNodeInfo info, String uniqueId) {
            info.setUniqueId(uniqueId);
        }
    }

    private static class Api34Impl {
        public static AccessibilityNodeInfo.AccessibilityAction getActionScrollInDirection() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void getBoundsInWindow(AccessibilityNodeInfo info, Rect bounds) {
            info.getBoundsInWindow(bounds);
        }

        public static java.lang.CharSequence getContainerTitle(AccessibilityNodeInfo info) {
            return info.getContainerTitle();
        }

        public static long getMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo info) {
            return info.getMinDurationBetweenContentChanges().toMillis();
        }

        public static boolean hasRequestInitialAccessibilityFocus(AccessibilityNodeInfo info) {
            return info.hasRequestInitialAccessibilityFocus();
        }

        public static boolean isAccessibilityDataSensitive(AccessibilityNodeInfo info) {
            return info.isAccessibilityDataSensitive();
        }

        public static void setAccessibilityDataSensitive(AccessibilityNodeInfo info, boolean accessibilityDataSensitive) {
            info.setAccessibilityDataSensitive(accessibilityDataSensitive);
        }

        public static void setBoundsInWindow(AccessibilityNodeInfo info, Rect bounds) {
            info.setBoundsInWindow(bounds);
        }

        public static void setContainerTitle(AccessibilityNodeInfo info, java.lang.CharSequence containerTitle) {
            info.setContainerTitle(containerTitle);
        }

        public static void setMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo info, long duration) {
            info.setMinDurationBetweenContentChanges(Duration.ofMillis(duration));
        }

        public static void setQueryFromAppProcessEnabled(AccessibilityNodeInfo info, View view, boolean enabled) {
            info.setQueryFromAppProcessEnabled(view, enabled);
        }

        public static void setRequestInitialAccessibilityFocus(AccessibilityNodeInfo info, boolean requestInitialAccessibilityFocus) {
            info.setRequestInitialAccessibilityFocus(requestInitialAccessibilityFocus);
        }
    }

    private static class Api35Impl {
        public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat buildCollectionInfoCompat(int rowCount, int columnCount, boolean hierarchical, int selectionMode, int itemCount, int importantForAccessibilityItemCount) {
            AccessibilityNodeInfo.CollectionInfo.Builder builder = new AccessibilityNodeInfo.CollectionInfo.Builder();
            AccessibilityNodeInfoCompat.CollectionInfoCompat collectionInfoCompat = new AccessibilityNodeInfoCompat.CollectionInfoCompat(builder.setRowCount(rowCount).setColumnCount(columnCount).setHierarchical(hierarchical).setSelectionMode(selectionMode).setItemCount(itemCount).setImportantForAccessibilityItemCount(importantForAccessibilityItemCount).build());
            return collectionInfoCompat;
        }

        public static int getImportantForAccessibilityItemCount(Object info) {
            return (AccessibilityNodeInfo.CollectionInfo)info.getImportantForAccessibilityItemCount();
        }

        public static int getItemCount(Object info) {
            return (AccessibilityNodeInfo.CollectionInfo)info.getItemCount();
        }
    }

    public static class CollectionInfoCompat {

        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        public static final int UNDEFINED = -1;
        final Object mInfo;
        CollectionInfoCompat(Object info) {
            super();
            this.mInfo = info;
        }

        public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat obtain(int rowCount, int columnCount, boolean hierarchical) {
            AccessibilityNodeInfoCompat.CollectionInfoCompat collectionInfoCompat = new AccessibilityNodeInfoCompat.CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(rowCount, columnCount, hierarchical));
            return collectionInfoCompat;
        }

        public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat obtain(int rowCount, int columnCount, boolean hierarchical, int selectionMode) {
            AccessibilityNodeInfoCompat.CollectionInfoCompat collectionInfoCompat = new AccessibilityNodeInfoCompat.CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(rowCount, columnCount, hierarchical, selectionMode));
            return collectionInfoCompat;
        }

        public int getColumnCount() {
            return (AccessibilityNodeInfo.CollectionInfo)this.mInfo.getColumnCount();
        }

        public int getImportantForAccessibilityItemCount() {
            if (Build.VERSION.SDK_INT >= 35) {
                return AccessibilityNodeInfoCompat.Api35Impl.getImportantForAccessibilityItemCount(this.mInfo);
            }
            return -1;
        }

        public int getItemCount() {
            if (Build.VERSION.SDK_INT >= 35) {
                return AccessibilityNodeInfoCompat.Api35Impl.getItemCount(this.mInfo);
            }
            return -1;
        }

        public int getRowCount() {
            return (AccessibilityNodeInfo.CollectionInfo)this.mInfo.getRowCount();
        }

        public int getSelectionMode() {
            return (AccessibilityNodeInfo.CollectionInfo)this.mInfo.getSelectionMode();
        }

        public boolean isHierarchical() {
            return (AccessibilityNodeInfo.CollectionInfo)this.mInfo.isHierarchical();
        }
    }

    public static class CollectionItemInfoCompat {

        final Object mInfo;
        CollectionItemInfoCompat(Object info) {
            super();
            this.mInfo = info;
        }

        public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat obtain(int rowIndex, int rowSpan, int columnIndex, int columnSpan, boolean heading) {
            AccessibilityNodeInfoCompat.CollectionItemInfoCompat collectionItemInfoCompat = new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(rowIndex, rowSpan, columnIndex, columnSpan, heading));
            return collectionItemInfoCompat;
        }

        public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat obtain(int rowIndex, int rowSpan, int columnIndex, int columnSpan, boolean heading, boolean selected) {
            AccessibilityNodeInfoCompat.CollectionItemInfoCompat collectionItemInfoCompat = new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(rowIndex, rowSpan, columnIndex, columnSpan, heading, selected));
            return collectionItemInfoCompat;
        }

        public int getColumnIndex() {
            return (AccessibilityNodeInfo.CollectionItemInfo)this.mInfo.getColumnIndex();
        }

        public int getColumnSpan() {
            return (AccessibilityNodeInfo.CollectionItemInfo)this.mInfo.getColumnSpan();
        }

        public String getColumnTitle() {
            if (Build.VERSION.SDK_INT >= 33) {
                return AccessibilityNodeInfoCompat.Api33Impl.getCollectionItemColumnTitle(this.mInfo);
            }
            return null;
        }

        public int getRowIndex() {
            return (AccessibilityNodeInfo.CollectionItemInfo)this.mInfo.getRowIndex();
        }

        public int getRowSpan() {
            return (AccessibilityNodeInfo.CollectionItemInfo)this.mInfo.getRowSpan();
        }

        public String getRowTitle() {
            if (Build.VERSION.SDK_INT >= 33) {
                return AccessibilityNodeInfoCompat.Api33Impl.getCollectionItemRowTitle(this.mInfo);
            }
            return null;
        }

        @Deprecated
        public boolean isHeading() {
            return (AccessibilityNodeInfo.CollectionItemInfo)this.mInfo.isHeading();
        }

        public boolean isSelected() {
            return (AccessibilityNodeInfo.CollectionItemInfo)this.mInfo.isSelected();
        }
    }

    public static class RangeInfoCompat {

        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        final Object mInfo;
        public RangeInfoCompat(int type, float min, float max, float current) {
            Object rangeInfo;
            super();
            if (Build.VERSION.SDK_INT >= 30) {
                this.mInfo = AccessibilityNodeInfoCompat.Api30Impl.createRangeInfo(type, min, max, current);
            } else {
                this.mInfo = AccessibilityNodeInfo.RangeInfo.obtain(type, min, max, current);
            }
        }

        RangeInfoCompat(Object info) {
            super();
            this.mInfo = info;
        }

        public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat obtain(int type, float min, float max, float current) {
            AccessibilityNodeInfoCompat.RangeInfoCompat rangeInfoCompat = new AccessibilityNodeInfoCompat.RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(type, min, max, current));
            return rangeInfoCompat;
        }

        public float getCurrent() {
            return (AccessibilityNodeInfo.RangeInfo)this.mInfo.getCurrent();
        }

        public float getMax() {
            return (AccessibilityNodeInfo.RangeInfo)this.mInfo.getMax();
        }

        public float getMin() {
            return (AccessibilityNodeInfo.RangeInfo)this.mInfo.getMin();
        }

        public int getType() {
            return (AccessibilityNodeInfo.RangeInfo)this.mInfo.getType();
        }
    }

    public static final class TouchDelegateInfoCompat {

        final AccessibilityNodeInfo.TouchDelegateInfo mInfo;
        TouchDelegateInfoCompat(AccessibilityNodeInfo.TouchDelegateInfo info) {
            super();
            this.mInfo = info;
        }

        public TouchDelegateInfoCompat(Map<Region, View> map) {
            super();
            AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo = new AccessibilityNodeInfo.TouchDelegateInfo(map);
            this.mInfo = touchDelegateInfo;
        }

        public Region getRegionAt(int index) {
            return this.mInfo.getRegionAt(index);
        }

        public int getRegionCount() {
            return this.mInfo.getRegionCount();
        }

        public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getTargetForRegion(Region region) {
            AccessibilityNodeInfo targetForRegion = this.mInfo.getTargetForRegion(region);
            if (targetForRegion != null) {
                return AccessibilityNodeInfoCompat.wrap(targetForRegion);
            }
            return null;
        }
    }
    static {
        AccessibilityNodeInfoCompat.sClickableSpanId = 0;
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo info) {
        super();
        final int i = -1;
        this.mInfo = info;
    }

    @Deprecated
    public AccessibilityNodeInfoCompat(Object info) {
        super();
        int i = -1;
        this.mInfo = (AccessibilityNodeInfo)info;
    }

    private void addSpanLocationToExtras(ClickableSpan span, Spanned spanned, int id) {
        extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(span)));
        extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(span)));
        extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(span)));
        extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(id));
    }

    private void clearExtrasSpans() {
        this.mInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.mInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.mInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.mInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    private List<Integer> extrasIntList(String key) {
        ArrayList list;
        Bundle extras;
        if (this.mInfo.getExtras().getIntegerArrayList(key) == null) {
            ArrayList arrayList = new ArrayList();
            this.mInfo.getExtras().putIntegerArrayList(key, arrayList);
        }
        return list;
    }

    static String getActionSymbolicName(int action) {
        switch (action) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908342:
                return "ACTION_SHOW_ON_SCREEN";
            case 16908343:
                return "ACTION_SCROLL_TO_POSITION";
            case 16908344:
                return "ACTION_SCROLL_UP";
            case 16908345:
                return "ACTION_SCROLL_LEFT";
            case 16908346:
                return "ACTION_SCROLL_DOWN";
            case 16908347:
                return "ACTION_SCROLL_RIGHT";
            case 16908348:
                return "ACTION_CONTEXT_CLICK";
            case 16908349:
                return "ACTION_SET_PROGRESS";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            case 16908356:
                return "ACTION_SHOW_TOOLTIP";
            case 16908357:
                return "ACTION_HIDE_TOOLTIP";
            case 16908358:
                return "ACTION_PAGE_UP";
            case 16908359:
                return "ACTION_PAGE_DOWN";
            case 16908360:
                return "ACTION_PAGE_LEFT";
            case 16908361:
                return "ACTION_PAGE_RIGHT";
            case 16908362:
                return "ACTION_PRESS_AND_HOLD";
            case 16908372:
                return "ACTION_IME_ENTER";
            case 16908373:
                return "ACTION_DRAG_START";
            case 16908374:
                return "ACTION_DRAG_DROP";
            case 16908375:
                return "ACTION_DRAG_CANCEL";
            case 16908382:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    private boolean getBooleanProperty(int property) {
        int i;
        final Bundle extras = getExtras();
        i = 0;
        if (extras == null) {
            return i;
        }
        if (int &= property == property) {
            i = 1;
        }
        return i;
    }

    public static ClickableSpan[] getClickableSpans(java.lang.CharSequence text) {
        if (text instanceof Spanned) {
            return (ClickableSpan[])(Spanned)text.getSpans(0, text.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> getOrCreateSpansFromViewTags(View host) {
        SparseArray spans;
        int tag_accessibility_clickable_spans;
        if (getSpansFromViewTags(host) == null) {
            SparseArray sparseArray = new SparseArray();
            host.setTag(R.id.tag_accessibility_clickable_spans, sparseArray);
        }
        return spans;
    }

    private SparseArray<WeakReference<ClickableSpan>> getSpansFromViewTags(View host) {
        return (SparseArray)host.getTag(R.id.tag_accessibility_clickable_spans);
    }

    private boolean hasSpans() {
        return empty ^= 1;
    }

    private int idForClickableSpan(ClickableSpan span, SparseArray<WeakReference<ClickableSpan>> sparseArray2) {
        int i;
        Object size;
        boolean equals;
        if (sparseArray2 != null) {
            i = 0;
            while (i < sparseArray2.size()) {
                i++;
            }
        }
        int i2 = AccessibilityNodeInfoCompat.sClickableSpanId;
        AccessibilityNodeInfoCompat.sClickableSpanId = i2 + 1;
        return i2;
    }

    public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat obtain() {
        return AccessibilityNodeInfoCompat.wrap(AccessibilityNodeInfo.obtain());
    }

    public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat obtain(View source) {
        return AccessibilityNodeInfoCompat.wrap(AccessibilityNodeInfo.obtain(source));
    }

    public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat obtain(View root, int virtualDescendantId) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityNodeInfo.obtain(root, virtualDescendantId));
    }

    public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat obtain(androidx.core.view.accessibility.AccessibilityNodeInfoCompat info) {
        return AccessibilityNodeInfoCompat.wrap(AccessibilityNodeInfo.obtain(info.mInfo));
    }

    private void removeCollectedSpans(View view) {
        ArrayList arrayList;
        int i2;
        int i;
        int valueOf;
        int intValue;
        final SparseArray spansFromViewTags = getSpansFromViewTags(view);
        if (spansFromViewTags != null) {
            arrayList = new ArrayList();
            i = 0;
            while (i < spansFromViewTags.size()) {
                if ((WeakReference)spansFromViewTags.valueAt(i).get() == null) {
                }
                i++;
                arrayList.add(Integer.valueOf(i));
            }
            i2 = 0;
            while (i2 < arrayList.size()) {
                spansFromViewTags.remove((Integer)arrayList.get(i2).intValue());
                i2++;
            }
        }
    }

    private void setBooleanProperty(int property, boolean value) {
        String str;
        int i;
        int i2;
        int booleanProperties;
        int i3;
        final Bundle extras = getExtras();
        str = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
        if (extras != null && value != null) {
            str = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
            if (value != null) {
                i = property;
            }
            extras.putInt(str, i |= booleanProperties);
        }
    }

    public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat wrap(AccessibilityNodeInfo info) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(info);
        return accessibilityNodeInfoCompat;
    }

    static androidx.core.view.accessibility.AccessibilityNodeInfoCompat wrapNonNullInstance(Object object) {
        if (object != null) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(object);
            return accessibilityNodeInfoCompat;
        }
        return null;
    }

    public void addAction(int action) {
        this.mInfo.addAction(action);
    }

    public void addAction(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat action) {
        this.mInfo.addAction((AccessibilityNodeInfo.AccessibilityAction)action.mAction);
    }

    public void addChild(View child) {
        this.mInfo.addChild(child);
    }

    public void addChild(View root, int virtualDescendantId) {
        this.mInfo.addChild(root, virtualDescendantId);
    }

    public void addSpansToExtras(java.lang.CharSequence text, View view) {
    }

    public boolean canOpenPopup() {
        return this.mInfo.canOpenPopup();
    }

    public boolean equals(Object obj) {
        boolean mInfo;
        AccessibilityNodeInfo mInfo2;
        final int i = 1;
        if (this == obj) {
            return i;
        }
        final int i2 = 0;
        if (obj == null) {
            return i2;
        }
        if (!obj instanceof AccessibilityNodeInfoCompat) {
            return i2;
        }
        Object obj2 = obj;
        if (this.mInfo == null) {
            if (obj2.mInfo != null) {
                return i2;
            }
        } else {
            if (!this.mInfo.equals(obj2.mInfo)) {
                return i2;
            }
        }
        if (this.mVirtualDescendantId != obj2.mVirtualDescendantId) {
            return i2;
        }
        if (this.mParentVirtualDescendantId != obj2.mParentVirtualDescendantId) {
            return i2;
        }
        return i;
    }

    public List<androidx.core.view.accessibility.AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String text) {
        int i;
        Object obj;
        androidx.core.view.accessibility.AccessibilityNodeInfoCompat wrap;
        ArrayList arrayList = new ArrayList();
        List accessibilityNodeInfosByText = this.mInfo.findAccessibilityNodeInfosByText(text);
        i = 0;
        while (i < accessibilityNodeInfosByText.size()) {
            arrayList.add(AccessibilityNodeInfoCompat.wrap((AccessibilityNodeInfo)accessibilityNodeInfosByText.get(i)));
            i++;
        }
        return arrayList;
    }

    public List<androidx.core.view.accessibility.AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String viewId) {
        Object next;
        androidx.core.view.accessibility.AccessibilityNodeInfoCompat wrap;
        ArrayList arrayList = new ArrayList();
        final Iterator iterator = this.mInfo.findAccessibilityNodeInfosByViewId(viewId).iterator();
        for (AccessibilityNodeInfo next : iterator) {
            arrayList.add(AccessibilityNodeInfoCompat.wrap(next));
        }
        return arrayList;
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat findFocus(int focus) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.findFocus(focus));
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat focusSearch(int direction) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.focusSearch(direction));
    }

    public List<androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList() {
        int i;
        Object obj;
        androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
        List actionList = this.mInfo.getActionList();
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < actionList.size()) {
            accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(actionList.get(i));
            arrayList.add(accessibilityActionCompat);
            i++;
        }
        return arrayList;
    }

    @Deprecated
    public int getActions() {
        return this.mInfo.getActions();
    }

    public List<String> getAvailableExtraData() {
        return this.mInfo.getAvailableExtraData();
    }

    @Deprecated
    public void getBoundsInParent(Rect outBounds) {
        this.mInfo.getBoundsInParent(outBounds);
    }

    public void getBoundsInScreen(Rect outBounds) {
        this.mInfo.getBoundsInScreen(outBounds);
    }

    public void getBoundsInWindow(Rect outBounds) {
        Object mInfo;
        int left;
        int top;
        int right;
        int bottom;
        if (Build.VERSION.SDK_INT >= 34) {
            AccessibilityNodeInfoCompat.Api34Impl.getBoundsInWindow(this.mInfo, outBounds);
        } else {
            mInfo = this.mInfo.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
            if ((Rect)mInfo != null) {
                outBounds.set(mInfo.left, mInfo.top, mInfo.right, mInfo.bottom);
            }
        }
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getChild(int index) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getChild(index));
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getChild(int index, int prefetchingStrategy) {
        if (Build.VERSION.SDK_INT >= 33) {
            return AccessibilityNodeInfoCompat.Api33Impl.getChild(this.mInfo, index, prefetchingStrategy);
        }
        return getChild(index);
    }

    public int getChildCount() {
        return this.mInfo.getChildCount();
    }

    public java.lang.CharSequence getClassName() {
        return this.mInfo.getClassName();
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat getCollectionInfo() {
        AccessibilityNodeInfo.CollectionInfo collectionInfo = this.mInfo.getCollectionInfo();
        if (collectionInfo != null) {
            AccessibilityNodeInfoCompat.CollectionInfoCompat collectionInfoCompat = new AccessibilityNodeInfoCompat.CollectionInfoCompat(collectionInfo);
            return collectionInfoCompat;
        }
        return null;
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat getCollectionItemInfo() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = this.mInfo.getCollectionItemInfo();
        if (collectionItemInfo != null) {
            AccessibilityNodeInfoCompat.CollectionItemInfoCompat collectionItemInfoCompat = new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(collectionItemInfo);
            return collectionItemInfoCompat;
        }
        return null;
    }

    public java.lang.CharSequence getContainerTitle() {
        if (Build.VERSION.SDK_INT >= 34) {
            return AccessibilityNodeInfoCompat.Api34Impl.getContainerTitle(this.mInfo);
        }
        return this.mInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public java.lang.CharSequence getContentDescription() {
        return this.mInfo.getContentDescription();
    }

    public int getDrawingOrder() {
        return this.mInfo.getDrawingOrder();
    }

    public java.lang.CharSequence getError() {
        return this.mInfo.getError();
    }

    public AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo() {
        if (Build.VERSION.SDK_INT >= 33) {
            return AccessibilityNodeInfoCompat.Api33Impl.getExtraRenderingInfo(this.mInfo);
        }
        return null;
    }

    public Bundle getExtras() {
        return this.mInfo.getExtras();
    }

    public java.lang.CharSequence getHintText() {
        return this.mInfo.getHintText();
    }

    @Deprecated
    public Object getInfo() {
        return this.mInfo;
    }

    public int getInputType() {
        return this.mInfo.getInputType();
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getLabelFor() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getLabelFor());
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getLabeledBy() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getLabeledBy());
    }

    public int getLiveRegion() {
        return this.mInfo.getLiveRegion();
    }

    public int getMaxTextLength() {
        return this.mInfo.getMaxTextLength();
    }

    public long getMinDurationBetweenContentChangesMillis() {
        if (Build.VERSION.SDK_INT >= 34) {
            return AccessibilityNodeInfoCompat.Api34Impl.getMinDurationBetweenContentChangeMillis(this.mInfo);
        }
        return this.mInfo.getExtras().getLong("androidx.view.accessibility.AccessibilityNodeInfoCompat.MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY");
    }

    public int getMovementGranularities() {
        return this.mInfo.getMovementGranularities();
    }

    public java.lang.CharSequence getPackageName() {
        return this.mInfo.getPackageName();
    }

    public java.lang.CharSequence getPaneTitle() {
        return this.mInfo.getPaneTitle();
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getParent() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getParent());
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getParent(int prefetchingStrategy) {
        if (Build.VERSION.SDK_INT >= 33) {
            return AccessibilityNodeInfoCompat.Api33Impl.getParent(this.mInfo, prefetchingStrategy);
        }
        return getParent();
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat getRangeInfo() {
        AccessibilityNodeInfo.RangeInfo rangeInfo = this.mInfo.getRangeInfo();
        if (rangeInfo != null) {
            AccessibilityNodeInfoCompat.RangeInfoCompat rangeInfoCompat = new AccessibilityNodeInfoCompat.RangeInfoCompat(rangeInfo);
            return rangeInfoCompat;
        }
        return null;
    }

    public java.lang.CharSequence getRoleDescription() {
        return this.mInfo.getExtras().getCharSequence("AccessibilityNodeInfo.roleDescription");
    }

    public java.lang.CharSequence getStateDescription() {
        if (Build.VERSION.SDK_INT >= 30) {
            return AccessibilityNodeInfoCompat.Api30Impl.getStateDescription(this.mInfo);
        }
        return this.mInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public java.lang.CharSequence getText() {
        int i;
        int accessibilityClickableSpanCompat;
        int intValue2;
        int intValue;
        int intValue3;
        if (hasSpans()) {
            List extrasIntList = extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.mInfo.getText(), 0, this.mInfo.getText().length()));
            i = 0;
            while (i < extrasIntList.size()) {
                accessibilityClickableSpanCompat = new AccessibilityClickableSpanCompat((Integer)extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").get(i).intValue(), this, getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY"));
                spannableString.setSpan(accessibilityClickableSpanCompat, (Integer)extrasIntList.get(i).intValue(), (Integer)extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").get(i).intValue(), (Integer)extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").get(i).intValue());
                i++;
            }
            return spannableString;
        }
        return this.mInfo.getText();
    }

    public int getTextSelectionEnd() {
        return this.mInfo.getTextSelectionEnd();
    }

    public int getTextSelectionStart() {
        return this.mInfo.getTextSelectionStart();
    }

    public java.lang.CharSequence getTooltipText() {
        return this.mInfo.getTooltipText();
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat.TouchDelegateInfoCompat getTouchDelegateInfo() {
        AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo = this.mInfo.getTouchDelegateInfo();
        if (touchDelegateInfo != null) {
            AccessibilityNodeInfoCompat.TouchDelegateInfoCompat touchDelegateInfoCompat = new AccessibilityNodeInfoCompat.TouchDelegateInfoCompat(touchDelegateInfo);
            return touchDelegateInfoCompat;
        }
        return null;
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getTraversalAfter() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getTraversalAfter());
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getTraversalBefore() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getTraversalBefore());
    }

    public String getUniqueId() {
        if (Build.VERSION.SDK_INT >= 33) {
            return AccessibilityNodeInfoCompat.Api33Impl.getUniqueId(this.mInfo);
        }
        return this.mInfo.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public String getViewIdResourceName() {
        return this.mInfo.getViewIdResourceName();
    }

    public androidx.core.view.accessibility.AccessibilityWindowInfoCompat getWindow() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(this.mInfo.getWindow());
    }

    public int getWindowId() {
        return this.mInfo.getWindowId();
    }

    public boolean hasRequestInitialAccessibilityFocus() {
        if (Build.VERSION.SDK_INT >= 34) {
            return AccessibilityNodeInfoCompat.Api34Impl.hasRequestInitialAccessibilityFocus(this.mInfo);
        }
        return getBooleanProperty(32);
    }

    public int hashCode() {
        int i;
        if (this.mInfo == null) {
            i = 0;
        } else {
            i = this.mInfo.hashCode();
        }
        return i;
    }

    public boolean isAccessibilityDataSensitive() {
        if (Build.VERSION.SDK_INT >= 34) {
            return AccessibilityNodeInfoCompat.Api34Impl.isAccessibilityDataSensitive(this.mInfo);
        }
        return getBooleanProperty(64);
    }

    public boolean isAccessibilityFocused() {
        return this.mInfo.isAccessibilityFocused();
    }

    public boolean isCheckable() {
        return this.mInfo.isCheckable();
    }

    public boolean isChecked() {
        return this.mInfo.isChecked();
    }

    public boolean isClickable() {
        return this.mInfo.isClickable();
    }

    public boolean isContentInvalid() {
        return this.mInfo.isContentInvalid();
    }

    public boolean isContextClickable() {
        return this.mInfo.isContextClickable();
    }

    public boolean isDismissable() {
        return this.mInfo.isDismissable();
    }

    public boolean isEditable() {
        return this.mInfo.isEditable();
    }

    public boolean isEnabled() {
        return this.mInfo.isEnabled();
    }

    public boolean isFieldRequired() {
        return this.mInfo.getExtras().getBoolean("androidx.view.accessibility.AccessibilityNodeInfoCompat.IS_REQUIRED_KEY");
    }

    public boolean isFocusable() {
        return this.mInfo.isFocusable();
    }

    public boolean isFocused() {
        return this.mInfo.isFocused();
    }

    public boolean isGranularScrollingSupported() {
        return getBooleanProperty(67108864);
    }

    public boolean isHeading() {
        return this.mInfo.isHeading();
    }

    public boolean isImportantForAccessibility() {
        return this.mInfo.isImportantForAccessibility();
    }

    public boolean isLongClickable() {
        return this.mInfo.isLongClickable();
    }

    public boolean isMultiLine() {
        return this.mInfo.isMultiLine();
    }

    public boolean isPassword() {
        return this.mInfo.isPassword();
    }

    public boolean isScreenReaderFocusable() {
        return this.mInfo.isScreenReaderFocusable();
    }

    public boolean isScrollable() {
        return this.mInfo.isScrollable();
    }

    public boolean isSelected() {
        return this.mInfo.isSelected();
    }

    public boolean isShowingHintText() {
        return this.mInfo.isShowingHintText();
    }

    public boolean isTextEntryKey() {
        return this.mInfo.isTextEntryKey();
    }

    public boolean isTextSelectable() {
        if (Build.VERSION.SDK_INT >= 33) {
            return AccessibilityNodeInfoCompat.Api33Impl.isTextSelectable(this.mInfo);
        }
        return getBooleanProperty(8388608);
    }

    public boolean isVisibleToUser() {
        return this.mInfo.isVisibleToUser();
    }

    public boolean performAction(int action) {
        return this.mInfo.performAction(action);
    }

    public boolean performAction(int action, Bundle arguments) {
        return this.mInfo.performAction(action, arguments);
    }

    @Deprecated
    public void recycle() {
    }

    public boolean refresh() {
        return this.mInfo.refresh();
    }

    public boolean removeAction(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat action) {
        return this.mInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction)action.mAction);
    }

    public boolean removeChild(View child) {
        return this.mInfo.removeChild(child);
    }

    public boolean removeChild(View root, int virtualDescendantId) {
        return this.mInfo.removeChild(root, virtualDescendantId);
    }

    public void setAccessibilityDataSensitive(boolean accessibilityDataSensitive) {
        AccessibilityNodeInfo mInfo;
        if (Build.VERSION.SDK_INT >= 34) {
            AccessibilityNodeInfoCompat.Api34Impl.setAccessibilityDataSensitive(this.mInfo, accessibilityDataSensitive);
        } else {
            setBooleanProperty(64, accessibilityDataSensitive);
        }
    }

    public void setAccessibilityFocused(boolean focused) {
        this.mInfo.setAccessibilityFocused(focused);
    }

    public void setAvailableExtraData(List<String> list) {
        this.mInfo.setAvailableExtraData(list);
    }

    @Deprecated
    public void setBoundsInParent(Rect bounds) {
        this.mInfo.setBoundsInParent(bounds);
    }

    public void setBoundsInScreen(Rect bounds) {
        this.mInfo.setBoundsInScreen(bounds);
    }

    public void setBoundsInWindow(Rect bounds) {
        Object mInfo;
        int str;
        if (Build.VERSION.SDK_INT >= 34) {
            AccessibilityNodeInfoCompat.Api34Impl.setBoundsInWindow(this.mInfo, bounds);
        } else {
            this.mInfo.getExtras().putParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY", bounds);
        }
    }

    public void setCanOpenPopup(boolean opensPopup) {
        this.mInfo.setCanOpenPopup(opensPopup);
    }

    public void setCheckable(boolean checkable) {
        this.mInfo.setCheckable(checkable);
    }

    public void setChecked(boolean checked) {
        this.mInfo.setChecked(checked);
    }

    public void setClassName(java.lang.CharSequence className) {
        this.mInfo.setClassName(className);
    }

    public void setClickable(boolean clickable) {
        this.mInfo.setClickable(clickable);
    }

    public void setCollectionInfo(Object collectionInfo) {
        int mInfo;
        if (collectionInfo == null) {
            mInfo = 0;
        } else {
            mInfo = obj.mInfo;
        }
        this.mInfo.setCollectionInfo(mInfo);
    }

    public void setCollectionItemInfo(Object collectionItemInfo) {
        int mInfo;
        if (collectionItemInfo == null) {
            mInfo = 0;
        } else {
            mInfo = obj.mInfo;
        }
        this.mInfo.setCollectionItemInfo(mInfo);
    }

    public void setContainerTitle(java.lang.CharSequence containerTitle) {
        Object mInfo;
        int str;
        if (Build.VERSION.SDK_INT >= 34) {
            AccessibilityNodeInfoCompat.Api34Impl.setContainerTitle(this.mInfo, containerTitle);
        } else {
            this.mInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY", containerTitle);
        }
    }

    public void setContentDescription(java.lang.CharSequence contentDescription) {
        this.mInfo.setContentDescription(contentDescription);
    }

    public void setContentInvalid(boolean contentInvalid) {
        this.mInfo.setContentInvalid(contentInvalid);
    }

    public void setContextClickable(boolean contextClickable) {
        this.mInfo.setContextClickable(contextClickable);
    }

    public void setDismissable(boolean dismissable) {
        this.mInfo.setDismissable(dismissable);
    }

    public void setDrawingOrder(int drawingOrderInParent) {
        this.mInfo.setDrawingOrder(drawingOrderInParent);
    }

    public void setEditable(boolean editable) {
        this.mInfo.setEditable(editable);
    }

    public void setEnabled(boolean enabled) {
        this.mInfo.setEnabled(enabled);
    }

    public void setError(java.lang.CharSequence error) {
        this.mInfo.setError(error);
    }

    public void setFieldRequired(boolean required) {
        this.mInfo.getExtras().putBoolean("androidx.view.accessibility.AccessibilityNodeInfoCompat.IS_REQUIRED_KEY", required);
    }

    public void setFocusable(boolean focusable) {
        this.mInfo.setFocusable(focusable);
    }

    public void setFocused(boolean focused) {
        this.mInfo.setFocused(focused);
    }

    public void setGranularScrollingSupported(boolean granularScrollingSupported) {
        setBooleanProperty(67108864, granularScrollingSupported);
    }

    public void setHeading(boolean isHeading) {
        this.mInfo.setHeading(isHeading);
    }

    public void setHintText(java.lang.CharSequence hintText) {
        this.mInfo.setHintText(hintText);
    }

    public void setImportantForAccessibility(boolean important) {
        this.mInfo.setImportantForAccessibility(important);
    }

    public void setInputType(int inputType) {
        this.mInfo.setInputType(inputType);
    }

    public void setLabelFor(View labeled) {
        this.mInfo.setLabelFor(labeled);
    }

    public void setLabelFor(View root, int virtualDescendantId) {
        this.mInfo.setLabelFor(root, virtualDescendantId);
    }

    public void setLabeledBy(View label) {
        this.mInfo.setLabeledBy(label);
    }

    public void setLabeledBy(View root, int virtualDescendantId) {
        this.mInfo.setLabeledBy(root, virtualDescendantId);
    }

    public void setLiveRegion(int mode) {
        this.mInfo.setLiveRegion(mode);
    }

    public void setLongClickable(boolean longClickable) {
        this.mInfo.setLongClickable(longClickable);
    }

    public void setMaxTextLength(int max) {
        this.mInfo.setMaxTextLength(max);
    }

    public void setMinDurationBetweenContentChangesMillis(long duration) {
        Object mInfo;
        int str;
        if (Build.VERSION.SDK_INT >= 34) {
            AccessibilityNodeInfoCompat.Api34Impl.setMinDurationBetweenContentChangeMillis(this.mInfo, duration);
        } else {
            this.mInfo.getExtras().putLong("androidx.view.accessibility.AccessibilityNodeInfoCompat.MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY", duration);
        }
    }

    public void setMovementGranularities(int granularities) {
        this.mInfo.setMovementGranularities(granularities);
    }

    public void setMultiLine(boolean multiLine) {
        this.mInfo.setMultiLine(multiLine);
    }

    public void setPackageName(java.lang.CharSequence packageName) {
        this.mInfo.setPackageName(packageName);
    }

    public void setPaneTitle(java.lang.CharSequence paneTitle) {
        this.mInfo.setPaneTitle(paneTitle);
    }

    public void setParent(View parent) {
        this.mParentVirtualDescendantId = -1;
        this.mInfo.setParent(parent);
    }

    public void setParent(View root, int virtualDescendantId) {
        this.mParentVirtualDescendantId = virtualDescendantId;
        this.mInfo.setParent(root, virtualDescendantId);
    }

    public void setPassword(boolean password) {
        this.mInfo.setPassword(password);
    }

    public void setQueryFromAppProcessEnabled(View view, boolean enabled) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 34) {
            AccessibilityNodeInfoCompat.Api34Impl.setQueryFromAppProcessEnabled(this.mInfo, view, enabled);
        }
    }

    public void setRangeInfo(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.RangeInfoCompat rangeInfo) {
        this.mInfo.setRangeInfo((AccessibilityNodeInfo.RangeInfo)rangeInfo.mInfo);
    }

    public void setRequestInitialAccessibilityFocus(boolean requestInitialAccessibilityFocus) {
        AccessibilityNodeInfo mInfo;
        if (Build.VERSION.SDK_INT >= 34) {
            AccessibilityNodeInfoCompat.Api34Impl.setRequestInitialAccessibilityFocus(this.mInfo, requestInitialAccessibilityFocus);
        } else {
            setBooleanProperty(32, requestInitialAccessibilityFocus);
        }
    }

    public void setRoleDescription(java.lang.CharSequence roleDescription) {
        this.mInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", roleDescription);
    }

    public void setScreenReaderFocusable(boolean screenReaderFocusable) {
        this.mInfo.setScreenReaderFocusable(screenReaderFocusable);
    }

    public void setScrollable(boolean scrollable) {
        this.mInfo.setScrollable(scrollable);
    }

    public void setSelected(boolean selected) {
        this.mInfo.setSelected(selected);
    }

    public void setShowingHintText(boolean showingHintText) {
        this.mInfo.setShowingHintText(showingHintText);
    }

    public void setSource(View source) {
        this.mVirtualDescendantId = -1;
        this.mInfo.setSource(source);
    }

    public void setSource(View root, int virtualDescendantId) {
        this.mVirtualDescendantId = virtualDescendantId;
        this.mInfo.setSource(root, virtualDescendantId);
    }

    public void setStateDescription(java.lang.CharSequence stateDescription) {
        Object mInfo;
        int str;
        if (Build.VERSION.SDK_INT >= 30) {
            AccessibilityNodeInfoCompat.Api30Impl.setStateDescription(this.mInfo, stateDescription);
        } else {
            this.mInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", stateDescription);
        }
    }

    public void setText(java.lang.CharSequence text) {
        this.mInfo.setText(text);
    }

    public void setTextEntryKey(boolean isTextEntryKey) {
        this.mInfo.setTextEntryKey(isTextEntryKey);
    }

    public void setTextSelectable(boolean selectableText) {
        AccessibilityNodeInfo mInfo;
        if (Build.VERSION.SDK_INT >= 33) {
            AccessibilityNodeInfoCompat.Api33Impl.setTextSelectable(this.mInfo, selectableText);
        } else {
            setBooleanProperty(8388608, selectableText);
        }
    }

    public void setTextSelection(int start, int end) {
        this.mInfo.setTextSelection(start, end);
    }

    public void setTooltipText(java.lang.CharSequence tooltipText) {
        this.mInfo.setTooltipText(tooltipText);
    }

    public void setTouchDelegateInfo(androidx.core.view.accessibility.AccessibilityNodeInfoCompat.TouchDelegateInfoCompat delegatedInfo) {
        this.mInfo.setTouchDelegateInfo(delegatedInfo.mInfo);
    }

    public void setTraversalAfter(View view) {
        this.mInfo.setTraversalAfter(view);
    }

    public void setTraversalAfter(View root, int virtualDescendantId) {
        this.mInfo.setTraversalAfter(root, virtualDescendantId);
    }

    public void setTraversalBefore(View view) {
        this.mInfo.setTraversalBefore(view);
    }

    public void setTraversalBefore(View root, int virtualDescendantId) {
        this.mInfo.setTraversalBefore(root, virtualDescendantId);
    }

    public void setUniqueId(String uniqueId) {
        Object mInfo;
        int str;
        if (Build.VERSION.SDK_INT >= 33) {
            AccessibilityNodeInfoCompat.Api33Impl.setUniqueId(this.mInfo, uniqueId);
        } else {
            this.mInfo.getExtras().putString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY", uniqueId);
        }
    }

    public void setViewIdResourceName(String viewId) {
        this.mInfo.setViewIdResourceName(viewId);
    }

    public void setVisibleToUser(boolean visibleToUser) {
        this.mInfo.setVisibleToUser(visibleToUser);
    }

    public String toString() {
        int i;
        Object obj;
        String actionName;
        int str;
        boolean equals;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder.append(stringBuilder2.append("; boundsInParent: ").append(rect).toString());
        getBoundsInScreen(rect);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder.append(stringBuilder3.append("; boundsInScreen: ").append(rect).toString());
        getBoundsInWindow(rect);
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder.append(stringBuilder4.append("; boundsInWindow: ").append(rect).toString());
        stringBuilder.append("; packageName: ").append(getPackageName());
        stringBuilder.append("; className: ").append(getClassName());
        stringBuilder.append("; text: ").append(getText());
        stringBuilder.append("; error: ").append(getError());
        stringBuilder.append("; maxTextLength: ").append(getMaxTextLength());
        stringBuilder.append("; stateDescription: ").append(getStateDescription());
        stringBuilder.append("; contentDescription: ").append(getContentDescription());
        stringBuilder.append("; tooltipText: ").append(getTooltipText());
        stringBuilder.append("; viewIdResName: ").append(getViewIdResourceName());
        stringBuilder.append("; uniqueId: ").append(getUniqueId());
        stringBuilder.append("; checkable: ").append(isCheckable());
        stringBuilder.append("; checked: ").append(isChecked());
        stringBuilder.append("; fieldRequired: ").append(isFieldRequired());
        stringBuilder.append("; focusable: ").append(isFocusable());
        stringBuilder.append("; focused: ").append(isFocused());
        stringBuilder.append("; selected: ").append(isSelected());
        stringBuilder.append("; clickable: ").append(isClickable());
        stringBuilder.append("; longClickable: ").append(isLongClickable());
        stringBuilder.append("; contextClickable: ").append(isContextClickable());
        stringBuilder.append("; enabled: ").append(isEnabled());
        stringBuilder.append("; password: ").append(isPassword());
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder.append(stringBuilder5.append("; scrollable: ").append(isScrollable()).toString());
        stringBuilder.append("; containerTitle: ").append(getContainerTitle());
        stringBuilder.append("; granularScrollingSupported: ").append(isGranularScrollingSupported());
        stringBuilder.append("; importantForAccessibility: ").append(isImportantForAccessibility());
        stringBuilder.append("; visible: ").append(isVisibleToUser());
        stringBuilder.append("; isTextSelectable: ").append(isTextSelectable());
        stringBuilder.append("; accessibilityDataSensitive: ").append(isAccessibilityDataSensitive());
        stringBuilder.append("; [");
        List actionList = getActionList();
        i = 0;
        while (i < actionList.size()) {
            obj = actionList.get(i);
            if (AccessibilityNodeInfoCompat.getActionSymbolicName((AccessibilityNodeInfoCompat.AccessibilityActionCompat)obj.getId()).equals("ACTION_UNKNOWN") && obj.getLabel() != null) {
            }
            stringBuilder.append(actionName);
            if (i != size2--) {
            }
            i++;
            stringBuilder.append(", ");
            if (obj.getLabel() != null) {
            }
            actionName = obj.getLabel().toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public AccessibilityNodeInfo unwrap() {
        return this.mInfo;
    }
}
