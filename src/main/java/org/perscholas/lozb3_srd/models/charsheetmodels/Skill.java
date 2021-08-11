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
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int skillId;

    @NotNull
    @NonNull
    @ManyToOne
    CharacterSheet characterSheet;

    String skillName;
    int skillRanks;
    String skillStat;
}
