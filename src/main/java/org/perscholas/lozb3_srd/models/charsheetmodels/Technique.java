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
public class Technique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int techId;

    @NotNull
    @NonNull
    @ManyToOne
    CharacterSheet characterSheet;

    String techName;
    String techCost;
    String techEffect;
    String techDesc;
}
