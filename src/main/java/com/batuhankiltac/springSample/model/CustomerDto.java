package com.batuhankiltac.springSample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDto {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;
}
