package com.motocart.library.common.dto.response;

import com.motocart.library.common.dto.MessageDTO;
import com.motocart.library.common.types.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<T> implements Serializable {
    private T data;
    private List<MessageDTO> messages;
    private ResponseStatus status;
}