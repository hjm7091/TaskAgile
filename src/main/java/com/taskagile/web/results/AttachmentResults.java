package com.taskagile.web.results;

import com.taskagile.domain.common.file.FileUrlCreator;
import com.taskagile.domain.model.attachment.Attachment;
import com.taskagile.utils.ImageUtils;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class AttachmentResults {

    public static ResponseEntity<ApiResult> build(List<Attachment> attachments, FileUrlCreator fileUrlCreator) {
        List<ListableAttachment> result = new ArrayList<>();
        for (Attachment attachment : attachments) {
            result.add(new ListableAttachment(attachment, fileUrlCreator));
        }
        ApiResult apiResult = ApiResult.blank()
                .add("attachments", result);
        return Result.ok(apiResult);
    }

    @Getter
    private static class ListableAttachment {

        private final long id;
        private final String fileName;
        private final String fileType;
        private final String fileUrl;
        private final String previewUrl;
        private final long userId;
        private final long createdDate;

        ListableAttachment(Attachment attachment, FileUrlCreator fileUrlCreator) {
            this.id = attachment.getId().value();
            this.fileName = attachment.getFileName();
            this.fileType = attachment.getFileType();
            this.fileUrl = fileUrlCreator.url(attachment.getFilePath());
            if (attachment.isThumbnailCreated()) {
                this.previewUrl = ImageUtils.getThumbnailVersion(this.fileUrl);
            } else {
                this.previewUrl = "";
            }
            this.userId = attachment.getUserId().value();
            this.createdDate = attachment.getCreatedDate().getTime();
        }
    }

}
