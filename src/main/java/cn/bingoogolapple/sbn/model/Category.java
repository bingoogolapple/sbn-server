package cn.bingoogolapple.sbn.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:17/3/15 上午9:57
 * 描述:博客分类实体
 */
@Getter
@Setter
public class Category implements Serializable {
    private Long id;
    private String name;
}
