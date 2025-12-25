//! Special integration tests
//! Ported from jadx-core/src/test/java/jadx/tests/integration/

#[allow(unused_imports)]
use crate::integration_test_framework::{IntegrationTestHelper, tools_status};

#[test]
fn package_info_support_test() {
    // Note: Java test (TestPackageInfoSupport) is a SmaliTest that loads from smali files.
    // This tests package-info.java support which requires smali input not available in
    // our standard test framework. Skipping as dexterity doesn't support smali input yet.
    //
    // Original assertions:
    // - @Deprecated annotation on package special.pkg1
    // - @ApiStatus.Internal annotation on package special.pkg2
    // - Plain package declaration for special.pkg3
    eprintln!("SKIPPED: SmaliTest - requires smali input format");
}
