//! Android Resource Table (ARSC) parser
//!
//! Parses resources.arsc files which contain compiled Android resources.
//! Provides resource ID to name mappings for use in XML decoding.

use std::collections::HashMap;
use std::io::{Cursor, Read, Seek, SeekFrom};

use byteorder::{LittleEndian, ReadBytesExt};

use crate::constants::*;
use crate::error::{ResourceError, Result};
use crate::string_pool::StringPool;

use std::sync::LazyLock;

/// Map of common Android framework attribute IDs to names
/// Based on AOSP frameworks/base/core/res/res/values/public.xml
static ANDROID_ATTR_MAP: LazyLock<HashMap<u32, &'static str>> = LazyLock::new(|| {
    let mut m = HashMap::new();
    // Core attributes (0x01010000 - 0x010100ff)
    m.insert(0x01010000, "theme");
    m.insert(0x01010001, "label");
    m.insert(0x01010002, "icon");
    m.insert(0x01010003, "name");
    m.insert(0x01010004, "manageSpaceActivity");
    m.insert(0x01010006, "allowClearUserData");
    m.insert(0x01010007, "permission");
    m.insert(0x01010008, "readPermission");
    m.insert(0x01010009, "writePermission");
    m.insert(0x0101000a, "protectionLevel");
    m.insert(0x0101000b, "permissionGroup");
    m.insert(0x0101000e, "sharedUserId");
    m.insert(0x0101000f, "hasCode");
    m.insert(0x01010010, "persistent");
    m.insert(0x01010011, "enabled");
    m.insert(0x01010012, "debuggable");
    m.insert(0x01010013, "exported");
    m.insert(0x01010014, "process");
    m.insert(0x01010015, "taskAffinity");
    m.insert(0x01010016, "multiprocess");
    m.insert(0x01010017, "finishOnTaskLaunch");
    m.insert(0x01010018, "clearTaskOnLaunch");
    m.insert(0x01010019, "stateNotNeeded");
    m.insert(0x0101001a, "excludeFromRecents");
    m.insert(0x0101001b, "authorities");
    m.insert(0x0101001c, "syncable");
    m.insert(0x0101001d, "initOrder");
    m.insert(0x0101001e, "grantUriPermissions");
    m.insert(0x0101001f, "priority");
    m.insert(0x01010020, "launchMode");
    m.insert(0x01010021, "screenOrientation");
    m.insert(0x01010022, "configChanges");
    m.insert(0x01010024, "targetActivity");
    m.insert(0x01010025, "alwaysRetainTaskState");
    m.insert(0x01010026, "allowTaskReparenting");
    m.insert(0x01010027, "searchButtonText");
    m.insert(0x01010028, "colorForeground");
    m.insert(0x01010029, "colorForegroundInverse");
    m.insert(0x0101002a, "colorBackground");
    m.insert(0x0101002b, "colorBackgroundCacheHint");
    m.insert(0x0101002c, "disabledAlpha");
    m.insert(0x01010030, "textColorPrimary");
    m.insert(0x01010031, "textColorPrimaryDisableOnly");
    m.insert(0x01010032, "textColorSecondary");
    m.insert(0x01010033, "textColorPrimaryInverse");
    m.insert(0x01010034, "textColorSecondaryInverse");
    m.insert(0x01010035, "textColorPrimaryNoDisable");
    m.insert(0x01010036, "textColorSecondaryNoDisable");
    m.insert(0x01010037, "textColorPrimaryInverseNoDisable");
    m.insert(0x01010038, "textColorSecondaryInverseNoDisable");
    m.insert(0x01010039, "textColorHintInverse");
    m.insert(0x0101003a, "textColorHighlight");
    m.insert(0x0101003b, "textColorHighlightInverse");
    m.insert(0x0101003c, "textColorLink");
    m.insert(0x0101003d, "textColorLinkInverse");
    m.insert(0x0101003e, "textColorAlertDialogListItem");
    m.insert(0x01010048, "candidatesTextStyleSpans");
    m.insert(0x01010049, "textAppearance");
    m.insert(0x0101004a, "textAppearanceInverse");
    m.insert(0x0101004b, "textColorTertiary");
    m.insert(0x0101004c, "textColorTertiaryInverse");
    m.insert(0x0101004d, "listPreferredItemHeight");
    m.insert(0x0101004e, "listDivider");
    m.insert(0x01010052, "windowBackground");
    m.insert(0x01010053, "windowFrame");
    m.insert(0x01010054, "windowNoTitle");
    m.insert(0x01010055, "windowIsFloating");
    m.insert(0x01010056, "windowIsTranslucent");
    m.insert(0x01010057, "windowContentOverlay");
    m.insert(0x01010058, "windowTitleSize");
    m.insert(0x01010059, "windowTitleStyle");
    m.insert(0x0101005a, "windowTitleBackgroundStyle");
    m.insert(0x0101005b, "alertDialogStyle");
    m.insert(0x0101005c, "panelBackground");
    m.insert(0x0101005d, "panelFullBackground");
    m.insert(0x0101005e, "panelColorForeground");
    m.insert(0x0101005f, "panelColorBackground");
    m.insert(0x01010060, "panelTextAppearance");
    m.insert(0x01010061, "scrollbarSize");
    m.insert(0x01010062, "scrollbarThumbHorizontal");
    m.insert(0x01010063, "scrollbarThumbVertical");
    m.insert(0x01010064, "scrollbarTrackHorizontal");
    m.insert(0x01010065, "scrollbarTrackVertical");
    m.insert(0x01010066, "scrollbarAlwaysDrawHorizontalTrack");
    m.insert(0x01010067, "scrollbarAlwaysDrawVerticalTrack");
    m.insert(0x01010068, "absListViewStyle");
    m.insert(0x01010069, "autoCompleteTextViewStyle");
    m.insert(0x0101006a, "checkboxStyle");
    m.insert(0x0101006b, "dropDownListViewStyle");
    m.insert(0x0101006c, "editTextStyle");
    m.insert(0x0101006d, "expandableListViewStyle");
    m.insert(0x0101006e, "galleryStyle");
    m.insert(0x0101006f, "gridViewStyle");
    m.insert(0x01010070, "imageButtonStyle");
    m.insert(0x01010071, "imageWellStyle");
    m.insert(0x01010072, "listViewStyle");
    m.insert(0x01010073, "listViewWhiteStyle");
    m.insert(0x01010074, "popupWindowStyle");
    m.insert(0x01010075, "progressBarStyle");
    m.insert(0x01010076, "progressBarStyleHorizontal");
    m.insert(0x01010077, "progressBarStyleSmall");
    m.insert(0x01010078, "progressBarStyleSmallTitle");
    m.insert(0x01010079, "progressBarStyleLarge");
    m.insert(0x0101007a, "progressBarStyleInverse");
    m.insert(0x0101007b, "progressBarStyleSmallInverse");
    m.insert(0x0101007c, "progressBarStyleLargeInverse");
    m.insert(0x0101007d, "seekBarStyle");
    m.insert(0x0101007e, "ratingBarStyle");
    m.insert(0x0101007f, "ratingBarStyleIndicator");
    m.insert(0x01010080, "ratingBarStyleSmall");
    m.insert(0x01010081, "radioButtonStyle");
    m.insert(0x01010082, "scrollViewStyle");
    m.insert(0x01010083, "horizontalScrollViewStyle");
    m.insert(0x01010084, "spinnerStyle");
    m.insert(0x01010085, "starStyle");
    m.insert(0x01010086, "tabWidgetStyle");
    m.insert(0x01010087, "textViewStyle");
    m.insert(0x01010088, "webViewStyle");
    m.insert(0x01010089, "dropDownItemStyle");
    m.insert(0x0101008a, "spinnerDropDownItemStyle");
    m.insert(0x0101008b, "spinnerItemStyle");
    m.insert(0x0101008c, "dropDownHintAppearance");
    m.insert(0x0101008d, "keyboardViewStyle");
    m.insert(0x0101008e, "quickContactBadgeStyleWindowSmall");
    m.insert(0x0101008f, "quickContactBadgeStyleWindowMedium");
    m.insert(0x01010090, "quickContactBadgeStyleWindowLarge");
    m.insert(0x01010091, "quickContactBadgeStyleSmallWindowSmall");
    m.insert(0x01010092, "quickContactBadgeStyleSmallWindowMedium");
    m.insert(0x01010093, "quickContactBadgeStyleSmallWindowLarge");
    m.insert(0x01010094, "textAppearanceLarge");
    m.insert(0x01010095, "textAppearanceMedium");
    m.insert(0x01010096, "textAppearanceSmall");
    m.insert(0x01010097, "textAppearanceLargeInverse");
    m.insert(0x01010098, "textAppearanceMediumInverse");
    m.insert(0x01010099, "textAppearanceSmallInverse");
    m.insert(0x0101009a, "textCheckMark");
    m.insert(0x0101009b, "textCheckMarkInverse");
    m.insert(0x0101009c, "buttonStyle");
    m.insert(0x0101009d, "buttonStyleSmall");
    m.insert(0x0101009e, "buttonStyleInset");
    m.insert(0x0101009f, "buttonStyleToggle");
    m.insert(0x010100a0, "yesNoPreferenceStyle");
    m.insert(0x010100a1, "dialogPreferenceStyle");
    m.insert(0x010100a2, "editTextPreferenceStyle");
    m.insert(0x010100a3, "ringtonePreferenceStyle");
    m.insert(0x010100a4, "preferenceLayoutChild");
    m.insert(0x010100a5, "textAppearanceListItem");
    m.insert(0x010100a6, "textAppearanceListItemSmall");
    m.insert(0x010100ab, "ellipsize");
    m.insert(0x010100ac, "startYear");
    m.insert(0x010100ad, "endYear");
    m.insert(0x010100ae, "windowAnimationStyle");
    m.insert(0x010100af, "activityOpenEnterAnimation");
    m.insert(0x010100b0, "activityOpenExitAnimation");
    m.insert(0x010100b1, "activityCloseEnterAnimation");
    m.insert(0x010100b2, "activityCloseExitAnimation");
    m.insert(0x010100b3, "taskOpenEnterAnimation");
    m.insert(0x010100b4, "taskOpenExitAnimation");
    m.insert(0x010100b5, "taskCloseEnterAnimation");
    m.insert(0x010100b6, "taskCloseExitAnimation");
    m.insert(0x010100b7, "taskToFrontEnterAnimation");
    m.insert(0x010100b8, "taskToFrontExitAnimation");
    m.insert(0x010100b9, "taskToBackEnterAnimation");
    m.insert(0x010100ba, "taskToBackExitAnimation");
    m.insert(0x010100bb, "windowEnterAnimation");
    m.insert(0x010100bc, "windowExitAnimation");
    m.insert(0x010100bd, "windowShowAnimation");
    m.insert(0x010100be, "windowHideAnimation");
    m.insert(0x010100d0, "id");
    m.insert(0x010100d1, "tag");
    m.insert(0x010100d2, "scrollX");
    m.insert(0x010100d3, "scrollY");
    m.insert(0x010100d4, "background");
    m.insert(0x010100d5, "padding");
    m.insert(0x010100d6, "paddingLeft");
    m.insert(0x010100d7, "paddingTop");
    m.insert(0x010100d8, "paddingRight");
    m.insert(0x010100d9, "paddingBottom");
    m.insert(0x010100da, "focusable");
    m.insert(0x010100db, "focusableInTouchMode");
    m.insert(0x010100dc, "visibility");
    m.insert(0x010100dd, "fitsSystemWindows");
    m.insert(0x010100de, "scrollbars");
    m.insert(0x010100df, "fadingEdge");
    m.insert(0x010100e0, "fadingEdgeLength");
    m.insert(0x010100e1, "nextFocusLeft");
    m.insert(0x010100e2, "nextFocusRight");
    m.insert(0x010100e3, "nextFocusUp");
    m.insert(0x010100e4, "nextFocusDown");
    m.insert(0x010100e5, "clickable");
    m.insert(0x010100e6, "longClickable");
    m.insert(0x010100e7, "saveEnabled");
    m.insert(0x010100e8, "drawingCacheQuality");
    m.insert(0x010100e9, "keepScreenOn");
    m.insert(0x010100ea, "duplicateParentState");
    m.insert(0x010100eb, "minHeight");
    m.insert(0x010100ec, "minWidth");
    m.insert(0x010100ed, "soundEffectsEnabled");
    m.insert(0x010100ee, "hapticFeedbackEnabled");
    m.insert(0x010100ef, "contentDescription");
    m.insert(0x010100f0, "onClick");
    m.insert(0x010100f1, "overScrollMode");
    m.insert(0x010100f2, "layout");
    m.insert(0x010100f3, "inflatedId");
    m.insert(0x010100f4, "layout_width");
    m.insert(0x010100f5, "layout_height");
    m.insert(0x010100f6, "layout_margin");
    m.insert(0x010100f7, "layout_marginLeft");
    m.insert(0x010100f8, "layout_marginTop");
    m.insert(0x010100f9, "layout_marginRight");
    m.insert(0x010100fa, "layout_marginBottom");
    m.insert(0x01010100, "orientation");
    m.insert(0x01010101, "gravity");
    m.insert(0x01010102, "layout_gravity");
    m.insert(0x01010103, "layout_weight");
    m.insert(0x01010104, "baselineAligned");
    m.insert(0x01010105, "baselineAlignedChildIndex");
    m.insert(0x01010106, "weightSum");
    m.insert(0x01010107, "divider");
    m.insert(0x01010108, "showDividers");
    m.insert(0x01010109, "dividerPadding");
    m.insert(0x0101010a, "measureWithLargestChild");
    m.insert(0x01010119, "src");
    m.insert(0x0101011a, "baselineAlignBottom");
    m.insert(0x0101011b, "adjustViewBounds");
    m.insert(0x0101011c, "maxWidth");
    m.insert(0x0101011d, "maxHeight");
    m.insert(0x0101011e, "scaleType");
    m.insert(0x0101011f, "tint");
    m.insert(0x01010120, "cropToPadding");
    m.insert(0x01010129, "text");
    m.insert(0x0101012a, "hint");
    m.insert(0x0101012b, "textColor");
    m.insert(0x0101012c, "textColorHighlight");
    m.insert(0x0101012d, "textColorHint");
    m.insert(0x0101012e, "textColorLink");
    m.insert(0x0101012f, "textSize");
    m.insert(0x01010130, "textScaleX");
    m.insert(0x01010131, "typeface");
    m.insert(0x01010132, "textStyle");
    m.insert(0x01010133, "fontFamily");
    m.insert(0x01010134, "shadowColor");
    m.insert(0x01010135, "shadowDx");
    m.insert(0x01010136, "shadowDy");
    m.insert(0x01010137, "shadowRadius");
    m.insert(0x01010140, "autoLink");
    m.insert(0x01010141, "linksClickable");
    m.insert(0x01010150, "digits");
    m.insert(0x01010151, "phoneNumber");
    m.insert(0x01010152, "inputMethod");
    m.insert(0x01010153, "capitalize");
    m.insert(0x01010154, "autoText");
    m.insert(0x01010155, "editable");
    m.insert(0x01010156, "selectAllOnFocus");
    m.insert(0x01010157, "includeFontPadding");
    m.insert(0x01010158, "cursorVisible");
    m.insert(0x01010159, "maxLength");
    m.insert(0x0101015a, "scrollHorizontally");
    m.insert(0x0101015b, "password");
    m.insert(0x0101015c, "singleLine");
    m.insert(0x0101015d, "enabled");
    m.insert(0x0101015e, "numeric");
    m.insert(0x0101015f, "lines");
    m.insert(0x01010160, "height");
    m.insert(0x01010161, "minLines");
    m.insert(0x01010162, "maxLines");
    m.insert(0x01010163, "ems");
    m.insert(0x01010164, "width");
    m.insert(0x01010165, "minEms");
    m.insert(0x01010166, "maxEms");
    m.insert(0x01010167, "ellipsize");
    m.insert(0x01010168, "marqueeRepeatLimit");
    m.insert(0x01010180, "drawableTop");
    m.insert(0x01010181, "drawableBottom");
    m.insert(0x01010182, "drawableLeft");
    m.insert(0x01010183, "drawableRight");
    m.insert(0x01010184, "drawablePadding");
    m.insert(0x01010186, "textAppearanceLargePopupMenu");
    m.insert(0x01010187, "textAppearanceSmallPopupMenu");
    m.insert(0x01010212, "textColorTertiary");
    m.insert(0x01010213, "textColorTertiaryInverse");
    m.insert(0x01010220, "listDividerAlertDialog");
    m.insert(0x01010221, "listChoiceIndicatorSingle");
    m.insert(0x01010222, "listChoiceIndicatorMultiple");
    m.insert(0x01010223, "listChoiceBackgroundIndicator");
    m.insert(0x01010224, "dropDownListViewStyle");
    m.insert(0x01010225, "popupMenuStyle");
    m.insert(0x01010230, "actionBarSize");
    m.insert(0x01010231, "actionBarTabStyle");
    m.insert(0x01010232, "actionBarTabBarStyle");
    m.insert(0x01010233, "actionBarTabTextStyle");
    m.insert(0x01010234, "actionOverflowButtonStyle");
    m.insert(0x01010250, "actionBarStyle");
    m.insert(0x01010251, "actionBarSplitStyle");
    m.insert(0x01010252, "actionBarWidgetTheme");
    m.insert(0x01010253, "actionModeBackground");
    m.insert(0x01010254, "actionModeSplitBackground");
    m.insert(0x01010255, "actionModeCloseDrawable");
    m.insert(0x01010256, "actionModeCutDrawable");
    m.insert(0x01010257, "actionModeCopyDrawable");
    m.insert(0x01010258, "actionModePasteDrawable");
    m.insert(0x01010259, "actionModeSelectAllDrawable");
    m.insert(0x0101025a, "actionModeShareDrawable");
    m.insert(0x0101025b, "actionModeFindDrawable");
    m.insert(0x0101025c, "actionModeWebSearchDrawable");
    m.insert(0x01010260, "windowActionBar");
    m.insert(0x01010261, "windowActionBarOverlay");
    m.insert(0x01010262, "windowActionModeOverlay");
    m.insert(0x01010263, "windowSoftInputMode");
    m.insert(0x01010264, "imeOptions");
    m.insert(0x01010265, "imeActionLabel");
    m.insert(0x01010266, "imeActionId");
    m.insert(0x01010267, "privateImeOptions");
    m.insert(0x01010268, "editorExtras");
    m.insert(0x01010269, "inputType");
    m.insert(0x01010270, "imeFullscreenBackground");
    m.insert(0x01010271, "imeExtractEnterAnimation");
    m.insert(0x01010272, "imeExtractExitAnimation");
    m.insert(0x01010273, "contentDescription");
    m.insert(0x01010274, "targetSdkVersion");
    m.insert(0x01010275, "maxSdkVersion");
    m.insert(0x01010276, "testOnly");
    m.insert(0x0101027f, "paddingStart");
    m.insert(0x01010280, "paddingEnd");
    m.insert(0x01010283, "layout_marginStart");
    m.insert(0x01010284, "layout_marginEnd");
    m.insert(0x010102ac, "fontFamily");
    m.insert(0x010102c9, "elevation");
    m.insert(0x010102d3, "hardwareAccelerated");
    m.insert(0x0101030d, "parentActivityName");
    m.insert(0x0101034f, "textColorHighlightInverse");
    m.insert(0x01010350, "textColorLinkInverse");
    m.insert(0x0101035a, "textAllCaps");
    m.insert(0x010103f2, "supportsRtl");
    m.insert(0x0101038c, "textAllCaps");  // duplicate for compatibility
    m.insert(0x0101020c, "minSdkVersion");
    m.insert(0x0101021b, "versionCode");
    m.insert(0x0101021c, "versionName");
    m
});

/// Map of common Android framework resource IDs to names (for references)
static ANDROID_RES_MAP: LazyLock<HashMap<u32, &'static str>> = LazyLock::new(|| {
    let mut m = HashMap::new();

    // Colors (0x0106xxxx)
    m.insert(0x0106000b, "android:color/white");
    m.insert(0x0106000c, "android:color/black");
    m.insert(0x0106000d, "android:color/transparent");
    m.insert(0x01060000, "android:color/background_dark");
    m.insert(0x01060001, "android:color/background_light");
    m.insert(0x01060002, "android:color/darker_gray");
    m.insert(0x01060003, "android:color/holo_blue_bright");
    m.insert(0x01060004, "android:color/holo_blue_dark");
    m.insert(0x01060005, "android:color/holo_blue_light");
    m.insert(0x01060006, "android:color/holo_green_dark");
    m.insert(0x01060007, "android:color/holo_green_light");
    m.insert(0x01060008, "android:color/holo_orange_dark");
    m.insert(0x01060009, "android:color/holo_orange_light");
    m.insert(0x0106000a, "android:color/holo_purple");
    m.insert(0x0106000e, "android:color/holo_red_dark");
    m.insert(0x0106000f, "android:color/holo_red_light");
    m.insert(0x01060010, "android:color/primary_text_dark");
    m.insert(0x01060011, "android:color/primary_text_dark_nodisable");
    m.insert(0x01060012, "android:color/primary_text_light");
    m.insert(0x01060013, "android:color/primary_text_light_nodisable");
    m.insert(0x01060014, "android:color/secondary_text_dark");
    m.insert(0x01060015, "android:color/secondary_text_dark_nodisable");
    m.insert(0x01060016, "android:color/secondary_text_light");
    m.insert(0x01060017, "android:color/secondary_text_light_nodisable");
    m.insert(0x01060018, "android:color/tab_indicator_text");
    m.insert(0x01060019, "android:color/tertiary_text_dark");
    m.insert(0x0106001a, "android:color/tertiary_text_light");
    m.insert(0x0106001b, "android:color/widget_edittext_dark");

    // Strings (0x0104xxxx)
    m.insert(0x01040000, "android:string/cancel");
    m.insert(0x01040001, "android:string/copy");
    m.insert(0x01040002, "android:string/copyUrl");
    m.insert(0x01040003, "android:string/cut");
    m.insert(0x01040004, "android:string/defaultMs498isplayName");
    m.insert(0x01040005, "android:string/defaultVoiceMailAlphaTag");
    m.insert(0x01040006, "android:string/dialog_alert_title");
    m.insert(0x01040007, "android:string/emptyPhoneNumber");
    m.insert(0x01040008, "android:string/httpErrorBadUrl");
    m.insert(0x01040009, "android:string/no");
    m.insert(0x0104000a, "android:string/ok");
    m.insert(0x0104000b, "android:string/paste");
    m.insert(0x0104000c, "android:string/search_go");
    m.insert(0x0104000d, "android:string/selectAll");
    m.insert(0x0104000e, "android:string/selectTextMode");
    m.insert(0x0104000f, "android:string/status_bar_notification_info_overflow");
    m.insert(0x01040010, "android:string/unknownName");
    m.insert(0x01040011, "android:string/untitled");
    m.insert(0x01040012, "android:string/VideoView_error_button");
    m.insert(0x01040013, "android:string/VideoView_error_text_invalid_progressive_playback");
    m.insert(0x01040014, "android:string/VideoView_error_text_unknown");
    m.insert(0x01040015, "android:string/VideoView_error_title");
    m.insert(0x01040016, "android:string/yes");

    // Drawables (0x0108xxxx)
    m.insert(0x01080000, "android:drawable/alert_dark_frame");
    m.insert(0x01080001, "android:drawable/alert_light_frame");
    m.insert(0x01080002, "android:drawable/arrow_down_float");
    m.insert(0x01080003, "android:drawable/arrow_up_float");
    m.insert(0x01080004, "android:drawable/bottom_bar");
    m.insert(0x01080005, "android:drawable/btn_default");
    m.insert(0x01080006, "android:drawable/btn_default_small");
    m.insert(0x01080007, "android:drawable/btn_dialog");
    m.insert(0x01080008, "android:drawable/btn_dropdown");
    m.insert(0x01080009, "android:drawable/btn_minus");
    m.insert(0x0108000a, "android:drawable/btn_plus");
    m.insert(0x0108000b, "android:drawable/btn_radio");
    m.insert(0x0108000c, "android:drawable/btn_star");
    m.insert(0x0108000d, "android:drawable/btn_star_big_off");
    m.insert(0x0108000e, "android:drawable/btn_star_big_on");
    m.insert(0x01080078, "android:drawable/ic_delete");
    m.insert(0x01080079, "android:drawable/ic_dialog_alert");
    m.insert(0x0108007a, "android:drawable/ic_dialog_dialer");
    m.insert(0x0108007b, "android:drawable/ic_dialog_email");
    m.insert(0x0108007c, "android:drawable/ic_dialog_info");
    m.insert(0x0108007d, "android:drawable/ic_dialog_map");
    m.insert(0x0108009b, "android:drawable/ic_input_add");
    m.insert(0x0108009c, "android:drawable/ic_input_delete");
    m.insert(0x0108009d, "android:drawable/ic_input_get");
    m.insert(0x010800b4, "android:drawable/ic_menu_add");
    m.insert(0x010800b5, "android:drawable/ic_menu_agenda");
    m.insert(0x010800b6, "android:drawable/ic_menu_always_landscape_portrait");
    m.insert(0x010800b7, "android:drawable/ic_menu_call");
    m.insert(0x010800b8, "android:drawable/ic_menu_camera");
    m.insert(0x010800b9, "android:drawable/ic_menu_close_clear_cancel");
    m.insert(0x010800ba, "android:drawable/ic_menu_compass");
    m.insert(0x010800bb, "android:drawable/ic_menu_crop");
    m.insert(0x010800bc, "android:drawable/ic_menu_day");
    m.insert(0x010800bd, "android:drawable/ic_menu_delete");
    m.insert(0x010800be, "android:drawable/ic_menu_directions");
    m.insert(0x010800bf, "android:drawable/ic_menu_edit");
    m.insert(0x010800c0, "android:drawable/ic_menu_gallery");
    m.insert(0x010800c1, "android:drawable/ic_menu_help");
    m.insert(0x010800c2, "android:drawable/ic_menu_info_details");
    m.insert(0x010800c3, "android:drawable/ic_menu_manage");
    m.insert(0x010800c4, "android:drawable/ic_menu_mapmode");
    m.insert(0x010800c5, "android:drawable/ic_menu_month");
    m.insert(0x010800c6, "android:drawable/ic_menu_more");
    m.insert(0x010800c7, "android:drawable/ic_menu_my_calendar");
    m.insert(0x010800c8, "android:drawable/ic_menu_mylocation");
    m.insert(0x010800c9, "android:drawable/ic_menu_myplaces");
    m.insert(0x010800ca, "android:drawable/ic_menu_preferences");
    m.insert(0x010800cb, "android:drawable/ic_menu_recent_history");
    m.insert(0x010800cc, "android:drawable/ic_menu_report_image");
    m.insert(0x010800cd, "android:drawable/ic_menu_revert");
    m.insert(0x010800ce, "android:drawable/ic_menu_rotate");
    m.insert(0x010800cf, "android:drawable/ic_menu_save");
    m.insert(0x010800d0, "android:drawable/ic_menu_search");
    m.insert(0x010800d1, "android:drawable/ic_menu_send");
    m.insert(0x010800d2, "android:drawable/ic_menu_set_as");
    m.insert(0x010800d3, "android:drawable/ic_menu_share");
    m.insert(0x010800d4, "android:drawable/ic_menu_slideshow");
    m.insert(0x010800d5, "android:drawable/ic_menu_sort_alphabetically");
    m.insert(0x010800d6, "android:drawable/ic_menu_sort_by_size");
    m.insert(0x010800d7, "android:drawable/ic_menu_today");
    m.insert(0x010800d8, "android:drawable/ic_menu_upload");
    m.insert(0x010800d9, "android:drawable/ic_menu_upload_you_tube");
    m.insert(0x010800da, "android:drawable/ic_menu_view");
    m.insert(0x010800db, "android:drawable/ic_menu_week");
    m.insert(0x010800dc, "android:drawable/ic_menu_zoom");

    // Styles (0x0103xxxx)
    m.insert(0x01030000, "android:style/Animation");
    m.insert(0x01030001, "android:style/Animation.Activity");
    m.insert(0x01030002, "android:style/Animation.Dialog");
    m.insert(0x01030003, "android:style/Animation.InputMethod");
    m.insert(0x01030004, "android:style/Animation.Toast");
    m.insert(0x01030005, "android:style/Animation.Translucent");
    m.insert(0x01030006, "android:style/DeviceDefault.ButtonBar");
    m.insert(0x01030007, "android:style/DeviceDefault.ButtonBar.AlertDialog");
    m.insert(0x01030008, "android:style/DeviceDefault.Light.ButtonBar");
    m.insert(0x01030009, "android:style/DeviceDefault.Light.ButtonBar.AlertDialog");
    m.insert(0x0103000a, "android:style/DeviceDefault.Light.SegmentedButton");
    m.insert(0x0103000b, "android:style/DeviceDefault.SegmentedButton");
    m.insert(0x0103000c, "android:style/Holo.ButtonBar");
    m.insert(0x0103000d, "android:style/Holo.ButtonBar.AlertDialog");
    m.insert(0x0103000e, "android:style/Holo.Light.ButtonBar");
    m.insert(0x0103000f, "android:style/Holo.Light.ButtonBar.AlertDialog");
    m.insert(0x01030010, "android:style/Holo.Light.SegmentedButton");
    m.insert(0x01030011, "android:style/Holo.SegmentedButton");
    m.insert(0x010300a0, "android:style/TextAppearance");
    m.insert(0x010300a1, "android:style/TextAppearance.DeviceDefault");
    m.insert(0x010300a2, "android:style/TextAppearance.DeviceDefault.DialogWindowTitle");
    m.insert(0x010300a3, "android:style/TextAppearance.DeviceDefault.Inverse");
    m.insert(0x010300a4, "android:style/TextAppearance.DeviceDefault.Large");
    m.insert(0x010300a5, "android:style/TextAppearance.DeviceDefault.Large.Inverse");
    m.insert(0x010300a6, "android:style/TextAppearance.DeviceDefault.Medium");
    m.insert(0x010300a7, "android:style/TextAppearance.DeviceDefault.Medium.Inverse");
    m.insert(0x010300a8, "android:style/TextAppearance.DeviceDefault.SearchResult.Subtitle");
    m.insert(0x010300a9, "android:style/TextAppearance.DeviceDefault.SearchResult.Title");
    m.insert(0x010300aa, "android:style/TextAppearance.DeviceDefault.Small");
    m.insert(0x010300ab, "android:style/TextAppearance.DeviceDefault.Small.Inverse");
    m.insert(0x010300ac, "android:style/TextAppearance.DeviceDefault.Widget");
    m.insert(0x010300ad, "android:style/TextAppearance.DeviceDefault.Widget.ActionBar.Menu");
    m.insert(0x010300ae, "android:style/TextAppearance.DeviceDefault.Widget.ActionBar.Subtitle");
    m.insert(0x010300af, "android:style/TextAppearance.DeviceDefault.Widget.ActionBar.Subtitle.Inverse");
    m.insert(0x010300b0, "android:style/TextAppearance.DeviceDefault.Widget.ActionBar.Title");
    m.insert(0x010300b1, "android:style/TextAppearance.DeviceDefault.Widget.ActionBar.Title.Inverse");
    m.insert(0x010300b2, "android:style/TextAppearance.DeviceDefault.Widget.ActionMode.Subtitle");
    m.insert(0x010300b3, "android:style/TextAppearance.DeviceDefault.Widget.ActionMode.Subtitle.Inverse");
    m.insert(0x010300b4, "android:style/TextAppearance.DeviceDefault.Widget.ActionMode.Title");
    m.insert(0x010300b5, "android:style/TextAppearance.DeviceDefault.Widget.ActionMode.Title.Inverse");
    m.insert(0x010300b6, "android:style/TextAppearance.DeviceDefault.Widget.Button");
    m.insert(0x010300b7, "android:style/TextAppearance.DeviceDefault.Widget.DropDownHint");
    m.insert(0x010300b8, "android:style/TextAppearance.DeviceDefault.Widget.DropDownItem");
    m.insert(0x010300b9, "android:style/TextAppearance.DeviceDefault.Widget.EditText");
    m.insert(0x010300ba, "android:style/TextAppearance.DeviceDefault.Widget.IconMenu.Item");
    m.insert(0x010300bb, "android:style/TextAppearance.DeviceDefault.Widget.PopupMenu");
    m.insert(0x010300bc, "android:style/TextAppearance.DeviceDefault.Widget.PopupMenu.Large");
    m.insert(0x010300bd, "android:style/TextAppearance.DeviceDefault.Widget.PopupMenu.Small");
    m.insert(0x010300be, "android:style/TextAppearance.DeviceDefault.Widget.TabWidget");
    m.insert(0x010300bf, "android:style/TextAppearance.DeviceDefault.Widget.TextView");
    m.insert(0x010300c0, "android:style/TextAppearance.DeviceDefault.Widget.TextView.PopupMenu");
    m.insert(0x010300c1, "android:style/TextAppearance.DeviceDefault.Widget.TextView.SpinnerItem");
    m.insert(0x010300c2, "android:style/TextAppearance.DeviceDefault.WindowTitle");
    m.insert(0x010300f0, "android:style/Theme");
    m.insert(0x010300f1, "android:style/Theme.Black");
    m.insert(0x010300f2, "android:style/Theme.Black.NoTitleBar");
    m.insert(0x010300f3, "android:style/Theme.Black.NoTitleBar.Fullscreen");
    m.insert(0x010300f4, "android:style/Theme.DeviceDefault");
    m.insert(0x010300f5, "android:style/Theme.DeviceDefault.Dialog");
    m.insert(0x010300f6, "android:style/Theme.DeviceDefault.Dialog.Alert");
    m.insert(0x010300f7, "android:style/Theme.DeviceDefault.Dialog.MinWidth");
    m.insert(0x010300f8, "android:style/Theme.DeviceDefault.Dialog.NoActionBar");
    m.insert(0x010300f9, "android:style/Theme.DeviceDefault.Dialog.NoActionBar.MinWidth");
    m.insert(0x010300fa, "android:style/Theme.DeviceDefault.DialogWhenLarge");
    m.insert(0x010300fb, "android:style/Theme.DeviceDefault.DialogWhenLarge.NoActionBar");
    m.insert(0x010300fc, "android:style/Theme.DeviceDefault.InputMethod");
    m.insert(0x010300fd, "android:style/Theme.DeviceDefault.Light");
    m.insert(0x010300fe, "android:style/Theme.DeviceDefault.Light.DarkActionBar");
    m.insert(0x010300ff, "android:style/Theme.DeviceDefault.Light.Dialog");
    m.insert(0x01030100, "android:style/Theme.DeviceDefault.Light.Dialog.Alert");
    m.insert(0x01030101, "android:style/Theme.DeviceDefault.Light.Dialog.MinWidth");
    m.insert(0x01030102, "android:style/Theme.DeviceDefault.Light.Dialog.NoActionBar");
    m.insert(0x01030103, "android:style/Theme.DeviceDefault.Light.Dialog.NoActionBar.MinWidth");
    m.insert(0x01030104, "android:style/Theme.DeviceDefault.Light.DialogWhenLarge");
    m.insert(0x01030105, "android:style/Theme.DeviceDefault.Light.DialogWhenLarge.NoActionBar");
    m.insert(0x01030106, "android:style/Theme.DeviceDefault.Light.NoActionBar");
    m.insert(0x01030107, "android:style/Theme.DeviceDefault.Light.NoActionBar.Fullscreen");
    m.insert(0x01030108, "android:style/Theme.DeviceDefault.Light.NoActionBar.Overscan");
    m.insert(0x01030109, "android:style/Theme.DeviceDefault.Light.NoActionBar.TranslucentDecor");
    m.insert(0x0103010a, "android:style/Theme.DeviceDefault.Light.Panel");
    m.insert(0x0103010b, "android:style/Theme.DeviceDefault.NoActionBar");
    m.insert(0x0103010c, "android:style/Theme.DeviceDefault.NoActionBar.Fullscreen");
    m.insert(0x0103010d, "android:style/Theme.DeviceDefault.NoActionBar.Overscan");
    m.insert(0x0103010e, "android:style/Theme.DeviceDefault.NoActionBar.TranslucentDecor");
    m.insert(0x0103010f, "android:style/Theme.DeviceDefault.Panel");
    m.insert(0x01030110, "android:style/Theme.DeviceDefault.Settings");
    m.insert(0x01030111, "android:style/Theme.DeviceDefault.Wallpaper");
    m.insert(0x01030112, "android:style/Theme.DeviceDefault.Wallpaper.NoTitleBar");
    m.insert(0x01030129, "android:style/Theme.Dialog");
    m.insert(0x0103012a, "android:style/Theme.Holo");
    m.insert(0x0103012b, "android:style/Theme.Holo.Dialog");
    m.insert(0x0103012c, "android:style/Theme.Holo.Dialog.MinWidth");
    m.insert(0x0103012d, "android:style/Theme.Holo.Dialog.NoActionBar");
    m.insert(0x0103012e, "android:style/Theme.Holo.Dialog.NoActionBar.MinWidth");
    m.insert(0x0103012f, "android:style/Theme.Holo.DialogWhenLarge");
    m.insert(0x01030130, "android:style/Theme.Holo.DialogWhenLarge.NoActionBar");
    m.insert(0x01030131, "android:style/Theme.Holo.InputMethod");
    m.insert(0x01030132, "android:style/Theme.Holo.Light");
    m.insert(0x01030133, "android:style/Theme.Holo.Light.DarkActionBar");
    m.insert(0x01030134, "android:style/Theme.Holo.Light.Dialog");
    m.insert(0x01030135, "android:style/Theme.Holo.Light.Dialog.MinWidth");
    m.insert(0x01030136, "android:style/Theme.Holo.Light.Dialog.NoActionBar");
    m.insert(0x01030137, "android:style/Theme.Holo.Light.Dialog.NoActionBar.MinWidth");
    m.insert(0x01030138, "android:style/Theme.Holo.Light.DialogWhenLarge");
    m.insert(0x01030139, "android:style/Theme.Holo.Light.DialogWhenLarge.NoActionBar");
    m.insert(0x0103013a, "android:style/Theme.Holo.Light.NoActionBar");
    m.insert(0x0103013b, "android:style/Theme.Holo.Light.NoActionBar.Fullscreen");
    m.insert(0x0103013c, "android:style/Theme.Holo.Light.NoActionBar.Overscan");
    m.insert(0x0103013d, "android:style/Theme.Holo.Light.NoActionBar.TranslucentDecor");
    m.insert(0x0103013e, "android:style/Theme.Holo.Light.Panel");
    m.insert(0x0103013f, "android:style/Theme.Holo.NoActionBar");
    m.insert(0x01030140, "android:style/Theme.Holo.NoActionBar.Fullscreen");
    m.insert(0x01030141, "android:style/Theme.Holo.NoActionBar.Overscan");
    m.insert(0x01030142, "android:style/Theme.Holo.NoActionBar.TranslucentDecor");
    m.insert(0x01030143, "android:style/Theme.Holo.Panel");
    m.insert(0x01030144, "android:style/Theme.Holo.Wallpaper");
    m.insert(0x01030145, "android:style/Theme.Holo.Wallpaper.NoTitleBar");
    m.insert(0x01030170, "android:style/Theme.Light");
    m.insert(0x01030171, "android:style/Theme.Light.NoTitleBar");
    m.insert(0x01030172, "android:style/Theme.Light.NoTitleBar.Fullscreen");
    m.insert(0x01030173, "android:style/Theme.Light.Panel");
    m.insert(0x01030174, "android:style/Theme.Light.WallpaperSettings");
    m.insert(0x010301e0, "android:style/Theme.Material");
    m.insert(0x010301e1, "android:style/Theme.Material.Dialog");
    m.insert(0x010301e2, "android:style/Theme.Material.Dialog.Alert");
    m.insert(0x010301e3, "android:style/Theme.Material.Dialog.MinWidth");
    m.insert(0x010301e4, "android:style/Theme.Material.Dialog.NoActionBar");
    m.insert(0x010301e5, "android:style/Theme.Material.Dialog.NoActionBar.MinWidth");
    m.insert(0x010301e6, "android:style/Theme.Material.Dialog.Presentation");
    m.insert(0x010301e7, "android:style/Theme.Material.DialogWhenLarge");
    m.insert(0x010301e8, "android:style/Theme.Material.DialogWhenLarge.NoActionBar");
    m.insert(0x010301e9, "android:style/Theme.Material.InputMethod");
    m.insert(0x010301ea, "android:style/Theme.Material.Light");
    m.insert(0x010301eb, "android:style/Theme.Material.Light.DarkActionBar");
    m.insert(0x010301ec, "android:style/Theme.Material.Light.Dialog");
    m.insert(0x010301ed, "android:style/Theme.Material.Light.Dialog.Alert");
    m.insert(0x010301ee, "android:style/Theme.Material.Light.Dialog.MinWidth");
    m.insert(0x010301ef, "android:style/Theme.Material.Light.Dialog.NoActionBar");
    m.insert(0x010301f0, "android:style/Theme.Material.Light.Dialog.NoActionBar.MinWidth");
    m.insert(0x010301f1, "android:style/Theme.Material.Light.Dialog.Presentation");
    m.insert(0x010301f2, "android:style/Theme.Material.Light.DialogWhenLarge");
    m.insert(0x010301f3, "android:style/Theme.Material.Light.DialogWhenLarge.NoActionBar");
    m.insert(0x010301f4, "android:style/Theme.Material.Light.LightStatusBar");
    m.insert(0x010301f5, "android:style/Theme.Material.Light.NoActionBar");
    m.insert(0x010301f6, "android:style/Theme.Material.Light.NoActionBar.Fullscreen");
    m.insert(0x010301f7, "android:style/Theme.Material.Light.NoActionBar.Overscan");
    m.insert(0x010301f8, "android:style/Theme.Material.Light.NoActionBar.TranslucentDecor");
    m.insert(0x010301f9, "android:style/Theme.Material.Light.Panel");
    m.insert(0x010301fa, "android:style/Theme.Material.Light.Voice");
    m.insert(0x010301fb, "android:style/Theme.Material.NoActionBar");
    m.insert(0x010301fc, "android:style/Theme.Material.NoActionBar.Fullscreen");
    m.insert(0x010301fd, "android:style/Theme.Material.NoActionBar.Overscan");
    m.insert(0x010301fe, "android:style/Theme.Material.NoActionBar.TranslucentDecor");
    m.insert(0x010301ff, "android:style/Theme.Material.Panel");
    m.insert(0x01030200, "android:style/Theme.Material.Settings");
    m.insert(0x01030201, "android:style/Theme.Material.Voice");
    m.insert(0x01030202, "android:style/Theme.Material.Wallpaper");
    m.insert(0x01030203, "android:style/Theme.Material.Wallpaper.NoTitleBar");
    m.insert(0x01030210, "android:style/Theme.NoTitleBar");
    m.insert(0x01030211, "android:style/Theme.NoTitleBar.Fullscreen");
    m.insert(0x01030212, "android:style/Theme.NoTitleBar.OverlayActionModes");
    m.insert(0x01030213, "android:style/Theme.Panel");
    m.insert(0x01030214, "android:style/Theme.Translucent");
    m.insert(0x01030215, "android:style/Theme.Translucent.NoTitleBar");
    m.insert(0x01030216, "android:style/Theme.Translucent.NoTitleBar.Fullscreen");
    m.insert(0x01030217, "android:style/Theme.Wallpaper");
    m.insert(0x01030218, "android:style/Theme.Wallpaper.NoTitleBar");
    m.insert(0x01030219, "android:style/Theme.Wallpaper.NoTitleBar.Fullscreen");
    m.insert(0x0103021a, "android:style/Theme.WallpaperSettings");
    m.insert(0x0103021b, "android:style/Theme.WithActionBar");

    // IDs (0x0102xxxx)
    m.insert(0x01020000, "android:id/background");
    m.insert(0x01020001, "android:id/button1");
    m.insert(0x01020002, "android:id/button2");
    m.insert(0x01020003, "android:id/button3");
    m.insert(0x01020004, "android:id/candidatesArea");
    m.insert(0x01020005, "android:id/checkbox");
    m.insert(0x01020006, "android:id/closeButton");
    m.insert(0x01020007, "android:id/content");
    m.insert(0x01020008, "android:id/copy");
    m.insert(0x01020009, "android:id/custom");
    m.insert(0x0102000a, "android:id/cut");
    m.insert(0x0102000b, "android:id/edit");
    m.insert(0x0102000c, "android:id/empty");
    m.insert(0x0102000d, "android:id/extractArea");
    m.insert(0x0102000e, "android:id/hint");
    m.insert(0x0102000f, "android:id/home");
    m.insert(0x01020010, "android:id/icon");
    m.insert(0x01020011, "android:id/icon1");
    m.insert(0x01020012, "android:id/icon2");
    m.insert(0x01020013, "android:id/input");
    m.insert(0x01020014, "android:id/inputArea");
    m.insert(0x01020015, "android:id/inputExtractEditText");
    m.insert(0x01020016, "android:id/keyboardView");
    m.insert(0x01020017, "android:id/list");
    m.insert(0x01020018, "android:id/list_container");
    m.insert(0x01020019, "android:id/mask");
    m.insert(0x0102001a, "android:id/message");
    m.insert(0x0102001b, "android:id/navigationBarBackground");
    m.insert(0x0102001c, "android:id/paste");
    m.insert(0x0102001d, "android:id/primary");
    m.insert(0x0102001e, "android:id/progress");
    m.insert(0x0102001f, "android:id/secondaryProgress");
    m.insert(0x01020020, "android:id/selectAll");
    m.insert(0x01020021, "android:id/selectTextMode");
    m.insert(0x01020022, "android:id/selectedIcon");
    m.insert(0x01020023, "android:id/startSelectingText");
    m.insert(0x01020024, "android:id/statusBarBackground");
    m.insert(0x01020025, "android:id/stopSelectingText");
    m.insert(0x01020026, "android:id/summary");
    m.insert(0x01020027, "android:id/switchInputMethod");
    m.insert(0x01020028, "android:id/tabcontent");
    m.insert(0x01020029, "android:id/tabhost");
    m.insert(0x0102002a, "android:id/tabs");
    m.insert(0x0102002b, "android:id/text1");
    m.insert(0x0102002c, "android:id/text2");
    m.insert(0x0102002d, "android:id/title");
    m.insert(0x0102002e, "android:id/toggle");
    m.insert(0x0102002f, "android:id/widget_frame");

    m
});

/// Resource configuration parsed from ResTable_config
#[derive(Debug, Clone, Default)]
pub struct ResConfig {
    /// Mobile Country Code
    pub mcc: u16,
    /// Mobile Network Code
    pub mnc: u16,
    /// Language code (2 chars)
    pub language: [u8; 2],
    /// Country/region code (2 chars)
    pub country: [u8; 2],
    /// Orientation (0=any, 1=port, 2=land, 3=square)
    pub orientation: u8,
    /// Touchscreen type
    pub touchscreen: u8,
    /// Screen density (DPI)
    pub density: u16,
    /// Keyboard type
    pub keyboard: u8,
    /// Navigation type
    pub navigation: u8,
    /// Input flags
    pub input_flags: u8,
    /// Screen width (pixels)
    pub screen_width: u16,
    /// Screen height (pixels)
    pub screen_height: u16,
    /// SDK version (e.g., 21 for Android 5.0)
    pub sdk_version: u16,
    /// Minor version
    pub minor_version: u16,
    /// Screen layout flags
    pub screen_layout: u8,
    /// UI mode (car, desk, television, etc.)
    pub ui_mode: u8,
    /// Smallest screen width dp
    pub smallest_screen_width_dp: u16,
    /// Screen width dp
    pub screen_width_dp: u16,
    /// Screen height dp
    pub screen_height_dp: u16,
    /// Locale script (4 chars, BCP 47)
    pub locale_script: [u8; 4],
    /// Locale variant (8 chars, BCP 47)
    pub locale_variant: [u8; 8],
    /// Screen layout 2 (round screen)
    pub screen_layout2: u8,
    /// Color mode (wide color gamut, HDR)
    pub color_mode: u8,
}

impl ResConfig {
    /// Parse a ResTable_config from the cursor
    pub fn parse(cursor: &mut Cursor<&[u8]>, config_size: u32) -> Result<Self> {
        let start = cursor.position();
        let mut config = Self::default();

        if config_size == 0 {
            return Ok(config);
        }

        // imsi: mcc (2) + mnc (2) = 4 bytes at offset 4
        if config_size >= 8 {
            config.mcc = cursor.read_u16::<LittleEndian>()?;
            config.mnc = cursor.read_u16::<LittleEndian>()?;
        }

        // locale: language (2) + country (2) = 4 bytes at offset 8
        if config_size >= 12 {
            cursor.read_exact(&mut config.language)?;
            cursor.read_exact(&mut config.country)?;
        }

        // screenType: orientation (1) + touchscreen (1) + density (2) = 4 bytes at offset 12
        if config_size >= 16 {
            config.orientation = cursor.read_u8()?;
            config.touchscreen = cursor.read_u8()?;
            config.density = cursor.read_u16::<LittleEndian>()?;
        }

        // input: keyboard (1) + navigation (1) + inputFlags (1) + inputPad0 (1) = 4 bytes at offset 16
        if config_size >= 20 {
            config.keyboard = cursor.read_u8()?;
            config.navigation = cursor.read_u8()?;
            config.input_flags = cursor.read_u8()?;
            let _pad = cursor.read_u8()?;
        }

        // screenSize: width (2) + height (2) = 4 bytes at offset 20
        if config_size >= 24 {
            config.screen_width = cursor.read_u16::<LittleEndian>()?;
            config.screen_height = cursor.read_u16::<LittleEndian>()?;
        }

        // version: sdkVersion (2) + minorVersion (2) = 4 bytes at offset 24
        if config_size >= 28 {
            config.sdk_version = cursor.read_u16::<LittleEndian>()?;
            config.minor_version = cursor.read_u16::<LittleEndian>()?;
        }

        // screenConfig: screenLayout (1) + uiMode (1) + smallestScreenWidthDp (2) = 4 bytes at offset 28
        if config_size >= 32 {
            config.screen_layout = cursor.read_u8()?;
            config.ui_mode = cursor.read_u8()?;
            config.smallest_screen_width_dp = cursor.read_u16::<LittleEndian>()?;
        }

        // screenSizeDp: screenWidthDp (2) + screenHeightDp (2) = 4 bytes at offset 32
        if config_size >= 36 {
            config.screen_width_dp = cursor.read_u16::<LittleEndian>()?;
            config.screen_height_dp = cursor.read_u16::<LittleEndian>()?;
        }

        // localeScript: 4 bytes at offset 36
        if config_size >= 40 {
            cursor.read_exact(&mut config.locale_script)?;
        }

        // localeVariant: 8 bytes at offset 40
        if config_size >= 48 {
            cursor.read_exact(&mut config.locale_variant)?;
        }

        // screenConfig2: screenLayout2 (1) + colorMode (1) + reserved (2) = 4 bytes at offset 48
        if config_size >= 52 {
            config.screen_layout2 = cursor.read_u8()?;
            config.color_mode = cursor.read_u8()?;
            let _reserved = cursor.read_u16::<LittleEndian>()?;
        }

        // Skip any remaining bytes in config
        let consumed = cursor.position() - start;
        if consumed < config_size as u64 {
            cursor.seek(SeekFrom::Current((config_size as u64 - consumed) as i64))?;
        }

        Ok(config)
    }

    /// Convert to qualifier string (e.g., "en-rUS-hdpi-v21")
    pub fn to_qualifier_string(&self) -> String {
        let mut parts = Vec::new();

        // MCC
        if self.mcc != 0 {
            parts.push(format!("mcc{}", self.mcc));
        }

        // MNC
        if self.mnc != 0 {
            parts.push(format!("mnc{}", self.mnc));
        }

        // Language/locale
        if self.language[0] != 0 {
            let lang = String::from_utf8_lossy(&self.language)
                .trim_end_matches('\0')
                .to_string();
            if !lang.is_empty() {
                if self.country[0] != 0 {
                    let country = String::from_utf8_lossy(&self.country)
                        .trim_end_matches('\0')
                        .to_string();
                    if !country.is_empty() {
                        parts.push(format!("{}-r{}", lang, country));
                    } else {
                        parts.push(lang);
                    }
                } else {
                    parts.push(lang);
                }
            }
        }

        // Locale script (BCP 47)
        if self.locale_script[0] != 0 {
            let script = String::from_utf8_lossy(&self.locale_script)
                .trim_end_matches('\0')
                .to_string();
            if !script.is_empty() {
                parts.push(format!("b+{}", script));
            }
        }

        // Screen layout size
        match self.screen_layout & 0x0F {
            1 => parts.push("small".to_string()),
            2 => parts.push("normal".to_string()),
            3 => parts.push("large".to_string()),
            4 => parts.push("xlarge".to_string()),
            _ => {}
        }

        // Screen layout long
        match (self.screen_layout >> 4) & 0x03 {
            1 => parts.push("notlong".to_string()),
            2 => parts.push("long".to_string()),
            _ => {}
        }

        // Screen round (from screenLayout2)
        match self.screen_layout2 & 0x03 {
            1 => parts.push("notround".to_string()),
            2 => parts.push("round".to_string()),
            _ => {}
        }

        // Wide color gamut
        match self.color_mode & 0x03 {
            1 => parts.push("nowidecg".to_string()),
            2 => parts.push("widecg".to_string()),
            _ => {}
        }

        // HDR
        match (self.color_mode >> 2) & 0x03 {
            1 => parts.push("lowdr".to_string()),
            2 => parts.push("highdr".to_string()),
            _ => {}
        }

        // Orientation
        match self.orientation {
            1 => parts.push("port".to_string()),
            2 => parts.push("land".to_string()),
            3 => parts.push("square".to_string()),
            _ => {}
        }

        // UI mode type
        match self.ui_mode & 0x0F {
            1 => parts.push("car".to_string()),
            2 => parts.push("desk".to_string()),
            3 => parts.push("television".to_string()),
            4 => parts.push("appliance".to_string()),
            5 => parts.push("watch".to_string()),
            6 => parts.push("vrheadset".to_string()),
            _ => {}
        }

        // UI mode night
        match (self.ui_mode >> 4) & 0x03 {
            1 => parts.push("notnight".to_string()),
            2 => parts.push("night".to_string()),
            _ => {}
        }

        // Density
        match self.density {
            0 => {}  // default
            0xFFFF => parts.push("nodpi".to_string()),
            0xFFFE => parts.push("anydpi".to_string()),
            120 => parts.push("ldpi".to_string()),
            160 => parts.push("mdpi".to_string()),
            213 => parts.push("tvdpi".to_string()),
            240 => parts.push("hdpi".to_string()),
            320 => parts.push("xhdpi".to_string()),
            480 => parts.push("xxhdpi".to_string()),
            640 => parts.push("xxxhdpi".to_string()),
            d => parts.push(format!("{}dpi", d)),
        }

        // Touchscreen
        match self.touchscreen {
            1 => parts.push("notouch".to_string()),
            2 => parts.push("stylus".to_string()),
            3 => parts.push("finger".to_string()),
            _ => {}
        }

        // Keyboard hidden (from input_flags)
        match self.input_flags & 0x03 {
            1 => parts.push("keysexposed".to_string()),
            2 => parts.push("keyshidden".to_string()),
            3 => parts.push("keyssoft".to_string()),
            _ => {}
        }

        // Keyboard type
        match self.keyboard {
            1 => parts.push("nokeys".to_string()),
            2 => parts.push("qwerty".to_string()),
            3 => parts.push("12key".to_string()),
            _ => {}
        }

        // Navigation hidden (from input_flags)
        match (self.input_flags >> 2) & 0x03 {
            1 => parts.push("navexposed".to_string()),
            2 => parts.push("navhidden".to_string()),
            _ => {}
        }

        // Navigation type
        match self.navigation {
            1 => parts.push("nonav".to_string()),
            2 => parts.push("dpad".to_string()),
            3 => parts.push("trackball".to_string()),
            4 => parts.push("wheel".to_string()),
            _ => {}
        }

        // Smallest screen width
        if self.smallest_screen_width_dp != 0 {
            parts.push(format!("sw{}dp", self.smallest_screen_width_dp));
        }

        // Screen width
        if self.screen_width_dp != 0 {
            parts.push(format!("w{}dp", self.screen_width_dp));
        }

        // Screen height
        if self.screen_height_dp != 0 {
            parts.push(format!("h{}dp", self.screen_height_dp));
        }

        // SDK version
        if self.sdk_version != 0 {
            parts.push(format!("v{}", self.sdk_version));
        }

        if parts.is_empty() {
            "default".to_string()
        } else {
            parts.join("-")
        }
    }
}

/// Raw value from resource table (type + data)
#[derive(Debug, Clone, Copy)]
pub struct RawValue {
    /// Value type (TYPE_STRING, TYPE_INT_DEC, TYPE_INT_COLOR_ARGB8, etc.)
    pub data_type: u8,
    /// Raw value data
    pub data: u32,
}

impl RawValue {
    /// Create a new raw value
    pub fn new(data_type: u8, data: u32) -> Self {
        Self { data_type, data }
    }
}

/// A single item in a bag/style/array resource
#[derive(Debug, Clone)]
pub struct BagItem {
    /// Attribute resource ID (key)
    pub name: u32,
    /// Value
    pub value: RawValue,
}

/// Resource entry information
#[derive(Debug, Clone)]
pub struct ResourceEntry {
    /// Resource ID (0xPPTTEEEE format)
    pub id: u32,
    /// Package name
    pub package_name: String,
    /// Type name (e.g., "drawable", "string", "layout")
    pub type_name: String,
    /// Entry name (e.g., "app_name", "ic_launcher")
    pub key_name: String,
    /// Simple value (for non-complex resources)
    pub value: Option<RawValue>,
    /// Complex entries (for styles, arrays, plurals, etc.)
    pub bag_items: Option<Vec<BagItem>>,
    /// Parent resource ID (for style inheritance)
    pub parent: Option<u32>,
    /// Configuration qualifier (e.g., "default", "hdpi", "v21")
    pub config: String,
}

impl ResourceEntry {
    /// Get the full resource name (type/name)
    pub fn full_name(&self) -> String {
        format!("{}/{}", self.type_name, self.key_name)
    }
}

/// Parsed resource table
pub struct ArscParser {
    /// Global string pool
    strings: StringPool,
    /// Parsed resource entries
    entries: Vec<ResourceEntry>,
    /// Resource ID to full name mapping
    res_names: HashMap<u32, String>,
}

impl ArscParser {
    /// Create a new ARSC parser
    pub fn new() -> Self {
        Self {
            strings: StringPool::empty(),
            entries: Vec::new(),
            res_names: HashMap::new(),
        }
    }

    /// Parse an ARSC file from bytes
    pub fn parse(&mut self, data: &[u8]) -> Result<()> {
        self.entries.clear();
        self.res_names.clear();

        let mut cursor = Cursor::new(data);

        // Read header
        let chunk_type = cursor.read_u16::<LittleEndian>()?;
        if chunk_type != RES_TABLE_TYPE {
            return Err(ResourceError::InvalidArsc(format!(
                "Expected RES_TABLE_TYPE (0x0002), got 0x{:04x}",
                chunk_type
            )));
        }

        let header_size = cursor.read_u16::<LittleEndian>()?;
        let chunk_size = cursor.read_u32::<LittleEndian>()?;
        let package_count = cursor.read_u32::<LittleEndian>()?;

        // Skip to end of header if needed
        if header_size > 12 {
            cursor.seek(SeekFrom::Current((header_size as i64) - 12))?;
        }

        // Parse global string pool
        let pool_type = cursor.read_u16::<LittleEndian>()?;
        if pool_type == RES_STRING_POOL_TYPE {
            self.parse_string_pool(&mut cursor)?;
        } else {
            return Err(ResourceError::InvalidArsc(
                "Expected string pool after header".to_string(),
            ));
        }

        // Parse packages
        for _ in 0..package_count {
            if cursor.position() >= chunk_size as u64 {
                break;
            }
            self.parse_package(&mut cursor)?;
        }

        Ok(())
    }

    /// Get the resource names map
    pub fn get_res_names(&self) -> HashMap<u32, String> {
        self.res_names.clone()
    }

    /// Get all parsed resource entries
    pub fn get_entries(&self) -> &[ResourceEntry] {
        &self.entries
    }

    /// Parse string pool chunk
    fn parse_string_pool(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        let start = cursor.position() - 2;
        let _header_size = cursor.read_u16::<LittleEndian>()?;
        let chunk_size = cursor.read_u32::<LittleEndian>()?;

        let string_count = cursor.read_u32::<LittleEndian>()?;
        let _style_count = cursor.read_u32::<LittleEndian>()?;
        let flags = cursor.read_u32::<LittleEndian>()?;
        let strings_start = cursor.read_u32::<LittleEndian>()?;
        let _styles_start = cursor.read_u32::<LittleEndian>()?;

        let header_consumed = cursor.position() - start;
        let adjusted_strings_start = strings_start as u64 - header_consumed;

        let remaining = chunk_size as u64 - (cursor.position() - start);
        let mut buffer = vec![0u8; remaining as usize];
        cursor.read_exact(&mut buffer)?;

        self.strings = StringPool::new(string_count, adjusted_strings_start as u32, buffer, flags);

        Ok(())
    }

    /// Parse a package chunk
    fn parse_package(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        let chunk_type = cursor.read_u16::<LittleEndian>()?;
        if chunk_type != RES_TABLE_PACKAGE_TYPE {
            // Skip unknown chunk
            let _header_size = cursor.read_u16::<LittleEndian>()?;
            let chunk_size = cursor.read_u32::<LittleEndian>()?;
            cursor.seek(SeekFrom::Current((chunk_size - 8) as i64))?;
            return Ok(());
        }

        let header_size = cursor.read_u16::<LittleEndian>()?;
        let chunk_size = cursor.read_u32::<LittleEndian>()?;
        let package_start = cursor.position() - 8;
        let package_end = package_start + chunk_size as u64;

        let package_id = cursor.read_u32::<LittleEndian>()?;

        // Read package name (256 bytes, UTF-16)
        let mut name_bytes = [0u8; 256];
        cursor.read_exact(&mut name_bytes)?;
        let package_name = decode_utf16_name(&name_bytes);

        let type_strings_offset = cursor.read_u32::<LittleEndian>()?;
        let _last_public_type = cursor.read_u32::<LittleEndian>()?;
        let key_strings_offset = cursor.read_u32::<LittleEndian>()?;
        let _last_public_key = cursor.read_u32::<LittleEndian>()?;

        // Skip to end of header
        cursor.seek(SeekFrom::Start(package_start + header_size as u64))?;

        // Parse type string pool
        let mut type_strings = StringPool::empty();
        if type_strings_offset != 0 {
            cursor.seek(SeekFrom::Start(package_start + type_strings_offset as u64))?;
            let pool_type = cursor.read_u16::<LittleEndian>()?;
            if pool_type == RES_STRING_POOL_TYPE {
                type_strings = self.parse_string_pool_inline(cursor)?;
            }
        }

        // Parse key string pool
        let mut key_strings = StringPool::empty();
        if key_strings_offset != 0 {
            cursor.seek(SeekFrom::Start(package_start + key_strings_offset as u64))?;
            let pool_type = cursor.read_u16::<LittleEndian>()?;
            if pool_type == RES_STRING_POOL_TYPE {
                key_strings = self.parse_string_pool_inline(cursor)?;
            }
        }

        // Parse type specs and types
        while cursor.position() < package_end {
            let pos = cursor.position();
            if pos + 8 > package_end {
                break;
            }

            let chunk_type = cursor.read_u16::<LittleEndian>()?;
            let chunk_header_size = cursor.read_u16::<LittleEndian>()?;
            let chunk_size = cursor.read_u32::<LittleEndian>()?;

            if chunk_size == 0 || pos + chunk_size as u64 > package_end {
                break;
            }

            match chunk_type {
                RES_TABLE_TYPE_SPEC_TYPE => {
                    // Type spec - skip for now, we just need the entries
                    cursor.seek(SeekFrom::Start(pos + chunk_size as u64))?;
                }
                RES_TABLE_TYPE_TYPE => {
                    // Actual resource type with entries
                    self.parse_type_chunk(
                        cursor,
                        pos,
                        chunk_header_size,
                        chunk_size,
                        package_id,
                        &package_name,
                        &mut type_strings,
                        &mut key_strings,
                    )?;
                }
                RES_TABLE_TYPE_LIBRARY | RES_TABLE_TYPE_OVERLAY |
                RES_TABLE_TYPE_OVERLAY_POLICY | RES_TABLE_TYPE_STAGED_ALIAS => {
                    // Skip these chunks
                    cursor.seek(SeekFrom::Start(pos + chunk_size as u64))?;
                }
                _ => {
                    // Unknown chunk, skip
                    cursor.seek(SeekFrom::Start(pos + chunk_size as u64))?;
                }
            }
        }

        Ok(())
    }

    /// Parse a string pool inline and return it
    fn parse_string_pool_inline(&self, cursor: &mut Cursor<&[u8]>) -> Result<StringPool> {
        let start = cursor.position() - 2;
        let _header_size = cursor.read_u16::<LittleEndian>()?;
        let chunk_size = cursor.read_u32::<LittleEndian>()?;

        let string_count = cursor.read_u32::<LittleEndian>()?;
        let _style_count = cursor.read_u32::<LittleEndian>()?;
        let flags = cursor.read_u32::<LittleEndian>()?;
        let strings_start = cursor.read_u32::<LittleEndian>()?;
        let _styles_start = cursor.read_u32::<LittleEndian>()?;

        let header_consumed = cursor.position() - start;
        let adjusted_strings_start = strings_start as u64 - header_consumed;

        let remaining = chunk_size as u64 - (cursor.position() - start);
        let mut buffer = vec![0u8; remaining as usize];
        cursor.read_exact(&mut buffer)?;

        Ok(StringPool::new(
            string_count,
            adjusted_strings_start as u32,
            buffer,
            flags,
        ))
    }

    /// Parse a type chunk with resource entries
    #[allow(clippy::too_many_arguments)]
    fn parse_type_chunk(
        &mut self,
        cursor: &mut Cursor<&[u8]>,
        chunk_start: u64,
        header_size: u16,
        chunk_size: u32,
        package_id: u32,
        package_name: &str,
        type_strings: &mut StringPool,
        key_strings: &mut StringPool,
    ) -> Result<()> {
        // Read type header
        let type_id = cursor.read_u8()?;
        let flags = cursor.read_u8()?;
        let _reserved = cursor.read_u16::<LittleEndian>()?;
        let entry_count = cursor.read_u32::<LittleEndian>()?;
        let entries_start = cursor.read_u32::<LittleEndian>()?;

        // Parse ResTable_config - size is first 4 bytes
        let config_size = cursor.read_u32::<LittleEndian>()?;
        let res_config = ResConfig::parse(cursor, config_size.saturating_sub(4))?;
        let config = res_config.to_qualifier_string();

        // Seek to end of header (in case config was shorter than expected)
        cursor.seek(SeekFrom::Start(chunk_start + header_size as u64))?;

        // Get type name
        let type_name = type_strings
            .get((type_id - 1) as u32)
            .unwrap_or_else(|| format!("type{}", type_id));

        // Read entry offsets or sparse entries
        let is_sparse = (flags & FLAG_SPARSE) != 0;
        let is_offset16 = (flags & FLAG_OFFSET16) != 0;

        let data_start = chunk_start + entries_start as u64;

        if is_sparse {
            // Sparse entries
            let count = entry_count;
            for _ in 0..count {
                let idx = cursor.read_u16::<LittleEndian>()? as u32;
                let offset = if is_offset16 {
                    (cursor.read_u16::<LittleEndian>()? as u32) * 4
                } else {
                    cursor.read_u32::<LittleEndian>()?
                };

                if offset != NO_ENTRY {
                    self.parse_entry(
                        cursor,
                        data_start + offset as u64,
                        package_id,
                        type_id as u32,
                        idx,
                        package_name,
                        &type_name,
                        key_strings,
                        &config,
                    )?;
                }
            }
        } else {
            // Dense entries
            let mut offsets = Vec::with_capacity(entry_count as usize);
            for _ in 0..entry_count {
                let offset = if is_offset16 {
                    let o = cursor.read_u16::<LittleEndian>()?;
                    if o == 0xFFFF {
                        NO_ENTRY
                    } else {
                        (o as u32) * 4
                    }
                } else {
                    cursor.read_u32::<LittleEndian>()?
                };
                offsets.push(offset);
            }

            for (idx, &offset) in offsets.iter().enumerate() {
                if offset != NO_ENTRY {
                    self.parse_entry(
                        cursor,
                        data_start + offset as u64,
                        package_id,
                        type_id as u32,
                        idx as u32,
                        package_name,
                        &type_name,
                        key_strings,
                        &config,
                    )?;
                }
            }
        }

        // Seek to end of chunk
        cursor.seek(SeekFrom::Start(chunk_start + chunk_size as u64))?;

        Ok(())
    }

    /// Parse a single resource entry
    #[allow(clippy::too_many_arguments)]
    fn parse_entry(
        &mut self,
        cursor: &mut Cursor<&[u8]>,
        entry_pos: u64,
        package_id: u32,
        type_id: u32,
        entry_idx: u32,
        package_name: &str,
        type_name: &str,
        key_strings: &mut StringPool,
        config: &str,
    ) -> Result<()> {
        let saved_pos = cursor.position();
        cursor.seek(SeekFrom::Start(entry_pos))?;

        // Read entry header
        let size_or_flags = cursor.read_u16::<LittleEndian>()?;
        let flags = cursor.read_u16::<LittleEndian>()?;

        // Check for compact entry format
        let (key_idx, value, bag_items, parent) = if (flags & FLAG_COMPACT) != 0 {
            // Compact format: size_or_flags is actually the key index
            // Value follows directly: type (1 byte) + data (3 bytes packed)
            let data_type = cursor.read_u8()?;
            let data = cursor.read_u24::<LittleEndian>()?;
            (size_or_flags as u32, Some(RawValue::new(data_type, data)), None, None)
        } else {
            // Normal format
            let key = cursor.read_u32::<LittleEndian>()?;

            // Check if complex entry
            let is_complex = (flags & FLAG_COMPLEX) != 0;

            if !is_complex {
                // Simple value: size (2) + res0 (1) + dataType (1) + data (4)
                let _value_size = cursor.read_u16::<LittleEndian>()?;
                let _res0 = cursor.read_u8()?;
                let data_type = cursor.read_u8()?;
                let data = cursor.read_u32::<LittleEndian>()?;
                (key, Some(RawValue::new(data_type, data)), None, None)
            } else {
                // Complex entry (bag/style/array/plural)
                // Structure: parent (4) + count (4) + items[]
                let parent_id = cursor.read_u32::<LittleEndian>()?;
                let count = cursor.read_u32::<LittleEndian>()?;

                let mut items = Vec::with_capacity(count as usize);
                for _ in 0..count {
                    // Each item: name (4) + Res_value (size:2 + res0:1 + dataType:1 + data:4)
                    let name = cursor.read_u32::<LittleEndian>()?;
                    let _value_size = cursor.read_u16::<LittleEndian>()?;
                    let _res0 = cursor.read_u8()?;
                    let data_type = cursor.read_u8()?;
                    let data = cursor.read_u32::<LittleEndian>()?;

                    items.push(BagItem {
                        name,
                        value: RawValue::new(data_type, data),
                    });
                }

                let parent = if parent_id != 0 { Some(parent_id) } else { None };
                (key, None, Some(items), parent)
            }
        };

        // Get key name
        let key_name = key_strings
            .get(key_idx)
            .unwrap_or_else(|| format!("entry{}", entry_idx));

        // Build resource ID: 0xPPTTEEEE
        let res_id = (package_id << 24) | (type_id << 16) | entry_idx;

        // Add entry
        let entry = ResourceEntry {
            id: res_id,
            package_name: package_name.to_string(),
            type_name: type_name.to_string(),
            key_name: key_name.clone(),
            value,
            bag_items,
            parent,
            config: config.to_string(),
        };

        self.res_names.insert(res_id, entry.full_name());
        self.entries.push(entry);

        cursor.seek(SeekFrom::Start(saved_pos))?;
        Ok(())
    }

    /// Decode a value to its string representation
    pub fn decode_value(&mut self, value: &RawValue) -> Option<String> {
        match value.data_type {
            TYPE_NULL => None,
            TYPE_STRING => self.strings.get(value.data),
            TYPE_INT_DEC => Some(value.data.to_string()),
            TYPE_INT_HEX => Some(format!("0x{:x}", value.data)),
            TYPE_INT_BOOLEAN => Some(if value.data == 0 { "false" } else { "true" }.to_string()),
            TYPE_FLOAT => Some(format!("{}", f32::from_bits(value.data))),
            TYPE_INT_COLOR_ARGB8 => Some(format!("#{:08x}", value.data)),
            TYPE_INT_COLOR_RGB8 => Some(format!("#{:06x}", value.data & 0xFFFFFF)),
            TYPE_INT_COLOR_ARGB4 => Some(format!("#{:04x}", value.data & 0xFFFF)),
            TYPE_INT_COLOR_RGB4 => Some(format!("#{:03x}", value.data & 0xFFF)),
            TYPE_REFERENCE => {
                if value.data == 0 {
                    Some("@null".to_string())
                } else if let Some(name) = self.res_names.get(&value.data) {
                    Some(format!("@{}", name))
                } else if let Some(name) = ANDROID_RES_MAP.get(&value.data) {
                    // Android framework resource
                    Some(format!("@{}", name))
                } else {
                    Some(format!("@0x{:08x}", value.data))
                }
            }
            TYPE_ATTRIBUTE => {
                if let Some(name) = self.res_names.get(&value.data) {
                    Some(format!("?{}", name))
                } else if let Some(name) = ANDROID_RES_MAP.get(&value.data) {
                    // Android framework attribute
                    Some(format!("?{}", name))
                } else if let Some(name) = ANDROID_ATTR_MAP.get(&value.data) {
                    // Android framework attribute from attr map
                    Some(format!("?android:attr/{}", name))
                } else {
                    Some(format!("?0x{:08x}", value.data))
                }
            }
            TYPE_DIMENSION => Some(decode_dimension(value.data)),
            TYPE_FRACTION => Some(decode_fraction(value.data)),
            _ => Some(format!("0x{:08x}", value.data)),
        }
    }

    /// Check if a value type is a color
    fn is_color_type(data_type: u8) -> bool {
        matches!(
            data_type,
            TYPE_INT_COLOR_ARGB8 | TYPE_INT_COLOR_RGB8 | TYPE_INT_COLOR_ARGB4 | TYPE_INT_COLOR_RGB4
        )
    }

    /// Generate strings.xml content
    pub fn generate_strings_xml(&mut self) -> String {
        let mut xml = String::from("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");

        // Collect string entries (default config only)
        let string_entries: Vec<_> = self
            .entries
            .iter()
            .filter(|e| e.type_name == "string" && e.config == "default")
            .cloned()
            .collect();

        for entry in string_entries {
            if let Some(ref value) = entry.value {
                match value.data_type {
                    TYPE_STRING => {
                        if let Some(decoded) = self.strings.get(value.data) {
                            let escaped = escape_string_resource(&decoded);
                            xml.push_str(&format!(
                                "    <string name=\"{}\">{}</string>\n",
                                entry.key_name, escaped
                            ));
                        }
                    }
                    TYPE_REFERENCE => {
                        // Include string references (e.g., @android:string/cancel)
                        let ref_str = self.decode_value(value).unwrap_or_else(|| format!("@0x{:08x}", value.data));
                        xml.push_str(&format!(
                            "    <string name=\"{}\">{}</string>\n",
                            entry.key_name, ref_str
                        ));
                    }
                    _ => {}
                }
            }
        }

        xml.push_str("</resources>\n");
        xml
    }

    /// Generate colors.xml content
    pub fn generate_colors_xml(&mut self) -> String {
        let mut xml = String::from("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");

        // Collect color entries (default config only)
        let color_entries: Vec<_> = self
            .entries
            .iter()
            .filter(|e| e.type_name == "color" && e.config == "default")
            .cloned()
            .collect();

        for entry in color_entries {
            if let Some(ref value) = entry.value {
                // Include color values, references, and attributes
                if Self::is_color_type(value.data_type)
                    || value.data_type == TYPE_REFERENCE
                    || value.data_type == TYPE_ATTRIBUTE
                {
                    if let Some(decoded) = self.decode_value(value) {
                        xml.push_str(&format!(
                            "    <color name=\"{}\">{}</color>\n",
                            entry.key_name, decoded
                        ));
                    }
                }
            }
        }

        xml.push_str("</resources>\n");
        xml
    }

    /// Generate drawables.xml content (for drawable references)
    pub fn generate_drawables_xml(&mut self) -> String {
        let mut xml = String::from("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");

        // Collect drawable entries that are references (default config only)
        let drawable_entries: Vec<_> = self
            .entries
            .iter()
            .filter(|e| {
                e.type_name == "drawable"
                    && e.config == "default"
                    && e.value
                        .as_ref()
                        .map(|v| v.data_type == TYPE_REFERENCE)
                        .unwrap_or(false)
            })
            .cloned()
            .collect();

        for entry in drawable_entries {
            if let Some(ref value) = entry.value {
                if let Some(decoded) = self.decode_value(value) {
                    xml.push_str(&format!(
                        "    <item type=\"drawable\" name=\"{}\">{}</item>\n",
                        entry.key_name, decoded
                    ));
                }
            }
        }

        xml.push_str("</resources>\n");
        xml
    }

    /// Generate public.xml content
    pub fn generate_public_xml(&self) -> String {
        let mut xml = String::from("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");

        // Sort entries by ID for consistent output - include ALL configs
        let mut sorted_entries: Vec<_> = self.entries.iter().collect();
        sorted_entries.sort_by_key(|e| e.id);

        // Track seen IDs to avoid duplicates
        let mut seen_ids = std::collections::HashSet::new();

        for entry in sorted_entries {
            if seen_ids.insert(entry.id) {
                // Normalize name for Java JADX compatibility:
                // - Replace $ with _ (invalid in XML names)
                // - Add _res_0x{id} suffix for names starting with special chars
                let name = normalize_resource_name(&entry.key_name, entry.id);
                xml.push_str(&format!(
                    "    <public type=\"{}\" name=\"{}\" id=\"0x{:08x}\" />\n",
                    entry.type_name, name, entry.id
                ));
            }
        }

        xml.push_str("</resources>\n");
        xml
    }

    /// Get attribute name for a bag item key (resource ID)
    fn get_attr_name(&self, name_id: u32) -> String {
        // Check if it's an Android framework attribute (0x01xxxxxx)
        if (name_id >> 24) == 0x01 {
            // Try to get from Android attribute map
            if let Some(name) = ANDROID_ATTR_MAP.get(&name_id) {
                return format!("android:{}", name);
            }
            // Fall back to hex
            return format!("android:attr/0x{:08x}", name_id);
        }

        // Check our resource names
        if let Some(name) = self.res_names.get(&name_id) {
            // Extract just the name part after the type
            if let Some(pos) = name.find('/') {
                return name[pos + 1..].to_string();
            }
            return name.clone();
        }

        // Special Android array indices (for plurals and arrays)
        match name_id {
            0x01000000 => "zero".to_string(),
            0x01000001 => "one".to_string(),
            0x01000002 => "two".to_string(),
            0x01000003 => "few".to_string(),
            0x01000004 => "many".to_string(),
            0x01000005 => "other".to_string(),
            _ => format!("attr_0x{:08x}", name_id),
        }
    }

    /// Generate styles.xml content
    pub fn generate_styles_xml(&mut self) -> String {
        let mut xml = String::from("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");

        // Collect style entries (default config only, with bag_items)
        let style_entries: Vec<_> = self
            .entries
            .iter()
            .filter(|e| e.type_name == "style" && e.config == "default" && e.bag_items.is_some())
            .cloned()
            .collect();

        for entry in style_entries {
            // Start style tag
            xml.push_str("    <style name=\"");
            xml.push_str(&escape_xml_text(&entry.key_name));
            xml.push('"');

            // Add parent if present
            if let Some(parent_id) = entry.parent {
                if let Some(parent_name) = self.res_names.get(&parent_id) {
                    xml.push_str(" parent=\"@");
                    xml.push_str(parent_name);
                    xml.push('"');
                } else if (parent_id >> 24) == 0x01 {
                    // Android framework style
                    xml.push_str(&format!(" parent=\"@android:style/0x{:08x}\"", parent_id));
                } else {
                    xml.push_str(&format!(" parent=\"@0x{:08x}\"", parent_id));
                }
            }

            if let Some(ref items) = entry.bag_items {
                if items.is_empty() {
                    // Empty styles use open/close tags (matches Java JADX format)
                    xml.push_str(">\n    </style>\n");
                } else {
                    xml.push_str(">\n");

                    for item in items {
                        let attr_name = self.get_attr_name(item.name);
                        let value_str = self.decode_value(&item.value)
                            .unwrap_or_else(|| format!("0x{:08x}", item.value.data));

                        xml.push_str("        <item name=\"");
                        xml.push_str(&attr_name);
                        xml.push_str("\">");
                        xml.push_str(&escape_xml_text(&value_str));
                        xml.push_str("</item>\n");
                    }

                    xml.push_str("    </style>\n");
                }
            } else {
                // No bag items means empty style
                xml.push_str(">\n    </style>\n");
            }
        }

        xml.push_str("</resources>\n");
        xml
    }

    /// Generate arrays.xml content
    pub fn generate_arrays_xml(&mut self) -> String {
        let mut xml = String::from("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");

        // Collect array entries (default config only, with bag_items)
        let array_entries: Vec<_> = self
            .entries
            .iter()
            .filter(|e| e.type_name == "array" && e.config == "default" && e.bag_items.is_some())
            .cloned()
            .collect();

        for entry in array_entries {
            // Determine array type based on first item
            let array_type = if let Some(ref items) = entry.bag_items {
                if let Some(first) = items.first() {
                    match first.value.data_type {
                        TYPE_STRING => "string-array",
                        TYPE_INT_DEC | TYPE_INT_HEX => "integer-array",
                        _ => "array",
                    }
                } else {
                    "array"
                }
            } else {
                "array"
            };

            xml.push_str(&format!("    <{} name=\"{}\">\n", array_type, entry.key_name));

            if let Some(ref items) = entry.bag_items {
                for item in items {
                    let value_str = self.decode_value(&item.value)
                        .unwrap_or_else(|| format!("0x{:08x}", item.value.data));
                    xml.push_str("        <item>");
                    xml.push_str(&escape_xml_text(&value_str));
                    xml.push_str("</item>\n");
                }
            }

            xml.push_str(&format!("    </{}>\n", array_type));
        }

        xml.push_str("</resources>\n");
        xml
    }

    /// Generate plurals.xml content
    pub fn generate_plurals_xml(&mut self) -> String {
        let mut xml = String::from("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");

        // Collect plurals entries (default config only, with bag_items)
        let plurals_entries: Vec<_> = self
            .entries
            .iter()
            .filter(|e| e.type_name == "plurals" && e.config == "default" && e.bag_items.is_some())
            .cloned()
            .collect();

        for entry in plurals_entries {
            xml.push_str(&format!("    <plurals name=\"{}\">\n", entry.key_name));

            if let Some(ref items) = entry.bag_items {
                for item in items {
                    let quantity = self.get_attr_name(item.name);
                    let value_str = self.decode_value(&item.value)
                        .unwrap_or_else(|| format!("0x{:08x}", item.value.data));
                    xml.push_str(&format!(
                        "        <item quantity=\"{}\">{}</item>\n",
                        quantity,
                        escape_xml_text(&value_str)
                    ));
                }
            }

            xml.push_str("    </plurals>\n");
        }

        xml.push_str("</resources>\n");
        xml
    }

    /// Generate dimens.xml content
    pub fn generate_dimens_xml(&mut self) -> String {
        let mut xml = String::from("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");

        // Collect dimen entries (default config only)
        let dimen_entries: Vec<_> = self
            .entries
            .iter()
            .filter(|e| e.type_name == "dimen" && e.config == "default")
            .cloned()
            .collect();

        for entry in dimen_entries {
            if let Some(ref value) = entry.value {
                let decoded = match value.data_type {
                    TYPE_DIMENSION => decode_dimension(value.data),
                    TYPE_FLOAT => format!("{}", f32::from_bits(value.data)),
                    _ => self.decode_value(value).unwrap_or_else(|| format!("0x{:x}", value.data)),
                };
                xml.push_str(&format!(
                    "    <dimen name=\"{}\">{}</dimen>\n",
                    entry.key_name, decoded
                ));
            }
        }

        xml.push_str("</resources>\n");
        xml
    }

    /// Generate integers.xml content
    pub fn generate_integers_xml(&mut self) -> String {
        let mut xml = String::from("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");

        // Collect integer entries (default config only)
        let int_entries: Vec<_> = self
            .entries
            .iter()
            .filter(|e| e.type_name == "integer" && e.config == "default")
            .cloned()
            .collect();

        for entry in int_entries {
            if let Some(ref value) = entry.value {
                let decoded = self.decode_value(value).unwrap_or_else(|| format!("{}", value.data));
                xml.push_str(&format!(
                    "    <integer name=\"{}\">{}</integer>\n",
                    entry.key_name, decoded
                ));
            }
        }

        xml.push_str("</resources>\n");
        xml
    }

    /// Generate bools.xml content
    pub fn generate_bools_xml(&mut self) -> String {
        let mut xml = String::from("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");

        // Collect bool entries (default config only)
        let bool_entries: Vec<_> = self
            .entries
            .iter()
            .filter(|e| e.type_name == "bool" && e.config == "default")
            .cloned()
            .collect();

        for entry in bool_entries {
            if let Some(ref value) = entry.value {
                let decoded = if value.data == 0 { "false" } else { "true" };
                xml.push_str(&format!(
                    "    <bool name=\"{}\">{}</bool>\n",
                    entry.key_name, decoded
                ));
            }
        }

        xml.push_str("</resources>\n");
        xml
    }

    /// Generate all values XML files as a map of filename -> content
    pub fn generate_values_xml(&mut self) -> HashMap<String, String> {
        let mut files = HashMap::new();

        // Generate strings.xml
        let strings_xml = self.generate_strings_xml();
        if strings_xml.contains("<string") {
            files.insert("strings.xml".to_string(), strings_xml);
        }

        // Generate colors.xml
        let colors_xml = self.generate_colors_xml();
        if colors_xml.contains("<color") {
            files.insert("colors.xml".to_string(), colors_xml);
        }

        // Generate drawables.xml (even if empty, for consistency with JADX)
        let drawables_xml = self.generate_drawables_xml();
        files.insert("drawables.xml".to_string(), drawables_xml);

        // Generate styles.xml
        let styles_xml = self.generate_styles_xml();
        if styles_xml.contains("<style") {
            files.insert("styles.xml".to_string(), styles_xml);
        }

        // Generate arrays.xml
        let arrays_xml = self.generate_arrays_xml();
        if arrays_xml.contains("<array") || arrays_xml.contains("-array") {
            files.insert("arrays.xml".to_string(), arrays_xml);
        }

        // Generate plurals.xml
        let plurals_xml = self.generate_plurals_xml();
        if plurals_xml.contains("<plurals") {
            files.insert("plurals.xml".to_string(), plurals_xml);
        }

        // Generate dimens.xml
        let dimens_xml = self.generate_dimens_xml();
        if dimens_xml.contains("<dimen") {
            files.insert("dimens.xml".to_string(), dimens_xml);
        }

        // Generate integers.xml
        let integers_xml = self.generate_integers_xml();
        if integers_xml.contains("<integer") {
            files.insert("integers.xml".to_string(), integers_xml);
        }

        // Generate bools.xml
        let bools_xml = self.generate_bools_xml();
        if bools_xml.contains("<bool") {
            files.insert("bools.xml".to_string(), bools_xml);
        }

        // Generate public.xml
        let public_xml = self.generate_public_xml();
        files.insert("public.xml".to_string(), public_xml);

        files
    }
}

impl Default for ArscParser {
    fn default() -> Self {
        Self::new()
    }
}

/// Decode a UTF-16 encoded name from a fixed-size buffer
fn decode_utf16_name(bytes: &[u8]) -> String {
    let mut chars: Vec<u16> = Vec::new();
    for chunk in bytes.chunks_exact(2) {
        let c = u16::from_le_bytes([chunk[0], chunk[1]]);
        if c == 0 {
            break;
        }
        chars.push(c);
    }
    String::from_utf16_lossy(&chars)
}

/// Escape special XML characters in text content
fn escape_xml_text(s: &str) -> String {
    let mut result = String::with_capacity(s.len());
    for c in s.chars() {
        match c {
            '&' => result.push_str("&amp;"),
            '<' => result.push_str("&lt;"),
            '>' => result.push_str("&gt;"),
            '"' => result.push_str("&quot;"),
            _ => result.push(c),
        }
    }
    result
}

/// Escape string for Android string resource XML (uses backslash escaping)
fn escape_string_resource(s: &str) -> String {
    let mut result = String::with_capacity(s.len() + s.len() / 10);
    for c in s.chars() {
        match c {
            '&' => result.push_str("&amp;"),
            '<' => result.push_str("&lt;"),
            '>' => result.push_str("&gt;"),
            '\'' => result.push_str("\\'"),
            '"' => result.push_str("\\\""),
            '\\' => result.push_str("\\\\"),
            '\n' => result.push_str("\\n"),
            '\t' => result.push_str("\\t"),
            '@' if result.is_empty() => result.push_str("\\@"),
            '?' if result.is_empty() => result.push_str("\\?"),
            _ => result.push(c),
        }
    }
    result
}

/// Normalize resource name for XML compatibility (matches Java JADX behavior)
/// - Names starting with $ get _ prefix and _res_0x{id} suffix
/// - Names with invalid XML chars get escaped
fn normalize_resource_name(name: &str, id: u32) -> String {
    if name.is_empty() {
        return format!("res_0x{:08x}", id);
    }

    let first_char = name.chars().next().unwrap();

    // Names starting with $ are invalid XML - normalize like Java JADX
    if first_char == '$' {
        let normalized = name.replace('$', "_");
        return format!("{}_res_0x{:08x}", normalized, id);
    }

    // Names starting with digit need underscore prefix
    if first_char.is_ascii_digit() {
        return format!("_{}_res_0x{:08x}", name, id);
    }

    name.to_string()
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_decode_utf16_name() {
        // "com" in UTF-16LE
        let bytes = [b'c', 0, b'o', 0, b'm', 0, 0, 0];
        assert_eq!(decode_utf16_name(&bytes), "com");
    }

    #[test]
    fn test_resource_entry_full_name() {
        let entry = ResourceEntry {
            id: 0x7f010001,
            package_name: "com.example".to_string(),
            type_name: "string".to_string(),
            key_name: "app_name".to_string(),
            value: None,
            bag_items: None,
            parent: None,
            config: "default".to_string(),
        };
        assert_eq!(entry.full_name(), "string/app_name");
    }

    #[test]
    fn test_raw_value_decode() {
        let mut parser = ArscParser::new();

        // Test integer
        let int_val = RawValue::new(TYPE_INT_DEC, 42);
        assert_eq!(parser.decode_value(&int_val), Some("42".to_string()));

        // Test boolean
        let bool_val = RawValue::new(TYPE_INT_BOOLEAN, 1);
        assert_eq!(parser.decode_value(&bool_val), Some("true".to_string()));

        // Test color
        let color_val = RawValue::new(TYPE_INT_COLOR_ARGB8, 0xff000000);
        assert_eq!(parser.decode_value(&color_val), Some("#ff000000".to_string()));
    }
}
