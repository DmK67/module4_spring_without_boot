package ru.practicum.item;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemRepositoryImpl implements ItemRepository {
    private List<Item> listItems = new ArrayList<>();
    private long nextIdItem = 0;

    @Override
    public List<Item> findByUserId(long userId) {
        List<Item> listItemsByUser = new ArrayList<>();
        for (Item listItem : listItems) {
            if (listItem.getUserId() == userId) {
                listItemsByUser.add(listItem);
            }
        }
        return listItemsByUser;
    }

    @Override
    public Item save(Item item) {
        if (item.getId() != null && item.getId() != 0) {
            listItems.remove(item.getId());
            listItems.add(item);
        } else {
            item.setId(nextIdItem++);
            listItems.add(item);
        }
        return item;
    }

    @Override
    public void deleteByUserIdAndItemId(long userId, long itemId) {
        for (Item item : listItems) {
            if (item.getUserId() == userId && item.getId() == itemId) {
                listItems.remove(item.getId());
            }
        }
    }
}
