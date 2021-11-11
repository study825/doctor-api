package com.example.doctorapi.common.util;

import lombok.*;

import java.io.Serializable;
import org.springframework.http.HttpStatus;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ControllerResponseT<T> implements Serializable {

    /**
     * 状态码
     */
    private int code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 数据内容，比如列表，实体
     */
    private T data;

    public static <T> ControllerResponseT<T> ofSuccess() {
        return ControllerResponseT.<T>builder()
                .code(HttpStatus.OK.value())
                .msg(HttpStatus.OK.getReasonPhrase())
                .build();
    }

    public static <T> ControllerResponseT<T> ofSuccess(String message) {
        return ControllerResponseT.<T>builder()
                .code(HttpStatus.OK.value())
                .msg(message)
                .build();
    }

    public static <T> ControllerResponseT<T> ofSuccess(String message, T data) {
        return ControllerResponseT.<T>builder()
                .code(HttpStatus.OK.value())
                .msg(message)
                .data(data)
                .build();
    }

    public static <T> ControllerResponseT<T> ofFail(int code, String message, T data) {
        return ControllerResponseT.<T>builder()
                .code(code)
                .msg(message)
                .data(data)
                .build();
    }

    public static <T> ControllerResponseT<T> ofFail(int code, String message) {
        return ControllerResponseT.<T>builder()
                .code(code)
                .msg(message)
                .build();
    }
}