//! Android Component Detection
//!
//! Detects Android-specific components for better naming:
//! - Activity, Fragment, Service, BroadcastReceiver
//! - ViewModel, Adapter, ViewHolder
//! - Custom views, dialogs, etc.

use dexterity_ir::{ArgType, ClassData};

/// Detected Android component type
#[derive(Debug, Clone, PartialEq, Eq)]
pub enum AndroidComponent {
    /// Activity component
    Activity(ActivityType),
    /// Fragment component
    Fragment(FragmentType),
    /// Service component
    Service(ServiceType),
    /// BroadcastReceiver component
    BroadcastReceiver,
    /// ContentProvider component
    ContentProvider,
    /// Application class
    Application,
    /// Custom View
    CustomView(ViewType),
    /// RecyclerView Adapter
    Adapter(AdapterType),
    /// RecyclerView ViewHolder
    ViewHolder,
    /// ViewModel (Architecture Components)
    ViewModel,
    /// Dialog or DialogFragment
    Dialog,
    /// Worker (WorkManager)
    Worker,
    /// Room Database
    RoomDatabase,
    /// Room DAO
    RoomDao,
}

/// Activity subtypes
#[derive(Debug, Clone, PartialEq, Eq)]
pub enum ActivityType {
    Main,
    Settings,
    Detail,
    List,
    Login,
    Splash,
    Base,
    Unknown,
}

/// Fragment subtypes
#[derive(Debug, Clone, PartialEq, Eq)]
pub enum FragmentType {
    Bottom,
    Dialog,
    List,
    Settings,
    Base,
    Unknown,
}

/// Service subtypes
#[derive(Debug, Clone, PartialEq, Eq)]
pub enum ServiceType {
    IntentService,
    JobService,
    Foreground,
    Bound,
    Unknown,
}

/// View subtypes
#[derive(Debug, Clone, PartialEq, Eq)]
pub enum ViewType {
    Layout,
    Button,
    Text,
    Image,
    List,
    Recycler,
    Custom,
}

/// Adapter subtypes
#[derive(Debug, Clone, PartialEq, Eq)]
pub enum AdapterType {
    RecyclerView,
    ListView,
    Pager,
    Spinner,
    Unknown,
}

impl AndroidComponent {
    /// Get a naming suffix for this component
    pub fn naming_suffix(&self) -> &'static str {
        match self {
            AndroidComponent::Activity(_) => "Activity",
            AndroidComponent::Fragment(_) => "Fragment",
            AndroidComponent::Service(_) => "Service",
            AndroidComponent::BroadcastReceiver => "Receiver",
            AndroidComponent::ContentProvider => "Provider",
            AndroidComponent::Application => "Application",
            AndroidComponent::CustomView(_) => "View",
            AndroidComponent::Adapter(_) => "Adapter",
            AndroidComponent::ViewHolder => "ViewHolder",
            AndroidComponent::ViewModel => "ViewModel",
            AndroidComponent::Dialog => "Dialog",
            AndroidComponent::Worker => "Worker",
            AndroidComponent::RoomDatabase => "Database",
            AndroidComponent::RoomDao => "Dao",
        }
    }

    /// Get a naming prefix based on component subtype
    pub fn naming_prefix(&self) -> Option<&'static str> {
        match self {
            AndroidComponent::Activity(ActivityType::Main) => Some("Main"),
            AndroidComponent::Activity(ActivityType::Settings) => Some("Settings"),
            AndroidComponent::Activity(ActivityType::Detail) => Some("Detail"),
            AndroidComponent::Activity(ActivityType::List) => Some("List"),
            AndroidComponent::Activity(ActivityType::Login) => Some("Login"),
            AndroidComponent::Activity(ActivityType::Splash) => Some("Splash"),
            AndroidComponent::Fragment(FragmentType::Bottom) => Some("Bottom"),
            AndroidComponent::Fragment(FragmentType::Dialog) => Some("Dialog"),
            AndroidComponent::Fragment(FragmentType::List) => Some("List"),
            AndroidComponent::Fragment(FragmentType::Settings) => Some("Settings"),
            AndroidComponent::Service(ServiceType::IntentService) => Some("Intent"),
            AndroidComponent::Service(ServiceType::JobService) => Some("Job"),
            AndroidComponent::Service(ServiceType::Foreground) => Some("Foreground"),
            AndroidComponent::Adapter(AdapterType::RecyclerView) => Some("Recycler"),
            AndroidComponent::Adapter(AdapterType::ListView) => Some("List"),
            AndroidComponent::Adapter(AdapterType::Pager) => Some("Pager"),
            _ => None,
        }
    }
}

/// Detector for Android components
pub struct AndroidComponentDetector;

impl AndroidComponentDetector {
    /// Detect Android component type from class
    pub fn detect(cls: &ClassData) -> Option<AndroidComponent> {
        // First check superclass
        if let Some(ref super_cls) = cls.superclass {
            if let Some(component) = Self::detect_from_superclass(super_cls, cls) {
                return Some(component);
            }
        }

        // Check interfaces
        for iface in &cls.interfaces {
            if let Some(component) = Self::detect_from_interface(iface) {
                return Some(component);
            }
        }

        // Check for Room annotations/patterns
        if Self::is_room_database(cls) {
            return Some(AndroidComponent::RoomDatabase);
        }
        if Self::is_room_dao(cls) {
            return Some(AndroidComponent::RoomDao);
        }

        None
    }

    /// Detect component from superclass
    fn detect_from_superclass(super_cls: &str, cls: &ClassData) -> Option<AndroidComponent> {
        let super_name = super_cls.trim_start_matches('L').trim_end_matches(';');

        // Activity types
        if super_name.contains("Activity") {
            let activity_type = Self::classify_activity(cls);
            return Some(AndroidComponent::Activity(activity_type));
        }

        // Fragment types
        if super_name.contains("Fragment") {
            if super_name.contains("DialogFragment") {
                return Some(AndroidComponent::Dialog);
            }
            if super_name.contains("BottomSheet") {
                return Some(AndroidComponent::Fragment(FragmentType::Bottom));
            }
            if super_name.contains("ListFragment") {
                return Some(AndroidComponent::Fragment(FragmentType::List));
            }
            if super_name.contains("PreferenceFragment") {
                return Some(AndroidComponent::Fragment(FragmentType::Settings));
            }
            let fragment_type = Self::classify_fragment(cls);
            return Some(AndroidComponent::Fragment(fragment_type));
        }

        // Service types
        if super_name.contains("Service") {
            if super_name.contains("IntentService") {
                return Some(AndroidComponent::Service(ServiceType::IntentService));
            }
            if super_name.contains("JobIntentService") || super_name.contains("JobService") {
                return Some(AndroidComponent::Service(ServiceType::JobService));
            }
            let service_type = Self::classify_service(cls);
            return Some(AndroidComponent::Service(service_type));
        }

        // BroadcastReceiver
        if super_name.contains("BroadcastReceiver") {
            return Some(AndroidComponent::BroadcastReceiver);
        }

        // ContentProvider
        if super_name.contains("ContentProvider") {
            return Some(AndroidComponent::ContentProvider);
        }

        // Application
        if super_name.contains("Application") && !super_name.contains("ApplicationWrapper") {
            return Some(AndroidComponent::Application);
        }

        // ViewModel
        if super_name.contains("ViewModel") {
            return Some(AndroidComponent::ViewModel);
        }

        // Adapter types
        if super_name.contains("Adapter") {
            return Some(Self::detect_adapter_type(super_name));
        }

        // ViewHolder
        if super_name.contains("ViewHolder") {
            return Some(AndroidComponent::ViewHolder);
        }

        // Dialog
        if super_name.contains("Dialog") && !super_name.contains("DialogFragment") {
            return Some(AndroidComponent::Dialog);
        }

        // Worker (WorkManager)
        if super_name.contains("Worker") || super_name.contains("ListenableWorker") {
            return Some(AndroidComponent::Worker);
        }

        // Custom View
        if super_name.contains("View")
            || super_name.contains("Layout")
            || super_name.contains("Widget")
        {
            let view_type = Self::classify_view(super_name);
            return Some(AndroidComponent::CustomView(view_type));
        }

        None
    }

    /// Detect component from interface
    fn detect_from_interface(iface: &ArgType) -> Option<AndroidComponent> {
        let iface_name = match iface {
            ArgType::Object(name) => name.trim_start_matches('L').trim_end_matches(';'),
            ArgType::Generic { base, .. } => base.trim_start_matches('L').trim_end_matches(';'),
            _ => return None,
        };

        // LifecycleOwner suggests Activity/Fragment
        if iface_name.contains("LifecycleOwner") {
            // Can't determine specific type from just interface
            return None;
        }

        None
    }

    /// Classify activity subtype
    fn classify_activity(cls: &ClassData) -> ActivityType {
        let class_name = cls.simple_name().to_lowercase();
        let methods: Vec<_> = cls.methods.iter().map(|m| m.name.to_lowercase()).collect();

        // Check class name hints
        if class_name.contains("main") || class_name.contains("home") || class_name.contains("launcher") {
            return ActivityType::Main;
        }
        if class_name.contains("setting") || class_name.contains("preference") {
            return ActivityType::Settings;
        }
        if class_name.contains("detail") || class_name.contains("info") {
            return ActivityType::Detail;
        }
        if class_name.contains("list") || class_name.contains("browse") {
            return ActivityType::List;
        }
        if class_name.contains("login") || class_name.contains("auth") || class_name.contains("signin") {
            return ActivityType::Login;
        }
        if class_name.contains("splash") || class_name.contains("launch") {
            return ActivityType::Splash;
        }
        if class_name.contains("base") {
            return ActivityType::Base;
        }

        // Check for launcher activity indicators
        if methods.iter().any(|m| m.contains("handleintent")) {
            return ActivityType::Main;
        }

        ActivityType::Unknown
    }

    /// Classify fragment subtype
    fn classify_fragment(cls: &ClassData) -> FragmentType {
        let class_name = cls.simple_name().to_lowercase();

        if class_name.contains("bottom") || class_name.contains("sheet") {
            return FragmentType::Bottom;
        }
        if class_name.contains("dialog") {
            return FragmentType::Dialog;
        }
        if class_name.contains("list") || class_name.contains("recycler") {
            return FragmentType::List;
        }
        if class_name.contains("setting") || class_name.contains("preference") {
            return FragmentType::Settings;
        }
        if class_name.contains("base") {
            return FragmentType::Base;
        }

        FragmentType::Unknown
    }

    /// Classify service subtype
    fn classify_service(cls: &ClassData) -> ServiceType {
        let methods: Vec<_> = cls.methods.iter().map(|m| m.name.as_str()).collect();

        // Check for foreground service indicators
        if methods.contains(&"startForeground") {
            return ServiceType::Foreground;
        }

        // Check for bound service indicators
        if methods.contains(&"onBind") && !methods.contains(&"onStartCommand") {
            return ServiceType::Bound;
        }

        ServiceType::Unknown
    }

    /// Detect adapter type from superclass name
    fn detect_adapter_type(super_name: &str) -> AndroidComponent {
        if super_name.contains("RecyclerView") {
            AndroidComponent::Adapter(AdapterType::RecyclerView)
        } else if super_name.contains("PagerAdapter") || super_name.contains("FragmentPagerAdapter") {
            AndroidComponent::Adapter(AdapterType::Pager)
        } else if super_name.contains("ArrayAdapter") || super_name.contains("BaseAdapter") {
            AndroidComponent::Adapter(AdapterType::ListView)
        } else if super_name.contains("SpinnerAdapter") {
            AndroidComponent::Adapter(AdapterType::Spinner)
        } else {
            AndroidComponent::Adapter(AdapterType::Unknown)
        }
    }

    /// Classify view type
    fn classify_view(super_name: &str) -> ViewType {
        if super_name.contains("Layout") || super_name.contains("ViewGroup") {
            ViewType::Layout
        } else if super_name.contains("Button") || super_name.contains("ImageButton") {
            ViewType::Button
        } else if super_name.contains("TextView") || super_name.contains("EditText") {
            ViewType::Text
        } else if super_name.contains("ImageView") {
            ViewType::Image
        } else if super_name.contains("ListView") {
            ViewType::List
        } else if super_name.contains("RecyclerView") {
            ViewType::Recycler
        } else {
            ViewType::Custom
        }
    }

    /// Check if class is a Room Database
    fn is_room_database(cls: &ClassData) -> bool {
        // Check superclass
        if let Some(ref super_cls) = cls.superclass {
            if super_cls.contains("RoomDatabase") {
                return true;
            }
        }

        // Check for abstract database-like patterns
        cls.is_abstract()
            && cls.methods.iter().any(|m| {
                let name = m.name.to_lowercase();
                name.ends_with("dao") || name.contains("getdao")
            })
    }

    /// Check if class is a Room DAO
    fn is_room_dao(cls: &ClassData) -> bool {
        // DAOs are typically interfaces with query methods
        if !cls.is_interface() {
            return false;
        }

        // Check for DAO-like method patterns
        let dao_methods = cls.methods.iter()
            .filter(|m| {
                let name = m.name.to_lowercase();
                name.starts_with("get")
                    || name.starts_with("find")
                    || name.starts_with("insert")
                    || name.starts_with("update")
                    || name.starts_with("delete")
                    || name.contains("query")
            })
            .count();

        dao_methods >= 2
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_activity_detection() {
        let mut cls = ClassData::new("Lcom/example/MainActivity;".to_string(), 0);
        cls.superclass = Some("Landroid/app/Activity;".to_string());

        let component = AndroidComponentDetector::detect(&cls);
        assert!(matches!(component, Some(AndroidComponent::Activity(ActivityType::Main))));
    }

    #[test]
    fn test_fragment_detection() {
        let mut cls = ClassData::new("Lcom/example/SettingsFragment;".to_string(), 0);
        cls.superclass = Some("Landroidx/fragment/app/Fragment;".to_string());

        let component = AndroidComponentDetector::detect(&cls);
        assert!(matches!(component, Some(AndroidComponent::Fragment(FragmentType::Settings))));
    }

    #[test]
    fn test_service_detection() {
        let mut cls = ClassData::new("Lcom/example/MyService;".to_string(), 0);
        cls.superclass = Some("Landroid/app/IntentService;".to_string());

        let component = AndroidComponentDetector::detect(&cls);
        assert!(matches!(component, Some(AndroidComponent::Service(ServiceType::IntentService))));
    }

    #[test]
    fn test_viewmodel_detection() {
        let mut cls = ClassData::new("Lcom/example/UserViewModel;".to_string(), 0);
        cls.superclass = Some("Landroidx/lifecycle/ViewModel;".to_string());

        let component = AndroidComponentDetector::detect(&cls);
        assert!(matches!(component, Some(AndroidComponent::ViewModel)));
    }

    #[test]
    fn test_adapter_detection() {
        let mut cls = ClassData::new("Lcom/example/UserAdapter;".to_string(), 0);
        cls.superclass = Some("Landroidx/recyclerview/widget/RecyclerView$Adapter;".to_string());

        let component = AndroidComponentDetector::detect(&cls);
        assert!(matches!(component, Some(AndroidComponent::Adapter(AdapterType::RecyclerView))));
    }

    #[test]
    fn test_naming_suffix() {
        assert_eq!(AndroidComponent::Activity(ActivityType::Main).naming_suffix(), "Activity");
        assert_eq!(AndroidComponent::Fragment(FragmentType::Dialog).naming_suffix(), "Fragment");
        assert_eq!(AndroidComponent::ViewModel.naming_suffix(), "ViewModel");
        assert_eq!(AndroidComponent::Adapter(AdapterType::RecyclerView).naming_suffix(), "Adapter");
    }
}
