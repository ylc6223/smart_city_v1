package com.belong.smart.entity.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Validated
public class AddFeedBack {
    @NotNull(message = "用户id不能为空")
    private int userId;
    @NotBlank(message = "意见内容不能为空")
    private String content;
}
