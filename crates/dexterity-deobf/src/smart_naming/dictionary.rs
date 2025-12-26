//! Word Dictionary System for Smart Naming
//!
//! Provides curated word lists for generating readable identifier names:
//! - Common English nouns, verbs, adjectives
//! - Domain-specific vocabularies (Android, Networking, Crypto, etc.)
//! - Compound name generation utilities

use lazy_static::lazy_static;
use std::collections::HashSet;

/// Main dictionary containing word lists for name generation
#[derive(Debug)]
pub struct Dictionary {
    /// Common English nouns for naming
    pub nouns: &'static HashSet<&'static str>,
    /// Action verbs
    pub verbs: &'static HashSet<&'static str>,
    /// Descriptive adjectives
    pub adjectives: &'static HashSet<&'static str>,
}

impl Dictionary {
    /// Get the global dictionary instance
    pub fn global() -> &'static Self {
        &DICTIONARY
    }

    /// Check if a word is a known noun
    pub fn is_noun(&self, word: &str) -> bool {
        self.nouns.contains(word.to_lowercase().as_str())
    }

    /// Check if a word is a known verb
    pub fn is_verb(&self, word: &str) -> bool {
        self.verbs.contains(word.to_lowercase().as_str())
    }

    /// Get a random noun from the dictionary (for fallback naming)
    pub fn get_noun_by_index(&self, index: usize) -> &'static str {
        let nouns: Vec<_> = self.nouns.iter().collect();
        nouns.get(index % nouns.len()).copied().unwrap_or("data")
    }
}

/// Domain-specific vocabulary
#[derive(Debug, Clone)]
pub struct DomainVocabulary {
    /// Domain keywords
    pub keywords: &'static HashSet<&'static str>,
    /// Common class suffixes in this domain
    pub class_suffixes: &'static [&'static str],
    /// Common method prefixes
    pub method_prefixes: &'static [&'static str],
}

lazy_static! {
    // ============================================================
    // COMMON ENGLISH WORDS
    // ============================================================

    /// Common nouns for naming
    static ref NOUNS: HashSet<&'static str> = {
        let mut s = HashSet::new();
        // Data/Storage
        s.insert("data"); s.insert("item"); s.insert("entry"); s.insert("record");
        s.insert("value"); s.insert("result"); s.insert("info"); s.insert("content");
        s.insert("buffer"); s.insert("cache"); s.insert("store"); s.insert("storage");
        s.insert("queue"); s.insert("stack"); s.insert("pool"); s.insert("bucket");
        // Objects/Entities
        s.insert("object"); s.insert("entity"); s.insert("model"); s.insert("bean");
        s.insert("node"); s.insert("element"); s.insert("component"); s.insert("module");
        s.insert("unit"); s.insert("block"); s.insert("chunk"); s.insert("segment");
        // Actions/Operations
        s.insert("action"); s.insert("task"); s.insert("job"); s.insert("work");
        s.insert("event"); s.insert("signal"); s.insert("message"); s.insert("command");
        s.insert("request"); s.insert("response"); s.insert("query"); s.insert("operation");
        // State/Status
        s.insert("state"); s.insert("status"); s.insert("flag"); s.insert("mode");
        s.insert("type"); s.insert("kind"); s.insert("category"); s.insert("level");
        s.insert("phase"); s.insert("stage"); s.insert("step"); s.insert("index");
        // Time
        s.insert("time"); s.insert("date"); s.insert("timestamp"); s.insert("duration");
        s.insert("interval"); s.insert("period"); s.insert("delay"); s.insert("timeout");
        // Identity
        s.insert("id"); s.insert("key"); s.insert("name"); s.insert("label");
        s.insert("tag"); s.insert("token"); s.insert("code"); s.insert("hash");
        // Size/Count
        s.insert("size"); s.insert("count"); s.insert("length"); s.insert("width");
        s.insert("height"); s.insert("depth"); s.insert("total"); s.insert("number");
        // Position
        s.insert("position"); s.insert("offset"); s.insert("location"); s.insert("point");
        s.insert("start"); s.insert("end"); s.insert("begin"); s.insert("finish");
        // Connection
        s.insert("link"); s.insert("connection"); s.insert("socket"); s.insert("channel");
        s.insert("stream"); s.insert("pipe"); s.insert("port"); s.insert("endpoint");
        // User/Person
        s.insert("user"); s.insert("client"); s.insert("account"); s.insert("profile");
        s.insert("owner"); s.insert("author"); s.insert("creator"); s.insert("admin");
        // Error/Exception
        s.insert("error"); s.insert("exception"); s.insert("failure"); s.insert("fault");
        s.insert("issue"); s.insert("problem"); s.insert("warning"); s.insert("alert");
        // Configuration
        s.insert("config"); s.insert("setting"); s.insert("option"); s.insert("preference");
        s.insert("param"); s.insert("argument"); s.insert("property"); s.insert("attribute");
        // Pattern-specific
        s.insert("handler"); s.insert("listener"); s.insert("callback"); s.insert("observer");
        s.insert("adapter"); s.insert("wrapper"); s.insert("proxy"); s.insert("delegate");
        s.insert("factory"); s.insert("builder"); s.insert("provider"); s.insert("manager");
        s.insert("controller"); s.insert("service"); s.insert("helper"); s.insert("utility");
        s
    };

    /// Common verbs for naming
    static ref VERBS: HashSet<&'static str> = {
        let mut s = HashSet::new();
        // CRUD
        s.insert("get"); s.insert("set"); s.insert("add"); s.insert("remove");
        s.insert("create"); s.insert("delete"); s.insert("update"); s.insert("insert");
        s.insert("read"); s.insert("write"); s.insert("load"); s.insert("save");
        s.insert("fetch"); s.insert("store"); s.insert("find"); s.insert("search");
        // Processing
        s.insert("process"); s.insert("handle"); s.insert("execute"); s.insert("run");
        s.insert("start"); s.insert("stop"); s.insert("pause"); s.insert("resume");
        s.insert("init"); s.insert("setup"); s.insert("cleanup"); s.insert("reset");
        s.insert("parse"); s.insert("format"); s.insert("convert"); s.insert("transform");
        s.insert("encode"); s.insert("decode"); s.insert("encrypt"); s.insert("decrypt");
        s.insert("compress"); s.insert("decompress"); s.insert("serialize"); s.insert("deserialize");
        // Checking
        s.insert("check"); s.insert("validate"); s.insert("verify"); s.insert("test");
        s.insert("compare"); s.insert("match"); s.insert("equals"); s.insert("contains");
        s.insert("is"); s.insert("has"); s.insert("can"); s.insert("should");
        // Communication
        s.insert("send"); s.insert("receive"); s.insert("notify"); s.insert("dispatch");
        s.insert("broadcast"); s.insert("publish"); s.insert("subscribe"); s.insert("emit");
        s.insert("request"); s.insert("respond"); s.insert("connect"); s.insert("disconnect");
        // UI
        s.insert("show"); s.insert("hide"); s.insert("display"); s.insert("render");
        s.insert("draw"); s.insert("paint"); s.insert("refresh"); s.insert("invalidate");
        s.insert("click"); s.insert("touch"); s.insert("drag"); s.insert("scroll");
        // Lifecycle
        s.insert("open"); s.insert("close"); s.insert("attach"); s.insert("detach");
        s.insert("bind"); s.insert("unbind"); s.insert("register"); s.insert("unregister");
        s
    };

    /// Common adjectives for naming
    static ref ADJECTIVES: HashSet<&'static str> = {
        let mut s = HashSet::new();
        // State
        s.insert("new"); s.insert("old"); s.insert("current"); s.insert("previous");
        s.insert("next"); s.insert("last"); s.insert("first"); s.insert("final");
        s.insert("active"); s.insert("inactive"); s.insert("enabled"); s.insert("disabled");
        s.insert("valid"); s.insert("invalid"); s.insert("available"); s.insert("pending");
        // Size
        s.insert("min"); s.insert("max"); s.insert("small"); s.insert("large");
        s.insert("tiny"); s.insert("huge"); s.insert("empty"); s.insert("full");
        // Scope
        s.insert("local"); s.insert("global"); s.insert("static"); s.insert("dynamic");
        s.insert("public"); s.insert("private"); s.insert("shared"); s.insert("common");
        s.insert("default"); s.insert("custom"); s.insert("internal"); s.insert("external");
        // Quality
        s.insert("main"); s.insert("primary"); s.insert("secondary"); s.insert("temp");
        s.insert("cached"); s.insert("lazy"); s.insert("eager"); s.insert("raw");
        s
    };

    // ============================================================
    // DOMAIN-SPECIFIC VOCABULARIES
    // ============================================================

    /// Android-specific keywords
    static ref ANDROID_KEYWORDS: HashSet<&'static str> = {
        let mut s = HashSet::new();
        // Components
        s.insert("activity"); s.insert("fragment"); s.insert("service"); s.insert("receiver");
        s.insert("provider"); s.insert("application"); s.insert("context"); s.insert("intent");
        // UI
        s.insert("view"); s.insert("layout"); s.insert("widget"); s.insert("button");
        s.insert("text"); s.insert("image"); s.insert("list"); s.insert("recycler");
        s.insert("adapter"); s.insert("viewholder"); s.insert("toolbar"); s.insert("menu");
        // Lifecycle
        s.insert("oncreate"); s.insert("onstart"); s.insert("onresume"); s.insert("onpause");
        s.insert("onstop"); s.insert("ondestroy"); s.insert("onsaveinstancestate");
        // Data
        s.insert("bundle"); s.insert("parcel"); s.insert("cursor"); s.insert("contentvalues");
        s.insert("sharedpreferences"); s.insert("database"); s.insert("room");
        // Threading
        s.insert("asynctask"); s.insert("handler"); s.insert("looper"); s.insert("runnable");
        s
    };

    /// Networking-specific keywords
    static ref NETWORK_KEYWORDS: HashSet<&'static str> = {
        let mut s = HashSet::new();
        s.insert("http"); s.insert("https"); s.insert("url"); s.insert("uri");
        s.insert("request"); s.insert("response"); s.insert("header"); s.insert("body");
        s.insert("socket"); s.insert("connection"); s.insert("client"); s.insert("server");
        s.insert("api"); s.insert("rest"); s.insert("json"); s.insert("xml");
        s.insert("retrofit"); s.insert("okhttp"); s.insert("volley"); s.insert("grpc");
        s.insert("download"); s.insert("upload"); s.insert("stream"); s.insert("websocket");
        s
    };

    /// Crypto-specific keywords
    static ref CRYPTO_KEYWORDS: HashSet<&'static str> = {
        let mut s = HashSet::new();
        s.insert("cipher"); s.insert("key"); s.insert("hash"); s.insert("digest");
        s.insert("signature"); s.insert("certificate"); s.insert("encrypt"); s.insert("decrypt");
        s.insert("aes"); s.insert("rsa"); s.insert("md5"); s.insert("sha");
        s.insert("hmac"); s.insert("salt"); s.insert("iv"); s.insert("nonce");
        s.insert("keystore"); s.insert("keyspec"); s.insert("secretkey"); s.insert("publickey");
        s
    };

    /// Database-specific keywords
    static ref DATABASE_KEYWORDS: HashSet<&'static str> = {
        let mut s = HashSet::new();
        s.insert("database"); s.insert("table"); s.insert("column"); s.insert("row");
        s.insert("query"); s.insert("insert"); s.insert("update"); s.insert("delete");
        s.insert("select"); s.insert("where"); s.insert("join"); s.insert("index");
        s.insert("cursor"); s.insert("transaction"); s.insert("dao"); s.insert("repository");
        s.insert("entity"); s.insert("sqlite"); s.insert("room"); s.insert("realm");
        s
    };

    /// Threading-specific keywords
    static ref THREADING_KEYWORDS: HashSet<&'static str> = {
        let mut s = HashSet::new();
        s.insert("thread"); s.insert("runnable"); s.insert("executor"); s.insert("future");
        s.insert("callable"); s.insert("lock"); s.insert("mutex"); s.insert("semaphore");
        s.insert("barrier"); s.insert("latch"); s.insert("atomic"); s.insert("volatile");
        s.insert("synchronized"); s.insert("concurrent"); s.insert("parallel"); s.insert("async");
        s.insert("coroutine"); s.insert("dispatcher"); s.insert("scope"); s.insert("job");
        s
    };

    /// UI-specific keywords
    static ref UI_KEYWORDS: HashSet<&'static str> = {
        let mut s = HashSet::new();
        s.insert("view"); s.insert("layout"); s.insert("widget"); s.insert("control");
        s.insert("button"); s.insert("label"); s.insert("text"); s.insert("input");
        s.insert("image"); s.insert("icon"); s.insert("color"); s.insert("style");
        s.insert("animation"); s.insert("transition"); s.insert("drawable"); s.insert("canvas");
        s.insert("paint"); s.insert("path"); s.insert("rect"); s.insert("bitmap");
        s
    };

    /// Common class suffixes by domain
    static ref ANDROID_CLASS_SUFFIXES: [&'static str; 16] = [
        "Activity", "Fragment", "Service", "Receiver",
        "Provider", "Adapter", "ViewHolder", "ViewModel",
        "Repository", "UseCase", "Presenter", "Controller",
        "Manager", "Helper", "Util", "Factory"
    ];

    static ref NETWORK_CLASS_SUFFIXES: [&'static str; 8] = [
        "Client", "Api", "Service", "Interceptor",
        "Converter", "Deserializer", "Serializer", "Factory"
    ];

    static ref CRYPTO_CLASS_SUFFIXES: [&'static str; 6] = [
        "Cipher", "KeyManager", "Encryptor", "Decryptor",
        "Hasher", "Signer"
    ];

    /// The main dictionary instance
    static ref DICTIONARY: Dictionary = Dictionary {
        nouns: &NOUNS,
        verbs: &VERBS,
        adjectives: &ADJECTIVES,
    };

    /// Android domain vocabulary
    pub static ref ANDROID_VOCAB: DomainVocabulary = DomainVocabulary {
        keywords: &ANDROID_KEYWORDS,
        class_suffixes: &ANDROID_CLASS_SUFFIXES[..],
        method_prefixes: &["on", "handle", "do", "perform", "setup", "init", "bind", "unbind"],
    };

    /// Network domain vocabulary
    pub static ref NETWORK_VOCAB: DomainVocabulary = DomainVocabulary {
        keywords: &NETWORK_KEYWORDS,
        class_suffixes: &NETWORK_CLASS_SUFFIXES[..],
        method_prefixes: &["fetch", "send", "receive", "request", "post", "get", "put", "delete"],
    };

    /// Crypto domain vocabulary
    pub static ref CRYPTO_VOCAB: DomainVocabulary = DomainVocabulary {
        keywords: &CRYPTO_KEYWORDS,
        class_suffixes: &CRYPTO_CLASS_SUFFIXES[..],
        method_prefixes: &["encrypt", "decrypt", "hash", "sign", "verify", "generate"],
    };
}

/// Utility functions for compound name generation
pub struct CompoundNameGenerator;

impl CompoundNameGenerator {
    /// Generate a field name from a type hint and optional context
    ///
    /// Examples:
    /// - ("Map", Some("user")) -> "userMap"
    /// - ("List", None) -> "itemList"
    /// - ("Handler", Some("main")) -> "mainHandler"
    pub fn generate_field_name(type_suffix: &str, context: Option<&str>) -> String {
        let prefix = context.unwrap_or_else(|| {
            // Default prefixes based on type
            match type_suffix.to_lowercase().as_str() {
                "map" | "hashmap" | "treemap" => "data",
                "list" | "arraylist" | "linkedlist" => "item",
                "set" | "hashset" | "treeset" => "value",
                "handler" => "main",
                "listener" => "event",
                "callback" => "result",
                "adapter" => "list",
                "thread" | "executor" => "worker",
                "buffer" | "stream" => "data",
                _ => "temp",
            }
        });

        format!("{}{}", to_camel_case(prefix), type_suffix)
    }

    /// Generate a method name from pattern and context
    ///
    /// Examples:
    /// - (Getter, "name") -> "getName"
    /// - (Setter, "value") -> "setValue"
    /// - (EventHandler, "Click") -> "onClick"
    pub fn generate_method_name(pattern: &str, context: &str) -> String {
        match pattern {
            "getter" => format!("get{}", capitalize_first(context)),
            "setter" => format!("set{}", capitalize_first(context)),
            "event" => format!("on{}", capitalize_first(context)),
            "check" => format!("is{}", capitalize_first(context)),
            "has" => format!("has{}", capitalize_first(context)),
            "factory" => format!("create{}", capitalize_first(context)),
            _ => format!("{}{}", pattern, capitalize_first(context)),
        }
    }

    /// Detect if a short name might be an abbreviation
    pub fn is_common_abbreviation(name: &str) -> Option<&'static str> {
        match name.to_lowercase().as_str() {
            "ctx" | "ctxt" => Some("context"),
            "btn" => Some("button"),
            "tv" => Some("textView"),
            "iv" => Some("imageView"),
            "lv" => Some("listView"),
            "rv" => Some("recyclerView"),
            "db" => Some("database"),
            "sp" => Some("sharedPreferences"),
            "prefs" => Some("preferences"),
            "req" => Some("request"),
            "res" | "resp" => Some("response"),
            "msg" => Some("message"),
            "pkg" => Some("package"),
            "cb" => Some("callback"),
            "idx" => Some("index"),
            "pos" => Some("position"),
            "len" => Some("length"),
            "cnt" | "num" => Some("count"),
            "err" => Some("error"),
            "ex" => Some("exception"),
            "cfg" => Some("config"),
            "tmp" => Some("temp"),
            "str" => Some("string"),
            "arr" => Some("array"),
            "obj" => Some("object"),
            "val" => Some("value"),
            "src" => Some("source"),
            "dst" | "dest" => Some("destination"),
            _ => None,
        }
    }
}

/// Convert a string to camelCase
fn to_camel_case(s: &str) -> String {
    s.chars()
        .next()
        .map(|c| c.to_lowercase().to_string())
        .unwrap_or_default()
        + &s.chars().skip(1).collect::<String>()
}

/// Capitalize the first character
fn capitalize_first(s: &str) -> String {
    s.chars()
        .next()
        .map(|c| c.to_uppercase().to_string())
        .unwrap_or_default()
        + &s.chars().skip(1).collect::<String>()
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_dictionary_lookup() {
        let dict = Dictionary::global();
        assert!(dict.is_noun("data"));
        assert!(dict.is_noun("handler"));
        assert!(dict.is_verb("get"));
        assert!(dict.is_verb("process"));
    }

    #[test]
    fn test_compound_name_generation() {
        assert_eq!(
            CompoundNameGenerator::generate_field_name("Map", Some("user")),
            "userMap"
        );
        assert_eq!(
            CompoundNameGenerator::generate_field_name("List", None),
            "itemList"
        );
        assert_eq!(
            CompoundNameGenerator::generate_field_name("Handler", Some("main")),
            "mainHandler"
        );
    }

    #[test]
    fn test_method_name_generation() {
        assert_eq!(
            CompoundNameGenerator::generate_method_name("getter", "name"),
            "getName"
        );
        assert_eq!(
            CompoundNameGenerator::generate_method_name("setter", "value"),
            "setValue"
        );
        assert_eq!(
            CompoundNameGenerator::generate_method_name("event", "Click"),
            "onClick"
        );
    }

    #[test]
    fn test_abbreviation_expansion() {
        assert_eq!(CompoundNameGenerator::is_common_abbreviation("ctx"), Some("context"));
        assert_eq!(CompoundNameGenerator::is_common_abbreviation("btn"), Some("button"));
        assert_eq!(CompoundNameGenerator::is_common_abbreviation("xyz"), None);
    }
}
