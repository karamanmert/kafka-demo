package com.karamanmert.kafkalearn.payload;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @author karamanmert
 * @date 27.12.2024
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @JsonProperty("id")
    private int id;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
