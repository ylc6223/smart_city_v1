package com.belong.smart.entity.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
@Data
public class AddComment {
    @NotBlank(message = "用户ID不能为空")
    private  int userId;
    @NotBlank(message = "新闻ID不能为空")
    private  int pressId;
    @NotBlank(message = "评论不能为空")
    private String content;
}
