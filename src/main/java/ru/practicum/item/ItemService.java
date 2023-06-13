package ru.practicum.item;

import java.util.List;

public interface ItemService {
    List<ItemDto> getItems(long userId);

    ItemDto addNewItem(long userId, ItemDto itemDto);

    void deleteItem(long userId, long itemId);
}
