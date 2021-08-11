package org.perscholas.lozb3_srd.models.charsheetmodels;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.perscholas.lozb3_srd.models.CharacterSheet;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int containerId;

    @NotNull
    @NonNull
    @ManyToOne
    CharacterSheet characterSheet;

    @OneToMany
    List<Item> itemList;
}
