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
@Slf4j
public class CharacterSheet implements Serializable {

    public CharacterSheet(@NonNull String sheetName) {
        this.sheetName = sheetName;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer sheetId;

//    @NotNull
//    @NonNull
//    @ManyToOne
//    PlayerAccount playerAccount;

    @NonNull
    String sheetName;

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
    String quickSelect1; // the name of the item in itemList that the quick select box draws from
    String quickSelect2;
    String quickSelect3;

    String quickMainHand;
    String quickOffHand;
    String quickArmor;

    String ammoName;
    int ammoHeld;
    int ammoMax;

    String quickSpellReference;
    String quickTechReference;

    String walletName;
    int greenRupees;
    int blueRupees;
    int redRupees;
    int otherRupees;
}
