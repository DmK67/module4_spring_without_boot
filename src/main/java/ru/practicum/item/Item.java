package ru.practicum.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.practicum.user.UserState;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column
    private String url;

    @Enumerated(EnumType.STRING)
    private UserState state;

    @ElementCollection
    @CollectionTable(name = "tags", joinColumns = @JoinColumn(name = "item_id"))
    @Column(name = "name")
    private Set<String> tags = new HashSet<>();

//    public Item(Long id, Long userId, String url) {
//        this.id = id;
//        this.userId = userId;
//        this.url = url;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        return id != null && id.equals(((Item) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
