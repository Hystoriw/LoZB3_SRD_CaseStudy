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
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int noteId;

    @NotNull
    @NonNull
    @ManyToOne
    CharacterSheet characterSheet;

    String noteTitle;
    String noteBody;
    // TODO: some sort of reference to a particular page in the srd?
}
