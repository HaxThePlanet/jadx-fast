package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

/* loaded from: classes2.dex */
public final class AutoCrashlyticsReportEncoder implements Configurator {

    public static final int CODEGEN_VERSION = 2;
    public static final Configurator CONFIG;

    private static final class CrashlyticsReportApplicationExitInfoEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo> {

        private static final FieldDescriptor IMPORTANCE_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder INSTANCE;
        private static final FieldDescriptor PID_DESCRIPTOR;
        private static final FieldDescriptor PROCESSNAME_DESCRIPTOR;
        private static final FieldDescriptor PSS_DESCRIPTOR;
        private static final FieldDescriptor REASONCODE_DESCRIPTOR;
        private static final FieldDescriptor RSS_DESCRIPTOR;
        private static final FieldDescriptor TIMESTAMP_DESCRIPTOR;
        private static final FieldDescriptor TRACEFILE_DESCRIPTOR;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder crashlyticsReportApplicationExitInfoEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.INSTANCE = crashlyticsReportApplicationExitInfoEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.PID_DESCRIPTOR = FieldDescriptor.of("pid");
            AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.PROCESSNAME_DESCRIPTOR = FieldDescriptor.of("processName");
            AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.REASONCODE_DESCRIPTOR = FieldDescriptor.of("reasonCode");
            AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.IMPORTANCE_DESCRIPTOR = FieldDescriptor.of("importance");
            AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.PSS_DESCRIPTOR = FieldDescriptor.of("pss");
            AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.RSS_DESCRIPTOR = FieldDescriptor.of("rss");
            AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.TIMESTAMP_DESCRIPTOR = FieldDescriptor.of("timestamp");
            AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.TRACEFILE_DESCRIPTOR = FieldDescriptor.of("traceFile");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo crashlyticsReport$ApplicationExitInfo, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.PID_DESCRIPTOR, applicationExitInfo.getPid());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.PROCESSNAME_DESCRIPTOR, applicationExitInfo.getProcessName());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.REASONCODE_DESCRIPTOR, applicationExitInfo.getReasonCode());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.IMPORTANCE_DESCRIPTOR, applicationExitInfo.getImportance());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.PSS_DESCRIPTOR, applicationExitInfo.getPss());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.RSS_DESCRIPTOR, applicationExitInfo.getRss());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.TIMESTAMP_DESCRIPTOR, applicationExitInfo.getTimestamp());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.TRACEFILE_DESCRIPTOR, applicationExitInfo.getTraceFile());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.ApplicationExitInfo)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportCustomAttributeEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute> {

        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportCustomAttributeEncoder INSTANCE;
        private static final FieldDescriptor KEY_DESCRIPTOR;
        private static final FieldDescriptor VALUE_DESCRIPTOR;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportCustomAttributeEncoder crashlyticsReportCustomAttributeEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportCustomAttributeEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportCustomAttributeEncoder.INSTANCE = crashlyticsReportCustomAttributeEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportCustomAttributeEncoder.KEY_DESCRIPTOR = FieldDescriptor.of("key");
            AutoCrashlyticsReportEncoder.CrashlyticsReportCustomAttributeEncoder.VALUE_DESCRIPTOR = FieldDescriptor.of("value");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute crashlyticsReport$CustomAttribute, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportCustomAttributeEncoder.KEY_DESCRIPTOR, customAttribute.getKey());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportCustomAttributeEncoder.VALUE_DESCRIPTOR, customAttribute.getValue());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.CustomAttribute)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport> {

        private static final FieldDescriptor BUILDVERSION_DESCRIPTOR;
        private static final FieldDescriptor DISPLAYVERSION_DESCRIPTOR;
        private static final FieldDescriptor GMPAPPID_DESCRIPTOR;
        private static final FieldDescriptor INSTALLATIONUUID_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder INSTANCE;
        private static final FieldDescriptor NDKPAYLOAD_DESCRIPTOR;
        private static final FieldDescriptor PLATFORM_DESCRIPTOR;
        private static final FieldDescriptor SDKVERSION_DESCRIPTOR;
        private static final FieldDescriptor SESSION_DESCRIPTOR;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder crashlyticsReportEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.INSTANCE = crashlyticsReportEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.SDKVERSION_DESCRIPTOR = FieldDescriptor.of("sdkVersion");
            AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.GMPAPPID_DESCRIPTOR = FieldDescriptor.of("gmpAppId");
            AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.PLATFORM_DESCRIPTOR = FieldDescriptor.of("platform");
            AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.INSTALLATIONUUID_DESCRIPTOR = FieldDescriptor.of("installationUuid");
            AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.BUILDVERSION_DESCRIPTOR = FieldDescriptor.of("buildVersion");
            AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.DISPLAYVERSION_DESCRIPTOR = FieldDescriptor.of("displayVersion");
            AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.SESSION_DESCRIPTOR = FieldDescriptor.of("session");
            AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.NDKPAYLOAD_DESCRIPTOR = FieldDescriptor.of("ndkPayload");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport crashlyticsReport, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.SDKVERSION_DESCRIPTOR, crashlyticsReport.getSdkVersion());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.GMPAPPID_DESCRIPTOR, crashlyticsReport.getGmpAppId());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.PLATFORM_DESCRIPTOR, crashlyticsReport.getPlatform());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.INSTALLATIONUUID_DESCRIPTOR, crashlyticsReport.getInstallationUuid());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.BUILDVERSION_DESCRIPTOR, crashlyticsReport.getBuildVersion());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.DISPLAYVERSION_DESCRIPTOR, crashlyticsReport.getDisplayVersion());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.SESSION_DESCRIPTOR, crashlyticsReport.getSession());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.NDKPAYLOAD_DESCRIPTOR, crashlyticsReport.getNdkPayload());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportFilesPayloadEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload> {

        private static final FieldDescriptor FILES_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadEncoder INSTANCE;
        private static final FieldDescriptor ORGID_DESCRIPTOR;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadEncoder crashlyticsReportFilesPayloadEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadEncoder.INSTANCE = crashlyticsReportFilesPayloadEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadEncoder.FILES_DESCRIPTOR = FieldDescriptor.of("files");
            AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadEncoder.ORGID_DESCRIPTOR = FieldDescriptor.of("orgId");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload crashlyticsReport$FilesPayload, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadEncoder.FILES_DESCRIPTOR, filesPayload.getFiles());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadEncoder.ORGID_DESCRIPTOR, filesPayload.getOrgId());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.FilesPayload)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportFilesPayloadFileEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File> {

        private static final FieldDescriptor CONTENTS_DESCRIPTOR;
        private static final FieldDescriptor FILENAME_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadFileEncoder INSTANCE;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadFileEncoder crashlyticsReportFilesPayloadFileEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadFileEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadFileEncoder.INSTANCE = crashlyticsReportFilesPayloadFileEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadFileEncoder.FILENAME_DESCRIPTOR = FieldDescriptor.of("filename");
            AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadFileEncoder.CONTENTS_DESCRIPTOR = FieldDescriptor.of("contents");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File crashlyticsReport$FilesPayload$File, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadFileEncoder.FILENAME_DESCRIPTOR, file.getFilename());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadFileEncoder.CONTENTS_DESCRIPTOR, file.getContents());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.FilesPayload.File)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportSessionApplicationEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application> {

        private static final FieldDescriptor DEVELOPMENTPLATFORMVERSION_DESCRIPTOR;
        private static final FieldDescriptor DEVELOPMENTPLATFORM_DESCRIPTOR;
        private static final FieldDescriptor DISPLAYVERSION_DESCRIPTOR;
        private static final FieldDescriptor IDENTIFIER_DESCRIPTOR;
        private static final FieldDescriptor INSTALLATIONUUID_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder INSTANCE;
        private static final FieldDescriptor ORGANIZATION_DESCRIPTOR;
        private static final FieldDescriptor VERSION_DESCRIPTOR;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder crashlyticsReportSessionApplicationEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder.INSTANCE = crashlyticsReportSessionApplicationEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder.IDENTIFIER_DESCRIPTOR = FieldDescriptor.of("identifier");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder.VERSION_DESCRIPTOR = FieldDescriptor.of("version");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder.DISPLAYVERSION_DESCRIPTOR = FieldDescriptor.of("displayVersion");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder.ORGANIZATION_DESCRIPTOR = FieldDescriptor.of("organization");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder.INSTALLATIONUUID_DESCRIPTOR = FieldDescriptor.of("installationUuid");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder.DEVELOPMENTPLATFORM_DESCRIPTOR = FieldDescriptor.of("developmentPlatform");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder.DEVELOPMENTPLATFORMVERSION_DESCRIPTOR = FieldDescriptor.of("developmentPlatformVersion");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application crashlyticsReport$Session$Application, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder.IDENTIFIER_DESCRIPTOR, application.getIdentifier());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder.VERSION_DESCRIPTOR, application.getVersion());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder.DISPLAYVERSION_DESCRIPTOR, application.getDisplayVersion());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder.ORGANIZATION_DESCRIPTOR, application.getOrganization());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder.INSTALLATIONUUID_DESCRIPTOR, application.getInstallationUuid());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder.DEVELOPMENTPLATFORM_DESCRIPTOR, application.getDevelopmentPlatform());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder.DEVELOPMENTPLATFORMVERSION_DESCRIPTOR, application.getDevelopmentPlatformVersion());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.Session.Application)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportSessionApplicationOrganizationEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization> {

        private static final FieldDescriptor CLSID_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationOrganizationEncoder INSTANCE;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationOrganizationEncoder crashlyticsReportSessionApplicationOrganizationEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationOrganizationEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationOrganizationEncoder.INSTANCE = crashlyticsReportSessionApplicationOrganizationEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationOrganizationEncoder.CLSID_DESCRIPTOR = FieldDescriptor.of("clsId");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization crashlyticsReport$Session$Application$Organization, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationOrganizationEncoder.CLSID_DESCRIPTOR, organization.getClsId());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.Session.Application.Organization)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportSessionDeviceEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device> {

        private static final FieldDescriptor ARCH_DESCRIPTOR;
        private static final FieldDescriptor CORES_DESCRIPTOR;
        private static final FieldDescriptor DISKSPACE_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder INSTANCE;
        private static final FieldDescriptor MANUFACTURER_DESCRIPTOR;
        private static final FieldDescriptor MODELCLASS_DESCRIPTOR;
        private static final FieldDescriptor MODEL_DESCRIPTOR;
        private static final FieldDescriptor RAM_DESCRIPTOR;
        private static final FieldDescriptor SIMULATOR_DESCRIPTOR;
        private static final FieldDescriptor STATE_DESCRIPTOR;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder crashlyticsReportSessionDeviceEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.INSTANCE = crashlyticsReportSessionDeviceEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.ARCH_DESCRIPTOR = FieldDescriptor.of("arch");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.MODEL_DESCRIPTOR = FieldDescriptor.of("model");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.CORES_DESCRIPTOR = FieldDescriptor.of("cores");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.RAM_DESCRIPTOR = FieldDescriptor.of("ram");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.DISKSPACE_DESCRIPTOR = FieldDescriptor.of("diskSpace");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.SIMULATOR_DESCRIPTOR = FieldDescriptor.of("simulator");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.STATE_DESCRIPTOR = FieldDescriptor.of("state");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.MANUFACTURER_DESCRIPTOR = FieldDescriptor.of("manufacturer");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.MODELCLASS_DESCRIPTOR = FieldDescriptor.of("modelClass");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device crashlyticsReport$Session$Device, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.ARCH_DESCRIPTOR, device.getArch());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.MODEL_DESCRIPTOR, device.getModel());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.CORES_DESCRIPTOR, device.getCores());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.RAM_DESCRIPTOR, device.getRam());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.DISKSPACE_DESCRIPTOR, device.getDiskSpace());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.SIMULATOR_DESCRIPTOR, device.isSimulator());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.STATE_DESCRIPTOR, device.getState());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.MANUFACTURER_DESCRIPTOR, device.getManufacturer());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.MODELCLASS_DESCRIPTOR, device.getModelClass());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.Session.Device)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportSessionEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session> {

        private static final FieldDescriptor APP_DESCRIPTOR;
        private static final FieldDescriptor CRASHED_DESCRIPTOR;
        private static final FieldDescriptor DEVICE_DESCRIPTOR;
        private static final FieldDescriptor ENDEDAT_DESCRIPTOR;
        private static final FieldDescriptor EVENTS_DESCRIPTOR;
        private static final FieldDescriptor GENERATORTYPE_DESCRIPTOR;
        private static final FieldDescriptor GENERATOR_DESCRIPTOR;
        private static final FieldDescriptor IDENTIFIER_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder INSTANCE;
        private static final FieldDescriptor OS_DESCRIPTOR;
        private static final FieldDescriptor STARTEDAT_DESCRIPTOR;
        private static final FieldDescriptor USER_DESCRIPTOR;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder crashlyticsReportSessionEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.INSTANCE = crashlyticsReportSessionEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.GENERATOR_DESCRIPTOR = FieldDescriptor.of("generator");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.IDENTIFIER_DESCRIPTOR = FieldDescriptor.of("identifier");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.STARTEDAT_DESCRIPTOR = FieldDescriptor.of("startedAt");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.ENDEDAT_DESCRIPTOR = FieldDescriptor.of("endedAt");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.CRASHED_DESCRIPTOR = FieldDescriptor.of("crashed");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.APP_DESCRIPTOR = FieldDescriptor.of("app");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.USER_DESCRIPTOR = FieldDescriptor.of("user");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.OS_DESCRIPTOR = FieldDescriptor.of("os");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.DEVICE_DESCRIPTOR = FieldDescriptor.of("device");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.EVENTS_DESCRIPTOR = FieldDescriptor.of("events");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.GENERATORTYPE_DESCRIPTOR = FieldDescriptor.of("generatorType");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session crashlyticsReport$Session, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.GENERATOR_DESCRIPTOR, session.getGenerator());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.IDENTIFIER_DESCRIPTOR, session.getIdentifierUtf8Bytes());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.STARTEDAT_DESCRIPTOR, session.getStartedAt());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.ENDEDAT_DESCRIPTOR, session.getEndedAt());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.CRASHED_DESCRIPTOR, session.isCrashed());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.APP_DESCRIPTOR, session.getApp());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.USER_DESCRIPTOR, session.getUser());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.OS_DESCRIPTOR, session.getOs());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.DEVICE_DESCRIPTOR, session.getDevice());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.EVENTS_DESCRIPTOR, session.getEvents());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.GENERATORTYPE_DESCRIPTOR, session.getGeneratorType());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.Session)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportSessionEventApplicationEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application> {

        private static final FieldDescriptor BACKGROUND_DESCRIPTOR;
        private static final FieldDescriptor CUSTOMATTRIBUTES_DESCRIPTOR;
        private static final FieldDescriptor EXECUTION_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationEncoder INSTANCE;
        private static final FieldDescriptor INTERNALKEYS_DESCRIPTOR;
        private static final FieldDescriptor UIORIENTATION_DESCRIPTOR;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationEncoder crashlyticsReportSessionEventApplicationEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationEncoder.INSTANCE = crashlyticsReportSessionEventApplicationEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationEncoder.EXECUTION_DESCRIPTOR = FieldDescriptor.of("execution");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationEncoder.CUSTOMATTRIBUTES_DESCRIPTOR = FieldDescriptor.of("customAttributes");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationEncoder.INTERNALKEYS_DESCRIPTOR = FieldDescriptor.of("internalKeys");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationEncoder.BACKGROUND_DESCRIPTOR = FieldDescriptor.of("background");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationEncoder.UIORIENTATION_DESCRIPTOR = FieldDescriptor.of("uiOrientation");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application crashlyticsReport$Session$Event$Application, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationEncoder.EXECUTION_DESCRIPTOR, application.getExecution());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationEncoder.CUSTOMATTRIBUTES_DESCRIPTOR, application.getCustomAttributes());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationEncoder.INTERNALKEYS_DESCRIPTOR, application.getInternalKeys());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationEncoder.BACKGROUND_DESCRIPTOR, application.getBackground());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationEncoder.UIORIENTATION_DESCRIPTOR, application.getUiOrientation());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.Session.Event.Application)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> {

        private static final FieldDescriptor BASEADDRESS_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder INSTANCE;
        private static final FieldDescriptor NAME_DESCRIPTOR;
        private static final FieldDescriptor SIZE_DESCRIPTOR;
        private static final FieldDescriptor UUID_DESCRIPTOR;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.INSTANCE = crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.BASEADDRESS_DESCRIPTOR = FieldDescriptor.of("baseAddress");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.SIZE_DESCRIPTOR = FieldDescriptor.of("size");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.NAME_DESCRIPTOR = FieldDescriptor.of("name");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.UUID_DESCRIPTOR = FieldDescriptor.of("uuid");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage crashlyticsReport$Session$Event$Application$Execution$BinaryImage, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.BASEADDRESS_DESCRIPTOR, binaryImage.getBaseAddress());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.SIZE_DESCRIPTOR, binaryImage.getSize());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.NAME_DESCRIPTOR, binaryImage.getName());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.UUID_DESCRIPTOR, binaryImage.getUuidUtf8Bytes());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportSessionEventApplicationExecutionEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution> {

        private static final FieldDescriptor APPEXITINFO_DESCRIPTOR;
        private static final FieldDescriptor BINARIES_DESCRIPTOR;
        private static final FieldDescriptor EXCEPTION_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionEncoder INSTANCE;
        private static final FieldDescriptor SIGNAL_DESCRIPTOR;
        private static final FieldDescriptor THREADS_DESCRIPTOR;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionEncoder crashlyticsReportSessionEventApplicationExecutionEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionEncoder.INSTANCE = crashlyticsReportSessionEventApplicationExecutionEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionEncoder.THREADS_DESCRIPTOR = FieldDescriptor.of("threads");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionEncoder.EXCEPTION_DESCRIPTOR = FieldDescriptor.of("exception");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionEncoder.APPEXITINFO_DESCRIPTOR = FieldDescriptor.of("appExitInfo");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionEncoder.SIGNAL_DESCRIPTOR = FieldDescriptor.of("signal");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionEncoder.BINARIES_DESCRIPTOR = FieldDescriptor.of("binaries");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution crashlyticsReport$Session$Event$Application$Execution, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionEncoder.THREADS_DESCRIPTOR, execution.getThreads());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionEncoder.EXCEPTION_DESCRIPTOR, execution.getException());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionEncoder.APPEXITINFO_DESCRIPTOR, execution.getAppExitInfo());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionEncoder.SIGNAL_DESCRIPTOR, execution.getSignal());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionEncoder.BINARIES_DESCRIPTOR, execution.getBinaries());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.Session.Event.Application.Execution)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception> {

        private static final FieldDescriptor CAUSEDBY_DESCRIPTOR;
        private static final FieldDescriptor FRAMES_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder INSTANCE;
        private static final FieldDescriptor OVERFLOWCOUNT_DESCRIPTOR;
        private static final FieldDescriptor REASON_DESCRIPTOR;
        private static final FieldDescriptor TYPE_DESCRIPTOR;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder crashlyticsReportSessionEventApplicationExecutionExceptionEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.INSTANCE = crashlyticsReportSessionEventApplicationExecutionExceptionEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.TYPE_DESCRIPTOR = FieldDescriptor.of("type");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.REASON_DESCRIPTOR = FieldDescriptor.of("reason");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.FRAMES_DESCRIPTOR = FieldDescriptor.of("frames");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.CAUSEDBY_DESCRIPTOR = FieldDescriptor.of("causedBy");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.OVERFLOWCOUNT_DESCRIPTOR = FieldDescriptor.of("overflowCount");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception crashlyticsReport$Session$Event$Application$Execution$Exception, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.TYPE_DESCRIPTOR, exception.getType());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.REASON_DESCRIPTOR, exception.getReason());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.FRAMES_DESCRIPTOR, exception.getFrames());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.CAUSEDBY_DESCRIPTOR, exception.getCausedBy());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.OVERFLOWCOUNT_DESCRIPTOR, exception.getOverflowCount());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.Session.Event.Application.Execution.Exception)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportSessionEventApplicationExecutionSignalEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal> {

        private static final FieldDescriptor ADDRESS_DESCRIPTOR;
        private static final FieldDescriptor CODE_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionSignalEncoder INSTANCE;
        private static final FieldDescriptor NAME_DESCRIPTOR;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionSignalEncoder crashlyticsReportSessionEventApplicationExecutionSignalEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionSignalEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.INSTANCE = crashlyticsReportSessionEventApplicationExecutionSignalEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.NAME_DESCRIPTOR = FieldDescriptor.of("name");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.CODE_DESCRIPTOR = FieldDescriptor.of("code");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.ADDRESS_DESCRIPTOR = FieldDescriptor.of("address");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal crashlyticsReport$Session$Event$Application$Execution$Signal, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.NAME_DESCRIPTOR, signal.getName());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.CODE_DESCRIPTOR, signal.getCode());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.ADDRESS_DESCRIPTOR, signal.getAddress());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.Session.Event.Application.Execution.Signal)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportSessionEventApplicationExecutionThreadEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread> {

        private static final FieldDescriptor FRAMES_DESCRIPTOR;
        private static final FieldDescriptor IMPORTANCE_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadEncoder INSTANCE;
        private static final FieldDescriptor NAME_DESCRIPTOR;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadEncoder crashlyticsReportSessionEventApplicationExecutionThreadEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.INSTANCE = crashlyticsReportSessionEventApplicationExecutionThreadEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.NAME_DESCRIPTOR = FieldDescriptor.of("name");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.IMPORTANCE_DESCRIPTOR = FieldDescriptor.of("importance");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.FRAMES_DESCRIPTOR = FieldDescriptor.of("frames");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread crashlyticsReport$Session$Event$Application$Execution$Thread, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.NAME_DESCRIPTOR, thread.getName());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.IMPORTANCE_DESCRIPTOR, thread.getImportance());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.FRAMES_DESCRIPTOR, thread.getFrames());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.Session.Event.Application.Execution.Thread)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> {

        private static final FieldDescriptor FILE_DESCRIPTOR;
        private static final FieldDescriptor IMPORTANCE_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder INSTANCE;
        private static final FieldDescriptor OFFSET_DESCRIPTOR;
        private static final FieldDescriptor PC_DESCRIPTOR;
        private static final FieldDescriptor SYMBOL_DESCRIPTOR;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.INSTANCE = crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.PC_DESCRIPTOR = FieldDescriptor.of("pc");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.SYMBOL_DESCRIPTOR = FieldDescriptor.of("symbol");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.FILE_DESCRIPTOR = FieldDescriptor.of("file");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.OFFSET_DESCRIPTOR = FieldDescriptor.of("offset");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.IMPORTANCE_DESCRIPTOR = FieldDescriptor.of("importance");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame crashlyticsReport$Session$Event$Application$Execution$Thread$Frame, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.PC_DESCRIPTOR, frame.getPc());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.SYMBOL_DESCRIPTOR, frame.getSymbol());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.FILE_DESCRIPTOR, frame.getFile());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.OFFSET_DESCRIPTOR, frame.getOffset());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.IMPORTANCE_DESCRIPTOR, frame.getImportance());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportSessionEventDeviceEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device> {

        private static final FieldDescriptor BATTERYLEVEL_DESCRIPTOR;
        private static final FieldDescriptor BATTERYVELOCITY_DESCRIPTOR;
        private static final FieldDescriptor DISKUSED_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder INSTANCE;
        private static final FieldDescriptor ORIENTATION_DESCRIPTOR;
        private static final FieldDescriptor PROXIMITYON_DESCRIPTOR;
        private static final FieldDescriptor RAMUSED_DESCRIPTOR;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder crashlyticsReportSessionEventDeviceEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder.INSTANCE = crashlyticsReportSessionEventDeviceEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder.BATTERYLEVEL_DESCRIPTOR = FieldDescriptor.of("batteryLevel");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder.BATTERYVELOCITY_DESCRIPTOR = FieldDescriptor.of("batteryVelocity");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder.PROXIMITYON_DESCRIPTOR = FieldDescriptor.of("proximityOn");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder.ORIENTATION_DESCRIPTOR = FieldDescriptor.of("orientation");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder.RAMUSED_DESCRIPTOR = FieldDescriptor.of("ramUsed");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder.DISKUSED_DESCRIPTOR = FieldDescriptor.of("diskUsed");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device crashlyticsReport$Session$Event$Device, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder.BATTERYLEVEL_DESCRIPTOR, device.getBatteryLevel());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder.BATTERYVELOCITY_DESCRIPTOR, device.getBatteryVelocity());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder.PROXIMITYON_DESCRIPTOR, device.isProximityOn());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder.ORIENTATION_DESCRIPTOR, device.getOrientation());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder.RAMUSED_DESCRIPTOR, device.getRamUsed());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder.DISKUSED_DESCRIPTOR, device.getDiskUsed());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.Session.Event.Device)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportSessionEventEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event> {

        private static final FieldDescriptor APP_DESCRIPTOR;
        private static final FieldDescriptor DEVICE_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventEncoder INSTANCE;
        private static final FieldDescriptor LOG_DESCRIPTOR;
        private static final FieldDescriptor TIMESTAMP_DESCRIPTOR;
        private static final FieldDescriptor TYPE_DESCRIPTOR;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventEncoder crashlyticsReportSessionEventEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventEncoder.INSTANCE = crashlyticsReportSessionEventEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventEncoder.TIMESTAMP_DESCRIPTOR = FieldDescriptor.of("timestamp");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventEncoder.TYPE_DESCRIPTOR = FieldDescriptor.of("type");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventEncoder.APP_DESCRIPTOR = FieldDescriptor.of("app");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventEncoder.DEVICE_DESCRIPTOR = FieldDescriptor.of("device");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventEncoder.LOG_DESCRIPTOR = FieldDescriptor.of("log");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event crashlyticsReport$Session$Event, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventEncoder.TIMESTAMP_DESCRIPTOR, event.getTimestamp());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventEncoder.TYPE_DESCRIPTOR, event.getType());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventEncoder.APP_DESCRIPTOR, event.getApp());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventEncoder.DEVICE_DESCRIPTOR, event.getDevice());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventEncoder.LOG_DESCRIPTOR, event.getLog());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.Session.Event)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportSessionEventLogEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log> {

        private static final FieldDescriptor CONTENT_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventLogEncoder INSTANCE;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventLogEncoder crashlyticsReportSessionEventLogEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventLogEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventLogEncoder.INSTANCE = crashlyticsReportSessionEventLogEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventLogEncoder.CONTENT_DESCRIPTOR = FieldDescriptor.of("content");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log crashlyticsReport$Session$Event$Log, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventLogEncoder.CONTENT_DESCRIPTOR, log.getContent());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.Session.Event.Log)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportSessionOperatingSystemEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem> {

        private static final FieldDescriptor BUILDVERSION_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionOperatingSystemEncoder INSTANCE;
        private static final FieldDescriptor JAILBROKEN_DESCRIPTOR;
        private static final FieldDescriptor PLATFORM_DESCRIPTOR;
        private static final FieldDescriptor VERSION_DESCRIPTOR;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionOperatingSystemEncoder crashlyticsReportSessionOperatingSystemEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportSessionOperatingSystemEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionOperatingSystemEncoder.INSTANCE = crashlyticsReportSessionOperatingSystemEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionOperatingSystemEncoder.PLATFORM_DESCRIPTOR = FieldDescriptor.of("platform");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionOperatingSystemEncoder.VERSION_DESCRIPTOR = FieldDescriptor.of("version");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionOperatingSystemEncoder.BUILDVERSION_DESCRIPTOR = FieldDescriptor.of("buildVersion");
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionOperatingSystemEncoder.JAILBROKEN_DESCRIPTOR = FieldDescriptor.of("jailbroken");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem crashlyticsReport$Session$OperatingSystem, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionOperatingSystemEncoder.PLATFORM_DESCRIPTOR, operatingSystem.getPlatform());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionOperatingSystemEncoder.VERSION_DESCRIPTOR, operatingSystem.getVersion());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionOperatingSystemEncoder.BUILDVERSION_DESCRIPTOR, operatingSystem.getBuildVersion());
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionOperatingSystemEncoder.JAILBROKEN_DESCRIPTOR, operatingSystem.isJailbroken());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.Session.OperatingSystem)object, (ObjectEncoderContext)object2);
        }
    }

    private static final class CrashlyticsReportSessionUserEncoder implements ObjectEncoder<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User> {

        private static final FieldDescriptor IDENTIFIER_DESCRIPTOR;
        static final com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionUserEncoder INSTANCE;
        static {
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionUserEncoder crashlyticsReportSessionUserEncoder = new AutoCrashlyticsReportEncoder.CrashlyticsReportSessionUserEncoder();
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionUserEncoder.INSTANCE = crashlyticsReportSessionUserEncoder;
            AutoCrashlyticsReportEncoder.CrashlyticsReportSessionUserEncoder.IDENTIFIER_DESCRIPTOR = FieldDescriptor.of("identifier");
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User crashlyticsReport$Session$User, ObjectEncoderContext objectEncoderContext2) {
            objectEncoderContext2.add(AutoCrashlyticsReportEncoder.CrashlyticsReportSessionUserEncoder.IDENTIFIER_DESCRIPTOR, user.getIdentifier());
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        public void encode(Object object, Object object2) {
            encode((CrashlyticsReport.Session.User)object, (ObjectEncoderContext)object2);
        }
    }
    static {
        AutoCrashlyticsReportEncoder autoCrashlyticsReportEncoder = new AutoCrashlyticsReportEncoder();
        AutoCrashlyticsReportEncoder.CONFIG = autoCrashlyticsReportEncoder;
    }

    public void configure(EncoderConfig<?> encoderConfig) {
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder iNSTANCE = AutoCrashlyticsReportEncoder.CrashlyticsReportEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.class, iNSTANCE);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport.class, iNSTANCE);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder iNSTANCE2 = AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.class, iNSTANCE2);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session.class, iNSTANCE2);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder iNSTANCE3 = AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Application.class, iNSTANCE3);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Application.class, iNSTANCE3);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationOrganizationEncoder iNSTANCE4 = AutoCrashlyticsReportEncoder.CrashlyticsReportSessionApplicationOrganizationEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Application.Organization.class, iNSTANCE4);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Application_Organization.class, iNSTANCE4);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionUserEncoder iNSTANCE5 = AutoCrashlyticsReportEncoder.CrashlyticsReportSessionUserEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.User.class, iNSTANCE5);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_User.class, iNSTANCE5);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionOperatingSystemEncoder iNSTANCE6 = AutoCrashlyticsReportEncoder.CrashlyticsReportSessionOperatingSystemEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.OperatingSystem.class, iNSTANCE6);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_OperatingSystem.class, iNSTANCE6);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder iNSTANCE7 = AutoCrashlyticsReportEncoder.CrashlyticsReportSessionDeviceEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Device.class, iNSTANCE7);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Device.class, iNSTANCE7);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventEncoder iNSTANCE8 = AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.class, iNSTANCE8);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event.class, iNSTANCE8);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationEncoder iNSTANCE9 = AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.class, iNSTANCE9);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application.class, iNSTANCE9);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionEncoder iNSTANCE10 = AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.class, iNSTANCE10);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution.class, iNSTANCE10);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadEncoder iNSTANCE11 = AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Thread.class, iNSTANCE11);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.class, iNSTANCE11);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder iNSTANCE12 = AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.class, iNSTANCE12);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.class, iNSTANCE12);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder iNSTANCE13 = AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Exception.class, iNSTANCE13);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.class, iNSTANCE13);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder iNSTANCE14 = AutoCrashlyticsReportEncoder.CrashlyticsReportApplicationExitInfoEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.ApplicationExitInfo.class, iNSTANCE14);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_ApplicationExitInfo.class, iNSTANCE14);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionSignalEncoder iNSTANCE15 = AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Signal.class, iNSTANCE15);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.class, iNSTANCE15);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder iNSTANCE16 = AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.class, iNSTANCE16);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.class, iNSTANCE16);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportCustomAttributeEncoder iNSTANCE17 = AutoCrashlyticsReportEncoder.CrashlyticsReportCustomAttributeEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.CustomAttribute.class, iNSTANCE17);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_CustomAttribute.class, iNSTANCE17);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder iNSTANCE18 = AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventDeviceEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Device.class, iNSTANCE18);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Device.class, iNSTANCE18);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventLogEncoder iNSTANCE19 = AutoCrashlyticsReportEncoder.CrashlyticsReportSessionEventLogEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Log.class, iNSTANCE19);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Log.class, iNSTANCE19);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadEncoder iNSTANCE20 = AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.FilesPayload.class, iNSTANCE20);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_FilesPayload.class, iNSTANCE20);
        com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadFileEncoder iNSTANCE21 = AutoCrashlyticsReportEncoder.CrashlyticsReportFilesPayloadFileEncoder.INSTANCE;
        encoderConfig.registerEncoder(CrashlyticsReport.FilesPayload.File.class, iNSTANCE21);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_FilesPayload_File.class, iNSTANCE21);
    }
}
