package com.belong.smart.entity.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Validated
public class UserBean {
    @NotBlank(message = "用户ID不能为空")
    private Long userId;

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "用户名不能为空")
    private String nickName;
    @NotBlank(message = "邮箱不能为空")
    private String email;
    @NotBlank(message = "手机号不能为空")
    private String phonenumber;
    @NotBlank(message = "性别不能为空")
    private String sex;
    @NotBlank(message = "备注不能为空")
    private String remark;
    @NotBlank(message = "用身份证不能为空")
    private String idCard;
}
