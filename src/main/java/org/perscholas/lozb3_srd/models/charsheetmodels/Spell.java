package org.perscholas.lozb3_srd.models.charsheetmodels;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.perscholas.lozb3_srd.models.CharacterSheet;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int spellId;

    @NotNull
    @NonNull
    @ManyToOne
    CharacterSheet characterSheet;

    String spellName;
    String spellCost;
    String spellEffect;
    String spellDesc;
}
