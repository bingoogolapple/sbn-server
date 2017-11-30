package cn.bingoogolapple.sbn.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadToken {
    private String token;
    private long expireTime;
}
