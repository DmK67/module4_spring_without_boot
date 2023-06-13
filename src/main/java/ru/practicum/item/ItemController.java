package ru.practicum.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public List<ItemDto> get(@RequestHeader("X-Later-User-Id") long userId) {
        return itemService.getItems(userId);
    }

    @PostMapping
    public ItemDto add(@RequestHeader("X-Later-User-Id") Long userId,
                    @RequestBody ItemDto itemDto) {
        return itemService.addNewItem(userId, itemDto);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@RequestHeader("X-Later-User-Id") long userId,
                           @PathVariable long itemId) {
        itemService.deleteItem(userId, itemId);
    }
}
