package com.motocart.library.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductReviewDTO {

    private int reviewId;
    private int productId;
    private int rating;
    private String comment;
    private int helpfulVotes;
    private List<String> mediaLinks;
    private String reviewedBy;
    private LocalDateTime reviewedAt;
    private boolean isVerified;
}
