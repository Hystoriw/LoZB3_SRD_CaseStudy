package org.perscholas.lozb3_srd.models;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
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
public class PlayerAccount {

    public PlayerAccount(@NonNull String username, @NonNull String password, List<CharacterSheet> characterSheetList) {
        this.username = username;
        this.password = password;
        this.characterSheetList = characterSheetList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer accId;

    @NotNull
    @NonNull
    @Column(unique = true)
    String username;

    @NotNull
    @NonNull
    String password;

    @OneToMany(fetch = FetchType.EAGER)
    List<CharacterSheet> characterSheetList;

    @ManyToMany
    List<GMAccount> gmAccountList;


}
