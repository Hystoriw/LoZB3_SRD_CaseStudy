package org.perscholas.lozb3_srd.models;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.lozb3_srd.models.charsheetmodels.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class CharacterSheet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer sheetId;

    @NotNull
    @NonNull
    @ManyToOne
    PlayerAccount playerAccount;

    @OneToMany
    List<Spell> spellList;

    @OneToMany
    List<Technique> techniqueList;

    @OneToMany
    List<Item> itemList;

    @OneToMany
    List<Skill> skillList;

    @OneToMany
    List<Trait> traitList;

    @OneToMany
    List<Container> containerList;

    @OneToMany
    List<Note> noteList;

    @OneToMany
    List<Wallet> walletList;

    // Main Sheet variables
    String characterName;
    String playerName;
    String race;
    String age;
    String virtueDisposition;
    int virtueVal;
    int sizeBaseVal;
    int sizeModVal;
    int mainSizeBaseVal;
    int mainSizeModVal;
    int speedBaseVal;
    int speedModVal;
    int hpBaseMax;
    int hpModMax;
    int hpUsed;
    int mpBaseMax;
    int mpModMax;
    int mpUsed;
    int spBaseMax;
    int spModMax;
    int spUsed;
    int brawnVal;
    int agilityVal;
    int gutsVal;
    int witsVal;
    int smartsVal;

    // Advancement Variables
    int skillPointMax;
    int heartPieces;
    int heartsExtra;
    int magicPieces;
    int magicExtra;
    int staminaPieces;
    int staminaExtra;

    // HTML Variables, for misc. character sheet boxes
    int quickSelectIndex1; // the index of the itemList that the quick select box draws from
    int quickSelectIndex2;
    int quickSelectIndex3;

    int mainHandIndex;
    int offHandIndex;
    int armorIndex;

    String ammoName;
    int ammoHeld;
    int ammoMax;

    int spellReferenceIndex;
    int techReferenceIndex;

}
