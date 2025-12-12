//! Android Binary XML (AXML) parser
//!
//! Parses compiled Android XML files like AndroidManifest.xml and layout files.
//! Produces XML output compatible with Java JADX.

use std::collections::{HashMap, HashSet};
use std::io::{Cursor, Read, Seek, SeekFrom};

use byteorder::{LittleEndian, ReadBytesExt};

use crate::constants::*;
use crate::error::{ResourceError, Result};
use crate::string_pool::StringPool;

/// Android Resource ID map for common attributes
mod android_res {
    use std::collections::HashMap;
    use std::sync::LazyLock;

    /// Map of Android framework resource IDs to attribute names
    pub static ANDROID_RES_MAP: LazyLock<HashMap<u32, &'static str>> = LazyLock::new(|| {
        let mut m = HashMap::new();

        // Manifest core attributes (0x01010000 - 0x01010030)
        m.insert(0x01010000, "attr/theme");
        m.insert(0x01010001, "attr/label");
        m.insert(0x01010002, "attr/icon");
        m.insert(0x01010003, "attr/name");
        m.insert(0x01010004, "attr/manageSpaceActivity");
        m.insert(0x01010005, "attr/allowClearUserData");
        m.insert(0x01010006, "attr/authorities");
        m.insert(0x01010007, "attr/syncable");
        m.insert(0x01010008, "attr/multiprocess");
        m.insert(0x01010009, "attr/grantUriPermissions");
        m.insert(0x0101000a, "attr/configChanges");
        m.insert(0x0101000b, "attr/allowBackup");
        m.insert(0x0101000c, "attr/initOrder");
        m.insert(0x0101000d, "attr/value");
        m.insert(0x0101000e, "attr/textSize");
        m.insert(0x0101000f, "attr/textColor");
        m.insert(0x01010010, "attr/enabled");
        m.insert(0x01010011, "attr/id");
        m.insert(0x01010012, "attr/text");
        m.insert(0x01010013, "attr/background");
        m.insert(0x01010014, "attr/foreground");
        m.insert(0x01010015, "attr/src");
        m.insert(0x01010016, "attr/data");
        m.insert(0x01010017, "attr/permission");
        m.insert(0x01010018, "attr/readPermission");
        m.insert(0x01010019, "attr/writePermission");
        m.insert(0x0101001a, "attr/sharedUserId");
        m.insert(0x0101001b, "attr/debuggable");
        m.insert(0x0101001c, "attr/persistent");
        m.insert(0x0101001d, "attr/windowSoftInputMode");
        m.insert(0x0101001e, "attr/launchMode");
        m.insert(0x0101001f, "attr/screenOrientation");
        m.insert(0x01010020, "attr/taskAffinity");
        m.insert(0x01010021, "attr/clearTaskOnLaunch");
        m.insert(0x01010022, "attr/stateNotNeeded");
        m.insert(0x01010023, "attr/excludeFromRecents");
        m.insert(0x01010024, "attr/layout_width");
        m.insert(0x01010025, "attr/layout_height");
        m.insert(0x01010026, "attr/layout_weight");
        m.insert(0x01010027, "attr/layout_gravity");
        m.insert(0x01010028, "attr/gravity");
        m.insert(0x01010029, "attr/hint");
        m.insert(0x0101002a, "attr/textColorHint");
        m.insert(0x0101002b, "attr/textStyle");
        m.insert(0x0101002c, "attr/typeface");
        m.insert(0x0101002d, "attr/shadowColor");
        m.insert(0x0101002e, "attr/shadowDx");
        m.insert(0x0101002f, "attr/shadowDy");
        m.insert(0x01010030, "attr/shadowRadius");

        // More layout and view attributes (0x01010031 - 0x01010070)
        m.insert(0x01010031, "attr/autoLink");
        m.insert(0x01010032, "attr/linksClickable");
        m.insert(0x01010033, "attr/entries");
        m.insert(0x01010034, "attr/scrollbars");
        m.insert(0x01010035, "attr/fadingEdge");
        m.insert(0x01010036, "attr/fadingEdgeLength");
        m.insert(0x01010037, "attr/nextFocusLeft");
        m.insert(0x01010038, "attr/nextFocusRight");
        m.insert(0x01010039, "attr/nextFocusUp");
        m.insert(0x0101003a, "attr/nextFocusDown");
        m.insert(0x0101003b, "attr/clickable");
        m.insert(0x0101003c, "attr/longClickable");
        m.insert(0x0101003d, "attr/saveEnabled");
        m.insert(0x0101003e, "attr/filterTouchesWhenObscured");
        m.insert(0x0101003f, "attr/drawingCacheQuality");
        m.insert(0x01010040, "attr/keepScreenOn");
        m.insert(0x01010041, "attr/soundEffectsEnabled");
        m.insert(0x01010042, "attr/hapticFeedbackEnabled");
        m.insert(0x01010043, "attr/scrollbarFadeDuration");
        m.insert(0x01010044, "attr/scrollbarDefaultDelayBeforeFade");
        m.insert(0x01010045, "attr/scrollbarSize");
        m.insert(0x01010046, "attr/scrollbarThumbHorizontal");
        m.insert(0x01010047, "attr/scrollbarThumbVertical");
        m.insert(0x01010048, "attr/scrollbarTrackHorizontal");
        m.insert(0x01010049, "attr/scrollbarTrackVertical");
        m.insert(0x0101004a, "attr/scrollbarAlwaysDrawHorizontalTrack");
        m.insert(0x0101004b, "attr/scrollbarAlwaysDrawVerticalTrack");
        m.insert(0x0101004c, "attr/padding");
        m.insert(0x0101004d, "attr/paddingLeft");
        m.insert(0x0101004e, "attr/paddingTop");
        m.insert(0x0101004f, "attr/paddingRight");
        m.insert(0x01010050, "attr/paddingBottom");
        m.insert(0x01010051, "attr/focusable");
        m.insert(0x01010052, "attr/focusableInTouchMode");
        m.insert(0x01010053, "attr/visibility");
        m.insert(0x01010054, "attr/fitsSystemWindows");
        m.insert(0x01010055, "attr/scrollbarStyle");
        m.insert(0x01010056, "attr/isScrollContainer");
        m.insert(0x01010057, "attr/duplicateParentState");
        m.insert(0x01010058, "attr/clipChildren");
        m.insert(0x01010059, "attr/clipToPadding");
        m.insert(0x0101005a, "attr/layoutAnimation");
        m.insert(0x0101005b, "attr/animationCache");
        m.insert(0x0101005c, "attr/persistentDrawingCache");
        m.insert(0x0101005d, "attr/alwaysDrawnWithCache");
        m.insert(0x0101005e, "attr/addStatesFromChildren");
        m.insert(0x0101005f, "attr/descendantFocusability");

        // Layout margins (0x01010060 - 0x01010070)
        m.insert(0x01010060, "attr/layout_margin");
        m.insert(0x01010061, "attr/layout_marginLeft");
        m.insert(0x01010062, "attr/layout_marginTop");
        m.insert(0x01010063, "attr/layout_marginRight");
        m.insert(0x01010064, "attr/layout_marginBottom");
        m.insert(0x01010065, "attr/listSelector");
        m.insert(0x01010066, "attr/drawSelectorOnTop");
        m.insert(0x01010067, "attr/stackFromBottom");
        m.insert(0x01010068, "attr/scrollingCache");
        m.insert(0x01010069, "attr/textFilterEnabled");
        m.insert(0x0101006a, "attr/transcriptMode");
        m.insert(0x0101006b, "attr/cacheColorHint");
        m.insert(0x0101006c, "attr/choiceMode");
        m.insert(0x0101006d, "attr/orientation");
        m.insert(0x0101006e, "attr/divider");
        m.insert(0x0101006f, "attr/dividerHeight");
        m.insert(0x01010070, "attr/headerDividersEnabled");
        m.insert(0x01010071, "attr/footerDividersEnabled");

        // More view attributes
        m.insert(0x01010095, "attr/textAppearance");
        m.insert(0x01010096, "attr/textAppearanceInverse");
        m.insert(0x01010097, "attr/textColorPrimary");
        m.insert(0x01010098, "attr/textColorSecondary");
        m.insert(0x01010099, "attr/textColorTertiary");
        m.insert(0x0101009a, "attr/textColorPrimaryDisableOnly");
        m.insert(0x0101009b, "attr/textColorPrimaryInverse");
        m.insert(0x0101009c, "attr/textColorSecondaryInverse");
        m.insert(0x0101009d, "attr/textColorTertiaryInverse");
        m.insert(0x0101009e, "attr/textColorPrimaryInverseDisableOnly");
        m.insert(0x0101009f, "attr/textColorPrimaryNoDisable");

        // ImageView attributes
        m.insert(0x010100bf, "attr/scaleType");
        m.insert(0x010100c0, "attr/adjustViewBounds");
        m.insert(0x010100c1, "attr/maxWidth");
        m.insert(0x010100c2, "attr/maxHeight");
        m.insert(0x010100c3, "attr/tint");
        m.insert(0x010100c4, "attr/baselineAlignBottom");
        m.insert(0x010100c5, "attr/cropToPadding");

        // Additional manifest attributes (0x01010200+)
        m.insert(0x01010200, "attr/protectionLevel");
        m.insert(0x01010201, "attr/permissionGroup");
        m.insert(0x01010202, "attr/sharedUserLabel");
        m.insert(0x01010203, "attr/priority");
        m.insert(0x01010204, "attr/finishOnTaskLaunch");
        m.insert(0x01010205, "attr/finishOnCloseSystemDialogs");
        m.insert(0x01010206, "attr/immersive");
        m.insert(0x0101020c, "attr/minSdkVersion");
        m.insert(0x0101020d, "attr/targetPackage");
        m.insert(0x0101020e, "attr/handleProfiling");
        m.insert(0x0101020f, "attr/functionalTest");
        m.insert(0x01010210, "attr/resource");
        m.insert(0x01010211, "attr/mimeType");
        m.insert(0x01010212, "attr/scheme");
        m.insert(0x01010213, "attr/host");
        m.insert(0x01010214, "attr/port");
        m.insert(0x01010215, "attr/path");
        m.insert(0x01010216, "attr/pathPrefix");
        m.insert(0x01010217, "attr/pathPattern");
        m.insert(0x01010218, "attr/action");
        m.insert(0x01010219, "attr/category");
        m.insert(0x0101021a, "attr/backupAgent");
        m.insert(0x0101021b, "attr/versionCode");
        m.insert(0x0101021c, "attr/versionName");
        m.insert(0x0101021d, "attr/restoreAnyVersion");
        m.insert(0x0101021e, "attr/installLocation");
        m.insert(0x0101021f, "attr/vmSafeMode");
        m.insert(0x01010220, "attr/webviewChromiumPath");

        // More SDK version attributes
        m.insert(0x01010270, "attr/targetSdkVersion");
        m.insert(0x01010271, "attr/testOnly");
        m.insert(0x01010272, "attr/contentAuthority");
        m.insert(0x01010273, "attr/contentSyncable");
        m.insert(0x01010274, "attr/testAccountType");
        m.insert(0x01010275, "attr/process");
        m.insert(0x01010276, "attr/killAfterRestore");
        m.insert(0x01010277, "attr/restoreNeedsApplication");
        m.insert(0x01010278, "attr/allowTaskReparenting");
        m.insert(0x01010279, "attr/noHistory");
        m.insert(0x0101027a, "attr/singleUser");
        m.insert(0x0101027b, "attr/isolatedProcess");
        m.insert(0x0101027c, "attr/hasCode");
        m.insert(0x0101027d, "attr/stopWithTask");
        m.insert(0x0101027e, "attr/cantSaveState");
        m.insert(0x0101027f, "attr/paddingStart");
        m.insert(0x01010280, "attr/paddingEnd");
        m.insert(0x01010281, "attr/layout_marginStart");
        m.insert(0x01010282, "attr/layout_marginEnd");
        m.insert(0x01010283, "attr/textDirection");
        m.insert(0x01010284, "attr/textAlignment");
        m.insert(0x01010285, "attr/layoutDirection");
        m.insert(0x01010286, "attr/supportsUploading");
        m.insert(0x01010287, "attr/accountType");
        m.insert(0x01010288, "attr/contentInsetStart");
        m.insert(0x01010289, "attr/contentInsetEnd");
        m.insert(0x0101028a, "attr/contentInsetLeft");
        m.insert(0x0101028b, "attr/contentInsetRight");
        m.insert(0x0101028c, "attr/accessibilityLiveRegion");
        m.insert(0x0101028d, "attr/labelFor");
        m.insert(0x0101028e, "attr/maxSdkVersion");

        // Exported and related (0x01010290+)
        m.insert(0x01010290, "attr/requireDeviceUnlock");
        m.insert(0x01010291, "attr/requiredNotFeature");
        m.insert(0x01010292, "attr/allowEmbedded");
        m.insert(0x01010293, "attr/parentActivityName");
        m.insert(0x01010294, "attr/lockTaskMode");
        m.insert(0x01010295, "attr/showForAllUsers");
        m.insert(0x01010296, "attr/encryptionAware");
        m.insert(0x01010297, "attr/directBootAware");
        m.insert(0x01010298, "attr/resizeableActivity");
        m.insert(0x01010299, "attr/maxRecents");
        m.insert(0x0101029a, "attr/exported");
        m.insert(0x0101029b, "attr/requiredFeature");
        m.insert(0x0101029c, "attr/requiredAccountType");
        m.insert(0x0101029d, "attr/restrictedAccountType");

        // Window and UI attributes (0x010102a0+)
        m.insert(0x010102a0, "attr/windowActionBar");
        m.insert(0x010102a1, "attr/windowActionBarOverlay");
        m.insert(0x010102a2, "attr/windowSplitActionBar");
        m.insert(0x010102a3, "attr/actionBarSplitStyle");
        m.insert(0x010102a4, "attr/actionProviderClass");
        m.insert(0x010102a5, "attr/actionViewClass");
        m.insert(0x010102a6, "attr/activatedBackgroundIndicator");
        m.insert(0x010102a7, "attr/logo");
        m.insert(0x010102a8, "attr/showAsAction");
        m.insert(0x010102a9, "attr/actionLayout");
        m.insert(0x010102aa, "attr/menuCategory");
        m.insert(0x010102ab, "attr/orderInCategory");
        m.insert(0x010102ac, "attr/fontFamily");
        m.insert(0x010102ad, "attr/detailsElementBackground");
        m.insert(0x010102ae, "attr/clipOrientation");
        m.insert(0x010102af, "attr/useIntrinsicSizeAsMinimum");
        m.insert(0x010102b0, "attr/fastScrollEnabled");
        m.insert(0x010102b1, "attr/fastScrollPreviewBackgroundLeft");
        m.insert(0x010102b2, "attr/fastScrollPreviewBackgroundRight");
        m.insert(0x010102b3, "attr/fastScrollThumbDrawable");
        m.insert(0x010102b4, "attr/fastScrollTrackDrawable");
        m.insert(0x010102b5, "attr/fastScrollTextColor");
        m.insert(0x010102b6, "attr/fastScrollOverlayPosition");

        // Elevation and Material attributes (0x010102c0+)
        m.insert(0x010102c0, "attr/translationZ");
        m.insert(0x010102c1, "attr/stateListAnimator");
        m.insert(0x010102c2, "attr/outlineProvider");
        m.insert(0x010102c3, "attr/backgroundTint");
        m.insert(0x010102c4, "attr/backgroundTintMode");
        m.insert(0x010102c5, "attr/foregroundTint");
        m.insert(0x010102c6, "attr/foregroundTintMode");
        m.insert(0x010102c7, "attr/drawableTint");
        m.insert(0x010102c8, "attr/drawableTintMode");
        m.insert(0x010102c9, "attr/elevation");
        m.insert(0x010102ca, "attr/banner");
        m.insert(0x010102cb, "attr/isGame");
        m.insert(0x010102cc, "attr/supportsPictureInPicture");
        m.insert(0x010102cd, "attr/allowUndo");
        m.insert(0x010102ce, "attr/largeHeap");
        m.insert(0x010102cf, "attr/windowEnableSplitTouch");
        m.insert(0x010102d0, "attr/requiredForAllUsers");
        m.insert(0x010102d1, "attr/allowAudioPlaybackCapture");
        m.insert(0x010102d2, "attr/preserveLegacyExternalStorage");
        m.insert(0x010102d3, "attr/hardwareAccelerated");
        m.insert(0x010102d4, "attr/documentLaunchMode");
        m.insert(0x010102d5, "attr/maxAspectRatio");
        m.insert(0x010102d6, "attr/minAspectRatio");
        m.insert(0x010102d7, "attr/maxRecentsLimitedByDeviceResources");
        m.insert(0x010102d8, "attr/autoRemoveFromRecents");
        m.insert(0x010102d9, "attr/relinquishTaskIdentity");
        m.insert(0x010102da, "attr/resumeWhilePausing");
        m.insert(0x010102db, "attr/extractNativeLibs");
        m.insert(0x010102dc, "attr/fullBackupOnly");
        m.insert(0x010102dd, "attr/fullBackupContent");
        m.insert(0x010102de, "attr/restrictionType");

        // App components and services (0x01010300+)
        m.insert(0x01010300, "attr/splitName");
        m.insert(0x01010301, "attr/featureSplit");
        m.insert(0x01010302, "attr/targetSandboxVersion");
        m.insert(0x01010303, "attr/compileSdkVersion");
        m.insert(0x01010304, "attr/compileSdkVersionCodename");
        m.insert(0x01010305, "attr/appComponentFactory");
        m.insert(0x01010306, "attr/usesNonSdkApi");
        m.insert(0x01010307, "attr/classLoader");
        m.insert(0x01010308, "attr/isFeatureSplit");
        m.insert(0x01010309, "attr/isSplitRequired");
        m.insert(0x0101030a, "attr/forceQueryable");
        m.insert(0x0101030b, "attr/crossProfile");

        // RTL and supportsRtl (0x010103f0+)
        m.insert(0x010103f0, "attr/importantForAccessibility");
        m.insert(0x010103f1, "attr/layoutMode");
        m.insert(0x010103f2, "attr/supportsRtl");
        m.insert(0x010103f3, "attr/textIsSelectable");
        m.insert(0x010103f4, "attr/showDividers");
        m.insert(0x010103f5, "attr/measureWithLargestChild");
        m.insert(0x010103f6, "attr/weightSum");
        m.insert(0x010103f7, "attr/baselineAligned");
        m.insert(0x010103f8, "attr/baselineAlignedChildIndex");
        m.insert(0x010103f9, "attr/useDefaultMargins");
        m.insert(0x010103fa, "attr/alignmentMode");
        m.insert(0x010103fb, "attr/columnOrderPreserved");
        m.insert(0x010103fc, "attr/rowOrderPreserved");
        m.insert(0x010103fd, "attr/columnCount");
        m.insert(0x010103fe, "attr/rowCount");

        // Network security (0x01010350+)
        m.insert(0x01010350, "attr/requestLegacyExternalStorage");
        m.insert(0x01010351, "attr/allowNativeHeapPointerTagging");
        m.insert(0x01010352, "attr/preserveLegacyStorage");
        m.insert(0x01010353, "attr/hasFragileUserData");
        m.insert(0x01010354, "attr/rollbackDataPolicy");
        m.insert(0x01010355, "attr/gwpAsanMode");
        m.insert(0x01010356, "attr/memtagMode");
        m.insert(0x01010357, "attr/nativeHeapZeroInitialized");
        m.insert(0x01010358, "attr/localeConfig");
        m.insert(0x01010359, "attr/enableOnBackInvokedCallback");
        m.insert(0x0101035a, "attr/knownActivityEmbeddingCerts");
        m.insert(0x0101035b, "attr/requiredSplitTypes");
        m.insert(0x0101035c, "attr/splitTypes");
        m.insert(0x0101035d, "attr/sdkLibrary");
        m.insert(0x0101035e, "attr/usesCleartextTraffic");

        // Uses-permission attributes
        m.insert(0x01010480, "attr/usesPermissionFlags");
        m.insert(0x01010481, "attr/minExtensionVersion");

        // Network security config
        m.insert(0x010104d8, "attr/networkSecurityConfig");
        m.insert(0x010104d9, "attr/roundIcon");
        m.insert(0x010104da, "attr/colorMode");
        m.insert(0x010104db, "attr/appCategory");
        m.insert(0x010104dc, "attr/maxAspectRatioMode");
        m.insert(0x010104dd, "attr/sharedLibraryName");
        m.insert(0x010104de, "attr/useEmbeddedDex");
        m.insert(0x010104df, "attr/splitRevisionCode");
        m.insert(0x010104e0, "attr/requestOptionalPermissions");

        // Foreground service types
        m.insert(0x01010500, "attr/foregroundServiceType");

        // VectorDrawable attributes
        m.insert(0x01010580, "attr/viewportWidth");
        m.insert(0x01010581, "attr/viewportHeight");
        m.insert(0x01010582, "attr/fillColor");
        m.insert(0x01010583, "attr/fillAlpha");
        m.insert(0x01010584, "attr/strokeColor");
        m.insert(0x01010585, "attr/strokeWidth");
        m.insert(0x01010586, "attr/strokeAlpha");
        m.insert(0x01010587, "attr/strokeLineCap");
        m.insert(0x01010588, "attr/strokeLineJoin");
        m.insert(0x01010589, "attr/strokeMiterLimit");
        m.insert(0x0101058a, "attr/pathData");
        m.insert(0x0101058b, "attr/trimPathStart");
        m.insert(0x0101058c, "attr/trimPathEnd");
        m.insert(0x0101058d, "attr/trimPathOffset");
        m.insert(0x0101058e, "attr/fillType");

        m
    });

    /// Get resource name by ID
    pub fn get_res_name(id: u32) -> Option<&'static str> {
        ANDROID_RES_MAP.get(&id).copied()
    }
}

/// Binary XML parser
pub struct AxmlParser {
    /// String pool
    strings: StringPool,
    /// Resource ID map from the XML
    resource_ids: Vec<u32>,
    /// Namespace URI -> prefix mapping
    ns_map: HashMap<String, String>,
    /// Generated namespace prefixes
    ns_generated: HashSet<String>,
    /// Defined namespaces (already output)
    defined_namespaces: HashSet<String>,
    /// Current tag name
    current_tag: String,
    /// Whether last output was an end tag
    is_last_end: bool,
    /// Whether current element can be on one line
    is_one_line: bool,
    /// Namespace depth for tracking
    namespace_depth: u32,
    /// App package name from manifest
    app_package_name: Option<String>,
    /// Resource names map (from ARSC if available)
    res_names: HashMap<u32, String>,
    /// Output buffer
    output: String,
    /// Current indentation level
    indent: usize,
    /// Whether this is the first element
    first_element: bool,
    /// Whether to put attributes on new lines
    attr_new_line: bool,
}

impl AxmlParser {
    /// Create a new AXML parser
    pub fn new() -> Self {
        Self {
            strings: StringPool::empty(),
            resource_ids: Vec::new(),
            ns_map: HashMap::new(),
            ns_generated: HashSet::new(),
            defined_namespaces: HashSet::new(),
            current_tag: "ERROR".to_string(),
            is_last_end: true,
            is_one_line: true,
            namespace_depth: 0,
            app_package_name: None,
            res_names: HashMap::new(),
            output: String::new(),
            indent: 0,
            first_element: true,
            attr_new_line: true,
        }
    }

    /// Set resource names map (from ARSC parsing)
    pub fn set_res_names(&mut self, res_names: HashMap<u32, String>) {
        self.res_names = res_names;
    }

    /// Parse binary XML from bytes
    pub fn parse(&mut self, data: &[u8]) -> Result<String> {
        self.reset();

        let mut cursor = Cursor::new(data);

        // Check if this is binary XML
        if !self.is_binary_xml(&mut cursor)? {
            // Return as plain text
            return Ok(String::from_utf8_lossy(data).to_string());
        }

        // Write XML header
        self.output.push_str("<?xml version=\"1.0\" encoding=\"utf-8\"?>");

        // Read total size
        let size = cursor.read_u32::<LittleEndian>()?;

        // Decode chunks
        while cursor.position() < size as u64 {
            let chunk_type = cursor.read_u16::<LittleEndian>()?;

            match chunk_type {
                RES_NULL_TYPE => {
                    // Null chunk - do nothing
                }
                RES_STRING_POOL_TYPE => {
                    self.parse_string_pool(&mut cursor)?;
                }
                RES_XML_RESOURCE_MAP_TYPE => {
                    self.parse_resource_map(&mut cursor)?;
                }
                RES_XML_START_NAMESPACE_TYPE => {
                    self.parse_namespace_start(&mut cursor)?;
                }
                RES_XML_END_NAMESPACE_TYPE => {
                    self.parse_namespace_end(&mut cursor)?;
                }
                RES_XML_START_ELEMENT_TYPE => {
                    self.parse_element_start(&mut cursor)?;
                }
                RES_XML_END_ELEMENT_TYPE => {
                    self.parse_element_end(&mut cursor)?;
                }
                RES_XML_CDATA_TYPE => {
                    self.parse_cdata(&mut cursor)?;
                }
                _ => {
                    if self.namespace_depth == 0 {
                        // Skip padding at file end
                        break;
                    }
                    return Err(ResourceError::UnexpectedChunkType(chunk_type));
                }
            }
        }

        // Add trailing newline to match Java JADX output
        if !self.output.ends_with('\n') {
            self.output.push('\n');
        }

        Ok(self.output.clone())
    }

    /// Reset parser state for reuse
    fn reset(&mut self) {
        self.strings = StringPool::empty();
        self.resource_ids.clear();
        self.ns_map.clear();
        self.ns_generated.clear();
        self.defined_namespaces.clear();
        self.current_tag = "ERROR".to_string();
        self.is_last_end = true;
        self.is_one_line = true;
        self.namespace_depth = 0;
        self.app_package_name = None;
        self.output.clear();
        self.indent = 0;
        self.first_element = true;
    }

    /// Check if data is binary XML
    fn is_binary_xml(&self, cursor: &mut Cursor<&[u8]>) -> Result<bool> {
        cursor.seek(SeekFrom::Start(0))?;
        let _version = cursor.read_u16::<LittleEndian>()?;
        let header_size = cursor.read_u16::<LittleEndian>()?;

        // Binary XML has header size 0x0008
        Ok(header_size == 0x0008)
    }

    /// Parse string pool chunk
    fn parse_string_pool(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        let start = cursor.position() - 2; // -2 for type already read
        let _header_size = cursor.read_u16::<LittleEndian>()?;
        let chunk_size = cursor.read_u32::<LittleEndian>()?;

        let string_count = cursor.read_u32::<LittleEndian>()?;
        let _style_count = cursor.read_u32::<LittleEndian>()?;
        let flags = cursor.read_u32::<LittleEndian>()?;
        let strings_start = cursor.read_u32::<LittleEndian>()?;
        let _styles_start = cursor.read_u32::<LittleEndian>()?;

        // Calculate adjusted strings start relative to our buffer
        let header_consumed = cursor.position() - start;
        let adjusted_strings_start = strings_start as u64 - header_consumed;

        // Read remaining chunk data (offsets + strings)
        let remaining = chunk_size as u64 - (cursor.position() - start);
        let mut buffer = vec![0u8; remaining as usize];
        cursor.read_exact(&mut buffer)?;

        self.strings = StringPool::new(
            string_count,
            adjusted_strings_start as u32,
            buffer,
            flags,
        );

        Ok(())
    }

    /// Parse resource map chunk
    fn parse_resource_map(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        let header_size = cursor.read_u16::<LittleEndian>()?;
        if header_size != 0x08 {
            return Err(ResourceError::InvalidHeaderSize {
                expected: 0x08,
                actual: header_size as u32,
            });
        }

        let chunk_size = cursor.read_u32::<LittleEndian>()?;
        let count = (chunk_size - 8) / 4;

        self.resource_ids.clear();
        for _ in 0..count {
            self.resource_ids.push(cursor.read_u32::<LittleEndian>()?);
        }

        Ok(())
    }

    /// Parse namespace start chunk
    fn parse_namespace_start(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        let header_size = cursor.read_u16::<LittleEndian>()?;
        let _chunk_size = cursor.read_u32::<LittleEndian>()?;
        let _line_number = cursor.read_u32::<LittleEndian>()?;
        let _comment = cursor.read_u32::<LittleEndian>()?;
        let prefix_idx = cursor.read_u32::<LittleEndian>()?;
        let uri_idx = cursor.read_u32::<LittleEndian>()?;

        // Skip extra header bytes if any
        if header_size > 0x10 {
            cursor.seek(SeekFrom::Current((header_size - 0x10) as i64))?;
        }

        let uri = self.get_string(uri_idx);
        let prefix = self.get_string(prefix_idx);

        if !uri.is_empty() && !self.ns_map.values().any(|v| v == &prefix) {
            self.ns_map.entry(uri).or_insert(prefix);
        }

        self.namespace_depth += 1;
        Ok(())
    }

    /// Parse namespace end chunk
    fn parse_namespace_end(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        let header_size = cursor.read_u16::<LittleEndian>()?;
        let _chunk_size = cursor.read_u32::<LittleEndian>()?;
        let _line_number = cursor.read_u32::<LittleEndian>()?;
        let _comment = cursor.read_u32::<LittleEndian>()?;
        let _prefix_idx = cursor.read_u32::<LittleEndian>()?;
        let _uri_idx = cursor.read_u32::<LittleEndian>()?;

        if header_size > 0x10 {
            cursor.seek(SeekFrom::Current((header_size - 0x10) as i64))?;
        }

        self.namespace_depth -= 1;
        Ok(())
    }

    /// Parse element start chunk
    fn parse_element_start(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        if !self.first_element {
            self.indent += 1;
        } else {
            self.first_element = false;
        }

        let elem_header_size = cursor.read_u16::<LittleEndian>()?;
        if elem_header_size != 0x10 {
            return Err(ResourceError::InvalidHeaderSize {
                expected: 0x10,
                actual: elem_header_size as u32,
            });
        }

        let _chunk_size = cursor.read_u32::<LittleEndian>()?;
        let _line_number = cursor.read_u32::<LittleEndian>()?;
        let _comment = cursor.read_u32::<LittleEndian>()?;
        let _namespace_idx = cursor.read_i32::<LittleEndian>()?;
        let name_idx = cursor.read_u32::<LittleEndian>()?;

        // Close previous unclosed tag (means parent has child content)
        if !self.is_last_end && self.current_tag != "ERROR" {
            self.output.push('>');
            self.is_last_end = true;
        }

        self.is_one_line = true;
        self.is_last_end = false;
        self.current_tag = self.get_string(name_idx);

        // Start new line with element
        self.start_line();
        self.output.push('<');
        self.output.push_str(&self.current_tag);

        let _attr_start = cursor.read_u16::<LittleEndian>()?;
        let attr_size = cursor.read_u16::<LittleEndian>()?;
        let attr_count = cursor.read_u16::<LittleEndian>()?;
        let _id_index = cursor.read_u16::<LittleEndian>()?;
        let _class_index = cursor.read_u16::<LittleEndian>()?;
        let _style_index = cursor.read_u16::<LittleEndian>()?;

        // Output namespace declarations on manifest element or if we have new ones
        if self.current_tag == "manifest" || self.defined_namespaces.len() != self.ns_map.len() {
            for (uri, prefix) in &self.ns_map {
                if !self.defined_namespaces.contains(uri) {
                    self.defined_namespaces.insert(uri.clone());
                    self.output.push_str(" xmlns");
                    if !prefix.is_empty() {
                        self.output.push(':');
                        self.output.push_str(prefix);
                    }
                    self.output.push_str("=\"");
                    self.output.push_str(&escape_xml(uri));
                    self.output.push('"');
                }
            }
        }

        // Parse attributes
        let attr_new_line = attr_count != 1 && self.attr_new_line;
        let mut attr_cache: HashSet<String> = HashSet::new();

        for _ in 0..attr_count {
            self.parse_attribute(cursor, attr_size, attr_new_line, &mut attr_cache)?;
        }

        Ok(())
    }

    /// Parse a single attribute
    fn parse_attribute(
        &mut self,
        cursor: &mut Cursor<&[u8]>,
        attr_size: u16,
        new_line: bool,
        attr_cache: &mut HashSet<String>,
    ) -> Result<()> {
        let attr_ns_idx = cursor.read_i32::<LittleEndian>()?;
        let attr_name_idx = cursor.read_u32::<LittleEndian>()?;
        let _attr_raw_value = cursor.read_i32::<LittleEndian>()?;

        // Skip 3 bytes, read type
        cursor.seek(SeekFrom::Current(3))?;
        let attr_type = cursor.read_u8()?;
        let attr_data = cursor.read_i32::<LittleEndian>()?;

        // Skip extra attribute bytes
        if attr_size > 0x14 {
            cursor.seek(SeekFrom::Current((attr_size - 0x14) as i64))?;
        }

        // Get namespace prefix
        let ns_prefix = if attr_ns_idx != -1 {
            self.get_attribute_ns(attr_ns_idx as u32, new_line)
        } else {
            None
        };

        // Get attribute name
        let attr_name = self.get_attribute_name(attr_name_idx);
        let attr_full_name = if let Some(ref prefix) = ns_prefix {
            format!("{}:{}", prefix, attr_name)
        } else {
            attr_name.clone()
        };

        // Skip duplicates
        if attr_cache.contains(&attr_full_name) {
            return Ok(());
        }
        attr_cache.insert(attr_full_name.clone());

        // Output attribute
        if new_line {
            self.start_line();
            self.add_indent();
        } else {
            self.output.push(' ');
        }

        self.output.push_str(&attr_full_name);
        self.output.push_str("=\"");

        // Decode and output value (pass attribute name for enum decoding)
        let value = self.decode_attribute_value(attr_type, attr_data, &attr_name);

        // Memorize package name
        if self.current_tag == "manifest" && attr_full_name == "package" {
            self.app_package_name = Some(value.clone());
        }

        self.output.push_str(&escape_xml(&value));
        self.output.push('"');

        Ok(())
    }

    /// Get namespace prefix for an attribute
    fn get_attribute_ns(&mut self, ns_idx: u32, new_line: bool) -> Option<String> {
        let uri = self.get_string(ns_idx);
        if uri.is_empty() {
            if is_res_internal_id(ns_idx) {
                return None;
            }
            // Default to android namespace
            return Some(self.get_or_generate_ns(ANDROID_NS_URL, new_line));
        }

        if let Some(prefix) = self.ns_map.get(&uri) {
            return Some(prefix.clone());
        }

        Some(self.get_or_generate_ns(&uri, new_line))
    }

    /// Get or generate a namespace prefix
    fn get_or_generate_ns(&mut self, uri: &str, new_line: bool) -> String {
        if let Some(prefix) = self.ns_map.get(uri) {
            return prefix.clone();
        }

        let prefix = if uri == ANDROID_NS_URL {
            ANDROID_NS_PREFIX.to_string()
        } else {
            let mut i = 1;
            loop {
                let name = format!("ns{}", i);
                if !self.ns_generated.contains(&name) && !self.ns_map.values().any(|v| v == &name) {
                    self.ns_generated.insert(name.clone());
                    break name;
                }
                i += 1;
            }
        };

        self.ns_map.insert(uri.to_string(), prefix.clone());

        // Output xmlns declaration
        if new_line {
            self.start_line();
            self.add_indent();
        } else {
            self.output.push(' ');
        }
        self.output.push_str("xmlns:");
        self.output.push_str(&prefix);
        self.output.push_str("=\"");
        self.output.push_str(uri);
        self.output.push_str("\" ");

        prefix
    }

    /// Get attribute name, preferring string pool then Android resource map
    fn get_attribute_name(&mut self, idx: u32) -> String {
        // Try string pool first - usually has correct attribute names
        let s = self.get_string(idx);
        if !s.is_empty() {
            return s;
        }

        // Fall back to Android resource ID map if string pool is empty
        if (idx as usize) < self.resource_ids.len() {
            let res_id = self.resource_ids[idx as usize];
            if let Some(name) = android_res::get_res_name(res_id) {
                // Extract name after the slash
                if let Some(pos) = name.find('/') {
                    return name[pos + 1..].to_string();
                }
                return name.to_string();
            }
        }

        format!("NOT_FOUND_0x{:x}", idx)
    }

    /// Decode an attribute value based on type and attribute name
    fn decode_attribute_value(&mut self, attr_type: u8, data: i32, attr_name: &str) -> String {
        // First try to decode as an enum/flag value based on attribute name
        if let Some(enum_val) = decode_enum_value(attr_name, data) {
            return enum_val;
        }

        match attr_type {
            TYPE_NULL => "".to_string(),
            TYPE_STRING => self.get_string(data as u32),
            TYPE_INT_DEC => data.to_string(),
            TYPE_INT_HEX => format!("0x{:x}", data),
            TYPE_INT_BOOLEAN => if data == 0 { "false" } else { "true" }.to_string(),
            TYPE_FLOAT => {
                let f = f32::from_bits(data as u32);
                float_to_string(f as f64)
            }
            TYPE_INT_COLOR_ARGB8 => format!("#{:08x}", data),
            TYPE_INT_COLOR_RGB8 => format!("#{:06x}", data & 0xFFFFFF),
            TYPE_INT_COLOR_ARGB4 => format!("#{:04x}", data & 0xFFFF),
            TYPE_INT_COLOR_RGB4 => format!("#{:03x}", data & 0xFFF),
            TYPE_REFERENCE | TYPE_DYNAMIC_REFERENCE => {
                self.decode_reference(data as u32)
            }
            TYPE_ATTRIBUTE => {
                self.decode_attribute_ref(data as u32)
            }
            TYPE_DIMENSION => decode_dimension(data as u32),
            TYPE_FRACTION => decode_fraction(data as u32),
            _ => {
                // Unknown type - output hex
                format!("0x{:x}", data)
            }
        }
    }

    /// Decode a resource reference
    fn decode_reference(&self, data: u32) -> String {
        if let Some(name) = self.res_names.get(&data) {
            let prefix = if name.starts_with("id/") { "@+" } else { "@" };
            return format!("{}{}", prefix, name);
        }

        if let Some(name) = android_res::get_res_name(data) {
            return format!("@android:{}", name);
        }

        if data == 0 {
            "@null".to_string()
        } else {
            format!("0x{:x}", data)
        }
    }

    /// Decode an attribute reference
    fn decode_attribute_ref(&self, data: u32) -> String {
        if let Some(name) = self.res_names.get(&data) {
            return format!("?{}", name);
        }

        if let Some(name) = android_res::get_res_name(data) {
            return format!("?android:{}", name);
        }

        format!("?0x{:x}", data)
    }

    /// Parse element end chunk
    fn parse_element_end(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        let header_size = cursor.read_u16::<LittleEndian>()?;
        if header_size != 0x10 {
            return Err(ResourceError::InvalidHeaderSize {
                expected: 0x10,
                actual: header_size as u32,
            });
        }

        let _chunk_size = cursor.read_u32::<LittleEndian>()?;
        let _line_number = cursor.read_u32::<LittleEndian>()?;
        let _comment = cursor.read_u32::<LittleEndian>()?;
        let _namespace_idx = cursor.read_i32::<LittleEndian>()?;
        let name_idx = cursor.read_u32::<LittleEndian>()?;

        let elem_name = self.get_string(name_idx);

        if self.current_tag == elem_name && self.is_one_line && !self.is_last_end {
            // Self-closing tag (no content between start and end)
            self.output.push_str("/>");
        } else {
            // Has child content or CDATA - use closing tag
            if !self.is_last_end {
                self.output.push('>');
            }
            self.start_line();
            self.output.push_str("</");
            self.output.push_str(&elem_name);
            self.output.push('>');
        }

        self.is_last_end = true;
        if self.indent > 0 {
            self.indent -= 1;
        }

        Ok(())
    }

    /// Parse CDATA chunk
    fn parse_cdata(&mut self, cursor: &mut Cursor<&[u8]>) -> Result<()> {
        let header_size = cursor.read_u16::<LittleEndian>()?;
        if header_size != 0x10 {
            return Err(ResourceError::InvalidHeaderSize {
                expected: 0x10,
                actual: header_size as u32,
            });
        }

        let _chunk_size = cursor.read_u32::<LittleEndian>()?;
        let _line_number = cursor.read_u32::<LittleEndian>()?;
        cursor.seek(SeekFrom::Current(4))?; // skip comment

        let str_idx = cursor.read_u32::<LittleEndian>()?;
        let text = self.get_string(str_idx);

        if !self.is_last_end {
            self.is_last_end = true;
            self.output.push('>');
        }

        self.output.push_str(&escape_xml(&text));

        // Skip typed value
        let size = cursor.read_u16::<LittleEndian>()?;
        cursor.seek(SeekFrom::Current((size - 2) as i64))?;

        Ok(())
    }

    /// Get a string from the pool
    fn get_string(&mut self, idx: u32) -> String {
        self.strings.get(idx).unwrap_or_else(|| {
            format!("NOT_FOUND_STR_0x{:x}", idx)
        })
    }

    /// Start a new line with indentation (4 spaces per level to match Java JADX)
    fn start_line(&mut self) {
        self.output.push('\n');
        for _ in 0..self.indent {
            self.output.push_str("    ");
        }
    }

    /// Start a new line for content (marks element as having content)
    fn start_content_line(&mut self) {
        self.start_line();
        self.is_one_line = false;
    }

    /// Add one level of indentation (4 spaces to match Java JADX)
    fn add_indent(&mut self) {
        self.output.push_str("    ");
    }
}

impl Default for AxmlParser {
    fn default() -> Self {
        Self::new()
    }
}

/// Check if a resource ID is internal
fn is_res_internal_id(resid: u32) -> bool {
    (resid & 0xFFFF0000) != 0 && (resid & 0xFF0000) == 0
}

/// Escape special XML characters
fn escape_xml(s: &str) -> String {
    let mut result = String::with_capacity(s.len());
    for c in s.chars() {
        match c {
            '<' => result.push_str("&lt;"),
            '>' => result.push_str("&gt;"),
            '&' => result.push_str("&amp;"),
            '"' => result.push_str("&quot;"),
            '\'' => result.push_str("&apos;"),
            _ => result.push(c),
        }
    }
    result
}

/// Format a float value for XML output
fn float_to_string(value: f64) -> String {
    if value == value.floor() && !value.is_infinite() {
        format!("{}", value as i64)
    } else {
        // Remove trailing zeros
        let s = format!("{:.4}", value);
        s.trim_end_matches('0').trim_end_matches('.').to_string()
    }
}

/// Decode Android enum/flag attribute values
/// Returns Some(string) if the attribute has a known enum mapping
fn decode_enum_value(attr_name: &str, data: i32) -> Option<String> {
    match attr_name {
        // Layout dimensions
        "layout_width" | "layout_height" | "width" | "height" |
        "minWidth" | "minHeight" | "maxWidth" | "maxHeight" => {
            match data {
                -1 => Some("match_parent".to_string()),
                -2 => Some("wrap_content".to_string()),
                _ => None,
            }
        }
        // Orientation
        "orientation" => {
            match data {
                0 => Some("horizontal".to_string()),
                1 => Some("vertical".to_string()),
                _ => None,
            }
        }
        // Visibility
        "visibility" => {
            match data {
                0 => Some("visible".to_string()),
                1 => Some("invisible".to_string()),
                2 => Some("gone".to_string()),
                _ => None,
            }
        }
        // Fill type (for vector drawables)
        "fillType" => {
            match data {
                0 => Some("nonZero".to_string()),
                1 => Some("evenOdd".to_string()),
                _ => None,
            }
        }
        // Text alignment
        "textAlignment" => {
            match data {
                0 => Some("inherit".to_string()),
                1 => Some("gravity".to_string()),
                2 => Some("textStart".to_string()),
                3 => Some("textEnd".to_string()),
                4 => Some("center".to_string()),
                5 => Some("viewStart".to_string()),
                6 => Some("viewEnd".to_string()),
                _ => None,
            }
        }
        // Input type
        "inputType" => {
            // Common input types (flags can be combined)
            match data {
                0 => Some("none".to_string()),
                1 => Some("text".to_string()),
                2 => Some("textCapCharacters".to_string()),
                3 => Some("number".to_string()),
                4 => Some("phone".to_string()),
                _ => None,
            }
        }
        // Gravity (flags - return None for complex combos, let it show as int)
        "gravity" | "layout_gravity" => {
            // Only handle simple single-flag values
            match data {
                0 => None, // Usually means default, show as "0"
                0x01 => Some("top".to_string()),
                0x10 => Some("bottom".to_string()),
                0x03 => Some("left".to_string()),
                0x05 => Some("right".to_string()),
                0x11 => Some("center_vertical".to_string()),
                0x07 => Some("center_horizontal".to_string()),
                0x17 => Some("center".to_string()),
                0x30 => Some("fill_vertical".to_string()),
                0x70 => Some("fill_horizontal".to_string()),
                0x77 => Some("fill".to_string()),
                0x800003 => Some("start".to_string()),
                0x800005 => Some("end".to_string()),
                _ => None,
            }
        }
        // Scale type for ImageView
        "scaleType" => {
            match data {
                0 => Some("matrix".to_string()),
                1 => Some("fitXY".to_string()),
                2 => Some("fitStart".to_string()),
                3 => Some("fitCenter".to_string()),
                4 => Some("fitEnd".to_string()),
                5 => Some("center".to_string()),
                6 => Some("centerCrop".to_string()),
                7 => Some("centerInside".to_string()),
                _ => None,
            }
        }
        // Ellipsize
        "ellipsize" => {
            match data {
                0 => Some("none".to_string()),
                1 => Some("start".to_string()),
                2 => Some("middle".to_string()),
                3 => Some("end".to_string()),
                4 => Some("marquee".to_string()),
                _ => None,
            }
        }
        // AutoLink
        "autoLink" => {
            match data {
                0 => Some("none".to_string()),
                1 => Some("web".to_string()),
                2 => Some("email".to_string()),
                4 => Some("phone".to_string()),
                8 => Some("map".to_string()),
                15 => Some("all".to_string()),
                _ => None,
            }
        }
        // Screen orientation
        "screenOrientation" => {
            match data {
                -1 => Some("unspecified".to_string()),
                0 => Some("landscape".to_string()),
                1 => Some("portrait".to_string()),
                2 => Some("user".to_string()),
                3 => Some("behind".to_string()),
                4 => Some("sensor".to_string()),
                5 => Some("nosensor".to_string()),
                6 => Some("sensorLandscape".to_string()),
                7 => Some("sensorPortrait".to_string()),
                8 => Some("reverseLandscape".to_string()),
                9 => Some("reversePortrait".to_string()),
                10 => Some("fullSensor".to_string()),
                11 => Some("userLandscape".to_string()),
                12 => Some("userPortrait".to_string()),
                13 => Some("fullUser".to_string()),
                14 => Some("locked".to_string()),
                _ => None,
            }
        }
        // Launch mode
        "launchMode" => {
            match data {
                0 => Some("standard".to_string()),
                1 => Some("singleTop".to_string()),
                2 => Some("singleTask".to_string()),
                3 => Some("singleInstance".to_string()),
                4 => Some("singleInstancePerTask".to_string()),
                _ => None,
            }
        }
        // Config changes (flags)
        "configChanges" => {
            if data == 0 {
                return None;
            }
            let mut flags = Vec::new();
            if data & 0x0001 != 0 { flags.push("mcc"); }
            if data & 0x0002 != 0 { flags.push("mnc"); }
            if data & 0x0004 != 0 { flags.push("locale"); }
            if data & 0x0008 != 0 { flags.push("touchscreen"); }
            if data & 0x0010 != 0 { flags.push("keyboard"); }
            if data & 0x0020 != 0 { flags.push("keyboardHidden"); }
            if data & 0x0040 != 0 { flags.push("navigation"); }
            if data & 0x0080 != 0 { flags.push("orientation"); }
            if data & 0x0100 != 0 { flags.push("screenLayout"); }
            if data & 0x0200 != 0 { flags.push("uiMode"); }
            if data & 0x0400 != 0 { flags.push("screenSize"); }
            if data & 0x0800 != 0 { flags.push("smallestScreenSize"); }
            if data & 0x1000 != 0 { flags.push("density"); }
            if data & 0x2000 != 0 { flags.push("layoutDirection"); }
            if data & 0x4000 != 0 { flags.push("colorMode"); }
            if data & 0x8000 != 0 { flags.push("fontScale"); }
            if flags.is_empty() {
                None
            } else {
                Some(flags.join("|"))
            }
        }
        // Window soft input mode (flags)
        "windowSoftInputMode" => {
            let state = data & 0x0F;
            let adjust = data & 0xF0;
            let mut parts = Vec::new();
            match state {
                0 => {} // unspecified
                1 => parts.push("stateUnchanged"),
                2 => parts.push("stateHidden"),
                3 => parts.push("stateAlwaysHidden"),
                4 => parts.push("stateVisible"),
                5 => parts.push("stateAlwaysVisible"),
                _ => {}
            }
            match adjust {
                0x00 => {} // unspecified
                0x10 => parts.push("adjustUnspecified"),
                0x20 => parts.push("adjustResize"),
                0x30 => parts.push("adjustPan"),
                _ => {}
            }
            if parts.is_empty() {
                None
            } else {
                Some(parts.join("|"))
            }
        }
        // Protection level
        "protectionLevel" => {
            match data & 0x0F {
                0 => Some("normal".to_string()),
                1 => Some("dangerous".to_string()),
                2 => Some("signature".to_string()),
                3 => Some("signatureOrSystem".to_string()),
                _ => None,
            }
        }
        // Install location
        "installLocation" => {
            match data {
                0 => Some("auto".to_string()),
                1 => Some("internalOnly".to_string()),
                2 => Some("preferExternal".to_string()),
                _ => None,
            }
        }
        _ => None,
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_escape_xml() {
        assert_eq!(escape_xml("hello"), "hello");
        assert_eq!(escape_xml("<test>"), "&lt;test&gt;");
        assert_eq!(escape_xml("a&b"), "a&amp;b");
        assert_eq!(escape_xml("\"quoted\""), "&quot;quoted&quot;");
    }

    #[test]
    fn test_float_to_string() {
        assert_eq!(float_to_string(1.0), "1");
        assert_eq!(float_to_string(1.5), "1.5");
        assert_eq!(float_to_string(1.25), "1.25");
    }

    #[test]
    fn test_is_res_internal() {
        assert!(!is_res_internal_id(0x7f010001));
        assert!(is_res_internal_id(0x01000001));
    }
}
