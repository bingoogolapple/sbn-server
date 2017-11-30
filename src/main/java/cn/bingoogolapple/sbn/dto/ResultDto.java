package cn.bingoogolapple.sbn.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResultDto<T> implements Serializable {
    /**
     * 表示成功
     */
    public static final Integer OK = 0;
    /**
     * 表示失败
     */
    public static final Integer FAILURE = 1;
    /**
     * 无权限
     */
    public static final Integer INVALID_TOKEN = 401;

    private Integer code;
    private String msg;
    private T data;

    public ResultDto() {
    }

    public ResultDto(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultDto ok(String message, Object data) {
        return new ResultDto(ResultDto.OK, message, data);
    }

    public static ResultDto data(Object data) {
        return ResultDto.ok("", data);
    }

    public static ResultDto failure(String msg) {
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(ResultDto.FAILURE);
        resultDto.setMsg(msg);
        return resultDto;
    }

    public static ResultDto invalidToken() {
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(ResultDto.INVALID_TOKEN);
        resultDto.setMsg("Token无效");
        return resultDto;
    }
}