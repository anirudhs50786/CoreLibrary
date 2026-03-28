package com.motocart.library.common.dto;

import com.motocart.library.common.types.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO implements Serializable {
    private String message;
    private MessageType type;
}
