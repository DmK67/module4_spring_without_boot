package ru.practicum.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Long id;

    private Long userId;

    private String url;

    private Set<String> tags;

}
