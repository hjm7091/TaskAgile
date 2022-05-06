package com.taskagile.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
@Configuration
@ConfigurationProperties(prefix = "app")
@Validated
public class ApplicationProperties {

    /**
     * Default `from` value of emails sent out by the system
     */
    @Email
    @NotBlank
    private String mailFrom;

    @NotBlank
    @NotEmpty
    private String tokenSecretKey;

    @NotBlank
    @NotEmpty
    private String realTimeServerUrl;

    @NotNull
    private FileStorageSetting fileStorage;

    @NotNull
    private ImageSetting image;

    @Getter @Setter
    private static class FileStorageSetting {

        private String localRootFolder;

        @NotBlank
        @NotEmpty
        private String tempFolder;

        @NotBlank
        @NotEmpty
        private String active;

        private String s3AccessKey;
        private String s3SecretKey;
        private String s3BucketName;
        private String s3Region;

    }

    @Getter @Setter
    private static class ImageSetting {
        @NotBlank
        @NotEmpty
        private String commandSearchPath;
    }
}
